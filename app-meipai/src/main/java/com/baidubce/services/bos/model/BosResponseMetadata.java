package com.baidubce.services.bos.model;

import com.baidubce.BceResponseMetadata;

public class BosResponseMetadata extends BceResponseMetadata {
    public String debugId;
    public Long nextAppendOffset;

    public String getBosDebugId() {
        return this.debugId;
    }

    public Long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public void setBosDebugId(String str) {
        this.debugId = str;
    }

    public void setNextAppendOffset(Long l) {
        this.nextAppendOffset = l;
    }
}
