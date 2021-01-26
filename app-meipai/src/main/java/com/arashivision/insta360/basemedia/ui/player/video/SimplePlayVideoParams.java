package com.arashivision.insta360.basemedia.ui.player.video;

import android.graphics.Color;
import com.arashivision.graphicpath.render.engine.Transform;

public class SimplePlayVideoParams implements IPlayVideoParams {
    public boolean I11L = true;
    public boolean I11li1 = true;
    public boolean I1I = true;
    public double IL1Iii = 0.0d;
    public boolean ILL = true;
    public Transform ILil = null;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public float f147ILl = 1.0f;
    public float Ilil = 30.0f;

    /* renamed from: I丨L reason: contains not printable characters */
    public double[] f148IL = {-1.0d, -1.0d};

    /* renamed from: I丨iL reason: contains not printable characters */
    public int f149IiL = -1;

    /* renamed from: L11丨丨丨1 reason: contains not printable characters */
    public Long f150L111 = null;
    public boolean LL1IL = false;
    public boolean Lil = false;
    public boolean LlLI1 = false;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public boolean f151Ll1 = true;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public int f152L11I = Color.parseColor("#00000000");

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public boolean f153LlLLL = true;
    public boolean iIi1 = true;
    public boolean iIlLiL = false;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public boolean f154iILLL1 = false;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public int f155lIiI = 0;

    /* renamed from: lI丨II reason: contains not printable characters */
    public Integer f156lIII = null;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public boolean f157lIlii = false;
    public boolean llliI = true;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public boolean f158llL1ii = false;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public int f159lLi1LL = 0;

    /* renamed from: 丨il reason: contains not printable characters */
    public boolean f160il = true;

    /* renamed from: 丨lL reason: contains not printable characters */
    public boolean f161lL = true;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public boolean f162l = true;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public boolean f1631 = true;

    public double[] getCustomizedPlayRange() {
        return this.f148IL;
    }

    public int getLoadingBackgroundColor() {
        return this.f152L11I;
    }

    public int getLoadingImageResId() {
        return this.f149IiL;
    }

    public float getMuteBgmWhenSpeedMoreThan() {
        return this.f147ILl;
    }

    public Long getNetId() {
        return this.f150L111;
    }

    public int getQueueMode() {
        return this.f159lLi1LL;
    }

    public Integer getRenderBackgroundColor() {
        return this.f156lIII;
    }

    public float getRenderFps() {
        return this.Ilil;
    }

    public int getRenderModelType() {
        return this.f155lIiI;
    }

    public Transform getRestoreCameraTransform() {
        return this.ILil;
    }

    public double getRestorePlayPosition() {
        return this.IL1Iii;
    }

    public boolean isApplyFlash() {
        return this.f154iILLL1;
    }

    public boolean isApplyMultiView() {
        return this.iIi1;
    }

    public boolean isApplyProxy() {
        return this.f157lIlii;
    }

    public boolean isApplyWatermark() {
        return this.f158llL1ii;
    }

    public boolean isAutoPlayAfterPrepared() {
        return this.f160il;
    }

    public boolean isForceVideoKeyFrameOnly() {
        return this.iIlLiL;
    }

    public boolean isGestureDistanceChangeEnabled() {
        return this.f153LlLLL;
    }

    public boolean isGestureEnabled() {
        return this.f161lL;
    }

    public boolean isGestureFovChangeEnabled() {
        return this.f1631;
    }

    public boolean isGestureHorizontalEnabled() {
        return this.I11L;
    }

    public boolean isGestureVerticalEnabled() {
        return this.llliI;
    }

    public boolean isGestureZoomEnabled() {
        return this.f162l;
    }

    public boolean isImageAutoScaleEnabled() {
        return this.I11li1;
    }

    public boolean isLooping() {
        return this.ILL;
    }

    public boolean isNeedLoadGpsInfo() {
        return this.LlLI1;
    }

    public boolean isPlayRangeEnabled() {
        return this.I1I;
    }

    public boolean isResetViewAngleOnSeekComplete() {
        return this.f151Ll1;
    }

    public boolean isUseTextureView() {
        return this.LL1IL;
    }

    public boolean isWithSwitchingAnimation() {
        return this.Lil;
    }

    public void setApplyFlash(boolean z) {
        this.f154iILLL1 = z;
    }

    public void setApplyMultiView(boolean z) {
        this.iIi1 = z;
    }

    public void setApplyProxy(boolean z) {
        this.f157lIlii = z;
    }

    public void setApplyWatermark(boolean z) {
        this.f158llL1ii = z;
    }

    public void setAutoPlayAfterPrepared(boolean z) {
        this.f160il = z;
    }

    public void setCustomizedPlayRange(double[] dArr) {
        this.f148IL = dArr;
    }

    public void setForceVideoKeyFrameOnly(boolean z) {
        this.iIlLiL = z;
    }

    public void setGestureDistanceChangeEnabled(boolean z) {
        this.f153LlLLL = z;
    }

    public void setGestureEnabled(boolean z) {
        this.f161lL = z;
    }

    public void setGestureFovChangeEnabled(boolean z) {
        this.f1631 = z;
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.I11L = z;
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.llliI = z;
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f162l = z;
    }

    public void setImageAutoScaleEnabled(boolean z) {
        this.I11li1 = z;
    }

    public void setLoadingBackgroundColor(int i2) {
        this.f152L11I = i2;
    }

    public void setLoadingImageResId(int i2) {
        this.f149IiL = i2;
    }

    public void setLooping(boolean z) {
        this.ILL = z;
    }

    public void setMuteBgmWhenSpeedMoreThan(float f2) {
        this.f147ILl = f2;
    }

    public void setNeedLoadGpsInfo(boolean z) {
        this.LlLI1 = z;
    }

    public void setNetId(Long l) {
        this.f150L111 = l;
    }

    public void setPlayRangeEnable(boolean z) {
        this.I1I = z;
    }

    public void setQueueMode(int i2) {
        this.f159lLi1LL = i2;
    }

    public void setRenderBackgroundColor(Integer num) {
        this.f156lIII = num;
    }

    public void setRenderFps(float f2) {
        this.Ilil = f2;
    }

    public void setRenderModelType(int i2) {
        this.f155lIiI = i2;
    }

    public void setResetViewAngleOnSeekComplete(boolean z) {
        this.f151Ll1 = z;
    }

    public void setRestoreCameraTransform(Transform transform) {
        this.ILil = transform;
    }

    public void setRestorePlayPosition(double d2) {
        this.IL1Iii = d2;
    }

    public void setUseTextureView(boolean z) {
        this.LL1IL = z;
    }

    public void setWithSwitchingAnimation(boolean z) {
        this.Lil = z;
    }
}
