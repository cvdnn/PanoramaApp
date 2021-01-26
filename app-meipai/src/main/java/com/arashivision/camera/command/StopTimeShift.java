package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StopTimeShift implements InstaCmdExe {
    public byte[] mExtraData;

    public StopTimeShift(byte[] bArr) {
        this.mExtraData = bArr;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.stopTimeShift(this.mExtraData);
        return null;
    }
}
