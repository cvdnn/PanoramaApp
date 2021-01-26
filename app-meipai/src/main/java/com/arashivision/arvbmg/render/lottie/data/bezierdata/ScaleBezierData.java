package com.arashivision.arvbmg.render.lottie.data.bezierdata;

public class ScaleBezierData implements IBezierData {
    public float mXScale;
    public float mYScale;

    public ScaleBezierData(float f2, float f3) {
        this.mXScale = f2;
        this.mYScale = f3;
    }

    public float getXScale() {
        return this.mXScale;
    }

    public float getYScale() {
        return this.mYScale;
    }

    public void setXScale(float f2) {
        this.mXScale = f2;
    }

    public void setYScale(float f2) {
        this.mYScale = f2;
    }
}
