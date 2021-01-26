package com.arashivision.arvbmg.render.lottie.data;

import com.arashivision.arvbmg.render.lottie.data.bezierdata.IBezierData;

public class BezierKeyFrame {
    public IBezierData mDefaultData;
    public IBezierData mEndData;
    public int mEndFrame;
    public float[] mInTangent;
    public boolean mIsHold;
    public boolean mNeedAnimation;
    public float[] mOutTangent;
    public IBezierData mStartData;
    public int mStartFrame;

    public IBezierData getDefaultData() {
        return this.mDefaultData;
    }

    public IBezierData getEndData() {
        return this.mEndData;
    }

    public int getEndFrame() {
        return this.mEndFrame;
    }

    public float[] getInTangent() {
        return this.mInTangent;
    }

    public float[] getOutTangent() {
        return this.mOutTangent;
    }

    public IBezierData getStartData() {
        return this.mStartData;
    }

    public int getStartFrame() {
        return this.mStartFrame;
    }

    public boolean isHold() {
        return this.mIsHold;
    }

    public boolean isNeedAnimation() {
        return this.mNeedAnimation;
    }

    public void setDefaultData(IBezierData iBezierData) {
        this.mDefaultData = iBezierData;
    }

    public void setEndData(IBezierData iBezierData) {
        this.mEndData = iBezierData;
    }

    public void setEndFrame(int i2) {
        this.mEndFrame = i2;
    }

    public void setHold(boolean z) {
        this.mIsHold = z;
    }

    public void setInTangent(float[] fArr) {
        this.mInTangent = fArr;
    }

    public void setNeedAnimation(boolean z) {
        this.mNeedAnimation = z;
    }

    public void setOutTangent(float[] fArr) {
        this.mOutTangent = fArr;
    }

    public void setStartData(IBezierData iBezierData) {
        this.mStartData = iBezierData;
    }

    public void setStartFrame(int i2) {
        this.mStartFrame = i2;
    }
}
