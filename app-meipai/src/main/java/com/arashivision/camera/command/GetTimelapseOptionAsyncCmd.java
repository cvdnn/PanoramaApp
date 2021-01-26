package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;

public class GetTimelapseOptionAsyncCmd implements InstaCmdExe {
    public GetTimelapseOptions mGetTimelapseOptions;

    public GetTimelapseOptionAsyncCmd(GetTimelapseOptions getTimelapseOptions) {
        this.mGetTimelapseOptions = getTimelapseOptions;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getTimelapseOptionsAsync(this.mGetTimelapseOptions));
    }
}
