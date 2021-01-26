package com.arashivision.onecamera.cameraresponse;

public class GetMiniThumbResp {
    public long requestID;
    public byte[] thumb;

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setThumb(byte[] bArr) {
        this.thumb = bArr;
    }
}
