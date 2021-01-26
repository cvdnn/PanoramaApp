package e.c.f.n;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.arashivision.insbase.arlog.MultipartUtility;
import com.baidubce.BceConfig;
import com.facebook.stetho.dumpapp.Framer;
import e.c.f.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* compiled from: GdUtil */
public final class e {

    /* renamed from: b reason: collision with root package name */
    public static final String f7052b = new String(a.a(new byte[]{77, 122, 65, 121, 77, 84, 73, Framer.EXIT_FRAME_PREFIX, 77, 68, 73, 61}));

    /* renamed from: c reason: collision with root package name */
    public static final String f7053c = new String(a.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));

    /* renamed from: d reason: collision with root package name */
    public static final String f7054d;

    /* renamed from: e reason: collision with root package name */
    public static b f7055e;

    /* renamed from: a reason: collision with root package name */
    public Context f7056a;

    /* compiled from: GdUtil */
    public static class a {
        public static byte[] a(byte[] bArr) {
            byte b2;
            int i2;
            byte[] bArr2 = bArr;
            int length = bArr2.length;
            int i3 = (length / 4) * 3;
            if (i3 == 0) {
                return new byte[0];
            }
            byte[] bArr3 = new byte[i3];
            int i4 = 0;
            while (true) {
                byte b3 = bArr2[length - 1];
                b2 = 10;
                if (!(b3 == 10 || b3 == 13 || b3 == 32 || b3 == 9)) {
                    if (b3 != 61) {
                        break;
                    }
                    i4++;
                }
                length--;
            }
            int i5 = 0;
            byte b4 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length) {
                byte b5 = bArr2[i5];
                if (!(b5 == b2 || b5 == 13 || b5 == 32 || b5 == 9)) {
                    if (b5 >= 65 && b5 <= 90) {
                        i2 = b5 - 65;
                    } else if (b5 >= 97 && b5 <= 122) {
                        i2 = b5 - 71;
                    } else if (b5 >= 48 && b5 <= 57) {
                        i2 = b5 + 4;
                    } else if (b5 == 43) {
                        i2 = 62;
                    } else if (b5 != 47) {
                        return null;
                    } else {
                        i2 = 63;
                    }
                    b4 = (b4 << 6) | ((byte) i2);
                    if (i7 % 4 == 3) {
                        int i8 = i6 + 1;
                        bArr3[i6] = (byte) ((b4 & 16711680) >> 16);
                        int i9 = i8 + 1;
                        bArr3[i8] = (byte) ((b4 & 65280) >> 8);
                        int i10 = i9 + 1;
                        bArr3[i9] = (byte) (b4 & 255);
                        i6 = i10;
                    }
                    i7++;
                }
                i5++;
                b2 = 10;
            }
            if (i4 > 0) {
                int i11 = b4 << (i4 * 6);
                int i12 = i6 + 1;
                bArr3[i6] = (byte) ((i11 & 16711680) >> 16);
                if (i4 == 1) {
                    i6 = i12 + 1;
                    bArr3[i12] = (byte) ((i11 & 65280) >> 8);
                } else {
                    i6 = i12;
                }
            }
            byte[] bArr4 = new byte[i6];
            System.arraycopy(bArr3, 0, bArr4, 0, i6);
            return bArr4;
        }
    }

    /* compiled from: GdUtil */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f7057a;

        /* renamed from: b reason: collision with root package name */
        public String f7058b;

        public b() {
        }

        public static b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                if (!TextUtils.isEmpty(string)) {
                    if (string2 != null) {
                        b bVar = new b();
                        bVar.f7057a = string;
                        bVar.f7058b = string2;
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable unused) {
                c.d();
                return null;
            }
        }

        public /* synthetic */ b(byte b2) {
        }

        public final String a() {
            try {
                String str = this.f7058b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                String stringBuffer = new StringBuffer(str).reverse().toString();
                StringBuilder sb = new StringBuilder();
                sb.append(this.f7057a);
                sb.append("|");
                sb.append(stringBuffer);
                return sb.toString();
            } catch (Throwable unused) {
                c.d();
                return null;
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f7052b);
        sb.append(f7053c);
        f7054d = sb.toString();
    }

    public e(Context context) {
        this.f7056a = context;
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (e.class) {
            if (f7055e == null) {
                f7055e = new e(context).a();
            }
            bVar = f7055e;
        }
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0053 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e.c.f.n.e.b c() {
        /*
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0057 }
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r2.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J"
            java.lang.String r3 = e.c.f.n.a.f(r3)     // Catch:{ all -> 0x0057 }
            r2.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU="
            java.lang.String r3 = e.c.f.n.a.f(r3)     // Catch:{ all -> 0x0057 }
            r2.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0057 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0057 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x005a
            java.lang.String r0 = a(r0)     // Catch:{ all -> 0x0057 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x005a
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = f7054d     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = f7054d     // Catch:{ all -> 0x0053 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0053 }
            byte[] r0 = e.c.f.n.e.a.a(r0)     // Catch:{ all -> 0x0053 }
            byte[] r0 = e.c.d.n.e.a(r2, r3, r0)     // Catch:{ all -> 0x0053 }
            r1.<init>(r0)     // Catch:{ all -> 0x0053 }
            e.c.f.n.e$b r0 = e.c.f.n.e.b.a(r1)     // Catch:{ all -> 0x0053 }
            return r0
        L_0x0053:
            e.c.f.c.d()     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            e.c.f.c.d()
        L_0x005a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.e.c():e.c.f.n.e$b");
    }

    public final String a(String str) {
        try {
            return System.getString(this.f7056a.getContentResolver(), str);
        } catch (Throwable unused) {
            c.d();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r1 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003b, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0026 }
            r1.<init>(r5)     // Catch:{ all -> 0x0026 }
            r5 = 8192(0x2000, float:1.14794E-41)
            char[] r5 = new char[r5]     // Catch:{ all -> 0x0027 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ all -> 0x0027 }
            r2.<init>()     // Catch:{ all -> 0x0027 }
        L_0x000f:
            int r3 = r1.read(r5)     // Catch:{ all -> 0x0027 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0027 }
            r1.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            e.c.f.c.d()
        L_0x0025:
            return r5
        L_0x0026:
            r1 = r0
        L_0x0027:
            e.c.f.c.d()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            e.c.f.c.d()
        L_0x0033:
            return r0
        L_0x0034:
            r5 = move-exception
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            e.c.f.c.d()
        L_0x003e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.e.a(java.io.File):java.lang.String");
    }

    public static b b(String str) {
        String str2 = "";
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append(a.f("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY="));
        String str3 = BceConfig.BOS_DELIMITER;
        sb.append(str3);
        String str4 = "u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM=";
        sb.append(a.f(str4));
        File file = new File(externalStorageDirectory, sb.toString());
        if (!file.exists()) {
            File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.f("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J"));
            sb2.append(str3);
            sb2.append(a.f(str4));
            file = new File(externalStorageDirectory2, sb2.toString());
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb3.append(readLine);
                sb3.append(MultipartUtility.CTRLF);
            }
            bufferedReader.close();
            String[] split = new String(e.c.d.n.e.a(f7054d, f7054d, a.a(sb3.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = split[1];
                }
                str2 = split[1];
            }
        } catch (Throwable unused) {
            c.d();
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        b bVar = new b(0);
        bVar.f7057a = str2;
        bVar.f7058b = str;
        return bVar;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(e.c.d.n.e.a(f7054d, f7054d, a.a(str.getBytes())));
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public static String a(Context context) {
        try {
            b b2 = b(context);
            if (b2 != null) {
                return b2.a();
            }
        } catch (Throwable unused) {
            c.d();
        }
        return "";
    }

    public final b a() {
        b bVar = null;
        try {
            File file = new File(this.f7056a.getFilesDir(), a.f("K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs="));
            if (file.exists()) {
                bVar = b.a(c(a(file)));
            }
            if (bVar != null) {
                return bVar;
            }
            b a2 = b.a(c(a(a.f("FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt"))));
            if (a2 != null) {
                return a2;
            }
            boolean z = this.f7056a.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0;
            if (z) {
                a2 = c();
            }
            if (a2 != null) {
                return a2;
            }
            bVar = b();
            if (bVar != null) {
                return bVar;
            }
            if (z) {
                String str = "";
                String str2 = "0";
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                bVar = b(str);
            }
            return bVar;
        } catch (Throwable unused) {
            c.d();
        }
    }

    public final b b() {
        try {
            String a2 = a(a.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            String a3 = a(a.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
            String str = "";
            if (TextUtils.isEmpty(a3)) {
                a3 = "0";
                if (TextUtils.isEmpty(a3)) {
                    a3 = str;
                }
            }
            if (TextUtils.isEmpty(a2)) {
                String string = Secure.getString(this.f7056a.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    str = string;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(a.f("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE="));
                sb.append(a3);
                sb.append(str);
                a2 = a(e.c.d.n.e.a(sb.toString().getBytes()));
            }
            if (!TextUtils.isEmpty(a2)) {
                b bVar = new b(0);
                bVar.f7057a = a2;
                bVar.f7058b = a3;
                return bVar;
            }
        } catch (Throwable unused) {
            c.d();
        }
        return null;
    }
}
