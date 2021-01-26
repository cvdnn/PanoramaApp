package com.arashivision.onecamera.camerarequest;

import e.a.a.a.a;

public class VideoParam {
    public int bitrate;
    public boolean enableGyro;
    public int fps;
    public int height;
    public int width;

    private int getBitrate() {
        return this.bitrate;
    }

    private boolean getEnableGyro() {
        return this.enableGyro;
    }

    private int getFPS() {
        return this.fps;
    }

    private int getVideoHeight() {
        return this.height;
    }

    private int getVideoWidth() {
        return this.width;
    }

    public String toString() {
        StringBuilder a2 = a.a(" w ");
        a2.append(this.width);
        a2.append(" h ");
        a2.append(this.height);
        a2.append(" fps ");
        a2.append(this.fps);
        a2.append(" br ");
        a2.append(this.bitrate);
        return a2.toString();
    }
}
