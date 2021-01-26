package h;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source */
public interface x extends Closeable {
    void close() throws IOException;

    long read(e eVar, long j2) throws IOException;

    y timeout();
}
