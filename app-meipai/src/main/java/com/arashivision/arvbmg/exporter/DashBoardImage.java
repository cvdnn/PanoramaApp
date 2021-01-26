package com.arashivision.arvbmg.exporter;

public class DashBoardImage {
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
