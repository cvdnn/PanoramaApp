package com.arashivision.onecamera.camerarequest;

public class TimelapseOptionsInfo {
    public int accelerateFequency;
    public int durationS;
    public int lapseTimeMs;

    public int getAccelerateFequency() {
        return this.accelerateFequency;
    }

    public int getDurationS() {
        return this.durationS;
    }

    public int getLapseTimeMs() {
        return this.lapseTimeMs;
    }

    public void setAccelerateFequency(int i2) {
        this.accelerateFequency = i2;
    }

    public void setDurationS(int i2) {
        this.durationS = i2;
    }

    public void setLapseTimeMs(int i2) {
        this.lapseTimeMs = i2;
    }
}
