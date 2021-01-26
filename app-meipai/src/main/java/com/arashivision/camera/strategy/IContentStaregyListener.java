package com.arashivision.camera.strategy;

import android.content.Context;
import com.arashivision.camera.listener.IBleConnectListener;
import com.arashivision.camera.listener.IBleScanListener;
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
import e.e.a.e.b;
import java.util.List;

public interface IContentStaregyListener {

    public interface IBleConntectListener {
        void closeBle();

        void connectDevice(b bVar, boolean z, IBleConnectListener iBleConnectListener);

        void disConnect(b bVar);

        void disConnectBle();

        void scan(long j2, boolean z, IBleScanListener iBleScanListener);

        void stopScan();

        void stopWakeup();

        void wakeUpBle(int i2, String str, byte b2);
    }

    public interface IUsbConnectListener {
        void closeUsb();

        void openUsb(Context context);

        void startColorTest();

        void startContactTest();

        void startHdrCapture();

        void stopHdrCapture(byte[] bArr);

        void testUsbSpeed(TestSDCardSpeed testSDCardSpeed);
    }

    public interface IWIfiConnectListener {
        void closeIperf();

        void closeWifi();

        void getIperfAverage();

        void openIperf(int i2);

        void openWifi(int i2, String str, short s, boolean z);
    }

    long badPointTest();

    long blackLevelTest();

    long calibrateGyro(CalibrateGyro calibrateGyro);

    long cancelAuthorization();

    long checkAuthorization(CheckAuthorization checkAuthorization);

    long closeCameraWifi();

    void closePreviewStream();

    long connectBT(ConnectToBTPeripheral connectToBTPeripheral);

    long delteFileList(DeleteFiles deleteFiles);

    long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral);

    long dspLinkTest();

    long eraseSdcard();

    long getAgeTestStatus();

    long getCaptureStatus();

    long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral);

    long getFileExtra(GetFileExtra getFileExtra);

    long getFileInfoList();

    long getFileList(GetFileList getFileList);

    long getFlowStateEnable();

    GetGyroResp getGyro(GetGyro getGyro);

    long getGyroSync(GetGyro getGyro);

    long getMultiVideoMode(List<String> list);

    Options getOptions(List<String> list);

    long getOptionsSync(List<String> list);

    PhotoOptions getPhotoOptions(int i2, List<String> list);

    long getPhotoOptionsAsync(int i2, List<String> list);

    int getPort();

    long getSingleSensor();

    long getSyncCaptureMode();

    TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions);

    long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions);

    void getWifiHeartDebug(boolean z);

    long gyroScopeTest();

    long openCameraWifi();

    void previewStream(StartStreamingParam startStreamingParam, String str);

    long reboot();

    void resetRecord();

    long scanBT(ScanBTPeripheral scanBTPeripheral);

    long setFileExtra(SetFileExtra setFileExtra);

    long setFlowStateEnable(int i2);

    long setGpsData(byte[] bArr);

    long setKeyTimePoint(KeyTimePoint keyTimePoint);

    long setMultiVideoMode(MultiPhotoOptions multiPhotoOptions);

    long setOptionAsync(Options options);

    long setPhotoOptionSync(int i2, PhotoOptions photoOptions);

    long setPhotoOptions(int i2, PhotoOptions photoOptions);

    long setSingleSensor(int i2);

    long setStandbyMode(int i2);

    long setSyncCaptureMode(int i2);

    long setSyncStandByMode(int i2);

    int setTimelapseOptions(SetTimelapseOptions setTimelapseOptions);

    long setTimelapseOptionsASync(SetTimelapseOptions setTimelapseOptions);

    void setWifiHeartDebug(boolean z);

    void startBleStatusTest();

    int startBulletTime();

    void startLedTest();

    void startRecord(boolean z, boolean z2, int i2, StartCaptureWithoutStorage startCaptureWithoutStorage);

    void startSpeakerTest();

    void startTestTypeC();

    long startTimeShift();

    void startTimeplapse(StartTimelapse startTimelapse);

    void startWifiStatusTest();

    void stopBulletTime(byte[] bArr);

    void stopLCDTest();

    void stopLive();

    void stopRecord(int i2, byte[] bArr);

    void stopTimeShift(byte[] bArr);

    void stopTimelapse(StopTimelapse stopTimelapse);

    long syncCaptureStatus();

    void takePicture(TakePicture takePicture, boolean z);

    void testButtonState();

    long vibrateTest();

    long whiteBlanceTest();
}
