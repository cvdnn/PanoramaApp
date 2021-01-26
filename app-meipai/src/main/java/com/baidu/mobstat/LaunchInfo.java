package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public class LaunchInfo {

    /* renamed from: a reason: collision with root package name */
    public String f1426a;

    /* renamed from: b reason: collision with root package name */
    public String f1427b;

    /* renamed from: c reason: collision with root package name */
    public String f1428c;

    public static JSONObject getConvertedJson(int i2, String str, String str2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", String.valueOf(i2));
                String str3 = Config.LAUNCH_REFERER;
                String str4 = "";
                if (str == null) {
                    str = str4;
                }
                jSONObject2.put(str3, str);
                String str5 = Config.LAUNCH_INFO;
                if (str2 == null) {
                    str2 = str4;
                }
                jSONObject2.put(str5, str2);
                jSONObject2.put(Config.LAUNCH_CONTENT, str4);
                return jSONObject2;
            } catch (Exception unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Exception unused2) {
            return jSONObject;
        }
    }

    public static String getLauncherHomePkgName(Context context) {
        String a2 = bj.a(context);
        return !TextUtils.isEmpty(a2) ? a2 : "";
    }

    public int getLaunchType(Context context) {
        if (!TextUtils.isEmpty(this.f1426a)) {
            return 2;
        }
        String packageName = context != null ? context.getPackageName() : "";
        if (!TextUtils.isEmpty(this.f1428c) && !this.f1428c.equals(packageName)) {
            String a2 = bj.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (!this.f1428c.equals(a2)) {
                    return 1;
                }
            } else if (!bj.a(context, this.f1428c)) {
                return 1;
            }
        }
        return 0;
    }

    public String getPushContent() {
        return !TextUtils.isEmpty(this.f1427b) ? this.f1427b : "";
    }

    public String getPushLandingPage() {
        return !TextUtils.isEmpty(this.f1426a) ? this.f1426a : "";
    }

    public String getRefererPkgName() {
        return !TextUtils.isEmpty(this.f1428c) ? this.f1428c : "";
    }

    public void setPushInfo(String str, String str2) {
        this.f1426a = str;
        this.f1427b = bx.a(str2, 1024);
    }

    public void setRefererPkgName(String str) {
        this.f1428c = str;
    }
}
