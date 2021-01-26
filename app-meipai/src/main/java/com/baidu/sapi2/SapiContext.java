package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.X.c;
import com.baidu.sapi2.X.d;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import e.c.b.e.Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SapiContext implements NoProguard {
    public static final int A = 5;
    public static String B = null;
    public static SapiContext C = null;
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String CHINA_UNICOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String KEY_CONFIG_FILE_ETAG = "config_file_etag";
    public static final String KEY_CONTACTS_UID_VERSION = "contacts_uid_version";
    public static final String KEY_LAST_CHECK_PUSH_TIME = "push_last_check_time";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_UID = "last_login_uid";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_LOGIN_PAGE_IS_CACHED = "login_page_is_cached";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_OPENID_UID_LIST = "openid_uid_list";
    public static final String KEY_OPEN_BDUSS_INFO = "open_bduss_info";
    public static final String KEY_PACKAGE_DIR_EXECUTE_PER = "package_dir_execute_per";
    public static final String KEY_PRE_LOGIN_TYPE = "pre_login_type";
    public static final String KEY_PUSH_INTERNAL_TIME = "push_internal_time";
    public static final String KEY_PUSH_SUC_TIME = "push_suc_time";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SHARE_INTERNAL_GRAY = "share_internal";
    public static int MAX_SHARE_ACCOUNTS = 5;

    /* renamed from: a reason: collision with root package name */
    public static final String f2229a = "app_version_code";

    /* renamed from: b reason: collision with root package name */
    public static final String f2230b = "current_account";

    /* renamed from: c reason: collision with root package name */
    public static final String f2231c = "share_accounts";

    /* renamed from: d reason: collision with root package name */
    public static final String f2232d = "login_accounts";

    /* renamed from: e reason: collision with root package name */
    public static final String f2233e = "first_install";

    /* renamed from: f reason: collision with root package name */
    public static final String f2234f = "login_status_changed";

    /* renamed from: g reason: collision with root package name */
    public static final String f2235g = "sapi_options";

    /* renamed from: h reason: collision with root package name */
    public static final String f2236h = "pkg_signs";

    /* renamed from: i reason: collision with root package name */
    public static final String f2237i = "hosts_hijacked";

    /* renamed from: j reason: collision with root package name */
    public static final String f2238j = "device_info_read_times";
    public static final String k = "root_status";
    public static final String l = "en_current_account";
    public static final String m = "en_share_accounts";
    public static final String n = "en_login_accounts";
    public static final String o = "account_type";
    public static final String p = "iqiyi_token";
    public static final String q = "face_livingunames";
    public static final String r = "v2_face_login_check_result";
    public static final String s = "share_storage";
    public static final String t = "share_delete_list";
    public static final String u = "face_login_delete_list";
    public static final String v = "bio_sdk_enable";
    public static final String w = "touchid_accounts";
    public static final String x = "touchid_login_record";
    public static final String y = "one_key_login_js_code";
    public static final String z = "one_key_login_js_md5";
    public SharedPreferences D;
    public Context E;

    public SapiContext(Context context) {
        this.E = context;
        this.D = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(n, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(m, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void c() {
        put(f2234f, true);
    }

    public static SapiContext getInstance() {
        synchronized (SapiContext.class) {
            if (C == null) {
                C = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            }
        }
        return C;
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i2;
        int i3;
        if (sapiAccount != null) {
            List loginAccounts = getLoginAccounts();
            Collections.reverse(loginAccounts);
            if (loginAccounts.contains(sapiAccount)) {
                int indexOf = loginAccounts.indexOf(sapiAccount);
                int size = loginAccounts.size();
                while (true) {
                    i2 = size - 1;
                    if (indexOf >= i2) {
                        break;
                    }
                    int i4 = indexOf + 1;
                    loginAccounts.set(indexOf, loginAccounts.get(i4));
                    indexOf = i4;
                }
                loginAccounts.set(i2, sapiAccount);
            } else if (loginAccounts.size() < 5) {
                loginAccounts.add(sapiAccount);
            } else {
                int size2 = loginAccounts.size();
                int i5 = 0;
                while (true) {
                    i3 = size2 - 1;
                    if (i5 >= i3) {
                        break;
                    }
                    int i6 = i5 + 1;
                    loginAccounts.set(i5, loginAccounts.get(i6));
                    i5 = i6;
                }
                loginAccounts.set(i3, sapiAccount);
            }
            a(loginAccounts);
        }
    }

    public void addShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List shareAccounts = getShareAccounts();
            if (!shareAccounts.contains(sapiAccount)) {
                shareAccounts.add(sapiAccount);
            } else {
                shareAccounts.remove(shareAccounts.indexOf(sapiAccount));
                shareAccounts.add(sapiAccount);
            }
            b(a(shareAccounts, MAX_SHARE_ACCOUNTS));
        }
    }

    public void addTouchidAccounts(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List touchidAccounts = getTouchidAccounts();
            Iterator it = touchidAccounts.iterator();
            while (it.hasNext()) {
                if (sapiAccount.equals((SapiAccount) it.next())) {
                    it.remove();
                }
            }
            touchidAccounts.add(sapiAccount);
            put(w, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
        }
    }

    public void addTouchidLoginRecord(String str) {
        String str2 = x;
        String string = getString(str2);
        if (TextUtils.isEmpty(string)) {
            put(str2, str);
        } else if (!string.contains(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(",");
            sb.append(str);
            put(str2, sb.toString());
        }
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public SapiAccount getAccountFromBduss(String str) {
        if (str == null) {
            return null;
        }
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null && str.equals(currentAccount.bduss)) {
            return currentAccount;
        }
        for (SapiAccount sapiAccount : getLoginAccounts()) {
            if (str.equals(sapiAccount.bduss)) {
                return sapiAccount;
            }
        }
        for (SapiAccount sapiAccount2 : getShareAccounts()) {
            if (str.equals(sapiAccount2.bduss)) {
                return sapiAccount2;
            }
        }
        return null;
    }

    public int getAppVersionCode() {
        return getInt(f2229a, 0);
    }

    public boolean getAsyncCookie() {
        return getSapiOptions().i();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().a();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().b();
    }

    public Map<String, String> getAuthorizedPackages() {
        return b().a();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().d();
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.D.getBoolean(str, z2);
    }

    public String getContactsVersionByUid() {
        String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), a());
        SapiAccount currentAccount = getCurrentAccount();
        String str = currentAccount != null ? currentAccount.uid : "";
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(decryptAccountInfo)) {
            try {
                jSONObject = new JSONObject(decryptAccountInfo);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return jSONObject.optString(str);
    }

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().f();
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        if (!TextUtils.isEmpty(getString(l))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(l), a());
        } else if (!TextUtils.isEmpty(getString(f2230b))) {
            str = getString(f2230b);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(l, encryptAccountInfo);
                put(f2230b, "");
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), a());
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().g();
    }

    public String[] getDeleteFaceLoginList() {
        String string = getString(u);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public String[] getDeleteShareLoginList() {
        String string = getString(t);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public String getDeviceInfo() {
        List n2 = getSapiOptions().n();
        if (n2.size() != 1 || !((String) n2.get(0)).equals("di")) {
            return SapiDeviceInfo.getDiCookieInfo(n2);
        }
        return SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
    }

    public long getDeviceInfoReadTimes() {
        String str = f2238j;
        long j2 = getLong(str, 0) + 1;
        put(str, j2);
        return j2;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().O;
    }

    public int getInt(String str, int i2) {
        return this.D.getInt(str, i2);
    }

    public String getIqiyiAccesstoken() {
        String str = p;
        if (TextUtils.isEmpty(getString(str))) {
            return "";
        }
        return SapiDataEncryptor.decryptAccountInfo(getString(str), a());
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().aa;
    }

    public long getLastPushCheckTime() {
        return getLong(KEY_LAST_CHECK_PUSH_TIME, 0);
    }

    public List<SapiAccount> getLoginAccounts() {
        String str;
        String str2 = n;
        if (!TextUtils.isEmpty(getString(str2))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(str2), a());
        } else {
            String str3 = f2232d;
            if (!TextUtils.isEmpty(getString(str3))) {
                String string = getString(str3);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(string, a());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(str2, encryptAccountInfo);
                    put(str3, "");
                }
                str = string;
            } else {
                str = null;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            List<SapiAccount> fromJSONArray = SapiAccount.fromJSONArray(new JSONArray(str));
            Collections.reverse(fromJSONArray);
            return fromJSONArray;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public int getLoginStatExtraLimitLen() {
        return getSapiOptions().W;
    }

    public long getLong(String str, long j2) {
        return this.D.getLong(str, j2);
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public String getOneKeyLoginJsCode() {
        return getString(y);
    }

    public String getOnekeyLoginJsMd5() {
        return getString(z);
    }

    public List<String> getOpenBdussDomains() {
        return getSapiOptions().p();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().r();
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public List<String> getPhoneRisksList() {
        return getSapiOptions().P;
    }

    public long getPushInternalTime() {
        return getLong(KEY_PUSH_INTERNAL_TIME, 1);
    }

    public long getPushSucTime() {
        return getLong(KEY_PUSH_SUC_TIME, 0);
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().Z;
    }

    public String getRootStatus() {
        return getString(k);
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return b().e();
    }

    public X getSapiOptions() {
        String string = getString(f2235g);
        if (!TextUtils.isEmpty(string)) {
            try {
                return X.a(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return new X();
    }

    public List<SapiAccount> getShareAccounts() {
        String str;
        String str2 = m;
        if (!TextUtils.isEmpty(getString(str2))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(str2), a());
        } else {
            String str3 = f2231c;
            if (!TextUtils.isEmpty(getString(str3))) {
                String string = getString(str3);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(string, a());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(str2, encryptAccountInfo);
                    put(str3, "");
                }
                str = string;
            } else {
                str = null;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            return a(SapiAccount.fromJSONArray(new JSONArray(str)), MAX_SHARE_ACCOUNTS);
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public boolean getShareCommonStorageEnabel() {
        return getSapiOptions().V;
    }

    public int getShareInternalGray() {
        return getSapiOptions().Y;
    }

    public JSONArray getShareStorage() {
        String str = s;
        if (!TextUtils.isEmpty(getString(str))) {
            try {
                return new JSONArray(SapiDataEncryptor.decryptAccountInfo(getString(str), a()));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getString(String str) {
        return this.D.getString(str, "");
    }

    public List<SapiAccount> getTouchidAccounts() {
        String str = w;
        String decryptAccountInfo = !TextUtils.isEmpty(getString(str)) ? SapiDataEncryptor.decryptAccountInfo(getString(str), a()) : null;
        if (TextUtils.isEmpty(decryptAccountInfo)) {
            return new ArrayList();
        }
        try {
            return SapiAccount.fromJSONArray(new JSONArray(decryptAccountInfo));
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public List<String> getTouchidLoginRecord() {
        String string = getString(x);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList(0);
        }
        return Arrays.asList(string.split(","));
    }

    public String getV2FaceLivingUnames() {
        return getString(q);
    }

    public JSONObject getV2FaceLoginCheckResults() {
        String str = "list";
        String decryptStr = getDecryptStr(r);
        if (TextUtils.isEmpty(decryptStr)) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject = new JSONObject(decryptStr);
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            String[] deleteFaceLoginList = getDeleteFaceLoginList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                for (String equals : deleteFaceLoginList) {
                    if (equals.equals(optJSONArray.getJSONObject(i2).optString("livinguname"))) {
                        optJSONArray.remove(i2);
                    }
                }
            }
            jSONObject.put(str, optJSONArray);
            return jSONObject;
        } catch (Exception e2) {
            Log.e(e2);
            return new JSONObject();
        }
    }

    public Map<String, String> getVehicleSystemPackages() {
        return b().f();
    }

    public boolean isFirstLaunch() {
        String str = f2233e;
        if (!getBoolean(str, true)) {
            return false;
        }
        put(str, false);
        return true;
    }

    public boolean isHostsHijacked() {
        return getBoolean(f2237i, false);
    }

    public boolean isLoginStatusChanged() {
        return getBoolean(f2234f, false);
    }

    public boolean isMeetOneKeyLoginGray(int i2) {
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? "unkown" : c.f2493d : c.f2492c : c.f2491b;
        return getSapiOptions().ba.a(str).f2502c;
    }

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
        int i2;
        String str;
        String[] deleteFaceLoginList = getDeleteFaceLoginList();
        StringBuilder sb = new StringBuilder();
        if (jSONArray.length() + deleteFaceLoginList.length > 10) {
            i2 = (jSONArray.length() + deleteFaceLoginList.length) - 10;
        } else {
            i2 = 0;
        }
        while (true) {
            str = ",";
            if (i2 >= deleteFaceLoginList.length) {
                break;
            }
            sb.append(deleteFaceLoginList[i2]);
            sb.append(str);
            i2++;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(URLDecoder.decode(jSONArray.optString(i3)));
            sb.append(str);
        }
        put(u, sb.toString().substring(0, sb.toString().length() - 1));
    }

    public void markAsDeleteShareLogin(String str) {
        String[] deleteShareLoginList = getDeleteShareLoginList();
        StringBuilder sb = new StringBuilder();
        for (int length = deleteShareLoginList.length + 1 > 10 ? (deleteShareLoginList.length + 1) - 10 : 0; length < deleteShareLoginList.length; length++) {
            sb.append(deleteShareLoginList[length]);
            sb.append(",");
        }
        sb.append(str);
        put(t, sb.toString());
    }

    public void put(String str, String str2) {
        this.D.edit().putString(str, str2).apply();
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, a()));
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
                setCurrentAccount(null);
                ServiceManager.getInstance().getIsAccountManager().invalidate(sapiAccount);
            }
            List loginAccounts = getLoginAccounts();
            if (loginAccounts.contains(sapiAccount)) {
                loginAccounts.remove(sapiAccount);
                a(loginAccounts);
            }
        }
    }

    public void removeShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List shareAccounts = getShareAccounts();
            if (shareAccounts.contains(sapiAccount)) {
                shareAccounts.remove(sapiAccount);
                b(shareAccounts);
            }
        }
    }

    public void removeTouchidAccountByPortrait(String str) {
        if (!TextUtils.isEmpty(str)) {
            List touchidAccounts = getTouchidAccounts();
            Iterator it = touchidAccounts.iterator();
            while (it.hasNext()) {
                if (str.equals(((SapiAccount) it.next()).email)) {
                    it.remove();
                }
            }
            put(w, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
        }
    }

    public void resetSilentShareStatus() {
        put(f2234f, false);
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public void setAppVersionCode(int i2) {
        put(f2229a, i2);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        String str = l;
        if (sapiAccount == null) {
            put(str, "");
            SapiUtils.webLogout(this.E);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(str, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
            SapiUtils.webLogin(this.E, sapiAccount.bduss, sapiAccount.ptoken);
            setPushInternalTime(1);
            setPushSucTime(0);
            setLastPushCheckTime(0);
            if (!isLoginStatusChanged()) {
                c();
            }
        }
    }

    public void setHostsHijacked(boolean z2) {
        put(f2237i, z2);
    }

    public void setIqiyiAccesstoken(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = p;
        if (isEmpty) {
            put(str2, "");
        } else {
            put(str2, SapiDataEncryptor.encryptAccountInfo(str, a()));
        }
    }

    public void setLastPushCheckTime(long j2) {
        put(KEY_LAST_CHECK_PUSH_TIME, j2);
    }

    public void setModifiedDirExecPer(boolean z2) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z2);
    }

    public void setOneKeyLoginJSCode(String str) {
        put(y, str);
    }

    public void setOnekeyLoginJsMd5(String str) {
        put(z, str);
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public void setPkgSigns(d dVar) {
        if (dVar != null) {
            put(f2236h, dVar.g());
        }
    }

    public void setPushInternalTime(long j2) {
        put(KEY_PUSH_INTERNAL_TIME, j2);
    }

    public void setPushSucTime(long j2) {
        put(KEY_PUSH_SUC_TIME, j2);
    }

    public void setRootStatus(String str) {
        put(k, str);
    }

    public void setSapiOptions(X x2) {
        if (x2 != null) {
            put(f2235g, x2.u());
        }
    }

    public void setShareStorage(JSONArray jSONArray) {
        String str = s;
        if (jSONArray == null) {
            put(str, "");
        } else {
            put(str, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    public void setV2FaceLivingunames(String str) {
        put(q, str);
    }

    public void setV2FaceLoginCheckResults(String str) {
        putEncryptStr(r, str);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().U;
    }

    public void updateContactsVersionWithUid(String str) {
        String str2 = KEY_CONTACTS_UID_VERSION;
        String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(str2), a());
        String str3 = getCurrentAccount().uid;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                jSONObject = new JSONObject(decryptAccountInfo);
            }
            jSONObject.put(str3, str);
        } catch (JSONException e2) {
            Log.e(e2);
        }
        put(str2, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
    }

    public void put(String str, int i2) {
        this.D.edit().putInt(str, i2).apply();
    }

    public void put(String str, long j2) {
        this.D.edit().putLong(str, j2).apply();
    }

    public void put(String str, boolean z2) {
        this.D.edit().putBoolean(str, z2).apply();
    }

    private String a() {
        if (TextUtils.isEmpty(B)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.E.getPackageName());
                sb.append(SapiUtils.getPackageSign(this.E, this.E.getPackageName()));
                B = Utils.a(sb.toString().getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return B;
    }

    private d b() {
        String string = getString(f2236h);
        if (!TextUtils.isEmpty(string)) {
            try {
                return d.a(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return new d();
    }

    public <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }
}
