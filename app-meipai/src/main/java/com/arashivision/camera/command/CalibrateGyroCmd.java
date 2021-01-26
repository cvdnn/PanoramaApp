package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;

public class CalibrateGyroCmd implements InstaCmdExe {
    public CalibrateGyro mCalibrateGyro;

    public CalibrateGyroCmd(CalibrateGyro calibrateGyro) {
        this.mCalibrateGyro = calibrateGyro;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.calibrateGyro(this.mCalibrateGyro));
    }
}
