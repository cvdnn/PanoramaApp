package e.c.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.arashivision.insbase.arlog.MultipartUtility;
import com.facebook.stetho.dumpapp.Framer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: d reason: collision with root package name */
    public static final String f5859d = e.a.a.a.a.a(new String(e.c.a.a.a.a.a(new byte[]{77, 122, 65, 121, 77, 84, 73, Framer.EXIT_FRAME_PREFIX, 77, 68, 73, 61})), new String(e.c.a.a.a.a.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61})));

    /* renamed from: e reason: collision with root package name */
    public static c f5860e;

    /* renamed from: a reason: collision with root package name */
    public final Context f5861a;

    /* renamed from: b reason: collision with root package name */
    public int f5862b = 0;

    /* renamed from: c reason: collision with root package name */
    public PublicKey f5863c;

    public class a implements Comparator<C0062b> {
        public a(b bVar) {
        }

        public int compare(Object obj, Object obj2) {
            C0062b bVar = (C0062b) obj;
            C0062b bVar2 = (C0062b) obj2;
            int i2 = bVar2.f5865b - bVar.f5865b;
            if (i2 != 0) {
                return i2;
            }
            if (bVar.f5867d && bVar2.f5867d) {
                return 0;
            }
            if (bVar.f5867d) {
                return -1;
            }
            if (bVar2.f5867d) {
                return 1;
            }
            return i2;
        }
    }

    /* renamed from: e.c.a.a.b.b$b reason: collision with other inner class name */
    public static class C0062b {

        /* renamed from: a reason: collision with root package name */
        public ApplicationInfo f5864a;

        /* renamed from: b reason: collision with root package name */
        public int f5865b = 0;

        /* renamed from: c reason: collision with root package name */
        public boolean f5866c = false;

        /* renamed from: d reason: collision with root package name */
        public boolean f5867d = false;

        public C0062b() {
        }

        public /* synthetic */ C0062b(a aVar) {
        }
    }

    public static class c {

        /* renamed from: a reason: collision with root package name */
        public String f5868a;

        /* renamed from: b reason: collision with root package name */
        public String f5869b;

        /* renamed from: c reason: collision with root package name */
        public int f5870c = 2;

        /* renamed from: d reason: collision with root package name */
        public int f5871d = 0;

        public static c a(String str) {
            String str2;
            String str3;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                String str4 = "0";
                String str5 = str4;
                while (true) {
                    str2 = "dmVy";
                    str3 = "ZGV2aWNlaWQ=";
                    if (!keys.hasNext()) {
                        break;
                    }
                    String str6 = (String) keys.next();
                    if (!b.d(str3).equals(str6)) {
                        if (!b.d(str2).equals(str6)) {
                            str5 = jSONObject.optString(str6, str4);
                        }
                    }
                }
                String string = jSONObject.getString(b.d(str3));
                int i2 = jSONObject.getInt(b.d(str2));
                int length = TextUtils.isEmpty(str5) ? 0 : str5.length();
                if (!TextUtils.isEmpty(string)) {
                    c cVar = new c();
                    cVar.f5868a = string;
                    cVar.f5870c = i2;
                    cVar.f5871d = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        }
                        cVar.f5869b = str4;
                    }
                    return cVar;
                }
            } catch (JSONException e2) {
                b.a((Throwable) e2);
            }
            return null;
        }

        public static /* synthetic */ c a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar = new c();
            cVar.f5868a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            cVar.f5871d = length;
            if (length >= 14) {
                return cVar;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            cVar.f5869b = str2;
            return cVar;
        }

        public String a() {
            try {
                return new JSONObject().put(b.d("ZGV2aWNlaWQ="), this.f5868a).put(b.d("aW1laQ=="), this.f5869b).put(b.d("dmVy"), this.f5870c).toString();
            } catch (JSONException e2) {
                b.a((Throwable) e2);
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[SYNTHETIC, Splitter:B:14:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A[SYNTHETIC, Splitter:B:20:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f5862b = r0
            android.content.Context r4 = r4.getApplicationContext()
            r3.f5861a = r4
            r4 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r1 = 871(0x367, float:1.22E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r1 = {48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, 32, 23, 13, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, 127, 37, -25, -33, 93, 51, -73, 32, -81, 61, 108, 37, 126, 14, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, 35, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, 33, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, 45, 9, 23, 34, 6, 103, 35, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, -128, -12, -108, 98, -29, -27, 60, -119, -74, 110, 61, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, 127, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, 33, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, -110, 12, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, -51, 107, -60, 12, 114, -71, 119, 49, -31, -65, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, -69, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, 33, -126, -103, 35, 115, -83, 99, 110, -39, 110, -125, -118, -69, 87, -103, 30, 12, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, 127, 14, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, 61, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, 63, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, 61, -108, -6, -60, 113, 45, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, -111, 104, -50, -3, -121, -90, -43, 61, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, 14, -56, 21, 47, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, 12, 111, 127, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, 31, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, 13, -117, 35, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56} // fill-array     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x003b, all -> 0x0034 }
            java.lang.String r4 = "X.509"
            java.security.cert.CertificateFactory r4 = java.security.cert.CertificateFactory.getInstance(r4)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            java.security.cert.Certificate r4 = r4.generateCertificate(r0)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            java.security.PublicKey r4 = r4.getPublicKey()     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r3.f5863c = r4     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r0.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0040
        L_0x002d:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0035
        L_0x0032:
            r4 = r0
            goto L_0x003b
        L_0x0034:
            r0 = move-exception
        L_0x0035:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            throw r0
        L_0x003b:
            if (r4 == 0) goto L_0x0040
            r4.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.a.b.b.<init>(android.content.Context):void");
    }

    public static /* synthetic */ void a(Throwable th) {
    }

    public static c c(Context context) {
        if (f5860e == null) {
            synchronized (c.class) {
                if (f5860e == null) {
                    SystemClock.uptimeMillis();
                    f5860e = new b(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f5860e;
    }

    public static /* synthetic */ String d(String str) {
        return new String(e.c.a.a.a.a.a(str.getBytes()));
    }

    public static /* synthetic */ String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return e.c.a.a.a.a.a(a.a.a.a.b.a.b(f5859d, f5859d, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return "";
        }
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(a.a.a.a.b.a.a(f5859d, f5859d, e.c.a.a.a.a.a(str.getBytes())));
        } catch (Exception unused) {
            return "";
        }
    }

    public final String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        int i2 = 0;
        while (i2 < length) {
            try {
                byte[] digest = MessageDigest.getInstance("SHA-1").digest(signatureArr[i2].toByteArray());
                if (digest != null) {
                    String str = "";
                    for (byte b2 : digest) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() == 1) {
                            str = e.a.a.a.a.a(str, "0", hexString);
                        } else {
                            str = e.a.a.a.a.a(str, hexString);
                        }
                    }
                    strArr[i2] = str.toLowerCase();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
                }
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return strArr;
    }

    public final String b(String str) {
        try {
            return System.getString(this.f5861a.getContentResolver(), str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return c(context).f5868a;
    }

    public final synchronized void b(c cVar) {
        new Thread(new c(this, cVar)).start();
    }

    public final c b() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a2 = a(file);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    return c.a(new String(a.a.a.a.b.a.a(f5859d, f5859d, e.c.a.a.a.a.a(a2.getBytes()))));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final c c() {
        String str;
        String str2 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(MultipartUtility.CTRLF);
            }
            bufferedReader.close();
            String[] split = new String(a.a.a.a.b.a.a(f5859d, f5859d, e.c.a.a.a.a.a(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                str = split[0];
                try {
                    str2 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused) {
                }
                return c.a(str2, str);
            }
        } catch (FileNotFoundException | IOException | Exception unused2) {
        }
        str = str2;
        return c.a(str2, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x011f A[Catch:{ NoSuchAlgorithmException -> 0x0122, Exception -> 0x0016 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<e.c.a.a.b.b.C0062b> a(android.content.Intent r14, boolean r15) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.Context r1 = r13.f5861a
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 0
            java.util.List r14 = r1.queryBroadcastReceivers(r14, r2)
            if (r14 == 0) goto L_0x012e
            java.util.Iterator r14 = r14.iterator()
        L_0x0016:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r14.next()
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            android.content.pm.ActivityInfo r4 = r3.activityInfo
            if (r4 == 0) goto L_0x0016
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo
            if (r4 == 0) goto L_0x0016
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ActivityInfo r5 = r3.activityInfo     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ActivityInfo r6 = r3.activityInfo     // Catch:{ Exception -> 0x0016 }
            java.lang.String r6 = r6.name     // Catch:{ Exception -> 0x0016 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0016 }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r4 = r1.getReceiverInfo(r4, r5)     // Catch:{ Exception -> 0x0016 }
            android.os.Bundle r4 = r4.metaData     // Catch:{ Exception -> 0x0016 }
            if (r4 != 0) goto L_0x0042
            goto L_0x0016
        L_0x0042:
            java.lang.String r5 = "galaxy_data"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0016 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0016 }
            if (r6 == 0) goto L_0x004f
            goto L_0x0016
        L_0x004f:
            java.lang.String r6 = "utf-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0016 }
            byte[] r5 = e.c.a.a.a.a.a(r5)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0016 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0016 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0016 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0016 }
            e.c.a.a.b.b$b r6 = new e.c.a.a.b.b$b     // Catch:{ Exception -> 0x0016 }
            r8 = 0
            r6.<init>(r8)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r8 = "priority"
            int r8 = r7.getInt(r8)     // Catch:{ Exception -> 0x0016 }
            r6.f5865b = r8     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ActivityInfo r8 = r3.activityInfo     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo     // Catch:{ Exception -> 0x0016 }
            r6.f5864a = r8     // Catch:{ Exception -> 0x0016 }
            android.content.Context r8 = r13.f5861a     // Catch:{ Exception -> 0x0016 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ActivityInfo r9 = r3.activityInfo     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ApplicationInfo r9 = r9.applicationInfo     // Catch:{ Exception -> 0x0016 }
            java.lang.String r9 = r9.packageName     // Catch:{ Exception -> 0x0016 }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x0016 }
            r9 = 1
            if (r8 == 0) goto L_0x008c
            r6.f5867d = r9     // Catch:{ Exception -> 0x0016 }
        L_0x008c:
            if (r15 == 0) goto L_0x0129
            java.lang.String r8 = "galaxy_sf"
            java.lang.String r4 = r4.getString(r8)     // Catch:{ Exception -> 0x0016 }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0016 }
            if (r8 != 0) goto L_0x0129
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ Exception -> 0x0016 }
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch:{ Exception -> 0x0016 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x0016 }
            r8 = 64
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r8)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r8 = "sigs"
            org.json.JSONArray r7 = r7.getJSONArray(r8)     // Catch:{ Exception -> 0x0016 }
            int r8 = r7.length()     // Catch:{ Exception -> 0x0016 }
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0016 }
            r11 = r2
        L_0x00b3:
            if (r11 >= r8) goto L_0x00be
            java.lang.String r12 = r7.getString(r11)     // Catch:{ Exception -> 0x0016 }
            r10[r11] = r12     // Catch:{ Exception -> 0x0016 }
            int r11 = r11 + 1
            goto L_0x00b3
        L_0x00be:
            android.content.pm.Signature[] r3 = r3.signatures     // Catch:{ Exception -> 0x0016 }
            java.lang.String[] r3 = r13.a(r3)     // Catch:{ Exception -> 0x0016 }
            int r7 = r3.length     // Catch:{ Exception -> 0x0016 }
            if (r8 == r7) goto L_0x00c9
            r3 = r2
            goto L_0x00ee
        L_0x00c9:
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x0016 }
            r7.<init>()     // Catch:{ Exception -> 0x0016 }
            r11 = r2
        L_0x00cf:
            if (r11 >= r8) goto L_0x00d9
            r12 = r10[r11]     // Catch:{ Exception -> 0x0016 }
            r7.add(r12)     // Catch:{ Exception -> 0x0016 }
            int r11 = r11 + 1
            goto L_0x00cf
        L_0x00d9:
            java.util.HashSet r8 = new java.util.HashSet     // Catch:{ Exception -> 0x0016 }
            r8.<init>()     // Catch:{ Exception -> 0x0016 }
            int r10 = r3.length     // Catch:{ Exception -> 0x0016 }
            r11 = r2
        L_0x00e0:
            if (r11 >= r10) goto L_0x00ea
            r12 = r3[r11]     // Catch:{ Exception -> 0x0016 }
            r8.add(r12)     // Catch:{ Exception -> 0x0016 }
            int r11 = r11 + 1
            goto L_0x00e0
        L_0x00ea:
            boolean r3 = r7.equals(r8)     // Catch:{ Exception -> 0x0016 }
        L_0x00ee:
            if (r3 == 0) goto L_0x0129
            byte[] r3 = r4.getBytes()     // Catch:{ Exception -> 0x0016 }
            byte[] r3 = e.c.a.a.a.a.a(r3)     // Catch:{ Exception -> 0x0016 }
            java.security.PublicKey r4 = r13.f5863c     // Catch:{ Exception -> 0x0016 }
            java.lang.String r7 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch:{ Exception -> 0x0016 }
            r8 = 2
            r7.init(r8, r4)     // Catch:{ Exception -> 0x0016 }
            byte[] r3 = r7.doFinal(r3)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = "SHA-1"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0122 }
            byte[] r4 = r4.digest(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0122 }
            if (r3 == 0) goto L_0x011c
            boolean r3 = java.util.Arrays.equals(r3, r4)     // Catch:{ Exception -> 0x0016 }
            if (r3 == 0) goto L_0x011c
            r3 = r9
            goto L_0x011d
        L_0x011c:
            r3 = r2
        L_0x011d:
            if (r3 == 0) goto L_0x0129
            r6.f5866c = r9     // Catch:{ Exception -> 0x0016 }
            goto L_0x0129
        L_0x0122:
            r3 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0016 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0016 }
            throw r4     // Catch:{ Exception -> 0x0016 }
        L_0x0129:
            r0.add(r6)     // Catch:{ Exception -> 0x0016 }
            goto L_0x0016
        L_0x012e:
            e.c.a.a.b.b$a r14 = new e.c.a.a.b.b$a
            r14.<init>(r13)
            java.util.Collections.sort(r0, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.a.b.b.a(android.content.Intent, boolean):java.util.List");
    }

    public static /* synthetic */ void c(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(random.nextInt());
                    sb.append(".tmp");
                    file = new File(parentFile, sb.toString());
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean a(e.c.a.a.b.b r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0048
            java.lang.String r1 = "libcuid.so"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L_0x000f
            r2 = r4
            goto L_0x0010
        L_0x000f:
            r2 = r5
        L_0x0010:
            android.content.Context r3 = r6.f5861a     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            java.io.FileOutputStream r0 = r3.openFileOutput(r1, r2)     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r0.write(r7)     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r0.flush()     // Catch:{ Exception -> 0x0042, all -> 0x003b }
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            if (r2 != 0) goto L_0x0039
            r7 = 436(0x1b4, float:6.11E-43)
            java.io.File r0 = new java.io.File
            android.content.Context r6 = r6.f5861a
            java.io.File r6 = r6.getFilesDir()
            r0.<init>(r6, r1)
            java.lang.String r6 = r0.getAbsolutePath()
            android.system.Os.chmod(r6, r7)     // Catch:{ ErrnoException | Exception -> 0x0047 }
        L_0x0039:
            r4 = r5
            goto L_0x0047
        L_0x003b:
            r6 = move-exception
            if (r0 == 0) goto L_0x0041
            r0.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            throw r6
        L_0x0042:
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{  }
        L_0x0047:
            return r4
        L_0x0048:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.a.b.b.a(e.c.a.a.b.b, java.lang.String):boolean");
    }

    public static /* synthetic */ boolean a(b bVar, String str, String str2) {
        if (bVar != null) {
            try {
                return System.putString(bVar.f5861a.getContentResolver(), str, str2);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    public final boolean a(c cVar) {
        if (cVar.f5871d >= 14) {
            cVar.f5869b = "O";
        } else if (!TextUtils.isEmpty(cVar.f5869b)) {
            return false;
        } else {
            cVar.f5869b = "0";
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028 A[SYNTHETIC, Splitter:B:18:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002f A[SYNTHETIC, Splitter:B:26:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x002c, all -> 0x0025 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x002c, all -> 0x0025 }
            r5 = 8192(0x2000, float:1.14794E-41)
            char[] r5 = new char[r5]     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
            r2.<init>()     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
        L_0x000f:
            int r3 = r1.read(r5)     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x002d, all -> 0x0022 }
            r1.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            return r5
        L_0x0022:
            r5 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0025:
            r5 = move-exception
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            throw r5
        L_0x002c:
            r1 = r0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.a.b.b.a(java.io.File):java.lang.String");
    }

    public static String a(Context context) {
        c c2 = c(context);
        String str = c2.f5869b;
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c2.f5868a);
        sb.append("|");
        sb.append(str);
        return sb.toString();
    }

    public final c a() {
        boolean z;
        boolean z2;
        String str = "com.baidu.intent.action.GALAXY";
        ArrayList arrayList = (ArrayList) a(new Intent(str).setPackage(this.f5861a.getPackageName()), true);
        String str2 = "DeviceId";
        if (arrayList.size() == 0) {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w(str2, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            z = ((C0062b) arrayList.get(0)).f5866c;
            if (!z) {
                for (int i3 = 0; i3 < 3; i3++) {
                    Log.w(str2, "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        String str3 = "libcuid.so";
        File file = new File(this.f5861a.getFilesDir(), str3);
        String str4 = null;
        c a2 = file.exists() ? c.a(f(a(file))) : null;
        if (a2 == null) {
            this.f5862b |= 16;
            List a3 = a(new Intent(str), z);
            String str5 = "files";
            File filesDir = this.f5861a.getFilesDir();
            if (!str5.equals(filesDir.getName())) {
                StringBuilder a4 = e.a.a.a.a.a("fetal error:: app files dir name is unexpectedly :: ");
                a4.append(filesDir.getAbsolutePath());
                Log.e(str2, a4.toString());
                str5 = filesDir.getName();
            }
            Iterator it = ((ArrayList) a3).iterator();
            while (it.hasNext()) {
                C0062b bVar = (C0062b) it.next();
                if (!bVar.f5867d) {
                    File file2 = new File(new File(bVar.f5864a.dataDir, str5), str3);
                    if (file2.exists()) {
                        a2 = c.a(f(a(file2)));
                        if (a2 != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (a2 == null) {
            a2 = c.a(f(b("com.baidu.deviceid.v2")));
        }
        boolean a5 = a("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && a5) {
            this.f5862b |= 2;
            a2 = b();
        }
        if (a2 == null) {
            this.f5862b |= 8;
            a2 = c.a(b("com.baidu.deviceid"), b("bd_setting_i"));
        }
        String str6 = "0";
        if (a2 != null || !a5) {
            z2 = false;
        } else {
            this.f5862b |= 1;
            a2 = c();
            str4 = str6;
            z2 = true;
        }
        if (a2 == null) {
            this.f5862b |= 4;
            if (!z2) {
                str4 = str6;
            }
            a2 = new c();
            String string = Secure.getString(this.f5861a.getContentResolver(), "android_id");
            String str7 = "";
            if (TextUtils.isEmpty(string)) {
                string = str7;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("com.baidu");
            sb.append(string);
            byte[] bytes = sb.toString().getBytes();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bytes);
                byte[] digest = instance.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                    if (upperCase.length() == 1) {
                        sb2.append(str6);
                    }
                    sb2.append(upperCase);
                    sb2.append(str7);
                }
                a2.f5868a = sb2.toString();
                a2.f5869b = str4;
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        a(a2);
        b(a2);
        return a2;
    }

    public final boolean a(String str) {
        return this.f5861a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
