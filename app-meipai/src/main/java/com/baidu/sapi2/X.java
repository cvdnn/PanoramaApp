package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiOptions */
public final class X {
    public static final String A = "share_direction";
    public static final String B = "pass_httpclient_async_cookie";
    public static final String C = "reset_file_exec_per";
    public static final String D = "gray";
    public static final int E = 1000000;
    public static final String F = "登录后%s将获得百度帐号的公开信息（用户名、头像）";

    /* renamed from: a reason: collision with root package name */
    public static final String f2471a = "global_share_strategy";

    /* renamed from: b reason: collision with root package name */
    public static final String f2472b = "specific_share_strategy";

    /* renamed from: c reason: collision with root package name */
    public static final String f2473c = "default_https_enabled";

    /* renamed from: d reason: collision with root package name */
    public static final String f2474d = "authorized_domains";

    /* renamed from: e reason: collision with root package name */
    public static final String f2475e = "cuid_authorized_domains";

    /* renamed from: f reason: collision with root package name */
    public static final String f2476f = "cache";

    /* renamed from: g reason: collision with root package name */
    public static final String f2477g = "cache_gray";

    /* renamed from: h reason: collision with root package name */
    public static final String f2478h = "percent";

    /* renamed from: i reason: collision with root package name */
    public static final String f2479i = "enabled";

    /* renamed from: j reason: collision with root package name */
    public static final String f2480j = "version";
    public static final String k = "modules";
    public static final String l = "id";
    public static final String m = "download_url";
    public static final String n = "hash";
    public static final String o = "login_cookie_di_keys";
    public static final String p = "pre_fetch_tpl_list";
    public static final String q = "phone_risks_tpls";
    public static final String r = "share_inter_storage_gray";
    public static final String s = "share_livinguname_enabled";
    public static final String t = "di_except_index";
    public static final String u = "share_common_storage_enable";
    public static final String v = "join_qr_login_prompt";
    public static final String w = "extrajson_limit_len";
    public static final String x = "open_bduss_tpls";
    public static final String y = "open_bduss_domains";
    public static final String z = "can_get_bduss";
    public a G = new a();
    public LoginShareStrategy H;
    public boolean I = true;
    public Map<String, LoginShareStrategy> J = new HashMap();
    public List<String> K = new ArrayList();
    public List<String> L = new ArrayList();
    public List<String> M = new ArrayList();
    public List<String> N = new ArrayList();
    public List<Integer> O = new ArrayList();
    public List<String> P = new ArrayList();
    public Map<String, String> Q = new HashMap();
    public List<String> R = new ArrayList();
    public List<String> S = new ArrayList();
    public boolean T = true;
    public boolean U;
    public boolean V;
    public int W;
    public boolean X;
    public int Y = 100;
    public boolean Z;
    public String aa = F;
    public c ba = new c();

    /* compiled from: SapiOptions */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static final String f2481a = ".BD_SAPI_CACHE";

        /* renamed from: b reason: collision with root package name */
        public boolean f2482b = true;

        /* renamed from: c reason: collision with root package name */
        public String f2483c;

        /* renamed from: d reason: collision with root package name */
        public List<C0011a> f2484d = new ArrayList();

        /* renamed from: com.baidu.sapi2.X$a$a reason: collision with other inner class name */
        /* compiled from: SapiOptions */
        public static class C0011a {

            /* renamed from: a reason: collision with root package name */
            public String f2485a;

            /* renamed from: b reason: collision with root package name */
            public String f2486b;

            /* renamed from: c reason: collision with root package name */
            public String f2487c;

            public static String b(String str) {
                StringBuilder a2 = e.a.a.a.a.a(ShareStorage.f2889c);
                a2.append(a(str));
                return a2.toString();
            }

            public static String c(String str) {
                return a(str).replace('/', '-');
            }

            public JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f2485a);
                    jSONObject.put(X.m, this.f2486b);
                    jSONObject.put("hash", this.f2487c);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0011a.class != obj.getClass()) {
                    return false;
                }
                return this.f2485a.equals(((C0011a) obj).f2485a);
            }

            public int hashCode() {
                return this.f2485a.hashCode();
            }

            public static C0011a a(JSONObject jSONObject) {
                C0011a aVar = new C0011a();
                aVar.f2485a = jSONObject.optString("id");
                aVar.f2486b = jSONObject.optString(X.m);
                aVar.f2487c = jSONObject.optString("hash");
                return aVar;
            }

            public static String a(String str) {
                return str.replace(':', '/');
            }
        }

        public String b() {
            return this.f2483c;
        }

        public boolean c() {
            return this.f2482b;
        }

        public JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(X.f2479i, this.f2482b);
                jSONObject.put("version", this.f2483c);
                JSONArray jSONArray = new JSONArray();
                for (C0011a a2 : a()) {
                    jSONArray.put(a2.a());
                }
                jSONObject.put(X.k, jSONArray);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public List<C0011a> a() {
            return this.f2484d;
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.f2482b = jSONObject.optBoolean(X.f2479i, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObject.optLong("version"));
                    sb.append("");
                    aVar.f2483c = sb.toString();
                    JSONArray optJSONArray = jSONObject.optJSONArray(X.k);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        aVar.a().add(C0011a.a(optJSONArray.getJSONObject(i2)));
                    }
                } catch (Throwable unused) {
                }
            }
            return aVar;
        }
    }

    /* compiled from: SapiOptions */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f2488a;

        /* renamed from: b reason: collision with root package name */
        public List<C0011a> f2489b = new ArrayList();

        public String b() {
            return this.f2488a;
        }

        public List<C0011a> a() {
            return this.f2489b;
        }

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            if (jSONObject != null) {
                try {
                    bVar.f2488a = jSONObject.optString(X.f2478h);
                    JSONArray optJSONArray = jSONObject.optJSONArray(X.k);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        bVar.a().add(C0011a.a(optJSONArray.getJSONObject(i2)));
                    }
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
    }

    /* compiled from: SapiOptions */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public static final String f2490a = "finger";

        /* renamed from: b reason: collision with root package name */
        public static final String f2491b = "cm_oauth";

        /* renamed from: c reason: collision with root package name */
        public static final String f2492c = "cu_oauth";

        /* renamed from: d reason: collision with root package name */
        public static final String f2493d = "ct_oauth";

        /* renamed from: e reason: collision with root package name */
        public static String f2494e = "v";

        /* renamed from: f reason: collision with root package name */
        public static String f2495f = "p";

        /* renamed from: g reason: collision with root package name */
        public static String f2496g = "ex";

        /* renamed from: h reason: collision with root package name */
        public static String f2497h = "meet";

        /* renamed from: i reason: collision with root package name */
        public static String f2498i = "t";

        /* renamed from: j reason: collision with root package name */
        public Map<String, a> f2499j = new HashMap();

        /* compiled from: SapiOptions */
        public static class a {

            /* renamed from: a reason: collision with root package name */
            public String f2500a;

            /* renamed from: b reason: collision with root package name */
            public long f2501b;

            /* renamed from: c reason: collision with root package name */
            public boolean f2502c;

            /* renamed from: d reason: collision with root package name */
            public String f2503d;

            public JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.f2494e, this.f2500a);
                    jSONObject.put(c.f2495f, this.f2501b);
                    jSONObject.put(c.f2496g, this.f2503d);
                    jSONObject.put(c.f2497h, this.f2502c);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }

            public static a a(String str, JSONObject jSONObject) {
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.has(c.f2498i) ? jSONObject.optJSONObject(c.f2498i).optJSONObject(confignation.tpl) : new JSONObject();
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                aVar.f2500a = optJSONObject.has(c.f2494e) ? optJSONObject.optString(c.f2494e) : jSONObject.optString(c.f2494e);
                aVar.f2501b = optJSONObject.has(c.f2495f) ? optJSONObject.optLong(c.f2495f) : jSONObject.optLong(c.f2495f);
                aVar.f2503d = optJSONObject.has(c.f2496g) ? optJSONObject.optString(c.f2496g) : jSONObject.optString(c.f2496g);
                long j2 = SapiContext.getInstance().getLong(str, -1);
                if (j2 == -1) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    j2 = (long) random.nextInt(1000000);
                    SapiContext.getInstance().put(str, j2);
                }
                aVar.f2502c = aVar.f2501b >= j2;
                if (!TextUtils.isEmpty(aVar.f2500a) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), aVar.f2500a) < 0) {
                    aVar.f2502c = false;
                }
                return aVar;
            }
        }

        public static c a(JSONObject jSONObject) {
            c cVar = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("gray");
            if (optJSONObject == null) {
                return cVar;
            }
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (obj != null && !"".equals(obj)) {
                    cVar.f2499j.put(obj, a.a(obj, optJSONObject.optJSONObject(obj)));
                }
            }
            return cVar;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f2499j.keySet()) {
                try {
                    jSONObject.put(str, ((a) this.f2499j.get(str)).a());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return jSONObject;
        }

        public a a(String str) {
            a aVar = (a) this.f2499j.get(str);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            aVar2.f2502c = true;
            return aVar2;
        }
    }

    /* compiled from: SapiOptions */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public static final String f2504a = "authorized_packages";

        /* renamed from: b reason: collision with root package name */
        public static final String f2505b = "sc_authorized_packages";

        /* renamed from: c reason: collision with root package name */
        public static final String f2506c = "vehicle_system_pkgs";

        /* renamed from: d reason: collision with root package name */
        public Map<String, String> f2507d = new HashMap();

        /* renamed from: e reason: collision with root package name */
        public Map<String, String> f2508e = new HashMap();

        /* renamed from: f reason: collision with root package name */
        public Map<String, String> f2509f = new HashMap();

        public static d a(JSONObject jSONObject) {
            d dVar = new d();
            X.b(jSONObject.optJSONObject(f2504a), dVar.f2507d);
            X.b(jSONObject.optJSONObject(f2506c), dVar.f2509f);
            X.b(jSONObject.optJSONObject(f2505b), dVar.f2508e);
            return dVar;
        }

        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
            hashMap.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
            String str = "c2b0b497d0389e6de1505e7fd8f4d539";
            hashMap.put("com.baidu.searchbox(.*)", str);
            hashMap.put("com.baidu.appsearch", str);
            hashMap.put("com.baidu.(.*)input(.*)", str);
            hashMap.put("com.baidu.BaiduMap(.*)", str);
            hashMap.put("com.baidu.browser.(.+)", str);
            String str2 = "13a0a8019be4015ed20e075d824f1696";
            hashMap.put("com.baidu.iknow", str2);
            hashMap.put("com.baidu.yuedu", str2);
            hashMap.put("com.baidu.homework", str2);
            hashMap.put("com.baidu.wenku", str2);
            hashMap.put("com.baidu.mbaby", str2);
            String str3 = "0586742e88a2e6a19e996598ec336b61";
            hashMap.put("com.baidu.travel", str3);
            hashMap.put("com.ting.mp3.android", str3);
            hashMap.put("com.baidu.news(.*)", str3);
            hashMap.put("com.baidu.video", str3);
            String str4 = "7fd3727852d29eb6f4283988dc0d6150";
            hashMap.put("com.baidu.hao123(.*)", str4);
            String str5 = "ae5821440fab5e1a61a025f014bd8972";
            hashMap.put("com.baidu.netdisk(.*)", str5);
            hashMap.put("com.hiapk.marketpho", "d46053ef4381d35cb774eb632d8e8aec");
            hashMap.put(com.baidu.sapi2.a.a.f2514e, "db97d206640d7aca6d75975b3c1f6e87");
            hashMap.put("com.nuomi", "59215ee95c063ff2c56226581a62130a");
            hashMap.put("cn.jingling.motu.photowonder", "6930f0bd9fa461c2cd65e216acee0118");
            hashMap.put("com.dragon.android.pandaspace", "5b120e96b20f5b4ec695d79b20d18753");
            hashMap.put("cn.opda.a.phonoalbumshoushou", "310a4f78e839b86df7731c2f48fcadae");
            hashMap.put("com.baidu.fb", "a4622402640f20dfda894cbe2edf8823");
            hashMap.put("com.baidu.baidutranslate", str3);
            hashMap.put("com.baidu.lbs.waimai", "77ad7ac419a031af0252422152c62e67");
            hashMap.put("com.baidu.lottery", "6e45686dd05db2374b0a600c7f28c0c4");
            String str6 = "49c95b74699e358ffe67f5daacab3d48";
            hashMap.put("com.baidu.doctor", str6);
            hashMap.put("com.baidu.patient", str6);
            hashMap.put("com.zongheng.reader(.*)", "b9c43ba43f1e150d4f1670ae09a89a7f");
            hashMap.put("com.baidu.doctor.doctorask", str2);
            hashMap.put("com.baidu.k12edu", "610d60c69d2adf4b57fc6c2ec83fecbf");
            hashMap.put("com.baidu.wallet", "de74282b18c0847e64b2b3f0ebbfe0a0");
            hashMap.put("com.baidu.clouda.mobile.crm", "561e009b4a1f97012bf90dfed6c054d5");
            hashMap.put("com.dianxinos.optimizer.channel", "bd3df198d50f0dafa3c5804d342d3698");
            hashMap.put("com.baidu.lbs.bus", "3d96c8b0be8fd5b1db754b8dbb73f23e");
            hashMap.put("com.baidu.hui", "3102ce07daa9cb7c8d62c82fdc61c0ba");
            hashMap.put("com.baidu.image", "ff934173c55f54a81d9c5da216263479");
            hashMap.put("com.baidu.vip", "a00a833bf8afe07172262db3ccb3a5c5");
            hashMap.put("com.baidu.mami", "86743dc804add1dd5f3a81a5818ead58");
            hashMap.put("com.baidu.panocam", "c6186fde16482ce83196441e7fbed1b3");
            hashMap.put("com.baidu.dsocial", str6);
            hashMap.put("com.qiyi.video", "846b46b26f2d9572124e4cfd778e8774");
            hashMap.put("tv.pps.mobile", "79a4816c58b11ba96e85524a7d5cf697");
            hashMap.put("com.baidu.cloudenterprise", str5);
            hashMap.put("com.baidu.haokan", str4);
            hashMap.put("com.baidu.fangmi", "08e0e60c3b3a37ac88a2a06e86d0f8fa");
            hashMap.put("com.chuanke.ikk", "b12d5bcf96654b0a8da91256638695ab");
            hashMap.put("com.baidu.golf", "57ed129c4f9c2340b91d9f224d1478e7");
            hashMap.put("com.baidu.wefan", "7cc37b8563f320aee19809b1ee56cba7");
            hashMap.put("com.baidu.inote", "c266cc0c884249ce197bcf0cdacbe772");
            hashMap.put("com.baidu.album", "4ffb648ae77dbfc7f8d57593d9a6b50c");
            hashMap.put("com.baidu.eduai", "5a9c869602eb27e97af3eaec4d88160b");
            hashMap.put("com.baidu.eureka", "934e69310f5eb3234ba2067d67694ec9");
            hashMap.put("com.baidu.aiting", "0fb46b5e8f8d50dd5a8cda441c8af10d");
            hashMap.put("com.baidu.car.faceos", "9b284760b6eed6ad6ff793c5ad32736a");
            hashMap.put("com.baidu.nani", "dd473ebed169a590680a89351a596f60");
            hashMap.put("com.baidu.car.radio", "246ed007729a5f84a1886adfebce0d63");
            hashMap.put("com.baidu.che.codriver", "5a7c4b062a2292a56f5b7ff283bf3da5");
            hashMap.put("com.baidu.searchcraft", "88f73a1aa8439d646e7ee31c92684f9a");
            hashMap.put("com.baidu.minivideo", str4);
            hashMap.put("com.baidu.duer.superapp", "bd8af7603d638668269bff68aeffd05a");
            hashMap.put("com.zaijia.xiaodu", "ea36f50eb0a843f6f5063b897b5e9497");
            return hashMap;
        }

        public Map<String, String> c() {
            HashMap hashMap = new HashMap();
            String str = "c2b0b497d0389e6de1505e7fd8f4d539";
            hashMap.put("com.baidu.BaiduMap(.*)", str);
            hashMap.put("com.nuomi.merchant", "59215ee95c063ff2c56226581a62130a");
            hashMap.put("com.baidu.hi", str);
            hashMap.put("com.baidu.finance", "3029dbf5932d8d9cd70d3f6e61a1bfaf");
            hashMap.put("com.baidu.searchcraft", "88f73a1aa8439d646e7ee31c92684f9a");
            hashMap.put("com.baidu.robot", "251b30bf338a35325dbcce7182009571");
            hashMap.put("com.baidu.carlife", "e4cebec6e83e2817aaae40de3a2275cb");
            hashMap.put("com.baidu.duer.smartmate", "b650a93303a12982d36ea9bbc1bba8");
            hashMap.put("com.baidu.wifikey", "a442374d6d1e3191490e9b1bf5bdf28f");
            hashMap.put("com.baidu.baijia", "121c6e789e83fd28e8103ba0c7610955");
            hashMap.put("com.baidu.mtjapp", "656365c98ade631c914b5aeac8737449");
            hashMap.put("com.baidu.umoney", "c2fad038465e40f47640e77c529165fb");
            hashMap.put("com.baidu.lbs.crowdapp", "dcbf2b2dc4c43c60cd09c09165de1b1f");
            hashMap.put("com.baidu.video.pad", "194981736af29076ef2e66238b70ba0d");
            hashMap.put("com.dianxinos.superuser", "bd3df198d50f0dafa3c5804d342d3698");
            hashMap.put("com.baidu.baiducamera", "ac979bc4100a1e17d145ca8a4d09bcde");
            hashMap.put("com.baidu.vrvision", "f250054dfbefd747928103b3c7146c95");
            hashMap.put("com.baidu.baike", "b729d38e6bca7cf35683f438159c000d");
            hashMap.put("com.baidu.bshop", "f099e273c67592854c51edccbb91005c");
            hashMap.put("com.baidu.motu.finder", "f555bc53b39fc3d5ceb16e1a9f5cf68b");
            hashMap.put("com.kezhuo", "525c84e2fa04915f12eb0a7bacdf7e8f");
            String str2 = "35abb58862c10c50a5d746ec9db24de5";
            hashMap.put("com.baidu.roocontroller", str2);
            hashMap.put("com.baidu.imesceneinput", str2);
            hashMap.put("com.baidu.doctor.doctoranswer", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.dict", "b154fb69ae7b033725dabaaf1e3b70d0");
            return hashMap;
        }

        public Map<String, String> d() {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.sapi2.demo.standard", "de308d7973b5171883333a97253327e4");
            return hashMap;
        }

        public Map<String, String> e() {
            if (!this.f2508e.isEmpty()) {
                return this.f2508e;
            }
            return c();
        }

        public Map<String, String> f() {
            if (this.f2509f.isEmpty()) {
                return d();
            }
            return this.f2509f;
        }

        public String g() {
            JSONObject jSONObject = new JSONObject();
            try {
                X.b(jSONObject, f2504a, this.f2507d);
                X.b(jSONObject, f2506c, this.f2509f);
                X.b(jSONObject, f2505b, this.f2508e);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }

        public Map<String, String> a() {
            if (!this.f2507d.isEmpty()) {
                return this.f2507d;
            }
            return b();
        }
    }

    public static void b(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject2.put((String) entry.getKey(), entry.getValue());
        }
        jSONObject.put(str, jSONObject2);
    }

    public static List<String> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    public static List<String> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    public static List<String> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    public static List<String> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.BaiduMap(.*)");
        arrayList.add("cn.opda.a.phonoalbumshoushou(.*)");
        return arrayList;
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(com.baidu.sapi2.a.a.f2514e);
        return arrayList;
    }

    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.sapi2.a.a.f2514e);
        return arrayList;
    }

    public a e() {
        return this.G;
    }

    public List<String> f() {
        if (!this.L.isEmpty()) {
            return this.L;
        }
        return l();
    }

    public boolean g() {
        return this.I;
    }

    public LoginShareStrategy h() {
        return this.H;
    }

    public boolean i() {
        return this.X;
    }

    public List<String> n() {
        return this.M;
    }

    public int o() {
        return this.W;
    }

    public List<String> p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baifubao.com");
        arrayList.add("duxiaoman.com");
        arrayList.add("dxmpay.com");
        arrayList.add("baiyingfund.com");
        arrayList.add("dxmbaoxian.com");
        arrayList.add("duxiaomanfund.com");
        arrayList.add("baidu.com");
        if (!this.S.isEmpty()) {
            arrayList.addAll(this.S);
        }
        return arrayList;
    }

    public List<String> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("licai");
        arrayList.add("baidugushitong");
        arrayList.add("walletloan");
        arrayList.add("baiduwalletapp");
        arrayList.add("umoney_ios");
        arrayList.add("walletloan_lite");
        arrayList.add("bdwalletsdk");
        if (!this.R.isEmpty()) {
            arrayList.addAll(this.R);
        }
        return arrayList;
    }

    public Map<String, Integer> r() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.wallet", Integer.valueOf(1));
        hashMap.put("com.nuomi", Integer.valueOf(2));
        hashMap.put("com.baidu.lbs.waimai", Integer.valueOf(3));
        hashMap.put("com.baidu.searchbox(.*)", Integer.valueOf(4));
        hashMap.put("com.baidu.BaiduMap(.*)", Integer.valueOf(5));
        hashMap.put("com.baidu.tieba(.*)", Integer.valueOf(6));
        hashMap.put("com.baidu.netdisk(.*)", Integer.valueOf(7));
        hashMap.put("com.baidu.appsearch", Integer.valueOf(8));
        return hashMap;
    }

    public List<String> s() {
        return this.N;
    }

    public Map<String, LoginShareStrategy> t() {
        return this.J;
    }

    public String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f2476f, this.G.d());
            jSONObject.put(s, this.U);
            jSONObject.put(u, this.V);
            jSONObject.put(r, this.Y);
            if (this.H != null) {
                jSONObject.put(f2471a, this.H.getStrValue());
            }
            jSONObject.put(f2473c, this.I);
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : this.J.entrySet()) {
                jSONObject2.put((String) entry.getKey(), ((LoginShareStrategy) entry.getValue()).getStrValue());
            }
            jSONObject.put(f2472b, jSONObject2);
            b(jSONObject, A, this.Q);
            a(jSONObject, f2474d, this.K);
            a(jSONObject, f2475e, this.L);
            a(jSONObject, o, this.M);
            a(jSONObject, p, this.N);
            a(jSONObject, q, this.P);
            a(jSONObject, x, this.R);
            a(jSONObject, y, this.S);
            JSONArray jSONArray = new JSONArray();
            for (Integer put : this.O) {
                jSONArray.put(put);
            }
            jSONObject.put(t, jSONArray);
            jSONObject.put(w, this.W);
            jSONObject.put(B, this.X);
            jSONObject.put(C, this.Z);
            jSONObject.put(v, this.aa);
            jSONObject.put("gray", this.ba.a());
            jSONObject.put(z, this.T);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<String> a() {
        if (!this.K.isEmpty()) {
            return this.K;
        }
        return j();
    }

    public static void b(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString)) {
                    map.put(str, optString);
                }
            }
        }
    }

    public void a(a aVar) {
        this.G = aVar;
    }

    public static void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        jSONObject.put(str, jSONArray);
    }

    public static void a(JSONObject jSONObject, X x2) {
        SapiContext instance = SapiContext.getInstance();
        String str = f2477g;
        int i2 = instance.getInt(str, -1);
        if (i2 == -1) {
            i2 = new Random().nextInt(100);
            instance.put(str, i2);
        }
        b a2 = b.a(jSONObject.optJSONObject(str));
        String b2 = a2.b();
        if (!TextUtils.isEmpty(b2)) {
            String[] split = b2.split("_");
            int length = split.length;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                i3 += Integer.valueOf(split[i4]).intValue();
                if (i2 <= i3) {
                    x2.G.f2484d.clear();
                    x2.G.f2484d.add(a2.f2489b.get(i4));
                    return;
                }
            }
        }
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String str = "http://";
        String str2 = "";
        String str3 = "https://";
        String str4 = "(:[0-9]{1,4})?";
        String replaceAll = confignation.environment.getWap().replace(str, str2).replace(str3, str2).replaceAll(str4, str2);
        String replaceAll2 = confignation.environment.getURL().replace(str, str2).replace(str3, str2).replaceAll(str4, str2);
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    public static X a(JSONObject jSONObject) {
        X x2 = new X();
        x2.G = a.a(jSONObject.optJSONObject(f2476f));
        if (jSONObject.has(f2477g)) {
            a(jSONObject, x2);
        }
        x2.U = jSONObject.optBoolean(s);
        x2.V = jSONObject.optBoolean(u);
        x2.I = jSONObject.optBoolean(f2473c, true);
        x2.Y = jSONObject.optInt(r, 0);
        String optString = jSONObject.optString(f2471a);
        if (!TextUtils.isEmpty(optString)) {
            x2.H = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(f2472b);
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                x2.J.put(str, LoginShareStrategy.mapStrToValue(optJSONObject.optString(str)));
            }
        }
        b(jSONObject.optJSONObject(A), x2.Q);
        a(jSONObject.optJSONArray(f2474d), x2.K);
        a(jSONObject.optJSONArray(f2475e), x2.L);
        a(jSONObject.optJSONArray(o), x2.M);
        a(jSONObject.optJSONArray(p), x2.N);
        a(jSONObject.optJSONArray(q), x2.P);
        a(jSONObject.optJSONArray(x), x2.R);
        a(jSONObject.optJSONArray(y), x2.S);
        JSONArray optJSONArray = jSONObject.optJSONArray(t);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                x2.O.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
        }
        x2.W = jSONObject.optInt(w, 100);
        x2.X = jSONObject.optBoolean(B, false);
        x2.Z = jSONObject.optBoolean(C, false);
        x2.aa = jSONObject.optString(v, F);
        x2.ba = c.a(jSONObject);
        x2.T = jSONObject.optBoolean(z, true);
        return x2;
    }

    public static void a(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                    list.add(jSONArray.optString(i2));
                }
            }
        }
    }
}
