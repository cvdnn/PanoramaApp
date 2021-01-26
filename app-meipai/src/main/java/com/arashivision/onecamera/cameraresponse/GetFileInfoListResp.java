package com.arashivision.onecamera.cameraresponse;

import java.util.List;

public class GetFileInfoListResp {
    public int errorCode;
    public List<FileInfo> mFileInfoList;
    public long requestID;

    private void setRequestID(long j2) {
        this.requestID = j2;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setFileInfoList(List<FileInfo> list) {
        this.mFileInfoList = list;
    }
}
