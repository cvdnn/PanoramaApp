package com.baidu.mobstat;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONObject;

public class ao {

    /* renamed from: a reason: collision with root package name */
    public String f1562a;

    /* renamed from: b reason: collision with root package name */
    public String f1563b;

    /* renamed from: c reason: collision with root package name */
    public String f1564c;

    /* renamed from: d reason: collision with root package name */
    public long f1565d;

    /* renamed from: e reason: collision with root package name */
    public long f1566e;

    /* renamed from: f reason: collision with root package name */
    public float f1567f;

    /* renamed from: g reason: collision with root package name */
    public float f1568g;

    /* renamed from: h reason: collision with root package name */
    public float f1569h;

    /* renamed from: i reason: collision with root package name */
    public float f1570i;

    /* renamed from: j reason: collision with root package name */
    public String f1571j;
    public boolean k;
    public String l;

    public ao(String str, String str2, String str3, long j2, long j3, float f2, float f3, float f4, float f5, String str4, boolean z, String str5) {
        this.f1562a = str;
        this.f1563b = str2;
        this.f1564c = str3;
        this.f1565d = j2;
        this.f1566e = j3;
        this.f1567f = f2;
        this.f1568g = f3;
        this.f1569h = f4;
        this.f1570i = f5;
        this.f1571j = str4;
        this.k = z;
        this.l = str5;
    }

    public String a() {
        return this.f1562a;
    }

    public String b() {
        return this.f1571j;
    }

    public JSONObject a(long j2, String str, String str2) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(this.l)) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("n", str);
            jSONObject2.put("t", this.f1563b);
            jSONObject2.put("d", this.f1565d);
            long j3 = this.f1566e - j2;
            if (j3 <= 0) {
                j3 = 0;
            }
            jSONObject2.put("ps", j3);
            jSONObject2.put("at", 1);
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject2.put(Config.SESSTION_ACTIVITY_X_VIEW_HEIGHT, decimalFormat.format((double) this.f1567f));
            jSONObject2.put(Config.SESSTION_ACTIVITY_Y_VIEW_HEIGHT, decimalFormat.format((double) this.f1568g));
            jSONObject2.put(Config.SESSTION_ACTIVITY_X_TOTAL_HEIGHT, decimalFormat.format((double) this.f1569h));
            jSONObject2.put(Config.SESSTION_ACTIVITY_Y_TOTAL_HEIGHT, decimalFormat.format((double) this.f1570i));
            jSONObject2.put("h5", 0);
            jSONObject2.put("sign", this.l);
            jSONObject = jSONObject2;
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
