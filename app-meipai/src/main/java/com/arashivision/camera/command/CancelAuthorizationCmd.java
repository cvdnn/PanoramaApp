package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class CancelAuthorizationCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.cancelAuthorization());
    }
}
