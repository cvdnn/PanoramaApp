package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StandByCmd implements InstaCmdExe {
    public int mMode;

    public StandByCmd(int i2) {
        this.mMode = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setStandbyMode(this.mMode));
    }
}
