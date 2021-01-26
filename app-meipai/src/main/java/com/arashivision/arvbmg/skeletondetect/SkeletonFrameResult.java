package com.arashivision.arvbmg.skeletondetect;

import e.a.a.a.a;
import java.util.Arrays;

public class SkeletonFrameResult {
    public double[] quat;
    public long timestamp;

    public void setQuat(double[] dArr) {
        this.quat = dArr;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("SkeletonFrameResult{timestamp=");
        a2.append(this.timestamp);
        a2.append(", quat=");
        a2.append(Arrays.toString(this.quat));
        a2.append('}');
        return a2.toString();
    }
}
