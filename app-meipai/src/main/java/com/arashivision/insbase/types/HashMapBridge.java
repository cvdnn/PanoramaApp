package com.arashivision.insbase.types;

import java.util.HashMap;

public class HashMapBridge {
    public static String stringStringHashMapGet(Object obj, String str) {
        return (String) ((HashMap) obj).get(str);
    }

    public static String[] stringStringHashMapKeys(Object obj) {
        return (String[]) ((HashMap) obj).keySet().toArray(new String[0]);
    }

    public static Object stringStringHashMapNew() {
        return new HashMap();
    }

    public static String stringStringHashMapPut(Object obj, String str, String str2) {
        return (String) ((HashMap) obj).put(str, str2);
    }
}
