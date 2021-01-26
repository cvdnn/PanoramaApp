package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class HeadObject {
    public JSONObject A;
    public JSONObject B;
    public String C;
    public int D;
    public String E = "";
    public String F;

    /* renamed from: a reason: collision with root package name */
    public boolean f1416a = false;

    /* renamed from: b reason: collision with root package name */
    public String f1417b;

    /* renamed from: c reason: collision with root package name */
    public String f1418c;

    /* renamed from: d reason: collision with root package name */
    public String f1419d = "0";

    /* renamed from: e reason: collision with root package name */
    public String f1420e = null;

    /* renamed from: f reason: collision with root package name */
    public String f1421f = null;

    /* renamed from: g reason: collision with root package name */
    public int f1422g = -1;

    /* renamed from: h reason: collision with root package name */
    public String f1423h;

    /* renamed from: i reason: collision with root package name */
    public String f1424i;

    /* renamed from: j reason: collision with root package name */
    public int f1425j;
    public int k;
    public String l = null;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* JADX WARNING: Can't wrap try/catch for region: R(36:6|7|8|(1:10)(1:11)|12|(1:14)|15|(2:16|17)|18|20|21|22|23|24|25|26|27|28|29|(1:31)|32|33|34|35|36|37|(1:39)(1:40)|41|42|(1:44)(1:45)|46|47|48|49|50|51) */
    /* JADX WARNING: Can't wrap try/catch for region: R(37:6|7|8|(1:10)(1:11)|12|(1:14)|15|16|17|18|20|21|22|23|24|25|26|27|28|29|(1:31)|32|33|34|35|36|37|(1:39)(1:40)|41|42|(1:44)(1:45)|46|47|48|49|50|51) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00b7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00d1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00f9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0121 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0136 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x014b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0155 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ea A[Catch:{ Exception -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012b A[Catch:{ Exception -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0132 A[Catch:{ Exception -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140 A[Catch:{ Exception -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0147 A[Catch:{ Exception -> 0x014b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f1416a     // Catch:{ all -> 0x017b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            com.baidu.mobstat.bo.e(r4, r0)     // Catch:{ all -> 0x017b }
            java.lang.String r0 = "android.permission.INTERNET"
            com.baidu.mobstat.bo.e(r4, r0)     // Catch:{ all -> 0x017b }
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            com.baidu.mobstat.bo.e(r4, r0)     // Catch:{ all -> 0x017b }
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r4.getSystemService(r0)     // Catch:{ all -> 0x017b }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getOSVersion()     // Catch:{ all -> 0x017b }
            r3.f1417b = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getOSSysVersion()     // Catch:{ all -> 0x017b }
            r3.f1418c = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getPhoneModel()     // Catch:{ all -> 0x017b }
            r3.n = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getManufacturer()     // Catch:{ all -> 0x017b }
            r3.o = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getUUID()     // Catch:{ all -> 0x017b }
            r3.z = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            org.json.JSONObject r1 = r1.getHeaderExt(r4)     // Catch:{ all -> 0x017b }
            r3.A = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            org.json.JSONObject r1 = r1.getPushId(r4)     // Catch:{ all -> 0x017b }
            r3.B = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.getDeviceId(r0, r4)     // Catch:{ all -> 0x017b }
            r3.f1424i = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.bq r1 = com.baidu.mobstat.bq.a()     // Catch:{ all -> 0x017b }
            boolean r1 = r1.i(r4)     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = "1"
            goto L_0x007d
        L_0x007b:
            java.lang.String r1 = "0"
        L_0x007d:
            r3.f1419d = r1     // Catch:{ all -> 0x017b }
            boolean r1 = com.baidu.mobstat.bw.w(r4)     // Catch:{ all -> 0x017b }
            if (r1 == 0) goto L_0x0089
            java.lang.String r1 = "2"
            r3.f1419d = r1     // Catch:{ all -> 0x017b }
        L_0x0089:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017b }
            r1.<init>()     // Catch:{ all -> 0x017b }
            java.lang.String r2 = r3.f1419d     // Catch:{ all -> 0x017b }
            r1.append(r2)     // Catch:{ all -> 0x017b }
            java.lang.String r2 = "-14"
            r1.append(r2)     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017b }
            r3.f1419d = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r1 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x00b0 }
            boolean r1 = r1.isDeviceMacEnabled(r4)     // Catch:{ Exception -> 0x00b0 }
            com.baidu.mobstat.CooperService r2 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r1 = r2.getMacAddress(r4, r1)     // Catch:{ Exception -> 0x00b0 }
            r3.s = r1     // Catch:{ Exception -> 0x00b0 }
        L_0x00b0:
            r1 = 1
            java.lang.String r2 = com.baidu.mobstat.bw.f(r1, r4)     // Catch:{ Exception -> 0x00b7 }
            r3.u = r2     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            java.lang.String r2 = com.baidu.mobstat.bw.a(r4, r1)     // Catch:{ Exception -> 0x00bd }
            r3.v = r2     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            com.baidu.mobstat.CooperService r2 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r2 = r2.getCUID(r4, r1)     // Catch:{ all -> 0x017b }
            r3.f1421f = r2     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r2 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r0 = r2.getOperator(r0)     // Catch:{ Exception -> 0x00d1 }
            r3.m = r0     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            int r0 = com.baidu.mobstat.bw.c(r4)     // Catch:{ Exception -> 0x00f9 }
            r3.f1425j = r0     // Catch:{ Exception -> 0x00f9 }
            int r0 = com.baidu.mobstat.bw.d(r4)     // Catch:{ Exception -> 0x00f9 }
            r3.k = r0     // Catch:{ Exception -> 0x00f9 }
            android.content.res.Resources r0 = r4.getResources()     // Catch:{ Exception -> 0x00f9 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x00f9 }
            int r0 = r0.orientation     // Catch:{ Exception -> 0x00f9 }
            r2 = 2
            if (r0 != r2) goto L_0x00f9
            int r0 = r3.f1425j     // Catch:{ Exception -> 0x00f9 }
            int r2 = r3.k     // Catch:{ Exception -> 0x00f9 }
            r0 = r0 ^ r2
            r3.f1425j = r0     // Catch:{ Exception -> 0x00f9 }
            int r2 = r3.k     // Catch:{ Exception -> 0x00f9 }
            r2 = r2 ^ r0
            r3.k = r2     // Catch:{ Exception -> 0x00f9 }
            r0 = r0 ^ r2
            r3.f1425j = r0     // Catch:{ Exception -> 0x00f9 }
        L_0x00f9:
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r0 = r0.getAppChannel(r4)     // Catch:{ all -> 0x017b }
            r3.l = r0     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r0 = r0.getAppKey(r4)     // Catch:{ all -> 0x017b }
            r3.f1420e = r0     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0121 }
            int r0 = r0.getAppVersionCode(r4)     // Catch:{ Exception -> 0x0121 }
            r3.f1422g = r0     // Catch:{ Exception -> 0x0121 }
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0121 }
            java.lang.String r0 = r0.getAppVersionName(r4)     // Catch:{ Exception -> 0x0121 }
            r3.f1423h = r0     // Catch:{ Exception -> 0x0121 }
        L_0x0121:
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0136 }
            boolean r0 = r0.checkCellLocationSetting(r4)     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x0132
            java.lang.String r0 = com.baidu.mobstat.bw.i(r4)     // Catch:{ Exception -> 0x0136 }
            r3.p = r0     // Catch:{ Exception -> 0x0136 }
            goto L_0x0136
        L_0x0132:
            java.lang.String r0 = "0_0_0"
            r3.p = r0     // Catch:{ Exception -> 0x0136 }
        L_0x0136:
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x014b }
            boolean r0 = r0.checkGPSLocationSetting(r4)     // Catch:{ Exception -> 0x014b }
            if (r0 == 0) goto L_0x0147
            java.lang.String r0 = com.baidu.mobstat.bw.j(r4)     // Catch:{ Exception -> 0x014b }
            r3.q = r0     // Catch:{ Exception -> 0x014b }
            goto L_0x014b
        L_0x0147:
            java.lang.String r0 = ""
            r3.q = r0     // Catch:{ Exception -> 0x014b }
        L_0x014b:
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r0 = r0.getLinkedWay(r4)     // Catch:{ Exception -> 0x0155 }
            r3.r = r0     // Catch:{ Exception -> 0x0155 }
        L_0x0155:
            java.lang.String r0 = com.baidu.mobstat.bw.b()     // Catch:{ all -> 0x017b }
            r3.w = r0     // Catch:{ all -> 0x017b }
            java.lang.String r0 = android.os.Build.BOARD     // Catch:{ all -> 0x017b }
            r3.x = r0     // Catch:{ all -> 0x017b }
            java.lang.String r0 = android.os.Build.BRAND     // Catch:{ all -> 0x017b }
            r3.y = r0     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()     // Catch:{ all -> 0x017b }
            java.lang.String r0 = r0.getUserId(r4)     // Catch:{ all -> 0x017b }
            r3.C = r0     // Catch:{ all -> 0x017b }
            r3.f1416a = r1     // Catch:{ all -> 0x017b }
            com.baidu.mobstat.bq r0 = com.baidu.mobstat.bq.a()     // Catch:{ all -> 0x017b }
            java.lang.String r4 = r0.u(r4)     // Catch:{ all -> 0x017b }
            r3.E = r4     // Catch:{ all -> 0x017b }
            monitor-exit(r3)
            return
        L_0x017b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.HeadObject.a(android.content.Context):void");
    }

    public synchronized void installHeader(Context context, JSONObject jSONObject) {
        a(context);
        if (jSONObject.length() <= 10) {
            updateHeader(context, jSONObject);
        }
    }

    public void setHeaderExt(JSONObject jSONObject) {
        this.A = jSONObject;
    }

    public void setPushInfo(JSONObject jSONObject) {
        this.B = jSONObject;
    }

    public void setStartType(boolean z2) {
        if (z2) {
            this.D = 1;
        } else {
            this.D = 0;
        }
    }

    public void setUserId(String str) {
        this.C = str;
    }

    public void setUserProperty(String str) {
        this.E = str;
    }

    public void setZid(String str) {
        this.F = str;
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject.put(Config.OS, "Android");
            int i2 = 0;
            jSONObject.put(Config.STAT_SDK_TYPE, 0);
            jSONObject.put("s", this.f1417b == null ? "" : this.f1417b);
            jSONObject.put("sv", this.f1418c == null ? "" : this.f1418c);
            jSONObject.put(Config.APP_KEY, this.f1420e == null ? "" : this.f1420e);
            jSONObject.put(Config.PLATFORM_TYPE, this.f1419d == null ? "0" : this.f1419d);
            jSONObject.put("i", "");
            jSONObject.put("v", "3.9.7.1");
            jSONObject.put(Config.STAT_SDK_CHANNEL, 14);
            jSONObject.put(Config.APP_VERSION_CODE, this.f1422g);
            jSONObject.put("n", this.f1423h == null ? "" : this.f1423h);
            jSONObject.put("d", "");
            jSONObject.put(Config.DEVICE_MAC_ID, this.s == null ? "" : this.s);
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, this.u == null ? "" : this.u);
            jSONObject.put(Config.DEVICE_ID_SEC, this.f1424i == null ? "" : this.f1424i);
            jSONObject.put(Config.CUID_SEC, this.f1421f == null ? "" : this.f1421f);
            jSONObject.put(Config.SDK_TAG, 1);
            jSONObject.put(Config.DEVICE_WIDTH, this.f1425j);
            jSONObject.put("h", this.k);
            jSONObject.put(Config.DEVICE_NAME, this.v == null ? "" : this.v);
            jSONObject.put("c", this.l == null ? "" : this.l);
            jSONObject.put(Config.OPERATOR, this.m == null ? "" : this.m);
            jSONObject.put(Config.MODEL, this.n == null ? "" : this.n);
            jSONObject.put(Config.MANUFACTURER, this.o == null ? "" : this.o);
            jSONObject.put(Config.CELL_LOCATION, this.p == null ? "" : this.p);
            jSONObject.put(Config.GPS_LOCATION, this.q == null ? "" : this.q);
            jSONObject.put("l", this.r == null ? "" : this.r);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.PACKAGE_NAME, bw.h(1, context));
            jSONObject.put(Config.ROM, this.w == null ? "" : this.w);
            jSONObject.put(Config.DEVICE_BOARD, this.x == null ? "" : this.x);
            jSONObject.put(Config.DEVICE_BRAND, this.y == null ? "" : this.y);
            jSONObject.put(Config.TEST_DEVICE_ID, bw.b(context));
            String str = Config.TARGET_SDK_VERSION;
            if (context != null) {
                if (context.getApplicationInfo() != null) {
                    i2 = context.getApplicationInfo().targetSdkVersion;
                }
            }
            jSONObject.put(str, i2);
            jSONObject.put(Config.USER_PROPERTY, this.E);
            if (!TextUtils.isEmpty(this.C)) {
                if (!TextUtils.isEmpty(this.E)) {
                    jSONObject2 = new JSONObject(this.E);
                } else {
                    jSONObject2 = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.C);
                jSONArray.put("1");
                jSONObject2.put("uid_", jSONArray);
                jSONObject.put(Config.USER_PROPERTY, jSONObject2.toString());
            }
            jSONObject.put(Config.UID_CHANGE, "");
            jSONObject.put("at", "0");
            String u2 = bw.u(context);
            jSONObject.put(Config.PROCESS_LABEL, u2);
            String str2 = null;
            if (!TextUtils.isEmpty(u2)) {
                str2 = bw.v(context);
            }
            String str3 = Config.PROCESS_CLASS;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put(str3, str2);
            jSONObject.put("sign", this.z == null ? "" : this.z);
            if (this.A == null || this.A.length() == 0) {
                jSONObject.remove("ext");
            } else {
                jSONObject.put("ext", this.A);
            }
            if (this.B == null) {
                this.B = new JSONObject();
            }
            jSONObject.put(Config.PUSH, this.B);
            jSONObject.put("uid", this.C);
            jSONObject.put(Config.START_TYPE, String.valueOf(this.D));
        } catch (Exception unused) {
        }
    }
}
