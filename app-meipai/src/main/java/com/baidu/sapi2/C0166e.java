package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.callback.a.b;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.OneKeyLoginResult;
import e.a.a.a.a;

/* renamed from: com.baidu.sapi2.e reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0166e implements b {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ C0167f f2732a;

    public C0166e(C0167f fVar) {
        this.f2732a = fVar;
    }

    public void a(String str, String str2) {
        C0167f fVar = this.f2732a;
        if (fVar.f2735c) {
            Intent intent = new Intent(fVar.f2736d, LoadExternalWebViewActivity.class);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("&adapter=3");
            String a2 = a.a(sb.toString(), "&lastLoginType=oneKeyLogin");
            if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                a2 = a.a(a2, "&liveAbility=1");
            }
            intent.putExtra("extra_external_url", a2);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
            Context context = this.f2732a.f2736d;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f2732a.f2737e.E.startActivity(intent);
            return;
        }
        new c().a(this.f2732a.f2733a, (int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT, (String) null);
    }
}
