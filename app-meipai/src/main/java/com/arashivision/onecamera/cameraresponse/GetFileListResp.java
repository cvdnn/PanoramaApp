package com.arashivision.onecamera.cameraresponse;

import java.util.List;

public class GetFileListResp {
    public int errorCode;
    public List<String> mUriList;
    public long requestID;

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    private void setUri(List<String> list) {
        this.mUriList = list;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }
}
