package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;

public class ac {

    /* renamed from: a reason: collision with root package name */
    public boolean f1498a = false;

    /* renamed from: b reason: collision with root package name */
    public String f1499b = "";

    /* renamed from: c reason: collision with root package name */
    public boolean f1500c = false;

    public ac() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f1498a);
        } catch (JSONException e2) {
            bb.c().b((Throwable) e2);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f1499b);
        } catch (JSONException e3) {
            bb.c().b((Throwable) e3);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.f1500c);
        } catch (JSONException e4) {
            bb.c().b((Throwable) e4);
        }
        return jSONObject;
    }

    public ac(JSONObject jSONObject) {
        try {
            this.f1498a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e2) {
            bb.c().b((Throwable) e2);
        }
        try {
            this.f1499b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e3) {
            bb.c().b((Throwable) e3);
        }
        try {
            this.f1500c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e4) {
            bb.c().b((Throwable) e4);
        }
    }
}
