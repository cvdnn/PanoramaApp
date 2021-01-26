package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class StartBulletTimeCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Integer.valueOf(oneDriver.startBulletTime());
    }
}
