package com.baidu.sapi2.httpwrap;

import android.os.Looper;
import java.util.HashMap;

public class HttpHandlerWrap {
    public boolean executCallbackInChildThread;

    public HttpHandlerWrap() {
    }

    public boolean isExecutCallbackInChildThread() {
        return this.executCallbackInChildThread;
    }

    public void onFailure(Throwable th, int i2, String str) {
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

    public HttpHandlerWrap(Looper looper) {
    }

    public HttpHandlerWrap(String str) {
    }

    public HttpHandlerWrap(boolean z) {
        this.executCallbackInChildThread = z;
    }
}
