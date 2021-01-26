package com.arashivision.arvbmg.bigboom;

public class IOUTrackCfg {
    public boolean activeKalman = true;
    public double confidenceStartNewTrack = 0.5d;
    public int lostThresHold = 10;
    public int maxOverlapFrame = 15;
    public int minTrackSeqNum = 30;
    public boolean useReId = false;
}
