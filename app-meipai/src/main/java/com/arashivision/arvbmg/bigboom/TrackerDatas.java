package com.arashivision.arvbmg.bigboom;

import e.a.a.a.a;
import java.util.Arrays;

public class TrackerDatas {
    public int frameHeight;
    public int frameWidth;
    public TrackerData[] trackerDataList;
    public int unFilterCount;
    public String version;
    public long videoDuration;

    public void setFrameHeight(int i2) {
        this.frameHeight = i2;
    }

    public void setFrameWidth(int i2) {
        this.frameWidth = i2;
    }

    public void setTrackerDataList(TrackerData[] trackerDataArr) {
        this.trackerDataList = trackerDataArr;
    }

    public void setUnFilterCount(int i2) {
        this.unFilterCount = i2;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVideoDuration(long j2) {
        this.videoDuration = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("TrackerDatas{version='");
        a.a(a2, this.version, '\'', ", videoDuration=");
        a2.append(this.videoDuration);
        a2.append(", frameWidth=");
        a2.append(this.frameWidth);
        a2.append(", frameHeight=");
        a2.append(this.frameHeight);
        a2.append(", trackerDataList=");
        a2.append(Arrays.toString(this.trackerDataList));
        a2.append('}');
        return a2.toString();
    }
}
