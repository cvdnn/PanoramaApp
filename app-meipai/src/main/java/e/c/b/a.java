package e.c.b;

import android.app.ActivityManager;
import android.app.Application;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import e.c.b.e.c;
import e.c.b.e.d;
import e.c.b.e.f;
import e.c.b.e.h;
import e.c.b.e.Utils;
import e.c.b.e.j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;

public class a {

    /* renamed from: a reason: collision with root package name */
    public static Application f5874a = null;

    /* renamed from: b reason: collision with root package name */
    public static String f5875b = "/sdcard";

    /* renamed from: c reason: collision with root package name */
    public static String f5876c = "";

    public static void a(Application application) {
        if (f.f5904b == null) {
            f.f5904b = application;
        }
        h.a(application);
        if (Utils.f5911d == null) {
            Utils.f5911d = application;
            PackageManager packageManager = application.getPackageManager();
            Utils.f5912e = packageManager;
            try {
                Utils.packageInfo = packageManager.getPackageInfo(Utils.f5911d.getPackageName(), 0);
            } catch (NameNotFoundException e2) {
                e.c.b.f.a.a("PackageCollector.init fail.", e2);
            }
        }
        if (a.a.a.a.b.a.f400i == null && application != null) {
            try {
                a.a.a.a.b.a.f400i = application.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                e.c.b.f.a.b("Battery Broadcast Regist Success");
            } catch (Exception e3) {
                e.c.b.f.a.a("Register Battery Error!", e3);
            }
        }
        a.a.a.a.b.a.f401j = Locale.getDefault();
        if (a.a.a.a.b.a.k == null) {
            a.a.a.a.b.a.k = application;
            a.a.a.a.b.a.l = (ActivityManager) application.getSystemService("activity");
        }
        if (j.f5918a == null) {
            j.f5918a = application;
            j.f5919b = application.getSharedPreferences("crab_user_info", 0);
        }
        Utils.f5910c = application;
        if (c.f5896c) {
            c.f5896c = false;
            c.f5897d = System.currentTimeMillis();
            application.registerActivityLifecycleCallbacks(new d());
        }
    }

    public static void b(Application application) {
        String str = "constant_crash";
        if (Utils.context == null) {
            Utils.context = application;
            Utils.sharedPreferences = application.getSharedPreferences("crab_crash_switch", 0);
            if (!(d.q == -1 || Utils.sharedPreferences == null)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i2 = 1; i2 < 8; i2++) {
                    Calendar instance = Calendar.getInstance();
                    instance.add(5, -i2);
                    strArr[i2 - 1] = simpleDateFormat.format(instance.getTime());
                }
                Editor edit = Utils.sharedPreferences.edit();
                for (int i3 = 0; i3 < 7; i3++) {
                    String str2 = strArr[i3];
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append("same_crash_oneday_count");
                    edit.remove(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("oneday_crash_count");
                    edit.remove(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append("oneday_anr_count");
                    edit.remove(sb3.toString());
                }
                Utils.a(edit, true);
            }
            if (d.v != -1) {
                try {
                    String string = Utils.sharedPreferences.getString(str, null);
                    if (!TextUtils.isEmpty(string) && new JSONObject(string).getInt(Config.TRACE_VISIT_RECENT_COUNT) >= d.v && d.I != null) {
                        Editor edit2 = Utils.sharedPreferences.edit();
                        edit2.remove(str);
                        if (edit2.commit()) {
                            d.I.a();
                        }
                    }
                } catch (Exception e2) {
                    StringBuilder sb4 = new StringBuilder("addConstantSameCrash exception ");
                    sb4.append(Utils.a((Throwable) e2));
                    e.c.b.f.a.c(sb4.toString());
                }
            }
        }
    }
}
