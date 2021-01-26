package com.arashivision.onecamera.cameranotification;

public class NotificationDeleteFilesProgress {
    public int failed_count;
    public int success_count;
    public int total_count;

    private void setFailed_count(int i2) {
        this.failed_count = i2;
    }

    private void setSuccess_count(int i2) {
        this.success_count = i2;
    }

    private void setTotal_count(int i2) {
        this.total_count = i2;
    }
}
