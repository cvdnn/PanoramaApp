package com.baidu.sofire;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.f.c;
import e.c.f.f.e;
import e.c.f.f.g;
import e.c.f.n.m;

public class MyService extends Service {

    /* renamed from: b reason: collision with root package name */
    public static long f3267b;

    /* renamed from: a reason: collision with root package name */
    public volatile int f3268a = 0;

    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f3269a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Intent f3270b;

        public a(String str, Intent intent) {
            this.f3269a = str;
            this.f3270b = intent;
        }

        public final void run() {
            try {
                MyService.this.f3268a++;
                if (MyService.this.getPackageName().equals(this.f3269a)) {
                    MyService.a(MyService.this, MyService.this.getClassLoader(), this.f3270b);
                    MyService.this.a();
                } else if ("teac".equals(this.f3270b.getAction())) {
                    int intExtra = this.f3270b.getIntExtra("plugin_id", 100041);
                    String stringExtra = this.f3270b.getStringExtra("target_method");
                    if (TextUtils.isEmpty(stringExtra)) {
                        MyService.this.a();
                        return;
                    }
                    e.a(intExtra, stringExtra, (Callback) null, (Class<?>[]) new Class[]{Intent.class}, this.f3270b);
                    StringBuilder sb = new StringBuilder("MyService#onStart2 intent=");
                    sb.append(this.f3270b);
                    sb.append(", extra=");
                    sb.append(this.f3270b.getExtras());
                    c.a();
                    MyService.this.a();
                } else {
                    g gVar = g.f6978g;
                    if (gVar == null) {
                        MyService.this.a();
                        return;
                    }
                    ApkInfo c2 = gVar.c(this.f3269a);
                    new StringBuilder("i=").append(c2);
                    c.a();
                    if (c2 == null) {
                        MyService.this.a();
                        return;
                    }
                    MyService.a(MyService.this, c2.classLoader, this.f3270b);
                    MyService.this.a();
                }
            } catch (Throwable unused) {
                c.d();
                MyService.this.a();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            try {
                return super.onStartCommand(intent, i2, i3);
            } catch (Throwable unused) {
                c.d();
            }
        } else {
            Bundle bundleExtra = intent.getBundleExtra("bundle");
            if (bundleExtra != null) {
                String[] stringArray = bundleExtra.getStringArray(LogBuilder.KEY_APPKEY);
                int[] intArray = bundleExtra.getIntArray("key");
                int i4 = bundleExtra.getInt("delay");
                if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                    e.a(getApplicationContext(), i4, stringArray[0], stringArray[1], intArray);
                    return super.onStartCommand(intent, i2, i3);
                }
            }
            String stringExtra = intent.getStringExtra("from_plugin_package");
            if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(intent.getAction())) {
                long j2 = f3267b;
                if ("teac".equals(intent.getAction())) {
                    f3267b = System.currentTimeMillis();
                    if (System.currentTimeMillis() - j2 < 3000) {
                        return super.onStartCommand(intent, i2, i3);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(intent.getAction());
                sb.append(" ");
                sb.append(stringExtra);
                c.a();
                m.a().a(new a(stringExtra, intent));
                return super.onStartCommand(intent, i2, i3);
            }
            a();
            return super.onStartCommand(intent, i2, i3);
        }
    }

    public final void a() {
        try {
            this.f3268a--;
            if (this.f3268a <= 0) {
                this.f3268a = 0;
                c.a();
                stopSelf();
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static /* synthetic */ void a(MyService myService, ClassLoader classLoader, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("target_class");
            Class loadClass = classLoader.loadClass(stringExtra);
            Object newInstance = loadClass.newInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(stringExtra);
            sb.append("-");
            sb.append(newInstance);
            c.a();
            String stringExtra2 = intent.getStringExtra("target_method");
            new StringBuilder().append(stringExtra2);
            c.a();
            loadClass.getDeclaredMethod(stringExtra2, new Class[]{Context.class, Intent.class}).invoke(newInstance, new Object[]{myService.getApplicationContext(), intent});
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
    }
}
