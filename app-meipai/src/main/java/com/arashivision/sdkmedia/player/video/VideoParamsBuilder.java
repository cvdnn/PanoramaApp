package com.arashivision.sdkmedia.player.video;

import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.sdkmedia.InstaMediaSDK;
import e.a.a.a.a;

public class VideoParamsBuilder {
    public static final int RENDER_MODE_AUTO = 0;
    public static final int RENDER_MODE_PLANE_STITCH = 10;

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public String f348O8oO888 = InstaMediaSDK.m55Ooo();
    public int Oo0 = -1;

    /* renamed from: 〇00oOOo reason: contains not printable characters */
    public boolean f34900oOOo = true;

    /* renamed from: 〇O reason: contains not printable characters */
    public int f350O = -16777216;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public boolean f351O8 = true;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public String f352Ooo = InstaMediaSDK.m53O8oO888();

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public int[] f353o0o0 = {-1, -1};

    /* renamed from: 〇oO reason: contains not printable characters */
    public int f354oO = 0;

    /* renamed from: 〇o〇0O〇0O reason: contains not printable characters */
    public boolean f355o0O0O = true;

    /* renamed from: 〇〇 reason: contains not printable characters */
    public boolean f356 = true;

    public String getCacheCutSceneRootPath() {
        return this.f352Ooo;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f348O8oO888;
    }

    public int getLoadingBackgroundColor() {
        return this.f350O;
    }

    public int getLoadingImageResId() {
        return this.Oo0;
    }

    public int getRenderModelType() {
        return this.f354oO;
    }

    public int[] getScreenRatio() {
        return this.f353o0o0;
    }

    public boolean isAutoPlayAfterPrepared() {
        return this.f355o0O0O;
    }

    public boolean isGestureEnabled() {
        return this.f34900oOOo;
    }

    public boolean isLooping() {
        return this.f356;
    }

    public boolean isStabEnabled() {
        return this.f351O8;
    }

    public VideoParamsBuilder setAutoPlayAfterPrepared(boolean z) {
        this.f355o0O0O = z;
        return this;
    }

    public VideoParamsBuilder setCacheCutSceneRootPath(String str) {
        this.f352Ooo = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public VideoParamsBuilder setCacheWorkThumbnailRootPath(String str) {
        this.f348O8oO888 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public VideoParamsBuilder setGestureEnabled(boolean z) {
        this.f34900oOOo = z;
        return this;
    }

    public VideoParamsBuilder setIsLooping(boolean z) {
        this.f356 = z;
        return this;
    }

    public VideoParamsBuilder setLoadingBackgroundColor(int i2) {
        this.f350O = i2;
        return this;
    }

    public VideoParamsBuilder setLoadingImageResId(int i2) {
        this.Oo0 = i2;
        return this;
    }

    public VideoParamsBuilder setRenderModelType(int i2) {
        this.f354oO = i2;
        return this;
    }

    public VideoParamsBuilder setScreenRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            int[] iArr = this.f353o0o0;
            iArr[0] = -1;
            iArr[1] = -1;
        } else {
            int[] iArr2 = this.f353o0o0;
            iArr2[0] = i2;
            iArr2[1] = i3;
        }
        return this;
    }

    public VideoParamsBuilder setStabEnabled(boolean z) {
        this.f351O8 = z;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("CacheWorkPath: ");
        a2.append(this.f348O8oO888);
        a2.append(", CacheCutScenePath: ");
        a2.append(this.f352Ooo);
        a2.append(", isStabEnabled: ");
        a2.append(this.f351O8);
        a2.append(", ScreenRatio: [");
        a2.append(this.f353o0o0[0]);
        a2.append(",");
        a2.append(this.f353o0o0[1]);
        a2.append("], RenderModeType: ");
        a2.append(this.f354oO);
        a2.append(", AutoPlayAfterPrepared: ");
        a2.append(this.f355o0O0O);
        a2.append(", isLooping: ");
        a2.append(this.f356);
        a2.append(", isGestureEnabled: ");
        a2.append(this.f34900oOOo);
        return a2.toString();
    }
}
