package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class CameraWifiHearCmd implements InstaCmdExe {
    public boolean isDebug;

    public CameraWifiHearCmd(boolean z) {
        this.isDebug = z;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Integer.valueOf(oneDriver.getCameraWifiDebug(this.isDebug));
    }
}
