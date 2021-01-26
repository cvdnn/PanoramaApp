package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SyncCaptureStatusCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.resumeInitialState());
    }
}
