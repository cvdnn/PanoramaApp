package com.arashivision.graphicpath.render.util;

import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Matrix4fc;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.joml.Vector4f;

public class RotationUtil {
    public static Quaternionf removeRoll(Quaternionf quaternionf) {
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 1.0f);
        vector3f.rotate(quaternionf);
        quaternionf.setLookAtCompat(vector3f);
        return quaternionf;
    }

    public static Matrix4f removeRoll(Matrix4f matrix4f) {
        Vector4f vector4f = new Vector4f(0.0f, 0.0f, 1.0f, 0.0f);
        vector4f.mul((Matrix4fc) matrix4f);
        matrix4f.setLookAtCompat(new Vector3f(vector4f.x, vector4f.y, vector4f.z));
        return matrix4f;
    }
}
