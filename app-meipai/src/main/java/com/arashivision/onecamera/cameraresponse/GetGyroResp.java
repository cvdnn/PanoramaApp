package com.arashivision.onecamera.cameraresponse;

import java.util.List;

public class GetGyroResp {
    public List<GyroData> mGyroDataList;

    private void setGyroes(List<GyroData> list) {
        this.mGyroDataList = list;
    }
}
