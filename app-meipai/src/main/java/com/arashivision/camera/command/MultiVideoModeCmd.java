package com.arashivision.camera.command;

import com.arashivision.onecamera.MultiPhotoOptions;
import com.arashivision.onecamera.OneDriver;

public class MultiVideoModeCmd implements InstaCmdExe {
    public MultiPhotoOptions mOptions;

    public MultiVideoModeCmd(MultiPhotoOptions multiPhotoOptions) {
        this.mOptions = multiPhotoOptions;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setMultiVideoMode(this.mOptions));
    }
}
