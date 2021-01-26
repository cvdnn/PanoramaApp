package com.arashivision.arvbmg.exporter;

import android.os.Handler;
import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.baidu.sapi2.utils.SapiUtils;
import e.a.a.a.a;

public abstract class OneExport extends BMGNativeObjectRef {
    public static final String TAG = "OneExport";
    public Handler mCBHandler;
    public boolean mDebug;
    public boolean mReleased;
    public OneExportCallback mStateCallback;

    public static final class ExporterMessageCode {
        public static final int SWITCHTOSOFTWAREDECODEH264 = 0;
        public static final int SWITCHTOSOFTWAREDECODEH265 = 1;
    }

    public static class State {
        public static final int CANCEL = 1;
        public static final int END = 2;
        public static final int ERROR = 0;
        public static final int MESSAGE = 3;
    }

    public OneExport(long j2, String str) {
        super(j2, str);
        setRequireFreeManually();
    }

    public static long getAudioEstimateSize(int i2, long j2) {
        return nativeGetAudioEstimateSize(i2, j2);
    }

    /* access modifiers changed from: private */
    public String getCodeStr(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "message" : "end" : "cancel" : SapiUtils.f3014b;
    }

    public static long getVideoEstimateSize(int i2, long j2) {
        return nativeGetVideoEstimateSize(i2, j2);
    }

    private native void nativeCancel();

    public static native long nativeGetAudioEstimateSize(int i2, long j2);

    public static native long nativeGetVideoEstimateSize(int i2, long j2);

    private native void nativeRelease();

    private native void nativeSetDebug(boolean z);

    private native void nativeStart();

    public void cancel() {
        nativeCancel();
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

    public long getEstimateSize() {
        return nativeGetEstimateSize();
    }

    public double getProgress() {
        return nativeGetProgress();
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public native long nativeGetEstimateSize();

    public native double nativeGetProgress();

    public void progressNotify(final double d2) {
        if (this.mStateCallback != null) {
            Handler handler = this.mCBHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        OneExport.this.mStateCallback.onExportProgressNotify(d2);
                    }
                });
            } else {
                Log.e(TAG, "Export callback handler null progressNotify");
            }
        }
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

    public void setDebug(boolean z) {
        this.mDebug = z;
        nativeSetDebug(z);
    }

    public void setStateCallback(OneExportCallback oneExportCallback, Handler handler) {
        this.mCBHandler = handler;
        this.mStateCallback = oneExportCallback;
    }

    public void start() {
        nativeStart();
    }

    public void stateNotify(final int i2, final int i3, final ExportError exportError) {
        if (this.mStateCallback != null) {
            Handler handler = this.mCBHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = a.a("stateNotify errorCode ");
                        a2.append(i2);
                        a2.append(" addition ");
                        a2.append(i3);
                        a2.append(" desc ");
                        a2.append(OneExport.this.getCodeStr(i2));
                        Log.i(OneExport.TAG, a2.toString());
                        OneExport.this.mStateCallback.onExportStateNotify(i2, i3, exportError);
                    }
                });
            } else {
                a.c("Export callback handler null stateNotify errorCode ", i2, TAG);
            }
        }
    }
}
