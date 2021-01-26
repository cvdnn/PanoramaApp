package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: SapiShareClient */
public class b implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Runnable f2902a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ c f2903b;

    public b(c cVar, Runnable runnable) {
        this.f2903b = cVar;
        this.f2902a = runnable;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2903b.f2905b.post(new a(this, iBinder, this));
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
