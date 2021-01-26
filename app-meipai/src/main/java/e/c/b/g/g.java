package e.c.b.g;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.b.d;
import e.c.b.e.Utils;
import e.c.b.f.a;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g {

    /* renamed from: a reason: collision with root package name */
    public static SharedPreferences f5940a;

    /* renamed from: b reason: collision with root package name */
    public static final ScheduledThreadPoolExecutor f5941b = new ScheduledThreadPoolExecutor(1);

    static {
        new ScheduledThreadPoolExecutor(1);
    }

    public static String a(String str) {
        return str.substring(str.lastIndexOf(BceConfig.BOS_DELIMITER) + 1);
    }

    public static void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (f5940a == null && context != null) {
                f5940a = context.getSharedPreferences("last_init_crab", 4);
            }
            if (f5940a != null) {
                f5940a.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder("setLastInitTime cost time = ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        a.b(sb.toString());
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (g.class) {
            h hVar = new h(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = "time_upload_crash";
                long j2 = 0;
                try {
                    if (f5940a == null && context != null) {
                        f5940a = context.getSharedPreferences("last_init_crab", 4);
                    }
                    if (f5940a != null) {
                        j2 = f5940a.getLong(str, 0);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                long j3 = currentTimeMillis - j2;
                StringBuilder sb = new StringBuilder("uploadCrash 距离初始化上次上传的间隔是：");
                sb.append(j3);
                a.b(sb.toString());
                if (j3 < FragmentStateAdapter.GRACE_WINDOW_TIME_MS) {
                    f5941b.schedule(hVar, 10, TimeUnit.SECONDS);
                } else {
                    f5941b.execute(hVar);
                }
                a(context, "time_upload_crash");
                return;
            }
            f5941b.execute(hVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x015a A[Catch:{ Exception -> 0x0266 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0164 A[Catch:{ Exception -> 0x0266 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b2 A[Catch:{ Exception -> 0x0266 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02de A[Catch:{ Exception -> 0x0266 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r9) {
        /*
            java.lang.Class<e.c.b.g.g> r0 = e.c.b.g.g.class
            monitor-enter(r0)
            java.util.List r9 = e.c.b.e.i.a(r9)     // Catch:{ all -> 0x02ff }
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            int r1 = r9.size()     // Catch:{ all -> 0x02ff }
            if (r1 == 0) goto L_0x02fd
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x02ff }
        L_0x0013:
            boolean r1 = r9.hasNext()     // Catch:{ all -> 0x02ff }
            if (r1 == 0) goto L_0x02fd
            java.lang.Object r1 = r9.next()     // Catch:{ all -> 0x02ff }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "(--#)  fileName when send  (--#)"
            r2.<init>(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = a(r1)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.b(r2)     // Catch:{ all -> 0x02ff }
            android.content.SharedPreferences r2 = e.c.b.e.i.k     // Catch:{ all -> 0x02ff }
            r3 = 0
            if (r2 == 0) goto L_0x003e
            int r2 = r2.getInt(r1, r3)     // Catch:{ all -> 0x02ff }
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            r4 = 2
            r5 = 1
            if (r2 <= r4) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r3 = r5
        L_0x0045:
            if (r3 != 0) goto L_0x004e
            e.c.b.e.i.c(r1)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.h(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x0013
        L_0x004e:
            byte[] r2 = e.c.b.e.i.n(r1)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r4 = "HttpSender.sendRecord: "
            r3.<init>(r4)     // Catch:{ all -> 0x02ff }
            r3.append(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r3)     // Catch:{ all -> 0x02ff }
            r3 = 0
            java.lang.String r4 = "crab_crash_"
            boolean r4 = r1.contains(r4)     // Catch:{ all -> 0x02ff }
            if (r4 == 0) goto L_0x00af
            java.lang.String r3 = "Crash"
            java.lang.String r4 = "/"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ all -> 0x02ff }
            int r4 = r4 + r5
            java.lang.String r4 = r1.substring(r4)     // Catch:{ all -> 0x02ff }
            boolean r6 = e.c.b.d.z     // Catch:{ all -> 0x02ff }
            if (r6 == 0) goto L_0x0091
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            r6.<init>()     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = e.c.b.d.G     // Catch:{ all -> 0x02ff }
            r6.append(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = "api_int/add_crab"
            r6.append(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x02ff }
            goto L_0x0093
        L_0x0091:
            java.lang.String r6 = e.c.b.d.J     // Catch:{ all -> 0x02ff }
        L_0x0093:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r8 = "sendCrashRecord postUrl:"
            r7.<init>(r8)     // Catch:{ all -> 0x02ff }
            r7.append(r6)     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = e.c.b.e.i.a(r6, r2, r3, r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "HttpSender.sendCrashRecord--->Crash"
        L_0x00aa:
            e.c.b.f.a.a(r2)     // Catch:{ all -> 0x02ff }
            goto L_0x0143
        L_0x00af:
            java.lang.String r4 = "crab_anr_"
            boolean r4 = r1.contains(r4)     // Catch:{ all -> 0x02ff }
            if (r4 == 0) goto L_0x00e0
            java.lang.String r3 = "Anr"
            java.lang.String r4 = "/"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ all -> 0x02ff }
            int r4 = r4 + r5
            java.lang.String r4 = r1.substring(r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r6 = e.c.b.d.a()     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r8 = "sendAnrRecord postUrl:"
            r7.<init>(r8)     // Catch:{ all -> 0x02ff }
            r7.append(r6)     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = e.c.b.e.i.a(r6, r2, r3, r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "HttpSender.sendAnrRecord--->Anr"
            goto L_0x00aa
        L_0x00e0:
            java.lang.String r4 = "crab_catched_"
            boolean r4 = r1.contains(r4)     // Catch:{ all -> 0x02ff }
            if (r4 == 0) goto L_0x0111
            java.lang.String r3 = "Exception"
            java.lang.String r4 = "/"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ all -> 0x02ff }
            int r4 = r4 + r5
            java.lang.String r4 = r1.substring(r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r6 = e.c.b.d.a()     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r8 = "sendExceptionRecord postUrl:"
            r7.<init>(r8)     // Catch:{ all -> 0x02ff }
            r7.append(r6)     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = e.c.b.e.i.a(r6, r2, r3, r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "HttpSender.sendExceptionRecord--->Exception"
            goto L_0x00aa
        L_0x0111:
            java.lang.String r4 = "crab_block_"
            boolean r4 = r1.contains(r4)     // Catch:{ all -> 0x02ff }
            if (r4 == 0) goto L_0x0143
            java.lang.String r3 = "Block"
            java.lang.String r4 = "/"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ all -> 0x02ff }
            int r4 = r4 + r5
            java.lang.String r4 = r1.substring(r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r6 = e.c.b.d.a()     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r8 = "sendBlockRecord postUrl:"
            r7.<init>(r8)     // Catch:{ all -> 0x02ff }
            r7.append(r6)     // Catch:{ all -> 0x02ff }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r7)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = e.c.b.e.i.a(r6, r2, r3, r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "HttpSender.sendExceptionRecord--->Block"
            goto L_0x00aa
        L_0x0143:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r4 = "HttpSender.doUpload.result: "
            r2.<init>(r4)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r2)     // Catch:{ all -> 0x02ff }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x02ff }
            if (r2 == 0) goto L_0x0164
            e.c.b.e.i.g(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r1 = "result is empty!"
        L_0x015f:
            e.c.b.f.a.d(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x02f9
        L_0x0164:
            if (r3 == 0) goto L_0x0171
            java.lang.String r2 = "N/A"
            boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x02ff }
            if (r2 == 0) goto L_0x0171
            java.lang.String r1 = "not connected to server!"
            goto L_0x015f
        L_0x0171:
            r2 = -100
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x02e3 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x02e3 }
            java.lang.String r3 = "errno"
            boolean r3 = r4.has(r3)     // Catch:{ Exception -> 0x02e3 }
            if (r3 == 0) goto L_0x018d
            java.lang.String r2 = "errno"
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x02e3 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x02e3 }
        L_0x0188:
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x02e3 }
            goto L_0x019e
        L_0x018d:
            java.lang.String r3 = "errNo"
            boolean r3 = r4.has(r3)     // Catch:{ Exception -> 0x02e3 }
            if (r3 == 0) goto L_0x019e
            java.lang.String r2 = "errNo"
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x02e3 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x02e3 }
            goto L_0x0188
        L_0x019e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r6 = "###--> errno = "
            r3.<init>(r6)     // Catch:{ all -> 0x02ff }
            r3.append(r2)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.a(r3)     // Catch:{ all -> 0x02ff }
            r3 = -1
            if (r2 == r3) goto L_0x02de
            if (r2 == 0) goto L_0x02ac
            if (r2 == r5) goto L_0x0225
            r3 = 10
            if (r2 == r3) goto L_0x01f0
            r3 = 15
            if (r2 == r3) goto L_0x01f0
            e.c.b.e.i.c(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ all -> 0x02ff }
            int r2 = r2 + r5
            java.lang.String r2 = r1.substring(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.k(r2)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "key_"
            r2.<init>(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "/"
            int r3 = r1.lastIndexOf(r3)     // Catch:{ all -> 0x02ff }
            int r3 = r3 + r5
            java.lang.String r3 = r1.substring(r3)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.m(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.h(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x02f9
        L_0x01f0:
            e.c.b.e.i.c(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ all -> 0x02ff }
            int r2 = r2 + r5
            java.lang.String r2 = r1.substring(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.k(r2)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "key_"
            r2.<init>(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "/"
            int r3 = r1.lastIndexOf(r3)     // Catch:{ all -> 0x02ff }
            int r3 = r3 + r5
            java.lang.String r3 = r1.substring(r3)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.m(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.h(r1)     // Catch:{ all -> 0x02ff }
        L_0x0220:
            e.c.b.e.i.h()     // Catch:{ all -> 0x02ff }
            goto L_0x02f9
        L_0x0225:
            java.lang.String r2 = "days"
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x0266 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0266 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0266 }
            if (r2 > 0) goto L_0x0234
            r2 = r5
        L_0x0234:
            e.c.b.e.i.a(r2)     // Catch:{ Exception -> 0x0266 }
            e.c.b.e.i.c(r1)     // Catch:{ Exception -> 0x0266 }
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ Exception -> 0x0266 }
            int r2 = r2 + r5
            java.lang.String r2 = r1.substring(r2)     // Catch:{ Exception -> 0x0266 }
            e.c.b.e.i.k(r2)     // Catch:{ Exception -> 0x0266 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0266 }
            java.lang.String r3 = "key_"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0266 }
            java.lang.String r3 = "/"
            int r3 = r1.lastIndexOf(r3)     // Catch:{ Exception -> 0x0266 }
            int r3 = r3 + r5
            java.lang.String r3 = r1.substring(r3)     // Catch:{ Exception -> 0x0266 }
            r2.append(r3)     // Catch:{ Exception -> 0x0266 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0266 }
            e.c.b.e.i.m(r2)     // Catch:{ Exception -> 0x0266 }
            goto L_0x02f9
        L_0x0266:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r4 = "handle crash result days json error, exception is "
            r3.<init>(r4)     // Catch:{ all -> 0x02ff }
            r3.append(r2)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.c(r3)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.a(r5)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.c(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "/"
            int r3 = r1.lastIndexOf(r3)     // Catch:{ all -> 0x02ff }
            int r3 = r3 + r5
            java.lang.String r3 = r1.substring(r3)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.k(r3)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r4 = "key_"
            r3.<init>(r4)     // Catch:{ all -> 0x02ff }
            java.lang.String r4 = "/"
            int r4 = r1.lastIndexOf(r4)     // Catch:{ all -> 0x02ff }
            int r4 = r4 + r5
            java.lang.String r1 = r1.substring(r4)     // Catch:{ all -> 0x02ff }
            r3.append(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.m(r1)     // Catch:{ all -> 0x02ff }
        L_0x02a8:
            r2.printStackTrace()     // Catch:{ all -> 0x02ff }
            goto L_0x02f9
        L_0x02ac:
            e.c.b.e.i.c(r1)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ all -> 0x02ff }
            int r2 = r2 + r5
            java.lang.String r2 = r1.substring(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.k(r2)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "key_"
            r2.<init>(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "/"
            int r3 = r1.lastIndexOf(r3)     // Catch:{ all -> 0x02ff }
            int r3 = r3 + r5
            java.lang.String r3 = r1.substring(r3)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.m(r2)     // Catch:{ all -> 0x02ff }
            e.c.b.e.i.h(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x0220
        L_0x02de:
            e.c.b.e.i.g(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x0220
        L_0x02e3:
            r2 = move-exception
            e.c.b.e.i.g(r1)     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = "handle crash result json error, exception is "
            r1.<init>(r3)     // Catch:{ all -> 0x02ff }
            r1.append(r2)     // Catch:{ all -> 0x02ff }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02ff }
            e.c.b.f.a.c(r1)     // Catch:{ all -> 0x02ff }
            goto L_0x02a8
        L_0x02f9:
            e.c.b.g.f.f5935c = r5     // Catch:{ all -> 0x02ff }
            goto L_0x0013
        L_0x02fd:
            monitor-exit(r0)
            return
        L_0x02ff:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.g.g.b(android.content.Context):void");
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            if (((ArrayList) Utils.a(context)).size() != 0) {
                String a2 = Utils.a();
                if (!"NONE".equals(a2)) {
                    if (!"UNKNOWN".equals(a2)) {
                        if (d.n) {
                            a.b("upload immediately!");
                            Utils.a(0);
                            b(context);
                            return;
                        } else if ("WIFI".equals(a2)) {
                            Utils.a(0);
                            b(context);
                            return;
                        } else if (d.p) {
                            a.b("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                            return;
                        } else {
                            if ("MOBILE".equals(a2)) {
                                SharedPreferences sharedPreferences = Utils.sharedPreferences;
                                long j2 = sharedPreferences != null ? sharedPreferences.getLong("crash_upload_time_nowifi", 0) : 0;
                                boolean z = false;
                                if (j2 == 0) {
                                    Utils.putLong(System.currentTimeMillis());
                                } else if (System.currentTimeMillis() - j2 > LogBuilder.MAX_INTERVAL) {
                                    Utils.a(0);
                                    z = true;
                                }
                                if (z) {
                                    a.b("upload without wifi!");
                                    Utils.a(0);
                                    b(context);
                                    return;
                                }
                            }
                            a.b("network is not wifi!");
                            return;
                        }
                    }
                }
                a.b("network is not available!");
            }
        }
    }
}
