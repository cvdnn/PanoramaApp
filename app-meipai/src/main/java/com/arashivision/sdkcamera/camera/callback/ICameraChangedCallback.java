package com.arashivision.sdkcamera.camera.callback;

public interface ICameraChangedCallback {
    void onCameraBatteryLow();

    void onCameraBatteryUpdate(int i2, boolean z);

    void onCameraConnectError();

    void onCameraSDCardStateChanged(boolean z);

    void onCameraStatusChanged(boolean z);

    void onCameraStorageChanged(long j2, long j3);
}
