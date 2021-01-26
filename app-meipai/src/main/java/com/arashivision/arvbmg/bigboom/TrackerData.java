package com.arashivision.arvbmg.bigboom;

import e.a.a.a.a;
import java.util.Arrays;

public class TrackerData {
    public double boxArea;
    public boolean isOnUserRight;
    public String objectName;
    public long[] occluders;
    public OrientationState[] orientationStates;
    public long passBegin;
    public long passEnd;
    public long passPoint;
    public long targetId = -1;

    public void setBoxArea(double d2) {
        this.boxArea = d2;
    }

    public void setObjectName(String str) {
        this.objectName = str;
    }

    public void setOccluders(long[] jArr) {
        this.occluders = jArr;
    }

    public void setOnUserRight(boolean z) {
        this.isOnUserRight = z;
    }

    public void setOrientationStates(OrientationState[] orientationStateArr) {
        this.orientationStates = orientationStateArr;
    }

    public void setPassBegin(long j2) {
        this.passBegin = j2;
    }

    public void setPassEnd(long j2) {
        this.passEnd = j2;
    }

    public void setPassPoint(long j2) {
        this.passPoint = j2;
    }

    public void setTargetId(long j2) {
        this.targetId = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("TrackerData{targetId=");
        a2.append(this.targetId);
        a2.append(",boxArea=");
        a2.append(this.boxArea);
        a2.append(",objectName=");
        a2.append(this.objectName);
        a2.append(", orientationStates=");
        a2.append(Arrays.toString(this.orientationStates));
        a2.append('}');
        return a2.toString();
    }
}
