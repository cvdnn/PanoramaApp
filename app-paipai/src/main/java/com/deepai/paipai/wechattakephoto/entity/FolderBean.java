package com.deepai.paipai.wechattakephoto.entity;

import org.apache.commons.httpclient.cookie.CookieSpec;

public class FolderBean {
    private String dir;
    private String firstImgPath;
    private int imgCount;
    private String name;

    public String getDir() {
        return this.dir;
    }

    public void setDir(String dir2) {
        this.dir = dir2;
        this.name = dir2.substring(dir2.lastIndexOf(CookieSpec.PATH_DELIM));
    }

    public String getFirstImgPath() {
        return this.firstImgPath;
    }

    public void setFirstImgPath(String firstImgPath2) {
        this.firstImgPath = firstImgPath2;
    }

    public String getName() {
        return this.name;
    }

    public int getImgCount() {
        return this.imgCount;
    }

    public void setImgCount(int imgCount2) {
        this.imgCount = imgCount2;
    }
}
