package com.baidu.sapi2.utils;

import com.baidu.sapi2.httpwrap.HttpHashMapWrap;

/* compiled from: StatService */
public class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ HttpHashMapWrap f3123a;

    public r(HttpHashMapWrap httpHashMapWrap) {
        this.f3123a = httpHashMapWrap;
    }

    public void run() {
        t.b(this.f3123a);
    }
}
