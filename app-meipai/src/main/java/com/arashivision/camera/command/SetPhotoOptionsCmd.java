package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.PhotoOptions;

public class SetPhotoOptionsCmd implements InstaCmdExe {
    public int mFuncMode;
    public PhotoOptions mPhotoOptions;

    public SetPhotoOptionsCmd(int i2, PhotoOptions photoOptions) {
        this.mFuncMode = i2;
        this.mPhotoOptions = photoOptions;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setPhotographyOptions(this.mFuncMode, this.mPhotoOptions));
    }
}
