package com.arashivision.arvbmg.common;

import java.util.List;

public class TrackVideoInfo {
    public List<TrackerSequence> trackerSequences;
    public String version;

    public void setTrackerSequences(List<TrackerSequence> list) {
        this.trackerSequences = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
