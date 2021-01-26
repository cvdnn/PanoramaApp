package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import java.util.List;

/* compiled from: ShareCallPacking */
public class m {

    /* renamed from: a reason: collision with root package name */
    public static final String f2940a = "extra_trace_id";

    /* renamed from: b reason: collision with root package name */
    public static final String f2941b = "extra_session_id";

    /* renamed from: c reason: collision with root package name */
    public static final String f2942c = "V2_FACE_LOGIN_UIDS_TIMES";

    /* renamed from: d reason: collision with root package name */
    public static final String f2943d = "FACE_LOGIN_MODEL";

    /* renamed from: e reason: collision with root package name */
    public static final String f2944e = "PKG";

    /* renamed from: f reason: collision with root package name */
    public static final String f2945f = "SDK_VERSION";

    /* renamed from: g reason: collision with root package name */
    public static final int f2946g = 20001;

    /* renamed from: h reason: collision with root package name */
    public static final int f2947h = 190;

    /* renamed from: i reason: collision with root package name */
    public static final String f2948i = "choice_share";

    /* renamed from: j reason: collision with root package name */
    public static final String f2949j = "choice_share_v2";
    public static b k;

    /* compiled from: ShareCallPacking */
    public static abstract class a {
        public void onFailed(int i2, String str) {
        }

        public abstract void onSuccess();
    }

    /* compiled from: ShareCallPacking */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public static final String f2950a = "index";

        /* renamed from: b reason: collision with root package name */
        public static final String f2951b = "account_tpl";

        /* renamed from: c reason: collision with root package name */
        public static final String f2952c = "account_app";

        /* renamed from: d reason: collision with root package name */
        public int f2953d;

        /* renamed from: e reason: collision with root package name */
        public String f2954e;

        /* renamed from: f reason: collision with root package name */
        public String f2955f;
    }

    public boolean a(Context context, String str) {
        return x.a(context, str);
    }

    public void a(boolean z) {
        ThreadPoolService.getInstance().run(new TPRunnable(new l(this, z)));
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list) {
        x.a(activity, str, str2, str3, str4, list);
    }

    public void a(a aVar, int i2, int i3, Intent intent, List<PassNameValuePair> list) {
        x.a(aVar, i2, i3, intent, this, list);
    }
}
