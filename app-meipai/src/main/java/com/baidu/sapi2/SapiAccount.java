package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.sapi2.share.k;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiAccount implements Parcelable, Cloneable {
    public static final Creator<SapiAccount> CREATOR = new C0177p();
    public static final String SAPI_ACCOUNT_APP = "app";
    public static final String SAPI_ACCOUNT_EXTRA = "extra";
    public static final String SAPI_ACCOUNT_PORTRAIT = "portrait";

    /* renamed from: a reason: collision with root package name */
    public static final String f2181a = "uid";

    /* renamed from: b reason: collision with root package name */
    public static final String f2182b = "displayname";

    /* renamed from: c reason: collision with root package name */
    public static final String f2183c = "username";

    /* renamed from: d reason: collision with root package name */
    public static final String f2184d = "email";

    /* renamed from: e reason: collision with root package name */
    public static final String f2185e = "phone";

    /* renamed from: f reason: collision with root package name */
    public static final String f2186f = "bduss";

    /* renamed from: g reason: collision with root package name */
    public static final String f2187g = "ptoken";

    /* renamed from: h reason: collision with root package name */
    public static final String f2188h = "stoken";
    public String app;
    public String bduss;
    public String displayname;
    @Deprecated
    public String email;
    public String extra;
    @Deprecated

    /* renamed from: i reason: collision with root package name */
    public String f2189i;
    @Deprecated
    public String phone;
    public String portrait;
    public String ptoken;
    @Deprecated
    public String stoken;
    public String uid;
    public String username;

    public static final class DispersionCertification implements NoProguard {
        public Map<String, String> tplStokenMap = new HashMap();

        public static DispersionCertification fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            DispersionCertification dispersionCertification = new DispersionCertification();
            dispersionCertification.tplStokenMap = getTplStokenMap(jSONObject.optJSONObject(ExtraProperty.EXTRA_TPL_STOKEN_LIST));
            return dispersionCertification;
        }

        public static Map<String, String> getTplStokenMap(JSONObject jSONObject) {
            HashMap hashMap = new HashMap();
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    hashMap.put(obj, jSONObject.optString(obj));
                }
            }
            return hashMap;
        }
    }

    public static final class ExtraProperty implements NoProguard {
        public static final String EXTRA_ACCOUNT_TYPE = "account_type";
        public static final String EXTRA_IS_GUEST_ACCOUNT = "is_guest_account";
        public static final String EXTRA_IS_SOCIAL_ACCOUNT = "is_social_account";
        public static final String EXTRA_PKG = "pkg";
        public static final String EXTRA_SOCIAL_PORTRAIT = "social_portrait";
        public static final String EXTRA_SOCIAL_TYPE = "social_type";
        public static final String EXTRA_TPL = "tpl";
        public static final String EXTRA_TPL_STOKEN_LIST = "stoken_list";

        /* renamed from: a reason: collision with root package name */
        public String f2190a;

        /* renamed from: b reason: collision with root package name */
        public String f2191b;

        /* renamed from: c reason: collision with root package name */
        public String f2192c;

        /* renamed from: d reason: collision with root package name */
        public String f2193d;
        public DispersionCertification dispersionCertification = new DispersionCertification();

        /* renamed from: e reason: collision with root package name */
        public String f2194e;

        /* renamed from: f reason: collision with root package name */
        public String f2195f;

        /* renamed from: g reason: collision with root package name */
        public String f2196g;

        public static ExtraProperty fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ExtraProperty extraProperty = new ExtraProperty();
            extraProperty.f2190a = jSONObject.optString("account_type");
            extraProperty.f2191b = jSONObject.optString(EXTRA_IS_SOCIAL_ACCOUNT);
            extraProperty.f2192c = jSONObject.optString(EXTRA_SOCIAL_TYPE);
            extraProperty.f2193d = jSONObject.optString(EXTRA_SOCIAL_PORTRAIT);
            extraProperty.dispersionCertification = DispersionCertification.fromJSONObject(jSONObject);
            extraProperty.f2194e = jSONObject.optString(EXTRA_IS_GUEST_ACCOUNT);
            extraProperty.f2195f = jSONObject.optString("tpl");
            extraProperty.f2196g = jSONObject.optString("pkg");
            return extraProperty;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account_type", this.f2190a);
                jSONObject.put(EXTRA_IS_SOCIAL_ACCOUNT, this.f2191b);
                jSONObject.put(EXTRA_SOCIAL_TYPE, this.f2192c);
                jSONObject.put(EXTRA_SOCIAL_PORTRAIT, this.f2193d);
                jSONObject.put(EXTRA_TPL_STOKEN_LIST, new JSONObject(this.dispersionCertification.tplStokenMap));
                jSONObject.put(EXTRA_IS_GUEST_ACCOUNT, this.f2194e);
                jSONObject.put("tpl", this.f2195f);
                jSONObject.put("pkg", this.f2196g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    static {
        try {
            k.a((k) new SapiAccountAccessorImpl());
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public SapiAccount() {
    }

    private boolean b() {
        Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
        for (String matches : SapiContext.getInstance().getSapiOptions().c()) {
            if (context.getPackageName().matches(matches)) {
                return true;
            }
        }
        return false;
    }

    public static List<SapiAccount> fromJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                SapiAccount fromJSONObject = fromJSONObject(jSONArray.getJSONObject(i2));
                if (fromJSONObject != null) {
                    arrayList.add(fromJSONObject);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return arrayList;
    }

    public static SapiAccount fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("username");
        sapiAccount.email = jSONObject.optString(f2184d);
        sapiAccount.phone = jSONObject.optString(f2185e);
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.app = jSONObject.optString("app");
        sapiAccount.ptoken = jSONObject.optString(f2187g);
        sapiAccount.stoken = jSONObject.optString(f2188h);
        sapiAccount.extra = jSONObject.optString(SAPI_ACCOUNT_EXTRA);
        sapiAccount.portrait = jSONObject.optString(SAPI_ACCOUNT_PORTRAIT);
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return null;
        }
        return sapiAccount;
    }

    public static JSONArray toJSONArray(List<SapiAccount> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (SapiAccount jSONObject : list) {
            JSONObject jSONObject2 = jSONObject.toJSONObject();
            if (jSONObject2 != null) {
                jSONArray.put(jSONObject2);
            }
        }
        return jSONArray;
    }

    public boolean a(String str, boolean z) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optBoolean(str, z);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return z;
    }

    public void addDispersionCertification(Map<String, String> map) {
        putExtra(ExtraProperty.EXTRA_TPL_STOKEN_LIST, new JSONObject(map));
    }

    public void addIsGuestAccount(String str) {
        putExtra(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, str);
    }

    public void addSocialInfo(SocialType socialType, String str) {
        putExtra(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, Boolean.valueOf(true));
        putExtra(ExtraProperty.EXTRA_SOCIAL_TYPE, Integer.valueOf(socialType.getType()));
        putExtra(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, str);
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = this.uid;
        sapiAccount.displayname = this.displayname;
        sapiAccount.username = this.username;
        sapiAccount.email = this.email;
        sapiAccount.phone = this.phone;
        sapiAccount.bduss = this.bduss;
        sapiAccount.ptoken = this.ptoken;
        sapiAccount.stoken = this.stoken;
        sapiAccount.app = this.app;
        sapiAccount.extra = this.extra;
        sapiAccount.portrait = this.portrait;
        return sapiAccount;
    }

    public void deleteStokens() {
        try {
            if (!TextUtils.isEmpty(this.extra)) {
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                fromJSONObject.dispersionCertification.tplStokenMap.clear();
                this.extra = fromJSONObject.toJSONObject().toString();
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || SapiAccount.class != obj.getClass()) {
            return false;
        }
        SapiAccount sapiAccount = (SapiAccount) obj;
        String str = this.uid;
        String str2 = sapiAccount.uid;
        if (str == null ? str2 != null : !str.equals(str2)) {
            z = false;
        }
        return z;
    }

    public AccountType getAccountType() {
        return AccountType.getAccountType(a("account_type", AccountType.UNKNOWN.getType()));
    }

    public String getCompletePortrait() {
        return a.a(a.a("https://himg.bdimg.com/sys/portrait/item/"), this.portrait, ".jpg");
    }

    public String getPtoken() {
        return b() ? this.ptoken : "";
    }

    public String getShareAccountPkg() {
        return a("pkg", (String) null);
    }

    public String getShareAccountTpl() {
        return a("tpl", "");
    }

    public String getSocialPortrait() {
        return a(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, (String) null);
    }

    public SocialType getSocialType() {
        return SocialType.getSocialType(a(ExtraProperty.EXTRA_SOCIAL_TYPE, SocialType.UNKNOWN.getType()));
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isGuestAccount() {
        return "1".equals(a(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, "0"));
    }

    public boolean isSocialAccount() {
        return a(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, false);
    }

    public void putExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (TextUtils.isEmpty(this.extra)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, obj);
                    this.extra = jSONObject.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(this.extra);
                    jSONObject2.put(str, obj);
                    this.extra = jSONObject2.toString();
                } catch (JSONException e3) {
                    Log.e(e3);
                }
            }
        }
    }

    public void setAccountPkg(String str) {
        putExtra("pkg", str);
    }

    public void setPtoken(String str) {
        if (b()) {
            this.ptoken = str;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put("username", this.username);
            jSONObject.put(f2184d, this.email);
            jSONObject.put(f2185e, this.phone);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("app", this.app);
            jSONObject.put(f2187g, this.ptoken);
            jSONObject.put(f2188h, this.stoken);
            jSONObject.put(SAPI_ACCOUNT_EXTRA, this.extra);
            jSONObject.put(SAPI_ACCOUNT_PORTRAIT, this.portrait);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(e2);
            return null;
        }
    }

    public String toString() {
        StringBuilder a2 = a.a("SapiAccount{uid='");
        a.a(a2, this.uid, '\'', ", displayname='");
        a.a(a2, this.displayname, '\'', ", username='");
        a.a(a2, this.username, '\'', ", email='");
        a.a(a2, this.email, '\'', ", phone='");
        a.a(a2, this.phone, '\'', ", bduss='");
        a.a(a2, this.bduss, '\'', ", app='");
        a.a(a2, this.app, '\'', ", ptoken='");
        a.a(a2, this.ptoken, '\'', ", stoken='");
        a.a(a2, this.stoken, '\'', ", extra='");
        a.a(a2, this.extra, '\'', ", portrait='");
        a2.append(this.portrait);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }

    public void updateSession(SapiAccount sapiAccount) {
        ExtraProperty extraProperty;
        if (SapiUtils.isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
            this.bduss = sapiAccount.bduss;
            this.ptoken = sapiAccount.ptoken;
            if (!TextUtils.isEmpty(sapiAccount.extra)) {
                try {
                    if (!TextUtils.isEmpty(this.extra)) {
                        extraProperty = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                    } else {
                        extraProperty = new ExtraProperty();
                    }
                    ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(sapiAccount.extra));
                    extraProperty.dispersionCertification.tplStokenMap = fromJSONObject.dispersionCertification.tplStokenMap;
                    extraProperty.f2193d = fromJSONObject.f2193d;
                    extraProperty.f2190a = fromJSONObject.f2190a;
                    extraProperty.f2194e = fromJSONObject.f2194e;
                    this.extra = extraProperty.toJSONObject().toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.uid);
        parcel.writeString(this.displayname);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(this.bduss);
        parcel.writeString(this.app);
        parcel.writeString(this.ptoken);
        parcel.writeString(this.stoken);
        parcel.writeString(this.f2189i);
        parcel.writeString(this.extra);
        parcel.writeString(this.portrait);
    }

    public SapiAccount(Parcel parcel) {
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.f2189i = parcel.readString();
        this.extra = parcel.readString();
        this.portrait = parcel.readString();
    }

    public String a(String str, String str2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optString(str, str2);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return str2;
    }

    public int a(String str, int i2) {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optInt(str, i2);
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return i2;
    }

    public void a() {
        if (TextUtils.isEmpty(this.bduss) || TextUtils.isEmpty(this.ptoken)) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.bduss);
            String cookiePtoken = SapiUtils.getCookiePtoken();
            String cookieBduss = SapiUtils.getCookieBduss();
            if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
                this.ptoken = accountFromBduss.ptoken;
            } else if (this.bduss.equals(cookieBduss) && !TextUtils.isEmpty(cookiePtoken)) {
                this.ptoken = cookiePtoken;
            }
        }
    }
}
