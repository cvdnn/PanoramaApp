package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SetGpsCmd implements InstaCmdExe {
    public byte[] mGpsData;

    public SetGpsCmd(byte[] bArr) {
        this.mGpsData = bArr;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setGPSData(this.mGpsData));
    }
}
