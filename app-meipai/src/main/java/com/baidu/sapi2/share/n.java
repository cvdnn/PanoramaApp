package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.h;
import com.baidu.sapi2.utils.t;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ShareEncryptor */
public final class n {

    /* renamed from: a reason: collision with root package name */
    public static String f2956a;

    public static String a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(new AES("AES", h.p).decrypt(SapiDataEncryptor.hexToByte(str), h.r, a(context))).trim();
            } catch (Exception e2) {
                Log.e(e2);
                HashMap hashMap = new HashMap();
                hashMap.put(Config.DEVICE_PART, Build.MODEL);
                hashMap.put("device_ver", VERSION.RELEASE);
                hashMap.put("error_msg", android.util.Log.getStackTraceString(e2));
                t.a("aes_decrypt_error", (Map<String, String>) hashMap);
            }
        }
        return null;
    }

    public static String b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return SapiDataEncryptor.byteToHex(new AES("AES", h.p).encrypt(str, h.r, a(context)));
            } catch (Exception e2) {
                Log.e(e2);
                HashMap hashMap = new HashMap();
                hashMap.put(Config.DEVICE_PART, Build.MODEL);
                hashMap.put("device_ver", VERSION.RELEASE);
                hashMap.put("error_msg", android.util.Log.getStackTraceString(e2));
                t.a("aes_encrypt_error", (Map<String, String>) hashMap);
            }
        }
        return null;
    }

    public static String a(Context context) {
        Object obj;
        Object obj2;
        String str;
        String str2 = f2956a;
        if (str2 != null) {
            return str2;
        }
        String str3 = Build.MODEL;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            StringBuilder sb = new StringBuilder();
            sb.append(statFs.getBlockSize());
            String str4 = "";
            sb.append(str4);
            obj2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(statFs.getBlockCount());
            sb2.append(str4);
            obj = sb2.toString();
        } else {
            obj2 = null;
            obj = null;
        }
        if (!TextUtils.isEmpty(null)) {
            str = String.format("%1$s-%2$s-%3$s-%4$s", new Object[]{str3, null, obj2, obj});
        } else {
            str = String.format("%1$s-%2$s-%3$s", new Object[]{str3, obj2, obj});
        }
        String substring = str.substring(0, 16);
        String str5 = "----------------";
        if (TextUtils.isEmpty(substring)) {
            substring = str5;
        }
        if (substring.length() < 16) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(substring);
            sb3.append(str5);
            substring = sb3.toString().substring(0, 16);
        }
        f2956a = substring;
        return substring;
    }

    public static SapiAccount b(Context context, SapiAccount sapiAccount) {
        if (context == null || sapiAccount == null) {
            return null;
        }
        SapiAccount sapiAccount2 = new SapiAccount();
        sapiAccount2.displayname = b(context, sapiAccount.displayname);
        sapiAccount2.uid = b(context, sapiAccount.uid);
        sapiAccount2.username = b(context, sapiAccount.username);
        sapiAccount2.app = b(context, sapiAccount.app);
        sapiAccount2.bduss = b(context, sapiAccount.bduss);
        k.a().c(sapiAccount2, b(context, k.a().b(sapiAccount)));
        k.a().d(sapiAccount2, b(context, k.a().c(sapiAccount)));
        k.a().b(sapiAccount2, b(context, k.a().a(sapiAccount)));
        sapiAccount2.email = b(context, sapiAccount.email);
        sapiAccount2.phone = b(context, sapiAccount.phone);
        return sapiAccount2;
    }

    public static SapiAccount a(Context context, SapiAccount sapiAccount) {
        if (context == null || sapiAccount == null) {
            return null;
        }
        SapiAccount sapiAccount2 = new SapiAccount();
        sapiAccount2.displayname = a(context, sapiAccount.displayname);
        sapiAccount2.uid = a(context, sapiAccount.uid);
        sapiAccount2.username = a(context, sapiAccount.username);
        sapiAccount2.app = a(context, sapiAccount.app);
        sapiAccount2.bduss = a(context, sapiAccount.bduss);
        k.a().c(sapiAccount2, a(context, k.a().b(sapiAccount)));
        k.a().d(sapiAccount2, a(context, k.a().c(sapiAccount)));
        k.a().b(sapiAccount2, a(context, k.a().a(sapiAccount)));
        sapiAccount2.email = a(context, sapiAccount.email);
        sapiAccount2.phone = a(context, sapiAccount.phone);
        return sapiAccount2;
    }
}
