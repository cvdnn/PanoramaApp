package com.arashivision.ble;

import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;

public interface OneBleCallbacks {
    void onBleErrorState(int i2);

    void onConnectFail();

    void onConnecting();

    void onDisConnected();

    void onMtuChanged(int i2, int i3);

    void onReadRssi(int i2);

    void onRecordVideoStateNotify(int i2, VideoResult videoResult);

    void onScanComplete();

    void onScanFail();

    void onServicesDiscovered();

    void onServicesDiscoveredFail();

    void onStartScan();

    void onStartWakeUpFail(int i2);

    void onStartWakeUpSuccess();

    void onStillImageWithStorageNotify(TakePictureResponse takePictureResponse);

    void onStopWakeUpFail(int i2);

    void onStopWakeUpSuccess();

    void onTimelapseNotify(int i2, VideoResult videoResult);
}
