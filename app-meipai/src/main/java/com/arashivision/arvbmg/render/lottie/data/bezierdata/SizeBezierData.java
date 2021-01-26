package com.arashivision.arvbmg.render.lottie.data.bezierdata;

public class SizeBezierData implements IBezierData {
    public int mHeight;
    public int mWidth;

    public SizeBezierData(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
    }
}
