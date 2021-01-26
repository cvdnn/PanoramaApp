package com.arashivision.graphicpath.render.util;

import com.arashivision.graphicpath.render.Stabilization.GyroRawItem;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.ResolveGyroOptions;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.nativeref.NativeBuffer;

public class SequenceStabilizer extends Stabilizer {
    public SequenceStabilizerCallback mSequenceStabilizerCallback = new SequenceStabilizerCallback() {
        public void onLoadingProgress(long j2, long j3) {
        }
    };

    public static class GaitType {
        public static final int DRIVING = 8;
        public static final int RUNNING = 4;
        public static final int RUNNING_AND_WALKING = 6;
        public static final int STILL = 1;
        public static final int UNKNOW = 256;
        public static final int WALKING = 2;
    }

    public interface SequenceStabilizerCallback {
        void onLoadingProgress(long j2, long j3);
    }

    public SequenceStabilizer(long j2) {
        super(j2, "SequenceStabilizer");
    }

    public static int getMainRotationFromGyroData(GyroRawItem[] gyroRawItemArr, String str, int i2, double d2) {
        return nativeGetMainRotationFromGyroData(GyroRawItem.ToByteArray(gyroRawItemArr), gyroRawItemArr.length, str, i2, d2);
    }

    public static native int nativeGetMainRotationFromGyroData(byte[] bArr, int i2, String str, int i3, double d2);

    private native boolean nativeResetFrameTimestampInMs(long[] jArr, boolean z);

    private native boolean nativeResetFrameTimestampInMs2(double[] dArr, boolean z);

    public static native SequenceStabilizer nativeResolveSequenceStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions);

    private void notifyLoadProgress(long j2, long j3) {
        this.mSequenceStabilizerCallback.onLoadingProgress(j2, j3);
    }

    public static SequenceStabilizer resolveSequenceStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        return nativeResolveSequenceStabilizer(asset, resolveGyroOptions);
    }

    public void cancelLoad() {
        quitLoading();
    }

    public native double checkLookUpRate(double d2, float f2, float f3, float f4);

    public native float getDelayTimeMs();

    public native int getFilterType();

    public native int getGaitType();

    public native int getQueueBufferSize();

    public NativeBuffer getSerializedStabilizerBuffer() {
        long nativeGetSerializedStabilizerBuffer = nativeGetSerializedStabilizerBuffer();
        if (nativeGetSerializedStabilizerBuffer == 0) {
            return null;
        }
        return new NativeBuffer(nativeGetSerializedStabilizerBuffer);
    }

    public native boolean isLoadedFromSerializedStabilizerBuffer();

    public native boolean isPreparedForRealtimeAntiShake(long j2);

    public native long nativeGetSerializedStabilizerBuffer();

    public native void nativeSetOnlineKFCenterViewportAndSmoothFactor(float[] fArr, double d2, double d3);

    public native void quitLoading();

    public boolean resetFrameTimestampInMs(long[] jArr, boolean z) {
        return nativeResetFrameTimestampInMs(jArr, z);
    }

    public boolean resetFrameTimestampInMs2(double[] dArr, boolean z) {
        return nativeResetFrameTimestampInMs2(dArr, z);
    }

    public native void setBatchConsumeCount(long j2);

    public native void setBidirectionOptimize(boolean z);

    public native void setDelayTimeMs(float f2);

    public native void setDurationForSlidingWindowFilter(int i2, double d2);

    public native void setFixedCacheSize(int i2);

    public native void setGyroFilterRenderFovAdjust(double d2, double d3);

    public void setGyroFilterRenderFovAdjust2(double d2, double d3, double d4, double d5) {
        setGyroFilterRenderFovAdjust2(d2, d3, d4, d5, 1.0d, 1.0d);
    }

    public native void setGyroFilterRenderFovAdjust2(double d2, double d3, double d4, double d5, double d6, double d7);

    public void setLoadProgressCallback(SequenceStabilizerCallback sequenceStabilizerCallback) {
        this.mSequenceStabilizerCallback = sequenceStabilizerCallback;
    }

    public void setOnlineKFCenterViewportAndSmoothFactor(Vector3f vector3f, double d2, double d3) {
        nativeSetOnlineKFCenterViewportAndSmoothFactor(new float[]{vector3f.x(), vector3f.y(), vector3f.z()}, d2, d3);
    }

    public native void setQueueBufferSize(int i2);

    public void setSequenceStabilizerCallback(SequenceStabilizerCallback sequenceStabilizerCallback) {
        this.mSequenceStabilizerCallback = sequenceStabilizerCallback;
    }

    public native void setSourceOffset(String str);
}
