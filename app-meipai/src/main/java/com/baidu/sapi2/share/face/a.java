package com.baidu.sapi2.share.face;

/* compiled from: FaceLoginModel */
public class a implements Comparable<a> {

    /* renamed from: a reason: collision with root package name */
    public String f2925a;

    /* renamed from: b reason: collision with root package name */
    public long f2926b;

    public a(String str, long j2) {
        this.f2925a = str;
        this.f2926b = j2;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        int i2 = ((aVar.f2926b - this.f2926b) > 0 ? 1 : ((aVar.f2926b - this.f2926b) == 0 ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }
}
