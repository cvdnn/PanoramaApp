package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.camerarequest.DeleteFiles;

public class DeleteFileListCmd implements InstaCmdExe {
    public final DeleteFiles mDeleteFiles;

    public DeleteFileListCmd(DeleteFiles deleteFiles) {
        this.mDeleteFiles = deleteFiles;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.deleteFiles(this.mDeleteFiles));
    }
}
