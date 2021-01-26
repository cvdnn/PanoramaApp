package com.arashivision.insta360.basemedia.ui.player.image;

import a.a.a.a.a.f.e.b;
import a.a.a.a.a.g.a;
import a.a.a.a.b.f;
import a.a.a.a.e.a.g.c;
import a.a.a.a.e.a.l.d;
import android.text.TextUtils;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.engine.Transform;
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
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SimpleImageParams implements IImageParams, Serializable {

    /* renamed from: IIi丨丨I reason: contains not printable characters */
    public static final MediaLogger f114IIiI = MediaLogger.getLogger(SimpleImageParams.class);
    public boolean I11L;
    public float I11li1;
    public byte[] I1I;
    public Work IL1Iii;
    public List<c> ILL;
    public int ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public int f115ILl;
    public boolean Ilil = true;

    /* renamed from: I丨Ii reason: contains not printable characters */
    public int f116IIi;

    /* renamed from: I丨L reason: contains not printable characters */
    public String f117IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public boolean f118IiL;

    /* renamed from: L11丨 reason: contains not printable characters */
    public String f119L11;

    /* renamed from: L11丨丨丨1 reason: contains not printable characters */
    public f f120L111;

    /* renamed from: LI丨丨l丨l reason: contains not printable characters */
    public boolean f121LIll;
    public float LL1IL;
    public int Lil;

    /* renamed from: LlIl丨 reason: contains not printable characters */
    public String f122LlIl;
    public int LlLI1;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public FileType f123Ll1;

    /* renamed from: L丨1l reason: contains not printable characters */
    public int[] f124L1l;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public boolean f125L11I;

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public boolean f126LlLLL;
    public LogoInfo iIi1;
    public a iIlLiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public File f127iILLL1;

    /* renamed from: il丨l丨 reason: contains not printable characters */
    public boolean f128ill;

    /* renamed from: l1IIi1丨 reason: contains not printable characters */
    public Constraint f129l1IIi1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public String f130lIiI;

    /* renamed from: lI丨II reason: contains not printable characters */
    public boolean f131lIII;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public boolean f132lIlii;
    public float llI;
    public a.a.a.a.e.a.g.f llliI;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public boolean f133llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public String f134lLi1LL;

    /* renamed from: 丨iI丨丨LLl reason: contains not printable characters */
    public int[] f135iILLl;

    /* renamed from: 丨il reason: contains not printable characters */
    public BMGStabilizer f136il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public int f137lL;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public String f138l;

    /* renamed from: 丨丨 reason: contains not printable characters */
    public boolean f139;

    /* renamed from: 丨丨LLlI1 reason: contains not printable characters */
    public Transform f140LLlI1;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public boolean f1411;

    /* renamed from: 丨丨丨丨 reason: contains not printable characters */
    public int f142;

    public SimpleImageParams(Work work) {
        EventIdUtils.getEventId();
        this.IL1Iii = work;
        String str = "";
        this.f122LlIl = str;
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getCacheFolder());
        sb.append("/stabilizer/");
        this.f134lLi1LL = sb.toString();
        boolean z = false;
        this.f118IiL = false;
        this.f125L11I = false;
        this.f136il = null;
        this.ILL = null;
        this.f123Ll1 = this.IL1Iii.getFileType();
        this.f130lIiI = this.IL1Iii.getOffset();
        this.f115ILl = this.IL1Iii.getStabType();
        this.Lil = 0;
        this.LlLI1 = -1;
        this.f133llL1ii = this.IL1Iii.isSelfie();
        this.f132lIlii = this.IL1Iii.isLogoEnabled();
        this.iIi1 = null;
        this.iIlLiL = this.IL1Iii.getStyleFilter();
        this.I11li1 = this.IL1Iii.getStyleFilterIntensity();
        this.f137lL = this.IL1Iii.getBeautyFilterLevel();
        this.f120L111 = this.IL1Iii.getWindowCropInfo();
        this.I11L = false;
        this.llliI = e.b.c.b.b.a.b.a.f5769a;
        this.f138l = str;
        this.f1411 = true;
        this.f126LlLLL = false;
        this.f131lIII = false;
        this.LL1IL = -1.0f;
        this.f140LLlI1 = null;
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f129l1IIi1 = constraint;
        this.f124L1l = new int[]{-1, -1};
        if (getFileType() == FileType.UNPANORAMA) {
            int width = getWidth();
            int height = getHeight();
            if (width <= 0 || height <= 0) {
                this.f135iILLl = new int[]{1, 1};
            } else {
                this.f135iILLl = d.a(new int[]{width, height});
            }
        } else {
            this.f135iILLl = new int[]{-1, -1};
        }
        int rotateDegree = this.IL1Iii.getRotateDegree();
        this.f116IIi = rotateDegree;
        if (rotateDegree != 0) {
            z = true;
        }
        this.f121LIll = z;
        this.f128ill = z;
        this.f142 = 1;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(MediaModule.getCacheFolder());
        sb2.append("cutscene/image/");
        this.f119L11 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(MediaModule.getCacheFolder());
        sb3.append("work/thumbnail/");
        sb3.append(FileUtils.removeFileExtension(work.getName()));
        sb3.append(".jpg");
        this.f122LlIl = sb3.toString();
        this.ILil = work.getIndex();
        ILil();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(a.a.a.a.a.e.a aVar, long j2, long j3) {
        boolean z;
        MediaLogger mediaLogger = f114IIiI;
        StringBuilder a2 = e.a.a.a.a.a("load stabilizer, progress: ", j2, " / ");
        a2.append(j3);
        mediaLogger.d(a2.toString());
        if (j2 == j3) {
            f114IIiI.d("stabilizer load finish");
            z = true;
        } else {
            z = false;
        }
        this.f125L11I = z;
        if (aVar != null) {
            aVar.IL1Iii(j2, j3);
        }
    }

    public static /* synthetic */ float[] IL1Iii(int i2, int i3, int i4, int i5) {
        return new float[]{200.0f, 100.0f, 0.0f, 0.0f};
    }

    public final String IL1Iii() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f134lLi1LL);
        sb.append(FileUtils.removeFileExtension(this.IL1Iii.getName()));
        sb.append("-");
        sb.append(this.ILil);
        sb.append(isSelfie() == this.IL1Iii.isSelfie() ? "" : "-fpv");
        return sb.toString();
    }

    public final void ILil() {
        this.I1I = null;
        this.f117IL = this.IL1Iii.getUrlsForPlay(this.ILil)[0];
        this.f127iILLL1 = new File(IL1Iii());
    }

    public void addReference(a.a.a.a.a.f.e.a aVar) {
        b.a().a(this.IL1Iii, aVar);
    }

    public synchronized boolean cancelStabilizer() {
        boolean z;
        BMGStabilizer bMGStabilizer = this.f136il;
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

    public final SimpleImageParams clone() {
        try {
            return (SimpleImageParams) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public synchronized BMGStabilizer createStabilizer(boolean z) {
        NativeBuffer nativeBuffer;
        if (!this.f118IiL) {
            Work work = this.IL1Iii;
            int i2 = this.ILil;
            if (isUseStabilizerCache()) {
                File file = this.f127iILLL1;
                if (file != null && file.exists()) {
                    nativeBuffer = FileUtils.readNativeBufferFromFile(this.f127iILLL1);
                    BMGSequenceStabilizer sequenceStabilizer = work.getSequenceStabilizer(i2, z, nativeBuffer, new a.a.a.a.e.a.k.d(this));
                    this.f136il = sequenceStabilizer;
                    if (sequenceStabilizer == null && this.IL1Iii.isInstaMedia(this.ILil) && this.IL1Iii.isPhoto(this.ILil)) {
                        this.f136il = this.IL1Iii.getSingleStabilizer(this.ILil, new a.a.a.a.e.a.k.d(this));
                    }
                    this.f118IiL = true;
                }
            }
            nativeBuffer = null;
            BMGSequenceStabilizer sequenceStabilizer2 = work.getSequenceStabilizer(i2, z, nativeBuffer, new a.a.a.a.e.a.k.d(this));
            this.f136il = sequenceStabilizer2;
            this.f136il = this.IL1Iii.getSingleStabilizer(this.ILil, new a.a.a.a.e.a.k.d(this));
            this.f118IiL = true;
        }
        return this.f136il;
    }

    public AssetInfo getAssetInfo() {
        AssetInfo assetInfo = this.IL1Iii.getAssetInfo(this.ILil);
        assetInfo.offset = getOffsetForPlay();
        assetInfo.isSelfie = Boolean.valueOf(isSelfie());
        f fVar = this.f120L111;
        if (fVar != null) {
            assetInfo.cropWindowSrcWidth = Integer.valueOf(fVar.f424a);
            assetInfo.cropWindowSrcHeight = Integer.valueOf(this.f120L111.f425b);
            assetInfo.cropWindowDstWidth = Integer.valueOf(this.f120L111.f426c);
            assetInfo.cropWindowDstHeight = Integer.valueOf(this.f120L111.f427d);
        }
        return assetInfo;
    }

    public int getBeautyFilterLevel() {
        return this.f137lL;
    }

    public float getBlendAngleRad() {
        return this.LL1IL;
    }

    public String getCacheCutSceneImagePath() {
        return this.f119L11;
    }

    public String getCacheWorkThumbnailRootPath() {
        return this.f122LlIl;
    }

    public int getCameraFacing() {
        return this.LlLI1;
    }

    public String getCameraType() {
        return this.IL1Iii.getCameraType();
    }

    public Constraint getConstraint() {
        if (getFileType() == FileType.UNPANORAMA) {
            return null;
        }
        return this.f129l1IIi1;
    }

    public int[] getConstraintRatio() {
        if (getFileType() == FileType.UNPANORAMA) {
            return null;
        }
        return Arrays.equals(this.f124L1l, new int[]{-1, -1}) ? this.f135iILLl : this.f124L1l;
    }

    public int getCount() {
        return this.IL1Iii.getCount();
    }

    public long getCreationTime() {
        return this.IL1Iii.getCreationTime(this.ILil);
    }

    public long getExtraInfoPos() {
        if (this.f117IL.equals(this.IL1Iii.getUrlsForPlay(this.ILil)[0])) {
            return this.IL1Iii.getExtraInfoPos(this.ILil);
        }
        return 0;
    }

    public FileType getFileType() {
        return this.f123Ll1;
    }

    public int getFitMode() {
        return this.f142;
    }

    public a.a.a.a.b.d getGps() {
        return this.IL1Iii.getGps();
    }

    public double getGyroDelayTime() {
        return this.IL1Iii.getGyroDelayTime(this.ILil);
    }

    public int getHeight() {
        return this.IL1Iii.getHeight(this.ILil);
    }

    public int getHeightOrigin() {
        return this.IL1Iii.getHeightOrigin();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v14, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v17, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v20, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getIdenticalKey() {
        /*
            r4 = this;
            com.arashivision.graphicpath.render.engine.Transform r0 = r4.getTransform()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r4.getUrlsForPlay()
            r1.append(r2)
            java.lang.String r2 = r4.getOffsetForPlay()
            r1.append(r2)
            int r2 = r4.getStabType()
            r1.append(r2)
            boolean r2 = r4.isLogoEnabled()
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0033
            com.arashivision.arvbmg.previewer.ClipRenderInfo$LogoInfo r2 = r4.getLogoInfo()
            com.arashivision.graphicpath.render.source.ImageAsset r2 = r2.getLogoAsset()
            java.lang.String r2 = r2.getName()
            goto L_0x0034
        L_0x0033:
            r2 = r3
        L_0x0034:
            r1.append(r2)
            a.a.a.a.a.g.a r2 = r4.getStyleFilter()
            a.a.a.a.a.g.b r2 = (a.a.a.a.a.g.b) r2
            if (r2 == 0) goto L_0x00b5
            java.lang.String r2 = "Original"
            r1.append(r2)
            int r2 = r4.getBeautyFilterLevel()
            r1.append(r2)
            if (r0 == 0) goto L_0x0056
            float r2 = r0.getFov()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x0057
        L_0x0056:
            r2 = r3
        L_0x0057:
            r1.append(r2)
            if (r0 == 0) goto L_0x0065
            float r2 = r0.getDistance()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x0066
        L_0x0065:
            r2 = r3
        L_0x0066:
            r1.append(r2)
            if (r0 == 0) goto L_0x0074
            float r2 = r0.getYaw()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x0075
        L_0x0074:
            r2 = r3
        L_0x0075:
            r1.append(r2)
            if (r0 == 0) goto L_0x0082
            float r0 = r0.getPitch()
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
        L_0x0082:
            r1.append(r3)
            boolean r0 = r4.isWatermarkEnabled()
            r1.append(r0)
            java.lang.String r0 = r4.getWatermarkResourcesPath()
            r1.append(r0)
            com.arashivision.insta360.basemedia.model.viewconstraint.Constraint r0 = r4.getConstraint()
            r1.append(r0)
            int[] r0 = r4.getConstraintRatio()
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r1.append(r0)
            boolean r0 = r4.isSelfie()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = com.arashivision.insta360.basemedia.util.MD5Util.getMD5String(r0)
            return r0
        L_0x00b5:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.image.SimpleImageParams.getIdenticalKey():java.lang.String");
    }

    public int getIndex() {
        return this.ILil;
    }

    public LogoInfo getLogoInfo() {
        return this.iIi1;
    }

    public String getMediaOffset() {
        return this.IL1Iii.getMediaOffset();
    }

    public String getName() {
        return this.IL1Iii.getName(this.ILil);
    }

    public String getOffsetForPlay() {
        return this.f130lIiI;
    }

    public List<c> getOptimizationRunnableList() {
        return this.ILL;
    }

    public float getPowerPanoRotateYaw() {
        return this.llI;
    }

    public int getRotateDegree() {
        return this.f116IIi;
    }

    public int[] getScreenRatio() {
        return this.f135iILLl;
    }

    public String getSerial() {
        return this.IL1Iii.getSerial(this.ILil);
    }

    public BMGSingleGyroStabilizer getSingleStabilizer() {
        return this.IL1Iii.getSingleStabilizer(this.ILil, new a.a.a.a.e.a.k.d(this));
    }

    public int getStabType() {
        return this.f115ILl;
    }

    public BMGStabilizer getStabilizer() {
        return this.f136il;
    }

    public StabilizingType getStabilizingType() {
        return this.IL1Iii.getStabilizingType(this.ILil);
    }

    public a getStyleFilter() {
        return this.iIlLiL;
    }

    public float getStyleFilterIntensity() {
        return this.I11li1;
    }

    public Transform getTransform() {
        return this.f140LLlI1;
    }

    public String getUrlForParse() {
        return this.IL1Iii.getUrlForParse(this.ILil);
    }

    public String getUrlsForPlay() {
        return this.f117IL;
    }

    public int getVRMode() {
        return this.Lil;
    }

    public a.a.a.a.e.a.g.f getWatermarkRectCalculator() {
        return this.llliI;
    }

    public String getWatermarkResourcesPath() {
        return this.f138l;
    }

    public int getWidth() {
        return this.IL1Iii.getWidth(this.ILil);
    }

    public int getWidthOrigin() {
        return this.IL1Iii.getWidthOrigin();
    }

    public f getWindowCropInfo() {
        return this.f120L111;
    }

    public boolean hasGyroList() {
        return this.IL1Iii.hasGyroList(this.ILil);
    }

    public boolean hasOffsetForPlay() {
        return !TextUtils.isEmpty(getOffsetForPlay());
    }

    public boolean hasThumbnail() {
        return this.IL1Iii.hasThumbnail(this.ILil);
    }

    public boolean isColorAdjustEnabled() {
        return this.f131lIII;
    }

    public boolean isDualStream() {
        return false;
    }

    public boolean isDynamicStitch() {
        return this.f1411;
    }

    public boolean isHDRPhoto() {
        return this.IL1Iii.isHDRPhoto(this.ILil);
    }

    public boolean isImageFusion() {
        return this.f126LlLLL;
    }

    public boolean isInstaMedia() {
        return this.IL1Iii.isInstaMedia(this.ILil);
    }

    public boolean isIntervalShooting() {
        return this.IL1Iii.isIntervalShooting(this.ILil);
    }

    public boolean isLocal() {
        return this.IL1Iii instanceof LocalWork;
    }

    public boolean isLogoEnabled() {
        return this.f132lIlii;
    }

    public boolean isPowerPanoMode() {
        return this.f139;
    }

    public boolean isRotateEnabled() {
        return this.f121LIll;
    }

    public boolean isRotateScreenRatioEnabled() {
        return this.f128ill;
    }

    public boolean isSelfie() {
        return this.f133llL1ii;
    }

    public boolean isUseStabilizerCache() {
        return this.Ilil;
    }

    public boolean isValid() {
        return this.IL1Iii.isValid();
    }

    public boolean isVideo() {
        return this.IL1Iii.isVideo();
    }

    public boolean isWatermarkEnabled() {
        return this.I11L;
    }

    public boolean isWideAngle() {
        return this.IL1Iii.isWideAngle();
    }

    public void loadExtraData() {
        this.IL1Iii.loadExtraData(this.ILil);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean loadStabilizer(a.a.a.a.a.e.a r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r0 = r8.f136il     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x0009
            boolean r9 = r8.f118IiL     // Catch:{ all -> 0x00da }
            monitor-exit(r8)
            return r9
        L_0x0009:
            boolean r1 = r8.f125L11I     // Catch:{ all -> 0x00da }
            r2 = 1
            if (r1 != 0) goto L_0x00d3
            boolean r1 = r0 instanceof com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00c5
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r0 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r0     // Catch:{ all -> 0x00da }
            e.b.c.b.b.a.b.g r1 = new e.b.c.b.b.a.b.g     // Catch:{ all -> 0x00da }
            r1.<init>(r8, r9)     // Catch:{ all -> 0x00da }
            r0.setSequenceStabilizerCallback(r1)     // Catch:{ all -> 0x00da }
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.f136il     // Catch:{ all -> 0x00da }
            boolean r9 = r9.startLoadData()     // Catch:{ all -> 0x00da }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.log.MediaLogger r5 = f114IIiI     // Catch:{ all -> 0x00da }
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
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r0 = r8.f136il     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r0 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r0     // Catch:{ all -> 0x00da }
            r1 = 0
            r0.setSequenceStabilizerCallback(r1)     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00bb
            boolean r9 = r8.isUseStabilizerCache()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            java.io.File r9 = r8.f127iILLL1     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0081
            boolean r9 = r9.exists()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0081
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.f136il     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r9 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r9     // Catch:{ all -> 0x00da }
            boolean r9 = r9.isLoadedFromSerializedStabilizerBuffer()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x0075
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer cache hits!"
            r9.d(r0)     // Catch:{ all -> 0x00da }
            r8.f125L11I = r2     // Catch:{ all -> 0x00da }
            goto L_0x0081
        L_0x0075:
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer cache exists and use cache is on, but stabilizer is not loaded from it, maybe file is corrupted or stabilizer version updated, delete this cache!"
            r9.w(r0)     // Catch:{ all -> 0x00da }
            java.io.File r9 = r8.f127iILLL1     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.util.FileUtils.fullDelete(r9)     // Catch:{ all -> 0x00da }
        L_0x0081:
            java.io.File r9 = r8.f127iILLL1     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            boolean r9 = r9.exists()     // Catch:{ all -> 0x00da }
            if (r9 != 0) goto L_0x00d8
            com.arashivision.arvbmg.render.gyro.BMGStabilizer r9 = r8.f136il     // Catch:{ all -> 0x00da }
            com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer r9 = (com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer) r9     // Catch:{ all -> 0x00da }
            com.arashivision.insbase.nativeref.NativeBuffer r9 = r9.getSerializedStabilizerBuffer()     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            java.io.File r0 = r8.f127iILLL1     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.util.FileUtils.saveNativeBufferToFile(r0, r9)     // Catch:{ all -> 0x00da }
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00da }
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
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
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer load data fail!!!"
            r9.e(r0)     // Catch:{ all -> 0x00da }
            r9 = 0
            monitor-exit(r8)
            return r9
        L_0x00c5:
            boolean r9 = r0 instanceof com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer     // Catch:{ all -> 0x00da }
            if (r9 == 0) goto L_0x00d8
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "stabilizer with single extra info gyro, treat as already loaded"
            r9.d(r0)     // Catch:{ all -> 0x00da }
            r8.f125L11I = r2     // Catch:{ all -> 0x00da }
            goto L_0x00d8
        L_0x00d3:
            com.arashivision.insta360.basemedia.log.MediaLogger r9 = f114IIiI     // Catch:{ all -> 0x00da }
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
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.image.SimpleImageParams.loadStabilizer(a.a.a.a.a.e.a):boolean");
    }

    public byte[] loadThumbnail() {
        if (this.I1I == null) {
            this.I1I = this.IL1Iii.loadThumbnail(this.ILil);
        }
        return this.I1I;
    }

    public void removeReference(a.a.a.a.a.f.e.a aVar) {
        b.a().b(this.IL1Iii, aVar);
    }

    public synchronized void resetStabilizer() {
        this.f136il = null;
        this.f118IiL = false;
        this.f125L11I = false;
    }

    public void setBeautyFilterLevel(int i2) {
        this.f137lL = i2;
    }

    public void setBlendAngleRad(float f2) {
        this.LL1IL = f2;
    }

    public void setCacheCutSceneImagePath(String str) {
        this.f119L11 = str;
    }

    public void setCacheWorkThumbnailRootPath(String str) {
        this.f122LlIl = str;
    }

    public void setCameraFacing(int i2) {
        this.LlLI1 = i2;
    }

    public void setColorAdjustEnabled(boolean z) {
        this.f131lIII = z;
    }

    public void setConstraint(Constraint constraint) {
        if (getFileType() == FileType.UNPANORAMA) {
            f114IIiI.e("FileType.UNPANORAMA doesn't support setConstraint()");
        } else {
            this.f129l1IIi1 = constraint;
        }
    }

    public void setConstraintRatio(int[] iArr) {
        if (getFileType() == FileType.UNPANORAMA) {
            f114IIiI.e("FileType.UNPANORAMA doesn't support setConstraintRatio()");
        } else {
            this.f124L1l = iArr;
        }
    }

    public void setDynamicStitch(boolean z) {
        this.f1411 = z;
    }

    public void setFileType(FileType fileType) {
        this.f123Ll1 = fileType;
    }

    public void setFitMode(int i2) {
        this.f142 = i2;
    }

    public void setImageFusion(boolean z) {
        this.f126LlLLL = z;
    }

    public void setIndex(int i2) {
        this.ILil = i2;
        ILil();
    }

    public void setLogoEnabled(boolean z) {
        this.f132lIlii = z;
    }

    public void setLogoInfo(LogoInfo logoInfo) {
        this.iIi1 = logoInfo;
    }

    public void setOffsetForPlay(String str) {
        this.f130lIiI = str;
    }

    public void setOptimizationRunnableList(List<c> list) {
        this.ILL = list;
    }

    public void setPowerPanoMode(boolean z) {
        this.f139 = z;
    }

    public void setPowerPanoRotateYaw(float f2) {
        this.llI = f2;
    }

    public void setRotateDegree(int i2) {
        if (getFileType() != FileType.UNPANORAMA) {
            f114IIiI.e("setRotateDegree, but work is not FileType.UNPANORAMA");
            return;
        }
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = i2 != 90;
            if (i2 == 180) {
                z = false;
            }
            if ((z2 && z) && i2 != 270) {
                MediaLogger mediaLogger = f114IIiI;
                StringBuilder sb = new StringBuilder();
                sb.append("setRotateDegree, but planeRotateDegree is invalid: ");
                sb.append(i2);
                mediaLogger.e(sb.toString());
                return;
            }
        }
        this.f116IIi = i2;
    }

    public void setRotateEnabled(boolean z) {
        FileType fileType = getFileType();
        if (fileType == FileType.UNPANORAMA || fileType == FileType.FISH_EYE) {
            this.f121LIll = z;
        } else {
            f114IIiI.e("setRotateEnabled, but work is not FileType.UNPANORAMA or FileType.FISH_EYE");
        }
    }

    public void setRotateScreenRatioEnabled(boolean z) {
        this.f128ill = z;
    }

    public void setScreenRatio(int[] iArr) {
        if (iArr == null || iArr[0] == 0 || iArr[1] == 0) {
            f114IIiI.e("setScreenRatio doesn't support null or ratio 0");
        } else {
            this.f135iILLl = d.a(iArr);
        }
    }

    public void setSelfie(boolean z) {
        this.f133llL1ii = z;
        this.f127iILLL1 = new File(IL1Iii());
    }

    public void setStabType(int i2) {
        this.f115ILl = i2;
    }

    public void setStabilizerCacheRootPath(String str) {
        StringBuilder a2 = e.a.a.a.a.a(str);
        a2.append(File.separator);
        this.f134lLi1LL = a2.toString();
        this.f127iILLL1 = new File(IL1Iii());
    }

    public void setStyleFilter(a aVar) {
        this.iIlLiL = aVar;
    }

    public void setStyleFilterIntensity(float f2) {
        this.I11li1 = f2;
    }

    public void setTransform(Transform transform) {
        this.f140LLlI1 = transform;
    }

    public void setUrlsForPlay(String str) {
        this.f117IL = str;
    }

    public void setUseStabilizerCache(boolean z) {
        this.Ilil = z;
    }

    public void setVRMode(int i2) {
        this.Lil = i2;
    }

    public void setWatermarkEnabled(boolean z) {
        this.I11L = z;
    }

    public void setWatermarkRectCalculator(a.a.a.a.e.a.g.f fVar) {
        this.llliI = fVar;
    }

    public void setWatermarkResourcesPath(String str) {
        this.f138l = str;
    }

    public void setWindowCropInfo(f fVar) {
        this.f120L111 = fVar;
    }

    public void updateStabilizer(int i2) {
        BMGStabilizer bMGStabilizer = this.f136il;
        if (bMGStabilizer != null) {
            bMGStabilizer.updateStabType(i2);
        } else {
            f114IIiI.e("updateStabilizer(type), but stabilizer is null");
        }
    }

    public synchronized void updateStabilizerByFovAndDistanceIfNeeded() {
        synchronized (this) {
            Constraint constraint = getConstraint();
            int[] constraintRatio = getConstraintRatio();
            if (!this.IL1Iii.adjustStabilizerByFovAndDistance(this.ILil) || constraint == null) {
                f114IIiI.d("updateStabilizerByFovAndDistanceIfNeeded(adjust), this source do not need to adjust stabilizer");
            } else {
                float defaultDistance = constraint.getDefaultDistance();
                float defaultFov = constraint.getDefaultFov();
                float xScale = constraint.getXScale();
                float yScale = constraint.getYScale();
                float f2 = (((float) constraintRatio[1]) * 1.0f) / ((float) constraintRatio[0]);
                BMGStabilizer bMGStabilizer = this.f136il;
                if (bMGStabilizer == null) {
                    f114IIiI.e("updateStabilizerByFovAndDistanceIfNeeded(adjust), but stabilizer is null");
                } else if (bMGStabilizer instanceof BMGSequenceStabilizer) {
                    ((BMGSequenceStabilizer) bMGStabilizer).setGyroFilterRenderFovAdjust2(1.0d, (double) defaultDistance, (double) defaultFov, (double) f2, (double) xScale, (double) yScale);
                } else {
                    f114IIiI.w("updateStabilizerByFovAndDistanceIfNeeded(adjust), but stabilizer is not a BMGSequenceStabilizer");
                }
            }
        }
    }
}
