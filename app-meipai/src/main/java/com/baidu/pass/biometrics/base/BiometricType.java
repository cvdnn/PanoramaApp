package com.baidu.pass.biometrics.base;

public final class BiometricType {
    public static final int LIVENESS_RECOG = 4;

    public static String getClass(int i2) {
        return i2 != 4 ? "" : "com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager";
    }
}
