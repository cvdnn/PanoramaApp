package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;

public class ax {

    /* renamed from: c reason: collision with root package name */
    public static final ax f1674c = new ax();

    /* renamed from: a reason: collision with root package name */
    public boolean f1675a = false;

    /* renamed from: b reason: collision with root package name */
    public volatile boolean f1676b;

    public static ax a() {
        return f1674c;
    }

    public boolean b() {
        return this.f1675a;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
                boolean z = false;
                if ((jSONObject != null ? jSONObject.optInt(LivenessStat.TYPE_VOICE_CLOSE) : 0) != 0) {
                    z = true;
                }
                this.f1675a = z;
            } catch (Exception unused) {
            }
            this.f1676b = true;
        }
    }
}
