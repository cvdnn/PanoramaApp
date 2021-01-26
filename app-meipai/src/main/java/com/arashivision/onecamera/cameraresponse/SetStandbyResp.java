package com.arashivision.onecamera.cameraresponse;

public class SetStandbyResp {
    public int errorCode;
    public long requestID;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }
}
