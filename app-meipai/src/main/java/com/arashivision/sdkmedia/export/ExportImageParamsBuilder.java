package com.arashivision.sdkmedia.export;

import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.sdkmedia.InstaMediaSDK;
import com.arashivision.sdkmedia.export.ExportUtils.ExportMode;
import e.a.a.a.a;
import java.io.File;

public class ExportImageParamsBuilder {

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public ExportMode f274O8oO888 = ExportMode.PANORAMA;

    /* renamed from: OO〇8 reason: contains not printable characters */
    public int f275OO8 = -1;
    public float Oo = 0.0f;
    public String Oo0 = InstaMediaSDK.m53O8oO888();

    /* renamed from: O〇80Oo0O reason: contains not printable characters */
    public float f276O80Oo0O = 0.0f;

    /* renamed from: o0o8〇 reason: contains not printable characters */
    public float f277o0o8 = 0.0f;

    /* renamed from: oo0〇OO〇O8 reason: contains not printable characters */
    public float f278oo0OOO8 = 0.0f;

    /* renamed from: 〇00oOOo reason: contains not printable characters */
    public int f27900oOOo = -1;

    /* renamed from: 〇O reason: contains not printable characters */
    public String f280O = null;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public String f281O8 = null;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public String f282Ooo = "INSTA 360";

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public String f283o0o0 = InstaMediaSDK.m55Ooo();

    /* renamed from: 〇oO reason: contains not printable characters */
    public String f284oO = InstaMediaSDK.m54O8();

    /* renamed from: 〇o〇0O〇0O reason: contains not printable characters */
    public boolean f285o0O0O = true;

    /* renamed from: 〇〇 reason: contains not printable characters */
    public boolean f286 = true;

    public String getCacheCutSceneRootPath() {
        return this.Oo0;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f283o0o0;
    }

    public String getCameraType() {
        return this.f282Ooo;
    }

    public float getDistance() {
        return this.f276O80Oo0O;
    }

    public ExportMode getExportMode() {
        return this.f274O8oO888;
    }

    public float getFov() {
        return this.f278oo0OOO8;
    }

    public int getHeight() {
        return this.f275OO8;
    }

    public float getPitch() {
        return this.f277o0o8;
    }

    public String getStabilizerCacheRootPath() {
        return this.f284oO;
    }

    public String getTargetPath() {
        return this.f281O8;
    }

    public String getUrlForExport() {
        return this.f280O;
    }

    public int getWidth() {
        return this.f27900oOOo;
    }

    public float getYaw() {
        return this.Oo;
    }

    public boolean isDynamicStitch() {
        return this.f286;
    }

    public boolean isStabEnabled() {
        return this.f285o0O0O;
    }

    public ExportImageParamsBuilder setCacheCutSceneRootPath(String str) {
        this.Oo0 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ExportImageParamsBuilder setCacheWorkThumbnailRootPath(String str) {
        this.f283o0o0 = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ExportImageParamsBuilder setCameraType(String str) {
        this.f282Ooo = str;
        return this;
    }

    public ExportImageParamsBuilder setDistance(float f2) {
        this.f276O80Oo0O = f2;
        return this;
    }

    public ExportImageParamsBuilder setDynamicStitch(boolean z) {
        this.f286 = z;
        return this;
    }

    public ExportImageParamsBuilder setExportMode(ExportMode exportMode) {
        this.f274O8oO888 = exportMode;
        return this;
    }

    public ExportImageParamsBuilder setFov(float f2) {
        this.f278oo0OOO8 = f2;
        return this;
    }

    public ExportImageParamsBuilder setHeight(int i2) {
        this.f275OO8 = i2;
        return this;
    }

    public ExportImageParamsBuilder setPitch(float f2) {
        this.f277o0o8 = f2;
        return this;
    }

    public ExportImageParamsBuilder setStabEnabled(boolean z) {
        this.f285o0O0O = z;
        return this;
    }

    public ExportImageParamsBuilder setStabilizerCacheRootPath(String str) {
        this.f284oO = str;
        FileUtils.createDirectoryIfNeeded(str);
        return this;
    }

    public ExportImageParamsBuilder setTargetPath(String str) {
        this.f281O8 = str;
        FileUtils.createDirectoryIfNeeded(new File(this.f281O8).getParent());
        return this;
    }

    public ExportImageParamsBuilder setUrlForExport(String str) {
        this.f280O = str;
        return this;
    }

    public ExportImageParamsBuilder setWidth(int i2) {
        this.f27900oOOo = i2;
        return this;
    }

    public ExportImageParamsBuilder setYaw(float f2) {
        this.Oo = f2;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("ExportMode: ");
        a2.append(this.f274O8oO888);
        a2.append(", CameraType: ");
        a2.append(this.f282Ooo);
        a2.append(", TargetPath: ");
        a2.append(this.f281O8);
        a2.append(", CacheWorkPath: ");
        a2.append(this.f283o0o0);
        a2.append(", StabilizerPath: ");
        a2.append(this.f284oO);
        a2.append(", CacheCutScenePath: ");
        a2.append(this.Oo0);
        a2.append(", UrlForExport: ");
        a2.append(this.f280O);
        a2.append(", isStabEnabled: ");
        a2.append(this.f285o0O0O);
        a2.append(", isDynamicStitch: ");
        a2.append(this.f286);
        a2.append(", width: ");
        a2.append(this.f27900oOOo);
        a2.append(", height: ");
        a2.append(this.f275OO8);
        a2.append(", fov: ");
        a2.append(this.f278oo0OOO8);
        a2.append(", distance: ");
        a2.append(this.f276O80Oo0O);
        a2.append(", yaw: ");
        a2.append(this.Oo);
        a2.append(", pitch: ");
        a2.append(this.f277o0o8);
        return a2.toString();
    }
}
