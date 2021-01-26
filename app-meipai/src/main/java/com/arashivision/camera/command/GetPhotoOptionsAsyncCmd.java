package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import java.util.List;

public class GetPhotoOptionsAsyncCmd implements InstaCmdExe {
    public int mFunMode;
    public List<String> mOptions;

    public GetPhotoOptionsAsyncCmd(int i2, List<String> list) {
        this.mFunMode = i2;
        this.mOptions = list;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getPhotographyOptionsAsync(this.mFunMode, this.mOptions));
    }
}
