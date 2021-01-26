package com.arashivision.arvbmg.render.lottie.data;

import com.arashivision.arvbmg.render.lottie.data.bezierdata.EffectData;
import java.util.List;

public class LayerData {
    public String mColor;
    public List<EffectData> mEffectList;
    public int mEndFrame;
    public int mHeight;
    public int mIndex;
    public List<MaskData> mMaskList;
    public String mName;
    public List<ShapeData> mShapeList;
    public int mStartFrame;
    public Type mType;
    public int mWidth;

    public enum Type {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text
    }

    public String getColor() {
        return this.mColor;
    }

    public List<EffectData> getEffectList() {
        return this.mEffectList;
    }

    public int getEndFrame() {
        return this.mEndFrame;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public List<MaskData> getMaskList() {
        return this.mMaskList;
    }

    public String getName() {
        return this.mName;
    }

    public List<ShapeData> getShapeList() {
        return this.mShapeList;
    }

    public int getStartFrame() {
        return this.mStartFrame;
    }

    public Type getType() {
        return this.mType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setEffectList(List<EffectData> list) {
        this.mEffectList = list;
    }

    public void setEndFrame(int i2) {
        this.mEndFrame = i2;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
    }

    public void setIndex(int i2) {
        this.mIndex = i2;
    }

    public void setMaskList(List<MaskData> list) {
        this.mMaskList = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setShapeList(List<ShapeData> list) {
        this.mShapeList = list;
    }

    public void setStartFrame(int i2) {
        this.mStartFrame = i2;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
    }
}
