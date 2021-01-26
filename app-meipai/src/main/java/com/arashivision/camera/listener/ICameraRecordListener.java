package com.arashivision.camera.listener;

import com.arashivision.onecamera.cameraresponse.VideoResult;

public interface ICameraRecordListener {
    void onDriverRecordVideoStateNotify(int i2, VideoResult videoResult);
}
