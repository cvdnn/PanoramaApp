package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.util.Base64;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.a;
import e.c.b.e.Utils;

/* compiled from: ShareStorage */
public class s implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ StorageModel f2969a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ t f2970b;

    public s(t tVar, StorageModel storageModel) {
        this.f2970b = tVar;
        this.f2969a = storageModel;
    }

    @TargetApi(8)
    public void run() {
        String str;
        LoginShareStrategy loginShareStrategy = SapiAccountManager.getInstance().getConfignation().loginShareStrategy();
        String loginShareDirection = SapiAccountManager.getInstance().getConfignation().loginShareDirection();
        if (loginShareStrategy == LoginShareStrategy.DISABLED || a.f3068a.equals(loginShareDirection)) {
            this.f2969a.f2896b = 1;
        }
        String a2 = Utils.a(this.f2970b.f2971a.f2894h.getPackageName().getBytes(), false);
        try {
            str = new String(Base64.encode(new AES().encrypt(this.f2969a.a().toString(), ShareStorage.f2892f, ShareStorage.f2891e), 0));
        } catch (Exception e2) {
            Log.e(e2);
            str = "";
        }
        this.f2970b.f2971a.setSp(a2, str);
        this.f2970b.f2971a.setSd(a2, str);
    }
}
