package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.ConnectToBTPeripheral;

public class ConnectBTCmd implements InstaCmdExe {
    public ConnectToBTPeripheral mConnectToBTPeripheral;

    public ConnectBTCmd(ConnectToBTPeripheral connectToBTPeripheral) {
        this.mConnectToBTPeripheral = connectToBTPeripheral;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.connectBT(this.mConnectToBTPeripheral));
    }
}
