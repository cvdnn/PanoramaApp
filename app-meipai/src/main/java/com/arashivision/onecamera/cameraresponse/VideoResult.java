package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.cameranotification.Video;

public class VideoResult {
    public int error_code;
    public Video video;

    private void setError_code(int i2) {
        this.error_code = i2;
    }

    private void setVideo(Video video2) {
        this.video = video2;
    }
}
