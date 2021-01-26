package com.arashivision.onestream;

public class ImageData {
    public byte[] csd;
    public byte[] data;
    public int data_offset;
    public int data_size;
    public int flags;
    public int fps;
    public int height;
    public boolean mH265;
    public long timestampNs;
    public int width;

    public byte[] getCsd() {
        return this.csd;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getData_offset() {
        return this.data_offset;
    }

    public int getData_size() {
        return this.data_size;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isH265() {
        return this.mH265;
    }
}
