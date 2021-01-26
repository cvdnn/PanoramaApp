package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class HdrStopCaptureCmd implements InstaCmdExe {
    public byte[] mExtraData;

    public HdrStopCaptureCmd(byte[] bArr) {
        this.mExtraData = bArr;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.stopHdrCapture(this.mExtraData);
        return Integer.valueOf(0);
    }
}
