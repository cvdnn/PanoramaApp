package com.arashivision.graphicpath.render.source;

public class VideoAssetSource extends Source {
    public VideoAssetSource(String str) {
        this(createNativeWrap(str, -2147483648L));
    }

    public static native long createNativeWrap(String str, long j2);

    public native VideoAsset getAsset();

    public VideoAssetSource(String str, long j2) {
        this(createNativeWrap(str, j2));
    }

    public VideoAssetSource(long j2) {
        super(j2);
    }
}
