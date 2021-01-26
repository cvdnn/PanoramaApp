package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.share.ShareService.a;

/* compiled from: ShareService */
public class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f2968a;

    public r(a aVar) {
        this.f2968a = aVar;
    }

    public void run() {
        if (SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
    }
}
