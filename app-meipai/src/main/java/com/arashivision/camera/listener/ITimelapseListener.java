package com.arashivision.camera.listener;

import com.arashivision.onecamera.cameraresponse.VideoResult;

public interface ITimelapseListener {
    void ononTimelapseRecordNotify(int i2, VideoResult videoResult);
}
