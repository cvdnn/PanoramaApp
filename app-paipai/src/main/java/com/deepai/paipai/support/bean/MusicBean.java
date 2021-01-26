package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class MusicBean implements Serializable {
    private String author;
    private String name;

    public MusicBean() {
    }

    public MusicBean(String name2, String author2) {
        this.name = name2;
        this.author = author2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }
}
