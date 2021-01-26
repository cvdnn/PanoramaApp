package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidubce.http.Headers;
import java.util.HashMap;

/* compiled from: SapiCache */
public class Q extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ X f2178a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ V f2179b;

    public Q(V v, boolean z, X x) {
        this.f2179b = v;
        this.f2178a = x;
        super(z);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2179b.c(this.f2178a);
        this.f2179b.b();
    }

    public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
        if (str != null) {
            this.f2179b.a(str, this.f2178a);
            if (hashMap != null) {
                SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, (String) hashMap.get(Headers.ETAG));
            }
            this.f2179b.b();
        }
    }
}
