package com.baidu.pass.http;

import java.util.HashMap;
import java.util.Map;

public class HttpHashMap {

    /* renamed from: a reason: collision with root package name */
    public Map<String, String> f1924a = new HashMap();

    public void doSign(String str) {
    }

    public String get(String str) {
        return (String) this.f1924a.get(str);
    }

    public Map getMap() {
        return this.f1924a;
    }

    public void put(String str, String str2) {
        this.f1924a.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f1924a.putAll(map);
    }
}
