package com.arashivision.insta360.basemedia.export.task.single.params.image;

import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.util.MD5Util;
import java.util.HashMap;

public class SimpleExportImageParams implements IExportImageParams {
    public int I1I;
    public String IL1Iii;
    public long ILL = -1;
    public int ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f23ILl = true;
    public boolean Ilil = false;

    /* renamed from: I丨L reason: contains not printable characters */
    public int f24IL = 0;

    /* renamed from: I丨iL reason: contains not printable characters */
    public HashMap<String, String> f25IiL = new HashMap<>();

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public boolean f26Ll1 = false;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public boolean f27L11I = false;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public HashMap<String, String> f28iILLL1 = new HashMap<>();

    /* renamed from: lIi丨I reason: contains not printable characters */
    public boolean f29lIiI = true;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public Transform f30lLi1LL;

    /* renamed from: 丨il reason: contains not printable characters */
    public boolean f31il = true;

    public void addExifInfo(String str, String str2) {
        this.f28iILLL1.put(str, str2);
    }

    public void addXmpInfo(String str, String str2) {
        this.f25IiL.put(str, str2);
    }

    public final SimpleExportImageParams clone() {
        try {
            return (SimpleExportImageParams) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> getExifInfo() {
        return this.f28iILLL1;
    }

    public long getExportTimestamp() {
        return this.ILL;
    }

    public int getHeight() {
        return this.I1I;
    }

    public String getIdenticalKey() {
        Transform transform = getTransform();
        StringBuilder sb = new StringBuilder();
        sb.append(getWidth());
        sb.append(getHeight());
        sb.append(getRenderModelType());
        Object obj = "";
        sb.append(isUseTransform() ? Float.valueOf(transform.getFov()) : obj);
        sb.append(isUseTransform() ? Float.valueOf(transform.getDistance()) : obj);
        sb.append(isUseTransform() ? Float.valueOf(transform.getYaw()) : obj);
        if (isUseTransform()) {
            obj = Float.valueOf(transform.getPitch());
        }
        sb.append(obj);
        sb.append(isApplyWatermark());
        sb.append(getExportTimestamp());
        return MD5Util.getMD5String(sb.toString());
    }

    public String getPath() {
        return this.IL1Iii;
    }

    public int getRenderModelType() {
        return this.f24IL;
    }

    public Transform getTransform() {
        return this.f30lLi1LL;
    }

    public int getWidth() {
        return this.ILil;
    }

    public HashMap<String, String> getXmpInfo() {
        return this.f25IiL;
    }

    public boolean isAccurateSeek() {
        return this.f29lIiI;
    }

    public boolean isApplyStabilizer() {
        return this.f23ILl;
    }

    public boolean isApplyWatermark() {
        return this.f31il;
    }

    public boolean isUseOriginalOutput() {
        return this.f26Ll1;
    }

    public boolean isUseSoftwareDecoder() {
        return this.f27L11I;
    }

    public boolean isUseTransform() {
        return this.Ilil;
    }

    public void setAccurateSeek(boolean z) {
        this.f29lIiI = z;
    }

    public void setApplyStabilizer(boolean z) {
        this.f23ILl = z;
    }

    public void setApplyWatermark(boolean z) {
        this.f31il = z;
    }

    public void setExportTimestamp(long j2) {
        this.ILL = j2;
    }

    public void setHeight(int i2) {
        this.I1I = i2;
    }

    public void setPath(String str) {
        this.IL1Iii = str;
    }

    public void setRenderModelType(int i2) {
        this.f24IL = i2;
    }

    public void setTransform(Transform transform) {
        this.f30lLi1LL = transform;
    }

    public void setUseOriginalOutput(boolean z) {
        this.f26Ll1 = z;
    }

    public void setUseSoftwareDecoder(boolean z) {
        this.f27L11I = z;
    }

    public void setUseTransform(boolean z) {
        this.Ilil = z;
    }

    public void setWidth(int i2) {
        this.ILil = i2;
    }
}
