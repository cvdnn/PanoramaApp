package com.arashivision.graphicpath.render.Stabilization;

public class RealTimeExposureRawData extends ExposureRawData {
    public RealTimeExposureRawData(long j2) {
        super(j2);
    }

    public static RealTimeExposureRawData CreateRealTimeExposureRawData(long j2) {
        long nativeCreateRealTimeExposureRawData = nativeCreateRealTimeExposureRawData(j2);
        if (0 == nativeCreateRealTimeExposureRawData) {
            return null;
        }
        return new RealTimeExposureRawData(nativeCreateRealTimeExposureRawData);
    }

    public static native long nativeCreateRealTimeExposureRawData(long j2);

    public void Feed(ExposureRawItem exposureRawItem) {
        nativeFeed(ExposureRawItem.ToByteArray(exposureRawItem), 1);
    }

    public long GetLatestTimeStamp() {
        return nativeGetLatestTimeStamp();
    }

    public double GetShutterSpeed(long j2) {
        return nativeGetShutterSpeed(j2);
    }

    public void InterruptIO() {
        nativeInterruptIO();
    }

    public int Size() {
        return nativeSize();
    }

    public native void nativeFeed(byte[] bArr, int i2);

    public native long nativeGetLatestTimeStamp();

    public native double nativeGetShutterSpeed(long j2);

    public native void nativeInterruptIO();

    public native int nativeSize();

    public void Feed(ExposureRawItem[] exposureRawItemArr) {
        nativeFeed(ExposureRawItem.ToByteArray(exposureRawItemArr), exposureRawItemArr.length);
    }
}
