package com.arashivision.arvbmg.timeshift;

import java.util.List;

public class TimeShiftResult {
    public long duration;
    public List<TimeShiftSequence> sequences;
    public String version;

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setSequences(List<TimeShiftSequence> list) {
        this.sequences = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
