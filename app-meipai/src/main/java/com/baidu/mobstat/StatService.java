package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobstat.BaiduStatJSInterface.CustomWebChromeViewClient;
import com.baidu.mobstat.BaiduStatJSInterface.CustomWebViewClient;
import com.baidu.mobstat.MtjConfig.FeedTrackStrategy;
import com.baidu.mobstat.MtjConfig.PushPlatform;
import com.baidu.mobstat.af.b;
import java.util.ArrayList;
import java.util.Map;

public class StatService {
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;

    /* renamed from: a reason: collision with root package name */
    public static boolean f1488a = false;

    /* renamed from: b reason: collision with root package name */
    public static boolean f1489b;

    public interface OnZidReceiveListener {
        String getZid();
    }

    public interface WearListener {
        boolean onSendLogData(String str);
    }

    @SuppressLint({"NewApi"})
    public static void a(WebView webView) {
    }

    public static boolean a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        for (int i2 = 2; i2 < stackTrace.length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement.getMethodName().equals(str)) {
                try {
                    Class cls2 = Class.forName(stackTraceElement.getClassName());
                    while (cls2.getSuperclass() != null && cls2.getSuperclass() != cls) {
                        cls2 = cls2.getSuperclass();
                    }
                    z = true;
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public static void autoTrace(Context context) {
        autoTrace(context, true, false);
    }

    public static void bindJSInterface(Context context, WebView webView) {
        bindJSInterface(context, webView, null);
    }

    public static void enableDeviceMac(Context context, boolean z) {
        CooperService.instance().enableDeviceMac(context, z);
        BDStatCore.instance().init(context);
    }

    public static void enableListTrack(View view) {
        if (view != null) {
            view.setTag(-97002, Boolean.valueOf(true));
        }
    }

    public static String getAppKey(Context context) {
        return PrefOperate.getAppKey(context);
    }

    public static String getSdkVersion() {
        return CooperService.instance().getMTJSDKVersion();
    }

    public static String getTestDeviceId(Context context) {
        return bw.b(context);
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        if (a(context, "onErised(...)")) {
            if (str == null || "".equals(str)) {
                bc.c().c("[WARNING] AppKey is invalid");
            } else {
                BDStatCore.instance().onErised(context, str, str2, str3);
            }
        }
    }

    public static void onEvent(Context context, String str, String str2, int i2, Map<String, String> map) {
        a(context, str, str2, i2, (ExtraInfo) null, map);
    }

    public static void onEventDuration(Context context, String str, String str2, long j2, Map<String, String> map) {
        a(context, str, str2, j2, (ExtraInfo) null, map);
    }

    public static void onEventEnd(Context context, String str, String str2) {
        a(context, str, str2, (ExtraInfo) null, null);
    }

    public static void onEventStart(Context context, String str, String str2) {
        if (a(context, "onEventStart(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventStart(context.getApplicationContext(), str, str2, false);
        }
    }

    public static synchronized void onPageEnd(Context context, String str) {
        synchronized (StatService.class) {
            a(context, str, null);
        }
    }

    public static synchronized void onPageStart(Context context, String str) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    BDStatCore.instance().onPageStart(context, str);
                    return;
                }
            }
            bc.c().c("[WARNING] onPageStart parameter invalid");
        }
    }

    public static synchronized void onPause(Activity activity) {
        synchronized (StatService.class) {
            onPause(activity, null);
        }
    }

    public static synchronized void onResume(Activity activity) {
        synchronized (StatService.class) {
            if (a((Context) activity, "onResume(...)")) {
                if (!a(Activity.class, "onResume")) {
                    bc.c().c("[WARNING] onResume must be called in Activity.onResume()");
                } else {
                    BDStatCore.instance().onResume(activity, false);
                }
            }
        }
    }

    public static void recordException(Context context, Throwable th) {
        if (context != null && th != null) {
            ExceptionAnalysis.getInstance().saveCrashInfo(context, th, false);
        }
    }

    @Deprecated
    public static void setAppChannel(String str) {
        PrefOperate.setAppChannel(str);
    }

    public static void setAppKey(String str) {
        PrefOperate.setAppKey(str);
    }

    public static void setAppVersionName(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            CooperService.instance().setAppVersionName(context, str);
        }
    }

    public static void setAttributes(View view, Map<String, String> map) {
        if (view != null) {
            view.setTag(-96000, map);
        }
    }

    public static void setContentId(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97004, str);
        }
    }

    public static void setContentTitle(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97003, str);
        }
    }

    public static void setCrashExtraInfo(String str) {
        ExceptionAnalysis.getInstance().setCrashExtraInfo(str);
    }

    public static void setDebugOn(boolean z) {
        bc.c().a(z);
    }

    public static void setEnableBackgroundSendLog(Context context, boolean z) {
        BDStatCore.instance().setAutoSendLog(context, z);
    }

    public static void setFeedTrack(FeedTrackStrategy feedTrackStrategy) {
        av.a(feedTrackStrategy);
        f1489b = true;
    }

    public static void setForTv(Context context, boolean z) {
        bq.a().c(context, z);
        BDStatCore.instance().init(context);
    }

    public static synchronized void setGlobalExtraInfo(Context context, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context != null) {
                CooperService.instance().setHeaderExt(context, extraInfo);
                BDStatCore.instance().init(context);
            }
        }
    }

    public static void setListName(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97001, str);
        }
    }

    public static void setLogSenderDelayed(int i2) {
        LogSender.instance().setLogSenderDelayed(i2);
    }

    public static void setOn(Context context, int i2) {
        if (a(context, "setOn(...)") && !f1488a) {
            f1488a = true;
            if ((i2 & 1) != 0) {
                a(context, false);
            } else if ((i2 & 16) != 0) {
                a(context, true);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static synchronized void setPushId(Context context, PushPlatform pushPlatform, String str) {
        synchronized (StatService.class) {
            if (context != null) {
                if (pushPlatform != null) {
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    if (str.length() > 1024) {
                        str = str.substring(0, 1024);
                    }
                    CooperService.instance().setPushId(context, pushPlatform.value(), pushPlatform.showName(), str);
                    BDStatCore.instance().init(context);
                }
            }
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        if (a(context, "setSendLogStrategy(...)")) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] setSendLogStrategy 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
            LogSender.instance().setSendLogStrategy(context.getApplicationContext(), sendStrategyEnum, i2, z);
        }
    }

    public static void setSessionTimeOut(int i2) {
        BDStatCore.instance().setSessionTimeOut(i2);
    }

    public static synchronized void setStartType(boolean z) {
        synchronized (StatService.class) {
            CooperService.instance().setStartType(z);
        }
    }

    public static void setUserId(Context context, String str) {
        if (context != null) {
            CooperService.instance().setUserId(context, str);
            BDStatCore.instance().init(context);
        }
    }

    public static void setUserProperty(Context context, Map<String, String> map) {
        if (context != null) {
            CooperService.instance().setUserProperty(context, bx.a(map));
            BDStatCore.instance().init(context);
        }
    }

    public static void start(Context context) {
        if (a(context, "start(...)")) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
        }
    }

    public static void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        a(context, webView, (WebViewClient) null, webChromeClient, true);
    }

    public static void autoTrace(Context context, boolean z, boolean z2) {
        if (z && a(context, "autoTrace(...)")) {
            String appKey = CooperService.instance().getAppKey(context);
            if (TextUtils.isEmpty(appKey)) {
                bc.c().c("[WARNING] AppKey is invalid, auto trace will do not take effect");
                return;
            }
            af.a(appKey);
            af.a(z2);
            if (!f1489b) {
                setFeedTrack(FeedTrackStrategy.TRACK_ALL);
            }
            BDStatCore.instance().init(context);
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        a(context, webView, webViewClient, (WebChromeClient) null, false);
    }

    public static void onEvent(Context context, String str, String str2, int i2) {
        a(context, str, str2, i2, (ExtraInfo) null, null);
    }

    public static void onEventDuration(Context context, String str, String str2, long j2) {
        a(context, str, str2, j2, (ExtraInfo) null, null);
    }

    public static void onEventEnd(Context context, String str, String str2, Map<String, String> map) {
        a(context.getApplicationContext(), str, str2, (ExtraInfo) null, map);
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        PrefOperate.setAppChannel(context, str, z);
        BDStatCore.instance().init(context);
    }

    public static void onEvent(Context context, String str, String str2) {
        a(context, str, str2, null);
    }

    public static synchronized void onPause(Activity activity, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (a((Context) activity, "onPause(...)")) {
                if (!a(Activity.class, "onPause")) {
                    bc.c().c("[WARNING] onPause must be called in Activity.onPause");
                } else {
                    BDStatCore.instance().onPause(activity, false, extraInfo);
                }
            }
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2) {
        setSendLogStrategy(context, sendStrategyEnum, i2, false);
    }

    public static synchronized void a(Context context, String str, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    BDStatCore.instance().onPageEnd(context, str, extraInfo);
                    return;
                }
            }
            bc.c().c("[WARNING] onPageEnd parameter invalid");
        }
    }

    public static void a(Context context, boolean z) {
        if (a(context, "onError(...)")) {
            BDStatCore.instance().init(context);
            ExceptionAnalysis.getInstance().openExceptionAnalysis(context.getApplicationContext(), z);
        }
    }

    public static void a(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map) {
        if (a(context, "onEvent(...)") && !TextUtils.isEmpty(str)) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] onEvent 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onEvent(context.getApplicationContext(), str, str2, i2, extraInfo, bx.a(map), a2);
        }
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo) {
        a(context, str, str2, 1, extraInfo, null);
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        if (a(context, "onEventEnd(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventEnd(context.getApplicationContext(), str, str2, extraInfo, bx.a(map));
        }
    }

    public static void a(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map) {
        Context context2 = context;
        if (!a(context, "onEventDuration(...)") || TextUtils.isEmpty(str)) {
            return;
        }
        if (j2 <= 0) {
            bc.c().b("[WARNING] onEventDuration duration must be greater than zero");
            return;
        }
        boolean a2 = bx.a(Application.class, "onCreate");
        if (a2) {
            bc.c().c("[WARNING] onEventDuration 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
        }
        BDStatCore.instance().onEventDuration(context.getApplicationContext(), str, str2, j2, extraInfo, bx.a(map), a2);
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            return true;
        }
        bc c2 = bc.c();
        StringBuilder sb = new StringBuilder();
        sb.append("[WARNING] ");
        sb.append(str);
        sb.append(", context is null, invalid");
        c2.b(sb.toString());
        return false;
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void a(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z) {
        if (context == null) {
            bc.c().c("[WARNING] context is null, invalid");
        } else if (webView == null) {
            bc.c().c("[WARNING] webview is null, invalid");
        } else {
            a(webView);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            if (!z) {
                webView.setWebViewClient(new CustomWebViewClient(context, webViewClient, null, null));
            } else {
                bl blVar = new bl();
                webView.addJavascriptInterface(blVar, "WebViewInterface");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new b());
                arrayList.add(new av.b());
                CustomWebChromeViewClient customWebChromeViewClient = new CustomWebChromeViewClient(context, webChromeClient, arrayList, blVar);
                webView.setWebChromeClient(customWebChromeViewClient);
                webView.setTag(-96001, customWebChromeViewClient);
            }
            BDStatCore.instance().init(context);
        }
    }
}
