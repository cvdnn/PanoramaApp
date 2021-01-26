package com.baidu.sapi2.utils;

import android.webkit.ValueCallback;

/* compiled from: SapiCoreUtil */
public class e implements ValueCallback<String> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ f f3038a;

    public e(f fVar) {
        this.f3038a = fVar;
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        this.f3038a.f3073c.a(str);
        this.f3038a.f3071a.destroy();
    }
}
