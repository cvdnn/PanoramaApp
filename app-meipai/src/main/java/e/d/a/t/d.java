package e.d.a.t;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class d extends InputStream {

    /* renamed from: c reason: collision with root package name */
    public static final Queue<d> f7907c = j.a(0);

    /* renamed from: a reason: collision with root package name */
    public InputStream f7908a;

    /* renamed from: b reason: collision with root package name */
    public IOException f7909b;

    public static d a(InputStream inputStream) {
        d dVar;
        synchronized (f7907c) {
            dVar = (d) f7907c.poll();
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.f7908a = inputStream;
        return dVar;
    }

    public int available() throws IOException {
        return this.f7908a.available();
    }

    public void close() throws IOException {
        this.f7908a.close();
    }

    public void mark(int i2) {
        this.f7908a.mark(i2);
    }

    public boolean markSupported() {
        return this.f7908a.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f7908a.read(bArr);
        } catch (IOException e2) {
            this.f7909b = e2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f7908a.reset();
    }

    public long skip(long j2) {
        try {
            return this.f7908a.skip(j2);
        } catch (IOException e2) {
            this.f7909b = e2;
            return 0;
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f7908a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f7909b = e2;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f7908a.read();
        } catch (IOException e2) {
            this.f7909b = e2;
            return -1;
        }
    }

    public void a() {
        this.f7909b = null;
        this.f7908a = null;
        synchronized (f7907c) {
            f7907c.offer(this);
        }
    }
}
