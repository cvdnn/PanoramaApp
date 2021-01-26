package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SyncSetCatpureModeCmd implements InstaCmdExe {
    public final int mMode;

    public SyncSetCatpureModeCmd(int i2) {
        this.mMode = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setSyncCaptureMode(this.mMode));
    }
}
