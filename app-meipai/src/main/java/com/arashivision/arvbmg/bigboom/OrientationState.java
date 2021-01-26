package com.arashivision.arvbmg.bigboom;

import e.a.a.a.a;
import java.util.Arrays;

public class OrientationState {
    public double[] position;
    public double[] rect;
    public long timestamp;

    public void setPosition(double[] dArr) {
        this.position = dArr;
    }

    public void setRect(double[] dArr) {
        this.rect = dArr;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("OrientationState{timestamp=");
        a2.append(this.timestamp);
        a2.append(", position=");
        a2.append(Arrays.toString(this.position));
        a2.append(", rect=");
        a2.append(Arrays.toString(this.rect));
        a2.append('}');
        return a2.toString();
    }
}
