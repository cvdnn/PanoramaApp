package com.arashivision.arvbmg.exporter;

import android.util.Log;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class FrameRenderExporter extends BMGNativeObjectRef {
    public static final String TAG = "FrameRenderExporter";
    public FrameRenderExporterCallback mFrameRenderExporterCallback;
    public boolean mReleased;

    public interface FrameRenderExporterCallback {
        ClipRenderInfo onGetClipRenderInfo();
    }

    public FrameRenderExporter(String[] strArr, long j2, FrameRenderExporterCallback frameRenderExporterCallback) {
        super(createNativeWrap(strArr, j2), FrameExporter.TAG);
        this.mFrameRenderExporterCallback = frameRenderExporterCallback;
    }

    public static native long createNativeWrap(String[] strArr, long j2);

    private native int nativeNextVideoFrameToFile(String str);

    private native int nativeNextVideoKeyFrameToFile(String str);

    private native int nativePrepare(int i2, int i3, boolean z, boolean z2, int i4);

    private native void nativeRelease();

    private native int nativeSeek(double d2, boolean z);

    private RenderModel onGetClipRenderModel() {
        return RenderModelUtil.createRootRenderModel(this.mFrameRenderExporterCallback.onGetClipRenderInfo(), null);
    }

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

    public int nextVideoFrameToFile(String str) {
        return nativeNextVideoFrameToFile(str);
    }

    public int nextVideoKeyFrameToFile(String str) {
        return nativeNextVideoKeyFrameToFile(str);
    }

    public int prepare(int i2, int i3, boolean z, boolean z2, int i4) {
        return nativePrepare(i2, i3, z, z2, i4);
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
