package com.baidu.picapture.model.nativeapi;

public class UnZipTask {
    public String from;
    public boolean overwrite = false;
    public boolean recursion = false;
    public boolean remove_source = true;
    public String to;

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public boolean isOverwrite() {
        return this.overwrite;
    }

    public boolean isRecursion() {
        return this.recursion;
    }

    public boolean isRemoveSource() {
        return this.remove_source;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setOverwrite(boolean z) {
        this.overwrite = z;
    }

    public void setRecursion(boolean z) {
        this.recursion = z;
    }

    public void setRemoveSource(boolean z) {
        this.remove_source = z;
    }

    public void setTo(String str) {
        this.to = str;
    }
}
