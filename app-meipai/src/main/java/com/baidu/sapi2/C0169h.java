package com.baidu.sapi2;

import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import java.util.List;

/* renamed from: com.baidu.sapi2.h reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0169h extends QrLoginCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ QrLoginCallback f2739a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ List f2740b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2741c;

    public C0169h(PassportSDK passportSDK, QrLoginCallback qrLoginCallback, List list) {
        this.f2741c = passportSDK;
        this.f2739a = qrLoginCallback;
        this.f2740b = list;
    }

    public void onFinish(QrLoginResult qrLoginResult) {
        this.f2739a.onFinish(qrLoginResult);
        if (this.f2740b.size() == 1) {
            ((WebAuthResult) this.f2740b.get(0)).finishActivity();
            this.f2739a.onLocalLogin((WebAuthResult) this.f2740b.get(0));
        }
    }

    public void onLocalLogin(WebAuthResult webAuthResult) {
    }
}
