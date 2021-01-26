package com.arashivision.graphicpath.render.base;

public class CameraConstraint {
    public float maxDistance;
    public float maxFov;
    public float maxPitch;
    public float maxYaw;
    public float minDistance;
    public float minFov;
    public float minPitch;
    public float minYaw;

    public CameraConstraint(float f2, float f3, float f4, float f5, float f6, float f7) {
        this(f2, f3, f4, f5, f6, f7, -3.4028235E38f, Float.MAX_VALUE);
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

    public float getMaxYaw() {
        return this.maxYaw;
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

    public float getMinYaw() {
        return this.minYaw;
    }

    public CameraConstraint(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.minPitch = f2;
        this.maxPitch = f3;
        this.minFov = f4;
        this.maxFov = f5;
        this.minDistance = f6;
        this.maxDistance = f7;
        this.minYaw = f8;
        this.maxYaw = f9;
    }
}
