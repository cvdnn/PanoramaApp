package com.arashivision.arvbmg.render.gyro;

import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.insbase.nativeref.NativeBuffer;

public final class BMGSequenceStabilizer extends BMGStabilizer {
    public SequenceStabilizerCallback mSequenceStabilizerCallback = new SequenceStabilizerCallback() {
        public void onLoadingProgress(long j2, long j3) {
        }
    };

    public interface SequenceStabilizerCallback {
        void onLoadingProgress(long j2, long j3);
    }

    public BMGSequenceStabilizer(long j2) {
        super(j2);
    }

    private native void nativeCancelLoad();

    private native double nativeCheckLookUpRate(double d2, float f2, float f3, float f4);

    private native float nativeGetDelayTimeMs();

    private native long nativeGetSerializedStabilizerBuffer();

    private native boolean nativeIsLoadedFromSerializedStabilizerBuffer();

    private native boolean nativeResetFrameTimestampInMs2(double[] dArr, boolean z);

    public static native BMGSequenceStabilizer nativeResolveSequenceStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions);

    private native void nativeSetBatchConsumeCount(long j2);

    private native void nativeSetBidirectionOptimize(boolean z);

    private native void nativeSetFixedCacheSize(int i2);

    private native void nativeSetGyroFilterRenderFovAdjust(double d2, double d3);

    private native void nativeSetGyroFilterRenderFovAdjust2(double d2, double d3, double d4, double d5, double d6, double d7);

    private native void nativeSetSourceOffset(String str);

    private void notifyLoadProgress(long j2, long j3) {
        SequenceStabilizerCallback sequenceStabilizerCallback = this.mSequenceStabilizerCallback;
        if (sequenceStabilizerCallback != null) {
            sequenceStabilizerCallback.onLoadingProgress(j2, j3);
        }
    }

    public static BMGSequenceStabilizer resolveSequenceStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        return nativeResolveSequenceStabilizer(asset, resolveGyroOptions);
    }

    public void cancelLoad() {
        nativeCancelLoad();
    }

    public double checkLookUpRate(double d2, float f2, float f3, float f4) {
        return nativeCheckLookUpRate(d2, f2, f3, f4);
    }

    public float getDelayTimeMs() {
        return nativeGetDelayTimeMs();
    }

    public NativeBuffer getSerializedStabilizerBuffer() {
        long nativeGetSerializedStabilizerBuffer = nativeGetSerializedStabilizerBuffer();
        if (nativeGetSerializedStabilizerBuffer == 0) {
            return null;
        }
        return new NativeBuffer(nativeGetSerializedStabilizerBuffer);
    }

    public boolean isLoadedFromSerializedStabilizerBuffer() {
        return nativeIsLoadedFromSerializedStabilizerBuffer();
    }

    public native boolean nativeResetFrameTimestampInMs(long[] jArr, boolean z);

    public boolean resetFrameTimestampInMs(long[] jArr, boolean z) {
        return nativeResetFrameTimestampInMs(jArr, z);
    }

    public boolean resetFrameTimestampInMs2(double[] dArr, boolean z) {
        return nativeResetFrameTimestampInMs2(dArr, z);
    }

    public void setBatchConsumeCount(long j2) {
        nativeSetBatchConsumeCount(j2);
    }

    public void setBidirectionOptimize(boolean z) {
        nativeSetBidirectionOptimize(z);
    }

    public void setFixedCacheSize(int i2) {
        nativeSetFixedCacheSize(i2);
    }

    public void setGyroFilterRenderFovAdjust(double d2, double d3) {
        nativeSetGyroFilterRenderFovAdjust(d2, d3);
    }

    public void setGyroFilterRenderFovAdjust2(double d2, double d3, double d4, double d5, double d6, double d7) {
        nativeSetGyroFilterRenderFovAdjust2(d2, d3, d4, d5, d6, d7);
    }

    public void setSequenceStabilizerCallback(SequenceStabilizerCallback sequenceStabilizerCallback) {
        this.mSequenceStabilizerCallback = sequenceStabilizerCallback;
    }

    public void setSourceOffset(String str) {
        nativeSetSourceOffset(str);
    }
}
