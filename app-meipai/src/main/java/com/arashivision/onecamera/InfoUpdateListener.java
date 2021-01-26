package com.arashivision.onecamera;

public interface InfoUpdateListener {
    void onCameraInfoNotify(int i2, int i3, Object obj);

    void onLivePushStarted(String str);

    void onRecordFpsUpdate(int i2);
}
