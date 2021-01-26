package com.baidu.mobstat;

import org.json.JSONObject;

public class ap {

    /* renamed from: a reason: collision with root package name */
    public String f1572a;

    /* renamed from: b reason: collision with root package name */
    public long f1573b;

    /* renamed from: c reason: collision with root package name */
    public long f1574c;

    /* renamed from: d reason: collision with root package name */
    public boolean f1575d;

    /* renamed from: e reason: collision with root package name */
    public long f1576e;

    public ap(String str, long j2, long j3, long j4, boolean z) {
        this.f1572a = str;
        this.f1573b = j2;
        this.f1574c = j3;
        this.f1576e = j4;
        this.f1575d = z;
    }

    public void a(long j2) {
        this.f1574c = j2;
    }

    public long b() {
        return this.f1573b;
    }

    public long c() {
        return this.f1574c;
    }

    public boolean d() {
        return this.f1575d;
    }

    public long e() {
        return this.f1576e;
    }

    public String a() {
        return this.f1572a;
    }

    public void b(long j2) {
        this.f1576e = j2;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f1573b);
            jSONObject.put("e", this.f1574c);
            jSONObject.put("user", this.f1575d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
