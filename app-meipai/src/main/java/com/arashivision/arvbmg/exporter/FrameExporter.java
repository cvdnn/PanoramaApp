package com.arashivision.arvbmg.exporter;

import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class FrameExporter extends BMGNativeObjectRef {
    public static final String TAG = "FrameExporter";
    public boolean mReleased;

    public FrameExporter(String[] strArr, long j2) {
        super(createNativeWrap(strArr, j2), TAG);
    }

    public static native long createNativeWrap(String[] strArr, long j2);

    private native long nativeNextVideoFrame();

    private native long nativeNextVideoKeyFrame();

    private native int nativePrepare(boolean z, boolean z2, int i2);

    private native void nativeRelease();

    private native int nativeSeek(double d2, boolean z);

    public void finalize() throws Throwable {
        if (this.mReleased) {
            release();
            super.finalize();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" not release before finalize ");
        throw new IllegalStateException(sb.toString());
    }

    public FrameExporterSample nextVideoFrame() {
        long nativeNextVideoFrame = nativeNextVideoFrame();
        if (nativeNextVideoFrame > 0) {
            return new FrameExporterSample(nativeNextVideoFrame);
        }
        return null;
    }

    public FrameExporterSample nextVideoKeyFrame() {
        long nativeNextVideoKeyFrame = nativeNextVideoKeyFrame();
        if (nativeNextVideoKeyFrame > 0) {
            return new FrameExporterSample(nativeNextVideoKeyFrame);
        }
        return null;
    }

    public int prepare(boolean z, boolean z2, int i2) {
        return nativePrepare(z, z2, i2);
    }

    public void release() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" release");
        Log.i(TAG, sb.toString());
        if (!this.mReleased) {
            nativeRelease();
            free();
            this.mReleased = true;
        }
    }

    public int seek(double d2) {
        return seek(d2, false);
    }

    public int seek(double d2, boolean z) {
        return nativeSeek(d2, z);
    }
}
