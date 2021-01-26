package com.baidu.picapture.common.bos.beans;

public class BosKeyBean {
    public String accessKeyId;
    public String secretAccessKey;
    public String sessionToken;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }
}
