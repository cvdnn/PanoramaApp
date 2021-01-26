package com.arashivision.sdkcamera.camera.callback;

public interface ICaptureStatusListener {
    void onCaptureCountChanged(int i2);

    void onCaptureFinish(String[] strArr);

    void onCaptureStarting();

    void onCaptureStopping();

    void onCaptureTimeChanged(long j2);

    void onCaptureWorking();
}
