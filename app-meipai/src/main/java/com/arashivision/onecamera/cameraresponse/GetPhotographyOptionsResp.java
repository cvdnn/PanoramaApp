package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.PhotoOptions;

public class GetPhotographyOptionsResp {
    public int errorCode;
    public long requestID;
    public PhotoOptions result;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setResult(PhotoOptions photoOptions) {
        this.result = photoOptions;
    }
}
