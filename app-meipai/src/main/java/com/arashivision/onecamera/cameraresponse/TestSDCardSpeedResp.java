package com.arashivision.onecamera.cameraresponse;

public class TestSDCardSpeedResp {
    public long requestID;
    public double[] write_speeds;

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setWrite_speeds(double[] dArr) {
        this.write_speeds = dArr;
    }
}
