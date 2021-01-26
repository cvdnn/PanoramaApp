package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;

/* compiled from: SapiCache */
public class S extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ T f2180a;

    public S(T t, boolean z) {
        this.f2180a = t;
        super(z);
    }

    public void onFailure(Throwable th, int i2, String str) {
        T t = this.f2180a;
        t.f2463b.a(t.f2464c);
        SapiContext.getInstance().setSapiOptions(this.f2180a.f2463b);
    }

    public void onSuccess(int i2, String str) {
        T t = this.f2180a;
        t.f2465d.a(str, t.f2462a);
    }
}
