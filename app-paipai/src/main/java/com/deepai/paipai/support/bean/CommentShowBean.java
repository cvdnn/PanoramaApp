package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class CommentShowBean implements Serializable {
    private String content;
    private String createTime;
    private String id;
    private String nickname;
    private String status;
    private String userId;

    public CommentShowBean() {
    }

    public CommentShowBean(String createTime2, String id2, String userId2, String content2, String status2, String nickname2) {
        this.createTime = createTime2;
        this.id = id2;
        this.userId = userId2;
        this.content = content2;
        this.status = status2;
        this.nickname = nickname2;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime2) {
        this.createTime = createTime2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId2) {
        this.userId = userId2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String toString() {
        return "CommentShowBean{createTime='" + this.createTime + '\'' + ", id='" + this.id + '\'' + ", userId='" + this.userId + '\'' + ", content='" + this.content + '\'' + ", status='" + this.status + '\'' + ", nickname='" + this.nickname + '\'' + '}';
    }
}
