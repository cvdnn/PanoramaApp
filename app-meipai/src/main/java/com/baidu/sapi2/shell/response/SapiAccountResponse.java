package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;
import java.util.Map;

public class SapiAccountResponse extends SapiResponse {
    public AccountType accountType = AccountType.UNKNOWN;
    public String actionType;
    public String app;
    public String authSid;
    public String bduss;
    public String displayname;
    public String email;
    public String extra;
    public String isGuestAccount;
    public String livingUname;
    public boolean newReg;
    public String portraitSign;
    public String ptoken;
    public String socialPortraitUrl;
    public SocialType socialType = SocialType.UNKNOWN;
    public String stoken;
    public Map<String, String> tplStokenMap = new HashMap();
    public String uid;
    public String username;

    public SapiAccountResponse() {
        String str = "";
        this.bduss = str;
        this.ptoken = str;
        this.stoken = str;
        this.displayname = str;
        this.username = str;
        this.email = str;
        this.uid = str;
        this.socialPortraitUrl = str;
        this.isGuestAccount = str;
    }
}
