package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class DataBean implements Serializable {
    private String expire;
    private String headimgurl;
    private String nickname;
    private String token;

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public void setHeadimgurl(String headimgurl2) {
        this.headimgurl = headimgurl2;
    }

    public String getExpire() {
        return this.expire;
    }

    public void setExpire(String expire2) {
        this.expire = expire2;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token2) {
        this.token = token2;
    }
}
