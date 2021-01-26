package com.arashivision.camera.command;

import android.util.Log;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.TakePicture;

public class CaptureCommand implements InstaCmdExe {
    public static final String TAG = "com.arashivision.camera.command.CaptureCommand";
    public TakePicture mTakePicture;
    public boolean withoutStorage;

    public CaptureCommand(TakePicture takePicture, boolean z) {
        this.mTakePicture = takePicture;
        this.withoutStorage = z;
    }

    public Object exeCmd(OneDriver oneDriver) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" one driver = ");
        sb.append(oneDriver);
        Log.d(str, sb.toString());
        if (this.withoutStorage) {
            oneDriver.captureStillImageWithouStorage(this.mTakePicture);
        } else {
            oneDriver.captureStillImage(this.mTakePicture);
        }
        return Integer.valueOf(0);
    }
}
