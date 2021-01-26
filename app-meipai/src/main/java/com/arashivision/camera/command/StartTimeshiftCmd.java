package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StartTimeshiftCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.startTimeShift();
        return Integer.valueOf(0);
    }
}
