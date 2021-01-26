package com.arashivision.onecamera.cameraresponse;

public class TakePictureWithoutStorageResponse {
    public byte[] data;
    public int status = 0;

    private void setData(byte[] bArr) {
        this.data = bArr;
    }

    private void setStatus(int i2) {
        this.status = i2;
    }
}
