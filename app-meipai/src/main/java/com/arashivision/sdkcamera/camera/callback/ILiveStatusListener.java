package com.arashivision.sdkcamera.camera.callback;

public interface ILiveStatusListener {
    void onLiveFpsUpdate(int i2);

    void onLivePushError();

    void onLivePushFinished();

    void onLivePushStarted();
}
