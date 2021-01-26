package com.baidu.pass.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

public class HttpResponseHandler extends Handler {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final int FAILURE_MESSAGE = 1;
    public static final int FINISH_MESSAGE = 3;
    public static final int START_MESSAGE = 2;
    public static final int SUCCESS_MESSAGE = 0;
    public boolean executCallbackInChildThread;
    public String mDefaultCharset;

    public HttpResponseHandler() {
        this("UTF-8");
    }

    public void a() {
        if (this.executCallbackInChildThread) {
            onStart();
        } else {
            sendMessage(obtainMessage(2));
        }
    }

    public void b() {
        if (this.executCallbackInChildThread) {
            onFinish();
        } else {
            sendMessage(obtainMessage(3));
        }
    }

    public void c(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        String str;
        if (i2 == 200) {
            a(i2, hashMap, bArr);
            return;
        }
        if (bArr == null) {
            str = null;
        } else {
            str = new String(bArr);
        }
        a(new HttpErrorException(i2, str), str);
    }

    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            b(((Integer) objArr[0]).intValue(), (HashMap) objArr[1], (byte[]) objArr[2]);
        } else if (i2 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            b((Throwable) objArr2[0], (String) objArr2[1]);
        } else if (i2 == 2) {
            onStart();
        } else if (i2 == 3) {
            onFinish();
        }
    }

    public void onFailure(Throwable th, String str) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i2, String str) {
    }

    public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
        onSuccess(i2, str);
    }

    public HttpResponseHandler(String str) {
        this.mDefaultCharset = str;
    }

    public HttpResponseHandler(Looper looper) {
        this(looper, false);
    }

    public void a(Throwable th, String str) {
        if (this.executCallbackInChildThread) {
            onFailure(th, str);
            return;
        }
        sendMessage(obtainMessage(1, new Object[]{th, str}));
    }

    public void b(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        onSuccess(i2, bArr == null ? null : new String(bArr), hashMap);
    }

    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        this.executCallbackInChildThread = z;
        this.mDefaultCharset = "UTF-8";
    }

    public void b(Throwable th, String str) {
        onFailure(th, str);
    }

    public void a(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        String str;
        if (this.executCallbackInChildThread) {
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr);
            }
            onSuccess(i2, str, hashMap);
            return;
        }
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), hashMap, bArr}));
    }
}
