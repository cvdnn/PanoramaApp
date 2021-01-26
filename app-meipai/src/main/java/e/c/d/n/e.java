package e.c.d.n;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.picapture.App;
import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.LocalTaskDao.Properties;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidu.sapi2.utils.h;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import e.c.b.e.Utils;
import e.c.e.a.b;
import e.c.e.a.f;
import e.c.f.c;
import e.c.f.d.a;
import e.c.f.f.d;
import e.c.f.f.g;
import e.g.b.j;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: PathUtils */
public class e {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr4 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[i2] = 0;
            }
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr4));
            byte[] doFinal = instance.doFinal(bArr2);
            if (bArr2 != null && bArr2.length > 0) {
                try {
                    bArr3 = MessageDigest.getInstance("MD5").digest(bArr2);
                } catch (Throwable unused) {
                }
                byte[] bArr5 = new byte[(doFinal.length + bArr3.length)];
                System.arraycopy(doFinal, 0, bArr5, 0, doFinal.length);
                System.arraycopy(bArr3, 0, bArr5, doFinal.length, bArr3.length);
                return bArr5;
            }
            bArr3 = null;
            byte[] bArr52 = new byte[(doFinal.length + bArr3.length)];
            System.arraycopy(doFinal, 0, bArr52, 0, doFinal.length);
            System.arraycopy(bArr3, 0, bArr52, doFinal.length, bArr3.length);
            return bArr52;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r6, byte[] r7) {
        /*
            r0 = 0
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "AES"
            r1.<init>(r6, r2)     // Catch:{ all -> 0x004c }
            java.lang.String r6 = "AES/CBC/PKCS7Padding"
            javax.crypto.Cipher r6 = javax.crypto.Cipher.getInstance(r6)     // Catch:{ all -> 0x004c }
            r2 = 16
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x004c }
            r4 = 0
            r5 = r4
        L_0x0014:
            if (r5 >= r2) goto L_0x001b
            r3[r5] = r4     // Catch:{ all -> 0x004c }
            int r5 = r5 + 1
            goto L_0x0014
        L_0x001b:
            javax.crypto.spec.IvParameterSpec r2 = new javax.crypto.spec.IvParameterSpec     // Catch:{ all -> 0x004c }
            r2.<init>(r3)     // Catch:{ all -> 0x004c }
            r3 = 1
            r6.init(r3, r1, r2)     // Catch:{ all -> 0x004c }
            byte[] r6 = r6.doFinal(r7)     // Catch:{ all -> 0x004c }
            if (r7 == 0) goto L_0x003c
            int r1 = r7.length     // Catch:{ all -> 0x004c }
            if (r1 > 0) goto L_0x002e
            goto L_0x003c
        L_0x002e:
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ all -> 0x0039 }
            byte[] r7 = r1.digest(r7)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            e.c.f.c.d()     // Catch:{ all -> 0x004c }
        L_0x003c:
            r7 = r0
        L_0x003d:
            int r1 = r6.length     // Catch:{ all -> 0x004c }
            int r2 = r7.length     // Catch:{ all -> 0x004c }
            int r1 = r1 + r2
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x004c }
            int r2 = r6.length     // Catch:{ all -> 0x004c }
            java.lang.System.arraycopy(r6, r4, r1, r4, r2)     // Catch:{ all -> 0x004c }
            int r6 = r6.length     // Catch:{ all -> 0x004c }
            int r2 = r7.length     // Catch:{ all -> 0x004c }
            java.lang.System.arraycopy(r7, r4, r1, r6, r2)     // Catch:{ all -> 0x004c }
            return r1
        L_0x004c:
            e.c.f.c.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.n.e.b(byte[], byte[]):byte[]");
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(b());
        sb.append("/pano");
        return sb.toString();
    }

    public static String d(String str) {
        String sb;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (!m(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf);
            str = str.substring(0, lastIndexOf);
        }
        int i2 = 1;
        do {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("的副本");
            sb2.append(i2);
            sb2.append(str2);
            sb = sb2.toString();
            i2++;
        } while (m(sb));
        return sb;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] bArr4 = new byte[(bArr2.length - 16)];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
            return instance.doFinal(bArr4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr2);
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    public static List<HotSpot> f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j(str));
        sb.append("/hotspots/config.json");
        String o = Utils.o(sb.toString());
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        return (List) new j().a(o, new f().getType());
    }

    public static SharedPreferences g() {
        return App.f1954b.getSharedPreferences("PICAPTURE", 0);
    }

    public static SharedPreferences h() {
        String str = e.c.d.d.c.e.f6006d.f6009c;
        if (TextUtils.isEmpty(str)) {
            return g();
        }
        App app = App.f1954b;
        StringBuilder sb = new StringBuilder();
        sb.append("PICAPTURE_");
        sb.append(str);
        return app.getSharedPreferences(sb.toString(), 0);
    }

    public static File[] i(String str) {
        File file = new File(k(str));
        File[] fileArr = new File[0];
        if (!file.exists() || !file.isDirectory()) {
            return fileArr;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles, b.f6873a);
        return listFiles;
    }

    public static String j(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b());
        sb2.append("/tasks");
        sb.append(sb2.toString());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(str);
        return sb.toString();
    }

    public static String k(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j(str));
        sb.append("/spin_360_scene");
        return sb.toString();
    }

    public static String l(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j(str));
        sb.append(".zip");
        return sb.toString();
    }

    public static boolean m(String str) {
        return new File(str).exists();
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("DCIM")) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b());
            sb2.append("/download");
            sb.append(sb2.toString());
            sb.append(BceConfig.BOS_DELIMITER);
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
        sb3.append(str.substring(4));
        return sb3.toString();
    }

    public static void c(String str) {
        Utils.d(j(str));
        Utils.d(l(str));
    }

    public static void a(Context context) {
        try {
            a a2 = a.a(context);
            d a3 = d.a(context);
            c.a();
            Iterator it = ((ArrayList) a2.a()).iterator();
            while (it.hasNext()) {
                ApkInfo apkInfo = (ApkInfo) it.next();
                if (apkInfo.duration != 0 && apkInfo.startTime + ((long) (apkInfo.duration * 60 * 1000)) < System.currentTimeMillis()) {
                    a3.a(apkInfo.packageName);
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(str);
        sb.append(".jpg");
        return sb.toString();
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr3[i2] = (byte) i2;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr2[i3] & 255) + (bArr3[i5] & 255) + i4) & 255;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i4];
                bArr3[i4] = b2;
                i3 = (i3 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i6 = 0;
        byte b3 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i6 = (i6 + 1) & 255;
            b3 = ((bArr3[i6] & 255) + b3) & 255;
            byte b4 = bArr3[i6];
            bArr3[i6] = bArr3[b3];
            bArr3[b3] = b4;
            int i8 = ((bArr3[i6] & 255) + (bArr3[b3] & 255)) & 255;
            bArr4[i7] = (byte) (bArr3[i8] ^ bArr[i7]);
            bArr4[i7] = (byte) (bArr4[i7] ^ 42);
        }
        return bArr4;
    }

    public static boolean f() {
        return a("is_capture_manual", true);
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(str);
        sb.append("_thumb.jpg");
        return sb.toString();
    }

    public static String d() {
        return b("app_language", false);
    }

    public static String e(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(BceConfig.BOS_DELIMITER);
        if (lastIndexOf == -1) {
            return trim;
        }
        if (lastIndexOf == trim.length() - 1) {
            return str2;
        }
        return trim.substring(lastIndexOf + 1);
    }

    public static long a(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public static String e() {
        return e.a.a.a.a.a("file:///android_asset/webcache/", LanguageUtils.isChineseLanguage() ? "userGuide.html" : "userGuide-en.html");
    }

    public static void a(Context context, Intent intent) {
        try {
            String[] e2 = e.c.f.n.a.e(context);
            StringBuilder sb = new StringBuilder();
            sb.append(e2[0]);
            sb.append(" : ");
            sb.append(e2[1]);
            c.a();
            e.c.f.f.e.a(context, 0, e2[0], e2[1], 100028);
            int i2 = 0;
            while (true) {
                Thread.sleep(500);
                i2++;
                new StringBuilder().append(i2);
                if (i2 > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", e2[0]);
                    e.c.f.n.a.a(context.getApplicationContext(), "1014115", (Map<String, Object>) hashMap);
                    new StringBuilder().append(hashMap.toString());
                    break;
                }
                g gVar = g.f6978g;
                if (gVar != null) {
                    if (gVar.c("com.baidu.sofire.x24") != null) {
                        break;
                    }
                }
            }
            e.c.f.f.e.a(100028, "onReceiveAwakeMessage", (Callback) new e.c.f.a(), (Class<?>[]) new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable unused) {
            c.a();
            c.d();
        }
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/Picapture");
        return sb.toString();
    }

    public static String b(Context context) {
        String str = "app_language";
        if (context != null) {
            return context.getSharedPreferences("PICAPTURE", 0).getString(str, null);
        }
        return b(str, false);
    }

    public static void b(Activity activity, b bVar) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            if (bVar != null) {
                bVar.onTranslucent(false);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.onTranslucent(true);
            }
            th.printStackTrace();
        }
    }

    public static String b(String str, boolean z) {
        if (z) {
            return h().getString(str, null);
        }
        return g().getString(str, null);
    }

    public static void b(String str, boolean z, boolean z2) {
        if (z2) {
            h().edit().putBoolean(str, z).apply();
        } else {
            g().edit().putBoolean(str, z).apply();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083 A[LOOP:0: B:15:0x0081->B:16:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d5 A[Catch:{ all -> 0x0269 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ec A[SYNTHETIC, Splitter:B:59:0x01ec] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0246 A[Catch:{ all -> 0x0269 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r17, java.lang.String r18, java.lang.String r19, boolean r20) throws java.lang.Throwable {
        /*
            r1 = r17
            java.lang.String r2 = "pu_cl_fd"
            java.lang.String[] r0 = e.c.f.n.a.e(r17)
            r3 = 0
            r4 = r0[r3]
            r5 = 1
            r6 = r0[r5]
            java.lang.String r0 = r17.getPackageName()
            java.lang.String r7 = "com.baidu.input_huawei"
            boolean r0 = r7.equals(r0)
            r7 = 4
            java.lang.String r9 = "re_po_rt"
            java.lang.String r10 = "leroadcfg"
            if (r0 == 0) goto L_0x0050
            android.content.SharedPreferences r11 = r1.getSharedPreferences(r10, r7)     // Catch:{ all -> 0x0037 }
            r11.edit()     // Catch:{ all -> 0x0035 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r10, r7)     // Catch:{ all -> 0x0035 }
            r0.edit()     // Catch:{ all -> 0x0035 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r7)     // Catch:{ all -> 0x0035 }
            r0.edit()     // Catch:{ all -> 0x0035 }
            goto L_0x003f
        L_0x0035:
            r0 = move-exception
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r11 = 0
        L_0x0039:
            r0.getMessage()
            e.c.f.c.c()
        L_0x003f:
            java.lang.String r0 = "s_c_c"
            boolean r0 = r11.getBoolean(r0, r5)
            if (r0 == 0) goto L_0x0048
            goto L_0x0050
        L_0x0048:
            android.accounts.NetworkErrorException r0 = new android.accounts.NetworkErrorException
            java.lang.String r1 = "conn is blocked"
            r0.<init>(r1)
            throw r0
        L_0x0050:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r11 = r0.getTime()
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 / r13
            java.lang.String r0 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            r11.append(r0)
            r11.append(r6)
            java.lang.String r6 = r11.toString()
            java.lang.String r6 = e.c.f.n.h.a(r6)
            java.lang.String r11 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            char[] r11 = r11.toCharArray()
            r12 = 16
            char[] r13 = new char[r12]
            r14 = r3
        L_0x0081:
            if (r14 >= r12) goto L_0x0095
            java.util.Random r15 = new java.util.Random
            r15.<init>()
            r8 = 62
            int r8 = r15.nextInt(r8)
            char r8 = r11[r8]
            r13[r14] = r8
            int r14 = r14 + 1
            goto L_0x0081
        L_0x0095:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r13)
            byte[] r8 = r8.getBytes()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = new java.lang.String
            r12.<init>(r8)
            r11.append(r12)
            e.c.f.c.a()
            boolean r11 = android.text.TextUtils.isEmpty(r19)
            java.lang.String r12 = ""
            if (r11 != 0) goto L_0x0102
            byte[] r11 = r19.getBytes()
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream
            r13.<init>(r11)
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream
            r11.<init>()
            java.util.zip.GZIPOutputStream r14 = new java.util.zip.GZIPOutputStream
            r14.<init>(r11)
            r15 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r15]
        L_0x00cd:
            int r7 = r13.read(r5, r3, r15)
            r15 = -1
            if (r7 == r15) goto L_0x00da
            r14.write(r5, r3, r7)
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x00cd
        L_0x00da:
            r14.flush()
            r14.finish()
            r14.close()
            byte[] r5 = r11.toByteArray()
            r11.flush()
            r11.close()
            r13.close()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r11 = r5.length
            r7.append(r11)
            com.baidu.sofire.ac.F r7 = com.baidu.sofire.ac.F.getInstance()
            byte[] r5 = r7.ae(r5, r8)
            goto L_0x0106
        L_0x0102:
            byte[] r5 = r12.getBytes()
        L_0x0106:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r11 = r5.length
            r7.append(r11)
            java.lang.String r11 = ","
            r7.append(r11)
            java.lang.String r11 = new java.lang.String
            r11.<init>(r5)
            r7.append(r11)
            java.lang.String r7 = e.c.f.n.c.b(r17)
            java.lang.String r7 = e.c.f.n.h.a(r7)
            byte[] r7 = r7.getBytes()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            if (r7 != 0) goto L_0x0131
            r13 = r3
            goto L_0x0132
        L_0x0131:
            int r13 = r7.length
        L_0x0132:
            r11.append(r13)
            com.baidu.sofire.ac.F r11 = com.baidu.sofire.ac.F.getInstance()
            byte[] r8 = r11.re(r8, r7)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r13 = r8.length
            r11.append(r13)
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r3)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r13 = r18
            r11.append(r13)
            java.lang.String r13 = "/100/"
            r11.append(r13)
            r11.append(r4)
            java.lang.String r4 = "/"
            r11.append(r4)
            r11.append(r0)
            r11.append(r4)
            r11.append(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = "?skey="
            r11.append(r0)
            java.lang.String r0 = "utf-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r8, r0)
            r11.append(r0)
        L_0x0186:
            e.c.f.n.g r0 = new e.c.f.n.g     // Catch:{ all -> 0x0193 }
            r0.<init>(r1)     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r11.toString()     // Catch:{ all -> 0x0193 }
            java.lang.String r12 = r0.a(r4, r5)     // Catch:{ all -> 0x0193 }
        L_0x0193:
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            java.lang.String r6 = "0"
            r13 = 0
            if (r20 == 0) goto L_0x0271
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0271
            r7 = 4
            android.content.SharedPreferences r8 = r1.getSharedPreferences(r10, r7)     // Catch:{ all -> 0x01c0 }
            android.content.SharedPreferences$Editor r11 = r8.edit()     // Catch:{ all -> 0x01be }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r10, r7)     // Catch:{ all -> 0x01ba }
            r0.edit()     // Catch:{ all -> 0x01ba }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r7)     // Catch:{ all -> 0x01ba }
            r0.edit()     // Catch:{ all -> 0x01ba }
            goto L_0x01c9
        L_0x01ba:
            r0 = move-exception
            r16 = r11
            goto L_0x01c4
        L_0x01be:
            r0 = move-exception
            goto L_0x01c2
        L_0x01c0:
            r0 = move-exception
            r8 = 0
        L_0x01c2:
            r16 = 0
        L_0x01c4:
            r0.getMessage()     // Catch:{ all -> 0x0269 }
            r11 = r16
        L_0x01c9:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0269 }
            long r15 = r8.getLong(r2, r13)     // Catch:{ all -> 0x0269 }
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x01e3
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0269 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0269 }
            r11.putLong(r2, r12)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
        L_0x01e3:
            long r9 = r9 - r15
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            java.lang.String r4 = "wi_fa_pu_cl"
            java.lang.String r5 = "mo_fa_pu_cl"
            if (r0 <= 0) goto L_0x0246
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0269 }
            r0.<init>()     // Catch:{ all -> 0x0269 }
            boolean r7 = e.c.f.n.a.c(r17)     // Catch:{ all -> 0x0269 }
            java.lang.String r9 = "1"
            if (r7 == 0) goto L_0x0212
            int r7 = r8.getInt(r4, r3)     // Catch:{ all -> 0x0269 }
            r10 = 1
            int r7 = r7 + r10
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0269 }
            r0.put(r6, r7)     // Catch:{ all -> 0x0269 }
            int r6 = r8.getInt(r5, r3)     // Catch:{ all -> 0x0269 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0269 }
            r0.put(r9, r6)     // Catch:{ all -> 0x0269 }
            goto L_0x022a
        L_0x0212:
            int r7 = r8.getInt(r4, r3)     // Catch:{ all -> 0x0269 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0269 }
            r0.put(r6, r7)     // Catch:{ all -> 0x0269 }
            int r6 = r8.getInt(r5, r3)     // Catch:{ all -> 0x0269 }
            r7 = 1
            int r6 = r6 + r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0269 }
            r0.put(r9, r6)     // Catch:{ all -> 0x0269 }
        L_0x022a:
            r11.putInt(r5, r3)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
            r11.putInt(r4, r3)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0269 }
            r11.putLong(r2, r3)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
            java.lang.String r2 = "1003112"
            e.c.f.n.a.a(r1, r2, r0)     // Catch:{ all -> 0x0269 }
            goto L_0x0269
        L_0x0246:
            boolean r0 = e.c.f.n.a.c(r17)     // Catch:{ all -> 0x0269 }
            if (r0 == 0) goto L_0x025b
            int r0 = r8.getInt(r4, r3)     // Catch:{ all -> 0x0269 }
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r1 = "wi_fa_pu_ap"
            r11.putInt(r1, r0)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
            goto L_0x0269
        L_0x025b:
            int r0 = r8.getInt(r5, r3)     // Catch:{ all -> 0x0269 }
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r1 = "mo_fa_pu_ap"
            r11.putInt(r1, r0)     // Catch:{ all -> 0x0269 }
            r11.commit()     // Catch:{ all -> 0x0269 }
        L_0x0269:
            android.accounts.NetworkErrorException r0 = new android.accounts.NetworkErrorException
            java.lang.String r1 = "response is empty"
            r0.<init>(r1)
            throw r0
        L_0x0271:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r12)
            java.lang.String r2 = "skey"
            java.lang.String r2 = r0.optString(r2)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            byte[] r2 = android.util.Base64.decode(r2, r3)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r11 = r2.length
            r8.append(r11)
            com.baidu.sofire.ac.F r8 = com.baidu.sofire.ac.F.getInstance()
            byte[] r2 = r8.rd(r2, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "null"
            if (r2 != 0) goto L_0x02a4
            r11 = r8
            goto L_0x02b1
        L_0x02a4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r12 = r2.length
            r11.append(r12)
            java.lang.String r11 = r11.toString()
        L_0x02b1:
            r7.append(r11)
            java.lang.String r7 = "response"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r11 = "request_id"
            java.lang.String r0 = r0.optString(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            byte[] r0 = android.util.Base64.decode(r7, r3)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            if (r0 != 0) goto L_0x02dc
            goto L_0x02e9
        L_0x02dc:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r11 = r0.length
            r8.append(r11)
            java.lang.String r8 = r8.toString()
        L_0x02e9:
            r7.append(r8)
            com.baidu.sofire.ac.F r7 = com.baidu.sofire.ac.F.getInstance()
            byte[] r2 = r7.ad(r0, r2)
            if (r0 == 0) goto L_0x0387
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0387
            if (r2 == 0) goto L_0x02fe
            int r0 = r2.length
            if (r0 != 0) goto L_0x0387
        L_0x02fe:
            r2 = 4
            android.content.SharedPreferences r7 = r1.getSharedPreferences(r10, r2)     // Catch:{ all -> 0x031e }
            android.content.SharedPreferences$Editor r8 = r7.edit()     // Catch:{ all -> 0x0318 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r10, r2)     // Catch:{ all -> 0x0316 }
            r0.edit()     // Catch:{ all -> 0x0316 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x0316 }
            r0.edit()     // Catch:{ all -> 0x0316 }
            goto L_0x0328
        L_0x0316:
            r0 = move-exception
            goto L_0x031a
        L_0x0318:
            r0 = move-exception
            r8 = 0
        L_0x031a:
            r16 = r8
            r8 = r7
            goto L_0x0322
        L_0x031e:
            r0 = move-exception
            r8 = 0
            r16 = 0
        L_0x0322:
            r0.getMessage()
            r7 = r8
            r8 = r16
        L_0x0328:
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = "se_ae_fd"
            long r11 = r7.getLong(r0, r13)
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0344
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = java.lang.System.currentTimeMillis()
            r8.putLong(r0, r13)
            r8.commit()
        L_0x0344:
            long r9 = r9 - r11
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            java.lang.String r4 = "mo_ae_fa_ct"
            if (r2 <= 0) goto L_0x0373
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            int r5 = r7.getInt(r4, r3)
            r7 = 1
            int r5 = r5 + r7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.put(r6, r5)
            r8.putInt(r4, r3)
            r8.commit()
            long r3 = java.lang.System.currentTimeMillis()
            r8.putLong(r0, r3)
            r8.commit()
            java.lang.String r0 = "1003119"
            e.c.f.n.a.a(r1, r0, r2)
            goto L_0x037f
        L_0x0373:
            int r0 = r7.getInt(r4, r3)
            r1 = 1
            int r0 = r0 + r1
            r8.putInt(r4, r0)
            r8.commit()
        L_0x037f:
            android.accounts.NetworkErrorException r0 = new android.accounts.NetworkErrorException
            java.lang.String r1 = "aes is fail"
            r0.<init>(r1)
            throw r0
        L_0x0387:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.n.e.a(android.content.Context, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static void a(Context context, int i2, boolean z) {
        AlarmManager alarmManager;
        PendingIntent service;
        long currentTimeMillis;
        try {
            alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
            intent.setClass(context, MyService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.SOFIRE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 2);
            service = PendingIntent.getService(context, 1001, intent, 134217728);
            long j2 = 600000;
            if (i2 == 0) {
                j2 = StatisticConfig.MIN_UPLOAD_INTERVAL;
            } else if (i2 == 1) {
                j2 = 180000;
            } else if (i2 == 2) {
                j2 = 300000;
            }
            currentTimeMillis = System.currentTimeMillis() + j2;
            StringBuilder sb = new StringBuilder("n=");
            sb.append(currentTimeMillis);
            sb.append(", c=");
            sb.append(System.currentTimeMillis());
            c.a();
            alarmManager.cancel(service);
        } catch (Throwable unused) {
            c.d();
            return;
        }
        if (!z) {
            try {
                alarmManager.set(0, currentTimeMillis, service);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static void a(String str, List<HotSpot> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(j(str));
        sb.append("/hotspots/config.json");
        Utils.write(sb.toString(), new j().a((Object) list));
    }

    public static boolean a(String str, boolean z) {
        return a(str, false, z);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[(bArr2.length - 16)];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return instance.doFinal(bArr2);
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    public static boolean a(String str, boolean z, boolean z2) {
        if (z2) {
            return h().getBoolean(str, z);
        }
        return g().getBoolean(str, z);
    }

    public static void a(Activity activity, b bVar) {
        Class[] declaredClasses;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class cls = null;
            for (Class cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Object newProxyInstance = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{cls}, new f(bVar));
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, new Object[]{newProxyInstance, invoke});
        } catch (Throwable unused) {
            if (bVar != null) {
                bVar.onTranslucent(false);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0056 A[SYNTHETIC, Splitter:B:34:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A[SYNTHETIC, Splitter:B:38:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.io.File r7, java.io.File r8, byte[] r9) {
        /*
            r0 = -1
            if (r7 == 0) goto L_0x006b
            boolean r1 = r7.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x006b
        L_0x000a:
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0050 }
            r3.<init>(r7)     // Catch:{ all -> 0x0050 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x004d }
            r7.<init>(r8)     // Catch:{ all -> 0x004d }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r8]     // Catch:{ all -> 0x004e }
        L_0x001a:
            int r4 = r3.read(r1)     // Catch:{ all -> 0x004e }
            if (r4 == r0) goto L_0x0045
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r5.<init>()     // Catch:{ all -> 0x004e }
            r5.append(r4)     // Catch:{ all -> 0x004e }
            e.c.f.c.a()     // Catch:{ all -> 0x004e }
            if (r4 >= r8) goto L_0x0033
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x004e }
            java.lang.System.arraycopy(r1, r2, r5, r2, r4)     // Catch:{ all -> 0x004e }
            goto L_0x0034
        L_0x0033:
            r5 = r1
        L_0x0034:
            byte[] r4 = a(r9, r5, r2)     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r5.<init>()     // Catch:{ all -> 0x004e }
            int r6 = r4.length     // Catch:{ all -> 0x004e }
            r5.append(r6)     // Catch:{ all -> 0x004e }
            r7.write(r4)     // Catch:{ all -> 0x004e }
            goto L_0x001a
        L_0x0045:
            r3.close()     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r7.close()     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = r2
            goto L_0x005e
        L_0x004d:
            r7 = r1
        L_0x004e:
            r1 = r3
            goto L_0x0051
        L_0x0050:
            r7 = r1
        L_0x0051:
            e.c.f.c.d()     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ all -> 0x0059 }
        L_0x0059:
            if (r7 == 0) goto L_0x005e
            r7.close()     // Catch:{ all -> 0x005e }
        L_0x005e:
            return r0
        L_0x005f:
            r8 = move-exception
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ all -> 0x0065 }
        L_0x0065:
            if (r7 == 0) goto L_0x006a
            r7.close()     // Catch:{ all -> 0x006a }
        L_0x006a:
            throw r8
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.n.e.a(java.io.File, java.io.File, byte[]):int");
    }

    public static String a(String str, String str2) {
        return String.format("%s/packages/%s/uploaded/%s", new Object[]{"penglai", str, e.a.a.a.a.a(str2, ".zip")});
    }

    public static /* synthetic */ String a(g gVar, int i2, int[] iArr, String str) {
        if (!(gVar == null || i2 == 0)) {
            iArr[0] = iArr[0] + 1;
            gVar.a((iArr[0] * 100) / i2);
        }
        return str;
    }

    public static void a() {
        LocalTaskDao a2 = e.c.d.f.b.b.b().a();
        if (a2 != null) {
            Utils.b.b.j.f fVar = new Utils.b.b.j.f(a2);
            fVar.a(" ASC", Properties.CreateTime);
            List<e.c.d.f.d.c> a3 = fVar.a();
            HashSet hashSet = new HashSet();
            if (!a3.isEmpty()) {
                for (e.c.d.f.d.c cVar : a3) {
                    if (cVar.f6077f < 1000) {
                        hashSet.add(cVar.f6072a);
                        StringBuilder sb = new StringBuilder();
                        sb.append(cVar.f6072a);
                        sb.append(".zip");
                        hashSet.add(sb.toString());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b());
            sb2.append("/tasks");
            File[] f2 = Utils.f(sb2.toString());
            if (f2 != null && f2.length > 0) {
                for (File file : f2) {
                    if (!hashSet.contains(file.getName()) && file.exists()) {
                        Utils.a(file);
                    }
                }
                return;
            }
            return;
        }
        throw null;
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher instance = Cipher.getInstance(h.p);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            String str = "";
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append(str);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
