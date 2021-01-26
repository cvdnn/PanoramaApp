package e.c.f.f;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidubce.BceConfig;
import e.c.f.c;
import e.c.f.n.a;
import e.c.f.n.h;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: PluginloaderHub */
public final class g {

    /* renamed from: g reason: collision with root package name */
    public static g f6978g;

    /* renamed from: h reason: collision with root package name */
    public static Application f6979h;

    /* renamed from: i reason: collision with root package name */
    public static Random f6980i = new Random();

    /* renamed from: j reason: collision with root package name */
    public static List<Integer> f6981j = new ArrayList();

    /* renamed from: a reason: collision with root package name */
    public String f6982a;

    /* renamed from: b reason: collision with root package name */
    public boolean f6983b;

    /* renamed from: c reason: collision with root package name */
    public Map<String, ApkInfo> f6984c = new ConcurrentHashMap();

    /* renamed from: d reason: collision with root package name */
    public Map<String, ApkInfo> f6985d = new ConcurrentHashMap();

    /* renamed from: e reason: collision with root package name */
    public Map<String, ApkInfo> f6986e = new ConcurrentHashMap();

    /* renamed from: f reason: collision with root package name */
    public Map<String, MyReceiver> f6987f = new HashMap();

    public static g a(Context context) {
        if (f6978g == null) {
            f6979h = (Application) context.getApplicationContext();
            f6978g = new g();
        }
        return f6978g;
    }

    public static boolean d(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|25|26|72) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0041, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00f1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(e.c.f.f.h r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.IntentFilter r0 = r5.f6991d     // Catch:{ all -> 0x00f1 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r4.f6985d     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = r5.f6988a     // Catch:{ all -> 0x00f1 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00f1 }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x00f1 }
            if (r0 == 0) goto L_0x006e
            java.util.List<e.c.f.f.h> r1 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x006e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00f1 }
            r1.<init>()     // Catch:{ all -> 0x00f1 }
            r2 = 0
        L_0x001d:
            java.util.List<e.c.f.f.h> r3 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            int r3 = r3.size()     // Catch:{ all -> 0x00f1 }
            if (r2 >= r3) goto L_0x003d
            java.util.List<e.c.f.f.h> r3 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00f1 }
            e.c.f.f.h r3 = (e.c.f.f.h) r3     // Catch:{ all -> 0x00f1 }
            boolean r3 = r5.a(r3)     // Catch:{ all -> 0x00f1 }
            if (r3 == 0) goto L_0x003a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00f1 }
            r1.add(r3)     // Catch:{ all -> 0x00f1 }
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x003d:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00f1 }
        L_0x0041:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00f1 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00f1 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00f1 }
            java.util.List<e.c.f.f.h> r3 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            if (r3 == 0) goto L_0x0041
            java.util.List<e.c.f.f.h> r3 = r0.intentFilters     // Catch:{ all -> 0x005b }
            r3.remove(r2)     // Catch:{ all -> 0x005b }
            goto L_0x0041
        L_0x005b:
            e.c.f.c.d()     // Catch:{ all -> 0x00f1 }
            goto L_0x0041
        L_0x005f:
            java.util.List<e.c.f.f.h> r1 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x006e
            java.util.List<e.c.f.f.h> r1 = r0.intentFilters     // Catch:{ all -> 0x00f1 }
            int r1 = r1.size()     // Catch:{ all -> 0x00f1 }
            if (r1 != 0) goto L_0x006e
            r1 = 0
            r0.intentFilters = r1     // Catch:{ all -> 0x00f1 }
        L_0x006e:
            android.content.IntentFilter r5 = r5.f6991d     // Catch:{ all -> 0x00f1 }
            java.lang.String r5 = a(r5)     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            r0.append(r5)     // Catch:{ all -> 0x00f1 }
            e.c.f.c.a()     // Catch:{ all -> 0x00f1 }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00f1 }
            if (r0 == 0) goto L_0x0087
            monitor-exit(r4)
            return
        L_0x0087:
            java.util.List r0 = r4.a()     // Catch:{ all -> 0x00f1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00f1 }
        L_0x008f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x00d5
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00f1 }
            com.baidu.sofire.core.ApkInfo r1 = (com.baidu.sofire.core.ApkInfo) r1     // Catch:{ all -> 0x00f1 }
            java.util.List<e.c.f.f.h> r2 = r1.intentFilters     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x008f
            java.util.List<e.c.f.f.h> r2 = r1.intentFilters     // Catch:{ all -> 0x00f1 }
            int r2 = r2.size()     // Catch:{ all -> 0x00f1 }
            if (r2 <= 0) goto L_0x008f
            java.util.List<e.c.f.f.h> r1 = r1.intentFilters     // Catch:{ all -> 0x00f1 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00f1 }
        L_0x00ad:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x008f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00f1 }
            e.c.f.f.h r2 = (e.c.f.f.h) r2     // Catch:{ all -> 0x00f1 }
            android.content.IntentFilter r2 = r2.f6991d     // Catch:{ all -> 0x00f1 }
            java.lang.String r2 = a(r2)     // Catch:{ all -> 0x00f1 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00f1 }
            if (r3 != 0) goto L_0x00ad
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x00ad
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            r0.append(r5)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r4)
            return
        L_0x00d5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            r0.append(r5)     // Catch:{ all -> 0x00f1 }
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r0 = r4.f6987f     // Catch:{ all -> 0x00f1 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00f1 }
            com.baidu.sofire.MyReceiver r0 = (com.baidu.sofire.MyReceiver) r0     // Catch:{ all -> 0x00f1 }
            android.app.Application r1 = f6979h     // Catch:{ all -> 0x00f1 }
            r1.unregisterReceiver(r0)     // Catch:{ all -> 0x00f1 }
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r0 = r4.f6987f     // Catch:{ all -> 0x00f1 }
            r0.remove(r5)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r4)
            return
        L_0x00f1:
            e.c.f.c.d()     // Catch:{ all -> 0x00f6 }
            monitor-exit(r4)
            return
        L_0x00f6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.b(e.c.f.f.h):void");
    }

    public final ApkInfo c(String str) {
        try {
            return (ApkInfo) this.f6985d.get(str);
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:31|32|33|34|35|36) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0093, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0096 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(e.c.f.f.h r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.IntentFilter r0 = r5.f6991d     // Catch:{ all -> 0x0096 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r4.f6985d     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = r5.f6988a     // Catch:{ all -> 0x0096 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0096 }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0094
            java.util.List<e.c.f.f.h> r1 = r0.intentFilters     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0096 }
            r1.<init>()     // Catch:{ all -> 0x0096 }
            r0.intentFilters = r1     // Catch:{ all -> 0x0096 }
        L_0x001e:
            r1 = 0
        L_0x001f:
            java.util.List<e.c.f.f.h> r2 = r0.intentFilters     // Catch:{ all -> 0x0096 }
            int r2 = r2.size()     // Catch:{ all -> 0x0096 }
            if (r1 >= r2) goto L_0x003a
            java.util.List<e.c.f.f.h> r2 = r0.intentFilters     // Catch:{ all -> 0x0096 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0096 }
            e.c.f.f.h r2 = (e.c.f.f.h) r2     // Catch:{ all -> 0x0096 }
            boolean r2 = r5.a(r2)     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x0037
            monitor-exit(r4)
            return
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x001f
        L_0x003a:
            java.util.List<e.c.f.f.h> r0 = r0.intentFilters     // Catch:{ all -> 0x0096 }
            r0.add(r5)     // Catch:{ all -> 0x0096 }
            android.content.IntentFilter r0 = r5.f6991d     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = a(r0)     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r1.<init>()     // Catch:{ all -> 0x0096 }
            r1.append(r0)     // Catch:{ all -> 0x0096 }
            e.c.f.c.a()     // Catch:{ all -> 0x0096 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0092
            java.lang.String r1 = "____"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x005f
            goto L_0x0092
        L_0x005f:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r1 = r4.f6987f     // Catch:{ all -> 0x0096 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0094
            com.baidu.sofire.MyReceiver r1 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0096 }
            r1.<init>()     // Catch:{ all -> 0x0096 }
            android.app.Application r2 = f6979h     // Catch:{ all -> 0x0096 }
            android.content.IntentFilter r3 = r5.f6991d     // Catch:{ all -> 0x0096 }
            boolean r2 = e.c.f.n.a.a(r2, r1, r3)     // Catch:{ all -> 0x0096 }
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x008c
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0082 }
            goto L_0x0085
        L_0x0082:
            e.c.f.c.d()     // Catch:{ all -> 0x0096 }
        L_0x0085:
            android.app.Application r2 = f6979h     // Catch:{ all -> 0x0096 }
            android.content.IntentFilter r5 = r5.f6991d     // Catch:{ all -> 0x0096 }
            e.c.f.n.a.a(r2, r1, r5)     // Catch:{ all -> 0x0096 }
        L_0x008c:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r5 = r4.f6987f     // Catch:{ all -> 0x0096 }
            r5.put(r0, r1)     // Catch:{ all -> 0x0096 }
            goto L_0x0094
        L_0x0092:
            monitor-exit(r4)
            return
        L_0x0094:
            monitor-exit(r4)
            return
        L_0x0096:
            e.c.f.c.d()     // Catch:{ all -> 0x009b }
            monitor-exit(r4)
            return
        L_0x009b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(e.c.f.f.h):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|90) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x00fa */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.IntentFilter r9) {
        /*
            java.lang.String r0 = ""
            if (r9 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r1.<init>()     // Catch:{ all -> 0x0129 }
            int r2 = r9.countActions()     // Catch:{ all -> 0x0129 }
            r3 = 0
            java.lang.String r4 = "_"
            if (r2 <= 0) goto L_0x0050
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r5.<init>()     // Catch:{ all -> 0x0129 }
            r6 = r3
        L_0x0019:
            if (r6 >= r2) goto L_0x002f
            java.lang.String r7 = r9.getAction(r6)     // Catch:{ all -> 0x0029 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0029 }
            if (r8 != 0) goto L_0x002c
            r5.add(r7)     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            e.c.f.c.d()     // Catch:{ all -> 0x0129 }
        L_0x002c:
            int r6 = r6 + 1
            goto L_0x0019
        L_0x002f:
            int r2 = r5.size()     // Catch:{ all -> 0x0129 }
            if (r2 <= 0) goto L_0x004c
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0129 }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0129 }
        L_0x003c:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x0053
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0129 }
            r1.append(r5)     // Catch:{ all -> 0x0129 }
            goto L_0x003c
        L_0x004c:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
            goto L_0x0053
        L_0x0050:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
        L_0x0053:
            int r2 = r9.countCategories()     // Catch:{ all -> 0x0129 }
            if (r2 <= 0) goto L_0x0096
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r5.<init>()     // Catch:{ all -> 0x0129 }
            r6 = r3
        L_0x005f:
            if (r6 >= r2) goto L_0x0075
            java.lang.String r7 = r9.getCategory(r6)     // Catch:{ all -> 0x006f }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006f }
            if (r8 != 0) goto L_0x0072
            r5.add(r7)     // Catch:{ all -> 0x006f }
            goto L_0x0072
        L_0x006f:
            e.c.f.c.d()     // Catch:{ all -> 0x0129 }
        L_0x0072:
            int r6 = r6 + 1
            goto L_0x005f
        L_0x0075:
            int r6 = r5.size()     // Catch:{ all -> 0x0129 }
            if (r6 <= 0) goto L_0x0092
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0129 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0129 }
        L_0x0082:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0129 }
            if (r6 == 0) goto L_0x0099
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0129 }
            r1.append(r6)     // Catch:{ all -> 0x0129 }
            goto L_0x0082
        L_0x0092:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
            goto L_0x0099
        L_0x0096:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
        L_0x0099:
            int r5 = r9.countDataTypes()     // Catch:{ all -> 0x0129 }
            if (r5 <= 0) goto L_0x00dc
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r5.<init>()     // Catch:{ all -> 0x0129 }
            r6 = r3
        L_0x00a5:
            if (r6 >= r2) goto L_0x00bb
            java.lang.String r7 = r9.getDataType(r6)     // Catch:{ all -> 0x00b5 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b5 }
            if (r8 != 0) goto L_0x00b8
            r5.add(r7)     // Catch:{ all -> 0x00b5 }
            goto L_0x00b8
        L_0x00b5:
            e.c.f.c.d()     // Catch:{ all -> 0x0129 }
        L_0x00b8:
            int r6 = r6 + 1
            goto L_0x00a5
        L_0x00bb:
            int r2 = r5.size()     // Catch:{ all -> 0x0129 }
            if (r2 <= 0) goto L_0x00d8
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0129 }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0129 }
        L_0x00c8:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x00df
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0129 }
            r1.append(r5)     // Catch:{ all -> 0x0129 }
            goto L_0x00c8
        L_0x00d8:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
            goto L_0x00df
        L_0x00dc:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
        L_0x00df:
            int r2 = r9.countDataSchemes()     // Catch:{ all -> 0x0129 }
            if (r2 <= 0) goto L_0x0121
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r5.<init>()     // Catch:{ all -> 0x0129 }
        L_0x00ea:
            if (r3 >= r2) goto L_0x0100
            java.lang.String r6 = r9.getDataScheme(r3)     // Catch:{ all -> 0x00fa }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00fa }
            if (r7 != 0) goto L_0x00fd
            r5.add(r6)     // Catch:{ all -> 0x00fa }
            goto L_0x00fd
        L_0x00fa:
            e.c.f.c.d()     // Catch:{ all -> 0x0129 }
        L_0x00fd:
            int r3 = r3 + 1
            goto L_0x00ea
        L_0x0100:
            int r9 = r5.size()     // Catch:{ all -> 0x0129 }
            if (r9 <= 0) goto L_0x011d
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0129 }
            java.util.Iterator r9 = r5.iterator()     // Catch:{ all -> 0x0129 }
        L_0x010d:
            boolean r2 = r9.hasNext()     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x0124
            java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0129 }
            r1.append(r2)     // Catch:{ all -> 0x0129 }
            goto L_0x010d
        L_0x011d:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
            goto L_0x0124
        L_0x0121:
            r1.append(r4)     // Catch:{ all -> 0x0129 }
        L_0x0124:
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0129 }
            return r9
        L_0x0129:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(android.content.IntentFilter):java.lang.String");
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = (ApkInfo) this.f6985d.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f6986e.remove(str);
        this.f6984c.remove(apkInfo.pkgPath);
        this.f6985d.remove(str);
        a.d(apkInfo.dataDir);
        Application application = f6979h;
        if (application != null) {
            a.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        }
        new StringBuilder().append(this.f6984c.size());
        c.a();
        new StringBuilder().append(this.f6985d.size());
        return true;
    }

    public final List<ApkInfo> a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f6985d.keySet()) {
                arrayList.add(this.f6985d.get(str));
            }
            return arrayList;
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    public final boolean a(ApkInfo apkInfo, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f6983b = z;
        this.f6982a = apkInfo.versionName;
        boolean a2 = a(apkInfo);
        new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis);
        c.a();
        return a2;
    }

    /* JADX INFO: used method not loaded: e.c.f.n.a.a(android.content.Context, java.lang.String, java.util.Map):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        a(r8.pkgPath);
        e.c.f.c.d();
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0130, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0263, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r1.getMessage();
        e.c.f.c.c();
        a(r8.pkgPath);
        r2 = new java.util.HashMap();
        r1 = e.c.f.c.a(r1);
        r3 = new java.lang.StringBuilder();
        r3.append(r1);
        r3.append("\r\n isUpgrade=");
        r3.append(r7.f6983b);
        r1 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a4, code lost:
        if (r1.contains("space left") != false) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a6, code lost:
        r1 = e.c.f.n.d.a(f6979h, r1, r8.packageName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02ae, code lost:
        r2.put("0", java.lang.Integer.valueOf(2));
        r2.put("1", java.lang.Integer.valueOf(r8.key));
        r2.put("2", r8.versionName);
        r2.put("3", android.util.Base64.encodeToString(r1.getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
        e.c.f.n.a.a(f6979h.getApplicationContext(), "1003117", (java.util.Map) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0304, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0126 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x02fb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(com.baidu.sofire.core.ApkInfo r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 == 0) goto L_0x0303
            java.lang.String r1 = r8.pkgPath     // Catch:{ all -> 0x0300 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0300 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0303
        L_0x000e:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r1 = r7.f6984c     // Catch:{ all -> 0x0300 }
            java.lang.String r2 = r8.pkgPath     // Catch:{ all -> 0x0300 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0300 }
            com.baidu.sofire.core.ApkInfo r1 = (com.baidu.sofire.core.ApkInfo) r1     // Catch:{ all -> 0x0300 }
            r2 = 1
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = r8.versionName     // Catch:{ all -> 0x0300 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0300 }
            if (r1 == 0) goto L_0x002a
            e.c.f.c.a()     // Catch:{ all -> 0x0300 }
            monitor-exit(r7)
            return r2
        L_0x002a:
            java.lang.String r1 = r8.pkgPath     // Catch:{ all -> 0x0300 }
            r7.a(r1)     // Catch:{ all -> 0x0300 }
        L_0x002f:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = r8.pkgPath     // Catch:{ all -> 0x0300 }
            r1.<init>(r3)     // Catch:{ all -> 0x0300 }
            boolean r1 = e.c.f.n.a.a(r1)     // Catch:{ all -> 0x0300 }
            if (r1 != 0) goto L_0x006c
            e.c.f.c.a()     // Catch:{ all -> 0x0300 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0300 }
            r1.<init>()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "0"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0300 }
            r1.put(r3, r2)     // Catch:{ all -> 0x0300 }
            java.lang.String r2 = "1"
            int r3 = r8.key     // Catch:{ all -> 0x0300 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0300 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0300 }
            java.lang.String r2 = "2"
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x0300 }
            r1.put(r2, r8)     // Catch:{ all -> 0x0300 }
            android.app.Application r8 = f6979h     // Catch:{ all -> 0x0300 }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ all -> 0x0300 }
            java.lang.String r2 = "1003117"
            e.c.f.n.a.a(r8, r2, r1)     // Catch:{ all -> 0x0300 }
            monitor-exit(r7)
            return r0
        L_0x006c:
            android.app.Application r1 = f6979h     // Catch:{ all -> 0x0130 }
            r8.hostContext = r1     // Catch:{ all -> 0x0130 }
            int r1 = r8.apkParseSuc     // Catch:{ all -> 0x0130 }
            if (r1 != r2) goto L_0x0133
            e.c.f.c.a()     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r8.packageName     // Catch:{ all -> 0x0126 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0126 }
            if (r1 != 0) goto L_0x011e
            java.lang.String r1 = r8.pkgPath     // Catch:{ all -> 0x0126 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0126 }
            if (r1 != 0) goto L_0x011e
            int r1 = r8.key     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r8.versionName     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r8.apkMD5     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r8.pkgPath     // Catch:{ all -> 0x0126 }
            boolean r1 = a(r1, r3, r4, r5)     // Catch:{ all -> 0x0126 }
            if (r1 != 0) goto L_0x0097
            monitor-exit(r7)
            return r0
        L_0x0097:
            android.app.Application r1 = f6979h     // Catch:{ all -> 0x0126 }
            java.io.File r1 = r1.getFilesDir()     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r1.getCanonicalPath()     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r3.<init>()     // Catch:{ all -> 0x0126 }
            r3.append(r1)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = "/."
            r3.append(r1)     // Catch:{ all -> 0x0126 }
            int r1 = r8.key     // Catch:{ all -> 0x0126 }
            r3.append(r1)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0126 }
            r8.dataDir = r1     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r1.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r8.dataDir     // Catch:{ all -> 0x0126 }
            r1.append(r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "/dex"
            r1.append(r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r3.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r8.dataDir     // Catch:{ all -> 0x0126 }
            r3.append(r4)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = "/lib/"
            r3.append(r4)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r7.f6982a     // Catch:{ all -> 0x0126 }
            r3.append(r4)     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0126 }
            java.util.Random r4 = f6980i     // Catch:{ all -> 0x0126 }
            int r4 = r4.nextInt()     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r5.<init>()     // Catch:{ all -> 0x0126 }
            r5.append(r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "/"
            r5.append(r3)     // Catch:{ all -> 0x0126 }
            r5.append(r4)     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0126 }
            d(r1)     // Catch:{ all -> 0x0126 }
            e.c.f.n.a.a(r1, r0)     // Catch:{ all -> 0x0126 }
            d(r3)     // Catch:{ all -> 0x0126 }
            r7.a(r8, r3, r1)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r1 = r7.f6984c     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r8.pkgPath     // Catch:{ all -> 0x0126 }
            r1.put(r3, r8)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r1 = r7.f6985d     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = r8.packageName     // Catch:{ all -> 0x0126 }
            r1.put(r3, r8)     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r8.className     // Catch:{ all -> 0x0126 }
            a(r8, r1)     // Catch:{ all -> 0x0126 }
            goto L_0x0133
        L_0x011e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "packageName or pkgPath miss"
            r1.<init>(r3)     // Catch:{ all -> 0x0126 }
            throw r1     // Catch:{ all -> 0x0126 }
        L_0x0126:
            java.lang.String r1 = r8.pkgPath     // Catch:{ all -> 0x0130 }
            r7.a(r1)     // Catch:{ all -> 0x0130 }
            e.c.f.c.d()     // Catch:{ all -> 0x0130 }
            r1 = r2
            goto L_0x0134
        L_0x0130:
            r1 = move-exception
            goto L_0x0274
        L_0x0133:
            r1 = r0
        L_0x0134:
            int r3 = r8.apkParseSuc     // Catch:{ all -> 0x0130 }
            if (r3 != r2) goto L_0x013a
            if (r1 == 0) goto L_0x0262
        L_0x013a:
            e.c.f.c.a()     // Catch:{ all -> 0x0130 }
            android.content.pm.PackageInfo r1 = r8.cloudPkgInfo     // Catch:{ all -> 0x0130 }
            if (r1 == 0) goto L_0x0152
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x0152
            java.lang.String r3 = r1.versionName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x0152
            goto L_0x018a
        L_0x0152:
            android.app.Application r1 = f6979h     // Catch:{ all -> 0x0130 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r8.pkgPath     // Catch:{ all -> 0x0130 }
            android.content.pm.PackageInfo r1 = r1.getPackageArchiveInfo(r3, r2)     // Catch:{ all -> 0x0130 }
            if (r1 == 0) goto L_0x0170
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x0170
            java.lang.String r3 = r1.versionName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 == 0) goto L_0x018a
        L_0x0170:
            java.lang.String r1 = r8.packageName     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r8.apkMD5     // Catch:{ all -> 0x0130 }
            android.content.pm.PackageInfo r1 = a(r1, r3)     // Catch:{ all -> 0x0130 }
            if (r1 == 0) goto L_0x026c
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x026c
            java.lang.String r3 = r1.versionName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x026c
        L_0x018a:
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x0264
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = "com.baidu.sofire"
            boolean r3 = r3.startsWith(r4)     // Catch:{ all -> 0x0130 }
            if (r3 == 0) goto L_0x0264
            int r3 = r8.key     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r1.versionName     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r8.apkMD5     // Catch:{ all -> 0x0130 }
            java.lang.String r6 = r8.pkgPath     // Catch:{ all -> 0x0130 }
            boolean r3 = a(r3, r4, r5, r6)     // Catch:{ all -> 0x0130 }
            if (r3 != 0) goto L_0x01ac
            monitor-exit(r7)
            return r0
        L_0x01ac:
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0130 }
            r8.packageName = r3     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = "p="
            r3.<init>(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r1.packageName     // Catch:{ all -> 0x0130 }
            r3.append(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = ", v="
            r3.append(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r1.versionName     // Catch:{ all -> 0x0130 }
            r3.append(r4)     // Catch:{ all -> 0x0130 }
            android.content.pm.ApplicationInfo r3 = r1.applicationInfo     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r3.className     // Catch:{ all -> 0x0130 }
            r8.className = r3     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r1.versionName     // Catch:{ all -> 0x0130 }
            r8.versionName = r3     // Catch:{ all -> 0x0130 }
            android.content.pm.ActivityInfo[] r3 = r1.activities     // Catch:{ all -> 0x0130 }
            r8.activities = r3     // Catch:{ all -> 0x0130 }
            android.content.pm.ApplicationInfo r3 = r1.applicationInfo     // Catch:{ all -> 0x0130 }
            int r3 = r3.theme     // Catch:{ all -> 0x0130 }
            r8.applicationTheme = r3     // Catch:{ all -> 0x0130 }
            android.app.Application r3 = f6979h     // Catch:{ all -> 0x0130 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r3.getCanonicalPath()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r4.<init>()     // Catch:{ all -> 0x0130 }
            r4.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "/."
            r4.append(r3)     // Catch:{ all -> 0x0130 }
            int r3 = r8.key     // Catch:{ all -> 0x0130 }
            r4.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0130 }
            r8.dataDir = r3     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r3.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r8.dataDir     // Catch:{ all -> 0x0130 }
            r3.append(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = "/dex"
            r3.append(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r4.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r8.dataDir     // Catch:{ all -> 0x0130 }
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = "/lib/"
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r5 = r7.f6982a     // Catch:{ all -> 0x0130 }
            r4.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0130 }
            java.util.Random r5 = f6980i     // Catch:{ all -> 0x0130 }
            int r5 = r5.nextInt()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r6.<init>()     // Catch:{ all -> 0x0130 }
            r6.append(r4)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = "/"
            r6.append(r4)     // Catch:{ all -> 0x0130 }
            r6.append(r5)     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0130 }
            d(r3)     // Catch:{ all -> 0x0130 }
            e.c.f.n.a.a(r3, r0)     // Catch:{ all -> 0x0130 }
            d(r4)     // Catch:{ all -> 0x0130 }
            r7.a(r8, r4, r3)     // Catch:{ all -> 0x0130 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r3 = r7.f6984c     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r8.pkgPath     // Catch:{ all -> 0x0130 }
            r3.put(r4, r8)     // Catch:{ all -> 0x0130 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r3 = r7.f6985d     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r8.packageName     // Catch:{ all -> 0x0130 }
            r3.put(r4, r8)     // Catch:{ all -> 0x0130 }
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo     // Catch:{ all -> 0x0130 }
            java.lang.String r1 = r1.className     // Catch:{ all -> 0x0130 }
            a(r8, r1)     // Catch:{ all -> 0x0130 }
        L_0x0262:
            monitor-exit(r7)
            return r2
        L_0x0264:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "package name check failed"
            r1.<init>(r2)     // Catch:{ all -> 0x0130 }
            throw r1     // Catch:{ all -> 0x0130 }
        L_0x026c:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "requestCloudPackageInfo failed"
            r1.<init>(r2)     // Catch:{ all -> 0x0130 }
            throw r1     // Catch:{ all -> 0x0130 }
        L_0x0274:
            r1.getMessage()     // Catch:{ all -> 0x02fb }
            e.c.f.c.c()     // Catch:{ all -> 0x02fb }
            java.lang.String r2 = r8.pkgPath     // Catch:{ all -> 0x02fb }
            r7.a(r2)     // Catch:{ all -> 0x02fb }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x02fb }
            r2.<init>()     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = e.c.f.c.a(r1)     // Catch:{ all -> 0x02fb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fb }
            r3.<init>()     // Catch:{ all -> 0x02fb }
            r3.append(r1)     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = "\r\n isUpgrade="
            r3.append(r1)     // Catch:{ all -> 0x02fb }
            boolean r1 = r7.f6983b     // Catch:{ all -> 0x02fb }
            r3.append(r1)     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "space left"
            boolean r3 = r1.contains(r3)     // Catch:{ all -> 0x02fb }
            if (r3 == 0) goto L_0x02ae
            android.app.Application r3 = f6979h     // Catch:{ all -> 0x02fb }
            java.lang.String r4 = r8.packageName     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = e.c.f.n.d.a(r3, r1, r4)     // Catch:{ all -> 0x02fb }
        L_0x02ae:
            java.lang.String r3 = "0"
            r4 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x02fb }
            r2.put(r3, r4)     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "1"
            int r4 = r8.key     // Catch:{ all -> 0x02fb }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x02fb }
            r2.put(r3, r4)     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "2"
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x02fb }
            r2.put(r3, r8)     // Catch:{ all -> 0x02fb }
            java.lang.String r8 = "3"
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r0)     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "\n"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "\t"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x02fb }
            java.lang.String r3 = "\r"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x02fb }
            r2.put(r8, r1)     // Catch:{ all -> 0x02fb }
            android.app.Application r8 = f6979h     // Catch:{ all -> 0x02fb }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ all -> 0x02fb }
            java.lang.String r1 = "1003117"
            e.c.f.n.a.a(r8, r1, r2)     // Catch:{ all -> 0x02fb }
            goto L_0x02fe
        L_0x02fb:
            e.c.f.c.d()     // Catch:{ all -> 0x0300 }
        L_0x02fe:
            monitor-exit(r7)
            return r0
        L_0x0300:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0303:
            monitor-exit(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(com.baidu.sofire.core.ApkInfo):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:30|31|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x010f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.pm.PackageInfo a(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "t"
            java.lang.String r1 = "n"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r3.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r4 = e.c.f.n.a.b()     // Catch:{ all -> 0x012a }
            r3.append(r4)     // Catch:{ all -> 0x012a }
            java.lang.String r4 = "p/1/pdl"
            r3.append(r4)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x012a }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x012a }
            r4.<init>()     // Catch:{ all -> 0x012a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x012a }
            r5.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "pk"
            r5.put(r6, r10)     // Catch:{ all -> 0x012a }
            java.lang.String r10 = "m"
            r5.put(r10, r11)     // Catch:{ all -> 0x012a }
            r4.put(r5)     // Catch:{ all -> 0x012a }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x012a }
            e.c.f.c.a()     // Catch:{ all -> 0x012a }
            android.app.Application r11 = f6979h     // Catch:{ all -> 0x012a }
            r4 = 0
            java.lang.String r10 = e.c.d.n.e.a(r11, r3, r10, r4)     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r11.<init>()     // Catch:{ all -> 0x012a }
            r11.append(r10)     // Catch:{ all -> 0x012a }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ all -> 0x012a }
            r11.<init>(r10)     // Catch:{ all -> 0x012a }
            int r10 = r11.length()     // Catch:{ all -> 0x012a }
            if (r10 > 0) goto L_0x0053
            return r2
        L_0x0053:
            org.json.JSONObject r10 = r11.optJSONObject(r4)     // Catch:{ all -> 0x012a }
            android.content.pm.PackageInfo r11 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x012a }
            r11.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r3 = "p"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ all -> 0x012a }
            r11.packageName = r3     // Catch:{ all -> 0x012a }
            java.lang.String r3 = "v"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ all -> 0x012a }
            r11.versionName = r3     // Catch:{ all -> 0x012a }
            android.content.pm.ApplicationInfo r3 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x012a }
            r3.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r5 = r10.optString(r1)     // Catch:{ all -> 0x012a }
            r3.className = r5     // Catch:{ all -> 0x012a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "."
            if (r5 != 0) goto L_0x009c
            java.lang.String r5 = r3.className     // Catch:{ all -> 0x012a }
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x012a }
            if (r5 == 0) goto L_0x009c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r5.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r7 = r11.packageName     // Catch:{ all -> 0x012a }
            r5.append(r7)     // Catch:{ all -> 0x012a }
            java.lang.String r7 = r3.className     // Catch:{ all -> 0x012a }
            r5.append(r7)     // Catch:{ all -> 0x012a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x012a }
            r3.className = r5     // Catch:{ all -> 0x012a }
        L_0x009c:
            int r5 = r10.optInt(r0)     // Catch:{ all -> 0x012a }
            r3.theme = r5     // Catch:{ all -> 0x012a }
            r11.applicationInfo = r3     // Catch:{ all -> 0x012a }
            java.lang.String r3 = "a"
            org.json.JSONArray r10 = r10.optJSONArray(r3)     // Catch:{ all -> 0x012a }
            if (r10 == 0) goto L_0x0129
            int r3 = r10.length()     // Catch:{ all -> 0x012a }
            if (r3 <= 0) goto L_0x0129
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x012a }
            r3.<init>()     // Catch:{ all -> 0x012a }
        L_0x00b7:
            int r5 = r10.length()     // Catch:{ all -> 0x012a }
            if (r4 >= r5) goto L_0x0115
            org.json.JSONObject r5 = r10.getJSONObject(r4)     // Catch:{ all -> 0x010f }
            if (r5 == 0) goto L_0x0112
            android.content.pm.ActivityInfo r7 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x010f }
            r7.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r5.optString(r1)     // Catch:{ all -> 0x010f }
            r7.name = r8     // Catch:{ all -> 0x010f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x010f }
            if (r8 != 0) goto L_0x00f1
            java.lang.String r8 = r7.name     // Catch:{ all -> 0x010f }
            boolean r8 = r8.startsWith(r6)     // Catch:{ all -> 0x010f }
            if (r8 == 0) goto L_0x00f1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r8.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r9 = r11.packageName     // Catch:{ all -> 0x010f }
            r8.append(r9)     // Catch:{ all -> 0x010f }
            java.lang.String r9 = r7.name     // Catch:{ all -> 0x010f }
            r8.append(r9)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x010f }
            r7.name = r8     // Catch:{ all -> 0x010f }
        L_0x00f1:
            java.lang.String r8 = r11.packageName     // Catch:{ all -> 0x010f }
            r7.packageName = r8     // Catch:{ all -> 0x010f }
            int r8 = r5.optInt(r0)     // Catch:{ all -> 0x010f }
            r7.theme = r8     // Catch:{ all -> 0x010f }
            java.lang.String r8 = "l"
            int r5 = r5.optInt(r8)     // Catch:{ all -> 0x010f }
            r7.labelRes = r5     // Catch:{ all -> 0x010f }
            java.lang.String r5 = r7.name     // Catch:{ all -> 0x010f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x010f }
            if (r5 != 0) goto L_0x0112
            r3.add(r7)     // Catch:{ all -> 0x010f }
            goto L_0x0112
        L_0x010f:
            e.c.f.c.d()     // Catch:{ all -> 0x012a }
        L_0x0112:
            int r4 = r4 + 1
            goto L_0x00b7
        L_0x0115:
            int r10 = r3.size()     // Catch:{ all -> 0x012a }
            if (r10 <= 0) goto L_0x0129
            int r10 = r3.size()     // Catch:{ all -> 0x012a }
            android.content.pm.ActivityInfo[] r10 = new android.content.pm.ActivityInfo[r10]     // Catch:{ all -> 0x012a }
            java.lang.Object[] r10 = r3.toArray(r10)     // Catch:{ all -> 0x012a }
            android.content.pm.ActivityInfo[] r10 = (android.content.pm.ActivityInfo[]) r10     // Catch:{ all -> 0x012a }
            r11.activities = r10     // Catch:{ all -> 0x012a }
        L_0x0129:
            return r11
        L_0x012a:
            e.c.f.c.d()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(java.lang.String, java.lang.String):android.content.pm.PackageInfo");
    }

    public static boolean a(int i2, String str, String str2, String str3) {
        Pair pair;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(str);
        String sb2 = sb.toString();
        Map<String, String> map = U.sRealtimeMd5Map;
        if (map != null) {
            String str4 = (String) map.get(sb2);
            if (!TextUtils.isEmpty(str4)) {
                c.a();
                str2 = str4;
            }
        }
        String str5 = "";
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            pair = new Pair(Boolean.valueOf(false), str5);
        } else {
            File file = new File(str3);
            if (!a.a(file)) {
                pair = new Pair(Boolean.valueOf(false), str5);
            } else {
                String a2 = h.a(file);
                if (TextUtils.isEmpty(a2)) {
                    pair = new Pair(Boolean.valueOf(false), str5);
                } else if (!a2.equalsIgnoreCase(str2)) {
                    pair = new Pair(Boolean.valueOf(false), a2);
                } else {
                    pair = new Pair(Boolean.valueOf(true), str5);
                }
            }
        }
        new StringBuilder("_").append(pair.first);
        c.a();
        if (((Boolean) pair.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.valueOf(3));
        hashMap.put("1", Integer.valueOf(i2));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) pair.second).getBytes(), 0).replace("\n", str5).replace("\t", str5).replace("\r", str5));
        a.a(f6979h.getApplicationContext(), "1003117", (Map<String, Object>) hashMap);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.baidu.sofire.core.ApkInfo r8, java.lang.String r9) {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r1.<init>()     // Catch:{ all -> 0x007c }
            r1.append(r9)     // Catch:{ all -> 0x007c }
            e.c.f.c.a()     // Catch:{ all -> 0x007c }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x007c }
            r2 = 1
            if (r1 == 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.ClassLoader r8 = r8.classLoader     // Catch:{ all -> 0x007c }
            java.lang.Class r8 = r8.loadClass(r9)     // Catch:{ all -> 0x007c }
            java.lang.Object r8 = r8.newInstance()     // Catch:{ all -> 0x007c }
            android.app.Application r8 = (android.app.Application) r8     // Catch:{ all -> 0x007c }
            java.lang.Class<android.app.Application> r9 = android.app.Application.class
            android.app.Application r1 = f6979h     // Catch:{ all -> 0x007c }
            if (r1 == 0) goto L_0x004f
            if (r8 != 0) goto L_0x0029
            goto L_0x004f
        L_0x0029:
            if (r9 == 0) goto L_0x004f
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r9 == r3) goto L_0x004f
            java.lang.reflect.Field[] r3 = r9.getDeclaredFields()     // Catch:{ all -> 0x007c }
            int r4 = r3.length     // Catch:{ all -> 0x007c }
            r5 = r0
        L_0x0035:
            if (r5 >= r4) goto L_0x004a
            r6 = r3[r5]     // Catch:{ all -> 0x007c }
            r6.setAccessible(r2)     // Catch:{ all -> 0x0044 }
            java.lang.Object r7 = r6.get(r1)     // Catch:{ all -> 0x0044 }
            r6.set(r8, r7)     // Catch:{ all -> 0x0044 }
            goto L_0x0047
        L_0x0044:
            e.c.f.c.d()     // Catch:{ all -> 0x007c }
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x0035
        L_0x004a:
            java.lang.Class r9 = r9.getSuperclass()     // Catch:{ all -> 0x007c }
            goto L_0x0029
        L_0x004f:
            android.app.Application r9 = f6979h     // Catch:{ all -> 0x007c }
            java.lang.Class r1 = r9.getClass()     // Catch:{ all -> 0x007c }
            java.lang.Class<android.app.Application> r3 = android.app.Application.class
        L_0x0057:
            if (r3 == 0) goto L_0x0078
            java.lang.String r4 = "mBase"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch:{ all -> 0x0070 }
            r4.setAccessible(r2)     // Catch:{ all -> 0x0070 }
            java.lang.Class r5 = r4.getType()     // Catch:{ all -> 0x0070 }
            boolean r5 = r5.isAssignableFrom(r1)     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x0073
            r4.set(r8, r9)     // Catch:{ all -> 0x0070 }
            goto L_0x0073
        L_0x0070:
            e.c.f.c.d()     // Catch:{ all -> 0x007c }
        L_0x0073:
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ all -> 0x007c }
            goto L_0x0057
        L_0x0078:
            r8.onCreate()     // Catch:{ all -> 0x007c }
            return r2
        L_0x007c:
            r8 = move-exception
            r8.getMessage()
            e.c.f.c.c()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(com.baidu.sofire.core.ApkInfo, java.lang.String):boolean");
    }

    /* JADX INFO: used method not loaded: e.c.f.n.a.d(java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|(1:23)|(2:28|29)(1:27)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        e.c.f.n.a.d(new java.io.File(r12, r2).getAbsolutePath());
        r12 = new java.io.File(r12, "dexDex").getAbsolutePath();
        e.c.f.n.a.d(r12);
        d(r12);
        r6 = a(r10, r11, false);
        new java.lang.StringBuilder().append(r6);
        r11 = new e.c.f.f.f(r6, r12, r3, r4);
        r10.classLoader = r11;
        r11 = r11.loadClass(r1);
        new java.lang.StringBuilder().append(r11);
        new java.lang.StringBuilder().append(r6);
        r12 = new java.io.File(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cc, code lost:
        if (r12.exists() != false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ce, code lost:
        r12.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        if (r11 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00dd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e3, code lost:
        throw new java.lang.Exception(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        e.c.f.n.a.d(r10.dataDir);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00eb, code lost:
        if (f6979h != null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
        e.c.f.n.a.d(f6979h.getFileStreamPath(r10.packageName).getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        r12 = new java.lang.StringBuilder("can't load EngineImpl by both dexFile:");
        r12.append(r6);
        r12.append(" and ZipFile:");
        r12.append(r10.pkgPath);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0119, code lost:
        throw new java.lang.RuntimeException(r12.toString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00e4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.baidu.sofire.core.ApkInfo r10, java.lang.String r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null"
            java.lang.String r1 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.String r2 = "apkDex"
            r3 = 1
            java.lang.String r3 = a(r10, r11, r3)
            java.lang.String r4 = "java.library.path"
            java.lang.String r4 = java.lang.System.getProperty(r4)
            int r5 = android.os.Build.VERSION.SDK_INT
            java.lang.String r6 = ""
            r7 = 25
            if (r5 >= r7) goto L_0x001f
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0020
        L_0x001f:
            r4 = r6
        L_0x0020:
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x0033
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0034
            java.lang.String r5 = ":"
            java.lang.String r3 = e.a.a.a.a.a(r3, r5, r4)
            goto L_0x0034
        L_0x0033:
            r3 = r4
        L_0x0034:
            r10.libPath = r3
            java.lang.Class<e.c.f.f.g> r4 = e.c.f.f.g.class
            java.lang.ClassLoader r4 = r4.getClassLoader()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            e.c.f.c.a()
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x007e }
            r5.<init>(r12, r2)     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x007e }
            e.c.f.n.a.d(r5)     // Catch:{ all -> 0x007e }
            d(r5)     // Catch:{ all -> 0x007e }
            e.c.f.f.f r7 = new e.c.f.f.f     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r10.pkgPath     // Catch:{ all -> 0x007e }
            r7.<init>(r8, r5, r3, r4)     // Catch:{ all -> 0x007e }
            r10.classLoader = r7     // Catch:{ all -> 0x007e }
            java.lang.Class r5 = r7.loadClass(r1)     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r7.<init>()     // Catch:{ all -> 0x007e }
            r7.append(r5)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0078
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x007e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0078
            return
        L_0x0078:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x007e }
            r5.<init>(r0)     // Catch:{ all -> 0x007e }
            throw r5     // Catch:{ all -> 0x007e }
        L_0x007e:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00e4 }
            r5.<init>(r12, r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = r5.getAbsolutePath()     // Catch:{ all -> 0x00e4 }
            e.c.f.n.a.d(r2)     // Catch:{ all -> 0x00e4 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = "dexDex"
            r2.<init>(r12, r5)     // Catch:{ all -> 0x00e4 }
            java.lang.String r12 = r2.getAbsolutePath()     // Catch:{ all -> 0x00e4 }
            e.c.f.n.a.d(r12)     // Catch:{ all -> 0x00e4 }
            d(r12)     // Catch:{ all -> 0x00e4 }
            r2 = 0
            java.lang.String r6 = a(r10, r11, r2)     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r11.<init>()     // Catch:{ all -> 0x00e4 }
            r11.append(r6)     // Catch:{ all -> 0x00e4 }
            e.c.f.f.f r11 = new e.c.f.f.f     // Catch:{ all -> 0x00e4 }
            r11.<init>(r6, r12, r3, r4)     // Catch:{ all -> 0x00e4 }
            r10.classLoader = r11     // Catch:{ all -> 0x00e4 }
            java.lang.Class r11 = r11.loadClass(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r12.<init>()     // Catch:{ all -> 0x00e4 }
            r12.append(r11)     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r12.<init>()     // Catch:{ all -> 0x00e4 }
            r12.append(r6)     // Catch:{ all -> 0x00e4 }
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x00e4 }
            r12.<init>(r6)     // Catch:{ all -> 0x00e4 }
            boolean r1 = r12.exists()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00d1
            r12.delete()     // Catch:{ all -> 0x00e4 }
        L_0x00d1:
            if (r11 == 0) goto L_0x00de
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x00e4 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00e4 }
            if (r11 != 0) goto L_0x00de
            return
        L_0x00de:
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ all -> 0x00e4 }
            r11.<init>(r0)     // Catch:{ all -> 0x00e4 }
            throw r11     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            java.lang.String r11 = r10.dataDir     // Catch:{ all -> 0x00fc }
            e.c.f.n.a.d(r11)     // Catch:{ all -> 0x00fc }
            android.app.Application r11 = f6979h     // Catch:{ all -> 0x00fc }
            if (r11 == 0) goto L_0x00fc
            android.app.Application r11 = f6979h     // Catch:{ all -> 0x00fc }
            java.lang.String r12 = r10.packageName     // Catch:{ all -> 0x00fc }
            java.io.File r11 = r11.getFileStreamPath(r12)     // Catch:{ all -> 0x00fc }
            java.lang.String r11 = r11.getAbsolutePath()     // Catch:{ all -> 0x00fc }
            e.c.f.n.a.d(r11)     // Catch:{ all -> 0x00fc }
        L_0x00fc:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "can't load EngineImpl by both dexFile:"
            r12.<init>(r0)
            r12.append(r6)
            java.lang.String r0 = " and ZipFile:"
            r12.append(r0)
            java.lang.String r10 = r10.pkgPath
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.lang.String):void");
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = (ApkInfo) this.f6984c.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f6986e.remove(apkInfo.packageName);
        this.f6984c.remove(str);
        this.f6985d.remove(apkInfo.packageName);
        a.d(apkInfo.dataDir);
        Application application = f6979h;
        if (application != null) {
            a.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019d, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019f, code lost:
        r5 = new java.io.File(r2, r0);
        d(r5.getAbsolutePath());
        r0 = (java.util.List) r13.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b1, code lost:
        if (r0 == null) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01b7, code lost:
        if (r0.size() <= 0) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01b9, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01c1, code lost:
        if (r0.hasNext() == false) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01c3, code lost:
        r6 = (java.util.zip.ZipEntry) r0.next();
        r7 = r6.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d1, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r7 = r7.substring(r7.lastIndexOf(r8) + 1);
        r10 = new java.lang.StringBuilder();
        r10.append(r9);
        r10.append(r4);
        a(r12, r6, new java.io.File(r5, r7.replace(r4, r10.toString())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01f3, code lost:
        r15 = r5.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01f9, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01fb, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0201, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x020f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0210, code lost:
        r10 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x028d, code lost:
        if (r10 != null) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0293, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0187, code lost:
        if (r3 == false) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x018d, code lost:
        if (r13.size() <= 0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018f, code lost:
        r0 = a(r1.hostContext, (java.util.Collection<java.lang.String>) r13.keySet());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x020f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:31:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:19:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x028f A[SYNTHETIC, Splitter:B:144:0x028f] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029c A[SYNTHETIC, Splitter:B:152:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a5 A[Catch:{ all -> 0x02a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02b5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.baidu.sofire.core.ApkInfo r17, java.lang.String r18, boolean r19) throws java.lang.Throwable {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.String r4 = ".so"
            java.lang.String r5 = ".dex"
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            if (r1 != 0) goto L_0x0011
            return r7
        L_0x0011:
            if (r3 == 0) goto L_0x0025
            java.lang.String r0 = r1.versionName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = r1.versionName
            java.lang.String r9 = "."
            java.lang.String r0 = r0.replace(r9, r7)
            r9 = r0
            goto L_0x0026
        L_0x0025:
            r9 = r7
        L_0x0026:
            r11 = 1
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ FileNotFoundException -> 0x003c }
            java.lang.String r12 = r1.pkgPath     // Catch:{ FileNotFoundException -> 0x003c }
            r0.<init>(r12)     // Catch:{ FileNotFoundException -> 0x003c }
        L_0x002e:
            r12 = r0
            goto L_0x009c
        L_0x0030:
            r0 = move-exception
            r10 = 0
            goto L_0x028d
        L_0x0034:
            r16 = r7
            goto L_0x0297
        L_0x0038:
            r16 = r7
            goto L_0x02a0
        L_0x003c:
            r0 = move-exception
            java.lang.String r12 = r0.getMessage()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            android.content.Context r13 = r1.hostContext     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.io.File r13 = r13.getFilesDir()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.String r14 = ".b"
            r0.<init>(r13, r14)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            boolean r13 = r0.exists()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            if (r13 == 0) goto L_0x0274
            java.io.File r13 = new java.io.File     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r14.<init>()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            int r15 = r1.key     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r14.append(r15)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r14.append(r6)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.String r15 = r1.versionName     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r14.append(r15)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.String r14 = r14.toString()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r13.<init>(r0, r14)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            boolean r0 = r13.exists()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            if (r0 == 0) goto L_0x025b
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.String r14 = r1.pkgPath     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            r0.<init>(r14)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            e.c.f.n.a.a(r13, r0)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            java.lang.String r14 = r1.pkgPath     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            e.c.f.n.a.a(r14, r11)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            e.c.f.e.a(r0)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            android.content.Context r14 = r1.hostContext     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            int r15 = r1.key     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            e.c.f.e.a(r14, r15, r0, r13)     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            boolean r0 = r0.exists()     // Catch:{ ZipException -> 0x0038, EOFException -> 0x0034, all -> 0x0030 }
            if (r0 == 0) goto L_0x0242
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0221 }
            java.lang.String r13 = r1.pkgPath     // Catch:{ all -> 0x0221 }
            r0.<init>(r13)     // Catch:{ all -> 0x0221 }
            goto L_0x002e
        L_0x009c:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ ZipException -> 0x021a, EOFException -> 0x0213, all -> 0x020f }
            r13.<init>()     // Catch:{ ZipException -> 0x021a, EOFException -> 0x0213, all -> 0x020f }
            java.util.Enumeration r14 = r12.entries()     // Catch:{ ZipException -> 0x021a, EOFException -> 0x0213, all -> 0x020f }
            r15 = r7
        L_0x00a6:
            boolean r0 = r14.hasMoreElements()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.String r8 = "/"
            if (r0 == 0) goto L_0x0187
            java.lang.Object r0 = r14.nextElement()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.String r10 = r0.getName()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.String r11 = ".."
            boolean r11 = r10.contains(r11)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r11 == 0) goto L_0x00c8
            r12.close()     // Catch:{ all -> 0x00c4 }
            goto L_0x00c7
        L_0x00c4:
            e.c.f.c.d()
        L_0x00c7:
            return r7
        L_0x00c8:
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r11 != 0) goto L_0x010b
            java.lang.String r11 = "lib/"
            boolean r11 = r10.startsWith(r11)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r11 == 0) goto L_0x010b
            boolean r11 = r0.isDirectory()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r11 != 0) goto L_0x010b
            if (r3 == 0) goto L_0x010b
            java.lang.String[] r8 = r10.split(r8)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            int r11 = r8.length     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r16 = r7
            r7 = 3
            if (r11 != r7) goto L_0x0182
            r7 = 1
            r8 = r8[r7]     // Catch:{ ZipException -> 0x0108, EOFException -> 0x0105, all -> 0x020f }
            boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r7 != 0) goto L_0x0182
            java.lang.Object r7 = r13.get(r8)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.util.List r7 = (java.util.List) r7     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r7 != 0) goto L_0x0101
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r7.<init>()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r13.put(r8, r7)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
        L_0x0101:
            r7.add(r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            goto L_0x010d
        L_0x0105:
            r11 = r7
            goto L_0x0207
        L_0x0108:
            r11 = r7
            goto L_0x020b
        L_0x010b:
            r16 = r7
        L_0x010d:
            boolean r7 = r10.endsWith(r5)     // Catch:{ all -> 0x0166 }
            if (r7 == 0) goto L_0x0182
            boolean r7 = r0.isDirectory()     // Catch:{ all -> 0x0166 }
            if (r7 != 0) goto L_0x0182
            if (r3 != 0) goto L_0x0182
            java.lang.String r7 = r1.dataDir     // Catch:{ all -> 0x0166 }
            d(r7)     // Catch:{ all -> 0x0166 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0166 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0166 }
            r10.<init>()     // Catch:{ all -> 0x0166 }
            int r11 = r1.key     // Catch:{ all -> 0x0166 }
            r10.append(r11)     // Catch:{ all -> 0x0166 }
            r10.append(r6)     // Catch:{ all -> 0x0166 }
            java.lang.String r11 = r1.versionName     // Catch:{ all -> 0x0166 }
            r10.append(r11)     // Catch:{ all -> 0x0166 }
            r10.append(r5)     // Catch:{ all -> 0x0166 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0166 }
            r8.<init>(r7, r10)     // Catch:{ all -> 0x0166 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
            java.lang.String r10 = "e: "
            r7.<init>(r10)     // Catch:{ all -> 0x0164 }
            java.lang.String r10 = r8.getAbsolutePath()     // Catch:{ all -> 0x0164 }
            r7.append(r10)     // Catch:{ all -> 0x0164 }
            e.c.f.c.a()     // Catch:{ all -> 0x0164 }
            boolean r0 = a(r12, r0, r8)     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x015a
            java.lang.String r15 = r8.getAbsolutePath()     // Catch:{ all -> 0x0164 }
            goto L_0x0182
        L_0x015a:
            boolean r0 = r8.exists()     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0182
            r8.delete()     // Catch:{ all -> 0x0164 }
            goto L_0x0182
        L_0x0164:
            r0 = move-exception
            goto L_0x0168
        L_0x0166:
            r0 = move-exception
            r8 = 0
        L_0x0168:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r7.<init>()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r7.append(r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            e.c.f.c.a()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r8 == 0) goto L_0x0182
            boolean r0 = r8.exists()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r0 == 0) goto L_0x0182
            r8.delete()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
        L_0x0182:
            r7 = r16
            r11 = 1
            goto L_0x00a6
        L_0x0187:
            if (r3 == 0) goto L_0x01fd
            int r0 = r13.size()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r0 <= 0) goto L_0x01fd
            java.util.Set r0 = r13.keySet()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            android.content.Context r5 = r1.hostContext     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.lang.String r0 = a(r5, r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r5 != 0) goto L_0x01fd
            java.io.File r5 = new java.io.File     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r5.<init>(r2, r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.lang.String r6 = r5.getAbsolutePath()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            d(r6)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.lang.Object r0 = r13.get(r0)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.util.List r0 = (java.util.List) r0     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r0 == 0) goto L_0x01f3
            int r6 = r0.size()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r6 <= 0) goto L_0x01f3
            java.util.Iterator r0 = r0.iterator()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
        L_0x01bd:
            boolean r6 = r0.hasNext()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            if (r6 == 0) goto L_0x01f3
            java.lang.Object r6 = r0.next()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.util.zip.ZipEntry r6 = (java.util.zip.ZipEntry) r6     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            java.lang.String r7 = r6.getName()     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            int r10 = r7.lastIndexOf(r8)     // Catch:{ ZipException -> 0x01fb, EOFException -> 0x01f9, all -> 0x020f }
            r11 = 1
            int r10 = r10 + r11
            java.lang.String r7 = r7.substring(r10)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            r10.<init>()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            r10.append(r9)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            r10.append(r4)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.String r10 = r10.toString()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.lang.String r7 = r7.replace(r4, r10)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            java.io.File r10 = new java.io.File     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            r10.<init>(r5, r7)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            a(r12, r6, r10)     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            goto L_0x01bd
        L_0x01f3:
            r11 = 1
            java.lang.String r15 = r5.getAbsolutePath()     // Catch:{ ZipException -> 0x020b, EOFException -> 0x0207, all -> 0x020f }
            goto L_0x01fd
        L_0x01f9:
            r11 = 1
            goto L_0x0207
        L_0x01fb:
            r11 = 1
            goto L_0x020b
        L_0x01fd:
            r12.close()     // Catch:{ all -> 0x0201 }
            goto L_0x0204
        L_0x0201:
            e.c.f.c.d()
        L_0x0204:
            r8 = 0
            goto L_0x02ae
        L_0x0207:
            r10 = r12
            r7 = r15
            goto L_0x029a
        L_0x020b:
            r10 = r12
            r7 = r15
            goto L_0x02a3
        L_0x020f:
            r0 = move-exception
            r10 = r12
            goto L_0x028d
        L_0x0213:
            r16 = r7
            r10 = r12
            r7 = r16
            goto L_0x029a
        L_0x021a:
            r16 = r7
            r10 = r12
            r7 = r16
            goto L_0x02a3
        L_0x0221:
            r0 = move-exception
            r16 = r7
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r5.<init>()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r5.append(r12)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r6 = "--"
            r5.append(r6)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r5.append(r0)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r0 = r5.toString()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            throw r4     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
        L_0x0242:
            r16 = r7
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r4.<init>()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r4.append(r12)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r5 = "--file not exists after copy"
            r4.append(r5)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r0.<init>(r4)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            throw r0     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
        L_0x025b:
            r16 = r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r0.<init>()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r0.append(r12)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r4 = "--backupFile not exists"
            r0.append(r4)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            throw r4     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
        L_0x0274:
            r16 = r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r0.<init>()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r0.append(r12)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r4 = "--backupDir not exists"
            r0.append(r4)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
            throw r4     // Catch:{ ZipException -> 0x02a0, EOFException -> 0x0297, all -> 0x0030 }
        L_0x028d:
            if (r10 == 0) goto L_0x0296
            r10.close()     // Catch:{ all -> 0x0293 }
            goto L_0x0296
        L_0x0293:
            e.c.f.c.d()
        L_0x0296:
            throw r0
        L_0x0297:
            r7 = r16
            r10 = 0
        L_0x029a:
            if (r10 == 0) goto L_0x02ac
            r10.close()     // Catch:{ all -> 0x02a9 }
            goto L_0x02ac
        L_0x02a0:
            r7 = r16
            r10 = 0
        L_0x02a3:
            if (r10 == 0) goto L_0x02ac
            r10.close()     // Catch:{ all -> 0x02a9 }
            goto L_0x02ac
        L_0x02a9:
            e.c.f.c.d()
        L_0x02ac:
            r15 = r7
            r8 = r11
        L_0x02ae:
            if (r8 == 0) goto L_0x02b5
            java.lang.String r0 = a(r1, r2, r9, r3)
            return r0
        L_0x02b5:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(com.baidu.sofire.core.ApkInfo, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x003f A[SYNTHETIC, Splitter:B:33:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0048 A[SYNTHETIC, Splitter:B:38:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.zip.ZipFile r3, java.util.zip.ZipEntry r4, java.io.File r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x0039 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0036 }
            r4.<init>(r5)     // Catch:{ all -> 0x0036 }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0037 }
        L_0x0012:
            int r2 = r3.read(r1)     // Catch:{ all -> 0x0037 }
            if (r2 <= 0) goto L_0x001c
            r4.write(r1, r0, r2)     // Catch:{ all -> 0x0037 }
            goto L_0x0012
        L_0x001c:
            r4.flush()     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0037 }
            r1 = 1
            e.c.f.n.a.a(r5, r1)     // Catch:{ all -> 0x0037 }
            r3.close()     // Catch:{ all -> 0x002b }
            goto L_0x002e
        L_0x002b:
            e.c.f.c.d()
        L_0x002e:
            r4.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0035
        L_0x0032:
            e.c.f.c.d()
        L_0x0035:
            return r1
        L_0x0036:
            r4 = r1
        L_0x0037:
            r1 = r3
            goto L_0x003a
        L_0x0039:
            r4 = r1
        L_0x003a:
            e.c.f.c.d()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            e.c.f.c.d()
        L_0x0046:
            if (r4 == 0) goto L_0x004f
            r4.close()     // Catch:{ all -> 0x004c }
            goto L_0x004f
        L_0x004c:
            e.c.f.c.d()
        L_0x004f:
            return r0
        L_0x0050:
            r3 = move-exception
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            e.c.f.c.d()
        L_0x005a:
            if (r4 == 0) goto L_0x0063
            r4.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            e.c.f.c.d()
        L_0x0063:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    public static String a(ApkInfo apkInfo, String str, String str2, boolean z) throws Throwable {
        ApkInfo apkInfo2 = apkInfo;
        String str3 = str;
        String str4 = ".dex";
        String str5 = ".so";
        String str6 = "";
        if (apkInfo2 == null) {
            return str6;
        }
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(apkInfo2.pkgPath));
        String str7 = str6;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                String str8 = "lib/";
                String str9 = BceConfig.BOS_DELIMITER;
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name.contains("..")) {
                        try {
                            zipInputStream.close();
                        } catch (Throwable unused) {
                            c.d();
                        }
                        return str6;
                    }
                    if (name.startsWith(str8) && !nextEntry.isDirectory() && z) {
                        String[] split = name.split(str9);
                        if (split.length != 3) {
                            zipInputStream.closeEntry();
                        } else {
                            String str10 = split[1];
                            if (TextUtils.isEmpty(str10)) {
                                zipInputStream.closeEntry();
                            } else if (!arrayList.contains(str10)) {
                                arrayList.add(str10);
                            }
                        }
                    }
                    File file = null;
                    try {
                        if (name.endsWith(str4) && !nextEntry.isDirectory() && !z) {
                            String str11 = apkInfo2.dataDir;
                            d(str11);
                            StringBuilder sb = new StringBuilder();
                            sb.append(apkInfo2.key);
                            sb.append("-");
                            sb.append(apkInfo2.versionName);
                            sb.append(str4);
                            File file2 = new File(str11, sb.toString());
                            try {
                                new StringBuilder().append(file2.getAbsolutePath());
                                c.a();
                                file2.delete();
                                file2.createNewFile();
                                if (a(file2, zipInputStream)) {
                                    str7 = file2.getAbsolutePath();
                                } else if (file2.exists()) {
                                    file2.delete();
                                }
                            } catch (Throwable th) {
                                th = th;
                                file = file2;
                                new StringBuilder().append(th.getMessage());
                                c.a();
                                if (file != null && file.exists()) {
                                    file.delete();
                                }
                                zipInputStream.closeEntry();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        new StringBuilder().append(th.getMessage());
                        c.a();
                        file.delete();
                        zipInputStream.closeEntry();
                    }
                    zipInputStream.closeEntry();
                } else {
                    try {
                        zipInputStream.close();
                    } catch (Throwable unused2) {
                        c.d();
                    }
                    if (z && arrayList.size() > 0) {
                        String a2 = a(apkInfo2.hostContext, (Collection<String>) arrayList);
                        if (!TextUtils.isEmpty(a2)) {
                            File file3 = new File(str3, a2);
                            d(file3.getAbsolutePath());
                            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(apkInfo2.pkgPath));
                            while (true) {
                                try {
                                    ZipEntry nextEntry2 = zipInputStream2.getNextEntry();
                                    if (nextEntry2 == null) {
                                        break;
                                    }
                                    String name2 = nextEntry2.getName();
                                    if (name2.startsWith(str8) && name2.endsWith(str5) && !nextEntry2.isDirectory()) {
                                        String[] split2 = name2.split(str9);
                                        if (split2.length != 3) {
                                            zipInputStream2.closeEntry();
                                        } else if (a2.equals(split2[1])) {
                                            String substring = name2.substring(name2.lastIndexOf(str9) + 1);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str2);
                                            sb2.append(str5);
                                            File file4 = new File(file3, substring.replace(str5, sb2.toString()));
                                            StringBuilder sb3 = new StringBuilder("l=");
                                            sb3.append(str3);
                                            sb3.append(", n=");
                                            sb3.append(name2);
                                            sb3.append(", f=");
                                            sb3.append(file4);
                                            c.a();
                                            file4.delete();
                                            file4.createNewFile();
                                            a(file4, zipInputStream2);
                                            zipInputStream2.closeEntry();
                                        }
                                    }
                                    String str12 = str2;
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                    c.d();
                                }
                            }
                            str7 = file3.getAbsolutePath();
                            try {
                                zipInputStream2.close();
                            } catch (Throwable unused4) {
                                c.d();
                            }
                        }
                    }
                    return str7;
                }
            } catch (Throwable unused5) {
                c.d();
            }
        }
        throw th;
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        if (r1 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r4, java.util.zip.ZipInputStream r5) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ all -> 0x0027 }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0028 }
        L_0x000a:
            int r3 = r5.read(r2)     // Catch:{ all -> 0x0028 }
            if (r3 <= 0) goto L_0x0014
            r1.write(r2, r0, r3)     // Catch:{ all -> 0x0028 }
            goto L_0x000a
        L_0x0014:
            r1.flush()     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0028 }
            r5 = 1
            e.c.f.n.a.a(r4, r5)     // Catch:{ all -> 0x0028 }
            r1.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0026
        L_0x0023:
            e.c.f.c.d()
        L_0x0026:
            return r5
        L_0x0027:
            r1 = 0
        L_0x0028:
            e.c.f.c.d()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0034
        L_0x0031:
            e.c.f.c.d()
        L_0x0034:
            return r0
        L_0x0035:
            r4 = move-exception
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            e.c.f.c.d()
        L_0x003f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(java.io.File, java.util.zip.ZipInputStream):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, java.util.Collection<java.lang.String> r8) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            android.content.pm.PackageManager r2 = r7.getPackageManager()     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0029
            java.lang.String r7 = r7.getPackageName()     // Catch:{ all -> 0x0026 }
            android.content.pm.ApplicationInfo r7 = r2.getApplicationInfo(r7, r1)     // Catch:{ all -> 0x0026 }
            if (r7 == 0) goto L_0x0029
            java.lang.Class<android.content.pm.ApplicationInfo> r2 = android.content.pm.ApplicationInfo.class
            java.lang.String r3 = "primaryCpuAbi"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ all -> 0x0026 }
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ all -> 0x0026 }
            java.lang.Object r7 = r2.get(r7)     // Catch:{ all -> 0x0026 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            e.c.f.c.d()
        L_0x0029:
            r7 = r0
        L_0x002a:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 != 0) goto L_0x0037
            boolean r2 = r8.contains(r7)
            if (r2 == 0) goto L_0x0037
            return r7
        L_0x0037:
            boolean r7 = android.os.Process.is64Bit()
            if (r7 == 0) goto L_0x0040
            java.lang.String[] r2 = android.os.Build.SUPPORTED_64_BIT_ABIS
            goto L_0x0042
        L_0x0040:
            java.lang.String[] r2 = android.os.Build.SUPPORTED_32_BIT_ABIS
        L_0x0042:
            if (r2 == 0) goto L_0x0057
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0057
            int r3 = r2.length
            r4 = r1
        L_0x0049:
            if (r4 >= r3) goto L_0x0057
            r5 = r2[r4]
            boolean r6 = r8.contains(r5)
            if (r6 == 0) goto L_0x0054
            return r5
        L_0x0054:
            int r4 = r4 + 1
            goto L_0x0049
        L_0x0057:
            if (r7 != 0) goto L_0x0073
            java.lang.String r7 = "armeabi"
            boolean r8 = r8.contains(r7)
            if (r8 == 0) goto L_0x0073
            java.lang.String[] r8 = android.os.Build.SUPPORTED_ABIS
            if (r8 == 0) goto L_0x0073
            int r2 = r8.length
            if (r2 <= 0) goto L_0x0073
            r8 = r8[r1]
            java.lang.String r1 = "mips"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x0073
            return r7
        L_0x0073:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.f.g.a(android.content.Context, java.util.Collection):java.lang.String");
    }
}
