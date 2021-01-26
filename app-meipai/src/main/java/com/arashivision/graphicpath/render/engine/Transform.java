package com.arashivision.graphicpath.render.engine;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Transform {
    public float distance;
    public float fov;
    public float pitch;
    public float roll;
    public float yaw;

    public Transform() {
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) obj;
        if (this.yaw == transform.yaw && this.pitch == transform.pitch && this.roll == transform.roll && this.distance == transform.distance && this.fov == transform.fov) {
            z = true;
        }
        return z;
    }

    public Transform fromFloatBuffer(FloatBuffer floatBuffer) {
        this.yaw = floatBuffer.get(0);
        this.pitch = floatBuffer.get(1);
        this.roll = floatBuffer.get(2);
        this.distance = floatBuffer.get(3);
        this.fov = floatBuffer.get(4);
        return this;
    }

    public float getDistance() {
        return this.distance;
    }

    public float getFov() {
        return this.fov;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setFov(float f2) {
        this.fov = f2;
    }

    public void setPitch(float f2) {
        this.pitch = f2;
    }

    public void setRoll(float f2) {
        this.roll = f2;
    }

    public void setYaw(float f2) {
        this.yaw = f2;
    }

    public float[] toFloatArray() {
        return new float[]{this.yaw, this.pitch, this.roll, this.distance, this.fov};
    }

    public FloatBuffer toFloatBuffer() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(128).asFloatBuffer();
        asFloatBuffer.put(this.yaw);
        asFloatBuffer.put(this.pitch);
        asFloatBuffer.put(this.roll);
        asFloatBuffer.put(this.distance);
        asFloatBuffer.put(this.fov);
        asFloatBuffer.flip();
        return asFloatBuffer;
    }

    public Transform(float f2, float f3, float f4, float f5) {
        this.yaw = f2;
        this.pitch = f3;
        this.distance = f4;
        this.fov = f5;
    }

    public Transform fromFloatBuffer(float[] fArr) {
        this.yaw = fArr[0];
        this.pitch = fArr[1];
        this.roll = fArr[2];
        this.distance = fArr[3];
        this.fov = fArr[4];
        return this;
    }

    public Transform(float f2, float f3, float f4, float f5, float f6) {
        this.yaw = f2;
        this.pitch = f3;
        this.roll = f4;
        this.distance = f5;
        this.fov = f6;
    }
}
