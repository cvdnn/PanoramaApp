package h;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class m implements x {

    /* renamed from: a reason: collision with root package name */
    public final g f9661a;

    /* renamed from: b reason: collision with root package name */
    public final Inflater f9662b;

    /* renamed from: c reason: collision with root package name */
    public int f9663c;

    /* renamed from: d reason: collision with root package name */
    public boolean f9664d;

    public m(g gVar, Inflater inflater) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f9661a = gVar;
            this.f9662b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final void a() throws IOException {
        int i2 = this.f9663c;
        if (i2 != 0) {
            int remaining = i2 - this.f9662b.getRemaining();
            this.f9663c -= remaining;
            this.f9661a.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.f9664d) {
            this.f9662b.end();
            this.f9664d = true;
            this.f9661a.close();
        }
    }

    public long read(e eVar, long j2) throws IOException {
        t a2;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f9664d) {
            throw new IllegalStateException("closed");
        } else if (i2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean z = false;
                if (this.f9662b.needsInput()) {
                    a();
                    if (this.f9662b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f9661a.g()) {
                        z = true;
                    } else {
                        t tVar = this.f9661a.c().f9646a;
                        int i3 = tVar.f9681c;
                        int i4 = tVar.f9680b;
                        int i5 = i3 - i4;
                        this.f9663c = i5;
                        this.f9662b.setInput(tVar.f9679a, i4, i5);
                    }
                }
                try {
                    a2 = eVar.a(1);
                    int inflate = this.f9662b.inflate(a2.f9679a, a2.f9681c, (int) Math.min(j2, (long) (8192 - a2.f9681c)));
                    if (inflate > 0) {
                        a2.f9681c += inflate;
                        long j3 = (long) inflate;
                        eVar.f9647b += j3;
                        return j3;
                    } else if (this.f9662b.finished()) {
                        break;
                    } else if (this.f9662b.needsDictionary()) {
                        break;
                    } else if (z) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            a();
            if (a2.f9680b == a2.f9681c) {
                eVar.f9646a = a2.a();
                u.a(a2);
            }
            return -1;
        }
    }

    public y timeout() {
        return this.f9661a.timeout();
    }
}
