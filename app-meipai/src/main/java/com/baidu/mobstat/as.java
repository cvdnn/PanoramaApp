package com.baidu.mobstat;

public class as {

    /* renamed from: e reason: collision with root package name */
    public static final as f1587e = new as();

    /* renamed from: a reason: collision with root package name */
    public boolean f1588a = false;

    /* renamed from: b reason: collision with root package name */
    public float f1589b = 50.0f;

    /* renamed from: c reason: collision with root package name */
    public long f1590c = 500;

    /* renamed from: d reason: collision with root package name */
    public volatile boolean f1591d;

    public static as a() {
        return f1587e;
    }

    public boolean b() {
        return this.f1588a;
    }

    public float c() {
        float f2 = this.f1589b;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        return f2 / 100.0f;
    }

    public long d() {
        return this.f1590c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|(1:9)(1:10)|11|(2:13|14)|15|16|(1:18)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[Catch:{ Exception -> 0x0050 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 1
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0050 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = "sv"
            java.lang.Object r5 = r1.opt(r5)     // Catch:{ Exception -> 0x0050 }
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x0050
            java.lang.String r1 = "close"
            int r1 = r5.optInt(r1)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = "area"
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = "duration"
            java.lang.String r5 = r5.optString(r3)     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x002d
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            r4.f1588a = r1     // Catch:{ Exception -> 0x0050 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0050 }
            if (r1 != 0) goto L_0x0040
            java.lang.Float r1 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x0040 }
            float r1 = r1.floatValue()     // Catch:{ Exception -> 0x0040 }
            r4.f1589b = r1     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0050 }
            if (r1 != 0) goto L_0x0050
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0050 }
            long r1 = r5.longValue()     // Catch:{ Exception -> 0x0050 }
            r4.f1590c = r1     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            r4.f1591d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.as.a(java.lang.String):void");
    }
}
