package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.AccountCenterResult;

public abstract class AccountCenterCallback {
    public void onBdussChange() {
    }

    public abstract void onFinish(AccountCenterResult accountCenterResult);

    public abstract void onSocialBind(String str);
}
