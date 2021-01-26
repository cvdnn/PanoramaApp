package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.graphicpath.render.base.BaseCameraController;

public class CameraRenderInfo {
    public BaseCameraController mBaseCameraController;
    public int mContentMode = -1;
    public FilterInfo[] mFilterInfos;
    public int mImageLayout;
    public LogoInfo mLogoInfo;
    public int mModelType;
    public String mOffset;
    public int mSphereSlices;
    public int mSphereStacks;
    public StabilizingType mStabilizingType;

    public BaseCameraController getBaseCameraController() {
        return this.mBaseCameraController;
    }

    public int getContentMode() {
        return this.mContentMode;
    }

    public FilterInfo[] getFilterInfos() {
        return this.mFilterInfos;
    }

    public int getImageLayout() {
        return this.mImageLayout;
    }

    public LogoInfo getLogoInfo() {
        return this.mLogoInfo;
    }

    public int getModelType() {
        return this.mModelType;
    }

    public String getOffset() {
        return this.mOffset;
    }

    public int getSphereSlices() {
        return this.mSphereSlices;
    }

    public int getSphereStacks() {
        return this.mSphereStacks;
    }

    public StabilizingType getStabilizingType() {
        return this.mStabilizingType;
    }

    public boolean isPreferDynamic() {
        return this.mStabilizingType == StabilizingType.DYNAMIC_VERTEX;
    }

    public void setBaseCameraController(BaseCameraController baseCameraController) {
        this.mBaseCameraController = baseCameraController;
    }

    public void setContentMode(int i2) {
        this.mContentMode = i2;
    }

    public void setFilterInfos(FilterInfo[] filterInfoArr) {
        this.mFilterInfos = filterInfoArr;
    }

    public void setImageLayout(int i2) {
        this.mImageLayout = i2;
    }

    public void setLogoInfo(LogoInfo logoInfo) {
        this.mLogoInfo = logoInfo;
    }

    public void setModelType(int i2) {
        this.mModelType = i2;
    }

    public void setOffset(String str) {
        this.mOffset = str;
    }

    public void setSphereSlices(int i2) {
        this.mSphereSlices = i2;
    }

    public void setSphereStacks(int i2) {
        this.mSphereStacks = i2;
    }

    public void setStabilizingType(StabilizingType stabilizingType) {
        this.mStabilizingType = stabilizingType;
    }
}
