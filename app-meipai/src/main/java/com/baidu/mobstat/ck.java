package com.baidu.mobstat;

import com.arashivision.sdkcamera.camera.InstaCameraManager;

public class ck extends ch {
    public ck() {
        super(InstaCameraManager.CAPTURE_TYPE_TIME_SHIFT_RECORD);
    }

    public ck(String str) {
        super((int) InstaCameraManager.CAPTURE_TYPE_TIME_SHIFT_RECORD, str);
    }
}
