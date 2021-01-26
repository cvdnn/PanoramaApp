package com.arashivision.camera.listener;

public interface ICameraConnectionListener {
    void onCameraConnect();

    void onCameraError(int i2);

    void onCameraStateChange();
}
