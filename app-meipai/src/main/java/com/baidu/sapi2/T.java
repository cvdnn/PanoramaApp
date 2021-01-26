package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.V.a;
import com.baidu.sapi2.X.a.C0011a;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;

/* compiled from: SapiCache */
public class T implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ C0011a f2462a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ X f2463b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ X.a f2464c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ V f2465d;

    public T(V v, C0011a aVar, X x, X.a aVar2) {
        this.f2465d = v;
        this.f2462a = aVar;
        this.f2463b = x;
        this.f2464c = aVar2;
    }

    public void a(C0011a aVar, String str) {
        if (!TextUtils.isEmpty(this.f2462a.f2485a) && !TextUtils.isEmpty(str)) {
            this.f2465d.a(this.f2462a.f2485a, str);
            V v = this.f2465d;
            v.a(v.f2470d, C0011a.c(this.f2462a.f2485a), str.getBytes());
        }
    }

    public void a(C0011a aVar) {
        new HttpClientWrap().get(this.f2462a.f2486b, new HttpHashMapWrap(), null, null, new S(this, true));
    }
}
