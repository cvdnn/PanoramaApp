package com.baidu.mobstat;

import e.a.a.a.a;

public class MtjConfig {
    public static final String BAIDU_MTJ_PUSH_CALL = "Baidu_mtj_push_call";
    public static final String BAIDU_MTJ_PUSH_MSG = "Baidu_mtj_push_msg";

    public enum FeedTrackStrategy {
        TRACK_ALL,
        TRACK_SINGLE,
        TRACK_NONE
    }

    public enum PushPlatform {
        BAIDUYUN("baiduyun", 0),
        JIGUANG("jiguang", 1),
        GETUI("getui", 2),
        HUAWEI("huawei", 3),
        XIAOMI("xiaomi", 4),
        UMENG("umeng", 5),
        XINGE("xinge", 6),
        ALIYUN("aliyun", 7),
        OPPO("oppo", 8),
        MEIZU("meizu", 9);
        

        /* renamed from: a reason: collision with root package name */
        public String f1454a;

        /* renamed from: b reason: collision with root package name */
        public int f1455b;

        /* access modifiers changed from: public */
        PushPlatform(String str, int i2) {
            this.f1454a = str;
            this.f1455b = i2;
        }

        public String showName() {
            return this.f1454a;
        }

        public String value() {
            StringBuilder a2 = a.a("p");
            a2.append(this.f1455b);
            return a2.toString();
        }
    }
}
