package com.arashivision.arvbmg.exporter;

public class FileClip {
    public long mEndMs;
    public boolean mLoopAudio;
    public long mStartMs;
    public TimeScale[] mTimeScales;
    public String[] mUrl;
    public boolean mVideoSlient;

    public static class TimeScale {
        public long endTimeMs;
        public double factor;
        public long startTimeMs;

        public long getEndTimeMs() {
            return this.endTimeMs;
        }

        public double getFactor() {
            return this.factor;
        }

        public long getStartTimeMs() {
            return this.startTimeMs;
        }

        public void setEndTimeMs(long j2) {
            this.endTimeMs = j2;
        }

        public void setFactor(double d2) {
            this.factor = d2;
        }

        public void setStartTimeMs(long j2) {
            this.startTimeMs = j2;
        }
    }

    public long getmEndMs() {
        return this.mEndMs;
    }

    public long getmStartMs() {
        return this.mStartMs;
    }

    public TimeScale[] getmTimeScales() {
        return this.mTimeScales;
    }

    public String[] getmUrl() {
        return this.mUrl;
    }

    public boolean ismLoopAudio() {
        return this.mLoopAudio;
    }

    public boolean ismVideoSlient() {
        return this.mVideoSlient;
    }

    public void setmEndMs(long j2) {
        this.mEndMs = j2;
    }

    public void setmLoopAudio(boolean z) {
        this.mLoopAudio = z;
    }

    public void setmStartMs(long j2) {
        this.mStartMs = j2;
    }

    public void setmTimeScales(TimeScale[] timeScaleArr) {
        this.mTimeScales = timeScaleArr;
    }

    public void setmUrl(String[] strArr) {
        this.mUrl = strArr;
    }

    public void setmVideoSlient(boolean z) {
        this.mVideoSlient = z;
    }
}
