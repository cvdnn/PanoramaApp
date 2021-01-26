package com.arashivision.onecamera.cameraresponse;

public class GetSingleSensorResp {
    public int errorCode;
    public long requestID;
    public int sensor;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setSensor(int i2) {
        this.sensor = i2;
    }
}
