package com.arashivision.camera.command.ble;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.ScanBTPeripheral;

public class ScanBTCmd implements InstaCmdExe {
    public ScanBTPeripheral mScanBTPeripheral;

    public ScanBTCmd(ScanBTPeripheral scanBTPeripheral) {
        this.mScanBTPeripheral = scanBTPeripheral;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.scanBT(this.mScanBTPeripheral));
    }
}
