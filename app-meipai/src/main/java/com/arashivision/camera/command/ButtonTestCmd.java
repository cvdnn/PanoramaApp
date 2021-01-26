package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class ButtonTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.testButtonPress();
        return null;
    }
}
