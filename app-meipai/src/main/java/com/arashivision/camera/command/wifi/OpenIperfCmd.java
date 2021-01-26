package com.arashivision.camera.command.wifi;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public class OpenIperfCmd implements InstaCmdExe {
    public int mMode;

    public OpenIperfCmd(int i2) {
        this.mMode = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.openIperf(this.mMode));
    }
}
