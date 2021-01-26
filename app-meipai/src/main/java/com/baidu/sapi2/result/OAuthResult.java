package com.baidu.sapi2.result;

import e.a.a.a.a;

public class OAuthResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "授权失败";
    public static final String RESULT_MSG_SUCCESS = "授权成功";
    public String accessToken;
    public int expiresIn;
    public String extra;
    public String openid;
    public String refreshToken;
    public String scope;
    public String sessionKey;
    public String sessionSecret;

    public OAuthResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        StringBuilder a2 = a.a("OAuthResult{accessToken='");
        a.a(a2, this.accessToken, '\'', ", expiresIn=");
        a2.append(this.expiresIn);
        a2.append(", refreshToken='");
        a.a(a2, this.refreshToken, '\'', ", scope='");
        a.a(a2, this.scope, '\'', ", sessionKey='");
        a.a(a2, this.sessionKey, '\'', ", sessionSecret='");
        a.a(a2, this.sessionSecret, '\'', ", extra='");
        a2.append(this.extra);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
