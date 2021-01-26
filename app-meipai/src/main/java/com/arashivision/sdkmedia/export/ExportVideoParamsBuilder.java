package com.arashivision.sdkmedia.export;

import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.sdkmedia.InstaMediaSDK;
import com.arashivision.sdkmedia.export.ExportUtils.ExportMode;
import e.a.a.a.a;
import java.io.File;

public class ExportVideoParamsBuilder {

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public ExportMode f290O8oO888 = ExportMode.PANORAMA;

    /* renamed from: OO〇8 reason: contains not printable characters */
    public int f291OO8 = -1;
    public boolean Oo0 = true;

    /* renamed from: 〇00oOOo reason: contains not printable characters */
    public int f29200oOOo = -1;

    /* renamed from: 〇O reason: contains not printable characters */
    public boolean f293O = true;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public String f294O8 = null;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public String f295Ooo = "INSTA 360";

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public String f296o0o0 = InstaMediaSDK.m55Ooo();

    /* renamed from: 〇oO reason: contains not printable characters */
    public String f297oO = InstaMediaSDK.m53O8oO888();

    /* renamed from: 〇o〇0O〇0O reason: contains not printable characters */
    public int f298o0O0O = -1;

    /* renamed from: 〇〇 reason: contains not printable characters */
    public int f299 = -1;

    public int getBitrate() {
        return this.f29200oOOo;
    }

    public String getCacheCutSceneRootPath() {
        return this.f297oO;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f296o0o0;
    }

    public String getCameraType() {
        return this.f295Ooo;
    }

    public ExportMode getExportMode() {
        return this.f290O8oO888;
    }

    public int getFps() {
        return this.f291OO8;
    }

    public int getHeight() {
        return this.f299;
    }

    public String getTargetPath() {
        return this.f294O8;
    }

    public int getWidth() {
        return this.f298o0O0O;
    }

    public boolean isDynamicStitch() {
        return this.f293O;
    }

    public boolean isStabEnabled() {
        return this.Oo0;
    }

    public ExportVideoParamsBuilder setBitrate(int i2) {
        this.f29200oOOo = i2;
        return this;
    }

    public ExportVideoParamsBuilder setCacheCutSceneRootPath(String str) {
        this.f297oO = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ExportVideoParamsBuilder setCacheWorkThumbnailRootPath(String str) {
        this.f296o0o0 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ExportVideoParamsBuilder setCameraType(String str) {
        this.f295Ooo = str;
        return this;
    }

    public ExportVideoParamsBuilder setDynamicStitch(boolean z) {
        this.f293O = z;
        return this;
    }

    public ExportVideoParamsBuilder setExportMode(ExportMode exportMode) {
        this.f290O8oO888 = exportMode;
        return this;
    }

    public ExportVideoParamsBuilder setFps(int i2) {
        this.f291OO8 = i2;
        return this;
    }

    public ExportVideoParamsBuilder setHeight(int i2) {
        this.f299 = i2;
        return this;
    }

    public ExportVideoParamsBuilder setStabEnabled(boolean z) {
        this.Oo0 = z;
        return this;
    }

    public ExportVideoParamsBuilder setTargetPath(String str) {
        this.f294O8 = str;
        FileUtils.createDirectoryIfNeeded(new File(this.f294O8).getParent());
        return this;
    }

    public ExportVideoParamsBuilder setWidth(int i2) {
        this.f298o0O0O = i2;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("ExportMode: ");
        a2.append(this.f290O8oO888);
        a2.append(", CameraType: ");
        a2.append(this.f295Ooo);
        a2.append(", TargetPath: ");
        a2.append(this.f294O8);
        a2.append(", CacheWorkPath: ");
        a2.append(this.f296o0o0);
        a2.append(", CacheCutScenePath: ");
        a2.append(this.f297oO);
        a2.append(", isStabEnabled: ");
        a2.append(this.Oo0);
        a2.append(", isDynamicStitch: ");
        a2.append(this.f293O);
        a2.append(", width: ");
        a2.append(this.f298o0O0O);
        a2.append(", height: ");
        a2.append(this.f299);
        a2.append(", bitrate: ");
        a2.append(this.f29200oOOo);
        a2.append(", fps: ");
        a2.append(this.f291OO8);
        return a2.toString();
    }
}
