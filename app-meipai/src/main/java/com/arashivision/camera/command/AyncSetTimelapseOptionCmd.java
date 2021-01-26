package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;

public class AyncSetTimelapseOptionCmd implements InstaCmdExe {
    public SetTimelapseOptions timelapseOptions;

    public AyncSetTimelapseOptionCmd(SetTimelapseOptions setTimelapseOptions) {
        this.timelapseOptions = setTimelapseOptions;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setTimelapseOptionsASync(this.timelapseOptions));
    }
}
