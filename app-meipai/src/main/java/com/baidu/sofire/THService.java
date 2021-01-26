package com.baidu.sofire;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.n.m;

public class THService extends Service {

    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Intent f3276a;

        public a(Intent intent) {
            this.f3276a = intent;
        }

        public final void run() {
            String str = "c";
            String str2 = "s";
            String str3 = "t";
            try {
                new StringBuilder().append(this.f3276a.getAction());
                c.a();
                if (str2.equals(this.f3276a.getStringExtra(str3))) {
                    String stringExtra = this.f3276a.getStringExtra(str);
                    Intent intent = new Intent();
                    intent.putExtra(str3, str2);
                    intent.putExtra(str, stringExtra);
                    e.a(THService.this.getApplicationContext(), intent);
                }
            } catch (Throwable unused) {
                c.d();
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
            m.a().a(new a(intent));
            return super.onStartCommand(intent, i2, i3);
        }
    }
}
