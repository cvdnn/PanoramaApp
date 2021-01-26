package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;

/* compiled from: ShareUtils */
public class w implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiContext f2974a;

    public w(SapiContext sapiContext) {
        this.f2974a = sapiContext;
    }

    public void run() {
        if (this.f2974a.getCurrentAccount() != null) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "slient_share");
            SapiAccountManager.getSilentShareListener().onSilentShare();
        }
    }
}
