package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;

public class GetTimelapseOptionCmd implements InstaCmdExe {
    public GetTimelapseOptions getTimelapseOptions;

    public GetTimelapseOptionCmd(GetTimelapseOptions getTimelapseOptions2) {
        this.getTimelapseOptions = getTimelapseOptions2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return oneDriver.getTimelapseOptions(this.getTimelapseOptions);
    }
}
