package com.arashivision.onecamera.cameraresponse;

import com.arashivision.onecamera.cameranotification.BTPeripheral;

public class GetConnectedBTPeripheralResp {
    public BTPeripheral[] peripherals;

    private void setPeripherals(BTPeripheral[] bTPeripheralArr) {
        this.peripherals = bTPeripheralArr;
    }
}
