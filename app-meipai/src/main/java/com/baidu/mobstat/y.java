package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import e.a.a.a.a;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class y {

    /* renamed from: a reason: collision with root package name */
    public static y f1912a;

    /* renamed from: b reason: collision with root package name */
    public Context f1913b;

    /* renamed from: c reason: collision with root package name */
    public JSONObject f1914c = new JSONObject();

    /* renamed from: d reason: collision with root package name */
    public long f1915d = 24;

    /* renamed from: e reason: collision with root package name */
    public long f1916e = 0;

    /* renamed from: f reason: collision with root package name */
    public long f1917f = 0;

    /* renamed from: g reason: collision with root package name */
    public long f1918g = 0;

    /* renamed from: h reason: collision with root package name */
    public long f1919h = 5;

    /* renamed from: i reason: collision with root package name */
    public long f1920i = 24;

    /* renamed from: j reason: collision with root package name */
    public long f1921j = 15;
    public long k = 15;
    public long l = 30;
    public long m = 12;
    public long n = 1;
    public long o = 24;
    public String p;
    public String q;

    public y(Context context) {
        String str = "";
        this.p = str;
        this.q = str;
        this.f1913b = context;
        m();
        j();
        k();
    }

    public static y a(Context context) {
        if (f1912a == null) {
            synchronized (y.class) {
                if (f1912a == null) {
                    f1912a = new y(context);
                }
            }
        }
        return f1912a;
    }

    private void m() {
        String b2 = bo.b("backups/system/.timestamp");
        try {
            if (!TextUtils.isEmpty(b2)) {
                this.f1914c = new JSONObject(b2);
            }
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.f1917f != 0;
    }

    public long c() {
        return this.f1915d * 60 * 60 * 1000;
    }

    public long d() {
        return this.o * 60 * 60 * 1000;
    }

    public long e() {
        return this.f1919h * 60 * 1000;
    }

    public long f() {
        return this.f1920i * 60 * 60 * 1000;
    }

    public long g() {
        return this.f1921j * 24 * 60 * 60 * 1000;
    }

    public long h() {
        return this.k * 24 * 60 * 60 * 1000;
    }

    public long i() {
        return this.m * 60 * 60 * 1000;
    }

    public void j() {
        try {
            String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f1913b, ".config2").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f1916e = jSONObject.getLong("c");
                } catch (JSONException e2) {
                    bb.c().b((Throwable) e2);
                }
                try {
                    this.f1919h = jSONObject.getLong("d");
                } catch (JSONException e3) {
                    bb.c().b((Throwable) e3);
                }
                try {
                    this.f1920i = jSONObject.getLong("e");
                } catch (JSONException e4) {
                    bb.c().b((Throwable) e4);
                }
                try {
                    this.f1921j = jSONObject.getLong("i");
                } catch (JSONException e5) {
                    bb.c().b((Throwable) e5);
                }
                try {
                    this.f1915d = jSONObject.getLong("f");
                } catch (JSONException e6) {
                    bb.c().b((Throwable) e6);
                }
                try {
                    this.o = jSONObject.getLong("s");
                } catch (JSONException e7) {
                    bb.c().b((Throwable) e7);
                }
                try {
                    this.k = jSONObject.getLong("pk");
                } catch (JSONException e8) {
                    bb.c().b((Throwable) e8);
                }
                try {
                    this.l = jSONObject.getLong("at");
                } catch (JSONException e9) {
                    bb.c().b((Throwable) e9);
                }
                try {
                    this.m = jSONObject.getLong("as");
                } catch (JSONException e10) {
                    bb.c().b((Throwable) e10);
                }
                try {
                    this.n = jSONObject.getLong("ac");
                } catch (JSONException e11) {
                    bb.c().b((Throwable) e11);
                }
                try {
                    this.f1917f = jSONObject.getLong(Config.DEVICE_MAC_ID);
                } catch (JSONException e12) {
                    bb.c().b((Throwable) e12);
                }
                try {
                    this.f1918g = jSONObject.getLong("lsc");
                } catch (JSONException e13) {
                    bb.c().b((Throwable) e13);
                }
            }
        } catch (Exception e14) {
            bb.c().b((Throwable) e14);
        }
    }

    public void k() {
        try {
            String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f1913b, ".sign").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.q = jSONObject.getString("sign");
                } catch (Exception e2) {
                    bb.c().b((Throwable) e2);
                }
                try {
                    this.p = jSONObject.getString("ver");
                } catch (Exception e3) {
                    bb.c().b((Throwable) e3);
                }
            }
        } catch (Exception e4) {
            bb.c().b((Throwable) e4);
        }
    }

    public boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = a(g.LAST_SEND);
        long d2 = d();
        bb c2 = bb.c();
        StringBuilder a3 = a.a("canSend now=", currentTimeMillis, ";lastSendTime=");
        a3.append(a2);
        a3.append(";sendLogTimeInterval=");
        a3.append(d2);
        c2.a(a3.toString());
        return currentTimeMillis - a2 > d2 || !a(a2);
    }

    public void b(String str) {
        bo.a(this.f1913b, ".sign", str, false);
        k();
    }

    public String c(String str) {
        return (TextUtils.isEmpty(this.p) || !this.p.equals(str) || TextUtils.isEmpty(this.q)) ? "" : this.q;
    }

    private long b(long j2) {
        if (j2 - System.currentTimeMillis() > 0) {
            return 0;
        }
        return j2;
    }

    public boolean a() {
        return this.f1916e != 0;
    }

    public void a(String str) {
        bo.a(this.f1913b, ".config2", str, false);
        j();
    }

    public long a(g gVar) {
        long j2 = gVar.f1876j;
        try {
            String str = gVar.toString();
            if (this.f1914c.has(str)) {
                j2 = this.f1914c.getLong(str);
            }
        } catch (Exception e2) {
            bb.c().a((Throwable) e2);
        }
        return b(j2);
    }

    public void a(g gVar, long j2) {
        gVar.f1876j = j2;
        try {
            this.f1914c.put(gVar.toString(), j2);
        } catch (Exception e2) {
            bb.c().a((Throwable) e2);
        }
        try {
            bo.a("backups/system/.timestamp", this.f1914c.toString(), false);
        } catch (Exception e3) {
            bb.c().a((Throwable) e3);
        }
    }

    public boolean a(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j2)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }
}
