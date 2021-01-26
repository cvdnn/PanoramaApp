package com.arashivision.camera.command;

import com.arashivision.camera.stream.StreamProcess;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onestream.OneStreamPipeline;

public class StopStreamingCmd implements InstaCmdExe {
    public OneStreamPipeline mStreamPipeline;
    public StreamProcess mStreamProcess;

    public StopStreamingCmd(OneStreamPipeline oneStreamPipeline, StreamProcess streamProcess) {
        this.mStreamPipeline = oneStreamPipeline;
        this.mStreamProcess = streamProcess;
    }

    public Object exeCmd(OneDriver oneDriver) {
        long stopStreaming = oneDriver.stopStreaming();
        oneDriver.setStreamListener(null);
        StreamProcess streamProcess = this.mStreamProcess;
        if (streamProcess != null) {
            streamProcess.release();
            this.mStreamProcess = null;
        }
        OneStreamPipeline oneStreamPipeline = this.mStreamPipeline;
        if (oneStreamPipeline != null) {
            oneStreamPipeline.close();
            this.mStreamPipeline.release();
            this.mStreamPipeline = null;
        }
        return Long.valueOf(stopStreaming);
    }
}
