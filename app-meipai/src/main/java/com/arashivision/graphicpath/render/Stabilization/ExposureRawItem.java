package com.arashivision.graphicpath.render.Stabilization;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ExposureRawItem {
    public static final int ExposureRawItemBytes = 16;
    public double shutterSpeeds;
    public long timestamp;

    public static ExposureRawItem[] FromByteArray(byte[] bArr) {
        int length = bArr.length / 16;
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        ExposureRawItem[] exposureRawItemArr = new ExposureRawItem[length];
        for (int i2 = 0; i2 < length; i2++) {
            ExposureRawItem exposureRawItem = new ExposureRawItem();
            exposureRawItem.shutterSpeeds = order.getDouble();
            exposureRawItem.timestamp = order.getLong();
            exposureRawItemArr[i2] = exposureRawItem;
        }
        return exposureRawItemArr;
    }

    public static byte[] ToByteArray(ExposureRawItem exposureRawItem) {
        byte[] bArr = new byte[16];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.putLong(exposureRawItem.timestamp);
        order.putDouble(exposureRawItem.shutterSpeeds);
        return bArr;
    }

    public static byte[] ToByteArray(ExposureRawItem[] exposureRawItemArr) {
        byte[] bArr = new byte[(exposureRawItemArr.length * 16)];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i2 = 0; i2 < exposureRawItemArr.length; i2++) {
            order.putLong(exposureRawItemArr[i2].timestamp);
            order.putDouble(exposureRawItemArr[i2].shutterSpeeds);
        }
        return bArr;
    }
}
