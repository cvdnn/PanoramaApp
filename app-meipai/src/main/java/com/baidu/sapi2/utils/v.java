package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ThreadPoolService */
public class v extends Handler {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ThreadPoolService f3128a;

    public v(ThreadPoolService threadPoolService, Looper looper) {
        this.f3128a = threadPoolService;
        super(looper);
    }

    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            ((TPRunnable) message.obj).run();
        } else if (i2 == 1) {
            this.f3128a.poolService.submit(((TPRunnable) message.obj).runable);
        }
    }
}
