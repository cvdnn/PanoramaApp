package com.arashivision.graphicpath.render.source;

import android.util.Range;
import com.arashivision.graphicpath.insmedia.common.MediaSampleMeta;
import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.graphicpath.render.Stabilization.RealTimeExposureRawData;
import com.arashivision.graphicpath.render.Stabilization.RealTimeGyroRawData;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.render.util.SequenceStabilizer;
import com.arashivision.graphicpath.render.util.SingleGyroStabilizer;
import com.arashivision.insbase.nativeref.NativeBuffer;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class Source extends NativeObjectRef {

    public static class ResolveGyroOptions {
        public boolean detectStabType = true;
        public boolean load = true;
        public int preferredStabType = 0;
        public long readBatchCount = 8192;
        public boolean readInStreamMode = false;
        public NativeBuffer serializedStabilizerBuffer;
        public Range<Double> timestampRange = null;
    }

    public static class ResolveOffsetOptions {
        public boolean enableDivingAir = false;
        public boolean enableDivingWater = false;
        public boolean enableProtectiveShell = false;
        public boolean enableWaterProof = false;
    }

    static {
        RenderLibsLoader.load();
    }

    public Source(long j2) {
        this(j2, "Source");
    }

    public static SequenceStabilizer createSequenceStabilizer(RealTimeGyroRawData realTimeGyroRawData, RealTimeExposureRawData realTimeExposureRawData, int i2, int i3) {
        long nativeCreateSequenceStabilizer = nativeCreateSequenceStabilizer(realTimeGyroRawData, realTimeExposureRawData, i2, i3);
        if (nativeCreateSequenceStabilizer == 0) {
            return null;
        }
        return new SequenceStabilizer(nativeCreateSequenceStabilizer);
    }

    public static SequenceStabilizer createSequenceStabilizer2(RealTimeGyroRawData realTimeGyroRawData, RealTimeExposureRawData realTimeExposureRawData, int i2, int i3, int i4, int i5) {
        long nativeCreateSequenceStabilizer2 = nativeCreateSequenceStabilizer2(realTimeGyroRawData, realTimeExposureRawData, i2, i3, i4, i5);
        if (nativeCreateSequenceStabilizer2 == 0) {
            return null;
        }
        return new SequenceStabilizer(nativeCreateSequenceStabilizer2);
    }

    public static native long nativeCreateSequenceStabilizer(RealTimeGyroRawData realTimeGyroRawData, RealTimeExposureRawData realTimeExposureRawData, int i2, int i3);

    public static native long nativeCreateSequenceStabilizer2(RealTimeGyroRawData realTimeGyroRawData, RealTimeExposureRawData realTimeExposureRawData, int i2, int i3, int i4, int i5);

    public static native RenderModelType nativeResolveRenderModelType1(Asset asset, RenderModelType renderModelType);

    public static native RenderModelType nativeResolveRenderModelType2(AssetInfo assetInfo, RenderModelType renderModelType);

    public static native String nativeResolveRenderOffset(Asset asset, boolean z, boolean z2, boolean z3, boolean z4);

    public static native String nativeResolveRenderOffset2(AssetInfo assetInfo, boolean z, boolean z2, boolean z3, boolean z4);

    public static native long nativeResolveSequenceStabilizer(Asset asset, boolean z, int i2, boolean z2, long j2, boolean z3, double d2, double d3, NativeBuffer nativeBuffer);

    public static native long nativeResolveSingleGyroStabilizer(Asset asset, boolean z, int i2, boolean z2, long j2, boolean z3, double d2, double d3);

    public static RenderModelType resolveRenderModelType(Asset asset, RenderModelType renderModelType) {
        return nativeResolveRenderModelType1(asset, renderModelType);
    }

    public static String resolveRenderOffset(Asset asset, ResolveOffsetOptions resolveOffsetOptions) {
        return nativeResolveRenderOffset(asset, resolveOffsetOptions.enableProtectiveShell, resolveOffsetOptions.enableWaterProof, resolveOffsetOptions.enableDivingWater, resolveOffsetOptions.enableDivingAir);
    }

    public static native SequenceStabilizer resolveSequenceStabilizer(Asset asset);

    public static SequenceStabilizer resolveSequenceStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        boolean z = resolveGyroOptions.detectStabType;
        int i2 = resolveGyroOptions.preferredStabType;
        boolean z2 = resolveGyroOptions.readInStreamMode;
        long j2 = resolveGyroOptions.readBatchCount;
        boolean z3 = resolveGyroOptions.load;
        Range<Double> range = resolveGyroOptions.timestampRange;
        double d2 = -1.0d;
        double doubleValue = range != null ? ((Double) range.getLower()).doubleValue() : -1.0d;
        Range<Double> range2 = resolveGyroOptions.timestampRange;
        if (range2 != null) {
            d2 = ((Double) range2.getUpper()).doubleValue() - ((Double) resolveGyroOptions.timestampRange.getLower()).doubleValue();
        }
        long nativeResolveSequenceStabilizer = nativeResolveSequenceStabilizer(asset, z, i2, z2, j2, z3, doubleValue, d2, resolveGyroOptions.serializedStabilizerBuffer);
        if (nativeResolveSequenceStabilizer == 0) {
            return null;
        }
        return new SequenceStabilizer(nativeResolveSequenceStabilizer);
    }

    public static native SingleGyroStabilizer resolveSingleGyroStabilizer(Asset asset);

    public static SingleGyroStabilizer resolveSingleGyroStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        long nativeResolveSingleGyroStabilizer = nativeResolveSingleGyroStabilizer(asset, resolveGyroOptions.detectStabType, resolveGyroOptions.preferredStabType, resolveGyroOptions.readInStreamMode, resolveGyroOptions.readBatchCount, resolveGyroOptions.load, ((Double) resolveGyroOptions.timestampRange.getLower()).doubleValue(), ((Double) resolveGyroOptions.timestampRange.getUpper()).doubleValue() - ((Double) resolveGyroOptions.timestampRange.getLower()).doubleValue());
        if (nativeResolveSingleGyroStabilizer == 0) {
            return null;
        }
        return new SingleGyroStabilizer(nativeResolveSingleGyroStabilizer);
    }

    public native MediaSampleMeta getPresentingFrameMeta();

    public native boolean hasUpdate();

    public native void update();

    public Source(long j2, String str) {
        super(j2, str);
    }

    public static RenderModelType resolveRenderModelType(AssetInfo assetInfo, RenderModelType renderModelType) {
        return nativeResolveRenderModelType2(assetInfo, renderModelType);
    }

    public static String resolveRenderOffset(AssetInfo assetInfo, ResolveOffsetOptions resolveOffsetOptions) {
        return nativeResolveRenderOffset2(assetInfo, resolveOffsetOptions.enableProtectiveShell, resolveOffsetOptions.enableWaterProof, resolveOffsetOptions.enableDivingWater, resolveOffsetOptions.enableDivingAir);
    }
}
