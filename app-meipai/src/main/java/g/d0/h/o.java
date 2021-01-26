package g.d0.h;

import g.d0.c;
import g.d0.h.d.b;
import h.e;
import h.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer */
public final class o implements Closeable {

    /* renamed from: g reason: collision with root package name */
    public static final Logger f9415g = Logger.getLogger(e.class.getName());

    /* renamed from: a reason: collision with root package name */
    public final f f9416a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f9417b;

    /* renamed from: c reason: collision with root package name */
    public final e f9418c;

    /* renamed from: d reason: collision with root package name */
    public int f9419d = 16384;

    /* renamed from: e reason: collision with root package name */
    public boolean f9420e;

    /* renamed from: f reason: collision with root package name */
    public final b f9421f;

    public o(f fVar, boolean z) {
        this.f9416a = fVar;
        this.f9417b = z;
        e eVar = new e();
        this.f9418c = eVar;
        this.f9421f = new b(eVar);
    }

    public synchronized void a() throws IOException {
        if (this.f9420e) {
            throw new IOException("closed");
        } else if (this.f9417b) {
            if (f9415g.isLoggable(Level.FINE)) {
                f9415g.fine(c.a(">> CONNECTION %s", e.f9316a.b()));
            }
            this.f9416a.write(e.f9316a.f());
            this.f9416a.flush();
        }
    }

    public synchronized void b(boolean z, int i2, List list) throws IOException {
        if (!this.f9420e) {
            a(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.f9420e = true;
        this.f9416a.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.f9420e) {
            this.f9416a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(s sVar) throws IOException {
        if (!this.f9420e) {
            a(0, Integer.bitCount(sVar.f9433a) * 6, 4, 0);
            int i2 = 0;
            while (i2 < 10) {
                boolean z = true;
                if (((1 << i2) & sVar.f9433a) == 0) {
                    z = false;
                }
                if (z) {
                    int i3 = i2 == 4 ? 3 : i2 == 7 ? 4 : i2;
                    this.f9416a.writeShort(i3);
                    this.f9416a.writeInt(sVar.f9434b[i2]);
                }
                i2++;
            }
            this.f9416a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(s sVar) throws IOException {
        if (!this.f9420e) {
            int i2 = this.f9419d;
            if ((sVar.f9433a & 32) != 0) {
                i2 = sVar.f9434b[5];
            }
            this.f9419d = i2;
            int i3 = -1;
            if (((sVar.f9433a & 2) != 0 ? sVar.f9434b[1] : -1) != -1) {
                b bVar = this.f9421f;
                if ((sVar.f9433a & 2) != 0) {
                    i3 = sVar.f9434b[1];
                }
                if (bVar != null) {
                    int min = Math.min(i3, 16384);
                    int i4 = bVar.f9311e;
                    if (i4 != min) {
                        if (min < i4) {
                            bVar.f9309c = Math.min(bVar.f9309c, min);
                        }
                        bVar.f9310d = true;
                        bVar.f9311e = min;
                        int i5 = bVar.f9315i;
                        if (min < i5) {
                            if (min == 0) {
                                bVar.a();
                            } else {
                                bVar.a(i5 - min);
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            a(0, 0, 4, 1);
            this.f9416a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.f9419d, j2);
            long j3 = (long) min;
            j2 -= j3;
            a(i2, min, 9, j2 == 0 ? (byte) 4 : 0);
            this.f9416a.a(this.f9418c, j3);
        }
    }

    public synchronized void a(int i2, int i3, List<c> list) throws IOException {
        if (!this.f9420e) {
            this.f9421f.a(list);
            long j2 = this.f9418c.f9647b;
            int min = (int) Math.min((long) (this.f9419d - 4), j2);
            long j3 = (long) min;
            int i4 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            a(i2, min + 4, 5, i4 == 0 ? (byte) 4 : 0);
            this.f9416a.writeInt(i3 & Integer.MAX_VALUE);
            this.f9416a.a(this.f9418c, j3);
            if (i4 > 0) {
                b(i2, j2 - j3);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar) throws IOException {
        if (this.f9420e) {
            throw new IOException("closed");
        } else if (bVar.f9287a != -1) {
            a(i2, 4, 3, 0);
            this.f9416a.writeInt(bVar.f9287a);
            this.f9416a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(boolean z, int i2, e eVar, int i3) throws IOException {
        if (!this.f9420e) {
            a(i2, i3, 0, z ? (byte) 1 : 0);
            if (i3 > 0) {
                this.f9416a.a(eVar, (long) i3);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, int i3) throws IOException {
        if (!this.f9420e) {
            a(0, 8, 6, z ? (byte) 1 : 0);
            this.f9416a.writeInt(i2);
            this.f9416a.writeInt(i3);
            this.f9416a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, b bVar, byte[] bArr) throws IOException {
        if (this.f9420e) {
            throw new IOException("closed");
        } else if (bVar.f9287a != -1) {
            a(0, bArr.length + 8, 7, 0);
            this.f9416a.writeInt(i2);
            this.f9416a.writeInt(bVar.f9287a);
            if (bArr.length > 0) {
                this.f9416a.write(bArr);
            }
            this.f9416a.flush();
        } else {
            e.a("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void a(int i2, long j2) throws IOException {
        if (this.f9420e) {
            throw new IOException("closed");
        } else if (j2 == 0 || j2 > 2147483647L) {
            e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
            throw null;
        } else {
            a(i2, 4, 8, 0);
            this.f9416a.writeInt((int) j2);
            this.f9416a.flush();
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        if (f9415g.isLoggable(Level.FINE)) {
            f9415g.fine(e.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f9419d;
        if (i3 > i4) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            f fVar = this.f9416a;
            fVar.writeByte((i3 >>> 16) & 255);
            fVar.writeByte((i3 >>> 8) & 255);
            fVar.writeByte(i3 & 255);
            this.f9416a.writeByte(b2 & 255);
            this.f9416a.writeByte(b3 & 255);
            this.f9416a.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            e.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    public void a(boolean z, int i2, List<c> list) throws IOException {
        if (!this.f9420e) {
            this.f9421f.a(list);
            long j2 = this.f9418c.f9647b;
            int min = (int) Math.min((long) this.f9419d, j2);
            long j3 = (long) min;
            int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, 1, b2);
            this.f9416a.a(this.f9418c, j3);
            if (i3 > 0) {
                b(i2, j2 - j3);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
