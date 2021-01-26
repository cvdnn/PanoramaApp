package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidubce.AbstractBceClient;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtraInfo {

    /* renamed from: a reason: collision with root package name */
    public String f1405a;

    /* renamed from: b reason: collision with root package name */
    public String f1406b;

    /* renamed from: c reason: collision with root package name */
    public String f1407c;

    /* renamed from: d reason: collision with root package name */
    public String f1408d;

    /* renamed from: e reason: collision with root package name */
    public String f1409e;

    /* renamed from: f reason: collision with root package name */
    public String f1410f;

    /* renamed from: g reason: collision with root package name */
    public String f1411g;

    /* renamed from: h reason: collision with root package name */
    public String f1412h;

    /* renamed from: i reason: collision with root package name */
    public String f1413i;

    /* renamed from: j reason: collision with root package name */
    public String f1414j;

    public ExtraInfo() {
        String str = "";
        this.f1405a = str;
        this.f1406b = str;
        this.f1407c = str;
        this.f1408d = str;
        this.f1409e = str;
        this.f1410f = str;
        this.f1411g = str;
        this.f1412h = str;
        this.f1413i = str;
        this.f1414j = str;
    }

    public static boolean a(String str, int i2) {
        int i3;
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            i3 = str.getBytes().length;
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 > i2) {
            z = true;
        }
        return z;
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f1405a)) {
                jSONObject.put(AbstractBceClient.URL_PREFIX, this.f1405a);
            }
            if (!TextUtils.isEmpty(this.f1406b)) {
                jSONObject.put("v2", this.f1406b);
            }
            if (!TextUtils.isEmpty(this.f1407c)) {
                jSONObject.put("v3", this.f1407c);
            }
            if (!TextUtils.isEmpty(this.f1408d)) {
                jSONObject.put("v4", this.f1408d);
            }
            if (!TextUtils.isEmpty(this.f1409e)) {
                jSONObject.put("v5", this.f1409e);
            }
            if (!TextUtils.isEmpty(this.f1410f)) {
                jSONObject.put("v6", this.f1410f);
            }
            if (!TextUtils.isEmpty(this.f1411g)) {
                jSONObject.put("v7", this.f1411g);
            }
            if (!TextUtils.isEmpty(this.f1412h)) {
                jSONObject.put("v8", this.f1412h);
            }
            if (!TextUtils.isEmpty(this.f1413i)) {
                jSONObject.put("v9", this.f1413i);
            }
            if (!TextUtils.isEmpty(this.f1414j)) {
                jSONObject.put("v10", this.f1414j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f1405a;
    }

    public String getV10() {
        return this.f1414j;
    }

    public String getV2() {
        return this.f1406b;
    }

    public String getV3() {
        return this.f1407c;
    }

    public String getV4() {
        return this.f1408d;
    }

    public String getV5() {
        return this.f1409e;
    }

    public String getV6() {
        return this.f1410f;
    }

    public String getV7() {
        return this.f1411g;
    }

    public String getV8() {
        return this.f1412h;
    }

    public String getV9() {
        return this.f1413i;
    }

    public void setV1(String str) {
        this.f1405a = a(str);
    }

    public void setV10(String str) {
        this.f1414j = a(str);
    }

    public void setV2(String str) {
        this.f1406b = a(str);
    }

    public void setV3(String str) {
        this.f1407c = a(str);
    }

    public void setV4(String str) {
        this.f1408d = a(str);
    }

    public void setV5(String str) {
        this.f1409e = a(str);
    }

    public void setV6(String str) {
        this.f1410f = a(str);
    }

    public void setV7(String str) {
        this.f1411g = a(str);
    }

    public void setV8(String str) {
        this.f1412h = a(str);
    }

    public void setV9(String str) {
        this.f1413i = a(str);
    }

    public static String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        return a(str, 1024) ? str2 : str;
    }
}
