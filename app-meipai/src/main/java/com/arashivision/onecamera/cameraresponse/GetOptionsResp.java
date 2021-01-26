package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.Options;

public class GetOptionsResp {
    public int errorCode;
    public long requestID;
    public Options result;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setResult(Options options) {
        this.result = options;
    }
}
