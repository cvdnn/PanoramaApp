package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.StartTimelapse;

public class StartTimeplaseCmd implements InstaCmdExe {
    public StartTimelapse mStartTimelapse;

    public StartTimeplaseCmd(StartTimelapse startTimelapse) {
        this.mStartTimelapse = startTimelapse;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.startTimeplapse(this.mStartTimelapse);
        return Integer.valueOf(0);
    }
}
