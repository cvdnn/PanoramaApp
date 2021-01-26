package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.SetFileExtra;

public class SetFileExtraCmd implements InstaCmdExe {
    public SetFileExtra setFileExtra;

    public SetFileExtraCmd(SetFileExtra setFileExtra2) {
        this.setFileExtra = setFileExtra2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setFileExtra(this.setFileExtra));
    }
}
