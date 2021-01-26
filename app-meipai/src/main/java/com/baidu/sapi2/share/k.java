package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;

/* compiled from: ShareAccountAccessor */
public abstract class k {

    /* renamed from: a reason: collision with root package name */
    public static k f2937a;

    public static k a() {
        k kVar = f2937a;
        if (kVar != null) {
            return kVar;
        }
        try {
            Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
        } catch (Exception e2) {
            Log.e(e2);
        }
        return f2937a;
    }

    public abstract String a(SapiAccount sapiAccount);

    public abstract void a(SapiAccount sapiAccount, SapiAccount sapiAccount2);

    public abstract void a(SapiAccount sapiAccount, String str);

    public abstract String b(SapiAccount sapiAccount);

    public abstract void b(SapiAccount sapiAccount, String str);

    public abstract String c(SapiAccount sapiAccount);

    public abstract void c(SapiAccount sapiAccount, String str);

    public abstract void d(SapiAccount sapiAccount);

    public abstract void d(SapiAccount sapiAccount, String str);

    public static void a(k kVar) {
        if (f2937a == null) {
            f2937a = kVar;
            return;
        }
        throw new IllegalStateException();
    }
}
