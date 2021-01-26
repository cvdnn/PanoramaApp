package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;

/* compiled from: SapiAccountRepository */
public class J extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallBack f2145a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ L f2146b;

    public J(L l, Looper looper, SapiCallBack sapiCallBack) {
        this.f2146b = l;
        this.f2145a = sapiCallBack;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        if (i2 == -203) {
            this.f2145a.onSystemError(i2);
        } else {
            this.f2146b.b(this.f2145a, str);
        }
    }

    public void onSuccess(int i2, String str) {
        this.f2146b.b(this.f2145a, str);
    }
}
