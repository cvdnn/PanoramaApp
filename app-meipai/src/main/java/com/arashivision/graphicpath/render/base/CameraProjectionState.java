package com.arashivision.graphicpath.render.base;

public class CameraProjectionState {
    public float aspect;
    public float far;
    public float fov;
    public float near;
    public float xScale = 1.0f;
    public float yScale = 1.0f;
    public float zoom;

    public CameraProjectionState(float f2, float f3, float f4, float f5, float f6) {
        this.fov = f2;
        this.aspect = f3;
        this.near = f4;
        this.far = f5;
        this.zoom = f6;
    }

    public float getAspect() {
        return this.aspect;
    }

    public float getFar() {
        return this.far;
    }

    public float getFov() {
        return this.fov;
    }

    public float getNear() {
        return this.near;
    }

    public float getXScale() {
        return this.xScale;
    }

    public float getYScale() {
        return this.yScale;
    }

    public float getZoom() {
        return this.zoom;
    }

    public void setAspect(float f2) {
        this.aspect = f2;
    }

    public void setFar(float f2) {
        this.far = f2;
    }

    public void setFov(float f2) {
        this.fov = f2;
    }

    public void setNear(float f2) {
        this.near = f2;
    }

    public void setXScale(float f2) {
        this.xScale = f2;
    }

    public void setYScale(float f2) {
        this.yScale = f2;
    }

    public void setZoom(float f2) {
        this.zoom = f2;
    }

    public CameraProjectionState(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.fov = f2;
        this.aspect = f3;
        this.near = f4;
        this.far = f5;
        this.zoom = f6;
        this.xScale = f7;
        this.yScale = f8;
    }
}
