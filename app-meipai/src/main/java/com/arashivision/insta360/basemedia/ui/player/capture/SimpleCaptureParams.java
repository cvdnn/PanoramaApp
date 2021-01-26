package com.arashivision.insta360.basemedia.ui.player.capture;

import a.a.a.a.a.g.a;
import a.a.a.a.e.a.g.f;
import a.a.a.a.e.a.h.b;
import android.text.TextUtils;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.util.ArrayList;
import java.util.List;

public class SimpleCaptureParams implements ICaptureParams {
    public int I11L = -1;
    public long I11li1;
    public boolean I1I;
    public String IL1Iii;
    public int ILL;
    public String ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f75ILl;
    public AssetInfo Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public boolean f76IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public float f77IiL;
    public Constraint Lil;
    public int LlLI1;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public int f78Ll1;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public int f79L11I;
    public FileType iIi1;
    public int iIlLiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public a f80iILLL1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public boolean f81lIiI;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public int f82lIlii = -1;
    public List<b> llliI = new ArrayList();

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public int f83llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f84lLi1LL;

    /* renamed from: 丨il reason: contains not printable characters */
    public int[] f85il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public int f86lL = -1;

    public boolean cancelStabilizer() {
        return false;
    }

    public SimpleCaptureParams clone() {
        try {
            return (SimpleCaptureParams) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public BMGStabilizer createStabilizer(boolean z) {
        return null;
    }

    public List<a.a.a.a.a.b.a> getAAADataList() {
        return null;
    }

    public AssetInfo getAssetInfo() {
        return this.Ilil;
    }

    public int getBeautyFilterLevel() {
        return this.f79L11I;
    }

    public int getCameraFacing() {
        return this.f82lIlii;
    }

    public String getCameraType() {
        return this.IL1Iii;
    }

    public Constraint getConstraint() {
        return this.Lil;
    }

    public int[] getConstraintRatio() {
        if (getFileType() == FileType.UNPANORAMA) {
            return null;
        }
        return this.f85il;
    }

    public float getContrastIntensity() {
        return 0.0f;
    }

    public FileType getFileType() {
        return this.iIi1;
    }

    public int getFitMode() {
        return this.iIlLiL;
    }

    public int getFps() {
        return this.ILL;
    }

    public int getGyroType() {
        return this.LlLI1;
    }

    public int getHeight() {
        return this.I11L;
    }

    public LogoInfo getLogoInfo() {
        return null;
    }

    public String[] getLrvUrlsForPlay() {
        return new String[0];
    }

    public a.a.a.a.a.d.a getLutFilter() {
        return null;
    }

    public String getOffsetForPlay() {
        return this.ILil;
    }

    public long getPreviewDelayNs() {
        return this.I11li1;
    }

    public int getRotateDegree() {
        return this.f78Ll1;
    }

    public int[] getScreenRatio() {
        return this.f85il;
    }

    public float getSharpnessIntensity() {
        return 0.0f;
    }

    public int getStabType() {
        return this.f83llL1ii;
    }

    public BMGStabilizer getStabilizer() {
        return null;
    }

    public StabilizingType getStabilizingType() {
        return null;
    }

    public a getStyleFilter() {
        return this.f80iILLL1;
    }

    public float getStyleFilterIntensity() {
        return this.f77IiL;
    }

    public List<b> getViewDecorationList() {
        return this.llliI;
    }

    public f getWatermarkRectCalculator() {
        return null;
    }

    public String getWatermarkResourcesPath() {
        return null;
    }

    public int getWidth() {
        return this.f86lL;
    }

    public boolean hasOffsetForPlay() {
        return !TextUtils.isEmpty(this.ILil);
    }

    public boolean isColorAdjustEnabled() {
        return false;
    }

    public boolean isDenoise() {
        return false;
    }

    public boolean isDualStream() {
        return this.f76IL;
    }

    public boolean isImageFusion() {
        return false;
    }

    public boolean isInstaMedia() {
        return this.I1I;
    }

    public boolean isLogoEnabled() {
        return this.f84lLi1LL;
    }

    public boolean isRotateEnabled() {
        return this.f81lIiI;
    }

    public boolean isRotateScreenRatioEnabled() {
        return this.f75ILl;
    }

    public boolean isVideo() {
        return true;
    }

    public boolean isWatermarkEnabled() {
        return false;
    }

    public boolean loadStabilizer(a.a.a.a.a.e.a aVar) {
        return false;
    }

    public void setAssetInfo(AssetInfo assetInfo) {
        this.Ilil = assetInfo;
    }

    public void setBeautyFilterLevel(int i2) {
        this.f79L11I = i2;
    }

    public void setCameraFacing(int i2) {
        this.f82lIlii = i2;
    }

    public void setCameraType(String str) {
        this.IL1Iii = str;
    }

    public void setColorAdjustEnabled(boolean z) {
    }

    public void setConstraint(Constraint constraint) {
        this.Lil = constraint;
    }

    public void setConstraintRatio(int[] iArr) {
    }

    public void setContrastIntensity(float f2) {
    }

    public void setDenoise(boolean z) {
    }

    public void setDualStream(boolean z) {
        this.f76IL = z;
    }

    public void setFileType(FileType fileType) {
        this.iIi1 = fileType;
    }

    public void setFitMode(int i2) {
        this.iIlLiL = i2;
    }

    public void setFps(int i2) {
        this.ILL = i2;
    }

    public void setGyroType(int i2) {
        this.LlLI1 = i2;
    }

    public void setHeight(int i2) {
        this.I11L = i2;
    }

    public void setImageFusion(boolean z) {
    }

    public void setInstaMedia(boolean z) {
        this.I1I = z;
    }

    public void setLogoEnabled(boolean z) {
        this.f84lLi1LL = z;
    }

    public void setLutFilter(a.a.a.a.a.d.a aVar) {
    }

    public void setOffsetForPlay(String str) {
        this.ILil = str;
    }

    public void setPreviewDelayNs(long j2) {
        this.I11li1 = j2;
    }

    public void setRotateDegree(int i2) {
        this.f78Ll1 = i2;
    }

    public void setRotateEnabled(boolean z) {
        this.f81lIiI = z;
    }

    public void setRotateScreenRatioEnabled(boolean z) {
        this.f75ILl = z;
    }

    public void setScreenRatio(int[] iArr) {
        this.f85il = iArr;
    }

    public void setSharpnessIntensity(float f2) {
    }

    public void setStabType(int i2) {
        this.f83llL1ii = i2;
    }

    public void setStyleFilter(a aVar) {
        this.f80iILLL1 = aVar;
    }

    public void setStyleFilterIntensity(float f2) {
        this.f77IiL = f2;
    }

    public void setViewDecorationList(List<b> list) {
        this.llliI = list;
    }

    public void setWidth(int i2) {
        this.f86lL = i2;
    }

    public void updateStabilizer(int i2) {
    }
}
