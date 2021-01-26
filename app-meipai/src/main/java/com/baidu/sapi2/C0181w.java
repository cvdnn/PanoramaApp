package com.baidu.sapi2;

import android.os.AsyncTask;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.n;
import com.youth.banner.config.BannerConfig;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.baidu.sapi2.w reason: case insensitive filesystem */
/* compiled from: SapiAccountRepository */
public class C0181w extends AsyncTask<String, Void, Long> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ String f3247a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f3248b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SsoHashCallback f3249c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ L f3250d;

    public C0181w(L l, String str, String str2, SsoHashCallback ssoHashCallback) {
        this.f3250d = l;
        this.f3247a = str;
        this.f3248b = str2;
        this.f3249c = ssoHashCallback;
    }

    /* renamed from: a */
    public Long doInBackground(String... strArr) {
        try {
            URLConnection openConnection = new URL(strArr[0]).openConnection();
            openConnection.setConnectTimeout(BannerConfig.LOOP_TIME);
            openConnection.connect();
            return Long.valueOf(openConnection.getDate() / 1000);
        } catch (Exception e2) {
            Log.e(e2);
            return Long.valueOf(0);
        }
    }

    /* renamed from: a */
    public void onPostExecute(Long l) {
        SsoHashResult ssoHashResult = new SsoHashResult();
        ssoHashResult.ssoHash = new n().a(l, this.f3247a, this.f3248b);
        ssoHashResult.setResultCode(0);
        this.f3249c.onSuccess(ssoHashResult);
    }
}
