package com.baidu.pass.biometrics.base.http.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.utils.Crypto;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HttpUtils {
    public static String getNonce(Context context, List<RestNameValuePair> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList, new Comparator<RestNameValuePair>() {
            public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
            }
        });
        RestNameValuePair restNameValuePair = new RestNameValuePair();
        restNameValuePair.setName("key");
        MessageDigest messageDigest = null;
        try {
            str = Crypto.sha1(context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        restNameValuePair.setValue(str);
        arrayList.add(restNameValuePair);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        }
        String str2 = "";
        if (messageDigest == null) {
            return str2;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            RestNameValuePair restNameValuePair2 = (RestNameValuePair) arrayList.get(i2);
            String name = restNameValuePair2.getName();
            String value = restNameValuePair2.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = str2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append('=');
                sb.append(value);
                if (i2 != arrayList.size() - 1) {
                    sb.append('&');
                }
                if (!TextUtils.isEmpty(sb)) {
                    messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                }
            }
        }
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b2 : digest) {
            sb2.append(Integer.toHexString((b2 & 255) | -256).substring(6));
        }
        return sb2.toString();
    }
}
