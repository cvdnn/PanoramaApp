package com.arashivision.arvbmg.render.lottie.data.bezierdata;

import com.arashivision.arvbmg.render.lottie.data.BezierKeyFrame;
import java.util.List;

public class EffectData {
    public List<BezierKeyFrame> mGaussianBlurriness;
    public List<BezierKeyFrame> mGaussianDimensions;
    public String mName;
    public List<BezierKeyFrame> mRadialAmount;
    public List<BezierKeyFrame> mRadialCenter;
    public List<BezierKeyFrame> mRadialType;
    public Type mType;

    public enum Type {
        Radial,
        Gaussian
    }

    public List<BezierKeyFrame> getGaussianBlurriness() {
        return this.mGaussianBlurriness;
    }

    public List<BezierKeyFrame> getGaussianDimensions() {
        return this.mGaussianDimensions;
    }

    public String getName() {
        return this.mName;
    }

    public List<BezierKeyFrame> getRadialAmount() {
        return this.mRadialAmount;
    }

    public List<BezierKeyFrame> getRadialCenter() {
        return this.mRadialCenter;
    }

    public List<BezierKeyFrame> getRadialType() {
        return this.mRadialType;
    }

    public Type getType() {
        return this.mType;
    }

    public void setGaussianBlurriness(List<BezierKeyFrame> list) {
        this.mGaussianBlurriness = list;
    }

    public void setGaussianDimensions(List<BezierKeyFrame> list) {
        this.mGaussianDimensions = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setRadialAmount(List<BezierKeyFrame> list) {
        this.mRadialAmount = list;
    }

    public void setRadialCenter(List<BezierKeyFrame> list) {
        this.mRadialCenter = list;
    }

    public void setRadialType(List<BezierKeyFrame> list) {
        this.mRadialType = list;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
