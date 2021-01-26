package com.arashivision.sdkmedia.player.image;

import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.sdkmedia.InstaMediaSDK;
import e.a.a.a.a;

public class ImageParamsBuilder {
    public static final int RENDER_MODE_AUTO = 0;
    public static final int RENDER_MODE_PLANE_STITCH = 10;

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public String f322O8oO888 = InstaMediaSDK.m55Ooo();
    public boolean Oo0 = true;

    /* renamed from: 〇O reason: contains not printable characters */
    public int[] f323O = {-1, -1};

    /* renamed from: 〇O8 reason: contains not printable characters */
    public String f324O8 = InstaMediaSDK.m53O8oO888();

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public String f325Ooo = InstaMediaSDK.m54O8();

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public String f326o0o0 = null;

    /* renamed from: 〇oO reason: contains not printable characters */
    public boolean f327oO = true;

    /* renamed from: 〇o〇0O〇0O reason: contains not printable characters */
    public int f328o0O0O = 0;

    /* renamed from: 〇〇 reason: contains not printable characters */
    public boolean f329 = true;

    public String getCacheCutSceneRootPath() {
        return this.f324O8;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f322O8oO888;
    }

    public int getRenderModelType() {
        return this.f328o0O0O;
    }

    public int[] getScreenRatio() {
        return this.f323O;
    }

    public String getStabilizerCacheRootPath() {
        return this.f325Ooo;
    }

    public String getUrlForPlay() {
        return this.f326o0o0;
    }

    public boolean isDynamicStitch() {
        return this.f327oO;
    }

    public boolean isGestureEnabled() {
        return this.f329;
    }

    public boolean isStabEnabled() {
        return this.Oo0;
    }

    public ImageParamsBuilder setCacheCutSceneRootPath(String str) {
        this.f324O8 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ImageParamsBuilder setCacheWorkThumbnailRootPath(String str) {
        this.f322O8oO888 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ImageParamsBuilder setDynamicStitch(boolean z) {
        this.f327oO = z;
        return this;
    }

    public ImageParamsBuilder setGestureEnabled(boolean z) {
        this.f329 = z;
        return this;
    }

    public ImageParamsBuilder setRenderModelType(int i2) {
        this.f328o0O0O = i2;
        return this;
    }

    public ImageParamsBuilder setScreenRatio(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            int[] iArr = this.f323O;
            iArr[0] = -1;
            iArr[1] = -1;
        } else {
            int[] iArr2 = this.f323O;
            iArr2[0] = i2;
            iArr2[1] = i3;
        }
        return this;
    }

    public ImageParamsBuilder setStabEnabled(boolean z) {
        this.Oo0 = z;
        return this;
    }

    public ImageParamsBuilder setStabilizerCacheRootPath(String str) {
        this.f325Ooo = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ImageParamsBuilder setUrlForPlay(String str) {
        this.f326o0o0 = str;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("CacheWorkPath: ");
        a2.append(this.f322O8oO888);
        a2.append(", StabilizerPath: ");
        a2.append(this.f325Ooo);
        a2.append(", CacheCutScenePath: ");
        a2.append(this.f324O8);
        a2.append(", UrlForPlay: ");
        a2.append(this.f326o0o0);
        a2.append(", isDynamicStitch: ");
        a2.append(this.f327oO);
        a2.append(", isStabEnabled: ");
        a2.append(this.Oo0);
        a2.append(", ScreenRatio: [");
        a2.append(this.f323O[0]);
        a2.append(",");
        a2.append(this.f323O[1]);
        a2.append("], RenderModeType: ");
        a2.append(this.f328o0O0O);
        a2.append(", isGestureEnabled: ");
        a2.append(this.f329);
        return a2.toString();
    }
}
