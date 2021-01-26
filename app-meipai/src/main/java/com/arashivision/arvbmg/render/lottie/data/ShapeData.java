package com.arashivision.arvbmg.render.lottie.data;

import java.util.List;

public class ShapeData {
    public List<BezierKeyFrame> mAnchor;
    public List<BezierKeyFrame> mCornerRadius;
    public String mName;
    public List<BezierKeyFrame> mOpacity;
    public List<BezierKeyFrame> mPosition;
    public List<BezierKeyFrame> mRotation;
    public List<BezierKeyFrame> mScale;
    public List<BezierKeyFrame> mSize;
    public Type mType;

    public enum Type {
        Rectangle,
        Transform
    }

    public List<BezierKeyFrame> getAnchor() {
        return this.mAnchor;
    }

    public List<BezierKeyFrame> getCornerRadius() {
        return this.mCornerRadius;
    }

    public String getName() {
        return this.mName;
    }

    public List<BezierKeyFrame> getOpacity() {
        return this.mOpacity;
    }

    public List<BezierKeyFrame> getPosition() {
        return this.mPosition;
    }

    public List<BezierKeyFrame> getRotation() {
        return this.mRotation;
    }

    public List<BezierKeyFrame> getScale() {
        return this.mScale;
    }

    public List<BezierKeyFrame> getSize() {
        return this.mSize;
    }

    public Type getType() {
        return this.mType;
    }

    public void setAnchor(List<BezierKeyFrame> list) {
        this.mAnchor = list;
    }

    public void setCornerRadius(List<BezierKeyFrame> list) {
        this.mCornerRadius = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOpacity(List<BezierKeyFrame> list) {
        this.mOpacity = list;
    }

    public void setPosition(List<BezierKeyFrame> list) {
        this.mPosition = list;
    }

    public void setRotation(List<BezierKeyFrame> list) {
        this.mRotation = list;
    }

    public void setScale(List<BezierKeyFrame> list) {
        this.mScale = list;
    }

    public void setSize(List<BezierKeyFrame> list) {
        this.mSize = list;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
