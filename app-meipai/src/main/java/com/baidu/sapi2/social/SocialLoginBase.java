package com.baidu.sapi2.social;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.activity.BaseActivity;

public class SocialLoginBase extends BaseActivity implements NoProguard {
    public static WXInvokeCallback r;

    public static WXInvokeCallback getWXinvokeCallback() {
        return r;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        r = wXInvokeCallback;
    }
}
