package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.StatService.WearListener;
import e.a.a.a.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataCore {

    /* renamed from: a reason: collision with root package name */
    public static JSONObject f1386a = new JSONObject();

    /* renamed from: b reason: collision with root package name */
    public static DataCore f1387b = new DataCore();

    /* renamed from: c reason: collision with root package name */
    public JSONArray f1388c = new JSONArray();

    /* renamed from: d reason: collision with root package name */
    public JSONArray f1389d = new JSONArray();

    /* renamed from: e reason: collision with root package name */
    public JSONArray f1390e = new JSONArray();

    /* renamed from: f reason: collision with root package name */
    public boolean f1391f = false;

    /* renamed from: g reason: collision with root package name */
    public volatile int f1392g = 0;

    /* renamed from: h reason: collision with root package name */
    public WearListener f1393h;

    /* renamed from: i reason: collision with root package name */
    public JSONObject f1394i;

    /* renamed from: j reason: collision with root package name */
    public Object f1395j = new Object();

    private void a(Context context, JSONObject jSONObject) {
    }

    private boolean a(String str) {
        return (BDStatCore.instance().getSessionSize() + str.getBytes().length) + this.f1392g > 184320;
    }

    private void b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject.length() != 0 && jSONObject2 != null && jSONObject2.length() != 0) {
            try {
                jSONObject.put(Config.LAUNCH, jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void b(JSONObject jSONObject) {
    }

    public static DataCore instance() {
        return f1387b;
    }

    public void clearCache(Context context) {
        a(false);
        synchronized (f1386a) {
            f1386a = new JSONObject();
        }
        installHeader(context);
        a(context);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String constructLogWithEmptyBody(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.baidu.mobstat.CooperService r2 = com.baidu.mobstat.CooperService.instance()
            com.baidu.mobstat.HeadObject r2 = r2.getHeadObject()
            java.lang.String r3 = r2.f1420e
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x001e
            r2.installHeader(r7, r1)
            goto L_0x0021
        L_0x001e:
            r2.updateHeader(r7, r1)
        L_0x0021:
            org.json.JSONArray r7 = new org.json.JSONArray
            r7.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
            java.lang.String r5 = "t"
            r1.put(r5, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = "ss"
            r1.put(r5, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "wl2"
            r1.put(r2, r7)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "sq"
            r3 = 0
            r1.put(r2, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "sign"
            com.baidu.mobstat.CooperService r3 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getUUID()     // Catch:{ Exception -> 0x006b }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "k"
            r1.put(r2, r8)     // Catch:{ Exception -> 0x006b }
            java.lang.String r8 = "he"
            r0.put(r8, r1)     // Catch:{ Exception -> 0x006b }
            java.lang.String r8 = "pr"
            r0.put(r8, r7)     // Catch:{  }
            java.lang.String r8 = "ev"
            r0.put(r8, r7)     // Catch:{  }
            java.lang.String r8 = "ex"
            r0.put(r8, r7)     // Catch:{  }
            java.lang.String r7 = r0.toString()
            return r7
        L_0x006b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.constructLogWithEmptyBody(android.content.Context, java.lang.String):java.lang.String");
    }

    public void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.f1388c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f1388c.toString()));
            }
            synchronized (this.f1389d) {
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.f1389d.toString()));
            }
            synchronized (f1386a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(f1386a.toString()));
            }
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (a()) {
            bc.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 184320) {
            a(true);
            return;
        }
        this.f1392g = length;
        StringBuilder a2 = a.a(bw.u(context));
        a2.append(Config.STAT_CACHE_FILE_NAME);
        bo.a(context, a2.toString(), jSONObject2, false);
        synchronized (this.f1390e) {
            bo.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f1390e.toString(), false);
        }
    }

    public int getCacheFileSzie() {
        return this.f1392g;
    }

    public JSONObject getLogData() {
        return this.f1394i;
    }

    public void init(Context context) {
        instance().loadStatData(context);
        instance().loadLastSession(context);
        instance().installHeader(context);
    }

    public void installHeader(Context context) {
        synchronized (f1386a) {
            CooperService.instance().getHeadObject().installHeader(context, f1386a);
        }
    }

    public void loadLastSession(Context context) {
        if (context != null) {
            StringBuilder a2 = a.a(bw.u(context));
            a2.append(Config.LAST_SESSION_FILE_NAME);
            String sb = a2.toString();
            if (bo.c(context, sb)) {
                String a3 = bo.a(context, sb);
                if (!TextUtils.isEmpty(a3)) {
                    bo.a(context, sb, new JSONObject().toString(), false);
                    putSession(a3);
                    flush(context);
                }
            }
        }
    }

    public void loadStatData(Context context) {
        if (context != null) {
            StringBuilder a2 = a.a(bw.u(context));
            a2.append(Config.STAT_CACHE_FILE_NAME);
            String sb = a2.toString();
            if (bo.c(context, sb)) {
                String a3 = bo.a(context, sb);
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(a3);
                    } catch (Exception unused) {
                    }
                    if (jSONObject != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                            if (jSONArray != null) {
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                    if (currentTimeMillis - jSONObject2.getLong("s") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                                        putSession(jSONObject2);
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
                            if (jSONArray2 != null) {
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                                    if (currentTimeMillis - jSONObject3.getLong("t") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                                        putEvent(context, jSONObject3);
                                    }
                                }
                            }
                        } catch (Exception unused3) {
                        }
                        try {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                            if (jSONObject4 != null) {
                                synchronized (f1386a) {
                                    f1386a = jSONObject4;
                                    if (TextUtils.isEmpty(bq.a().t(context))) {
                                        String string = f1386a.getString(Config.DEVICE_ID_SEC);
                                        if (!TextUtils.isEmpty(string)) {
                                            bq.a().l(context, string);
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused4) {
                        }
                    }
                }
            }
        }
    }

    public void loadWifiData(Context context) {
        if (context != null && bo.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray = new JSONArray(bo.a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray.length();
                if (length >= 10) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = length - 10; i2 < length; i2++) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                    jSONArray = jSONArray2;
                }
                String g2 = bw.g(1, context);
                if (!TextUtils.isEmpty(g2)) {
                    jSONArray.put(g2);
                }
                synchronized (this.f1390e) {
                    this.f1390e = jSONArray;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (a(jSONObject.toString())) {
                bc.c().b("[WARNING] data to put exceed limit, ignored");
                return;
            }
            synchronized (this.f1389d) {
                EventAnalysis.doEventMerge(this.f1389d, jSONObject);
            }
        }
    }

    public void putSession(Session session) {
        putSession(session.constructJSONObject());
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j2, boolean z3) {
        saveLogData(context, z, z2, j2, z3, null);
    }

    public void saveLogDataAndSendForRaven(Context context) {
        synchronized (this.f1395j) {
        }
    }

    public void sendDataForDueros(Context context) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void putSession(org.json.JSONObject r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r4.toString()
            boolean r0 = r3.a(r0)
            if (r0 == 0) goto L_0x0017
            com.baidu.mobstat.bc r4 = com.baidu.mobstat.bc.c()
            java.lang.String r0 = "[WARNING] data to put exceed limit, ignored"
            r4.b(r0)
            return
        L_0x0017:
            org.json.JSONArray r0 = r3.f1388c
            monitor-enter(r0)
            org.json.JSONArray r1 = r3.f1388c     // Catch:{ all -> 0x0027 }
            int r1 = r1.length()     // Catch:{ all -> 0x0027 }
            org.json.JSONArray r2 = r3.f1388c     // Catch:{ JSONException -> 0x0025 }
            r2.put(r1, r4)     // Catch:{ JSONException -> 0x0025 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.putSession(org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:66|67|68|69|70|71|72) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:74|75|76|77|78|79|80) */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0102, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0108, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0115 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x00ff */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0105 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveLogData(android.content.Context r9, boolean r10, boolean r11, long r12, boolean r14, org.json.JSONObject r15) {
        /*
            r8 = this;
            com.baidu.mobstat.CooperService r0 = com.baidu.mobstat.CooperService.instance()
            com.baidu.mobstat.HeadObject r0 = r0.getHeadObject()
            if (r0 == 0) goto L_0x0036
            org.json.JSONObject r1 = f1386a
            monitor-enter(r1)
            java.lang.String r2 = r0.f1420e     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x001b
            org.json.JSONObject r2 = f1386a     // Catch:{ all -> 0x0033 }
            r0.installHeader(r9, r2)     // Catch:{ all -> 0x0033 }
            goto L_0x0020
        L_0x001b:
            org.json.JSONObject r2 = f1386a     // Catch:{ all -> 0x0033 }
            r0.updateHeader(r9, r2)     // Catch:{ all -> 0x0033 }
        L_0x0020:
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.f1420e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0036
            com.baidu.mobstat.bc r9 = com.baidu.mobstat.bc.c()
            java.lang.String r10 = "[WARNING] 无法找到有效APP Key, 请参考文档配置"
            r9.c(r10)
            return
        L_0x0033:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r9
        L_0x0036:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = f1386a
            monitor-enter(r1)
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0117 }
            org.json.JSONObject r4 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = "at"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r5 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid"
            java.lang.String r5 = r5.optString(r6)     // Catch:{ Exception -> 0x0115 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0115 }
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "0"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x0115 }
            if (r4 == 0) goto L_0x0086
            com.baidu.mobstat.CooperService r4 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r4 = r4.getLastUserId(r9)     // Catch:{ Exception -> 0x0115 }
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0115 }
            if (r4 != 0) goto L_0x0076
            org.json.JSONObject r4 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid_change"
            r4.put(r6, r5)     // Catch:{ Exception -> 0x0115 }
            goto L_0x007f
        L_0x0076:
            org.json.JSONObject r4 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid_change"
            java.lang.String r7 = ""
            r4.put(r6, r7)     // Catch:{ Exception -> 0x0115 }
        L_0x007f:
            com.baidu.mobstat.CooperService r4 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0115 }
            r4.setLastUserId(r9, r5)     // Catch:{ Exception -> 0x0115 }
        L_0x0086:
            org.json.JSONObject r4 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = "t"
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r2 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = "sq"
            if (r10 == 0) goto L_0x0095
            r4 = 0
            goto L_0x0096
        L_0x0095:
            r4 = 1
        L_0x0096:
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r2 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = "ss"
            r2.put(r3, r12)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONArray r12 = r8.f1390e     // Catch:{ Exception -> 0x0115 }
            monitor-enter(r12)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r13 = f1386a     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "wl2"
            org.json.JSONArray r3 = r8.f1390e     // Catch:{ all -> 0x0112 }
            r13.put(r2, r3)     // Catch:{ all -> 0x0112 }
            monitor-exit(r12)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r12 = f1386a     // Catch:{ Exception -> 0x0115 }
            java.lang.String r13 = "sign"
            com.baidu.mobstat.CooperService r2 = com.baidu.mobstat.CooperService.instance()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r2.getUUID()     // Catch:{ Exception -> 0x0115 }
            r12.put(r13, r2)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r12 = f1386a     // Catch:{ Exception -> 0x0115 }
            r8.b(r9, r12, r15)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r12 = "he"
            org.json.JSONObject r13 = f1386a     // Catch:{ Exception -> 0x0115 }
            r0.put(r12, r13)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONArray r12 = r8.f1388c     // Catch:{ all -> 0x0117 }
            monitor-enter(r12)     // Catch:{ all -> 0x0117 }
            java.lang.String r13 = "pr"
            org.json.JSONArray r15 = r8.f1388c     // Catch:{ JSONException -> 0x010d }
            r0.put(r13, r15)     // Catch:{ JSONException -> 0x010d }
            org.json.JSONArray r13 = r8.f1389d     // Catch:{ all -> 0x010b }
            monitor-enter(r13)     // Catch:{ all -> 0x010b }
            java.lang.String r15 = "ev"
            org.json.JSONArray r2 = r8.f1389d     // Catch:{ JSONException -> 0x0105 }
            r0.put(r15, r2)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r15 = "ex"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ff }
            r2.<init>()     // Catch:{ JSONException -> 0x00ff }
            r0.put(r15, r2)     // Catch:{ JSONException -> 0x00ff }
            r8.a(r9, r0, r11)     // Catch:{ all -> 0x0103 }
            r8.b(r0)     // Catch:{ all -> 0x0103 }
            r8.a(r9, r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0103 }
            r8.a(r9, r11, r10, r14)     // Catch:{ all -> 0x0103 }
            r8.f1394i = r0     // Catch:{ all -> 0x0103 }
            r8.clearCache(r9)     // Catch:{ all -> 0x0103 }
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x00ff:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0103:
            r9 = move-exception
            goto L_0x0109
        L_0x0105:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0109:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            throw r9     // Catch:{ all -> 0x010b }
        L_0x010b:
            r9 = move-exception
            goto L_0x0110
        L_0x010d:
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0110:
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            throw r9     // Catch:{ all -> 0x0117 }
        L_0x0112:
            r9 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0112 }
            throw r9     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0117:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.saveLogData(android.content.Context, boolean, boolean, long, boolean, org.json.JSONObject):void");
    }

    private void a(boolean z) {
        this.f1391f = z;
    }

    private boolean a() {
        return this.f1391f;
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            boolean z2 = true;
            try {
                jSONObject2.put(Config.TRACE_APPLICATION_SESSION, z ? 1 : 0);
            } catch (Exception unused) {
            }
            try {
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception unused2) {
            }
            try {
                jSONObject2.put(Config.TRACE_CIRCLE, af.c());
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put(Config.TRACE_PART, jSONObject2);
            } catch (Exception unused4) {
                z2 = false;
            }
            if (z2) {
                a(context, jSONObject, jSONObject2);
            }
        }
    }

    public void putSession(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r7, org.json.JSONObject r8, org.json.JSONObject r9) {
        /*
            r6 = this;
            int r5 = r6.a(r8)
            r0 = 0
            java.lang.String r2 = "he"
            org.json.JSONObject r8 = r8.getJSONObject(r2)     // Catch:{ Exception -> 0x0015 }
            if (r8 == 0) goto L_0x0015
            java.lang.String r2 = "ss"
            long r2 = r8.getLong(r2)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x0020
            long r0 = java.lang.System.currentTimeMillis()
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r2
        L_0x0021:
            r0 = r6
            r1 = r7
            r2 = r9
            r0.a(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(android.content.Context, org.json.JSONObject, org.json.JSONObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[Catch:{ Exception -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(org.json.JSONObject r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.lang.String r3 = "he"
            org.json.JSONObject r3 = r10.getJSONObject(r3)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r4 = "sq"
            long r4 = r3.getLong(r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r6 = "ss"
            long r6 = r3.getLong(r6)     // Catch:{ Exception -> 0x0022 }
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            int r3 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = r0
        L_0x0023:
            java.lang.String r4 = "pr"
            org.json.JSONArray r10 = r10.getJSONArray(r4)     // Catch:{ Exception -> 0x0056 }
            if (r10 == 0) goto L_0x0056
            int r4 = r10.length()     // Catch:{ Exception -> 0x0056 }
            if (r4 == 0) goto L_0x0056
        L_0x0031:
            int r4 = r10.length()     // Catch:{ Exception -> 0x0056 }
            if (r0 >= r4) goto L_0x0056
            java.lang.Object r4 = r10.get(r0)     // Catch:{ Exception -> 0x0056 }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = "c"
            long r5 = r4.getLong(r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r7 = "e"
            long r7 = r4.getLong(r7)     // Catch:{ Exception -> 0x0056 }
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0053
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x0053
            int r3 = r3 + 1
        L_0x0053:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x0056:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(org.json.JSONObject):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0 A[SYNTHETIC, Splitter:B:27:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8 A[SYNTHETIC, Splitter:B:40:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012d A[SYNTHETIC, Splitter:B:55:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r15, org.json.JSONObject r16, long r17, int r19) {
        /*
            r14 = this;
            r6 = r14
            r7 = r15
            r8 = r16
            r0 = r17
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            java.lang.Long r2 = r2.b(r15)
            long r2 = r2.longValue()
            r4 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x0022
            if (r19 == 0) goto L_0x0022
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            r2.a(r15, r0)
            r2 = r0
        L_0x0022:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "first"
            r14.a(r8, r3, r2)
            if (r19 == 0) goto L_0x0058
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            java.lang.Long r2 = r2.c(r15)
            long r2 = r2.longValue()
            long r9 = r0 - r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0046
            int r3 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0046
            r9 = -1
            goto L_0x0049
        L_0x0046:
            if (r2 != 0) goto L_0x0049
            r9 = r4
        L_0x0049:
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            r2.b(r15, r0)
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            r2.c(r15, r9)
            goto L_0x0064
        L_0x0058:
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            java.lang.Long r2 = r2.d(r15)
            long r9 = r2.longValue()
        L_0x0064:
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            java.lang.String r3 = "session_last_interval"
            r14.a(r8, r3, r2)
            com.baidu.mobstat.ae r2 = com.baidu.mobstat.ae.a()
            java.lang.String r2 = r2.e(r15)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r9 = 0
            java.lang.String r10 = ""
            java.lang.String r11 = ":"
            if (r3 != 0) goto L_0x0099
            boolean r3 = r2.contains(r11)
            if (r3 == 0) goto L_0x0099
            java.lang.String[] r2 = r2.split(r11)
            if (r2 == 0) goto L_0x0099
            int r3 = r2.length
            r12 = 2
            if (r3 != r12) goto L_0x0099
            r10 = r2[r9]
            r3 = 1
            r2 = r2[r3]
            r13 = r10
            r10 = r2
            r2 = r13
            goto L_0x009a
        L_0x0099:
            r2 = r10
        L_0x009a:
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 != 0) goto L_0x00a8
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00a8 }
            int r9 = r3.intValue()     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            java.lang.String r0 = com.baidu.mobstat.bx.a(r17)
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x00bc
            boolean r1 = r0.equals(r2)
            if (r1 == 0) goto L_0x00b9
            goto L_0x00bc
        L_0x00b9:
            r1 = r19
            goto L_0x00be
        L_0x00bc:
            int r1 = r19 + r9
        L_0x00be:
            if (r19 == 0) goto L_0x00d9
            com.baidu.mobstat.ae r3 = com.baidu.mobstat.ae.a()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            r3.a(r15, r10)
        L_0x00d9:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "session_today_cnt"
            r14.a(r8, r3, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x00f2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00f2 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x00f2 }
            long r10 = (long) r1
            goto L_0x00f3
        L_0x00f2:
            r10 = r4
        L_0x00f3:
            int r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            java.lang.String r12 = "recent"
            if (r1 == 0) goto L_0x011e
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x011e
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x011e
            if (r19 == 0) goto L_0x011e
            long r4 = (long) r9
            r0 = r14
            r1 = r15
            r2 = r10
            org.json.JSONArray r0 = r0.a(r1, r2, r4)
            com.baidu.mobstat.ae r1 = com.baidu.mobstat.ae.a()
            java.lang.String r2 = r0.toString()
            r1.b(r15, r2)
            r14.a(r8, r12, r0)
            goto L_0x013d
        L_0x011e:
            com.baidu.mobstat.ae r0 = com.baidu.mobstat.ae.a()
            java.lang.String r0 = r0.f(r15)
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0133
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x0133 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0133 }
            r1 = r2
        L_0x0133:
            if (r1 != 0) goto L_0x013a
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
        L_0x013a:
            r14.a(r8, r12, r1)
        L_0x013d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(android.content.Context, org.json.JSONObject, long, int):void");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONArray a(android.content.Context r7, long r8, long r10) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.baidu.mobstat.ae r1 = com.baidu.mobstat.ae.a()
            java.lang.String r7 = r1.f(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 0
            if (r1 != 0) goto L_0x0032
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0032 }
            int r7 = r1.length()     // Catch:{ Exception -> 0x0032 }
            if (r7 == 0) goto L_0x0032
            r7 = r2
        L_0x0020:
            int r3 = r1.length()     // Catch:{ Exception -> 0x0032 }
            if (r7 >= r3) goto L_0x0032
            java.lang.Object r3 = r1.get(r7)     // Catch:{ Exception -> 0x0032 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x0032 }
            r0.add(r3)     // Catch:{ Exception -> 0x0032 }
            int r7 = r7 + 1
            goto L_0x0020
        L_0x0032:
            java.util.Iterator r7 = r0.iterator()
        L_0x0036:
            boolean r1 = r7.hasNext()
            java.lang.String r3 = "day"
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r7.next()
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            long r4 = r1.getLong(r3)     // Catch:{ Exception -> 0x0036 }
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0036
            goto L_0x004e
        L_0x004d:
            r2 = 1
        L_0x004e:
            if (r2 == 0) goto L_0x0060
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0060 }
            r7.<init>()     // Catch:{ Exception -> 0x0060 }
            r7.put(r3, r8)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r8 = "count"
            r7.put(r8, r10)     // Catch:{ Exception -> 0x0060 }
            r0.add(r7)     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            int r7 = r0.size()
            r8 = 5
            if (r7 <= r8) goto L_0x006d
            int r8 = r7 + -5
            java.util.List r0 = r0.subList(r8, r7)
        L_0x006d:
            org.json.JSONArray r7 = new org.json.JSONArray
            r7.<init>(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(android.content.Context, long, long):org.json.JSONArray");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "visit"
            boolean r1 = r3.has(r0)
            if (r1 != 0) goto L_0x0013
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0013 }
            r3.put(r0, r1)     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            java.lang.Object r3 = r3.get(r0)     // Catch:{ Exception -> 0x001c }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x001c }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.a(org.json.JSONObject, java.lang.String, java.lang.Object):void");
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        WearListener wearListener = this.f1393h;
        if (wearListener == null || !wearListener.onSendLogData(str)) {
            boolean z3 = false;
            LogSender.instance().saveLogData(context, str, false);
            bc c2 = bc.c();
            StringBuilder sb = new StringBuilder();
            sb.append("Save log: ");
            sb.append(str);
            c2.a(sb.toString());
            if (z) {
                av.a(context);
            } else {
                if (aw.a().b() == 0 && aw.a().c()) {
                    z3 = true;
                }
                av.a(context, z3);
            }
            return;
        }
        bc c3 = bc.c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Log has been passed to app level, log: ");
        sb2.append(str);
        c3.a(sb2.toString());
    }

    private void a(Context context) {
        synchronized (this.f1389d) {
            this.f1389d = new JSONArray();
        }
        synchronized (this.f1388c) {
            this.f1388c = new JSONArray();
        }
        synchronized (this.f1390e) {
            this.f1390e = new JSONArray();
        }
        flush(context);
    }
}
