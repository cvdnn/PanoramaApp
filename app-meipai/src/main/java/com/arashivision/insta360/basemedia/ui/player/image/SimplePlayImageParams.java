package com.arashivision.insta360.basemedia.ui.player.image;

import com.arashivision.graphicpath.render.engine.Transform;

public class SimplePlayImageParams implements IPlayImageParams {
    public boolean I1I = false;
    public Transform IL1Iii = null;
    public int ILil = 0;
    public boolean Ilil = true;

    /* renamed from: I丨L reason: contains not printable characters */
    public boolean f143IL = false;

    /* renamed from: I丨iL reason: contains not printable characters */
    public boolean f144IiL = true;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public boolean f145iILLL1 = true;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f146lLi1LL = true;

    public int getRenderModelType() {
        return this.ILil;
    }

    public Transform getRestoreCameraTransform() {
        return this.IL1Iii;
    }

    public boolean isApplyWatermark() {
        return this.f143IL;
    }

    public boolean isGestureEnabled() {
        return this.Ilil;
    }

    public boolean isGestureHorizontalEnabled() {
        return this.f146lLi1LL;
    }

    public boolean isGestureVerticalEnabled() {
        return this.f145iILLL1;
    }

    public boolean isGestureZoomEnabled() {
        return this.f144IiL;
    }

    public boolean isWithSwitchingAnimation() {
        return this.I1I;
    }

    public void setApplyWatermark(boolean z) {
        this.f143IL = z;
    }

    public void setGestureEnabled(boolean z) {
        this.Ilil = z;
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.f146lLi1LL = z;
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.f145iILLL1 = z;
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f144IiL = z;
    }

    public void setRenderModelType(int i2) {
        this.ILil = i2;
    }

    public void setRestoreCameraTransform(Transform transform) {
        this.IL1Iii = transform;
    }

    public void setWithSwitchingAnimation(boolean z) {
        this.I1I = z;
    }
}
