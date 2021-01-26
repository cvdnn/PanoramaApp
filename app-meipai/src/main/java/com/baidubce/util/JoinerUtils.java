package com.baidubce.util;

import e.a.a.a.a;
import java.util.List;

public class JoinerUtils {
    public static String cut(String str, String str2) {
        return str2.replace(str, "");
    }

    public static String on(String str, List<String> list) {
        String str2 = "";
        for (String a2 : list) {
            str2 = a.a(str2, a2, str);
        }
        return str2.substring(0, str2.length() - 1);
    }

    public static String on(String str, Object... objArr) {
        String str2 = "";
        for (Object obj : objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(obj);
            sb.append(str);
            str2 = sb.toString();
        }
        return str2.substring(0, str2.length() - 1);
    }
}
