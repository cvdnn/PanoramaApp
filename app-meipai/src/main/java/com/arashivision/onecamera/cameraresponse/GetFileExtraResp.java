package com.arashivision.onecamera.cameraresponse;

public class GetFileExtraResp {
    public byte[] extraData;
    public long requestID;

    private void setExtraData(byte[] bArr) {
        this.extraData = bArr;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }
}
