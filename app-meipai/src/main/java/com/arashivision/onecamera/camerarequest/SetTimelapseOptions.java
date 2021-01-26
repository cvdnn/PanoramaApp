package com.arashivision.onecamera.camerarequest;

public class SetTimelapseOptions {
    public int mode;
    public TimelapseOptionsInfo timelapse_options;

    private int getTimelapseMode() {
        return this.mode;
    }

    private TimelapseOptionsInfo getTimelapse_options() {
        return this.timelapse_options;
    }
}
