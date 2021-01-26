package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.L;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiDeviceUtils.DeviceCrypto;
import com.tencent.connect.common.Constants;
import e.c.b.e.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiDeviceInfo implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final int f3008a = 11;

    /* renamed from: b reason: collision with root package name */
    public static final String f3009b = Character.toString(1);

    /* renamed from: c reason: collision with root package name */
    public static final String f3010c = "android";

    /* renamed from: d reason: collision with root package name */
    public static final String f3011d = TextUtils.join("", new String[]{"O", Config.APP_VERSION_CODE, L.f2152a, "h", "z", "O", "K", "T", "T", "Q", "G", L.f2152a, Config.DEVICE_WIDTH, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "h", "P"});

    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public static Map<String, String> f3012a = new HashMap();

        public static List<String> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("PackageName");
            arrayList.add("AppVersion");
            arrayList.add("SdkVersion");
            arrayList.add("PhoneModel");
            arrayList.add("SystemVersion");
            arrayList.add("SystemType");
            arrayList.add("cuid");
            arrayList.add("tpl");
            arrayList.add("uid_count");
            arrayList.add("uid_list");
            arrayList.add("usetype");
            arrayList.add("used_times");
            arrayList.add("cur_uid");
            arrayList.add("net_type");
            arrayList.add("is_root");
            arrayList.add("wifi");
            arrayList.add("imei");
            arrayList.add("emulator");
            arrayList.add("mac_address");
            arrayList.add("cpu_info");
            arrayList.add("ram");
            arrayList.add("internal_memory");
            arrayList.add("internal_avail_memory");
            arrayList.add("up_time");
            arrayList.add(ExtraMetadataKey.kGps);
            arrayList.add("package_list");
            arrayList.add(ExtraMetadataKey.kIp);
            arrayList.add("device_name");
            arrayList.add("map_location");
            arrayList.add("device_sn");
            arrayList.add("device_uuid");
            arrayList.add("mtj_cuid");
            arrayList.add("idfa");
            arrayList.add("baidumap_cuid");
            arrayList.add("sf_zid");
            arrayList.add("hostver");
            arrayList.add("iccid");
            return arrayList;
        }

        public static void a(List<String> list) {
            List a2 = a();
            int i2 = 0;
            while (i2 < a2.size() && i2 < list.size()) {
                f3012a.put(a2.get(i2), list.get(i2));
                i2++;
            }
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(new Random().nextInt(100))}));
        sb.append(System.currentTimeMillis() / 1000);
        sb.append(String.format("%03d", new Object[]{Integer.valueOf(11)}));
        sb.append("0");
        return sb.toString();
    }

    public static List<String> b() {
        List<SapiAccount> shareAccounts = ServiceManager.getInstance().getIsAccountManager().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    public static List<String> buildDeviceTokens(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        SapiConfiguration confignation = isAccountManager.getConfignation();
        Context context = confignation.context;
        List diExceptIndex = SapiContext.getInstance().getDiExceptIndex();
        ArrayList arrayList = new ArrayList();
        String str21 = "";
        if (e.a.a.a.a.a(arrayList, diExceptIndex.contains(Integer.valueOf(0)) ? str21 : context.getPackageName(), 1, diExceptIndex)) {
            str2 = str21;
        } else {
            str2 = SapiUtils.getVersionName(context);
        }
        if (e.a.a.a.a.a(arrayList, str2, 2, diExceptIndex)) {
            str3 = str21;
        } else {
            str3 = isAccountManager.getVersionName();
        }
        if (e.a.a.a.a.a(arrayList, str3, 3, diExceptIndex)) {
            str4 = str21;
        } else {
            str4 = c();
        }
        if (e.a.a.a.a.a(arrayList, str4, 4, diExceptIndex)) {
            str5 = str21;
        } else {
            str5 = d();
        }
        boolean a2 = e.a.a.a.a.a(arrayList, str5, 5, diExceptIndex);
        String str22 = f3010c;
        if (e.a.a.a.a.a(arrayList, a2 ? str21 : str22, 6, diExceptIndex)) {
            str6 = str21;
        } else {
            str6 = SapiUtils.getClientId(context);
        }
        if (e.a.a.a.a.a(arrayList, str6, 7, diExceptIndex)) {
            str7 = str21;
        } else {
            str7 = confignation.tpl;
        }
        if (e.a.a.a.a.a(arrayList, str7, 8, diExceptIndex)) {
            str8 = str21;
        } else {
            str8 = String.valueOf(isAccountManager.getShareAccounts().size());
        }
        String str23 = ",";
        if (e.a.a.a.a.a(arrayList, str8, 9, diExceptIndex)) {
            str9 = str21;
        } else {
            str9 = TextUtils.join(str23, b());
        }
        if (e.a.a.a.a.a(arrayList, str9, 10, diExceptIndex) || str == null) {
            str = str21;
        }
        if (e.a.a.a.a.a(arrayList, str, 11, diExceptIndex)) {
            str10 = str21;
        } else {
            str10 = String.valueOf(SapiContext.getInstance().getDeviceInfoReadTimes());
        }
        arrayList.add(str10);
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (e.a.a.a.a.a(arrayList, (!diExceptIndex.contains(Integer.valueOf(12)) && currentAccount != null) ? currentAccount.uid : str21, 13, diExceptIndex)) {
            str11 = str21;
        } else {
            str11 = SapiUtils.getNetworkClass(context);
        }
        if (!e.a.a.a.a.a(arrayList, str11, 14, diExceptIndex)) {
            str12 = SapiContext.getInstance().getRootStatus();
            if (TextUtils.isEmpty(str12)) {
                str12 = String.valueOf(SapiUtils.isRoot());
                SapiContext.getInstance().setRootStatus(str12);
            }
        } else {
            str12 = str21;
        }
        if (e.a.a.a.a.a(arrayList, str12, 15, diExceptIndex)) {
            str13 = str21;
        } else {
            str13 = SapiUtils.getWifiInfo(context);
        }
        if (e.a.a.a.a.a(arrayList, str13, 16, diExceptIndex)) {
            str14 = str21;
        } else {
            str14 = SapiDeviceUtils.b(context);
        }
        if (e.a.a.a.a.a(arrayList, str14, 17, diExceptIndex)) {
            str22 = str21;
        } else if (SapiUtils.isEmulator(context)) {
            str22 = "emulator";
        }
        if (e.a.a.a.a.a(arrayList, str22, 18, diExceptIndex)) {
            str15 = str21;
        } else {
            str15 = SapiDeviceUtils.c(context);
        }
        if (e.a.a.a.a.a(arrayList, (!e.a.a.a.a.a(arrayList, str15, 19, diExceptIndex) && SapiUtils.getCpuName() != null) ? SapiUtils.getCpuName() : str21, 20, diExceptIndex)) {
            str16 = str21;
        } else {
            str16 = SapiUtils.getRamMemorySize();
        }
        if (e.a.a.a.a.a(arrayList, str16, 21, diExceptIndex)) {
            str17 = str21;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(SapiUtils.getInternalMemorySize());
            sb.append(str21);
            str17 = sb.toString();
        }
        if (e.a.a.a.a.a(arrayList, str17, 22, diExceptIndex)) {
            str18 = str21;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SapiUtils.getInternalAvailableMemorySize());
            sb2.append(str21);
            str18 = sb2.toString();
        }
        if (e.a.a.a.a.a(arrayList, str18, 23, diExceptIndex)) {
            str19 = str21;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(SapiUtils.getTimeSinceBoot());
            sb3.append(str21);
            str19 = sb3.toString();
        }
        arrayList.add(str19);
        diExceptIndex.contains(Integer.valueOf(24));
        arrayList.add(str21);
        if (e.a.a.a.a.a(arrayList, (!e.a.a.a.a.a(arrayList, diExceptIndex.contains(Integer.valueOf(25)) ? str21 : TextUtils.join(str23, SapiUtils.getPackageList(context)), 26, diExceptIndex) && SapiUtils.getLocalIpAddress() != null) ? SapiUtils.getLocalIpAddress() : str21, 27, diExceptIndex)) {
            str20 = str21;
        } else {
            str20 = SapiUtils.a(context);
        }
        arrayList.add(str20);
        diExceptIndex.contains(Integer.valueOf(28));
        arrayList.add(str21);
        arrayList.add(str21);
        arrayList.add(str21);
        arrayList.add(str21);
        arrayList.add(str21);
        arrayList.add(str21);
        arrayList.add(diExceptIndex.contains(Integer.valueOf(34)) ? str21 : isAccountManager.getCurrentZid(context));
        diExceptIndex.contains(Integer.valueOf(35));
        arrayList.add(str21);
        if (!diExceptIndex.contains(Integer.valueOf(36))) {
            str21 = SapiUtils.getIccid(context);
        }
        arrayList.add(str21);
        return arrayList;
    }

    public static String c() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    public static String d() {
        return !TextUtils.isEmpty(VERSION.RELEASE) ? VERSION.RELEASE : "";
    }

    public static String getDeviceInfo(String str) {
        List buildDeviceTokens = buildDeviceTokens(str);
        a.a(buildDeviceTokens);
        return a(TextUtils.join(f3009b, buildDeviceTokens));
    }

    public static String getDiCookieInfo(List<String> list) {
        return getDiCookieInfo(list, true);
    }

    public static String getDiCookieInfo(List<String> list, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (a.f3012a.isEmpty() || list == null) {
            return null;
        }
        for (String str : list) {
            try {
                jSONObject.put(str, a.f3012a.get(str));
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        String str2 = "sf_zid";
        if ("NoZidYet".equals(jSONObject.optString(str2))) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                jSONObject.put(str2, isAccountManager.getZidAndCheckSafe(isAccountManager.getConfignation().context, currentAccount == null ? null : currentAccount.uid, 120));
            } catch (JSONException e3) {
                Log.e(e3);
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        if (z) {
            return a(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public static String a(String str) {
        String str2 = "_";
        try {
            String a2 = a();
            String base64Encode = DeviceCrypto.base64Encode(new AES().encrypt(str, a2, f3011d));
            String[] strArr = new String[3];
            strArr[0] = a2;
            strArr[1] = base64Encode;
            strArr[2] = "check";
            return TextUtils.join(str2, new String[]{a2, base64Encode, Utils.a(TextUtils.join(str2, strArr).getBytes(), false).substring(0, 6)});
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }
}
