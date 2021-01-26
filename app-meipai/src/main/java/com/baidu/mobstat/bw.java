package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidu.mobstat.bm.b;
import com.baidu.mobstat.bt.a;
import com.baidu.sapi2.SapiAccount;
import com.gyf.immersionbar.OSUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class bw {

    /* renamed from: a reason: collision with root package name */
    public static String f1765a;

    /* renamed from: b reason: collision with root package name */
    public static String f1766b;

    /* renamed from: c reason: collision with root package name */
    public static String f1767c;

    /* renamed from: d reason: collision with root package name */
    public static final Pattern f1768d = Pattern.compile("\\s*|\t|\r|\n");

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = null;
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    obj = bundle.get(str);
                }
                if (obj == null) {
                    bc c2 = bc.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("can't find information in AndroidManifest.xml for key ");
                    sb.append(str);
                    c2.a(sb.toString());
                    return str2;
                }
                str2 = obj.toString();
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static String b(Context context) {
        return a.a(a(context).getBytes()).toUpperCase(Locale.US);
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception unused) {
        }
        return displayMetrics.widthPixels;
    }

    public static int d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception unused) {
        }
        return displayMetrics.heightPixels;
    }

    public static DisplayMetrics e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        String str = "%d";
        String str2 = "";
        Integer valueOf = Integer.valueOf(0);
        String str3 = "%s_%s_%s";
        String format = String.format(str3, new Object[]{valueOf, valueOf, valueOf});
        try {
            if (bo.e(context, "android.permission.ACCESS_FINE_LOCATION") || bo.e(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService(SapiAccount.f2185e)).getCellLocation();
                if (cellLocation == null) {
                    return format;
                }
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format(str3, new Object[]{String.format(str, new Object[]{Integer.valueOf(gsmCellLocation.getCid())}), String.format(str, new Object[]{Integer.valueOf(gsmCellLocation.getLac())}), valueOf});
                }
                String[] split = cellLocation.toString().replace("[", str2).replace("]", str2).split(",");
                return String.format(str3, new Object[]{split[0], split[3], split[4]});
            }
        } catch (Exception unused) {
        }
        return format;
    }

    public static String j(Context context) {
        try {
            if (bo.e(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation(ExtraMetadataKey.kGps);
                if (lastKnownLocation != null) {
                    return String.format("%s_%s_%s", new Object[]{Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude())});
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String k(Context context) {
        return d();
    }

    public static String l(Context context) {
        try {
            if (bo.e(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(macAddress)) {
                        return macAddress;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String m(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String name = defaultAdapter.getName();
                if (name != null) {
                    return name;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    public static String n(Context context) {
        String str = Build.BRAND;
        String str2 = "";
        if ("4.1.1".equals(VERSION.RELEASE) && "TCT".equals(str)) {
            return str2;
        }
        try {
            if (bo.e(context, "android.permission.BLUETOOTH")) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    String address = defaultAdapter.getAddress();
                    if (address != null) {
                        return address;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static String o(Context context) {
        String p = p(context);
        if (TextUtils.isEmpty(p)) {
            return "";
        }
        return bm.a.a(p.getBytes());
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0 A[ADDED_TO_REGION, EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  
EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  
EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  
EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0 A[ADDED_TO_REGION, EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  
EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  
EDGE_INSN: B:58:0x00b0->B:46:0x00b0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(android.content.Context r15) {
        /*
            java.lang.String r0 = ""
            if (r15 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            boolean r1 = com.baidu.mobstat.bo.e(r15, r1)
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r1 = 0
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = com.baidu.mobstat.bo.e(r15, r2)     // Catch:{ Exception -> 0x0026 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = "location"
            java.lang.Object r2 = r15.getSystemService(r2)     // Catch:{ Exception -> 0x0026 }
            android.location.LocationManager r2 = (android.location.LocationManager) r2     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "gps"
            boolean r2 = r2.isProviderEnabled(r3)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            r3 = 0
            java.lang.String r4 = "wifi"
            java.lang.Object r4 = r15.getSystemService(r4)     // Catch:{ all -> 0x0039 }
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ all -> 0x0039 }
            android.net.wifi.WifiInfo r5 = r4.getConnectionInfo()     // Catch:{ all -> 0x0039 }
            java.util.List r4 = r4.getScanResults()     // Catch:{ all -> 0x003a }
            goto L_0x003b
        L_0x0039:
            r5 = r3
        L_0x003a:
            r4 = r3
        L_0x003b:
            if (r4 == 0) goto L_0x004b
            int r6 = r4.size()
            if (r6 == 0) goto L_0x004b
            com.baidu.mobstat.bw$1 r6 = new com.baidu.mobstat.bw$1
            r6.<init>()
            java.util.Collections.sort(r4, r6)
        L_0x004b:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            r7 = r1
        L_0x0051:
            r8 = 1
            java.lang.String r9 = "|"
            if (r4 == 0) goto L_0x00b0
            int r10 = r4.size()
            if (r7 >= r10) goto L_0x00b0
            r10 = 30
            if (r7 >= r10) goto L_0x00b0
            java.lang.Object r11 = r4.get(r7)     // Catch:{ Exception -> 0x00ad }
            android.net.wifi.ScanResult r11 = (android.net.wifi.ScanResult) r11     // Catch:{ Exception -> 0x00ad }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ad }
            r12.<init>()     // Catch:{ Exception -> 0x00ad }
            java.lang.String r13 = r11.BSSID     // Catch:{ Exception -> 0x00ad }
            r12.append(r13)     // Catch:{ Exception -> 0x00ad }
            r12.append(r9)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r13 = r11.SSID     // Catch:{ Exception -> 0x00ad }
            java.lang.String r14 = "\\|"
            java.lang.String r13 = r13.replaceAll(r14, r0)     // Catch:{ Exception -> 0x00ad }
            int r14 = r13.length()     // Catch:{ Exception -> 0x00ad }
            if (r14 <= r10) goto L_0x0085
            java.lang.String r13 = r13.substring(r1, r10)     // Catch:{ Exception -> 0x00ad }
        L_0x0085:
            r12.append(r13)     // Catch:{ Exception -> 0x00ad }
            r12.append(r9)     // Catch:{ Exception -> 0x00ad }
            int r10 = r11.level     // Catch:{ Exception -> 0x00ad }
            r12.append(r10)     // Catch:{ Exception -> 0x00ad }
            r12.append(r9)     // Catch:{ Exception -> 0x00ad }
            if (r5 == 0) goto L_0x00a2
            java.lang.String r9 = r11.BSSID     // Catch:{ Exception -> 0x00ad }
            java.lang.String r10 = r5.getBSSID()     // Catch:{ Exception -> 0x00ad }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x00ad }
            if (r9 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r8 = r1
        L_0x00a3:
            r12.append(r8)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r8 = r12.toString()     // Catch:{ Exception -> 0x00ad }
            r6.put(r8)     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            int r7 = r7 + 1
            goto L_0x0051
        L_0x00b0:
            int r4 = r6.length()
            if (r4 != 0) goto L_0x00b7
            return r3
        L_0x00b7:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee }
            r4.<init>()     // Catch:{ Exception -> 0x00ee }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ee }
            r4.append(r10)     // Catch:{ Exception -> 0x00ee }
            r4.append(r9)     // Catch:{ Exception -> 0x00ee }
            if (r2 == 0) goto L_0x00ce
            r1 = r8
        L_0x00ce:
            r4.append(r1)     // Catch:{ Exception -> 0x00ee }
            r4.append(r9)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r15 = j(r15)     // Catch:{ Exception -> 0x00ee }
            r4.append(r15)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r15 = "ap-list"
            r3.put(r15, r6)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r15 = "meta-data"
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00ee }
            r3.put(r15, r1)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r15 = r3.toString()     // Catch:{ Exception -> 0x00ee }
            return r15
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bw.p(android.content.Context):java.lang.String");
    }

    public static boolean q(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String r(Context context) {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            String typeName = activeNetworkInfo.getTypeName();
            return (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean s(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (bo.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isAvailable();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String t(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String u(Context context) {
        String str = f1766b;
        if (str == null) {
            String y = y(context);
            String b2 = b(context, y);
            if (TextUtils.isEmpty(b2)) {
                b2 = c(context, y);
            }
            str = b2 == null ? "" : b2;
            f1766b = str;
        }
        return str;
    }

    public static String v(Context context) {
        String str;
        String y = y(context);
        String str2 = "";
        if (y == null) {
            return str2;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (Exception unused) {
        }
        if (packageInfo == null) {
            return str2;
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr == null) {
            return str2;
        }
        int length = serviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = str2;
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i2];
            if (y.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
            i2++;
        }
        if (str != null) {
            str2 = str;
        }
        return str2;
    }

    public static boolean w(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String x(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.MODEL, memoryInfo.availMem);
            jSONObject.put("l", memoryInfo.lowMemory);
            jSONObject.put("t", memoryInfo.threshold);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_mem", jSONArray);
            jSONObject2.put("meta-data", sb.toString());
            return bm.a.a(jSONObject2.toString().getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String y(Context context) {
        String str = f1765a;
        if (str == null) {
            try {
                List runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                int i2 = 0;
                while (true) {
                    if (runningAppProcesses == null || i2 >= runningAppProcesses.size()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                    i2++;
                }
            } catch (Exception unused) {
            }
            if (str == null) {
                str = "";
            }
            f1765a = str;
        }
        return str;
    }

    public static String b(int i2, Context context) {
        String l = l(context);
        return TextUtils.isEmpty(l) ? "" : b.c(i2, l.getBytes());
    }

    public static String c(int i2, Context context) {
        String d2 = d(i2, context);
        String c2 = !TextUtils.isEmpty(d2) ? b.c(i2, d2.getBytes()) : null;
        return TextUtils.isEmpty(c2) ? "" : c2;
    }

    @TargetApi(9)
    public static String d() {
        String str = "";
        String str2 = "wlan0";
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.getName().equalsIgnoreCase(str2)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02x:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    str = sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @SuppressLint({"NewApi"})
    public static String e(int i2, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = null;
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isAnyLocalAddress() && (inetAddress instanceof Inet4Address)) {
                        if (!inetAddress.isLoopbackAddress()) {
                            if (inetAddress.isSiteLocalAddress()) {
                                bArr = networkInterface.getHardwareAddress();
                            } else if (!inetAddress.isLinkLocalAddress()) {
                                bArr = networkInterface.getHardwareAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        String str = "";
        String str2 = Config.TRACE_TODAY_VISIT_SPLIT;
        if (bArr != null) {
            for (byte a2 : bArr) {
                stringBuffer.append(a(a2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(str2, str);
        }
        String b2 = b(i2, context);
        if (b2 != null) {
            b2 = b2.replaceAll(str2, str);
        }
        return b2;
    }

    public static String h(int i2, Context context) {
        String t = t(context);
        if (!TextUtils.isEmpty(t)) {
            try {
                return b.c(i2, t.getBytes());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String b(Context context, String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf > 0) {
            int i2 = lastIndexOf + 1;
            if (i2 < str.length()) {
                str2 = str.substring(i2);
            }
        }
        return str2;
    }

    public static String f(int i2, Context context) {
        String n = n(context);
        return TextUtils.isEmpty(n) ? "" : b.c(i2, n.getBytes());
    }

    public static String g(int i2, Context context) {
        String p = p(context);
        if (TextUtils.isEmpty(p)) {
            return "";
        }
        return b.d(i2, p.getBytes());
    }

    public static String a(int i2, Context context) {
        try {
            return b.c(i2, a(context).getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        String str = f1767c;
        if (str != null) {
            return str;
        }
        String str2 = !TextUtils.isEmpty(a(OSUtils.KEY_MIUI_VERSION_NAME)) ? "miui" : !TextUtils.isEmpty(a("ro.build.version.opporom")) ? "coloros" : !TextUtils.isEmpty(a(OSUtils.KEY_EMUI_VERSION_NAME)) ? "emui" : !TextUtils.isEmpty(a("ro.vivo.os.version")) ? "funtouch" : !TextUtils.isEmpty(a("ro.smartisan.version")) ? "smartisan" : "";
        if (TextUtils.isEmpty(str2)) {
            String a2 = a(OSUtils.KEY_DISPLAY);
            if (!TextUtils.isEmpty(a2) && a2.contains("Flyme")) {
                str2 = "flyme";
            }
        }
        f1767c = str2;
        return str2;
    }

    public static String c(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            str = null;
        }
        return str;
    }

    public static String a(Context context) {
        return f1768d.matcher(bx.a(context)).replaceAll("");
    }

    public static Boolean c() {
        Boolean valueOf = Boolean.valueOf(true);
        try {
            Object invoke = Class.forName("com.baidu.disasterrecovery.MtjAdapter").getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0]);
            return (invoke == null || !(invoke instanceof Boolean)) ? valueOf : (Boolean) invoke;
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static String a(byte b2) {
        StringBuilder a2 = e.a.a.a.a.a("00");
        a2.append(Integer.toHexString(b2));
        a2.append(Config.TRACE_TODAY_VISIT_SPLIT);
        String sb = a2.toString();
        return sb.substring(sb.length() - 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[SYNTHETIC, Splitter:B:26:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC, Splitter:B:34:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 20
            r2 = 0
            char[] r3 = new char[r1]     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            java.lang.String r6 = "/sys/class/net/eth0/address"
            r5.<init>(r6)     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x005a, all -> 0x0053 }
        L_0x0016:
            int r5 = r4.read(r3)     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            r6 = -1
            if (r5 == r6) goto L_0x003c
            r6 = 13
            if (r5 != r1) goto L_0x002d
            r7 = 19
            char r7 = r3[r7]     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            if (r7 == r6) goto L_0x002d
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            r5.print(r3)     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            goto L_0x0016
        L_0x002d:
            r7 = 0
        L_0x002e:
            if (r7 >= r5) goto L_0x0016
            char r8 = r3[r7]     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            if (r8 == r6) goto L_0x0039
            char r8 = r3[r7]     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            r0.append(r8)     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
        L_0x0039:
            int r7 = r7 + 1
            goto L_0x002e
        L_0x003c:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            java.lang.String r1 = ":"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replaceAll(r1, r3)     // Catch:{ Exception -> 0x005b, all -> 0x0050 }
            r4.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
            r2 = r4
            goto L_0x0054
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            throw r0
        L_0x005a:
            r4 = r2
        L_0x005b:
            if (r4 == 0) goto L_0x0060
            r4.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bw.a():java.lang.String");
    }

    public static String d(int i2, Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = e(i2, context);
        }
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    public static String a(Context context, int i2) {
        String m = m(context);
        return TextUtils.isEmpty(m) ? "" : b.c(i2, m.getBytes());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        if (r5 == null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[SYNTHETIC, Splitter:B:19:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[SYNTHETIC, Splitter:B:29:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            r2.<init>()     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            r2.append(r5)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003c, all -> 0x0037 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003c, all -> 0x0037 }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ Exception -> 0x003c, all -> 0x0037 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003c, all -> 0x0037 }
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x003c, all -> 0x0037 }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x004f, all -> 0x0035 }
            r1.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r5.destroy()
            goto L_0x0057
        L_0x0035:
            r0 = move-exception
            goto L_0x0042
        L_0x0037:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0042
        L_0x003c:
            r1 = r0
            goto L_0x004f
        L_0x003e:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            if (r5 == 0) goto L_0x004c
            r5.destroy()
        L_0x004c:
            throw r0
        L_0x004d:
            r5 = r0
            r1 = r5
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            if (r5 == 0) goto L_0x0057
            goto L_0x0031
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bw.a(java.lang.String):java.lang.String");
    }
}
