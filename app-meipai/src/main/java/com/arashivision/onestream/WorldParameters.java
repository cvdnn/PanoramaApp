package com.arashivision.onestream;

import com.arashivision.onestream.math.vector.Vector3;

public final class WorldParameters {
    public static final Vector3 FORWARD_AXIS = Vector3.Z.clone();
    public static final Vector3 NEG_FORWARD_AXIS = Vector3.NEG_Z.clone();
    public static final Vector3 NEG_RIGHT_AXIS = Vector3.NEG_X.clone();
    public static final Vector3 NEG_UP_AXIS = Vector3.NEG_Y.clone();
    public static final Vector3 RIGHT_AXIS = Vector3.X.clone();
    public static final Vector3 TEMP_VECTOR = new Vector3();
    public static final Vector3 UP_AXIS = Vector3.Y.clone();

    public static void setWorldAxes(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        TEMP_VECTOR.crossAndSet(vector3, vector32);
        if (TEMP_VECTOR.equals(vector33, 1.0E-6d)) {
            RIGHT_AXIS.setAll(vector3);
            NEG_RIGHT_AXIS.setAll(RIGHT_AXIS).inverse();
            UP_AXIS.setAll(vector32);
            NEG_UP_AXIS.setAll(UP_AXIS).inverse();
            FORWARD_AXIS.setAll(vector33);
            NEG_FORWARD_AXIS.setAll(FORWARD_AXIS).inverse();
            return;
        }
        throw new IllegalArgumentException("World axes must be orthogonal.");
    }
}
