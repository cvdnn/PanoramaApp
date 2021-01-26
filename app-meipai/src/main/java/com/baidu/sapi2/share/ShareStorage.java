package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.h;
import com.baidubce.BceConfig;
import e.c.b.e.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareStorage {
    public static final String TAG = "ShareStorage";

    /* renamed from: a reason: collision with root package name */
    public static final String f2887a = "sapi_share";

    /* renamed from: b reason: collision with root package name */
    public static final String f2888b = ".BD_SAPI_CACHE/.sapi_temp/";

    /* renamed from: c reason: collision with root package name */
    public static final String f2889c = ".BD_SAPI_CACHE/";

    /* renamed from: d reason: collision with root package name */
    public static final String f2890d;

    /* renamed from: e reason: collision with root package name */
    public static final String f2891e = "w0d4o27mh3k1e461";

    /* renamed from: f reason: collision with root package name */
    public static final String f2892f = "2314906973403010";

    /* renamed from: g reason: collision with root package name */
    public static final int f2893g = 5;

    /* renamed from: h reason: collision with root package name */
    public Context f2894h = SapiAccountManager.getInstance().getConfignation().context;
    public boolean readSpFromChmodFile = false;

    public static class StorageModel {

        /* renamed from: a reason: collision with root package name */
        public String f2895a;
        public String app;

        /* renamed from: b reason: collision with root package name */
        public int f2896b;

        /* renamed from: c reason: collision with root package name */
        public int f2897c;

        /* renamed from: d reason: collision with root package name */
        public int f2898d;
        public String displayname;
        public String pkg;
        public String tpl;
        public String url;

        public /* synthetic */ StorageModel(t tVar) {
            this();
        }

        public static StorageModel a(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            storageModel.url = jSONObject.optString("url");
            storageModel.displayname = jSONObject.optString("displayname");
            storageModel.app = jSONObject.optString("app");
            storageModel.tpl = jSONObject.optString("tpl");
            storageModel.f2895a = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString("pkg");
            storageModel.f2896b = jSONObject.optInt("flag", -1);
            Domain domain = Domain.DOMAIN_ONLINE;
            storageModel.f2898d = jSONObject.optInt("env", 0);
            return storageModel;
        }

        public static JSONArray toJSONArray(List<StorageModel> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (StorageModel a2 : list) {
                JSONObject a3 = a2.a();
                if (a3 != null) {
                    jSONArray.put(a3);
                }
            }
            return jSONArray;
        }

        public StorageModel() {
        }

        public static List<StorageModel> a(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    StorageModel a2 = a(jSONArray.getJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return arrayList;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("uid", this.f2895a);
                jSONObject.put("pkg", this.pkg);
                jSONObject.put("flag", this.f2896b);
                jSONObject.put("env", this.f2898d);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        public static void a(Context context, boolean z, a aVar) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null || currentAccount.isGuestAccount()) {
                StorageModel storageModel = new StorageModel();
                storageModel.f2896b = 1;
                aVar.a(storageModel);
            } else if (z) {
                StorageModel storageModel2 = new StorageModel();
                storageModel2.displayname = currentAccount.displayname;
                storageModel2.url = SapiContext.getInstance().getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel2.app = SapiUtils.getAppName(context);
                storageModel2.pkg = context.getPackageName();
                storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel2.f2895a = UUID.randomUUID().toString();
                storageModel2.f2896b = 0;
                storageModel2.f2898d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                aVar.a(storageModel2);
            } else {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new u(aVar, context), SapiContext.getInstance().getCurrentAccount().bduss);
            }
        }
    }

    public interface a {
        void a(StorageModel storageModel);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl());
        sb.append(h.A);
        f2890d = sb.toString();
    }

    private boolean b() {
        SapiContext instance = SapiContext.getInstance();
        String str = SapiContext.KEY_SHARE_INTERNAL_GRAY;
        int i2 = instance.getInt(str, -1);
        if (i2 == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i2 = random.nextInt(100);
            SapiContext.getInstance().put(str, i2);
        }
        return i2 <= SapiContext.getInstance().getShareInternalGray();
    }

    @TargetApi(8)
    private StorageModel c(String str) {
        try {
            String sp = getSp(str, Utils.a(str.getBytes(), false));
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sp, 0), f2892f, f2891e))));
            a2.f2897c = 0;
            return a2;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSd(String str) {
        try {
            if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.f2894h)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath().toString());
            sb.append(File.separator);
            sb.append(f2888b);
            sb.append(str);
            String sb2 = sb.toString();
            if (com.baidu.sapi2.utils.a.a(sb2)) {
                return com.baidu.sapi2.utils.a.b(sb2);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public boolean setSd(String str, String str2) {
        try {
            if (!SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.f2894h)) {
                return false;
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            StringBuilder sb = new StringBuilder();
            sb.append(f2888b);
            sb.append(str);
            File file = new File(externalStorageDirectory, sb.toString());
            if (TextUtils.isEmpty(str2)) {
                com.baidu.sapi2.utils.a.a(file);
            } else {
                com.baidu.sapi2.utils.a.a(file, str2.getBytes(), false);
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @TargetApi(4)
    public boolean setSp(String str, String str2) {
        try {
            this.f2894h.getSharedPreferences(f2887a, 5).edit().putString(str, str2).apply();
            return true;
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            boolean isEmpty = TextUtils.isEmpty(str);
            String str3 = f2887a;
            if (isEmpty) {
                sharedPreferences = this.f2894h.getSharedPreferences(str3, 5);
            } else {
                sharedPreferences = this.f2894h.createPackageContext(str, 2).getSharedPreferences(str3, 5);
            }
            return sharedPreferences.getString(str2, "");
        } catch (Throwable unused) {
            String a2 = a(str, str2);
            if (!TextUtils.isEmpty(a2)) {
                this.readSpFromChmodFile = true;
            }
            return a2;
        }
    }

    public void a(boolean z) {
        StorageModel.a(this.f2894h, z, new t(this));
    }

    public StorageModel a(String str) {
        StorageModel c2 = c(str);
        return c2 == null ? b(str) : c2;
    }

    @TargetApi(4)
    private String a(String str, String str2) {
        String str3 = "getDataFromShareInternal";
        Log.e(TAG, str3);
        if (TextUtils.isEmpty(str)) {
            str = this.f2894h.getPackageName();
        }
        String str4 = this.f2894h.getApplicationInfo().dataDir;
        StringBuilder sb = new StringBuilder();
        sb.append(str4.replace(this.f2894h.getPackageName(), ""));
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(BceConfig.BOS_DELIMITER);
        sb3.append(f2889c);
        sb3.append(str2);
        String sb4 = sb3.toString();
        Log.e(TAG, str3, "fileName", sb4);
        try {
            return com.baidu.sapi2.utils.a.b(sb4);
        } catch (Throwable th) {
            Log.e(th);
            return null;
        }
    }

    @TargetApi(8)
    private StorageModel b(String str) {
        try {
            String sd = getSd(Utils.a(str.getBytes(), false));
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sd, 0), f2892f, f2891e))));
            a2.f2897c = 1;
            return a2;
        } catch (Exception unused) {
            return null;
        }
    }
}
