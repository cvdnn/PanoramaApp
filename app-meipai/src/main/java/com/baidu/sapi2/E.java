package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.utils.SapiDataEncryptor;

/* compiled from: SapiAccountRepository */
public class E extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallBack f2124a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ boolean f2125b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiDataEncryptor f2126c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ L f2127d;

    public E(L l, Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        this.f2127d = l;
        this.f2124a = sapiCallBack;
        this.f2125b = z;
        this.f2126c = sapiDataEncryptor;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        super.onFailure(th, i2, str);
        if (i2 == -201) {
            this.f2124a.onNetworkFailed();
        } else {
            this.f2124a.onSystemError(i2);
        }
    }

    public void onSuccess(int i2, String str) {
        super.onSuccess(i2, str);
        L l = this.f2127d;
        l.a(l.b(str), this.f2124a, str, this.f2125b, this.f2126c);
    }
}
