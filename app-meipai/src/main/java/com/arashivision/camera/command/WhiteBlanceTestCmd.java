package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class WhiteBlanceTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.whiteBlanceTest());
    }
}
