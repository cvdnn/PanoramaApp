package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SapiShareClient */
public class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ List f2932a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ boolean f2933b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Handler f2934c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ HandlerThread f2935d;

    public i(List list, boolean z, Handler handler, HandlerThread handlerThread) {
        this.f2932a = list;
        this.f2933b = z;
        this.f2934c = handler;
        this.f2935d = handlerThread;
    }

    public void run() {
        if (!this.f2932a.isEmpty()) {
            try {
                if (this.f2933b) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("cuid", SapiUtils.getClientId(SapiShareClient.f2873i.context));
                    hashMap.put(Config.DEVICE_PART, Build.MODEL);
                    String str = "num";
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f2932a.size());
                    sb.append("");
                    hashMap.put(str, sb.toString());
                    t.a("share_silent_account", (Map<String, String>) hashMap);
                }
                if (!SapiShareClient.f2873i.context.bindService((Intent) this.f2932a.get(0), new h(this, this), 1)) {
                    this.f2932a.remove(0);
                    if (this.f2932a.isEmpty() || SapiShareClient.f2874j.getShareAccounts().size() >= 5) {
                        this.f2935d.quit();
                    } else {
                        this.f2934c.post(this);
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
