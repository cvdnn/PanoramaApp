package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccount.ExtraProperty;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.share.m.b;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView.f;
import com.baidubce.AbstractBceClient;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SapiStatUtil {
    public static final String LOGIN_STATUS_BDUSS_INVALIDATE = "2";
    public static final String LOGIN_STATUS_BDUSS_VALIDATE = "0";
    public static final String LOGIN_STATUS_NO_LOGIN = "1";
    public static final String LOGIN_STATUS_UNKNOWN = "3";

    public static void buildStatExtraMap(Map<String, String> map, List<PassNameValuePair> list) {
        if (list != null && !list.isEmpty()) {
            for (PassNameValuePair passNameValuePair : list) {
                String str = "extrajson";
                if (passNameValuePair.name.equals(str) && SapiUtils.statExtraValid(passNameValuePair.getValue())) {
                    map.put(str, passNameValuePair.getValue());
                }
            }
        }
    }

    public static void statLoadLogin(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str);
        }
        t.a("load_login", (Map<String, String>) hashMap);
    }

    public static void statPreGetPhoneInfo(int i2, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String str5 = "";
        sb.append(str5);
        hashMap.put("cm_pre_phone", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str5);
        hashMap.put("cm_pre_phone_errno", sb2.toString());
        hashMap.put("operator", str2);
        String str6 = "1".equals(str4) ? WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA : "2".equals(str4) ? "wifi" : "3".equals(str4) ? "dataAndWifi" : "unknown";
        hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str3);
        hashMap.put("netType", str6);
        t.a("pass_sdk_init", (Map<String, String>) hashMap);
    }

    public static void statShareClickOther(String str, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        if (str.equals("v2")) {
            t.a("share_v2_click_other", (Map<String, String>) hashMap);
        } else if (str.equals(AbstractBceClient.URL_PREFIX)) {
            t.a("share_v1_click_other", (Map<String, String>) hashMap);
        }
    }

    public static void statShareV1AccountClick(int i2, String str, String str2, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        hashMap.put("index", sb.toString());
        hashMap.put(b.f2951b, str);
        hashMap.put(b.f2952c, str2);
        t.a("share_v1_account_click", (Map<String, String>) hashMap);
    }

    public static void statShareV1Login(SapiAccount sapiAccount, List<PassNameValuePair> list) {
        String accountActionType = SapiContext.getInstance().getAccountActionType();
        String str = m.f2948i;
        if (str.equals(accountActionType)) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, str);
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            hashMap.put(b.f2951b, sapiAccount.getShareAccountTpl());
            hashMap.put(b.f2952c, sapiAccount.app);
            hashMap.put("uid", sapiAccount.uid);
            t.a("share_v1_account_suc", (Map<String, String>) hashMap);
        }
    }

    public static void statShareV1OpenPage(List<SapiAccount> list, List<PassNameValuePair> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SapiAccount sapiAccount : list) {
            if (!TextUtils.isEmpty(sapiAccount.getShareAccountTpl())) {
                arrayList.add(sapiAccount.getShareAccountTpl());
            }
            if (!TextUtils.isEmpty(sapiAccount.app)) {
                arrayList2.add(sapiAccount.app);
            }
        }
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list2);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        sb.append("");
        hashMap.put("account_size", sb.toString());
        String str = ",";
        hashMap.put("account_tpls", TextUtils.join(str, arrayList));
        hashMap.put("account_apps", TextUtils.join(str, arrayList2));
        t.a("share_v1_account_open", (Map<String, String>) hashMap);
    }

    public static void statShareV2ActiveLoginSuc() {
        t.a("share_v2_active_login_suc", (Map<String, String>) new HashMap<String,String>());
    }

    public static void statShareV2Click(b bVar, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        a.a(new StringBuilder(), bVar.f2953d, "", hashMap, "index");
        hashMap.put(b.f2951b, bVar.f2954e);
        hashMap.put(b.f2952c, bVar.f2955f);
        t.a("share_account_click", (Map<String, String>) hashMap);
    }

    public static void statShareV2Invoke(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(c.k, str);
        t.a("share_v2_invoke", (Map<String, String>) hashMap);
    }

    public static void statShareV2Oauth() {
        t.a("share_v2_oauth", (Map<String, String>) new HashMap<String,String>());
    }

    public static void statShareV2OauthSuc() {
        t.a("share_v2_oauth_suc", (Map<String, String>) new HashMap<String,String>());
    }

    public static void statShareV2Open(List<StorageModel> list, String str, List<PassNameValuePair> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (StorageModel storageModel : list) {
            if (!TextUtils.isEmpty(storageModel.tpl)) {
                arrayList.add(storageModel.tpl);
            }
            if (!TextUtils.isEmpty(storageModel.app)) {
                arrayList2.add(storageModel.app);
            }
        }
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str);
        }
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        sb.append("");
        hashMap.put("account_size", sb.toString());
        String str2 = ",";
        hashMap.put("account_tpls", TextUtils.join(str2, arrayList));
        hashMap.put("account_apps", TextUtils.join(str2, arrayList2));
        t.a("share_account_open", (Map<String, String>) hashMap);
    }

    public static void statShareV2OpenMax(Context context, int i2, int i3, int i4, int i5, ShareStorage shareStorage, List<StorageModel> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String str = "";
        sb.append(str);
        hashMap.put("read_failure_count", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i3);
        sb2.append(str);
        hashMap.put("read_sp_count", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i4);
        sb3.append(str);
        hashMap.put("read_sd_count", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i5);
        sb4.append(str);
        hashMap.put("app_count", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(list.size());
        sb5.append(str);
        hashMap.put("share_count", sb5.toString());
        hashMap.put("os_version", VERSION.RELEASE);
        hashMap.put("chmod", shareStorage.readSpFromChmodFile ? "1" : "0");
        t.a("share_read", (Map<String, String>) hashMap);
    }

    public static void statShareV2OtherFail(int i2) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        hashMap.put(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, sb.toString());
        t.a("share_v2_oauth_fail", (Map<String, String>) hashMap);
    }

    public static void statShareV2Result(b bVar, String str, int i2, String str2, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        hashMap.put("share_result", sb.toString());
        hashMap.put("fail_reason", str);
        if (m.k != null) {
            hashMap.put(b.f2951b, bVar.f2954e);
            hashMap.put(b.f2952c, bVar.f2955f);
        }
        hashMap.put("uid", str2);
        t.a("share_account_result", (Map<String, String>) hashMap);
    }

    public static void statSmsCodeClip(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("os_version", VERSION.RELEASE);
        hashMap.put(f.k, str);
        t.a("get_sms_check_code_from_clip", (Map<String, String>) hashMap);
    }

    public static void statThirdLoginEnter(SocialType socialType) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientip", SapiUtils.getLocalIpAddress());
        hashMap.put("client", SapiDeviceInfo.f3010c);
        StringBuilder sb = new StringBuilder();
        sb.append(socialType.getType());
        String str = "";
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = ExtraProperty.EXTRA_SOCIAL_TYPE;
        hashMap.put(str2, sb2);
        if (SocialType.SINA_WEIBO_SSO == socialType) {
            hashMap.put("is_sso", "1");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(socialType.getType());
        sb3.append(str);
        hashMap.put(str2, sb3.toString());
        t.a("thirdlogin_enter", (Map<String, String>) hashMap);
    }
}
