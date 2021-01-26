package com.arashivision.algorithm;

public final class DoubleWatchResult {
    public float[] quat;
    public double srcTime;

    public float[] getQuat() {
        return this.quat;
    }

    public double getSrcTime() {
        return this.srcTime;
    }

    public void setQuat(float[] fArr) {
        this.quat = fArr;
    }

    public void setSrcTime(double d2) {
        this.srcTime = d2;
    }
}
