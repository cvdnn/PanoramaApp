package com.arashivision.camera.command;

import android.util.Log;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;

public class ResetRecord implements InstaCmdExe {
    public static final String TAG = "RestRecord";
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public OneStreamPipeline mStreamPiple;

    public ResetRecord(ICameraPreviewPipeline iCameraPreviewPipeline, OneStreamPipeline oneStreamPipeline) {
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
        this.mStreamPiple = oneStreamPipeline;
    }

    public Object exeCmd(OneDriver oneDriver) {
        if (this.mICameraPreviewPipeline != null) {
            Log.i(TAG, "resetRecord while live");
            this.mICameraPreviewPipeline.onStopLive();
        } else {
            this.mStreamPiple.resetRecord();
        }
        return null;
    }
}
