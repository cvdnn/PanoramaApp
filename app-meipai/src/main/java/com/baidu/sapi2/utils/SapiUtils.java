package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.SapiDeviceUtils.DeviceCrypto;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import e.a.a.a.a;
import e.c.a.a.b.b;
import e.c.b.e.Utils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiUtils implements NoProguard {
    public static final String COOKIE_HTTPS_URL_PREFIX = "https://";
    public static final String COOKIE_URL_PREFIX = "https://www.";
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int MAX_WIFI_LIST = 10;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";

    /* renamed from: a reason: collision with root package name */
    public static final String f3013a = "cmd";

    /* renamed from: b reason: collision with root package name */
    public static final String f3014b = "error";

    /* renamed from: c reason: collision with root package name */
    public static final String f3015c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";

    /* renamed from: d reason: collision with root package name */
    public static final String f3016d = Character.toString(2);

    /* renamed from: e reason: collision with root package name */
    public static final String f3017e = Character.toString(3);

    @TargetApi(3)
    public static String a(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "qrsign";
        if (!str.contains(str2)) {
            return false;
        }
        String str3 = "scope";
        if (!str.contains(str3)) {
            return false;
        }
        String str4 = "channelid";
        if (!str.contains(str4)) {
            return false;
        }
        String str5 = "client_id";
        if (!str.contains(str5)) {
            return false;
        }
        Map urlParamsToMap = urlParamsToMap(str);
        if (TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str2)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str3)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str4)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str5))) {
            return false;
        }
        return true;
    }

    public static String buildBDUSSCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, instance.getTime(), false);
    }

    public static String buildCuidCookie(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("cuid=");
        sb.append(str2);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;httponly");
        return sb.toString();
    }

    public static String buildDarkModeCookie(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, TextUtils.isEmpty(str2) ? -1 : 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append("passtheme=");
        sb.append(str2);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(instance.getTime()));
        return sb.toString();
    }

    public static String buildDeviceInfoCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, instance.getTime(), true);
    }

    public static String buildIqiyiCookie(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, TextUtils.isEmpty(str3) ? -2 : 2);
        return a(str, str2, str3, instance.getTime(), false);
    }

    public static String buildPtokenCookie(String str, String str2) {
        return a(str, "PTOKEN", str2);
    }

    public static String buildStokenCookie(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
        return a(str, "STOKEN", str2, instance.getTime(), true);
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
        ArrayList arrayList = new ArrayList();
        for (Object add : map.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                String str3 = (String) map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append("&");
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        sb.append("sign_key=");
        sb.append(str);
        return Utils.a(sb.toString().getBytes(), false);
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        try {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String createRequestParams(List<PassNameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    String str = "=";
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(passNameValuePair.getName());
                        sb.append(str);
                        sb.append(passNameValuePair.getValue());
                    } else {
                        sb.append("&");
                        sb.append(passNameValuePair.getName());
                        sb.append(str);
                        sb.append(passNameValuePair.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static int dip2px(Context context, float f2) {
        if (context != null) {
            return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        throw new IllegalArgumentException("Context can't be null");
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<String> getAuthorizedDomains() {
        return SapiContext.getInstance().getAuthorizedDomains();
    }

    public static List<String> getAuthorizedDomainsForPtoken() {
        return SapiContext.getInstance().getAuthorizedDomainsForPtoken();
    }

    public static String getClientId(Context context) {
        try {
            return b.b(context);
        } catch (Throwable unused) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append("123456789");
            sb.append(Utils.a(String.valueOf(random.nextInt(100)).getBytes(), false));
            return sb.toString();
        }
    }

    public static String getCookie(String str, String str2) {
        try {
            CookieSyncManager.createInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                for (String trim : cookie.split(";")) {
                    String trim2 = trim.trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        int indexOf = trim2.indexOf("=");
                        if (indexOf > -1) {
                            String[] strArr = new String[2];
                            strArr[0] = trim2.substring(0, indexOf);
                            int i2 = indexOf + 1;
                            if (i2 < trim2.length()) {
                                strArr[1] = trim2.substring(i2, trim2.length());
                            }
                            if (strArr[0].equals(str2)) {
                                return strArr[1];
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return "";
    }

    public static String getCookieBduss() {
        return getCookie(j.a(j.l), "BDUSS");
    }

    public static String getCookiePtoken() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String str = "PTOKEN";
        String cookie = getCookie(confignation.environment.getWap(), str);
        return TextUtils.isEmpty(cookie) ? getCookie(confignation.environment.getURL(), str) : cookie;
    }

    public static String getCpuName() {
        String str = "";
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                if (split.length > 1) {
                    str = split[1];
                }
                return str;
            }
        } catch (FileNotFoundException e2) {
            Log.e(e2);
        } catch (IOException e3) {
            Log.e(e3);
        }
        return str;
    }

    public static List<String> getCuidAuthorizedDomains() {
        return SapiContext.getInstance().getCuidAuthorizedDomains();
    }

    public static boolean getDefaultHttpsEnabled() {
        return SapiContext.getInstance().getDefaultHttpsEnabled();
    }

    public static String getIccid(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList == null) {
                return null;
            }
            for (SubscriptionInfo iccId : activeSubscriptionInfoList) {
                sb.append(iccId.getIccId());
                sb.append(f3016d);
            }
            if (sb.length() > 0) {
                return sb.toString().substring(0, sb.length() - 1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static long getInternalAvailableMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        } catch (Throwable th) {
            Log.e(th);
            return 0;
        }
    }

    public static long getInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        } catch (Throwable th) {
            Log.e(th);
            return 0;
        }
    }

    public static int getLastLoginType() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_PRE_LOGIN_TYPE);
        String str = "none";
        if (TextUtils.isEmpty(string)) {
            string = str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Integer.valueOf(0));
        hashMap.put("password", Integer.valueOf(1));
        hashMap.put("sms", Integer.valueOf(2));
        hashMap.put("face", Integer.valueOf(3));
        StringBuilder sb = new StringBuilder();
        sb.append(SocialType.WEIXIN.getName());
        String str2 = "";
        sb.append(str2);
        hashMap.put(sb.toString(), Integer.valueOf(4));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(SocialType.SINA_WEIBO_SSO.getName());
        sb2.append(str2);
        hashMap.put(sb2.toString(), Integer.valueOf(5));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(SocialType.QQ_SSO.getName());
        sb3.append(str2);
        hashMap.put(sb3.toString(), Integer.valueOf(6));
        StringBuilder sb4 = new StringBuilder();
        sb4.append(SocialType.HUAWEI.getName());
        sb4.append(str2);
        hashMap.put(sb4.toString(), Integer.valueOf(10));
        hashMap.put("slient_share", Integer.valueOf(7));
        hashMap.put(m.f2948i, Integer.valueOf(8));
        hashMap.put(m.f2949j, Integer.valueOf(9));
        hashMap.put("oneKeyLogin", Integer.valueOf(12));
        hashMap.put("finger_account", Integer.valueOf(15));
        hashMap.put(c.f2818e, Integer.valueOf(16));
        hashMap.put(c.f2819f, Integer.valueOf(17));
        hashMap.put(c.f2820g, Integer.valueOf(18));
        hashMap.put(SapiWebView.SWITCH_ACCOUNT_PAGE, Integer.valueOf(19));
        if (hashMap.containsKey(string)) {
            return ((Integer) hashMap.get(string)).intValue();
        }
        return 11;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress != null && hostAddress.length() > 0 && (inetAddress instanceof Inet4Address)) {
                                return hostAddress;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return null;
    }

    public static String getLoginType() {
        return SapiContext.getInstance().getAccountActionType();
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        String str = "UNKNOWN";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return "WIFI";
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return "2G";
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return "3G";
                            case 13:
                                return "4G";
                            default:
                                return str;
                        }
                    }
                    return str;
                }
            }
            return "UNCNCT";
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static List<String> getPackageList(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(SapiShareClient.f2871g), 32);
        if (queryIntentServices != null) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    arrayList.add(serviceInfo.packageName);
                }
            }
        }
        return arrayList;
    }

    public static String getPackageSign(Context context, String str) {
        String str2 = "";
        if (context == null || TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures.length > 0) {
                return Utils.a(packageInfo.signatures[0].toByteArray(), false);
            }
            return str2;
        } catch (Throwable th) {
            Log.e(th);
            return str2;
        }
    }

    public static String[] getPkgIconAndName(Context context, String str) {
        String[] strArr = new String[2];
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            strArr[1] = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a(packageInfo.applicationInfo.loadIcon(packageManager)), 80, 80, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 100;
            createScaledBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > 524288 && i2 > 0) {
                i2 /= 2;
                byteArrayOutputStream.reset();
                createScaledBitmap.compress(CompressFormat.PNG, i2, byteArrayOutputStream);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("data:image/png;base64,");
            sb.append(DeviceCrypto.base64Encode(byteArrayOutputStream.toByteArray()));
            strArr[0] = sb.toString();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.e(e2);
        }
        return strArr;
    }

    public static String getRamMemorySize() {
        String str = "";
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                if (split.length > 1) {
                    str = split[1].replace("kB", str).trim();
                }
                return str;
            }
        } catch (FileNotFoundException e2) {
            Log.e(e2);
        } catch (IOException e3) {
            Log.e(e3);
        }
        return str;
    }

    public static String getSmsCheckCode(String str) {
        String[] split;
        for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split("-")) {
            if (str2.length() == 6) {
                return str2;
            }
        }
        return "";
    }

    public static long getTimeSinceBoot() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static int getVersionCode(Context context) {
        int i2 = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i2).versionCode;
        } catch (Exception unused) {
            return i2;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            Log.e(th);
            return "0";
        }
    }

    public static String getWifiInfo(Context context) {
        String str;
        int i2;
        String str2;
        String str3 = "";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            List<ScanResult> list = null;
            WifiInfo connectionInfo = ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol() ? wifiManager.getConnectionInfo() : null;
            String str4 = Config.TRACE_TODAY_VISIT_SPLIT;
            int i3 = 0;
            if (connectionInfo != null) {
                i2 = StrictMath.abs(connectionInfo.getRssi());
                str = connectionInfo.getSSID();
                if (str != null) {
                    str = str.replace("\"", str3);
                }
                str2 = connectionInfo.getBSSID();
                if (str2 != null) {
                    str2 = str2.replace(str4, str3);
                }
            } else {
                str2 = str3;
                str = str2;
                i2 = 0;
            }
            if (checkRequestPermission("android.permission.ACCESS_FINE_LOCATION", context)) {
                list = wifiManager.getScanResults();
            }
            if (list != null) {
                for (ScanResult scanResult : list) {
                    String str5 = scanResult.BSSID;
                    String str6 = scanResult.SSID;
                    int abs = StrictMath.abs(scanResult.level);
                    String replace = str5 != null ? str5.replace(str4, str3) : str3;
                    if (!replace.equals(str2)) {
                        if (abs != 0) {
                            if (i3 >= 10) {
                                break;
                            }
                            stringBuffer.append(f3016d);
                            stringBuffer.append(replace);
                            stringBuffer.append(f3017e);
                            stringBuffer.append(abs);
                            stringBuffer.append(f3017e);
                            stringBuffer.append(str6);
                            stringBuffer.append(f3017e);
                            stringBuffer.append("2");
                            i3++;
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(f3016d);
                sb.append(str2);
                sb.append(f3017e);
                sb.append(i2);
                sb.append(f3017e);
                sb.append(str);
                sb.append(f3017e);
                sb.append('1');
                str3 = sb.toString();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
        StringBuilder a2 = a.a(str3);
        a2.append(stringBuffer.toString());
        return a2.toString();
    }

    public static boolean hasActiveNetwork(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    @TargetApi(3)
    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (NameNotFoundException unused) {
            }
        }
        return false;
    }

    @TargetApi(4)
    public static boolean isDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @TargetApi(4)
    public static boolean isEmulator(Context context) {
        String str;
        if (VERSION.SDK_INT <= 27 || context.getApplicationInfo().targetSdkVersion <= 27) {
            str = Build.SERIAL;
        } else {
            if (checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
                try {
                    str = Build.getSerial();
                } catch (Throwable unused) {
                }
            }
            str = null;
        }
        if (!Config.NULL_DEVICE_ID.equals(SapiDeviceUtils.b(context)) && !Build.FINGERPRINT.contains("test-keys")) {
            String str2 = "unknown";
            if (!Build.FINGERPRINT.startsWith(str2) && !Build.BRAND.startsWith("generic") && !Build.BOARD.equals(str2) && !str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        try {
            if (!cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass())) {
                return true;
            }
        } catch (NoSuchMethodException unused) {
        }
        return false;
    }

    @TargetApi(4)
    public static boolean isOnline(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.matches("com.baidu.sapi2.(.*)")) {
            return true;
        }
        if (isDebug(context)) {
            return false;
        }
        Map authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
        String packageSign = getPackageSign(context, packageName);
        for (String str : authorizedPackages.keySet()) {
            if (packageName.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                return true;
            }
        }
        return false;
    }

    public static String[] isQrArtificialAppeal(String str) {
        Domain environment = ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment();
        String host = Uri.parse(environment.getWap()).getHost();
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(Uri.parse(environment.getWap()).getHost());
        sb.append("/v3/getpass/artificialappeal");
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str) && str.contains(sb2)) {
            String[] strArr = {Uri.decode(parse.getQueryParameter("title")), Uri.decode(parse.getQueryParameter("url"))};
            Uri parse2 = Uri.parse(strArr[1]);
            if (TextUtils.isEmpty(strArr[1]) || !host.equals(parse2.getHost())) {
                return null;
            }
            return strArr;
        }
        return null;
    }

    public static boolean isQrLoginSchema(String str) {
        boolean z = true;
        if (b(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = f3014b;
            if (str.contains(str2)) {
                String str3 = "sign";
                if (str.contains(str3)) {
                    String str4 = f3013a;
                    if (str.contains(str4)) {
                        String str5 = KEY_QR_LOGIN_LP;
                        if (str.contains(str5)) {
                            Map urlParamsToMap = urlParamsToMap(str);
                            if (TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str2)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str3)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str4)) || TextUtils.isEmpty((CharSequence) urlParamsToMap.get(str5))) {
                                z = false;
                            }
                            return z;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isRoot() {
        String str = "/system/bin/su";
        if (!new File(str).exists() || !a(str)) {
            String str2 = "/system/xbin/su";
            if (!new File(str2).exists() || !a(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        return sapiAccount != null && !TextUtils.isEmpty(sapiAccount.bduss) && !TextUtils.isEmpty(sapiAccount.uid) && !TextUtils.isEmpty(sapiAccount.displayname);
    }

    public static boolean isValidPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(1)\\d{10}$").matcher(str).matches();
    }

    public static boolean isValidUsername(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 14;
    }

    public static JSONArray map2JsonArray(Map<String, Long> map, String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (map != null && !map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    try {
                        jSONObject.put(str, entry.getKey());
                        jSONObject.put(str2, entry.getValue());
                    } catch (JSONException unused) {
                    }
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static String mapToUrlParams(Map<String, String> map, boolean z) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (sb.length() > 0 || z) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            String str2 = "=";
            if (value == null) {
                try {
                    sb.append(str);
                    sb.append(str2);
                } catch (Exception e2) {
                    sb.append(str);
                    sb.append(str2);
                    sb.append(value);
                    e2.printStackTrace();
                }
            } else {
                sb.append(str);
                sb.append(str2);
                sb.append(URLEncoder.encode(value.toString(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static void notEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String parseQrFaceAuthSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"ucenter/qrlivingnav", "url", "tpl"};
        for (int i2 = 0; i2 < 3; i2++) {
            if (!str.contains(strArr[i2])) {
                return null;
            }
        }
        return URLDecoder.decode(str.substring(str.indexOf("url=") + 4, str.length()));
    }

    public static Map<String, String> parseQrLoginSchema(String str) {
        HashMap hashMap = new HashMap();
        boolean b2 = b(str);
        String str2 = "pc";
        String str3 = KEY_QR_LOGIN_LP;
        if (b2) {
            hashMap.put(str3, str2);
            return hashMap;
        } else if (!isQrLoginSchema(str)) {
            return hashMap;
        } else {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            if (str2.equals((String) urlParamsToMap.get(str3))) {
                HashMap hashMap2 = new HashMap();
                String str4 = "islogin";
                if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
                    hashMap2.put(str4, "0");
                } else {
                    hashMap2.put(str4, "1");
                }
                hashMap2.put("client", SapiDeviceInfo.f3010c);
                t.a(t.f3124a, (Map<String, String>) hashMap2);
            }
            return urlParamsToMap;
        }
    }

    public static int px2sp(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reportGid(int r1) {
        /*
            r0 = 12001(0x2ee1, float:1.6817E-41)
            if (r1 == r0) goto L_0x0027
            switch(r1) {
                case 10001: goto L_0x001b;
                case 10002: goto L_0x0018;
                case 10003: goto L_0x0015;
                case 10004: goto L_0x0012;
                case 10005: goto L_0x000f;
                case 10006: goto L_0x000c;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r1) {
                case 11001: goto L_0x0024;
                case 11002: goto L_0x0021;
                case 11003: goto L_0x001e;
                default: goto L_0x000a;
            }
        L_0x000a:
            r1 = 0
            goto L_0x0029
        L_0x000c:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.SYSTEM_SCREEN_ON     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x000f:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.BUSINESS_LOGOUT     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0012:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.BUSINESS_GET_GID     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0015:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.BUSINESS_ACCOUNT_REG     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0018:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.BUSINESS_ACCOUNT_LOGIN     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x001b:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.BUSINESS_APP_PROCESS_START     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x001e:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.SYSTEM_NETWORK_CHANGE_WIFI_TO_MOB     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0021:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0024:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0027:
            com.baidu.pass.gid.utils.Event r1 = com.baidu.pass.gid.utils.GIDEvent.TIME_FREQ     // Catch:{ all -> 0x0033 }
        L_0x0029:
            if (r1 != 0) goto L_0x002c
            return
        L_0x002c:
            com.baidu.pass.gid.BaiduGIDManager r0 = com.baidu.pass.gid.BaiduGIDManager.getInstance()     // Catch:{ all -> 0x0033 }
            r0.check(r1)     // Catch:{ all -> 0x0033 }
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SapiUtils.reportGid(int):void");
    }

    public static void resetSilentShareStatus() {
        if (SapiContext.getInstance().getCurrentAccount() == null) {
            SapiContext.getInstance().resetSilentShareStatus();
        }
    }

    public static boolean statExtraValid(String str) {
        return !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance().getLoginStatExtraLimitLen();
    }

    public static void syncCookies(Context context, List<PassNameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (TextUtils.isEmpty(confignation.clientId)) {
            confignation.clientId = getClientId(context);
        }
        List<String> cuidAuthorizedDomains = getCuidAuthorizedDomains();
        String str = "https://";
        if (confignation.getEnvironment() != Domain.DOMAIN_ONLINE) {
            String str2 = "http://";
            String str3 = "";
            String str4 = "(:[0-9]{1,4})?";
            String replaceAll = confignation.environment.getWap().replace(str2, str3).replace(str, str3).replaceAll(str4, str3);
            String replaceAll2 = confignation.environment.getURL().replace(str2, str3).replace(str, str3).replaceAll(str4, str3);
            cuidAuthorizedDomains.add(replaceAll);
            cuidAuthorizedDomains.add(replaceAll2);
        }
        for (String str5 : cuidAuthorizedDomains) {
            instance.setCookie(a.a(str, str5), buildCuidCookie(str5, confignation.clientId));
        }
        if (list != null) {
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    instance.setCookie(passNameValuePair.getName(), passNameValuePair.getValue());
                }
            }
        }
        instance.flush();
    }

    public static Map<String, String> urlParamsToMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String str2 = "?";
        if (str.contains(str2)) {
            try {
                str = str.substring(str.indexOf(str2) + 1, str.length());
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public static boolean validateMobile(String str) {
        return Pattern.compile("1[3456789]\\d{9}").matcher(str).matches();
    }

    public static int versionCompareTo(String str, String str2) {
        String str3 = "0";
        String str4 = "";
        String str5 = "[^\\d\\.]+";
        String replaceAll = TextUtils.isEmpty(str) ? str3 : str.replaceAll(str5, str4);
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2.replaceAll(str5, str4);
        }
        String str6 = "\\.";
        String[] split = replaceAll.split(str6);
        String[] split2 = str3.split(str6);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String parseInt : split) {
            arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        for (String parseInt2 : split2) {
            arrayList2.add(Integer.valueOf(Integer.parseInt(parseInt2)));
        }
        int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        while (arrayList.size() < size) {
            arrayList.add(Integer.valueOf(0));
        }
        while (arrayList2.size() < size) {
            arrayList2.add(Integer.valueOf(0));
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (((Integer) arrayList.get(i2)).intValue() > ((Integer) arrayList2.get(i2)).intValue()) {
                return 1;
            }
            if (((Integer) arrayList.get(i2)).intValue() < ((Integer) arrayList2.get(i2)).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean webLogin(Context context, String str) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str);
    }

    public static boolean webLogout(Context context) {
        String str;
        String str2;
        String str3;
        if (context == null) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = getAuthorizedDomains().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                str = COOKIE_URL_PREFIX;
                str2 = "";
                if (!hasNext) {
                    break;
                }
                String str4 = (String) it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str4);
                arrayList.add(new PassNameValuePair(sb.toString(), buildBDUSSCookie(str4, str2)));
            }
            Iterator it2 = getAuthorizedDomainsForPtoken().iterator();
            while (true) {
                str3 = "https://";
                if (!it2.hasNext()) {
                    break;
                }
                String str5 = (String) it2.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str5);
                arrayList.add(new PassNameValuePair(sb2.toString(), buildPtokenCookie(str5, str2)));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(str5);
                arrayList.add(new PassNameValuePair(sb3.toString(), buildPtokenCookie(str5, str2)));
            }
            for (String str6 : getAuthorizedDomainsForPtoken()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb4.append(str6);
                arrayList.add(new PassNameValuePair(sb4.toString(), buildStokenCookie(str6, str2)));
            }
            syncCookies(context, arrayList);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
        if (r5 == null) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e A[SYNTHETIC, Splitter:B:40:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0083 A[SYNTHETIC, Splitter:B:51:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r2.<init>()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.lang.String r3 = "ls -l "
            r2.append(r3)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            r2.append(r5)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ IOException -> 0x0065, all -> 0x0061 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005c, all -> 0x005a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005c, all -> 0x005a }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ IOException -> 0x005c, all -> 0x005a }
            r2.<init>(r3)     // Catch:{ IOException -> 0x005c, all -> 0x005a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x005c, all -> 0x005a }
            java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x0058 }
            if (r0 == 0) goto L_0x004f
            int r2 = r0.length()     // Catch:{ IOException -> 0x0058 }
            r3 = 4
            if (r2 < r3) goto L_0x004f
            r2 = 3
            char r0 = r0.charAt(r2)     // Catch:{ IOException -> 0x0058 }
            r2 = 115(0x73, float:1.61E-43)
            if (r0 == r2) goto L_0x0042
            r2 = 120(0x78, float:1.68E-43)
            if (r0 != r2) goto L_0x004f
        L_0x0042:
            r0 = 1
            r1.close()     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r1 = move-exception
            com.baidu.sapi2.utils.Log.e(r1)
        L_0x004b:
            r5.destroy()
            return r0
        L_0x004f:
            r1.close()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0078
        L_0x0053:
            r0 = move-exception
            com.baidu.sapi2.utils.Log.e(r0)
            goto L_0x0078
        L_0x0058:
            r0 = move-exception
            goto L_0x0069
        L_0x005a:
            r1 = move-exception
            goto L_0x0081
        L_0x005c:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x0081
        L_0x0065:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
        L_0x0069:
            com.baidu.sapi2.utils.Log.e(r0)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r0 = move-exception
            com.baidu.sapi2.utils.Log.e(r0)
        L_0x0076:
            if (r5 == 0) goto L_0x007b
        L_0x0078:
            r5.destroy()
        L_0x007b:
            r5 = 0
            return r5
        L_0x007d:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0081:
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r0 = move-exception
            com.baidu.sapi2.utils.Log.e(r0)
        L_0x008b:
            if (r5 == 0) goto L_0x0090
            r5.destroy()
        L_0x0090:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SapiUtils.a(java.lang.String):boolean");
    }

    public static boolean webLogin(Context context, String str, String str2) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str, str2);
    }

    public static String buildBDUSSCookie(String str, String str2) {
        return buildBDUSSCookie(str, "BDUSS", str2);
    }

    public static String a(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        a.a(sb, str3, ";domain=", str, ";path=/;expires=");
        sb.append(simpleDateFormat.format(date));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, instance.getTime(), true);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (VERSION.SDK_INT < 26 || !(drawable instanceof AdaptiveIconDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{adaptiveIconDrawable.getBackground(), adaptiveIconDrawable.getForeground()});
        Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawable.draw(canvas);
        return createBitmap;
    }
}
