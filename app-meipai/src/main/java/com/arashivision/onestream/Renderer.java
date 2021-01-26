package com.arashivision.onestream;

public interface Renderer {
    void deInit();

    int init();

    int render(int i2, float[] fArr, float[] fArr2);

    void setTargetFb(int i2);
}
