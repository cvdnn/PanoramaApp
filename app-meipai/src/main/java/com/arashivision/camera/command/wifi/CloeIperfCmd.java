package com.arashivision.camera.command.wifi;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public class CloeIperfCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.closeIperf();
        return null;
    }
}
