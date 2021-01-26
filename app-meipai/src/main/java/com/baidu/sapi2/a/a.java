package com.baidu.sapi2.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.BceConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: SapiScheme */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final String f2510a = "SapiScheme";

    /* renamed from: b reason: collision with root package name */
    public static final String f2511b = "3.0.5";

    /* renamed from: c reason: collision with root package name */
    public static final int f2512c = 2;

    /* renamed from: d reason: collision with root package name */
    public static final String f2513d = "3.0.5";

    /* renamed from: e reason: collision with root package name */
    public static final String f2514e = "com.baidu.passport.securitycenter";

    /* renamed from: f reason: collision with root package name */
    public static final String f2515f = "baiduppscapp";

    /* renamed from: g reason: collision with root package name */
    public static final String f2516g = "otp";

    /* renamed from: h reason: collision with root package name */
    public static final int f2517h = 0;

    /* renamed from: i reason: collision with root package name */
    public static final int f2518i = 1;

    /* renamed from: j reason: collision with root package name */
    public static final int f2519j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 3001;
    public static final String n = "achieve_sc_app_data";
    public InvokeScAppResult o;
    public b p;

    public int a(Context context, String str, InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(f2514e, 0);
        } catch (NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return 2;
        }
        if (SapiUtils.versionCompareTo(packageInfo.versionName, str) < 0) {
            return 1;
        }
        if (invokeScAppCallback == null) {
            return 4;
        }
        if (!a(context, context.getPackageName())) {
            return 3;
        }
        return 0;
    }

    public void a(Activity activity, String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult) {
        this.o = invokeScAppResult;
        a aVar = new a();
        if (!aVar.a((Context) activity, f2514e)) {
            this.o.setInvokeResult(a((int) b.f2521b, b.f2523d));
            return;
        }
        try {
            aVar.a(activity, aVar.a(str, str2, list));
        } catch (Exception unused) {
            this.o.setInvokeResult(a((int) b.f2520a, b.f2522c));
        }
    }

    public void a(int i2, int i3, Intent intent) {
        if (this.o != null) {
            String str = null;
            if (intent != null) {
                str = intent.getExtras().getString(n);
            }
            this.o.setInvokeResult(str);
        }
    }

    private String a(String str, String str2, List<PassNameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("baiduppscapp://v2");
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(str);
        sb.append("?");
        String sb2 = sb.toString();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new PassNameValuePair("minver", str2));
        return e.a.a.a.a.a(sb2, SapiUtils.createRequestParams(list));
    }

    private void a(Activity activity, String str) throws Exception {
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), m);
    }

    public boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(SapiContext.getInstance().getAuthorizedPackages());
            hashMap.putAll(SapiContext.getInstance().getSCAuthorizedPackages());
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (!TextUtils.isEmpty(packageSign)) {
                for (String str2 : hashMap.keySet()) {
                    if (str.matches(str2) && packageSign.equals(hashMap.get(str2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String a(int i2, String str) {
        b bVar = new b();
        this.p = bVar;
        bVar.setResultCode(i2);
        this.p.setResultMsg(str);
        return this.p.a();
    }
}
