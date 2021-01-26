package com.arashivision.onestream.Gyro;

public class OneGyroField {
    public static final int OFFSET_INTERVAL = 8;
    public static final int ONE_GYRO_LEN = 56;
    public double[] accels = new double[3];
    public double[] gyros = new double[3];
    public long originTsMs;
    public long timestampMs;
    public long timestampNs;

    public OneGyroField(byte[] bArr, int i2, long j2) {
        long bytes2Long = bytes2Long(bArr, i2);
        this.originTsMs = bytes2Long;
        long j3 = (bytes2Long * 1000000) + j2;
        this.timestampNs = j3;
        this.timestampMs = j3 / 1000000;
        int i3 = i2 + 8;
        this.accels[0] = bytes2Double(bArr, i3);
        int i4 = i3 + 8;
        this.accels[1] = bytes2Double(bArr, i4);
        int i5 = i4 + 8;
        this.accels[2] = bytes2Double(bArr, i5);
        int i6 = i5 + 8;
        this.gyros[0] = bytes2Double(bArr, i6);
        int i7 = i6 + 8;
        this.gyros[1] = bytes2Double(bArr, i7);
        this.gyros[2] = bytes2Double(bArr, i7 + 8);
    }

    private double bytes2Double(byte[] bArr, int i2) {
        long j2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j2 |= ((long) (bArr[i3 + i2] & 255)) << (i3 * 8);
        }
        return Double.longBitsToDouble(j2);
    }

    private long bytes2Long(byte[] bArr, int i2) {
        long j2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j2 |= ((long) (bArr[i3 + i2] & 255)) << (i3 * 8);
        }
        return j2;
    }

    private void double2Bytes(double d2, byte[] bArr, int i2) {
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3 + i2] = (byte) ((int) ((doubleToRawLongBits >> (i3 * 8)) & 255));
        }
    }

    private void long2Bytes(long j2, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3 + i2] = (byte) ((int) ((j2 >> (i3 * 8)) & 255));
        }
    }

    private void long2BytesBE(long j2, byte[] bArr, int i2) {
        int i3 = 0;
        for (int i4 = 7; i4 >= 0; i4--) {
            bArr[i4 + i2] = (byte) ((int) ((j2 >> (i3 * 8)) & 255));
            i3++;
        }
    }

    public void toBytes(byte[] bArr, int i2) {
        long2Bytes(this.timestampMs, bArr, i2);
        int i3 = i2 + 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            double[] dArr = this.accels;
            if (i5 >= dArr.length) {
                break;
            }
            double2Bytes(dArr[i5], bArr, i3);
            i3 += 8;
            i5++;
        }
        while (true) {
            double[] dArr2 = this.gyros;
            if (i4 < dArr2.length) {
                double2Bytes(dArr2[i4], bArr, i3);
                i3 += 8;
                i4++;
            } else {
                return;
            }
        }
    }

    public void toBytesBE(byte[] bArr, int i2) {
        long2BytesBE(this.timestampMs, bArr, i2);
        int i3 = i2 + 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            double[] dArr = this.accels;
            if (i5 >= dArr.length) {
                break;
            }
            double2Bytes(dArr[i5], bArr, i3);
            i3 += 8;
            i5++;
        }
        while (true) {
            double[] dArr2 = this.gyros;
            if (i4 < dArr2.length) {
                double2Bytes(dArr2[i4], bArr, i3);
                i3 += 8;
                i4++;
            } else {
                return;
            }
        }
    }
}
