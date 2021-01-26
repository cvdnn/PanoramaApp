package com.arashivision.arvbmg.previewer;

import e.a.a.a.a;

public final class PlaybackProgress {
    public final int clipIndex;
    public final double clipSrcTime;
    public final double clockTime;

    public PlaybackProgress(double d2) {
        this(d2, 0);
    }

    public final PlaybackProgress copy(long j2, int i2, long j3) {
        PlaybackProgress playbackProgress = new PlaybackProgress((double) j2, i2, (double) j3);
        return playbackProgress;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaybackProgress) {
            PlaybackProgress playbackProgress = (PlaybackProgress) obj;
            if (this.clockTime == playbackProgress.clockTime && this.clipIndex == playbackProgress.clipIndex && this.clipSrcTime == playbackProgress.clipSrcTime) {
                return true;
            }
        }
        return false;
    }

    public final int getClipIndex() {
        return this.clipIndex;
    }

    public final double getClipSrcTime() {
        return this.clipSrcTime;
    }

    public final double getClockTime() {
        return this.clockTime;
    }

    public String toString() {
        StringBuilder a2 = a.a("PlaybackProgress(clockTime=");
        a2.append(this.clockTime);
        a2.append(", clipIndex=");
        a2.append(this.clipIndex);
        a2.append(", clipSrcTime=");
        a2.append(this.clipSrcTime);
        a2.append(")");
        return a2.toString();
    }

    public PlaybackProgress(double d2, int i2) {
        this(d2, i2, 0.0d);
    }

    public PlaybackProgress(double d2, int i2, double d3) {
        this.clockTime = d2;
        this.clipIndex = i2;
        this.clipSrcTime = d3;
    }
}
