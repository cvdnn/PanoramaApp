package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiDeviceUtils.DeviceCrypto;
import e.c.b.e.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Security */
public class n {
    @TargetApi(8)
    public String a(Long l, String str, String str2) {
        String str3;
        String str4 = "";
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        String packageName = confignation.context.getPackageName();
        String packageSign = SapiUtils.getPackageSign(confignation.context, packageName);
        String packageSign2 = SapiUtils.getPackageSign(confignation.context, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", SapiAccountService.f2213b);
            jSONObject.put("timestamp", l);
            jSONObject.put("host_api_key", confignation.bdOauthAppId);
            jSONObject.put("host_pkgname", packageName);
            jSONObject.put("host_key_hash", packageSign);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str3 = str4;
            } else {
                str3 = currentAccount.bduss;
            }
            jSONObject.put("bduss_sign", Utils.a(str3.getBytes(), false));
            jSONObject.put("pkgname", str);
            jSONObject.put("key_hash", packageSign2);
            jSONObject.put("app_id", str2);
        } catch (JSONException e2) {
            Log.e(e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("as#JU*342ns");
        sb.append(str2);
        sb.append("#$FW34sfs");
        String a2 = Utils.a(sb.toString().getBytes(), false);
        String substring = a2.substring(0, 16);
        try {
            return DeviceCrypto.base64Encode(new AES().encrypt(jSONObject.toString(), new StringBuffer(a2.substring(a2.length() - 16, a2.length())).reverse().toString(), substring));
        } catch (Exception e3) {
            Log.e(e3);
            return str4;
        }
    }
}
