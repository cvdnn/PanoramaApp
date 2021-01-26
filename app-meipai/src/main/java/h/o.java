package h;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class o {

    /* renamed from: a reason: collision with root package name */
    public static final Logger f9667a = Logger.getLogger(o.class.getName());

    /* compiled from: Okio */
    public class a implements x {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ y f9668a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ InputStream f9669b;

        public a(y yVar, InputStream inputStream) {
            this.f9668a = yVar;
            this.f9669b = inputStream;
        }

        public void close() throws IOException {
            this.f9669b.close();
        }

        public long read(e eVar, long j2) throws IOException {
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (i2 == 0) {
                return 0;
            } else {
                try {
                    this.f9668a.e();
                    t a2 = eVar.a(1);
                    int read = this.f9669b.read(a2.f9679a, a2.f9681c, (int) Math.min(j2, (long) (8192 - a2.f9681c)));
                    if (read == -1) {
                        return -1;
                    }
                    a2.f9681c += read;
                    long j3 = (long) read;
                    eVar.f9647b += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (o.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public y timeout() {
            return this.f9668a;
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("source(");
            a2.append(this.f9669b);
            a2.append(")");
            return a2.toString();
        }
    }

    public static g a(x xVar) {
        return new s(xVar);
    }

    public static x b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            p pVar = new p(socket);
            return new b(pVar, a(socket.getInputStream(), pVar));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static f a(w wVar) {
        return new r(wVar);
    }

    public static w a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            p pVar = new p(socket);
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return new a(pVar, new n(pVar, outputStream));
            }
            throw new IllegalArgumentException("out == null");
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static x a(InputStream inputStream) {
        return a(inputStream, new y());
    }

    public static x a(InputStream inputStream, y yVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (yVar != null) {
            return new a(yVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static x a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
