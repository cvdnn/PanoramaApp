package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class IndexPhotoBean implements Serializable {
    private String commentnum;
    private String createtime;
    private String headimgurl;
    private String hidecontent;
    private String howLong;
    private String id;
    private String location;
    private String nickname;
    private String praisenum;
    private String shareurl;
    private String songname;
    private String status;
    private String surl;
    private String title;
    private String url;
    private String userid;

    public IndexPhotoBean() {
    }

    public IndexPhotoBean(String commentnum2, String createtime2, String nickname2, String praisenum2, String shareurl2, String location2, String id2, String title2, String userid2, String url2, String surl2, String howLong2, String headimgurl2, String hidecontent2, String songname2, String status2) {
        this.commentnum = commentnum2;
        this.createtime = createtime2;
        this.nickname = nickname2;
        this.praisenum = praisenum2;
        this.shareurl = shareurl2;
        this.location = location2;
        this.id = id2;
        this.title = title2;
        this.userid = userid2;
        this.url = url2;
        this.surl = surl2;
        this.howLong = howLong2;
        this.headimgurl = headimgurl2;
        this.hidecontent = hidecontent2;
        this.songname = songname2;
        this.status = status2;
    }

    public String getCommentnum() {
        return this.commentnum;
    }

    public void setCommentnum(String commentnum2) {
        this.commentnum = commentnum2;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime2) {
        this.createtime = createtime2;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String getPraisenum() {
        return this.praisenum;
    }

    public void setPraisenum(String praisenum2) {
        this.praisenum = praisenum2;
    }

    public String getShareurl() {
        return this.shareurl;
    }

    public void setShareurl(String shareurl2) {
        this.shareurl = shareurl2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location2) {
        this.location = location2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid2) {
        this.userid = userid2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getSurl() {
        return this.surl;
    }

    public void setSurl(String surl2) {
        this.surl = surl2;
    }

    public String getHowLong() {
        return this.howLong;
    }

    public void setHowLong(String howLong2) {
        this.howLong = howLong2;
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public void setHeadimgurl(String headimgurl2) {
        this.headimgurl = headimgurl2;
    }

    public String getHidecontent() {
        return this.hidecontent;
    }

    public void setHidecontent(String hidecontent2) {
        this.hidecontent = hidecontent2;
    }

    public String getSongname() {
        return this.songname;
    }

    public void setSongname(String songname2) {
        this.songname = songname2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String toString() {
        return "IndexPhotoBean{commentnum='" + this.commentnum + '\'' + ", createtime='" + this.createtime + '\'' + ", nickname='" + this.nickname + '\'' + ", praisenum='" + this.praisenum + '\'' + ", shareurl='" + this.shareurl + '\'' + ", location='" + this.location + '\'' + ", id='" + this.id + '\'' + ", title='" + this.title + '\'' + ", userid='" + this.userid + '\'' + ", url='" + this.url + '\'' + ", surl='" + this.surl + '\'' + ", howLong='" + this.howLong + '\'' + ", headimgurl='" + this.headimgurl + '\'' + ", hidecontent='" + this.hidecontent + '\'' + ", songname='" + this.songname + '\'' + ", status='" + this.status + '\'' + '}';
    }
}
