package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a.C0102a;
import e.e.a.g.f.b;

public class BleStopScanCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        if (C0102a.f7939a != null) {
            b.f8023a.a();
            return null;
        }
        throw null;
    }
}
