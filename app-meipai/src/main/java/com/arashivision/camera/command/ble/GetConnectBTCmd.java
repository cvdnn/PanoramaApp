package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetConnectedBTPeripheral;

public class GetConnectBTCmd implements InstaCmdExe {
    public GetConnectedBTPeripheral mGetConnectedBTPeripheral;

    public GetConnectBTCmd(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        this.mGetConnectedBTPeripheral = getConnectedBTPeripheral;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getConnectBT(this.mGetConnectedBTPeripheral));
    }
}
