package d.h.d;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ActivityRecreator */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public static final Class<?> f4769a;

    /* renamed from: b reason: collision with root package name */
    public static final Field f4770b;

    /* renamed from: c reason: collision with root package name */
    public static final Field f4771c;

    /* renamed from: d reason: collision with root package name */
    public static final Method f4772d;

    /* renamed from: e reason: collision with root package name */
    public static final Method f4773e;

    /* renamed from: f reason: collision with root package name */
    public static final Method f4774f;

    /* renamed from: g reason: collision with root package name */
    public static final Handler f4775g = new Handler(Looper.getMainLooper());

    /* compiled from: ActivityRecreator */
    public static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ c f4776a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Object f4777b;

        public a(c cVar, Object obj) {
            this.f4776a = cVar;
            this.f4777b = obj;
        }

        public void run() {
            this.f4776a.f4780a = this.f4777b;
        }
    }

    /* renamed from: d.h.d.b$b reason: collision with other inner class name */
    /* compiled from: ActivityRecreator */
    public static class C0035b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Application f4778a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ c f4779b;

        public C0035b(Application application, c cVar) {
            this.f4778a = application;
            this.f4779b = cVar;
        }

        public void run() {
            this.f4778a.unregisterActivityLifecycleCallbacks(this.f4779b);
        }
    }

    /* compiled from: ActivityRecreator */
    public static final class c implements ActivityLifecycleCallbacks {

        /* renamed from: a reason: collision with root package name */
        public Object f4780a;

        /* renamed from: b reason: collision with root package name */
        public Activity f4781b;

        /* renamed from: c reason: collision with root package name */
        public boolean f4782c = false;

        /* renamed from: d reason: collision with root package name */
        public boolean f4783d = false;

        /* renamed from: e reason: collision with root package name */
        public boolean f4784e = false;

        public c(Activity activity) {
            this.f4781b = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f4781b == activity) {
                this.f4781b = null;
                this.f4783d = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f4783d && !this.f4784e && !this.f4782c) {
                Object obj = this.f4780a;
                boolean z = false;
                try {
                    Object obj2 = b.f4771c.get(activity);
                    if (obj2 == obj) {
                        b.f4775g.postAtFrontOfQueue(new c(b.f4770b.get(activity), obj2));
                        z = true;
                    }
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while fetching field values", th);
                }
                if (z) {
                    this.f4784e = true;
                    this.f4780a = null;
                }
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f4781b == activity) {
                this.f4782c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A[SYNTHETIC, Splitter:B:25:0x005d] */
    static {
        /*
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            f4775g = r0
            r0 = 0
            java.lang.String r1 = "android.app.ActivityThread"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            f4769a = r1
            r1 = 1
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.String r3 = "mMainThread"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ all -> 0x0023 }
            r2.setAccessible(r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r2 = r0
        L_0x0024:
            f4770b = r2
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.String r3 = "mToken"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ all -> 0x0032 }
            r2.setAccessible(r1)     // Catch:{ all -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r2 = r0
        L_0x0033:
            f4771c = r2
            java.lang.Class<?> r2 = f4769a
            r3 = 3
            java.lang.String r4 = "performStopActivity"
            r5 = 2
            r6 = 0
            if (r2 != 0) goto L_0x0040
        L_0x003e:
            r2 = r0
            goto L_0x0055
        L_0x0040:
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x003e }
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch:{ all -> 0x003e }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x003e }
            r7[r1] = r8     // Catch:{ all -> 0x003e }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r5] = r8     // Catch:{ all -> 0x003e }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x003e }
            r2.setAccessible(r1)     // Catch:{ all -> 0x003e }
        L_0x0055:
            f4772d = r2
            java.lang.Class<?> r2 = f4769a
            if (r2 != 0) goto L_0x005d
        L_0x005b:
            r2 = r0
            goto L_0x006e
        L_0x005d:
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x005b }
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch:{ all -> 0x005b }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x005b }
            r7[r1] = r8     // Catch:{ all -> 0x005b }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x005b }
            r2.setAccessible(r1)     // Catch:{ all -> 0x005b }
        L_0x006e:
            f4773e = r2
            java.lang.Class<?> r2 = f4769a
            boolean r4 = a()
            if (r4 == 0) goto L_0x00b3
            if (r2 != 0) goto L_0x007b
            goto L_0x00b3
        L_0x007b:
            java.lang.String r4 = "requestRelaunchActivity"
            r7 = 9
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ all -> 0x00b3 }
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch:{ all -> 0x00b3 }
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r7[r1] = r6     // Catch:{ all -> 0x00b3 }
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r7[r5] = r6     // Catch:{ all -> 0x00b3 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00b3 }
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            r3 = 4
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b3 }
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            r3 = 5
            java.lang.Class<android.content.res.Configuration> r5 = android.content.res.Configuration.class
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            r3 = 6
            java.lang.Class<android.content.res.Configuration> r5 = android.content.res.Configuration.class
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            r3 = 7
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b3 }
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            r3 = 8
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b3 }
            r7[r3] = r5     // Catch:{ all -> 0x00b3 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x00b3 }
            r2.setAccessible(r1)     // Catch:{ all -> 0x00b3 }
            r0 = r2
        L_0x00b3:
            f4774f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.d.b.<clinit>():void");
    }

    public static boolean a(Activity activity) {
        Application application;
        c cVar;
        if (VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f4774f == null) {
            return false;
        } else {
            if (f4773e == null && f4772d == null) {
                return false;
            }
            try {
                Object obj = f4771c.get(activity);
                if (obj == null) {
                    return false;
                }
                Object obj2 = f4770b.get(activity);
                if (obj2 == null) {
                    return false;
                }
                application = activity.getApplication();
                cVar = new c(activity);
                application.registerActivityLifecycleCallbacks(cVar);
                f4775g.post(new a(cVar, obj));
                if (a()) {
                    f4774f.invoke(obj2, new Object[]{obj, null, null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), Boolean.valueOf(false)});
                } else {
                    activity.recreate();
                }
                f4775g.post(new C0035b(application, cVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static boolean a() {
        int i2 = VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }
}
