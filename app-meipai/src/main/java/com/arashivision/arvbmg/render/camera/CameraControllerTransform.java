package com.arashivision.arvbmg.render.camera;

public class CameraControllerTransform {
    public float aspect = Float.MAX_VALUE;
    public float distance = Float.MAX_VALUE;
    public float fixedRoll = Float.MAX_VALUE;
    public float fov = Float.MAX_VALUE;
    public float maxDistance = Float.MAX_VALUE;
    public float maxFov = Float.MAX_VALUE;
    public float maxPitch = Float.MAX_VALUE;
    public float minDistance = Float.MAX_VALUE;
    public float minFov = Float.MAX_VALUE;
    public float minPitch = Float.MAX_VALUE;
    public float pitch = Float.MAX_VALUE;
    public float yaw = Float.MAX_VALUE;

    public float getAspect() {
        return this.aspect;
    }

    public float getDistance() {
        return this.distance;
    }

    public float getFixedRoll() {
        return this.fixedRoll;
    }

    public float getFov() {
        return this.fov;
    }

    public float getMaxDistance() {
        return this.maxDistance;
    }

    public float getMaxFov() {
        return this.maxFov;
    }

    public float getMaxPitch() {
        return this.maxPitch;
    }

    public float getMinDistance() {
        return this.minDistance;
    }

    public float getMinFov() {
        return this.minFov;
    }

    public float getMinPitch() {
        return this.minPitch;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void reset() {
        this.yaw = Float.MAX_VALUE;
        this.pitch = Float.MAX_VALUE;
        this.fixedRoll = Float.MAX_VALUE;
        this.distance = Float.MAX_VALUE;
        this.aspect = Float.MAX_VALUE;
        this.fov = Float.MAX_VALUE;
        this.maxPitch = Float.MAX_VALUE;
        this.maxFov = Float.MAX_VALUE;
        this.maxDistance = Float.MAX_VALUE;
        this.minPitch = Float.MAX_VALUE;
        this.minFov = Float.MAX_VALUE;
        this.minDistance = Float.MAX_VALUE;
    }

    public void setAspect(float f2) {
        this.aspect = f2;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setFixedRoll(float f2) {
        this.fixedRoll = f2;
    }

    public void setFov(float f2) {
        this.fov = f2;
    }

    public void setMaxDistance(float f2) {
        this.maxDistance = f2;
    }

    public void setMaxFov(float f2) {
        this.maxFov = f2;
    }

    public void setMaxPitch(float f2) {
        this.maxPitch = f2;
    }

    public void setMinDistance(float f2) {
        this.minDistance = f2;
    }

    public void setMinFov(float f2) {
        this.minFov = f2;
    }

    public void setMinPitch(float f2) {
        this.minPitch = f2;
    }

    public void setPitch(float f2) {
        this.pitch = f2;
    }

    public void setYaw(float f2) {
        this.yaw = f2;
    }
}
