package com.baidu.sapi2;

import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.List;

/* renamed from: com.baidu.sapi2.i reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0170i extends WebAuthListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ List f2750a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f2751b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ boolean f2752c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2753d;

    public C0170i(PassportSDK passportSDK, List list, String str, boolean z) {
        this.f2753d = passportSDK;
        this.f2750a = list;
        this.f2751b = str;
        this.f2752c = z;
    }

    public void onFailure(WebAuthResult webAuthResult) {
    }

    public void onSuccess(WebAuthResult webAuthResult) {
        this.f2750a.add(webAuthResult);
        String str = "?";
        if (this.f2751b.indexOf(str) > 0) {
            str = "&";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2751b);
        sb.append(str);
        sb.append("login_action_type=");
        sb.append(SapiUtils.getLastLoginType());
        sb.append("&clientfrom=android");
        this.f2753d.a(sb.toString(), this.f2752c);
    }
}
