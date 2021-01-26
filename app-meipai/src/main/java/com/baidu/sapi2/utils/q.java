package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StatLoadLogin */
public class q {

    /* renamed from: a reason: collision with root package name */
    public static final String f3113a = "t_open_login";

    /* renamed from: b reason: collision with root package name */
    public static final String f3114b = "t_view_init_done";

    /* renamed from: c reason: collision with root package name */
    public static final String f3115c = "t_before_login";

    /* renamed from: d reason: collision with root package name */
    public static final String f3116d = "t_start_login";

    /* renamed from: e reason: collision with root package name */
    public static final String f3117e = "t_load_login";

    /* renamed from: f reason: collision with root package name */
    public static final String f3118f = "is_load_cache";

    /* renamed from: g reason: collision with root package name */
    public long f3119g;

    /* renamed from: h reason: collision with root package name */
    public long f3120h;

    /* renamed from: i reason: collision with root package name */
    public long f3121i;

    /* renamed from: j reason: collision with root package name */
    public long f3122j;
    public long k;
    public boolean l;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f3113a, this.f3119g);
            jSONObject.put(f3114b, this.f3120h);
            jSONObject.put(f3115c, this.f3121i);
            jSONObject.put(f3116d, this.f3122j);
            jSONObject.put(f3117e, this.k);
            jSONObject.put(f3118f, this.l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
