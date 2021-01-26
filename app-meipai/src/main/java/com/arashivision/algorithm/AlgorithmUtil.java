package com.arashivision.algorithm;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import com.arashivision.graphicpath.render.base.BaseCameraController;

public class AlgorithmUtil {

    public static final class GetDoubleAsteroidFovInfo {
        public float deltaFovRadian = ((float) Math.toRadians(1.0d));
        public float limitInsidePositionY = 0.01f;
        public float limitOutsidePositionY = 0.24f;
        public BaseCameraController mInsideCameraController;
        public BaseCameraController mOutsideCameraController;
        public float maxFovRadian = ((float) Math.toRadians(170.0d));
        public float minFovRadian = ((float) Math.toRadians(80.0d));
        public float[] spherePosition;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public static int getDoubleAsteroidFov(GetDoubleAsteroidFovInfo getDoubleAsteroidFovInfo, float[] fArr) {
        return nativeGetDoubleAsteroidFov(getDoubleAsteroidFovInfo.mOutsideCameraController, getDoubleAsteroidFovInfo.mInsideCameraController, getDoubleAsteroidFovInfo.minFovRadian, getDoubleAsteroidFovInfo.maxFovRadian, getDoubleAsteroidFovInfo.deltaFovRadian, getDoubleAsteroidFovInfo.limitOutsidePositionY, getDoubleAsteroidFovInfo.limitInsidePositionY, getDoubleAsteroidFovInfo.spherePosition, fArr);
    }

    public static native boolean nativeCheckRotate(float[] fArr, float f2, float f3, float[] fArr2, float f4, float f5, float f6, float f7);

    public static native float[] nativeConvertQuat(float[] fArr, float f2, float f3, float f4);

    public static native int nativeGetDoubleAsteroidFov(BaseCameraController baseCameraController, BaseCameraController baseCameraController2, float f2, float f3, float f4, float f5, float f6, float[] fArr, float[] fArr2);

    public static native int nativeTestRotation();

    public static void testRotation() {
        nativeTestRotation();
    }
}
