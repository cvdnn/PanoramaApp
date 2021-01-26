package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import java.util.List;

public enum t {
    SERVICE(1) {
        public void a(Context context) {
            if (t.d(context) && u.a(context).b(context)) {
                try {
                    Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                    intent.putExtra("SDK_PRODUCT_LY", "MS");
                    context.startService(intent);
                } catch (Throwable th) {
                    bb.c().b(th);
                }
            }
        }
    },
    NO_SERVICE(2) {
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f1498a = false;
                acVar.f1499b = "M";
                acVar.f1500c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    },
    RECEIVER(3) {
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f1498a = false;
                acVar.f1499b = "R";
                acVar.f1500c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    },
    ERISED(4) {
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f1498a = false;
                acVar.f1499b = "E";
                acVar.f1500c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    };
    

    /* renamed from: e reason: collision with root package name */
    public int f1902e;

    public static t a(int i2) {
        t[] values;
        for (t tVar : values()) {
            if (tVar.f1902e == i2) {
                return tVar;
            }
        }
        return NO_SERVICE;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                int i2 = 0;
                while (runningServices != null && i2 < runningServices.size()) {
                    if ("com.baidu.bottom.service.BottomService".equals(((RunningServiceInfo) runningServices.get(i2)).service.getClassName())) {
                        return true;
                    }
                    i2++;
                }
            } catch (Exception e2) {
                bb.c().a((Throwable) e2);
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        return bo.e(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public abstract void a(Context context);

    public String toString() {
        return String.valueOf(this.f1902e);
    }

    /* access modifiers changed from: public */
    t(int i2) {
        this.f1902e = i2;
    }
}
