package com.arashivision.arvbmg.render.lottie.data.bezierdata;

public class PointBezierData implements IBezierData {
    public float[] mPoint;

    public PointBezierData(float[] fArr) {
        this.mPoint = fArr;
    }

    public float[] getPoint() {
        return this.mPoint;
    }

    public void setPoint(float[] fArr) {
        this.mPoint = fArr;
    }
}
