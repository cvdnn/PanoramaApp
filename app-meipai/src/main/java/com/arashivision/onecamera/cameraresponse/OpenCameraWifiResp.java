package com.arashivision.onecamera.cameraresponse;

public class OpenCameraWifiResp {
    public int errorCode;
    public long requestID;

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getRequestID() {
        return this.requestID;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setRequestID(long j2) {
        this.requestID = j2;
    }
}
