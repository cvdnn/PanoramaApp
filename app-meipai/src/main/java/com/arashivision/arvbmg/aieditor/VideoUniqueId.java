package com.arashivision.arvbmg.aieditor;

import e.a.a.a.a;

public class VideoUniqueId {
    public int captureViewType;
    public String key;
    public int targetId;

    public int getCaptureViewType() {
        return this.captureViewType;
    }

    public String getKey() {
        return this.key;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public void setCaptureViewType(int i2) {
        this.captureViewType = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTargetId(int i2) {
        this.targetId = i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("VideoUniqueId{key='");
        a.a(a2, this.key, '\'', ", captureViewType=");
        a2.append(this.captureViewType);
        a2.append(", targetId=");
        a2.append(this.targetId);
        a2.append('}');
        return a2.toString();
    }
}
