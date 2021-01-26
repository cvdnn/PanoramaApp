package com.arashivision.insta360.basemedia.model.work;

import a.a.a.a.a.d.b;
import a.a.a.a.a.f.a.a;
import a.a.a.a.b.c;
import a.a.a.a.b.d;
import a.a.a.a.b.e;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGSingleGyroStabilizer;
import com.arashivision.arvbmg.render.gyro.ResolveGyroOptions;
import com.arashivision.graphicpath.render.Stabilization.GyroRawItem;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.graphicpath.render.source.AutoStitcherLib;
import com.arashivision.graphicpath.render.source.ExtraInfoAsset;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.source.TimeRange;
import com.arashivision.graphicpath.render.source.VideoAsset;
import com.arashivision.insbase.nativeref.NativeBuffer;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.asset.GyroInfo;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.CameraType;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.util.FileUtils;
import com.arashivision.onecamera.OneDriverInfo.RecordFormat;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.views.SmsLoginView.f;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Work implements Comparable<Work> {

    /* renamed from: I丨iL reason: contains not printable characters */
    public static final MediaLogger f55IiL = MediaLogger.getLogger(Work.class);
    public boolean[] I1I;
    public String[] IL1Iii;
    public String[] ILil;
    public Asset[] Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public a[] f56IL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public int f57iILLL1;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f58lLi1LL;

    public interface IL1Iii {
        void IL1Iii(Work work, int i2);
    }

    public Work(String[] strArr) {
        this.IL1Iii = strArr;
        this.I1I = new boolean[strArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.I1I;
            if (i3 >= zArr.length) {
                break;
            }
            zArr[i3] = false;
            i3++;
        }
        this.f56IL = new a[strArr.length];
        while (true) {
            a[] aVarArr = this.f56IL;
            if (i2 < aVarArr.length) {
                aVarArr[i2] = new a();
                i2++;
            } else {
                this.Ilil = new Asset[strArr.length];
                return;
            }
        }
    }

    public final synchronized boolean I1I(int i2) {
        boolean z = false;
        if (!isValid()) {
            return false;
        }
        if (this.I1I[i2]) {
            return true;
        }
        MediaLogger mediaLogger = f55IiL;
        StringBuilder sb = new StringBuilder();
        sb.append("loadExtra before ");
        sb.append(getIdenticalKey(i2));
        mediaLogger.i(sb.toString());
        long uptimeMillis = SystemClock.uptimeMillis();
        Asset IL1Iii2 = IL1Iii(i2);
        int IL1Iii3 = IL1Iii();
        if (isValid()) {
            z = IL1Iii2.parse(IL1Iii3);
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        MediaLogger mediaLogger2 = f55IiL;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadExtra after ");
        sb2.append(getIdenticalKey(i2));
        mediaLogger2.i(sb2.toString());
        MediaLogger mediaLogger3 = f55IiL;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("loadExtraData ");
        sb3.append(z ? f.k : LivenessStat.TYPE_FACE_MATCH_FAIL);
        sb3.append(", cost time ");
        sb3.append(uptimeMillis2 - uptimeMillis);
        sb3.append("ms");
        mediaLogger3.i(sb3.toString());
        this.Ilil[i2] = IL1Iii2;
        this.f56IL[i2] = new a();
        this.I1I[i2] = z;
        return z;
    }

    public abstract int IL1Iii();

    public Asset IL1Iii(int i2) {
        String urlForParse = getUrlForParse(i2);
        return (a.a.a.a.b.a.a((CharSequence) urlForParse, (CharSequence) "insv") || a.a.a.a.b.a.a((CharSequence) urlForParse, (CharSequence) RecordFormat.VIDEO_FORMAT_MP4)) ? new VideoAsset(urlForParse) : new ImageAsset(urlForParse);
    }

    public void IL1Iii(Asset[] assetArr) {
        int i2 = 0;
        while (true) {
            Asset[] assetArr2 = this.Ilil;
            if (i2 < assetArr2.length) {
                if (assetArr == null || i2 >= assetArr.length || assetArr[i2] == null) {
                    this.Ilil[i2] = IL1Iii(i2);
                    Asset asset = this.Ilil[i2];
                    if (isValid()) {
                        asset.parse(1);
                    }
                } else {
                    assetArr2[i2] = assetArr[i2];
                }
                i2++;
            } else {
                this.f58lLi1LL = true;
                this.f57iILLL1 = 0;
                return;
            }
        }
    }

    public final int ILil(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].p == null) {
            aVarArr[i2].p = Integer.valueOf(AssetUtils.getSubMediaType(this.Ilil[i2]));
        }
        return this.f56IL[i2].p.intValue();
    }

    public boolean adjustStabilizerByFovAndDistance() {
        return adjustStabilizerByFovAndDistance(getIndex());
    }

    public boolean adjustStabilizerByFovAndDistance(int i2) {
        int ordinal = CameraType.getForType(getCameraType(i2)).ordinal();
        boolean z = true;
        if (ordinal == 4) {
            if (getFileType(i2) != FileType.FISH_EYE) {
                z = false;
            }
            return z;
        } else if (ordinal != 5) {
            return false;
        } else {
            return !isStaticTimeLapse(i2);
        }
    }

    public int compareTo(Work work) {
        return getCreationTime(this.f57iILLL1) - work.getCreationTime(work.f57iILLL1) > 0 ? 1 : -1;
    }

    public ExtraInfoAsset copyExtraMetaData() {
        return copyExtraMetaData(isForceIndexTo0() ? 0 : getIndex());
    }

    public ExtraInfoAsset copyExtraMetaData(int i2) {
        NativeBuffer copyExtraFrame = AssetUtils.copyExtraFrame(this.Ilil[i2], 1);
        if (copyExtraFrame == null) {
            return null;
        }
        byte[] bArr = copyExtraFrame.get(0, (int) copyExtraFrame.size(), new byte[((int) copyExtraFrame.size())], 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.clear();
        allocateDirect.put(bArr);
        return new ExtraInfoAsset(allocateDirect);
    }

    public AssetInfo getAssetInfo() {
        return getAssetInfo(getIndex());
    }

    public AssetInfo getAssetInfo(int i2) {
        return AssetUtils.getAssetInfo(this.Ilil[i2]);
    }

    public int getBatteryType(int i2) {
        return AssetUtils.getBatteryType(this.Ilil[i2]);
    }

    public int getBeautyFilterLevel() {
        return getBeautyFilterLevel(isForceIndexTo0() ? 0 : getIndex());
    }

    public int getBeautyFilterLevel(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].l == null) {
            aVarArr[i2].l = Integer.valueOf(a.a.a.a.d.a.b(AssetUtils.getBeautifyFilter(this.Ilil[i2])));
        }
        return this.f56IL[i2].l.intValue();
    }

    public int getBitrate() {
        return getBitrate(getIndex());
    }

    public int getBitrate(int i2) {
        if (isVideo(i2)) {
            Asset[] assetArr = this.Ilil;
            if (!(assetArr[i2] instanceof ExtraInfoAsset) && (assetArr[i2] instanceof VideoAsset)) {
                return (int) ((VideoAsset) assetArr[i2]).bitrate();
            }
        }
        return 0;
    }

    public int getCameraLensType() {
        return getCameraLensType(isForceIndexTo0() ? 0 : getIndex());
    }

    public int getCameraLensType(int i2) {
        return AutoStitcherLib.ResolveLensTypeFromOffset(getMediaOffset(i2));
    }

    public String getCameraType() {
        return getCameraType(isForceIndexTo0() ? 0 : getIndex());
    }

    public String getCameraType(int i2) {
        return AssetUtils.getCameraType(this.Ilil[i2]);
    }

    public int getCount() {
        if (isIntervalShooting(0) || isBurst(0)) {
            return this.IL1Iii.length;
        }
        return 1;
    }

    public long getCreationTime() {
        return getCreationTime(getIndex());
    }

    public abstract long getCreationTime(int i2);

    public long getDurationInMs() {
        return getDurationInMs(getIndex());
    }

    public long getDurationInMs(int i2) {
        if (isVideo(i2)) {
            Asset[] assetArr = this.Ilil;
            if (assetArr[i2] instanceof ExtraInfoAsset) {
                return (long) (((double) AssetUtils.getTotalTimeInS(assetArr[i2])) * 1000.0d);
            }
            if (assetArr[i2] instanceof VideoAsset) {
                long videoDurationS = (long) (((VideoAsset) assetArr[i2]).videoDurationS() * 1000.0d);
                if (getFps() > 0.0d) {
                    long fps = (long) (((double) videoDurationS) - ((1000.0d / getFps()) * 2.5d));
                    if (fps > 0) {
                        videoDurationS = fps;
                    }
                }
                return videoDurationS;
            }
        }
        return 0;
    }

    public long getDurationInS() {
        return getDurationInS(getIndex());
    }

    public long getDurationInS(int i2) {
        if (isVideo(i2)) {
            Asset[] assetArr = this.Ilil;
            if (assetArr[i2] instanceof ExtraInfoAsset) {
                return AssetUtils.getTotalTimeInS(assetArr[i2]);
            }
            if (assetArr[i2] instanceof VideoAsset) {
                return (long) ((VideoAsset) assetArr[i2]).videoDurationS();
            }
        }
        return 0;
    }

    public String getExifMetadata(int i2, String str) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            if (assetArr[i2] instanceof ImageAsset) {
                return AssetUtils.getExifMetadata((ImageAsset) assetArr[i2], str);
            }
            f55IiL.e("getExifMetadata, but asset is not ImageAsset");
        }
        return null;
    }

    public String getExifMetadata(String str) {
        return getExifMetadata(getIndex(), str);
    }

    public long getExtraDurationInMs() {
        return getExtraDurationInMs(getIndex());
    }

    public long getExtraDurationInMs(int i2) {
        if (isVideo(i2)) {
            return (long) (((double) AssetUtils.getTotalTimeInS(this.Ilil[i2])) * 1000.0d);
        }
        return 0;
    }

    public long getExtraFramePos(int i2) {
        return getExtraFramePos(getIndex(), i2);
    }

    public long getExtraFramePos(int i2, int i3) {
        return AssetUtils.getExtraFramePos(this.Ilil[i2], i3);
    }

    public long getExtraFrameSize(int i2) {
        return getExtraFrameSize(getIndex(), i2);
    }

    public long getExtraFrameSize(int i2, int i3) {
        return AssetUtils.getExtraFrameSize(this.Ilil[i2], i3);
    }

    public long getExtraInfoPos() {
        return getExtraInfoPos(getIndex());
    }

    public long getExtraInfoPos(int i2) {
        return AssetUtils.getExtraInfoPos(this.Ilil[i2]);
    }

    public long getExtraInfoSize() {
        return getExtraInfoSize(getIndex());
    }

    public long getExtraInfoSize(int i2) {
        return AssetUtils.getExtraInfoSize(this.Ilil[i2]);
    }

    public FileType getFileType() {
        return getFileType(getIndex());
    }

    public FileType getFileType(int i2) {
        int ordinal = CameraType.getForType(getCameraType(i2)).ordinal();
        if (!(ordinal == 1 || ordinal == 2)) {
            if (ordinal == 4) {
                switch (getCameraLensType(i2)) {
                    case 33:
                        return FileType.VR360;
                    case 34:
                    case 35:
                        String urlForParse = getUrlForParse(i2);
                        return (a.a.a.a.b.a.a((CharSequence) urlForParse, (CharSequence) ".insv") || a.a.a.a.b.a.a((CharSequence) urlForParse, (CharSequence) ".insp")) ? FileType.FISH_EYE : FileType.UNPANORAMA;
                    default:
                        MediaLogger mediaLogger = f55IiL;
                        StringBuilder a2 = e.a.a.a.a.a("getFileType, but unknown camera lens type: ");
                        a2.append(getCameraLensType(i2));
                        mediaLogger.d(a2.toString());
                        return FileType.UNPANORAMA;
                }
            } else if (ordinal == 5) {
                return getFps(i2) >= 90.0d ? FileType.UNPANORAMA : FileType.FISH_EYE;
            } else {
                if (ordinal != 6) {
                    return FileType.UNPANORAMA;
                }
            }
        }
        return FileType.VR360;
    }

    public long getFirstFrameTimeStamp() {
        return getFirstFrameTimeStamp(getIndex());
    }

    public long getFirstFrameTimeStamp(int i2) {
        return AssetUtils.getFirstFrameTimestamp(this.Ilil[i2]);
    }

    public long getFirstGpsTimeStamp() {
        return getFirstGpsTimeStamp(getIndex());
    }

    public long getFirstGpsTimeStamp(int i2) {
        return AssetUtils.getFirstGpsTimestamp(this.Ilil[i2]);
    }

    public long getFirstGpsTimeStampFormatted(int i2, List<a.a.a.a.a.a.a> list) {
        if (getFirstGpsTimeStamp(i2) > 0) {
            return getFirstGpsTimeStamp(i2);
        }
        if (list == null || list.size() <= 0) {
            return 0;
        }
        if (((a.a.a.a.a.a.a) list.get(list.size() - 1)) != null) {
            return (((long) 0) + 0) - getDurationInMs(i2);
        }
        throw null;
    }

    public long getFirstGpsTimeStampFormatted(List<a.a.a.a.a.a.a> list) {
        return getFirstGpsTimeStampFormatted(getIndex(), list);
    }

    public int getFovType() {
        return getFovType(isForceIndexTo0() ? 0 : getIndex());
    }

    public int getFovType(int i2) {
        return AssetUtils.getFovType(this.Ilil[i2]);
    }

    public double getFps() {
        return getFps(getIndex());
    }

    public double getFps(int i2) {
        a aVar;
        a aVar2;
        double videoFramerate;
        if (this.f56IL[i2].m == null) {
            if (isPhoto(i2)) {
                aVar = this.f56IL[i2];
            } else {
                Asset[] assetArr = this.Ilil;
                if (assetArr[i2] instanceof ExtraInfoAsset) {
                    aVar2 = this.f56IL[i2];
                    videoFramerate = (double) AssetUtils.getFrameRate(assetArr[i2]);
                } else if (assetArr[i2] instanceof VideoAsset) {
                    aVar2 = this.f56IL[i2];
                    videoFramerate = ((VideoAsset) assetArr[i2]).videoFramerate();
                } else {
                    aVar = this.f56IL[i2];
                }
                aVar2.m = Double.valueOf(videoFramerate);
            }
            aVar.m = Double.valueOf(0.0d);
        }
        return this.f56IL[i2].m.doubleValue();
    }

    public String getFwVersion() {
        return getFwVersion(getIndex());
    }

    public String getFwVersion(int i2) {
        return AssetUtils.getFWVersion(this.Ilil[i2]);
    }

    public d getGps() {
        return getGps(getIndex());
    }

    public d getGps(int i2) {
        return AssetUtils.getGps(this.Ilil[i2]);
    }

    public double getGyroDelayTime() {
        return getGyroDelayTime(getIndex());
    }

    public double getGyroDelayTime(int i2) {
        return AssetUtils.getGyroDelayTime(this.Ilil[i2]);
    }

    public GyroInfo[] getGyroInfo() {
        return getGyroInfo(getIndex());
    }

    public GyroInfo[] getGyroInfo(int i2) {
        NativeBuffer copyRawGyroData = this.Ilil[i2].copyRawGyroData();
        GyroRawItem[] FromByteArray = GyroRawItem.FromByteArray(copyRawGyroData.get(0, (int) copyRawGyroData.size(), new byte[((int) copyRawGyroData.size())], 0));
        ArrayList arrayList = new ArrayList();
        long firstFrameTimeStamp = getFirstFrameTimeStamp(i2);
        for (GyroRawItem gyroRawItem : FromByteArray) {
            if (gyroRawItem.timestamp >= firstFrameTimeStamp) {
                GyroInfo gyroInfo = new GyroInfo();
                gyroInfo.setAccelerate_x(gyroRawItem.AccelerationX);
                gyroInfo.setAccelerate_y(gyroRawItem.AccelerationY);
                gyroInfo.setAccelerate_z(gyroRawItem.AccelerationZ);
                gyroInfo.setRotation_x(gyroRawItem.RotationX);
                gyroInfo.setRotation_y(gyroRawItem.RotationY);
                gyroInfo.setRotation_z(gyroRawItem.RotationZ);
                gyroInfo.setTimestamp(gyroRawItem.timestamp);
                arrayList.add(gyroInfo);
            }
        }
        return (GyroInfo[]) arrayList.toArray(new GyroInfo[0]);
    }

    public int getHeight() {
        return getHeight(isForceIndexTo0() ? 0 : getIndex());
    }

    public int getHeight(int i2) {
        if (this.f56IL[i2].f373e == null) {
            int[] resolutionSize = AssetUtils.getResolutionSize(this.Ilil[i2]);
            int i3 = 0;
            this.f56IL[i2].f373e = Integer.valueOf(resolutionSize != null ? resolutionSize[1] : 0);
            if (this.f56IL[i2].f373e.intValue() <= 0) {
                this.f56IL[i2].f373e = Integer.valueOf(AssetUtils.getHeight(this.Ilil[i2]));
                if (this.f56IL[i2].f373e.intValue() <= 0) {
                    int[] dimension = AssetUtils.getDimension(this.Ilil[i2]);
                    a aVar = this.f56IL[i2];
                    if (dimension != null) {
                        i3 = dimension[1];
                    }
                    aVar.f373e = Integer.valueOf(i3);
                }
            }
        }
        return this.f56IL[i2].f373e.intValue();
    }

    public int getHeightOrigin() {
        return getHeightOrigin(getIndex());
    }

    public int getHeightOrigin(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f371c == null) {
            aVarArr[i2].f371c = Integer.valueOf(AssetUtils.getHeight(this.Ilil[i2]));
            if (this.f56IL[i2].f371c.intValue() <= 0) {
                int[] dimension = AssetUtils.getDimension(this.Ilil[i2]);
                this.f56IL[i2].f371c = Integer.valueOf(dimension != null ? dimension[1] : 0);
            }
        }
        return this.f56IL[i2].f371c.intValue();
    }

    public String getIdenticalKey() {
        return getIdenticalKey(isForceIndexTo0() ? 0 : getIndex());
    }

    public String getIdenticalKey(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(getUrlsForPlay(i2)));
        sb.append(isLogoEnabled(i2));
        sb.append(isRemovePurpleBoundary(i2));
        sb.append(getStabType(i2));
        sb.append(isEulerEnabled(i2));
        sb.append(getMediaOffset(i2));
        sb.append(getOriginalOffset(i2));
        sb.append(getHeight(i2));
        sb.append(getWidth(i2));
        if (((b) getLutFilter(i2)) != null) {
            sb.append("LutOff");
            if (((a.a.a.a.a.g.b) getStyleFilter(i2)) != null) {
                sb.append("Original");
                sb.append(getStyleFilterIntensity(i2));
                sb.append(getBeautyFilterLevel(i2));
                return sb.toString();
            }
            throw null;
        }
        throw null;
    }

    public int getIndex() {
        return this.f57iILLL1;
    }

    public int getIntervalShootingMaxSize() {
        return getUrls().length;
    }

    public a.a.a.a.a.d.a getLutFilter() {
        return getLutFilter(isForceIndexTo0() ? 0 : getIndex());
    }

    public a.a.a.a.a.d.a getLutFilter(int i2) {
        a.a.a.a.a.d.a aVar;
        a aVar2;
        if (!isVideo(i2) || !isLog(i2)) {
            aVar2 = this.f56IL[i2];
            aVar = b.a();
        } else {
            aVar2 = this.f56IL[i2];
            aVar = a.a.a.a.d.a.c(AssetUtils.getLutFilter(this.Ilil[i2]));
        }
        aVar2.f377i = aVar;
        return this.f56IL[i2].f377i;
    }

    public String getMediaOffset() {
        return getMediaOffset(getIndex());
    }

    public String getMediaOffset(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f369a == null) {
            aVarArr[i2].f369a = AssetUtils.getOffset(this.Ilil[i2]);
        }
        return this.f56IL[i2].f369a;
    }

    public String getName() {
        return getName(isForceIndexTo0() ? 0 : getIndex());
    }

    public abstract String getName(int i2);

    public String getOffset() {
        return getOffset(getIndex());
    }

    public String getOffset(int i2) {
        return getFileType(i2) == FileType.UNPANORAMA ? "" : getMediaOffset(i2);
    }

    public ArrayList<a.a.a.a.b.b> getOffsetConvertStates() {
        return getOffsetConvertStates(getIndex());
    }

    public ArrayList<a.a.a.a.b.b> getOffsetConvertStates(int i2) {
        int[] offsetConvertStates = AssetUtils.getOffsetConvertStates(this.Ilil[i2]);
        ArrayList<a.a.a.a.b.b> arrayList = new ArrayList<>();
        if (offsetConvertStates == null) {
            return arrayList;
        }
        for (int a2 : offsetConvertStates) {
            arrayList.add(a.a.a.a.b.b.a(a2));
        }
        return arrayList;
    }

    public String getOriginalOffset() {
        return getOriginalOffset(getIndex());
    }

    public String getOriginalOffset(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f376h == null) {
            aVarArr[i2].f376h = AssetUtils.getOriginalOffset(this.Ilil[i2]);
        }
        return this.f56IL[i2].f376h;
    }

    public abstract String[] getRawUrls();

    public String[] getRawUrlsForDelete() {
        return this.ILil;
    }

    public abstract String[] getRawUrlsForPlay(int i2);

    public int getRotateDegree() {
        return getRotateDegree(getIndex());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getRotateDegree(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.getCameraType(r5)
            com.arashivision.insta360.basemedia.model.CameraType r0 = com.arashivision.insta360.basemedia.model.CameraType.getForType(r0)
            int r0 = r0.ordinal()
            r1 = 360(0x168, float:5.04E-43)
            r2 = 0
            r3 = 4
            if (r0 == r3) goto L_0x002d
            r3 = 5
            if (r0 == r3) goto L_0x0016
            return r2
        L_0x0016:
            com.arashivision.graphicpath.render.source.AssetInfo r5 = r4.getAssetInfo(r5)
            if (r5 == 0) goto L_0x0025
            java.lang.Integer r5 = r5.planeRotationDegree
            if (r5 == 0) goto L_0x0025
            int r5 = r5.intValue()
            goto L_0x0026
        L_0x0025:
            r5 = r2
        L_0x0026:
            int r5 = 360 - r5
            if (r5 != r1) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = r5
        L_0x002c:
            return r2
        L_0x002d:
            com.arashivision.insta360.basemedia.model.FileType r0 = r4.getFileType(r5)
            com.arashivision.insta360.basemedia.model.FileType r3 = com.arashivision.insta360.basemedia.model.FileType.UNPANORAMA
            if (r0 == r3) goto L_0x003b
            com.arashivision.insta360.basemedia.model.FileType r3 = com.arashivision.insta360.basemedia.model.FileType.FISH_EYE
            if (r0 != r3) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            return r2
        L_0x003b:
            com.arashivision.insta360.basemedia.model.FileType r3 = com.arashivision.insta360.basemedia.model.FileType.UNPANORAMA
            if (r0 != r3) goto L_0x0045
            boolean r3 = r4.isSelfie(r5)
            if (r3 == 0) goto L_0x004f
        L_0x0045:
            com.arashivision.insta360.basemedia.model.FileType r3 = com.arashivision.insta360.basemedia.model.FileType.FISH_EYE
            if (r0 != r3) goto L_0x0051
            boolean r0 = r4.isSelfie(r5)
            if (r0 == 0) goto L_0x0051
        L_0x004f:
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            if (r0 == 0) goto L_0x0065
            com.arashivision.graphicpath.render.source.Asset[] r0 = r4.Ilil
            r5 = r0[r5]
            int r5 = com.arashivision.insta360.basemedia.asset.AssetUtils.getCameraPosture(r5)
            int r5 = r5 * 90
            int r5 = 360 - r5
            if (r5 != r1) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r2 = r5
        L_0x0064:
            return r2
        L_0x0065:
            com.arashivision.graphicpath.render.source.Asset[] r0 = r4.Ilil
            r5 = r0[r5]
            int r5 = com.arashivision.insta360.basemedia.asset.AssetUtils.getCameraPosture(r5)
            int r5 = r5 * 90
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.model.work.Work.getRotateDegree(int):int");
    }

    public BMGSequenceStabilizer getSequenceStabilizer(int i2, boolean z, NativeBuffer nativeBuffer, a.a.a.a.a.f.b bVar) {
        ResolveGyroOptions resolveGyroOptions = new ResolveGyroOptions();
        resolveGyroOptions.setLoad(false);
        resolveGyroOptions.setReadInStreamMode(z);
        resolveGyroOptions.setReadBatchCount(51200);
        if (nativeBuffer != null) {
            resolveGyroOptions.setLoad(true);
            resolveGyroOptions.setNativeBuffer(nativeBuffer);
        }
        if (TextUtils.isEmpty(getMediaOffset(i2))) {
            return null;
        }
        bVar.b(this.Ilil[i2]);
        BMGSequenceStabilizer resolveSequenceStabilizer = BMGSequenceStabilizer.resolveSequenceStabilizer(this.Ilil[i2], resolveGyroOptions);
        bVar.a(this.Ilil[i2]);
        return resolveSequenceStabilizer;
    }

    public BMGSequenceStabilizer getSequenceStabilizer(boolean z, NativeBuffer nativeBuffer, a.a.a.a.a.f.b bVar) {
        return getSequenceStabilizer(getIndex(), z, nativeBuffer, bVar);
    }

    public String getSerial() {
        return getSerial(getIndex());
    }

    public String getSerial(int i2) {
        return AssetUtils.getSerialNumber(this.Ilil[i2]);
    }

    public BMGSingleGyroStabilizer getSingleStabilizer(int i2, a.a.a.a.a.f.b bVar) {
        ResolveGyroOptions resolveGyroOptions = new ResolveGyroOptions();
        resolveGyroOptions.setLoad(true);
        resolveGyroOptions.setReadInStreamMode(false);
        if (TextUtils.isEmpty(getMediaOffset(i2))) {
            return null;
        }
        bVar.b(this.Ilil[i2]);
        BMGSingleGyroStabilizer resolveSingleStabilizer = BMGSingleGyroStabilizer.resolveSingleStabilizer(this.Ilil[i2], resolveGyroOptions);
        bVar.a(this.Ilil[i2]);
        return resolveSingleStabilizer;
    }

    public BMGSingleGyroStabilizer getSingleStabilizer(a.a.a.a.a.f.b bVar) {
        return getSingleStabilizer(getIndex(), bVar);
    }

    public int getStabType() {
        return getStabType(isForceIndexTo0() ? 0 : getIndex());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r9 != 5) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (r9 != 5) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r9 != 5) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getStabType(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.getCameraType(r9)
            com.arashivision.insta360.basemedia.model.FileType r1 = r8.getFileType(r9)
            boolean r2 = r8.isBulletTime(r9)
            com.arashivision.graphicpath.render.source.Asset[] r3 = r8.Ilil
            r9 = r3[r9]
            int r9 = com.arashivision.insta360.basemedia.asset.AssetUtils.getVideoGyroMode(r9)
            com.arashivision.insta360.basemedia.model.CameraType r0 = com.arashivision.insta360.basemedia.model.CameraType.getForType(r0)
            int r0 = r0.ordinal()
            r3 = 4
            r4 = 5
            r5 = 2
            r6 = 1
            if (r0 == r6) goto L_0x0059
            r7 = 3
            if (r0 == r5) goto L_0x0045
            if (r0 == r3) goto L_0x0045
            if (r0 == r4) goto L_0x0039
            r2 = 6
            if (r0 == r2) goto L_0x002d
            goto L_0x006c
        L_0x002d:
            int r0 = r1.ordinal()
            if (r0 == r5) goto L_0x0034
            goto L_0x006c
        L_0x0034:
            if (r9 == r6) goto L_0x006c
            if (r9 == r4) goto L_0x006a
            goto L_0x0068
        L_0x0039:
            int r0 = r1.ordinal()
            if (r0 == r7) goto L_0x0040
            goto L_0x006c
        L_0x0040:
            if (r9 == r6) goto L_0x006c
            if (r9 == r5) goto L_0x006d
            goto L_0x006a
        L_0x0045:
            int r0 = r1.ordinal()
            if (r0 == r5) goto L_0x0051
            if (r0 == r7) goto L_0x004e
            goto L_0x006c
        L_0x004e:
            if (r9 == r6) goto L_0x006c
            goto L_0x006d
        L_0x0051:
            if (r2 == 0) goto L_0x0054
            goto L_0x0062
        L_0x0054:
            if (r9 == r6) goto L_0x006c
            if (r9 == r4) goto L_0x006a
            goto L_0x0068
        L_0x0059:
            int r0 = r1.ordinal()
            if (r0 == r5) goto L_0x0060
            goto L_0x006c
        L_0x0060:
            if (r2 == 0) goto L_0x0064
        L_0x0062:
            r3 = r4
            goto L_0x006d
        L_0x0064:
            if (r9 == r6) goto L_0x006c
            if (r9 == r4) goto L_0x006a
        L_0x0068:
            r3 = 0
            goto L_0x006d
        L_0x006a:
            r3 = r5
            goto L_0x006d
        L_0x006c:
            r3 = -1
        L_0x006d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.model.work.Work.getStabType(int):int");
    }

    public StabilizingType getStabilizingType() {
        return getStabilizingType(getIndex());
    }

    public StabilizingType getStabilizingType(int i2) {
        return hasGyroList(i2) ? StabilizingType.DYNAMIC_VERTEX : StabilizingType.NO;
    }

    public a.a.a.a.a.g.a getStyleFilter() {
        return getStyleFilter(isForceIndexTo0() ? 0 : getIndex());
    }

    public a.a.a.a.a.g.a getStyleFilter(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f378j == null) {
            aVarArr[i2].f378j = a.a.a.a.d.a.a(AssetUtils.getFilter(this.Ilil[i2]));
        }
        return this.f56IL[i2].f378j;
    }

    public float getStyleFilterIntensity() {
        return getStyleFilterIntensity(isForceIndexTo0() ? 0 : getIndex());
    }

    public float getStyleFilterIntensity(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].k == null) {
            aVarArr[i2].k = Float.valueOf(a.a.a.a.d.a.d(AssetUtils.getFilter(this.Ilil[i2])));
        }
        return this.f56IL[i2].k.floatValue();
    }

    public abstract long getTotalSize();

    public String getUrlForParse() {
        return getUrlForParse(isForceIndexTo0() ? 0 : getIndex());
    }

    public abstract String getUrlForParse(int i2);

    public abstract String[] getUrls();

    public String[] getUrlsForDelete() {
        return this.IL1Iii;
    }

    public String[] getUrlsForPlay() {
        return getUrlsForPlay(getIndex());
    }

    public abstract String[] getUrlsForPlay(int i2);

    public int getWidth() {
        return getWidth(isForceIndexTo0() ? 0 : getIndex());
    }

    public int getWidth(int i2) {
        if (this.f56IL[i2].f372d == null) {
            int[] resolutionSize = AssetUtils.getResolutionSize(this.Ilil[i2]);
            int i3 = 0;
            this.f56IL[i2].f372d = Integer.valueOf(resolutionSize != null ? resolutionSize[0] : 0);
            if (this.f56IL[i2].f372d.intValue() <= 0) {
                this.f56IL[i2].f372d = Integer.valueOf(AssetUtils.getWidth(this.Ilil[i2]));
                if (this.f56IL[i2].f372d.intValue() <= 0) {
                    int[] dimension = AssetUtils.getDimension(this.Ilil[i2]);
                    a aVar = this.f56IL[i2];
                    if (dimension != null) {
                        i3 = dimension[0];
                    }
                    aVar.f372d = Integer.valueOf(i3);
                }
            }
            if (isDualStream(i2)) {
                a[] aVarArr = this.f56IL;
                aVarArr[i2].f372d = Integer.valueOf(aVarArr[i2].f372d.intValue() * 2);
            }
        }
        return this.f56IL[i2].f372d.intValue();
    }

    public int getWidthOrigin() {
        return getWidthOrigin(getIndex());
    }

    public int getWidthOrigin(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f370b == null) {
            aVarArr[i2].f370b = Integer.valueOf(AssetUtils.getWidth(this.Ilil[i2]));
            if (this.f56IL[i2].f370b.intValue() <= 0) {
                int[] dimension = AssetUtils.getDimension(this.Ilil[i2]);
                a aVar = this.f56IL[i2];
                int i3 = 0;
                if (dimension != null) {
                    i3 = dimension[0];
                }
                aVar.f370b = Integer.valueOf(i3);
            }
            if (isDualStream(i2)) {
                a[] aVarArr2 = this.f56IL;
                aVarArr2[i2].f370b = Integer.valueOf(aVarArr2[i2].f370b.intValue() * 2);
            }
        }
        return this.f56IL[i2].f370b.intValue();
    }

    public a.a.a.a.b.f getWindowCropInfo() {
        return getWindowCropInfo(getIndex());
    }

    public a.a.a.a.b.f getWindowCropInfo(int i2) {
        return AssetUtils.getWindowCropInfo(this.Ilil[i2]);
    }

    public String getXmpMetadata(int i2, String str) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            if (assetArr[i2] instanceof ImageAsset) {
                return AssetUtils.getXmpMetadata((ImageAsset) assetArr[i2], str);
            }
            f55IiL.e("getXmpMetadata, but asset is not ImageAsset");
        }
        return null;
    }

    public String getXmpMetadata(String str) {
        return getXmpMetadata(getIndex(), str);
    }

    public boolean hasAAAList() {
        return hasAAAList(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean hasAAAList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasAAAList(assetArr[i2]);
        }
        return false;
    }

    public boolean hasAnchorList() {
        return hasAnchorList(getIndex());
    }

    public boolean hasAnchorList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasAnchorList(assetArr[i2]);
        }
        return false;
    }

    public boolean hasAudio() {
        return hasAudio(getIndex());
    }

    public boolean hasAudio(int i2) {
        if (isVideo(i2)) {
            Asset[] assetArr = this.Ilil;
            if (!(assetArr[i2] instanceof ExtraInfoAsset) && (assetArr[i2] instanceof VideoAsset)) {
                return ((VideoAsset) assetArr[i2]).hasAudio();
            }
        }
        return false;
    }

    public boolean hasExposureList() {
        return hasExposureList(getIndex());
    }

    public boolean hasExposureList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasExposureList(assetArr[i2]);
        }
        return false;
    }

    public boolean hasGpsList() {
        return hasGpsList(getIndex());
    }

    public boolean hasGpsList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasGpsList(assetArr[i2]);
        }
        return false;
    }

    public boolean hasGyroList() {
        return hasGyroList(getIndex());
    }

    public boolean hasGyroList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasGyroList(assetArr[i2]);
        }
        return false;
    }

    public boolean hasOffset() {
        return hasOffset(getIndex());
    }

    public boolean hasOffset(int i2) {
        return !TextUtils.isEmpty(getOffset(i2));
    }

    public boolean hasThumbnail() {
        return hasThumbnail(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean hasThumbnail(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasThumbnail(assetArr[i2]);
        }
        return false;
    }

    public boolean hasThumbnailExt() {
        return hasThumbnailExt(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean hasThumbnailExt(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasThumbnailExt(assetArr[i2]);
        }
        return false;
    }

    public boolean hasTimeLapseList() {
        return hasTimeLapseList(getIndex());
    }

    public boolean hasTimeLapseList(int i2) {
        Asset[] assetArr = this.Ilil;
        if (assetArr != null) {
            return AssetUtils.hasTimeLapseList(assetArr[i2]);
        }
        return false;
    }

    public boolean inputGyroBySegment() {
        return inputGyroBySegment(getIndex());
    }

    public boolean inputGyroBySegment(int i2) {
        return isVideo(i2) && (isTimeLapse(i2) || isStaticTimeLapse(i2)) && (AssetUtils.getGyroDataSize(this.Ilil[i2]) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS > 150;
    }

    public boolean isAntiShakeEnabled() {
        return isAntiShakeEnabled(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean isAntiShakeEnabled(int i2) {
        return getStabType(i2) != -1;
    }

    public boolean isBulletTime() {
        return isBulletTime(getIndex());
    }

    public boolean isBulletTime(int i2) {
        return isVideo(i2) && ILil(i2) == c.VIDEO_BULLETTIME.f417a;
    }

    public boolean isBurst() {
        return isBurst(getIndex());
    }

    public boolean isBurst(int i2) {
        return ILil(i2) == c.PHOTO_BURST.f417a;
    }

    public boolean isDualStream() {
        return isDualStream(getIndex());
    }

    public boolean isDualStream(int i2) {
        return getUrlsForPlay(i2).length == 2;
    }

    public boolean isEulerEnabled() {
        return isEulerEnabled(getIndex());
    }

    public boolean isEulerEnabled(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f375g == null) {
            aVarArr[i2].f375g = Boolean.valueOf(AssetUtils.isEulerEnabled(this.Ilil[i2]));
        }
        return this.f56IL[i2].f375g.booleanValue();
    }

    public boolean isExtraDataLoaded() {
        return isExtraDataLoaded(getIndex());
    }

    public boolean isExtraDataLoaded(int i2) {
        return this.I1I[i2];
    }

    public boolean isForceIndexTo0() {
        return this.f58lLi1LL;
    }

    public boolean isFps(double d2) {
        return isFps(getIndex(), d2);
    }

    public boolean isFps(int i2, double d2) {
        double fps = getFps(i2);
        return fps >= d2 - 5.0d && fps <= d2 + 5.0d;
    }

    public boolean isHDRPhoto() {
        return isHDRPhoto(getIndex());
    }

    public boolean isHDRPhoto(int i2) {
        return isPhoto(i2) && ILil(i2) == c.PHOTO_HDR.f417a;
    }

    public boolean isHDRVideo() {
        return isHDRVideo(getIndex());
    }

    public boolean isHDRVideo(int i2) {
        return isVideo(i2) && ILil(i2) == c.VIDEO_HDR.f417a;
    }

    public boolean isInstaMedia() {
        return isInstaMedia(getIndex());
    }

    public abstract boolean isInstaMedia(int i2);

    public boolean isIntervalShooting() {
        return isIntervalShooting(getIndex());
    }

    public boolean isIntervalShooting(int i2) {
        return ILil(i2) == c.PHOTO_INTERVALSHOOTING.f417a;
    }

    public boolean isLog() {
        return isLog(getIndex());
    }

    public boolean isLog(int i2) {
        String gammaMode = AssetUtils.getGammaMode(this.Ilil[i2]);
        return gammaMode != null && gammaMode.equals("log");
    }

    public boolean isLogoEnabled() {
        return isLogoEnabled(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean isLogoEnabled(int i2) {
        return false;
    }

    public boolean isLrv() {
        return FileUtils.getFileUrlName(getUrlForParse()).startsWith("LRV");
    }

    public boolean isMJpeg() {
        return isMJpeg(getIndex());
    }

    public boolean isMJpeg(int i2) {
        if (!isVideo(i2) || CameraType.getForType(getCameraType(i2)).ordinal() != 5) {
            return false;
        }
        return isStaticTimeLapse(i2);
    }

    public boolean isPhoto() {
        return isPhoto(getIndex());
    }

    public boolean isPhoto(int i2) {
        return !isVideo(i2);
    }

    public boolean isRaw() {
        return isRaw(getIndex());
    }

    public boolean isRaw(int i2) {
        return getRawUrls() != null && getRawUrls().length > 0;
    }

    public boolean isRemovePurpleBoundary() {
        return isRemovePurpleBoundary(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean isRemovePurpleBoundary(int i2) {
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].f374f == null) {
            aVarArr[i2].f374f = Boolean.valueOf(AssetUtils.isRemovePurpleBoundary(this.Ilil[i2]));
        }
        return this.f56IL[i2].f374f.booleanValue();
    }

    public boolean isSelfie() {
        return isSelfie(getIndex());
    }

    public boolean isSelfie(int i2) {
        return AssetUtils.isSelfie(this.Ilil[i2]);
    }

    public boolean isSlowMo() {
        return isSlowMo(getIndex());
    }

    @Deprecated
    public boolean isSlowMo(int i2) {
        boolean z = false;
        if (isVideo(i2)) {
            if (CameraType.getForType(getCameraType(i2)).ordinal() != 5) {
                return false;
            }
            if (ILil(i2) == c.VIDEO_NORMAL.f417a && getFps(i2) >= 90.0d) {
                z = true;
            }
        }
        return z;
    }

    public boolean isStabilizedInCamera() {
        return isStabilizedInCamera(getIndex());
    }

    public boolean isStabilizedInCamera(int i2) {
        return AssetUtils.isStabilizedInCamera(this.Ilil[i2]);
    }

    public boolean isStaticTimeLapse() {
        return isStaticTimeLapse(getIndex());
    }

    public boolean isStaticTimeLapse(int i2) {
        return isVideo(i2) && ILil(i2) == c.VIDEO_STATIC_TIMELAPSE.f417a;
    }

    public boolean isSuperNight() {
        return isSuperNight(getIndex());
    }

    public boolean isSuperNight(int i2) {
        return isPhoto(i2) && ILil(i2) == c.PHOTO_AEB_NIGHT_MODE.f417a;
    }

    public boolean isTimeLapse() {
        return isTimeLapse(getIndex());
    }

    public boolean isTimeLapse(int i2) {
        return isVideo(i2) && ILil(i2) == c.VIDEO_TIMELAPSE.f417a;
    }

    public boolean isTimeShift() {
        return isTimeShift(getIndex());
    }

    public boolean isTimeShift(int i2) {
        return ILil(i2) == c.VIDEO_TIMESHIFT.f417a;
    }

    public abstract boolean isValid();

    public boolean isVideo() {
        return isVideo(getIndex());
    }

    public boolean isVideo(int i2) {
        boolean z;
        a aVar;
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].o == null) {
            Asset[] assetArr = this.Ilil;
            if (assetArr[i2] instanceof ExtraInfoAsset) {
                aVar = aVarArr[i2];
                z = a.a.a.a.b.a.a((CharSequence) getUrlForParse(i2), (CharSequence) "insv") || a.a.a.a.b.a.a((CharSequence) getUrlForParse(i2), (CharSequence) RecordFormat.VIDEO_FORMAT_MP4);
            } else {
                aVar = aVarArr[i2];
                z = AssetUtils.isVideo(assetArr[i2]);
            }
            aVar.o = Boolean.valueOf(z);
        }
        return this.f56IL[i2].o.booleanValue();
    }

    public boolean isWideAngle() {
        return isWideAngle(getIndex());
    }

    public boolean isWideAngle(int i2) {
        boolean z = false;
        if (CameraType.getForType(getCameraType(i2)).ordinal() != 4) {
            return false;
        }
        if (getFileType(i2) == FileType.FISH_EYE) {
            z = true;
        }
        return z;
    }

    public byte[] loadAAA() {
        return loadAAA(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadAAA(int i2) {
        NativeBuffer copyAAAData = this.Ilil[i2].copyAAAData();
        if (copyAAAData == null) {
            return null;
        }
        return copyAAAData.get(0, (int) copyAAAData.size(), new byte[((int) copyAAAData.size())], 0);
    }

    public byte[] loadAnchor() {
        return loadAnchor(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadAnchor(int i2) {
        NativeBuffer copyAnchorsData = this.Ilil[i2].copyAnchorsData();
        if (copyAnchorsData == null) {
            return null;
        }
        return copyAnchorsData.get(0, (int) copyAnchorsData.size(), new byte[((int) copyAnchorsData.size())], 0);
    }

    public byte[] loadExposure() {
        return loadExposure(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadExposure(int i2) {
        NativeBuffer copyRawExposureData = this.Ilil[i2].copyRawExposureData();
        if (copyRawExposureData == null) {
            return null;
        }
        return copyRawExposureData.get(0, (int) copyRawExposureData.size(), new byte[((int) copyRawExposureData.size())], 0);
    }

    public boolean loadExtraData() {
        return loadExtraData(getIndex());
    }

    public boolean loadExtraData(int i2) {
        if (i2 == 0 || !isForceIndexTo0()) {
            return I1I(i2);
        }
        boolean z = false;
        if (I1I(i2) && I1I(0)) {
            z = true;
        }
        return z;
    }

    public byte[] loadGps() {
        return loadGps(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadGps(int i2) {
        NativeBuffer copyGpsData = this.Ilil[i2].copyGpsData();
        if (copyGpsData == null) {
            return null;
        }
        return copyGpsData.get(0, (int) copyGpsData.size(), new byte[((int) copyGpsData.size())], 0);
    }

    public byte[] loadThumbnail() {
        return loadThumbnail(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadThumbnail(int i2) {
        NativeBuffer copyThumbnailData = this.Ilil[i2].copyThumbnailData();
        if (copyThumbnailData == null) {
            return null;
        }
        return copyThumbnailData.get(0, (int) copyThumbnailData.size(), new byte[((int) copyThumbnailData.size())], 0);
    }

    public byte[] loadThumbnailExt() {
        return loadThumbnailExt(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadThumbnailExt(int i2) {
        NativeBuffer copyThumbnailExtData = this.Ilil[i2].copyThumbnailExtData();
        if (copyThumbnailExtData == null) {
            return null;
        }
        return copyThumbnailExtData.get(0, (int) copyThumbnailExtData.size(), new byte[((int) copyThumbnailExtData.size())], 0);
    }

    public byte[] loadTimeLapse() {
        return loadTimeLapse(isForceIndexTo0() ? 0 : getIndex());
    }

    public byte[] loadTimeLapse(int i2) {
        NativeBuffer copyTimelapseRawDataInTimestampRange = this.Ilil[i2].copyTimelapseRawDataInTimestampRange(new TimeRange(0.0d, 0.0d));
        if (copyTimelapseRawDataInTimestampRange == null) {
            return null;
        }
        return copyTimelapseRawDataInTimestampRange.get(0, (int) copyTimelapseRawDataInTimestampRange.size(), new byte[((int) copyTimelapseRawDataInTimestampRange.size())], 0);
    }

    public boolean needLogo() {
        return needLogo(isForceIndexTo0() ? 0 : getIndex());
    }

    public boolean needLogo(int i2) {
        return false;
    }

    public abstract void save(int i2, IL1Iii iL1Iii);

    public Work setBeautyFilterLevel(int i2) {
        return setBeautyFilterLevel(isForceIndexTo0() ? 0 : getIndex(), i2);
    }

    public Work setBeautyFilterLevel(int i2, int i3) {
        this.f56IL[i2].l = Integer.valueOf(i3);
        AssetUtils.setBeautifyFilter(this.Ilil[i2], a.a.a.a.d.a.a(i3));
        return this;
    }

    public Work setEuler(int i2, e eVar) {
        AssetUtils.setEuler(this.Ilil[i2], eVar);
        return this;
    }

    public Work setEuler(e eVar) {
        return setEuler(isForceIndexTo0() ? 0 : getIndex(), eVar);
    }

    public void setForceIndexTo0(boolean z) {
        this.f58lLi1LL = z;
    }

    public Work setFwVersion(int i2, String str) {
        AssetUtils.setFWVersion(this.Ilil[i2], str);
        return this;
    }

    public Work setFwVersion(String str) {
        return setFwVersion(isForceIndexTo0() ? 0 : getIndex(), str);
    }

    public Work setGps(int i2, Location location) {
        d dVar = new d();
        if (location != null) {
            dVar.f420c = location.getAltitude();
            dVar.f418a = location.getLatitude();
            dVar.f419b = location.getLongitude();
        }
        AssetUtils.setGps(this.Ilil[i2], dVar);
        return this;
    }

    public Work setGps(Location location) {
        return setGps(isForceIndexTo0() ? 0 : getIndex(), location);
    }

    public Work setIP(int i2, String str) {
        AssetUtils.setIp(this.Ilil[i2], str);
        return this;
    }

    public Work setIP(String str) {
        return setIP(isForceIndexTo0() ? 0 : getIndex(), str);
    }

    public void setIndex(int i2) {
        this.f57iILLL1 = i2;
    }

    public Work setLogoEnabled(int i2, boolean z) {
        return this;
    }

    public Work setLogoEnabled(boolean z) {
        return setLogoEnabled(isForceIndexTo0() ? 0 : getIndex(), z);
    }

    public Work setLutFilter(int i2, a.a.a.a.a.d.a aVar) {
        if (isVideo(i2) && isLog(i2)) {
            this.f56IL[i2].f377i = aVar;
            Asset asset = this.Ilil[i2];
            if (((b) aVar) != null) {
                AssetUtils.setLutFilter(asset, "LutOff");
            } else {
                throw null;
            }
        }
        return this;
    }

    public Work setLutFilter(a.a.a.a.a.d.a aVar) {
        return setLutFilter(isForceIndexTo0() ? 0 : getIndex(), aVar);
    }

    public Work setMediaOffset(int i2, String str) {
        AssetUtils.setOffset(this.Ilil[i2], str);
        return this;
    }

    public Work setMediaOffset(String str) {
        return setMediaOffset(isForceIndexTo0() ? 0 : getIndex(), str);
    }

    public Work setOffsetConvertStates(int i2, List<a.a.a.a.b.b> list) {
        int size = list != null ? list.size() : 0;
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((a.a.a.a.b.b) list.get(i3)).f407a;
        }
        AssetUtils.setOffsetConvertStates(this.Ilil[i2], iArr);
        return this;
    }

    public Work setOffsetConvertStates(List<a.a.a.a.b.b> list) {
        return setOffsetConvertStates(isForceIndexTo0() ? 0 : getIndex(), list);
    }

    public Work setOriginalOffset(int i2, String str) {
        AssetUtils.setOriginalOffset(this.Ilil[i2], str);
        return this;
    }

    public Work setOriginalOffset(String str) {
        return setOriginalOffset(isForceIndexTo0() ? 0 : getIndex(), str);
    }

    public void setRawUrls(String[] strArr) {
        this.ILil = strArr;
    }

    public Work setRemovePurpleBoundary(int i2, boolean z) {
        this.f56IL[i2].f374f = Boolean.valueOf(z);
        AssetUtils.setRemovePurpleBoundary(this.Ilil[i2], z);
        return this;
    }

    public Work setRemovePurpleBoundary(boolean z) {
        return setRemovePurpleBoundary(isForceIndexTo0() ? 0 : getIndex(), z);
    }

    public Work setSerial(int i2, String str) {
        AssetUtils.setSerialNumber(this.Ilil[i2], str);
        return this;
    }

    public Work setSerial(String str) {
        return setSerial(isForceIndexTo0() ? 0 : getIndex(), str);
    }

    public Work setStabType(int i2) {
        return setStabType(isForceIndexTo0() ? 0 : getIndex(), i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r11 != 2) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r11 != 4) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
        if (r11 != 2) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r11 != 2) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.arashivision.insta360.basemedia.model.work.Work setStabType(int r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = r9.getCameraType(r10)
            com.arashivision.insta360.basemedia.model.FileType r1 = r9.getFileType(r10)
            boolean r2 = r9.isBulletTime(r10)
            com.arashivision.insta360.basemedia.model.CameraType r0 = com.arashivision.insta360.basemedia.model.CameraType.getForType(r0)
            int r0 = r0.ordinal()
            r3 = 5
            r4 = 1
            r5 = -1
            r6 = 2
            if (r0 == r4) goto L_0x005b
            r7 = 3
            r8 = 4
            if (r0 == r6) goto L_0x0044
            if (r0 == r8) goto L_0x0044
            if (r0 == r3) goto L_0x0034
            r2 = 6
            if (r0 == r2) goto L_0x0026
            goto L_0x006f
        L_0x0026:
            int r0 = r1.ordinal()
            if (r0 == r6) goto L_0x002d
            goto L_0x006f
        L_0x002d:
            if (r11 == r5) goto L_0x006d
            if (r11 == 0) goto L_0x006b
            if (r11 == r6) goto L_0x0070
            goto L_0x006f
        L_0x0034:
            int r0 = r1.ordinal()
            if (r0 == r7) goto L_0x003b
            goto L_0x006f
        L_0x003b:
            if (r11 == r5) goto L_0x006d
            if (r11 == r6) goto L_0x006b
            if (r11 == r8) goto L_0x0042
            goto L_0x006f
        L_0x0042:
            r3 = r6
            goto L_0x0070
        L_0x0044:
            int r0 = r1.ordinal()
            if (r0 == r6) goto L_0x0052
            if (r0 == r7) goto L_0x004d
            goto L_0x006f
        L_0x004d:
            if (r11 == r5) goto L_0x006d
            if (r11 == r8) goto L_0x006b
            goto L_0x006f
        L_0x0052:
            if (r2 != 0) goto L_0x006f
            if (r11 == r5) goto L_0x006d
            if (r11 == 0) goto L_0x006b
            if (r11 == r6) goto L_0x0070
            goto L_0x006f
        L_0x005b:
            int r0 = r1.ordinal()
            if (r0 == r6) goto L_0x0062
            goto L_0x006f
        L_0x0062:
            if (r2 != 0) goto L_0x006f
            if (r11 == r5) goto L_0x006d
            if (r11 == 0) goto L_0x006b
            if (r11 == r6) goto L_0x0070
            goto L_0x006f
        L_0x006b:
            r3 = 0
            goto L_0x0070
        L_0x006d:
            r3 = r4
            goto L_0x0070
        L_0x006f:
            r3 = r5
        L_0x0070:
            if (r3 < 0) goto L_0x0079
            com.arashivision.graphicpath.render.source.Asset[] r11 = r9.Ilil
            r10 = r11[r10]
            com.arashivision.insta360.basemedia.asset.AssetUtils.setVideoGyroMode(r10, r3)
        L_0x0079:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.model.work.Work.setStabType(int, int):com.arashivision.insta360.basemedia.model.work.Work");
    }

    public Work setStyleFilter(int i2, a.a.a.a.a.g.a aVar) {
        this.f56IL[i2].f378j = aVar;
        AssetUtils.setFilter(this.Ilil[i2], a.a.a.a.d.a.a(aVar, getStyleFilterIntensity(i2)));
        return this;
    }

    public Work setStyleFilter(a.a.a.a.a.g.a aVar) {
        return setStyleFilter(isForceIndexTo0() ? 0 : getIndex(), aVar);
    }

    public Work setStyleFilterIntensity(float f2) {
        return setStyleFilterIntensity(isForceIndexTo0() ? 0 : getIndex(), f2);
    }

    public Work setStyleFilterIntensity(int i2, float f2) {
        this.f56IL[i2].k = Float.valueOf(f2);
        AssetUtils.setFilter(this.Ilil[i2], a.a.a.a.d.a.a(getStyleFilter(i2), f2));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
        sb.append(Arrays.toString(getUrls()));
        return sb.toString();
    }

    public boolean updateStabilizerByFrameTimestampInMs() {
        return updateStabilizerByFrameTimestampInMs(getIndex());
    }

    public boolean updateStabilizerByFrameTimestampInMs(int i2) {
        boolean z = false;
        if (CameraType.getForType(getCameraType(i2)).ordinal() != 4) {
            return false;
        }
        if (getFileType(i2) == FileType.FISH_EYE && !isTimeLapse(i2)) {
            z = true;
        }
        return z;
    }
}
