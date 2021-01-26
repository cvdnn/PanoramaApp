package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import java.util.List;

public class GetOptionSyncCmd implements InstaCmdExe {
    public List<String> mOptionList;

    public GetOptionSyncCmd(List<String> list) {
        this.mOptionList = list;
    }

    public Object exeCmd(OneDriver oneDriver) {
        List<String> list = this.mOptionList;
        if (list == null) {
            return Long.valueOf(oneDriver.getAllOptionsAsync());
        }
        return Long.valueOf(oneDriver.getOptionsAsync(list));
    }
}
