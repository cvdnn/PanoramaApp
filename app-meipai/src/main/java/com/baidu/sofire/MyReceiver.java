package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import e.c.f.c;
import e.c.f.n.m;

public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    public boolean f3261a = false;

    /* renamed from: b reason: collision with root package name */
    public long f3262b = 0;

    /* renamed from: c reason: collision with root package name */
    public long f3263c = 0;

    public class a extends Callback {
        public a(MyReceiver myReceiver) {
        }

        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    }

    public static class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Intent f3264a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Context f3265b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean f3266c;

        public b(Intent intent, Context context, boolean z) {
            this.f3264a = intent;
            this.f3265b = context;
            this.f3266c = z;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:50|51|70) */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0132 */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0095 A[Catch:{ all -> 0x016a }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0096 A[Catch:{ all -> 0x016a }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r14 = this;
                java.lang.String r0 = "c"
                java.lang.String r1 = "r"
                java.lang.String r2 = "t"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x016a }
                r3.<init>()     // Catch:{ all -> 0x016a }
                android.content.Intent r4 = r14.f3264a     // Catch:{ all -> 0x016a }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016a }
                r3.append(r4)     // Catch:{ all -> 0x016a }
                e.c.f.c.a()     // Catch:{ all -> 0x016a }
                android.content.Intent r3 = r14.f3264a     // Catch:{ all -> 0x016a }
                java.lang.String r3 = r3.getStringExtra(r2)     // Catch:{ all -> 0x016a }
                boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x016a }
                if (r3 == 0) goto L_0x0039
                android.content.Intent r3 = r14.f3264a     // Catch:{ all -> 0x016a }
                java.lang.String r3 = r3.getStringExtra(r0)     // Catch:{ all -> 0x016a }
                android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x016a }
                r4.<init>()     // Catch:{ all -> 0x016a }
                r4.putExtra(r2, r1)     // Catch:{ all -> 0x016a }
                r4.putExtra(r0, r3)     // Catch:{ all -> 0x016a }
                android.content.Context r0 = r14.f3265b     // Catch:{ all -> 0x016a }
                e.c.d.n.e.a(r0, r4)     // Catch:{ all -> 0x016a }
            L_0x0039:
                android.content.Intent r0 = r14.f3264a     // Catch:{ all -> 0x016a }
                java.lang.String r0 = r0.getAction()     // Catch:{ all -> 0x016a }
                boolean r1 = r14.f3266c     // Catch:{ all -> 0x016a }
                r2 = 3
                java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x006a
                boolean r1 = r3.equals(r0)     // Catch:{ all -> 0x016a }
                if (r1 == 0) goto L_0x006a
                android.content.Context r1 = r14.f3265b     // Catch:{ all -> 0x016a }
                boolean r1 = e.c.f.n.a.d(r1)     // Catch:{ all -> 0x016a }
                if (r1 == 0) goto L_0x006a
                boolean r1 = com.baidu.sofire.ac.U.sMonitorNetworkWhenUpgradeNoNet     // Catch:{ all -> 0x016a }
                if (r1 == 0) goto L_0x006a
                com.baidu.sofire.ac.U r1 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x016a }
                android.content.Context r6 = r14.f3265b     // Catch:{ all -> 0x016a }
                android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x016a }
                r1.<init>(r6, r2, r5)     // Catch:{ all -> 0x016a }
                r1.start()     // Catch:{ all -> 0x016a }
                r1 = r4
                goto L_0x006b
            L_0x006a:
                r1 = r5
            L_0x006b:
                boolean r6 = r14.f3266c     // Catch:{ all -> 0x016a }
                if (r6 == 0) goto L_0x0091
                boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x016a }
                if (r0 == 0) goto L_0x0091
                boolean r0 = e.c.f.n.a.f7036a     // Catch:{ all -> 0x016a }
                if (r0 == 0) goto L_0x0091
                if (r1 != 0) goto L_0x0091
                android.content.Context r0 = r14.f3265b     // Catch:{ all -> 0x016a }
                boolean r0 = e.c.f.n.a.c(r0)     // Catch:{ all -> 0x016a }
                if (r0 == 0) goto L_0x0091
                com.baidu.sofire.ac.U r0 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x016a }
                android.content.Context r1 = r14.f3265b     // Catch:{ all -> 0x016a }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x016a }
                r0.<init>(r1, r2, r5)     // Catch:{ all -> 0x016a }
                r0.start()     // Catch:{ all -> 0x016a }
            L_0x0091:
                boolean r0 = r14.f3266c     // Catch:{ all -> 0x016a }
                if (r0 == 0) goto L_0x0096
                return
            L_0x0096:
                android.content.Intent r0 = r14.f3264a     // Catch:{ all -> 0x016a }
                java.lang.String r1 = "from_plugin_package"
                java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x016a }
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x016a }
                if (r1 == 0) goto L_0x013a
                e.c.f.f.g r0 = e.c.f.f.g.f6978g     // Catch:{ all -> 0x016a }
                if (r0 != 0) goto L_0x00a9
                return
            L_0x00a9:
                java.util.List r0 = r0.a()     // Catch:{ all -> 0x016a }
                if (r0 == 0) goto L_0x0139
                r1 = r5
            L_0x00b0:
                int r2 = r0.size()     // Catch:{ all -> 0x016a }
                if (r1 >= r2) goto L_0x0139
                java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x016a }
                com.baidu.sofire.core.ApkInfo r2 = (com.baidu.sofire.core.ApkInfo) r2     // Catch:{ all -> 0x016a }
                java.util.List<e.c.f.f.h> r3 = r2.intentFilters     // Catch:{ all -> 0x016a }
                if (r3 == 0) goto L_0x0135
                r3 = r5
            L_0x00c1:
                java.util.List<e.c.f.f.h> r6 = r2.intentFilters     // Catch:{ all -> 0x0132 }
                int r6 = r6.size()     // Catch:{ all -> 0x0132 }
                if (r3 >= r6) goto L_0x0135
                java.util.List<e.c.f.f.h> r6 = r2.intentFilters     // Catch:{ all -> 0x0132 }
                java.lang.Object r6 = r6.get(r3)     // Catch:{ all -> 0x0132 }
                e.c.f.f.h r6 = (e.c.f.f.h) r6     // Catch:{ all -> 0x0132 }
                android.content.IntentFilter r7 = r6.f6991d     // Catch:{ all -> 0x0132 }
                android.content.Intent r8 = r14.f3264a     // Catch:{ all -> 0x0132 }
                java.lang.String r8 = r8.getAction()     // Catch:{ all -> 0x0132 }
                android.content.Intent r9 = r14.f3264a     // Catch:{ all -> 0x0132 }
                java.lang.String r9 = r9.getType()     // Catch:{ all -> 0x0132 }
                android.content.Intent r10 = r14.f3264a     // Catch:{ all -> 0x0132 }
                java.lang.String r10 = r10.getScheme()     // Catch:{ all -> 0x0132 }
                android.content.Intent r11 = r14.f3264a     // Catch:{ all -> 0x0132 }
                android.net.Uri r11 = r11.getData()     // Catch:{ all -> 0x0132 }
                android.content.Intent r12 = r14.f3264a     // Catch:{ all -> 0x0132 }
                java.util.Set r12 = r12.getCategories()     // Catch:{ all -> 0x0132 }
                java.lang.String r13 = "PIF"
                int r7 = r7.match(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0132 }
                if (r7 < 0) goto L_0x012f
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
                r7.<init>()     // Catch:{ all -> 0x0132 }
                r7.append(r2)     // Catch:{ all -> 0x0132 }
                java.lang.ClassLoader r7 = r2.classLoader     // Catch:{ all -> 0x0132 }
                java.lang.String r8 = r6.f6989b     // Catch:{ all -> 0x0132 }
                java.lang.Class r7 = r7.loadClass(r8)     // Catch:{ all -> 0x0132 }
                java.lang.Object r8 = r7.newInstance()     // Catch:{ all -> 0x0132 }
                java.lang.String r6 = r6.f6990c     // Catch:{ all -> 0x0132 }
                r9 = 2
                java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x0132 }
                java.lang.Class<android.content.Context> r11 = android.content.Context.class
                r10[r5] = r11     // Catch:{ all -> 0x0132 }
                java.lang.Class<android.content.Intent> r11 = android.content.Intent.class
                r10[r4] = r11     // Catch:{ all -> 0x0132 }
                java.lang.reflect.Method r6 = r7.getDeclaredMethod(r6, r10)     // Catch:{ all -> 0x0132 }
                java.lang.Object[] r7 = new java.lang.Object[r9]     // Catch:{ all -> 0x0132 }
                android.content.Context r9 = r14.f3265b     // Catch:{ all -> 0x0132 }
                android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0132 }
                r7[r5] = r9     // Catch:{ all -> 0x0132 }
                android.content.Intent r9 = r14.f3264a     // Catch:{ all -> 0x0132 }
                r7[r4] = r9     // Catch:{ all -> 0x0132 }
                r6.invoke(r8, r7)     // Catch:{ all -> 0x0132 }
            L_0x012f:
                int r3 = r3 + 1
                goto L_0x00c1
            L_0x0132:
                e.c.f.c.d()     // Catch:{ all -> 0x016a }
            L_0x0135:
                int r1 = r1 + 1
                goto L_0x00b0
            L_0x0139:
                return
            L_0x013a:
                android.content.Context r1 = r14.f3265b     // Catch:{ all -> 0x016a }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x016a }
                boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x016a }
                if (r1 == 0) goto L_0x0154
                android.content.Context r0 = r14.f3265b     // Catch:{ all -> 0x016a }
                java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ all -> 0x016a }
                android.content.Intent r1 = r14.f3264a     // Catch:{ all -> 0x016a }
                android.content.Context r2 = r14.f3265b     // Catch:{ all -> 0x016a }
                com.baidu.sofire.MyReceiver.a(r0, r1, r2)     // Catch:{ all -> 0x016a }
                return
            L_0x0154:
                e.c.f.f.g r1 = e.c.f.f.g.f6978g     // Catch:{ all -> 0x016a }
                if (r1 != 0) goto L_0x0159
                return
            L_0x0159:
                com.baidu.sofire.core.ApkInfo r0 = r1.c(r0)     // Catch:{ all -> 0x016a }
                if (r0 != 0) goto L_0x0160
                return
            L_0x0160:
                java.lang.ClassLoader r0 = r0.classLoader     // Catch:{ all -> 0x016a }
                android.content.Intent r1 = r14.f3264a     // Catch:{ all -> 0x016a }
                android.content.Context r2 = r14.f3265b     // Catch:{ all -> 0x016a }
                com.baidu.sofire.MyReceiver.a(r0, r1, r2)     // Catch:{ all -> 0x016a }
                return
            L_0x016a:
                e.c.f.c.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.MyReceiver.b.run():void");
        }
    }

    public MyReceiver() {
        new a(this);
    }

    public final MyReceiver a() {
        try {
            this.f3262b = System.currentTimeMillis();
            this.f3261a = true;
        } catch (Throwable unused) {
            c.d();
        }
        return this;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(intent.toString());
                sb.append(", ins=");
                sb.append(this);
                c.a();
                if (!this.f3261a || System.currentTimeMillis() - this.f3262b >= 2000) {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        if (System.currentTimeMillis() - this.f3263c >= 100 && e.c.f.n.a.d(context)) {
                            this.f3263c = System.currentTimeMillis();
                        } else {
                            return;
                        }
                    }
                    new StringBuilder("_2_").append(intent.toString());
                    m.a().a(new b(intent, context.getApplicationContext(), this.f3261a));
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    public static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            Object newInstance = loadClass.newInstance();
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), new Class[]{Context.class, Intent.class}).invoke(newInstance, new Object[]{context.getApplicationContext(), intent});
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
    }
}
