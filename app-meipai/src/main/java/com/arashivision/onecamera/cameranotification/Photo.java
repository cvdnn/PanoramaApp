package com.arashivision.onecamera.cameranotification;

public class Photo {
    public long file_size;
    public byte[] s_thumbnail;
    public String uri;

    private void setFile_size(long j2) {
        this.file_size = j2;
    }

    private void setS_thumbnail(byte[] bArr) {
        this.s_thumbnail = bArr;
    }

    private void setUri(String str) {
        this.uri = str;
    }
}
