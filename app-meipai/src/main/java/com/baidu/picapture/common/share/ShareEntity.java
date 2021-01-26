package com.baidu.picapture.common.share;

import androidx.annotation.Keep;

@Keep
public class ShareEntity {
    public String description;
    public String imageUrl;
    public String shareUrl;
    public String title;
    public String type;

    public ShareEntity(String str, String str2, String str3, String str4, String str5) {
        this.type = str;
        this.title = str2;
        this.description = str3;
        this.imageUrl = str4;
        this.shareUrl = str5;
    }
}
