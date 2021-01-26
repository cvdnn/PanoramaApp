package com.baidu.sapi2;

import com.baidu.sapi2.share.k;

/* renamed from: com.baidu.sapi2.q reason: case insensitive filesystem */
public final class SapiAccountAccessorImpl extends k {
    public String a(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    public String b(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    public void c(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    public void d(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    public void a(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }

    public void b(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    public String c(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    public void d(SapiAccount sapiAccount) {
        sapiAccount.a();
    }

    public void a(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }
}
