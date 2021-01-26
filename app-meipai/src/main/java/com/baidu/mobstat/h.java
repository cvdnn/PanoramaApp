package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", VERSION.SDK_INT);
            jSONObject.put("sv", VERSION.RELEASE);
            jSONObject.put(Config.CUID_SEC, bw.a(2, context));
            jSONObject.put(Config.DEVICE_WIDTH, bw.c(context));
            jSONObject.put("h", bw.d(context));
            jSONObject.put("ly", ab.f1495c);
            jSONObject.put("pv", "33");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put(Config.PACKAGE_NAME, bw.h(2, context));
                jSONObject.put(Config.APP_VERSION_CODE, packageInfo.versionCode);
                jSONObject.put("n", packageInfo.versionName);
            } catch (Exception e2) {
                bb.c().a((Throwable) e2);
            }
            jSONObject.put(Config.DEVICE_MAC_ID, bw.b(2, context));
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, bw.f(2, context));
            jSONObject.put(Config.MODEL, Build.MODEL);
            jSONObject.put(Config.DEVICE_NAME, bw.a(context, 2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            jSONObject2.put("send_index", 0);
            String b2 = bw.b();
            String str = Config.ROM;
            if (b2 == null) {
                b2 = "";
            }
            jSONObject2.put(str, b2);
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (JSONException e3) {
            bb.c().b((Throwable) e3);
        }
        return jSONObject;
    }

    public static void b(JSONObject jSONObject) {
        String str = Config.TRACE_FAILED_CNT;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put(str, jSONObject2.getLong(str) + 1);
        } catch (Exception unused) {
        }
    }

    public static void c(JSONObject jSONObject) {
        String str = "send_index";
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.TRACE_PART);
            jSONObject2.put(str, jSONObject2.getLong(str) + 1);
        } catch (Exception unused) {
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("payload");
            JSONObject jSONObject3 = (jSONArray == null || jSONArray.length() <= 0) ? null : (JSONObject) jSONArray.get(0);
            if (jSONObject3 != null) {
                jSONObject2 = jSONObject3.getJSONObject(Config.HEADER_PART);
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }
}
