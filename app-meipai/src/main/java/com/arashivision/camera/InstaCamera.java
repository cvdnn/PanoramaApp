package com.arashivision.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.InstaCameraController.InstaCameraParmas;
import com.arashivision.camera.listener.IBleConnectListener;
import com.arashivision.camera.listener.IBleScanListener;
import com.arashivision.camera.listener.ICameraConnectionListener;
import com.arashivision.camera.listener.ICameraInfoListener;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.camera.listener.ICameraRecordListener;
import com.arashivision.camera.listener.IScreenCaptureListener;
import com.arashivision.camera.listener.ITimelapseListener;
import com.arashivision.camera.listener.OnStillImageListener;
import com.arashivision.camera.strategy.ConnectStrategyImpl;
import com.arashivision.camera.strategy.TraceUtil;
import com.arashivision.onecamera.AudioSource;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.MultiPhotoOptions;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.StartCaptureWithoutStorage;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
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
import com.arashivision.onecamera.cameraresponse.GetGyroResp;
import com.arashivision.onestream.PlayerBackend;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.e.a.d.k;
import e.e.a.d.l;
import e.e.a.e.b;
import java.util.List;

public class InstaCamera {
    public static final String TAG = "com.arashivision.camera.InstaCamera";
    public InstaCameraController mCameraController;

    public static class Builder {
        public Context mContext;
        public InstaCameraParmas mParams = new InstaCameraParmas();

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder addCameraConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
            this.mParams.mConnectionListener = iCameraConnectionListener;
            return this;
        }

        public InstaCamera build() {
            InstaCamera instance = InstaCamera.getInstance();
            this.mParams.apply(this.mContext, instance.mCameraController);
            return instance;
        }

        public Builder connectType(int i2) {
            this.mParams.mConnectType = i2;
            return this;
        }

        public Builder mode(InstaMode instaMode) {
            this.mParams.mInstaMode = instaMode;
            return this;
        }
    }

    public static class InstaCameraHolder {
        public static final InstaCamera sInstance = new InstaCamera();
    }

    public static InstaCamera getInstance() {
        return new InstaCamera();
    }

    public long activeSensor(int i2) {
        return this.mCameraController.setSingleSensor(i2);
    }

    public void addCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        this.mCameraController.addCameraInfoListener(iCameraInfoListener);
    }

    public void addCameraRecordListener(ICameraRecordListener iCameraRecordListener) {
        this.mCameraController.addCameraRecordListener(iCameraRecordListener);
    }

    public void addConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        this.mCameraController.addConnectionListener(iCameraConnectionListener);
    }

    public void addStillImageListener(OnStillImageListener onStillImageListener) {
        this.mCameraController.addOnStillImageListener(onStillImageListener);
    }

    public void addTimelapseRecordListener(ITimelapseListener iTimelapseListener) {
        this.mCameraController.addTimelapseListener(iTimelapseListener);
    }

    public long badPointTest() {
        return this.mCameraController.badPointTest();
    }

    public long blackLevelTest() {
        return this.mCameraController.blackLevelTest();
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        return this.mCameraController.calibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        return this.mCameraController.cancelAuthorization();
    }

    public void changeConnectType(int i2) {
        this.mCameraController.changeConnectType(i2);
    }

    public long checkAuthorization(CheckAuthorization checkAuthorization) {
        return this.mCameraController.checkAuthorization(checkAuthorization);
    }

    public void close() {
        this.mCameraController.close();
    }

    public void closeBle() {
        this.mCameraController.closeBle();
    }

    public long closeCameraWifi() {
        return this.mCameraController.closeCameraWifi();
    }

    public void closeIperf() {
        this.mCameraController.m1closeIperf();
    }

    public void closePreviewStream() {
        this.mCameraController.closePreviewStream();
    }

    public void closeWifi() {
        this.mCameraController.closeWifi();
    }

    public void connect(b bVar, IBleConnectListener iBleConnectListener) {
        connect(bVar, false, iBleConnectListener);
    }

    public long connectBT(ConnectToBTPeripheral connectToBTPeripheral) {
        return this.mCameraController.connectBT(connectToBTPeripheral);
    }

    public void debug(boolean z) {
        TraceUtil.TRACE = z;
    }

    public long deleteFileList(DeleteFiles deleteFiles) {
        return this.mCameraController.deleteFileList(deleteFiles);
    }

    public void disConnect(b bVar) {
        this.mCameraController.disConnect(bVar);
    }

    public long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral) {
        return this.mCameraController.disConnectBT(disconnectBTPeripheral);
    }

    public void disConnectBle() {
        this.mCameraController.disConnectBle();
    }

    public long dspLinkTest() {
        return this.mCameraController.dspLinkTest();
    }

    public long ersaSDcard() {
        return this.mCameraController.ersaSDcasrd();
    }

    public long getAgeingTestStatus() {
        return this.mCameraController.getAgeTestStatus();
    }

    public long getCaptureStatus() {
        return this.mCameraController.getCaptureStatus();
    }

    public long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        return this.mCameraController.getConnectBT(getConnectedBTPeripheral);
    }

    public int getCurrentStatus() {
        return InstaCameraState.create().getState();
    }

    public long getFileExtra(GetFileExtra getFileExtra) {
        return this.mCameraController.getFileExtra(getFileExtra);
    }

    public long getFileInfoList() {
        return this.mCameraController.getFileInfoList();
    }

    public long getFileList(GetFileList getFileList) {
        return this.mCameraController.getFileList(getFileList);
    }

    public long getFlowStateEnable() {
        return this.mCameraController.getFlowStateEnable();
    }

    public GetGyroResp getGyro(GetGyro getGyro) {
        return this.mCameraController.getGyro(getGyro);
    }

    public long getGyroSync(GetGyro getGyro) {
        return this.mCameraController.getGyroSync(getGyro);
    }

    public void getIperfAverage() {
        this.mCameraController.getIperfAverage();
    }

    public long getMultiVideoOptions(List<String> list) {
        return this.mCameraController.getMultiVideoMode(list);
    }

    public Options getOptions(List<String> list) {
        return this.mCameraController.getOptions(list);
    }

    public long getOptionsSync(List<String> list) {
        return this.mCameraController.getOptionsSync(list);
    }

    public PhotoOptions getPhotoOptions(int i2, List<String> list) {
        return this.mCameraController.getPhotoOptions(i2, list);
    }

    public long getPhotoOptionsAsync(int i2, List<String> list) {
        return this.mCameraController.getPhotoOptionsAsync(i2, list);
    }

    public int getPort() {
        return this.mCameraController.getPort();
    }

    public long getSensorMode() {
        return this.mCameraController.getSingleSensor();
    }

    public Object getSurface() {
        return this.mCameraController.getSurface();
    }

    public long getSyncCaptureMode() {
        return this.mCameraController.getSyncCaptureMode();
    }

    public void getTestButtonState() {
        this.mCameraController.testButtonState();
    }

    public TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions) {
        return this.mCameraController.getTimelapseOption(getTimelapseOptions);
    }

    public long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions) {
        return this.mCameraController.getTimelapseOptionAsync(getTimelapseOptions);
    }

    public void init(Context context) {
        this.mCameraController.init(context);
        ConnectStrategyImpl connectStrategyImpl = new ConnectStrategyImpl(context);
        connectStrategyImpl.init(context);
        this.mCameraController.setStrategy(connectStrategyImpl);
    }

    public boolean isCameraReady() {
        return InstaCameraState.create().isCameraReady();
    }

    public long openCameraWifi() {
        return this.mCameraController.openCameraWifi();
    }

    public void openIperf(int i2) {
        this.mCameraController.openIperf(i2);
    }

    public void openUsb(Context context) {
        this.mCameraController.openUsb(context);
    }

    public void openWifi(String str, short s) {
        openWifi(5000, str, s, true);
    }

    public void previewStream(StartStreamingParam startStreamingParam, String str) {
        this.mCameraController.previewStream(startStreamingParam, str);
    }

    public long reboot() {
        return this.mCameraController.reboot();
    }

    public void release() {
        this.mCameraController.release();
    }

    public void releaseSurface() {
        this.mCameraController.setSurface(null, null, false);
    }

    public void removeCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        this.mCameraController.removeCameraInfoListener(iCameraInfoListener);
    }

    public void removeCameraReocrdListener(ICameraRecordListener iCameraRecordListener) {
        this.mCameraController.removeCameraRecordListener(iCameraRecordListener);
    }

    public void removeConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        this.mCameraController.removeConnectionListener(iCameraConnectionListener);
    }

    public void removeStillImageListener(OnStillImageListener onStillImageListener) {
        this.mCameraController.removeStillImageListener(onStillImageListener);
    }

    public void removeTimelapseRecordListener(ITimelapseListener iTimelapseListener) {
        this.mCameraController.removeTimelapseListener(iTimelapseListener);
    }

    public void resetRecord() {
        this.mCameraController.resetRecord();
    }

    public void scan(IBleScanListener iBleScanListener) {
        this.mCameraController.scan(FragmentStateAdapter.GRACE_WINDOW_TIME_MS, false, iBleScanListener);
    }

    public long scanBT(ScanBTPeripheral scanBTPeripheral) {
        return this.mCameraController.scanBT(scanBTPeripheral);
    }

    public void setAudioSource(AudioSource audioSource) {
        this.mCameraController.setAudioSource(audioSource);
    }

    public void setBleWakeupListener(l lVar) {
        this.mCameraController.setBleWakeupListener(lVar);
    }

    public void setCameraLiveStateListener(ICameraLiveStateListener iCameraLiveStateListener) {
        this.mCameraController.setCameraLiveStateListener(iCameraLiveStateListener);
    }

    public void setCameraWifiHeartDebug(boolean z) {
        this.mCameraController.getWifiHeartDebug(z);
    }

    public long setFileExtra(SetFileExtra setFileExtra) {
        return this.mCameraController.setFileExtra(setFileExtra);
    }

    public long setFlowStateEnable(int i2) {
        return this.mCameraController.setFlowStateEnable(i2);
    }

    public long setGPSData(byte[] bArr) {
        return this.mCameraController.setGpsData(bArr);
    }

    public void setGyroRebaseMatrix(float[] fArr) {
        this.mCameraController.setGyroRebaseMatrix(fArr);
    }

    public void setInfoUpdateListener(Handler handler, InfoUpdateListener infoUpdateListener) {
        this.mCameraController.setInfoUpdateListener(handler, infoUpdateListener);
    }

    public long setKeyTimePoint(KeyTimePoint keyTimePoint) {
        return this.mCameraController.setKeyTimePoint(keyTimePoint);
    }

    public long setMultiVideoOptions(MultiPhotoOptions multiPhotoOptions) {
        return this.mCameraController.setMultiVideoMode(multiPhotoOptions);
    }

    public long setOptionAsync(Options options) {
        return this.mCameraController.setOptions(options);
    }

    public long setPhotoOptions(int i2, PhotoOptions photoOptions) {
        return this.mCameraController.setPhotoOptions(i2, photoOptions);
    }

    public long setPhotoOptionsSync(int i2, PhotoOptions photoOptions) {
        return this.mCameraController.setPhotoOptionsSync(i2, photoOptions);
    }

    public void setPipeline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mCameraController.setPipline(iCameraPreviewPipeline);
    }

    public void setPlayerBackend(PlayerBackend playerBackend) {
        this.mCameraController.setPlayerBackend(playerBackend);
    }

    public void setPreviewDelta(long j2) {
        this.mCameraController.setPreviewDelta(j2);
    }

    public void setRecordType(RecordingType recordingType) {
        this.mCameraController.setRecordType(recordingType);
    }

    public void setScreenCaptureListener(IScreenCaptureListener iScreenCaptureListener) {
        this.mCameraController.setScreenCaptureListener(iScreenCaptureListener);
    }

    public void setStreamEncode(boolean z) {
        this.mCameraController.setStreamEncode(z);
    }

    public void setSurface(Object obj) {
        setSurface(obj, null, true);
    }

    public long setSyncCaptureMode(int i2) {
        return this.mCameraController.setSyncCaptureMode(i2);
    }

    public long setSyncStandByMode(int i2) {
        return this.mCameraController.setStandbyMode(i2);
    }

    public int setTimelapseOptions(SetTimelapseOptions setTimelapseOptions) {
        return this.mCameraController.setTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions) {
        return this.mCameraController.setTimelapseOptionsASync(setTimelapseOptions);
    }

    public void setWifiHeartDebug(boolean z) {
        this.mCameraController.setWifiHeartDebug(z);
    }

    public void startBleStatusTest() {
        this.mCameraController.startBleStatusTest();
    }

    public int startBulletTime() {
        return this.mCameraController.startBulletTime();
    }

    public void startColorTest() {
        this.mCameraController.startColorTest();
    }

    public void startContactTest() {
        this.mCameraController.startContactTest();
    }

    public void startHdrCapture() {
        this.mCameraController.startHdrCapture();
    }

    public void startLedTest() {
        this.mCameraController.startLedTest();
    }

    public void startRecord(boolean z, boolean z2, int i2, StartCaptureWithoutStorage startCaptureWithoutStorage) {
        this.mCameraController.startRecord(z, z2, i2, startCaptureWithoutStorage);
    }

    public void startScreenCapture(int i2, int i3, String str) {
        this.mCameraController.startScreenCapture(i2, i3, str);
    }

    public void startSpeakerTest() {
        this.mCameraController.startSpeakerTest();
    }

    public void startTimeShift() {
        this.mCameraController.startTimeShift();
    }

    public void startTimelapse(StartTimelapse startTimelapse) {
        startTimelapseDelay(startTimelapse, 0);
    }

    public void startTimelapseDelay(StartTimelapse startTimelapse, int i2) {
        this.mCameraController.startTimelapseDelay(startTimelapse, i2);
    }

    public void startWifiStatusTest() {
        this.mCameraController.startWifiStatusTest();
    }

    public void stopBleWakeupListener(k kVar) {
        this.mCameraController.setBleStopWakeupListener(kVar);
    }

    public void stopBulletTime(byte[] bArr) {
        this.mCameraController.stopBulletTime(bArr);
    }

    public void stopHdrCapture(byte[] bArr) {
        this.mCameraController.stopHdrCapture(bArr);
    }

    public void stopLCDTest() {
        this.mCameraController.stopLCDTest();
    }

    public void stopLive() {
        this.mCameraController.stopLive();
    }

    public void stopRecord(int i2, byte[] bArr) {
        this.mCameraController.stopRecord(i2, bArr);
    }

    public void stopScanBle() {
        this.mCameraController.stopScanBle();
    }

    public void stopTimeShift(byte[] bArr) {
        this.mCameraController.stopTimeShift(bArr);
    }

    public void stopTimelapse(StopTimelapse stopTimelapse) {
        this.mCameraController.stopTimelapse(stopTimelapse);
    }

    public void stopWakeupBle() {
        this.mCameraController.stopWakeupBle();
    }

    public long syncCaptureStatus() {
        return this.mCameraController.syncCaptureStatus();
    }

    public void tackPicture(TakePicture takePicture) {
        tackPicture(takePicture, false);
    }

    public void testSpeedTypec() {
        this.mCameraController.testTypec();
    }

    public void testUsbSpeed(TestSDCardSpeed testSDCardSpeed) {
        this.mCameraController.testUsbSpeed(testSDCardSpeed);
    }

    public void updatePanoOffset(String str) {
        this.mCameraController.updateOffset(str);
    }

    public long vibrateTest() {
        return this.mCameraController.vibrateTest();
    }

    public void wakeUpBle(int i2, String str, byte b2) {
        this.mCameraController.wakeUpBle(i2, str, b2);
    }

    public long whiteBlanceTest() {
        return this.mCameraController.whiteBlanceTest();
    }

    public InstaCamera() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("camera instance = ");
        sb.append(this);
        Log.d(str, sb.toString());
        this.mCameraController = InstaCameraController.create();
    }

    public void connect(b bVar, boolean z, IBleConnectListener iBleConnectListener) {
        this.mCameraController.connectDevice(bVar, z, iBleConnectListener);
    }

    public void openWifi(int i2, String str, short s, boolean z) {
        this.mCameraController.openWifi(i2, str, s, z);
    }

    public void scan(long j2, boolean z, IBleScanListener iBleScanListener) {
        this.mCameraController.scan(j2, z, iBleScanListener);
    }

    public void setSurface(Object obj, Object obj2, boolean z) {
        this.mCameraController.setSurface(obj, obj2, z);
    }

    public void tackPicture(TakePicture takePicture, boolean z) {
        this.mCameraController.takePicture(takePicture, z);
    }
}
