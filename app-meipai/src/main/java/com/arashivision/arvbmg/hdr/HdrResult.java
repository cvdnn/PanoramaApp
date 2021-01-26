package com.arashivision.arvbmg.hdr;

import java.nio.ByteBuffer;

public class HdrResult {
    public static final int TYPE_RGB = 1;
    public ByteBuffer mByteBuffer;
    public int mHeight;
    public int mType;
    public int mWidth;

    public HdrResult(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        this.mByteBuffer = byteBuffer;
        this.mHeight = i3;
        this.mWidth = i2;
        this.mType = i4;
    }

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getType() {
        return this.mType;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
