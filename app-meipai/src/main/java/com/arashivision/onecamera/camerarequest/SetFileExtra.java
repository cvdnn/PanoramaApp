package com.arashivision.onecamera.camerarequest;

public class SetFileExtra {
    public byte[] data;
    public int extra_type;
    public String uri;

    private byte[] getData() {
        return this.data;
    }

    private int getExtra_type() {
        return this.extra_type;
    }

    private String getUri() {
        return this.uri;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setExtra_type(int i2) {
        this.extra_type = i2;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
