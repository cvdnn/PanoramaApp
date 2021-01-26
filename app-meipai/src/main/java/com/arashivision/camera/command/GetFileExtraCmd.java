package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetFileExtra;

public class GetFileExtraCmd implements InstaCmdExe {
    public GetFileExtra getFileExtra;

    public GetFileExtraCmd(GetFileExtra getFileExtra2) {
        this.getFileExtra = getFileExtra2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getFileExtra(this.getFileExtra));
    }
}
