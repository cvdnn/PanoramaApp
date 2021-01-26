package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.Options;

public class SetOptionAsyncCmd implements InstaCmdExe {
    public Options mOptions;

    public SetOptionAsyncCmd(Options options) {
        this.mOptions = options;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setOptionsAsync(this.mOptions));
    }
}
