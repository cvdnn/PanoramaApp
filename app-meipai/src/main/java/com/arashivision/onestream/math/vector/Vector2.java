package com.arashivision.onestream.math.vector;

public class Vector2 {
    public double mX;
    public double mY;

    public Vector2() {
    }

    public double getX() {
        return this.mX;
    }

    public double getY() {
        return this.mY;
    }

    public void setAll(double d2, double d3) {
        this.mX = d2;
        this.mY = d3;
    }

    public void setX(double d2) {
        this.mX = d2;
    }

    public void setY(double d2) {
        this.mY = d2;
    }

    public Vector2(double d2, double d3) {
        this.mX = d2;
        this.mY = d3;
    }

    public Vector2(String[] strArr) {
        this.mX = (double) Float.parseFloat(strArr[0]);
        this.mY = (double) Float.parseFloat(strArr[1]);
    }
}
