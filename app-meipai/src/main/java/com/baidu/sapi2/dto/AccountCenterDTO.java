package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountCenterDTO extends SapiWebDTO {
    public static final PassNameValuePair HIDE_PERSONAL_DATA;
    public static final PassNameValuePair HIDE_REAL_NAME;
    public static String REFER_ACCOUNT_CENTER = "account_center";
    public static String REFER_ACCOUNT_CHECK = "account_check";
    public String bduss;
    public boolean handleLogin = false;
    public boolean logoutAfterBdussInvalid = true;
    public List<PassNameValuePair> paramsList = new ArrayList();
    public String refer = REFER_ACCOUNT_CENTER;

    static {
        String str = "0";
        HIDE_PERSONAL_DATA = new PassNameValuePair("personalData", str);
        HIDE_REAL_NAME = new PassNameValuePair("realname", str);
    }
}
