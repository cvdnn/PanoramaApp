package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SyncSetStandByCmd implements InstaCmdExe {
    public final int mMode;

    public SyncSetStandByCmd(int i2) {
        this.mMode = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setStandbyMode(this.mMode));
    }
}
