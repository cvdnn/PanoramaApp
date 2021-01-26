package com.baidu.picapture.model.nativeapi;

public class ShareBean {
    public String description;
    public String imageUrl;
    public String shareUrl;
    public String title;
    public String type;

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
