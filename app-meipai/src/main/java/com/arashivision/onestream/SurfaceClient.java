package com.arashivision.onestream;

import com.arashivision.onestream.Gyro.ByteBuf;

public interface SurfaceClient {

    public static class ImageInfo {
        public ByteBuf byteBuf;
        public int mIFrame;
        public long timestampNs;

        public boolean isIFrame() {
            return this.mIFrame == 1;
        }
    }

    ImageInfo getImageInfo();
}
