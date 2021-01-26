package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: SapiShareClient */
public class e implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Runnable f2913a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f2914b;

    public e(f fVar, Runnable runnable) {
        this.f2914b = fVar;
        this.f2913a = runnable;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2914b.f2916b.post(new d(this, iBinder, this));
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
