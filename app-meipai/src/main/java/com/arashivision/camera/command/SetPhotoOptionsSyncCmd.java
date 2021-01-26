package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.PhotoOptions;

public class SetPhotoOptionsSyncCmd implements InstaCmdExe {
    public int mFuncMode;
    public PhotoOptions mPhotoOptions;

    public SetPhotoOptionsSyncCmd(int i2, PhotoOptions photoOptions) {
        this.mFuncMode = i2;
        this.mPhotoOptions = photoOptions;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setPhotographyOptionsAsync(this.mFuncMode, this.mPhotoOptions));
    }
}
