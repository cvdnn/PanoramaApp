package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import e.a.a.a.a;

public final class StapleTrackResult {
    public float fov;
    public float[] rect;
    public float[] smoothBottonMiddlePosition;
    public float[] smoothQuat;
    public float[] smoothSpherePosition;
    public double srcTime;
    public float[] unsmoothBottonMiddlePosition;
    public float[] unsmoothQuat;
    public float[] unsmoothSpherePosition;

    public float getFov() {
        return this.fov;
    }

    public float[] getRect() {
        return this.rect;
    }

    public float[] getSmoothBottonMiddlePosition() {
        return this.smoothBottonMiddlePosition;
    }

    public float[] getSmoothQuat() {
        return this.smoothQuat;
    }

    public float[] getSmoothSpherePosition() {
        return this.smoothSpherePosition;
    }

    public double getSrcTime() {
        return this.srcTime;
    }

    public float[] getUnsmoothBottonMiddlePosition() {
        return this.unsmoothBottonMiddlePosition;
    }

    public float[] getUnsmoothQuat() {
        return this.unsmoothQuat;
    }

    public float[] getUnsmoothSpherePosition() {
        return this.unsmoothSpherePosition;
    }

    public void printInfo() {
        StringBuilder a2 = a.a("srcTime ");
        a2.append(getSrcTime());
        a2.append(" fov ");
        a2.append(getFov());
        a2.append(" rect (");
        a2.append(getRect()[0]);
        String str = ",";
        a2.append(str);
        a2.append(getRect()[1]);
        a2.append(str);
        a2.append(getRect()[2]);
        a2.append(str);
        a2.append(getRect()[3]);
        a2.append(" smoothQuat (");
        a2.append(getSmoothQuat()[0]);
        a2.append(str);
        a2.append(getSmoothQuat()[1]);
        a2.append(str);
        a2.append(getSmoothQuat()[2]);
        a2.append(str);
        a2.append(getSmoothQuat()[3]);
        a2.append(") unsmoothQuat (");
        a2.append(getUnsmoothQuat()[0]);
        a2.append(str);
        a2.append(getUnsmoothQuat()[1]);
        a2.append(str);
        a2.append(getUnsmoothQuat()[2]);
        a2.append(str);
        a2.append(getUnsmoothQuat()[3]);
        a2.append(") smoothSpherePosition (");
        a2.append(this.smoothSpherePosition[0]);
        a2.append(str);
        a2.append(this.smoothSpherePosition[1]);
        a2.append(str);
        a2.append(this.smoothSpherePosition[2]);
        a2.append(") unsmoothSpherePosition (");
        a2.append(this.unsmoothSpherePosition[0]);
        a2.append(str);
        a2.append(this.unsmoothSpherePosition[1]);
        a2.append(str);
        a2.append(this.unsmoothSpherePosition[2]);
        a2.append(")");
        Log.i(BMGConstants.TAG, a2.toString());
    }

    public void setFov(float f2) {
        this.fov = f2;
    }

    public void setRect(float[] fArr) {
        this.rect = fArr;
    }

    public void setSmoothBottonMiddlePosition(float[] fArr) {
        this.smoothBottonMiddlePosition = fArr;
    }

    public void setSmoothQuat(float[] fArr) {
        this.smoothQuat = fArr;
    }

    public void setSmoothSpherePosition(float[] fArr) {
        this.smoothSpherePosition = fArr;
    }

    public void setSrcTime(double d2) {
        this.srcTime = d2;
    }

    public void setUnsmoothBottonMiddlePosition(float[] fArr) {
        this.unsmoothBottonMiddlePosition = fArr;
    }

    public void setUnsmoothQuat(float[] fArr) {
        this.unsmoothQuat = fArr;
    }

    public void setUnsmoothSpherePosition(float[] fArr) {
        this.unsmoothSpherePosition = fArr;
    }
}
