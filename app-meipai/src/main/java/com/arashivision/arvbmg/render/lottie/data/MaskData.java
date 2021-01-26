package com.arashivision.arvbmg.render.lottie.data;

import java.util.List;

public class MaskData {
    public boolean mClosed;
    public List<BezierKeyFrame> mExpansion;
    public boolean mInverted;
    public List<BezierKeyFrame> mMaskShape;
    public String mName;
    public List<BezierKeyFrame> mOpacity;
    public Type mType;

    public enum Type {
        Add,
        Subtract,
        Intersect
    }

    public List<BezierKeyFrame> getExpansion() {
        return this.mExpansion;
    }

    public List<BezierKeyFrame> getMaskShape() {
        return this.mMaskShape;
    }

    public String getName() {
        return this.mName;
    }

    public List<BezierKeyFrame> getOpacity() {
        return this.mOpacity;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    public void setClosed(boolean z) {
        this.mClosed = z;
    }

    public void setExpansion(List<BezierKeyFrame> list) {
        this.mExpansion = list;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public void setMaskShape(List<BezierKeyFrame> list) {
        this.mMaskShape = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOpacity(List<BezierKeyFrame> list) {
        this.mOpacity = list;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
