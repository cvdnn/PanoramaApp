package com.baidu.picapture.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.ui.home.HomeActivity;
import com.baidu.picapture.ui.widget.dialog.NextPolicyPromptDialog;
import com.baidu.picapture.ui.widget.dialog.NextPolicyPromptDialog.b;
import com.baidu.picapture.ui.widget.dialog.PolicyPromptDialog;
import e.c.d.e.a0;
import e.c.d.m.a.a;
import e.c.d.m.g.c;
import e.c.d.m.g.d;
import e.c.d.m.i.i.k;
import e.c.d.n.e;
import java.util.Arrays;
import java.util.Hashtable;

public class SplashActivity extends a<a0> {
    public Handler s = new Handler();

    public /* synthetic */ void a(k kVar) {
        kVar.dismiss();
        i0();
    }

    public /* synthetic */ void b(k kVar) {
        kVar.dismiss();
        e.b("has_agreed_policy_prompt", false, false);
        b bVar = new b(null);
        bVar.f2082b = getString(R.string.next_policy_prompt_content);
        bVar.f2085e = false;
        String string = getString(R.string.next);
        c cVar = new c(this);
        bVar.f2083c = string;
        bVar.f2086f = cVar;
        NextPolicyPromptDialog nextPolicyPromptDialog = new NextPolicyPromptDialog(this, null);
        nextPolicyPromptDialog.f2076a = bVar;
        nextPolicyPromptDialog.show();
    }

    public /* synthetic */ void c(k kVar) {
        kVar.dismiss();
        this.s.postDelayed(new e.c.d.m.g.b(this), 1000);
        e.b("has_agreed_policy_prompt", true, false);
    }

    public d.w.a f0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_splash, null, false);
        if (inflate != null) {
            return new a0((LinearLayout) inflate);
        }
        throw new NullPointerException("rootView");
    }

    public void g0() {
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(action)) {
                    finish();
                    return;
                }
            }
        }
        if (e.a("has_agreed_policy_prompt", false)) {
            this.s.postDelayed(new e.c.d.m.g.b(this), 1000);
        } else {
            i0();
        }
    }

    public /* synthetic */ void h0() {
        a(HomeActivity.class, null);
        finish();
    }

    public final void i0() {
        Hashtable hashtable = new Hashtable();
        String string = getString(R.string.service_agreement);
        String[] strArr = new String[2];
        strArr[0] = getString(R.string.service_agreement_title);
        String str = "file:///android_asset/webcache/";
        strArr[1] = e.a.a.a.a.a(str, LanguageUtils.isChineseLanguage() ? "service.html" : "service-en.html");
        hashtable.put(string, Arrays.asList(strArr));
        String string2 = getString(R.string.privacy_policy);
        String[] strArr2 = new String[2];
        strArr2[0] = getString(R.string.privacy_policy_title);
        strArr2[1] = e.a.a.a.a.a(str, LanguageUtils.isChineseLanguage() ? "privacy.html" : "privacy-en.html");
        hashtable.put(string2, Arrays.asList(strArr2));
        PolicyPromptDialog.a aVar = new PolicyPromptDialog.a(null);
        aVar.f2096b = getString(R.string.policy_prompt_content);
        aVar.f2099e = false;
        aVar.f2100f = hashtable;
        String string3 = getString(R.string.disagree);
        d dVar = new d(this);
        aVar.f2097c = string3;
        aVar.f2101g = dVar;
        String string4 = getString(R.string.agree);
        e.c.d.m.g.a aVar2 = new e.c.d.m.g.a(this);
        aVar.f2098d = string4;
        aVar.f2102h = aVar2;
        PolicyPromptDialog policyPromptDialog = new PolicyPromptDialog(this, null);
        policyPromptDialog.f2087a = aVar;
        policyPromptDialog.show();
    }

    public void onDestroy() {
        super.onDestroy();
        this.s.removeCallbacksAndMessages(null);
        this.s = null;
    }
}
