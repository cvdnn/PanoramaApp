package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidubce.BceConfig;
import e.a.a.a.a;
import e.c.b.e.Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalConfigOptions {
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ZIP_GRAY_THRESHOLD = 100;
    public static final String EXTERNAL_CACHE_DIR = ".BD_SAPI_CACHE";
    public static final String KEY_ILLUM_GRAY = "illum_gray";
    public static final String LIVENESS_RECOG_NAME = "pass_face_sdk";
    public static LocalConfigOptions instance;
    public Context context;
    public String encryptKey;
    public SharedPreferences storage;

    public LocalConfigOptions(Context context2) {
        this.context = context2.getApplicationContext();
        this.storage = context2.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String getAccountEncryptKey(Context context2) {
        if (TextUtils.isEmpty(this.encryptKey)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context2.getPackageName());
                sb.append(PassBiometricUtil.getPackageSign(context2, context2.getPackageName()));
                this.encryptKey = Utils.a(sb.toString().getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return this.encryptKey;
    }

    public static String getExternalZipPath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = BceConfig.BOS_DELIMITER;
        sb.append(str2);
        sb.append(".BD_SAPI_CACHE");
        sb.append(str2);
        sb.append(LIVENESS_RECOG_NAME);
        a.a(sb, str2, "3.0.0", "-", str);
        sb.append(".zip");
        return sb.toString();
    }

    public static LocalConfigOptions getInstance(Context context2) {
        if (instance == null) {
            instance = new LocalConfigOptions(context2);
        }
        return instance;
    }

    public static String getInternalRootPath(Context context2) {
        return context2.getDir(LIVENESS_RECOG_NAME, 0).getAbsolutePath();
    }

    public static String getInternalZipPath(Context context2, String str) {
        StringBuilder a2 = a.a(getInternalRootPath(context2));
        a2.append(File.separator);
        a2.append(LIVENESS_RECOG_NAME);
        a.a(a2, File.separator, "3.0.0", "-", str);
        a2.append(".zip");
        return new File(a2.toString()).getAbsolutePath();
    }

    public static String getLoadSoPath(Context context2) {
        StringBuilder a2 = a.a(getInternalRootPath(context2));
        a2.append(File.separator);
        return new File(a2.toString()).getAbsolutePath();
    }

    private String getString(String str) {
        return this.storage.getString(str, "");
    }

    private void setString(String str, String str2) {
        this.storage.edit().putString(str, str2).apply();
    }

    public SdkConfigOptions getBioOptions() {
        String string = getString(LIVENESS_RECOG_NAME);
        if (!TextUtils.isEmpty(string)) {
            String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(string, getAccountEncryptKey(this.context));
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    return SdkConfigOptions.fromLocalJson(new JSONObject(decryptAccountInfo));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        }
        return new SdkConfigOptions();
    }

    public int getIllumVlaueGray() {
        return getInt(KEY_ILLUM_GRAY, -1);
    }

    public int getInt(String str, int i2) {
        return this.storage.getInt(str, i2);
    }

    public void put(String str, int i2) {
        this.storage.edit().putInt(str, i2).apply();
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions != null) {
            setString(LIVENESS_RECOG_NAME, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), getAccountEncryptKey(this.context)));
        }
    }

    public void setIllumValueGray(int i2) {
        put(KEY_ILLUM_GRAY, i2);
    }
}
