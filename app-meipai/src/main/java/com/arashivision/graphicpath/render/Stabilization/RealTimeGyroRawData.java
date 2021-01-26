package com.arashivision.graphicpath.render.Stabilization;

public class RealTimeGyroRawData extends GyroRawData {
    public RealTimeGyroRawData(long j2) {
        super(j2);
    }

    public static RealTimeGyroRawData CreateRealTimeGyroRawData(int i2) {
        long nativeCreateRealTimeGyroRawData = nativeCreateRealTimeGyroRawData(i2);
        if (0 == nativeCreateRealTimeGyroRawData) {
            return null;
        }
        return new RealTimeGyroRawData(nativeCreateRealTimeGyroRawData);
    }

    public static native long nativeCreateRealTimeGyroRawData(int i2);

    public void Feed(GyroRawItem gyroRawItem) {
        nativeFeed(GyroRawItem.ToByteArray(gyroRawItem), 1);
    }

    public void InterruptIO() {
    }

    public boolean IsStream() {
        return true;
    }

    public long LatestTimeStamp() {
        return nativeLatestTimeStamp();
    }

    public void Reset() {
        nativeReset();
    }

    public int Size() {
        return nativeSize();
    }

    public native void nativeFeed(byte[] bArr, int i2);

    public native long nativeLatestTimeStamp();

    public native void nativeReset();

    public native void nativeSetGyroTimeOffsetMs(long j2);

    public native int nativeSize();

    public void setGyroTimeOffsetMs(long j2) {
        nativeSetGyroTimeOffsetMs(j2);
    }

    public void Feed(GyroRawItem[] gyroRawItemArr) {
        nativeFeed(GyroRawItem.ToByteArray(gyroRawItemArr), gyroRawItemArr.length);
    }
}
