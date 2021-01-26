package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class SaveShareDataBean implements Serializable {
    private String hideInform;
    private String musicName;
    private String photoImagPath;

    public SaveShareDataBean() {
    }

    public SaveShareDataBean(String photoImagPath2, String musicName2, String hideInform2) {
        this.photoImagPath = photoImagPath2;
        this.musicName = musicName2;
        this.hideInform = hideInform2;
    }

    public String getPhotoImagPath() {
        return this.photoImagPath;
    }

    public void setPhotoImagPath(String photoImagPath2) {
        this.photoImagPath = photoImagPath2;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public void setMusicName(String musicName2) {
        this.musicName = musicName2;
    }

    public String getHideInform() {
        return this.hideInform;
    }

    public void setHideInform(String hideInform2) {
        this.hideInform = hideInform2;
    }

    public String toString() {
        return "SaveShareDataBean{photoImagPath='" + this.photoImagPath + '\'' + ", musicName='" + this.musicName + '\'' + ", hideInform='" + this.hideInform + '\'' + '}';
    }
}
