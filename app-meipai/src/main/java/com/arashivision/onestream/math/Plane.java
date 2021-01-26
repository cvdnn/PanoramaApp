package com.arashivision.onestream.math;

import com.arashivision.onestream.math.vector.Vector3;

public class Plane {
    public double mD;
    public Vector3 mNormal;

    public enum PlaneSide {
        BACK,
        ONPLANE,
        FRONT
    }

    public Plane() {
        this.mNormal = new Vector3();
    }

    public double getD() {
        return this.mD;
    }

    public double getDistanceTo(Vector3 vector3) {
        return this.mNormal.dot(vector3) + this.mD;
    }

    public Vector3 getNormal() {
        return this.mNormal;
    }

    public PlaneSide getPointSide(Vector3 vector3) {
        double dot = Vector3.dot(this.mNormal, vector3) + this.mD;
        if (dot == 0.0d) {
            return PlaneSide.ONPLANE;
        }
        if (dot < 0.0d) {
            return PlaneSide.BACK;
        }
        return PlaneSide.FRONT;
    }

    public boolean isFrontFacing(Vector3 vector3) {
        return Vector3.dot(this.mNormal, vector3) <= 0.0d;
    }

    public void normalize() {
        double length = 1.0d / this.mNormal.length();
        this.mNormal.multiply(length);
        this.mD *= length;
    }

    public void set(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Vector3 vector34 = new Vector3();
        Vector3 vector35 = new Vector3();
        vector34.subtractAndSet(vector3, vector32);
        vector35.subtractAndSet(vector33, vector32);
        Vector3 cross = vector34.cross(vector35);
        this.mNormal = cross;
        cross.normalize();
        this.mD = -vector3.dot(this.mNormal);
    }

    public void setComponents(double d2, double d3, double d4, double d5) {
        this.mNormal.setAll(d2, d3, d4);
        this.mD = d5;
    }

    public Plane(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        set(vector3, vector32, vector33);
    }
}
