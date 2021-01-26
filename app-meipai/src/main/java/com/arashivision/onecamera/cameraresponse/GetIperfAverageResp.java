package com.arashivision.onecamera.cameraresponse;

public class GetIperfAverageResp {
    public byte[] data;
    public long requestID;

    private void setData(byte[] bArr) {
        this.data = bArr;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }
}
