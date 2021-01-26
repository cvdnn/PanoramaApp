package com.baidu.sofire.jni;

import e.c.f.c;

public class Asc {
    static {
        try {
            System.loadLibrary("fire");
        } catch (Throwable unused) {
            c.d();
        }
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native int df(String str, String str2, byte[] bArr);

    public native byte[] dr(byte[] bArr, byte[] bArr2);
}
