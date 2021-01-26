package com.arashivision.onecamera.cameranotification;

public class NotificationCaptureStopped {
    public int err_code;
    public Video mVideo;

    private void setErrCode(int i2) {
        this.err_code = i2;
    }

    private void setVideo(Object obj) {
        this.mVideo = (Video) obj;
    }
}
