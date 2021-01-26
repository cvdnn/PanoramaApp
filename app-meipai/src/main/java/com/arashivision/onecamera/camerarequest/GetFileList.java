package com.arashivision.onecamera.camerarequest;

public class GetFileList {
    public int limit;
    public int media_type;
    public int start;

    public int getLimit() {
        return this.limit;
    }

    public int getMedia_type() {
        return this.media_type;
    }

    public int getStart() {
        return this.start;
    }

    public void setLimit(int i2) {
        this.limit = i2;
    }

    public void setMedia_type(int i2) {
        this.media_type = i2;
    }

    public void setStart(int i2) {
        this.start = i2;
    }
}
