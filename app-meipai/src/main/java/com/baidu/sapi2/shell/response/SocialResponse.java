package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccount.ExtraProperty;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONArray;
import org.json.JSONObject;

public class SocialResponse extends SapiAccountResponse {
    public boolean accountCenterFlag = false;
    public String baiduUname;
    public boolean bindConflict;
    public boolean bindGuide;
    public boolean isBinded = false;
    public String nextUrl;
    public boolean offlineNotice;
    public String socialUname;
    public String userInfoXmlContent;

    public SocialResponse() {
        String str = "";
        this.baiduUname = str;
        this.socialUname = str;
        this.bindGuide = false;
        this.offlineNotice = false;
    }

    public static SocialResponse fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SocialResponse socialResponse = new SocialResponse();
        socialResponse.errorCode = jSONObject.optInt("errno");
        socialResponse.errorMsg = jSONObject.optString("errmsg");
        socialResponse.livingUname = jSONObject.optString("livinguname");
        socialResponse.socialType = SocialType.getSocialType(jSONObject.optInt("os_type"));
        socialResponse.bduss = jSONObject.optString("bduss");
        socialResponse.socialPortraitUrl = jSONObject.optString("os_headurl");
        String optString = jSONObject.optString("incomplete_user");
        if ("0".equals(optString)) {
            socialResponse.accountType = AccountType.NORMAL;
        } else if ("1".equals(optString)) {
            socialResponse.accountType = AccountType.INCOMPLETE_USER;
        } else {
            socialResponse.accountType = AccountType.UNKNOWN;
        }
        socialResponse.uid = jSONObject.optString("bduid");
        socialResponse.isBinded = jSONObject.optBoolean("is_binded");
        socialResponse.displayname = jSONObject.optString("display_name");
        socialResponse.username = jSONObject.optString("passport_uname");
        socialResponse.ptoken = jSONObject.optString(SapiAccount.f2187g);
        String str = SapiAccount.f2188h;
        socialResponse.stoken = jSONObject.optString(str);
        JSONObject optJSONObject = jSONObject.optJSONObject(ExtraProperty.EXTRA_TPL_STOKEN_LIST);
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String[] split = optJSONArray.optString(i2).split("#");
                    if (split != null && split.length > 1) {
                        socialResponse.tplStokenMap.put(split[0], split[1]);
                    }
                }
            }
        }
        socialResponse.isGuestAccount = jSONObject.optString("guest_account");
        socialResponse.nextUrl = jSONObject.optString("next_url");
        socialResponse.userInfoXmlContent = jSONObject.optString("userInfoXmlContent");
        return socialResponse;
    }
}
