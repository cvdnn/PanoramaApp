package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import com.baidu.sapi2.NoProguard;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolService implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadFactory f3018a = new u();

    /* renamed from: b reason: collision with root package name */
    public static final int f3019b = 0;

    /* renamed from: c reason: collision with root package name */
    public static final int f3020c = 1;

    /* renamed from: d reason: collision with root package name */
    public Handler f3021d;
    public ThreadPoolExecutor poolService;

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static ThreadPoolService f3022a = new ThreadPoolService(null);
    }

    public /* synthetic */ ThreadPoolService(u uVar) {
        this();
    }

    public static ThreadPoolService getInstance() {
        return a.f3022a;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f3021d.sendMessage(this.f3021d.obtainMessage(0, tPRunnable));
    }

    public ThreadPoolService() {
        this.f3021d = new v(this, Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), f3018a);
        this.poolService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
