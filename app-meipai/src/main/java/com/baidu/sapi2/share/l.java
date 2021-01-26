package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;

/* compiled from: ShareCallPacking */
public class l implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ boolean f2938a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ m f2939b;

    public l(m mVar, boolean z) {
        this.f2939b = mVar;
        this.f2938a = z;
    }

    public void run() {
        new ShareStorage().a(this.f2938a);
        x.c();
        SapiAccountManager.getInstance().getAccountService().refreshOpenidToUid();
    }
}
