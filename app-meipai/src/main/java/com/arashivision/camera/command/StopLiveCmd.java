package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;

public class StopLiveCmd implements InstaCmdExe {
    public ICameraPreviewPipeline mCameraPreviewPipeline;

    public StopLiveCmd(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mCameraPreviewPipeline = iCameraPreviewPipeline;
    }

    public Object exeCmd(OneDriver oneDriver) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mCameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onStopLive();
        }
        return null;
    }
}
