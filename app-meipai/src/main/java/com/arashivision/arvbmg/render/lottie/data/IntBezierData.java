package com.arashivision.arvbmg.render.lottie.data;

import com.arashivision.arvbmg.render.lottie.data.bezierdata.IBezierData;

public class IntBezierData implements IBezierData {
    public int mValue;

    public IntBezierData(int i2) {
        this.mValue = i2;
    }

    public int getValue() {
        return this.mValue;
    }

    public void setValue(int i2) {
        this.mValue = i2;
    }
}
