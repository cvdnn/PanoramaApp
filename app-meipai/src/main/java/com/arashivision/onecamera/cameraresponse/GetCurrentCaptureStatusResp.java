package com.arashivision.onecamera.cameraresponse;

public class GetCurrentCaptureStatusResp {
    public int errorCode;
    public long requestID;
    public CameraCaptureStatus status;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setStatus(CameraCaptureStatus cameraCaptureStatus) {
        this.status = cameraCaptureStatus;
    }
}
