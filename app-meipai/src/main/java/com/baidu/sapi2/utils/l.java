package com.baidu.sapi2.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.sapi2.SapiWebView;

/* compiled from: SapiWebViewUtil */
public class l implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiWebView f3107a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ View f3108b;

    public l(SapiWebView sapiWebView, View view) {
        this.f3107a = sapiWebView;
        this.f3108b = view;
    }

    public void onClick(View view) {
        this.f3107a.post(new k(this));
    }
}
