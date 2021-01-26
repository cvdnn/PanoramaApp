package com.arashivision.onecamera.cameraresponse;

public class GetFlowStatusResp {
    public int enable;
    public int errorCode;
    public long requestID;

    private void setEnable(int i2) {
        this.enable = i2;
    }

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }
}
