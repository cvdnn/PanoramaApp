package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import e.c.a.a.b.b;
import e.c.b.e.Utils;
import java.util.List;
import java.util.Random;

public class PassBioBaseUtil {
    public static String getClientId(Context context) {
        try {
            return b.b(context);
        } catch (Throwable unused) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append("123456789");
            sb.append(Utils.a(String.valueOf(random.nextInt(100)).getBytes(), false));
            return sb.toString();
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static boolean listValueEqual(List<Integer> list, List<Integer> list2) {
        if (list == null || list2 == null || list.isEmpty() || list2.isEmpty() || list.size() != list2.size()) {
            return false;
        }
        for (Integer intValue : list) {
            if (!list2.contains(Integer.valueOf(intValue.intValue()))) {
                return false;
            }
        }
        return true;
    }
}
