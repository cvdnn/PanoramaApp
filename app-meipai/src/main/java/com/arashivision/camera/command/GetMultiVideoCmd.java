package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;
import java.util.List;

public class GetMultiVideoCmd implements InstaCmdExe {
    public List<String> mOptionList;

    public GetMultiVideoCmd(List<String> list) {
        this.mOptionList = list;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.getMultiVideo(this.mOptionList));
    }
}
