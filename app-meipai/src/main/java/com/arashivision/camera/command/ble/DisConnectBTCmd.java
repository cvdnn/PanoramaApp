package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.DisconnectBTPeripheral;

public class DisConnectBTCmd implements InstaCmdExe {
    public DisconnectBTPeripheral mDisconnectBTPeripheral;

    public DisConnectBTCmd(DisconnectBTPeripheral disconnectBTPeripheral) {
        this.mDisconnectBTPeripheral = disconnectBTPeripheral;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.disConnectBT(this.mDisconnectBTPeripheral));
    }
}
