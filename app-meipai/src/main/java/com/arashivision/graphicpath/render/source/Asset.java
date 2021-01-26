package com.arashivision.graphicpath.render.source;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeBuffer;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class Asset extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public Asset(long j2) {
        this(j2, "Asset");
    }

    public static native int getAAAItemSize();

    public static native int getRawExposureItemSize();

    private native long nativeCopyAAAData();

    private native long nativeCopyAAASimulationData();

    private native long nativeCopyAnchorsData();

    private native long nativeCopyExtraFrame(int i2);

    private native long nativeCopyExtraInfo();

    private native long nativeCopyGpsData();

    private native long nativeCopyRawExposureData();

    private native long nativeCopyRawGyroData();

    private native long nativeCopyThumbnailData();

    private native long nativeCopyThumbnailExtData();

    private native boolean nativeGetAssetInfo(AssetInfo assetInfo);

    private native long nativeGetExtraMetadata(String str);

    private native void nativeSetExtraMetadataBuffer(String str, NativeBuffer nativeBuffer);

    private native int nativeWriteFrame(int i2, int i3, NativeBuffer nativeBuffer);

    public native void appendNewExtraInfo(int i2);

    public native String captureCameraName();

    public NativeBuffer copyAAAData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyAAAData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyAAASimulationData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyAAASimulationData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyAnchorsData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyAnchorsData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyExtraFrame(int i2) {
        long nativeCopyExtraFrame = nativeCopyExtraFrame(i2);
        if (nativeCopyExtraFrame == 0) {
            return null;
        }
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyExtraFrame);
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyExtraInfo() {
        long nativeCopyExtraInfo = nativeCopyExtraInfo();
        if (nativeCopyExtraInfo == 0) {
            return null;
        }
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyExtraInfo);
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyGpsData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyGpsData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyRawExposureData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyRawExposureData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyRawGyroData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyRawGyroData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyThumbnailData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyThumbnailData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyThumbnailExtData() {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyThumbnailExtData());
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public NativeBuffer copyTimelapseRawDataInTimestampRange(TimeRange timeRange) {
        NativeBuffer nativeBuffer = new NativeBuffer(nativeCopyTimelapseRawDataInTimestampRange(timeRange.Begin(), timeRange.Length()));
        if (nativeBuffer.size() == 0) {
            return null;
        }
        return nativeBuffer;
    }

    public void deleteMetadata(String str) {
        if (str != null) {
            nativeDeleteMetadata(str);
            return;
        }
        throw null;
    }

    public boolean getAssetInfo(AssetInfo assetInfo) {
        return nativeGetAssetInfo(assetInfo);
    }

    public native long getExposureDataSize();

    public native long getExtraFramePositin(int i2);

    public native int getExtraFrameSize(int i2);

    public native long getExtraInfoPos();

    public native long getExtraInfoSize();

    public MetadataValue getExtraMetadata(String str) {
        if (str == null) {
            throw null;
        } else if (!hasMetadata(str)) {
            return null;
        } else {
            NativeBuffer nativeBuffer = new NativeBuffer(nativeGetExtraMetadata(str));
            if (nativeBuffer.size() == 0) {
                return null;
            }
            return new MetadataValue(nativeBuffer);
        }
    }

    public native long getGyroDataSize();

    public native int getHeight();

    public native String getOffset();

    public native int getWidth();

    public boolean hasMetadata(String str) {
        if (str != null) {
            return nativeHasMetadata(str);
        }
        throw null;
    }

    public native boolean isBulletTimeVideo();

    public native boolean isFisheye3D();

    public native boolean isInsFormat();

    public native boolean isPanoramaFormat();

    public native boolean isVideo();

    public native long nativeCopyTimelapseRawDataInTimestampRange(double d2, double d3);

    public native void nativeDeleteMetadata(String str);

    public native boolean nativeHasMetadata(String str);

    public boolean parse() {
        return parse(MetadataOption.kAll);
    }

    public native boolean parse(int i2);

    public native void reset();

    public native void save();

    public void setExtraMetadata(String str, MetadataValue metadataValue) {
        if (str == null || metadataValue == null) {
            throw null;
        }
        nativeSetExtraMetadataBuffer(str, metadataValue.getBuffer());
    }

    public int writeFrame(int i2, int i3, NativeBuffer nativeBuffer) {
        return nativeWriteFrame(i2, i3, nativeBuffer);
    }

    public Asset(long j2, String str) {
        super(j2, str);
    }
}
