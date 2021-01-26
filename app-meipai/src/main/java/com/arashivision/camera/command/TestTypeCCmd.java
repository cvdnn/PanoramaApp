package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class TestTypeCCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.testTypeC();
        return null;
    }
}
