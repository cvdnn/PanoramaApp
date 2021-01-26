package com.arashivision.sdkmedia.player.capture;

import android.view.Surface;
import com.arashivision.insta360.basemedia.model.CameraType;
import e.a.a.a.a;

public class CaptureParamsBuilder {
    public static final int RENDER_MODE_AUTO = 0;
    public static final int RENDER_MODE_PLANE_STITCH = 10;

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public String f300O8oO888 = CameraType.ONEX.type;

    /* renamed from: OO〇8 reason: contains not printable characters */
    public boolean f301OO8 = true;
    public int Oo;
    public int Oo0 = 720;

    /* renamed from: O〇80Oo0O reason: contains not printable characters */
    public Surface f302O80Oo0O;

    /* renamed from: O〇o8ooOo〇 reason: contains not printable characters */
    public boolean f303Oo8ooOo = false;

    /* renamed from: o0o8〇 reason: contains not printable characters */
    public int f304o0o8;

    /* renamed from: oo0〇OO〇O8 reason: contains not printable characters */
    public boolean f305oo0OOO8 = true;

    /* renamed from: 〇00oOOo reason: contains not printable characters */
    public int f30600oOOo = 0;

    /* renamed from: 〇O reason: contains not printable characters */
    public int f307O = 30;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public boolean f308O8;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public String f309Ooo = "";

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public boolean f310o0o0;

    /* renamed from: 〇oO reason: contains not printable characters */
    public int f311oO = 1440;

    /* renamed from: 〇o〇0O〇0O reason: contains not printable characters */
    public boolean f312o0O0O = true;

    /* renamed from: 〇〇 reason: contains not printable characters */
    public int[] f313 = {-1, -1};

    public Surface getCameraRenderSurface() {
        return this.f302O80Oo0O;
    }

    public int getCameraRenderSurfaceHeight() {
        return this.f304o0o8;
    }

    public int getCameraRenderSurfaceWidth() {
        return this.Oo;
    }

    public String getCameraType() {
        return this.f300O8oO888;
    }

    public int getFps() {
        return this.f307O;
    }

    public int getHeight() {
        return this.Oo0;
    }

    public String getMediaOffset() {
        return this.f309Ooo;
    }

    public int getRenderModelType() {
        return this.f30600oOOo;
    }

    public int[] getScreenRatio() {
        return this.f313;
    }

    public int getWidth() {
        return this.f311oO;
    }

    public boolean isCameraSelfie() {
        return this.f308O8;
    }

    public boolean isCopyVideoHwaccel() {
        return this.f305oo0OOO8;
    }

    public boolean isGestureEnabled() {
        return this.f301OO8;
    }

    public boolean isLive() {
        return this.f310o0o0;
    }

    public boolean isOnlyStitchSurfaceRender() {
        return this.f303Oo8ooOo;
    }

    public boolean isStabEnabled() {
        return this.f312o0O0O;
    }

    public CaptureParamsBuilder setCameraRenderSurfaceInfo(Surface surface, int i2, int i3) {
        this.f302O80Oo0O = surface;
        this.Oo = i2;
        this.f304o0o8 = i3;
        return this;
    }

    public CaptureParamsBuilder setCameraSelfie(boolean z) {
        this.f308O8 = z;
        return this;
    }

    public CaptureParamsBuilder setCameraType(String str) {
        this.f300O8oO888 = str;
        return this;
    }

    public CaptureParamsBuilder setCopyVideoHwaccel(boolean z) {
        this.f305oo0OOO8 = z;
        return this;
    }

    public CaptureParamsBuilder setGestureEnabled(boolean z) {
        this.f301OO8 = z;
        return this;
    }

    public CaptureParamsBuilder setLive(boolean z) {
        this.f310o0o0 = z;
        return this;
    }

    public CaptureParamsBuilder setMediaOffset(String str) {
        this.f309Ooo = str;
        return this;
    }

    public CaptureParamsBuilder setOnlyStitchSurfaceRender(boolean z) {
        this.f303Oo8ooOo = z;
        return this;
    }

    public CaptureParamsBuilder setRenderModelType(int i2) {
        this.f30600oOOo = i2;
        return this;
    }

    public CaptureParamsBuilder setResolutionParams(int i2, int i3, int i4) {
        this.f311oO = i2;
        this.Oo0 = i3;
        this.f307O = i4;
        return this;
    }

    public CaptureParamsBuilder setScreenRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            int[] iArr = this.f313;
            iArr[0] = -1;
            iArr[1] = -1;
        } else {
            int[] iArr2 = this.f313;
            iArr2[0] = i2;
            iArr2[1] = i3;
        }
        return this;
    }

    public CaptureParamsBuilder setStabEnabled(boolean z) {
        this.f312o0O0O = z;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("CameraType: ");
        a2.append(this.f300O8oO888);
        a2.append(", MediaOffset: ");
        a2.append(this.f309Ooo);
        a2.append(", isCameraSelfie: ");
        a2.append(this.f308O8);
        a2.append(", isLive: ");
        a2.append(this.f310o0o0);
        a2.append(", width: ");
        a2.append(this.f311oO);
        a2.append(", height: ");
        a2.append(this.Oo0);
        a2.append(", fps: ");
        a2.append(this.f307O);
        a2.append(", isStabEnabled: ");
        a2.append(this.f312o0O0O);
        a2.append(", ScreenRatio: [");
        a2.append(this.f313[0]);
        a2.append(",");
        a2.append(this.f313[1]);
        a2.append("], RenderModeType: ");
        a2.append(this.f30600oOOo);
        a2.append(", isGestureEnabled: ");
        a2.append(this.f301OO8);
        a2.append(", CopyVideoHwaccel: ");
        a2.append(this.f305oo0OOO8);
        a2.append(", CameraRenderSurface: ");
        a2.append(this.f302O80Oo0O);
        a2.append(", CameraRenderSurfaceWidth: ");
        a2.append(this.Oo);
        a2.append(", CameraRenderSurfaceHeight: ");
        a2.append(this.f304o0o8);
        a2.append(", OnlyStitchSurfaceRender: ");
        a2.append(this.f303Oo8ooOo);
        return a2.toString();
    }
}
