package com.arashivision.onecamera.cameranotification;

public class Video {
    public long file_size;
    public int total_time;
    public String uri;

    private void setFile_size(long j2) {
        this.file_size = j2;
    }

    private void setTotal_time(int i2) {
        this.total_time = i2;
    }

    private void setUri(String str) {
        this.uri = str;
    }
}
