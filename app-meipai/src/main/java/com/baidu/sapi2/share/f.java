package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
import java.util.List;

/* compiled from: SapiShareClient */
public class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ List f2915a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Handler f2916b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiAccount f2917c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ HandlerThread f2918d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ SapiShareClient f2919e;

    public f(SapiShareClient sapiShareClient, List list, Handler handler, SapiAccount sapiAccount, HandlerThread handlerThread) {
        this.f2919e = sapiShareClient;
        this.f2915a = list;
        this.f2916b = handler;
        this.f2917c = sapiAccount;
        this.f2918d = handlerThread;
    }

    public void run() {
        if (!this.f2915a.isEmpty()) {
            try {
                if (!SapiShareClient.f2873i.context.bindService((Intent) this.f2915a.get(0), new e(this, this), 1)) {
                    this.f2915a.remove(0);
                    if (!this.f2915a.isEmpty()) {
                        this.f2916b.post(this);
                    } else {
                        this.f2918d.quit();
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
