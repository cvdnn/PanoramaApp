package com.baidu.pass.http;

import java.io.InputStream;

public class MultipartHashMap extends HttpHashMap {
    public a fileWrapper;

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1926a;

        /* renamed from: b reason: collision with root package name */
        public String f1927b;

        /* renamed from: c reason: collision with root package name */
        public String f1928c;

        /* renamed from: d reason: collision with root package name */
        public InputStream f1929d;

        public a(String str, InputStream inputStream, String str2, String str3) {
            this.f1926a = str;
            this.f1929d = inputStream;
            this.f1927b = str2;
            this.f1928c = str3;
        }

        public String a() {
            String str = this.f1927b;
            return str != null ? str : "nofilename";
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        this.fileWrapper = new a(str, inputStream, str2, str3);
    }
}
