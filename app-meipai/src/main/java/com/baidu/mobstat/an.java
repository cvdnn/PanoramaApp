package com.baidu.mobstat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;

public class an {

    /* renamed from: c reason: collision with root package name */
    public static volatile String f1547c;

    /* renamed from: d reason: collision with root package name */
    public static volatile int f1548d;

    /* renamed from: a reason: collision with root package name */
    public final b f1549a = new b();

    /* renamed from: b reason: collision with root package name */
    public final Handler f1550b = new Handler(Looper.getMainLooper());

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public Bitmap f1551a = null;

        /* renamed from: b reason: collision with root package name */
        public final Paint f1552b = new Paint(2);

        public synchronized void a(int i2, int i3, int i4, Bitmap bitmap) {
            if (!(this.f1551a != null && this.f1551a.getWidth() == i2 && this.f1551a.getHeight() == i3)) {
                try {
                    this.f1551a = Bitmap.createBitmap(i2, i3, Config.RGB_565);
                } catch (OutOfMemoryError unused) {
                    this.f1551a = null;
                }
                if (this.f1551a != null) {
                    this.f1551a.setDensity(i4);
                }
            }
            if (this.f1551a != null) {
                new Canvas(this.f1551a).drawBitmap(bitmap, 0.0f, 0.0f, this.f1552b);
            }
        }
    }

    public static class b implements Callable<List<c>> {

        /* renamed from: a reason: collision with root package name */
        public Activity f1553a;

        /* renamed from: b reason: collision with root package name */
        public final List<c> f1554b = new ArrayList();

        /* renamed from: c reason: collision with root package name */
        public final DisplayMetrics f1555c = new DisplayMetrics();

        /* renamed from: d reason: collision with root package name */
        public final a f1556d = new a();

        /* renamed from: e reason: collision with root package name */
        public final int f1557e = 160;

        private void b() {
            ai.a(this.f1553a, false);
        }

        private void c() {
            ai.a(this.f1553a, true);
        }

        public void a(Activity activity) {
            this.f1553a = activity;
        }

        /* renamed from: a */
        public List<c> call() throws Exception {
            this.f1554b.clear();
            HashSet hashSet = new HashSet(1);
            hashSet.add(this.f1553a);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                String canonicalName = activity.getClass().getCanonicalName();
                View b2 = bj.b(activity);
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.f1555c);
                this.f1554b.add(new c(canonicalName, b2));
            }
            int size = this.f1554b.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = (c) this.f1554b.get(i2);
                b();
                a(cVar);
                c();
            }
            return this.f1554b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x007e A[SYNTHETIC, Splitter:B:17:0x007e] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(com.baidu.mobstat.an.c r14) {
            /*
                r13 = this;
                android.view.View r0 = r14.f1559b
                r1 = 0
                r2 = 0
                r3 = 1
                java.lang.Class<android.view.View> r4 = android.view.View.class
                java.lang.String r5 = "createSnapshot"
                r6 = 3
                java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Class<android.graphics.Bitmap$Config> r8 = android.graphics.Bitmap.Config.class
                r7[r2] = r8     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r7[r3] = r8     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r9 = 2
                r7[r9] = r8     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r7)     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r4.setAccessible(r3)     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r5[r2] = r6     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r6 = -1
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r5[r3] = r6     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                r5[r9] = r6     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                java.lang.Object r4 = r4.invoke(r0, r5)     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ NoSuchMethodException -> 0x0071, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x005b, IllegalAccessException -> 0x0050, ClassCastException -> 0x0045, Exception -> 0x003a }
                goto L_0x007c
            L_0x003a:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = " autotrace:createSnapshot encounter exception"
                r5.d(r6, r4)
                goto L_0x007b
            L_0x0045:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = "autotrace: createSnapshot didn't return a bitmap"
                r5.d(r6, r4)
                goto L_0x007b
            L_0x0050:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = "autotrace: Can't access createSnapshot, using drawCache"
                r5.d(r6, r4)
                goto L_0x007b
            L_0x005b:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = "autotrace: Exception when calling createSnapshot"
                r5.d(r6, r4)
                goto L_0x007b
            L_0x0066:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = "autotrace: Can't call createSnapshot with arguments"
                r5.b(r6, r4)
                goto L_0x007b
            L_0x0071:
                r4 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.String r6 = "autotrace: Can't call createSnapshot, will use drawCache"
                r5.a(r6, r4)
            L_0x007b:
                r4 = r1
            L_0x007c:
                if (r4 != 0) goto L_0x00b0
                boolean r5 = r0.isDrawingCacheEnabled()     // Catch:{ Exception -> 0x0092 }
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0092 }
                r0.setDrawingCacheEnabled(r3)     // Catch:{ Exception -> 0x0092 }
                r0.buildDrawingCache(r3)     // Catch:{ Exception -> 0x0092 }
                android.graphics.Bitmap r3 = r0.getDrawingCache()     // Catch:{ Exception -> 0x0092 }
                r4 = r3
                goto L_0x00b0
            L_0x0092:
                r3 = move-exception
                com.baidu.mobstat.bc r5 = com.baidu.mobstat.bc.c()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "autotrace: Can't take a bitmap snapshot of view "
                r6.append(r7)
                r6.append(r0)
                java.lang.String r7 = ", skipping for now."
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r5.a(r6, r3)
            L_0x00b0:
                r3 = 1065353216(0x3f800000, float:1.0)
                if (r4 == 0) goto L_0x00e9
                int r5 = r4.getDensity()
                if (r5 == 0) goto L_0x00be
                r3 = 1126170624(0x43200000, float:160.0)
                float r5 = (float) r5
                float r3 = r3 / r5
            L_0x00be:
                int r5 = r4.getWidth()
                int r6 = r4.getHeight()
                int r7 = r4.getWidth()
                float r7 = (float) r7
                float r7 = r7 * r3
                double r7 = (double) r7
                r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
                double r7 = r7 + r9
                int r7 = (int) r7
                int r8 = r4.getHeight()
                float r8 = (float) r8
                float r8 = r8 * r3
                double r11 = (double) r8
                double r11 = r11 + r9
                int r8 = (int) r11
                if (r5 <= 0) goto L_0x00e9
                if (r6 <= 0) goto L_0x00e9
                if (r7 <= 0) goto L_0x00e9
                if (r8 <= 0) goto L_0x00e9
                com.baidu.mobstat.an$a r5 = r13.f1556d
                r6 = 160(0xa0, float:2.24E-43)
                r5.a(r7, r8, r6, r4)
            L_0x00e9:
                if (r1 == 0) goto L_0x00f4
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x00f4
                r0.setDrawingCacheEnabled(r2)
            L_0x00f4:
                r14.f1561d = r3
                com.baidu.mobstat.an$a r0 = r13.f1556d
                r14.f1560c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.an.b.a(com.baidu.mobstat.an$c):void");
        }
    }

    public static class c {

        /* renamed from: a reason: collision with root package name */
        public final String f1558a;

        /* renamed from: b reason: collision with root package name */
        public final View f1559b;

        /* renamed from: c reason: collision with root package name */
        public a f1560c = null;

        /* renamed from: d reason: collision with root package name */
        public float f1561d = 1.0f;

        public c(String str, View view) {
            this.f1558a = str;
            this.f1559b = view;
        }
    }

    public static void a() {
        f1548d = 0;
    }

    public static void b() {
        f1547c = "";
    }

    private JSONArray c(Activity activity) throws Exception {
        JSONArray jSONArray = new JSONArray();
        View a2 = bj.a(activity);
        a(activity, a2, jSONArray, "", a2);
        return jSONArray;
    }

    public JSONObject a(Activity activity) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (activity == null) {
            return null;
        }
        try {
            if (!ak.a()) {
                return null;
            }
            int i2 = f1548d + 1;
            f1548d = i2;
            if (i2 >= 3) {
                ak.a(false);
            }
            Bitmap b2 = b(activity);
            if (b2 == null) {
                return null;
            }
            JSONArray c2 = c(activity);
            String a2 = com.baidu.mobstat.bt.a.a(c2.toString().getBytes());
            if (f1547c != null && f1547c.equals(a2)) {
                return null;
            }
            f1547c = a2;
            jSONObject = new JSONObject();
            try {
                jSONObject.put("screenshot", bj.a(b2));
                jSONObject.put("hash", bj.b(b2));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Config.DEVICE_WIDTH, b2.getWidth());
                jSONObject3.put("h", b2.getHeight());
                jSONObject.put("screen", jSONObject3);
                jSONObject.put("page", activity.getClass().getName());
                jSONObject.put("objects", c2);
            } catch (Throwable unused) {
                jSONObject2 = jSONObject;
            }
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject = jSONObject2;
            return jSONObject;
        }
    }

    public Bitmap b(Activity activity) {
        this.f1549a.a(activity);
        FutureTask futureTask = new FutureTask(this.f1549a);
        this.f1550b.post(futureTask);
        List emptyList = Collections.emptyList();
        try {
            emptyList = (List) futureTask.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            bc.c().b("autotrace: Screenshot interrupted, no screenshot will be sent.", e2);
        } catch (TimeoutException e3) {
            bc.c().c("autotrace: Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e3);
        } catch (Exception e4) {
            bc.c().d("autotrace: Exception thrown during screenshot attempt", e4);
        }
        if (emptyList.size() == 0) {
            return null;
        }
        return ((c) emptyList.get(0)).f1560c.f1551a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.app.Activity r13, android.view.View r14, org.json.JSONArray r15, java.lang.String r16, android.view.View r17) throws java.lang.Exception {
        /*
            r12 = this;
            r6 = r13
            r0 = r14
            r1 = r16
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.graphics.Rect r2 = com.baidu.mobstat.bj.e(r14)
            if (r2 != 0) goto L_0x000e
            return
        L_0x000e:
            boolean r3 = com.baidu.mobstat.ai.a(r14)
            if (r3 == 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r3 = com.baidu.mobstat.bj.l(r14)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x0020
            return
        L_0x0020:
            boolean r4 = com.baidu.mobstat.bj.c(r13, r14)
            if (r4 == 0) goto L_0x0027
            return
        L_0x0027:
            java.lang.String r4 = com.baidu.mobstat.bj.c(r14)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0042
            java.lang.String r4 = com.baidu.mobstat.bj.a(r14, r1)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0042
            r7 = r17
            java.lang.String r4 = com.baidu.mobstat.bj.a(r14, r7)
            goto L_0x0044
        L_0x0042:
            r7 = r17
        L_0x0044:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x004b
            return
        L_0x004b:
            r8 = -1
            java.lang.Long r5 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0055 }
            long r8 = r5.longValue()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            r10 = 0
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x005c
            return
        L_0x005c:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = "p"
            r9.put(r10, r3)
            java.lang.String r3 = "i"
            r9.put(r3, r4)
            java.lang.String r10 = com.baidu.mobstat.bj.b(r14)
            java.lang.String r3 = "t"
            r9.put(r3, r10)
            r8.put(r9)
            java.lang.String r3 = "path"
            r5.put(r3, r8)
            java.lang.String r3 = "type"
            r5.put(r3, r10)
            java.lang.String r3 = com.baidu.mobstat.bj.a(r14)
            java.lang.String r4 = "value"
            r5.put(r4, r3)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            int r4 = r2.left
            float r4 = (float) r4
            int r4 = com.baidu.mobstat.ah.a(r13, r4)
            java.lang.String r8 = "x"
            r3.put(r8, r4)
            int r4 = r2.top
            float r4 = (float) r4
            int r4 = com.baidu.mobstat.ah.a(r13, r4)
            java.lang.String r8 = "y"
            r3.put(r8, r4)
            int r4 = r2.width()
            float r4 = (float) r4
            int r4 = com.baidu.mobstat.ah.a(r13, r4)
            java.lang.String r8 = "w"
            r3.put(r8, r4)
            int r4 = r2.height()
            float r4 = (float) r4
            int r4 = com.baidu.mobstat.ah.a(r13, r4)
            java.lang.String r8 = "h"
            r3.put(r8, r4)
            java.lang.String r4 = "frame"
            r5.put(r4, r3)
            int r3 = com.baidu.mobstat.bj.i(r14)
            java.lang.String r4 = "alpha"
            r5.put(r4, r3)
            java.lang.Class r3 = r13.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "page"
            r5.put(r4, r3)
            float r3 = com.baidu.mobstat.bj.j(r14)
            double r3 = (double) r3
            java.lang.String r8 = "z"
            r5.put(r8, r3)
            boolean r3 = r0 instanceof android.webkit.WebView
            java.lang.String r4 = "child"
            if (r3 == 0) goto L_0x0133
            r8 = 0
            r9 = r0
            android.webkit.WebView r9 = (android.webkit.WebView) r9
            java.lang.String r2 = com.baidu.mobstat.bl.a(r13, r9, r2)
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r11 = "url"
            if (r9 != 0) goto L_0x0118
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r2)
            java.lang.String r2 = r8.optString(r11)
            java.lang.String r9 = "objects"
            org.json.JSONArray r8 = r8.optJSONArray(r9)
            goto L_0x011a
        L_0x0118:
            java.lang.String r2 = ""
        L_0x011a:
            if (r8 != 0) goto L_0x0121
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
        L_0x0121:
            r5.put(r4, r8)
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 == 0) goto L_0x0130
            java.lang.String r2 = "/"
            r5.put(r11, r2)
            goto L_0x0133
        L_0x0130:
            r5.put(r11, r2)
        L_0x0133:
            boolean r1 = com.baidu.mobstat.bj.b(r14, r1)
            java.lang.String r2 = "edit"
            r5.put(r2, r1)
            r1 = r15
            r15.put(r5)
            if (r3 == 0) goto L_0x0143
            return
        L_0x0143:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x016a
            r8 = r0
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            org.json.JSONArray r9 = new org.json.JSONArray
            r9.<init>()
            r5.put(r4, r9)
            r0 = 0
            r11 = r0
        L_0x0154:
            int r0 = r8.getChildCount()
            if (r11 >= r0) goto L_0x0172
            android.view.View r2 = r8.getChildAt(r11)
            r0 = r12
            r1 = r13
            r3 = r9
            r4 = r10
            r5 = r17
            r0.a(r1, r2, r3, r4, r5)
            int r11 = r11 + 1
            goto L_0x0154
        L_0x016a:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r5.put(r4, r0)
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.an.a(android.app.Activity, android.view.View, org.json.JSONArray, java.lang.String, android.view.View):void");
    }
}
