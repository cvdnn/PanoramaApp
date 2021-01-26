package com.arashivision.onecamera.camerarequest;

public class StartTimelapse {
    public byte[] extraData;
    public int mode;

    private byte[] getExtraData() {
        return this.extraData;
    }

    private int getTimelapseMode() {
        return this.mode;
    }
}
