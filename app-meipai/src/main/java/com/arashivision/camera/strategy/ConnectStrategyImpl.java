package com.arashivision.camera.strategy;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.arashivision.camera.command.AgeTestStatusCmd;
import com.arashivision.camera.command.AyncSetTimelapseOptionCmd;
import com.arashivision.camera.command.BadPointTestCmd;
import com.arashivision.camera.command.BlackLevelTestCmd;
import com.arashivision.camera.command.ButtonTestCmd;
import com.arashivision.camera.command.CalibrateGyroCmd;
import com.arashivision.camera.command.CameraWifiHearCmd;
import com.arashivision.camera.command.CancelAuthorizationCmd;
import com.arashivision.camera.command.CaptureCommand;
import com.arashivision.camera.command.CheckAuthorizationCmd;
import com.arashivision.camera.command.CloseCameraWifiCmd;
import com.arashivision.camera.command.DeleteFileListCmd;
import com.arashivision.camera.command.DspLinkCmd;
import com.arashivision.camera.command.EraseSdcardCmd;
import com.arashivision.camera.command.GetCaptureStatus;
import com.arashivision.camera.command.GetFileExtraCmd;
import com.arashivision.camera.command.GetFileInfoListCmd;
import com.arashivision.camera.command.GetFileListCmd;
import com.arashivision.camera.command.GetFlowStateCmd;
import com.arashivision.camera.command.GetGyroCmd;
import com.arashivision.camera.command.GetMultiVideoCmd;
import com.arashivision.camera.command.GetOptionCmd;
import com.arashivision.camera.command.GetOptionSyncCmd;
import com.arashivision.camera.command.GetPhotoOptionCmd;
import com.arashivision.camera.command.GetPhotoOptionsAsyncCmd;
import com.arashivision.camera.command.GetSingleSensorCmd;
import com.arashivision.camera.command.GetSyncCaptureModeCmd;
import com.arashivision.camera.command.GetTimelapseOptionAsyncCmd;
import com.arashivision.camera.command.GetTimelapseOptionCmd;
import com.arashivision.camera.command.GyroScopeCmd;
import com.arashivision.camera.command.HdrCaptureCommand;
import com.arashivision.camera.command.HdrStopCaptureCmd;
import com.arashivision.camera.command.KeyTimePointCmd;
import com.arashivision.camera.command.LedTestCmd;
import com.arashivision.camera.command.MultiVideoModeCmd;
import com.arashivision.camera.command.OpenCameraWifiCmd;
import com.arashivision.camera.command.OpenUsbCmd;
import com.arashivision.camera.command.OpenWifiCmd;
import com.arashivision.camera.command.PreviewStreamingCmd;
import com.arashivision.camera.command.RebootCmd;
import com.arashivision.camera.command.ResetRecord;
import com.arashivision.camera.command.SetFileExtraCmd;
import com.arashivision.camera.command.SetFlowStateCmd;
import com.arashivision.camera.command.SetGpsCmd;
import com.arashivision.camera.command.SetOptionAsyncCmd;
import com.arashivision.camera.command.SetPhotoOptionsCmd;
import com.arashivision.camera.command.SetPhotoOptionsSyncCmd;
import com.arashivision.camera.command.SetTimelapseOptionCmd;
import com.arashivision.camera.command.SingleSensorCmd;
import com.arashivision.camera.command.SpeakerTestCmd;
import com.arashivision.camera.command.StandByCmd;
import com.arashivision.camera.command.StartBulletTimeCmd;
import com.arashivision.camera.command.StartRecordCmd;
import com.arashivision.camera.command.StartTimeplaseCmd;
import com.arashivision.camera.command.StartTimeshiftCmd;
import com.arashivision.camera.command.StopBulletTimeCmd;
import com.arashivision.camera.command.StopLCDCmd;
import com.arashivision.camera.command.StopLiveCmd;
import com.arashivision.camera.command.StopRecordCmd;
import com.arashivision.camera.command.StopStreamingCmd;
import com.arashivision.camera.command.StopTimeShift;
import com.arashivision.camera.command.StopTimelapseCmd;
import com.arashivision.camera.command.SyncCaptureStatusCmd;
import com.arashivision.camera.command.SyncSetCatpureModeCmd;
import com.arashivision.camera.command.SyncSetStandByCmd;
import com.arashivision.camera.command.TestTypeCCmd;
import com.arashivision.camera.command.VibrateTextCmd;
import com.arashivision.camera.command.WhiteBlanceTestCmd;
import com.arashivision.camera.command.ble.BleCloseCmd;
import com.arashivision.camera.command.ble.BleConnectCmd;
import com.arashivision.camera.command.ble.BleScanCmd;
import com.arashivision.camera.command.ble.BleStatusCmd;
import com.arashivision.camera.command.ble.BleStopCmd;
import com.arashivision.camera.command.ble.BleStopScanCmd;
import com.arashivision.camera.command.ble.BleStopWakeupCmd;
import com.arashivision.camera.command.ble.BleWakeUpCmd;
import com.arashivision.camera.command.ble.ConnectBTCmd;
import com.arashivision.camera.command.ble.DisConnectBTCmd;
import com.arashivision.camera.command.ble.GetConnectBTCmd;
import com.arashivision.camera.command.ble.ScanBTCmd;
import com.arashivision.camera.command.usb.CloseUsbCmd;
import com.arashivision.camera.command.usb.ColorTestCmd;
import com.arashivision.camera.command.usb.ContactTestCmd;
import com.arashivision.camera.command.usb.UsbSpeedCmd;
import com.arashivision.camera.command.wifi.CloeIperfCmd;
import com.arashivision.camera.command.wifi.GetIperfAverageCmd;
import com.arashivision.camera.command.wifi.OpenIperfCmd;
import com.arashivision.camera.command.wifi.WifiHeartCmd;
import com.arashivision.camera.command.wifi.WifiStatusCmd;
import com.arashivision.camera.listener.IBleConnectListener;
import com.arashivision.camera.listener.IBleScanListener;
import com.arashivision.onecamera.MultiPhotoOptions;
import com.arashivision.onecamera.OneDriver;
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
import e.e.a.a.C0102a;
import e.e.a.e.b;
import java.util.List;

public class ConnectStrategyImpl extends InstaCameraStrategy {
    public static final int MSG_HEART = 10;
    public HeartHandler mHeartHandler;

    public static class HeartHandler extends Handler {
        public HeartHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10) {
                OneDriver oneDriver = (OneDriver) message.obj;
                if (oneDriver != null) {
                    oneDriver.sendWifiHearBeat();
                    Message obtain = Message.obtain();
                    obtain.obj = oneDriver;
                    obtain.what = 10;
                    sendMessageDelayed(obtain, 2000);
                }
            }
        }
    }

    public ConnectStrategyImpl(Context context) {
        String str = InstaCameraStrategy.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("context = ");
        sb.append(context);
        Log.d(str, sb.toString());
        this.mContext = context;
    }

    public long badPointTest() {
        return ((Long) addWorker(new BadPointTestCmd())).longValue();
    }

    public long blackLevelTest() {
        return ((Long) addWorker(new BlackLevelTestCmd())).longValue();
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        return ((Long) addWorker(new CalibrateGyroCmd(calibrateGyro))).longValue();
    }

    public long cancelAuthorization() {
        return ((Long) addWorker(new CancelAuthorizationCmd())).longValue();
    }

    public long checkAuthorization(CheckAuthorization checkAuthorization) {
        return ((Long) addWorker(new CheckAuthorizationCmd(checkAuthorization))).longValue();
    }

    public void closeBle() {
        addWorker(new BleCloseCmd());
    }

    public long closeCameraWifi() {
        return ((Long) addWorker(new CloseCameraWifiCmd())).longValue();
    }

    public void closeIperf() {
        addWorker(new CloeIperfCmd());
    }

    public void closePreviewStream() {
        addWorker(new StopStreamingCmd(this.mStreamPiple, this.mStreamProcess));
    }

    public void closeUsb() {
        addWorkerSync(0, new CloseUsbCmd(this.mUsbService));
    }

    public void closeWifi() {
        addWorker(new CloseUsbCmd(this.mUsbService));
        this.mHeartHandler.removeMessages(10);
    }

    public long connectBT(ConnectToBTPeripheral connectToBTPeripheral) {
        return ((Long) addWorker(new ConnectBTCmd(connectToBTPeripheral))).longValue();
    }

    public void connectDevice(b bVar, boolean z, IBleConnectListener iBleConnectListener) {
        BleConnectCmd bleConnectCmd = new BleConnectCmd(bVar, z, iBleConnectListener, this.mOneDrvier, this.mThreadHandler);
        addWorkerSync(0, bleConnectCmd);
    }

    public long delteFileList(DeleteFiles deleteFiles) {
        return ((Long) addWorker(new DeleteFileListCmd(deleteFiles))).longValue();
    }

    public void disConnect(b bVar) {
        addWorker(new BleStopCmd(bVar));
    }

    public long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral) {
        return ((Long) addWorker(new DisConnectBTCmd(disconnectBTPeripheral))).longValue();
    }

    public void disConnectBle() {
        C0102a.f7939a.a();
    }

    public long dspLinkTest() {
        return ((Long) addWorker(new DspLinkCmd())).longValue();
    }

    public long eraseSdcard() {
        return ((Long) addWorker(new EraseSdcardCmd())).longValue();
    }

    public long getAgeTestStatus() {
        return ((Long) addWorker(new AgeTestStatusCmd())).longValue();
    }

    public long getCaptureStatus() {
        return ((Long) addWorker(new GetCaptureStatus())).longValue();
    }

    public long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        return ((Long) addWorker(new GetConnectBTCmd(getConnectedBTPeripheral))).longValue();
    }

    public long getFileExtra(GetFileExtra getFileExtra) {
        return ((Long) addWorker(new GetFileExtraCmd(getFileExtra))).longValue();
    }

    public long getFileInfoList() {
        return ((Long) addWorker(new GetFileInfoListCmd())).longValue();
    }

    public long getFileList(GetFileList getFileList) {
        return ((Long) addWorker(new GetFileListCmd(getFileList))).longValue();
    }

    public long getFlowStateEnable() {
        return ((Long) addWorker(new GetFlowStateCmd())).longValue();
    }

    public GetGyroResp getGyro(GetGyro getGyro) {
        Object addWorker = addWorker(new GetGyroCmd(getGyro));
        if (addWorker instanceof GetGyroResp) {
            return (GetGyroResp) addWorker;
        }
        return null;
    }

    public long getGyroSync(GetGyro getGyro) {
        return ((Long) addWorker(new GetGyroCmd(getGyro))).longValue();
    }

    public void getIperfAverage() {
        addWorker(new GetIperfAverageCmd());
    }

    public long getMultiVideoMode(List<String> list) {
        return ((Long) addWorker(new GetMultiVideoCmd(list))).longValue();
    }

    public Options getOptions(List<String> list) {
        Object addWorker = addWorker(new GetOptionCmd(list));
        if (addWorker instanceof Options) {
            return (Options) addWorker;
        }
        return null;
    }

    public long getOptionsSync(List<String> list) {
        return ((Long) addWorker(new GetOptionSyncCmd(list))).longValue();
    }

    public PhotoOptions getPhotoOptions(int i2, List<String> list) {
        return (PhotoOptions) addWorker(new GetPhotoOptionCmd(i2, list));
    }

    public long getPhotoOptionsAsync(int i2, List<String> list) {
        return ((Long) addWorker(new GetPhotoOptionsAsyncCmd(i2, list))).longValue();
    }

    public int getPort() {
        int tunelPort = this.mOneDrvier.getTunelPort();
        if (tunelPort <= 0) {
            return 8080;
        }
        return tunelPort;
    }

    public long getSingleSensor() {
        return ((Long) addWorker(new GetSingleSensorCmd())).longValue();
    }

    public long getSyncCaptureMode() {
        return ((Long) addWorker(new GetSyncCaptureModeCmd())).longValue();
    }

    public TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions) {
        return (TimelapseOptionsInfo) addWorker(new GetTimelapseOptionCmd(getTimelapseOptions));
    }

    public long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions) {
        return ((Long) addWorker(new GetTimelapseOptionAsyncCmd(getTimelapseOptions))).longValue();
    }

    public void getWifiHeartDebug(boolean z) {
        addWorker(new CameraWifiHearCmd(z));
    }

    public long gyroScopeTest() {
        return ((Long) addWorker(new GyroScopeCmd())).longValue();
    }

    public long openCameraWifi() {
        return ((Long) addWorker(new OpenCameraWifiCmd())).longValue();
    }

    public void openIperf(int i2) {
        addWorker(new OpenIperfCmd(i2));
    }

    public void openUsb(Context context) {
        addWorker(new OpenUsbCmd(context, this.mUsbService, this.mCameraConnectionListeners));
    }

    public void openWifi(int i2, String str, short s, boolean z) {
        HandlerThread handlerThread = new HandlerThread("WifiConnect");
        this.handlerThread = handlerThread;
        handlerThread.start();
        HeartHandler heartHandler = new HeartHandler(this.handlerThread.getLooper());
        this.mHeartHandler = heartHandler;
        OpenWifiCmd openWifiCmd = new OpenWifiCmd(i2, str, s, z, this.mMainHandler, heartHandler, this.mCameraConnectionListeners);
        addWorkerSync(1000, openWifiCmd);
    }

    public void previewStream(StartStreamingParam startStreamingParam, String str) {
        this.mStartStreamingParam = startStreamingParam;
        PreviewStreamingCmd previewStreamingCmd = new PreviewStreamingCmd(this.mContext, this.mMainHandler, startStreamingParam, this.mStreamPiple, this.mICameraPreviewPipeline, this.mGyroMatrix, this.mAudioSource, this.firstSurface, str);
        addWorker(previewStreamingCmd);
    }

    public long reboot() {
        return ((Long) addWorker(new RebootCmd())).longValue();
    }

    public void resetRecord() {
        addWorker(new ResetRecord(this.mICameraPreviewPipeline, this.mStreamPiple));
    }

    public void scan(long j2, boolean z, IBleScanListener iBleScanListener) {
        addWorker(new BleScanCmd(j2, z, iBleScanListener));
    }

    public long scanBT(ScanBTPeripheral scanBTPeripheral) {
        return ((Long) addWorker(new ScanBTCmd(scanBTPeripheral))).longValue();
    }

    public long setFileExtra(SetFileExtra setFileExtra) {
        return ((Long) addWorker(new SetFileExtraCmd(setFileExtra))).longValue();
    }

    public long setFlowStateEnable(int i2) {
        return ((Long) addWorker(new SetFlowStateCmd(i2))).longValue();
    }

    public long setGpsData(byte[] bArr) {
        return ((Long) addWorker(new SetGpsCmd(bArr))).longValue();
    }

    public long setKeyTimePoint(KeyTimePoint keyTimePoint) {
        return ((Long) addWorker(new KeyTimePointCmd(keyTimePoint))).longValue();
    }

    public long setMultiVideoMode(MultiPhotoOptions multiPhotoOptions) {
        return ((Long) addWorker(new MultiVideoModeCmd(multiPhotoOptions))).longValue();
    }

    public long setOptionAsync(Options options) {
        return ((Long) addWorker(new SetOptionAsyncCmd(options))).longValue();
    }

    public long setPhotoOptionSync(int i2, PhotoOptions photoOptions) {
        return ((Long) addWorker(new SetPhotoOptionsSyncCmd(i2, photoOptions))).longValue();
    }

    public long setPhotoOptions(int i2, PhotoOptions photoOptions) {
        return ((Long) addWorker(new SetPhotoOptionsCmd(i2, photoOptions))).longValue();
    }

    public long setSingleSensor(int i2) {
        return ((Long) addWorker(new SingleSensorCmd(i2))).longValue();
    }

    public long setStandbyMode(int i2) {
        return ((Long) addWorker(new SyncSetStandByCmd(i2))).longValue();
    }

    public long setSyncCaptureMode(int i2) {
        return ((Long) addWorker(new SyncSetCatpureModeCmd(i2))).longValue();
    }

    public long setSyncStandByMode(int i2) {
        return ((Long) addWorker(new StandByCmd(i2))).longValue();
    }

    public int setTimelapseOptions(SetTimelapseOptions setTimelapseOptions) {
        return ((Integer) addWorker(new SetTimelapseOptionCmd(setTimelapseOptions))).intValue();
    }

    public long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions) {
        return ((Long) addWorker(new AyncSetTimelapseOptionCmd(setTimelapseOptions))).longValue();
    }

    public void setWifiHeartDebug(boolean z) {
        addWorker(new WifiHeartCmd(z));
    }

    public void startBleStatusTest() {
        addWorker(new BleStatusCmd());
    }

    public int startBulletTime() {
        return ((Integer) addWorker(new StartBulletTimeCmd())).intValue();
    }

    public void startColorTest() {
        addWorker(new ColorTestCmd());
    }

    public void startContactTest() {
        addWorker(new ContactTestCmd());
    }

    public void startHdrCapture() {
        addWorker(new HdrCaptureCommand());
    }

    public void startLedTest() {
        addWorker(new LedTestCmd());
    }

    public void startRecord(boolean z, boolean z2, int i2, StartCaptureWithoutStorage startCaptureWithoutStorage) {
        StartRecordCmd startRecordCmd = new StartRecordCmd(z, z2, i2, this.mStartStreamingParam, this.mRecordingType, this.mStreamPiple, startCaptureWithoutStorage, this.mICameraPreviewPipeline, this.mAudioSource, this.mInfoUpdateListener, this.mInfoHandler, this.mCameraLiveStateListener);
        addWorker(startRecordCmd);
    }

    public void startSpeakerTest() {
        addWorker(new SpeakerTestCmd());
    }

    public void startTestTypeC() {
        addWorker(new TestTypeCCmd());
    }

    public long startTimeShift() {
        return ((Long) addWorker(new StartTimeshiftCmd())).longValue();
    }

    public void startTimeplapse(StartTimelapse startTimelapse) {
        addWorker(new StartTimeplaseCmd(startTimelapse));
    }

    public void startWifiStatusTest() {
        addWorker(new WifiStatusCmd());
    }

    public void stopBulletTime(byte[] bArr) {
        addWorker(new StopBulletTimeCmd(bArr));
    }

    public void stopHdrCapture(byte[] bArr) {
        addWorker(new HdrStopCaptureCmd(bArr));
    }

    public void stopLCDTest() {
        addWorker(new StopLCDCmd());
    }

    public void stopLive() {
        addWorkerSync(0, new StopLiveCmd(this.mICameraPreviewPipeline));
    }

    public void stopRecord(int i2, byte[] bArr) {
        addWorker(new StopRecordCmd(i2, bArr, this.mRecordingType, this.mStreamPiple));
    }

    public void stopScan() {
        addWorker(new BleStopScanCmd());
    }

    public void stopTimeShift(byte[] bArr) {
        addWorker(new StopTimeShift(bArr));
    }

    public void stopTimelapse(StopTimelapse stopTimelapse) {
        addWorker(new StopTimelapseCmd(stopTimelapse));
    }

    public void stopWakeup() {
        addWorker(new BleStopWakeupCmd(this.mBleStopWakeupCallback));
    }

    public long syncCaptureStatus() {
        return ((Long) addWorker(new SyncCaptureStatusCmd())).longValue();
    }

    public void takePicture(TakePicture takePicture, boolean z) {
        addWorker(new CaptureCommand(takePicture, z));
    }

    public void testButtonState() {
        addWorker(new ButtonTestCmd());
    }

    public void testUsbSpeed(TestSDCardSpeed testSDCardSpeed) {
        addWorker(new UsbSpeedCmd(testSDCardSpeed));
    }

    public long vibrateTest() {
        return ((Long) addWorker(new VibrateTextCmd())).longValue();
    }

    public void wakeUpBle(int i2, String str, byte b2) {
        addWorker(new BleWakeUpCmd(i2, str, b2, this.mBleWakeUpListener));
    }

    public long whiteBlanceTest() {
        return ((Long) addWorker(new WhiteBlanceTestCmd())).longValue();
    }
}
