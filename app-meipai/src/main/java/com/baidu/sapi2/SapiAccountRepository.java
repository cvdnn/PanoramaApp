package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;

/* renamed from: com.baidu.sapi2.s reason: case insensitive filesystem */
public class SapiAccountRepository extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ L f2864a;

    public SapiAccountRepository(L l, Looper looper) {
        this.f2864a = l;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        super.onFailure(th, i2, str);
    }

    public void onSuccess(int i2, String str) {
        super.onSuccess(i2, str);
    }
}
