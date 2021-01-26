package com.arashivision.graphicpath.insmedia.previewer2;

public class TimeScale {
    public double factor;
    public double repeatToFps;
    public double scaleEndTimeMs;
    public double scaleStartTimeMs;
    public boolean videoKeyframeOnly;

    public TimeScale(double d2, double d3, double d4, double d5, boolean z) {
        this.scaleStartTimeMs = d2;
        this.scaleEndTimeMs = d3;
        this.factor = d4;
        this.repeatToFps = d5;
        this.videoKeyframeOnly = z;
    }

    public TimeScale(double d2, double d3, double d4, double d5) {
        this.scaleStartTimeMs = d2;
        this.scaleEndTimeMs = d3;
        this.factor = d4;
        this.repeatToFps = d5;
    }

    public TimeScale(long j2, long j3, double d2) {
        this((double) j2, (double) j3, d2, 0.0d);
    }
}
