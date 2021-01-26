package com.arashivision.graphicpath.render.Stabilization;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GyroRawItem {
    public static final int GyroRawItemBytes = 56;
    public double AccelerationX;
    public double AccelerationY;
    public double AccelerationZ;
    public double RotationX;
    public double RotationY;
    public double RotationZ;
    public long timestamp;

    public static GyroRawItem[] FromByteArray(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int length = bArr.length / 56;
        GyroRawItem[] gyroRawItemArr = new GyroRawItem[length];
        for (int i2 = 0; i2 < length; i2++) {
            GyroRawItem gyroRawItem = new GyroRawItem();
            gyroRawItem.timestamp = order.getLong();
            gyroRawItem.AccelerationX = order.getDouble();
            gyroRawItem.AccelerationY = order.getDouble();
            gyroRawItem.AccelerationZ = order.getDouble();
            gyroRawItem.RotationX = order.getDouble();
            gyroRawItem.RotationY = order.getDouble();
            gyroRawItem.RotationZ = order.getDouble();
            gyroRawItemArr[i2] = gyroRawItem;
        }
        return gyroRawItemArr;
    }

    public static byte[] ToByteArray(GyroRawItem gyroRawItem) {
        byte[] bArr = new byte[56];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.putLong(gyroRawItem.timestamp);
        order.putDouble(gyroRawItem.AccelerationX);
        order.putDouble(gyroRawItem.AccelerationY);
        order.putDouble(gyroRawItem.AccelerationZ);
        order.putDouble(gyroRawItem.RotationX);
        order.putDouble(gyroRawItem.RotationY);
        order.putDouble(gyroRawItem.RotationZ);
        return bArr;
    }

    public static byte[] ToByteArray(GyroRawItem[] gyroRawItemArr) {
        byte[] bArr = new byte[(gyroRawItemArr.length * 56)];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i2 = 0; i2 < gyroRawItemArr.length; i2++) {
            order.putLong(gyroRawItemArr[i2].timestamp);
            order.putDouble(gyroRawItemArr[i2].AccelerationX);
            order.putDouble(gyroRawItemArr[i2].AccelerationY);
            order.putDouble(gyroRawItemArr[i2].AccelerationZ);
            order.putDouble(gyroRawItemArr[i2].RotationX);
            order.putDouble(gyroRawItemArr[i2].RotationY);
            order.putDouble(gyroRawItemArr[i2].RotationZ);
        }
        return bArr;
    }
}
