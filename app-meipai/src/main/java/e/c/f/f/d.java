package e.c.f.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.sofire.core.ApkInfo;
import e.c.f.c;
import e.c.f.e;
import e.c.f.i;
import e.c.f.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ForHostApp */
public final class d implements OnSharedPreferenceChangeListener {

    /* renamed from: e reason: collision with root package name */
    public static d f6938e;

    /* renamed from: f reason: collision with root package name */
    public static Context f6939f;

    /* renamed from: g reason: collision with root package name */
    public static int f6940g;

    /* renamed from: h reason: collision with root package name */
    public static List<Integer> f6941h = new ArrayList();

    /* renamed from: a reason: collision with root package name */
    public volatile boolean f6942a = false;

    /* renamed from: b reason: collision with root package name */
    public i f6943b;

    /* renamed from: c reason: collision with root package name */
    public l f6944c;

    /* renamed from: d reason: collision with root package name */
    public e.c.f.d.a f6945d;

    /* compiled from: ForHostApp */
    public class a implements Comparator<ApkInfo> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ List f6946a;

        public a(d dVar, List list) {
            this.f6946a = list;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ApkInfo apkInfo = (ApkInfo) obj;
            ApkInfo apkInfo2 = (ApkInfo) obj2;
            if (apkInfo.priority == -1 && apkInfo2.priority != -1) {
                return 1;
            }
            if (apkInfo.priority != -1 && apkInfo2.priority == -1) {
                return -1;
            }
            int i2 = apkInfo.priority;
            int i3 = apkInfo2.priority;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            List list = this.f6946a;
            int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo.key))) ? -1 : this.f6946a.indexOf(Integer.valueOf(apkInfo.key));
            List list2 = this.f6946a;
            int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo2.key))) ? -1 : this.f6946a.indexOf(Integer.valueOf(apkInfo2.key));
            if (indexOf != -1 && indexOf2 == -1) {
                return -1;
            }
            if ((indexOf == -1 && indexOf2 != -1) || indexOf > indexOf2) {
                return 1;
            }
            if (indexOf < indexOf2) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: ForHostApp */
    public class b extends Thread {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f6947a;

        /* compiled from: ForHostApp */
        public class a extends TimerTask {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ g f6949a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ ApkInfo f6950b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ File f6951c;

            public a(g gVar, ApkInfo apkInfo, File file) {
                this.f6949a = gVar;
                this.f6950b = apkInfo;
                this.f6951c = file;
            }

            public final void run() {
                new StringBuilder().append(System.currentTimeMillis());
                c.a();
                ApkInfo c2 = this.f6949a.c(b.this.f6947a);
                if (c2 != null) {
                    String str = c2.versionName;
                    if (str != null && str.equals(this.f6950b.versionName)) {
                        this.f6949a.b(b.this.f6947a);
                        b bVar = b.this;
                        d.this.f6945d.a(bVar.f6947a);
                        e.c.f.n.a.b(d.f6939f);
                        File file = new File(this.f6950b.pkgPath);
                        StringBuilder sb = new StringBuilder("f=");
                        sb.append(file.getAbsolutePath());
                        sb.append(", e=");
                        sb.append(file.exists());
                        String str2 = " s=";
                        if (file.exists()) {
                            e.a(file);
                            boolean delete = file.delete();
                            StringBuilder sb2 = new StringBuilder("d: ");
                            sb2.append(file.getAbsolutePath());
                            sb2.append(str2);
                            sb2.append(delete);
                        }
                        if (this.f6951c.exists()) {
                            File file2 = this.f6951c;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.f6950b.key);
                            sb3.append("-");
                            sb3.append(this.f6950b.versionName);
                            File file3 = new File(file2, sb3.toString());
                            if (e.c.f.n.a.a(file3)) {
                                boolean delete2 = file3.delete();
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(file3.getAbsolutePath());
                                sb4.append(str2);
                                sb4.append(delete2);
                            }
                        }
                        String sb5 = new StringBuilder(b.this.f6947a).reverse().toString();
                        ApkInfo b2 = d.this.f6945d.b(sb5);
                        if (b2 != null) {
                            d.this.a(sb5, b2.pkgPath);
                        }
                    }
                }
            }
        }

        public b(String str) {
            this.f6947a = str;
        }

        public final void run() {
            String str = ", i=";
            super.run();
            try {
                if (!TextUtils.isEmpty(this.f6947a)) {
                    g a2 = g.a(d.f6939f.getApplicationContext());
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f6947a);
                    sb.append(", h=");
                    sb.append(a2);
                    c.a();
                    if (a2 != null) {
                        File file = new File(d.f6939f.getFilesDir(), ".b");
                        ApkInfo c2 = a2.c(this.f6947a);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f6947a);
                        sb2.append(str);
                        sb2.append(c2);
                        c.a();
                        String str2 = "-";
                        String str3 = " s=";
                        if (c2 == null) {
                            ApkInfo b2 = d.this.f6945d.b(this.f6947a);
                            if (b2 != null) {
                                d.this.a(this.f6947a, b2.pkgPath);
                                if (file.exists()) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(b2.key);
                                    sb3.append(str2);
                                    sb3.append(b2.versionName);
                                    File file2 = new File(file, sb3.toString());
                                    if (e.c.f.n.a.a(file2)) {
                                        boolean delete = file2.delete();
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(file2.getAbsolutePath());
                                        sb4.append(str3);
                                        sb4.append(delete);
                                    }
                                }
                                String canonicalPath = d.f6939f.getFilesDir().getCanonicalPath();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(canonicalPath);
                                sb5.append("/.");
                                sb5.append(b2.key);
                                e.c.f.n.a.d(sb5.toString());
                                e.c.f.n.a.d(d.f6939f.getFileStreamPath(b2.packageName).getAbsolutePath());
                                String sb6 = new StringBuilder(this.f6947a).reverse().toString();
                                ApkInfo b3 = d.this.f6945d.b(sb6);
                                if (b3 != null) {
                                    d.this.a(sb6, b3.pkgPath);
                                }
                                return;
                            }
                            return;
                        }
                        Class a3 = ((f) c2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object invoke = a3.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a3, new Object[]{d.f6939f});
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(this.f6947a);
                        sb7.append(str);
                        sb7.append(invoke);
                        if (invoke != null) {
                            new StringBuilder("t:").append(System.currentTimeMillis());
                            new Timer().schedule(new a(a2, c2, file), 600000);
                            Object a4 = e.c.f.n.a.a(invoke, "unload", (Class<?>[]) null, new Object[0]);
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(this.f6947a);
                            sb8.append("object=");
                            sb8.append(a4);
                            a2.b(this.f6947a);
                            d.this.f6945d.a(this.f6947a);
                            e.c.f.n.a.b(d.f6939f);
                            File file3 = new File(c2.pkgPath);
                            StringBuilder sb9 = new StringBuilder("f=");
                            sb9.append(file3.getAbsolutePath());
                            sb9.append(", e=");
                            sb9.append(file3.exists());
                            if (file3.exists()) {
                                e.a(file3);
                                boolean delete2 = file3.delete();
                                StringBuilder sb10 = new StringBuilder("d: ");
                                sb10.append(file3.getAbsolutePath());
                                sb10.append(str3);
                                sb10.append(delete2);
                            }
                            if (file.exists()) {
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append(c2.key);
                                sb11.append(str2);
                                sb11.append(c2.versionName);
                                File file4 = new File(file, sb11.toString());
                                if (e.c.f.n.a.a(file4)) {
                                    boolean delete3 = file4.delete();
                                    StringBuilder sb12 = new StringBuilder();
                                    sb12.append(file4.getAbsolutePath());
                                    sb12.append(str3);
                                    sb12.append(delete3);
                                }
                            }
                            String sb13 = new StringBuilder(this.f6947a).reverse().toString();
                            ApkInfo b4 = d.this.f6945d.b(sb13);
                            if (b4 != null) {
                                d.this.a(sb13, b4.pkgPath);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
                c.c();
            }
        }
    }

    public d(Context context) {
        c.a();
        Context applicationContext = context.getApplicationContext();
        f6939f = applicationContext;
        this.f6945d = e.c.f.d.a.a(applicationContext);
        this.f6943b = new i(f6939f);
        l lVar = new l(f6939f);
        this.f6944c = lVar;
        SharedPreferences sharedPreferences = lVar.f7028a;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f6938e == null) {
                f6938e = new d(context.getApplicationContext());
            }
            dVar = f6938e;
        }
        return dVar;
    }

    public final void b() {
        try {
            List a2 = this.f6945d.a();
            new StringBuilder("all=").append(a2);
            c.a();
            List g2 = this.f6943b.g();
            List f2 = this.f6943b.f();
            int i2 = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) f2;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ArrayList arrayList2 = (ArrayList) g2;
                if (!arrayList2.contains(arrayList.get(i2))) {
                    arrayList2.add(arrayList.get(i2));
                }
                i2++;
            }
            Collections.sort(a2, new a(this, g2));
            Iterator it = ((ArrayList) a2).iterator();
            while (it.hasNext()) {
                ApkInfo apkInfo = (ApkInfo) it.next();
                g gVar = g.f6978g;
                if ((gVar != null ? gVar.c(apkInfo.packageName) : null) == null) {
                    boolean z = this.f6945d.g(apkInfo.key) != 3;
                    String str = "-";
                    String str2 = ".b";
                    if (!this.f6943b.b() || !z) {
                        File file = new File(f6939f.getFilesDir(), str2);
                        if (file.exists()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo.key);
                            sb.append(str);
                            sb.append(apkInfo.versionName);
                            File file2 = new File(file, sb.toString());
                            if (e.c.f.n.a.a(file2)) {
                                e.a(file2);
                                boolean delete = file2.delete();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(file2.getAbsolutePath());
                                sb2.append(" s=");
                                sb2.append(delete);
                            }
                        }
                    } else {
                        File file3 = new File(f6939f.getFilesDir(), str2);
                        if (!file3.exists()) {
                            file3.mkdir();
                        }
                        File file4 = new File(apkInfo.pkgPath);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(apkInfo.key);
                        sb3.append(str);
                        sb3.append(apkInfo.versionName);
                        File file5 = new File(file3, sb3.toString());
                        if (!e.c.f.n.a.a(file5)) {
                            e.c.f.n.a.a(file4, file5);
                        }
                        e.a(f6939f, apkInfo.key, file4, file5);
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String str2 = "xytk";
        if (str != null) {
            try {
                if (str.equals(str2)) {
                    c.a();
                    e.f6953a = this.f6944c.f7028a.getString(str2, "");
                }
                if (str.equals("xyus")) {
                    this.f6943b.e();
                    c.a();
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:33|34|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0110 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x011f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.f6942a     // Catch:{ all -> 0x011f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r9)
            return
        L_0x0007:
            r0 = 1
            r9.f6942a = r0     // Catch:{ all -> 0x011f }
            android.content.Context r1 = f6939f     // Catch:{ all -> 0x011f }
            e.c.f.n.a.j(r1)     // Catch:{ all -> 0x011f }
            e.c.f.i r1 = r9.f6943b     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r2 = r1.f7009c     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "s_c_c"
            r2.putBoolean(r3, r0)     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r1 = r1.f7009c     // Catch:{ all -> 0x011f }
            r1.commit()     // Catch:{ all -> 0x011f }
            android.content.Context r1 = f6939f     // Catch:{ all -> 0x011f }
            org.json.JSONObject r1 = e.c.f.n.a.k(r1)     // Catch:{ all -> 0x011f }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x011f }
            e.c.f.c.a()     // Catch:{ all -> 0x011f }
            java.lang.String r6 = "3.3.9.8.2"
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x0031
            goto L_0x0048
        L_0x0031:
            java.lang.String r5 = "com.baidu.sofire"
            com.baidu.sofire.rp.Report r3 = com.baidu.sofire.rp.Report.getInstance(r2)     // Catch:{ all -> 0x011f }
            e.c.f.n.a.b(r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "sofire"
            java.lang.String r7 = "1003003"
            java.lang.String r8 = "1003002"
            r3.i(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r2 = move-exception
            r2.getMessage()     // Catch:{ all -> 0x011f }
        L_0x0048:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r2.<init>()     // Catch:{ all -> 0x011f }
            boolean r3 = r9.f6942a     // Catch:{ all -> 0x011f }
            r2.append(r3)     // Catch:{ all -> 0x011f }
            e.c.f.i r2 = r9.f6943b     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "3.3.9.8.2"
            android.content.SharedPreferences$Editor r4 = r2.f7009c     // Catch:{ all -> 0x011f }
            java.lang.String r5 = "ssv"
            r4.putString(r5, r3)     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r2 = r2.f7009c     // Catch:{ all -> 0x011f }
            r2.commit()     // Catch:{ all -> 0x011f }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x011f }
            com.baidu.sofire.rp.Report r2 = com.baidu.sofire.rp.Report.getInstance(r2)     // Catch:{ all -> 0x011f }
            r2.n()     // Catch:{ all -> 0x011f }
            e.c.f.d.a r2 = r9.f6945d     // Catch:{ all -> 0x011f }
            java.util.List r2 = r2.a()     // Catch:{ all -> 0x011f }
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x011f }
        L_0x0077:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x011f }
            r4 = 0
            if (r3 == 0) goto L_0x00c3
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x011f }
            com.baidu.sofire.core.ApkInfo r3 = (com.baidu.sofire.core.ApkInfo) r3     // Catch:{ all -> 0x011f }
            android.content.Context r5 = f6939f     // Catch:{ IOException -> 0x008f }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ IOException -> 0x008f }
            java.lang.String r4 = r5.getCanonicalPath()     // Catch:{ IOException -> 0x008f }
            goto L_0x0092
        L_0x008f:
            e.c.f.c.d()     // Catch:{ all -> 0x011f }
        L_0x0092:
            if (r4 == 0) goto L_0x0077
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r5.<init>()     // Catch:{ all -> 0x011f }
            r5.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "/."
            r5.append(r4)     // Catch:{ all -> 0x011f }
            int r4 = r3.key     // Catch:{ all -> 0x011f }
            r5.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x011f }
            r3.dataDir = r4     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.dataDir     // Catch:{ all -> 0x011f }
            r4.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "/lib"
            r4.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x011f }
            e.c.f.n.a.d(r3)     // Catch:{ all -> 0x011f }
            goto L_0x0077
        L_0x00c3:
            e.c.f.d.a r2 = r9.f6945d     // Catch:{ all -> 0x011f }
            r2.d()     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r2.<init>()     // Catch:{ all -> 0x011f }
            e.c.f.i r3 = r9.f6943b     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences r3 = r3.f7007a     // Catch:{ all -> 0x011f }
            java.lang.String r5 = "iio"
            r6 = 0
            boolean r3 = r3.getBoolean(r5, r6)     // Catch:{ all -> 0x011f }
            r2.append(r3)     // Catch:{ all -> 0x011f }
            e.c.f.i r2 = r9.f6943b     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences r2 = r2.f7007a     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "iio"
            boolean r2 = r2.getBoolean(r3, r6)     // Catch:{ all -> 0x011f }
            if (r2 != 0) goto L_0x00f6
            e.c.f.i r2 = r9.f6943b     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r3 = r2.f7009c     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "iio"
            r3.putBoolean(r4, r0)     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r2 = r2.f7009c     // Catch:{ all -> 0x011f }
            r2.commit()     // Catch:{ all -> 0x011f }
            goto L_0x0113
        L_0x00f6:
            e.c.f.d.a r2 = r9.f6945d     // Catch:{ all -> 0x011f }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x011f }
            r3.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r5 = "n"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x011f }
            r3.put(r5, r7)     // Catch:{ all -> 0x011f }
            android.database.sqlite.SQLiteDatabase r2 = r2.f6918d     // Catch:{ all -> 0x0110 }
            java.lang.String r5 = "pgn"
            java.lang.String r7 = "n=-1"
            r2.update(r5, r3, r7, r4)     // Catch:{ all -> 0x0110 }
            goto L_0x0113
        L_0x0110:
            e.c.f.c.d()     // Catch:{ all -> 0x011f }
        L_0x0113:
            com.baidu.sofire.ac.U r2 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x011f }
            android.content.Context r3 = f6939f     // Catch:{ all -> 0x011f }
            r2.<init>(r3, r0, r6, r1)     // Catch:{ all -> 0x011f }
            r2.start()     // Catch:{ all -> 0x011f }
            monitor-exit(r9)
            return
        L_0x011f:
            e.c.f.c.d()     // Catch:{ all -> 0x0124 }
            monitor-exit(r9)
            return
        L_0x0124:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a():void");
    }

    public static void b(String str) {
        new StringBuilder().append(str);
        c.a();
        try {
            if (!TextUtils.isEmpty(str)) {
                g gVar = g.f6978g;
                if (gVar != null) {
                    ApkInfo c2 = gVar.c(str);
                    if (c2 != null) {
                        Class a2 = ((f) c2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object invoke = a2.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a2, new Object[]{f6939f});
                        if (invoke != null) {
                            new StringBuilder().append(e.c.f.n.a.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                            gVar.b(str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:52|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|46|78) */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        e.c.f.c.d();
        r9 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x010d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x012b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.json.JSONObject r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "t"
            java.lang.String r3 = "n"
            java.lang.String r4 = "l"
            java.lang.String r5 = "lpcf"
            e.c.f.i r6 = r0.f6943b     // Catch:{ all -> 0x0167 }
            android.content.SharedPreferences r6 = r6.f7007a     // Catch:{ all -> 0x0167 }
            r7 = 0
            boolean r6 = r6.getBoolean(r5, r7)     // Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x0166
            if (r1 != 0) goto L_0x001b
            goto L_0x0166
        L_0x001b:
            java.lang.String r6 = "6"
            org.json.JSONArray r1 = r1.optJSONArray(r6)     // Catch:{ all -> 0x0167 }
            r6 = 1
            if (r1 == 0) goto L_0x0036
            int r8 = r1.length()     // Catch:{ all -> 0x0167 }
            if (r8 <= 0) goto L_0x0036
            e.c.f.i r8 = r0.f6943b     // Catch:{ all -> 0x0167 }
            android.content.SharedPreferences$Editor r9 = r8.f7009c     // Catch:{ all -> 0x0167 }
            r9.putBoolean(r5, r6)     // Catch:{ all -> 0x0167 }
            android.content.SharedPreferences$Editor r5 = r8.f7009c     // Catch:{ all -> 0x0167 }
            r5.commit()     // Catch:{ all -> 0x0167 }
        L_0x0036:
            if (r1 != 0) goto L_0x0039
            return
        L_0x0039:
            r5 = r7
        L_0x003a:
            int r8 = r1.length()     // Catch:{ all -> 0x0167 }
            if (r5 >= r8) goto L_0x015a
            org.json.JSONObject r8 = r1.optJSONObject(r5)     // Catch:{ all -> 0x0167 }
            java.lang.String r10 = "errno"
            int r10 = r8.optInt(r10)     // Catch:{ all -> 0x0167 }
            int r11 = r8.optInt(r4)     // Catch:{ all -> 0x0167 }
            if (r10 != r6) goto L_0x0154
            java.lang.String r10 = "detail"
            org.json.JSONObject r8 = r8.optJSONObject(r10)     // Catch:{ all -> 0x012b }
            android.content.pm.PackageInfo r10 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x012b }
            r10.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r12 = "p"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ all -> 0x012b }
            r10.packageName = r12     // Catch:{ all -> 0x012b }
            java.lang.String r12 = "v"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ all -> 0x012b }
            r10.versionName = r12     // Catch:{ all -> 0x012b }
            android.content.pm.ApplicationInfo r12 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x012b }
            r12.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r13 = r8.optString(r3)     // Catch:{ all -> 0x012b }
            r12.className = r13     // Catch:{ all -> 0x012b }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x012b }
            java.lang.String r14 = "."
            if (r13 != 0) goto L_0x009b
            java.lang.String r13 = r12.className     // Catch:{ all -> 0x012b }
            boolean r13 = r13.startsWith(r14)     // Catch:{ all -> 0x012b }
            if (r13 == 0) goto L_0x009b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r13.<init>()     // Catch:{ all -> 0x012b }
            java.lang.String r15 = r10.packageName     // Catch:{ all -> 0x012b }
            r13.append(r15)     // Catch:{ all -> 0x012b }
            java.lang.String r15 = r12.className     // Catch:{ all -> 0x012b }
            r13.append(r15)     // Catch:{ all -> 0x012b }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x012b }
            r12.className = r13     // Catch:{ all -> 0x012b }
        L_0x009b:
            int r13 = r8.optInt(r2)     // Catch:{ all -> 0x012b }
            r12.theme = r13     // Catch:{ all -> 0x012b }
            r10.applicationInfo = r12     // Catch:{ all -> 0x012b }
            java.lang.String r12 = "a"
            org.json.JSONArray r8 = r8.optJSONArray(r12)     // Catch:{ all -> 0x012b }
            if (r8 == 0) goto L_0x0129
            int r12 = r8.length()     // Catch:{ all -> 0x012b }
            if (r12 <= 0) goto L_0x0129
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x012b }
            r12.<init>()     // Catch:{ all -> 0x012b }
            r13 = r7
        L_0x00b7:
            int r15 = r8.length()     // Catch:{ all -> 0x012b }
            if (r13 >= r15) goto L_0x0115
            org.json.JSONObject r15 = r8.getJSONObject(r13)     // Catch:{ all -> 0x010d }
            if (r15 == 0) goto L_0x0110
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x010d }
            r6.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r7 = r15.optString(r3)     // Catch:{ all -> 0x010d }
            r6.name = r7     // Catch:{ all -> 0x010d }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010d }
            if (r7 != 0) goto L_0x00f1
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x010d }
            boolean r7 = r7.startsWith(r14)     // Catch:{ all -> 0x010d }
            if (r7 == 0) goto L_0x00f1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010d }
            r7.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r9 = r10.packageName     // Catch:{ all -> 0x010d }
            r7.append(r9)     // Catch:{ all -> 0x010d }
            java.lang.String r9 = r6.name     // Catch:{ all -> 0x010d }
            r7.append(r9)     // Catch:{ all -> 0x010d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010d }
            r6.name = r7     // Catch:{ all -> 0x010d }
        L_0x00f1:
            java.lang.String r7 = r10.packageName     // Catch:{ all -> 0x010d }
            r6.packageName = r7     // Catch:{ all -> 0x010d }
            int r7 = r15.optInt(r2)     // Catch:{ all -> 0x010d }
            r6.theme = r7     // Catch:{ all -> 0x010d }
            int r7 = r15.optInt(r4)     // Catch:{ all -> 0x010d }
            r6.labelRes = r7     // Catch:{ all -> 0x010d }
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x010d }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010d }
            if (r7 != 0) goto L_0x0110
            r12.add(r6)     // Catch:{ all -> 0x010d }
            goto L_0x0110
        L_0x010d:
            e.c.f.c.d()     // Catch:{ all -> 0x012b }
        L_0x0110:
            int r13 = r13 + 1
            r6 = 1
            r7 = 0
            goto L_0x00b7
        L_0x0115:
            int r6 = r12.size()     // Catch:{ all -> 0x012b }
            if (r6 <= 0) goto L_0x0129
            int r6 = r12.size()     // Catch:{ all -> 0x012b }
            android.content.pm.ActivityInfo[] r6 = new android.content.pm.ActivityInfo[r6]     // Catch:{ all -> 0x012b }
            java.lang.Object[] r6 = r12.toArray(r6)     // Catch:{ all -> 0x012b }
            android.content.pm.ActivityInfo[] r6 = (android.content.pm.ActivityInfo[]) r6     // Catch:{ all -> 0x012b }
            r10.activities = r6     // Catch:{ all -> 0x012b }
        L_0x0129:
            r9 = r10
            goto L_0x012f
        L_0x012b:
            e.c.f.c.d()     // Catch:{ all -> 0x0167 }
            r9 = 0
        L_0x012f:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r6 = e.c.f.n.a.k     // Catch:{ all -> 0x0167 }
            if (r6 == 0) goto L_0x0154
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r6 = e.c.f.n.a.k     // Catch:{ all -> 0x0167 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0167 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0167 }
            com.baidu.sofire.core.ApkInfo r6 = (com.baidu.sofire.core.ApkInfo) r6     // Catch:{ all -> 0x0167 }
            if (r6 == 0) goto L_0x0154
            if (r9 == 0) goto L_0x0154
            java.lang.String r7 = r9.packageName     // Catch:{ all -> 0x0167 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0167 }
            if (r7 != 0) goto L_0x0154
            int r7 = r6.key     // Catch:{ all -> 0x0167 }
            java.lang.String r8 = r6.versionName     // Catch:{ all -> 0x0167 }
            java.lang.String r6 = r6.apkMD5     // Catch:{ all -> 0x0167 }
            r0.a(r7, r8, r6, r9)     // Catch:{ all -> 0x0167 }
        L_0x0154:
            int r5 = r5 + 1
            r6 = 1
            r7 = 0
            goto L_0x003a
        L_0x015a:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r1 = e.c.f.n.a.k     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x0166
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r1 = e.c.f.n.a.k     // Catch:{ all -> 0x0167 }
            r1.clear()     // Catch:{ all -> 0x0167 }
            r1 = 0
            e.c.f.n.a.k = r1     // Catch:{ all -> 0x0167 }
        L_0x0166:
            return
        L_0x0167:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a(org.json.JSONObject):void");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:22|(1:24)|25|26|27|28|29|(2:30|(1:32)(1:135))|33|(2:35|(1:37)(5:38|(1:40)(1:41)|42|43|(2:54|(2:56|(1:58)))(6:46|47|(1:49)|50|(1:52)|53)))|59|60|61|62|63|64) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0185 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v3
  assigns: []
  uses: []
  mth insns count: 194
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
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ce A[Catch:{ all -> 0x01ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ee A[SYNTHETIC, Splitter:B:118:0x01ee] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01f3 A[SYNTHETIC, Splitter:B:122:0x01f3] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            r8 = this;
            java.lang.String r0 = "-"
            e.c.f.d.a r1 = r8.f6945d     // Catch:{ all -> 0x006c }
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r9)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x006f
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x006c }
            boolean r1 = e.c.f.n.a.a(r10, r1)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0013
            return
        L_0x0013:
            e.c.f.d.a r1 = r8.f6945d     // Catch:{ all -> 0x0068 }
            com.baidu.sofire.core.ApkInfo r1 = r1.a(r9)     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x001c
            goto L_0x006f
        L_0x001c:
            e.c.f.d.a r2 = r8.f6945d     // Catch:{ all -> 0x0068 }
            r2.h(r9)     // Catch:{ all -> 0x0068 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r1.pkgPath     // Catch:{ all -> 0x0068 }
            r2.<init>(r1)     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r1.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = r2.getAbsolutePath()     // Catch:{ all -> 0x0068 }
            r1.append(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = ", e="
            r1.append(r3)     // Catch:{ all -> 0x0068 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0068 }
            r1.append(r3)     // Catch:{ all -> 0x0068 }
            e.c.f.c.a()     // Catch:{ all -> 0x0068 }
            boolean r1 = r2.exists()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x006f
            e.c.f.e.a(r2)     // Catch:{ all -> 0x0068 }
            boolean r1 = r2.delete()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r3.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0068 }
            r3.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = " s="
            r3.append(r2)     // Catch:{ all -> 0x0068 }
            r3.append(r1)     // Catch:{ all -> 0x0068 }
            e.c.f.c.a()     // Catch:{ all -> 0x0068 }
            goto L_0x006f
        L_0x0068:
            e.c.f.c.d()     // Catch:{ all -> 0x006c }
            goto L_0x006f
        L_0x006c:
            e.c.f.c.d()
        L_0x006f:
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x01c7 }
            if (r2 != 0) goto L_0x018c
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x01c7 }
            android.content.Context r3 = f6939f     // Catch:{ all -> 0x01c7 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = ".tmp"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x01c7 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x01c7 }
            if (r3 != 0) goto L_0x008c
            r2.mkdir()     // Catch:{ all -> 0x01c7 }
        L_0x008c:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x01c7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r4.<init>()     // Catch:{ all -> 0x01c7 }
            r4.append(r9)     // Catch:{ all -> 0x01c7 }
            r4.append(r0)     // Catch:{ all -> 0x01c7 }
            r4.append(r10)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = ".zip"
            r4.append(r5)     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c7 }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x01c7 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0189 }
            r2.<init>(r3)     // Catch:{ all -> 0x0189 }
            android.content.Context r4 = f6939f     // Catch:{ all -> 0x01c4 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ all -> 0x01c4 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x01c4 }
            java.io.InputStream r1 = r4.open(r5)     // Catch:{ all -> 0x01c4 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x01c4 }
        L_0x00bf:
            int r5 = r1.read(r4)     // Catch:{ all -> 0x01c4 }
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L_0x00cb
            r2.write(r4, r7, r5)     // Catch:{ all -> 0x01c4 }
            goto L_0x00bf
        L_0x00cb:
            r2.flush()     // Catch:{ all -> 0x01c4 }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ all -> 0x01c4 }
            r5 = 1
            e.c.f.n.a.a(r4, r5)     // Catch:{ all -> 0x01c4 }
            java.lang.String r4 = e.c.f.n.h.a(r3)     // Catch:{ all -> 0x01c4 }
            if (r4 == 0) goto L_0x017f
            boolean r11 = r4.equalsIgnoreCase(r11)     // Catch:{ all -> 0x01c4 }
            if (r11 != 0) goto L_0x00e4
            goto L_0x017f
        L_0x00e4:
            com.baidu.sofire.core.ApkInfo r11 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x01c4 }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ all -> 0x01c4 }
            r11.<init>(r9, r10, r6)     // Catch:{ all -> 0x01c4 }
            r11.apkMD5 = r4     // Catch:{ all -> 0x01c4 }
            r11.priority = r5     // Catch:{ all -> 0x01c4 }
            e.c.f.d.a r4 = r8.f6945d     // Catch:{ all -> 0x01c4 }
            r4.a(r11)     // Catch:{ all -> 0x01c4 }
            e.c.f.d.a r11 = r8.f6945d     // Catch:{ all -> 0x01c4 }
            int r11 = r11.g(r9)     // Catch:{ all -> 0x01c4 }
            r4 = 3
            if (r11 != r4) goto L_0x0103
            e.c.f.c.a()     // Catch:{ all -> 0x01c4 }
            goto L_0x0104
        L_0x0103:
            r7 = r5
        L_0x0104:
            e.c.f.i r11 = r8.f6943b     // Catch:{ all -> 0x01c4 }
            boolean r11 = r11.b()     // Catch:{ all -> 0x01c4 }
            java.lang.String r4 = ".b"
            if (r11 == 0) goto L_0x014a
            if (r7 == 0) goto L_0x014a
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x01c4 }
            android.content.Context r5 = f6939f     // Catch:{ all -> 0x01c4 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ all -> 0x01c4 }
            r11.<init>(r5, r4)     // Catch:{ all -> 0x01c4 }
            boolean r4 = r11.exists()     // Catch:{ all -> 0x01c4 }
            if (r4 != 0) goto L_0x0124
            r11.mkdir()     // Catch:{ all -> 0x01c4 }
        L_0x0124:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r5.<init>()     // Catch:{ all -> 0x01c4 }
            r5.append(r9)     // Catch:{ all -> 0x01c4 }
            r5.append(r0)     // Catch:{ all -> 0x01c4 }
            r5.append(r10)     // Catch:{ all -> 0x01c4 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01c4 }
            r4.<init>(r11, r0)     // Catch:{ all -> 0x01c4 }
            boolean r11 = e.c.f.n.a.a(r4)     // Catch:{ all -> 0x01c4 }
            if (r11 != 0) goto L_0x0144
            e.c.f.n.a.a(r3, r4)     // Catch:{ all -> 0x01c4 }
        L_0x0144:
            android.content.Context r11 = f6939f     // Catch:{ all -> 0x01c4 }
            e.c.f.e.a(r11, r9, r3, r4)     // Catch:{ all -> 0x01c4 }
            goto L_0x018e
        L_0x014a:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x01c4 }
            android.content.Context r5 = f6939f     // Catch:{ all -> 0x01c4 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ all -> 0x01c4 }
            r11.<init>(r5, r4)     // Catch:{ all -> 0x01c4 }
            boolean r4 = r11.exists()     // Catch:{ all -> 0x01c4 }
            if (r4 == 0) goto L_0x018e
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r5.<init>()     // Catch:{ all -> 0x01c4 }
            r5.append(r9)     // Catch:{ all -> 0x01c4 }
            r5.append(r0)     // Catch:{ all -> 0x01c4 }
            r5.append(r10)     // Catch:{ all -> 0x01c4 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01c4 }
            r4.<init>(r11, r0)     // Catch:{ all -> 0x01c4 }
            boolean r11 = e.c.f.n.a.a(r4)     // Catch:{ all -> 0x01c4 }
            if (r11 == 0) goto L_0x018e
            e.c.f.e.a(r4)     // Catch:{ all -> 0x01c4 }
            r4.delete()     // Catch:{ all -> 0x01c4 }
            goto L_0x018e
        L_0x017f:
            r3.delete()     // Catch:{ all -> 0x01c4 }
            r1.close()     // Catch:{ IOException -> 0x0185 }
        L_0x0185:
            r2.close()     // Catch:{ IOException -> 0x0188 }
        L_0x0188:
            return
        L_0x0189:
            r10 = r1
            r2 = r10
            goto L_0x01c5
        L_0x018c:
            r2 = r1
            r3 = r2
        L_0x018e:
            e.c.f.d.a r11 = r8.f6945d     // Catch:{ all -> 0x01c4 }
            com.baidu.sofire.core.ApkInfo r11 = r11.a(r9)     // Catch:{ all -> 0x01c4 }
            if (r11 == 0) goto L_0x01b9
            java.lang.String r11 = r11.pkgPath     // Catch:{ all -> 0x01c4 }
            boolean r11 = e.c.f.n.a.c(r11)     // Catch:{ all -> 0x01c4 }
            if (r11 != 0) goto L_0x019f
            goto L_0x01b9
        L_0x019f:
            boolean r10 = r8.a(r9, r10, r12)     // Catch:{ all -> 0x01c4 }
            if (r10 == 0) goto L_0x01ae
            java.util.List<java.lang.Integer> r10 = f6941h     // Catch:{ all -> 0x01c4 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01c4 }
            r10.add(r11)     // Catch:{ all -> 0x01c4 }
        L_0x01ae:
            if (r1 == 0) goto L_0x01b3
            r1.close()     // Catch:{ IOException -> 0x01b3 }
        L_0x01b3:
            if (r2 == 0) goto L_0x01f6
            r2.close()     // Catch:{ IOException -> 0x01b8 }
        L_0x01b8:
            return
        L_0x01b9:
            if (r1 == 0) goto L_0x01be
            r1.close()     // Catch:{ IOException -> 0x01be }
        L_0x01be:
            if (r2 == 0) goto L_0x01c3
            r2.close()     // Catch:{ IOException -> 0x01c3 }
        L_0x01c3:
            return
        L_0x01c4:
            r10 = r1
        L_0x01c5:
            r1 = r3
            goto L_0x01c9
        L_0x01c7:
            r10 = r1
            r2 = r10
        L_0x01c9:
            e.c.f.c.d()     // Catch:{ all -> 0x01ea }
            if (r1 == 0) goto L_0x01ec
            boolean r11 = r1.exists()     // Catch:{ all -> 0x01ea }
            if (r11 == 0) goto L_0x01ec
            e.c.f.e.a(r1)     // Catch:{ all -> 0x01ea }
            e.c.f.d.a r11 = r8.f6945d     // Catch:{ all -> 0x01ea }
            r11.h(r9)     // Catch:{ all -> 0x01ea }
            r1.delete()     // Catch:{ all -> 0x01ea }
            if (r10 == 0) goto L_0x01e4
            r10.close()     // Catch:{ IOException -> 0x01e4 }
        L_0x01e4:
            if (r2 == 0) goto L_0x01e9
            r2.close()     // Catch:{ IOException -> 0x01e9 }
        L_0x01e9:
            return
        L_0x01ea:
            r9 = move-exception
            goto L_0x01f7
        L_0x01ec:
            if (r10 == 0) goto L_0x01f1
            r10.close()     // Catch:{ IOException -> 0x01f1 }
        L_0x01f1:
            if (r2 == 0) goto L_0x01f6
            r2.close()     // Catch:{ IOException -> 0x01f6 }
        L_0x01f6:
            return
        L_0x01f7:
            if (r10 == 0) goto L_0x01fc
            r10.close()     // Catch:{ IOException -> 0x01fc }
        L_0x01fc:
            if (r2 == 0) goto L_0x0201
            r2.close()     // Catch:{ IOException -> 0x0201 }
        L_0x0201:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        return a(i2, str, false, packageInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02f1, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d5, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        e.c.f.c.d();
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0281, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r1.f6945d.f(r2);
        r0 = e.c.f.n.d.a(f6939f, e.c.f.c.a(r0), r7.packageName);
        r8.a(r7.pkgPath);
        r4 = new java.util.HashMap();
        r4.put("0", java.lang.Integer.valueOf(7));
        r4.put("1", java.lang.String.valueOf(r17));
        r4.put("2", r3);
        r4.put("3", android.util.Base64.encodeToString(r0.getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02da, code lost:
        if (r19 == false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02dc, code lost:
        e.c.f.n.a.a(f6939f, "1003105", (java.util.Map<java.lang.String, java.lang.Object>) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0119 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x01ca */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x02e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x02e9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(int r17, java.lang.String r18, boolean r19, android.content.pm.PackageInfo r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r0 = r20
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            monitor-enter(r16)
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e9 }
            r6.<init>()     // Catch:{ all -> 0x02e9 }
            r6.append(r2)     // Catch:{ all -> 0x02e9 }
            e.c.f.c.a()     // Catch:{ all -> 0x02e9 }
            r6 = 1
            if (r19 == 0) goto L_0x0024
            e.c.f.d.a r7 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            int r7 = r7.c(r2)     // Catch:{ all -> 0x02e9 }
            if (r7 == r6) goto L_0x0024
            monitor-exit(r16)
            return r5
        L_0x0024:
            e.c.f.d.a r7 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            com.baidu.sofire.core.ApkInfo r7 = r7.a(r2)     // Catch:{ all -> 0x02e9 }
            if (r7 != 0) goto L_0x0053
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02e9 }
            r0.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "0"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r6)     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "1"
            java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r2)     // Catch:{ all -> 0x02e9 }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x02e9 }
            if (r19 != 0) goto L_0x0051
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "1003105"
            e.c.f.n.a.a(r2, r3, r0)     // Catch:{ all -> 0x02e9 }
        L_0x0051:
            monitor-exit(r16)
            return r5
        L_0x0053:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x02e9 }
            java.lang.String r9 = r7.pkgPath     // Catch:{ all -> 0x02e9 }
            r8.<init>(r9)     // Catch:{ all -> 0x02e9 }
            r8.getAbsolutePath()     // Catch:{ all -> 0x02e9 }
            boolean r8 = e.c.f.n.a.a(r8)     // Catch:{ all -> 0x02e9 }
            r9 = 3
            if (r8 != 0) goto L_0x0090
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            r0.f(r2)     // Catch:{ all -> 0x02e9 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02e9 }
            r0.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "0"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r6)     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "1"
            java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r2)     // Catch:{ all -> 0x02e9 }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x02e9 }
            if (r19 != 0) goto L_0x008e
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "1003105"
            e.c.f.n.a.a(r2, r3, r0)     // Catch:{ all -> 0x02e9 }
        L_0x008e:
            monitor-exit(r16)
            return r5
        L_0x0090:
            if (r0 == 0) goto L_0x0094
            r7.cloudPkgInfo = r0     // Catch:{ all -> 0x02e9 }
        L_0x0094:
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x02e9 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x02e9 }
            e.c.f.f.g r8 = e.c.f.f.g.a(r0)     // Catch:{ all -> 0x02e9 }
            boolean r0 = r8.a(r7, r5)     // Catch:{ all -> 0x02e9 }
            if (r0 != 0) goto L_0x00d6
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            r0.f(r2)     // Catch:{ all -> 0x02e9 }
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x02e9 }
            r8.a(r0)     // Catch:{ all -> 0x02e9 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02e9 }
            r0.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "0"
            r6 = 4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r6)     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "1"
            java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r2)     // Catch:{ all -> 0x02e9 }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x02e9 }
            if (r19 != 0) goto L_0x00d4
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "1003105"
            e.c.f.n.a.a(r2, r3, r0)     // Catch:{ all -> 0x02e9 }
        L_0x00d4:
            monitor-exit(r16)
            return r5
        L_0x00d6:
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0281 }
            java.lang.String[] r0 = e.c.f.n.a.e(r0)     // Catch:{ all -> 0x0281 }
            r10 = 2
            if (r0 == 0) goto L_0x00f7
            int r11 = r0.length     // Catch:{ all -> 0x0281 }
            if (r11 != r10) goto L_0x00f7
            r11 = r0[r5]     // Catch:{ all -> 0x0281 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0281 }
            if (r11 != 0) goto L_0x00f7
            r11 = r0[r6]     // Catch:{ all -> 0x0281 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0281 }
            if (r11 != 0) goto L_0x00f7
            r11 = r0[r5]     // Catch:{ all -> 0x0281 }
            r0 = r0[r6]     // Catch:{ all -> 0x0281 }
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r11 = "3"
            java.lang.String r0 = "925fc15df8a49bed0b3eca8d2b44cb7b"
        L_0x00fb:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            java.lang.String r13 = "ak="
            r12.<init>(r13)     // Catch:{ all -> 0x0281 }
            r12.append(r11)     // Catch:{ all -> 0x0281 }
            java.lang.String r13 = ", sk="
            r12.append(r13)     // Catch:{ all -> 0x0281 }
            r12.append(r0)     // Catch:{ all -> 0x0281 }
            java.lang.String r12 = r7.pkgPath     // Catch:{ all -> 0x0281 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r13 = r8.f6984c     // Catch:{ all -> 0x0119 }
            java.lang.Object r12 = r13.get(r12)     // Catch:{ all -> 0x0119 }
            com.baidu.sofire.core.ApkInfo r12 = (com.baidu.sofire.core.ApkInfo) r12     // Catch:{ all -> 0x0119 }
            r7 = r12
            goto L_0x011d
        L_0x0119:
            e.c.f.c.d()     // Catch:{ all -> 0x0281 }
            r7 = 0
        L_0x011d:
            java.lang.ClassLoader r12 = r7.classLoader     // Catch:{ all -> 0x0281 }
            e.c.f.f.f r12 = (e.c.f.f.f) r12     // Catch:{ all -> 0x0281 }
            java.lang.String r13 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r13 = r12.a(r13)     // Catch:{ all -> 0x0281 }
            if (r13 != 0) goto L_0x0198
            java.lang.String r0 = "java.lang.String"
            java.lang.Class r0 = r12.a(r0)     // Catch:{ all -> 0x0281 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "0"
            r9 = 9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0281 }
            r4.put(r6, r9)     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "1"
            java.lang.String r9 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x0281 }
            r4.put(r6, r9)     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "2"
            r4.put(r6, r3)     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "3"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            java.lang.String r10 = "classloader="
            r9.<init>(r10)     // Catch:{ all -> 0x0281 }
            r9.append(r12)     // Catch:{ all -> 0x0281 }
            java.lang.String r10 = ",StringClass="
            r9.append(r10)     // Catch:{ all -> 0x0281 }
            r9.append(r0)     // Catch:{ all -> 0x0281 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0281 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0281 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r9 = "\n"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x0281 }
            java.lang.String r9 = "\t"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x0281 }
            java.lang.String r9 = "\r"
            java.lang.String r10 = ""
            java.lang.String r0 = r0.replace(r9, r10)     // Catch:{ all -> 0x0281 }
            r4.put(r6, r0)     // Catch:{ all -> 0x0281 }
            if (r19 != 0) goto L_0x0191
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "1003105"
            e.c.f.n.a.a(r0, r6, r4)     // Catch:{ all -> 0x0281 }
        L_0x0191:
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x0281 }
            r0.f(r2)     // Catch:{ all -> 0x0281 }
            monitor-exit(r16)
            return r5
        L_0x0198:
            java.lang.String r12 = "getInstance"
            java.lang.Class[] r14 = new java.lang.Class[r6]     // Catch:{ all -> 0x0281 }
            java.lang.Class<android.content.Context> r15 = android.content.Context.class
            r14[r5] = r15     // Catch:{ all -> 0x0281 }
            java.lang.reflect.Method r12 = r13.getDeclaredMethod(r12, r14)     // Catch:{ all -> 0x0281 }
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ all -> 0x0281 }
            android.content.Context r15 = f6939f     // Catch:{ all -> 0x0281 }
            r14[r5] = r15     // Catch:{ all -> 0x0281 }
            java.lang.Object r12 = r12.invoke(r13, r14)     // Catch:{ all -> 0x0281 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            java.lang.String r14 = "ai="
            r13.<init>(r14)     // Catch:{ all -> 0x0281 }
            r13.append(r12)     // Catch:{ all -> 0x0281 }
            java.lang.String r13 = "setSecurityVerifyInfo"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x01ca }
            r14[r5] = r4     // Catch:{ all -> 0x01ca }
            r14[r6] = r4     // Catch:{ all -> 0x01ca }
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ all -> 0x01ca }
            r4[r5] = r11     // Catch:{ all -> 0x01ca }
            r4[r6] = r0     // Catch:{ all -> 0x01ca }
            e.c.f.n.a.a(r12, r13, (java.lang.Class<?>[]) r14, r4)     // Catch:{ all -> 0x01ca }
            goto L_0x01cd
        L_0x01ca:
            e.c.f.c.d()     // Catch:{ all -> 0x0281 }
        L_0x01cd:
            java.lang.String r0 = "init"
            java.lang.Class[] r4 = new java.lang.Class[r10]     // Catch:{ all -> 0x0281 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0281 }
            r4[r5] = r11     // Catch:{ all -> 0x0281 }
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0281 }
            r4[r6] = r11     // Catch:{ all -> 0x0281 }
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x0281 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0281 }
            r10[r5] = r11     // Catch:{ all -> 0x0281 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0281 }
            r10[r6] = r11     // Catch:{ all -> 0x0281 }
            java.lang.Object r0 = e.c.f.n.a.a(r12, r0, (java.lang.Class<?>[]) r4, r10)     // Catch:{ all -> 0x0281 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0281 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0281 }
            if (r0 != 0) goto L_0x0225
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0281 }
            r0.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = "0"
            r6 = 6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0281 }
            r0.put(r4, r6)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = "1"
            java.lang.String r6 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x0281 }
            r0.put(r4, r6)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = "2"
            r0.put(r4, r3)     // Catch:{ all -> 0x0281 }
            if (r19 != 0) goto L_0x0219
            android.content.Context r4 = f6939f     // Catch:{ all -> 0x0281 }
            java.lang.String r6 = "1003105"
            e.c.f.n.a.a(r4, r6, r0)     // Catch:{ all -> 0x0281 }
        L_0x0219:
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x0281 }
            r0.f(r2)     // Catch:{ all -> 0x0281 }
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x0281 }
            r8.a(r0)     // Catch:{ all -> 0x0281 }
            monitor-exit(r16)
            return r5
        L_0x0225:
            r7.initStatus = r6     // Catch:{ all -> 0x02e9 }
            r7.apkParseSuc = r6     // Catch:{ all -> 0x02e9 }
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            r0.a(r7)     // Catch:{ all -> 0x02e9 }
            e.c.f.d.a r0 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            int r4 = r7.key     // Catch:{ all -> 0x02e9 }
            int r0 = r0.g(r4)     // Catch:{ all -> 0x02e9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e9 }
            r4.<init>()     // Catch:{ all -> 0x02e9 }
            int r8 = r7.key     // Catch:{ all -> 0x02e9 }
            r4.append(r8)     // Catch:{ all -> 0x02e9 }
            java.lang.String r8 = " "
            r4.append(r8)     // Catch:{ all -> 0x02e9 }
            r4.append(r0)     // Catch:{ all -> 0x02e9 }
            if (r0 >= r9) goto L_0x0255
            r4 = -1
            if (r0 == r4) goto L_0x0255
            e.c.f.d.a r4 = r1.f6945d     // Catch:{ all -> 0x02e9 }
            int r7 = r7.key     // Catch:{ all -> 0x02e9 }
            int r0 = r0 + r6
            r4.b(r7, r0)     // Catch:{ all -> 0x02e9 }
        L_0x0255:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02e9 }
            r0.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "0"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r7)     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "1"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02e9 }
            r0.put(r4, r2)     // Catch:{ all -> 0x02e9 }
            java.lang.String r2 = "2"
            r0.put(r2, r3)     // Catch:{ all -> 0x02e9 }
            if (r19 != 0) goto L_0x027a
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "1003105"
            e.c.f.n.a.a(r2, r3, r0)     // Catch:{ all -> 0x02e9 }
        L_0x027a:
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x02e9 }
            e.c.f.n.a.b(r0)     // Catch:{ all -> 0x02e9 }
            monitor-exit(r16)
            return r6
        L_0x0281:
            r0 = move-exception
            e.c.f.d.a r4 = r1.f6945d     // Catch:{ all -> 0x02e4 }
            r4.f(r2)     // Catch:{ all -> 0x02e4 }
            java.lang.String r0 = e.c.f.c.a(r0)     // Catch:{ all -> 0x02e4 }
            android.content.Context r4 = f6939f     // Catch:{ all -> 0x02e4 }
            java.lang.String r6 = r7.packageName     // Catch:{ all -> 0x02e4 }
            java.lang.String r0 = e.c.f.n.d.a(r4, r0, r6)     // Catch:{ all -> 0x02e4 }
            java.lang.String r4 = r7.pkgPath     // Catch:{ all -> 0x02e4 }
            r8.a(r4)     // Catch:{ all -> 0x02e4 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x02e4 }
            r4.<init>()     // Catch:{ all -> 0x02e4 }
            java.lang.String r6 = "0"
            r7 = 7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x02e4 }
            r4.put(r6, r7)     // Catch:{ all -> 0x02e4 }
            java.lang.String r6 = "1"
            java.lang.String r2 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x02e4 }
            r4.put(r6, r2)     // Catch:{ all -> 0x02e4 }
            java.lang.String r2 = "2"
            r4.put(r2, r3)     // Catch:{ all -> 0x02e4 }
            java.lang.String r2 = "3"
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x02e4 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ all -> 0x02e4 }
            java.lang.String r3 = "\n"
            java.lang.String r6 = ""
            java.lang.String r0 = r0.replace(r3, r6)     // Catch:{ all -> 0x02e4 }
            java.lang.String r3 = "\t"
            java.lang.String r6 = ""
            java.lang.String r0 = r0.replace(r3, r6)     // Catch:{ all -> 0x02e4 }
            java.lang.String r3 = "\r"
            java.lang.String r6 = ""
            java.lang.String r0 = r0.replace(r3, r6)     // Catch:{ all -> 0x02e4 }
            r4.put(r2, r0)     // Catch:{ all -> 0x02e4 }
            if (r19 != 0) goto L_0x02e7
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x02e4 }
            java.lang.String r2 = "1003105"
            e.c.f.n.a.a(r0, r2, r4)     // Catch:{ all -> 0x02e4 }
            goto L_0x02e7
        L_0x02e4:
            e.c.f.c.d()     // Catch:{ all -> 0x02e9 }
        L_0x02e7:
            monitor-exit(r16)
            return r5
        L_0x02e9:
            e.c.f.c.d()     // Catch:{ all -> 0x02ee }
            monitor-exit(r16)
            return r5
        L_0x02ee:
            r0 = move-exception
            r2 = r0
            monitor-exit(r16)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a(int, java.lang.String, boolean, android.content.pm.PackageInfo):boolean");
    }

    public final void a(String str, String str2) {
        try {
            this.f6945d.a(str);
            File file = new File(str2);
            StringBuilder sb = new StringBuilder("f=");
            sb.append(file.getAbsolutePath());
            sb.append(", e=");
            sb.append(file.exists());
            if (file.exists()) {
                e.a(file);
                boolean delete = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getAbsolutePath());
                sb2.append(" s=");
                sb2.append(delete);
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:(2:145|146)|147|148) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:64|65|66|67|68|69|(1:71)|72) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x023c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x015a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r24, java.lang.String r25, com.baidu.sofire.ac.Callback r26, java.lang.Class<?>[] r27, java.lang.Object... r28) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = "0"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x023d }
            r5.<init>()     // Catch:{ all -> 0x023d }
            r5.append(r2)     // Catch:{ all -> 0x023d }
            e.c.f.c.a()     // Catch:{ all -> 0x023d }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x023d }
            r5.<init>()     // Catch:{ all -> 0x023d }
            java.lang.String r6 = java.lang.Integer.toString(r24)     // Catch:{ all -> 0x023d }
            r5.put(r4, r6)     // Catch:{ all -> 0x023d }
            java.lang.String r6 = "1"
            boolean r7 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x023d }
            if (r7 != 0) goto L_0x002b
            r7 = r2
            goto L_0x002d
        L_0x002b:
            java.lang.String r7 = " "
        L_0x002d:
            r5.put(r6, r7)     // Catch:{ all -> 0x023d }
            java.lang.String r6 = "2"
            r5.put(r6, r4)     // Catch:{ all -> 0x023d }
            android.content.Context r4 = f6939f     // Catch:{ all -> 0x023d }
            java.lang.String r6 = "1003136"
            e.c.f.n.a.a(r4, r6, r5)     // Catch:{ all -> 0x023d }
            boolean r4 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x023d }
            java.lang.String r6 = "1003141"
            java.lang.String r7 = "3"
            r8 = 0
            r9 = 1
            if (r4 == 0) goto L_0x0060
            if (r3 == 0) goto L_0x0055
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x023d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x023d }
            r0[r8] = r2     // Catch:{ all -> 0x023d }
            r3.onError(r0)     // Catch:{ all -> 0x023d }
        L_0x0055:
            java.lang.String r0 = "11"
            r5.put(r7, r0)     // Catch:{ all -> 0x023d }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x023d }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x023d }
            return
        L_0x0060:
            r4 = 18
            r10 = 3
            r11 = 2
            if (r3 == 0) goto L_0x006b
            java.lang.Object[] r15 = new java.lang.Object[r8]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r3.onBegin(r15)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x006b:
            e.c.f.d.a r15 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            boolean r15 = r15.d(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r15 == 0) goto L_0x0091
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x0077:
            e.c.f.d.a r15 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            boolean r15 = r15.d(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r15 == 0) goto L_0x0091
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            long r18 = r18 - r16
            r20 = 10000(0x2710, double:4.9407E-320)
            int r15 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r15 >= 0) goto L_0x0091
            r18 = 300(0x12c, double:1.48E-321)
            android.os.SystemClock.sleep(r18)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            goto L_0x0077
        L_0x0091:
            e.c.f.d.a r15 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            boolean r15 = r15.d(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r15 == 0) goto L_0x00b5
            if (r3 == 0) goto L_0x00a6
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r0[r8] = r2     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r3.onError(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x00a6:
            r0 = 12
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x00b4 }
            r5.put(r7, r0)     // Catch:{ all -> 0x00b4 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x00b4 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            return
        L_0x00b5:
            boolean r15 = r1.f6942a     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r15 != 0) goto L_0x00c2
            int r15 = f6940g     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r15 != 0) goto L_0x00bf
            f6940g = r10     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x00bf:
            r23.a()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x00c2:
            android.content.Context r15 = f6939f     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            android.content.Context r15 = r15.getApplicationContext()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            e.c.f.f.g r15 = e.c.f.f.g.a(r15)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r16 = 0
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x00d2:
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            long r19 = r19 - r17
            r21 = 120000(0x1d4c0, double:5.9288E-319)
            int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r19 > 0) goto L_0x0101
            e.c.f.d.a r14 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            com.baidu.sofire.core.ApkInfo r14 = r14.a(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r14 == 0) goto L_0x00f9
            java.lang.String r13 = r14.packageName     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            com.baidu.sofire.core.ApkInfo r13 = r15.c(r13)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            if (r13 == 0) goto L_0x00f1
            r0 = r9
            goto L_0x0104
        L_0x00f1:
            int r13 = r14.initStatus     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r12 = -1
            if (r13 == r12) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r0 = r8
            goto L_0x0104
        L_0x00f9:
            r12 = 1000(0x3e8, double:4.94E-321)
            android.os.SystemClock.sleep(r12)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r16 = r14
            goto L_0x00d2
        L_0x0101:
            r0 = r8
            r14 = r16
        L_0x0104:
            if (r0 != 0) goto L_0x0123
            if (r3 == 0) goto L_0x0114
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r0[r8] = r2     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r3.onError(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x0114:
            r0 = 13
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x0122 }
            r5.put(r7, r0)     // Catch:{ all -> 0x0122 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0122 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x0122 }
        L_0x0122:
            return
        L_0x0123:
            java.lang.String r0 = r14.packageName     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            com.baidu.sofire.core.ApkInfo r0 = r15.c(r0)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.ClassLoader r0 = r0.classLoader     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            e.c.f.f.f r0 = (e.c.f.f.f) r0     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.String r12 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r0 = r0.a(r12)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.String r12 = "getInstance"
            java.lang.Class[] r13 = new java.lang.Class[r9]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.Class<android.content.Context> r14 = android.content.Context.class
            r13[r8] = r14     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.reflect.Method r12 = r0.getDeclaredMethod(r12, r13)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            android.content.Context r14 = f6939f     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r13[r8] = r14     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.Object r0 = r12.invoke(r0, r13)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r12 = r27
            r13 = r28
            java.lang.Object r0 = e.c.f.n.a.a(r0, r2, (java.lang.Class<?>[]) r12, r13)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r2.<init>()     // Catch:{ all -> 0x015a }
            r2.append(r0)     // Catch:{ all -> 0x015a }
            goto L_0x015d
        L_0x015a:
            e.c.f.c.d()     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x015d:
            if (r3 == 0) goto L_0x0166
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r2[r8] = r0     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
            r3.onEnd(r2)     // Catch:{ NoSuchMethodException -> 0x0205, InvocationTargetException -> 0x01dc, IllegalAccessException -> 0x01b3, IllegalArgumentException -> 0x0188, all -> 0x0167 }
        L_0x0166:
            return
        L_0x0167:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0185 }
            if (r3 == 0) goto L_0x0178
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x0185 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0185 }
            r0[r8] = r2     // Catch:{ all -> 0x0185 }
            r3.onError(r0)     // Catch:{ all -> 0x0185 }
        L_0x0178:
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0184 }
            r5.put(r7, r0)     // Catch:{ all -> 0x0184 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0184 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x0184 }
        L_0x0184:
            return
        L_0x0185:
            r0 = move-exception
            goto L_0x022e
        L_0x0188:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x01ae }
            if (r3 == 0) goto L_0x019f
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x019a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x019a }
            r0[r8] = r2     // Catch:{ all -> 0x019a }
            r3.onError(r0)     // Catch:{ all -> 0x019a }
            goto L_0x019f
        L_0x019a:
            r0 = move-exception
            r4 = 17
            goto L_0x022e
        L_0x019f:
            r2 = 17
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x01ad }
            r5.put(r7, r0)     // Catch:{ all -> 0x01ad }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x01ad }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x01ad }
        L_0x01ad:
            return
        L_0x01ae:
            r0 = move-exception
            r2 = 17
            goto L_0x022d
        L_0x01b3:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x01d8 }
            if (r3 == 0) goto L_0x01c9
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x01c5 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01c5 }
            r0[r8] = r2     // Catch:{ all -> 0x01c5 }
            r3.onError(r0)     // Catch:{ all -> 0x01c5 }
            goto L_0x01c9
        L_0x01c5:
            r0 = move-exception
            r4 = 16
            goto L_0x022e
        L_0x01c9:
            r2 = 16
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x01d7 }
            r5.put(r7, r0)     // Catch:{ all -> 0x01d7 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x01d7 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x01d7 }
        L_0x01d7:
            return
        L_0x01d8:
            r0 = move-exception
            r2 = 16
            goto L_0x022d
        L_0x01dc:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0201 }
            if (r3 == 0) goto L_0x01f2
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x01ee }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01ee }
            r0[r8] = r2     // Catch:{ all -> 0x01ee }
            r3.onError(r0)     // Catch:{ all -> 0x01ee }
            goto L_0x01f2
        L_0x01ee:
            r0 = move-exception
            r4 = 15
            goto L_0x022e
        L_0x01f2:
            r2 = 15
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x0200 }
            r5.put(r7, r0)     // Catch:{ all -> 0x0200 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0200 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x0200 }
        L_0x0200:
            return
        L_0x0201:
            r0 = move-exception
            r2 = 15
            goto L_0x022d
        L_0x0205:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x022a }
            if (r3 == 0) goto L_0x021b
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x0217 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0217 }
            r0[r8] = r2     // Catch:{ all -> 0x0217 }
            r3.onError(r0)     // Catch:{ all -> 0x0217 }
            goto L_0x021b
        L_0x0217:
            r0 = move-exception
            r4 = 14
            goto L_0x022e
        L_0x021b:
            r2 = 14
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x0229 }
            r5.put(r7, r0)     // Catch:{ all -> 0x0229 }
            android.content.Context r0 = f6939f     // Catch:{ all -> 0x0229 }
            e.c.f.n.a.a(r0, r6, r5)     // Catch:{ all -> 0x0229 }
        L_0x0229:
            return
        L_0x022a:
            r0 = move-exception
            r2 = 14
        L_0x022d:
            r4 = r2
        L_0x022e:
            if (r4 == 0) goto L_0x023c
            java.lang.String r2 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x023c }
            r5.put(r7, r2)     // Catch:{ all -> 0x023c }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x023c }
            e.c.f.n.a.a(r2, r6, r5)     // Catch:{ all -> 0x023c }
        L_0x023c:
            throw r0     // Catch:{ all -> 0x023d }
        L_0x023d:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a(int, java.lang.String, com.baidu.sofire.ac.Callback, java.lang.Class[], java.lang.Object[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:47|48|49|50|51|52|53|54) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x011d */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c2 A[SYNTHETIC, Splitter:B:104:0x01c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<java.lang.Integer, java.lang.Object> a(int r17, java.lang.String r18, java.lang.Class<?>[] r19, java.lang.Object... r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            e.c.f.c.a()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = java.lang.Integer.toString(r17)
            java.lang.String r5 = "0"
            r3.put(r5, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r18)
            if (r4 != 0) goto L_0x0027
            r4 = r2
            goto L_0x0029
        L_0x0027:
            java.lang.String r4 = " "
        L_0x0029:
            java.lang.String r5 = "1"
            r3.put(r5, r4)
            java.lang.String r4 = "2"
            r3.put(r4, r5)
            android.content.Context r4 = f6939f
            java.lang.String r6 = "1003136"
            e.c.f.n.a.a(r4, r6, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r18)
            r6 = 1
            r7 = 0
            java.lang.String r8 = "1003141"
            java.lang.String r9 = "3"
            if (r4 == 0) goto L_0x0058
            r3.put(r9, r5)
            android.content.Context r0 = f6939f
            e.c.f.n.a.a(r0, r8, r3)
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r0.<init>(r2, r7)
            return r0
        L_0x0058:
            r4 = 10
            r5 = 9
            r13 = 3
            r14 = 2
            e.c.f.d.a r15 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            boolean r15 = r15.d(r0)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r12.<init>()     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r12.append(r15)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            if (r15 == 0) goto L_0x0084
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r0.<init>(r2, r7)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.String r2 = java.lang.Integer.toString(r14)     // Catch:{ all -> 0x0083 }
            r3.put(r9, r2)     // Catch:{ all -> 0x0083 }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x0083 }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x0083 }
        L_0x0083:
            return r0
        L_0x0084:
            boolean r12 = r1.f6942a     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            if (r12 != 0) goto L_0x009e
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r0.<init>(r2, r7)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.String r2 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x009d }
            r3.put(r9, r2)     // Catch:{ all -> 0x009d }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x009d }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x009d }
        L_0x009d:
            return r0
        L_0x009e:
            e.c.f.f.g r12 = e.c.f.f.g.f6978g     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r15 = 4
            if (r12 != 0) goto L_0x00b9
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r0.<init>(r2, r7)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.String r2 = java.lang.Integer.toString(r15)     // Catch:{ all -> 0x00b8 }
            r3.put(r9, r2)     // Catch:{ all -> 0x00b8 }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x00b8 }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            return r0
        L_0x00b9:
            e.c.f.d.a r11 = r1.f6945d     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            com.baidu.sofire.core.ApkInfo r0 = r11.a(r0)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r11 = 0
            if (r0 == 0) goto L_0x00cc
            java.lang.String r10 = r0.packageName     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            com.baidu.sofire.core.ApkInfo r10 = r12.c(r10)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            if (r10 == 0) goto L_0x00cc
            r10 = r6
            goto L_0x00cd
        L_0x00cc:
            r10 = r11
        L_0x00cd:
            if (r10 != 0) goto L_0x00e6
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r0.<init>(r2, r7)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r2 = 5
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x00e5 }
            r3.put(r9, r2)     // Catch:{ all -> 0x00e5 }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x00e5 }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x00e5 }
        L_0x00e5:
            return r0
        L_0x00e6:
            java.lang.String r0 = r0.packageName     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            com.baidu.sofire.core.ApkInfo r0 = r12.c(r0)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.ClassLoader r0 = r0.classLoader     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            e.c.f.f.f r0 = (e.c.f.f.f) r0     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.String r10 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r0 = r0.a(r10)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.String r10 = "getInstance"
            java.lang.Class[] r12 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Class<android.content.Context> r15 = android.content.Context.class
            r12[r11] = r15     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.reflect.Method r10 = r0.getDeclaredMethod(r10, r12)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            android.content.Context r12 = f6939f     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r6[r11] = r12     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Object r0 = r10.invoke(r0, r6)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r6 = r19
            r10 = r20
            java.lang.Object r0 = e.c.f.n.a.a(r0, r2, (java.lang.Class<?>[]) r6, r10)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r2.<init>()     // Catch:{ all -> 0x011d }
            r2.append(r0)     // Catch:{ all -> 0x011d }
            goto L_0x0120
        L_0x011d:
            e.c.f.c.d()     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
        L_0x0120:
            android.util.Pair r2 = new android.util.Pair     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            r2.<init>(r6, r0)     // Catch:{ NoSuchMethodException -> 0x01a2, InvocationTargetException -> 0x0184, IllegalAccessException -> 0x0164, IllegalArgumentException -> 0x0147, all -> 0x012a }
            return r2
        L_0x012a:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0144 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0144 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0144 }
            r0.<init>(r2, r7)     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0143 }
            r3.put(r9, r2)     // Catch:{ all -> 0x0143 }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x0143 }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x0143 }
        L_0x0143:
            return r0
        L_0x0144:
            r0 = move-exception
            goto L_0x01c0
        L_0x0147:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0161 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0161 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0161 }
            r0.<init>(r2, r7)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0160 }
            r3.put(r9, r2)     // Catch:{ all -> 0x0160 }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x0160 }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x0160 }
        L_0x0160:
            return r0
        L_0x0161:
            r0 = move-exception
            r4 = r5
            goto L_0x01c0
        L_0x0164:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0180 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0180 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0180 }
            r0.<init>(r2, r7)     // Catch:{ all -> 0x0180 }
            r2 = 8
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x017f }
            r3.put(r9, r2)     // Catch:{ all -> 0x017f }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x017f }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x017f }
        L_0x017f:
            return r0
        L_0x0180:
            r0 = move-exception
            r2 = 8
            goto L_0x01bf
        L_0x0184:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x019f }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x019f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x019f }
            r0.<init>(r2, r7)     // Catch:{ all -> 0x019f }
            r2 = 7
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x019e }
            r3.put(r9, r2)     // Catch:{ all -> 0x019e }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x019e }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x019e }
        L_0x019e:
            return r0
        L_0x019f:
            r0 = move-exception
            r2 = 7
            goto L_0x01bf
        L_0x01a2:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x01bd }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x01bd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x01bd }
            r0.<init>(r2, r7)     // Catch:{ all -> 0x01bd }
            r2 = 6
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x01bc }
            r3.put(r9, r2)     // Catch:{ all -> 0x01bc }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x01bc }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x01bc }
        L_0x01bc:
            return r0
        L_0x01bd:
            r0 = move-exception
            r2 = 6
        L_0x01bf:
            r4 = r2
        L_0x01c0:
            if (r4 == 0) goto L_0x01ce
            java.lang.String r2 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x01ce }
            r3.put(r9, r2)     // Catch:{ all -> 0x01ce }
            android.content.Context r2 = f6939f     // Catch:{ all -> 0x01ce }
            e.c.f.n.a.a(r2, r8, r3)     // Catch:{ all -> 0x01ce }
        L_0x01ce:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.d.a(int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
    }

    public final void a(String str) {
        try {
            new StringBuilder().append(str);
            c.a();
            new b(str).start();
        } catch (Throwable unused) {
            c.d();
        }
    }
}
