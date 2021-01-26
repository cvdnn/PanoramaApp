package com.arashivision.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.arashivision.ble.OneBleDriver.OnNotificationListener;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.TaskWaiter;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
import com.arashivision.onecamera.camerarequest.GetMiniThumbnail;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.cameraresponse.CameraCaptureStatus;
import com.arashivision.onecamera.cameraresponse.GetCurrentCaptureStatusResp;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import e.e.a.a;
import java.lang.ref.WeakReference;
import java.util.List;

public class OneBleImplement {
    public static final int BLE_WRITE_MAX_LEN = 20;
    public static final int MAX_BROADCAST_COUNT = 1;
    public static final int MSG_CAPTURE_STILL_TO = 1;
    public static final int MSG_STARTBROADCAST = 6;
    public static final int MSG_START_CAPTURE_TO = 2;
    public static final int MSG_START_TIMELAPSE_TO = 4;
    public static final int MSG_STOP_CAPTURE_TO = 3;
    public static final int MSG_STOP_TIMELAPSE_TO = 5;
    public static final int NORMAL_TO = 20000;
    public static final int SCAN_BLE_TO = -1;
    public static final String SID = "be80";
    public static final String TAG = "OneBle";
    public static final boolean mConnectUI = false;
    public boolean bWriteFail;
    public boolean bWriting = false;
    public a bleManager;
    public int charaProp;
    public BluetoothGattCharacteristic characteristicNotify;
    public BluetoothGattCharacteristic characteristicRW;
    public BluetoothGatt gatt;
    public final AdvertiseHandler mAdvertiseHandler;
    public BleInfoUpdateListener mBleInfoUpdateListener;
    public int mBroadcastCount = 0;
    public Handler mCBHandler;
    public OneBleCallbacks mCallbacks;
    public ConnectState mConnectState = ConnectState.Idle;
    public Context mContext;
    public long mCurrentTime;
    public OneBleDriver mDriver;
    public HandlerThread mDriverHandlerThread;
    public Handler mHandler;
    public Handler mHandlerTimeout;
    public Handler mInfoHandler;
    public volatile RecordStatus mRecordStatus = RecordStatus.Idle;
    public boolean mReleased;
    public Handler mUIHandler;
    public String mac;
    public String name;
    public BluetoothGattService service;

    public static final class AdvertiseHandler extends Handler {
        public WeakReference<OneBleImplement> mOneBleImplementWeakReference;

        public AdvertiseHandler(OneBleImplement oneBleImplement, Looper looper) {
            super(looper);
            this.mOneBleImplementWeakReference = new WeakReference<>(oneBleImplement);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            OneBleImplement oneBleImplement = (OneBleImplement) this.mOneBleImplementWeakReference.get();
            if (oneBleImplement == null) {
                StringBuilder a2 = e.a.a.a.a.a("OneBleImplement handleMessage: ");
                a2.append(message.what);
                a2.append(", but OneBleImplement not exists now");
                e.e.a.h.a.c(a2.toString());
                return;
            }
            if (message.what == 6) {
                StringBuilder a3 = e.a.a.a.a.a("send broadcast ");
                a3.append(oneBleImplement.mBroadcastCount);
                Log.e("fast", a3.toString());
                if (oneBleImplement.mBroadcastCount >= 1) {
                    removeMessages(6);
                } else {
                    oneBleImplement.startAdverting(message.arg1, (byte) message.arg2, (String) message.obj);
                    sendMessageDelayed(Message.obtain(message), 20000);
                }
            }
        }
    }

    public enum ConnectState {
        Idle,
        Connecting,
        ConnectComplete,
        ConnectSynced,
        Error,
        Disconnected
    }

    public static final class MyHandler extends Handler {
        public WeakReference<OneBleImplement> mOneBleImplementWeakReference;

        public MyHandler(OneBleImplement oneBleImplement, Looper looper) {
            super(looper);
            this.mOneBleImplementWeakReference = new WeakReference<>(oneBleImplement);
        }

        public void handleMessage(Message message) {
            OneBleImplement oneBleImplement = (OneBleImplement) this.mOneBleImplementWeakReference.get();
            if (oneBleImplement == null) {
                StringBuilder a2 = e.a.a.a.a.a("OneBleImplement handleMessage: ");
                a2.append(message.what);
                a2.append(", but OneBleImplement not exists now");
                e.e.a.h.a.c(a2.toString());
                return;
            }
            oneBleImplement.onBleTimeout(1);
        }
    }

    public interface OneBleIOCallbacks {
        void onWrite(byte[] bArr);
    }

    public interface OneBleSyncCallbacks {
        void onRecord(boolean z);
    }

    public enum RecordStatus {
        Idle,
        Recording,
        Stopping,
        Error,
        TimelapseError
    }

    public OneBleImplement(Looper looper, Context context, OneBleCallbacks oneBleCallbacks, Handler handler) {
        this.mContext = context;
        StringBuilder a2 = e.a.a.a.a.a("onecamera created isSupportBle() ");
        a2.append(isSupportBle());
        e.e.a.h.a.b(a2.toString());
        if (isSupportBle()) {
            this.mHandler = new Handler(looper);
            this.mUIHandler = new Handler(Looper.getMainLooper());
            this.mAdvertiseHandler = new AdvertiseHandler(this, Looper.getMainLooper());
            this.mCallbacks = oneBleCallbacks;
            if (handler != null) {
                StringBuilder a3 = e.a.a.a.a.a("ble callback run on caller's handler thread: ");
                a3.append(handler.getLooper().getThread().getName());
                e.e.a.h.a.b(a3.toString());
                this.mCBHandler = handler;
                return;
            }
            e.e.a.h.a.b("ble callback run on camera thread");
            this.mCBHandler = this.mHandler;
            return;
        }
        throw new IllegalStateException("ble not support");
    }

    private void checkConnect(String str) {
        if (this.mConnectState != ConnectState.ConnectComplete) {
            StringBuilder b2 = e.a.a.a.a.b(str, " mConnectState: ");
            b2.append(this.mConnectState);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void checkConnectIdle(String str) {
        if (this.mConnectState != ConnectState.Idle) {
            StringBuilder b2 = e.a.a.a.a.b(str, " mConnectState: ");
            b2.append(this.mConnectState);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void checkConnectSynced(String str) {
        ConnectState connectState = this.mConnectState;
        if (connectState != ConnectState.ConnectSynced && connectState != ConnectState.ConnectComplete) {
            StringBuilder b2 = e.a.a.a.a.b(str, " mConnectState: ");
            b2.append(this.mConnectState);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void checkRecord(String str) {
        if (this.mRecordStatus != RecordStatus.Recording) {
            StringBuilder b2 = e.a.a.a.a.b(str, " mRecordStatus: ");
            b2.append(this.mRecordStatus);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void checkRecordIdle(String str) {
        if (this.mRecordStatus != RecordStatus.Idle) {
            StringBuilder b2 = e.a.a.a.a.b(str, " mRecordStatus: ");
            b2.append(this.mRecordStatus);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void isAllowClose() {
        boolean z = true;
        if (this.mRecordStatus == RecordStatus.Stopping) {
            if (this.mConnectState != ConnectState.Disconnected) {
                z = false;
            } else {
                e.e.a.h.a.c("close connect met stopping when disconnect");
            }
        } else if (this.mRecordStatus == RecordStatus.TimelapseError || this.mRecordStatus == RecordStatus.Error) {
            StringBuilder a2 = e.a.a.a.a.a("close met record error mRecordStatus ");
            a2.append(this.mRecordStatus);
            e.e.a.h.a.c(a2.toString());
            resetRecord();
        }
        if (!z) {
            StringBuilder a3 = e.a.a.a.a.a(" mRecordStatus ");
            a3.append(this.mRecordStatus);
            a3.append(" mConnectState ");
            a3.append(this.mConnectState);
            throw new RuntimeException(a3.toString());
        }
    }

    /* access modifiers changed from: private */
    public void onBleTimeout(final int i2) {
        this.mHandler.post(new Runnable() {
            public void run() {
                OneBleImplement.this.mConnectState = ConnectState.Disconnected;
                OneBleImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = e.a.a.a.a.a("ble ");
                        a2.append(i2 == 0 ? "disconnet" : "timeout");
                        e.e.a.h.a.b(a2.toString());
                        OneBleImplement.this.mCallbacks.onDisConnected();
                    }
                });
            }
        });
    }

    private void onServiceDiscover() {
        HandlerThread handlerThread = new HandlerThread(OneBleDriver.TAG);
        this.mDriverHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandlerTimeout = new MyHandler(this, this.mDriverHandlerThread.getLooper());
        this.mDriver = new OneBleDriver(this.mContext, this.mDriverHandlerThread.getLooper(), new OneBleIOCallbacks() {
            public void onWrite(byte[] bArr) {
                OneBleImplement.this.bWriteFail = false;
                StringBuilder sb = new StringBuilder();
                String str = "onWrite mData len ";
                sb.append(str);
                sb.append(bArr.length);
                e.e.a.h.a.b(sb.toString());
                while (!OneBleImplement.this.bWriteFail && bArr.length > 0) {
                    new TaskWaiter();
                    int i2 = 20;
                    if (20 > bArr.length) {
                        i2 = bArr.length + 0;
                    }
                    System.arraycopy(bArr, 0, new byte[i2], 0, i2);
                    if (OneBleImplement.this.characteristicRW == null) {
                        OneBleImplement.this.requireCharacteristicRW();
                    }
                    if (OneBleImplement.this.characteristicRW == null) {
                        break;
                    }
                }
                OneBleImplement.this.bWriting = false;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(bArr.length);
                sb2.append(" over ");
                e.e.a.h.a.b(sb2.toString());
            }
        });
        setDriverListener();
        this.mConnectState = ConnectState.ConnectComplete;
        this.mCBHandler.postDelayed(new Runnable() {
            public void run() {
                OneBleImplement.this.mCallbacks.onServicesDiscovered();
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public void requireCharacteristicRW() {
        if (this.characteristicRW == null) {
            BluetoothGatt bluetoothGatt = this.gatt;
            if (bluetoothGatt != null) {
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    if (bluetoothGattService.getUuid().toString().contains("be80")) {
                        setService(bluetoothGattService);
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                            int properties = bluetoothGattCharacteristic.getProperties();
                            if ((properties & 2) > 0 && (properties & 8) > 0) {
                                e.e.a.h.a.b("found r/w character ");
                                setCharacteristicRW(bluetoothGattCharacteristic);
                            }
                        }
                    }
                }
            }
        }
    }

    private void resetInfo() {
        this.name = null;
        this.mac = null;
        this.gatt = null;
        this.service = null;
        this.characteristicRW = null;
        this.characteristicNotify = null;
        this.charaProp = 0;
    }

    private void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    private void scanWithConnectName(String str, String str2, boolean z) {
        resetInfo();
        cancelScan(false);
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneBleImplement.this.mCallbacks.onStartScan();
            }
        });
    }

    private void sendDelayMsg(int i2, int i3) {
        this.mHandlerTimeout.sendMessageDelayed(this.mHandlerTimeout.obtainMessage(i2), (long) i3);
    }

    private void sendHeartBeats() {
        if (this.mDriver != null && System.currentTimeMillis() - this.mCurrentTime >= 500) {
            this.mCurrentTime = System.currentTimeMillis();
        }
    }

    private void setDriverListener() {
        this.mDriver.setNotificationListener(new OnNotificationListener() {
            public void onDriverBleState(final int i2) {
                OneBleImplement.this.mHandlerTimeout.removeMessages(1);
                OneBleImplement.this.mHandlerTimeout.removeMessages(2);
                OneBleImplement.this.mHandlerTimeout.removeMessages(3);
                OneBleImplement.this.mHandlerTimeout.removeMessages(4);
                OneBleImplement.this.mHandlerTimeout.removeMessages(5);
                OneBleImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = e.a.a.a.a.a("onDriverBleState error state ");
                        a2.append(i2);
                        e.e.a.h.a.b(a2.toString());
                        OneBleImplement.this.mCallbacks.onBleErrorState(i2);
                    }
                });
            }

            public void onDriverInfoNotify(final int i2, final int i3, final Object obj) {
                StringBuilder a2 = e.a.a.a.a.a("onDriverInfoNotify error ", i3, " what ", i2, " mConnectState ");
                a2.append(OneBleImplement.this.mConnectState);
                e.e.a.h.a.b(a2.toString());
                OneBleImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        if (OneBleImplement.this.mConnectState == ConnectState.Disconnected) {
                            e.e.a.h.a.a("receive info notify after disconnect");
                            return;
                        }
                        int i2 = i2;
                        if (i2 == 8) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(2);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(3);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(4);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(5);
                        } else if (i2 == 9) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(1);
                        } else if (i2 == 72) {
                            GetCurrentCaptureStatusResp getCurrentCaptureStatusResp = (GetCurrentCaptureStatusResp) obj;
                            if (getCurrentCaptureStatusResp.errorCode == 0) {
                                StringBuilder a2 = e.a.a.a.a.a("new mCaptureStatus.state ");
                                a2.append(getCurrentCaptureStatusResp.status.state);
                                e.e.a.h.a.b(a2.toString());
                                int i3 = getCurrentCaptureStatusResp.status.state;
                                if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 7) {
                                    OneBleImplement.this.mRecordStatus = RecordStatus.Recording;
                                } else {
                                    OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                                }
                                OneBleImplement.this.mConnectState = ConnectState.ConnectSynced;
                            } else {
                                StringBuilder a3 = e.a.a.a.a.a("error mCaptureStatus.errorCode ");
                                a3.append(getCurrentCaptureStatusResp.errorCode);
                                e.e.a.h.a.a(a3.toString());
                            }
                        } else if (i2 == 77) {
                            CameraCaptureStatus cameraCaptureStatus = (CameraCaptureStatus) obj;
                            StringBuilder a4 = e.a.a.a.a.a("notify new mCaptureStatus.state ");
                            a4.append(cameraCaptureStatus.state);
                            e.e.a.h.a.b(a4.toString());
                            int i4 = cameraCaptureStatus.state;
                            if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 7) {
                                OneBleImplement.this.mRecordStatus = RecordStatus.Recording;
                            } else {
                                OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                            }
                        }
                        if (OneBleImplement.this.mInfoHandler != null) {
                            OneBleImplement.this.mInfoHandler.post(new Runnable() {
                                public void run() {
                                    BleInfoUpdateListener access$1300 = OneBleImplement.this.mBleInfoUpdateListener;
                                    AnonymousClass1 r1 = AnonymousClass1.this;
                                    access$1300.onCameraInfoNotify(i2, i3, obj);
                                }
                            });
                        } else {
                            OneBleImplement.this.mBleInfoUpdateListener.onCameraInfoNotify(i2, i3, obj);
                        }
                    }
                });
            }

            public void onDriverRecordVideoStateNotify(final int i2, final VideoResult videoResult) {
                OneBleImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = e.a.a.a.a.a("onDriverRecordVideoStateNotify error code ");
                        a2.append(videoResult.error_code);
                        a2.append(" state ");
                        a2.append(i2);
                        e.e.a.h.a.b(a2.toString());
                        StringBuilder sb = new StringBuilder();
                        sb.append("uri ");
                        sb.append(videoResult.video.uri);
                        e.e.a.h.a.b(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("file_size ");
                        sb2.append(videoResult.video.file_size);
                        e.e.a.h.a.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("total_time ");
                        sb3.append(videoResult.video.total_time);
                        e.e.a.h.a.b(sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(" mRecordStatus is ");
                        sb4.append(OneBleImplement.this.mRecordStatus);
                        e.e.a.h.a.b(sb4.toString());
                        int i2 = i2;
                        if (i2 == 0) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(2);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("STARTED mRecordStatus ");
                            sb5.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.b(sb5.toString());
                        } else if (i2 == 1) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(3);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("COMPLETE mRecordStatus ");
                            sb6.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.b(sb6.toString());
                            if (OneBleImplement.this.mRecordStatus != RecordStatus.Stopping) {
                                StringBuilder a3 = e.a.a.a.a.a("received record complete message, status: ");
                                a3.append(OneBleImplement.this.mRecordStatus);
                                Log.w("OneBle", a3.toString());
                                return;
                            }
                            OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else if (i2 == 2) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(2);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(3);
                            OneBleImplement.this.mRecordStatus = RecordStatus.Error;
                        } else if (i2 == 3) {
                            StringBuilder a4 = e.a.a.a.a.a("received cancelled, record status: ");
                            a4.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.a(a4.toString());
                            OneBleImplement.this.mHandlerTimeout.removeMessages(2);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(3);
                            OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else {
                            StringBuilder a5 = e.a.a.a.a.a("onDriverRecordVideoStateNotify state: ");
                            a5.append(i2);
                            throw new IllegalStateException(a5.toString());
                        }
                        OneBleImplement.this.mCBHandler.post(new Runnable() {
                            public void run() {
                                OneBleCallbacks access$000 = OneBleImplement.this.mCallbacks;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                access$000.onRecordVideoStateNotify(i2, videoResult);
                            }
                        });
                    }
                });
            }

            public void onDriverStillImageNotify(final TakePictureResponse takePictureResponse) {
                OneBleImplement.this.mHandlerTimeout.removeMessages(1);
                OneBleImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = e.a.a.a.a.a("onDriverStillImageNotify ");
                        a2.append(takePictureResponse.error_code);
                        e.e.a.h.a.b(a2.toString());
                        String str = "thub len  ";
                        String str2 = "uri ";
                        String str3 = "file_size ";
                        if (takePictureResponse.image != null) {
                            StringBuilder a3 = e.a.a.a.a.a(str3);
                            a3.append(takePictureResponse.image.file_size);
                            e.e.a.h.a.b(a3.toString());
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(takePictureResponse.image.uri);
                            e.e.a.h.a.b(sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(takePictureResponse.image.s_thumbnail.length);
                            e.e.a.h.a.b(sb2.toString());
                        } else {
                            e.e.a.h.a.b("mResponse.image null");
                        }
                        if (takePictureResponse.aeb_images != null) {
                            StringBuilder a4 = e.a.a.a.a.a(" mResponse.aeb_images len ");
                            a4.append(takePictureResponse.aeb_images.length);
                            e.e.a.h.a.b(a4.toString());
                            for (int i2 = 0; i2 < takePictureResponse.aeb_images.length; i2++) {
                                StringBuilder a5 = e.a.a.a.a.a(str3);
                                a5.append(takePictureResponse.aeb_images[i2].file_size);
                                e.e.a.h.a.b(a5.toString());
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str2);
                                sb3.append(takePictureResponse.aeb_images[i2].uri);
                                e.e.a.h.a.b(sb3.toString());
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str);
                                sb4.append(takePictureResponse.aeb_images[i2].s_thumbnail.length);
                                e.e.a.h.a.b(sb4.toString());
                            }
                        } else {
                            e.e.a.h.a.b("mResponse.aeb_images null");
                        }
                        OneBleImplement.this.mCallbacks.onStillImageWithStorageNotify(takePictureResponse);
                    }
                });
            }

            public void onDriverTimelapseNotify(final int i2, final VideoResult videoResult) {
                OneBleImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = e.a.a.a.a.a("handleDriverTimelapseNotify error code ");
                        a2.append(videoResult.error_code);
                        a2.append(" state ");
                        a2.append(i2);
                        e.e.a.h.a.b(a2.toString());
                        StringBuilder sb = new StringBuilder();
                        sb.append("uri ");
                        sb.append(videoResult.video.uri);
                        e.e.a.h.a.b(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("file_size ");
                        sb2.append(videoResult.video.file_size);
                        e.e.a.h.a.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("total_time ");
                        sb3.append(videoResult.video.total_time);
                        e.e.a.h.a.b(sb3.toString());
                        int i2 = i2;
                        if (i2 == 0) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(4);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("timelapse STARTED mRecordStatus ");
                            sb4.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.b(sb4.toString());
                        } else if (i2 == 1) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(5);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("timelapse COMPLETE mRecordStatus ");
                            sb5.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.b(sb5.toString());
                            if (OneBleImplement.this.mRecordStatus != RecordStatus.Stopping) {
                                StringBuilder a3 = e.a.a.a.a.a("received record complete message, status: ");
                                a3.append(OneBleImplement.this.mRecordStatus);
                                Log.w("OneBle", a3.toString());
                                return;
                            }
                            OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else if (i2 == 2) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(4);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(5);
                            OneBleImplement.this.mRecordStatus = RecordStatus.TimelapseError;
                        } else if (i2 == 3) {
                            OneBleImplement.this.mHandlerTimeout.removeMessages(4);
                            OneBleImplement.this.mHandlerTimeout.removeMessages(5);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("received cancelled, record status: ");
                            sb6.append(OneBleImplement.this.mRecordStatus);
                            e.e.a.h.a.a(sb6.toString());
                            OneBleImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else {
                            StringBuilder a4 = e.a.a.a.a.a("onDriverRecordVideoStateNotify state: ");
                            a4.append(i2);
                            throw new IllegalStateException(a4.toString());
                        }
                        OneBleImplement.this.mCBHandler.post(new Runnable() {
                            public void run() {
                                OneBleCallbacks access$000 = OneBleImplement.this.mCallbacks;
                                AnonymousClass4 r1 = AnonymousClass4.this;
                                access$000.onTimelapseNotify(i2, videoResult);
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void startAdverting(int i2, byte b2, String str) {
    }

    private void stopCaptureWithStorage(byte[] bArr) {
        this.mRecordStatus = RecordStatus.Stopping;
        this.mDriver.stopRecordWithCameraStorage(bArr);
        sendDelayMsg(3, 20000);
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        checkConnectSynced("calibrateGyro");
        return this.mDriver.calibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        checkConnectSynced("cancelAuthorization");
        return this.mDriver.cancelAuthorization();
    }

    public void cancelScan(boolean z) {
    }

    public void captureStillImage(TakePicture takePicture, int i2) {
        checkRecordIdle("captureStillImage");
        this.mDriver.captureStillImage(takePicture);
        if (i2 > 20000) {
            sendDelayMsg(1, i2);
        } else {
            sendDelayMsg(1, 20000);
        }
    }

    public long checkAuthorization(CheckAuthorization checkAuthorization) {
        checkConnectSynced("checkAuthorization");
        return this.mDriver.checkAuthorization(checkAuthorization.uniqueId);
    }

    public long closeCameraOled() {
        checkConnectSynced("closeCameraOled");
        return this.mDriver.closeCameraOled();
    }

    public long closeCameraWifi() {
        checkConnectSynced("closeCameraWifi");
        return this.mDriver.closeCameraWifi();
    }

    public void closeConnect() {
        StringBuilder a2 = e.a.a.a.a.a("closeConnect mConnectState ");
        a2.append(this.mConnectState);
        a2.append(" mRecordStatus ");
        a2.append(this.mRecordStatus);
        e.e.a.h.a.b(a2.toString());
        isAllowClose();
        if (this.bWriting) {
            e.e.a.h.a.a("closeConnect while writing");
        }
        if (this.mDriver != null) {
            this.mDriverHandlerThread.quit();
            try {
                this.mDriverHandlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mDriverHandlerThread = null;
            this.mHandlerTimeout = null;
            this.mDriver = null;
        }
        resetInfo();
        this.mConnectState = ConnectState.Idle;
        cancelScan(false);
    }

    public long eraseSDCard() {
        checkConnectSynced("eraseSDCard");
        return this.mDriver.eraseSDCard();
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public Options getAllOptions() {
        checkConnectSynced("getAllOptions");
        return this.mDriver.getAllOptions();
    }

    public long getAllOptionsAsync() {
        checkConnectSynced("getAllOptionsAsync");
        return this.mDriver.getAllOptionsAsync();
    }

    public long getCaptureStatus() {
        checkConnectSynced("getCaptureStatus");
        return this.mDriver.getCaptureStatus();
    }

    public int getCharaProp() {
        return this.charaProp;
    }

    public BluetoothGattCharacteristic getCharacteristicNotify() {
        return this.characteristicNotify;
    }

    public BluetoothGattCharacteristic getCharacteristicRW() {
        return this.characteristicRW;
    }

    public void getFileInfoList() {
        checkConnect("getFileInfoList");
        this.mDriver.getFileInfoList();
    }

    public BluetoothGatt getGatt() {
        return this.gatt;
    }

    public String getMac() {
        return this.mac;
    }

    public long getMiniThumbnail(GetMiniThumbnail getMiniThumbnail) {
        checkConnectSynced("getMiniThumbnail");
        return this.mDriver.getMiniThumbnail(getMiniThumbnail);
    }

    public String getName() {
        return this.name;
    }

    public Options getOptions(List<String> list) {
        checkConnectSynced("getOptions");
        return this.mDriver.getOptions(list);
    }

    public long getOptionsAsync(List<String> list) {
        checkConnectSynced("getOptionsAsync");
        return this.mDriver.getOptionsAsync(list);
    }

    public PhotoOptions getPhotoOptions(int i2) {
        checkConnectSynced("getPhotoOptions");
        return this.mDriver.getPhotographyOptions(i2, null);
    }

    public long getPhotoOptionsAsync(int i2) {
        checkConnectSynced("getPhotoOptionsAsync");
        return this.mDriver.getPhotographyOptionsAsync(i2, null);
    }

    public BluetoothGattService getService() {
        return this.service;
    }

    public TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions) {
        checkConnectSynced("getTimelapseOption");
        return this.mDriver.getTimelapseOptions(getTimelapseOptions);
    }

    public long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions) {
        checkConnectSynced("getTimelapseOptionAsync");
        return this.mDriver.getTimelapseOptionsAsync(getTimelapseOptions);
    }

    public boolean isNoncancelableTaskRunning() {
        StringBuilder a2 = e.a.a.a.a.a("isNoncancelableTaskRunning mRecordStatus is ");
        a2.append(this.mRecordStatus);
        a2.append(" mConnectState ");
        a2.append(this.mConnectState);
        e.e.a.h.a.b(a2.toString());
        if (this.mRecordStatus != RecordStatus.Stopping) {
            return false;
        }
        if (this.mConnectState != ConnectState.Disconnected) {
            return true;
        }
        Log.i("OneBle", "close ble met disconnect");
        return false;
    }

    public boolean isSupportBle() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public long openCameraOled() {
        checkConnectSynced("openCameraOled");
        return this.mDriver.openCameraOled();
    }

    public long openCameraWifi() {
        checkConnectSynced("openCameraWifi");
        return this.mDriver.openCameraWifi();
    }

    public long reboot() {
        checkConnectSynced("reboot");
        return this.mDriver.reboot();
    }

    public void recoverCamera(String str) {
        if (!TextUtils.isEmpty(str)) {
            OneBleDriver oneBleDriver = this.mDriver;
            if (oneBleDriver != null) {
                oneBleDriver.putData(str.getBytes());
            }
        }
    }

    public void release() {
        e.e.a.h.a.b("release");
        if (this.mConnectState != ConnectState.Idle) {
            closeConnect();
        }
        this.mReleased = true;
    }

    public synchronized void requestMtu(int i2) {
        checkConnectSynced("requestMtu");
        StringBuilder sb = new StringBuilder();
        sb.append("requestMtu ");
        sb.append(i2);
        e.e.a.h.a.b(sb.toString());
        getGatt().requestMtu(i2);
    }

    public void resetRecord() {
        StringBuilder a2 = e.a.a.a.a.a("resetRecord mConnectState ");
        a2.append(this.mConnectState);
        a2.append(" mRecordStatus ");
        a2.append(this.mRecordStatus);
        e.e.a.h.a.b(a2.toString());
        if (!(this.mRecordStatus == RecordStatus.Error && this.mRecordStatus == RecordStatus.TimelapseError)) {
            StringBuilder a3 = e.a.a.a.a.a("resetRecord record status ");
            a3.append(this.mRecordStatus);
            new IllegalStateException(a3.toString());
        }
        if (this.mConnectState != ConnectState.Disconnected) {
            if (this.mRecordStatus == RecordStatus.TimelapseError) {
                this.mDriver.stopTimeplapse(new StopTimelapse());
            } else {
                this.mDriver.stopRecordWithCameraStorage(null);
            }
        }
        this.mRecordStatus = RecordStatus.Idle;
    }

    public void scanAndConnect(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("scanAndConnect name ");
        sb.append(str);
        e.e.a.h.a.b(sb.toString());
        scanWithConnectName(str, str2, z);
    }

    public void scanDevice() {
        scanWithConnectName(null, null, false);
    }

    public void setBleInfoUpdateListener(Handler handler, BleInfoUpdateListener bleInfoUpdateListener) {
        this.mInfoHandler = handler;
        this.mBleInfoUpdateListener = bleInfoUpdateListener;
    }

    public void setCharaProp(int i2) {
        this.charaProp = i2;
    }

    public void setCharacteristicNotify(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.characteristicNotify = bluetoothGattCharacteristic;
    }

    public void setCharacteristicRW(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.characteristicRW = bluetoothGattCharacteristic;
    }

    public int setOptions(Options options) {
        checkConnectSynced("setOptions");
        return this.mDriver.setOptions(options);
    }

    public long setOptionsAsync(Options options) {
        checkConnectSynced("setOptionsAsync");
        return this.mDriver.setOptionsAsync(options);
    }

    public int setPhotoOptions(int i2, PhotoOptions photoOptions) {
        checkConnectSynced("setPhotoOptions");
        return this.mDriver.setPhotographyOptions(i2, photoOptions);
    }

    public long setPhotoOptionsAsync(int i2, PhotoOptions photoOptions) {
        checkConnectSynced("setPhotoOptionsAsync");
        return this.mDriver.setPhotographyOptionsAsync(i2, photoOptions);
    }

    public void setService(BluetoothGattService bluetoothGattService) {
        this.service = bluetoothGattService;
    }

    public void setTimelapseOption(SetTimelapseOptions setTimelapseOptions) {
        checkConnectSynced("setTimelapseOption");
        this.mDriver.setTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionAsync(SetTimelapseOptions setTimelapseOptions) {
        checkConnectSynced("setTimelapseOptionAsync");
        return this.mDriver.setTimelapseOptionsASync(setTimelapseOptions);
    }

    public void startBroadCast(int i2, byte b2, String str) {
        Message obtain = Message.obtain();
        obtain.arg1 = i2;
        obtain.arg2 = b2;
        obtain.obj = str;
        obtain.what = 6;
        this.mBroadcastCount = 0;
        this.mAdvertiseHandler.sendMessage(obtain);
    }

    public void startBulletTime() {
        this.mRecordStatus = RecordStatus.Recording;
        this.mDriver.startBulletTime();
    }

    public int startCaptureWithStorage() {
        checkRecordIdle("startCaptureWithStorage");
        this.mRecordStatus = RecordStatus.Recording;
        int startRecordWithCameraStorage = this.mDriver.startRecordWithCameraStorage();
        sendDelayMsg(2, 20000);
        return startRecordWithCameraStorage;
    }

    public void startTimeplapse(StartTimelapse startTimelapse, int i2) {
        this.mRecordStatus = RecordStatus.Recording;
        this.mDriver.startTimeplapse(startTimelapse);
        if (i2 > 20000) {
            sendDelayMsg(4, i2);
        } else {
            sendDelayMsg(4, 20000);
        }
    }

    public void stopBroadCast() {
        e.e.a.h.a.b("stopBroadCast");
    }

    public void stopBulletTime(byte[] bArr) {
        if (this.mConnectState != ConnectState.Disconnected) {
            this.mDriver.stopBulletTime(bArr);
            this.mRecordStatus = RecordStatus.Stopping;
            return;
        }
        Log.e("OneBle", "stop bullettime when ble disconnected");
    }

    public void stopRecord(byte[] bArr) {
        StringBuilder a2 = e.a.a.a.a.a("stop record extraData len ");
        a2.append(bArr.length);
        e.e.a.h.a.b(a2.toString());
        String str = "OneBle";
        if (this.mRecordStatus == RecordStatus.Error) {
            Log.w(str, "stop record won't run as recorder is already met error,need call resetRecord in App");
            return;
        }
        checkRecord("stopRecord");
        if (this.mConnectState != ConnectState.Disconnected) {
            this.mRecordStatus = RecordStatus.Stopping;
            stopCaptureWithStorage(bArr);
        } else {
            Log.e(str, "stop Record when ble disconnect");
        }
    }

    public void stopTimeplapse(StopTimelapse stopTimelapse) {
        String str = "OneBle";
        if (this.mRecordStatus == RecordStatus.TimelapseError) {
            Log.w(str, "stop record won't run as recorder is already met error,need call reset in app");
            return;
        }
        if (this.mConnectState != ConnectState.Disconnected) {
            this.mDriver.stopTimeplapse(stopTimelapse);
            this.mRecordStatus = RecordStatus.Stopping;
            sendDelayMsg(5, 20000);
        } else {
            Log.e(str, "stop timelapse when ble disconnected");
        }
    }

    public long syncCaptureStatus() {
        checkConnect("syncCaptureStatus");
        return this.mDriver.resumeInitialState();
    }

    public long testSDCardSpeed(TestSDCardSpeed testSDCardSpeed) {
        checkConnectSynced("testSDCardSpeed");
        return this.mDriver.testSDCardSpeed(testSDCardSpeed);
    }

    public PhotoOptions getPhotoOptions(int i2, List<String> list) {
        checkConnectSynced("getPhotoOptions");
        return this.mDriver.getPhotographyOptions(i2, list);
    }

    public long getPhotoOptionsAsync(int i2, List<String> list) {
        checkConnectSynced("getPhotoOptionsAsync");
        return this.mDriver.getPhotographyOptionsAsync(i2, list);
    }
}
