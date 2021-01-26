package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StopBulletTimeCmd implements InstaCmdExe {
    public byte[] mExtraData;

    public StopBulletTimeCmd(byte[] bArr) {
        this.mExtraData = bArr;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.stopBulletTime(this.mExtraData);
        return Integer.valueOf(0);
    }
}
