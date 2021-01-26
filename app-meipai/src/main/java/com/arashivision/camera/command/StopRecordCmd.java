package com.arashivision.camera.command;

import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onestream.OneStreamPipeline;

public class StopRecordCmd implements InstaCmdExe {
    public byte[] mExtraData;
    public int mMode;
    public RecordingType mRecordingType;
    public OneStreamPipeline mStreamPipeline;

    public StopRecordCmd(int i2, byte[] bArr, RecordingType recordingType, OneStreamPipeline oneStreamPipeline) {
        this.mExtraData = bArr;
        this.mRecordingType = recordingType;
        this.mStreamPipeline = oneStreamPipeline;
        this.mMode = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        if (RecordingType.Camera == this.mRecordingType) {
            oneDriver.stopRecordWithCameraStorage(this.mMode, this.mExtraData);
        } else {
            this.mStreamPipeline.stopRecordVideo();
        }
        return Integer.valueOf(0);
    }
}
