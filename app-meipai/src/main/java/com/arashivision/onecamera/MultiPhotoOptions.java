package com.arashivision.onecamera;

import android.util.Log;
import com.arashivision.onecamera.OneDriver.NativeLibsLoader;
import com.arashivision.onecamera.OneDriverInfo.MultiVideoOptions;
import com.arashivision.onecamera.OneDriverInfo.Options;

public class MultiPhotoOptions {
    public static final String TAG = "MultiPhotoOptions";
    public long mNativeInstance;
    public State mState = State.Working;

    public enum State {
        Working,
        Release
    }

    static {
        NativeLibsLoader.load();
    }

    public MultiPhotoOptions() {
        nativeCreate();
    }

    private native void nativeCreate();

    private native boolean nativeGetBoolean(String str);

    private native int nativeGetInt32(String str);

    private native void nativeRelease();

    private native void nativeSetBoolean(String str, boolean z);

    private native void nativeSetInt32(String str, int i2);

    public void enableFlowState(boolean z) {
        nativeSetBoolean(Options.INTERNAL_FLOWSTATE, z);
    }

    public void finalize() throws Throwable {
        if (this.mState != State.Release) {
            release();
        } else {
            Log.e(TAG, "finalize(): Options already released");
        }
        super.finalize();
    }

    public boolean getFlowState() {
        return nativeGetBoolean(Options.INTERNAL_FLOWSTATE);
    }

    public int getResolution() {
        return nativeGetInt32(MultiVideoOptions.RESOLUTION);
    }

    public void release() {
        nativeRelease();
        this.mState = State.Release;
    }

    public void setResolution(int i2) {
        nativeSetInt32(MultiVideoOptions.RESOLUTION, i2);
    }
}
