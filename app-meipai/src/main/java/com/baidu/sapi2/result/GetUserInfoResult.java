package com.baidu.sapi2.result;

import e.a.a.a.a;

public class GetUserInfoResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "用户信息获取失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public int carSdkFace;
    public String displayname;
    public int faceLoginSwitch;
    public boolean havePwd = true;
    public boolean incompleteUser;
    public boolean isInitialPortrait = false;
    public String portrait;
    public String portraitHttps;
    public String portraitSign;
    public String secureEmail;
    public String secureMobile;
    public String uid;
    public String username;

    public GetUserInfoResult() {
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        StringBuilder a2 = a.a("GetUserInfoResult{username='");
        a.a(a2, this.username, '\'', ", displayname='");
        a.a(a2, this.displayname, '\'', ", uid='");
        a.a(a2, this.uid, '\'', ", secureMobile='");
        a.a(a2, this.secureMobile, '\'', ", secureEmail='");
        a.a(a2, this.secureEmail, '\'', ", incompleteUser=");
        a2.append(this.incompleteUser);
        a2.append(", portrait='");
        a.a(a2, this.portrait, '\'', ", portraitSign='");
        a.a(a2, this.portraitSign, '\'', ", isInitialPortrait=");
        a2.append(this.isInitialPortrait);
        a2.append(", havePwd=");
        a2.append(this.havePwd);
        a2.append('}');
        return a2.toString();
    }
}
