package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.cmic.sso.sdk.auth.AuthnHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OneKeyLoginSdkCall */
public class c {

    /* renamed from: a reason: collision with root package name */
    public static final String f2814a = "OneKeyLogin";

    /* renamed from: b reason: collision with root package name */
    public static final int f2815b = 1;

    /* renamed from: c reason: collision with root package name */
    public static final int f2816c = 2;

    /* renamed from: d reason: collision with root package name */
    public static final int f2817d = 3;

    /* renamed from: e reason: collision with root package name */
    public static final String f2818e = "CM";

    /* renamed from: f reason: collision with root package name */
    public static final String f2819f = "CU";

    /* renamed from: g reason: collision with root package name */
    public static final String f2820g = "CT";

    /* renamed from: h reason: collision with root package name */
    public static final String f2821h = "0";

    /* renamed from: i reason: collision with root package name */
    public static final String f2822i = "1";

    /* renamed from: j reason: collision with root package name */
    public static final String f2823j = "3";
    public static final String k = "login";
    public static final String l = "init";
    public static final String m = "sapi";
    public static final String n = "product";
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;

    /* compiled from: OneKeyLoginSdkCall */
    public interface a {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    private boolean c(SapiConfiguration sapiConfiguration) {
        if (TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaUnicomAppPublicKey) || !SapiContext.getInstance().isMeetOneKeyLoginGray(2)) {
            return false;
        }
        return true;
    }

    public void a(SapiConfiguration sapiConfiguration, String str) {
        a(sapiConfiguration, str, (OneKeyLoginCallback) null);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (a()) {
                boolean isEmpty = TextUtils.isEmpty(o);
                String str = "operator";
                String str2 = SapiAccount.f2185e;
                if (!isEmpty) {
                    jSONObject.put(str2, o);
                    jSONObject.put(str, f2818e);
                } else if (!TextUtils.isEmpty(p)) {
                    jSONObject.put(str2, p);
                    jSONObject.put(str, f2820g);
                } else {
                    jSONObject.put(str2, r);
                    jSONObject.put(str, f2819f);
                    jSONObject.put("CUVersion", "2");
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    public void a(SapiConfiguration sapiConfiguration, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        JSONObject jSONObject;
        boolean isLogin = SapiAccountManager.getInstance().isLogin();
        String str2 = f2814a;
        if (isLogin) {
            Log.i(str2, "is login");
            b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE, null);
            return;
        }
        String str3 = "0";
        if (!TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) && !TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey)) {
            try {
                jSONObject = AuthnHelper.getInstance(sapiConfiguration.context, a.f2810a).getNetworkType(sapiConfiguration.context);
            } catch (Throwable th) {
                Log.e(str2, th);
                jSONObject = null;
            }
            if (jSONObject == null) {
                b(oneKeyLoginCallback, -100, null);
                return;
            }
            int optInt = jSONObject.optInt("operatortype");
            String optString = jSONObject.optString("networktype");
            StringBuilder sb = new StringBuilder();
            sb.append("operatorType = ");
            sb.append(optInt);
            sb.append(" netType = ");
            sb.append(optString);
            Log.i(str2, sb.toString());
            if (TextUtils.isEmpty(optString)) {
                optString = str3;
            }
            if (optInt != 1) {
                String str4 = "3";
                String str5 = "1";
                if (optInt != 2) {
                    if (optInt != 3) {
                        b(oneKeyLoginCallback, -100, null);
                    } else if ((str5.equals(optString) || str4.equals(optString)) && b(sapiConfiguration)) {
                        new ChinaTelecomSdkWrap().a(sapiConfiguration, str, optString, oneKeyLoginCallback);
                    } else {
                        b(oneKeyLoginCallback, -101, null);
                    }
                } else if ((str5.equals(optString) || str4.equals(optString)) && c(sapiConfiguration)) {
                    new b().a(sapiConfiguration, str, optString, oneKeyLoginCallback);
                } else {
                    b(oneKeyLoginCallback, -101, null);
                }
            } else if (str3.equals(optString) || !a(sapiConfiguration)) {
                b(oneKeyLoginCallback, -101, null);
            } else {
                new a().a(sapiConfiguration, str, optString, oneKeyLoginCallback);
            }
        } else if (b(sapiConfiguration)) {
            new ChinaTelecomSdkWrap().a(sapiConfiguration, str, str3, oneKeyLoginCallback);
        } else if (c(sapiConfiguration)) {
            new b().a(sapiConfiguration, str, str3, oneKeyLoginCallback);
        } else {
            b(oneKeyLoginCallback, -101, null);
        }
    }

    public String c() {
        if (!a()) {
            return null;
        }
        if (!TextUtils.isEmpty(o)) {
            return f2818e;
        }
        return !TextUtils.isEmpty(p) ? f2820g : f2819f;
    }

    private boolean b(SapiConfiguration sapiConfiguration) {
        if (TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppKey) || TextUtils.isEmpty(sapiConfiguration.chinaTelecomAppSecret) || !SapiContext.getInstance().isMeetOneKeyLoginGray(3)) {
            return false;
        }
        return true;
    }

    public void b(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    public void a(SapiConfiguration sapiConfiguration, a aVar) {
        if (!TextUtils.isEmpty(o)) {
            new a().a(sapiConfiguration, aVar);
        } else if (!TextUtils.isEmpty(q)) {
            new ChinaTelecomSdkWrap().a(sapiConfiguration, aVar);
        } else if (!TextUtils.isEmpty(s)) {
            new b().a(sapiConfiguration, aVar);
        } else {
            aVar.onGetTokenComplete(new JSONObject());
        }
    }

    private boolean a(SapiConfiguration sapiConfiguration) {
        if (TextUtils.isEmpty(sapiConfiguration.chinaMobileAppID) || TextUtils.isEmpty(sapiConfiguration.chinaMobileAppKey) || !SapiContext.getInstance().isMeetOneKeyLoginGray(1)) {
            return false;
        }
        return true;
    }

    public boolean a() {
        if (TextUtils.isEmpty(p) && TextUtils.isEmpty(o) && TextUtils.isEmpty(r)) {
            return false;
        }
        return true;
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }
}
