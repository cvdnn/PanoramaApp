package com.arashivision.graphicpath.render.source;

public class TimeRange {
    public double timeStart = 0.0d;
    public double timelength = 0.0d;

    public TimeRange() {
    }

    public double Begin() {
        return this.timeStart;
    }

    public double End() {
        return this.timeStart + this.timelength;
    }

    public double Length() {
        return this.timelength;
    }

    public TimeRange(double d2, double d3) {
        this.timeStart = d2;
        this.timelength = d3;
    }
}
