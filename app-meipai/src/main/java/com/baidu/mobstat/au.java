package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

public class au {

    /* renamed from: a reason: collision with root package name */
    public static final au f1629a = new au();

    /* renamed from: b reason: collision with root package name */
    public HashMap<String, String> f1630b = new HashMap<>();

    /* renamed from: c reason: collision with root package name */
    public HashMap<Character, Integer> f1631c = new HashMap<>();

    /* renamed from: d reason: collision with root package name */
    public HashMap<String, String> f1632d = new HashMap<>();

    /* renamed from: e reason: collision with root package name */
    public HashMap<Character, Integer> f1633e = new HashMap<>();

    /* renamed from: f reason: collision with root package name */
    public HashMap<String, String> f1634f = new HashMap<>();

    /* renamed from: g reason: collision with root package name */
    public HashMap<Character, Integer> f1635g = new HashMap<>();

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static int f1637a = 0;

        /* renamed from: b reason: collision with root package name */
        public static int f1638b = 1;

        /* renamed from: c reason: collision with root package name */
        public static int f1639c = 2;
    }

    public static au a() {
        return f1629a;
    }

    public void b(int i2) {
        if (i2 == a.f1637a) {
            this.f1631c.clear();
            this.f1630b.clear();
        } else if (i2 == a.f1639c) {
            this.f1635g.clear();
            this.f1634f.clear();
        } else {
            this.f1633e.clear();
            this.f1632d.clear();
        }
    }

    public String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == a.f1637a) {
            String str2 = (String) this.f1630b.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            a(str, this.f1631c, this.f1630b);
            return (String) this.f1630b.get(str);
        } else if (i2 == a.f1639c) {
            String str3 = (String) this.f1634f.get(str);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            a(str, this.f1635g, this.f1634f);
            return (String) this.f1634f.get(str);
        } else {
            String str4 = (String) this.f1632d.get(str);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            a(str, this.f1633e, this.f1632d);
            return (String) this.f1632d.get(str);
        }
    }

    public void b() {
        b(a.f1637a);
        b(a.f1639c);
        b(a.f1638b);
    }

    private void a(String str, HashMap<Character, Integer> hashMap, HashMap<String, String> hashMap2) {
        int i2 = 0;
        char lowerCase = Character.toLowerCase(str.charAt(0));
        Integer num = (Integer) hashMap.get(Character.valueOf(lowerCase));
        if (num != null) {
            i2 = num.intValue() + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toString(lowerCase));
        sb.append(i2);
        String sb2 = sb.toString();
        hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(i2));
        hashMap2.put(str, sb2);
    }

    public JSONObject a(int i2) {
        HashMap<String, String> hashMap;
        if (i2 == a.f1637a) {
            hashMap = this.f1630b;
        } else if (i2 == a.f1639c) {
            hashMap = this.f1634f;
        } else {
            hashMap = this.f1632d;
        }
        JSONObject jSONObject = new JSONObject();
        if (hashMap == null) {
            return jSONObject;
        }
        ArrayList arrayList = new ArrayList(hashMap.entrySet());
        try {
            Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
                /* renamed from: a */
                public int compare(Entry<String, String> entry, Entry<String, String> entry2) {
                    return ((String) entry.getValue()).compareTo((String) entry2.getValue());
                }
            });
        } catch (Exception unused) {
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            try {
                jSONObject.put((String) entry.getValue(), (String) entry.getKey());
            } catch (Exception unused2) {
            }
        }
        return jSONObject;
    }
}
