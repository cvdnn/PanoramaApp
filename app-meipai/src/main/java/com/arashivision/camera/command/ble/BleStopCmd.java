package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.c.c;
import e.e.a.e.b;

public class BleStopCmd implements InstaCmdExe {
    public final b bleDevice;
    public final a bleManager = C0102a.f7939a;

    public BleStopCmd(b bVar) {
        this.bleDevice = bVar;
    }

    public Object exeCmd(OneDriver oneDriver) {
        b bVar = this.bleDevice;
        if (bVar == null) {
            this.bleManager.a();
        } else {
            c cVar = this.bleManager.f7932d;
            if (cVar != null) {
                cVar.b(bVar);
            }
        }
        return null;
    }
}
