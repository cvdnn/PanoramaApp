package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetGyro;

public class GetGyroCmd implements InstaCmdExe {
    public GetGyro mGetGyro;

    public GetGyroCmd(GetGyro getGyro) {
        this.mGetGyro = getGyro;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return oneDriver.getGyro(this.mGetGyro);
    }
}
