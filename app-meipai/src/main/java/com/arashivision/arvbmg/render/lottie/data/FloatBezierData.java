package com.arashivision.arvbmg.render.lottie.data;

import com.arashivision.arvbmg.render.lottie.data.bezierdata.IBezierData;

public class FloatBezierData implements IBezierData {
    public float mValue;

    public FloatBezierData(float f2) {
        this.mValue = f2;
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f2) {
        this.mValue = f2;
    }
}
