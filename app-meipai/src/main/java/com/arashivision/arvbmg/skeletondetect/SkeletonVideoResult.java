package com.arashivision.arvbmg.skeletondetect;

import e.a.a.a.a;
import java.util.Arrays;

public class SkeletonVideoResult {
    public SkeletonFrameResult[] frames;

    public void setFrames(SkeletonFrameResult[] skeletonFrameResultArr) {
        this.frames = skeletonFrameResultArr;
    }

    public String toString() {
        StringBuilder a2 = a.a("SkeletonVideoResult{frames=");
        a2.append(Arrays.toString(this.frames));
        a2.append('}');
        return a2.toString();
    }
}
