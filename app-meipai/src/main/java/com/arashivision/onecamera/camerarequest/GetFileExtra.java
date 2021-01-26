package com.arashivision.onecamera.camerarequest;

public class GetFileExtra {
    public int extra_type;
    public GyroOptionIndexRange mGyroOptionIndexRange;
    public GyroOptionTimeRange mGyroOptionTimeRange;
    public String uri;

    private int getExtra_type() {
        return this.extra_type;
    }

    private GyroOptionIndexRange getGyroOptionIndexRange() {
        return this.mGyroOptionIndexRange;
    }

    private GyroOptionTimeRange getGyroOptionTimeRange() {
        return this.mGyroOptionTimeRange;
    }

    private String getUri() {
        return this.uri;
    }

    private boolean hasGyroOptionIndexRange() {
        return this.mGyroOptionIndexRange != null;
    }

    private boolean hasGyroOptionTimeRange() {
        return this.mGyroOptionTimeRange != null;
    }
}
