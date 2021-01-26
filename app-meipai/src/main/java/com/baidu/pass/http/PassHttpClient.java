package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import e.a.a.a.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PassHttpClient {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadFactory f1930a = new ThreadFactory() {

        /* renamed from: a reason: collision with root package name */
        public final AtomicInteger f1933a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder a2 = a.a("pass_net_work_request_thread # ");
            a2.append(this.f1933a.getAndIncrement());
            return new Thread(runnable, a2.toString());
        }
    };

    /* renamed from: b reason: collision with root package name */
    public static final ThreadPoolExecutor f1931b;

    /* renamed from: c reason: collision with root package name */
    public a f1932c;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), f1930a);
        f1931b = threadPoolExecutor;
        f1931b.allowCoreThreadTimeOut(true);
    }

    public void cancelRequests(boolean z) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (PassHttpClient.this.f1932c != null && PassHttpClient.this.f1932c.b() != null) {
                        PassHttpClient.this.f1932c.b().disconnect();
                        PassHttpClient.this.f1932c.a();
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public void get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e2, e2.getMessage());
            }
        }
    }

    public void post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e2, e2.getMessage());
            }
        }
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        } else if (passHttpParamDTO == null || TextUtils.isEmpty(passHttpParamDTO.url)) {
            throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
        }
    }

    private void a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        a aVar = new a(method, context, passHttpParamDTO, httpResponseHandler);
        this.f1932c = aVar;
        f1931b.submit(aVar);
    }
}
