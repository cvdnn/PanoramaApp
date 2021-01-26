package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.GetFileList;

public class GetFileListCmd implements InstaCmdExe {
    public GetFileList mGetFileList;

    public GetFileListCmd(GetFileList getFileList) {
        this.mGetFileList = getFileList;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getFileList(this.mGetFileList));
    }
}
