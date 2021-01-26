package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StopLCDCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.stopLCDTest();
        return null;
    }
}
