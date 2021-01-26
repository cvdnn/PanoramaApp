package com.arashivision.arvbmg.bigboom.passby;

import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;

public class PassByConfig {
    public String cacheJsonPath;
    public int height = 320;
    public int lostFrameCount = 5;
    public String mnnPath;
    public String namesPath;
    public float passAngleBegin = 30.0f;
    public float passAngleEnd = 150.0f;
    public boolean quick = true;
    public int width = CameraInterface.DEFAULT_PREVIEW_WIDTH;
}
