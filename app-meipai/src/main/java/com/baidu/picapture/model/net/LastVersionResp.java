package com.baidu.picapture.model.net;

public class LastVersionResp {
    public String downloadingUrl;
    public boolean forceUpdate;
    public String note;
    public String note_en;
    public String version;

    public String getDownloadingUrl() {
        return this.downloadingUrl;
    }

    public String getNote() {
        return this.note;
    }

    public String getNoteEn() {
        return this.note_en;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public void setDownloadingUrl(String str) {
        this.downloadingUrl = str;
    }

    public void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setNoteEN(String str) {
        this.note_en = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
