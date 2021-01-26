package com.baidu.sapi2;

import com.baidu.sapi2.V.a;
import com.baidu.sapi2.X.a.C0011a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;

/* compiled from: SapiCache */
public class U implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ V f2466a;

    public U(V v) {
        this.f2466a = v;
    }

    public void a(C0011a aVar) {
        String c2 = C0011a.c(aVar.f2485a);
        String b2 = C0011a.b(aVar.f2485a);
        if (new File(this.f2466a.f2470d.getFilesDir(), c2).exists()) {
            try {
                String d2 = this.f2466a.d(this.f2466a.f2470d, c2);
                if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.f2466a.f2470d)) {
                    this.f2466a.a(b2, d2.getBytes());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public void a(C0011a aVar, String str) {
    }
}
