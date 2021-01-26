package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;

public class CheckAuthorizationCmd implements InstaCmdExe {
    public CheckAuthorization mCheckAuthorization;

    public CheckAuthorizationCmd(CheckAuthorization checkAuthorization) {
        this.mCheckAuthorization = checkAuthorization;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.checkAuthorization(this.mCheckAuthorization.uniqueId));
    }
}
