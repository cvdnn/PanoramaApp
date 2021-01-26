package com.arashivision.camera.listener;

import com.arashivision.camera.InstaCameraConstants.RecordingType;

public interface ICameraLiveStateListener {
    void onRecordComplete(RecordingType recordingType, String str);

    void onRecordError(int i2, RecordingType recordingType, String str);
}
