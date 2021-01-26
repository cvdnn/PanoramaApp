package com.arashivision.insta360.basemedia.export.task.single.params.video;

import a.a.a.a.c.a.d.d.a.a;
import a.a.a.a.c.a.d.d.a.b;
import a.a.a.a.c.a.d.d.a.c;
import com.arashivision.insta360.basemedia.util.MD5Util;
import java.util.ArrayList;
import java.util.List;

public class SimpleExportVideoParams implements IExportVideoParams {
    public boolean I11li1 = false;
    public int I1I;
    public String IL1Iii;
    public int ILL = 0;
    public int ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f32ILl = false;
    public int Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public int f33IL = 30;

    /* renamed from: I丨iL reason: contains not printable characters */
    public int f34IiL = 0;
    public boolean Lil = true;
    public boolean LlLI1 = false;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public int f35Ll1 = 0;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public String f36L11I;
    public c iIi1 = null;
    public float iIlLiL = 0.0f;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public int f37iILLL1 = 0;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public boolean f38lIiI = false;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public b f39lIlii = new a();

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public List<Long> f40llL1ii = new ArrayList();

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f41lLi1LL = false;

    /* renamed from: 丨il reason: contains not printable characters */
    public String f42il;

    public int getBitrate() {
        return this.Ilil;
    }

    public int getFps() {
        return this.f33IL;
    }

    public b getFrameInput() {
        return this.f39lIlii;
    }

    public List<Long> getFrameTimestampList() {
        return this.f40llL1ii;
    }

    public int getHeight() {
        return this.I1I;
    }

    public c getImageDownloader() {
        return this.iIi1;
    }

    public String getMetaDataMake() {
        return this.f36L11I;
    }

    public String getMetaDataModel() {
        return this.f42il;
    }

    public int getMp4Type() {
        return this.f34IiL;
    }

    public String getPath() {
        return this.IL1Iii;
    }

    public int getPriorityFpsDen() {
        return this.f35Ll1;
    }

    public int getPriorityFpsNum() {
        return this.ILL;
    }

    public int getRenderModelType() {
        return this.f37iILLL1;
    }

    public float getStarrySkyK() {
        return this.iIlLiL;
    }

    public int getWidth() {
        return this.ILil;
    }

    public boolean isApplyFlash() {
        return this.I11li1;
    }

    public boolean isApplyWatermark() {
        return this.Lil;
    }

    public boolean isStarrySkyEnabled() {
        return this.LlLI1;
    }

    public boolean isTurnBack() {
        return this.f41lLi1LL;
    }

    public boolean isUseSoftwareDecoder() {
        return this.f38lIiI;
    }

    public boolean isUseSoftwareEncoder() {
        return this.f32ILl;
    }

    public String md5Key() {
        StringBuilder a2 = e.a.a.a.a.a("SimpleExportVideoParams{mWidth=");
        a2.append(this.ILil);
        a2.append(", mHeight=");
        a2.append(this.I1I);
        a2.append(", mFps=");
        a2.append(this.f33IL);
        a2.append(", mBitrate=");
        a2.append(this.Ilil);
        a2.append(", mRenderModelType=");
        a2.append(this.f37iILLL1);
        a2.append(", mFrameTimestampList=");
        a2.append(this.f40llL1ii);
        a2.append(", mIsTurnBack=");
        a2.append(this.f41lLi1LL);
        a2.append('}');
        return MD5Util.getMD5String(a2.toString());
    }

    public void setApplyFlash(boolean z) {
        this.I11li1 = z;
    }

    public void setApplyWatermark(boolean z) {
        this.Lil = z;
    }

    public void setBitrate(int i2) {
        this.Ilil = i2;
    }

    public void setFps(int i2) {
        this.f33IL = i2;
    }

    public void setFrameInput(b bVar) {
        this.f39lIlii = bVar;
    }

    public void setFrameTimestampList(List<Long> list) {
        this.f40llL1ii = list;
    }

    public void setHeight(int i2) {
        this.I1I = i2;
    }

    public void setImageDownloader(c cVar) {
        this.iIi1 = cVar;
    }

    public void setMetaDataMake(String str) {
        this.f36L11I = str;
    }

    public void setMetaDataModel(String str) {
        this.f42il = str;
    }

    public void setMp4Type(int i2) {
        this.f34IiL = i2;
    }

    public void setPath(String str) {
        this.IL1Iii = str;
    }

    public void setPriorityFpsDen(int i2) {
        this.f35Ll1 = i2;
    }

    public void setPriorityFpsNum(int i2) {
        this.ILL = i2;
    }

    public void setRenderModelType(int i2) {
        this.f37iILLL1 = i2;
    }

    public void setStarrySkyEnabled(boolean z) {
        this.LlLI1 = z;
    }

    public void setStarrySkyK(float f2) {
        this.iIlLiL = f2;
    }

    public void setTurnBack(boolean z) {
        this.f41lLi1LL = z;
    }

    public void setUseSoftwareDecoder(boolean z) {
        this.f38lIiI = z;
    }

    public void setUseSoftwareEncoder(boolean z) {
        this.f32ILl = z;
    }

    public void setWidth(int i2) {
        this.ILil = i2;
    }
}
