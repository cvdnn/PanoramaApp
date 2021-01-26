package com.baidu.sapi2.service;

import android.app.Activity;
import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;

public interface AbstractThirdPartyService {
    public static final String EXTRA_RESULT_CODE = "result_code";
    public static final String EXTRA_RESULT_MSG = "result_msg";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static final int RESULT_AUTH_FAILURE = 1002;
    public static final int RESULT_AUTH_SUCCESS = 1001;

    void handleWXLoginResp(Activity activity, String str, String str2, int i2);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2);

    void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str);

    void socialBind(Activity activity, SocialType socialType, int i2, String str);
}
