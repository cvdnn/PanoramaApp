package com.arashivision.graphicpath.insmedia.common;

import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class VideoSampleGroup extends NativeObjectRef {
    static {
        InsMediaLibsLoader.load();
    }

    public VideoSampleGroup(long j2) {
        super(j2, "VideoSampleGroup");
        setRequireFreeManually();
    }

    public static VideoSampleGroup MoveFrom(NativeObjectRef nativeObjectRef) {
        return new VideoSampleGroup(nativeObjectRef.moveGetWrapPtr());
    }

    private native long[] nativeGetMetas(boolean z);

    public MediaSampleMeta getCutscenesMeta() {
        long[] nativeGetMetas = nativeGetMetas(true);
        if (nativeGetMetas == null || nativeGetMetas.length == 0) {
            return null;
        }
        int length = nativeGetMetas.length;
        MediaSampleMeta[] mediaSampleMetaArr = new MediaSampleMeta[length];
        for (int i2 = 0; i2 < length; i2++) {
            mediaSampleMetaArr[i2] = new MediaSampleMeta(nativeGetMetas[i2]);
        }
        return mediaSampleMetaArr[0];
    }

    public MediaSampleMeta[] getCutscenesMetas() {
        long[] nativeGetMetas = nativeGetMetas(true);
        if (nativeGetMetas == null || nativeGetMetas.length == 0) {
            return null;
        }
        int length = nativeGetMetas.length;
        MediaSampleMeta[] mediaSampleMetaArr = new MediaSampleMeta[length];
        for (int i2 = 0; i2 < length; i2++) {
            mediaSampleMetaArr[i2] = new MediaSampleMeta(nativeGetMetas[i2]);
        }
        return mediaSampleMetaArr;
    }

    public native int getCutscenesSampleCount();

    public native int getCutscenesSampleHeight(int i2);

    public native int getCutscenesSampleWidth(int i2);

    public native String getDesc();

    public MediaSampleMeta getMeta() {
        MediaSampleMeta[] metas = getMetas();
        if (metas == null || metas.length == 0) {
            return null;
        }
        return metas[0];
    }

    public MediaSampleMeta[] getMetas() {
        long[] nativeGetMetas = nativeGetMetas(false);
        if (nativeGetMetas == null || nativeGetMetas.length == 0) {
            return null;
        }
        int length = nativeGetMetas.length;
        MediaSampleMeta[] mediaSampleMetaArr = new MediaSampleMeta[length];
        for (int i2 = 0; i2 < length; i2++) {
            mediaSampleMetaArr[i2] = new MediaSampleMeta(nativeGetMetas[i2]);
        }
        return mediaSampleMetaArr;
    }

    public native int getSampleCount();

    public native int getSampleHeight(int i2);

    public native int getSampleWidth(int i2);

    public native int getSourceUniqueId();

    public native boolean hasCutscenesSamples();

    public native boolean isKeyFrame();
}
