package com.baidu.sapi2.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;

/* compiled from: FingerprintHelper */
public class g extends AuthenticationCallback {

    /* renamed from: a reason: collision with root package name */
    public static final int f2699a = 0;

    /* renamed from: b reason: collision with root package name */
    public static final int f2700b = -2;

    /* renamed from: c reason: collision with root package name */
    public static final int f2701c = -3;

    /* renamed from: d reason: collision with root package name */
    public static final int f2702d = -8;

    /* renamed from: e reason: collision with root package name */
    public static final String f2703e = "g";

    /* renamed from: f reason: collision with root package name */
    public static final int f2704f = 5;

    /* renamed from: g reason: collision with root package name */
    public int f2705g;

    /* renamed from: h reason: collision with root package name */
    public char f2706h = 5;

    /* renamed from: i reason: collision with root package name */
    public Context f2707i;

    /* renamed from: j reason: collision with root package name */
    public FingerprintManager f2708j;
    public CryptoObject k = null;
    public CancellationSignal l = null;
    public a m;
    public b n;

    public g(Context context, b bVar) {
        this.f2707i = context;
        this.n = bVar;
        this.f2708j = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.k = null;
        this.l = new CancellationSignal();
    }

    private void b() {
        a((Activity) this.f2707i, (Dialog) this.n);
        this.n.a("百度帐号 触控ID", "请验证已有手机指纹").a(1).setNegativeBtn(SapiWebView.A, new c(this)).showDialog();
    }

    private void c() {
        a((Activity) this.f2707i, (Dialog) this.n);
        String str = "换个登录方式";
        this.n.a("再试一次", "请验证已有手机指纹").a(2).setNegativeBtn(SapiWebView.A, new f(this)).setPositiveBtn(str, new e(this)).showDialog();
    }

    private void d() {
        a((Activity) this.f2707i, (Dialog) this.n);
        this.n.a("再试一次", "请验证已有手机指纹").a(1).setNegativeBtn(SapiWebView.A, new d(this)).showDialog();
    }

    public void onAuthenticationError(int i2, CharSequence charSequence) {
        super.onAuthenticationError(i2, charSequence);
        String str = f2703e;
        StringBuilder sb = new StringBuilder();
        sb.append("Authentication error:");
        sb.append(i2);
        sb.append(charSequence);
        Log.i(str, sb.toString());
        a();
        this.f2706h = 5;
        if (i2 == 7) {
            a aVar = this.m;
            if (aVar != null) {
                aVar.onCall(-8);
                return;
            }
            return;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.onCall(i2);
        }
    }

    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(f2703e, "Authentication failed ");
        char c2 = (char) (this.f2706h - 1);
        this.f2706h = c2;
        if (c2 <= 0) {
            a();
            this.f2706h = 5;
        } else if (this.f2705g == 3) {
            c();
        } else {
            d();
        }
    }

    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        super.onAuthenticationHelp(i2, charSequence);
        String str = f2703e;
        StringBuilder sb = new StringBuilder();
        sb.append("Authentication help:");
        sb.append(i2);
        sb.append(charSequence);
        Log.i(str, sb.toString());
    }

    public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(f2703e, "Authentication Succeeded ");
        a((Activity) this.f2707i, (Dialog) this.n);
        a aVar = this.m;
        if (aVar != null) {
            aVar.onCall(0);
        }
    }

    public void a(int i2, a aVar) {
        Log.i(f2703e, "startAuthenticate");
        this.f2705g = i2;
        this.m = aVar;
        if (this.l.isCanceled()) {
            this.l = new CancellationSignal();
        }
        this.f2708j.authenticate(this.k, this.l, 0, this, null);
        b();
    }

    public void a() {
        Log.i(f2703e, "stopAuthenticate");
        a((Activity) this.f2707i, (Dialog) this.n);
        this.l.cancel();
        this.f2708j.authenticate(this.k, this.l, 0, this, null);
    }

    public static void a(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }
}
