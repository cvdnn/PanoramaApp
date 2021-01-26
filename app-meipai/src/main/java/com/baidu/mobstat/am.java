package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.baidu.picapture.model.device.LanguageUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class am {
    public static final am B = new am();
    public bf A = bf.a();
    public Handler C = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 32:
                    am.this.b();
                    return;
                case 33:
                    am.this.c();
                    return;
                case 34:
                    am.this.h();
                    return;
                default:
                    return;
            }
        }
    };
    public com.baidu.mobstat.ak.a D = new com.baidu.mobstat.ak.a() {
        public void a() {
            if (bd.c().b()) {
                bd.c().a("onGesture");
            }
            am.this.i();
        }
    };
    public boolean E = true;
    public JSONArray F = new JSONArray();
    public Object G = new Object();

    /* renamed from: a reason: collision with root package name */
    public Context f1532a;

    /* renamed from: b reason: collision with root package name */
    public ak f1533b;

    /* renamed from: c reason: collision with root package name */
    public aj f1534c;

    /* renamed from: d reason: collision with root package name */
    public Activity f1535d;

    /* renamed from: e reason: collision with root package name */
    public an f1536e = new an();

    /* renamed from: f reason: collision with root package name */
    public Handler f1537f;

    /* renamed from: g reason: collision with root package name */
    public HandlerThread f1538g;

    /* renamed from: h reason: collision with root package name */
    public Handler f1539h;

    /* renamed from: i reason: collision with root package name */
    public HandlerThread f1540i;

    /* renamed from: j reason: collision with root package name */
    public volatile boolean f1541j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile String p;
    public volatile String q;
    public volatile String r;
    public long s;
    public long t;
    public long u;
    public String v;
    public boolean w;
    public String x;
    public JSONObject y = new JSONObject();
    public JSONObject z = new JSONObject();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 21:
                    am.this.l();
                    return;
                case 22:
                    am.this.m();
                    return;
                case 23:
                    am.this.n();
                    return;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        am.this.b(data.getString("autoconfig.key"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public class b implements com.baidu.mobstat.aj.a {
        public b() {
        }

        public void a() {
            am.this.j();
        }

        public void b() {
            am.this.k();
        }

        public void a(boolean z) {
            am.this.b(z);
        }

        public void a(String str) {
            Message obtainMessage = am.this.f1537f.obtainMessage(24);
            Bundle bundle = new Bundle();
            bundle.putString("autoconfig.key", str);
            obtainMessage.setData(bundle);
            am.this.f1537f.sendMessage(obtainMessage);
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                am.this.o();
            } else if (i2 == 2) {
                am.this.s();
            }
        }
    }

    public am() {
        HandlerThread handlerThread = new HandlerThread("crawlerThread");
        this.f1540i = handlerThread;
        handlerThread.start();
        this.f1539h = new c(this.f1540i.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("downloadThread");
        this.f1538g = handlerThread2;
        handlerThread2.start();
        this.f1537f = new a(this.f1538g.getLooper());
    }

    /* access modifiers changed from: private */
    public void k() {
        this.f1541j = true;
        if (p() && this.f1541j) {
            this.C.sendMessage(this.C.obtainMessage(32));
            this.f1539h.sendMessage(this.f1539h.obtainMessage(2));
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!this.k) {
            boolean a2 = bg.a(this.f1532a, this.v, 0, true);
            this.k = true;
            if (a2) {
                this.p = bo.a(this.f1532a, "mtj_vizParser.js");
            }
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (!this.l) {
            boolean a2 = bg.a(this.f1532a, this.v, 1, true);
            this.l = true;
            if (a2) {
                this.q = bo.a(this.f1532a, "mtj_autoTracker.js");
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!this.m) {
            boolean a2 = bg.a(this.f1532a, this.v, 2, true);
            this.m = true;
            if (a2) {
                this.C.sendMessage(this.C.obtainMessage(34));
            }
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        bc.c().a("autotrace: start to connect");
        a(1);
        if (p()) {
            bc.c().a("autotrace: connect established, no need to duplicate connect");
            return;
        }
        String a2 = a(this.f1532a);
        if (bd.c().b()) {
            String str = "url:";
            if (!TextUtils.isEmpty(a2)) {
                str = e.a.a.a.a.a(str, a2);
            }
            bd.c().a(str);
        }
        try {
            this.f1534c = new aj(URI.create(a2), new b());
        } catch (Exception unused) {
        }
    }

    private boolean p() {
        aj ajVar = this.f1534c;
        return ajVar != null && ajVar.b();
    }

    private boolean q() {
        return !TextUtils.isEmpty(this.v);
    }

    private String r() {
        Activity activity = this.f1535d;
        if (activity != null) {
            return activity.getClass().getName();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void s() {
        if (p() && this.f1541j) {
            JSONObject a2 = a(this.f1536e.a(this.f1535d));
            if (a2 != null) {
                if (bd.c().b()) {
                    bd c2 = bd.c();
                    StringBuilder a3 = e.a.a.a.a.a("doSendSnapshot:");
                    a3.append(a2.toString());
                    c2.a(a3.toString());
                }
                try {
                    this.f1534c.a(a2);
                } catch (Exception unused) {
                }
            }
            this.f1539h.sendMessageDelayed(this.f1539h.obtainMessage(2), 2000);
        }
    }

    private void t() {
        if (bw.s(this.f1532a) && !this.m) {
            if (this.u == 0) {
                this.u = bq.a().p(this.f1532a);
            }
            if (System.currentTimeMillis() - this.u > LogBuilder.MAX_INTERVAL) {
                this.f1537f.sendMessage(this.f1537f.obtainMessage(23));
            }
        }
    }

    private void u() {
        if (bw.s(this.f1532a) && !this.l) {
            if (!this.n) {
                this.q = bo.a(this.f1532a, "mtj_autoTracker.js");
                this.n = true;
            }
            if (this.s == 0) {
                this.s = bq.a().n(this.f1532a);
                this.t = bq.a().o(this.f1532a);
            }
            if ((this.n && TextUtils.isEmpty(this.q)) || System.currentTimeMillis() - this.s > this.t) {
                this.f1537f.sendMessage(this.f1537f.obtainMessage(22));
            }
        }
    }

    private void v() {
        if (!this.o) {
            if (TextUtils.isEmpty(this.r)) {
                h();
            }
            this.o = true;
        }
    }

    public void a(Activity activity) {
    }

    private void d(Activity activity) {
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra(MtjConfig.BAIDU_MTJ_PUSH_CALL, false);
                String stringExtra = intent.getStringExtra(MtjConfig.BAIDU_MTJ_PUSH_MSG);
                if (this.E) {
                    LaunchInfo launchInfo = new LaunchInfo();
                    if (booleanExtra) {
                        launchInfo.setPushInfo(bj.e(activity), stringExtra);
                    }
                    String g2 = bj.g(activity);
                    if (!TextUtils.isEmpty(g2)) {
                        launchInfo.setRefererPkgName(g2);
                    }
                    BDStatCore.instance().autoTrackLaunchInfo(this.f1532a, launchInfo, true);
                } else {
                    LaunchInfo launchInfo2 = new LaunchInfo();
                    if (booleanExtra) {
                        launchInfo2.setPushInfo(bj.e(activity), stringExtra);
                    }
                    String g3 = bj.g(activity);
                    if (!TextUtils.isEmpty(g3)) {
                        launchInfo2.setRefererPkgName(g3);
                    }
                    BDStatCore.instance().autoTrackLaunchInfo(this.f1532a, launchInfo2, false);
                }
                this.E = false;
            }
        }
    }

    private void e(Activity activity) {
        if (bd.c().b()) {
            bd.c().a("installConnectionTracker");
        }
        ak akVar = new ak(this.D);
        this.f1533b = akVar;
        akVar.a(activity);
    }

    private void f() {
        if (bd.c().b()) {
            bd.c().a("uninstallConnectionTracker");
        }
        ak akVar = this.f1533b;
        if (akVar != null) {
            akVar.b();
            this.f1533b = null;
        }
    }

    private void g() {
        if (!p() || !this.f1541j) {
            c();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        this.r = bo.a(this.f1532a, "mtj_auto.config");
        c(this.r);
        av.b(this.r);
        ar.a(this.r);
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!p()) {
            bc.c().a("autotrace: gesture success");
            a(0);
            if (!bw.s(this.f1532a)) {
                bc.c().a("autotrace: network invalid, failed to connect to circle server");
                return;
            }
            this.f1539h.sendMessage(this.f1539h.obtainMessage(1));
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!this.k) {
            this.f1537f.sendMessage(this.f1537f.obtainMessage(21));
        }
    }

    public void b(Activity activity) {
        if (q()) {
            this.f1532a = activity.getApplicationContext();
            Intent intent = activity.getIntent();
            if (intent != null && a(activity, intent)) {
                a().i();
            }
            if (this.f1535d != null) {
                c();
            }
            this.f1535d = activity;
            d(activity);
            v();
            t();
            u();
            b(activity, true);
            e(activity);
            g();
            a(activity, true);
        }
    }

    public void c(Activity activity) {
        if (q()) {
            this.f1535d = null;
            b(activity, false);
            f();
            a(activity, false);
        }
    }

    public static am a() {
        return B;
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    public JSONArray e() {
        synchronized (this.G) {
            if (this.f1532a == null) {
                JSONArray jSONArray = new JSONArray();
                return jSONArray;
            }
            String a2 = bo.a(this.f1532a, "trace_circle.data");
            JSONArray jSONArray2 = null;
            try {
                if (!TextUtils.isEmpty(a2)) {
                    jSONArray2 = new JSONArray(a2);
                }
            } catch (Exception unused) {
            }
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            JSONArray jSONArray3 = new JSONArray();
            this.F = jSONArray3;
            bo.a(this.f1532a, "trace_circle.data", jSONArray3.toString(), false);
            return jSONArray2;
        }
    }

    public boolean a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String scheme = data.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        try {
            String queryParameter = data.getQueryParameter("token");
            String queryParameter2 = data.getQueryParameter(LogBuilder.KEY_TIME);
            if (!scheme.startsWith("mtj") || scheme.length() <= 3) {
                return false;
            }
            String substring = scheme.substring(3);
            if (TextUtils.isEmpty(substring) || !substring.equals(this.v.toLowerCase()) || TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            this.x = queryParameter;
            String s2 = bq.a().s(activity);
            if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(s2)) {
                return false;
            }
            bq.a().k(activity, queryParameter2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void c() {
        Activity activity = this.f1535d;
        if (activity != null) {
            ai.a(activity);
        }
    }

    private void c(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            bl blVar2 = blVar;
            blVar2.a(this.f1535d, webView, str, a(this.y, r()), true);
        }
    }

    private void c(String str) {
        String str2 = WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA;
        String str3 = "meta";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(str3);
                JSONArray jSONArray = (JSONArray) jSONObject.get(str2);
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                    String str4 = (String) jSONObject3.opt("url");
                    if (!TextUtils.isEmpty((String) jSONObject3.opt("webLayout")) || !TextUtils.isEmpty(str4)) {
                        jSONArray2.put(jSONObject3);
                    } else {
                        jSONArray3.put(jSONObject3);
                    }
                }
                this.y.put(str3, jSONObject2);
                this.y.put(str2, jSONArray2);
                this.z.put(str3, jSONObject2);
                this.z.put(str2, jSONArray3);
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        Activity activity = this.f1535d;
        if (activity != null) {
            ai.b(activity);
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        this.f1541j = false;
        an.b();
        this.f1539h.removeMessages(2);
        this.C.sendMessage(this.C.obtainMessage(33));
    }

    public void a(Activity activity, boolean z2) {
        if (!(activity instanceof IIgnoreAutoEvent)) {
            if (z2) {
                this.A.a(activity, true, this.z, this.w);
            } else {
                this.A.a(activity, true);
            }
        }
    }

    public void d() {
        if (p()) {
            this.f1534c.a();
        }
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bo.a(this.f1532a, "mtj_vizParser.js");
        }
        b(webView, this.p, blVar);
        if (TextUtils.isEmpty(this.q)) {
            this.q = bo.a(this.f1532a, "mtj_autoTracker.js");
        }
        c(webView, this.q, blVar);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (this.f1532a != null && !TextUtils.isEmpty(str)) {
            bq.a().c(this.f1532a, System.currentTimeMillis());
            bo.a(this.f1532a, "mtj_auto.config", str, false);
            this.C.sendMessage(this.C.obtainMessage(34));
        }
    }

    private String a(Context context) {
        String str = "UTF-8";
        ArrayList arrayList = new ArrayList();
        StringBuilder a2 = e.a.a.a.a.a("");
        a2.append(this.v);
        arrayList.add(new Pair(WBConstants.SSO_APP_KEY, a2.toString()));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("appName", bw.h(context)));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair("sdkVersion", StatService.getSdkVersion()));
        arrayList.add(new Pair("deviceName", bw.m(context)));
        arrayList.add(new Pair("platform", "Android"));
        arrayList.add(new Pair("model", Build.MODEL));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair(LanguageUtils.AUTO, "1"));
        if (!TextUtils.isEmpty(this.x)) {
            arrayList.add(new Pair("token", this.x));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), str);
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), str);
                String str2 = "=";
                if (TextUtils.isEmpty(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(encode);
                    sb2.append(str2);
                    sb2.append(encode2);
                    sb.append(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("&");
                    sb3.append(encode);
                    sb3.append(str2);
                    sb3.append(encode2);
                    sb.append(sb3.toString());
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder a3 = e.a.a.a.a.a("wss://mtjsocket.baidu.com/app?");
        a3.append(sb.toString());
        String sb4 = a3.toString();
        this.x = null;
        return sb4;
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            blVar.a(webView, str);
        }
    }

    private void b(Activity activity, boolean z2) {
        if (!(activity instanceof IIgnoreAutoTrace)) {
            if (z2) {
                BDStatCore.instance().onResume(activity, true);
            } else {
                BDStatCore.instance().onPause(activity, true, null);
            }
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            jSONObject2.put("type", "upload");
            jSONObject2.put(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA, jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ Exception -> 0x0064 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(org.json.JSONObject r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "data"
            java.lang.String r1 = "meta"
            r2 = 0
            if (r11 != 0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            if (r3 == 0) goto L_0x000f
            return r2
        L_0x000f:
            java.lang.Object r3 = r11.get(r1)     // Catch:{ Exception -> 0x0064 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = "matchAll"
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0064 }
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Exception -> 0x0064 }
            org.json.JSONArray r11 = (org.json.JSONArray) r11     // Catch:{ Exception -> 0x0064 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0064 }
            r5.<init>()     // Catch:{ Exception -> 0x0064 }
            r6 = 0
            r7 = r6
        L_0x0028:
            int r8 = r11.length()     // Catch:{ Exception -> 0x0064 }
            if (r7 >= r8) goto L_0x0048
            java.lang.Object r8 = r11.get(r7)     // Catch:{ Exception -> 0x0064 }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ Exception -> 0x0064 }
            java.lang.String r9 = "page"
            java.lang.Object r9 = r8.get(r9)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0064 }
            boolean r9 = r12.equals(r9)     // Catch:{ Exception -> 0x0064 }
            if (r9 == 0) goto L_0x0045
            r5.put(r8)     // Catch:{ Exception -> 0x0064 }
        L_0x0045:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x0048:
            r11 = 1
            if (r4 == 0) goto L_0x004d
        L_0x004b:
            r6 = r11
            goto L_0x0056
        L_0x004d:
            if (r4 != 0) goto L_0x0056
            int r12 = r5.length()     // Catch:{ Exception -> 0x0064 }
            if (r12 == 0) goto L_0x0056
            goto L_0x004b
        L_0x0056:
            if (r6 == 0) goto L_0x0064
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0064 }
            r11.<init>()     // Catch:{ Exception -> 0x0064 }
            r11.put(r1, r3)     // Catch:{ Exception -> 0x0063 }
            r11.put(r0, r5)     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            r2 = r11
        L_0x0064:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.am.a(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    public void a(int i2) {
        a(i2, "");
    }

    public void a(int i2, String str) {
        synchronized (this.G) {
            if (this.f1532a != null) {
                if (str == null) {
                    str = "";
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean s2 = bw.s(this.f1532a);
                StringBuilder sb = new StringBuilder();
                sb.append(s2 ? 1 : 0);
                sb.append("|");
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i2);
                sb3.append("_");
                sb3.append(currentTimeMillis);
                sb3.append("_");
                sb3.append(sb2);
                this.F.put(sb3.toString());
                bo.a(this.f1532a, "trace_circle.data", this.F.toString(), false);
            }
        }
    }
}
