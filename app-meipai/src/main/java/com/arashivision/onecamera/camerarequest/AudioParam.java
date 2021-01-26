package com.arashivision.onecamera.camerarequest;

public class AudioParam {
    public int bitrate = 0;
    public int codec;
    public boolean enable = true;
    public int sampleRate = 0;

    private int getBitrate() {
        return this.bitrate;
    }

    private int getCodec() {
        return this.codec;
    }

    private boolean getEnable() {
        return this.enable;
    }

    private int getSampleRate() {
        return this.sampleRate;
    }
}
