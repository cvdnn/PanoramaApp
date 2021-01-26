package com.arashivision.insta360.basemedia.ui.player.capture;

public class SimplePlayCaptureParams implements IPlayCaptureParams {
    public boolean I1I;
    public int IL1Iii;
    public boolean ILL = true;
    public int ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f87ILl = false;
    public boolean Ilil = false;

    /* renamed from: I丨L reason: contains not printable characters */
    public boolean f88IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public boolean f89IiL = true;
    public CameraRenderSurfaceInfo Lil;
    public String[] LlLI1;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public boolean f90Ll1 = false;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public boolean f91L11I = true;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public boolean f92iILLL1 = true;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public boolean f93lIiI = true;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f94lLi1LL = false;

    /* renamed from: 丨il reason: contains not printable characters */
    public boolean f95il = true;

    public CameraRenderSurfaceInfo getCameraRenderSurfaceInfo() {
        return this.Lil;
    }

    public int getLiveRenderModelType() {
        return this.ILil;
    }

    public String[] getMultiViewTrackModelPaths() {
        return this.LlLI1;
    }

    public int getRenderModelType() {
        return this.IL1Iii;
    }

    public boolean isApplyMultiView() {
        return this.f94lLi1LL;
    }

    public boolean isApplyWatermark() {
        return this.f88IL;
    }

    public boolean isAutoRotateEnable() {
        return this.f90Ll1;
    }

    public boolean isCopyVideoHwaccel() {
        return this.f93lIiI;
    }

    public boolean isGestureEnabled() {
        return this.f92iILLL1;
    }

    public boolean isGestureHorizontalEnabled() {
        return this.f89IiL;
    }

    public boolean isGestureVerticalEnabled() {
        return this.f91L11I;
    }

    public boolean isGestureZoomEnabled() {
        return this.f95il;
    }

    public boolean isNeedInitMultiView() {
        return this.Ilil;
    }

    public boolean isOnlyStitchSurfaceRender() {
        return this.f87ILl;
    }

    public boolean isStabilizeEnabled() {
        return this.ILL;
    }

    public boolean isWithSwitchingAnimation() {
        return this.I1I;
    }

    public void setApplyMultiView(boolean z) {
        this.f94lLi1LL = z;
    }

    public void setApplyWatermark(boolean z) {
        this.f88IL = z;
    }

    public void setAutoRotateEnable(boolean z) {
        this.f90Ll1 = z;
    }

    public void setCameraRenderSurfaceInfo(CameraRenderSurfaceInfo cameraRenderSurfaceInfo) {
        this.Lil = cameraRenderSurfaceInfo;
    }

    public void setCopyVideoHwaccel(boolean z) {
        this.f93lIiI = z;
    }

    public void setGestureEnabled(boolean z) {
        this.f92iILLL1 = z;
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.f89IiL = z;
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.f91L11I = z;
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f95il = z;
    }

    public void setLiveRenderModelType(int i2) {
        this.ILil = i2;
    }

    public void setMultiViewTrackModelPaths(String[] strArr) {
        this.LlLI1 = strArr;
    }

    public void setNeedInitMultiView(boolean z) {
        this.Ilil = z;
    }

    public void setOnlyStitchSurfaceRender(boolean z) {
        this.f87ILl = z;
    }

    public void setRenderModelType(int i2) {
        this.IL1Iii = i2;
    }

    public void setStabilizeEnabled(boolean z) {
        this.ILL = z;
    }

    public void setWithSwitchingAnimation(boolean z) {
        this.I1I = z;
    }
}
