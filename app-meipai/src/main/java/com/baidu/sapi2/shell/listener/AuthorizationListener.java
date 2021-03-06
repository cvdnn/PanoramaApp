package com.baidu.sapi2.shell.listener;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.AccountType;

public abstract class AuthorizationListener {
    public void beforeSuccess(SapiAccount sapiAccount) {
    }

    public abstract void onFailed(int i2, String str);

    public boolean onForgetPwd() {
        return false;
    }

    public void onSuccess() {
    }

    public void onSuccess(AccountType accountType) {
    }
}
