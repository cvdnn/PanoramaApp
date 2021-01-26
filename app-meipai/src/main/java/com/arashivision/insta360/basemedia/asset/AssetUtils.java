package com.arashivision.insta360.basemedia.asset;

import a.a.a.a.b.a;
import a.a.a.a.b.d;
import a.a.a.a.b.e;
import a.a.a.a.b.f;
import android.text.TextUtils;
import android.util.Log;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.graphicpath.render.source.ExtraInfoAsset;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.source.MetadataValue;
import com.arashivision.insbase.nativeref.NativeBuffer;
import java.nio.ByteBuffer;

public class AssetUtils {
    public static final int CALIBRATE_MODE_DEFAULT = 0;
    public static final int CALIBRATE_MODE_DIRECTIONAL = 5;
    public static final int CALIBRATE_MODE_FOCUS_TO_CAMERA_BASE_ROTATION = 4;
    public static final int CALIBRATE_MODE_NO = 1;
    public static final int CALIBRATE_MODE_NORMAL = 2;
    public static final int CALIBRATE_MODE_REMOVE_YAW = 3;

    public static int I1I(Asset asset, String str) {
        if (asset != null) {
            MetadataValue ILil = ILil(asset, str);
            if (ILil != null) {
                return a.c(ILil.getBufferOfBytes(), 0);
            }
        }
        return 0;
    }

    public static void IL1Iii(Asset asset, String str, String str2) {
        if (asset == null || TextUtils.isEmpty(str)) {
            Log.e("AssetUtils", "setExtraMetaData failed: Illegal arguments ! ");
            return;
        }
        synchronized (asset) {
            if (str2 != null) {
                asset.setExtraMetadata(str, new MetadataValue(str2));
            } else {
                asset.deleteMetadata(str);
            }
        }
    }

    public static void IL1Iii(Asset asset, String str, byte[] bArr) {
        if (asset == null || TextUtils.isEmpty(str)) {
            Log.e("AssetUtils", "setExtraMetaData failed: Illegal arguments ! ");
            return;
        }
        synchronized (asset) {
            if (bArr != null) {
                if (bArr.length > 0) {
                    asset.setExtraMetadata(str, new MetadataValue(bArr, 0));
                }
            }
            asset.deleteMetadata(str);
        }
    }

    public static boolean IL1Iii(Asset asset, String str) {
        if (asset == null) {
            return false;
        }
        MetadataValue ILil = ILil(asset, str);
        if (ILil == null) {
            return false;
        }
        byte[] bufferOfBytes = ILil.getBufferOfBytes();
        if (bufferOfBytes != null && bufferOfBytes.length != 0) {
            return bufferOfBytes[0] != 0;
        }
        Log.e("ByteConvertUtils", "byte[] is null : no this key");
        return false;
    }

    public static MetadataValue ILil(Asset asset, String str) {
        MetadataValue extraMetadata;
        if (asset == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (asset) {
            extraMetadata = asset.getExtraMetadata(str);
        }
        return extraMetadata;
    }

    public static long Ilil(Asset asset, String str) {
        if (asset != null) {
            MetadataValue ILil = ILil(asset, str);
            if (ILil != null) {
                return a.a(ILil.getBufferOfBytes(), 0);
            }
        }
        return 0;
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public static int[] m2IL(Asset asset, String str) {
        int[] iArr = null;
        if (asset != null) {
            MetadataValue ILil = ILil(asset, str);
            if (ILil != null) {
                byte[] bufferOfBytes = ILil.getBufferOfBytes();
                if (!(bufferOfBytes == null || bufferOfBytes.length == 0)) {
                    int length = bufferOfBytes.length / 4;
                    iArr = new int[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = a.c(bufferOfBytes, i2 * 4);
                    }
                }
            }
        }
        return iArr;
    }

    public static ExtraInfoAsset convert(byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.clear();
        allocateDirect.put(bArr);
        ExtraInfoAsset extraInfoAsset = new ExtraInfoAsset(allocateDirect);
        extraInfoAsset.parse(1);
        return extraInfoAsset;
    }

    public static byte[] convert(Asset asset) {
        NativeBuffer copyExtraFrame = asset.copyExtraFrame(1);
        if (copyExtraFrame != null) {
            return copyExtraFrame.get(0, (int) copyExtraFrame.size(), new byte[((int) copyExtraFrame.size())], 0);
        }
        return null;
    }

    public static NativeBuffer copyExtraFrame(Asset asset, int i2) {
        NativeBuffer copyExtraFrame;
        synchronized (asset) {
            copyExtraFrame = asset.copyExtraFrame(i2);
        }
        return copyExtraFrame;
    }

    public static AssetInfo getAssetInfo(Asset asset) {
        AssetInfo assetInfo;
        synchronized (asset) {
            assetInfo = new AssetInfo();
            asset.getAssetInfo(assetInfo);
        }
        return assetInfo;
    }

    public static int getBatteryType(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kBatteryType);
    }

    public static String getBeautifyFilter(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kBeautifyFilter);
    }

    public static int getCameraPosture(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kCameraPosture);
    }

    public static String getCameraType(Asset asset) {
        return m3lLi1LL(asset, "camera_type");
    }

    public static long getCreationTime(Asset asset) {
        return Ilil(asset, ExtraMetadataKey.kCreationTime);
    }

    public static int[] getDimension(Asset asset) {
        return m2IL(asset, ExtraMetadataKey.kDimension);
    }

    public static e getEuler(Asset asset) {
        MetadataValue ILil = ILil(asset, ExtraMetadataKey.kEuler);
        if (ILil != null) {
            return new e(ILil.getBufferOfBytes());
        }
        return null;
    }

    public static String getExifMetadata(ImageAsset imageAsset, String str) {
        String exifMetadata;
        if (imageAsset == null) {
            return null;
        }
        synchronized (imageAsset) {
            exifMetadata = imageAsset.getExifMetadata(str);
        }
        return exifMetadata;
    }

    public static long getExtraFramePos(Asset asset, int i2) {
        long extraFramePositin;
        synchronized (asset) {
            extraFramePositin = asset.getExtraFramePositin(i2);
        }
        return extraFramePositin;
    }

    public static long getExtraFrameSize(Asset asset, int i2) {
        long extraFrameSize;
        synchronized (asset) {
            extraFrameSize = (long) asset.getExtraFrameSize(i2);
        }
        return extraFrameSize;
    }

    public static long getExtraInfoPos(Asset asset) {
        long extraInfoPos;
        synchronized (asset) {
            extraInfoPos = asset.getExtraInfoPos();
        }
        return extraInfoPos;
    }

    public static long getExtraInfoSize(Asset asset) {
        long extraInfoSize;
        synchronized (asset) {
            extraInfoSize = asset.getExtraInfoSize();
        }
        return extraInfoSize;
    }

    public static String getFWVersion(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kFwVersion);
    }

    public static String getFileGroupIdentify(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kFileGroupInfoIdentify);
    }

    public static int getFileGroupIndex(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kFileGroupInfoIndex);
    }

    public static long getFileSize(Asset asset) {
        return Ilil(asset, ExtraMetadataKey.kFileSize);
    }

    public static String getFilter(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kFilter);
    }

    public static long getFirstFrameTimestamp(Asset asset) {
        return Ilil(asset, ExtraMetadataKey.kFirstFrameTimestamp);
    }

    public static long getFirstGpsTimestamp(Asset asset) {
        return Ilil(asset, ExtraMetadataKey.kFirstGpsTimestamp);
    }

    public static int getFovType(Asset asset) {
        return I1I(asset, "fov_type");
    }

    public static int getFrameRate(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kFrameRate);
    }

    public static String getGammaMode(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kGammaMode);
    }

    public static d getGps(Asset asset) {
        MetadataValue ILil = ILil(asset, ExtraMetadataKey.kGps);
        if (ILil != null) {
            return new d(ILil.getBufferOfBytes());
        }
        return null;
    }

    public static GyroInfo getGyro(Asset asset) {
        MetadataValue ILil = ILil(asset, ExtraMetadataKey.kGyro);
        if (ILil != null) {
            return new GyroInfo(ILil.getBufferOfBytes());
        }
        return null;
    }

    public static long getGyroDataSize(Asset asset) {
        long gyroDataSize;
        synchronized (asset) {
            gyroDataSize = asset.getGyroDataSize();
        }
        return gyroDataSize;
    }

    public static double getGyroDelayTime(Asset asset) {
        if (asset != null) {
            MetadataValue ILil = ILil(asset, ExtraMetadataKey.kGyroDelayTime);
            if (ILil != null) {
                return a.b(ILil.getBufferOfBytes(), 0);
            }
        }
        return 0.0d;
    }

    public static int getHeight(Asset asset) {
        int height;
        synchronized (asset) {
            height = asset.getHeight();
        }
        return height;
    }

    public static String getIp(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kIp);
    }

    public static int getLogoType(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kLogoType);
    }

    public static String getLutFilter(Asset asset) {
        return m3lLi1LL(asset, "lut_filter");
    }

    public static String getOffset(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kOffset);
    }

    public static int[] getOffsetConvertStates(Asset asset) {
        return m2IL(asset, ExtraMetadataKey.kOffsetConvertStates);
    }

    public static String getOriginalOffset(Asset asset) {
        return m3lLi1LL(asset, ExtraMetadataKey.kOriginalOffset);
    }

    public static int[] getResolutionSize(Asset asset) {
        return m2IL(asset, ExtraMetadataKey.kResolutionSize);
    }

    public static String getSerialNumber(Asset asset) {
        return m3lLi1LL(asset, "serial_number");
    }

    public static int getSubMediaType(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kFileSubMediaType);
    }

    public static int getTotalTime(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kTotalTime);
    }

    public static long getTotalTimeInS(Asset asset) {
        return (long) I1I(asset, ExtraMetadataKey.kTotalTime);
    }

    public static int getTriggerSource(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kTriggerSource);
    }

    public static int getVideoGyroMode(Asset asset) {
        return I1I(asset, ExtraMetadataKey.kGyroCalibrateMode);
    }

    public static int getWidth(Asset asset) {
        int width;
        synchronized (asset) {
            width = asset.getWidth();
        }
        return width;
    }

    public static f getWindowCropInfo(Asset asset) {
        MetadataValue ILil = ILil(asset, ExtraMetadataKey.kWindowCropInfo);
        if (ILil != null) {
            return new f(ILil.getBufferOfBytes());
        }
        return null;
    }

    public static String getXmpMetadata(ImageAsset imageAsset, String str) {
        String xmpMetadata;
        if (imageAsset == null) {
            return null;
        }
        synchronized (imageAsset) {
            xmpMetadata = imageAsset.getXmpMetadata(str);
        }
        return xmpMetadata;
    }

    public static boolean hasAAAList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(9) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasAnchorList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(10) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasExposureList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(4) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasGpsList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(7) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasGyroList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(3) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasThumbnail(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(2) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasThumbnailExt(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(5) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean hasTimeLapseList(Asset asset) {
        boolean z = false;
        if (asset == null) {
            return false;
        }
        synchronized (asset) {
            if (asset.getExtraFrameSize(6) > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isEulerEnabled(Asset asset) {
        return IL1Iii(asset, ExtraMetadataKey.kEnableEuler);
    }

    public static boolean isInsFormat(Asset asset) {
        boolean isInsFormat;
        synchronized (asset) {
            isInsFormat = asset.isInsFormat();
        }
        return isInsFormat;
    }

    public static boolean isPanoramaFormat(Asset asset) {
        boolean isPanoramaFormat;
        synchronized (asset) {
            isPanoramaFormat = asset.isPanoramaFormat();
        }
        return isPanoramaFormat;
    }

    public static boolean isRemovePurpleBoundary(Asset asset) {
        return IL1Iii(asset, ExtraMetadataKey.kRemovePurple);
    }

    public static boolean isSelfie(Asset asset) {
        return IL1Iii(asset, "is_selfie");
    }

    public static boolean isStabilizedInCamera(Asset asset) {
        return IL1Iii(asset, ExtraMetadataKey.kIsFlowstateOnline);
    }

    public static boolean isVideo(Asset asset) {
        boolean isVideo;
        synchronized (asset) {
            isVideo = asset.isVideo();
        }
        return isVideo;
    }

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public static String m3lLi1LL(Asset asset, String str) {
        if (asset != null) {
            MetadataValue ILil = ILil(asset, str);
            if (ILil != null) {
                return ILil.getString();
            }
        }
        return "";
    }

    public static void save(Asset asset) {
        synchronized (asset) {
            asset.save();
        }
    }

    public static void setBeautifyFilter(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kBeautifyFilter, str);
    }

    public static void setCameraType(Asset asset, String str) {
        IL1Iii(asset, "camera_type", str);
    }

    public static void setCreationTime(Asset asset, long j2) {
        IL1Iii(asset, ExtraMetadataKey.kCreationTime, a.a(j2));
    }

    public static void setEuler(Asset asset, e eVar) {
        if (eVar == null) {
            eVar = new e();
        }
        byte[] bArr = new byte[24];
        System.arraycopy(a.a(Double.doubleToLongBits(eVar.f421a)), 0, bArr, 0, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(eVar.f422b)), 0, bArr, 8, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(eVar.f423c)), 0, bArr, 16, 8);
        IL1Iii(asset, ExtraMetadataKey.kEuler, bArr);
    }

    public static void setFWVersion(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kFwVersion, str);
    }

    public static void setFilter(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kFilter, str);
    }

    public static void setGps(Asset asset, d dVar) {
        if (dVar == null) {
            dVar = new d();
        }
        byte[] bArr = new byte[24];
        System.arraycopy(a.a(Double.doubleToLongBits(dVar.f418a)), 0, bArr, 0, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(dVar.f419b)), 0, bArr, 8, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(dVar.f420c)), 0, bArr, 16, 8);
        IL1Iii(asset, ExtraMetadataKey.kGps, bArr);
    }

    public static void setIp(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kIp, str);
    }

    public static void setLogoType(Asset asset, int i2) {
        IL1Iii(asset, ExtraMetadataKey.kLogoType, a.a(i2));
    }

    public static void setLutFilter(Asset asset, String str) {
        IL1Iii(asset, "lut_filter", str);
    }

    public static void setOffset(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kOffset, str);
    }

    public static void setOffsetConvertStates(Asset asset, int[] iArr) {
        byte[] bArr;
        if (iArr == null || iArr.length == 0) {
            bArr = null;
        } else {
            bArr = new byte[(iArr.length * 4)];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = i2 * 4;
                System.arraycopy(a.a(iArr[i2]), 0, bArr, i3, i3 + 4);
            }
        }
        IL1Iii(asset, ExtraMetadataKey.kOffsetConvertStates, bArr);
    }

    public static void setOriginalOffset(Asset asset, String str) {
        IL1Iii(asset, ExtraMetadataKey.kOriginalOffset, str);
    }

    public static void setRemovePurpleBoundary(Asset asset, boolean z) {
        IL1Iii(asset, ExtraMetadataKey.kRemovePurple, new byte[]{z ? (byte) 1 : 0});
    }

    public static void setSelfie(Asset asset, boolean z) {
        IL1Iii(asset, "is_selfie", new byte[]{z ? (byte) 1 : 0});
    }

    public static void setSerialNumber(Asset asset, String str) {
        IL1Iii(asset, "serial_number", str);
    }

    public static void setVideoGyroMode(Asset asset, int i2) {
        IL1Iii(asset, ExtraMetadataKey.kGyroCalibrateMode, a.a(i2));
    }
}
