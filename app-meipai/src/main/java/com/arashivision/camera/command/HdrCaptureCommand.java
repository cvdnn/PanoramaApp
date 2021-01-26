package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class HdrCaptureCommand implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.startHdrCapture();
        return Integer.valueOf(0);
    }
}
