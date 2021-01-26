package com.arashivision.onecamera.cameraresponse;

public class CameraCaptureStatus {
    public int capture_nums;
    public int capture_time;
    public int state;

    private void setCapture_nums(int i2) {
        this.capture_nums = i2;
    }

    private void setCapture_time(int i2) {
        this.capture_time = i2;
    }

    private void setState(int i2) {
        this.state = i2;
    }
}
