package h;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
public interface w extends Closeable, Flushable {
    void a(e eVar, long j2) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    y timeout();
}
