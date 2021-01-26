package com.baidu.picapture.model.hotspot;

import java.io.Serializable;

public class HotSpot implements Serializable {
    public String describe;
    public String img;
    public String title;

    public String getDescribe() {
        return this.describe;
    }

    public String getImg() {
        return this.img;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
