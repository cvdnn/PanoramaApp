package h;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource */
public interface g extends x, ReadableByteChannel {
    int a(q qVar) throws IOException;

    long a(byte b2) throws IOException;

    long a(h hVar) throws IOException;

    String a(Charset charset) throws IOException;

    boolean a(long j2, h hVar) throws IOException;

    long b(h hVar) throws IOException;

    @Deprecated
    e c();

    h c(long j2) throws IOException;

    boolean e(long j2) throws IOException;

    byte[] f() throws IOException;

    byte[] f(long j2) throws IOException;

    void g(long j2) throws IOException;

    boolean g() throws IOException;

    e getBuffer();

    String j() throws IOException;

    int k() throws IOException;

    short n() throws IOException;

    long o() throws IOException;

    InputStream p();

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j2) throws IOException;
}
