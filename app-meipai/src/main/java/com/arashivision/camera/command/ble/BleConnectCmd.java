package com.arashivision.camera.command.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import android.util.Log;
import com.arashivision.ble.OneBleImplement.OneBleIOCallbacks;
import com.arashivision.camera.InstaCameraState;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.camera.listener.IBleConnectListener;
import com.arashivision.camera.strategy.TraceUtil;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a.C0102a;
import e.e.a.c.c;
import e.e.a.d.b;
import e.e.a.d.e;
import e.e.a.d.m;
import e.e.a.f.BleException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class BleConnectCmd implements InstaCmdExe, OneBleIOCallbacks {
    public static final int BLE_WRITE_MAX_LEN = 20;
    public static final String SID = "be80";
    public static final String TAG = "com.arashivision.camera.command.ble.BleConnectCmd";
    public b bleCallBack = new b() {
        public void onConnectFail(e.e.a.e.b bVar, BleException aVar) {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onConnectFail(bVar, aVar);
            }
        }

        public void onConnectSuccess(final e.e.a.e.b bVar, final BluetoothGatt bluetoothGatt, final int i2) {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.mBleDevice = bVar;
                String access$200 = BleConnectCmd.TAG;
                StringBuilder a2 = e.a.a.a.a.a("connect success = ");
                a2.append(BleConnectCmd.this.mBleDevice.a());
                Log.d(access$200, a2.toString());
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    if (bluetoothGattService.getUuid().toString().contains("be80")) {
                        Iterator it = bluetoothGattService.getCharacteristics().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) it.next();
                            int properties = bluetoothGattCharacteristic.getProperties();
                            if ((properties & 2) > 0 && (properties & 8) > 0) {
                                String access$2002 = BleConnectCmd.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("get rw characteristic ");
                                sb.append(properties);
                                sb.append(",set characteristic");
                                Log.d(access$2002, sb.toString());
                                BleConnectCmd.this.mWriteCharacteristic = bluetoothGattCharacteristic;
                            }
                            if ((properties & 16) > 0) {
                                String access$2003 = BleConnectCmd.TAG;
                                StringBuilder a3 = e.a.a.a.a.a("service = ");
                                a3.append(bluetoothGattService.getUuid());
                                a3.append(",getProperties ");
                                a3.append(bluetoothGattCharacteristic.getProperties());
                                a3.append(",uuid");
                                a3.append(bluetoothGattCharacteristic.getUuid());
                                Log.d(access$2003, a3.toString());
                                C0102a.f7939a.a(bVar, bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString(), new e() {
                                    public void onCharacteristicChanged(final byte[] bArr) {
                                        BleConnectCmd.this.mThreadHandler.post(new Runnable() {
                                            public void run() {
                                                if (BleConnectCmd.this.mOneDrvier != null) {
                                                    if (TraceUtil.TRACE) {
                                                        String access$200 = BleConnectCmd.TAG;
                                                        StringBuilder a2 = e.a.a.a.a.a("notify data = ");
                                                        a2.append(new String(bArr));
                                                        Log.d(access$200, a2.toString());
                                                    }
                                                    if (BleConnectCmd.this.mOneDrvier != null) {
                                                        BleConnectCmd.this.mOneDrvier.putData(bArr);
                                                    }
                                                }
                                            }
                                        });
                                    }

                                    public void onNotifyFailure(BleException aVar) {
                                        String access$200 = BleConnectCmd.TAG;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("notify error ");
                                        sb.append(aVar);
                                        Log.d(access$200, sb.toString());
                                        BleConnectCmd.this.bleConnectListener.onConnectFail(bVar, aVar);
                                        InstaCameraState.create().changeState(4);
                                    }

                                    public void onNotifySuccess() {
                                        Log.d(BleConnectCmd.TAG, "notify success");
                                        BleConnectCmd.this.bleConnectListener.onConnectSuccess(bVar, bluetoothGatt, i2);
                                        InstaCameraState.create().changeState(2);
                                    }
                                });
                                break;
                            }
                        }
                    }
                }
            }
        }

        public void onDisConnected(boolean z, e.e.a.e.b bVar, BluetoothGatt bluetoothGatt, int i2) {
            Log.d(BleConnectCmd.TAG, "dis connect");
            if (BleConnectCmd.this.mOneDrvier != null) {
                BleConnectCmd.this.mOneDrvier.setBleError(501);
            }
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onDisConnected(z, bVar, bluetoothGatt, i2);
            }
        }

        public void onStartConnect() {
            if (BleConnectCmd.this.bleConnectListener != null) {
                BleConnectCmd.this.bleConnectListener.onStartConnect();
            }
        }
    };
    public final IBleConnectListener bleConnectListener;
    public final e.e.a.a bleManager;
    public boolean isFail;
    public e.e.a.e.b mBleDevice;
    public final OneDriver mOneDrvier;
    public Handler mThreadHandler;
    public BluetoothGattCharacteristic mWriteCharacteristic;

    public BleConnectCmd(e.e.a.e.b bVar, boolean z, IBleConnectListener iBleConnectListener, OneDriver oneDriver, Handler handler) {
        this.mBleDevice = bVar;
        this.bleConnectListener = iBleConnectListener;
        this.mOneDrvier = oneDriver;
        this.mThreadHandler = handler;
        this.bleManager = C0102a.f7939a;
    }

    /* access modifiers changed from: private */
    public void getRwCharacteristic() {
        e.e.a.a aVar = C0102a.f7939a;
        e.e.a.e.b bVar = this.mBleDevice;
        c cVar = aVar.f7932d;
        BluetoothGatt bluetoothGatt = null;
        e.e.a.c.a c2 = cVar != null ? cVar.c(bVar) : null;
        if (c2 != null) {
            bluetoothGatt = c2.k;
        }
        if (bluetoothGatt != null) {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                if (bluetoothGattService.getUuid().toString().contains("be80")) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        int properties = bluetoothGattCharacteristic.getProperties();
                        if ((properties & 2) > 0 && (properties & 8) > 0) {
                            String str = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("get rw characteristic empty ");
                            sb.append(properties);
                            sb.append(",set characteristic");
                            Log.d(str, sb.toString());
                            this.mWriteCharacteristic = bluetoothGattCharacteristic;
                        }
                    }
                }
            }
        }
    }

    public Object exeCmd(OneDriver oneDriver) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("one driver = ");
        sb.append(oneDriver);
        Log.d(str, sb.toString());
        String str2 = TAG;
        StringBuilder a2 = e.a.a.a.a.a("thread = ");
        a2.append(Thread.currentThread());
        Log.i(str2, a2.toString());
        BluetoothGatt a3 = this.bleManager.a(this.mBleDevice, this.bleCallBack);
        oneDriver.openBle(this);
        return a3;
    }

    public void onWrite(final byte[] bArr) {
        if (TraceUtil.TRACE) {
            String str = TAG;
            StringBuilder a2 = e.a.a.a.a.a("write ble = ");
            a2.append(this.mBleDevice.a());
            a2.append("，mWriteCharacteristic = ");
            a2.append(this.mWriteCharacteristic);
            Log.d(str, a2.toString());
        }
        this.mThreadHandler.post(new Runnable() {
            public void run() {
                if (BleConnectCmd.this.mWriteCharacteristic == null) {
                    BleConnectCmd.this.getRwCharacteristic();
                }
                if (BleConnectCmd.this.mWriteCharacteristic != null) {
                    BleConnectCmd.this.isFail = false;
                    int i2 = 0;
                    while (!BleConnectCmd.this.isFail && i2 < bArr.length) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        int i3 = i2 + 20;
                        byte[] bArr = bArr;
                        int length = i3 > bArr.length ? bArr.length - i2 : 20;
                        byte[] bArr2 = new byte[length];
                        System.arraycopy(bArr, i2, bArr2, 0, length);
                        String access$200 = BleConnectCmd.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("offset = ");
                        sb.append(i2);
                        sb.append(",len = ");
                        sb.append(length);
                        Log.d(access$200, sb.toString());
                        C0102a.f7939a.a(BleConnectCmd.this.mBleDevice, BleConnectCmd.this.mWriteCharacteristic.getService().getUuid().toString(), BleConnectCmd.this.mWriteCharacteristic.getUuid().toString(), bArr2, new m() {
                            public void onWriteFailure(BleException aVar) {
                                String access$200 = BleConnectCmd.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("write error ");
                                sb.append(aVar);
                                Log.d(access$200, sb.toString());
                                countDownLatch.countDown();
                                BleConnectCmd.this.isFail = true;
                            }

                            public void onWriteSuccess(int i2, int i3, byte[] bArr) {
                                countDownLatch.countDown();
                                Log.d(BleConnectCmd.TAG, "write success");
                            }
                        });
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i2 += length;
                    }
                }
            }
        });
    }
}
