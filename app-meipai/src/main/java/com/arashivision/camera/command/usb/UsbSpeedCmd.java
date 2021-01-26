package com.arashivision.camera.command.usb;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;

public class UsbSpeedCmd implements InstaCmdExe {
    public TestSDCardSpeed mTestSDCardSpeed;

    public UsbSpeedCmd(TestSDCardSpeed testSDCardSpeed) {
        this.mTestSDCardSpeed = testSDCardSpeed;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.testSDCardSpeed(this.mTestSDCardSpeed));
    }
}
