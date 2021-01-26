package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class BlackLevelTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.blackLevelTest());
    }
}
