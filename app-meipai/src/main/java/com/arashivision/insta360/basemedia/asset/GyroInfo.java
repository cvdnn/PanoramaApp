package com.arashivision.insta360.basemedia.asset;

import a.a.a.a.b.a;

public class GyroInfo {
    public static final int LENGTH = 56;
    public double accelerate_x;
    public double accelerate_y;
    public double accelerate_z;
    public double rotation_x;
    public double rotation_y;
    public double rotation_z;
    public long timestamp;

    public GyroInfo() {
    }

    public GyroInfo(byte[] bArr) {
        if (bArr != null && bArr.length >= 56) {
            this.timestamp = a.a(bArr, 0);
            this.accelerate_x = a.b(bArr, 8);
            this.accelerate_y = a.b(bArr, 16);
            this.accelerate_z = a.b(bArr, 24);
            this.rotation_x = a.b(bArr, 32);
            this.rotation_y = a.b(bArr, 40);
            this.rotation_z = a.b(bArr, 48);
        }
    }

    public double getAccelerate_x() {
        return this.accelerate_x;
    }

    public double getAccelerate_y() {
        return this.accelerate_y;
    }

    public double getAccelerate_z() {
        return this.accelerate_z;
    }

    public float[] getGyro() {
        return new float[]{(float) this.accelerate_x, (float) this.accelerate_y, (float) this.accelerate_z, (float) this.rotation_x, (float) this.rotation_y, (float) this.rotation_z};
    }

    public double getRotation_x() {
        return this.rotation_x;
    }

    public double getRotation_y() {
        return this.rotation_y;
    }

    public double getRotation_z() {
        return this.rotation_z;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAccelerate_x(double d2) {
        this.accelerate_x = d2;
    }

    public void setAccelerate_y(double d2) {
        this.accelerate_y = d2;
    }

    public void setAccelerate_z(double d2) {
        this.accelerate_z = d2;
    }

    public void setRotation_x(double d2) {
        this.rotation_x = d2;
    }

    public void setRotation_y(double d2) {
        this.rotation_y = d2;
    }

    public void setRotation_z(double d2) {
        this.rotation_z = d2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[56];
        System.arraycopy(a.a(this.timestamp), 0, bArr, 0, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.accelerate_x)), 0, bArr, 8, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.accelerate_y)), 0, bArr, 16, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.accelerate_z)), 0, bArr, 24, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.rotation_x)), 0, bArr, 32, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.rotation_y)), 0, bArr, 40, 8);
        System.arraycopy(a.a(Double.doubleToLongBits(this.rotation_z)), 0, bArr, 48, 8);
        return bArr;
    }
}
