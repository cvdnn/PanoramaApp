package com.arashivision.onecamera.camerarequest;

public class TakePicture {
    public int[] aeb_ev_bias;
    public byte[] extra_metadata;
    public boolean isRawEnable;
    public int mode;

    private int[] getAeb_ev_bias() {
        return this.aeb_ev_bias;
    }

    private byte[] getExtra_metadata() {
        return this.extra_metadata;
    }

    private int getMode() {
        return this.mode;
    }

    public boolean isRawEnable() {
        return this.isRawEnable;
    }
}
