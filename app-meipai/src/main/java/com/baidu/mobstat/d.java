package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.mobstat.bt.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a reason: collision with root package name */
    public static d f1837a = new d();

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1838a;

        /* renamed from: b reason: collision with root package name */
        public String f1839b;

        /* renamed from: c reason: collision with root package name */
        public String f1840c;

        /* renamed from: d reason: collision with root package name */
        public String f1841d;

        public a(String str, String str2, String str3, String str4) {
            String str5 = "";
            if (str == null) {
                str = str5;
            }
            if (str2 == null) {
                str2 = str5;
            }
            if (str3 == null) {
                str3 = str5;
            }
            if (str4 == null) {
                str4 = str5;
            }
            this.f1838a = str;
            this.f1839b = str2;
            this.f1840c = str3;
            this.f1841d = str4;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", this.f1838a);
                jSONObject.put("v", this.f1839b);
                jSONObject.put("c", this.f1840c);
                jSONObject.put(Config.APP_VERSION_CODE, this.f1841d);
                return jSONObject;
            } catch (JSONException e2) {
                bb.c().b((Throwable) e2);
                return null;
            }
        }
    }

    private void b(Context context) {
        a(context, c(context));
    }

    private ArrayList<a> c(Context context) {
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator it = d(context).iterator();
        while (it.hasNext()) {
            PackageInfo packageInfo = (PackageInfo) it.next();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                String str = packageInfo.packageName;
                String str2 = packageInfo.versionName;
                Signature[] signatureArr = packageInfo.signatures;
                String str3 = "";
                String a2 = b.a(((signatureArr == null || signatureArr.length == 0) ? str3 : signatureArr[0].toChars().toString()).getBytes());
                String str4 = applicationInfo.sourceDir;
                if (!TextUtils.isEmpty(str4)) {
                    str3 = b.a(new File(str4));
                }
                arrayList.add(new a(str, str2, a2, str3));
            }
        }
        return arrayList;
    }

    private ArrayList<PackageInfo> d(Context context) {
        ArrayList<PackageInfo> arrayList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        List<PackageInfo> arrayList2 = new ArrayList<>(1);
        try {
            arrayList2 = packageManager.getInstalledPackages(64);
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
        }
        for (PackageInfo packageInfo : arrayList2) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public synchronized void a(Context context) {
        b(context);
    }

    private void a(Context context, ArrayList<a> arrayList) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
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
            jSONObject.put("app_apk", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = com.baidu.mobstat.bm.a.a(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.APP_APK.a(System.currentTimeMillis(), str);
        }
    }
}
