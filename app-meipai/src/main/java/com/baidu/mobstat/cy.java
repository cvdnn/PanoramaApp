package com.baidu.mobstat;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class cy implements cu {

    /* renamed from: a reason: collision with root package name */
    public byte[] f1835a;

    /* renamed from: b reason: collision with root package name */
    public TreeMap<String, String> f1836b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void a(String str, String str2) {
        this.f1836b.put(str, str2);
    }

    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.f1836b.keySet()).iterator();
    }

    public byte[] c() {
        return this.f1835a;
    }

    public String b(String str) {
        String str2 = (String) this.f1836b.get(str);
        return str2 == null ? "" : str2;
    }

    public boolean c(String str) {
        return this.f1836b.containsKey(str);
    }
}
