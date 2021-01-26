package com.arashivision.arvbmg.timeshift;

import com.arashivision.arvbmg.common.PositionOrientation;
import e.a.a.a.a;
import java.util.Arrays;

public class TimeShiftSequence {
    public long endTimeStamp;
    public PositionOrientation[] orientations;
    public long showCount;
    public long startTimeStamp;
    public long targetId;

    public void setEndTimeStamp(long j2) {
        this.endTimeStamp = j2;
    }

    public void setOrientations(PositionOrientation[] positionOrientationArr) {
        this.orientations = positionOrientationArr;
    }

    public void setShowCount(long j2) {
        this.showCount = j2;
    }

    public void setStartTimeStamp(long j2) {
        this.startTimeStamp = j2;
    }

    public void setTargetId(long j2) {
        this.targetId = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("TimeShiftSequence{targetId=");
        a2.append(this.targetId);
        a2.append(", showCount=");
        a2.append(this.showCount);
        a2.append(", startTimeStamp=");
        a2.append(this.startTimeStamp);
        a2.append(", endTimeStamp=");
        a2.append(this.endTimeStamp);
        a2.append(", orientations=");
        a2.append(Arrays.toString(this.orientations));
        a2.append('}');
        return a2.toString();
    }
}
