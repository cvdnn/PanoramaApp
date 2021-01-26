package com.arashivision.arvbmg.common;

import e.a.a.a.a;
import java.util.Arrays;

public class TrackerSequence {
    public long endTimestamp;
    public PositionOrientation[] positionOrientations;
    public long startTimestamp;
    public long targetId;

    public void setEndTimestamp(long j2) {
        this.endTimestamp = j2;
    }

    public void setPositionOrientations(PositionOrientation[] positionOrientationArr) {
        this.positionOrientations = positionOrientationArr;
    }

    public void setStartTimestamp(long j2) {
        this.startTimestamp = j2;
    }

    public void setTargetId(long j2) {
        this.targetId = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("TrackerSequence{targetId=");
        a2.append(this.targetId);
        a2.append(", startTimestamp=");
        a2.append(this.startTimestamp);
        a2.append(", endTimestamp=");
        a2.append(this.endTimestamp);
        a2.append(", positionOrientations=");
        a2.append(Arrays.toString(this.positionOrientations));
        a2.append('}');
        return a2.toString();
    }
}
