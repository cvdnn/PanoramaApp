package com.arashivision.camera.command.wifi;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public class WifiHeartCmd implements InstaCmdExe {
    public boolean isDebug;

    public WifiHeartCmd(boolean z) {
        this.isDebug = z;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Integer.valueOf(oneDriver.setWifiHeartDebug(this.isDebug));
    }
}
