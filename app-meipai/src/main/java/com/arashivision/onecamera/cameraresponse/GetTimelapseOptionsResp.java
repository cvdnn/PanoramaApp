package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;

public class GetTimelapseOptionsResp {
    public int errorCode;
    public long requestID;
    public TimelapseOptionsInfo timelapse_options;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setTimelapse_options(TimelapseOptionsInfo timelapseOptionsInfo) {
        this.timelapse_options = timelapseOptionsInfo;
    }
}
