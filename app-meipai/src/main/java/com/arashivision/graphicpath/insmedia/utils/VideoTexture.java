package com.arashivision.graphicpath.insmedia.utils;

import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.graphicpath.insmedia.common.MediaSampleMeta;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class VideoTexture extends NativeObjectRef {
    public boolean mReleased;

    public static class TextureGroup {
        public TextureInfo[] cutscenesTextures;
        public TextureInfo[] textures;
    }

    public static class TextureInfo {
        public int id;
        public MediaSampleMeta meta;

        public TextureInfo(int i2, MediaSampleMeta mediaSampleMeta) {
            this.id = i2;
            this.meta = mediaSampleMeta;
        }
    }

    static {
        InsMediaLibsLoader.load();
    }

    public VideoTexture(int i2, long j2) {
        this(createNativeWrap(i2, j2), "VideoTexture");
    }

    public static native long createNativeWrap(int i2, long j2);

    private native void nativeGetTexture(int[] iArr, int[] iArr2, long[] jArr, int[] iArr3, int[] iArr4, long[] jArr2);

    public native void enableDebug(boolean z);

    public TextureGroup getTexture() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[16];
        long[] jArr = new long[16];
        int[] iArr3 = new int[1];
        int[] iArr4 = new int[16];
        long[] jArr2 = new long[16];
        nativeGetTexture(iArr, iArr2, jArr, iArr3, iArr4, jArr2);
        TextureGroup textureGroup = new TextureGroup();
        textureGroup.textures = new TextureInfo[iArr[0]];
        for (int i2 = 0; i2 < iArr[0]; i2++) {
            textureGroup.textures[i2] = new TextureInfo(iArr2[i2], new MediaSampleMeta(jArr[i2]));
        }
        textureGroup.cutscenesTextures = new TextureInfo[iArr3[0]];
        for (int i3 = 0; i3 < iArr3[0]; i3++) {
            textureGroup.cutscenesTextures[i3] = new TextureInfo(iArr4[i3], new MediaSampleMeta(jArr2[i3]));
        }
        return textureGroup;
    }

    public native boolean hasUpdate();

    public native void queueSampleGroup(VideoSampleGroup videoSampleGroup);

    public native void release();

    public native boolean updateTexture();

    public VideoTexture(long j2, String str) {
        super(j2, str);
    }
}
