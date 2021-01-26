package com.arashivision.graphicpath.render.util;

import com.arashivision.insbase.joml.Quaternionf;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class MathDataConverter {
    public static Quaternionf FloatArrayToQuaternion(float[] fArr) {
        return new Quaternionf(fArr[1], fArr[2], fArr[3], fArr[0]);
    }

    public static Quaternionf FloatBufferToQuaternion(FloatBuffer floatBuffer) {
        return new Quaternionf(floatBuffer.get(1), floatBuffer.get(2), floatBuffer.get(3), floatBuffer.get(0));
    }

    public static float[] QuaternionToFloatArray(Quaternionf quaternionf) {
        return new float[]{quaternionf.w, quaternionf.x, quaternionf.y, quaternionf.z};
    }

    public static FloatBuffer QuaternionToFloatBuffer(Quaternionf quaternionf) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(128).asFloatBuffer();
        asFloatBuffer.put(quaternionf.w);
        asFloatBuffer.put(quaternionf.x);
        asFloatBuffer.put(quaternionf.y);
        asFloatBuffer.put(quaternionf.z);
        asFloatBuffer.flip();
        return asFloatBuffer;
    }
}
