package e.c.f.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.ApkInfo;
import e.c.f.n.m;
import java.util.concurrent.CountDownLatch;

/* compiled from: MethodImpl */
public class e {

    /* renamed from: a reason: collision with root package name */
    public static String f6953a = "";

    /* renamed from: b reason: collision with root package name */
    public static String f6954b = "";

    /* renamed from: c reason: collision with root package name */
    public static boolean f6955c = false;

    /* compiled from: MethodImpl */
    public static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Context f6956a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ String f6957b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ String f6958c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ int[] f6959d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ int f6960e;

        public a(Context context, String str, String str2, int[] iArr, int i2) {
            this.f6956a = context;
            this.f6957b = str;
            this.f6958c = str2;
            this.f6959d = iArr;
            this.f6960e = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00be, code lost:
            if (r0.getPackageName().equals(e.c.f.n.a.f7042g) != false) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            e.c.f.c.d();
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x018a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x01ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x01bd */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x021c A[Catch:{ all -> 0x01df, all -> 0x0222 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca A[Catch:{ all -> 0x01df, all -> 0x0222 }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0120 A[Catch:{ all -> 0x01df, all -> 0x0222 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r10 = this;
                android.content.Context r0 = r10.f6956a
                boolean r1 = e.c.f.n.a.f(r0)
                r2 = 0
                if (r1 == 0) goto L_0x007f
                java.lang.String r1 = r0.getPackageName()
                java.lang.String r3 = "com.baidu.input"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x007f
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "SDK Self Check: "
                r1.<init>(r3)
                int r3 = r1.length()
                java.lang.String r4 = "fire"
                java.lang.System.loadLibrary(r4)     // Catch:{ all -> 0x0026 }
                goto L_0x002b
            L_0x0026:
                java.lang.String r4 = "LoadLibrary Error,"
                r1.append(r4)
            L_0x002b:
                java.lang.String r4 = "com.baidu.sofire.ac.F"
                java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x0039 }
                java.lang.String r5 = "getInstance"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0039 }
                r4.getDeclaredMethod(r5, r6)     // Catch:{ Exception -> 0x0039 }
                goto L_0x003e
            L_0x0039:
                java.lang.String r4 = "Proguard Error,"
                r1.append(r4)
            L_0x003e:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
                r4.<init>()     // Catch:{ all -> 0x005e }
                java.lang.String r5 = r0.getPackageName()     // Catch:{ all -> 0x005e }
                r4.append(r5)     // Catch:{ all -> 0x005e }
                java.lang.String r5 = ".sofire.ac.provider"
                r4.append(r5)     // Catch:{ all -> 0x005e }
                android.content.pm.PackageManager r5 = r0.getPackageManager()     // Catch:{ all -> 0x005e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005e }
                android.content.pm.ProviderInfo r4 = r5.resolveContentProvider(r4, r2)     // Catch:{ all -> 0x005e }
                boolean r4 = r4.multiprocess     // Catch:{ all -> 0x005e }
                goto L_0x0063
            L_0x005e:
                java.lang.String r4 = "Provider Error,"
                r1.append(r4)
            L_0x0063:
                boolean r0 = e.c.f.n.a.a(r0, r2)
                if (r0 != 0) goto L_0x006e
                java.lang.String r0 = "Service or Receiver Error."
                r1.append(r0)
            L_0x006e:
                int r0 = r1.length()
                if (r0 > r3) goto L_0x0075
                goto L_0x007f
            L_0x0075:
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x007f:
                android.content.Context r0 = r10.f6956a     // Catch:{ all -> 0x0222 }
                r1 = 1
                boolean r0 = e.c.f.n.a.a(r0, r1)     // Catch:{ all -> 0x0222 }
                if (r0 != 0) goto L_0x008c
                e.c.f.c.a()     // Catch:{ all -> 0x0222 }
                return
            L_0x008c:
                android.content.Context r0 = r10.f6956a     // Catch:{ all -> 0x0222 }
                r3 = 2
                java.lang.String r4 = e.c.f.n.a.a(r0)     // Catch:{ all -> 0x00c4 }
                java.lang.String r5 = e.c.f.n.a.f7042g     // Catch:{ all -> 0x00c4 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00c4 }
                if (r5 == 0) goto L_0x00a5
                int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x00c4 }
                java.lang.String r5 = e.c.f.n.a.a(r5)     // Catch:{ all -> 0x00c4 }
                e.c.f.n.a.f7042g = r5     // Catch:{ all -> 0x00c4 }
            L_0x00a5:
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00c4 }
                if (r5 != 0) goto L_0x00b4
                java.lang.String r0 = e.c.f.n.a.f7042g     // Catch:{ all -> 0x00c4 }
                boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x00c4 }
                if (r0 == 0) goto L_0x00c2
                goto L_0x00c0
            L_0x00b4:
                java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x00c4 }
                java.lang.String r4 = e.c.f.n.a.f7042g     // Catch:{ all -> 0x00c4 }
                boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x00c4 }
                if (r0 == 0) goto L_0x00c2
            L_0x00c0:
                r0 = r1
                goto L_0x00c8
            L_0x00c2:
                r0 = r3
                goto L_0x00c8
            L_0x00c4:
                e.c.f.c.d()     // Catch:{ all -> 0x0222 }
                r0 = r2
            L_0x00c8:
                if (r0 == r1) goto L_0x0120
                if (r0 != r3) goto L_0x011c
                e.c.f.c.a()     // Catch:{ all -> 0x0222 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0222 }
                java.lang.String r4 = "com.baidu.action.SOFIRE.VIEW"
                r0.<init>(r4)     // Catch:{ all -> 0x0222 }
                android.content.Context r4 = r10.f6956a     // Catch:{ all -> 0x0222 }
                java.lang.Class<com.baidu.sofire.MyService> r5 = com.baidu.sofire.MyService.class
                r0.setClass(r4, r5)     // Catch:{ all -> 0x0222 }
                android.content.Context r4 = r10.f6956a     // Catch:{ all -> 0x0222 }
                java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0222 }
                r0.setPackage(r4)     // Catch:{ all -> 0x0222 }
                java.lang.String r4 = "com.baidu.category.SOFIRE"
                r0.addCategory(r4)     // Catch:{ all -> 0x0222 }
                java.lang.String r4 = "android.intent.category.DEFAULT"
                r0.addCategory(r4)     // Catch:{ all -> 0x0222 }
                android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x0222 }
                r4.<init>()     // Catch:{ all -> 0x0222 }
                java.lang.String r5 = "appkey"
                java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x0222 }
                java.lang.String r6 = r10.f6957b     // Catch:{ all -> 0x0222 }
                r3[r2] = r6     // Catch:{ all -> 0x0222 }
                java.lang.String r2 = r10.f6958c     // Catch:{ all -> 0x0222 }
                r3[r1] = r2     // Catch:{ all -> 0x0222 }
                r4.putStringArray(r5, r3)     // Catch:{ all -> 0x0222 }
                java.lang.String r1 = "key"
                int[] r2 = r10.f6959d     // Catch:{ all -> 0x0222 }
                r4.putIntArray(r1, r2)     // Catch:{ all -> 0x0222 }
                java.lang.String r1 = "delay"
                int r2 = r10.f6960e     // Catch:{ all -> 0x0222 }
                r4.putInt(r1, r2)     // Catch:{ all -> 0x0222 }
                java.lang.String r1 = "bundle"
                r0.putExtra(r1, r4)     // Catch:{ all -> 0x0222 }
                android.content.Context r1 = r10.f6956a     // Catch:{ all -> 0x0222 }
                r1.startService(r0)     // Catch:{ all -> 0x0222 }
            L_0x011c:
                e.c.f.c.a()     // Catch:{ all -> 0x0222 }
                return
            L_0x0120:
                android.content.Context r0 = r10.f6956a     // Catch:{ all -> 0x0222 }
                e.c.f.f.e.a(r0)     // Catch:{ all -> 0x0222 }
                android.content.Context r0 = r10.f6956a     // Catch:{ all -> 0x0222 }
                e.c.f.f.d r0 = e.c.f.f.d.a(r0)     // Catch:{ all -> 0x0222 }
                android.content.Context r3 = r10.f6956a     // Catch:{ all -> 0x0222 }
                e.c.f.n.c.a(r3)     // Catch:{ all -> 0x0222 }
                android.content.Context r3 = r10.f6956a     // Catch:{ all -> 0x0222 }
                e.c.f.n.c.b(r3)     // Catch:{ all -> 0x0222 }
                java.lang.String r3 = r10.f6957b     // Catch:{ all -> 0x0222 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0222 }
                java.lang.String r4 = "-"
                if (r3 != 0) goto L_0x018d
                java.lang.String r3 = r10.f6958c     // Catch:{ all -> 0x0222 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0222 }
                if (r3 != 0) goto L_0x018d
                java.lang.String r3 = r10.f6957b     // Catch:{ all -> 0x0222 }
                java.lang.String r5 = r10.f6958c     // Catch:{ all -> 0x0222 }
                boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x018a }
                if (r6 != 0) goto L_0x018d
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x018a }
                if (r6 == 0) goto L_0x0158
                goto L_0x018d
            L_0x0158:
                java.lang.String r6 = "3"
                boolean r6 = r6.equals(r3)     // Catch:{ all -> 0x018a }
                if (r6 == 0) goto L_0x0169
                java.lang.String r6 = "925fc15df8a49bed0b3eca8d2b44cb7b"
                boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x018a }
                if (r6 == 0) goto L_0x0169
                goto L_0x018d
            L_0x0169:
                e.c.f.i r6 = r0.f6943b     // Catch:{ all -> 0x018a }
                android.content.SharedPreferences$Editor r7 = r6.f7009c     // Catch:{ all -> 0x018a }
                java.lang.String r8 = "svi"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
                r9.<init>()     // Catch:{ all -> 0x018a }
                r9.append(r3)     // Catch:{ all -> 0x018a }
                r9.append(r4)     // Catch:{ all -> 0x018a }
                r9.append(r5)     // Catch:{ all -> 0x018a }
                java.lang.String r3 = r9.toString()     // Catch:{ all -> 0x018a }
                r7.putString(r8, r3)     // Catch:{ all -> 0x018a }
                android.content.SharedPreferences$Editor r3 = r6.f7009c     // Catch:{ all -> 0x018a }
                r3.commit()     // Catch:{ all -> 0x018a }
                goto L_0x018d
            L_0x018a:
                e.c.f.c.d()     // Catch:{ all -> 0x0222 }
            L_0x018d:
                android.content.Context r3 = r10.f6956a     // Catch:{ all -> 0x0222 }
                e.c.f.n.k r5 = e.c.f.n.k.a(r3)     // Catch:{ all -> 0x01ad }
                java.lang.String r5 = r5.b()     // Catch:{ all -> 0x01ad }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01ad }
                if (r5 == 0) goto L_0x01b0
                e.c.f.n.k r5 = e.c.f.n.k.a(r3)     // Catch:{ all -> 0x01ad }
                java.lang.String r5 = r5.a()     // Catch:{ all -> 0x01ad }
                e.c.f.n.k r3 = e.c.f.n.k.a(r3)     // Catch:{ all -> 0x01ad }
                r3.a(r5)     // Catch:{ all -> 0x01ad }
                goto L_0x01b0
            L_0x01ad:
                e.c.f.c.d()     // Catch:{ all -> 0x0222 }
            L_0x01b0:
                int r3 = r10.f6960e     // Catch:{ all -> 0x01bd }
                if (r3 <= 0) goto L_0x01c0
                int r3 = r10.f6960e     // Catch:{ all -> 0x01bd }
                int r3 = r3 * 1000
                long r5 = (long) r3     // Catch:{ all -> 0x01bd }
                java.lang.Thread.sleep(r5)     // Catch:{ all -> 0x01bd }
                goto L_0x01c0
            L_0x01bd:
                e.c.f.c.d()     // Catch:{ all -> 0x0222 }
            L_0x01c0:
                r3 = 0
                android.content.Context r5 = r10.f6956a     // Catch:{ all -> 0x0222 }
                java.lang.String r6 = "leroadcfg"
                r7 = 4
                android.content.SharedPreferences r8 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01df }
                android.content.SharedPreferences$Editor r3 = r8.edit()     // Catch:{ all -> 0x01df }
                android.content.SharedPreferences r6 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01df }
                r6.edit()     // Catch:{ all -> 0x01df }
                java.lang.String r6 = "re_po_rt"
                android.content.SharedPreferences r5 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01df }
                r5.edit()     // Catch:{ all -> 0x01df }
                goto L_0x01e6
            L_0x01df:
                r5 = move-exception
                r5.getMessage()     // Catch:{ all -> 0x0222 }
                e.c.f.c.c()     // Catch:{ all -> 0x0222 }
            L_0x01e6:
                int[] r5 = r10.f6959d     // Catch:{ all -> 0x0222 }
                java.lang.String r6 = "hcpk"
                if (r5 == 0) goto L_0x0210
                int r7 = r5.length     // Catch:{ all -> 0x0222 }
                if (r7 != 0) goto L_0x01f0
                goto L_0x0210
            L_0x01f0:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
                r7.<init>()     // Catch:{ all -> 0x0222 }
            L_0x01f5:
                int r8 = r5.length     // Catch:{ all -> 0x0222 }
                if (r2 >= r8) goto L_0x0208
                r8 = r5[r2]     // Catch:{ all -> 0x0222 }
                r7.append(r8)     // Catch:{ all -> 0x0222 }
                int r8 = r5.length     // Catch:{ all -> 0x0222 }
                int r8 = r8 + -1
                if (r2 == r8) goto L_0x0205
                r7.append(r4)     // Catch:{ all -> 0x0222 }
            L_0x0205:
                int r2 = r2 + 1
                goto L_0x01f5
            L_0x0208:
                java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0222 }
                r3.putString(r6, r2)     // Catch:{ all -> 0x0222 }
                goto L_0x0215
            L_0x0210:
                java.lang.String r2 = ""
                r3.putString(r6, r2)     // Catch:{ all -> 0x0222 }
            L_0x0215:
                r3.commit()     // Catch:{ all -> 0x0222 }
                int r2 = e.c.f.f.d.f6940g     // Catch:{ all -> 0x0222 }
                if (r2 != 0) goto L_0x021e
                e.c.f.f.d.f6940g = r1     // Catch:{ all -> 0x0222 }
            L_0x021e:
                r0.a()     // Catch:{ all -> 0x0222 }
                return
            L_0x0222:
                e.c.f.c.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.a.run():void");
        }
    }

    /* compiled from: MethodImpl */
    public static class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Callback f6961a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f6962b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ String f6963c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ Class[] f6964d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ Object[] f6965e;

        public b(Callback callback, int i2, String str, Class[] clsArr, Object[] objArr) {
            this.f6961a = callback;
            this.f6962b = i2;
            this.f6963c = str;
            this.f6964d = clsArr;
            this.f6965e = objArr;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x010c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r14 = this;
                android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                r1 = 50
                r3 = 20
                r4 = 1
                r5 = 0
                if (r0 != 0) goto L_0x0033
                r6 = r5
            L_0x000b:
                if (r6 >= r3) goto L_0x001b
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0014
            L_0x0011:
                e.c.f.c.d()     // Catch:{ all -> 0x0139 }
            L_0x0014:
                android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                if (r0 != 0) goto L_0x001b
                int r6 = r6 + 1
                goto L_0x000b
            L_0x001b:
                if (r0 != 0) goto L_0x0033
                e.c.f.c.a()     // Catch:{ all -> 0x0139 }
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x0032
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0139 }
                r2 = 4
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0139 }
                r1[r5] = r2     // Catch:{ all -> 0x0139 }
                r0.onError(r1)     // Catch:{ all -> 0x0139 }
            L_0x0032:
                return
            L_0x0033:
                android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                boolean r0 = e.c.f.n.a.a(r0, r5)     // Catch:{ all -> 0x0139 }
                r6 = 11
                if (r0 != 0) goto L_0x0052
                e.c.f.c.a()     // Catch:{ all -> 0x0139 }
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x0051
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0139 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0139 }
                r1[r5] = r2     // Catch:{ all -> 0x0139 }
                r0.onError(r1)     // Catch:{ all -> 0x0139 }
            L_0x0051:
                return
            L_0x0052:
                android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                java.lang.String r0 = e.c.f.n.a.a(r0)     // Catch:{ all -> 0x0139 }
                boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0139 }
                if (r7 == 0) goto L_0x00b8
                android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0139 }
                boolean r0 = e.c.f.n.a.b(r0)     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x007d
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x007c
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0139 }
                r2 = 5
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0139 }
                r1[r5] = r2     // Catch:{ all -> 0x0139 }
                r0.onError(r1)     // Catch:{ all -> 0x0139 }
            L_0x007c:
                return
            L_0x007d:
                e.c.f.c.a()     // Catch:{ all -> 0x0139 }
                e.c.f.f.d r0 = e.c.f.f.d.f6938e     // Catch:{ all -> 0x0139 }
                if (r0 != 0) goto L_0x00a9
                r7 = r5
            L_0x0085:
                if (r7 >= r3) goto L_0x0095
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x008b }
                goto L_0x008e
            L_0x008b:
                e.c.f.c.d()     // Catch:{ all -> 0x0139 }
            L_0x008e:
                e.c.f.f.d r0 = e.c.f.f.d.f6938e     // Catch:{ all -> 0x0139 }
                if (r0 != 0) goto L_0x0095
                int r7 = r7 + 1
                goto L_0x0085
            L_0x0095:
                if (r0 != 0) goto L_0x00a9
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x00a8
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0139 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0139 }
                r1[r5] = r2     // Catch:{ all -> 0x0139 }
                r0.onError(r1)     // Catch:{ all -> 0x0139 }
            L_0x00a8:
                return
            L_0x00a9:
                r6 = r0
                int r7 = r14.f6962b     // Catch:{ all -> 0x0139 }
                java.lang.String r8 = r14.f6963c     // Catch:{ all -> 0x0139 }
                com.baidu.sofire.ac.Callback r9 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Class[] r10 = r14.f6964d     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r11 = r14.f6965e     // Catch:{ all -> 0x0139 }
                r6.a(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0139 }
                return
            L_0x00b8:
                boolean r0 = e.c.f.n.a.b(r0)     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x00fe
                e.c.f.c.a()     // Catch:{ all -> 0x0139 }
                android.content.Context r9 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x0139 }
                int r10 = r14.f6962b     // Catch:{ all -> 0x0139 }
                java.lang.String r11 = r14.f6963c     // Catch:{ all -> 0x0139 }
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Class[] r12 = r14.f6964d     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r13 = r14.f6965e     // Catch:{ all -> 0x0139 }
                boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00ec }
                if (r1 == 0) goto L_0x00e1
                if (r0 == 0) goto L_0x00fd
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ec }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00ec }
                r1[r5] = r2     // Catch:{ all -> 0x00ec }
                r0.onError(r1)     // Catch:{ all -> 0x00ec }
                goto L_0x00fd
            L_0x00e1:
                e.c.f.f.e$e r1 = new e.c.f.f.e$e     // Catch:{ all -> 0x00ec }
                r7 = r1
                r8 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ec }
                r1.start()     // Catch:{ all -> 0x00ec }
                goto L_0x00fd
            L_0x00ec:
                if (r0 == 0) goto L_0x00fa
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x00fa }
                r2 = 3
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00fa }
                r1[r5] = r2     // Catch:{ all -> 0x00fa }
                r0.onError(r1)     // Catch:{ all -> 0x00fa }
            L_0x00fa:
                e.c.f.c.d()     // Catch:{ all -> 0x0139 }
            L_0x00fd:
                return
            L_0x00fe:
                e.c.f.c.a()     // Catch:{ all -> 0x0139 }
                e.c.f.f.d r0 = e.c.f.f.d.f6938e     // Catch:{ all -> 0x0139 }
                if (r0 != 0) goto L_0x012a
                r7 = r5
            L_0x0106:
                if (r7 >= r3) goto L_0x0116
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x010c }
                goto L_0x010f
            L_0x010c:
                e.c.f.c.d()     // Catch:{ all -> 0x0139 }
            L_0x010f:
                e.c.f.f.d r0 = e.c.f.f.d.f6938e     // Catch:{ all -> 0x0139 }
                if (r0 != 0) goto L_0x0116
                int r7 = r7 + 1
                goto L_0x0106
            L_0x0116:
                if (r0 != 0) goto L_0x012a
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                if (r0 == 0) goto L_0x0129
                com.baidu.sofire.ac.Callback r0 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0139 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0139 }
                r1[r5] = r2     // Catch:{ all -> 0x0139 }
                r0.onError(r1)     // Catch:{ all -> 0x0139 }
            L_0x0129:
                return
            L_0x012a:
                r6 = r0
                int r7 = r14.f6962b     // Catch:{ all -> 0x0139 }
                java.lang.String r8 = r14.f6963c     // Catch:{ all -> 0x0139 }
                com.baidu.sofire.ac.Callback r9 = r14.f6961a     // Catch:{ all -> 0x0139 }
                java.lang.Class[] r10 = r14.f6964d     // Catch:{ all -> 0x0139 }
                java.lang.Object[] r11 = r14.f6965e     // Catch:{ all -> 0x0139 }
                r6.a(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0139 }
                return
            L_0x0139:
                e.c.f.c.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.b.run():void");
        }
    }

    /* compiled from: MethodImpl */
    public static class c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Context f6966a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ String f6967b;

        public c(Context context, String str) {
            this.f6966a = context;
            this.f6967b = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            e.c.f.c.d();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                java.lang.Class<e.c.f.f.e> r0 = e.c.f.f.e.class
                monitor-enter(r0)
                android.content.Context r1 = r5.f6966a     // Catch:{ all -> 0x003a }
                r2 = 0
                r3 = 0
                java.lang.String r4 = "leroadcfg"
                android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)     // Catch:{ all -> 0x0012 }
                android.content.SharedPreferences$Editor r2 = r1.edit()     // Catch:{ all -> 0x0013 }
                goto L_0x0016
            L_0x0012:
                r1 = r2
            L_0x0013:
                e.c.f.c.d()     // Catch:{ all -> 0x003a }
            L_0x0016:
                java.lang.String r4 = "td_a_c"
                int r1 = r1.getInt(r4, r3)     // Catch:{ all -> 0x003a }
                int r1 = r1 + 1
                if (r1 >= 0) goto L_0x0021
                goto L_0x0022
            L_0x0021:
                r3 = r1
            L_0x0022:
                java.lang.String r1 = "td_a_c"
                r2.putInt(r1, r3)     // Catch:{ all -> 0x003a }
                r2.commit()     // Catch:{ all -> 0x003a }
                android.content.Context r1 = r5.f6966a     // Catch:{ all -> 0x003a }
                e.c.f.n.k r1 = e.c.f.n.k.a(r1)     // Catch:{ all -> 0x003a }
                java.lang.String r2 = r5.f6967b     // Catch:{ all -> 0x003a }
                java.lang.String r1 = r1.a(r2, r3)     // Catch:{ all -> 0x003a }
                e.c.f.f.e.f6954b = r1     // Catch:{ all -> 0x003a }
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                return
            L_0x003a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.c.run():void");
        }
    }

    /* compiled from: MethodImpl */
    public static class d extends Callback {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Bundle f6968a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ c f6969b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f6970c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ String f6971d;

        public d(Bundle bundle, c cVar, CountDownLatch countDownLatch, String str) {
            this.f6968a = bundle;
            this.f6969b = cVar;
            this.f6970c = countDownLatch;
            this.f6971d = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
            r3.f6970c.countDown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
            throw r4;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object onEnd(java.lang.Object... r4) {
            /*
                r3 = this;
                android.os.Bundle r0 = r3.f6968a     // Catch:{ all -> 0x000f }
                java.lang.String r1 = "status"
                r2 = 0
                r0.putInt(r1, r2)     // Catch:{ all -> 0x000f }
                e.c.f.f.c r0 = r3.f6969b     // Catch:{ all -> 0x000f }
                r4 = r4[r2]     // Catch:{ all -> 0x000f }
                r0.f6937f = r4     // Catch:{ all -> 0x000f }
                goto L_0x0012
            L_0x000f:
                e.c.f.c.d()     // Catch:{ all -> 0x0019 }
            L_0x0012:
                java.util.concurrent.CountDownLatch r4 = r3.f6970c
                r4.countDown()
                r4 = 0
                return r4
            L_0x0019:
                r4 = move-exception
                java.util.concurrent.CountDownLatch r0 = r3.f6970c
                r0.countDown()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.d.onEnd(java.lang.Object[]):java.lang.Object");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
            r4.f6970c.countDown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
            throw r5;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x002c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object onError(java.lang.Object... r5) {
            /*
                r4 = this;
                android.os.Bundle r0 = r4.f6968a     // Catch:{ all -> 0x002c }
                java.lang.String r1 = "status"
                r2 = 0
                r3 = r5[r2]     // Catch:{ all -> 0x002c }
                java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x002c }
                int r3 = r3.intValue()     // Catch:{ all -> 0x002c }
                r0.putInt(r1, r3)     // Catch:{ all -> 0x002c }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
                r0.<init>()     // Catch:{ all -> 0x002c }
                java.lang.String r1 = r4.f6971d     // Catch:{ all -> 0x002c }
                r0.append(r1)     // Catch:{ all -> 0x002c }
                java.lang.String r1 = "onError "
                r0.append(r1)     // Catch:{ all -> 0x002c }
                r5 = r5[r2]     // Catch:{ all -> 0x002c }
                java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x002c }
                r0.append(r5)     // Catch:{ all -> 0x002c }
                e.c.f.c.a()     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                e.c.f.c.d()     // Catch:{ all -> 0x0036 }
            L_0x002f:
                java.util.concurrent.CountDownLatch r5 = r4.f6970c
                r5.countDown()
                r5 = 0
                return r5
            L_0x0036:
                r5 = move-exception
                java.util.concurrent.CountDownLatch r0 = r4.f6970c
                r0.countDown()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.d.onError(java.lang.Object[]):java.lang.Object");
        }
    }

    /* renamed from: e.c.f.f.e$e reason: collision with other inner class name */
    /* compiled from: MethodImpl */
    public static class C0075e extends Thread {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Callback f6972a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Context f6973b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ int f6974c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ String f6975d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ Class[] f6976e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ Object[] f6977f;

        public C0075e(Callback callback, Context context, int i2, String str, Class[] clsArr, Object[] objArr) {
            this.f6972a = callback;
            this.f6973b = context;
            this.f6974c = i2;
            this.f6975d = str;
            this.f6976e = clsArr;
            this.f6977f = objArr;
        }

        public final void run() {
            super.run();
            Callback callback = this.f6972a;
            if (callback != null) {
                callback.onBegin(new Object[0]);
            }
            Pair a2 = e.a(this.f6973b, this.f6974c, 0, this.f6975d, this.f6976e, this.f6977f);
            if (this.f6972a != null) {
                if (((Integer) a2.first).intValue() != 0) {
                    this.f6972a.onError(a2.first);
                    return;
                }
                this.f6972a.onEnd(a2.second);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r9, int r10, java.lang.String r11, java.lang.String r12, int... r13) {
        /*
            java.lang.Class<e.c.f.f.e> r0 = e.c.f.f.e.class
            monitor-enter(r0)
            boolean r1 = f6955c     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            f6955c = r1     // Catch:{ all -> 0x0023 }
            e.c.f.f.d.f6939f = r9     // Catch:{ all -> 0x0023 }
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x0023 }
            e.c.f.f.e$a r8 = new e.c.f.f.e$a     // Catch:{ all -> 0x0023 }
            r2 = r8
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0023 }
            r1.<init>(r8)     // Catch:{ all -> 0x0023 }
            r1.start()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return
        L_0x0023:
            e.c.f.c.d()     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)
            return
        L_0x0028:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.a(android.content.Context, int, java.lang.String, java.lang.String, int[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0092, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r8) {
        /*
            java.lang.String r0 = "xytk_m"
            java.lang.String r1 = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03"
            java.lang.String r2 = ""
            r3 = 0
            r4 = 0
            java.lang.String r5 = "leroadcfg"
            android.content.SharedPreferences r5 = r8.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0013 }
            android.content.SharedPreferences$Editor r3 = r5.edit()     // Catch:{ all -> 0x0014 }
            goto L_0x0017
        L_0x0013:
            r5 = r3
        L_0x0014:
            e.c.f.c.d()     // Catch:{ all -> 0x0092 }
        L_0x0017:
            java.lang.String r6 = "xytk"
            java.lang.String r6 = r5.getString(r6, r2)     // Catch:{ all -> 0x0092 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0092 }
            if (r7 != 0) goto L_0x0026
            f6953a = r6     // Catch:{ all -> 0x0092 }
            return r6
        L_0x0026:
            java.lang.String r2 = r5.getString(r0, r2)     // Catch:{ all -> 0x0092 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0092 }
            if (r5 != 0) goto L_0x0033
            f6953a = r2     // Catch:{ all -> 0x0092 }
            return r2
        L_0x0033:
            java.lang.String r8 = e.c.f.n.c.b(r8)     // Catch:{ all -> 0x0092 }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0092 }
            if (r2 != 0) goto L_0x0095
            java.lang.String r2 = "\\|"
            java.lang.String[] r8 = r8.split(r2)     // Catch:{ all -> 0x0092 }
            if (r8 == 0) goto L_0x008f
            int r2 = r8.length     // Catch:{ all -> 0x0092 }
            r5 = 2
            if (r2 != r5) goto L_0x008f
            r2 = r8[r4]     // Catch:{ all -> 0x0092 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0092 }
            if (r2 != 0) goto L_0x008f
            r2 = 1
            r5 = r8[r2]     // Catch:{ all -> 0x0092 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0092 }
            if (r5 == 0) goto L_0x005b
            goto L_0x008f
        L_0x005b:
            com.baidu.sofire.ac.F r5 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ all -> 0x0092 }
            r2 = r8[r2]     // Catch:{ all -> 0x0092 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0092 }
            r6 = r8[r4]     // Catch:{ all -> 0x0092 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x0092 }
            byte[] r2 = r5.re(r2, r6)     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x0095
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r5.<init>()     // Catch:{ all -> 0x0092 }
            r8 = r8[r4]     // Catch:{ all -> 0x0092 }
            r5.append(r8)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = e.c.f.n.a.a(r2)     // Catch:{ all -> 0x0092 }
            r5.append(r8)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0092 }
            r3.putString(r0, r8)     // Catch:{ all -> 0x0092 }
            r3.commit()     // Catch:{ all -> 0x0092 }
            f6953a = r8     // Catch:{ all -> 0x0092 }
            return r8
        L_0x008f:
            f6953a = r1     // Catch:{ all -> 0x0092 }
            return r1
        L_0x0092:
            e.c.f.c.d()
        L_0x0095:
            f6953a = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.b(android.content.Context):java.lang.String");
    }

    public static Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = d.f6939f;
            if (context == null) {
                return new Pair<>(Integer.valueOf(4), null);
            }
            if (!e.c.f.n.a.a(d.f6939f, false)) {
                e.c.f.c.a();
                return new Pair<>(Integer.valueOf(11), null);
            }
            String a2 = e.c.f.n.a.a(d.f6939f);
            if (TextUtils.isEmpty(a2)) {
                if (e.c.f.n.a.b(d.f6939f.getPackageName())) {
                    return new Pair<>(Integer.valueOf(5), null);
                }
                e.c.f.c.a();
                return d.a(context).a(i2, str, clsArr, objArr);
            } else if (e.c.f.n.a.b(a2)) {
                e.c.f.c.a();
                return a(d.f6939f, i2, str, clsArr, objArr);
            } else {
                e.c.f.c.a();
                return d.a(context).a(i2, str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            e.c.f.c.d();
            return new Pair<>(Integer.valueOf(3), null);
        }
    }

    public static Pair<Integer, Object> b(String str, Class<?>[] clsArr, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(Integer.valueOf(1), null);
        }
        try {
            g gVar = g.f6978g;
            if (gVar == null) {
                return new Pair<>(Integer.valueOf(3), null);
            }
            ApkInfo c2 = gVar.c("com.baidu.sofire.x0");
            if (c2 != null) {
                Class a2 = ((f) c2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                return new Pair<>(Integer.valueOf(0), e.c.f.n.a.a(a2.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(a2, new Object[]{d.f6939f}), str, clsArr, objArr));
            }
            return new Pair<>(Integer.valueOf(3), null);
        } catch (Throwable unused) {
            e.c.f.c.d();
        }
    }

    public static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = d.f6939f;
            if (context == null) {
                return new Pair<>(Integer.valueOf(4), null);
            }
            if (!e.c.f.n.a.a(d.f6939f, false)) {
                return new Pair<>(Integer.valueOf(11), null);
            }
            String a2 = e.c.f.n.a.a(d.f6939f);
            if (TextUtils.isEmpty(a2)) {
                if (e.c.f.n.a.b(d.f6939f.getPackageName())) {
                    return new Pair<>(Integer.valueOf(5), null);
                }
                d.a(context);
                return b(str, clsArr, objArr);
            } else if (e.c.f.n.a.b(a2)) {
                return a(d.f6939f, 1, str, clsArr, objArr);
            } else {
                d.a(context);
                return b(str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            e.c.f.c.d();
            return new Pair<>(Integer.valueOf(3), null);
        }
    }

    public static String b(Context context, String str, int i2, String str2) {
        Class<String> cls = String.class;
        if (i2 != 0) {
            String str3 = "ice";
            if (TextUtils.isEmpty(str2)) {
                a(1, str3, (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE}, str, Integer.valueOf(i2));
            } else {
                a(1, str3, (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE, cls}, str, Integer.valueOf(i2), str2);
            }
        }
        return b(context);
    }

    public static boolean a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            m a2 = m.a();
            b bVar = new b(callback, i2, str, clsArr, objArr);
            a2.a(bVar);
            return true;
        } catch (Throwable unused) {
            e.c.f.c.d();
            return false;
        }
    }

    public static String a(Context context, String str, int i2, String str2) {
        Class<String> cls = String.class;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(f6953a)) {
                if (i2 != 0) {
                    String str4 = "ice";
                    if (TextUtils.isEmpty(str2)) {
                        a(1, str4, (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE}, str, Integer.valueOf(i2));
                    } else {
                        a(1, str4, (Callback) null, (Class<?>[]) new Class[]{cls, Integer.TYPE, cls}, str, Integer.valueOf(i2), str2);
                    }
                }
                return f6953a;
            } else if (!e.c.f.n.a.a(context, false)) {
                e.c.f.c.a();
                return str3;
            } else {
                String a2 = e.c.f.n.a.a(context);
                if (TextUtils.isEmpty(a2)) {
                    if (e.c.f.n.a.b(context.getPackageName())) {
                        return str3;
                    }
                    e.c.f.c.a();
                    return b(context, str, i2, str2);
                } else if (e.c.f.n.a.b(a2)) {
                    e.c.f.c.a();
                    Pair a3 = a(context, 0, "gzfi", (Class<?>[]) null, str, Integer.valueOf(i2), str2);
                    return (a3 == null || ((Integer) a3.first).intValue() != 0) ? str3 : (String) a3.second;
                } else {
                    e.c.f.c.a();
                    return b(context, str, i2, str2);
                }
            }
        } catch (Throwable unused) {
            e.c.f.c.d();
        }
        return str3;
    }

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(f6953a)) {
                return f6953a;
            }
            String str = "";
            if (!e.c.f.n.a.a(context, false)) {
                e.c.f.c.a();
                return str;
            }
            String a2 = e.c.f.n.a.a(context);
            if (TextUtils.isEmpty(a2)) {
                if (e.c.f.n.a.b(context.getPackageName())) {
                    return str;
                }
                e.c.f.c.a();
                return b(context);
            } else if (e.c.f.n.a.b(a2)) {
                e.c.f.c.a();
                Pair a3 = a(context, 0, "gz", (Class<?>[]) null, new Object[0]);
                if (a3 != null) {
                    return ((Integer) a3.first).intValue() == 0 ? (String) a3.second : str;
                }
                String str2 = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                f6953a = str2;
                return str2;
            } else {
                e.c.f.c.a();
                return b(context);
            }
        } catch (Throwable unused) {
            e.c.f.c.d();
        }
    }

    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.Class[]] */
    /* JADX WARNING: type inference failed for: r11v3, types: [java.lang.Class[]] */
    /* JADX WARNING: type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v33, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:69|70|71) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:61|62|63|64|65|66) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        e.c.f.c.d();
        r3.putInt(r2, 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        e.c.f.c.d();
        r3.putParcelable(r10, r0);
        r3.putInt(r2, 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0187, code lost:
        return r3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0165 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x017d */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String, java.lang.Class[], ?[OBJECT, ARRAY]]
  uses: [java.lang.Class[], java.lang.String, ?[OBJECT, ARRAY][]]
  mth insns count: 177
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
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091 A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:9:0x0033=Splitter:B:9:0x0033, B:69:0x017d=Splitter:B:69:0x017d} */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle a(android.content.Context r17, java.lang.String r18, android.os.Bundle r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "status"
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r4.<init>()     // Catch:{ all -> 0x01b0 }
            r4.append(r0)     // Catch:{ all -> 0x01b0 }
            e.c.f.c.a()     // Catch:{ all -> 0x01b0 }
            java.lang.String r4 = "gzfi"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x01b0 }
            r5 = 3
            r6 = 8
            r7 = 7
            java.lang.String r8 = "args"
            r9 = 2
            java.lang.String r10 = "result"
            r11 = 0
            r12 = 1
            r13 = 0
            if (r4 == 0) goto L_0x00b5
            if (r1 == 0) goto L_0x01b3
            e.c.f.f.c r0 = new e.c.f.f.c     // Catch:{ all -> 0x01b0 }
            r0.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.Class<com.baidu.sofire.MyProvider> r4 = com.baidu.sofire.MyProvider.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x00ae }
            r1.setClassLoader(r4)     // Catch:{ all -> 0x00ae }
            android.os.Parcelable r1 = r1.getParcelable(r8)     // Catch:{ all -> 0x00ae }
            e.c.f.f.c r1 = (e.c.f.f.c) r1     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x0089
            java.lang.Object[] r4 = r1.f6936e     // Catch:{ all -> 0x00ae }
            int r4 = r4.length     // Catch:{ all -> 0x00ae }
            if (r4 != r9) goto L_0x006b
            java.lang.Object[] r4 = r1.f6936e     // Catch:{ all -> 0x00ae }
            r4 = r4[r13]     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00ae }
            java.lang.Object[] r1 = r1.f6936e     // Catch:{ all -> 0x00ae }
            r1 = r1[r12]     // Catch:{ all -> 0x00ae }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "args "
            r5.<init>(r8)     // Catch:{ all -> 0x00ae }
            r5.append(r4)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = " "
            r5.append(r8)     // Catch:{ all -> 0x00ae }
            r5.append(r1)     // Catch:{ all -> 0x00ae }
            r16 = r11
            r11 = r4
            r4 = r16
            goto L_0x008b
        L_0x006b:
            java.lang.Object[] r4 = r1.f6936e     // Catch:{ all -> 0x00ae }
            int r4 = r4.length     // Catch:{ all -> 0x00ae }
            if (r4 != r5) goto L_0x0089
            java.lang.Object[] r4 = r1.f6936e     // Catch:{ all -> 0x00ae }
            r4 = r4[r13]     // Catch:{ all -> 0x00ae }
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00ae }
            java.lang.Object[] r4 = r1.f6936e     // Catch:{ all -> 0x00ae }
            r4 = r4[r12]     // Catch:{ all -> 0x00ae }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00ae }
            java.lang.Object[] r1 = r1.f6936e     // Catch:{ all -> 0x00ae }
            r1 = r1[r9]     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ae }
            r16 = r4
            r4 = r1
            r1 = r16
            goto L_0x008b
        L_0x0089:
            r1 = r11
            r4 = r1
        L_0x008b:
            if (r1 != 0) goto L_0x0091
            r14 = r17
            r1 = r13
            goto L_0x0097
        L_0x0091:
            int r1 = r1.intValue()     // Catch:{ all -> 0x00ae }
            r14 = r17
        L_0x0097:
            java.lang.String r1 = b(r14, r11, r1, r4)     // Catch:{ all -> 0x00ae }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x00a5
            r3.putInt(r2, r6)     // Catch:{ all -> 0x00ae }
            goto L_0x00ad
        L_0x00a5:
            r0.f6937f = r1     // Catch:{ all -> 0x00ae }
            r3.putParcelable(r10, r0)     // Catch:{ all -> 0x00ae }
            r3.putInt(r2, r13)     // Catch:{ all -> 0x00ae }
        L_0x00ad:
            return r3
        L_0x00ae:
            e.c.f.c.d()     // Catch:{ all -> 0x01b0 }
            r3.putInt(r2, r7)     // Catch:{ all -> 0x01b0 }
            return r3
        L_0x00b5:
            r14 = r17
            java.lang.String r4 = "invokeMethod"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x01b0 }
            if (r4 == 0) goto L_0x0188
            if (r1 == 0) goto L_0x01b3
            e.c.f.f.c r0 = new e.c.f.f.c     // Catch:{ all -> 0x01b0 }
            r0.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.Class<com.baidu.sofire.MyProvider> r4 = com.baidu.sofire.MyProvider.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x017d }
            r1.setClassLoader(r4)     // Catch:{ all -> 0x017d }
            android.os.Parcelable r1 = r1.getParcelable(r8)     // Catch:{ all -> 0x017d }
            e.c.f.f.c r1 = (e.c.f.f.c) r1     // Catch:{ all -> 0x017d }
            int r4 = r1.f6932a     // Catch:{ all -> 0x017d }
            int r6 = r1.f6933b     // Catch:{ all -> 0x017d }
            java.lang.String r8 = r1.f6934c     // Catch:{ all -> 0x017d }
            java.lang.Object[] r9 = r1.f6935d     // Catch:{ all -> 0x017d }
            if (r9 == 0) goto L_0x011c
            int r11 = r9.length     // Catch:{ all -> 0x017d }
            java.lang.Class[] r11 = new java.lang.Class[r11]     // Catch:{ all -> 0x017d }
        L_0x00e2:
            int r14 = r9.length     // Catch:{ all -> 0x017d }
            if (r13 >= r14) goto L_0x011c
            r14 = r9[r13]     // Catch:{ all -> 0x017d }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x017d }
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x017d }
            if (r15 != 0) goto L_0x010e
            java.lang.String r15 = "@@"
            boolean r15 = r14.contains(r15)     // Catch:{ all -> 0x017d }
            if (r15 == 0) goto L_0x010e
            java.lang.Class r14 = e.c.f.n.a.a(r14)     // Catch:{ all -> 0x017d }
            if (r14 == 0) goto L_0x0118
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            java.lang.String r7 = "convert back class name "
            r15.<init>(r7)     // Catch:{ all -> 0x017d }
            java.lang.String r7 = r14.getCanonicalName()     // Catch:{ all -> 0x017d }
            r15.append(r7)     // Catch:{ all -> 0x017d }
            r11[r13] = r14     // Catch:{ all -> 0x017d }
            goto L_0x0118
        L_0x010e:
            r7 = r9[r13]     // Catch:{ all -> 0x017d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x017d }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x017d }
            r11[r13] = r7     // Catch:{ all -> 0x017d }
        L_0x0118:
            int r13 = r13 + 1
            r7 = 7
            goto L_0x00e2
        L_0x011c:
            java.lang.Object[] r1 = r1.f6936e     // Catch:{ all -> 0x017d }
            if (r6 != r12) goto L_0x014d
            if (r4 != r12) goto L_0x012f
            java.lang.String r5 = "xgz"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x017d }
            if (r5 == 0) goto L_0x012f
            android.util.Pair r1 = b(r8, r11, r1)     // Catch:{ all -> 0x017d }
            goto L_0x0133
        L_0x012f:
            android.util.Pair r1 = a(r4, r8, (java.lang.Class<?>[]) r11, r1)     // Catch:{ all -> 0x017d }
        L_0x0133:
            java.lang.Object r4 = r1.first     // Catch:{ all -> 0x017d }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x017d }
            int r4 = r4.intValue()     // Catch:{ all -> 0x017d }
            r3.putInt(r2, r4)     // Catch:{ all -> 0x017d }
            java.lang.Object r4 = r1.first     // Catch:{ all -> 0x017d }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x017d }
            int r4 = r4.intValue()     // Catch:{ all -> 0x017d }
            if (r4 != 0) goto L_0x016b
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x017d }
            r0.f6937f = r1     // Catch:{ all -> 0x017d }
            goto L_0x016b
        L_0x014d:
            if (r6 != 0) goto L_0x016b
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x017d }
            r6.<init>(r12)     // Catch:{ all -> 0x017d }
            e.c.f.f.e$d r7 = new e.c.f.f.e$d     // Catch:{ all -> 0x017d }
            r7.<init>(r3, r0, r6, r8)     // Catch:{ all -> 0x017d }
            a(r4, r8, r7, (java.lang.Class<?>[]) r11, r1)     // Catch:{ all -> 0x017d }
            r7 = 180000(0x2bf20, double:8.8932E-319)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0165 }
            r6.await(r7, r1)     // Catch:{ all -> 0x0165 }
            goto L_0x016b
        L_0x0165:
            r3.putInt(r2, r5)     // Catch:{ all -> 0x017d }
            e.c.f.c.d()     // Catch:{ all -> 0x017d }
        L_0x016b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            java.lang.String r4 = "return bundle"
            r1.<init>(r4)     // Catch:{ all -> 0x017d }
            int r4 = r3.getInt(r2)     // Catch:{ all -> 0x017d }
            r1.append(r4)     // Catch:{ all -> 0x017d }
            r3.putParcelable(r10, r0)     // Catch:{ all -> 0x017d }
            return r3
        L_0x017d:
            e.c.f.c.d()     // Catch:{ all -> 0x01b0 }
            r3.putParcelable(r10, r0)     // Catch:{ all -> 0x01b0 }
            r0 = 7
            r3.putInt(r2, r0)     // Catch:{ all -> 0x01b0 }
            return r3
        L_0x0188:
            java.lang.String r1 = "gz"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 == 0) goto L_0x01ac
            java.lang.String r0 = b(r17)     // Catch:{ all -> 0x01b0 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01b0 }
            if (r1 == 0) goto L_0x019e
            r3.putInt(r2, r6)     // Catch:{ all -> 0x01b0 }
            goto L_0x01ab
        L_0x019e:
            e.c.f.f.c r1 = new e.c.f.f.c     // Catch:{ all -> 0x01b0 }
            r1.<init>()     // Catch:{ all -> 0x01b0 }
            r1.f6937f = r0     // Catch:{ all -> 0x01b0 }
            r3.putParcelable(r10, r1)     // Catch:{ all -> 0x01b0 }
            r3.putInt(r2, r13)     // Catch:{ all -> 0x01b0 }
        L_0x01ab:
            return r3
        L_0x01ac:
            r3.putInt(r2, r9)     // Catch:{ all -> 0x01b0 }
            return r3
        L_0x01b0:
            e.c.f.c.d()
        L_0x01b3:
            r0 = 10
            r3.putInt(r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.a(android.content.Context, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[Catch:{ all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1 A[Catch:{ all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa A[Catch:{ all -> 0x00d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Object> a(android.content.Context r5, int r6, int r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Object... r10) {
        /*
            r0 = 3
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x0012
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00d4 }
            android.util.Pair r5 = android.util.Pair.create(r5, r1)     // Catch:{ all -> 0x00d4 }
            return r5
        L_0x0012:
            java.lang.String r2 = "gzfi"
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x00d4 }
            if (r2 != 0) goto L_0x0026
            java.lang.String r2 = "gz"
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            java.lang.String r2 = "invokeMethod"
            goto L_0x0027
        L_0x0026:
            r2 = r8
        L_0x0027:
            e.c.f.f.c r3 = new e.c.f.f.c     // Catch:{ all -> 0x00d4 }
            r3.<init>()     // Catch:{ all -> 0x00d4 }
            r3.f6932a = r6     // Catch:{ all -> 0x00d4 }
            r3.f6934c = r8     // Catch:{ all -> 0x00d4 }
            r3.f6933b = r7     // Catch:{ all -> 0x00d4 }
            if (r9 == 0) goto L_0x0070
            int r6 = r9.length     // Catch:{ all -> 0x00d4 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00d4 }
            r7 = 0
        L_0x0038:
            int r8 = r9.length     // Catch:{ all -> 0x00d4 }
            if (r7 >= r8) goto L_0x006e
            r8 = r9[r7]     // Catch:{ all -> 0x00d4 }
            boolean r8 = r8.isPrimitive()     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x0063
            r8 = r9[r7]     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = e.c.f.n.a.a(r8)     // Catch:{ all -> 0x00d4 }
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00d4 }
            if (r4 != 0) goto L_0x006b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r4.<init>()     // Catch:{ all -> 0x00d4 }
            r4.append(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = "@@"
            r4.append(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00d4 }
            r6[r7] = r8     // Catch:{ all -> 0x00d4 }
            goto L_0x006b
        L_0x0063:
            r8 = r9[r7]     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = r8.getCanonicalName()     // Catch:{ all -> 0x00d4 }
            r6[r7] = r8     // Catch:{ all -> 0x00d4 }
        L_0x006b:
            int r7 = r7 + 1
            goto L_0x0038
        L_0x006e:
            r3.f6935d = r6     // Catch:{ all -> 0x00d4 }
        L_0x0070:
            r3.f6936e = r10     // Catch:{ all -> 0x00d4 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00d4 }
            r6.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = "args"
            r6.putParcelable(r7, r3)     // Catch:{ all -> 0x00d4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = "content://"
            r7.<init>(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = r5.getPackageName()     // Catch:{ all -> 0x00d4 }
            r7.append(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r8 = ".sofire.ac.provider"
            r7.append(r8)     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00d4 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x00d4 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ all -> 0x00d4 }
            android.os.Bundle r5 = r5.call(r7, r2, r1, r6)     // Catch:{ all -> 0x00d4 }
            if (r5 != 0) goto L_0x00aa
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00d4 }
            android.util.Pair r5 = android.util.Pair.create(r5, r1)     // Catch:{ all -> 0x00d4 }
            return r5
        L_0x00aa:
            java.lang.Class<e.c.f.f.c> r6 = e.c.f.f.c.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ all -> 0x00d4 }
            r5.setClassLoader(r6)     // Catch:{ all -> 0x00d4 }
            java.lang.String r6 = "status"
            int r6 = r5.getInt(r6)     // Catch:{ all -> 0x00d4 }
            if (r6 != 0) goto L_0x00c4
            java.lang.String r7 = "result"
            android.os.Parcelable r5 = r5.getParcelable(r7)     // Catch:{ all -> 0x00d4 }
            e.c.f.f.c r5 = (e.c.f.f.c) r5     // Catch:{ all -> 0x00d4 }
            goto L_0x00c5
        L_0x00c4:
            r5 = r1
        L_0x00c5:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00d4 }
            if (r5 != 0) goto L_0x00cd
            r5 = r1
            goto L_0x00cf
        L_0x00cd:
            java.lang.Object r5 = r5.f6937f     // Catch:{ all -> 0x00d4 }
        L_0x00cf:
            android.util.Pair r5 = android.util.Pair.create(r6, r5)     // Catch:{ all -> 0x00d4 }
            return r5
        L_0x00d4:
            e.c.f.c.d()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            android.util.Pair r5 = android.util.Pair.create(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.e.a(android.content.Context, int, int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
    }

    public static Pair<Integer, Object> a(Context context, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i2, 1, str, clsArr, objArr);
    }
}
