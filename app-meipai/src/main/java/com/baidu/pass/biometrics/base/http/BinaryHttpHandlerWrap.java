package com.baidu.pass.biometrics.base.http;

import android.os.Looper;

public class BinaryHttpHandlerWrap extends HttpHandlerWrap {
    public String[] allowedContentTypes;

    public BinaryHttpHandlerWrap(Looper looper) {
        super(looper);
    }

    public void onSuccess(int i2, byte[] bArr) {
    }

    public BinaryHttpHandlerWrap(Looper looper, String[] strArr) {
        this.allowedContentTypes = strArr;
    }

    public BinaryHttpHandlerWrap(boolean z, String[] strArr) {
        this.executCallbackInChildThread = z;
        this.allowedContentTypes = strArr;
    }
}
