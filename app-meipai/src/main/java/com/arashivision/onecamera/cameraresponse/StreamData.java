package com.arashivision.onecamera.cameraresponse;

public class StreamData {
    public byte[] data;
    public int streamType;
    public long timestamp;

    private void setData(byte[] bArr) {
        this.data = bArr;
    }

    private void setStreamType(int i2) {
        this.streamType = i2;
    }

    private void setTimestamp(long j2) {
        this.timestamp = j2;
    }
}
