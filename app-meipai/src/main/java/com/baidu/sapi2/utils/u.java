package com.baidu.sapi2.utils;

import e.a.a.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ThreadPoolService */
public class u implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    public final AtomicInteger f3127a = new AtomicInteger(1);

    public Thread newThread(Runnable runnable) {
        StringBuilder a2 = a.a("pass_pool_thread # ");
        a2.append(this.f3127a.getAndIncrement());
        return new Thread(runnable, a2.toString());
    }
}
