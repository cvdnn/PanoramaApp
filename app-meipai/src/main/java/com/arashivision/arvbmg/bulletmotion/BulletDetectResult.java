package com.arashivision.arvbmg.bulletmotion;

import e.a.a.a.a;

public class BulletDetectResult {
    public int code;
    public long trimEndTime;
    public long trimStartTime;

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setTrimEndTime(long j2) {
        this.trimEndTime = j2;
    }

    public void setTrimStartTime(long j2) {
        this.trimStartTime = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("BulletDetectResult{code=");
        a2.append(this.code);
        a2.append(", trimStartTime=");
        a2.append(this.trimStartTime);
        a2.append(", trimEndTime=");
        a2.append(this.trimEndTime);
        a2.append('}');
        return a2.toString();
    }
}
