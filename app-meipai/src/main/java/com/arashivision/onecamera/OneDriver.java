package com.arashivision.onecamera;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.arashivision.ble.OneBleIO;
import com.arashivision.ble.OneBleImplement.OneBleIOCallbacks;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.ConnectToBTPeripheral;
import com.arashivision.onecamera.camerarequest.DeleteFiles;
import com.arashivision.onecamera.camerarequest.DisconnectBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetConnectedBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetFileExtra;
import com.arashivision.onecamera.camerarequest.GetFileList;
import com.arashivision.onecamera.camerarequest.GetGyro;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.KeyTimePoint;
import com.arashivision.onecamera.camerarequest.ScanBTPeripheral;
import com.arashivision.onecamera.camerarequest.SetFileExtra;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onecamera.cameraresponse.GetGyroResp;
import com.arashivision.onecamera.cameraresponse.StreamData;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.TakePictureWithoutStorageResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.List;

public class OneDriver {
    public static final int DRIVER_INFO_NOTIFY = 0;
    public static final int DRIVER_RECORD_VIDEO_STATE_NOTIFY = 3;
    public static final int DRIVER_STEAM_DATA_NOTIFY = 5;
    public static final int DRIVER_STILL_IMAGE_NOTIFY = 2;
    public static final int DRIVER_STILL_IMAGE_WITHOUT_STORAGE_NOTIFY = 6;
    public static final int DRIVER_TIMELAPSESTATE_NOTIFY = 4;
    public static final int DRIVER_USB_ERROR_NOTIFY = 1;
    public static final String TAG = "OneDriverJava";
    public boolean isSendWifiDebug;
    public long mNativeInstance;
    public Handler mNotificationHandler;
    public OnNotificationListener mOnNotificationListenerListener;
    public OneBleIO mOneBleIO;
    public OnStreamListener mStreamListener;

    public static class NativeLibsLoader {
        public static boolean mLoaded;
        public static final Object mSyncObject = new Object();

        public static void load() {
            synchronized (mSyncObject) {
                if (!mLoaded) {
                    Log.i(OneDriver.TAG, "NativeLibsLoader");
                    System.loadLibrary("c++_shared");
                    System.loadLibrary("usb-1.0");
                    System.loadLibrary("One");
                    mLoaded = true;
                    Log.i(OneDriver.TAG, "NativeLibsLoader suc");
                }
            }
        }
    }

    public static class NotificationHandler extends Handler {
        public WeakReference<OneDriver> mOneDriverWeakRef;

        public NotificationHandler(OneDriver oneDriver, Looper looper) {
            super(looper);
            this.mOneDriverWeakRef = new WeakReference<>(oneDriver);
        }

        public void handleMessage(Message message) {
            OneDriver oneDriver = (OneDriver) this.mOneDriverWeakRef.get();
            String str = OneDriver.TAG;
            if (oneDriver == null) {
                StringBuilder a2 = a.a("OneDriver.NotificationHandler handleMessage: ");
                a2.append(message.what);
                a2.append(", but driver not exists now");
                Log.w(str, a2.toString());
                return;
            }
            int i2 = message.what;
            switch (i2) {
                case 0:
                    oneDriver.handleDriverInfoNotify(message.arg1, message.arg2, message.obj);
                    break;
                case 1:
                    oneDriver.handleDriverUsbState(message.arg1, message.arg2);
                    break;
                case 2:
                    oneDriver.handleDriverStillImageNotify((TakePictureResponse) message.obj);
                    break;
                case 3:
                    oneDriver.handleDriverRecordVideoStateNotify(message.arg1, (VideoResult) message.obj);
                    break;
                case 4:
                    oneDriver.handleDriverTimelapseNotify(message.arg1, (VideoResult) message.obj);
                    break;
                case 5:
                    oneDriver.handleDriverStreamDataNotify((StreamData) message.obj);
                    break;
                case 6:
                    oneDriver.handleDriverStillImageWithoutStorageNotify((TakePictureWithoutStorageResponse) message.obj);
                    break;
                default:
                    a.c("OneDriver handle what ", i2, str);
                    break;
            }
        }
    }

    public interface OnNotificationListener {
        void onDriverInfoNotify(int i2, int i3, Object obj);

        void onDriverRecordVideoStateNotify(int i2, VideoResult videoResult);

        void onDriverStillImageNotify(TakePictureResponse takePictureResponse);

        void onDriverStillImageWithoutStorageNotify(TakePictureWithoutStorageResponse takePictureWithoutStorageResponse);

        void onDriverStreamDataNotify(StreamData streamData);

        void onDriverTimelapseNotify(int i2, VideoResult videoResult);

        void onDriverUsbState(int i2, int i3);
    }

    public interface OnStreamListener {
        void onDriverStreamDataNotify(StreamData streamData);
    }

    static {
        NativeLibsLoader.load();
    }

    public OneDriver(Context context, Looper looper) {
        String str = TAG;
        Log.d(str, "OneDriver");
        if (looper != null) {
            Log.d(str, "use non ui handler");
        } else if (Looper.myLooper() != null) {
            looper = Looper.getMainLooper();
            Log.d(str, "OneDriver getMainLooper");
        } else {
            looper = Looper.myLooper();
            Log.d(str, "OneDriver myLooper");
        }
        this.mNotificationHandler = new NotificationHandler(this, looper);
        Log.d(str, "OneDriver over");
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

    private void driverStillImageWithoutStorageNotify(Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(6, obj));
    }

    private void driverStreamDataNotify(Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(5, obj));
    }

    private void driverTimelapseNotify(int i2, Object obj) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(4, i2, 0, obj));
    }

    private void driverUsbStateNotify(int i2, int i3) {
        Handler handler = this.mNotificationHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, i3));
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
    public void handleDriverStillImageWithoutStorageNotify(TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        this.mOnNotificationListenerListener.onDriverStillImageWithoutStorageNotify(takePictureWithoutStorageResponse);
    }

    /* access modifiers changed from: private */
    public void handleDriverStreamDataNotify(StreamData streamData) {
        OnStreamListener onStreamListener = this.mStreamListener;
        if (onStreamListener != null) {
            onStreamListener.onDriverStreamDataNotify(streamData);
        }
    }

    /* access modifiers changed from: private */
    public void handleDriverTimelapseNotify(int i2, VideoResult videoResult) {
        this.mOnNotificationListenerListener.onDriverTimelapseNotify(i2, videoResult);
    }

    /* access modifiers changed from: private */
    public void handleDriverUsbState(int i2, int i3) {
        this.mOnNotificationListenerListener.onDriverUsbState(i2, i3);
    }

    private native long nativeBadPointTest();

    private native long nativeBlackLevelTest();

    private native long nativeCalibrateGyro(CalibrateGyro calibrateGyro);

    private native long nativeCancelAuthorization();

    private native void nativeCancelCaptureWithStorage();

    private native void nativeCaptureStillImage(TakePicture takePicture);

    private native void nativeCaptureStillImageWithoutStorage(TakePicture takePicture);

    private native long nativeCheckAuthorization(String str);

    private native void nativeClose();

    private native long nativeCloseCameraOled();

    private native long nativeCloseCameraWifi();

    private native long nativeCloseIperf();

    private native long nativeConnectBT(ConnectToBTPeripheral connectToBTPeripheral);

    private native long nativeDeleteFiles(DeleteFiles deleteFiles);

    private native long nativeDisConnectBT(DisconnectBTPeripheral disconnectBTPeripheral);

    private native long nativeDspLinkTest();

    private native long nativeEraseSDCard();

    private native long nativeGetAgeTestStatus();

    private native Options nativeGetAllOptions();

    private native long nativeGetAllOptionsAsync();

    private native long nativeGetCaptureStatus();

    private native long nativeGetConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral);

    private native long nativeGetFileExtra(GetFileExtra getFileExtra);

    private native long nativeGetFileInfoList();

    private native long nativeGetFileList(GetFileList getFileList);

    private native long nativeGetFlowStateEnable();

    private native GetGyroResp nativeGetGyro(GetGyro getGyro);

    private native long nativeGetGyroAsync(GetGyro getGyro);

    private native long nativeGetIperfAverage();

    private native long nativeGetMultiVideoMode(List<String> list);

    private native Options nativeGetOptions(List<String> list);

    private native long nativeGetOptionsAsync(List<String> list);

    private native PhotoOptions nativeGetPhotographyOptions(int i2, List<String> list);

    private native long nativeGetPhotographyOptionsAsync(int i2, List<String> list);

    private native long nativeGetSingleSensor();

    private native long nativeGetSyncCaptureMode();

    private native TimelapseOptionsInfo nativeGetTimelapseOptions(GetTimelapseOptions getTimelapseOptions);

    private native long nativeGetTimelapseOptionsAsync(GetTimelapseOptions getTimelapseOptions);

    private native int nativeGetTunelPort();

    private native long nativeGyroScopeTest();

    private native long nativeMultiVideoMode(MultiPhotoOptions multiPhotoOptions);

    private native int nativeOpen(String str);

    private native int nativeOpenBle(OneBleIO oneBleIO);

    private native long nativeOpenCameraOled();

    private native long nativeOpenCameraWifi();

    private native long nativeOpenIperf(int i2);

    private native int nativeOpenWifi(int i2, String str, short s);

    private native int nativePutData(byte[] bArr);

    private native long nativeReboot();

    private native long nativeResumeInitialState();

    private native long nativeScanBT(ScanBTPeripheral scanBTPeripheral);

    private native void nativeSendHeartBeat();

    private native void nativeSendWifiHeartBeat();

    private native void nativeSetAudioParam(AudioParam audioParam);

    private native void nativeSetBleError(int i2);

    private native int nativeSetCameraWifiDebug(boolean z);

    private native long nativeSetFileExtra(SetFileExtra setFileExtra);

    private native long nativeSetFlowStateEnable(int i2);

    private native long nativeSetGPSData(byte[] bArr);

    private native long nativeSetKeyTimePoint(KeyTimePoint keyTimePoint);

    private native int nativeSetOptions(Options options);

    private native long nativeSetOptionsAsync(Options options);

    private native int nativeSetPhotographyOptions(int i2, PhotoOptions photoOptions);

    private native long nativeSetPhotographyOptionsAsync(int i2, PhotoOptions photoOptions);

    private native long nativeSetStandByMode(int i2);

    private native long nativeSetSyncCaptureMode(int i2);

    private native int nativeSetTimelapseOptions(SetTimelapseOptions setTimelapseOptions);

    private native long nativeSetTimelapseOptionsAsync(SetTimelapseOptions setTimelapseOptions);

    private native void nativeSetVideoParam(VideoParam videoParam);

    private native long nativeSingleSensor(int i2);

    private native long nativeStartBluetoothStatusTest();

    private native int nativeStartBulletTime();

    private native int nativeStartCaptureWithStorage(int i2);

    private native void nativeStartColorTest();

    private native void nativeStartContactTest();

    private native void nativeStartHdrCapture();

    private native long nativeStartLedTest();

    private native long nativeStartSpeakerTest();

    private native long nativeStartStreaming();

    private native long nativeStartStreaming2(VideoParam videoParam, VideoParam videoParam2, AudioParam audioParam, int i2);

    private native void nativeStartTimeShift();

    private native void nativeStartTimelapse(StartTimelapse startTimelapse);

    private native long nativeStartWifiStatusTest();

    private native void nativeStopBulletTime(byte[] bArr);

    private native void nativeStopCaptureWithStorage(int i2, byte[] bArr);

    private native void nativeStopHdrCapture(byte[] bArr);

    private native void nativeStopLCDTest();

    private native long nativeStopStreaming();

    private native void nativeStopTimeShift(byte[] bArr);

    private native void nativeStopTimelapse(StopTimelapse stopTimelapse);

    private native void nativeSupportStreaming(boolean z);

    private native void nativeTestButtonPress();

    private native long nativeTestSDCardSpeed(TestSDCardSpeed testSDCardSpeed);

    private native void nativeTestTypeC();

    private native long nativeVibrateTest();

    private native long nativeWhiteBlanceTest();

    public static native void setCameraDevMode(boolean z);

    public long badPointTest() {
        return nativeBadPointTest();
    }

    public long blackLevelTest() {
        return nativeBlackLevelTest();
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        return nativeCalibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        return nativeCancelAuthorization();
    }

    public void cancelRecordWithCameraStorage() {
        nativeCancelCaptureWithStorage();
    }

    public void captureStillImage(TakePicture takePicture) {
        nativeCaptureStillImage(takePicture);
    }

    public void captureStillImageWithouStorage(TakePicture takePicture) {
        nativeCaptureStillImageWithoutStorage(takePicture);
    }

    public long checkAuthorization(String str) {
        return nativeCheckAuthorization(str);
    }

    public void close() {
        nativeClose();
    }

    public long closeCameraOled() {
        return nativeCloseCameraOled();
    }

    public long closeCameraWifi() {
        return nativeCloseCameraWifi();
    }

    public long closeIperf() {
        return nativeCloseIperf();
    }

    public long connectBT(ConnectToBTPeripheral connectToBTPeripheral) {
        return nativeConnectBT(connectToBTPeripheral);
    }

    public long deleteFiles(DeleteFiles deleteFiles) {
        return nativeDeleteFiles(deleteFiles);
    }

    public long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral) {
        return nativeDisConnectBT(disconnectBTPeripheral);
    }

    public long dspLinkTest() {
        return nativeDspLinkTest();
    }

    public long eraseSDCard() {
        return nativeEraseSDCard();
    }

    public long getAgeStatus() {
        return nativeGetAgeTestStatus();
    }

    public Options getAllOptions() {
        return nativeGetAllOptions();
    }

    public long getAllOptionsAsync() {
        return nativeGetAllOptionsAsync();
    }

    public int getCameraWifiDebug(boolean z) {
        return nativeSetCameraWifiDebug(z);
    }

    public long getCaptureStatus() {
        return nativeGetCaptureStatus();
    }

    public long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        return nativeGetConnectBT(getConnectedBTPeripheral);
    }

    public long getFileExtra(GetFileExtra getFileExtra) {
        return nativeGetFileExtra(getFileExtra);
    }

    public long getFileInfoList() {
        return nativeGetFileInfoList();
    }

    public long getFileList(GetFileList getFileList) {
        return nativeGetFileList(getFileList);
    }

    public long getFlowStateEnable() {
        return nativeGetFlowStateEnable();
    }

    public GetGyroResp getGyro(GetGyro getGyro) {
        return nativeGetGyro(getGyro);
    }

    public long getGyroAsync(GetGyro getGyro) {
        return nativeGetGyroAsync(getGyro);
    }

    public long getIperfAverage() {
        return nativeGetIperfAverage();
    }

    public long getMultiVideo(List<String> list) {
        return nativeGetMultiVideoMode(list);
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

    public long getSingleSensor() {
        return nativeGetSingleSensor();
    }

    public long getSyncCaptureMode() {
        return nativeGetSyncCaptureMode();
    }

    public TimelapseOptionsInfo getTimelapseOptions(GetTimelapseOptions getTimelapseOptions) {
        return nativeGetTimelapseOptions(getTimelapseOptions);
    }

    public long getTimelapseOptionsAsync(GetTimelapseOptions getTimelapseOptions) {
        return nativeGetTimelapseOptionsAsync(getTimelapseOptions);
    }

    public int getTunelPort() {
        return nativeGetTunelPort();
    }

    public long gyroScopeTest() {
        return nativeGyroScopeTest();
    }

    public int open(String str) {
        return nativeOpen(str);
    }

    public int openBle(OneBleIOCallbacks oneBleIOCallbacks) {
        OneBleIO oneBleIO = new OneBleIO(oneBleIOCallbacks);
        this.mOneBleIO = oneBleIO;
        return nativeOpenBle(oneBleIO);
    }

    public long openCameraOled() {
        return nativeOpenCameraOled();
    }

    public long openCameraWifi() {
        return nativeOpenCameraWifi();
    }

    public long openIperf(int i2) {
        return nativeOpenIperf(i2);
    }

    public int openWifi(int i2, String str, short s) {
        return nativeOpenWifi(i2, str, s);
    }

    public int putData(byte[] bArr) {
        return nativePutData(bArr);
    }

    public long reboot() {
        return nativeReboot();
    }

    public long resumeInitialState() {
        return nativeResumeInitialState();
    }

    public long scanBT(ScanBTPeripheral scanBTPeripheral) {
        return nativeScanBT(scanBTPeripheral);
    }

    public void sendHeartBeat() {
        nativeSendHeartBeat();
    }

    public void sendWifiHearBeat() {
        if (this.isSendWifiDebug) {
            Log.d(TAG, "send wifi heart beat");
        }
        nativeSendWifiHeartBeat();
    }

    public void setAudioParam(AudioParam audioParam) {
        nativeSetAudioParam(audioParam);
    }

    public void setBleError(int i2) {
        nativeSetBleError(i2);
    }

    public long setFileExtra(SetFileExtra setFileExtra) {
        return nativeSetFileExtra(setFileExtra);
    }

    public long setFlowStateEnable(int i2) {
        return nativeSetFlowStateEnable(i2);
    }

    public long setGPSData(byte[] bArr) {
        return nativeSetGPSData(bArr);
    }

    public long setKeyTimePoint(KeyTimePoint keyTimePoint) {
        return nativeSetKeyTimePoint(keyTimePoint);
    }

    public long setMultiVideoMode(MultiPhotoOptions multiPhotoOptions) {
        return nativeMultiVideoMode(multiPhotoOptions);
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

    public long setPhotographyOptions(int i2, PhotoOptions photoOptions) {
        return (long) nativeSetPhotographyOptions(i2, photoOptions);
    }

    public long setPhotographyOptionsAsync(int i2, PhotoOptions photoOptions) {
        return nativeSetPhotographyOptionsAsync(i2, photoOptions);
    }

    public long setSingleSensor(int i2) {
        return nativeSingleSensor(i2);
    }

    public long setStandbyMode(int i2) {
        return nativeSetStandByMode(i2);
    }

    public void setStreamListener(OnStreamListener onStreamListener) {
        this.mStreamListener = onStreamListener;
    }

    public void setSupportStreaming(boolean z) {
        nativeSupportStreaming(z);
    }

    public long setSyncCaptureMode(int i2) {
        return nativeSetSyncCaptureMode(i2);
    }

    public int setTimelapseOptions(SetTimelapseOptions setTimelapseOptions) {
        return nativeSetTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions) {
        return nativeSetTimelapseOptionsAsync(setTimelapseOptions);
    }

    public void setVideoParam(VideoParam videoParam) {
        nativeSetVideoParam(videoParam);
    }

    public int setWifiHeartDebug(boolean z) {
        this.isSendWifiDebug = z;
        return 0;
    }

    public long startBluetoothStatusTest() {
        return nativeStartBluetoothStatusTest();
    }

    public int startBulletTime() {
        return nativeStartBulletTime();
    }

    public void startColorTest() {
        nativeStartColorTest();
    }

    public void startContactTest() {
        nativeStartContactTest();
    }

    public void startHdrCapture() {
        nativeStartHdrCapture();
    }

    public long startLedTest() {
        return nativeStartLedTest();
    }

    public int startRecordWithCameraStorage(int i2) {
        return nativeStartCaptureWithStorage(i2);
    }

    public long startSpeakerTest() {
        return nativeStartSpeakerTest();
    }

    public long startStreaming() {
        return nativeStartStreaming();
    }

    public void startTimeShift() {
        nativeStartTimeShift();
    }

    public void startTimeplapse(StartTimelapse startTimelapse) {
        nativeStartTimelapse(startTimelapse);
    }

    public long startWifiStatusTest() {
        return nativeStartWifiStatusTest();
    }

    public void stopBulletTime(byte[] bArr) {
        nativeStopBulletTime(bArr);
    }

    public void stopHdrCapture(byte[] bArr) {
        nativeStopHdrCapture(bArr);
    }

    public void stopLCDTest() {
        nativeStopLCDTest();
    }

    public void stopRecordWithCameraStorage(int i2, byte[] bArr) {
        nativeStopCaptureWithStorage(i2, bArr);
    }

    public long stopStreaming() {
        return nativeStopStreaming();
    }

    public void stopTimeShift(byte[] bArr) {
        nativeStopTimeShift(bArr);
    }

    public void stopTimeplapse(StopTimelapse stopTimelapse) {
        nativeStopTimelapse(stopTimelapse);
    }

    public void testButtonPress() {
        nativeTestButtonPress();
    }

    public long testSDCardSpeed(TestSDCardSpeed testSDCardSpeed) {
        return nativeTestSDCardSpeed(testSDCardSpeed);
    }

    public void testTypeC() {
        nativeTestTypeC();
    }

    public long vibrateTest() {
        return nativeVibrateTest();
    }

    public long whiteBlanceTest() {
        return nativeWhiteBlanceTest();
    }

    public long startStreaming(VideoParam videoParam, VideoParam videoParam2, AudioParam audioParam, int i2) {
        return nativeStartStreaming2(videoParam, videoParam2, audioParam, i2);
    }
}
