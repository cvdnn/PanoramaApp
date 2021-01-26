package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import e.c.b.e.Utils;

/* compiled from: SapiAccountRepository */
public class B extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ String f2108a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f2109b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ String f2110c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginResult f2111d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ L f2112e;

    public B(L l, Looper looper, String str, OneKeyLoginCallback oneKeyLoginCallback, String str2, OneKeyLoginResult oneKeyLoginResult) {
        this.f2112e = l;
        this.f2108a = str;
        this.f2109b = oneKeyLoginCallback;
        this.f2110c = str2;
        this.f2111d = oneKeyLoginResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        new c().b(this.f2109b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, null);
    }

    public void onSuccess(int i2, String str) {
        String a2 = Utils.a(str.getBytes(), false);
        String str2 = this.f2108a;
        if (str2 == null || str2.equals(a2)) {
            SapiContext.getInstance().setOneKeyLoginJSCode(str);
            SapiContext.getInstance().setOnekeyLoginJsMd5(this.f2108a);
            OneKeyLoginResult.secondJsCode = this.f2110c;
            this.f2109b.available(this.f2111d);
            return;
        }
        Log.d(L.f2152a, "oneKeyLogin check javsScript MD5 failed");
        new c().b(this.f2109b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, null);
    }
}
