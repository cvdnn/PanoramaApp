package com.arashivision.graphicpath.render.base;

public class CameraTransformState {
    public float distance;
    public float pitch;
    public float roll;
    public float yaw;

    public CameraTransformState() {
    }

    public float getDistance() {
        return this.distance;
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

    public void setPitch(float f2) {
        this.pitch = f2;
    }

    public void setRoll(float f2) {
        this.roll = f2;
    }

    public void setYaw(float f2) {
        this.yaw = f2;
    }

    public CameraTransformState(float f2, float f3, float f4, float f5) {
        this.yaw = f2;
        this.pitch = f3;
        this.roll = f4;
        this.distance = f5;
    }
}
