package com.arashivision.graphicpath.render.source;

import java.nio.ByteBuffer;

public class ImageAsset extends Asset {
    public ImageAsset(long j2) {
        super(j2);
    }

    public static native long createNativeWrap(String str, long j2);

    public static native long createNativeWrap(ByteBuffer byteBuffer);

    private native String nativeGetExifMetadata(String str);

    private native String nativeGetXmpMetadata(String str);

    public String getExifMetadata(String str) {
        if (!hasMetadata(str)) {
            return null;
        }
        return nativeGetExifMetadata(str);
    }

    public String getXmpMetadata(String str) {
        if (!hasMetadata(str)) {
            return null;
        }
        return nativeGetXmpMetadata(str);
    }

    public native boolean loadData();

    public native void setExifMetadata(String str, String str2);

    public native void setXmpMetadata(String str, String str2);

    public ImageAsset(String str) {
        this(createNativeWrap(str, -2147483648L));
    }

    public ImageAsset(String str, long j2) {
        this(createNativeWrap(str, j2));
    }

    public ImageAsset(ByteBuffer byteBuffer) {
        this(createNativeWrap(byteBuffer));
    }
}
