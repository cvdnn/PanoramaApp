package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.MultiPhotoOptions;

public class GetMultiModeResp {
    public int errorCode;
    public long requestID;
    public MultiPhotoOptions result;

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    public void setResult(MultiPhotoOptions multiPhotoOptions) {
        this.result = multiPhotoOptions;
    }
}
