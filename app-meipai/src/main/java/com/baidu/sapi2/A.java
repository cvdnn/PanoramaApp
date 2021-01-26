package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.a.a;
import com.baidu.sapi2.callback.a.b;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class A implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f2104a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ b f2105b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2106c;

    public A(L l, OneKeyLoginCallback oneKeyLoginCallback, b bVar) {
        this.f2106c = l;
        this.f2104a = oneKeyLoginCallback;
        this.f2105b = bVar;
    }

    public void a(String str) {
        JSONObject jSONObject = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            HttpHashMap httpHashMap = new HttpHashMap();
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    httpHashMap.put(str2, jSONObject.optString(str2));
                }
            }
            L l = this.f2106c;
            new HttpClientWrap().post(this.f2106c.l(), httpHashMap, l.a(l.f2155d.context, this.f2106c.f2155d), this.f2106c.x(), new z(this, Looper.getMainLooper()));
            return;
        }
        Log.e(L.f2152a, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
        new c().a(this.f2104a, (int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, (String) null);
    }
}
