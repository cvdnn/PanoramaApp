package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class MyCommentBean implements Serializable {
    private String commentNum;
    private String commenthowLong;
    private String content;
    private String createTime;
    private String headimgurl;
    private String hidecontent;
    private String howLong;
    private String id;
    private String ifpraise;
    private String location;
    private String name;
    private String nickname;
    private String piccreatetime;
    private String pictureId;
    private String praiseNum;
    private String shareurl;
    private String songname;
    private String surl;
    private String title;
    private String url;
    private String userid;

    public MyCommentBean() {
    }

    public MyCommentBean(String pictureId2, String content2, String commentNum2, String piccreatetime2, String createTime2, String nickname2, String name2, String praiseNum2, String shareurl2, String location2, String id2, String ifpraise2, String title2, String userid2, String url2, String surl2, String howLong2, String commenthowLong2, String headimgurl2, String hidecontent2, String songname2) {
        this.pictureId = pictureId2;
        this.content = content2;
        this.commentNum = commentNum2;
        this.piccreatetime = piccreatetime2;
        this.createTime = createTime2;
        this.nickname = nickname2;
        this.name = name2;
        this.praiseNum = praiseNum2;
        this.shareurl = shareurl2;
        this.location = location2;
        this.id = id2;
        this.ifpraise = ifpraise2;
        this.title = title2;
        this.userid = userid2;
        this.url = url2;
        this.surl = surl2;
        this.howLong = howLong2;
        this.commenthowLong = commenthowLong2;
        this.headimgurl = headimgurl2;
        this.hidecontent = hidecontent2;
        this.songname = songname2;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(String pictureId2) {
        this.pictureId = pictureId2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getCommentNum() {
        return this.commentNum;
    }

    public void setCommentNum(String commentNum2) {
        this.commentNum = commentNum2;
    }

    public String getPiccreatetime() {
        return this.piccreatetime;
    }

    public void setPiccreatetime(String piccreatetime2) {
        this.piccreatetime = piccreatetime2;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime2) {
        this.createTime = createTime2;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getPraiseNum() {
        return this.praiseNum;
    }

    public void setPraiseNum(String praiseNum2) {
        this.praiseNum = praiseNum2;
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

    public String getIfpraise() {
        return this.ifpraise;
    }

    public void setIfpraise(String ifpraise2) {
        this.ifpraise = ifpraise2;
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

    public String getCommenthowLong() {
        return this.commenthowLong;
    }

    public void setCommenthowLong(String commenthowLong2) {
        this.commenthowLong = commenthowLong2;
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

    public String toString() {
        return "MyCommentBean{pictureId='" + this.pictureId + '\'' + ", content='" + this.content + '\'' + ", commentNum='" + this.commentNum + '\'' + ", piccreatetime='" + this.piccreatetime + '\'' + ", createTime='" + this.createTime + '\'' + ", nickname='" + this.nickname + '\'' + ", name='" + this.name + '\'' + ", praiseNum='" + this.praiseNum + '\'' + ", shareurl='" + this.shareurl + '\'' + ", location='" + this.location + '\'' + ", id='" + this.id + '\'' + ", ifpraise='" + this.ifpraise + '\'' + ", title='" + this.title + '\'' + ", userid='" + this.userid + '\'' + ", url='" + this.url + '\'' + ", surl='" + this.surl + '\'' + ", howLong='" + this.howLong + '\'' + ", commenthowLong='" + this.commenthowLong + '\'' + ", headimgurl='" + this.headimgurl + '\'' + ", hidecontent='" + this.hidecontent + '\'' + ", songname='" + this.songname + '\'' + '}';
    }
}
