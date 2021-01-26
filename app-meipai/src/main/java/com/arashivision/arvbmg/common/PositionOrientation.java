package com.arashivision.arvbmg.common;

import e.a.a.a.a;
import java.util.Arrays;

public class PositionOrientation {
    public float[] quat;
    public long timestamp;
    public float x;
    public float y;

    public float[] getQuat() {
        return this.quat;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setQuat(float[] fArr) {
        this.quat = fArr;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    public String toString() {
        StringBuilder a2 = a.a("PositionOrientation{timestamp=");
        a2.append(this.timestamp);
        a2.append(", quat=");
        a2.append(Arrays.toString(this.quat));
        a2.append('}');
        return a2.toString();
    }
}
