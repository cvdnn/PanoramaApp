package com.baidu.sapi2.result;

public class AccountCenterResult extends SapiResult {
    public static final int ERROR_CODE_HANDLE_LOGIN = -10001;
    public static final String ERROR_MSG_HANDLE_LOGIN = "请登录";
    public String encryptedId;
    public boolean isAccountDestory = false;
    public boolean isAccountFreeze = false;
    public String preSetUserName;

    public AccountCenterResult() {
        this.msgMap.put(-10001, "请登录");
    }

    public void loginSuc() {
    }
}
