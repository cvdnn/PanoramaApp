package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobstat.bm.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a reason: collision with root package name */
    public static final e f1861a = new e();

    private void b(Context context, boolean z) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            List<PackageInfo> arrayList = new ArrayList<>(1);
            try {
                arrayList = packageManager.getInstalledPackages(0);
            } catch (Exception e2) {
                bb.c().b((Throwable) e2);
            }
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo packageInfo : arrayList) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    boolean z2 = (applicationInfo.flags & 1) != 0;
                    String charSequence = applicationInfo.loadLabel(packageManager).toString();
                    String str2 = applicationInfo.sourceDir;
                    if (z == z2) {
                        a(z, charSequence, str2, packageInfo, jSONArray);
                    }
                }
            }
            if (jSONArray.length() != 0) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append("|");
                sb.append(sb2.toString());
                sb.append(z ? 1 : 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_list", jSONArray);
                    jSONObject.put("meta-data", sb.toString());
                    str = a.a(jSONObject.toString().getBytes());
                } catch (Exception unused) {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    k.APP_LIST.a(System.currentTimeMillis(), str);
                }
            }
        }
    }

    public synchronized void a(Context context, boolean z) {
        b(context, z);
    }

    private void a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray) {
        long j2;
        if (!z || !packageInfo.packageName.startsWith("com.android.")) {
            long j3 = 0;
            try {
                j2 = packageInfo.firstInstallTime;
            } catch (Throwable th) {
                bb.c().b(th);
                j2 = j3;
            }
            try {
                j3 = packageInfo.lastUpdateTime;
            } catch (Throwable th2) {
                bb.c().b(th2);
            }
            long a2 = a(str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put(Config.APP_VERSION_CODE, str);
                jSONObject.put("v", String.valueOf(packageInfo.versionName));
                jSONObject.put("f", j2);
                jSONObject.put("l", j3);
                jSONObject.put(Config.MODEL, a2);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                bb.c().b((Throwable) e2);
            }
        }
    }

    private long a(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                return file.lastModified();
            }
        }
        return 0;
    }
}
