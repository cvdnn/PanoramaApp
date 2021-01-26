package e.c.b.g;

import android.content.Context;
import android.os.Environment;
import e.c.b.e.Utils;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;

public final class f implements UncaughtExceptionHandler {

    /* renamed from: c reason: collision with root package name */
    public static boolean f5935c = false;

    /* renamed from: d reason: collision with root package name */
    public static final String f5936d;

    /* renamed from: e reason: collision with root package name */
    public static f f5937e = new f();

    /* renamed from: a reason: collision with root package name */
    public UncaughtExceptionHandler f5938a = null;

    /* renamed from: b reason: collision with root package name */
    public Context f5939b = null;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append(File.separator);
        sb.append(Utils.c());
        sb.append(File.separator);
        sb.append("oom");
        sb.append(File.separator);
        f5936d = sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014e, code lost:
        if (e.c.b.d.u > e.c.b.d.r) goto L_0x0150;
     */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uncaughtException(java.lang.Thread r17, java.lang.Throwable r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            boolean r0 = e.c.b.d.E
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            r4 = 1
            e.c.b.d.E = r4
            e.c.b.b r0 = e.c.b.d.H
            if (r0 == 0) goto L_0x0015
            r0.a(r2, r3)
        L_0x0015:
            java.lang.String r0 = r18.toString()
            java.lang.String r5 = ""
            r6 = 0
            if (r0 == 0) goto L_0x0035
            boolean r7 = r0.equals(r5)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = ":"
            java.lang.String[] r7 = r0.split(r7)     // Catch:{ Exception -> 0x0035 }
            int r8 = r0.length()     // Catch:{ Exception -> 0x0035 }
            if (r8 <= r4) goto L_0x0033
            r7 = r7[r6]     // Catch:{ Exception -> 0x0035 }
            goto L_0x0036
        L_0x0033:
            r7 = r0
            goto L_0x0036
        L_0x0035:
            r7 = r5
        L_0x0036:
            if (r7 == 0) goto L_0x003e
            boolean r8 = r7.equals(r5)
            if (r8 == 0) goto L_0x003f
        L_0x003e:
            r7 = r0
        L_0x003f:
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            java.io.PrintWriter r8 = new java.io.PrintWriter
            r8.<init>(r0)
            r3.printStackTrace(r8)
            java.lang.String r9 = r0.toString()
            r8.close()     // Catch:{ IOException -> 0x0057 }
            r0.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r0 = move-exception
            java.lang.String r8 = "pw"
            e.c.b.f.a.a(r8, r0)
        L_0x005d:
            if (r9 == 0) goto L_0x0429
            java.lang.String r0 = r7.trim()
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0429
            boolean r0 = e.c.b.d.l
            if (r0 == 0) goto L_0x0100
            r0 = r3
        L_0x006e:
            java.lang.String r5 = "java.lang.OutOfMemoryError"
            java.lang.Class r7 = r0.getClass()
            java.lang.String r7 = r7.getName()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0080
            r0 = r4
            goto L_0x0087
        L_0x0080:
            java.lang.Throwable r0 = r0.getCause()
            if (r0 != 0) goto L_0x006e
            r0 = r6
        L_0x0087:
            if (r0 == 0) goto L_0x0100
            java.lang.String r0 = f5936d     // Catch:{ all -> 0x00ea }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00ea }
            r5.<init>(r0)     // Catch:{ all -> 0x00ea }
            boolean r7 = r5.exists()     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00bd
            boolean r5 = r5.mkdirs()     // Catch:{ all -> 0x00ea }
            if (r5 != 0) goto L_0x00ae
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = "app文件创建失败  fileName is "
            r5.<init>(r7)     // Catch:{ all -> 0x00ea }
            r5.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ea }
        L_0x00aa:
            e.c.b.f.a.c(r5)     // Catch:{ all -> 0x00ea }
            goto L_0x00bd
        L_0x00ae:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = "app文件创建ok  fileName is "
            r5.<init>(r7)     // Catch:{ all -> 0x00ea }
            r5.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ea }
            goto L_0x00aa
        L_0x00bd:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r5.<init>()     // Catch:{ all -> 0x00ea }
            r5.append(r0)     // Catch:{ all -> 0x00ea }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ea }
            r5.append(r7)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = ".hprof"
            r5.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00ea }
            android.os.Debug.dumpHprofData(r0)     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            java.lang.String r7 = "输出OOM的dump信息 name="
            r5.<init>(r7)     // Catch:{ all -> 0x00ea }
            r5.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00ea }
            e.c.b.f.a.b(r0)     // Catch:{ all -> 0x00ea }
            goto L_0x0100
        L_0x00ea:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "oom save fail"
            r5.<init>(r7)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            e.c.b.f.a.c(r0)
        L_0x0100:
            boolean r0 = e.c.b.e.i.g()
            if (r0 == 0) goto L_0x0429
            int r0 = e.c.b.d.r
            java.lang.String r5 = "oneday_crash_count"
            r7 = -1
            if (r0 != r7) goto L_0x010f
        L_0x010d:
            r0 = r4
            goto L_0x0151
        L_0x010f:
            android.content.SharedPreferences r0 = e.c.b.e.i.k
            if (r0 == 0) goto L_0x014a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = e.c.b.e.i.j()
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            int r0 = r0.getInt(r8, r7)
            int r8 = e.c.b.d.r
            if (r0 <= r8) goto L_0x014a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "exceed daily crash quota "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r0 = "/"
            r8.append(r0)
            int r0 = e.c.b.d.r
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            e.c.b.f.a.c(r0)
            goto L_0x0150
        L_0x014a:
            int r0 = e.c.b.d.u
            int r8 = e.c.b.d.r
            if (r0 <= r8) goto L_0x010d
        L_0x0150:
            r0 = r6
        L_0x0151:
            if (r0 == 0) goto L_0x0429
            int r0 = e.c.b.d.q
            java.lang.String r8 = "errorOriLine"
            java.lang.String r9 = "same_crash_oneday_count"
            java.lang.String r10 = "count"
            r11 = 0
            if (r0 != r7) goto L_0x0161
        L_0x015e:
            r0 = r4
            goto L_0x0205
        L_0x0161:
            android.content.SharedPreferences r0 = e.c.b.e.i.k
            if (r0 == 0) goto L_0x01fe
            java.lang.String r12 = e.c.b.e.i.b(r18)
            android.content.SharedPreferences r0 = e.c.b.e.i.k
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = e.c.b.e.i.j()
            r13.append(r14)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = r0.getString(r13, r11)
            boolean r13 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01b5 }
            if (r13 != 0) goto L_0x01cb
            org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ Exception -> 0x01b5 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x01b5 }
            r0 = r6
        L_0x018e:
            int r14 = r13.length()     // Catch:{ Exception -> 0x01b5 }
            if (r0 >= r14) goto L_0x01cb
            java.lang.Object r14 = r13.get(r0)     // Catch:{ Exception -> 0x01b5 }
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r15 = r14.getString(r8)     // Catch:{ Exception -> 0x01b5 }
            boolean r15 = r15.equals(r12)     // Catch:{ Exception -> 0x01b5 }
            if (r15 == 0) goto L_0x01b2
            int r14 = r14.getInt(r10)     // Catch:{ Exception -> 0x01b5 }
            int r15 = e.c.b.d.q     // Catch:{ Exception -> 0x01b5 }
            if (r14 < r15) goto L_0x01b2
            java.lang.String r0 = "canSameCrashUpload no"
            e.c.b.f.a.b(r0)     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01fc
        L_0x01b2:
            int r0 = r0 + 1
            goto L_0x018e
        L_0x01b5:
            r0 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "canSameCrashUpload exception "
            r13.<init>(r14)
            java.lang.String r0 = e.c.b.e.i.a(r0)
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            e.c.b.f.a.c(r0)
        L_0x01cb:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = e.c.b.d.t
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01d5:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x01fe
            java.lang.Object r13 = r0.next()
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = r13.equals(r12)
            if (r14 == 0) goto L_0x01d5
            java.util.HashMap<java.lang.String, java.lang.Integer> r14 = e.c.b.d.t
            java.lang.Object r13 = r14.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            int r14 = e.c.b.d.q
            if (r13 <= r14) goto L_0x01d5
            java.lang.String r0 = "SharedPreferences ignore, but canSameCrashUpload no"
            e.c.b.f.a.b(r0)
        L_0x01fc:
            r0 = r6
            goto L_0x0205
        L_0x01fe:
            java.lang.String r0 = "canSameCrashUpload yes"
            e.c.b.f.a.b(r0)
            goto L_0x015e
        L_0x0205:
            if (r0 == 0) goto L_0x0429
            f5935c = r6
            android.content.Context r0 = r1.f5939b
            if (r0 == 0) goto L_0x03f7
            if (r2 == 0) goto L_0x03f7
            java.util.Map r0 = e.c.b.e.i.a(r0, r3, r6)
            java.lang.String r0 = e.c.b.e.i.b(r0)
            android.content.Context r12 = r1.f5939b
            e.c.b.e.i.b(r12, r0)
            int r0 = e.c.b.d.q
            if (r0 != r7) goto L_0x0222
            goto L_0x0314
        L_0x0222:
            android.content.SharedPreferences r0 = e.c.b.e.i.k
            if (r0 == 0) goto L_0x0314
            java.lang.String r0 = e.c.b.e.i.b(r18)
            java.util.HashMap<java.lang.String, java.lang.Integer> r12 = e.c.b.d.t
            java.util.Set r12 = r12.keySet()
            java.util.Iterator r12 = r12.iterator()
            r13 = r4
        L_0x0235:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x025d
            java.lang.Object r14 = r12.next()
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = r14.equals(r0)
            if (r15 == 0) goto L_0x0235
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = e.c.b.d.t
            java.lang.Object r15 = r13.get(r14)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            int r15 = r15 + r4
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r13.put(r14, r15)
            r13 = r6
            goto L_0x0235
        L_0x025d:
            if (r13 == 0) goto L_0x0268
            java.util.HashMap<java.lang.String, java.lang.Integer> r12 = e.c.b.d.t
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)
            r12.put(r0, r13)
        L_0x0268:
            android.content.SharedPreferences r12 = e.c.b.e.i.k
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = e.c.b.e.i.j()
            r13.append(r14)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.String r12 = r12.getString(r13, r11)
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x02fe }
            if (r13 != 0) goto L_0x02c6
            org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ Exception -> 0x02fe }
            r13.<init>(r12)     // Catch:{ Exception -> 0x02fe }
            r12 = r6
            r14 = r12
        L_0x028e:
            int r15 = r13.length()     // Catch:{ Exception -> 0x02fe }
            if (r12 >= r15) goto L_0x02b1
            java.lang.Object r15 = r13.get(r12)     // Catch:{ Exception -> 0x02fe }
            org.json.JSONObject r15 = (org.json.JSONObject) r15     // Catch:{ Exception -> 0x02fe }
            java.lang.String r6 = r15.getString(r8)     // Catch:{ Exception -> 0x02fe }
            boolean r6 = r6.equals(r0)     // Catch:{ Exception -> 0x02fe }
            if (r6 == 0) goto L_0x02ad
            int r6 = r15.getInt(r10)     // Catch:{ Exception -> 0x02fe }
            int r6 = r6 + r4
            r15.put(r10, r6)     // Catch:{ Exception -> 0x02fe }
            r14 = r4
        L_0x02ad:
            int r12 = r12 + 1
            r6 = 0
            goto L_0x028e
        L_0x02b1:
            if (r14 != 0) goto L_0x02c1
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fe }
            r6.<init>()     // Catch:{ Exception -> 0x02fe }
            r6.put(r8, r0)     // Catch:{ Exception -> 0x02fe }
            r6.put(r10, r4)     // Catch:{ Exception -> 0x02fe }
            r13.put(r6)     // Catch:{ Exception -> 0x02fe }
        L_0x02c1:
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x02fe }
            goto L_0x02dd
        L_0x02c6:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x02fe }
            r6.<init>()     // Catch:{ Exception -> 0x02fe }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fe }
            r12.<init>()     // Catch:{ Exception -> 0x02fe }
            r12.put(r8, r0)     // Catch:{ Exception -> 0x02fe }
            r12.put(r10, r4)     // Catch:{ Exception -> 0x02fe }
            r6.put(r12)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x02fe }
        L_0x02dd:
            android.content.SharedPreferences r6 = e.c.b.e.i.k     // Catch:{ Exception -> 0x02fe }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ Exception -> 0x02fe }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02fe }
            r8.<init>()     // Catch:{ Exception -> 0x02fe }
            java.lang.String r12 = e.c.b.e.i.j()     // Catch:{ Exception -> 0x02fe }
            r8.append(r12)     // Catch:{ Exception -> 0x02fe }
            r8.append(r9)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02fe }
            android.content.SharedPreferences$Editor r0 = r6.putString(r8, r0)     // Catch:{ Exception -> 0x02fe }
            e.c.b.e.i.a(r0, r4)     // Catch:{ Exception -> 0x02fe }
            goto L_0x0314
        L_0x02fe:
            r0 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "addSameCrashUploadCount exception "
            r6.<init>(r8)
            java.lang.String r0 = e.c.b.e.i.a(r0)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            e.c.b.f.a.c(r0)
        L_0x0314:
            java.lang.String r0 = "constant_crash"
            int r6 = e.c.b.d.v
            if (r6 != r7) goto L_0x031c
            goto L_0x0399
        L_0x031c:
            android.content.SharedPreferences r6 = e.c.b.e.i.k
            if (r6 == 0) goto L_0x0399
            java.lang.String r6 = e.c.b.e.i.b(r18)
            android.content.SharedPreferences r8 = e.c.b.e.i.k     // Catch:{ Exception -> 0x0383 }
            java.lang.String r8 = r8.getString(r0, r11)     // Catch:{ Exception -> 0x0383 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0383 }
            java.lang.String r11 = "crash"
            if (r9 != 0) goto L_0x0355
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0383 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0383 }
            java.lang.String r8 = r9.getString(r11)     // Catch:{ Exception -> 0x0383 }
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0383 }
            if (r8 == 0) goto L_0x034a
            int r6 = r9.getInt(r10)     // Catch:{ Exception -> 0x0383 }
            int r6 = r6 + r4
            r9.put(r10, r6)     // Catch:{ Exception -> 0x0383 }
            goto L_0x0350
        L_0x034a:
            r9.put(r11, r6)     // Catch:{ Exception -> 0x0383 }
            r9.put(r10, r4)     // Catch:{ Exception -> 0x0383 }
        L_0x0350:
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x0383 }
            goto L_0x0364
        L_0x0355:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0383 }
            r8.<init>()     // Catch:{ Exception -> 0x0383 }
            r8.put(r11, r6)     // Catch:{ Exception -> 0x0383 }
            r8.put(r10, r4)     // Catch:{ Exception -> 0x0383 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x0383 }
        L_0x0364:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0383 }
            java.lang.String r9 = "同一crash连续发生："
            r8.<init>(r9)     // Catch:{ Exception -> 0x0383 }
            r8.append(r6)     // Catch:{ Exception -> 0x0383 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0383 }
            e.c.b.f.a.c(r8)     // Catch:{ Exception -> 0x0383 }
            android.content.SharedPreferences r8 = e.c.b.e.i.k     // Catch:{ Exception -> 0x0383 }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ Exception -> 0x0383 }
            android.content.SharedPreferences$Editor r0 = r8.putString(r0, r6)     // Catch:{ Exception -> 0x0383 }
            e.c.b.e.i.a(r0, r4)     // Catch:{ Exception -> 0x0383 }
            goto L_0x0399
        L_0x0383:
            r0 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "addConstantSameCrash exception "
            r6.<init>(r8)
            java.lang.String r0 = e.c.b.e.i.a(r0)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            e.c.b.f.a.c(r0)
        L_0x0399:
            int r0 = e.c.b.d.r
            if (r0 != r7) goto L_0x039e
            goto L_0x03f1
        L_0x039e:
            android.content.SharedPreferences r0 = e.c.b.e.i.k
            if (r0 == 0) goto L_0x03ec
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = e.c.b.e.i.j()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r7 = 0
            int r0 = r0.getInt(r6, r7)
            int r0 = r0 + r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "addCrashUploadCount todayCount: "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            e.c.b.f.a.c(r6)
            android.content.SharedPreferences r6 = e.c.b.e.i.k
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = e.c.b.e.i.j()
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.content.SharedPreferences$Editor r0 = r6.putInt(r5, r0)
            e.c.b.e.i.a(r0, r4)
        L_0x03ec:
            int r0 = e.c.b.d.u
            int r0 = r0 + r4
            e.c.b.d.u = r0
        L_0x03f1:
            android.content.Context r0 = r1.f5939b
            r4 = 0
            e.c.b.g.g.a(r4, r0)
        L_0x03f7:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0425 }
        L_0x03fb:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0425 }
            boolean r0 = f5935c     // Catch:{ Exception -> 0x0425 }
            if (r0 == 0) goto L_0x041b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0425 }
            java.lang.String r8 = "^^ upload finished()! --> cost : "
            r0.<init>(r8)     // Catch:{ Exception -> 0x0425 }
            long r6 = r6 - r4
            r0.append(r6)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r4 = "ms"
            r0.append(r4)     // Catch:{ Exception -> 0x0425 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0425 }
        L_0x0417:
            e.c.b.f.a.b(r0)     // Catch:{ Exception -> 0x0425 }
            goto L_0x0429
        L_0x041b:
            long r6 = r6 - r4
            r8 = 2500(0x9c4, double:1.235E-320)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x03fb
            java.lang.String r0 = "T^T upload timeout!"
            goto L_0x0417
        L_0x0425:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0429:
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.f5938a
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0436
            java.lang.Thread$UncaughtExceptionHandler r0 = r1.f5938a
            r0.uncaughtException(r2, r3)
        L_0x0436:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.g.f.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
