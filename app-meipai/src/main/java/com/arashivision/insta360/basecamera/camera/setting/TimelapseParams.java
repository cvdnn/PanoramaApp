package com.arashivision.insta360.basecamera.camera.setting;

public class TimelapseParams {
    public int mAccelerateFequency;
    public int mDurationS;
    public int mIntervalMs;

    public TimelapseParams() {
    }

    public TimelapseParams(int i2, int i3, int i4) {
        this.mDurationS = i2;
        this.mIntervalMs = i3;
        this.mAccelerateFequency = i4;
    }
}
