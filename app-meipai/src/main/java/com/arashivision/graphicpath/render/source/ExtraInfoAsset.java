package com.arashivision.graphicpath.render.source;

import java.nio.ByteBuffer;

public class ExtraInfoAsset extends Asset {
    public ExtraInfoAsset(long j2) {
        super(j2);
    }

    public static native long createNativeWrap(String str, long j2);

    public static native long createNativeWrap(ByteBuffer byteBuffer);

    public static native long createNativeWrap(ByteBuffer byteBuffer, boolean z);

    public ExtraInfoAsset(String str) {
        this(createNativeWrap(str, -2147483648L));
    }

    public ExtraInfoAsset(String str, long j2) {
        this(createNativeWrap(str, j2));
    }

    public ExtraInfoAsset(ByteBuffer byteBuffer) {
        this(createNativeWrap(byteBuffer));
    }

    public ExtraInfoAsset(ByteBuffer byteBuffer, boolean z) {
        this(createNativeWrap(byteBuffer));
    }
}
