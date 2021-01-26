package com.arashivision.onecamera.cameraresponse;

public class GyroData {
    public double accelX;
    public double accelY;
    public double accelZ;
    public double rotationX;
    public double rotationY;
    public double rotationZ;
    public long timestamp;

    private void setAccelX(double d2) {
        this.accelX = d2;
    }

    private void setAccelY(double d2) {
        this.accelY = d2;
    }

    private void setAccelZ(double d2) {
        this.accelZ = d2;
    }

    private void setRotationX(double d2) {
        this.rotationX = d2;
    }

    private void setRotationY(double d2) {
        this.rotationY = d2;
    }

    private void setRotationZ(double d2) {
        this.rotationZ = d2;
    }

    private void setTimestamp(long j2) {
        this.timestamp = j2;
    }
}
