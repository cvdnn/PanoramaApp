package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.x;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.b.e.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceLoginService {

    /* renamed from: a reason: collision with root package name */
    public static final String f2920a = "FaceLoginService";

    /* renamed from: b reason: collision with root package name */
    public static final String f2921b = "face_login_model_v2";

    /* renamed from: c reason: collision with root package name */
    public static final String f2922c = "livingunames";

    /* renamed from: d reason: collision with root package name */
    public static final int f2923d = 10;

    /* renamed from: e reason: collision with root package name */
    public Context f2924e = SapiAccountManager.getInstance().getConfignation().context;

    private String a(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f2922c, SapiUtils.map2JsonArray(map, "livinguname", LogBuilder.KEY_TIME));
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private List<a> b() {
        return str2ShareModelV2List(SapiContext.getInstance().getV2FaceLivingUnames());
    }

    public boolean isSupFaceLogin() {
        JSONObject v2FaceLoginCheckResults = SapiContext.getInstance().getV2FaceLoginCheckResults();
        if (v2FaceLoginCheckResults != null) {
            String str = "list";
            if (v2FaceLoginCheckResults.has(str) && v2FaceLoginCheckResults.optJSONArray(str).length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin) {
                return true;
            }
        }
        return false;
    }

    public List<a> str2ShareModelV2List(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(f2922c);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong(LogBuilder.KEY_TIME, 0);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new a(optString, optLong));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void syncFaceLoginUID(Context context, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new a(str, System.currentTimeMillis()));
        }
        syncFaceLoginUidList(context, arrayList);
    }

    public void syncFaceLoginUidList(Context context, List<a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.addAll(b());
        arrayList.addAll(a());
        Map a2 = a((List<a>) arrayList);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : a2.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("livinguname", str);
                jSONObject2.put(LogBuilder.KEY_TIME, a2.get(str));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException e2) {
            Log.i(e2);
        }
        String a3 = a(a2);
        a(a3);
        SapiContext.getInstance().setV2FaceLivingunames(a3);
        SapiContext.getInstance().setV2FaceLoginCheckResults(jSONObject.toString());
    }

    private void a(String str) {
        if (!SapiContext.getInstance().getShareCommonStorageEnabel() || TextUtils.isEmpty(str) || !SapiContext.getInstance().shareLivingunameEnable()) {
            Log.i(f2920a, "setV2ShareFaceUids false");
            return;
        }
        ShareStorage shareStorage = new ShareStorage();
        String str2 = f2921b;
        shareStorage.setSp(str2, str);
        shareStorage.setSd(Utils.a(str2.getBytes(), false), str);
    }

    private Map<String, Long> a(List<a> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            for (a aVar : list) {
                if (!linkedHashMap.containsKey(aVar.f2925a)) {
                    linkedHashMap.put(aVar.f2925a, Long.valueOf(aVar.f2926b));
                }
            }
            if (linkedHashMap.size() > 10) {
                Iterator it = linkedHashMap.entrySet().iterator();
                int size = linkedHashMap.size() - 10;
                int i2 = 0;
                while (it.hasNext() && i2 < size) {
                    it.next();
                    it.remove();
                    i2++;
                }
            }
        }
        return linkedHashMap;
    }

    private List<a> a() {
        ArrayList arrayList = new ArrayList();
        if (!SapiContext.getInstance().shareLivingunameEnable()) {
            return arrayList;
        }
        List c2 = x.c(this.f2924e);
        if (c2.isEmpty()) {
            return arrayList;
        }
        ShareStorage shareStorage = new ShareStorage();
        Iterator it = c2.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String str = f2921b;
            if (hasNext) {
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(((Intent) it.next()).getComponent().getPackageName(), str)));
            } else {
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(Utils.a(str.getBytes(), false))));
                return arrayList;
            }
        }
    }
}
