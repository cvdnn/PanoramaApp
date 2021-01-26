package com.arashivision.insta360.basemedia.ui.player.video;

import a.a.a.a.e.a.c.k;
import a.a.a.a.e.a.e.k.i.a;
import a.a.a.a.e.a.g.c;
import a.a.a.a.e.a.i.b;
import a.a.a.a.e.a.i.d;
import a.a.a.a.e.a.i.e;
import a.a.a.a.e.a.i.g;
import a.a.a.a.e.a.i.h;
import a.a.a.a.e.a.l.f;
import android.text.TextUtils;
import com.arashivision.arvbmg.exporter.ExporterClip.ExporterTimeScale;
import com.arashivision.arvbmg.exporter.VideoTimePicker;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;
import com.arashivision.graphicpath.insmedia.previewer2.VideoTimePicker.VideoTimeSequence;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insbase.nativeref.NativeBuffer;
import com.arashivision.insta360.basemedia.MediaModule;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.model.work.LocalWork;
import com.arashivision.insta360.basemedia.model.work.Work;
import com.arashivision.insta360.basemedia.util.EventIdUtils;
import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.insta360.basemedia.util.MD5Util;
import e.b.c.b.b.a.d.o;
import java.io.File;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleVideoParams implements IVideoParams, Serializable {
    public static final MediaLogger ILI1Ll = MediaLogger.getLogger(SimpleVideoParams.class);
    public String I1;
    public boolean I11L;
    public int I11li1;
    public double I1I;
    public List<b> I1IILIIL;

    /* renamed from: I1L丨11L reason: contains not printable characters */
    public double f164I1L11L;

    /* renamed from: IIi丨丨I reason: contains not printable characters */
    public boolean f165IIiI;
    public Work IL1Iii;
    public boolean ILL;

    /* renamed from: ILL丨Ii reason: contains not printable characters */
    public Constraint f166ILLIi;
    public String[] ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f167ILl;
    public byte[] Ilil = null;

    /* renamed from: I丨 reason: contains not printable characters */
    public double f168I;

    /* renamed from: I丨Ii reason: contains not printable characters */
    public boolean f169IIi;

    /* renamed from: I丨L reason: contains not printable characters */
    public double f170IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public byte[] f171IiL;

    /* renamed from: L11丨 reason: contains not printable characters */
    public float f172L11;

    /* renamed from: L11丨丨丨1 reason: contains not printable characters */
    public float f173L111;
    public long L1iI1;
    public e LI11;

    /* renamed from: LI丨l reason: contains not printable characters */
    public boolean f174LIl;

    /* renamed from: LI丨丨l丨l reason: contains not printable characters */
    public int f175LIll;
    public a LL;
    public float LL1IL;
    public List<h> LLL;
    public List<a.a.a.a.e.a.i.a> LiL1;
    public List<a.a.a.a.e.a.h.b> Liil1L1l;
    public boolean Lil;

    /* renamed from: LlIl丨 reason: contains not printable characters */
    public int f176LlIl;
    public BMGStabilizer LlLI1;

    /* renamed from: LlLiL丨L丨 reason: contains not printable characters */
    public int f177LlLiLL;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public String f178Ll1;

    /* renamed from: L丨1l reason: contains not printable characters */
    public boolean f179L1l;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public byte[] f180L11I;

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public float f181LlLLL;
    public int[] i1;
    public boolean iI;

    /* renamed from: iI1i丨I reason: contains not printable characters */
    public double f182iI1iI;
    public String iIi1;
    public f.a iIilII1;

    /* renamed from: iIl1il丨 reason: contains not printable characters */
    public int f183iIl1il;
    public int iIlLiL;

    /* renamed from: iI丨1LI reason: contains not printable characters */
    public String f184iI1LI;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public byte[] f185iILLL1;

    /* renamed from: iI丨Li丨lI reason: contains not printable characters */
    public boolean f186iILilI;

    /* renamed from: iiIIi丨11 reason: contains not printable characters */
    public List<g> f187iiIIi11;

    /* renamed from: ili丨11 reason: contains not printable characters */
    public int f188ili11;
    public boolean ill1LI1l;

    /* renamed from: il丨l丨 reason: contains not printable characters */
    public float f189ill;

    /* renamed from: i丨1I1I1l reason: contains not printable characters */
    public List<d> f190i1I1I1l;

    /* renamed from: i丨ILiiLl reason: contains not printable characters */
    public String f191iILiiLl;

    /* renamed from: l1IIi1丨 reason: contains not printable characters */
    public boolean f192l1IIi1;
    public long[] l1Lll;

    /* renamed from: lIIiIlL丨 reason: contains not printable characters */
    public boolean f193lIIiIlL;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public File f194lIiI;

    /* renamed from: lI丨II reason: contains not printable characters */
    public int f195lIII;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public FileType f196lIlii;
    public float lL;
    public String llI;
    public boolean llliI;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public List<c> f197llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public byte[] f198lLi1LL = null;

    /* renamed from: l丨liiI1 reason: contains not printable characters */
    public float f199lliiI1;

    /* renamed from: l丨丨i11 reason: contains not printable characters */
    public int[] f200li11;

    /* renamed from: 丨1 reason: contains not printable characters */
    public String f2011;

    /* renamed from: 丨i1丨1i reason: contains not printable characters */
    public long f202i11i;

    /* renamed from: 丨i1丨1丨LL reason: contains not printable characters */
    public float f203i11LL;

    /* renamed from: 丨iI丨丨LLl reason: contains not printable characters */
    public boolean f204iILLl;

    /* renamed from: 丨il reason: contains not printable characters */
    public String[] f205il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public int f206lL;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public a.a.a.a.a.d.a f207l;

    /* renamed from: 丨丨 reason: contains not printable characters */
    public a.a.a.a.e.a.g.f f208;

    /* renamed from: 丨丨LLlI1 reason: contains not printable characters */
    public boolean f209LLlI1;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public a.a.a.a.a.g.a f2101;

    /* renamed from: 丨丨丨丨 reason: contains not printable characters */
    public boolean f211;

    public SimpleVideoParams(Work work) {
        EventIdUtils.getEventId();
        this.IL1Iii = work;
        String str = "";
        this.f2011 = str;
        this.f185iILLL1 = null;
        this.f171IiL = null;
        this.f180L11I = null;
        this.f205il = work.getUrlsForPlay();
        this.ILL = true;
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getCacheFolder());
        sb.append("/stabilizer/");
        this.f178Ll1 = sb.toString();
        this.f194lIiI = new File(IL1Iii());
        this.f167ILl = false;
        this.Lil = false;
        this.LlLI1 = null;
        this.f197llL1ii = null;
        this.f196lIlii = this.IL1Iii.getFileType();
        this.iIi1 = this.IL1Iii.getOffset();
        this.iIlLiL = this.IL1Iii.getStabType();
        this.I11li1 = 0;
        this.f206lL = -1;
        this.I11L = this.IL1Iii.isSelfie();
        this.llliI = this.IL1Iii.isLogoEnabled();
        this.f207l = this.IL1Iii.getLutFilter();
        this.f2101 = this.IL1Iii.getStyleFilter();
        this.f181LlLLL = this.IL1Iii.getStyleFilterIntensity();
        this.f195lIII = this.IL1Iii.getBeautyFilterLevel();
        this.LL1IL = 0.0f;
        this.f173L111 = 0.0f;
        this.f209LLlI1 = false;
        this.f208 = o.f5815a;
        this.llI = str;
        this.f168I = 1.0d;
        this.ill1LI1l = false;
        this.f193lIIiIlL = false;
        this.f192l1IIi1 = true;
        this.f179L1l = false;
        this.f204iILLl = false;
        this.f169IIi = false;
        this.f175LIll = 0;
        this.f189ill = 0.0f;
        this.f211 = false;
        this.f172L11 = 0.0f;
        this.f176LlIl = 0;
        this.f165IIiI = false;
        this.f199lliiI1 = -1.0f;
        this.f203i11LL = 1.0f;
        this.f183iIl1il = 0;
        if (getFileType() == FileType.UNPANORAMA) {
            int width = getWidth();
            int height = getHeight();
            if (width <= 0 || height <= 0) {
                this.i1 = new int[]{1, 1};
            } else {
                this.i1 = a.a.a.a.e.a.l.d.a(new int[]{width, height});
            }
        } else {
            this.i1 = new int[]{-1, -1};
        }
        int rotateDegree = this.IL1Iii.getRotateDegree();
        this.f188ili11 = rotateDegree;
        boolean z = rotateDegree != 0;
        this.f174LIl = z;
        this.iI = z;
        this.f177LlLiLL = 1;
        this.LLL = new ArrayList();
        this.f182iI1iI = -1.0d;
        this.f164I1L11L = -1.0d;
        this.I1 = str;
        this.f202i11i = -1;
        this.lL = 0.0f;
        this.l1Lll = new long[]{0, 0};
        this.L1iI1 = 0;
        this.I1IILIIL = new ArrayList();
        this.f187iiIIi11 = new ArrayList();
        this.f186iILilI = false;
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f166ILLIi = constraint;
        this.f200li11 = new int[]{-1, -1};
        this.LiL1 = new ArrayList();
        this.iIilII1 = null;
        this.Liil1L1l = new ArrayList();
        this.LL = null;
        this.f190i1I1I1l = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(MediaModule.getCacheFolder());
        sb2.append("cutscene/video/");
        this.f184iI1LI = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(MediaModule.getCacheFolder());
        sb3.append("work/thumbnail/");
        sb3.append(FileUtils.removeFileExtension(work.getName()));
        sb3.append(".jpg");
        this.f2011 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(MediaModule.getCacheFolder());
        sb4.append("proxy/");
        sb4.append(FileUtils.removeFileExtension(work.getName()));
        this.f191iILiiLl = sb4.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(a.a.a.a.a.e.a aVar, long j2, long j3) {
        boolean z;
        MediaLogger mediaLogger = ILI1Ll;
        StringBuilder a2 = e.a.a.a.a.a("load stabilizer, progress: ", j2, " / ");
        a2.append(j3);
        mediaLogger.d(a2.toString());
        if (j2 == j3) {
            ILI1Ll.d("stabilizer load finish");
            z = true;
        } else {
            z = false;
        }
        this.Lil = z;
        if (aVar != null) {
            aVar.IL1Iii(j2, j3);
        }
    }

    public static /* synthetic */ float[] IL1Iii(int i2, int i3, int i4, int i5) {
        return new float[]{200.0f, 100.0f, 0.0f, 0.0f};
    }

    public final String IL1Iii() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f178Ll1);
        sb.append(FileUtils.removeFileExtension(this.IL1Iii.getName()));
        sb.append(isSelfie() == this.IL1Iii.isSelfie() ? "" : "-fpv");
        return sb.toString();
    }

    public void addReference(a.a.a.a.a.f.e.a aVar) {
        a.a.a.a.a.f.e.b.a().a(this.IL1Iii, aVar);
    }

    public synchronized boolean cancelStabilizer() {
        boolean z;
        BMGStabilizer bMGStabilizer = this.LlLI1;
        if (bMGStabilizer == null) {
            z = false;
        } else {
            if (bMGStabilizer instanceof BMGSequenceStabilizer) {
                ((BMGSequenceStabilizer) bMGStabilizer).cancelLoad();
            } else {
                boolean z2 = bMGStabilizer instanceof BMGSingleGyroStabilizer;
            }
            z = true;
        }
        return z;
    }

    public final SimpleVideoParams clone() {
        try {
            SimpleVideoParams simpleVideoParams = (SimpleVideoParams) super.clone();
            ArrayList arrayList = new ArrayList();
            for (a.a.a.a.e.a.h.b a2 : this.Liil1L1l) {
                arrayList.add(a2.a());
            }
            simpleVideoParams.Liil1L1l = arrayList;
            return simpleVideoParams;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean containsBgmData() {
        if (!TextUtils.isEmpty(this.I1) && this.f202i11i >= 0 && this.L1iI1 >= 0) {
            float f2 = this.lL;
            if (f2 >= 0.0f && f2 <= 1.0f) {
                return true;
            }
        }
        return false;
    }

    public boolean containsRecordListData() {
        List<h> list = this.LLL;
        return list != null && list.size() > 0;
    }

    public boolean containsSpeedSectionListData() {
        if (this.f187iiIIi11 == null) {
            return false;
        }
        double speedFactor = getSpeedFactor();
        for (g gVar : this.f187iiIIi11) {
            if (gVar.f612c != speedFactor) {
                return true;
            }
        }
        return false;
    }

    public boolean containsTrimEndData() {
        double d2 = this.f164I1L11L;
        return d2 > 0.0d && d2 > this.f182iI1iI;
    }

    public boolean containsTrimStartData() {
        return this.f182iI1iI > 0.0d;
    }

    public synchronized BMGStabilizer createStabilizer(boolean z) {
        NativeBuffer nativeBuffer;
        if (!this.f167ILl) {
            Work work = this.IL1Iii;
            if (isUseStabilizerCache()) {
                File file = this.f194lIiI;
                if (file != null && file.exists()) {
                    nativeBuffer = FileUtils.readNativeBufferFromFile(this.f194lIiI);
                    BMGSequenceStabilizer sequenceStabilizer = work.getSequenceStabilizer(z, nativeBuffer, new k(this));
                    this.LlLI1 = sequenceStabilizer;
                    if (sequenceStabilizer == null && this.IL1Iii.isInstaMedia()) {
                        this.LlLI1 = this.IL1Iii.getSingleStabilizer(new k(this));
                    }
                    this.f167ILl = true;
                }
            }
            nativeBuffer = null;
            BMGSequenceStabilizer sequenceStabilizer2 = work.getSequenceStabilizer(z, nativeBuffer, new k(this));
            this.LlLI1 = sequenceStabilizer2;
            this.LlLI1 = this.IL1Iii.getSingleStabilizer(new k(this));
            this.f167ILl = true;
        }
        return this.LlLI1;
    }

    public List<a.a.a.a.a.b.a> getAAADataList() {
        byte[] bArr = this.f180L11I;
        if (bArr == null) {
            ILI1Ll.e("getAAADataList, but mAAABytes is null, maybe loadAAA() is not called or this source does not contains ISO data");
            return new ArrayList();
        }
        int aAAItemSize = Asset.getAAAItemSize();
        ArrayList arrayList = new ArrayList();
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int limit = order.limit();
        while (order.position() + aAAItemSize <= limit) {
            a.a.a.a.a.b.a aVar = new a.a.a.a.a.b.a();
            order.getInt();
            order.getFloat();
            order.getFloat();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            order.getInt();
            arrayList.add(aVar);
        }
        int i2 = 40;
        Iterator it = arrayList.iterator();
        while (it.hasNext() && i2 > 0) {
            i2--;
            it.next();
            it.remove();
        }
        return arrayList;
    }

    public AssetInfo getAssetInfo() {
        AssetInfo assetInfo = this.IL1Iii.getAssetInfo();
        assetInfo.offset = getOffsetForPlay();
        assetInfo.isSelfie = Boolean.valueOf(isSelfie());
        return assetInfo;
    }

    public List<b> getAudioEffectList() {
        return this.I1IILIIL;
    }

    public int getBeautyFilterLevel() {
        return this.f195lIII;
    }

    public long getBgmDuration() {
        return this.f202i11i;
    }

    public long getBgmOffset() {
        return this.L1iI1;
    }

    public long[] getBgmRange() {
        return this.l1Lll;
    }

    public String getBgmUrl() {
        return this.I1;
    }

    public float getBgmWeight() {
        return this.lL;
    }

    public int getBitrate() {
        return this.IL1Iii.getBitrate();
    }

    public float getBlendAngleRad() {
        return this.f199lliiI1;
    }

    public String getCacheCutSceneVideoPath() {
        return this.f184iI1LI;
    }

    public String getCacheVideoProxyRootPath() {
        return this.f191iILiiLl;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f2011;
    }

    public int getCameraFacing() {
        return this.f206lL;
    }

    public String getCameraType() {
        return this.IL1Iii.getCameraType();
    }

    public Constraint getConstraint() {
        if (getFileType() == FileType.UNPANORAMA) {
            return null;
        }
        return this.f166ILLIi;
    }

    public int[] getConstraintRatio() {
        if (getFileType() == FileType.UNPANORAMA) {
            return null;
        }
        return Arrays.equals(this.f200li11, new int[]{-1, -1}) ? this.i1 : this.f200li11;
    }

    public float getContrastIntensity() {
        return this.LL1IL;
    }

    public long getCreationTime() {
        return this.IL1Iii.getCreationTime();
    }

    public int getDenoiseLevel() {
        return this.f175LIll;
    }

    public double getDurationInMs() {
        return isVideo() ? (double) this.IL1Iii.getDurationInMs() : this.f170IL;
    }

    public List<a.a.a.a.a.c.a> getExposureDataList() {
        byte[] bArr = this.f185iILLL1;
        if (bArr == null) {
            ILI1Ll.e("getAAADataList, but mAAABytes is null, maybe loadAAA() is not called or this source does not contains ISO data");
            return new ArrayList();
        }
        int rawExposureItemSize = Asset.getRawExposureItemSize();
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        ArrayList arrayList = new ArrayList();
        int length = bArr.length / rawExposureItemSize;
        for (int i2 = 0; i2 < length; i2++) {
            a.a.a.a.a.c.a aVar = new a.a.a.a.a.c.a();
            order.getLong();
            order.getDouble();
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public long[] getExtraInfoPos() {
        int i2 = 0;
        if (Arrays.equals(this.f205il, this.IL1Iii.getUrlsForPlay())) {
            String[] urlsForPlay = this.IL1Iii.getUrlsForPlay();
            long[] jArr = new long[urlsForPlay.length];
            while (i2 < urlsForPlay.length) {
                jArr[i2] = i2 == 0 ? this.IL1Iii.getExtraInfoPos() : 0;
                i2++;
            }
            return jArr;
        }
        long[] jArr2 = new long[this.f205il.length];
        while (i2 < this.f205il.length) {
            jArr2[i2] = 0;
            i2++;
        }
        return jArr2;
    }

    public FileType getFileType() {
        return this.f196lIlii;
    }

    public long getFirstFrameTimeStamp() {
        return this.IL1Iii.getFirstFrameTimeStamp();
    }

    public long getFirstGpsTimeStamp() {
        return this.IL1Iii.getFirstGpsTimeStamp();
    }

    public long getFirstGpsTimeStampFormatted(List<a.a.a.a.a.a.a> list) {
        return this.IL1Iii.getFirstGpsTimeStampFormatted(list);
    }

    public int getFitMode() {
        return this.f177LlLiLL;
    }

    public List<a.a.a.a.e.a.i.a> getFlashDataList() {
        return this.LiL1;
    }

    public e getFlashEffect() {
        return this.LI11;
    }

    public double getFps() {
        return isVideo() ? this.IL1Iii.getFps() : this.I1I;
    }

    public int getFrameCount() {
        return this.f183iIl1il;
    }

    public a.a.a.a.b.d getGps() {
        return this.IL1Iii.getGps();
    }

    public double getGyroDelayTime() {
        return this.IL1Iii.getGyroDelayTime();
    }

    public int getHDREffectLevel() {
        return this.f176LlIl;
    }

    public float getHDRStrength() {
        return this.f172L11;
    }

    public int getHeight() {
        return this.IL1Iii.getHeight();
    }

    public int getHeightOrigin() {
        return this.IL1Iii.getHeightOrigin();
    }

    public String getIdenticalKey() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(getOffsetForPlay());
        sb.append(getStabType());
        String str2 = "";
        sb.append(isLogoEnabled() ? getLogoInfo().getLogoAsset().getName() : str2);
        if (((a.a.a.a.a.g.b) getStyleFilter()) != null) {
            sb.append("Original");
            sb.append(getBeautyFilterLevel());
            if (((a.a.a.a.a.d.b) getLutFilter()) != null) {
                sb.append("LutOff");
                sb.append(isMotionBlur());
                sb.append(isDrifterOptimize());
                List<h> list = this.LLL;
                if (!(list == null || list.size() == 0)) {
                    StringBuilder sb2 = new StringBuilder();
                    for (h hVar : this.LLL) {
                        if (hVar != null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(hVar.f614b);
                            sb3.append(hVar.f618f);
                            sb3.append(hVar.f616d);
                            List<a.a.a.a.e.a.i.f.e> list2 = hVar.f617e;
                            if (list2 != null) {
                                for (a.a.a.a.e.a.i.f.e eVar : list2) {
                                    sb3.append(eVar.f602a);
                                    sb3.append(eVar.f608g);
                                    sb3.append(eVar.f603b);
                                    sb3.append(eVar.f607f);
                                    sb3.append(eVar.f606e);
                                    sb3.append(eVar.f605d);
                                    sb3.append(eVar.f604c);
                                    double[] dArr = eVar.f609h;
                                    if (dArr == null) {
                                        str = str2;
                                    } else {
                                        str = Arrays.toString(dArr);
                                    }
                                    sb3.append(str);
                                }
                            }
                            sb2.append(sb3.toString());
                        }
                    }
                    str2 = sb2.toString();
                }
                sb.append(str2);
                sb.append(getTrimStart());
                sb.append(Arrays.toString(getScreenRatio()));
                sb.append(getFitMode());
                sb.append(isWatermarkEnabled());
                sb.append(getWatermarkResourcesPath());
                sb.append(getConstraint());
                sb.append(Arrays.toString(getConstraintRatio()));
                sb.append(getCameraFacing());
                sb.append(isSpeedSectionCopySameFrame());
                sb.append(isSelfie());
                for (a.a.a.a.e.a.h.b identicalKey : getViewDecorationList()) {
                    sb.append(identicalKey.getIdenticalKey());
                }
                List<g> list3 = this.f187iiIIi11;
                if (list3 != null) {
                    for (g a2 : list3) {
                        sb.append(a2.a());
                    }
                }
                return MD5Util.getMD5String(sb.toString());
            }
            throw null;
        }
        throw null;
    }

    public LogoInfo getLogoInfo() {
        return null;
    }

    public String[] getLrvUrlsForPlay() {
        return this.ILil;
    }

    public a.a.a.a.a.d.a getLutFilter() {
        return this.f207l;
    }

    public String getMediaOffset() {
        return this.IL1Iii.getMediaOffset();
    }

    public List<d> getMultiViewClipList() {
        return this.f190i1I1I1l;
    }

    public a getMultiViewConfig() {
        return this.LL;
    }

    public String getName() {
        return this.IL1Iii.getName();
    }

    public String getOffsetForPlay() {
        return this.iIi1;
    }

    public List<c> getOptimizationRunnableList() {
        return this.f197llL1ii;
    }

    public f.a getRecordConverter() {
        return this.iIilII1;
    }

    public List<h> getRecordList() {
        return this.LLL;
    }

    public int getRotateDegree() {
        return this.f188ili11;
    }

    public int[] getScreenRatio() {
        return this.i1;
    }

    public String getSerial() {
        return this.IL1Iii.getSerial();
    }

    public float getSharpnessIntensity() {
        return this.f173L111;
    }

    public BMGSingleGyroStabilizer getSingleStabilizer() {
        return this.IL1Iii.getSingleStabilizer(new k(this));
    }

    public float getSourceVolume() {
        return this.f203i11LL;
    }

    public double getSpeedFactor() {
        return this.f168I;
    }

    public List<g> getSpeedSectionList() {
        return this.f187iiIIi11;
    }

    public int getStabType() {
        return this.iIlLiL;
    }

    public BMGStabilizer getStabilizer() {
        return this.LlLI1;
    }

    public StabilizingType getStabilizingType() {
        return this.IL1Iii.getStabilizingType();
    }

    public a.a.a.a.a.g.a getStyleFilter() {
        return this.f2101;
    }

    public float getStyleFilterIntensity() {
        return this.f181LlLLL;
    }

    public float getSuperNightDenoiseLevel() {
        return this.f189ill;
    }

    public double getTrimEnd() {
        return containsTrimEndData() ? this.f164I1L11L : getDurationInMs();
    }

    public double getTrimStart() {
        if (containsTrimStartData()) {
            return this.f182iI1iI;
        }
        return 0.0d;
    }

    public String getUrlForParse() {
        return this.IL1Iii.getUrlForParse();
    }

    public String[] getUrlsForPlay() {
        return this.f205il;
    }

    public int getVRMode() {
        return this.I11li1;
    }

    public List<a.a.a.a.e.a.h.b> getViewDecorationList() {
        return this.Liil1L1l;
    }

    public a.a.a.a.e.a.g.f getWatermarkRectCalculator() {
        return this.f208;
    }

    public String getWatermarkResourcesPath() {
        return this.llI;
    }

    public int getWidth() {
        return this.IL1Iii.getWidth();
    }

    public int getWidthOrigin() {
        return this.IL1Iii.getWidthOrigin();
    }

    public boolean hasAAAList() {
        return this.IL1Iii.hasAAAList();
    }

    public boolean hasAudio() {
        return this.IL1Iii.hasAudio();
    }

    public boolean hasExposureList() {
        return this.IL1Iii.hasExposureList();
    }

    public boolean hasGpsList() {
        return this.IL1Iii.hasGpsList();
    }

    public boolean hasGyroList() {
        return this.IL1Iii.hasGyroList();
    }

    public boolean hasOffsetForPlay() {
        return !TextUtils.isEmpty(getOffsetForPlay());
    }

    public boolean hasThumbnail() {
        return this.IL1Iii.hasThumbnail();
    }

    public boolean hasThumbnailExt() {
        return this.IL1Iii.hasThumbnailExt();
    }

    public boolean inputGyroBySegment() {
        return this.IL1Iii.inputGyroBySegment();
    }

    public boolean isBulletTime() {
        return this.IL1Iii.isBulletTime();
    }

    public boolean isColorAdjustEnabled() {
        return this.f165IIiI;
    }

    public boolean isDenoise() {
        return this.f169IIi;
    }

    public boolean isDrifterOptimize() {
        return this.f193lIIiIlL;
    }

    public boolean isDualStream() {
        return this.IL1Iii.isDualStream();
    }

    public boolean isDynamicStitch() {
        return this.f192l1IIi1;
    }

    public boolean isHDREnabled() {
        return this.f211;
    }

    public boolean isHDRVideo() {
        return this.IL1Iii.isHDRVideo();
    }

    public boolean isImageFusion() {
        return this.f179L1l;
    }

    public boolean isInstaMedia() {
        return this.IL1Iii.isInstaMedia();
    }

    public boolean isLocal() {
        return this.IL1Iii instanceof LocalWork;
    }

    public boolean isLogoEnabled() {
        return this.llliI;
    }

    public boolean isMJpeg() {
        return this.IL1Iii.isMJpeg();
    }

    public boolean isMotionBlur() {
        return this.ill1LI1l;
    }

    public boolean isRotateEnabled() {
        return this.f174LIl;
    }

    public boolean isRotateScreenRatioEnabled() {
        return this.iI;
    }

    public boolean isSelfie() {
        return this.I11L;
    }

    public boolean isSlowMo() {
        return this.IL1Iii.isSlowMo();
    }

    public boolean isSpeedSectionCopySameFrame() {
        return this.f186iILilI;
    }

    public boolean isStabilizedInCamera() {
        return this.IL1Iii.isStabilizedInCamera();
    }

    public boolean isStabilizerLoaded() {
        return this.LlLI1 == null ? this.f167ILl : this.Lil;
    }

    public boolean isStaticTimeLapse() {
        return this.IL1Iii.isStaticTimeLapse();
    }

    public boolean isSuperNight() {
        return this.f204iILLl;
    }

    public boolean isTimeLapse() {
        return this.IL1Iii.isTimeLapse();
    }

    public boolean isUseStabilizerCache() {
        return this.ILL;
    }

    public boolean isValid() {
        return this.IL1Iii.isValid();
    }

    public boolean isVideo() {
        return this.IL1Iii.isVideo();
    }

    public boolean isWatermarkEnabled() {
        return this.f209LLlI1;
    }

    public boolean isWideAngle() {
        return this.IL1Iii.isWideAngle();
    }

    public byte[] loadAAA() {
        if (this.f180L11I == null) {
            this.f180L11I = this.IL1Iii.loadAAA();
        }
        return this.f180L11I;
    }

    public byte[] loadExposure() {
        if (this.f185iILLL1 == null) {
            this.f185iILLL1 = this.IL1Iii.loadExposure();
        }
        return this.f185iILLL1;
    }

    public void loadExtraData() {
        this.IL1Iii.loadExtraData();
    }

    public byte[] loadGps() {
        if (this.f171IiL == null) {
            this.f171IiL = this.IL1Iii.loadGps();
        }
        return this.f171IiL;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean loadStabilizer(a.a.a.a.a.e.a r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r0 = r8.LlLI1     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x0009
            boolean r9 = r8.f167ILl     // Catch:{ all -> 0x00da }
            monitor-exit(r8)
            return r9
        L_0x0009:
            boolean r1 = r8.Lil     // Catch:{ all -> 0x00da }
            r2 = 1
            if (r1 != 0) goto L_0x00d3
            boolean r1 = r0 instanceof com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00c5
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r0 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r0     // Catch:{ all -> 0x00da }
            e.b.c.b.b.a.d.a r1 = new e.b.c.b.b.a.d.a     // Catch:{ all -> 0x00da }
            r1.<init>(r8, r9)     // Catch:{ all -> 0x00da }
            r0.setSequenceStabilizerCallback(r1)     // Catch:{ all -> 0x00da }
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.LlLI1     // Catch:{ all -> 0x00da }
            boolean r9 = r9.startLoadData()     // Catch:{ all -> 0x00da }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.log.MediaLogger r5 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r6.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r7 = "load stabilizer cost time: "
            r6.append(r7)     // Catch:{ all -> 0x00da }
            long r0 = r3 - r0
            r6.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "ms"
            r6.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00da }
            r5.d(r0)     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r0 = r8.LlLI1     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r0 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r0     // Catch:{ all -> 0x00da }
            r1 = 0
            r0.setSequenceStabilizerCallback(r1)     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00bb
            boolean r9 = r8.isUseStabilizerCache()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            java.io.File r9 = r8.f194lIiI     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0081
            boolean r9 = r9.exists()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0081
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.LlLI1     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r9 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r9     // Catch:{ all -> 0x00da }
            boolean r9 = r9.isLoadedFromSerializedStabilizerBuffer()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0075
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer cache hits!"
            r9.d(r0)     // Catch:{ all -> 0x00da }
            r8.Lil = r2     // Catch:{ all -> 0x00da }
            goto L_0x0081
        L_0x0075:
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer cache exists and use cache is on, but stabilizer is not loaded from it, maybe file is corrupted or stabilizer version updated, delete this cache!"
            r9.w(r0)     // Catch:{ all -> 0x00da }
            java.io.File r9 = r8.f194lIiI     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.util.FileUtils.fullDelete(r9)     // Catch:{ all -> 0x00da }
        L_0x0081:
            java.io.File r9 = r8.f194lIiI     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            boolean r9 = r9.exists()     // Catch:{ all -> 0x00da }
            if (r9 != 0) goto L_0x00d8
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.LlLI1     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r9 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r9     // Catch:{ all -> 0x00da }
            com.arashivision.insbase.nativeref.NativeBuffer r9 = r9.getSerializedStabilizerBuffer()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            java.io.File r0 = r8.f194lIiI     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.util.FileUtils.saveNativeBufferToFile(r0, r9)     // Catch:{ all -> 0x00da }
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r5.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r6 = "write stabilizer cache cost time: "
            r5.append(r6)     // Catch:{ all -> 0x00da }
            long r0 = r0 - r3
            r5.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "ms"
            r5.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00da }
        L_0x00b7:
            r9.d(r0)     // Catch:{ all -> 0x00da }
            goto L_0x00d8
        L_0x00bb:
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer load data fail!!!"
            r9.e(r0)     // Catch:{ all -> 0x00da }
            r9 = 0
            monitor-exit(r8)
            return r9
        L_0x00c5:
            boolean r9 = r0 instanceof com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer with single extra info gyro, treat as already loaded"
            r9.d(r0)     // Catch:{ all -> 0x00da }
            r8.Lil = r2     // Catch:{ all -> 0x00da }
            goto L_0x00d8
        L_0x00d3:
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = ILI1Ll     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer is already loaded"
            goto L_0x00b7
        L_0x00d8:
            monitor-exit(r8)
            return r2
        L_0x00da:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.video.SimpleVideoParams.loadStabilizer(a.a.a.a.a.e.a):boolean");
    }

    public byte[] loadThumbnail() {
        if (this.Ilil == null) {
            this.Ilil = this.IL1Iii.loadThumbnail();
        }
        return this.Ilil;
    }

    public byte[] loadThumbnailExt() {
        if (this.f198lLi1LL == null) {
            this.f198lLi1LL = this.IL1Iii.loadThumbnailExt();
        }
        return this.f198lLi1LL;
    }

    public void removeReference(a.a.a.a.a.f.e.a aVar) {
        a.a.a.a.a.f.e.b.a().b(this.IL1Iii, aVar);
    }

    public synchronized void resetStabilizer() {
        this.LlLI1 = null;
        this.f167ILl = false;
        this.Lil = false;
    }

    public void setAudioEffectList(List<b> list) {
        this.I1IILIIL = list;
    }

    public void setBeautyFilterLevel(int i2) {
        this.f195lIII = i2;
    }

    public void setBgmDuration(long j2) {
        this.f202i11i = j2;
    }

    public void setBgmOffset(long j2) {
        this.L1iI1 = j2;
    }

    public void setBgmRange(long[] jArr) {
        this.l1Lll = jArr;
    }

    public void setBgmUrl(String str) {
        this.I1 = str;
    }

    public void setBgmWeight(float f2) {
        this.lL = f2;
    }

    public void setBlendAngleRad(float f2) {
        this.f199lliiI1 = f2;
    }

    public void setCacheCutSceneVideoPath(String str) {
        this.f184iI1LI = str;
    }

    public void setCacheVideoProxyRootPath(String str) {
        this.f191iILiiLl = str;
    }

    public void setCacheWorkThumbnailRootPath(String str) {
        this.f2011 = str;
    }

    public void setCameraFacing(int i2) {
        this.f206lL = i2;
    }

    public void setColorAdjustEnabled(boolean z) {
        this.f165IIiI = z;
    }

    public void setConstraint(Constraint constraint) {
        if (getFileType() == FileType.UNPANORAMA) {
            ILI1Ll.e("FileType.UNPANORAMA doesn't support setConstraint()");
        } else {
            this.f166ILLIi = constraint;
        }
    }

    public void setConstraintRatio(int[] iArr) {
        if (getFileType() == FileType.UNPANORAMA) {
            ILI1Ll.e("FileType.UNPANORAMA doesn't support setConstraintRatio()");
        } else {
            this.f200li11 = iArr;
        }
    }

    public void setContrastIntensity(float f2) {
        this.LL1IL = f2;
    }

    public void setDenoise(boolean z) {
        this.f169IIi = z;
    }

    public void setDenoiseLevel(int i2) {
        this.f175LIll = i2;
    }

    public void setDrifterOptimize(boolean z) {
        this.f193lIIiIlL = z;
    }

    public void setDurationInMs(double d2) {
        this.f170IL = d2;
    }

    public void setDynamicStitch(boolean z) {
        this.f192l1IIi1 = z;
    }

    public void setFileType(FileType fileType) {
        this.f196lIlii = fileType;
    }

    public void setFitMode(int i2) {
        this.f177LlLiLL = i2;
    }

    public void setFlashDataList(List<a.a.a.a.e.a.i.a> list) {
        this.LiL1 = list;
    }

    public void setFlashEffect(e eVar) {
        this.LI11 = eVar;
    }

    public void setFps(double d2) {
        this.I1I = d2;
    }

    public void setFrameCount(int i2) {
        this.f183iIl1il = i2;
    }

    public void setHDREffectLevel(int i2) {
        this.f176LlIl = i2;
    }

    public void setHDREnabled(boolean z) {
        this.f211 = z;
    }

    public void setHDRStrength(float f2) {
        this.f172L11 = f2;
    }

    public void setImageFusion(boolean z) {
        this.f179L1l = z;
    }

    public void setLogoEnabled(boolean z) {
        this.llliI = z;
    }

    public void setLrvUrlsForPlay(String[] strArr) {
        this.ILil = strArr;
    }

    public void setLutFilter(a.a.a.a.a.d.a aVar) {
        this.f207l = aVar;
    }

    public void setMotionBlur(boolean z) {
        this.ill1LI1l = z;
    }

    public void setMultiViewClipList(List<d> list) {
        this.f190i1I1I1l = list;
    }

    public void setMultiViewConfig(a aVar) {
        this.LL = aVar;
    }

    public void setOffsetForPlay(String str) {
        this.iIi1 = str;
    }

    public void setOptimizationRunnableList(List<c> list) {
        this.f197llL1ii = list;
    }

    public void setRecordConverter(f.a aVar) {
        this.iIilII1 = aVar;
    }

    public void setRecordList(List<h> list) {
        this.LLL = list;
    }

    public void setRotateDegree(int i2) {
        if (getFileType() != FileType.UNPANORAMA) {
            ILI1Ll.e("setRotateDegree, but work is not FileType.UNPANORAMA");
            return;
        }
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = i2 != 90;
            if (i2 == 180) {
                z = false;
            }
            if ((z2 && z) && i2 != 270) {
                MediaLogger mediaLogger = ILI1Ll;
                StringBuilder sb = new StringBuilder();
                sb.append("setRotateDegree, but rotateDegree is invalid: ");
                sb.append(i2);
                mediaLogger.e(sb.toString());
                return;
            }
        }
        this.f188ili11 = i2;
    }

    public void setRotateEnabled(boolean z) {
        FileType fileType = getFileType();
        if (fileType == FileType.UNPANORAMA || fileType == FileType.FISH_EYE) {
            this.f174LIl = z;
        } else {
            ILI1Ll.e("setRotateEnabled, but work is not FileType.UNPANORAMA or FileType.FISH_EYE");
        }
    }

    public void setRotateScreenRatioEnabled(boolean z) {
        this.iI = z;
    }

    public void setScreenRatio(int[] iArr) {
        if (iArr == null || iArr[0] == 0 || iArr[1] == 0) {
            ILI1Ll.e("setScreenRatio doesn't support null or ratio 0");
        } else {
            this.i1 = a.a.a.a.e.a.l.d.a(iArr);
        }
    }

    public void setSelfie(boolean z) {
        this.I11L = z;
        this.f194lIiI = new File(IL1Iii());
    }

    public void setSharpnessIntensity(float f2) {
        this.f173L111 = f2;
    }

    public void setSourceVolume(float f2) {
        this.f203i11LL = f2;
    }

    public void setSpeedFactor(double d2) {
        this.f168I = d2;
    }

    public void setSpeedSectionCopySameFrame(boolean z) {
        this.f186iILilI = z;
    }

    public void setSpeedSectionList(List<g> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f187iiIIi11 = list;
    }

    public void setStabType(int i2) {
        this.iIlLiL = i2;
    }

    public void setStabilizerCacheRootPath(String str) {
        StringBuilder a2 = e.a.a.a.a.a(str);
        a2.append(File.separator);
        this.f178Ll1 = a2.toString();
        this.f194lIiI = new File(IL1Iii());
    }

    public void setStyleFilter(a.a.a.a.a.g.a aVar) {
        this.f2101 = aVar;
    }

    public void setStyleFilterIntensity(float f2) {
        this.f181LlLLL = f2;
    }

    public void setSuperNight(boolean z) {
        this.f204iILLl = z;
    }

    public void setSuperNightDenoiseLevel(float f2) {
        this.f189ill = f2;
    }

    public void setTrimEnd(double d2) {
        this.f164I1L11L = d2;
    }

    public void setTrimStart(double d2) {
        this.f182iI1iI = d2;
    }

    public void setUrlsForPlay(String[] strArr) {
        this.f205il = strArr;
    }

    public void setUseStabilizerCache(boolean z) {
        this.ILL = z;
    }

    public void setVRMode(int i2) {
        this.I11li1 = i2;
    }

    public void setViewDecorationList(List<a.a.a.a.e.a.h.b> list) {
        this.Liil1L1l = list;
    }

    public void setWatermarkEnabled(boolean z) {
        this.f209LLlI1 = z;
    }

    public void setWatermarkRectCalculator(a.a.a.a.e.a.g.f fVar) {
        this.f208 = fVar;
    }

    public void setWatermarkResourcesPath(String str) {
        this.llI = str;
    }

    public void updateStabilizer(int i2) {
        BMGStabilizer bMGStabilizer = this.LlLI1;
        if (bMGStabilizer != null) {
            bMGStabilizer.updateStabType(i2);
        } else {
            ILI1Ll.e("updateStabilizer(type), but stabilizer is null");
        }
    }

    public synchronized void updateStabilizerByFovAndDistanceIfNeeded() {
        synchronized (this) {
            Constraint constraint = getConstraint();
            int[] constraintRatio = getConstraintRatio();
            if (!this.IL1Iii.adjustStabilizerByFovAndDistance() || constraint == null) {
                ILI1Ll.d("updateStabilizerByFovAndDistanceIfNeeded(adjust), this source do not need to adjust stabilizer");
            } else {
                float defaultDistance = constraint.getDefaultDistance();
                float defaultFov = constraint.getDefaultFov();
                float xScale = constraint.getXScale();
                float yScale = constraint.getYScale();
                float f2 = (((float) constraintRatio[1]) * 1.0f) / ((float) constraintRatio[0]);
                BMGStabilizer bMGStabilizer = this.LlLI1;
                if (bMGStabilizer == null) {
                    ILI1Ll.e("updateStabilizerByFovAndDistanceIfNeeded(adjust), but stabilizer is null");
                } else if (bMGStabilizer instanceof BMGSequenceStabilizer) {
                    ((BMGSequenceStabilizer) bMGStabilizer).setGyroFilterRenderFovAdjust2(1.0d, (double) defaultDistance, (double) defaultFov, (double) f2, (double) xScale, (double) yScale);
                } else {
                    ILI1Ll.w("updateStabilizerByFovAndDistanceIfNeeded(adjust), but stabilizer is not a BMGSequenceStabilizer");
                }
            }
        }
    }

    public synchronized void updateStabilizerByFrameTimestampInMsForExport() {
        BMGStabilizer bMGStabilizer = this.LlLI1;
        if (bMGStabilizer != null && (bMGStabilizer instanceof BMGSequenceStabilizer) && isVideo()) {
            ArrayList arrayList = (ArrayList) a.a.a.a.b.a.a(getDurationInMs(), getSpeedSectionList(), getSpeedFactor(), getTrimStart(), getTrimEnd(), true, (a.a.a.a.e.a.l.e) new a.a.a.a.e.a.l.a());
            ExporterTimeScale[] exporterTimeScaleArr = new ExporterTimeScale[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                exporterTimeScaleArr[i2] = (ExporterTimeScale) arrayList.get(i2);
            }
            ((BMGSequenceStabilizer) this.LlLI1).resetFrameTimestampInMs(VideoTimePicker.calculateVideoTime(this.IL1Iii.getUrlsForPlay()[0], (long) getTrimStart(), (long) getTrimEnd(), exporterTimeScaleArr), true);
        }
    }

    public synchronized void updateStabilizerByFrameTimestampInMsForPreview(PreviewerSource previewerSource, int i2) {
        BMGStabilizer bMGStabilizer = this.LlLI1;
        if (bMGStabilizer != null && (bMGStabilizer instanceof BMGSequenceStabilizer) && isVideo()) {
            com.arashivision.graphicpath.insmedia.previewer2.VideoTimePicker videoTimePicker = new com.arashivision.graphicpath.insmedia.previewer2.VideoTimePicker();
            videoTimePicker.calculate(previewerSource);
            VideoTimeSequence[] result = videoTimePicker.getResult();
            if (result == null || result.length <= i2) {
                ILI1Ll.e("videoTimePicker for preview can't resolve this media");
            } else {
                ((BMGSequenceStabilizer) this.LlLI1).resetFrameTimestampInMs2(result[i2].getTsSeqs(), true);
            }
        }
    }
}
