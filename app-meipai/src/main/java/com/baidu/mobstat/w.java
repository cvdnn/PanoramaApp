package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONObject;

public class w implements a {

    /* renamed from: a reason: collision with root package name */
    public z f1905a = z.f1922a;

    /* renamed from: b reason: collision with root package name */
    public Object f1906b;

    /* renamed from: c reason: collision with root package name */
    public Class<?> f1907c;

    public w(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("proxy is null.");
        } else if ("com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
            this.f1906b = obj;
            this.f1907c = obj.getClass();
        } else {
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            this.f1905a.a(context, jSONObject);
        }
    }

    public void b(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            this.f1905a.b(context, str);
        }
    }

    public void a(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            this.f1905a.a(context, str);
        }
    }

    public boolean b(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            return this.f1905a.b(context);
        }
    }

    public void a(Context context, long j2) {
        try {
            a(new Object[]{context, Long.valueOf(j2)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            this.f1905a.a(context, j2);
        }
    }

    public boolean a(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
            return this.f1905a.a(context);
        }
    }

    private <T> T a(Object[] objArr, String str, Class<?>[] clsArr) throws Exception {
        return this.f1907c.getMethod(str, clsArr).invoke(this.f1906b, objArr);
    }
}
