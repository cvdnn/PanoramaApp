package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import com.tencent.open.SocialConstants;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: StatService */
public final class t {

    /* renamed from: a reason: collision with root package name */
    public static final String f3124a = "qrlogin_enter";

    /* renamed from: b reason: collision with root package name */
    public static final Map<String, String> f3125b;

    /* renamed from: c reason: collision with root package name */
    public static List<String> f3126c;

    static {
        HashMap hashMap = new HashMap();
        f3125b = hashMap;
        hashMap.put("pid", "111");
        f3125b.put("type", "1023");
        f3125b.put(Config.DEVICE_PART, Build.MODEL);
        ArrayList arrayList = new ArrayList();
        f3126c = arrayList;
        arrayList.add("share_read");
        f3126c.add("share_silent_account");
        f3126c.add("share_silent_account_success");
        f3126c.add("load_login");
        f3126c.add("share_account_open");
        f3126c.add("pass_sdk_init");
    }

    public static void b(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(j.a(j.k), httpHashMapWrap, null, null, new s(true));
    }

    public static void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.putAll(f3125b);
                httpHashMapWrap.put("name", str);
                httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
                httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                if (map != null) {
                    for (Entry entry : map.entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                            httpHashMapWrap.put((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
                if (!f3126c.contains(str) || !a()) {
                    b(httpHashMapWrap);
                }
                NetworkRequestScheduler.execute(new r(httpHashMapWrap), "pass_sdk_".concat(str), 60000, false);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public static boolean a() {
        try {
            Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("name", str);
        a(linkedHashMap);
    }

    public static void a(LinkedHashMap<String, String> linkedHashMap) {
        a(linkedHashMap, null);
    }

    @TargetApi(8)
    public static void a(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder a2 = a.a("{");
        for (String str : linkedHashMap.keySet()) {
            a2.append(str);
            a2.append(Config.TRACE_TODAY_VISIT_SPLIT);
            a2.append((String) linkedHashMap.get(str));
        }
        a2.append("}");
        String str2 = "auto_statistic";
        map.put(str2, Base64.encodeToString(a2.toString().getBytes(), 0));
        map.put(SocialConstants.PARAM_SOURCE, SapiAccountService.f2213b);
        map.put("data_source", "client");
        a(str2, map);
    }
}
