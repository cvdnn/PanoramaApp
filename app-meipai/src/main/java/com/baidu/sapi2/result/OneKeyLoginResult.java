package com.baidu.sapi2.result;

public class OneKeyLoginResult extends SapiResult {
    public static final int ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT = -109;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL = -106;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL = -108;
    public static final int ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL = -107;
    public static final int ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL = -105;
    public static final int ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL = -102;
    public static final int ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT = -111;
    public static final int ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS = -104;
    public static final int ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE = -110;
    public static final int ONE_KEY_LOGIN_CODE_LOGIN_FAIL = -103;
    public static final int ONE_KEY_LOGIN_CODE_UNKNOW = -100;
    public static final int ONE_KEY_LOGIN_CODE_UNSUPPORT = -101;

    /* renamed from: a reason: collision with root package name */
    public static final String f2854a = "未知错误";

    /* renamed from: b reason: collision with root package name */
    public static final String f2855b = "不支持一键登录";

    /* renamed from: c reason: collision with root package name */
    public static final String f2856c = "获取token失败";

    /* renamed from: d reason: collision with root package name */
    public static final String f2857d = "一键登录失败";

    /* renamed from: e reason: collision with root package name */
    public static final String f2858e = "进行引导流程中";

    /* renamed from: f reason: collision with root package name */
    public static final String f2859f = "获取JS代码失败";

    /* renamed from: g reason: collision with root package name */
    public static final String f2860g = "JS代码校验失败";

    /* renamed from: h reason: collision with root package name */
    public static final String f2861h = "执行JS代码失败";

    /* renamed from: i reason: collision with root package name */
    public static final String f2862i = "sign签名校验失败";

    /* renamed from: j reason: collision with root package name */
    public static final String f2863j = "Android版本低于KITKAT";
    public static final String k = "冷启预取号失败，二次取号时已登录";
    public static final String l = "一键登录命中风控，登录失败";
    public static String secondJsCode;
    public boolean enable;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public String operator;
    public String sign;

    public OneKeyLoginResult() {
        this.msgMap.put(-100, f2854a);
        this.msgMap.put(-101, f2855b);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, f2856c);
        this.msgMap.put(-103, f2857d);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, f2858e);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, f2859f);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, f2860g);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, f2861h);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL, f2862i);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, f2863j);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE, k);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT, l);
    }
}
