package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.StopTimelapse;

public class StopTimelapseCmd implements InstaCmdExe {
    public StopTimelapse stopTimelapse;

    public StopTimelapseCmd(StopTimelapse stopTimelapse2) {
        this.stopTimelapse = stopTimelapse2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.stopTimeplapse(this.stopTimelapse);
        return null;
    }
}
