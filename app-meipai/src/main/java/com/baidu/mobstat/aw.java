package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.Config.EventViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aw {

    /* renamed from: b reason: collision with root package name */
    public static aw f1640b = new aw();

    /* renamed from: a reason: collision with root package name */
    public a f1641a;

    /* renamed from: c reason: collision with root package name */
    public HandlerThread f1642c = new HandlerThread("fullTraceHandleThread");

    /* renamed from: d reason: collision with root package name */
    public Handler f1643d;

    /* renamed from: e reason: collision with root package name */
    public volatile int f1644e;

    /* renamed from: f reason: collision with root package name */
    public int f1645f;

    /* renamed from: g reason: collision with root package name */
    public JSONObject f1646g = new JSONObject();

    /* renamed from: h reason: collision with root package name */
    public JSONArray f1647h = new JSONArray();

    /* renamed from: i reason: collision with root package name */
    public JSONArray f1648i = new JSONArray();

    /* renamed from: j reason: collision with root package name */
    public JSONArray f1649j = new JSONArray();
    public JSONArray k = new JSONArray();
    public boolean l = false;

    public interface a {
        void a(JSONObject jSONObject);
    }

    public aw() {
        this.f1642c.start();
        this.f1642c.setPriority(10);
        this.f1643d = new Handler(this.f1642c.getLooper());
    }

    private void b(JSONObject jSONObject) {
    }

    private void d(Context context) {
        this.f1648i = b(this.f1648i, BDStatCore.instance().getPageSessionHead());
        b(context, false);
        d();
    }

    private void e() {
        this.f1645f = 0;
    }

    public boolean c() {
        return this.l;
    }

    public int b() {
        return this.f1645f;
    }

    public void c(Context context, boolean z) {
        this.f1646g = new JSONObject();
        b(context);
        this.f1648i = new JSONArray();
        this.f1647h = new JSONArray();
        this.f1649j = new JSONArray();
        this.k = new JSONArray();
        if (!z) {
            au.a().b();
        }
        c(context);
    }

    public void b(Context context, boolean z) {
        if (z) {
            e();
        } else {
            d();
        }
        try {
            b(context, this.f1646g);
        } catch (Exception unused) {
        }
        if (this.f1647h.length() != 0 || this.f1648i.length() != 0 || this.f1649j.length() != 0 || this.k.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.HEADER_PART, this.f1646g);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put(Config.PRINCIPAL_PART, this.f1648i);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put(Config.EVENT_PART, this.f1647h);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put(Config.FEED_LIST_PART, this.f1649j);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("sv", this.k);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1638b));
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1637a));
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put(Config.FEED_LIST_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1639c));
            } catch (Exception unused9) {
            }
            c(context, jSONObject);
            b(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (bh.c().b()) {
                bh c2 = bh.c();
                StringBuilder sb = new StringBuilder();
                sb.append("saveCurrentCacheToSend content: ");
                sb.append(jSONObject2);
                c2.a(sb.toString());
            }
            b(context, jSONObject2);
            c(context, !z);
            this.l = true;
        }
    }

    private void d() {
        this.f1645f++;
    }

    private void d(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (bh.c().b()) {
                bh c2 = bh.c();
                StringBuilder a2 = e.a.a.a.a.a("putPage: ");
                a2.append(jSONObject.toString());
                c2.a(a2.toString());
            }
            String jSONObject2 = jSONObject.toString();
            if (a(context, jSONObject2)) {
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    StringBuilder a3 = e.a.a.a.a.a("checkExceedLogLimit exceed:true; mCacheLogSize: ");
                    a3.append(this.f1644e);
                    a3.append("; addedSize:");
                    a3.append(jSONObject2.length());
                    c3.a(a3.toString());
                }
                d(context);
            }
            a(this.f1648i, jSONObject);
        }
    }

    public static aw a() {
        return f1640b;
    }

    public void a(Context context) {
        if (context != null) {
            this.l = true;
            e();
            StringBuilder a2 = e.a.a.a.a.a(bw.u(context));
            a2.append(Config.STAT_FULL_CACHE_FILE_NAME);
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
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray(Config.EVENT_PART);
                            JSONArray optJSONArray2 = jSONObject.optJSONArray(Config.PRINCIPAL_PART);
                            JSONArray optJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("sv");
                            if ((optJSONArray == null || optJSONArray.length() == 0) && ((optJSONArray2 == null || optJSONArray2.length() == 0) && (optJSONArray3 == null || optJSONArray3.length() == 0))) {
                                if (optJSONArray4 != null) {
                                    if (optJSONArray4.length() == 0) {
                                    }
                                }
                                if (bh.c().b()) {
                                    bh.c().a("saveLastCacheToSend content:empty, return");
                                }
                                return;
                            }
                            b(context, jSONObject.getJSONObject(Config.HEADER_PART));
                            c(context, jSONObject);
                            b(jSONObject);
                            a3 = jSONObject.toString();
                        } catch (Exception unused2) {
                        }
                        if (bh.c().b()) {
                            bh c2 = bh.c();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("saveLastCacheToSend content: ");
                            sb2.append(a3);
                            c2.a(sb2.toString());
                        }
                        b(context, a3);
                        c(context, false);
                        this.l = false;
                    }
                }
            }
        }
    }

    public void c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, new JSONObject(this.f1646g.toString()));
            jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f1648i.toString()));
            jSONObject.put(Config.EVENT_PART, new JSONArray(this.f1647h.toString()));
            jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.f1649j.toString()));
            jSONObject.put("sv", new JSONArray(this.k.toString()));
            jSONObject.put(Config.EVENT_PAGE_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1638b));
            jSONObject.put(Config.EVENT_PATH_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1637a));
            jSONObject.put(Config.FEED_LIST_MAPPING, au.a().a(com.baidu.mobstat.au.a.f1639c));
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.getBytes().length;
        if (length < 184320) {
            this.f1644e = length;
            StringBuilder a2 = e.a.a.a.a.a(bw.u(context));
            a2.append(Config.STAT_FULL_CACHE_FILE_NAME);
            bo.a(context, a2.toString(), jSONObject2, false);
        }
    }

    /* access modifiers changed from: private */
    public void d(Context context, ArrayList<aq> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aq aqVar = (aq) it.next();
                JSONObject a2 = aqVar.a(au.a().a(aqVar.b(), com.baidu.mobstat.au.a.f1638b), au.a().a(aqVar.f(), com.baidu.mobstat.au.a.f1639c), bj.c(aqVar.c()));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            b(context, jSONArray);
            c(context);
        }
    }

    public void b(Context context) {
        CooperService.instance().getHeadObject().installHeader(context, this.f1646g);
    }

    private void b(Context context, JSONObject jSONObject) {
        CooperService.instance().getHeadObject().installHeader(context, jSONObject);
        try {
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.SEQUENCE_INDEX, this.f1645f);
            jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
            jSONObject.put("at", "1");
            jSONObject.put("sign", CooperService.instance().getUUID());
        } catch (Exception unused) {
        }
    }

    private void c(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(Config.TRACE_PART, jSONObject2);
            } catch (Exception unused2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Context context, ArrayList<ap> arrayList) {
        if (context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ap apVar = (ap) it.next();
                JSONObject a2 = apVar.a(au.a().a(apVar.a(), com.baidu.mobstat.au.a.f1639c));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a(context, jSONArray);
            c(context);
        }
    }

    private void b(Context context, String str) {
        LogSender.instance().saveLogData(context, str, true);
        if (this.f1641a != null) {
            try {
                this.f1641a.a(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    public void a(Context context, String str, String str2, int i2, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, JSONObject jSONObject, String str6) {
        a(context, str, str2, i2, j2, str3, jSONArray, str4, jSONArray2, str5, map, false, jSONObject, str6);
    }

    public void a(Context context, String str, String str2, int i2, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        final Context context2 = context;
        final String str7 = str;
        final String str8 = str2;
        final int i3 = i2;
        final long j3 = j2;
        final String str9 = str3;
        final JSONArray jSONArray3 = jSONArray;
        final String str10 = str4;
        final JSONArray jSONArray4 = jSONArray2;
        final String str11 = str5;
        final Map<String, String> map2 = map;
        final boolean z2 = z;
        final JSONObject jSONObject2 = jSONObject;
        final String str12 = str6;
        Handler handler = this.f1643d;
        AnonymousClass1 r19 = r0;
        AnonymousClass1 r0 = new Runnable(this) {
            public final /* synthetic */ aw o;

            {
                this.o = r4;
            }

            public void run() {
                long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                if (sessionStartTime > 0) {
                    this.o.a(context2, sessionStartTime, str7, str8, i3, j3, str9, jSONArray3, str10, jSONArray4, str11, map2, z2, jSONObject2, str12);
                }
            }
        };
        handler.post(r19);
    }

    /* access modifiers changed from: private */
    public void a(Context context, long j2, String str, String str2, int i2, long j3, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        boolean z2 = z;
        JSONObject jSONObject2 = jSONObject;
        String str7 = str6;
        String str8 = "";
        a(context, EventAnalysis.getEvent(context, j2, str, str2, i2, j3, 0, str8, null, null, bj.a(str3), bj.a(str4), str5, EventViewType.EDIT.getValue(), 3, null, map, bj.c(jSONArray), bj.d(jSONArray2), z2, jSONObject2, str7));
        c(context);
    }

    public void b(final Context context, final ArrayList<aq> arrayList) {
        this.f1643d.post(new Runnable() {
            public void run() {
                aw.this.d(context, arrayList);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(Context context, ao aoVar) {
        if (!(context == null || aoVar == null)) {
            JSONArray b2 = b(this.f1648i, BDStatCore.instance().getPageSessionHead());
            this.f1648i = b2;
            if (b2.length() != 0) {
                long a2 = a(this.f1648i);
                if (a2 > 0) {
                    d(context, aoVar.a(a2, au.a().a(aoVar.a(), com.baidu.mobstat.au.a.f1638b), au.a().a(aoVar.b(), com.baidu.mobstat.au.a.f1639c)));
                    c(context);
                }
            }
        }
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (bh.c().b()) {
                bh c2 = bh.c();
                StringBuilder a2 = e.a.a.a.a.a("putEvent: ");
                a2.append(jSONObject.toString());
                c2.a(a2.toString());
            }
            String jSONObject2 = jSONObject.toString();
            if (a(context, jSONObject2)) {
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    StringBuilder a3 = e.a.a.a.a.a("checkExceedLogLimit exceed:true; mCacheLogSize: ");
                    a3.append(this.f1644e);
                    a3.append("; addedSize:");
                    a3.append(jSONObject2.length());
                    c3.a(a3.toString());
                }
                d(context);
            }
            EventAnalysis.doEventMerge(this.f1647h, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC, Splitter:B:30:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONArray b(org.json.JSONArray r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x0060
            if (r5 != 0) goto L_0x0005
            goto L_0x0060
        L_0x0005:
            java.lang.String r0 = "s"
            long r0 = r6.optLong(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0012
            return r5
        L_0x0012:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            int r1 = r5.length()
            java.lang.String r2 = "p"
            r3 = 0
            if (r1 != 0) goto L_0x003a
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0033 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0033 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0033 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0032 }
            r5.<init>()     // Catch:{ Exception -> 0x0032 }
            r6.put(r2, r5)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r3 = r6
        L_0x0033:
            r6 = r3
        L_0x0034:
            if (r6 == 0) goto L_0x005f
            r0.put(r6)
            goto L_0x005f
        L_0x003a:
            r1 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r1)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0041
        L_0x0040:
            r5 = r3
        L_0x0041:
            if (r5 == 0) goto L_0x0048
            org.json.JSONArray r5 = r5.getJSONArray(r2)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0049
        L_0x0048:
            r5 = r3
        L_0x0049:
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0059 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0059 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0059 }
            if (r5 == 0) goto L_0x005a
            r1.put(r2, r5)     // Catch:{ Exception -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            r3 = r1
        L_0x0059:
            r1 = r3
        L_0x005a:
            if (r1 == 0) goto L_0x005f
            r0.put(r1)
        L_0x005f:
            return r0
        L_0x0060:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.aw.b(org.json.JSONArray, org.json.JSONObject):org.json.JSONArray");
    }

    private boolean a(Context context, String str) {
        if ((str != null ? str.getBytes().length : 0) + this.f1644e > 184320) {
            return true;
        }
        return false;
    }

    public void a(final Context context, final boolean z) {
        this.f1643d.post(new Runnable() {
            public void run() {
                aw.this.b(context, z);
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        this.f1643d.post(new Runnable() {
            public void run() {
                JSONObject jSONObject = jSONObject;
                if (jSONObject != null && jSONObject.length() != 0) {
                    aw awVar = aw.this;
                    awVar.f1648i = awVar.b(awVar.f1648i, jSONObject);
                }
            }
        });
    }

    public void a(final Context context, final ao aoVar) {
        this.f1643d.post(new Runnable() {
            public void run() {
                if (BDStatCore.instance().getSessionStartTime() > 0) {
                    aw.this.b(context, aoVar);
                }
            }
        });
    }

    public void a(final Context context, final ArrayList<ap> arrayList) {
        this.f1643d.post(new Runnable() {
            public void run() {
                aw.this.c(context, arrayList);
            }
        });
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray2 = null;
        try {
            jSONObject2 = jSONArray.getJSONObject(0);
        } catch (Exception unused) {
            jSONObject2 = null;
        }
        String str = "p";
        if (jSONObject2 != null) {
            try {
                jSONArray2 = jSONObject2.optJSONArray(str);
            } catch (Exception unused2) {
            }
        }
        if (jSONArray2 == null) {
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put(str, jSONArray3);
                } catch (Exception unused3) {
                }
            }
        } else {
            jSONArray2.put(jSONObject);
        }
    }

    private void b(Context context, JSONArray jSONArray) {
        if (context != null && this.k != null && jSONArray != null && jSONArray.length() != 0) {
            if (bh.c().b()) {
                bh c2 = bh.c();
                StringBuilder a2 = e.a.a.a.a.a("putFeedListItem: ");
                a2.append(jSONArray.toString());
                c2.a(a2.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (a(context, jSONArray2)) {
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    StringBuilder a3 = e.a.a.a.a.a("checkExceedLogLimit exceed:true; mCacheLogSize: ");
                    a3.append(this.f1644e);
                    a3.append("; addedSize:");
                    a3.append(jSONArray2.length());
                    c3.a(a3.toString());
                }
                d(context);
            }
            b(this.k, jSONArray);
        }
    }

    private long a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return 0;
        }
        try {
            return jSONArray.getJSONObject(0).optLong("s");
        } catch (Exception unused) {
            return 0;
        }
    }

    private void a(Context context, JSONArray jSONArray) {
        if (context != null && this.f1649j != null && jSONArray != null && jSONArray.length() != 0) {
            if (bh.c().b()) {
                bh c2 = bh.c();
                StringBuilder a2 = e.a.a.a.a.a("putFeedList: ");
                a2.append(jSONArray.toString());
                c2.a(a2.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (a(context, jSONArray2)) {
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    StringBuilder a3 = e.a.a.a.a.a("checkExceedLogLimit exceed:true; mCacheLogSize: ");
                    a3.append(this.f1644e);
                    a3.append("; addedSize:");
                    a3.append(jSONArray2.length());
                    c3.a(a3.toString());
                }
                d(context);
            }
            a(this.f1649j, jSONArray);
        }
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            int i2 = 0;
            while (i2 < jSONArray2.length()) {
                try {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                    if (jSONObject != null) {
                        if (jSONObject.length() != 0) {
                            JSONObject jSONObject2 = null;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= jSONArray.length()) {
                                    break;
                                }
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                                if (jSONObject3 != null) {
                                    if (jSONObject3.length() != 0) {
                                        if (a(jSONObject3, jSONObject)) {
                                            jSONObject2 = jSONObject3;
                                            break;
                                        }
                                    }
                                }
                                i3++;
                            }
                            if (jSONObject2 == null) {
                                jSONArray.put(jSONObject);
                            } else {
                                b(jSONObject2, jSONObject);
                            }
                        }
                    }
                    i2++;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            int i2 = 0;
            while (i2 < jSONArray2.length()) {
                try {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                    i2++;
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        String str3;
        String[] strArr;
        long j2;
        int i2;
        long j3;
        String[] strArr2;
        String str4;
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = jSONObject2;
        String str5 = "d";
        String optString = jSONObject3.optString(str5);
        String str6 = "c";
        int optInt = jSONObject3.optInt(str6);
        String str7 = "t";
        long optLong = jSONObject3.optLong(str7);
        String str8 = "ps";
        String optString2 = jSONObject3.optString(str8);
        String optString3 = jSONObject4.optString(str5);
        int optInt2 = jSONObject4.optInt(str6);
        long optLong2 = jSONObject4.optLong(str7);
        String optString4 = jSONObject4.optString(str8);
        int i3 = optInt + optInt2;
        int i4 = (optLong > optLong2 ? 1 : (optLong == optLong2 ? 0 : -1));
        long j4 = i4 <= 0 ? optLong : optLong2;
        String str9 = "|";
        if (i4 <= 0) {
            str = e.a.a.a.a.a(optString, str9, optString3);
        } else {
            str = e.a.a.a.a.a(optString3, str9, optString);
        }
        String str10 = "\\|";
        long j5 = 0;
        if (i4 <= 0) {
            long j6 = optLong2 - optLong;
            StringBuilder sb = new StringBuilder();
            String[] split = optString4.split(str10);
            if (split == null || split.length == 0) {
                str2 = str8;
                try {
                    j5 = Long.valueOf(optString4).longValue();
                } catch (Exception unused) {
                }
                sb.append(j6 + j5);
            } else {
                int length = split.length;
                int i5 = 0;
                while (i5 < length) {
                    String str11 = split[i5];
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append(str9);
                    }
                    try {
                        j3 = Long.valueOf(str11).longValue();
                        strArr2 = split;
                        str4 = str8;
                    } catch (Exception unused2) {
                        strArr2 = split;
                        str4 = str8;
                        j3 = 0;
                    }
                    sb.append(j3 + j6);
                    i5++;
                    str8 = str4;
                    split = strArr2;
                }
                str2 = str8;
            }
            StringBuilder b2 = e.a.a.a.a.b(optString2, str9);
            b2.append(sb.toString());
            str3 = b2.toString();
        } else {
            str2 = str8;
            long j7 = optLong - optLong2;
            StringBuilder sb2 = new StringBuilder();
            String[] split2 = optString2.split(str10);
            if (split2 == null || split2.length == 0) {
                try {
                    j5 = Long.valueOf(optString2).longValue();
                } catch (Exception unused3) {
                }
                sb2.append(j7 + j5);
            } else {
                int length2 = split2.length;
                int i6 = 0;
                while (i6 < length2) {
                    String str12 = split2[i6];
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append(str9);
                    }
                    try {
                        j2 = Long.valueOf(str12).longValue();
                        i2 = length2;
                        strArr = split2;
                    } catch (Exception unused4) {
                        i2 = length2;
                        strArr = split2;
                        j2 = 0;
                    }
                    sb2.append(j2 + j7);
                    i6++;
                    split2 = strArr;
                    length2 = i2;
                }
            }
            StringBuilder b3 = e.a.a.a.a.b(optString4, str9);
            b3.append(sb2.toString());
            str3 = b3.toString();
        }
        try {
            jSONObject3.put(str6, i3);
            jSONObject3.put(str7, j4);
            jSONObject3.put(str5, str);
            jSONObject3.put(str2, str3);
        } catch (Exception unused5) {
        }
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = jSONObject2;
        if (jSONObject3 == null || jSONObject4 == null) {
            return false;
        }
        String str = "id";
        String optString = jSONObject3.optString(str);
        String str2 = "d";
        jSONObject3.optString(str2);
        String str3 = "p";
        String optString2 = jSONObject3.optString(str3);
        String str4 = "path";
        String optString3 = jSONObject3.optString(str4);
        String str5 = "title";
        String optString4 = jSONObject3.optString(str5);
        String str6 = "index";
        String optString5 = jSONObject3.optString(str6);
        String str7 = "n";
        String optString6 = jSONObject3.optString(str7);
        String str8 = "user";
        String str9 = optString5;
        int optInt = jSONObject3.optInt(str8);
        String str10 = "c";
        jSONObject3.optInt(str10);
        String str11 = optString4;
        String str12 = "t";
        jSONObject3.optLong(str12);
        String str13 = optString3;
        String str14 = "ps";
        jSONObject3.optString(str14);
        String optString7 = jSONObject4.optString(str);
        jSONObject4.optString(str2);
        String optString8 = jSONObject4.optString(str3);
        String optString9 = jSONObject4.optString(str4);
        String optString10 = jSONObject4.optString(str5);
        String optString11 = jSONObject4.optString(str6);
        String optString12 = jSONObject4.optString(str7);
        int optInt2 = jSONObject4.optInt(str8);
        jSONObject4.optInt(str10);
        jSONObject4.optLong(str12);
        jSONObject4.optString(str14);
        if (!a(optString, optString7)) {
            return false;
        }
        if (a(optString2, optString8) && a(str13, optString9) && a(str11, optString10) && a(str9, optString11) && a(optString6, optString12) && optInt == optInt2) {
            return true;
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2);
    }
}
