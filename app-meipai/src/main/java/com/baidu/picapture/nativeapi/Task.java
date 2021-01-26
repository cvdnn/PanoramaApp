package com.baidu.picapture.nativeapi;

import android.webkit.JavascriptInterface;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import e.c.d.j.h1;
import e.c.d.j.j;
import e.c.d.j.j1;
import e.c.d.j.x0;
import e.c.d.k.k;
import e.c.d.k.l;
import java.util.Hashtable;
import java.util.Map;

public class Task {

    /* renamed from: a reason: collision with root package name */
    public Map<String, a> f1972a = new Hashtable();

    /* renamed from: b reason: collision with root package name */
    public Map<String, a> f1973b = new Hashtable();

    /* renamed from: c reason: collision with root package name */
    public Map<String, a> f1974c = new Hashtable();

    /* renamed from: d reason: collision with root package name */
    public Map<String, a> f1975d = new Hashtable();

    public Task() {
        j1 e2 = j1.e();
        k kVar = new k(this);
        if (!e2.f6285h.contains(kVar)) {
            e2.f6285h.registerObserver(kVar);
        }
        h1 e3 = h1.e();
        l lVar = new l(this);
        if (!e3.f6271g.contains(lVar)) {
            e3.f6271g.registerObserver(lVar);
        }
    }

    public /* synthetic */ void a(String str, String str2) {
        if (!this.f1972a.isEmpty()) {
            a aVar = (a) this.f1972a.get(str);
            if (aVar != null) {
                j1 e2 = j1.e();
                e2.f6254a.execute(new x0(e2, str));
                aVar.a(str2);
                this.f1972a.remove(str);
            }
        }
        if (!this.f1973b.isEmpty()) {
            a aVar2 = (a) this.f1973b.get(str);
            if (aVar2 != null) {
                aVar2.a(str2);
                this.f1973b.remove(str);
            }
        }
    }

    public /* synthetic */ void b(String str, String str2) {
        if (!this.f1974c.isEmpty()) {
            a aVar = (a) this.f1974c.get(str);
            if (aVar != null) {
                h1 e2 = h1.e();
                e2.f6254a.execute(new j(e2, str));
                aVar.a(str2);
                this.f1974c.remove(str);
            }
        }
        if (!this.f1975d.isEmpty()) {
            a aVar2 = (a) this.f1975d.get(str);
            if (aVar2 != null) {
                aVar2.a(str2);
                this.f1975d.remove(str);
            }
        }
    }

    @JavascriptInterface
    public void cancel(String str, a aVar) {
        a(str, aVar, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "taskId"
            java.lang.String r2 = "taskType"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0030 }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x0030 }
            boolean r5 = r3.has(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 != 0) goto L_0x002f
            boolean r5 = r3.has(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x0024
            goto L_0x002f
        L_0x0024:
            java.lang.String r5 = r3.getString(r2)     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r0 = r3.getString(r1)     // Catch:{ JSONException -> 0x002d }
            goto L_0x0036
        L_0x002d:
            r1 = move-exception
            goto L_0x0033
        L_0x002f:
            return
        L_0x0030:
            r5 = move-exception
            r1 = r5
            r5 = r0
        L_0x0033:
            r1.printStackTrace()
        L_0x0036:
            java.lang.String r1 = "spin"
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x004d
            e.c.d.j.j1 r5 = e.c.d.j.j1.e()
            java.util.concurrent.ExecutorService r1 = r5.f6254a
            e.c.d.j.x0 r2 = new e.c.d.j.x0
            r2.<init>(r5, r0)
            r1.execute(r2)
            goto L_0x0063
        L_0x004d:
            java.lang.String r1 = "pano"
            boolean r5 = r5.equalsIgnoreCase(r1)
            if (r5 == 0) goto L_0x0063
            e.c.d.j.h1 r5 = e.c.d.j.h1.e()
            java.util.concurrent.ExecutorService r1 = r5.f6254a
            e.c.d.j.j r2 = new e.c.d.j.j
            r2.<init>(r5, r0)
            r1.execute(r2)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Task.delete(java.lang.String):void");
    }

    @JavascriptInterface
    public void pause(String str, a aVar) {
        a(str, aVar, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void retry(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "taskId"
            java.lang.String r2 = "taskType"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0030 }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x0030 }
            boolean r5 = r3.has(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 != 0) goto L_0x002f
            boolean r5 = r3.has(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x0024
            goto L_0x002f
        L_0x0024:
            java.lang.String r5 = r3.getString(r2)     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r0 = r3.getString(r1)     // Catch:{ JSONException -> 0x002d }
            goto L_0x0035
        L_0x002d:
            r1 = move-exception
            goto L_0x0032
        L_0x002f:
            return
        L_0x0030:
            r1 = move-exception
            r5 = r0
        L_0x0032:
            r1.printStackTrace()
        L_0x0035:
            java.lang.String r1 = "spin"
            boolean r5 = r5.equalsIgnoreCase(r1)
            if (r5 == 0) goto L_0x004b
            e.c.d.j.j1 r5 = e.c.d.j.j1.e()
            java.util.concurrent.ExecutorService r1 = r5.f6254a
            e.c.d.j.y0 r2 = new e.c.d.j.y0
            r2.<init>(r5, r0)
            r1.execute(r2)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Task.retry(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "taskId"
            java.lang.String r2 = "taskType"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0030 }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x0030 }
            boolean r5 = r3.has(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r2)     // Catch:{ JSONException -> 0x0030 }
            if (r5 != 0) goto L_0x002f
            boolean r5 = r3.has(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x002f
            boolean r5 = r3.isNull(r1)     // Catch:{ JSONException -> 0x0030 }
            if (r5 == 0) goto L_0x0024
            goto L_0x002f
        L_0x0024:
            java.lang.String r5 = r3.getString(r2)     // Catch:{ JSONException -> 0x0030 }
            java.lang.String r0 = r3.getString(r1)     // Catch:{ JSONException -> 0x002d }
            goto L_0x0035
        L_0x002d:
            r1 = move-exception
            goto L_0x0032
        L_0x002f:
            return
        L_0x0030:
            r1 = move-exception
            r5 = r0
        L_0x0032:
            r1.printStackTrace()
        L_0x0035:
            java.lang.String r1 = "spin"
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x006b
            if (r7 == 0) goto L_0x004e
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1973b
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x0048
            return
        L_0x0048:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1973b
            r5.put(r0, r6)
            goto L_0x005c
        L_0x004e:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1972a
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x0057
            return
        L_0x0057:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1972a
            r5.put(r0, r6)
        L_0x005c:
            e.c.d.j.j1 r5 = e.c.d.j.j1.e()
            java.util.concurrent.ExecutorService r6 = r5.f6254a
            e.c.d.j.g0 r7 = new e.c.d.j.g0
            r7.<init>(r5, r0)
            r6.execute(r7)
            goto L_0x00a0
        L_0x006b:
            java.lang.String r1 = "pano"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00a0
            if (r7 == 0) goto L_0x0084
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1975d
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x007e
            return
        L_0x007e:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1975d
            r5.put(r0, r6)
            goto L_0x0092
        L_0x0084:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1974c
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto L_0x008d
            return
        L_0x008d:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r5 = r4.f1974c
            r5.put(r0, r6)
        L_0x0092:
            e.c.d.j.h1 r5 = e.c.d.j.h1.e()
            java.util.concurrent.ExecutorService r6 = r5.f6254a
            e.c.d.j.p r7 = new e.c.d.j.p
            r7.<init>(r5, r0)
            r6.execute(r7)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Task.a(java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a, boolean):void");
    }
}
