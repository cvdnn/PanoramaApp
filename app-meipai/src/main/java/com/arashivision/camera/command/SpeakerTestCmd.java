package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SpeakerTestCmd implements InstaCmdExe {
    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.startSpeakerTest());
    }
}
