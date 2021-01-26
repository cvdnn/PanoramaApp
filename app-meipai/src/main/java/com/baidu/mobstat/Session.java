package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Session {

    /* renamed from: a reason: collision with root package name */
    public volatile long f1459a = 0;

    /* renamed from: b reason: collision with root package name */
    public volatile long f1460b = 0;

    /* renamed from: c reason: collision with root package name */
    public volatile long f1461c = 0;

    /* renamed from: d reason: collision with root package name */
    public volatile long f1462d = 0;

    /* renamed from: e reason: collision with root package name */
    public volatile long f1463e = 0;

    /* renamed from: f reason: collision with root package name */
    public volatile int f1464f = 0;

    /* renamed from: g reason: collision with root package name */
    public List<a> f1465g = new ArrayList();

    /* renamed from: h reason: collision with root package name */
    public volatile JSONObject f1466h = null;

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1467a;

        /* renamed from: b reason: collision with root package name */
        public String f1468b;

        /* renamed from: c reason: collision with root package name */
        public String f1469c;

        /* renamed from: d reason: collision with root package name */
        public long f1470d;

        /* renamed from: e reason: collision with root package name */
        public long f1471e;

        /* renamed from: f reason: collision with root package name */
        public boolean f1472f;

        /* renamed from: g reason: collision with root package name */
        public JSONObject f1473g;

        /* renamed from: h reason: collision with root package name */
        public boolean f1474h;

        public a(String str, String str2, String str3, long j2, long j3, boolean z, ExtraInfo extraInfo, boolean z2) {
            this.f1468b = str;
            this.f1469c = str2;
            this.f1467a = str3;
            this.f1470d = j2;
            this.f1471e = j3;
            this.f1472f = z;
            JSONObject jSONObject = new JSONObject();
            if (extraInfo != null) {
                jSONObject = extraInfo.dumpToJson();
            }
            this.f1473g = jSONObject;
            this.f1474h = z2;
        }

        public String a() {
            return this.f1468b;
        }

        public JSONObject e() {
            return this.f1473g;
        }

        public boolean f() {
            return this.f1472f;
        }

        public void a(a aVar) {
            this.f1467a = aVar.f1467a;
            this.f1468b = aVar.f1468b;
            this.f1469c = aVar.f1469c;
            this.f1470d = aVar.f1470d;
            this.f1471e = aVar.f1471e;
            this.f1472f = aVar.f1472f;
            this.f1473g = aVar.f1473g;
            this.f1474h = aVar.f1474h;
        }

        public String b() {
            return this.f1469c;
        }

        public long c() {
            return this.f1470d;
        }

        public long d() {
            return this.f1471e;
        }
    }

    private void a(List<a> list, a aVar) {
        if (list != null && aVar != null) {
            int size = list.size();
            if (size == 0) {
                list.add(aVar);
                return;
            }
            a aVar2 = (a) list.get(size - 1);
            if (TextUtils.isEmpty(aVar2.f1467a) || TextUtils.isEmpty(aVar.f1467a)) {
                list.add(aVar);
            } else if (!aVar2.f1467a.equals(aVar.f1467a) || aVar2.f1472f == aVar.f1472f) {
                list.add(aVar);
            } else {
                if (aVar2.f1472f) {
                    aVar2.a(aVar);
                }
            }
        }
    }

    public static JSONObject getPVJson(a aVar, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", aVar.a());
            jSONObject.put("d", aVar.c());
            long d2 = aVar.d() - j2;
            String str = "ps";
            if (d2 < 0) {
                d2 = 0;
            }
            jSONObject.put(str, d2);
            jSONObject.put("t", aVar.b());
            int i2 = 1;
            jSONObject.put("at", aVar.f() ? 1 : 0);
            JSONObject e2 = aVar.e();
            if (!(e2 == null || e2.length() == 0)) {
                jSONObject.put("ext", e2);
            }
            String str2 = "h5";
            if (!aVar.f1474h) {
                i2 = 0;
            }
            jSONObject.put(str2, i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void addPageView(String str, String str2, String str3, long j2, long j3, boolean z, ExtraInfo extraInfo, boolean z2) {
        a aVar = new a(str, str2, str3, j2, j3, z, extraInfo, z2);
        a(this.f1465g, aVar);
    }

    public JSONObject constructJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f1459a);
            jSONObject.put("e", this.f1460b);
            jSONObject.put("i", this.f1463e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f1461c == 0 ? this.f1459a : this.f1461c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f1462d == 0 ? this.f1460b : this.f1462d);
            jSONObject.put("pc", this.f1464f);
            if (!(this.f1466h == null || this.f1466h.length() == 0)) {
                jSONObject.put(Config.LAUNCH, this.f1466h);
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f1465g.size(); i2++) {
                jSONArray.put(getPVJson((a) this.f1465g.get(i2), this.f1459a));
            }
            jSONObject.put("p", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPageSessionHead() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f1459a);
            jSONObject.put("e", this.f1460b);
            jSONObject.put("i", this.f1463e);
            jSONObject.put("c", 1);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f1461c == 0 ? this.f1459a : this.f1461c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f1462d == 0 ? this.f1460b : this.f1462d);
            jSONObject.put("pc", this.f1464f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.f1459a;
    }

    public boolean hasEnd() {
        return this.f1460b > 0;
    }

    public boolean hasStart() {
        return this.f1459a > 0;
    }

    public void reset() {
        this.f1459a = 0;
        this.f1460b = 0;
        this.f1461c = 0;
        this.f1462d = 0;
        this.f1464f = 0;
        this.f1465g.clear();
    }

    public void setEndTime(long j2) {
        this.f1460b = j2;
    }

    public void setInvokeType(int i2) {
        this.f1464f = i2;
    }

    public void setLaunchInfo(JSONObject jSONObject) {
        this.f1466h = jSONObject;
    }

    public void setStartTime(long j2) {
        if (this.f1459a <= 0) {
            this.f1459a = j2;
            this.f1463e = j2;
        }
    }

    public void setTrackEndTime(long j2) {
        this.f1462d = j2;
    }

    public void setTrackStartTime(long j2) {
        if (this.f1461c <= 0) {
            this.f1461c = j2;
        }
    }

    public String toString() {
        return constructJSONObject().toString();
    }

    public void addPageView(a aVar) {
        a(this.f1465g, aVar);
    }
}
