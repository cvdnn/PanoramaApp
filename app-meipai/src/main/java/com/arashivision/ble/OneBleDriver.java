package com.arashivision.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.arashivision.ble.OneBleImplement.OneBleIOCallbacks;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.GetMiniThumbnail;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import e.e.a.h.a;
import java.lang.ref.WeakReference;
import java.util.List;

public class OneBleDriver {
    public static final int DRIVER_BLE_STATE_NOTIFY = 5;
    public static final int DRIVER_INFO_NOTIFY = 0;
    public static final int DRIVER_RECORD_VIDEO_STATE_NOTIFY = 3;
    public static final int DRIVER_STILL_IMAGE_NOTIFY = 2;
    public static final int DRIVER_TIMELAPSESTATE_NOTIFY = 4;
    public static final String TAG = "OneBleDriver";
    public long mNativeInstance;
    public Handler mNotificationHandler;
    public OnNotificationListener mOnNotificationListenerListener;
    public OneBleIO mOneBleIO;
    public State mState = State.Idle;

    public static class NativeLibsLoader {
        public static boolean mLoaded;
        public static final Object mSyncObject = new Object();

        public static void load() {
            synchronized (mSyncObject) {
                if (!mLoaded) {
                    a.b("NativeLibsLoader");
                    System.loadLibrary("c++_shared");
                    System.loadLibrary("native_utils");
                    System.loadLibrary("usb-1.0");
                    System.loadLibrary("One");
                    mLoaded = true;
                    a.b("NativeLibsLoader suc");
                }
            }
        }
    }

    public static class NotificationHandler extends Handler {
        public WeakReference<OneBleDriver> mOneDriverWeakRef;

        public NotificationHandler(OneBleDriver oneBleDriver, Looper looper) {
            super(looper);
            this.mOneDriverWeakRef = new WeakReference<>(oneBleDriver);
        }

        public void handleMessage(Message message) {
            OneBleDriver oneBleDriver = (OneBleDriver) this.mOneDriverWeakRef.get();
            String str = OneBleDriver.TAG;
            if (oneBleDriver == null) {
                StringBuilder a2 = e.a.a.a.a.a("OneBleDriver.NotificationHandler handleMessage: ");
                a2.append(message.what);
                a2.append(", but driver not exists now");
                Log.w(str, a2.toString());
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                oneBleDriver.handleDriverInfoNotify(message.arg1, message.arg2, message.obj);
            } else if (i2 == 2) {
                oneBleDriver.handleDriverStillImageNotify((TakePictureResponse) message.obj);
            } else if (i2 == 3) {
                oneBleDriver.handleDriverRecordVideoStateNotify(message.arg1, (VideoResult) message.obj);
            } else if (i2 == 4) {
                oneBleDriver.handleDriverTimelapseNotify(message.arg1, (VideoResult) message.obj);
            } else if (i2 != 5) {
                e.a.a.a.a.c("OneBleDriver handle what ", i2, str);
            } else {
                oneBleDriver.handleDriverBleState(message.arg1);
            }
        }
    }

    public interface OnNotificationListener {
        void onDriverBleState(int i2);

        void onDriverInfoNotify(int i2, int i3, Object obj);

        void onDriverRecordVideoStateNotify(int i2, VideoResult videoResult);

        void onDriverStillImageNotify(TakePictureResponse takePictureResponse);

        void onDriverTimelapseNotify(int i2, VideoResult videoResult);
    }

    public enum State {
        Idle,
        Release
    }

    static {
        NativeLibsLoader.load();
    }

    public OneBleDriver(Context context, Looper looper, OneBleIOCallbacks oneBleIOCallbacks) {
        if (looper == null) {
            looper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        } else {
            a.b("bledriver use non ui looper");
        }
        this.mNotificationHandler = new NotificationHandler(this, looper);
        open(oneBleIOCallbacks);
    }

    private void close() {
        nativeClose(this.mOneBleIO);
        this.mOneBleIO = null;
    }

    private void driverBleStateNotify(int i2) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(5, i2, 0));
    }

    private void driverInfoNotify(int i2, int i3, Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(0, i2, i3, obj));
    }

    private void driverRecordVideoStateNotify(int i2, Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(3, i2, 0, obj));
    }

    private void driverStillImageNotify(Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(2, obj));
    }

    private void driverTimelapseNotify(int i2, Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(4, i2, 0, obj));
    }

    /* access modifiers changed from: private */
    public void handleDriverBleState(int i2) {
        this.mOnNotificationListenerListener.onDriverBleState(i2);
    }

    /* access modifiers changed from: private */
    public void handleDriverInfoNotify(int i2, int i3, Object obj) {
        this.mOnNotificationListenerListener.onDriverInfoNotify(i2, i3, obj);
    }

    /* access modifiers changed from: private */
    public void handleDriverRecordVideoStateNotify(int i2, VideoResult videoResult) {
        this.mOnNotificationListenerListener.onDriverRecordVideoStateNotify(i2, videoResult);
    }

    /* access modifiers changed from: private */
    public void handleDriverStillImageNotify(TakePictureResponse takePictureResponse) {
        this.mOnNotificationListenerListener.onDriverStillImageNotify(takePictureResponse);
    }

    /* access modifiers changed from: private */
    public void handleDriverTimelapseNotify(int i2, VideoResult videoResult) {
        this.mOnNotificationListenerListener.onDriverTimelapseNotify(i2, videoResult);
    }

    private native long nativeCalibrateGyro(CalibrateGyro calibrateGyro);

    private native long nativeCancelAuthorization();

    private native void nativeCancelCaptureWithStorage();

    private native void nativeCaptureStillImage(TakePicture takePicture);

    private native long nativeCheckAuthorization(String str);

    private native void nativeClose(OneBleIO oneBleIO);

    private native long nativeCloseCameraOled();

    private native long nativeCloseCameraWifi();

    private native long nativeEraseSDCard();

    private native Options nativeGetAllOptions();

    private native long nativeGetAllOptionsAsync();

    private native long nativeGetCaptureStatus();

    private native long nativeGetFileInfoList();

    private native long nativeGetMiniThumb(GetMiniThumbnail getMiniThumbnail);

    private native Options nativeGetOptions(List<String> list);

    private native long nativeGetOptionsAsync(List<String> list);

    private native PhotoOptions nativeGetPhotographyOptions(int i2, List<String> list);

    private native long nativeGetPhotographyOptionsAsync(int i2, List<String> list);

    private native TimelapseOptionsInfo nativeGetTimelapseOptions(GetTimelapseOptions getTimelapseOptions);

    private native long nativeGetTimelapseOptionsAsync(GetTimelapseOptions getTimelapseOptions);

    private native int nativeOpen(OneBleIO oneBleIO);

    private native long nativeOpenCameraOled();

    private native long nativeOpenCameraWifi();

    private native long nativeReboot();

    private native long nativeResumeInitialState();

    private native void nativeSendHeartBeats();

    private native int nativeSetOptions(Options options);

    private native long nativeSetOptionsAsync(Options options);

    private native int nativeSetPhotographyOptions(int i2, PhotoOptions photoOptions);

    private native long nativeSetPhotographyOptionsAsync(int i2, PhotoOptions photoOptions);

    private native void nativeSetTimelapseOptions(SetTimelapseOptions setTimelapseOptions);

    private native long nativeSetTimelapseOptionsAsync(SetTimelapseOptions setTimelapseOptions);

    private native void nativeStartBullet();

    private native int nativeStartCaptureWithStorage();

    private native void nativeStartTimelapse(StartTimelapse startTimelapse);

    private native void nativeStopBullet(byte[] bArr);

    private native void nativeStopCaptureWithStorage(byte[] bArr);

    private native void nativeStopTimelapse(StopTimelapse stopTimelapse);

    private native long nativeTestSDCardSpeed(TestSDCardSpeed testSDCardSpeed);

    private int open(OneBleIOCallbacks oneBleIOCallbacks) {
        OneBleIO oneBleIO = new OneBleIO(oneBleIOCallbacks);
        this.mOneBleIO = oneBleIO;
        return nativeOpen(oneBleIO);
    }

    private void release() {
        a.b("release");
        close();
        this.mState = State.Release;
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        return nativeCalibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        return nativeCancelAuthorization();
    }

    public void captureStillImage(TakePicture takePicture) {
        nativeCaptureStillImage(takePicture);
    }

    public long checkAuthorization(String str) {
        return nativeCheckAuthorization(str);
    }

    public long closeCameraOled() {
        return nativeCloseCameraOled();
    }

    public long closeCameraWifi() {
        return nativeCloseCameraWifi();
    }

    public long eraseSDCard() {
        return nativeEraseSDCard();
    }

    public void finalize() throws Throwable {
        if (this.mState != State.Release) {
            Log.e(TAG, "finalize(): player not released, force clean");
            release();
        }
        super.finalize();
    }

    public Options getAllOptions() {
        return nativeGetAllOptions();
    }

    public long getAllOptionsAsync() {
        return nativeGetAllOptionsAsync();
    }

    public long getCaptureStatus() {
        return nativeGetCaptureStatus();
    }

    public void getFileInfoList() {
        nativeGetFileInfoList();
    }

    public long getMiniThumbnail(GetMiniThumbnail getMiniThumbnail) {
        return nativeGetMiniThumb(getMiniThumbnail);
    }

    public Options getOptions(List<String> list) {
        return nativeGetOptions(list);
    }

    public long getOptionsAsync(List<String> list) {
        return nativeGetOptionsAsync(list);
    }

    public PhotoOptions getPhotographyOptions(int i2, List<String> list) {
        return nativeGetPhotographyOptions(i2, list);
    }

    public long getPhotographyOptionsAsync(int i2, List<String> list) {
        return nativeGetPhotographyOptionsAsync(i2, list);
    }

    public TimelapseOptionsInfo getTimelapseOptions(GetTimelapseOptions getTimelapseOptions) {
        return nativeGetTimelapseOptions(getTimelapseOptions);
    }

    public long getTimelapseOptionsAsync(GetTimelapseOptions getTimelapseOptions) {
        return nativeGetTimelapseOptionsAsync(getTimelapseOptions);
    }

    public long openCameraOled() {
        return nativeOpenCameraOled();
    }

    public long openCameraWifi() {
        return nativeOpenCameraWifi();
    }

    public void putData(byte[] bArr) {
        this.mOneBleIO.putData(bArr);
    }

    public long reboot() {
        return nativeReboot();
    }

    public long resumeInitialState() {
        return nativeResumeInitialState();
    }

    public void sendHeartBeats() {
        nativeSendHeartBeats();
    }

    public void setBleError(int i2) {
        OneBleIO oneBleIO = this.mOneBleIO;
        if (oneBleIO != null) {
            oneBleIO.setBleErr(i2);
        }
    }

    public void setNotificationListener(OnNotificationListener onNotificationListener) {
        this.mOnNotificationListenerListener = onNotificationListener;
    }

    public int setOptions(Options options) {
        return nativeSetOptions(options);
    }

    public long setOptionsAsync(Options options) {
        return nativeSetOptionsAsync(options);
    }

    public int setPhotographyOptions(int i2, PhotoOptions photoOptions) {
        return nativeSetPhotographyOptions(i2, photoOptions);
    }

    public long setPhotographyOptionsAsync(int i2, PhotoOptions photoOptions) {
        return nativeSetPhotographyOptionsAsync(i2, photoOptions);
    }

    public void setTimelapseOptions(SetTimelapseOptions setTimelapseOptions) {
        nativeSetTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions) {
        return nativeSetTimelapseOptionsAsync(setTimelapseOptions);
    }

    public void startBulletTime() {
        nativeStartBullet();
    }

    public int startRecordWithCameraStorage() {
        return nativeStartCaptureWithStorage();
    }

    public void startTimeplapse(StartTimelapse startTimelapse) {
        nativeStartTimelapse(startTimelapse);
    }

    public void stopBulletTime(byte[] bArr) {
        nativeStopBullet(bArr);
    }

    public void stopRecordWithCameraStorage(byte[] bArr) {
        nativeStopCaptureWithStorage(bArr);
    }

    public void stopTimeplapse(StopTimelapse stopTimelapse) {
        nativeStopTimelapse(stopTimelapse);
    }

    public long testSDCardSpeed(TestSDCardSpeed testSDCardSpeed) {
        return nativeTestSDCardSpeed(testSDCardSpeed);
    }
}
