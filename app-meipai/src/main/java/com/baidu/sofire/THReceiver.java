package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.n.m;

public class THReceiver extends BroadcastReceiver {

    public static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Intent f3274a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Context f3275b;

        public a(Intent intent, Context context) {
            this.f3274a = intent;
            this.f3275b = context;
        }

        public final void run() {
            String str = "c";
            String str2 = "r";
            String str3 = "t";
            try {
                new StringBuilder().append(this.f3274a.toString());
                c.a();
                System.currentTimeMillis();
                if (str2.equals(this.f3274a.getStringExtra(str3))) {
                    String stringExtra = this.f3274a.getStringExtra(str);
                    Intent intent = new Intent();
                    intent.putExtra(str3, str2);
                    intent.putExtra(str, stringExtra);
                    e.a(this.f3275b, intent);
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                new StringBuilder().append(intent.toString());
                c.a();
                m.a().a(new a(intent, context));
            } catch (Throwable unused) {
                c.d();
            }
        }
    }
}
