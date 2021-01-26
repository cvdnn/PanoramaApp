package com.arashivision.insbase.nativeref;

public class NativeBuffer extends NativeObjectRef {
    public String mName;

    public NativeBuffer(long j2) {
        super(j2, "NativeBuffer");
        this.mName = "";
    }

    public static NativeBuffer createEmptyBuffer(long j2) {
        return new NativeBuffer(j2, "NativeBuffer");
    }

    public static native long createNativeWrap(long j2);

    public native byte[] get(int i2, int i3, byte[] bArr, int i4);

    public native void set(int i2, int i3, byte[] bArr, int i4);

    public native long size();

    public NativeBuffer(long j2, String str) {
        this(createNativeWrap(j2));
        this.mName = str;
    }
}
