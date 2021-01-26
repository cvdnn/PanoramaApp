package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {

    /* renamed from: a reason: collision with root package name */
    public static f f1862a = new f();

    /* renamed from: b reason: collision with root package name */
    public String f1863b = "";

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1864a;

        /* renamed from: b reason: collision with root package name */
        public String f1865b;

        /* renamed from: c reason: collision with root package name */
        public String f1866c;

        public a(String str, String str2, String str3) {
            String str4 = "";
            if (str == null) {
                str = str4;
            }
            this.f1864a = str;
            if (str2 == null) {
                str2 = str4;
            }
            this.f1865b = str2;
            if (str3 == null) {
                str3 = str4;
            }
            this.f1866c = str3;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", this.f1864a);
                jSONObject.put("v", this.f1865b);
                jSONObject.put(Config.DEVICE_WIDTH, this.f1866c);
                return jSONObject;
            } catch (JSONException e2) {
                bb.c().b((Throwable) e2);
                return null;
            }
        }

        public String b() {
            return this.f1864a;
        }
    }

    private boolean a(int i2) {
        return i2 == 100 || i2 == 200 || i2 == 130;
    }

    private ArrayList<a> b(Context context, int i2) {
        List<RunningTaskInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            list = null;
        }
        if (list == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RunningTaskInfo runningTaskInfo : list) {
            if (linkedHashMap.size() > i2) {
                break;
            }
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (!TextUtils.isEmpty(packageName) && !b(context, packageName) && !linkedHashMap.containsKey(packageName)) {
                    linkedHashMap.put(packageName, new a(packageName, a(context, packageName), ""));
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    private ArrayList<a> c(Context context, int i2) {
        List runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 = 0; i3 < runningAppProcesses.size() && linkedHashMap.size() <= i2; i3++) {
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i3);
            if (a(runningAppProcessInfo.importance)) {
                String[] strArr = runningAppProcessInfo.pkgList;
                if (!(strArr == null || strArr.length == 0)) {
                    String str = strArr[0];
                    if (!TextUtils.isEmpty(str) && !b(context, str) && !linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, new a(str, a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                    }
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    public synchronized void a(Context context, boolean z) {
        int i2 = 1;
        if (!z) {
            i2 = 20;
        }
        a(context, z, i2);
    }

    private void a(Context context, boolean z, int i2) {
        ArrayList a2 = a(context, i2);
        if (a2 != null && a2.size() != 0) {
            if (z) {
                String b2 = ((a) a2.get(0)).b();
                if (a(b2, this.f1863b)) {
                    this.f1863b = b2;
                }
            }
            a(context, a2, z);
        }
    }

    private ArrayList<a> a(Context context, int i2) {
        return c(context, i2);
    }

    private boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !str.equals(this.f1863b);
    }

    private String a(Context context, String str) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        String str3 = "";
        if (packageManager == null) {
            return str3;
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e2) {
            bb.c().b((Throwable) e2);
            str2 = str3;
        }
        if (str2 != null) {
            str3 = str2;
        }
        return str3;
    }

    private void a(Context context, ArrayList<a> arrayList, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("|");
        sb.append(sb2.toString());
        sb.append(z ? 1 : 0);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a2 = ((a) it.next()).a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_trace", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = com.baidu.mobstat.bm.a.a(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.APP_TRACE.a(System.currentTimeMillis(), str);
        }
    }

    private boolean b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        if (packageManager == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo == null) {
                return false;
            }
            if ((applicationInfo.flags & 1) != 0) {
                z = true;
            }
            return z;
        } catch (NameNotFoundException e2) {
            bb.c().b((Throwable) e2);
        }
    }
}
