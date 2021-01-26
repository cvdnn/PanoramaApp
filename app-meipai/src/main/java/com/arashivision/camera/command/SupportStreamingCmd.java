package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SupportStreamingCmd implements InstaCmdExe {
    public boolean mIsSupportStreaming;

    public SupportStreamingCmd(boolean z) {
        this.mIsSupportStreaming = z;
    }

    public Object exeCmd(OneDriver oneDriver) {
        oneDriver.setSupportStreaming(this.mIsSupportStreaming);
        return null;
    }
}
