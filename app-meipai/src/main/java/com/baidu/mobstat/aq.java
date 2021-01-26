package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mobstat.bt.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class aq {

    /* renamed from: a reason: collision with root package name */
    public String f1577a;

    /* renamed from: b reason: collision with root package name */
    public String f1578b;

    /* renamed from: c reason: collision with root package name */
    public JSONArray f1579c;

    /* renamed from: d reason: collision with root package name */
    public String f1580d;

    /* renamed from: e reason: collision with root package name */
    public String f1581e;

    /* renamed from: f reason: collision with root package name */
    public String f1582f;

    /* renamed from: g reason: collision with root package name */
    public boolean f1583g;

    /* renamed from: h reason: collision with root package name */
    public long f1584h;

    /* renamed from: i reason: collision with root package name */
    public long f1585i;

    /* renamed from: j reason: collision with root package name */
    public long f1586j;
    public int k;
    public String l;
    public String m;

    public aq(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z, int i2, long j2, long j3, long j4, String str6, String str7) {
        this.f1577a = str;
        this.f1578b = str2;
        this.f1579c = jSONArray;
        this.f1580d = str3;
        this.f1581e = str4;
        this.f1582f = str5;
        this.f1583g = z;
        this.k = i2;
        this.f1584h = j2;
        this.f1585i = j3;
        this.f1586j = j4;
        this.l = str6;
        this.m = str7;
    }

    public String a() {
        return this.f1577a;
    }

    public String b() {
        return this.f1578b;
    }

    public JSONArray c() {
        return this.f1579c;
    }

    public String d() {
        return this.f1580d;
    }

    public String e() {
        return this.f1581e;
    }

    public String f() {
        return this.f1582f;
    }

    public boolean g() {
        return this.f1583g;
    }

    public int h() {
        return this.k;
    }

    public long i() {
        return this.f1584h;
    }

    public long j() {
        return this.f1585i;
    }

    public long k() {
        return this.f1586j;
    }

    public String l() {
        return this.l;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void b(long j2) {
        this.f1586j = j2;
    }

    public void a(long j2) {
        this.f1585i = j2;
    }

    public void b(String str) {
        this.m = str;
    }

    public void a(String str) {
        this.l = str;
    }

    public JSONObject a(String str, String str2, String str3) {
        String a2 = a(this.f1577a, this.f1578b, this.f1579c, this.f1580d, this.f1581e, this.f1582f, this.f1583g);
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", this.f1577a);
            jSONObject2.put("d", this.l);
            jSONObject2.put("p", str);
            jSONObject2.put("path", str3);
            jSONObject2.put("title", this.f1580d);
            jSONObject2.put("index", this.f1581e);
            jSONObject2.put("n", str2);
            jSONObject2.put("user", this.f1583g ? 1 : 0);
            jSONObject2.put("c", this.k);
            jSONObject2.put("t", this.f1584h);
            jSONObject2.put("ps", this.m);
            jSONObject2.put("sign", a2);
            jSONObject = jSONObject2;
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        String str6;
        String str7 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("p", str2);
            jSONObject.put("path", jSONArray);
            jSONObject.put("title", str3);
            jSONObject.put("index", str4);
            jSONObject.put("n", str5);
            jSONObject.put("user", z ? 1 : 0);
            str6 = jSONObject.toString();
        } catch (Exception unused) {
            str6 = str7;
        }
        return !TextUtils.isEmpty(str6) ? a.a(str6.getBytes()) : str7;
    }
}
