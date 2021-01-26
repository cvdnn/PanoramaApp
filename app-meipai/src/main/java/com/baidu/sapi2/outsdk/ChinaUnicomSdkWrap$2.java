package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.sdk.base.api.CallBack;
import e.a.a.a.a;
import org.json.JSONObject;

public class ChinaUnicomSdkWrap$2 implements CallBack<Object> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f2806a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f2807b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ String f2808c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ b f2809d;

    public ChinaUnicomSdkWrap$2(b bVar, OneKeyLoginCallback oneKeyLoginCallback, String str, String str2) {
        this.f2809d = bVar;
        this.f2806a = oneKeyLoginCallback;
        this.f2807b = str;
        this.f2808c = str2;
    }

    public void onFailed(int i2, int i3, String str, String str2) {
        StringBuilder a2 = a.a("onFailure  code:   ", i2, "   status: ", i3, "  msg：");
        a2.append(str);
        Log.e(c.f2814a, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("");
        SapiStatUtil.statPreGetPhoneInfo(0, sb.toString(), c.f2819f, this.f2807b, this.f2808c);
        new c().b(this.f2806a, -101, null);
    }

    public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
        Throwable th;
        Exception e2;
        String str3 = c.f2819f;
        int i4 = 1;
        StringBuilder a2 = a.a("onSuccess: code:", i2, "   status:", i3, "   msg:");
        a2.append(str);
        a2.append("    response: ");
        a2.append(obj);
        a2.append("    seq: ");
        a2.append(str2);
        int i5 = 0;
        Log.i(c.f2814a, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("");
        String sb2 = sb.toString();
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            if (jSONObject.optInt("code") == 0) {
                c.s = jSONObject.optString("accessCode");
                c.r = jSONObject.optString("fakeMobile");
            }
            if (!TextUtils.isEmpty(c.r)) {
                try {
                    if (this.f2806a != null) {
                        SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(this.f2806a, c.r);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else {
                new c().b(this.f2806a, -101, null);
                i4 = 0;
            }
            SapiContext.getInstance().put("china_telecom_expired_time", System.currentTimeMillis() / 1000);
        } catch (Exception e4) {
            i4 = 0;
            e2 = e4;
            try {
                Log.e(e2);
                new c().b(this.f2806a, -101, null);
                SapiStatUtil.statPreGetPhoneInfo(i4, sb2, str3, this.f2807b, this.f2808c);
            } catch (Throwable th2) {
                th = th2;
                i5 = i4;
                SapiStatUtil.statPreGetPhoneInfo(i5, sb2, str3, this.f2807b, this.f2808c);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            SapiStatUtil.statPreGetPhoneInfo(i5, sb2, str3, this.f2807b, this.f2808c);
            throw th;
        }
        SapiStatUtil.statPreGetPhoneInfo(i4, sb2, str3, this.f2807b, this.f2808c);
    }
}
