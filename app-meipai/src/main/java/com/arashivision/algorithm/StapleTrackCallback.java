package com.arashivision.algorithm;

public interface StapleTrackCallback {
    void onStapleTrackError(int i2);

    void onStapleTrackResult(double d2, float f2, float[] fArr, float[] fArr2, float[] fArr3);
}
