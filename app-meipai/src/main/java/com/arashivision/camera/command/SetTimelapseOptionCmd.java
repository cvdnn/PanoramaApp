package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;

public class SetTimelapseOptionCmd implements InstaCmdExe {
    public SetTimelapseOptions setTimelapseOptions;

    public SetTimelapseOptionCmd(SetTimelapseOptions setTimelapseOptions2) {
        this.setTimelapseOptions = setTimelapseOptions2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Integer.valueOf(oneDriver.setTimelapseOptions(this.setTimelapseOptions));
    }
}
