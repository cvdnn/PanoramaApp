package com.baidu.sapi2.dto;

import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;

public class WebSocialLoginDTO extends SapiWebDTO {
    public Context context;
    public boolean finishActivityAfterSuc = true;
    public SocialType socialType;
    public String statExtra;
}
