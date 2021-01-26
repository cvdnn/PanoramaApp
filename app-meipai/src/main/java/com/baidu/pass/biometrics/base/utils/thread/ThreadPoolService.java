package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e.a.a.a.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolService {
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    public static final int MSG_RUN_IN_CHILD_THREAD = 1;
    public static final int MSG_RUN_IN_UI_THREAD = 0;
    public static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        public final AtomicInteger count = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder a2 = a.a("pass_face_thread # ");
            a2.append(this.count.getAndIncrement());
            return new Thread(runnable, a2.toString());
        }
    };
    public Handler mHandler;
    public ThreadPoolExecutor poolService;

    public static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, tPRunnable));
    }

    public ThreadPoolService() {
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    ((TPRunnable) message.obj).run();
                } else if (i2 == 1) {
                    ThreadPoolService.this.poolService.submit(((TPRunnable) message.obj).runable);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(CPU_COUNT - 1, 4)), Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        this.poolService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
