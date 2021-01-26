package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SingleSensorCmd implements InstaCmdExe {
    public int mSensor;

    public SingleSensorCmd(int i2) {
        this.mSensor = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setSingleSensor(this.mSensor));
    }
}
