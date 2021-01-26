package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: SapiShareClient */
public class h implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Runnable f2930a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ i f2931b;

    public h(i iVar, Runnable runnable) {
        this.f2931b = iVar;
        this.f2930a = runnable;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2931b.f2934c.post(new g(this, iBinder, this));
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
