package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.TakePicture;

public class CaptureWithoutStorageCmd implements InstaCmdExe {
    public TakePicture mTakePicture;

    public CaptureWithoutStorageCmd(TakePicture takePicture) {
        this.mTakePicture = takePicture;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.captureStillImageWithouStorage(this.mTakePicture);
        return Integer.valueOf(0);
    }
}
