package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.j;

public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", j.f3097b, j.f3098c, j.f3099d, j.f3100e),
    DOMAIN_QA(j.f3101f, j.f3102g, j.f3103h, j.f3104i, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    

    /* renamed from: b reason: collision with root package name */
    public String f3049b;

    /* renamed from: c reason: collision with root package name */
    public String f3050c;

    /* renamed from: d reason: collision with root package name */
    public String f3051d;

    /* renamed from: e reason: collision with root package name */
    public String f3052e;

    /* renamed from: f reason: collision with root package name */
    public String f3053f;

    /* renamed from: g reason: collision with root package name */
    public boolean f3054g;

    /* access modifiers changed from: public */
    Domain(String str, String str2, String str3, String str4, String str5) {
        this.f3049b = j.a(str);
        this.f3050c = j.a(str2);
        this.f3051d = j.a(str3);
        this.f3052e = j.a(str4);
        this.f3053f = j.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.f3054g = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.f3052e;
    }

    public String getDeviceUrl() {
        return this.f3051d;
    }

    public String getPortraitUrl() {
        return this.f3053f;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getWap() {
        if ((!equals(DOMAIN_ONLINE) || !SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.f3054g)) {
            return this.f3050c;
        }
        return this.f3050c.replace("http://", "https://");
    }

    public String getURL(boolean z) {
        if ((!equals(DOMAIN_ONLINE) || !z) && (equals(DOMAIN_ONLINE) || !this.f3054g)) {
            return this.f3049b;
        }
        return this.f3049b.replace("http://", "https://");
    }
}
