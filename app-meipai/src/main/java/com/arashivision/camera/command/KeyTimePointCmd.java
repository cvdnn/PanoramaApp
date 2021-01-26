package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.KeyTimePoint;

public class KeyTimePointCmd implements InstaCmdExe {
    public KeyTimePoint mKeyTimePoint;

    public KeyTimePointCmd(KeyTimePoint keyTimePoint) {
        this.mKeyTimePoint = keyTimePoint;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setKeyTimePoint(this.mKeyTimePoint));
    }
}
