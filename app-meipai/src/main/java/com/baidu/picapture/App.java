package com.baidu.picapture;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.baidu.picapture.model.device.LanguageUtils;
import e.c.d.d.b.b;
import e.c.d.l.c.h;
import e.c.d.n.e;
import i.b.a.c;
import java.util.Locale;

public class App extends Application {

    /* renamed from: b reason: collision with root package name */
    public static App f1954b;

    /* renamed from: a reason: collision with root package name */
    public boolean f1955a = false;

    public static /* synthetic */ void a(App app) {
        LanguageUtils.initContextSettingLanguage(app.getBaseContext());
        String d2 = e.d();
        if (d2 == null || d2.equals(LanguageUtils.AUTO)) {
            c.b().a((Object) new e.c.d.g.c(LanguageUtils.getSystemLanguageValue(LanguageUtils.getSystemLanguage())));
        }
        LanguageUtils.setIsSystemLanguageChange(false);
    }

    public void attachBaseContext(Context context) {
        LanguageUtils.setSystemLanguage(Locale.getDefault());
        super.attachBaseContext(LanguageUtils.attachBaseContext(context));
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.getLocales() != null && configuration.getLocales().size() > 0) {
            LanguageUtils.setSystemLanguage(configuration.getLocales().get(0));
        }
        super.onConfigurationChanged(configuration);
        LanguageUtils.initContextSettingLanguage(getBaseContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x015a, code lost:
        if (e.c.b.d.w > e.c.b.d.s) goto L_0x015c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r12 = this;
            super.onCreate()
            f1954b = r12
            e.c.d.a r0 = new e.c.d.a
            r0.<init>(r12)
            r12.registerActivityLifecycleCallbacks(r0)
            java.lang.String r0 = "898659b5d9"
            com.baidu.mobstat.StatService.setAppKey(r0)
            r0 = 0
            com.baidu.mobstat.StatService.setDebugOn(r0)
            com.baidu.mobstat.StatService.autoTrace(r12)
            java.lang.String r1 = "c748fbaf249f5d0b"
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x034e
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "crab init begin: "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            e.c.b.f.a.c(r5)
            e.c.b.d.f5880d = r1
            e.c.b.a.f5874a = r12
            java.io.File r5 = r12.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            e.c.b.a.f5875b = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "FILE_PATH IS : "
            r5.<init>(r6)
            java.lang.String r6 = e.c.b.a.f5875b
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            e.c.b.f.a.b(r5)
            android.app.Application r5 = e.c.b.a.f5874a
            int r6 = android.os.Process.myPid()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "CrabSDK.init from "
            r7.<init>(r8)
            android.app.Application r8 = e.c.b.a.f5874a
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            java.lang.String r8 = " with pid "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            e.c.b.f.a.a(r7)
            java.lang.String r7 = "activity"
            java.lang.Object r8 = r5.getSystemService(r7)
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8
            java.util.List r8 = r8.getRunningAppProcesses()
            r9 = 1
            if (r8 == 0) goto L_0x0182
            int r10 = r8.size()
            if (r10 != 0) goto L_0x0094
            goto L_0x0182
        L_0x0094:
            java.util.Iterator r8 = r8.iterator()
        L_0x0098:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00da
            java.lang.Object r10 = r8.next()
            android.app.ActivityManager$RunningAppProcessInfo r10 = (android.app.ActivityManager.RunningAppProcessInfo) r10
            int r11 = r10.pid
            if (r11 != r6) goto L_0x0098
            java.lang.String r6 = r10.processName
            java.lang.String r8 = r5.getPackageName()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x00bc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Main process "
            r6.<init>(r8)
            goto L_0x00c3
        L_0x00bc:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Sub process "
            r6.<init>(r8)
        L_0x00c3:
            java.lang.String r8 = r10.processName
            r6.append(r8)
            java.lang.String r8 = "."
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            e.c.b.f.a.a(r6)
            java.lang.String r6 = r10.processName
            e.c.b.a.f5876c = r6
            r6 = r9
            goto L_0x00db
        L_0x00da:
            r6 = r0
        L_0x00db:
            if (r6 != 0) goto L_0x00df
            goto L_0x0187
        L_0x00df:
            e.c.b.a.b(r5)
            e.c.b.a.a(r5)
            e.c.b.g.f r6 = e.c.b.g.f.f5937e
            java.lang.Thread$UncaughtExceptionHandler r8 = r6.f5938a
            if (r8 != 0) goto L_0x00f4
            java.lang.Thread$UncaughtExceptionHandler r8 = java.lang.Thread.getDefaultUncaughtExceptionHandler()
            r6.f5938a = r8
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r6)
        L_0x00f4:
            android.content.Context r8 = r6.f5939b
            if (r8 != 0) goto L_0x00fe
            android.content.Context r8 = r5.getApplicationContext()
            r6.f5939b = r8
        L_0x00fe:
            e.c.b.d.f5880d = r1
            e.c.b.a.a(r5)
            e.c.b.a.b(r5)
            boolean r1 = e.c.b.d.y
            if (r1 != 0) goto L_0x0174
            int r1 = e.c.b.d.D
            if (r1 == 0) goto L_0x0174
            java.lang.String r6 = "===Anr init!==="
            e.c.b.f.a.a(r6)
            int r6 = e.c.b.d.s
            r8 = -1
            if (r6 != r8) goto L_0x0119
            goto L_0x015e
        L_0x0119:
            android.content.SharedPreferences r6 = e.c.b.e.i.k
            if (r6 == 0) goto L_0x0156
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = e.c.b.e.i.j()
            r10.append(r11)
            java.lang.String r11 = "oneday_anr_count"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            int r6 = r6.getInt(r10, r8)
            int r8 = e.c.b.d.s
            if (r6 <= r8) goto L_0x0156
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "exceed daily anr quota "
            r8.<init>(r10)
            r8.append(r6)
            java.lang.String r6 = "/"
            r8.append(r6)
            int r6 = e.c.b.d.s
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            e.c.b.f.a.c(r6)
            goto L_0x015c
        L_0x0156:
            int r6 = e.c.b.d.w
            int r8 = e.c.b.d.s
            if (r6 <= r8) goto L_0x015e
        L_0x015c:
            r6 = r0
            goto L_0x015f
        L_0x015e:
            r6 = r9
        L_0x015f:
            if (r6 == 0) goto L_0x0174
            java.lang.String r6 = "===Anr watchThread start!==="
            e.c.b.f.a.a(r6)
            e.c.b.g.d r6 = new e.c.b.g.d     // Catch:{ Exception -> 0x016f }
            r6.<init>(r5, r1, r0)     // Catch:{ Exception -> 0x016f }
            r6.start()     // Catch:{ Exception -> 0x016f }
            goto L_0x0174
        L_0x016f:
            java.lang.String r1 = "Anr watchThread start failed !!"
            e.c.b.f.a.c(r1)
        L_0x0174:
            boolean r1 = e.c.b.e.i.g()
            if (r1 == 0) goto L_0x0187
            boolean r1 = e.c.b.d.y
            if (r1 != 0) goto L_0x0187
            e.c.b.g.g.a(r9, r5)
            goto L_0x0187
        L_0x0182:
            java.lang.String r1 = "getRunningAppProcesses error!!"
            e.c.b.f.a.a(r1)
        L_0x0187:
            long r5 = java.lang.System.currentTimeMillis()
            e.c.b.d.E = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r8 = "crab init end: "
            r1.<init>(r8)
            r1.append(r5)
            java.lang.String r8 = ", cost: "
            r1.append(r8)
            long r5 = r5 - r3
            r1.append(r5)
            java.lang.String r3 = "ms"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            e.c.b.f.a.c(r1)
            e.c.d.i.c.r r1 = e.c.d.i.c.r.f6218b
            if (r1 == 0) goto L_0x034d
            com.baidu.picapture.App r1 = f1954b
            com.arashivision.sdkcamera.InstaCameraSDK.init(r1)
            com.baidu.picapture.App r1 = f1954b
            com.arashivision.sdkmedia.InstaMediaSDK.init(r1)
            e.c.d.i.c.n r1 = e.c.d.i.c.n.f6212c
            if (r1 == 0) goto L_0x034c
            g.u r3 = new g.u
            r3.<init>()
            g.u$b r4 = new g.u$b
            r4.<init>(r3)
            r5 = 5
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r4.a(r5, r3)
            g.u r3 = new g.u
            r3.<init>(r4)
            r1.f6214b = r3
            e.c.d.i.c.s r1 = e.c.d.i.c.s.f6220b
            g.u r3 = new g.u
            r3.<init>()
            g.u$b r4 = new g.u$b
            r4.<init>(r3)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r5 = 1
            r4.c(r5, r3)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r4.b(r5, r3)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r4.a(r5, r3)
            g.u r3 = new g.u
            r3.<init>(r4)
            r1.f6221a = r3
            e.c.d.d.c.e r1 = e.c.d.d.c.e.f6006d
            if (r1 == 0) goto L_0x034b
            e.c.d.d.c.a r3 = e.c.d.d.c.a.f6002a
            com.baidu.sapi2.SapiAccountManager.registerSilentShareListener(r3)
            e.c.d.d.c.b r3 = new e.c.d.d.c.b
            r3.<init>(r1)
            com.baidu.sapi2.SapiAccountManager.registerReceiveShareListener(r3)
            e.c.d.d.c.c r3 = new e.c.d.d.c.c
            r3.<init>(r1)
            com.baidu.sapi2.PassportSDK.setLoginStatusChangeCallback(r3)
            e.c.d.d.c.e r1 = e.c.d.d.c.e.f6006d
            com.baidu.sapi2.dto.WebLoginDTO r3 = r1.f6008b
            java.util.List<com.baidu.sapi2.dto.PassNameValuePair> r3 = r3.extraParams
            com.baidu.sapi2.dto.PassNameValuePair r4 = com.baidu.sapi2.SapiWebView.EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER
            r3.add(r4)
            com.baidu.sapi2.utils.enums.Language r3 = com.baidu.sapi2.utils.enums.Language.CHINESE
            boolean r4 = com.baidu.picapture.model.device.LanguageUtils.isChineseLanguage()
            if (r4 != 0) goto L_0x0228
            com.baidu.sapi2.utils.enums.Language r3 = com.baidu.sapi2.utils.enums.Language.ENGLISH
        L_0x0228:
            com.baidu.sapi2.SapiConfiguration$Builder r4 = new com.baidu.sapi2.SapiConfiguration$Builder
            com.baidu.picapture.App r5 = f1954b
            r4.<init>(r5)
            java.lang.String r5 = "baidu_vr"
            java.lang.String r6 = "1"
            java.lang.String r8 = "7d231a54c9e5f1de2d3324c93ff12673"
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.setProductLineInfo(r5, r6, r8)
            r5 = 292615(0x47707, float:4.10041E-40)
            java.lang.String r6 = "292615"
            java.lang.String r8 = "42792fb99669c9f8732529e3e0547fb5"
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.sofireSdkConfig(r6, r8, r5)
            com.baidu.sapi2.utils.enums.Domain r5 = com.baidu.sapi2.utils.enums.Domain.DOMAIN_ONLINE
            com.baidu.sapi2.utils.enums.Domain r5 = r5.forceHttps(r9)
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.setRuntimeEnvironment(r5)
            com.baidu.sapi2.utils.enums.FastLoginFeature[] r5 = new com.baidu.sapi2.utils.enums.FastLoginFeature[r9]
            com.baidu.sapi2.utils.enums.FastLoginFeature r6 = com.baidu.sapi2.utils.enums.FastLoginFeature.TX_WEIXIN_SSO
            r5[r0] = r6
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.fastLoginSupport(r5)
            java.lang.String r5 = "wxf4d91e07aec514ad"
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.wxAppID(r5)
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.debug(r0)
            com.baidu.sapi2.SapiConfiguration$Builder r4 = r4.setSupportTouchLogin(r9)
            com.baidu.sapi2.SapiConfiguration$Builder r3 = r4.setLanguage(r3)
            com.baidu.sapi2.SapiConfiguration r3 = r3.build()
            com.baidu.sapi2.SapiAccountManager r4 = com.baidu.sapi2.SapiAccountManager.getInstance()
            r4.init(r3)
            com.baidu.sapi2.PassportSDK r3 = com.baidu.sapi2.PassportSDK.getInstance()
            r1.f6007a = r3
            boolean r3 = r1.c()
            if (r3 == 0) goto L_0x028f
            e.c.d.d.c.e r3 = e.c.d.d.c.e.f6006d
            com.baidu.sapi2.SapiAccount r3 = r3.a()
            java.lang.String r3 = r3.uid
            java.lang.String r3 = e.c.b.e.i.i(r3)
            r1.f6009c = r3
        L_0x028f:
            e.c.d.f.a r1 = e.c.d.f.a.c()
            r1.b()
            android.content.Context r1 = r12.getBaseContext()
            com.baidu.picapture.model.device.LanguageUtils.initContextSettingLanguage(r1)
            int r1 = android.os.Process.myPid()
            android.content.Context r3 = r12.getApplicationContext()
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.Object r3 = r3.getSystemService(r7)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            if (r3 != 0) goto L_0x02b2
            goto L_0x02cd
        L_0x02b2:
            java.util.List r3 = r3.getRunningAppProcesses()
            java.util.Iterator r3 = r3.iterator()
        L_0x02ba:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02cd
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r1) goto L_0x02ba
            java.lang.String r1 = r4.processName
            goto L_0x02cf
        L_0x02cd:
            java.lang.String r1 = ""
        L_0x02cf:
            java.lang.String r3 = r12.getPackageName()
            boolean r1 = r3.equals(r1)
            r12.f1955a = r1
            if (r1 == 0) goto L_0x0333
            e.c.d.l.c.h r1 = e.c.d.l.c.h.c()
            if (r1 == 0) goto L_0x0332
            e.c.d.d.f.b r2 = new e.c.d.d.f.b
            r2.<init>()
            r1.f6389d = r2
            e.c.d.d.f.b r2 = new e.c.d.d.f.b
            r2.<init>()
            r1.f6390e = r2
            com.baidu.picapture.App r2 = f1954b
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            r1.f6386a = r2
            android.net.NetworkRequest$Builder r2 = new android.net.NetworkRequest$Builder
            r2.<init>()
            android.net.NetworkRequest$Builder r0 = r2.addTransportType(r0)
            r2 = 12
            android.net.NetworkRequest$Builder r0 = r0.addCapability(r2)
            android.net.NetworkRequest r0 = r0.build()
            android.net.ConnectivityManager r3 = r1.f6386a
            android.net.ConnectivityManager$NetworkCallback r4 = r1.f6393h
            r3.requestNetwork(r0, r4)
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder
            r0.<init>()
            android.net.NetworkRequest$Builder r0 = r0.addTransportType(r9)
            android.net.NetworkRequest$Builder r0 = r0.addCapability(r2)
            android.net.NetworkRequest r0 = r0.build()
            android.net.ConnectivityManager r2 = r1.f6386a
            android.net.ConnectivityManager$NetworkCallback r1 = r1.f6394i
            r2.requestNetwork(r0, r1)
            goto L_0x0349
        L_0x0332:
            throw r2
        L_0x0333:
            e.c.d.d.b.b r0 = e.c.d.d.b.b.a()
            if (r0 == 0) goto L_0x034a
            android.content.Intent r1 = new android.content.Intent
            com.baidu.picapture.App r2 = f1954b
            java.lang.Class<com.baidu.picapture.common.ipc.IPCService> r3 = com.baidu.picapture.common.ipc.IPCService.class
            r1.<init>(r2, r3)
            com.baidu.picapture.App r2 = f1954b
            android.content.ServiceConnection r0 = r0.f5998b
            r2.bindService(r1, r0, r9)
        L_0x0349:
            return
        L_0x034a:
            throw r2
        L_0x034b:
            throw r2
        L_0x034c:
            throw r2
        L_0x034d:
            throw r2
        L_0x034e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.App.onCreate():void");
    }

    public void onTerminate() {
        super.onTerminate();
        h.c().b();
        if (this.f1955a) {
            h.c().b();
            return;
        }
        b a2 = b.a();
        if (a2 != null) {
            f1954b.unbindService(a2.f5998b);
            return;
        }
        throw null;
    }
}
