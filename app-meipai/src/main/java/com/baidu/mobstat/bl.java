package com.baidu.mobstat;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class bl {

    /* renamed from: a reason: collision with root package name */
    public static String f1751a;

    /* renamed from: b reason: collision with root package name */
    public WeakReference<WebView> f1752b;

    /* renamed from: c reason: collision with root package name */
    public WeakReference<Activity> f1753c;

    /* renamed from: d reason: collision with root package name */
    public JSONObject f1754d;

    /* renamed from: e reason: collision with root package name */
    public boolean f1755e;

    /* renamed from: f reason: collision with root package name */
    public boolean f1756f;

    public static void b(Activity activity, final WebView webView, Rect rect) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (rect != null) {
            i5 = ah.a(activity, (float) rect.left);
            i4 = ah.a(activity, (float) rect.top);
            i3 = ah.a(activity, (float) rect.width());
            i2 = ah.a(activity, (float) rect.height());
        } else {
            i2 = 0;
            i4 = 0;
            i3 = 0;
        }
        int a2 = ah.a(activity, (float) bj.c(activity));
        int a3 = ah.a(activity, (float) bj.d(activity));
        StringBuilder a4 = a.a("{\"x\": ", i5, ", \"y\": ", i4, ", \"w\": ");
        a4.append(i3);
        a4.append(", \"h\": ");
        a4.append(i2);
        a4.append(", \"sw\": ");
        a4.append(a2);
        a4.append(", \"sh\": ");
        a4.append(a3);
        a4.append("}");
        final String a5 = a.a("javascript:window._automtj.getViewportTree('android', '", a4.toString(), "', 'window.WebViewInterface.setViewportTreeToNative')");
        activity.runOnUiThread(new Runnable() {
            public void run() {
                webView.loadUrl(a5);
            }
        });
    }

    public void a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append(str);
            webView.loadUrl(sb.toString());
        }
    }

    @JavascriptInterface
    public void setEventToNative(String str) {
        String str2 = "setEventToNative: ";
        if (bd.c().b() && this.f1756f) {
            bd c2 = bd.c();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            c2.a(sb.toString());
        }
        if (bh.c().b()) {
            bh c3 = bh.c();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str);
            c3.a(sb2.toString());
        }
        WeakReference<Activity> weakReference = this.f1753c;
        if (weakReference != null) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                WeakReference<WebView> weakReference2 = this.f1752b;
                if (weakReference2 != null) {
                    WebView webView = (WebView) weakReference2.get();
                    if (webView != null) {
                        a(str, activity, webView);
                    }
                }
            }
        }
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        if (bd.c().b()) {
            bd c2 = bd.c();
            StringBuilder sb = new StringBuilder();
            sb.append("setViewportTreeToNative ");
            sb.append(str);
            c2.a(sb.toString());
        }
        f1751a = str;
    }

    public static String a(Activity activity, WebView webView, Rect rect) {
        String str = "";
        f1751a = str;
        b(activity, webView, rect);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 15) {
                return str;
            }
            try {
                Thread.sleep(20);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(f1751a)) {
                return f1751a;
            }
            i2 = i3;
        }
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                this.f1756f = z;
                this.f1754d = jSONObject;
            }
            if (z) {
                bd c2 = bd.c();
                StringBuilder sb = new StringBuilder();
                sb.append("injectTrackJs circleConfig: ");
                sb.append(jSONObject);
                c2.a(sb.toString());
            }
            if (a(webView, z)) {
                String str2 = "injectTrackJs, no need to entry";
                if (z) {
                    bd.c().a(str2);
                } else {
                    bh.c().a(str2);
                }
                return;
            }
            if (activity != null) {
                this.f1753c = new WeakReference<>(activity);
            }
            if (webView != null) {
                this.f1752b = new WeakReference<>(webView);
            }
            this.f1755e = z;
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                a2 = new JSONObject().toString();
            }
            String str3 = "injectTrackJs h5Config: ";
            if (bd.c().b() && this.f1756f) {
                bd c3 = bd.c();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(a2);
                c3.a(sb2.toString());
            }
            if (bh.c().b()) {
                bh c4 = bh.c();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(a2);
                c4.a(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": ");
            sb4.append(a2);
            sb4.append("};");
            sb4.append(str);
            sb4.append("})()");
            String sb5 = sb4.toString();
            if (webView != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("javascript:");
                sb6.append(sb5);
                webView.loadUrl(sb6.toString());
            }
        }
    }

    private boolean a(WebView webView, boolean z) {
        WeakReference<WebView> weakReference = this.f1752b;
        return (weakReference == null || ((WebView) weakReference.get()) != webView || this.f1755e == z) ? false : true;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("matchAll", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("meta", jSONObject);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return new JSONObject().toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r34, android.app.Activity r35, android.webkit.WebView r36) {
        /*
            r33 = this;
            r6 = r33
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0028 }
            r2 = r34
            r1.<init>(r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "h3"
            org.json.JSONArray r2 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r3 = "p2"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r4 = "l"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r5 = "point"
            org.json.JSONObject r0 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x002b }
            r1 = 1
            goto L_0x002c
        L_0x0024:
            r4 = r0
            goto L_0x002b
        L_0x0026:
            r3 = r0
            goto L_0x002a
        L_0x0028:
            r2 = r0
            r3 = r2
        L_0x002a:
            r4 = r3
        L_0x002b:
            r1 = 0
        L_0x002c:
            r21 = r0
            r23 = r2
            r22 = r4
            if (r1 != 0) goto L_0x0035
            return
        L_0x0035:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = "/"
            r24 = r0
            goto L_0x0042
        L_0x0040:
            r24 = r3
        L_0x0042:
            org.json.JSONArray r25 = com.baidu.mobstat.bj.a(r35, r36)
            java.lang.Class r0 = r35.getClass()
            java.lang.String r26 = r0.getName()
            java.lang.String r4 = com.baidu.mobstat.bj.a(r25)
            java.lang.String r5 = com.baidu.mobstat.bj.b(r23)
            java.lang.String r27 = com.baidu.mobstat.bj.f(r36)
            java.util.Map r28 = com.baidu.mobstat.bj.g(r36)
            android.content.Context r29 = r35.getApplicationContext()
            java.lang.String r30 = ""
            long r31 = java.lang.System.currentTimeMillis()
            org.json.JSONObject r1 = r6.f1754d
            java.lang.Class r0 = r35.getClass()
            java.lang.String r2 = r0.getName()
            r0 = r33
            r3 = r24
            boolean r0 = r0.a(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x009d
            com.baidu.mobstat.BDStatCore r7 = com.baidu.mobstat.BDStatCore.instance()
            r11 = 1
            long r12 = java.lang.System.currentTimeMillis()
            r20 = 1
            r8 = r29
            r9 = r30
            r10 = r22
            r14 = r25
            r15 = r23
            r16 = r26
            r17 = r24
            r18 = r27
            r19 = r28
            r7.onEvent(r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x00b4
        L_0x009d:
            com.baidu.mobstat.bd r0 = com.baidu.mobstat.bd.c()
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r6.f1756f
            if (r0 == 0) goto L_0x00b4
            com.baidu.mobstat.bd r0 = com.baidu.mobstat.bd.c()
            java.lang.String r1 = "setEventToNative: not circle event, will not take effect"
            r0.a(r1)
        L_0x00b4:
            com.baidu.mobstat.aw r7 = com.baidu.mobstat.aw.a()
            r11 = 1
            r20 = 1
            java.lang.String r0 = ""
            r8 = r29
            r9 = r30
            r10 = r22
            r12 = r31
            r14 = r26
            r15 = r25
            r16 = r24
            r17 = r23
            r18 = r27
            r19 = r28
            r22 = r0
            r7.a(r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bl.a(java.lang.String, android.app.Activity, android.webkit.WebView):void");
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008d, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008d, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v8
  assigns: []
  uses: []
  mth insns count: 62
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(org.json.JSONObject r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0093
            java.lang.String r1 = r9.toString()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0018
            goto L_0x0093
        L_0x0018:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x0093
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 != 0) goto L_0x0093
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 != 0) goto L_0x0093
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 == 0) goto L_0x0031
            goto L_0x0093
        L_0x0031:
            r1 = 1
            java.lang.String r2 = "meta"
            java.lang.Object r2 = r9.get(r2)     // Catch:{ Exception -> 0x0043 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "matchAll"
            int r2 = r2.getInt(r3)     // Catch:{ Exception -> 0x0043 }
            if (r2 == 0) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r2 = "data"
            java.lang.Object r9 = r9.get(r2)     // Catch:{ Exception -> 0x0091 }
            org.json.JSONArray r9 = (org.json.JSONArray) r9     // Catch:{ Exception -> 0x0091 }
            r2 = r0
        L_0x004c:
            int r3 = r9.length()     // Catch:{ Exception -> 0x0090 }
            if (r0 >= r3) goto L_0x0092
            java.lang.Object r3 = r9.get(r0)     // Catch:{ Exception -> 0x0090 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x0090 }
            java.lang.String r4 = "page"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r5 = "layout"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = "url"
            java.lang.Object r6 = r3.opt(r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0090 }
            java.lang.String r7 = "webLayout"
            java.lang.Object r3 = r3.opt(r7)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0090 }
            boolean r4 = r10.equals(r4)     // Catch:{ Exception -> 0x0090 }
            if (r4 == 0) goto L_0x008d
            boolean r4 = r11.equals(r6)     // Catch:{ Exception -> 0x0090 }
            if (r4 == 0) goto L_0x008d
            boolean r4 = r12.equals(r5)     // Catch:{ Exception -> 0x0090 }
            if (r4 == 0) goto L_0x008d
            boolean r3 = r13.equals(r3)     // Catch:{ Exception -> 0x0090 }
            if (r3 == 0) goto L_0x008d
            r2 = r1
        L_0x008d:
            int r0 = r0 + 1
            goto L_0x004c
        L_0x0090:
            r0 = r2
        L_0x0091:
            r2 = r0
        L_0x0092:
            return r2
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bl.a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
