package h;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
public interface f extends w, WritableByteChannel {
    long a(x xVar) throws IOException;

    f b(String str, int i2, int i3) throws IOException;

    e c();

    f c(h hVar) throws IOException;

    f c(String str) throws IOException;

    f d(long j2) throws IOException;

    void flush() throws IOException;

    f h() throws IOException;

    f write(byte[] bArr) throws IOException;

    f write(byte[] bArr, int i2, int i3) throws IOException;

    f writeByte(int i2) throws IOException;

    f writeInt(int i2) throws IOException;

    f writeShort(int i2) throws IOException;
}
