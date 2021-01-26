package com.baidu.sofire;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.Config;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.n.m;

public class MyActivity extends Activity {

    public static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Intent f3259a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Context f3260b;

        public a(Intent intent, Context context) {
            this.f3259a = intent;
            this.f3260b = context;
        }

        public final void run() {
            String str = "c";
            try {
                new StringBuilder().append(this.f3259a.toString());
                c.a();
                String stringExtra = this.f3259a.getStringExtra(str);
                Intent intent = new Intent();
                intent.putExtra("t", Config.APP_VERSION_CODE);
                intent.putExtra(str, stringExtra);
                e.a(this.f3260b.getApplicationContext(), intent);
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate(Bundle bundle) {
        String str = "teac";
        try {
            Intent intent = getIntent();
            if (str.equals(intent.getAction())) {
                c.a();
                Intent intent2 = new Intent(intent);
                intent2.setAction(str);
                intent2.setComponent(new ComponentName(getApplicationContext().getPackageName(), MyService.class.getCanonicalName()));
                startService(intent2);
            }
            if (Config.APP_VERSION_CODE.equals(intent.getStringExtra("t"))) {
                m.a().a(new a(intent, getApplicationContext()));
            }
            super.onCreate(bundle);
            c.a();
        } catch (Throwable unused) {
            c.d();
        }
        finish();
    }
}
