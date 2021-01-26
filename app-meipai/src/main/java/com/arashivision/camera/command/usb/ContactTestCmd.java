package com.arashivision.camera.command.usb;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public class ContactTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.startContactTest();
        return null;
    }
}
