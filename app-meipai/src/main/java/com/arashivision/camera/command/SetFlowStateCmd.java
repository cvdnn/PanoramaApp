package com.arashivision.camera.command;

import com.arashivision.onecamera.OneDriver;

public class SetFlowStateCmd implements InstaCmdExe {
    public int flowStateEnable;

    public SetFlowStateCmd(int i2) {
        this.flowStateEnable = i2;
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(oneDriver.setFlowStateEnable(this.flowStateEnable));
    }
}
