package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class BadPointTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.badPointTest());
    }
}
