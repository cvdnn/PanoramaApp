package com.baidu.sapi2.shell.result;

import android.app.Activity;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;

public class WebAuthResult extends SapiResult {
    public static final int ERROR_CODE_NEED_BACK_PHONE_NO_REG = 12;
    public static final String ERROR_MSG_NEED_BACK_PHONE_NO_REG = "手机号未注册";
    public AccountType accountType = AccountType.UNKNOWN;
    public Activity activity;
    public boolean isAccountFreeze = false;

    public enum LoginType {
        PHONE_REG("phonereg"),
        LOGIN(c.k),
        LOGIN_PROTECT("apilogin"),
        FORCE_BIND("AccountBind"),
        GUIDE_BIND("apibind"),
        SHARE_V1_CHOICE(m.f2948i),
        SHARE_V2_CHOICE(m.f2949j);
        

        /* renamed from: b reason: collision with root package name */
        public String f2990b;

        /* access modifiers changed from: public */
        LoginType(String str) {
            this.f2990b = str;
        }

        public String getLoginType() {
            return this.f2990b;
        }
    }

    public WebAuthResult() {
        this.msgMap.put(12, ERROR_MSG_NEED_BACK_PHONE_NO_REG);
    }

    public void finishActivity() {
    }

    public void finishActivity(boolean z) {
    }

    public String getLoginType() {
        return SapiUtils.getLoginType();
    }
}
