package com.arashivision.camera;

import android.content.Context;
import android.os.Handler;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.exception.ObjectShouldNotNullException;
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
import com.arashivision.camera.strategy.InstaCameraStrategy;
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

public class InstaCameraController {
    public final InstaCameraState mCameraState = InstaCameraState.create();
    public Context mContext;
    public InstaCameraStrategy mInstaCameraStrategy;

    public static class InstaCameraParmas {
        public int mConnectType;
        public ICameraConnectionListener mConnectionListener;
        public InstaMode mInstaMode;

        public void apply(Context context, InstaCameraController instaCameraController) {
            ConnectStrategyImpl connectStrategyImpl = new ConnectStrategyImpl(context);
            connectStrategyImpl.init(context);
            instaCameraController.setStrategy(connectStrategyImpl);
        }
    }

    public static InstaCameraController create() {
        return new InstaCameraController();
    }

    public void addCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        this.mInstaCameraStrategy.addCameraInfoListener(iCameraInfoListener);
    }

    public void addCameraRecordListener(ICameraRecordListener iCameraRecordListener) {
        this.mInstaCameraStrategy.addCameraRecordListener(iCameraRecordListener);
    }

    public void addConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        this.mInstaCameraStrategy.addConnectionListener(iCameraConnectionListener);
    }

    public void addOnStillImageListener(OnStillImageListener onStillImageListener) {
        this.mInstaCameraStrategy.addStillImageListener(onStillImageListener);
    }

    public void addTimelapseListener(ITimelapseListener iTimelapseListener) {
        this.mInstaCameraStrategy.addTimelapseListener(iTimelapseListener);
    }

    public long badPointTest() {
        return this.mInstaCameraStrategy.badPointTest();
    }

    public long blackLevelTest() {
        return this.mInstaCameraStrategy.blackLevelTest();
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        return this.mInstaCameraStrategy.calibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        return this.mInstaCameraStrategy.cancelAuthorization();
    }

    public void changeConnectType(int i2) {
    }

    public long checkAuthorization(CheckAuthorization checkAuthorization) {
        return this.mInstaCameraStrategy.checkAuthorization(checkAuthorization);
    }

    public void close() {
        this.mInstaCameraStrategy.closeUsb();
    }

    public void closeBle() {
        this.mInstaCameraStrategy.closeBle();
    }

    public long closeCameraWifi() {
        return this.mInstaCameraStrategy.closeCameraWifi();
    }

    /* renamed from: closeIperæf reason: contains not printable characters */
    public void m1closeIperf() {
        this.mInstaCameraStrategy.closeIperf();
    }

    public void closePreviewStream() {
        this.mInstaCameraStrategy.closePreviewStream();
    }

    public void closeWifi() {
        this.mInstaCameraStrategy.closeWifi();
    }

    public long connectBT(ConnectToBTPeripheral connectToBTPeripheral) {
        return this.mInstaCameraStrategy.connectBT(connectToBTPeripheral);
    }

    public void connectDevice(b bVar, boolean z, IBleConnectListener iBleConnectListener) {
        this.mInstaCameraStrategy.connectDevice(bVar, z, iBleConnectListener);
    }

    public long deleteFileList(DeleteFiles deleteFiles) {
        return this.mInstaCameraStrategy.delteFileList(deleteFiles);
    }

    public void disConnect(b bVar) {
        this.mInstaCameraStrategy.disConnect(bVar);
    }

    public long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral) {
        return this.mInstaCameraStrategy.disConnectBT(disconnectBTPeripheral);
    }

    public void disConnectBle() {
        this.mInstaCameraStrategy.disConnectBle();
    }

    public long dspLinkTest() {
        return this.mInstaCameraStrategy.dspLinkTest();
    }

    public long ersaSDcasrd() {
        return this.mInstaCameraStrategy.eraseSdcard();
    }

    public long getAgeTestStatus() {
        return this.mInstaCameraStrategy.getAgeTestStatus();
    }

    public long getCaptureStatus() {
        return this.mInstaCameraStrategy.getCaptureStatus();
    }

    public long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        return this.mInstaCameraStrategy.getConnectBT(getConnectedBTPeripheral);
    }

    public long getFileExtra(GetFileExtra getFileExtra) {
        return this.mInstaCameraStrategy.getFileExtra(getFileExtra);
    }

    public long getFileInfoList() {
        return this.mInstaCameraStrategy.getFileInfoList();
    }

    public long getFileList(GetFileList getFileList) {
        return this.mInstaCameraStrategy.getFileList(getFileList);
    }

    public long getFlowStateEnable() {
        return this.mInstaCameraStrategy.getFlowStateEnable();
    }

    public GetGyroResp getGyro(GetGyro getGyro) {
        return this.mInstaCameraStrategy.getGyro(getGyro);
    }

    public long getGyroSync(GetGyro getGyro) {
        return this.mInstaCameraStrategy.getGyroSync(getGyro);
    }

    public void getIperfAverage() {
        this.mInstaCameraStrategy.getIperfAverage();
    }

    public long getMultiVideoMode(List<String> list) {
        return this.mInstaCameraStrategy.getMultiVideoMode(list);
    }

    public Options getOptions(List<String> list) {
        return this.mInstaCameraStrategy.getOptions(list);
    }

    public long getOptionsSync(List<String> list) {
        return this.mInstaCameraStrategy.getOptionsSync(list);
    }

    public PhotoOptions getPhotoOptions(int i2, List<String> list) {
        return this.mInstaCameraStrategy.getPhotoOptions(i2, list);
    }

    public long getPhotoOptionsAsync(int i2, List<String> list) {
        return this.mInstaCameraStrategy.getPhotoOptionsAsync(i2, list);
    }

    public int getPort() {
        return this.mInstaCameraStrategy.getPort();
    }

    public long getSingleSensor() {
        return this.mInstaCameraStrategy.getSingleSensor();
    }

    public Object getSurface() {
        return this.mInstaCameraStrategy.getSurface();
    }

    public long getSyncCaptureMode() {
        return this.mInstaCameraStrategy.getSyncCaptureMode();
    }

    public TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions) {
        return this.mInstaCameraStrategy.getTimelapseOption(getTimelapseOptions);
    }

    public long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions) {
        return this.mInstaCameraStrategy.getTimelapseOptionAsync(getTimelapseOptions);
    }

    public void getWifiHeartDebug(boolean z) {
        this.mInstaCameraStrategy.getWifiHeartDebug(z);
    }

    public long gyroScopeTest() {
        return this.mInstaCameraStrategy.gyroScopeTest();
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public long openCameraWifi() {
        return this.mInstaCameraStrategy.openCameraWifi();
    }

    public void openIperf(int i2) {
        this.mInstaCameraStrategy.openIperf(i2);
    }

    public void openUsb(Context context) {
        this.mInstaCameraStrategy.openUsb(context);
    }

    public void openWifi(int i2, String str, short s, boolean z) {
        this.mInstaCameraStrategy.openWifi(i2, str, s, z);
    }

    public void previewStream(StartStreamingParam startStreamingParam, String str) {
        this.mInstaCameraStrategy.previewStream(startStreamingParam, str);
    }

    public long reboot() {
        return this.mInstaCameraStrategy.reboot();
    }

    public void release() {
        this.mCameraState.checkoutOpenState();
    }

    public void removeCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        this.mInstaCameraStrategy.removeCameraInfoListener(iCameraInfoListener);
    }

    public void removeCameraRecordListener(ICameraRecordListener iCameraRecordListener) {
        this.mInstaCameraStrategy.removeCameraRecordListener(iCameraRecordListener);
    }

    public void removeConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        this.mInstaCameraStrategy.removeConnectionListener(iCameraConnectionListener);
    }

    public void removeStillImageListener(OnStillImageListener onStillImageListener) {
        this.mInstaCameraStrategy.removeStillImageListener(onStillImageListener);
    }

    public void removeTimelapseListener(ITimelapseListener iTimelapseListener) {
        this.mInstaCameraStrategy.removeTimelapseListener(iTimelapseListener);
    }

    public void resetRecord() {
        this.mInstaCameraStrategy.resetRecord();
    }

    public void scan(long j2, boolean z, IBleScanListener iBleScanListener) {
        this.mInstaCameraStrategy.scan(j2, z, iBleScanListener);
    }

    public long scanBT(ScanBTPeripheral scanBTPeripheral) {
        return this.mInstaCameraStrategy.scanBT(scanBTPeripheral);
    }

    public void setAudioSource(AudioSource audioSource) {
        this.mInstaCameraStrategy.setAudioSource(audioSource);
    }

    public void setBleStopWakeupListener(k kVar) {
        this.mInstaCameraStrategy.setBleStopWakeupListener(kVar);
    }

    public void setBleWakeupListener(l lVar) {
        this.mInstaCameraStrategy.setBleWakeupListener(lVar);
    }

    public void setCameraLiveStateListener(ICameraLiveStateListener iCameraLiveStateListener) {
        this.mInstaCameraStrategy.setCameraLiveStateListener(iCameraLiveStateListener);
    }

    public long setFileExtra(SetFileExtra setFileExtra) {
        return this.mInstaCameraStrategy.setFileExtra(setFileExtra);
    }

    public long setFlowStateEnable(int i2) {
        return this.mInstaCameraStrategy.setFlowStateEnable(i2);
    }

    public long setGpsData(byte[] bArr) {
        return this.mInstaCameraStrategy.setGpsData(bArr);
    }

    public void setGyroRebaseMatrix(float[] fArr) {
        this.mInstaCameraStrategy.setGyroRebaseMatrix(fArr);
    }

    public void setInfoUpdateListener(Handler handler, InfoUpdateListener infoUpdateListener) {
        this.mInstaCameraStrategy.setInfoUpdateListener(handler, infoUpdateListener);
    }

    public long setKeyTimePoint(KeyTimePoint keyTimePoint) {
        return this.mInstaCameraStrategy.setKeyTimePoint(keyTimePoint);
    }

    public long setMultiVideoMode(MultiPhotoOptions multiPhotoOptions) {
        return this.mInstaCameraStrategy.setMultiVideoMode(multiPhotoOptions);
    }

    public long setOptions(Options options) {
        return this.mInstaCameraStrategy.setOptionAsync(options);
    }

    public long setPhotoOptions(int i2, PhotoOptions photoOptions) {
        return this.mInstaCameraStrategy.setPhotoOptions(i2, photoOptions);
    }

    public long setPhotoOptionsSync(int i2, PhotoOptions photoOptions) {
        return this.mInstaCameraStrategy.setPhotoOptionSync(i2, photoOptions);
    }

    public void setPipline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mInstaCameraStrategy.setPipeline(iCameraPreviewPipeline);
    }

    public void setPlayerBackend(PlayerBackend playerBackend) {
        this.mInstaCameraStrategy.setPlayerBackend(playerBackend);
    }

    public void setPreviewDelta(long j2) {
        this.mInstaCameraStrategy.setPreviewDelta(j2);
    }

    public void setRecordType(RecordingType recordingType) {
        this.mInstaCameraStrategy.setRecordType(recordingType);
    }

    public void setScreenCaptureListener(IScreenCaptureListener iScreenCaptureListener) {
        this.mInstaCameraStrategy.setScreenScptureListener(iScreenCaptureListener);
    }

    public long setSingleSensor(int i2) {
        return this.mInstaCameraStrategy.setSingleSensor(i2);
    }

    public long setStandbyMode(int i2) {
        return this.mInstaCameraStrategy.setStandbyMode(i2);
    }

    public void setStrategy(InstaCameraStrategy instaCameraStrategy) {
        this.mInstaCameraStrategy = instaCameraStrategy;
    }

    public void setStreamEncode(boolean z) {
        this.mInstaCameraStrategy.setStreamEncode(z);
    }

    public void setSurface(Object obj, Object obj2, boolean z) {
        this.mInstaCameraStrategy.setSurface(obj, obj2, z);
    }

    public long setSyncCaptureMode(int i2) {
        return this.mInstaCameraStrategy.setSyncCaptureMode(i2);
    }

    public long setSyncStandByMode(int i2) {
        return this.mInstaCameraStrategy.setSyncStandByMode(i2);
    }

    public int setTimelapseOptions(SetTimelapseOptions setTimelapseOptions) {
        return this.mInstaCameraStrategy.setTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions) {
        return this.mInstaCameraStrategy.setTimelapseOptionsASync(setTimelapseOptions);
    }

    public void setWifiHeartDebug(boolean z) {
        this.mInstaCameraStrategy.setWifiHeartDebug(z);
    }

    public void startBleStatusTest() {
        this.mInstaCameraStrategy.startBleStatusTest();
    }

    public int startBulletTime() {
        return this.mInstaCameraStrategy.startBulletTime();
    }

    public void startColorTest() {
        this.mInstaCameraStrategy.startColorTest();
    }

    public void startContactTest() {
        this.mInstaCameraStrategy.startContactTest();
    }

    public void startHdrCapture() {
        this.mInstaCameraStrategy.startHdrCapture();
    }

    public void startLedTest() {
        this.mInstaCameraStrategy.startLedTest();
    }

    public void startRecord(boolean z, boolean z2, int i2, StartCaptureWithoutStorage startCaptureWithoutStorage) {
        if (!z2 || startCaptureWithoutStorage != null) {
            this.mInstaCameraStrategy.startRecord(z, z2, i2, startCaptureWithoutStorage);
            return;
        }
        throw new ObjectShouldNotNullException("on livepush mode StartCaptureWithoutStorage should not null");
    }

    public void startScreenCapture(int i2, int i3, String str) {
        this.mInstaCameraStrategy.startScreenCapture(i2, i3, str);
    }

    public void startSpeakerTest() {
        this.mInstaCameraStrategy.startSpeakerTest();
    }

    public long startTimeShift() {
        return this.mInstaCameraStrategy.startTimeShift();
    }

    public void startTimelapseDelay(StartTimelapse startTimelapse, int i2) {
        this.mInstaCameraStrategy.startTimeplapse(startTimelapse);
    }

    public void startWifiStatusTest() {
        this.mInstaCameraStrategy.startWifiStatusTest();
    }

    public void stopBulletTime(byte[] bArr) {
        this.mInstaCameraStrategy.stopBulletTime(bArr);
    }

    public void stopHdrCapture(byte[] bArr) {
        this.mInstaCameraStrategy.stopHdrCapture(bArr);
    }

    public void stopLCDTest() {
        this.mInstaCameraStrategy.stopLCDTest();
    }

    public void stopLive() {
        this.mInstaCameraStrategy.stopLive();
    }

    public void stopRecord(int i2, byte[] bArr) {
        this.mInstaCameraStrategy.stopRecord(i2, bArr);
    }

    public void stopScanBle() {
        this.mInstaCameraStrategy.stopScan();
    }

    public void stopTimeShift(byte[] bArr) {
        this.mInstaCameraStrategy.stopTimeShift(bArr);
    }

    public void stopTimelapse(StopTimelapse stopTimelapse) {
        this.mInstaCameraStrategy.stopTimelapse(stopTimelapse);
    }

    public void stopWakeupBle() {
        this.mInstaCameraStrategy.stopWakeup();
    }

    public long syncCaptureStatus() {
        return this.mInstaCameraStrategy.syncCaptureStatus();
    }

    public void takePicture(TakePicture takePicture, boolean z) {
        this.mInstaCameraStrategy.takePicture(takePicture, z);
    }

    public void testButtonState() {
        this.mInstaCameraStrategy.testButtonState();
    }

    public void testTypec() {
        this.mInstaCameraStrategy.startTestTypeC();
    }

    public void testUsbSpeed(TestSDCardSpeed testSDCardSpeed) {
        this.mInstaCameraStrategy.testUsbSpeed(testSDCardSpeed);
    }

    public void updateOffset(String str) {
        this.mInstaCameraStrategy.updateOffset(str);
    }

    public long vibrateTest() {
        return this.mInstaCameraStrategy.vibrateTest();
    }

    public void wakeUpBle(int i2, String str, byte b2) {
        this.mInstaCameraStrategy.wakeUpBle(i2, str, b2);
    }

    public long whiteBlanceTest() {
        return this.mInstaCameraStrategy.whiteBlanceTest();
    }
}
