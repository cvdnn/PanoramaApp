package com.cvdnn.panorama;

import android.Loople;
import android.assist.Assert;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.frame.context.FrameActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.log.Log;
import android.math.Maths;
import android.network.NetUtils;
import android.network.Response;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.TextureView;
import android.view.View;

import androidx.annotation.WorkerThread;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cvdnn.camera.CameraWrap;
import com.cvdnn.camera.ImageUtils;
import com.cvdnn.panorama.BleEngine.SpinType;
import com.cvdnn.panorama.databinding.ActSpinBinding;

import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.BLUETOOTH;
import static android.Manifest.permission.BLUETOOTH_ADMIN;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.bluetooth.BluetoothGatt.GATT_SUCCESS;
import static android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.cvdnn.panorama.BleEngine.BT_IDLE_MILLIS;
import static com.cvdnn.panorama.BleEngine.FLAG_END_MOTION;
import static com.cvdnn.panorama.BleEngine.FLAG_START_MOTION;
import static com.cvdnn.panorama.BleEngine.SpinType.SPIN18;

public class MainActivity extends FrameActivity<ActSpinBinding> {
    private static final String TAG = "MainActivity";

    private static final int ACTION_REQUEST_PERMISSIONS = 0x001;
    private static final String[] NEEDED_PERMISSIONS = new String[]{
            WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, CAMERA, BLUETOOTH_ADMIN, BLUETOOTH, ACCESS_COARSE_LOCATION
    };

    private static final int ACTION_REQUEST_BLUETOOTH_LE = 1001;

    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 10000;

    private static final int STATE_DISCONNECTED = 0;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_CONNECTED = 2;

    private static final int FLAG_STATE_UNKNOWN = 0;
    private static final int FLAG_STATE_FAIL = -1;
    private static final int FLAG_STATE_SUCCESS = 1;

    private int mConnectionState = STATE_DISCONNECTED;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;

    private boolean mScanning;

    private String mBluetoothAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattService mBluetoothGattService;
    private BluetoothGattCharacteristic mSendCharacteristic, mReceiveCharacteristic;

    private final ArrayMap<String, BluetoothDevice> mBDMap = new ArrayMap<>();

    private final SpinType mSpinType = SPIN18;

    private int mTakeIndex = 0;

    private int mDeviceState;

    private Camera mCamera;
    private File mPictureTempPath;

    @Override
    protected final ActSpinBinding onViewBinding() {
        return ActSpinBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onInitData() {
        super.onInitData();

        // 使用此检查确定设备是否支持BLE。 然后你可以有选择地禁用与BLE相关的功能
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            makeToast("ble_not_supported");

            finish();
        }
    }

    @Override
    protected void onCreateView() {
        super.onCreateView();

        binding.ccpBar.setTextFlag(true);
        binding.ccpBar.setMaxProgress(mSpinType.num);
        binding.ccpBar.setVisibility(INVISIBLE);

        binding.takePicture.setOnClickListener(mTakePictureListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkPermissions(NEEDED_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS, ACTION_REQUEST_PERMISSIONS);

        } else {
            // Initializes a Bluetooth adapter.
            // For API level 18 and above, get a reference to BluetoothAdapter through BluetoothManager.
//        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//        mBluetoothAdapter = bluetoothManager.getAdapter();

            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();

            // FIXME DEMO简单蓝牙设置
            // Ensures Bluetooth is available on the device and it is enabled. If not,
            // displays a dialog requesting user permission to enable Bluetooth.
            if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, ACTION_REQUEST_BLUETOOTH_LE);
            }

            onActiveApp();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        BleEngine.disconnect(mBluetoothGatt);
        mBluetoothGatt = BleEngine.close(mBluetoothGatt);
    }

    /**
     * 扫描设备，通常10秒内能查找到相应到蓝牙设备
     * FIXME 需要添加扫描状态控制
     *
     * @param enable
     */
    private void onStartScanLeDevice(final boolean enable) {
        if (mBluetoothLeScanner != null) {
            if (enable) {
                mBluetoothLeScanner.startScan(mScanCallback);

                Loople.Task.schedule(() -> {
                    if (mBluetoothLeScanner != null) {
                        mBluetoothLeScanner.stopScan(mScanCallback);
                    }

                }, SCAN_PERIOD);

            } else {
                mBluetoothLeScanner.stopScan(mScanCallback);
            }
        }
    }

    private final ScanCallback mScanCallback = new ScanCallback() {

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            BluetoothDevice bd = result.getDevice();

            String devName = bd.getName();
            if (Assert.notEmpty(devName) && bd.getName().startsWith("FC-")) {
                // FIXME DEMO测试单个设备
                mBluetoothLeScanner.stopScan(this);

                String bdAddress = bd.getAddress();
                Log.e(TAG, "::: " + bd.getType() + ": " + bd.getName() + ", " + bdAddress + ": " + result.getRssi());

                Loople.Task.schedule(() -> connect(bdAddress));
            }
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            Log.e(TAG, "::: size: %d", results.size());
        }

        @Override
        public void onScanFailed(int errorCode) {
            Log.e(TAG, "::: onScanFailed: %d", errorCode);
        }
    };

    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     * FIXME DEMO缺少重连策略
     *
     * @param address The device address of the destination device.
     *
     * @return Return true if the connection is initiated successfully. The connection result is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)} callback.
     */
    public boolean connect(final String address) {
        if (mBluetoothAdapter == null || address == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device. Try to reconnect.
        if (address.equals(mBluetoothAddress) && mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                return true;
            } else {
                return false;
            }
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            Log.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        // We want to directly connect to the device, so we are setting the autoConnect parameter to false.
        mBluetoothGatt = device.connectGatt(this, true, mGattCallback);
        Log.d(TAG, "Trying to create a new connection.");

        mBluetoothAddress = address;
        mConnectionState = STATE_CONNECTING;

        return true;
    }

    /**
     * Implements callback methods for GATT events that the app cares about.
     * For example, connection change and services discovered.
     */
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {

        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == STATE_CONNECTED) {
                mConnectionState = STATE_CONNECTED;

                Log.i(TAG, ":::Connected to GATT server.");
                // Attempts to discover services after successful connection.

                // 连接成功后查询设备所提供的蓝牙服务
                boolean result = gatt.discoverServices();
                if (!result) {
                    // FIXME 提示重连等
                    Log.e(TAG, ":::Attempting to start service discovery:" + result);
                }

            } else if (newState == STATE_DISCONNECTED) {
                mConnectionState = STATE_DISCONNECTED;
                Log.i(TAG, ":::Disconnected from GATT server.");

                // FIXME 提示重连等
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == GATT_SUCCESS) {
                mBluetoothGattService = BleEngine.findGattService(mBluetoothGatt);
                onGattServices(mBluetoothGattService);

            } else {
                Log.w(TAG, ":::onServicesDiscovered received: " + status);
                // FIXME 重新尝试获取服务
            }
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (status == GATT_SUCCESS) {
                byte[] bytes = characteristic.getValue();
                if (BleEngine.checkResponse(bytes)) {
                    mDeviceState = FLAG_STATE_SUCCESS;

                    makeToast("设备连接成功");
                } else {
                    Log.d(TAG, "::: onCharacteristicRead: %d, %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
                }
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] bytes = characteristic.getValue();
            if (BleEngine.asResponse(bytes)) {
                byte state = BleEngine.getState(bytes);
                // 设备开始启动运行
                if (state == FLAG_START_MOTION) {

                    // 设备运行成功
                } else if (state == FLAG_END_MOTION) {
                    // FIXME 模拟开始拍照
                    Loople.Task.schedule(() -> onInvokeTakePicture(), BT_IDLE_MILLIS);
                }
            }

//            Log.d(TAG, "::: onCharacteristicChanged: %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
        }
    };


    private final void onGattServices(BluetoothGattService service) {
        if (service != null) {
            mSendCharacteristic = BleEngine.findSendCharacteristic(service);

            if (mReceiveCharacteristic != null) {
                BleEngine.setCharacteristicNotification(mBluetoothGatt, mReceiveCharacteristic, false);
                mReceiveCharacteristic = null;
            }

            BluetoothGattCharacteristic receiveCharacteristic = BleEngine.findReceiveCharacteristic(service);
            if (receiveCharacteristic != null) {
                if (BleEngine.setCharacteristicNotification(mBluetoothGatt, receiveCharacteristic, true)) {
                    mReceiveCharacteristic = receiveCharacteristic;
                }

                // 查询设备状态
                BleEngine.readCharacteristic(mBluetoothGatt, receiveCharacteristic);
            }
        }
    }

    private View.OnClickListener mTakePictureListener = v -> {
        if (mDeviceState == FLAG_STATE_SUCCESS) {
            binding.ccpBar.setVisibility(VISIBLE);

            mPictureTempPath = new File(getExternalCacheDir(), Maths.unique());
            mPictureTempPath.mkdirs();
            Log.e(TAG, ":: path: %s", mPictureTempPath.getAbsoluteFile());

            // FIXME 模拟开始拍照
            mTakeIndex = 0;
            onInvokeTakePicture();

        } else if (mDeviceState == FLAG_STATE_FAIL) {
            binding.ccpBar.setVisibility(INVISIBLE);

            // FIXME 重连策略
            makeToast("等待设备连接失败");

        } else {
            makeToast("等待设备连接");
        }
    };

    /**
     * FIXME DEMO模拟拍照
     */
    @WorkerThread
    private void onInvokeTakePicture() {
        if (mTakeIndex >= 0 && mTakeIndex < mSpinType.num) {
            takePicture();
            BleEngine.takeAround(mBluetoothGatt, mSendCharacteristic, mSpinType);

        } else if (mTakeIndex >= mSpinType.num) {

            // 完成环物拍照
            Loople.Main.post(() -> binding.ccpBar.setVisibility(INVISIBLE));
            Loople.Task.schedule(() -> {
                File zipFilePath = new File(mPictureTempPath, mPictureTempPath.getName() + ".zip");
                ZipFile zipfile = new ZipFile(zipFilePath);
                File[] fileList = mPictureTempPath.listFiles();
                if (Assert.notEmpty(fileList)) {
                    try {
                        zipfile.addFiles(Arrays.asList(fileList));
                    } catch (Exception e) {
                        Log.e(TAG, e);
                    }
                }

                Response response = NetUtils.post("", zipFilePath);
                if (NetUtils.success(response)) {
                    makeToast("拍照完成");
                } else {
                    makeToast("上传呢失败");
                }
            });

            mTakeIndex = -1;
            // 转盘回正
            BleEngine.takeAround(mBluetoothGatt, mSendCharacteristic, mSpinType);

            Log.e(TAG, "::: ------ finish -------");
        }
    }

    private void takePicture() {
        runOnUiThread(() -> binding.ccpBar.setProgress(mTakeIndex + 1));

        if (mCamera != null) {
            mCamera.takePicture(null, null, mPictureCallback);
        }

        mTakeIndex++;
    }

    private void onActiveApp() {
        onCreatePreview(CAMERA_FACING_BACK);

        onStartScanLeDevice(true);
    }

    private void onCreatePreview(int cameraId) {
        binding.preview.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            private CameraWrap mEngine;

            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
                mEngine = new CameraWrap.Builder(cameraId)
                        .setPreviewSize(width, height)
                        .setSurfaceTexture(surfaceTexture)
//                        .setPreviewCallback((nv21, camera) -> {
////                            Log.i(TAG, ";");
//
////                                    iv.setImageBitmap(BitmapFactory.decodeByteArray(nv21, 0, nv21.length));
//                        })
                        .build();
                mEngine.start();
                mCamera = mEngine.camera();
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                mEngine.stop();
                mEngine.release();

                return true;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

            }
        });
    }

    private final Camera.PictureCallback mPictureCallback = (data, camera) -> {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        if (bitmap != null) {
            Bitmap newBmp = ImageUtils.getRotatedBitmap(bitmap, 90);
            bitmap = ImageUtils.recycle(bitmap);

            ImageUtils.write(newBmp, new File(mPictureTempPath, String.format("%02d.jpg", mTakeIndex)));
            newBmp = ImageUtils.recycle(newBmp);
        }

        runOnUiThread(camera::startPreview);
    };

    private boolean checkPermissions(String[] neededPermissions) {
        boolean allGranted = true;
        if (Assert.notEmpty(neededPermissions)) {
            for (String neededPermission : neededPermissions) {
                allGranted &= ContextCompat.checkSelfPermission(this, neededPermission) == PackageManager.PERMISSION_GRANTED;
            }
        }

        return allGranted;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ACTION_REQUEST_PERMISSIONS) {
            boolean isAllGranted = true;
            for (int grantResult : grantResults) {
                isAllGranted &= (grantResult == PackageManager.PERMISSION_GRANTED);
            }
            if (isAllGranted) {
                onActiveApp();
            }
        }
    }
}