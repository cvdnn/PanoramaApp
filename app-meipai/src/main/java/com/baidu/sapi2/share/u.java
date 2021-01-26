package com.baidu.sapi2.share;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.ShareStorage.a;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.UUID;

/* compiled from: ShareStorage */
public class u extends GetUserInfoCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f2972a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Context f2973b;

    public u(a aVar, Context context) {
        this.f2972a = aVar;
        this.f2973b = context;
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        StorageModel storageModel = new StorageModel(null);
        storageModel.f2896b = 1;
        this.f2972a.a(storageModel);
    }

    public void onFailure(GetUserInfoResult getUserInfoResult) {
        StorageModel storageModel = new StorageModel(null);
        storageModel.f2896b = 1;
        this.f2972a.a(storageModel);
    }

    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        StorageModel storageModel = new StorageModel(null);
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (!TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
            storageModel.url = getUserInfoResult.portraitHttps;
        } else {
            storageModel.url = ShareStorage.f2890d;
        }
        SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
        storageModel.displayname = currentAccount.displayname;
        storageModel.app = SapiUtils.getAppName(this.f2973b);
        storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
        storageModel.pkg = this.f2973b.getPackageName();
        storageModel.f2895a = UUID.randomUUID().toString();
        storageModel.f2896b = 0;
        storageModel.f2898d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
        this.f2972a.a(storageModel);
    }
}
