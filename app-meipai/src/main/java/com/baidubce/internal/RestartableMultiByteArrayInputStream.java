package com.baidubce.internal;

import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class RestartableMultiByteArrayInputStream extends RestartableInputStream {
    public int blockSize;
    public List<byte[]> byteArrayList;
    public long length;
    public long pos = 0;

    public RestartableMultiByteArrayInputStream(List<byte[]> list, long j2) {
        long j3 = 0;
        CheckUtils.isNotNull(list, "byteArrayList should not be null.");
        CheckUtils.checkArgument(!list.isEmpty(), "byteArrayList should not be empty.");
        Iterator it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            byte[] bArr = (byte[]) it.next();
            CheckUtils.isNotNull(bArr, "byteArrayList should not contain null element.");
            if (bArr.length > 0) {
                z = true;
            }
            CheckUtils.checkArgument(z, "byteArrayList should not contain empty byte array.");
            j3 += (long) bArr.length;
        }
        CheckUtils.checkArgument(j3 >= j2, "The specified length(%s) is greater than the total length(%s) of elements in byteArrayList.", Long.valueOf(j2), Long.valueOf(j3));
        this.blockSize = ((byte[]) list.get(0)).length;
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            int length2 = ((byte[]) list.get(i2)).length;
            CheckUtils.checkArgument(length2 == this.blockSize, "All elements in byteArrayList except the last one should have the same length. The first element's length is %s but the %sth element's length is %s.", Integer.valueOf(this.blockSize), Integer.valueOf(i2), Integer.valueOf(length2));
        }
        this.byteArrayList = list;
        this.length = j2;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        } else if (this.pos == this.length) {
            return -1;
        } else {
            int i4 = 0;
            while (i3 > 0) {
                long j2 = this.pos;
                if (j2 >= this.length) {
                    break;
                }
                int i5 = this.blockSize;
                int i6 = (int) (j2 / ((long) i5));
                int i7 = (int) (j2 % ((long) i5));
                byte[] bArr2 = (byte[]) this.byteArrayList.get(i6);
                int length2 = bArr2.length - i7;
                if (length2 > i3) {
                    length2 = i3;
                }
                System.arraycopy(bArr2, i7, bArr, i2, length2);
                this.pos += (long) length2;
                i2 += length2;
                i3 -= length2;
                i4 += length2;
            }
            return i4;
        }
    }

    public void restart() {
        this.pos = 0;
    }

    public int read() {
        long j2 = this.pos;
        if (j2 == this.length) {
            return -1;
        }
        int i2 = this.blockSize;
        int i3 = (int) (j2 / ((long) i2));
        int i4 = (int) (j2 % ((long) i2));
        this.pos = j2 + 1;
        return ((byte[]) this.byteArrayList.get(i3))[i4] & 255;
    }
}
