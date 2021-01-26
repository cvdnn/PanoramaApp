package com.arashivision.onestream;

import android.util.Log;
import e.a.a.a.a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class TexturePipeline {
    public static final String TAG = "TexturePipeline";
    public long mNativeInstance;

    public static class TextureInfo {
        public int clipIndex;
        public int height;
        public long mediaTime;
        public long originalPts;
        public long repeatMediaTimeOffsetMs;
        public int secTextureId;
        public int textureId;
        public int width;

        public TextureInfo(int i2, int i3, int i4, int i5) {
            this.textureId = i2;
            this.secTextureId = i3;
            this.width = i4;
            this.height = i5;
        }

        public int getClipIndex() {
            return this.clipIndex;
        }

        public int getHeight() {
            return this.height;
        }

        public long getMediaTime() {
            return this.mediaTime;
        }

        public long getOriginalPts() {
            return this.originalPts;
        }

        public long getRepeatMediaTimeOffsetMs() {
            return this.repeatMediaTimeOffsetMs;
        }

        public int getSecTextureId() {
            return this.secTextureId;
        }

        public int getTextureId() {
            return this.textureId;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int i2) {
            this.height = i2;
        }

        public void setSecTextureId(int i2) {
            this.secTextureId = i2;
        }

        public void setWidth(int i2) {
            this.width = i2;
        }

        public TextureInfo(int i2, int i3, long j2, long j3, long j4) {
            this.textureId = i2;
            this.clipIndex = i3;
            this.originalPts = j2;
            this.repeatMediaTimeOffsetMs = j4;
            this.mediaTime = j3;
        }
    }

    static {
        NativePlayerLibLoader.load();
    }

    public TexturePipeline() {
        this(1);
    }

    private void debugContext() {
        StringBuilder a2 = a.a("gl context ");
        a2.append(((EGL10) EGLContext.getEGL()).eglGetCurrentContext());
        Log.d(TAG, a2.toString());
    }

    private native void nativeCreate(int i2);

    private native int nativeGetSecTextureId();

    private native TextureInfo nativeGetTextureInfo();

    private native void nativeRelease();

    public int getSecTextureId() {
        return nativeGetSecTextureId();
    }

    public TextureInfo getTextureInfo() {
        return nativeGetTextureInfo();
    }

    public void release() {
        nativeRelease();
    }

    public TexturePipeline(int i2) {
        nativeCreate(i2);
        debugContext();
    }
}
