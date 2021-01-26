package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a.C0102a;

public class BleCloseCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        C0102a.f7939a.a();
        return Integer.valueOf(0);
    }
}
