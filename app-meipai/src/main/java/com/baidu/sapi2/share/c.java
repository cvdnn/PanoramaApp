package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
import java.util.List;

/* compiled from: SapiShareClient */
public class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ List f2904a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Handler f2905b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiAccount f2906c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ boolean f2907d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ HandlerThread f2908e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ SapiShareClient f2909f;

    public c(SapiShareClient sapiShareClient, List list, Handler handler, SapiAccount sapiAccount, boolean z, HandlerThread handlerThread) {
        this.f2909f = sapiShareClient;
        this.f2904a = list;
        this.f2905b = handler;
        this.f2906c = sapiAccount;
        this.f2907d = z;
        this.f2908e = handlerThread;
    }

    public void run() {
        if (!this.f2904a.isEmpty()) {
            try {
                if (!SapiShareClient.f2873i.context.bindService((Intent) this.f2904a.get(0), new b(this, this), 1)) {
                    this.f2904a.remove(0);
                    if (!this.f2904a.isEmpty()) {
                        this.f2905b.post(this);
                    } else {
                        this.f2908e.quit();
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
