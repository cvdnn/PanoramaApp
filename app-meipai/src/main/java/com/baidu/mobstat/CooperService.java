package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.bm.b;
import com.baidu.sapi2.SapiAccount;
import e.a.a.a.a;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService implements ICooperService {

    /* renamed from: a reason: collision with root package name */
    public static CooperService f1384a;

    /* renamed from: b reason: collision with root package name */
    public HeadObject f1385b = new HeadObject();

    public static String a(Context context) {
        String l = bw.l(context);
        return !TextUtils.isEmpty(l) ? l.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "") : l;
    }

    public static String b(Context context) {
        String k = bw.k(context);
        return !TextUtils.isEmpty(k) ? k.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "") : k;
    }

    public static String c(Context context) {
        String n = bw.n(context);
        return !TextUtils.isEmpty(n) ? n.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "") : n;
    }

    private String d(Context context) {
        String e2 = bq.a().e(context);
        if (!TextUtils.isEmpty(e2) && !e2.equals(Config.NULL_DEVICE_ID)) {
            return e2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new Date().getTime());
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder a2 = a.a("hol");
        a2.append(sb2.hashCode());
        a2.append("mes");
        String sb3 = a2.toString();
        bq.a().a(context, sb3);
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r4.f1385b.l.equals(r1) != false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String e(android.content.Context r5) {
        /*
            r4 = this;
            com.baidu.mobstat.HeadObject r0 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0012
            com.baidu.mobstat.HeadObject r0 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0044
        L_0x0012:
            com.baidu.mobstat.bq r0 = com.baidu.mobstat.bq.a()     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.g(r5)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0028
            com.baidu.mobstat.HeadObject r2 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            com.baidu.mobstat.bq r3 = com.baidu.mobstat.bq.a()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r3.f(r5)     // Catch:{ Exception -> 0x0044 }
            r2.l = r3     // Catch:{ Exception -> 0x0044 }
        L_0x0028:
            if (r0 == 0) goto L_0x003a
            com.baidu.mobstat.HeadObject r0 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x003a
            com.baidu.mobstat.HeadObject r0 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0044 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0044
        L_0x003a:
            com.baidu.mobstat.HeadObject r0 = r4.f1385b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "BaiduMobAd_CHANNEL"
            java.lang.String r5 = com.baidu.mobstat.bw.a(r5, r1)     // Catch:{ Exception -> 0x0044 }
            r0.l = r5     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            com.baidu.mobstat.HeadObject r5 = r4.f1385b
            java.lang.String r5 = r5.l
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.CooperService.e(android.content.Context):java.lang.String");
    }

    public static synchronized CooperService instance() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f1384a == null) {
                f1384a = new CooperService();
            }
            cooperService = f1384a;
        }
        return cooperService;
    }

    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_CELL_LOCATION));
    }

    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(bw.a(context, Config.GET_GPS_LOCATION));
    }

    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_WIFI_LOCATION));
    }

    public void enableDeviceMac(Context context, boolean z) {
        bq.a().d(context, z);
    }

    public String getAppChannel(Context context) {
        return e(context);
    }

    public String getAppKey(Context context) {
        HeadObject headObject = this.f1385b;
        if (headObject.f1420e == null) {
            headObject.f1420e = bw.a(context, Config.APPKEY_META_NAME);
        }
        return this.f1385b.f1420e;
    }

    public int getAppVersionCode(Context context) {
        HeadObject headObject = this.f1385b;
        if (headObject.f1422g == -1) {
            headObject.f1422g = bw.f(context);
        }
        return this.f1385b.f1422g;
    }

    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.f1385b.f1423h)) {
            this.f1385b.f1423h = bw.g(context);
        }
        return this.f1385b.f1423h;
    }

    public String getCUID(Context context, boolean z) {
        String str = "";
        bq.a().b(context, str);
        String str2 = this.f1385b.f1421f;
        if (str2 == null || str.equalsIgnoreCase(str2)) {
            try {
                this.f1385b.f1421f = bx.a(context);
                Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f1385b.f1421f);
                this.f1385b.f1421f = matcher.replaceAll(str);
                this.f1385b.f1421f = getSecretValue(this.f1385b.f1421f);
            } catch (Exception unused) {
            }
        }
        if (z) {
            return this.f1385b.f1421f;
        }
        try {
            String str3 = this.f1385b.f1421f;
            if (!TextUtils.isEmpty(str3)) {
                return new String(b.b(1, bp.a(str3.getBytes())));
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    public String getDevicImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(SapiAccount.f2185e)).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        if (!TextUtils.isEmpty(this.f1385b.f1424i)) {
            return this.f1385b.f1424i;
        }
        if (bq.a().i(context)) {
            this.f1385b.f1424i = getMacIdForTv(context);
            return this.f1385b.f1424i;
        }
        String t = bq.a().t(context);
        if (!TextUtils.isEmpty(t)) {
            this.f1385b.f1424i = t;
            return t;
        } else if (telephonyManager == null) {
            return this.f1385b.f1424i;
        } else {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    t = compile.matcher(deviceId).replaceAll("");
                }
            } catch (Exception unused) {
            }
            String str = Config.NULL_DEVICE_ID;
            if (t == null || t.equals(str)) {
                t = a(context);
            }
            if (bw.w(context) && (TextUtils.isEmpty(t) || t.equals(str))) {
                try {
                    t = c(context);
                } catch (Exception unused2) {
                }
            }
            if (TextUtils.isEmpty(t) || t.equals(str)) {
                t = d(context);
            }
            HeadObject headObject = this.f1385b;
            headObject.f1424i = t;
            headObject.f1424i = getSecretValue(t);
            return this.f1385b.f1424i;
        }
    }

    public HeadObject getHeadObject() {
        return this.f1385b;
    }

    public JSONObject getHeaderExt(Context context) {
        String k = bq.a().k(context);
        if (!TextUtils.isEmpty(k)) {
            try {
                return new JSONObject(k);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    public String getLastUserId(Context context) {
        return bq.a().r(context);
    }

    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.f1385b.r)) {
            this.f1385b.r = bw.r(context);
        }
        return this.f1385b.r;
    }

    public String getMTJSDKVersion() {
        return "3.9.7.1";
    }

    public String getMacAddress(Context context, boolean z) {
        String str = "";
        String replace = Config.DEF_MAC_ID.replace(Config.TRACE_TODAY_VISIT_SPLIT, str);
        if (!z) {
            return getSecretValue(replace);
        }
        if (!TextUtils.isEmpty(this.f1385b.s)) {
            return this.f1385b.s;
        }
        String h2 = bq.a().h(context);
        if (!TextUtils.isEmpty(h2)) {
            this.f1385b.s = h2;
            return h2;
        }
        String a2 = a(context, z);
        if (TextUtils.isEmpty(a2) || replace.equals(a2)) {
            this.f1385b.s = str;
            return str;
        }
        this.f1385b.s = getSecretValue(a2);
        bq.a().e(context, this.f1385b.s);
        return this.f1385b.s;
    }

    public String getMacIdForTv(Context context) {
        if (!TextUtils.isEmpty(this.f1385b.t)) {
            return this.f1385b.t;
        }
        String j2 = bq.a().j(context);
        if (!TextUtils.isEmpty(j2)) {
            this.f1385b.t = j2;
            return j2;
        }
        String c2 = bw.c(1, context);
        if (!TextUtils.isEmpty(c2)) {
            this.f1385b.t = c2;
            bq.a().f(context, c2);
            return this.f1385b.t;
        }
        String str = "";
        this.f1385b.t = str;
        return str;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f1385b.o)) {
            this.f1385b.o = Build.MANUFACTURER;
        }
        return this.f1385b.o;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.f1385b.f1418c)) {
            this.f1385b.f1418c = VERSION.RELEASE;
        }
        return this.f1385b.f1418c;
    }

    public String getOSVersion() {
        if (TextUtils.isEmpty(this.f1385b.f1417b)) {
            this.f1385b.f1417b = Integer.toString(VERSION.SDK_INT);
        }
        return this.f1385b.f1417b;
    }

    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.f1385b.m)) {
            this.f1385b.m = telephonyManager.getNetworkOperator();
        }
        return this.f1385b.m;
    }

    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.f1385b.n)) {
            this.f1385b.n = Build.MODEL;
        }
        return this.f1385b.n;
    }

    public String getPlainDeviceIdForCar(Context context) {
        String optUUID = CarUUID.optUUID(context);
        if (TextUtils.isEmpty(optUUID)) {
            optUUID = d(context);
        }
        return TextUtils.isEmpty(optUUID) ? "" : optUUID;
    }

    public JSONObject getPushId(Context context) {
        String l = bq.a().l(context);
        if (!TextUtils.isEmpty(l)) {
            try {
                return new JSONObject(l);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String getSecretValue(String str) {
        return b.c(1, str.getBytes());
    }

    public int getTagValue() {
        return 1;
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getUserId(Context context) {
        return bq.a().q(context);
    }

    public void installHeader(Context context, JSONObject jSONObject) {
        this.f1385b.installHeader(context, jSONObject);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return bq.a().m(context);
    }

    public void resetHeadSign() {
        this.f1385b.z = instance().getUUID();
    }

    public void setAppVersionName(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1385b.f1423h = str;
        }
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f1385b.setHeaderExt(jSONObject);
        bq.a().g(context, jSONObject.toString());
        if (extraInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set global ExtraInfo: ");
            sb.append(jSONObject);
            str = sb.toString();
        } else {
            str = "Clear global ExtraInfo";
        }
        bc.c().a(str);
    }

    public void setLastUserId(Context context, String str) {
        bq.a().j(context, str);
    }

    public void setPushId(Context context, String str, String str2, String str3) {
        String str4;
        JSONObject pushId = getPushId(context);
        if (pushId == null) {
            pushId = new JSONObject();
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                pushId.put(str, str3);
            } else {
                pushId.remove(str);
            }
        } catch (Exception unused) {
        }
        this.f1385b.setPushInfo(pushId);
        bq.a().h(context, pushId.toString());
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set platform:");
            sb.append(str2);
            sb.append(" pushId: ");
            sb.append(str3);
            str4 = sb.toString();
        } else {
            str4 = a.a("Clear platform:", str2, " pushId");
        }
        bc.c().a(str4);
    }

    public void setStartType(boolean z) {
        this.f1385b.setStartType(z);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        bq.a().i(context, str);
        this.f1385b.setUserId(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Set user id ");
        sb.append(str);
        bc.c().a(sb.toString());
    }

    public void setUserProperty(Context context, Map<String, String> map) {
        boolean z;
        String str = "";
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            try {
                bq.a().m(context, str);
                this.f1385b.setUserProperty(str);
            } catch (Exception e2) {
                bc c2 = bc.c();
                StringBuilder a2 = a.a("[Exception] ");
                a2.append(e2.getMessage());
                c2.c(a2.toString());
                e2.printStackTrace();
                z = false;
            }
        } else if (map.size() > 100) {
            bc.c().c("[WARNING] setUserProperty failed,map size can not over 100 !");
        } else {
            for (Entry entry : map.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str2)) {
                    if (str3 != null) {
                        if (str2.length() <= 256) {
                            if (TextUtils.isEmpty(str3) || str3.length() <= 256) {
                                jSONArray.put(str3);
                                jSONArray.put("1");
                                jSONObject.put(str2, jSONArray);
                            }
                        }
                        bc.c().c("[WARNING] setUserProperty failed,key or value can not over 256 bytes !");
                        return;
                    }
                }
                bc.c().c("[WARNING] setUserProperty failed,key or value can not null !");
                return;
            }
            z = true;
            if (z) {
                bq.a().m(context, jSONObject.toString());
                this.f1385b.setUserProperty(jSONObject.toString());
            }
        }
    }

    public void setZid(String str) {
    }

    private String a(Context context, boolean z) {
        String str;
        if (z) {
            str = b(context);
        } else {
            str = a(context);
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
