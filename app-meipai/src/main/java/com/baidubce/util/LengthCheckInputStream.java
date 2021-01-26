package com.baidubce.util;

import com.baidubce.BceClientException;
import e.a.a.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LengthCheckInputStream extends FilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    public long dataLength;
    public final long expectedLength;
    public final boolean includeSkipped;
    public long marked;

    public LengthCheckInputStream(InputStream inputStream, long j2, boolean z) {
        super(inputStream);
        if (j2 >= 0) {
            this.expectedLength = j2;
            this.includeSkipped = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLength(boolean z) {
        String str = ")";
        if (z) {
            if (this.dataLength != this.expectedLength) {
                StringBuilder a2 = a.a("Data read (");
                a2.append(this.dataLength);
                a2.append(") has a different length than the expected (");
                a2.append(this.expectedLength);
                a2.append(str);
                throw new BceClientException(a2.toString());
            }
        } else if (this.dataLength > this.expectedLength) {
            StringBuilder a3 = a.a("More data read (");
            a3.append(this.dataLength);
            a3.append(") than expected (");
            a3.append(this.expectedLength);
            a3.append(str);
            throw new BceClientException(a3.toString());
        }
    }

    public void mark(int i2) {
        super.mark(i2);
        this.marked = this.dataLength;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.dataLength = this.marked;
        }
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        this.dataLength += read >= 0 ? (long) read : 0;
        checkLength(read == -1);
        return read;
    }
}
