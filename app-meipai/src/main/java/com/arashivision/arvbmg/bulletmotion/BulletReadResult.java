package com.arashivision.arvbmg.bulletmotion;

import e.a.a.a.a;

public class BulletReadResult {
    public int code;
    public long endTime;
    public long startTime;

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setEndTime(long j2) {
        this.endTime = j2;
    }

    public void setStartTime(long j2) {
        this.startTime = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("BulletReadResult{code=");
        a2.append(this.code);
        a2.append(", startTime=");
        a2.append(this.startTime);
        a2.append(", endTime=");
        a2.append(this.endTime);
        a2.append('}');
        return a2.toString();
    }
}
