package com.arashivision.sdkcamera.camera.callback;

public interface IPreviewStatusListener {
    void onError();

    void onIdle();

    void onOpened();

    void onOpening();
}
