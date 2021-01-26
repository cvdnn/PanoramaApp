package com.arashivision.arvbmg.aieditor;

import e.a.a.a.a;

public class SegmentInfo {
    public float avgcore;
    public long createTime;
    public float duration;
    public String rule;
    public int shotIndex;
    public float startTime;
    public VideoUniqueId videoUniqueId;

    public void setAvgcore(float f2) {
        this.avgcore = f2;
    }

    public void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public void setDuration(float f2) {
        this.duration = f2;
    }

    public void setRule(String str) {
        this.rule = str;
    }

    public void setShotIndex(int i2) {
        this.shotIndex = i2;
    }

    public void setStartTime(float f2) {
        this.startTime = f2;
    }

    public void setVideoUniqueId(VideoUniqueId videoUniqueId2) {
        this.videoUniqueId = videoUniqueId2;
    }

    public String toString() {
        StringBuilder a2 = a.a("SegmentInfo{shotIndex=");
        a2.append(this.shotIndex);
        a2.append(", startTime=");
        a2.append(this.startTime);
        a2.append(", avgcore=");
        a2.append(this.avgcore);
        a2.append(", duration=");
        a2.append(this.duration);
        a2.append(", createTime=");
        a2.append(this.createTime);
        a2.append(", rule='");
        a.a(a2, this.rule, '\'', ", setVideoUniqueId='");
        a2.append(this.videoUniqueId);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
