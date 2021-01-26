package com.arashivision.arvbmg.aieditor;

import e.a.a.a.a;
import java.util.List;

public class MatchInfo {
    public int epochCount;
    public int epochIndex;
    public List<SegmentInfo> segmentInfos;

    public void setEpochCount(int i2) {
        this.epochCount = i2;
    }

    public void setEpochIndex(int i2) {
        this.epochIndex = i2;
    }

    public void setSegmentInfos(List<SegmentInfo> list) {
        this.segmentInfos = list;
    }

    public String toString() {
        StringBuilder a2 = a.a("MatchInfo{epochIndex=");
        a2.append(this.epochIndex);
        a2.append(", epochCount=");
        a2.append(this.epochCount);
        a2.append(", segmentInfos=");
        a2.append(this.segmentInfos);
        a2.append('}');
        return a2.toString();
    }
}
