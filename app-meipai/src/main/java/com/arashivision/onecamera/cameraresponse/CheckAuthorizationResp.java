package com.arashivision.onecamera.cameraresponse;

public class CheckAuthorizationResp {
    public int errorCode;
    public long requestID;
    public int state;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setState(int i2) {
        this.state = i2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getRequestID() {
        return this.requestID;
    }

    public int getState() {
        return this.state;
    }
}
