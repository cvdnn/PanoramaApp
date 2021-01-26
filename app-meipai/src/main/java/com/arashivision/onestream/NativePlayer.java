package com.arashivision.onestream;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.arashivision.onestreamtarget.OneStreamTarget;
import com.arashivision.onestreamtarget.StreamTarget;

public class NativePlayer extends AbstractPlayer {
    public static final String TAG = "NativePlayer";
    public long mNativeInstance;

    static {
        NativePlayerLibLoader.load();
    }

    public NativePlayer(Looper looper) {
        this.mCBHandler = new Handler(looper);
        nativeCreate();
    }

    private native void nativeCreate();

    private native void nativeInit(Surface surface, Surface surface2, int i2, int i3, String str, int i4);

    private native void nativePutData(ImageData imageData, ImageData imageData2);

    private native void nativeRelease();

    private native void nativeSetPipeline(TexturePipeline texturePipeline, int i2, int i3, String str, int i4);

    private native void nativeStart();

    public void init(Object obj, int i2, int i3, String str, int i4) {
        if (obj instanceof OneStreamTarget) {
            OneStreamTarget oneStreamTarget = (OneStreamTarget) obj;
            this.mTarget = oneStreamTarget;
            if (oneStreamTarget.isSurface()) {
                nativeInit(this.mTarget.getSurface(), this.mTarget.getSecSurface(), i2, i3, str, i4);
                return;
            }
            Log.i(TAG, "empty texture mode");
        } else if (obj instanceof TexturePipeline) {
            setPipeline((TexturePipeline) obj, i2, i3, str, i4);
        } else {
            throw new IllegalArgumentException("unsupported nativeplayer target ");
        }
    }

    public void putData(ImageData imageData) {
        nativePutData(imageData, null);
    }

    public void release() {
        nativeRelease();
    }

    public void setPipeline(TexturePipeline texturePipeline, int i2, int i3, String str, int i4) {
        nativeSetPipeline(texturePipeline, i2, i3, str, i4);
    }

    public void setStreamTarget(StreamTarget streamTarget) {
        this.mStreamTarget = streamTarget;
    }

    public void start() {
        nativeStart();
    }

    public void putData(ImageData imageData, ImageData imageData2) {
        nativePutData(imageData, imageData2);
    }
}
