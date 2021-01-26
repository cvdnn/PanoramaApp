package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import e.c.b.e.Utils;
import java.util.Random;

public class PassBioDataEncryptor {
    public static final String TAG = "PassBioDataEncryptor";

    public static String decryptAccountInfo(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str3 = new String(Utils.a(new AES().decrypt(Utils.a(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), "UTF-8").trim();
        } catch (Throwable th) {
            String str4 = TAG;
            Log.e(str4, str4, th);
            str3 = "";
        }
        return str3;
    }

    public static String encryptAccountInfo(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str3 = Utils.b(new AES().encrypt(Utils.b(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2));
        } catch (Throwable th) {
            String str4 = TAG;
            Log.e(str4, str4, th);
            str3 = "";
        }
        return str3;
    }

    public static String encryptParams(String str) {
        String str2;
        String str3 = "";
        String randomKey = getRandomKey(16);
        try {
            str2 = Utils.b(new AES().encrypt(str, new StringBuffer(randomKey).reverse().toString(), randomKey));
            try {
                str3 = Utils.b(RSA.encrypt(randomKey));
            } catch (Exception e2) {
                e = e2;
                String str4 = TAG;
                Log.e(str4, str4, e);
                return TextUtils.join("_", new String[]{str3, str2});
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str3;
            String str42 = TAG;
            Log.e(str42, str42, e);
            return TextUtils.join("_", new String[]{str3, str2});
        }
        return TextUtils.join("_", new String[]{str3, str2});
    }

    public static String getRandomKey(int i2) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }
}
