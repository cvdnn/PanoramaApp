package com.arashivision.arvbmg.supernight;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.util.List;

public class SuperNight extends BMGNativeObjectRef {
    public boolean mReleased;
    public ISuperNightCallback mSuperNightCallback;

    public interface ISuperNightCallback {
        void onSuperNightCallback(boolean z, String str);
    }

    public SuperNight() {
        this(nativeCreate());
    }

    private native void nativeCancel();

    public static native long nativeCreate();

    private native boolean nativeDoSuperNight(List<String> list, String str);

    private native void nativeDoSuperNightAsync(List<String> list, String str);

    private void onNightiCallback(boolean z, String str) {
        ISuperNightCallback iSuperNightCallback = this.mSuperNightCallback;
        if (iSuperNightCallback != null) {
            iSuperNightCallback.onSuperNightCallback(z, str);
        }
    }

    private void release() {
        if (!this.mReleased) {
            nativeCancel();
            this.mReleased = true;
        }
    }

    public void cancel() {
        nativeCancel();
    }

    public boolean doSuperNight(List<String> list, String str) {
        return nativeDoSuperNight(list, str);
    }

    public void doSuperNightAsync(List<String> list, String str) {
        nativeDoSuperNightAsync(list, str);
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void setSuperNightCallback(ISuperNightCallback iSuperNightCallback) {
        this.mSuperNightCallback = iSuperNightCallback;
    }

    public SuperNight(long j2) {
        super(j2, "SuperNight");
    }
}
