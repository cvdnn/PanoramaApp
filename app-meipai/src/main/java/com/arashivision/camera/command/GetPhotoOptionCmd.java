package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import java.util.List;

public class GetPhotoOptionCmd implements InstaCmdExe {
    public int mFunMode;
    public List<String> mOptions;

    public GetPhotoOptionCmd(int i2, List<String> list) {
        this.mFunMode = i2;
        this.mOptions = list;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return oneDriver.getPhotographyOptions(this.mFunMode, this.mOptions);
    }
}
