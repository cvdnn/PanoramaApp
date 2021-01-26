package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetGyro;

public class GetGyroSyncCmd implements InstaCmdExe {
    public final GetGyro mGetGyro;

    public GetGyroSyncCmd(GetGyro getGyro) {
        this.mGetGyro = getGyro;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.getGyroAsync(this.mGetGyro);
        return null;
    }
}
