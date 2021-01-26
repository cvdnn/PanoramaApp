package com.arashivision.arvbmg.autodetect;

import com.arashivision.arvbmg.common.TrackVideoInfo;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.util.Stabilizer;
import java.io.File;

public class AutoDectection extends BMGNativeObjectRef {
    public static final int RATIO = 1000;
    public static final String TAG = "com.arashivision.arvbmg.autodetect.AutoDectection";
    public IAutoDetectCallback mIAutoDetectCallback;

    public interface IAutoDetectCallback {
        void onAutoDetect(TrackVideoInfo trackVideoInfo);
    }

    public AutoDectection(long j2) {
        super(j2, "AutoDectection");
    }

    private native void nativeClear();

    private native boolean nativeConfig(String str, String[] strArr, Stabilizer stabilizer, int i2, double d2);

    public static native long nativeCreateObj();

    private native void nativeFinishDect();

    private native void nativeProcessFrame(FrameExporterSample frameExporterSample);

    private native void nativeSetDebug(boolean z);

    private native void nativeSetDetectCallback();

    private void onAutoDetect(TrackVideoInfo trackVideoInfo) {
        IAutoDetectCallback iAutoDetectCallback = this.mIAutoDetectCallback;
        if (iAutoDetectCallback != null) {
            iAutoDetectCallback.onAutoDetect(trackVideoInfo);
        }
    }

    public void clear() {
        nativeClear();
    }

    public boolean config(String str, String[] strArr, Stabilizer stabilizer) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return nativeConfig(str, strArr, stabilizer, 0, 4.0d);
    }

    public void finish() {
        nativeFinishDect();
    }

    public void processKeyFrame(FrameExporterSample frameExporterSample) {
        if (frameExporterSample != null) {
            nativeProcessFrame(frameExporterSample);
        }
    }

    public void setAutoDetectCallback(IAutoDetectCallback iAutoDetectCallback) {
        this.mIAutoDetectCallback = iAutoDetectCallback;
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public AutoDectection() {
        this(nativeCreateObj());
        nativeSetDetectCallback();
    }

    public boolean config(String str, String[] strArr, Stabilizer stabilizer, int i2, double d2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return nativeConfig(str, strArr, stabilizer, i2, d2);
    }
}
