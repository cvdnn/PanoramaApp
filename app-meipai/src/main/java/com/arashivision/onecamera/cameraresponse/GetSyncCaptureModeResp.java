package com.arashivision.onecamera.cameraresponse;

public class GetSyncCaptureModeResp {
    public int errorCode;
    public int mode;
    public long requestID;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setMode(int i2) {
        this.mode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getMode() {
        return this.mode;
    }

    public long getRequestID() {
        return this.requestID;
    }
}
