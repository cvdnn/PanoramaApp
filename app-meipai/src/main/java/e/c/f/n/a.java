package e.c.f.n;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.rp.Report;
import com.tencent.connect.common.Constants;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.g.b;
import e.c.f.i;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommonMethods */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static boolean f7036a = false;

    /* renamed from: b reason: collision with root package name */
    public static String f7037b = null;

    /* renamed from: c reason: collision with root package name */
    public static String f7038c = null;

    /* renamed from: d reason: collision with root package name */
    public static int f7039d = 0;

    /* renamed from: e reason: collision with root package name */
    public static MyReceiver f7040e = null;

    /* renamed from: f reason: collision with root package name */
    public static String f7041f = "";

    /* renamed from: g reason: collision with root package name */
    public static String f7042g = "";

    /* renamed from: h reason: collision with root package name */
    public static int f7043h = -1;

    /* renamed from: i reason: collision with root package name */
    public static int f7044i = -1;

    /* renamed from: j reason: collision with root package name */
    public static int f7045j = -1;
    public static HashMap<Integer, ApkInfo> k;

    public static void a() {
        c.d();
    }

    public static void b(Context context, String str) {
        String str2 = "";
        String str3 = "leroadcfg";
        Editor editor = null;
        try {
            context.getSharedPreferences(str3, 4).edit();
            context.getSharedPreferences(str3, 4).edit();
            editor = context.getSharedPreferences("re_po_rt", 4).edit();
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str4 = str2;
                    while (optJSONObject.keys().hasNext()) {
                        str4 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str4)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        String optString = optJSONObject.optString(str4);
                        StringBuilder sb = new StringBuilder("al_da");
                        sb.append(str4);
                        editor.putString(sb.toString(), optString);
                        editor.commit();
                    }
                }
            } catch (Throwable unused) {
                c.d();
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    while (optJSONObject2.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String optString2 = optJSONObject2.optString(str2);
                        StringBuilder sb2 = new StringBuilder("in_da");
                        sb2.append(str2);
                        editor.putString(sb2.toString(), optString2);
                        editor.commit();
                    }
                }
            } catch (Throwable unused2) {
                c.d();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    new StringBuilder().append(optJSONArray.toString());
                    c.a();
                    editor.putString("li_pk_s", optJSONArray.toString());
                    editor.commit();
                }
            } catch (Throwable unused3) {
                c.d();
            }
        } catch (Throwable unused4) {
            c.d();
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    String str2 = " d:";
                    if (listFiles != null) {
                        if (listFiles.length > 0) {
                            for (File file2 : listFiles) {
                                if (file2.isDirectory()) {
                                    d(file2.getAbsolutePath());
                                } else {
                                    boolean delete = file2.delete();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(file2.getAbsolutePath());
                                    sb.append(str2);
                                    sb.append(delete);
                                    c.a();
                                }
                            }
                        }
                    }
                    boolean delete2 = file.delete();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(file.getAbsolutePath());
                    sb2.append(str2);
                    sb2.append(delete2);
                    c.a();
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] e(android.content.Context r13) {
        /*
            java.lang.String r0 = f7037b
            java.lang.String r1 = f7038c
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 != 0) goto L_0x001d
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x001d
            e.c.f.c.a()
            java.lang.String[] r13 = new java.lang.String[r5]
            r13[r4] = r0
            r13[r3] = r1
            return r13
        L_0x001d:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            java.lang.String r8 = "re_po_rt"
            r9 = 4
            java.lang.String r10 = "leroadcfg"
            r11 = 0
            if (r2 != 0) goto L_0x0033
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x006c
        L_0x0033:
            android.content.SharedPreferences r2 = r13.getSharedPreferences(r10, r9)     // Catch:{ all -> 0x004b }
            r2.edit()     // Catch:{ all -> 0x0049 }
            android.content.SharedPreferences r12 = r13.getSharedPreferences(r10, r9)     // Catch:{ all -> 0x0049 }
            r12.edit()     // Catch:{ all -> 0x0049 }
            android.content.SharedPreferences r12 = r13.getSharedPreferences(r8, r9)     // Catch:{ all -> 0x0049 }
            r12.edit()     // Catch:{ all -> 0x0049 }
            goto L_0x0053
        L_0x0049:
            r12 = move-exception
            goto L_0x004d
        L_0x004b:
            r12 = move-exception
            r2 = r11
        L_0x004d:
            r12.getMessage()
            e.c.f.c.c()
        L_0x0053:
            java.lang.String r12 = "svi_n"
            java.lang.String r2 = r2.getString(r12, r7)
            boolean r12 = android.text.TextUtils.isEmpty(r2)
            if (r12 != 0) goto L_0x006c
            java.lang.String[] r2 = r2.split(r6)
            if (r2 == 0) goto L_0x006c
            int r12 = r2.length
            if (r12 != r5) goto L_0x006c
            e.c.f.c.a()
            return r2
        L_0x006c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0078
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x00ae
        L_0x0078:
            android.content.SharedPreferences r11 = r13.getSharedPreferences(r10, r9)     // Catch:{ all -> 0x008e }
            r11.edit()     // Catch:{ all -> 0x008e }
            android.content.SharedPreferences r2 = r13.getSharedPreferences(r10, r9)     // Catch:{ all -> 0x008e }
            r2.edit()     // Catch:{ all -> 0x008e }
            android.content.SharedPreferences r13 = r13.getSharedPreferences(r8, r9)     // Catch:{ all -> 0x008e }
            r13.edit()     // Catch:{ all -> 0x008e }
            goto L_0x0095
        L_0x008e:
            r13 = move-exception
            r13.getMessage()
            e.c.f.c.c()
        L_0x0095:
            java.lang.String r13 = "svi"
            java.lang.String r13 = r11.getString(r13, r7)
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 != 0) goto L_0x00ae
            java.lang.String[] r13 = r13.split(r6)
            if (r13 == 0) goto L_0x00ae
            int r2 = r13.length
            if (r2 != r5) goto L_0x00ae
            e.c.f.c.a()
            return r13
        L_0x00ae:
            boolean r13 = android.text.TextUtils.isEmpty(r0)
            if (r13 != 0) goto L_0x00ba
            boolean r13 = android.text.TextUtils.isEmpty(r1)
            if (r13 == 0) goto L_0x00c1
        L_0x00ba:
            e.c.f.c.a()
            java.lang.String r0 = "3"
            java.lang.String r1 = "925fc15df8a49bed0b3eca8d2b44cb7b"
        L_0x00c1:
            java.lang.String[] r13 = new java.lang.String[r5]
            r13[r4] = r0
            r13[r3] = r1
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.e(android.content.Context):java.lang.String[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|(2:15|(1:17)(1:18))) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r4.getApplicationInfo() != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if ((r4.getApplicationInfo().flags & 2) != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        f7045j = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        f7045j = 0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(android.content.Context r4) {
        /*
            r0 = 0
            int r1 = f7045j     // Catch:{ all -> 0x0051 }
            r2 = 1
            if (r1 >= 0) goto L_0x004c
            if (r4 == 0) goto L_0x004c
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            r3.append(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = ".BuildConfig"
            r3.append(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0037 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = "DEBUG"
            java.lang.reflect.Field r1 = r1.getField(r3)     // Catch:{ all -> 0x0037 }
            r1.setAccessible(r2)     // Catch:{ all -> 0x0037 }
            r3 = 0
            boolean r1 = r1.getBoolean(r3)     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0033
            r1 = r2
            goto L_0x0034
        L_0x0033:
            r1 = r0
        L_0x0034:
            f7045j = r1     // Catch:{ all -> 0x0037 }
            goto L_0x004c
        L_0x0037:
            android.content.pm.ApplicationInfo r1 = r4.getApplicationInfo()     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004c
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch:{ all -> 0x0051 }
            int r4 = r4.flags     // Catch:{ all -> 0x0051 }
            r4 = r4 & 2
            if (r4 == 0) goto L_0x004a
            f7045j = r2     // Catch:{ all -> 0x0051 }
            goto L_0x004c
        L_0x004a:
            f7045j = r0     // Catch:{ all -> 0x0051 }
        L_0x004c:
            int r4 = f7045j     // Catch:{ all -> 0x0051 }
            if (r4 != r2) goto L_0x0054
            return r2
        L_0x0051:
            e.c.f.c.d()
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.f(android.content.Context):boolean");
    }

    public static int g(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.CONNECTED) {
                if (activeNetworkInfo.getType() == 1) {
                    return 4;
                }
                if (activeNetworkInfo.getType() != 0) {
                    return -2;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                    case 6:
                        return 2;
                    case 7:
                        return 1;
                    case 8:
                    case 9:
                    case 10:
                        return 2;
                    case 11:
                        return 1;
                    case 12:
                        return 2;
                    case 13:
                        return 3;
                    case 14:
                    case 15:
                        return 2;
                    default:
                        return 5;
                }
            }
            return -1;
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00b7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00d5 */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ea A[SYNTHETIC, Splitter:B:66:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f2 A[Catch:{ all -> 0x00f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject h(android.content.Context r6) {
        /*
            java.lang.String r0 = "phone"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = android.os.Build.BOARD     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "0"
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0010
            r2 = r4
        L_0x0010:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.DEVICE     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "1"
            if (r2 != 0) goto L_0x001a
            r2 = r4
        L_0x001a:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.HARDWARE     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "2"
            if (r2 != 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.HOST     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "3"
            if (r2 != 0) goto L_0x002e
            r2 = r4
        L_0x002e:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.DISPLAY     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "4"
            if (r2 != 0) goto L_0x0038
            r2 = r4
        L_0x0038:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "5"
            if (r2 != 0) goto L_0x0042
            r2 = r4
        L_0x0042:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.VERSION.CODENAME     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "6"
            if (r2 != 0) goto L_0x004c
            r2 = r4
        L_0x004c:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "7"
            if (r2 != 0) goto L_0x0056
            r2 = r4
        L_0x0056:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "8"
            java.lang.String r3 = e.c.f.n.c.b(r6)     // Catch:{ all -> 0x00f8 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "9"
            if (r2 != 0) goto L_0x0069
            r2 = r4
        L_0x0069:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "10"
            if (r2 != 0) goto L_0x0073
            r2 = r4
        L_0x0073:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "11"
            java.lang.String r3 = e.c.f.n.c.h(r6)     // Catch:{ all -> 0x00f8 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "12"
            if (r2 != 0) goto L_0x0086
            r2 = r4
        L_0x0086:
            r1.put(r3, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "13"
            java.lang.String r3 = e.c.f.n.c.c(r6)     // Catch:{ all -> 0x00f8 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "14"
            r1.put(r2, r4)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "15"
            java.lang.String r3 = e.c.f.n.c.i(r6)     // Catch:{ all -> 0x00f8 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "17"
            java.lang.Object r3 = r6.getSystemService(r0)     // Catch:{ all -> 0x00b6 }
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x00b4
            java.lang.String r3 = r3.getSimOperatorName()     // Catch:{ all -> 0x00b6 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00b7 }
            if (r5 == 0) goto L_0x00ba
        L_0x00b4:
            r3 = r4
            goto L_0x00ba
        L_0x00b6:
            r3 = r4
        L_0x00b7:
            e.c.f.c.d()     // Catch:{ all -> 0x00f8 }
        L_0x00ba:
            r1.put(r2, r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "18"
            java.lang.Object r6 = r6.getSystemService(r0)     // Catch:{ all -> 0x00d5 }
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x00d8
            java.lang.String r6 = r6.getNetworkOperator()     // Catch:{ all -> 0x00d5 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x00d2
            goto L_0x00d8
        L_0x00d2:
            r4 = r6
            goto L_0x00d8
        L_0x00d4:
            r4 = r6
        L_0x00d5:
            e.c.f.c.d()     // Catch:{ all -> 0x00f8 }
        L_0x00d8:
            r1.put(r2, r4)     // Catch:{ all -> 0x00f8 }
            java.lang.String r6 = "20"
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f8 }
            r1.put(r6, r0)     // Catch:{ all -> 0x00f8 }
            java.util.TimeZone r6 = java.util.TimeZone.getDefault()     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = "21"
            if (r6 == 0) goto L_0x00f2
            java.lang.String r6 = r6.getID()     // Catch:{ all -> 0x00f8 }
            r1.put(r0, r6)     // Catch:{ all -> 0x00f8 }
            goto L_0x00fb
        L_0x00f2:
            java.lang.String r6 = "-1"
            r1.put(r0, r6)     // Catch:{ all -> 0x00f8 }
            goto L_0x00fb
        L_0x00f8:
            e.c.f.c.d()
        L_0x00fb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.h(android.content.Context):org.json.JSONObject");
    }

    public static int i(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            c.d();
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        if (networkInfo.getType() == 0) {
        }
        return 1;
    }

    public static void j(Context context) {
        try {
            MyReceiver myReceiver = new MyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
            intentFilter.addCategory("com.baidu.category.SOFIRE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".permission.sofire.RECEIVE");
            context.registerReceiver(myReceiver, intentFilter, sb.toString(), null);
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Can't wrap try/catch for region: R(57:58|59|60|61|62|68|69|(3:71|72|(44:74|75|95|(1:104)(1:103)|(2:106|(1:108)(2:109|(2:113|(42:117|118|119|(1:124)(1:123)|127|128|129|130|134|(1:136)|137|(1:139)|140|(1:142)|143|(1:145)|146|(1:148)|149|(1:151)|152|(1:154)|155|(1:157)|158|(1:160)|161|162|163|164|165|166|167|168|178|179|(1:181)|182|184|185|(1:187)(12:188|(3:190|191|(2:193|194)(1:195))|196|197|(2:199|200)(1:201)|202|203|(3:205|206|207)(1:208)|209|210|(2:212|213)(1:214)|215)|216))))|125|127|128|129|130|134|(0)|137|(0)|140|(0)|143|(0)|146|(0)|149|(0)|152|(0)|155|(0)|158|(0)|161|162|163|164|165|166|167|168|178|179|(0)|182|184|185|(0)(0)|216))|76|77|78|79|85|(3:87|(2:89|(1:91)(2:92|75))|93)(1:94)|95|(3:97|99|101)|104|(0)|125|127|128|129|130|134|(0)|137|(0)|140|(0)|143|(0)|146|(0)|149|(0)|152|(0)|155|(0)|158|(0)|161|162|163|164|165|166|167|168|178|179|(0)|182|184|185|(0)(0)|216) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        e.c.f.c.d();
        r5 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x0260 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x0327 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00af */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f2 A[Catch:{ all -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x029b A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ab A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02bb A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02cb A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02db A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ef A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02ff A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x030f A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x031f A[Catch:{ all -> 0x028b, all -> 0x0327 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0359 A[Catch:{ all -> 0x037c }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x038e A[Catch:{ all -> 0x047e }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0390 A[Catch:{ all -> 0x047e }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7 A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0148 A[Catch:{ all -> 0x0486 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017a A[SYNTHETIC, Splitter:B:71:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b9 A[Catch:{ all -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d1 A[Catch:{ all -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01da A[Catch:{ all -> 0x025e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject k(android.content.Context r21) {
        /*
            r1 = r21
            java.lang.String r2 = "s1"
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "appinv_ky"
            java.lang.String r5 = "4"
            java.lang.String r6 = "3"
            java.lang.String r7 = "1"
            java.lang.String r8 = "re_po_rt"
            java.lang.String r9 = "leroadcfg"
            java.lang.String r10 = ""
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0486 }
            r0.<init>()     // Catch:{ all -> 0x0486 }
            java.lang.String r12 = b()     // Catch:{ all -> 0x0486 }
            r0.append(r12)     // Catch:{ all -> 0x0486 }
            java.lang.String r12 = "p/5/aio"
            r0.append(r12)     // Catch:{ all -> 0x0486 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x0486 }
            e.c.f.c.a()     // Catch:{ all -> 0x0486 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0486 }
            r13.<init>()     // Catch:{ all -> 0x0486 }
            org.json.JSONArray r0 = m(r21)     // Catch:{ all -> 0x0486 }
            java.lang.String r14 = "0"
            if (r0 == 0) goto L_0x003c
            r13.put(r14, r0)     // Catch:{ all -> 0x0486 }
        L_0x003c:
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ all -> 0x0486 }
            r15.<init>()     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = android.os.Build.MODEL     // Catch:{ all -> 0x0486 }
            r15.put(r14, r0)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = e.c.f.n.c.b(r21)     // Catch:{ all -> 0x0486 }
            r15.put(r7, r0)     // Catch:{ all -> 0x0486 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0486 }
            r15.put(r6, r0)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = "3.3.9.8.2"
            r15.put(r5, r0)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = r21.getPackageName()     // Catch:{ all -> 0x0486 }
            android.content.pm.PackageManager r11 = r21.getPackageManager()     // Catch:{ all -> 0x0486 }
            r16 = r5
            r5 = 64
            android.content.pm.PackageInfo r5 = r11.getPackageInfo(r0, r5)     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            e.c.f.c.d()     // Catch:{ all -> 0x0486 }
            r5 = 0
        L_0x0070:
            if (r5 == 0) goto L_0x0481
            r17 = r3
            android.content.pm.ApplicationInfo r3 = r5.applicationInfo     // Catch:{ all -> 0x0486 }
            java.lang.CharSequence r3 = r3.loadLabel(r11)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0486 }
            int r11 = r3.length()     // Catch:{ all -> 0x00ab }
            r18 = r2
            r2 = 0
        L_0x0085:
            if (r2 >= r11) goto L_0x00a2
            r19 = r11
            char r11 = r3.charAt(r2)     // Catch:{ all -> 0x00ad }
            r20 = r6
            r6 = 32
            if (r11 <= r6) goto L_0x009b
            char r6 = r3.charAt(r2)     // Catch:{ all -> 0x00af }
            r11 = 160(0xa0, float:2.24E-43)
            if (r6 != r11) goto L_0x00a4
        L_0x009b:
            int r2 = r2 + 1
            r11 = r19
            r6 = r20
            goto L_0x0085
        L_0x00a2:
            r20 = r6
        L_0x00a4:
            if (r2 <= 0) goto L_0x00b3
            java.lang.String r3 = r3.substring(r2)     // Catch:{ all -> 0x00af }
            goto L_0x00b3
        L_0x00ab:
            r18 = r2
        L_0x00ad:
            r20 = r6
        L_0x00af:
            e.c.f.c.d()     // Catch:{ all -> 0x0486 }
            r3 = r10
        L_0x00b3:
            java.lang.String r2 = "5"
            r15.put(r2, r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "6"
            r15.put(r2, r0)     // Catch:{ all -> 0x0486 }
            android.content.pm.ApplicationInfo r0 = r5.applicationInfo     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = r0.sourceDir     // Catch:{ all -> 0x0486 }
            java.security.PublicKey r0 = a(r5, r0)     // Catch:{ all -> 0x0486 }
            if (r0 == 0) goto L_0x00ee
            byte[] r0 = r0.getEncoded()     // Catch:{ all -> 0x0486 }
            java.lang.String r2 = "7"
            if (r0 == 0) goto L_0x00eb
            a(r1, r0)     // Catch:{ all -> 0x0486 }
            r3 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r3)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "\n"
            java.lang.String r0 = r0.replace(r3, r10)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = "\r"
            java.lang.String r0 = r0.replace(r3, r10)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = e.c.f.n.h.a(r0)     // Catch:{ all -> 0x0486 }
            r15.put(r2, r0)     // Catch:{ all -> 0x0486 }
            goto L_0x00ee
        L_0x00eb:
            r15.put(r2, r10)     // Catch:{ all -> 0x0486 }
        L_0x00ee:
            java.lang.String r0 = "8"
            java.lang.String r2 = r5.versionName     // Catch:{ all -> 0x0486 }
            r15.put(r0, r2)     // Catch:{ all -> 0x0486 }
            r2 = 4
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x010e }
            r3.edit()     // Catch:{ all -> 0x010c }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x010c }
            r0.edit()     // Catch:{ all -> 0x010c }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r8, r2)     // Catch:{ all -> 0x010c }
            r0.edit()     // Catch:{ all -> 0x010c }
            goto L_0x0116
        L_0x010c:
            r0 = move-exception
            goto L_0x0110
        L_0x010e:
            r0 = move-exception
            r3 = 0
        L_0x0110:
            r0.getMessage()     // Catch:{ all -> 0x0486 }
            e.c.f.c.c()     // Catch:{ all -> 0x0486 }
        L_0x0116:
            java.lang.String r0 = "9"
            java.lang.String r5 = "opi"
            r6 = 0
            int r3 = r3.getInt(r5, r6)     // Catch:{ all -> 0x0486 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0486 }
            r15.put(r0, r3)     // Catch:{ all -> 0x0486 }
            r13.put(r7, r15)     // Catch:{ all -> 0x0486 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0486 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0486 }
            r3.<init>()     // Catch:{ all -> 0x0486 }
            r3.append(r12)     // Catch:{ all -> 0x0486 }
            java.lang.String r5 = "---"
            r3.append(r5)     // Catch:{ all -> 0x0486 }
            r3.append(r0)     // Catch:{ all -> 0x0486 }
            r3 = 1
            java.lang.String r0 = e.c.d.n.e.a(r1, r12, r0, r3)     // Catch:{ all -> 0x0486 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0486 }
            if (r5 != 0) goto L_0x047f
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0486 }
            r5.<init>(r0)     // Catch:{ all -> 0x0486 }
            android.content.SharedPreferences r6 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x0165 }
            r6.edit()     // Catch:{ all -> 0x0163 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x0163 }
            r0.edit()     // Catch:{ all -> 0x0163 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r8, r2)     // Catch:{ all -> 0x0163 }
            r0.edit()     // Catch:{ all -> 0x0163 }
            goto L_0x016d
        L_0x0163:
            r0 = move-exception
            goto L_0x0167
        L_0x0165:
            r0 = move-exception
            r6 = 0
        L_0x0167:
            r0.getMessage()     // Catch:{ all -> 0x025e }
            e.c.f.c.c()     // Catch:{ all -> 0x025e }
        L_0x016d:
            java.lang.String r0 = f7037b     // Catch:{ all -> 0x025e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            java.lang.String r11 = "-"
            java.lang.String r12 = "svi_n"
            r13 = 2
            if (r0 != 0) goto L_0x018f
            java.lang.String r0 = f7038c     // Catch:{ all -> 0x025e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            if (r0 != 0) goto L_0x018f
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ all -> 0x025e }
            java.lang.String r10 = f7037b     // Catch:{ all -> 0x025e }
            r15 = 0
            r0[r15] = r10     // Catch:{ all -> 0x025e }
            java.lang.String r10 = f7038c     // Catch:{ all -> 0x025e }
            r0[r3] = r10     // Catch:{ all -> 0x025e }
        L_0x018d:
            r10 = 0
            goto L_0x01d4
        L_0x018f:
            android.content.SharedPreferences r15 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x01a7 }
            r15.edit()     // Catch:{ all -> 0x01a5 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x01a5 }
            r0.edit()     // Catch:{ all -> 0x01a5 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r8, r2)     // Catch:{ all -> 0x01a5 }
            r0.edit()     // Catch:{ all -> 0x01a5 }
            goto L_0x01af
        L_0x01a5:
            r0 = move-exception
            goto L_0x01a9
        L_0x01a7:
            r0 = move-exception
            r15 = 0
        L_0x01a9:
            r0.getMessage()     // Catch:{ all -> 0x025e }
            e.c.f.c.c()     // Catch:{ all -> 0x025e }
        L_0x01af:
            java.lang.String r0 = r15.getString(r12, r10)     // Catch:{ all -> 0x025e }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            if (r10 != 0) goto L_0x01d1
            java.lang.String[] r0 = r0.split(r11)     // Catch:{ all -> 0x025e }
            if (r0 == 0) goto L_0x01cd
            int r10 = r0.length     // Catch:{ all -> 0x025e }
            if (r10 == r13) goto L_0x01c3
            goto L_0x01cd
        L_0x01c3:
            r10 = 0
            r15 = r0[r10]     // Catch:{ all -> 0x025e }
            f7037b = r15     // Catch:{ all -> 0x025e }
            r10 = r0[r3]     // Catch:{ all -> 0x025e }
            f7038c = r10     // Catch:{ all -> 0x025e }
            goto L_0x018d
        L_0x01cd:
            r10 = 0
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ all -> 0x025e }
            goto L_0x01d4
        L_0x01d1:
            r10 = 0
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ all -> 0x025e }
        L_0x01d4:
            int r6 = r6.getInt(r4, r3)     // Catch:{ all -> 0x025e }
            if (r6 != r3) goto L_0x01ef
            int r6 = r0.length     // Catch:{ all -> 0x025e }
            if (r6 != r13) goto L_0x01ed
            r6 = r0[r10]     // Catch:{ all -> 0x025e }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x025e }
            if (r6 != 0) goto L_0x01ed
            r0 = r0[r3]     // Catch:{ all -> 0x025e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            if (r0 == 0) goto L_0x01ef
        L_0x01ed:
            r0 = r3
            goto L_0x01f0
        L_0x01ef:
            r0 = 0
        L_0x01f0:
            if (r0 == 0) goto L_0x025e
            java.lang.String r0 = "2"
            org.json.JSONObject r0 = r5.optJSONObject(r0)     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            java.lang.String r10 = "c:"
            r6.<init>(r10)     // Catch:{ all -> 0x025e }
            r6.append(r0)     // Catch:{ all -> 0x025e }
            if (r0 != 0) goto L_0x0205
            goto L_0x025e
        L_0x0205:
            java.lang.String r6 = r0.optString(r14)     // Catch:{ all -> 0x025e }
            java.lang.String r0 = r0.optString(r7)     // Catch:{ all -> 0x025e }
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x025e }
            if (r10 != 0) goto L_0x025e
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            if (r10 != 0) goto L_0x025e
            e.c.f.f.d r10 = e.c.f.f.d.a(r21)     // Catch:{ all -> 0x025e }
            boolean r13 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x025e }
            if (r13 != 0) goto L_0x025e
            boolean r13 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x025e }
            if (r13 == 0) goto L_0x022a
            goto L_0x025e
        L_0x022a:
            r13 = r20
            boolean r15 = r13.equals(r6)     // Catch:{ all -> 0x0260 }
            if (r15 == 0) goto L_0x023b
            java.lang.String r15 = "925fc15df8a49bed0b3eca8d2b44cb7b"
            boolean r15 = r15.equals(r0)     // Catch:{ all -> 0x0260 }
            if (r15 == 0) goto L_0x023b
            goto L_0x0260
        L_0x023b:
            f7037b = r6     // Catch:{ all -> 0x0260 }
            f7038c = r0     // Catch:{ all -> 0x0260 }
            e.c.f.i r10 = r10.f6943b     // Catch:{ all -> 0x0260 }
            android.content.SharedPreferences$Editor r15 = r10.f7009c     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            r3.<init>()     // Catch:{ all -> 0x0260 }
            r3.append(r6)     // Catch:{ all -> 0x0260 }
            r3.append(r11)     // Catch:{ all -> 0x0260 }
            r3.append(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0260 }
            r15.putString(r12, r0)     // Catch:{ all -> 0x0260 }
            android.content.SharedPreferences$Editor r0 = r10.f7009c     // Catch:{ all -> 0x0260 }
            r0.commit()     // Catch:{ all -> 0x0260 }
            goto L_0x0260
        L_0x025e:
            r13 = r20
        L_0x0260:
            org.json.JSONObject r0 = r5.optJSONObject(r13)     // Catch:{ all -> 0x0327 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0327 }
            java.lang.String r6 = "i:"
            r3.<init>(r6)     // Catch:{ all -> 0x0327 }
            r3.append(r0)     // Catch:{ all -> 0x0327 }
            java.lang.String r3 = "c"
            org.json.JSONObject r3 = r0.getJSONObject(r3)     // Catch:{ all -> 0x0327 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x028b }
            r0.edit()     // Catch:{ all -> 0x028b }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x028b }
            r0.edit()     // Catch:{ all -> 0x028b }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r8, r2)     // Catch:{ all -> 0x028b }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x028b }
            goto L_0x0293
        L_0x028b:
            r0 = move-exception
            r0.getMessage()     // Catch:{ all -> 0x0327 }
            e.c.f.c.c()     // Catch:{ all -> 0x0327 }
            r0 = 0
        L_0x0293:
            java.lang.String r6 = "n"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x02a3
            java.lang.String r10 = "re_net_ty"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02a3:
            java.lang.String r6 = "i"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x02b3
            java.lang.String r10 = "re_net_hr"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02b3:
            java.lang.String r6 = "i2"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x02c3
            java.lang.String r10 = "re_net_hr_bc"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02c3:
            java.lang.String r6 = "w"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x02d3
            java.lang.String r10 = "re_net_wt"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02d3:
            r6 = r18
            int r10 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r10 <= 0) goto L_0x02e7
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            java.lang.String r10 = "re_net_one_lt"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02e7:
            java.lang.String r6 = "s2"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x02f7
            java.lang.String r10 = "re_net_dy_lt"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x02f7:
            java.lang.String r6 = "t"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x0307
            java.lang.String r10 = "re_net_over"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x0307:
            java.lang.String r6 = "l1"
            int r6 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r6 <= 0) goto L_0x0317
            java.lang.String r10 = "up_nu_co"
            r0.putInt(r10, r6)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x0317:
            java.lang.String r6 = "l2"
            int r3 = r3.optInt(r6)     // Catch:{ all -> 0x0327 }
            if (r3 <= 0) goto L_0x0327
            java.lang.String r6 = "up_nu_li"
            r0.putInt(r6, r3)     // Catch:{ all -> 0x0327 }
            r0.commit()     // Catch:{ all -> 0x0327 }
        L_0x0327:
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x0345 }
            android.content.SharedPreferences$Editor r6 = r3.edit()     // Catch:{ all -> 0x0343 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r9, r2)     // Catch:{ all -> 0x0341 }
            android.content.SharedPreferences$Editor r11 = r0.edit()     // Catch:{ all -> 0x0341 }
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r8, r2)     // Catch:{ all -> 0x033f }
            r0.edit()     // Catch:{ all -> 0x033f }
            goto L_0x034f
        L_0x033f:
            r0 = move-exception
            goto L_0x0349
        L_0x0341:
            r0 = move-exception
            goto L_0x0348
        L_0x0343:
            r0 = move-exception
            goto L_0x0347
        L_0x0345:
            r0 = move-exception
            r3 = 0
        L_0x0347:
            r6 = 0
        L_0x0348:
            r11 = 0
        L_0x0349:
            r0.getMessage()     // Catch:{ all -> 0x047e }
            e.c.f.c.c()     // Catch:{ all -> 0x047e }
        L_0x034f:
            java.lang.String r0 = r5.optString(r14)     // Catch:{ all -> 0x037c }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x037c }
            if (r1 != 0) goto L_0x037c
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x037c }
            java.lang.String r2 = "30212102dicudiab"
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x037c }
            r8 = r17
            byte[] r0 = r0.getBytes(r8)     // Catch:{ all -> 0x037c }
            byte[] r0 = e.c.d.n.e.b(r2, r0)     // Catch:{ all -> 0x037c }
            r2 = 10
            byte[] r0 = android.util.Base64.encode(r0, r2)     // Catch:{ all -> 0x037c }
            r1.<init>(r0, r8)     // Catch:{ all -> 0x037c }
            java.lang.String r0 = "gli"
            r11.putString(r0, r1)     // Catch:{ all -> 0x037c }
            r11.commit()     // Catch:{ all -> 0x037c }
        L_0x037c:
            r1 = r16
            org.json.JSONObject r0 = r5.optJSONObject(r1)     // Catch:{ all -> 0x047e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x047e }
            java.lang.String r2 = "s:"
            r1.<init>(r2)     // Catch:{ all -> 0x047e }
            r1.append(r0)     // Catch:{ all -> 0x047e }
            if (r0 != 0) goto L_0x0390
            goto L_0x047e
        L_0x0390:
            java.lang.String r1 = "app"
            int r1 = r0.optInt(r1)     // Catch:{ all -> 0x047e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x047e }
            java.lang.String r8 = "App-"
            r2.<init>(r8)     // Catch:{ all -> 0x047e }
            java.lang.String r8 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x047e }
            r2.append(r8)     // Catch:{ all -> 0x047e }
            java.lang.String r2 = "appinv_t"
            r6.putInt(r2, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "js"
            int r1 = r0.optInt(r1)     // Catch:{ all -> 0x047e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x047e }
            java.lang.String r8 = "JS-"
            r2.<init>(r8)     // Catch:{ all -> 0x047e }
            java.lang.String r8 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x047e }
            r2.append(r8)     // Catch:{ all -> 0x047e }
            java.lang.String r2 = "appinv_js"
            r6.putInt(r2, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "a"
            r2 = 1
            int r1 = r0.optInt(r1, r2)     // Catch:{ all -> 0x047e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x047e }
            java.lang.String r8 = "get key-"
            r2.<init>(r8)     // Catch:{ all -> 0x047e }
            java.lang.String r8 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x047e }
            r2.append(r8)     // Catch:{ all -> 0x047e }
            r6.putInt(r4, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "pi"
            r2 = 360(0x168, float:5.04E-43)
            int r1 = r0.optInt(r1, r2)     // Catch:{ all -> 0x047e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x047e }
            java.lang.String r4 = "net Interval-"
            r2.<init>(r4)     // Catch:{ all -> 0x047e }
            java.lang.String r4 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x047e }
            r2.append(r4)     // Catch:{ all -> 0x047e }
            java.lang.String r2 = "appplg_te"
            r6.putInt(r2, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "ti"
            r2 = 1
            int r1 = r0.optInt(r1, r2)     // Catch:{ all -> 0x047e }
            r2 = 24
            if (r1 <= 0) goto L_0x0426
            r8 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r10 = (double) r1     // Catch:{ all -> 0x047e }
            double r8 = r8 / r10
            long r8 = java.lang.Math.round(r8)     // Catch:{ all -> 0x047e }
            int r1 = (int) r8
            java.lang.String r4 = "appal_te"
            if (r1 <= 0) goto L_0x0420
            r6.putInt(r4, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            goto L_0x0426
        L_0x0420:
            r6.putInt(r4, r2)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
        L_0x0426:
            java.lang.String r1 = "alm"
            int r1 = r0.optInt(r1, r2)     // Catch:{ all -> 0x047e }
            java.lang.String r4 = "appal_daa"
            if (r1 <= 0) goto L_0x0437
            r6.putInt(r4, r1)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            goto L_0x043d
        L_0x0437:
            r6.putInt(r4, r2)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
        L_0x043d:
            r1 = 0
            int r2 = r0.optInt(r14, r1)     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "a_a_c_b"
            if (r2 <= 0) goto L_0x044f
            r2 = 1
            r6.putBoolean(r1, r2)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            r2 = 0
            goto L_0x0456
        L_0x044f:
            r2 = 0
            r6.putBoolean(r1, r2)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
        L_0x0456:
            r1 = -1
            int r1 = r0.optInt(r7, r1)     // Catch:{ all -> 0x047e }
            java.lang.String r4 = "se_fg_s"
            r7 = 1
            if (r1 != r7) goto L_0x046a
            r3.getBoolean(r4, r2)     // Catch:{ all -> 0x047e }
            r6.putBoolean(r4, r7)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
            goto L_0x0470
        L_0x046a:
            r6.putBoolean(r4, r2)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
        L_0x0470:
            java.lang.String r1 = "ai"
            int r0 = r0.optInt(r1, r2)     // Catch:{ all -> 0x047e }
            java.lang.String r1 = "appinv_sai"
            r6.putInt(r1, r0)     // Catch:{ all -> 0x047e }
            r6.commit()     // Catch:{ all -> 0x047e }
        L_0x047e:
            return r5
        L_0x047f:
            r1 = 0
            return r1
        L_0x0481:
            r0 = 6
            f7039d = r0     // Catch:{ all -> 0x0486 }
            r1 = 0
            return r1
        L_0x0486:
            e.c.f.c.d()
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.k(android.content.Context):org.json.JSONObject");
    }

    public static String l(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(c.b(context));
            sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
            String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
            String str = "0";
            if (!TextUtils.isEmpty(hexString)) {
                int length = 8 - hexString.length();
                if (length > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    while (length > 0) {
                        sb2.append(str);
                        length--;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2.toString());
                    sb3.append(hexString);
                    hexString = sb3.toString();
                }
            }
            String str2 = e(context)[0];
            String hexString2 = Long.toHexString(Long.valueOf(str2).longValue());
            StringBuilder sb4 = new StringBuilder("time ");
            sb4.append(hexString);
            sb4.append(" appkey");
            sb4.append(str2);
            c.a();
            if (!TextUtils.isEmpty(hexString2)) {
                int length2 = 16 - hexString2.length();
                if (length2 > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    while (length2 > 0) {
                        sb5.append(str);
                        length2--;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(sb5.toString());
                    sb6.append(hexString2);
                    hexString2 = sb6.toString();
                }
            }
            sb.append(hexString);
            sb.append(hexString2);
            return sb.toString();
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0154, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0150 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.json.JSONArray m(android.content.Context r11) {
        /*
            java.lang.Class<e.c.f.n.a> r0 = e.c.f.n.a.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = "leroadcfg"
            r3 = 4
            android.content.SharedPreferences r4 = r11.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x0025 }
            android.content.SharedPreferences$Editor r5 = r4.edit()     // Catch:{ all -> 0x0022 }
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x0020 }
            r2.edit()     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = "re_po_rt"
            android.content.SharedPreferences r2 = r11.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x0020 }
            r2.edit()     // Catch:{ all -> 0x0020 }
            goto L_0x002e
        L_0x0020:
            r2 = move-exception
            goto L_0x0028
        L_0x0022:
            r2 = move-exception
            r5 = r1
            goto L_0x0028
        L_0x0025:
            r2 = move-exception
            r4 = r1
            r5 = r4
        L_0x0028:
            r2.getMessage()     // Catch:{ all -> 0x0150 }
            e.c.f.c.c()     // Catch:{ all -> 0x0150 }
        L_0x002e:
            java.lang.String r2 = "lpcf"
            r3 = 0
            boolean r2 = r4.getBoolean(r2, r3)     // Catch:{ all -> 0x0150 }
            if (r2 == 0) goto L_0x0039
            monitor-exit(r0)
            return r1
        L_0x0039:
            java.lang.String r2 = "sofire_local.cfg"
            java.lang.String r4 = "local"
            java.lang.String r11 = b(r11, r2, r4)     // Catch:{ all -> 0x0150 }
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0150 }
            if (r2 == 0) goto L_0x0049
            monitor-exit(r0)
            return r1
        L_0x0049:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x0150 }
            r2.<init>(r11)     // Catch:{ all -> 0x0150 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r11 = k     // Catch:{ all -> 0x0150 }
            if (r11 != 0) goto L_0x005a
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x0150 }
            r11.<init>()     // Catch:{ all -> 0x0150 }
            k = r11     // Catch:{ all -> 0x0150 }
            goto L_0x005f
        L_0x005a:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r11 = k     // Catch:{ all -> 0x0150 }
            r11.clear()     // Catch:{ all -> 0x0150 }
        L_0x005f:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0150 }
            r11.<init>()     // Catch:{ all -> 0x0150 }
            r4 = r3
        L_0x0065:
            int r6 = r2.length()     // Catch:{ all -> 0x0150 }
            if (r4 >= r6) goto L_0x00c1
            org.json.JSONObject r6 = r2.optJSONObject(r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r7 = "pkgname"
            java.lang.String r7 = r6.optString(r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "version"
            java.lang.String r8 = r6.optString(r8)     // Catch:{ all -> 0x0150 }
            java.lang.String r9 = "id"
            int r9 = r6.optInt(r9)     // Catch:{ all -> 0x0150 }
            if (r9 <= 0) goto L_0x008a
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0150 }
            r11.add(r10)     // Catch:{ all -> 0x0150 }
        L_0x008a:
            java.lang.String r10 = "md5"
            java.lang.String r6 = r6.optString(r10)     // Catch:{ all -> 0x0150 }
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0150 }
            if (r10 != 0) goto L_0x00be
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0150 }
            if (r10 != 0) goto L_0x00be
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0150 }
            if (r10 != 0) goto L_0x00be
            if (r9 <= 0) goto L_0x00be
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x0150 }
            com.baidu.sofire.core.ApkInfo r10 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x0150 }
            r10.<init>()     // Catch:{ all -> 0x0150 }
            r10.packageName = r7     // Catch:{ all -> 0x0150 }
            r10.versionName = r8     // Catch:{ all -> 0x0150 }
            r10.key = r9     // Catch:{ all -> 0x0150 }
            r10.apkMD5 = r6     // Catch:{ all -> 0x0150 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r6 = k     // Catch:{ all -> 0x0150 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0150 }
            r6.put(r7, r10)     // Catch:{ all -> 0x0150 }
        L_0x00be:
            int r4 = r4 + 1
            goto L_0x0065
        L_0x00c1:
            int r2 = r11.size()     // Catch:{ all -> 0x0150 }
            java.lang.String r4 = "glspk"
            if (r2 != 0) goto L_0x00cf
            java.lang.String r11 = ""
            r5.putString(r4, r11)     // Catch:{ all -> 0x0150 }
            goto L_0x00f8
        L_0x00cf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0150 }
            r2.<init>()     // Catch:{ all -> 0x0150 }
        L_0x00d4:
            int r6 = r11.size()     // Catch:{ all -> 0x0150 }
            if (r3 >= r6) goto L_0x00f1
            java.lang.Object r6 = r11.get(r3)     // Catch:{ all -> 0x0150 }
            r2.append(r6)     // Catch:{ all -> 0x0150 }
            int r6 = r11.size()     // Catch:{ all -> 0x0150 }
            int r6 = r6 + -1
            if (r3 == r6) goto L_0x00ee
            java.lang.String r6 = "-"
            r2.append(r6)     // Catch:{ all -> 0x0150 }
        L_0x00ee:
            int r3 = r3 + 1
            goto L_0x00d4
        L_0x00f1:
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x0150 }
            r5.putString(r4, r11)     // Catch:{ all -> 0x0150 }
        L_0x00f8:
            r5.commit()     // Catch:{ all -> 0x0150 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r11 = k     // Catch:{ all -> 0x0150 }
            int r11 = r11.size()     // Catch:{ all -> 0x0150 }
            if (r11 > 0) goto L_0x010e
            java.lang.String r11 = "lpcf"
            r2 = 1
            r5.putBoolean(r11, r2)     // Catch:{ all -> 0x0150 }
            r5.commit()     // Catch:{ all -> 0x0150 }
            monitor-exit(r0)
            return r1
        L_0x010e:
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ all -> 0x0150 }
            r11.<init>()     // Catch:{ all -> 0x0150 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r2 = k     // Catch:{ all -> 0x0150 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0150 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0150 }
        L_0x011d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0150 }
            if (r3 == 0) goto L_0x014e
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0150 }
            com.baidu.sofire.core.ApkInfo r3 = (com.baidu.sofire.core.ApkInfo) r3     // Catch:{ all -> 0x0150 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0150 }
            r4.<init>()     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "pk"
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x0150 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "m"
            java.lang.String r6 = r3.apkMD5     // Catch:{ all -> 0x0150 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "l"
            int r6 = r3.key     // Catch:{ all -> 0x0150 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "v"
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x0150 }
            r4.put(r5, r3)     // Catch:{ all -> 0x0150 }
            r11.put(r4)     // Catch:{ all -> 0x0150 }
            goto L_0x011d
        L_0x014e:
            monitor-exit(r0)
            return r11
        L_0x0150:
            e.c.f.c.d()     // Catch:{ all -> 0x0155 }
            monitor-exit(r0)
            return r1
        L_0x0155:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.m(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|10|11|(5:16|17|(1:19)(3:20|(2:21|(3:23|(6:27|28|(1:29)|78|31|(2:70|40)(1:(2:42|76)(3:43|(4:46|(2:47|(2:49|(1:54)(2:79|53))(2:80|55))|(1:72)(2:57|(2:73|59)(1:60))|44)|77)))|69)(3:71|62|(1:66)(0)))|61)|67|83)(1:84)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC, Splitter:B:16:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e A[Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c, all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x008a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.PublicKey a(android.content.pm.PackageInfo r10, java.lang.String r11) {
        /*
            android.content.pm.Signature[] r10 = r10.signatures
            r0 = 0
            r1 = 0
            if (r10 == 0) goto L_0x002d
            int r2 = r10.length
            if (r2 <= 0) goto L_0x002d
            r2 = r10[r1]
            if (r2 == 0) goto L_0x002d
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "X.509"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2)     // Catch:{ all -> 0x002a }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002a }
            byte[] r10 = r10.toByteArray()     // Catch:{ all -> 0x002a }
            r3.<init>(r10)     // Catch:{ all -> 0x002a }
            java.security.cert.Certificate r10 = r2.generateCertificate(r3)     // Catch:{ all -> 0x002a }
            r3.close()     // Catch:{ all -> 0x0025 }
        L_0x0025:
            java.security.PublicKey r10 = r10.getPublicKey()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            e.c.f.c.d()
        L_0x002d:
            r10 = r0
        L_0x002e:
            if (r10 != 0) goto L_0x00cb
            boolean r10 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00ca }
            if (r10 == 0) goto L_0x0038
            goto L_0x00ca
        L_0x0038:
            r10 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r10]     // Catch:{ all -> 0x00ca }
            java.util.jar.JarFile r3 = new java.util.jar.JarFile     // Catch:{ all -> 0x00ca }
            r3.<init>(r11)     // Catch:{ all -> 0x00ca }
            java.util.Enumeration r11 = r3.entries()     // Catch:{ all -> 0x00ca }
            r4 = r0
        L_0x0046:
            boolean r5 = r11.hasMoreElements()     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x00bc
            java.lang.Object r5 = r11.nextElement()     // Catch:{ all -> 0x00ca }
            java.util.jar.JarEntry r5 = (java.util.jar.JarEntry) r5     // Catch:{ all -> 0x00ca }
            boolean r6 = r5.isDirectory()     // Catch:{ all -> 0x00ca }
            if (r6 != 0) goto L_0x0046
            java.lang.String r6 = r5.getName()     // Catch:{ all -> 0x00ca }
            java.lang.String r7 = "META-INF/"
            boolean r6 = r6.startsWith(r7)     // Catch:{ all -> 0x00ca }
            if (r6 != 0) goto L_0x0046
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
            java.io.InputStream r7 = r3.getInputStream(r5)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
        L_0x006d:
            int r7 = r6.read(r2, r1, r10)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
            r8 = -1
            if (r7 != r8) goto L_0x006d
            r6.close()     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
            java.security.cert.Certificate[] r5 = r5.getCertificates()     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0080, all -> 0x007c }
            goto L_0x0088
        L_0x007c:
            e.c.f.c.d()     // Catch:{ all -> 0x00ca }
            goto L_0x0087
        L_0x0080:
            e.c.f.c.d()     // Catch:{ all -> 0x00ca }
            goto L_0x0087
        L_0x0084:
            e.c.f.c.d()     // Catch:{ all -> 0x00ca }
        L_0x0087:
            r5 = r0
        L_0x0088:
            if (r5 != 0) goto L_0x008e
            r3.close()     // Catch:{ all -> 0x00ca }
            goto L_0x00ca
        L_0x008e:
            if (r4 != 0) goto L_0x0092
            r4 = r5
            goto L_0x0046
        L_0x0092:
            r6 = r1
        L_0x0093:
            int r7 = r4.length     // Catch:{ all -> 0x00ca }
            if (r6 >= r7) goto L_0x0046
            r7 = r1
        L_0x0097:
            int r8 = r5.length     // Catch:{ all -> 0x00ca }
            if (r7 >= r8) goto L_0x00ad
            r8 = r4[r6]     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x00aa
            r8 = r4[r6]     // Catch:{ all -> 0x00ca }
            r9 = r5[r7]     // Catch:{ all -> 0x00ca }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x00aa
            r7 = 1
            goto L_0x00ae
        L_0x00aa:
            int r7 = r7 + 1
            goto L_0x0097
        L_0x00ad:
            r7 = r1
        L_0x00ae:
            if (r7 == 0) goto L_0x00b8
            int r7 = r4.length     // Catch:{ all -> 0x00ca }
            int r8 = r5.length     // Catch:{ all -> 0x00ca }
            if (r7 == r8) goto L_0x00b5
            goto L_0x00b8
        L_0x00b5:
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00b8:
            r3.close()     // Catch:{ all -> 0x00ca }
            goto L_0x00ca
        L_0x00bc:
            r3.close()     // Catch:{ all -> 0x00ca }
            if (r4 == 0) goto L_0x00ca
            int r10 = r4.length     // Catch:{ all -> 0x00ca }
            if (r10 <= 0) goto L_0x00ca
            r10 = r4[r1]     // Catch:{ all -> 0x00ca }
            java.security.PublicKey r0 = r10.getPublicKey()     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r10 = r0
        L_0x00cb:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.pm.PackageInfo, java.lang.String):java.security.PublicKey");
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r1 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r1 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(java.lang.String r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0033 }
            r1.<init>(r6)     // Catch:{ all -> 0x0033 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x0034 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0034 }
            r6.<init>(r2)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r3 = 1
        L_0x0018:
            java.lang.String r4 = r6.readLine()     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x002b
            if (r3 != 0) goto L_0x0026
            r5 = 10
            r2.append(r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            r2.append(r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0018
        L_0x002b:
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0034 }
            r1.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            return r6
        L_0x0033:
            r1 = r0
        L_0x0034:
            e.c.f.c.d()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x003c:
            return r0
        L_0x003d:
            r6 = move-exception
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ all -> 0x0043 }
        L_0x0043:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.g(java.lang.String):java.lang.String");
    }

    public static String f(String str) {
        try {
            String str2 = new String(e.a("30212102dicudiab".getBytes(), Base64.decode(str, 10), true), "UTF-8");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        } catch (Throwable unused) {
            c.d();
        }
        return "";
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[Catch:{ all -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(java.lang.String r9) {
        /*
            java.lang.String r0 = "ses_ic"
            android.content.Context r1 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x00b8 }
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            android.content.Context r1 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "leroadcfg"
            r3 = 0
            r4 = 4
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x002b }
            android.content.SharedPreferences$Editor r6 = r5.edit()     // Catch:{ all -> 0x0028 }
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r2.edit()     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = "re_po_rt"
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r1.edit()     // Catch:{ all -> 0x0026 }
            goto L_0x0034
        L_0x0026:
            r1 = move-exception
            goto L_0x002e
        L_0x0028:
            r1 = move-exception
            r6 = r3
            goto L_0x002e
        L_0x002b:
            r1 = move-exception
            r5 = r3
            r6 = r5
        L_0x002e:
            r1.getMessage()     // Catch:{ all -> 0x00b8 }
            e.c.f.c.c()     // Catch:{ all -> 0x00b8 }
        L_0x0034:
            java.lang.String r1 = ""
            java.lang.String r1 = r5.getString(r0, r1)     // Catch:{ all -> 0x00b8 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b8 }
            r4 = 1
            if (r2 == 0) goto L_0x004e
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b8 }
            r1.put(r9, r2)     // Catch:{ all -> 0x00b8 }
            goto L_0x00a0
        L_0x004e:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0074 }
            r2.<init>(r1)     // Catch:{ all -> 0x0074 }
            java.util.Iterator r1 = r2.keys()     // Catch:{ all -> 0x0074 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0074 }
            r5.<init>()     // Catch:{ all -> 0x0074 }
        L_0x005c:
            boolean r7 = r1.hasNext()     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0072
            java.lang.Object r7 = r1.next()     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0074 }
            java.lang.Object r8 = r2.get(r7)     // Catch:{ all -> 0x0074 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0074 }
            r5.put(r7, r8)     // Catch:{ all -> 0x0074 }
            goto L_0x005c
        L_0x0072:
            r3 = r5
            goto L_0x0077
        L_0x0074:
            e.c.f.c.d()     // Catch:{ all -> 0x00b8 }
        L_0x0077:
            if (r3 == 0) goto L_0x009f
            int r1 = r3.size()     // Catch:{ all -> 0x00b8 }
            if (r1 <= 0) goto L_0x009f
            java.lang.Object r1 = r3.get(r9)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r3.get(r9)     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00b8 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00b8 }
            int r1 = r1 + r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00b8 }
            r3.put(r9, r1)     // Catch:{ all -> 0x00b8 }
            goto L_0x009f
        L_0x0098:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b8 }
            r3.put(r9, r1)     // Catch:{ all -> 0x00b8 }
        L_0x009f:
            r1 = r3
        L_0x00a0:
            if (r1 == 0) goto L_0x00b7
            int r9 = r1.size()     // Catch:{ all -> 0x00b8 }
            if (r9 <= 0) goto L_0x00b7
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00b8 }
            r9.<init>(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00b8 }
            r6.putString(r0, r9)     // Catch:{ all -> 0x00b8 }
            r6.commit()     // Catch:{ all -> 0x00b8 }
        L_0x00b7:
            return
        L_0x00b8:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.e(java.lang.String):void");
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(f7042g)) {
                f7042g = a(Process.myPid());
            }
            if (!str.equals(f7042g)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }

    public static String a(Class<?> cls) {
        try {
            if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                return Integer.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                return Boolean.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static boolean b(String str, String str2) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!new File(str2).exists()) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                StringBuilder sb = new StringBuilder("chmod ");
                sb.append(str);
                sb.append(" ");
                sb.append(str2);
                sb.append("\n");
                runtime.exec(sb.toString()).waitFor();
                z = true;
            } catch (Throwable unused) {
                c.d();
            }
        }
        return z;
    }

    public static void b(Context context) {
        String str = "0";
        try {
            Report instance = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            e.c.f.d.a a2 = e.c.f.d.a.a(context);
            HashMap hashMap = (HashMap) a2.b();
            jSONObject.put(str, hashMap.keySet());
            jSONObject.put("1", hashMap.values());
            new StringBuilder().append(jSONObject.toString());
            c.a();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put(str, jSONObject3);
            Map c2 = a2.c();
            JSONArray jSONArray = new JSONArray();
            for (String put : ((HashMap) c2).values()) {
                jSONArray.put(put);
            }
            jSONArray.put("com.baidu.sofire");
            new StringBuilder().append(jSONArray.toString());
            c.a();
            jSONObject2.put("2", jSONArray);
            instance.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
    }

    public static Class<?> a(String str) {
        try {
            if (str.contains(Integer.class.getCanonicalName())) {
                return Integer.TYPE;
            }
            if (str.contains(Boolean.class.getCanonicalName())) {
                return Boolean.TYPE;
            }
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode("2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q", 0), "30212102dicudiab".getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        InputStream inputStream;
        String str3 = "";
        try {
            Properties properties = new Properties();
            inputStream = null;
            try {
                InputStream open = context.getAssets().open(str);
                properties.load(open);
                str3 = properties.getProperty(str2);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            } catch (IOException e3) {
                e3.getMessage();
                c.c();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                    }
                }
            }
        } catch (Throwable unused) {
            c.d();
        }
        return str3;
        e.getMessage();
        c.c();
        return str3;
    }

    public static String a(byte[] bArr, int i2) {
        String str = "";
        if (bArr != null) {
            try {
                byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
                int length = bArr.length + bytes.length + 4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                int i3 = length - 4;
                int[] iArr = new int[i3];
                iArr[0] = i2;
                for (int i4 = 1; i4 < i3; i4++) {
                    iArr[i4] = ((iArr[i4 - 1] * 3) + 1) % 128;
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr2[i5] = (byte) (bArr2[i5] ^ ((byte) iArr[i5]));
                }
                byte[] bArr3 = new byte[4];
                bArr3[3] = (byte) (i2 & 255);
                bArr3[2] = (byte) ((i2 >> 8) & 255);
                bArr3[1] = (byte) ((i2 >> 16) & 255);
                bArr3[0] = (byte) (i2 >>> 24);
                System.arraycopy(bArr3, 0, bArr2, i3, 4);
                return Base64.encodeToString(bArr2, 9).replace("\n", str);
            } catch (Throwable unused) {
                c.d();
                return str;
            }
        } else {
            c.a();
            return str;
        }
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r4v2, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r6, int r7) {
        /*
            java.lang.String r0 = "tk_sa_pu_cl"
            java.lang.String r1 = ""
            java.lang.String r7 = java.lang.Integer.toHexString(r7)     // Catch:{ all -> 0x00b7 }
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b7 }
            r3 = 4
            if (r2 != 0) goto L_0x0039
            int r2 = r7.length()     // Catch:{ all -> 0x00b7 }
            int r2 = 4 - r2
            if (r2 <= 0) goto L_0x0039
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r4.<init>()     // Catch:{ all -> 0x00b7 }
        L_0x001c:
            if (r2 <= 0) goto L_0x0026
            java.lang.String r5 = "0"
            r4.append(r5)     // Catch:{ all -> 0x00b7 }
            int r2 = r2 + -1
            goto L_0x001c
        L_0x0026:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r2.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b7 }
            r2.append(r4)     // Catch:{ all -> 0x00b7 }
            r2.append(r7)     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00b7 }
        L_0x0039:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r2.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = l(r6)     // Catch:{ all -> 0x00b7 }
            r2.append(r4)     // Catch:{ all -> 0x00b7 }
            r2.append(r7)     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = "30212102dicudiab"
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b7 }
            byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x00b7 }
            byte[] r7 = e.c.d.n.e.e(r2, r7)     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = "leroadcfg"
            r4 = 0
            android.content.SharedPreferences r5 = r6.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x007e }
            android.content.SharedPreferences$Editor r4 = r5.edit()     // Catch:{ all -> 0x007a }
            android.content.SharedPreferences r2 = r6.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x007a }
            r2.edit()     // Catch:{ all -> 0x007a }
            java.lang.String r2 = "re_po_rt"
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x007a }
            r6.edit()     // Catch:{ all -> 0x007a }
            goto L_0x0088
        L_0x007a:
            r6 = move-exception
            r2 = r4
            r4 = r5
            goto L_0x0080
        L_0x007e:
            r6 = move-exception
            r2 = r4
        L_0x0080:
            r6.getMessage()     // Catch:{ all -> 0x00b7 }
            e.c.f.c.c()     // Catch:{ all -> 0x00b7 }
            r5 = r4
            r4 = r2
        L_0x0088:
            r6 = 0
            int r6 = r5.getInt(r0, r6)     // Catch:{ all -> 0x00b7 }
            int r6 = r6 + 1
            r4.putInt(r0, r6)     // Catch:{ all -> 0x00b7 }
            r4.commit()     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = a(r7, r6)     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r7.<init>()     // Catch:{ all -> 0x00b7 }
            r7.append(r6)     // Catch:{ all -> 0x00b7 }
            int r6 = r7.length()     // Catch:{ all -> 0x00b7 }
            int r6 = r6 + -2
            java.lang.String r0 = "A"
            r7.insert(r6, r0)     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = "\n"
            java.lang.String r6 = r6.replace(r7, r1)     // Catch:{ all -> 0x00b7 }
            return r6
        L_0x00b7:
            e.c.f.c.d()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, int):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3) {
        /*
            r0 = 1
            java.lang.String r1 = f7041f     // Catch:{ all -> 0x003e }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x003b
            int r1 = f7044i     // Catch:{ all -> 0x003e }
            if (r1 != r0) goto L_0x000e
            goto L_0x003b
        L_0x000e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r1.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r3.getPackageName()     // Catch:{ all -> 0x003e }
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = ".sofire.ac.provider"
            r1.append(r2)     // Catch:{ all -> 0x003e }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0037 }
            r2 = 0
            android.content.pm.ProviderInfo r3 = r3.resolveContentProvider(r1, r2)     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0041
            boolean r1 = r3.multiprocess     // Catch:{ all -> 0x0037 }
            if (r1 == r0) goto L_0x0041
            java.lang.String r3 = r3.processName     // Catch:{ all -> 0x0037 }
            f7041f = r3     // Catch:{ all -> 0x0037 }
            goto L_0x0041
        L_0x0037:
            e.c.f.c.d()     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003b:
            java.lang.String r3 = f7041f     // Catch:{ all -> 0x003e }
            return r3
        L_0x003e:
            e.c.f.c.d()
        L_0x0041:
            f7044i = r0
            java.lang.String r3 = f7041f
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r5 != 1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r5, boolean r6) {
        /*
            java.lang.Class<e.c.f.n.a> r0 = e.c.f.n.a.class
            monitor-enter(r0)
            r1 = 0
            int r2 = f7043h     // Catch:{ all -> 0x0031 }
            r3 = -1
            r4 = 1
            if (r2 == r3) goto L_0x0011
            int r5 = f7043h     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)
            if (r5 != r4) goto L_0x0010
            return r4
        L_0x0010:
            return r1
        L_0x0011:
            java.lang.String r2 = a(r5)     // Catch:{ all -> 0x0031 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0024
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0031 }
            boolean r5 = a(r5, r2, r4, r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0028
        L_0x0024:
            boolean r5 = a(r5, r2, r1, r6)     // Catch:{ all -> 0x0031 }
        L_0x0028:
            if (r5 == 0) goto L_0x002d
            f7043h = r4     // Catch:{ all -> 0x0031 }
            goto L_0x002f
        L_0x002d:
            f7043h = r1     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r0)
            return r5
        L_0x0031:
            e.c.f.c.d()     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)
            return r1
        L_0x0036:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f A[Catch:{ all -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, java.lang.String r7, boolean r8, boolean r9) {
        /*
            r0 = 0
            r1 = 1
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x002f }
            r2.<init>()     // Catch:{ all -> 0x002f }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ all -> 0x002f }
            java.lang.String r4 = r6.getPackageName()     // Catch:{ all -> 0x002f }
            java.lang.Class<com.baidu.sofire.MyService> r5 = com.baidu.sofire.MyService.class
            java.lang.String r5 = r5.getCanonicalName()     // Catch:{ all -> 0x002f }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x002f }
            r2.setComponent(r3)     // Catch:{ all -> 0x002f }
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch:{ all -> 0x002f }
            android.content.pm.ResolveInfo r2 = r3.resolveService(r2, r0)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0033
            android.content.pm.ServiceInfo r3 = r2.serviceInfo     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r3.processName     // Catch:{ all -> 0x0030 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0033
        L_0x002f:
            r2 = 0
        L_0x0030:
            e.c.f.c.d()
        L_0x0033:
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = "service"
            java.lang.String r2 = a(r6, r7, r2)     // Catch:{ all -> 0x008a }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0042
            r0 = r1
        L_0x0042:
            java.lang.String r2 = f7042g     // Catch:{ all -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0054
            int r2 = android.os.Process.myPid()     // Catch:{ all -> 0x008a }
            java.lang.String r2 = a(r2)     // Catch:{ all -> 0x008a }
            f7042g = r2     // Catch:{ all -> 0x008a }
        L_0x0054:
            if (r9 == 0) goto L_0x008d
            java.lang.String r9 = f7042g     // Catch:{ all -> 0x008a }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x008d
            if (r0 == 0) goto L_0x0062
            if (r8 == 0) goto L_0x008d
        L_0x0062:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x008a }
            r7.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r9 = "0"
            if (r0 != 0) goto L_0x0074
            r1 = 2
            java.lang.String r1 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x008a }
            r7.put(r9, r1)     // Catch:{ all -> 0x008a }
            goto L_0x007d
        L_0x0074:
            if (r0 != 0) goto L_0x007d
            java.lang.String r1 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x008a }
            r7.put(r9, r1)     // Catch:{ all -> 0x008a }
        L_0x007d:
            if (r8 == 0) goto L_0x0084
            java.lang.String r8 = "1"
            r7.put(r8, r9)     // Catch:{ all -> 0x008a }
        L_0x0084:
            java.lang.String r8 = "1003140"
            a(r6, r8, r7)     // Catch:{ all -> 0x008a }
            goto L_0x008d
        L_0x008a:
            e.c.f.c.d()
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, java.lang.String, boolean, boolean):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:92|93|149) */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x0199 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:128:0x01de */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x0155 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ all -> 0x01e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "provider"
            r1 = 0
            java.lang.String r2 = r13.getPackageName()     // Catch:{ all -> 0x01e4 }
            r3 = 3
            android.content.Context r2 = r13.createPackageContext(r2, r3)     // Catch:{ all -> 0x01e4 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ all -> 0x01e4 }
            java.lang.String r3 = "AndroidManifest.xml"
            android.content.res.XmlResourceParser r2 = r2.openXmlResourceParser(r3)     // Catch:{ all -> 0x01e4 }
            if (r2 == 0) goto L_0x01e7
        L_0x0018:
            int r3 = r2.next()     // Catch:{ all -> 0x01e4 }
            r4 = 2
            r5 = 1
            if (r3 == r4) goto L_0x0026
            if (r3 == r5) goto L_0x0026
            e.c.f.c.a()     // Catch:{ all -> 0x01e4 }
            goto L_0x0018
        L_0x0026:
            if (r3 == r4) goto L_0x0029
            return r1
        L_0x0029:
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x01e4 }
            java.lang.String r6 = "manifest"
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x01e4 }
            if (r3 != 0) goto L_0x0036
            return r1
        L_0x0036:
            java.lang.String r3 = "package"
            java.lang.String r3 = r2.getAttributeValue(r1, r3)     // Catch:{ all -> 0x01e4 }
            if (r3 == 0) goto L_0x01e3
            int r6 = r3.length()     // Catch:{ all -> 0x01e4 }
            if (r6 != 0) goto L_0x0046
            goto L_0x01e3
        L_0x0046:
            int r6 = r3.length()     // Catch:{ all -> 0x01e4 }
            r7 = 0
            r10 = r5
            r8 = r7
            r9 = r8
        L_0x004e:
            if (r8 >= r6) goto L_0x0091
            char r11 = r3.charAt(r8)     // Catch:{ all -> 0x01e4 }
            r12 = 97
            if (r11 < r12) goto L_0x005c
            r12 = 122(0x7a, float:1.71E-43)
            if (r11 <= r12) goto L_0x0064
        L_0x005c:
            r12 = 65
            if (r11 < r12) goto L_0x0066
            r12 = 90
            if (r11 > r12) goto L_0x0066
        L_0x0064:
            r10 = r7
            goto L_0x007a
        L_0x0066:
            if (r10 != 0) goto L_0x0074
            r12 = 48
            if (r11 < r12) goto L_0x0070
            r12 = 57
            if (r11 <= r12) goto L_0x007a
        L_0x0070:
            r12 = 95
            if (r11 == r12) goto L_0x007a
        L_0x0074:
            r9 = 46
            if (r11 != r9) goto L_0x007d
            r9 = r5
            r10 = r9
        L_0x007a:
            int r8 = r8 + 1
            goto L_0x004e
        L_0x007d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e4 }
            java.lang.String r7 = "bad character '"
            r6.<init>(r7)     // Catch:{ all -> 0x01e4 }
            r6.append(r11)     // Catch:{ all -> 0x01e4 }
            java.lang.String r7 = "'"
            r6.append(r7)     // Catch:{ all -> 0x01e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01e4 }
            goto L_0x0097
        L_0x0091:
            if (r9 == 0) goto L_0x0095
            r6 = r1
            goto L_0x0097
        L_0x0095:
            java.lang.String r6 = "must have at least one '.' separator"
        L_0x0097:
            if (r6 == 0) goto L_0x00a2
            java.lang.String r6 = "android"
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x01e4 }
            if (r3 != 0) goto L_0x00a2
            return r1
        L_0x00a2:
            boolean r3 = r15.equals(r0)     // Catch:{ all -> 0x01e4 }
            java.lang.String r6 = "receiver"
            java.lang.String r7 = "service"
            if (r3 == 0) goto L_0x00b3
            java.lang.Class<com.baidu.sofire.MyProvider> r15 = com.baidu.sofire.MyProvider.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01e4 }
            goto L_0x00ce
        L_0x00b3:
            boolean r3 = r15.equals(r7)     // Catch:{ all -> 0x01e4 }
            if (r3 == 0) goto L_0x00c0
            java.lang.Class<com.baidu.sofire.MyService> r15 = com.baidu.sofire.MyService.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01e4 }
            goto L_0x00ce
        L_0x00c0:
            boolean r15 = r15.equals(r6)     // Catch:{ all -> 0x01e4 }
            if (r15 == 0) goto L_0x00cd
            java.lang.Class<com.baidu.sofire.MyReceiver> r15 = com.baidu.sofire.MyReceiver.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01e4 }
            goto L_0x00ce
        L_0x00cd:
            r15 = r1
        L_0x00ce:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e4 }
            r3.<init>()     // Catch:{ all -> 0x01e4 }
            r3.append(r15)     // Catch:{ all -> 0x01e4 }
            e.c.f.c.a()     // Catch:{ all -> 0x01e4 }
        L_0x00d9:
            int r3 = r2.next()     // Catch:{ all -> 0x01e4 }
            if (r3 == r5) goto L_0x01e7
            if (r3 == r4) goto L_0x00e2
            goto L_0x00d9
        L_0x00e2:
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x01e4 }
            boolean r8 = r0.equals(r3)     // Catch:{ all -> 0x01e4 }
            java.lang.String r9 = ":"
            java.lang.String r10 = "process"
            java.lang.String r11 = "name"
            java.lang.String r12 = "http://schemas.android.com/apk/res/android"
            if (r8 == 0) goto L_0x0159
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x0155 }
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = "multiprocess"
            java.lang.String r3 = r2.getAttributeValue(r12, r3)     // Catch:{ all -> 0x0155 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x0117
            java.lang.String r8 = "true"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0155 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x0117
            return r1
        L_0x0117:
            java.lang.String r3 = "authorities"
            java.lang.String r3 = r2.getAttributeValue(r12, r3)     // Catch:{ all -> 0x0155 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x0154
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0155 }
            if (r3 != 0) goto L_0x012a
            return r1
        L_0x012a:
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x0155 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x014f
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x0155 }
            if (r8 == 0) goto L_0x014e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r8.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x0155 }
            r8.append(r9)     // Catch:{ all -> 0x0155 }
            r8.append(r3)     // Catch:{ all -> 0x0155 }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x0155 }
            return r13
        L_0x014e:
            return r3
        L_0x014f:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x0155 }
            return r13
        L_0x0154:
            return r1
        L_0x0155:
            e.c.f.c.d()     // Catch:{ all -> 0x01e4 }
            goto L_0x00d9
        L_0x0159:
            boolean r8 = r7.equals(r3)     // Catch:{ all -> 0x01e4 }
            if (r8 == 0) goto L_0x019e
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x0199 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0199 }
            if (r8 != 0) goto L_0x00d9
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x0199 }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x0199 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0199 }
            if (r8 != 0) goto L_0x0194
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x0199 }
            if (r8 == 0) goto L_0x0193
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r8.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x0199 }
            r8.append(r9)     // Catch:{ all -> 0x0199 }
            r8.append(r3)     // Catch:{ all -> 0x0199 }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x0199 }
            return r13
        L_0x0193:
            return r3
        L_0x0194:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x0199 }
            return r13
        L_0x0199:
            e.c.f.c.d()     // Catch:{ all -> 0x01e4 }
            goto L_0x00d9
        L_0x019e:
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x01e4 }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x01de }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01de }
            if (r8 != 0) goto L_0x00d9
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x01de }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x01de }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01de }
            if (r8 != 0) goto L_0x01d9
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x01de }
            if (r8 == 0) goto L_0x01d8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01de }
            r8.<init>()     // Catch:{ all -> 0x01de }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x01de }
            r8.append(r9)     // Catch:{ all -> 0x01de }
            r8.append(r3)     // Catch:{ all -> 0x01de }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x01de }
            return r13
        L_0x01d8:
            return r3
        L_0x01d9:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x01de }
            return r13
        L_0x01de:
            e.c.f.c.d()     // Catch:{ all -> 0x01e4 }
            goto L_0x00d9
        L_0x01e3:
            return r1
        L_0x01e4:
            e.c.f.c.d()
        L_0x01e7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e A[SYNTHETIC, Splitter:B:38:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0078 A[SYNTHETIC, Splitter:B:43:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r5, java.io.File r6) {
        /*
            if (r5 == 0) goto L_0x0098
            if (r6 == 0) goto L_0x0098
            boolean r0 = a(r5)
            if (r0 != 0) goto L_0x000c
            goto L_0x0098
        L_0x000c:
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0015
            r6.delete()
        L_0x0015:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0068 }
            r1.<init>(r5)     // Catch:{ all -> 0x0068 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0065 }
            r2.<init>(r6)     // Catch:{ all -> 0x0065 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0066 }
        L_0x0024:
            int r3 = r1.read(r0)     // Catch:{ all -> 0x0066 }
            r4 = -1
            if (r3 == r4) goto L_0x0030
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ all -> 0x0066 }
            goto L_0x0024
        L_0x0030:
            r2.flush()     // Catch:{ all -> 0x0066 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r0.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0066 }
            r0.append(r5)     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = " > "
            r0.append(r5)     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ all -> 0x0066 }
            r0.append(r5)     // Catch:{ all -> 0x0066 }
            e.c.f.c.a()     // Catch:{ all -> 0x0066 }
            r1.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0059
        L_0x0052:
            r5 = move-exception
            r5.getMessage()
            e.c.f.c.c()
        L_0x0059:
            r2.close()     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r5 = move-exception
            r5.getMessage()
            e.c.f.c.c()
            return
        L_0x0065:
            r2 = r0
        L_0x0066:
            r0 = r1
            goto L_0x0069
        L_0x0068:
            r2 = r0
        L_0x0069:
            e.c.f.c.d()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r5 = move-exception
            r5.getMessage()
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ all -> 0x005d }
        L_0x007b:
            return
        L_0x007c:
            r5 = move-exception
            if (r0 == 0) goto L_0x008a
            r0.close()     // Catch:{ all -> 0x0083 }
            goto L_0x008a
        L_0x0083:
            r6 = move-exception
            r6.getMessage()
            e.c.f.c.c()
        L_0x008a:
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0090:
            r6 = move-exception
            r6.getMessage()
            e.c.f.c.c()
        L_0x0097:
            throw r5
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(java.io.File, java.io.File):void");
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085 A[LOOP:0: B:10:0x0028->B:45:0x0085, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0083 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r11, java.lang.String r12, java.lang.Class<?>[] r13, java.lang.Object... r14) throws java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        /*
            if (r11 == 0) goto L_0x00a6
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x00a6
            if (r13 == 0) goto L_0x001c
            if (r14 == 0) goto L_0x001c
            int r0 = r13.length
            int r1 = r14.length
            if (r0 != r1) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            e.c.f.c.a()
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            java.lang.String r12 = "paramTypes or args fail"
            r11.<init>(r12)
            throw r11
        L_0x001c:
            java.lang.Class r0 = r11.getClass()
            java.lang.reflect.Method[] r0 = r0.getDeclaredMethods()
            r1 = 0
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x0028:
            if (r4 >= r2) goto L_0x0088
            r5 = r0[r4]
            java.lang.String r6 = r5.getName()
            boolean r6 = r12.equals(r6)
            r7 = 1
            if (r6 != 0) goto L_0x0039
        L_0x0037:
            r7 = r3
            goto L_0x0081
        L_0x0039:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r12)
            e.c.f.c.a()
            java.lang.Class[] r6 = r5.getParameterTypes()
            if (r6 == 0) goto L_0x004d
            int r8 = r6.length
            if (r8 != 0) goto L_0x0053
        L_0x004d:
            if (r13 == 0) goto L_0x0081
            int r8 = r13.length
            if (r8 != 0) goto L_0x0053
            goto L_0x0081
        L_0x0053:
            if (r13 == 0) goto L_0x0058
            int r8 = r13.length
            if (r8 != 0) goto L_0x005e
        L_0x0058:
            if (r6 == 0) goto L_0x005e
            int r8 = r6.length
            if (r8 <= 0) goto L_0x005e
            goto L_0x0037
        L_0x005e:
            if (r6 == 0) goto L_0x0063
            int r8 = r6.length
            if (r8 != 0) goto L_0x0069
        L_0x0063:
            if (r13 == 0) goto L_0x0069
            int r8 = r13.length
            if (r8 <= 0) goto L_0x0069
            goto L_0x0037
        L_0x0069:
            if (r6 == 0) goto L_0x0037
            if (r13 != 0) goto L_0x006e
            goto L_0x0037
        L_0x006e:
            int r8 = r6.length
            int r9 = r13.length
            if (r8 == r9) goto L_0x0073
            goto L_0x0037
        L_0x0073:
            r8 = r3
        L_0x0074:
            int r9 = r6.length
            if (r8 >= r9) goto L_0x0081
            r9 = r6[r8]
            r10 = r13[r8]
            if (r9 == r10) goto L_0x007e
            goto L_0x0037
        L_0x007e:
            int r8 = r8 + 1
            goto L_0x0074
        L_0x0081:
            if (r7 == 0) goto L_0x0085
            r1 = r5
            goto L_0x0088
        L_0x0085:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0088:
            if (r1 == 0) goto L_0x008f
            java.lang.Object r11 = r1.invoke(r11, r14)
            return r11
        L_0x008f:
            e.c.f.c.a()
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "cannot find method in target methodName="
            r13.<init>(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.<init>(r12)
            throw r11
        L_0x00a6:
            e.c.f.c.a()
            java.lang.NoSuchMethodException r13 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "object="
            r14.<init>(r0)
            r14.append(r11)
            java.lang.String r11 = ", methodName="
            r14.append(r11)
            r14.append(r12)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(java.lang.Object, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public static void a(String str, boolean z) {
        String str2 = "771";
        boolean b2 = b(str2, str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = ",s=";
        sb.append(str3);
        sb.append(b2);
        c.a();
        if (z) {
            String absolutePath = new File(str).getParentFile().getAbsolutePath();
            b(str2, absolutePath);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(absolutePath);
            sb2.append(str3);
            sb2.append(b2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A[SYNTHETIC, Splitter:B:19:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088 A[Catch:{ all -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00a7 }
            r2.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "0"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "1"
            r2.put(r3, r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "2"
            r2.put(r3, r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String[] r0 = e(r8)     // Catch:{ all -> 0x00a7 }
            r3 = 1
            java.lang.String r4 = "3"
            r5 = 0
            if (r0 == 0) goto L_0x0047
            int r6 = r0.length     // Catch:{ all -> 0x00a7 }
            r7 = 2
            if (r6 != r7) goto L_0x0047
            r6 = r0[r5]     // Catch:{ all -> 0x00a7 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a7 }
            if (r6 != 0) goto L_0x0047
            r6 = r0[r3]     // Catch:{ all -> 0x00a7 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a7 }
            if (r6 != 0) goto L_0x0047
            r0 = r0[r5]     // Catch:{ all -> 0x00a7 }
            goto L_0x0048
        L_0x0047:
            r0 = r4
        L_0x0048:
            r2.put(r4, r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "4"
            r2.put(r0, r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "5"
            r2.put(r0, r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "6"
            r2.put(r0, r3)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "7"
            r2.put(r0, r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "8"
            java.lang.String r3 = "sofire"
            r2.put(r0, r3)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "3.3.9.8.2"
            java.lang.String r3 = "9"
            r2.put(r3, r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "10"
            r2.put(r0, r9)     // Catch:{ all -> 0x00a7 }
            java.lang.String r9 = "Common_section"
            r1.put(r9, r2)     // Catch:{ all -> 0x00a7 }
            int r9 = r10.size()     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "Module_section"
            if (r9 <= 0) goto L_0x0088
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00a7 }
            r9.<init>(r10)     // Catch:{ all -> 0x00a7 }
            r1.put(r0, r9)     // Catch:{ all -> 0x00a7 }
            goto L_0x0090
        L_0x0088:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00a7 }
            r9.<init>()     // Catch:{ all -> 0x00a7 }
            r1.put(r0, r9)     // Catch:{ all -> 0x00a7 }
        L_0x0090:
            com.baidu.sofire.rp.Report r8 = com.baidu.sofire.rp.Report.getInstance(r8)     // Catch:{ all -> 0x00a7 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r10.<init>()     // Catch:{ all -> 0x00a7 }
            r10.append(r9)     // Catch:{ all -> 0x00a7 }
            e.c.f.c.a()     // Catch:{ all -> 0x00a7 }
            r8.s(r9)     // Catch:{ all -> 0x00a7 }
            return
        L_0x00a7:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] e2 = e(context);
            if (e2 != null && e2.length == 2) {
                if (!TextUtils.isEmpty(e2[0]) && !TextUtils.isEmpty(e2[1]) && "200080".equals(e2[0]) && context.getPackageName().equals("com.baidu.BaiduMap") && bArr != null) {
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr[i2] = (byte) (bArr[i2] ^ 246);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) {
            return false;
        }
        return true;
    }

    public static String a(int i2) {
        String str;
        try {
            str = g(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(i2)}));
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str.trim();
                }
            } catch (Throwable unused) {
                c.d();
                return str;
            }
        } catch (Throwable unused2) {
            str = null;
            c.d();
            return str;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        e.c.f.c.d();
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a1, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        e.c.f.c.d();
        r13 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0208, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0151 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0174 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x01e0 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109 A[SYNTHETIC, Splitter:B:48:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010d A[Catch:{ all -> 0x01a1, all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013f A[SYNTHETIC, Splitter:B:54:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015b A[Catch:{ all -> 0x01a1, all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d4 A[SYNTHETIC, Splitter:B:85:0x01d4] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d8 A[Catch:{ all -> 0x01a1, all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f7 A[SYNTHETIC, Splitter:B:95:0x01f7] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01fb A[Catch:{ all -> 0x01a1, all -> 0x0208 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r19, org.json.JSONObject r20) {
        /*
            r1 = r19
            r2 = r20
            java.lang.String r3 = "xyglsn"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = "Common_section"
            org.json.JSONObject r0 = r2.getJSONObject(r0)     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            e.c.f.c.d()
            r0 = 0
        L_0x001a:
            java.lang.String r8 = "9"
            java.lang.String r9 = "8"
            java.lang.String r10 = "3"
            java.lang.String r11 = "1"
            java.lang.String r12 = "10"
            java.lang.String r13 = ""
            if (r0 == 0) goto L_0x0047
            java.lang.String r5 = r0.optString(r12)
            java.lang.String r6 = "0"
            long r14 = r0.optLong(r6)
            java.lang.String r6 = r0.optString(r11)
            java.lang.String r16 = r0.optString(r10)
            java.lang.String r17 = r0.optString(r9)
            java.lang.String r0 = r0.optString(r8)
            r7 = r16
            r2 = r17
            goto L_0x004d
        L_0x0047:
            r14 = r5
            r0 = r13
            r2 = r0
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x004d:
            r17 = r3
            android.content.pm.ApplicationInfo r3 = r19.getApplicationInfo()     // Catch:{ all -> 0x0062 }
            r18 = r13
            android.content.pm.PackageManager r13 = r19.getPackageManager()     // Catch:{ all -> 0x0064 }
            java.lang.CharSequence r3 = r3.loadLabel(r13)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0064 }
            goto L_0x0069
        L_0x0062:
            r18 = r13
        L_0x0064:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
            r3 = r18
        L_0x0069:
            r4.put(r11, r3)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "2"
            java.lang.String r11 = r19.getPackageName()     // Catch:{ all -> 0x0208 }
            r4.put(r3, r11)     // Catch:{ all -> 0x0208 }
            android.content.pm.PackageManager r3 = r19.getPackageManager()     // Catch:{ all -> 0x0086 }
            java.lang.String r11 = r19.getPackageName()     // Catch:{ all -> 0x0086 }
            r13 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r11, r13)     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x0086 }
            goto L_0x008b
        L_0x0086:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "1.0.0"
        L_0x008b:
            r4.put(r10, r3)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "4"
            java.lang.String r10 = e.c.f.n.c.b(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r3, r10)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "5"
            r4.put(r3, r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "6"
            r4.put(r3, r14)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "7"
            r4.put(r3, r6)     // Catch:{ all -> 0x0208 }
            r4.put(r9, r7)     // Catch:{ all -> 0x0208 }
            r4.put(r8, r2)     // Catch:{ all -> 0x0208 }
            r4.put(r12, r0)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "leroadcfg"
            r2 = 4
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r0, r2)     // Catch:{ all -> 0x00d6 }
            r3.edit()     // Catch:{ all -> 0x00d6 }
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r0, r2)     // Catch:{ all -> 0x00d6 }
            android.content.SharedPreferences$Editor r5 = r3.edit()     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "re_po_rt"
            android.content.SharedPreferences r7 = r1.getSharedPreferences(r0, r2)     // Catch:{ all -> 0x00cf }
            r7.edit()     // Catch:{ all -> 0x00cb }
            goto L_0x00e3
        L_0x00cb:
            r0 = move-exception
            r16 = r5
            goto L_0x00db
        L_0x00cf:
            r0 = move-exception
            r16 = r5
            r7 = 0
            goto L_0x00db
        L_0x00d4:
            r0 = move-exception
            goto L_0x00d8
        L_0x00d6:
            r0 = move-exception
            r3 = 0
        L_0x00d8:
            r7 = 0
            r16 = 0
        L_0x00db:
            r0.getMessage()     // Catch:{ all -> 0x0208 }
            e.c.f.c.c()     // Catch:{ all -> 0x0208 }
            r5 = r16
        L_0x00e3:
            java.lang.String r0 = "11"
            java.lang.String r6 = "re_a_cv"
            r8 = r18
            java.lang.String r6 = r7.getString(r6, r8)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r6)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "12"
            java.lang.String r6 = "re_a_lc"
            java.lang.String r6 = r7.getString(r6, r8)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r6)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "13"
            r6 = 1
            r4.put(r0, r6)     // Catch:{ all -> 0x0208 }
            int r0 = g(r19)     // Catch:{ all -> 0x0208 }
            java.lang.String r7 = "14"
            if (r0 != r2) goto L_0x010d
            r4.put(r7, r6)     // Catch:{ all -> 0x0208 }
            goto L_0x0111
        L_0x010d:
            r0 = 2
            r4.put(r7, r0)     // Catch:{ all -> 0x0208 }
        L_0x0111:
            java.lang.String r0 = "20"
            java.lang.String r2 = e.c.f.n.c.d(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "21"
            java.lang.String r2 = e.c.f.n.c.g(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "22"
            java.lang.String r2 = e.c.f.n.c.c(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            r2 = r17
            java.lang.String r0 = r3.getString(r2, r8)     // Catch:{ all -> 0x0208 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0208 }
            r9 = 10
            java.lang.String r10 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            java.lang.String r11 = "UTF-8"
            if (r7 == 0) goto L_0x013f
            goto L_0x0154
        L_0x013f:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0151 }
            byte[] r12 = r10.getBytes()     // Catch:{ all -> 0x0151 }
            byte[] r0 = android.util.Base64.decode(r0, r9)     // Catch:{ all -> 0x0151 }
            byte[] r0 = e.c.d.n.e.a(r12, r0, r6)     // Catch:{ all -> 0x0151 }
            r7.<init>(r0, r11)     // Catch:{ all -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
        L_0x0154:
            r7 = r8
        L_0x0155:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x01a4
            java.lang.String r0 = "xygls"
            java.lang.String r0 = r3.getString(r0, r8)     // Catch:{ all -> 0x0208 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x0177
            java.lang.String r0 = e.c.f.n.e.a(r19)     // Catch:{ all -> 0x0173 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x0177
            r0 = r8
            goto L_0x0177
        L_0x0173:
            r0 = r8
        L_0x0174:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
        L_0x0177:
            r7 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x0185
            r5.putString(r2, r8)     // Catch:{ all -> 0x0208 }
            r5.commit()     // Catch:{ all -> 0x0208 }
            goto L_0x01a4
        L_0x0185:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x01a1 }
            byte[] r3 = r10.getBytes()     // Catch:{ all -> 0x01a1 }
            byte[] r6 = r7.getBytes(r11)     // Catch:{ all -> 0x01a1 }
            byte[] r3 = e.c.d.n.e.b(r3, r6)     // Catch:{ all -> 0x01a1 }
            byte[] r3 = android.util.Base64.encode(r3, r9)     // Catch:{ all -> 0x01a1 }
            r0.<init>(r3, r11)     // Catch:{ all -> 0x01a1 }
            r5.putString(r2, r0)     // Catch:{ all -> 0x0208 }
            r5.commit()     // Catch:{ all -> 0x0208 }
            goto L_0x01a4
        L_0x01a1:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
        L_0x01a4:
            java.lang.String r0 = "32"
            r4.put(r0, r7)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "25"
            java.lang.String r2 = e.c.f.n.n.a(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "26"
            java.lang.String r2 = e.c.f.n.n.b(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "28"
            java.lang.String r2 = e.c.f.n.i.a(r19)     // Catch:{ all -> 0x0208 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0208 }
            e.c.f.n.k r0 = e.c.f.n.k.a(r19)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0208 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "30"
            if (r2 == 0) goto L_0x01d8
            r4.put(r3, r8)     // Catch:{ all -> 0x0208 }
            goto L_0x01db
        L_0x01d8:
            r4.put(r3, r0)     // Catch:{ all -> 0x0208 }
        L_0x01db:
            java.lang.String r13 = e.c.a.a.b.b.a(r19)     // Catch:{ all -> 0x01e0 }
            goto L_0x01e4
        L_0x01e0:
            e.c.f.c.d()     // Catch:{ all -> 0x0208 }
            r13 = r8
        L_0x01e4:
            java.lang.String r0 = "23"
            r4.put(r0, r13)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "Module_section"
            r1 = r20
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0208 }
            boolean r1 = r0 instanceof org.json.JSONArray     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = "module_section"
            if (r1 == 0) goto L_0x01fb
            r4.put(r2, r0)     // Catch:{ all -> 0x0208 }
            goto L_0x020b
        L_0x01fb:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x0208 }
            r1.<init>()     // Catch:{ all -> 0x0208 }
            org.json.JSONArray r0 = r1.put(r0)     // Catch:{ all -> 0x0208 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0208 }
            goto L_0x020b
        L_0x0208:
            e.c.f.c.d()
        L_0x020b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        b.a(context).a();
        b a2 = b.a(context);
        Message message = new Message();
        message.what = 8;
        a2.f7048a.f7030a.sendMessage(message);
        b bVar = new b();
        bVar.f6997a = str;
        bVar.f6998b = str2;
        bVar.f6999c = str3;
        bVar.f7000d = str4;
        bVar.f7001e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            i iVar = new i(context);
            List h2 = iVar.h();
            if (h2 == null) {
                iVar.a(bVar);
            } else if (!h2.contains(bVar)) {
                iVar.a(bVar);
            } else {
                int indexOf = h2.indexOf(bVar);
                if (indexOf != -1) {
                    b bVar2 = (b) h2.get(indexOf);
                    if (bVar2 != null) {
                        String a3 = b.a(bVar2);
                        String a4 = b.a(bVar);
                        String str6 = "re_con";
                        iVar.f7012f.putString(str6, iVar.f7011e.getString(str6, "").replace(a3, a4));
                        iVar.f7012f.commit();
                    }
                }
                e.c.f.m.a aVar = b.a(context).f7048a;
                Message message2 = new Message();
                message2.what = 7;
                aVar.f7030a.sendMessage(message2);
            }
            String str7 = bVar.f7001e;
            SharedPreferences sharedPreferences = iVar.f7011e;
            StringBuilder sb = new StringBuilder("re_net_ins_");
            sb.append(str7);
            if (!sharedPreferences.getBoolean(sb.toString(), false)) {
                b a5 = b.a(context);
                Message message3 = new Message();
                message3.what = 3;
                message3.obj = bVar;
                a5.f7048a.f7030a.sendMessage(message3);
            }
            e.c.f.m.a aVar2 = b.a(context).f7048a;
            Message message4 = new Message();
            message4.what = 7;
            aVar2.f7030a.sendMessage(message4);
            b.a(context).b();
        }
    }

    public static void a(Context context, String str) {
        JSONObject jSONObject;
        SharedPreferences sharedPreferences;
        try {
            jSONObject = new JSONObject(str);
            sharedPreferences = null;
            String str2 = "leroadcfg";
            context.getSharedPreferences(str2, 4).edit();
            context.getSharedPreferences(str2, 4).edit();
            sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            sharedPreferences.edit();
        } catch (Throwable unused) {
            c.d();
            return;
        }
        System.currentTimeMillis();
        sharedPreferences.getInt("re_net_ty", 2);
        JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
        long optLong = optJSONObject.optLong("0");
        String optString = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        int optInt = optJSONObject.optInt("5");
        int optInt2 = optJSONObject.optInt(Constants.VIA_SHARE_TYPE_INFO);
        int optInt3 = optJSONObject.optInt("7");
        int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        String str3 = "";
        if (optInt2 == 0) {
            optInt2 = 1;
        }
        e.c.f.j.a aVar = new e.c.f.j.a();
        aVar.f7017d = str;
        aVar.f7015b = optString;
        aVar.f7020g = optInt;
        aVar.f7016c = 3;
        aVar.f7018e = optLong;
        aVar.f7019f = optInt2;
        aVar.f7021h = optInt3;
        aVar.f7022i = optInt4;
        aVar.f7023j = str3;
        b a2 = b.a(context);
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        a2.f7048a.f7030a.sendMessage(message);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062 A[SYNTHETIC, Splitter:B:12:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "0"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0077 }
            r2.<init>()     // Catch:{ all -> 0x0077 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0077 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "1"
            r2.put(r3, r0)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "2"
            r2.put(r3, r0)     // Catch:{ all -> 0x0077 }
            java.lang.String[] r6 = e(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r0 = "3"
            r3 = 0
            if (r6 == 0) goto L_0x0030
            int r4 = r6.length     // Catch:{ all -> 0x0077 }
            r5 = 2
            if (r4 != r5) goto L_0x0030
            r6 = r6[r3]     // Catch:{ all -> 0x0077 }
            r2.put(r0, r6)     // Catch:{ all -> 0x0077 }
            goto L_0x0033
        L_0x0030:
            r2.put(r0, r0)     // Catch:{ all -> 0x0077 }
        L_0x0033:
            java.lang.String r6 = "4"
            r2.put(r6, r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "5"
            r2.put(r6, r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "6"
            r0 = 1
            r2.put(r6, r0)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "7"
            r2.put(r6, r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "8"
            r2.put(r6, r7)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "9"
            r2.put(r6, r8)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "10"
            r2.put(r6, r9)     // Catch:{ all -> 0x0077 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0077 }
            r6.<init>()     // Catch:{ all -> 0x0077 }
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0077 }
            if (r7 != 0) goto L_0x006c
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0069 }
            r7.<init>(r10)     // Catch:{ all -> 0x0069 }
            r6 = r7
            goto L_0x006c
        L_0x0069:
            e.c.f.c.d()     // Catch:{ all -> 0x0077 }
        L_0x006c:
            java.lang.String r7 = "Common_section"
            r1.put(r7, r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "Module_section"
            r1.put(r7, r6)     // Catch:{ all -> 0x0077 }
            goto L_0x007a
        L_0x0077:
            e.c.f.c.d()
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.a.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    public static void a(Context context, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.b.r.p");
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable unused) {
            c.d();
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j2, broadcast);
        } catch (Throwable unused2) {
            c.d();
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                StringBuilder sb = new StringBuilder("0");
                sb.append(hexString);
                hexString = sb.toString();
            }
            StringBuilder a2 = e.a.a.a.a.a(str);
            a2.append(hexString.toUpperCase());
            str = a2.toString();
        }
        return str;
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".permission.sofire.RECEIVE");
            context.registerReceiver(broadcastReceiver, intentFilter, sb.toString(), null);
            return true;
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }
}
