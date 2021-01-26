package com.arashivision.camera.command.wifi;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public class WifiStatusCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.startWifiStatusTest());
    }
}
