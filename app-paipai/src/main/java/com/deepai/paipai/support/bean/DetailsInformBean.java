package com.deepai.paipai.support.bean;

import java.io.Serializable;
import java.util.List;

public class DetailsInformBean implements Serializable {
    private List<CommentShowBean> commentList;
    private String ifpraise;

    public DetailsInformBean() {
    }

    public DetailsInformBean(String ifpraise2, List<CommentShowBean> commentList2) {
        this.ifpraise = ifpraise2;
        this.commentList = commentList2;
    }

    public String getIfpraise() {
        return this.ifpraise;
    }

    public void setIfpraise(String ifpraise2) {
        this.ifpraise = ifpraise2;
    }

    public List<CommentShowBean> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<CommentShowBean> commentList2) {
        this.commentList = commentList2;
    }

    public String toString() {
        return "DetailsInformBean{ifpraise='" + this.ifpraise + '\'' + ", commentList=" + this.commentList + '}';
    }
}
