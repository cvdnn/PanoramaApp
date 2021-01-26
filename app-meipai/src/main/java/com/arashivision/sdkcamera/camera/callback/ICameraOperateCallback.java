package com.arashivision.sdkcamera.camera.callback;

public interface ICameraOperateCallback {
    void onCameraConnectError();

    void onFailed();

    void onSuccessful();
}
