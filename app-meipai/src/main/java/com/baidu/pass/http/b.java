package com.baidu.pass.http;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidubce.BceConfig;
import e.a.a.a.a;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;

/* compiled from: PassHttpCookieUtil */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final String f1946a = "b";

    /* renamed from: b reason: collision with root package name */
    public static final String f1947b = "Set-Cookie";

    /* renamed from: c reason: collision with root package name */
    public static final String f1948c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";

    /* renamed from: d reason: collision with root package name */
    public static final String f1949d = "Cookie";

    /* renamed from: e reason: collision with root package name */
    public static final String f1950e = "https://";

    @TargetApi(9)
    public static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            URI uri = new URI(passHttpParamDTO.url);
            StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(uri.getHost());
            String cookie = instance.getCookie(sb.toString());
            String str = f1946a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("asyncCookie");
            sb2.append(passHttpParamDTO.asyncCookie);
            c.a(str, sb2.toString());
            String str2 = f1946a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("webviewCookies");
            sb3.append(cookie);
            c.a(str2, sb3.toString());
            String[] strArr = null;
            if (!passHttpParamDTO.asyncCookie) {
                cookie = null;
            }
            List<HttpCookie> list = passHttpParamDTO.cookie;
            if (!TextUtils.isEmpty(cookie) || (list != null && !list.isEmpty())) {
                String str3 = "";
                String str4 = ";";
                if (!TextUtils.isEmpty(cookie)) {
                    strArr = cookie.split(str4);
                }
                String str5 = "=";
                if (strArr != null) {
                    if (strArr.length > 0) {
                        for (String str6 : strArr) {
                            if (!TextUtils.isEmpty(str6)) {
                                List parse = HttpCookie.parse(str6);
                                if (!parse.isEmpty()) {
                                    HttpCookie httpCookie = (HttpCookie) parse.get(0);
                                    if (httpCookie != null) {
                                        if (!httpCookie.hasExpired()) {
                                            if (list != null) {
                                                for (HttpCookie httpCookie2 : list) {
                                                    if (httpCookie.getName().equals(httpCookie2.getName()) && a(passHttpParamDTO.url, httpCookie)) {
                                                        httpCookie = httpCookie2;
                                                    }
                                                }
                                            }
                                            if (!httpCookie.hasExpired()) {
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(str3);
                                                sb4.append(httpCookie.getName());
                                                sb4.append(str5);
                                                sb4.append(httpCookie.getValue());
                                                sb4.append(str4);
                                                str3 = sb4.toString();
                                            }
                                            String str7 = f1946a;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("httpCookie webview item name:");
                                            sb5.append(httpCookie.getName());
                                            sb5.append(",value:");
                                            sb5.append(httpCookie.getValue());
                                            c.a(str7, sb5.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (list != null) {
                    for (HttpCookie httpCookie3 : list) {
                        if (a(passHttpParamDTO.url, httpCookie3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str3);
                            sb6.append(httpCookie3.getName());
                            sb6.append(str5);
                            sb6.append(httpCookie3.getValue());
                            sb6.append(str4);
                            str3 = sb6.toString();
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, str3.length() - 1);
                    String str8 = f1946a;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("cookieStr");
                    sb7.append(substring);
                    c.a(str8, sb7.toString());
                    httpURLConnection.setRequestProperty(f1949d, substring);
                }
            }
        } catch (Exception e2) {
            String str9 = f1946a;
            StringBuilder a2 = a.a("asyncWebviewCookie2NA:");
            a2.append(e2.toString());
            c.a(str9, a2.toString());
        }
    }

    @TargetApi(9)
    public static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        try {
            String str = f1946a;
            StringBuilder sb = new StringBuilder();
            sb.append("asyncCookie");
            sb.append(passHttpParamDTO.asyncCookie);
            c.a(str, sb.toString());
            if (passHttpParamDTO.asyncCookie) {
                Map headerFields = httpURLConnection.getHeaderFields();
                if (headerFields != null) {
                    if (!headerFields.isEmpty()) {
                        List<String> list = (List) headerFields.get("Set-Cookie");
                        if (list != null) {
                            if (!list.isEmpty()) {
                                CookieSyncManager.createInstance(context);
                                CookieManager instance = CookieManager.getInstance();
                                instance.setAcceptCookie(true);
                                if (instance.acceptCookie()) {
                                    for (String str2 : list) {
                                        if (!TextUtils.isEmpty(str2)) {
                                            List parse = HttpCookie.parse(str2);
                                            if (!parse.isEmpty()) {
                                                HttpCookie httpCookie = (HttpCookie) parse.get(0);
                                                if (a(passHttpParamDTO.url, httpCookie)) {
                                                    String str3 = f1946a;
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("httpcookie:");
                                                    sb2.append(httpCookie.toString());
                                                    Log.e(str3, sb2.toString());
                                                    String a2 = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), (httpCookie.getMaxAge() * 1000) + System.currentTimeMillis(), httpCookie.getSecure());
                                                    String str4 = f1946a;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("httpcookie build:");
                                                    sb3.append(a2);
                                                    Log.e(str4, sb3.toString());
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append("https://");
                                                    sb4.append(httpCookie.getDomain());
                                                    instance.setCookie(sb4.toString(), a2);
                                                }
                                            }
                                        }
                                    }
                                    instance.flush();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            String str5 = f1946a;
            StringBuilder a3 = a.a("asyncNaCookie2Webview:");
            a3.append(e2.toString());
            c.a(str5, a3.toString());
        }
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.startsWith(str2) || (!str2.endsWith(BceConfig.BOS_DELIMITER) && str.charAt(str2.length()) != '/')) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, String str3, long j2, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        a.a(sb, str3, ";domain=", str, ";path=/;expires=");
        sb.append(simpleDateFormat.format(instance.getTime()));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    @TargetApi(9)
    public static boolean a(String str, HttpCookie httpCookie) {
        try {
            URL url = new URL(str);
            if (!httpCookie.getDiscard() && !httpCookie.hasExpired() && a(url.getHost(), httpCookie.getDomain()) && b(url.getPath(), httpCookie.getPath()) && a(str, httpCookie.getSecure())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z || str.startsWith("https://")) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if ((!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || c.b(str)) && !str.endsWith(str2) && !str2.startsWith(".") && c.b(str)) {
            return false;
        }
        return true;
    }
}
