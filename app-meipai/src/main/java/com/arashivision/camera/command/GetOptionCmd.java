package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import java.util.List;

public class GetOptionCmd implements InstaCmdExe {
    public List<String> mOptionList;

    public GetOptionCmd(List<String> list) {
        this.mOptionList = list;
    }

    public Object exeCmd(OneDriver oneDriver) {
        List<String> list = this.mOptionList;
        if (list == null) {
            return oneDriver.getAllOptions();
        }
        return oneDriver.getOptions(list);
    }
}
