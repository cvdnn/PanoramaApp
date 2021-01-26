package com.arashivision.graphicpath.render.source;

public class ImageAssetSource extends Source {
    public ImageAssetSource(String str) {
        this(createNativeWrap(str, -2147483648L));
    }

    public static native long createNativeWrap(String str, long j2);

    public native ImageAsset getAsset();

    public ImageAssetSource(String str, long j2) {
        this(createNativeWrap(str, j2));
    }

    public ImageAssetSource(long j2) {
        super(j2);
    }
}
