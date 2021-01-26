package com.arashivision.onestream.pipeline;

public interface ICameraLivePipline {
    void onCameraLiveNotify(int i2, int i3, int i4, String str, String str2);

    void onCameraLiveStop();
}
