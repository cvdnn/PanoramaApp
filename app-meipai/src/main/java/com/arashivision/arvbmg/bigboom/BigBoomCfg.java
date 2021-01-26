package com.arashivision.arvbmg.bigboom;

public class BigBoomCfg {
    public BigBoomTrackerType bigBoomTrackerType = BigBoomTrackerType.StereoGraphicBigBoomTracker;
    public int fps;
    public float headThreshold = 0.3f;
    public int maxMergeSeq = 40;
    public int minTrackSeq = 30;

    public BigBoomTrackerType getBigBoomTrackerType() {
        return this.bigBoomTrackerType;
    }

    public int getFps() {
        return this.fps;
    }

    public float getHeadThreshold() {
        return this.headThreshold;
    }

    public int getMaxMergeSeq() {
        return this.maxMergeSeq;
    }

    public int getMinTrackSeq() {
        return this.minTrackSeq;
    }
}
