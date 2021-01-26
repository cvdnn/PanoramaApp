package h;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class y {

    /* renamed from: d reason: collision with root package name */
    public static final y f9690d = new a();

    /* renamed from: a reason: collision with root package name */
    public boolean f9691a;

    /* renamed from: b reason: collision with root package name */
    public long f9692b;

    /* renamed from: c reason: collision with root package name */
    public long f9693c;

    /* compiled from: Timeout */
    public class a extends y {
        public y a(long j2) {
            return this;
        }

        public y a(long j2, TimeUnit timeUnit) {
            return this;
        }

        public void e() throws IOException {
        }
    }

    public y a(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.f9693c = timeUnit.toNanos(j2);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public y b() {
        this.f9693c = 0;
        return this;
    }

    public long c() {
        if (this.f9691a) {
            return this.f9692b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f9691a;
    }

    public void e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f9691a && this.f9692b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y a(long j2) {
        this.f9691a = true;
        this.f9692b = j2;
        return this;
    }

    public y a() {
        this.f9691a = false;
        return this;
    }
}
