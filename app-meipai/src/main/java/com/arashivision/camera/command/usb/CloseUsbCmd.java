package com.arashivision.camera.command.usb;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.appusb.AppUsbService;

public class CloseUsbCmd implements InstaCmdExe {
    public AppUsbService mAppUsbService;

    public CloseUsbCmd(AppUsbService appUsbService) {
        this.mAppUsbService = appUsbService;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.close();
        AppUsbService appUsbService = this.mAppUsbService;
        if (appUsbService != null) {
            appUsbService.release();
        }
        return null;
    }
}
