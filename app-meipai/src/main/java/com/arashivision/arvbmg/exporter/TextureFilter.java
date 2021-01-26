package com.arashivision.arvbmg.exporter;

import java.nio.ByteBuffer;

public interface TextureFilter {

    public static class DashBoardImage {
        public byte[] data;
        public int height;
        public int width;

        public byte[] getData() {
            return this.data;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public void setData(byte[] bArr) {
            this.data = bArr;
        }

        public void setHeight(int i2) {
            this.height = i2;
        }

        public void setWidth(int i2) {
            this.width = i2;
        }
    }

    public static class Frame {
        public int blurIndex;
        public int clipIndex;
        public boolean dashboardOff;
        public long rawPtsMs;
        public boolean renderTarget;
        public int secTextureId;
        public int textureId;
        public boolean waterMarkOff;

        public void setBlurIndex(int i2) {
            this.blurIndex = i2;
        }

        public void setClipIndex(int i2) {
            this.clipIndex = i2;
        }

        public void setDashboardOff(boolean z) {
            this.dashboardOff = z;
        }

        public void setRawPtsMs(long j2) {
            this.rawPtsMs = j2;
        }

        public void setRenderTarget(boolean z) {
            this.renderTarget = z;
        }

        public void setSecTextureId(int i2) {
            this.secTextureId = i2;
        }

        public void setTextureId(int i2) {
            this.textureId = i2;
        }

        public void setWaterMarkOff(boolean z) {
            this.waterMarkOff = z;
        }
    }

    void deinit();

    int filter(Frame frame);

    DashBoardImage getDashboardData(long j2);

    int init(int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2);

    void tailClearI420(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3);

    void tailClearNV12(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i2, int i3);

    void tailClearRGBA(ByteBuffer byteBuffer, int i2, int i3);
}
