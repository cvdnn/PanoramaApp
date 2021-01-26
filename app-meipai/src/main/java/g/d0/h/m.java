package g.d0.h;

import com.arashivision.graphicpath.render.Stabilization.GyroType;
import g.d0.c;
import g.d0.h.g.f;
import h.e;
import h.g;
import h.h;
import h.x;
import h.y;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Reader */
public final class m implements Closeable {

    /* renamed from: e reason: collision with root package name */
    public static final Logger f9384e = Logger.getLogger(e.class.getName());

    /* renamed from: a reason: collision with root package name */
    public final g f9385a;

    /* renamed from: b reason: collision with root package name */
    public final a f9386b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f9387c;

    /* renamed from: d reason: collision with root package name */
    public final g.d0.h.d.a f9388d;

    /* compiled from: Http2Reader */
    public static final class a implements x {

        /* renamed from: a reason: collision with root package name */
        public final g f9389a;

        /* renamed from: b reason: collision with root package name */
        public int f9390b;

        /* renamed from: c reason: collision with root package name */
        public byte f9391c;

        /* renamed from: d reason: collision with root package name */
        public int f9392d;

        /* renamed from: e reason: collision with root package name */
        public int f9393e;

        /* renamed from: f reason: collision with root package name */
        public short f9394f;

        public a(g gVar) {
            this.f9389a = gVar;
        }

        public void close() throws IOException {
        }

        public long read(e eVar, long j2) throws IOException {
            int i2;
            int readInt;
            do {
                int i3 = this.f9393e;
                if (i3 == 0) {
                    this.f9389a.skip((long) this.f9394f);
                    this.f9394f = 0;
                    if ((this.f9391c & 4) != 0) {
                        return -1;
                    }
                    i2 = this.f9392d;
                    int a2 = m.a(this.f9389a);
                    this.f9393e = a2;
                    this.f9390b = a2;
                    byte readByte = (byte) (this.f9389a.readByte() & 255);
                    this.f9391c = (byte) (this.f9389a.readByte() & 255);
                    if (m.f9384e.isLoggable(Level.FINE)) {
                        m.f9384e.fine(e.a(true, this.f9392d, this.f9390b, readByte, this.f9391c));
                    }
                    readInt = this.f9389a.readInt() & Integer.MAX_VALUE;
                    this.f9392d = readInt;
                    if (readByte != 9) {
                        e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                        throw null;
                    }
                } else {
                    long read = this.f9389a.read(eVar, Math.min(j2, (long) i3));
                    if (read == -1) {
                        return -1;
                    }
                    this.f9393e = (int) (((long) this.f9393e) - read);
                    return read;
                }
            } while (readInt == i2);
            e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        public y timeout() {
            return this.f9389a.timeout();
        }
    }

    /* compiled from: Http2Reader */
    public interface b {
    }

    public m(g gVar, boolean z) {
        this.f9385a = gVar;
        this.f9387c = z;
        a aVar = new a(gVar);
        this.f9386b = aVar;
        this.f9388d = new g.d0.h.d.a(4096, aVar);
    }

    public void a(b bVar) throws IOException {
        if (!this.f9387c) {
            h c2 = this.f9385a.c((long) e.f9316a.d());
            if (f9384e.isLoggable(Level.FINE)) {
                f9384e.fine(c.a("<< CONNECTION %s", c2.b()));
            }
            if (!e.f9316a.equals(c2)) {
                e.b("Expected a connection header but was %s", c2.g());
                throw null;
            }
        } else if (!a(true, bVar)) {
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public void close() throws IOException {
        this.f9385a.close();
    }

    public boolean a(boolean z, b bVar) throws IOException {
        b bVar2 = bVar;
        short s = 0;
        try {
            this.f9385a.g(9);
            int a2 = a(this.f9385a);
            if (a2 < 0 || a2 > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f9385a.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f9385a.readByte() & 255);
                int readInt = this.f9385a.readInt() & Integer.MAX_VALUE;
                if (f9384e.isLoggable(Level.FINE)) {
                    f9384e.fine(e.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        if (readInt != 0) {
                            boolean z2 = (readByte2 & 1) != 0;
                            if (!((readByte2 & 32) != 0)) {
                                short readByte3 = (readByte2 & 8) != 0 ? (short) (this.f9385a.readByte() & 255) : 0;
                                int a3 = a(a2, readByte2, readByte3);
                                g gVar = this.f9385a;
                                f fVar = (f) bVar2;
                                if (g.this.b(readInt)) {
                                    g gVar2 = g.this;
                                    if (gVar2 != null) {
                                        e eVar = new e();
                                        long j2 = (long) a3;
                                        gVar.g(j2);
                                        gVar.read(eVar, j2);
                                        if (eVar.f9647b == j2) {
                                            ExecutorService executorService = gVar2.f9340h;
                                            j jVar = new j(gVar2, "OkHttp %s Push Data[%s]", new Object[]{gVar2.f9336d, Integer.valueOf(readInt)}, readInt, eVar, a3, z2);
                                            executorService.execute(jVar);
                                        } else {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(eVar.f9647b);
                                            sb.append(" != ");
                                            sb.append(a3);
                                            throw new IOException(sb.toString());
                                        }
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    n a4 = g.this.a(readInt);
                                    if (a4 == null) {
                                        g.this.a(readInt, b.PROTOCOL_ERROR);
                                        gVar.skip((long) a3);
                                    } else {
                                        a4.f9401g.a(gVar, (long) a3);
                                        if (z2) {
                                            a4.f();
                                        }
                                    }
                                }
                                this.f9385a.skip((long) readByte3);
                                break;
                            } else {
                                e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                                throw null;
                            }
                        } else {
                            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 1:
                        if (readInt != 0) {
                            boolean z3 = (readByte2 & 1) != 0;
                            if ((readByte2 & 8) != 0) {
                                s = (short) (this.f9385a.readByte() & 255);
                            }
                            if ((readByte2 & 32) != 0) {
                                a(bVar2, readInt);
                                a2 -= 5;
                            }
                            ((f) bVar2).a(z3, readInt, -1, a(a(a2, readByte2, s), s, readByte2, readInt));
                            break;
                        } else {
                            e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 2:
                        if (a2 != 5) {
                            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(a2));
                            throw null;
                        } else if (readInt != 0) {
                            a(bVar2, readInt);
                            break;
                        } else {
                            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 3:
                        if (a2 != 4) {
                            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(a2));
                            throw null;
                        } else if (readInt != 0) {
                            int readInt2 = this.f9385a.readInt();
                            b a5 = b.a(readInt2);
                            if (a5 != null) {
                                f fVar2 = (f) bVar2;
                                if (!g.this.b(readInt)) {
                                    n d2 = g.this.d(readInt);
                                    if (d2 != null) {
                                        d2.d(a5);
                                        break;
                                    }
                                } else {
                                    g gVar3 = g.this;
                                    ExecutorService executorService2 = gVar3.f9340h;
                                    k kVar = new k(gVar3, "OkHttp %s Push Reset[%s]", new Object[]{gVar3.f9336d, Integer.valueOf(readInt)}, readInt, a5);
                                    executorService2.execute(kVar);
                                    break;
                                }
                            } else {
                                e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
                                throw null;
                            }
                        } else {
                            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
                            throw null;
                        }
                        break;
                    case 4:
                        if (readInt != 0) {
                            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
                            throw null;
                        } else if ((readByte2 & 1) != 0) {
                            if (a2 != 0) {
                                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                                throw null;
                            } else if (((f) bVar2) == null) {
                                throw null;
                            }
                        } else if (a2 % 6 == 0) {
                            s sVar = new s();
                            for (int i2 = 0; i2 < a2; i2 += 6) {
                                short readShort = this.f9385a.readShort();
                                int readInt3 = this.f9385a.readInt();
                                if (readShort != 2) {
                                    if (readShort == 3) {
                                        readShort = 4;
                                    } else if (readShort == 4) {
                                        readShort = 7;
                                        if (readInt3 < 0) {
                                            e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                            throw null;
                                        }
                                    } else if (readShort == 5 && (readInt3 < 16384 || readInt3 > 16777215)) {
                                        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt3));
                                        throw null;
                                    }
                                } else if (!(readInt3 == 0 || readInt3 == 1)) {
                                    e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    throw null;
                                }
                                sVar.a(readShort, readInt3);
                            }
                            ((f) bVar2).a(false, sVar);
                            break;
                        } else {
                            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(a2));
                            throw null;
                        }
                        break;
                    case 5:
                        if (readInt != 0) {
                            if ((readByte2 & 8) != 0) {
                                s = (short) (this.f9385a.readByte() & 255);
                            }
                            g.this.a(this.f9385a.readInt() & Integer.MAX_VALUE, a(a(a2 - 4, readByte2, s), s, readByte2, readInt));
                            break;
                        } else {
                            e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                            throw null;
                        }
                    case 6:
                        if (a2 != 8) {
                            e.b("TYPE_PING length != 8: %s", Integer.valueOf(a2));
                            throw null;
                        } else if (readInt == 0) {
                            int readInt4 = this.f9385a.readInt();
                            int readInt5 = this.f9385a.readInt();
                            f fVar3 = (f) bVar2;
                            if (!((readByte2 & 1) != 0)) {
                                g gVar4 = g.this;
                                ExecutorService executorService3 = g.t;
                                h hVar = new h(gVar4, "OkHttp %s ping %08x%08x", new Object[]{gVar4.f9336d, Integer.valueOf(readInt4), Integer.valueOf(readInt5)}, true, readInt4, readInt5, null);
                                executorService3.execute(hVar);
                                break;
                            } else {
                                q c2 = g.this.c(readInt4);
                                if (c2 != null) {
                                    if (c2.f9431c == -1 && c2.f9430b != -1) {
                                        c2.f9431c = System.nanoTime();
                                        c2.f9429a.countDown();
                                        break;
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                }
                            }
                        } else {
                            e.b("TYPE_PING streamId != 0", new Object[0]);
                            throw null;
                        }
                        break;
                    case 7:
                        if (a2 < 8) {
                            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(a2));
                            throw null;
                        } else if (readInt == 0) {
                            int readInt6 = this.f9385a.readInt();
                            int readInt7 = this.f9385a.readInt();
                            int i3 = a2 - 8;
                            b a6 = b.a(readInt7);
                            if (a6 != null) {
                                h hVar2 = h.f9650e;
                                if (i3 > 0) {
                                    hVar2 = this.f9385a.c((long) i3);
                                }
                                ((f) bVar2).a(readInt6, a6, hVar2);
                                break;
                            } else {
                                e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt7));
                                throw null;
                            }
                        } else {
                            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
                            throw null;
                        }
                    case 8:
                        if (a2 == 4) {
                            long readInt8 = ((long) this.f9385a.readInt()) & 2147483647L;
                            if (readInt8 != 0) {
                                ((f) bVar2).a(readInt, readInt8);
                                break;
                            } else {
                                e.b("windowSizeIncrement was 0", Long.valueOf(readInt8));
                                throw null;
                            }
                        } else {
                            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(a2));
                            throw null;
                        }
                    default:
                        this.f9385a.skip((long) a2);
                        break;
                }
                return true;
            }
            e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    public final List<c> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f9386b;
        aVar.f9393e = i2;
        aVar.f9390b = i2;
        aVar.f9394f = s;
        aVar.f9391c = b2;
        aVar.f9392d = i3;
        g.d0.h.d.a aVar2 = this.f9388d;
        while (!aVar2.f9300b.g()) {
            byte readByte = aVar2.f9300b.readByte() & 255;
            if (readByte == 128) {
                throw new IOException("index == 0");
            } else if ((readByte & 128) == 128) {
                int a2 = aVar2.a((int) readByte, (int) GyroType.INS_WEARABLE_TEST) - 1;
                if (a2 >= 0 && a2 <= d.f9297a.length - 1) {
                    aVar2.f9299a.add(d.f9297a[a2]);
                } else {
                    int a3 = aVar2.a(a2 - d.f9297a.length);
                    if (a3 >= 0) {
                        c[] cVarArr = aVar2.f9303e;
                        if (a3 <= cVarArr.length - 1) {
                            aVar2.f9299a.add(cVarArr[a3]);
                        }
                    }
                    StringBuilder a4 = e.a.a.a.a.a("Header index too large ");
                    a4.append(a2 + 1);
                    throw new IOException(a4.toString());
                }
            } else if (readByte == 64) {
                h b3 = aVar2.b();
                d.a(b3);
                aVar2.a(-1, new c(b3, aVar2.b()));
            } else if ((readByte & 64) == 64) {
                aVar2.a(-1, new c(aVar2.c(aVar2.a((int) readByte, 63) - 1), aVar2.b()));
            } else if ((readByte & 32) == 32) {
                int a5 = aVar2.a((int) readByte, 31);
                aVar2.f9302d = a5;
                if (a5 < 0 || a5 > aVar2.f9301c) {
                    StringBuilder a6 = e.a.a.a.a.a("Invalid dynamic table size update ");
                    a6.append(aVar2.f9302d);
                    throw new IOException(a6.toString());
                }
                int i4 = aVar2.f9306h;
                if (a5 < i4) {
                    if (a5 == 0) {
                        aVar2.a();
                    } else {
                        aVar2.b(i4 - a5);
                    }
                }
            } else if (readByte == 16 || readByte == 0) {
                h b4 = aVar2.b();
                d.a(b4);
                aVar2.f9299a.add(new c(b4, aVar2.b()));
            } else {
                aVar2.f9299a.add(new c(aVar2.c(aVar2.a((int) readByte, 15) - 1), aVar2.b()));
            }
        }
        g.d0.h.d.a aVar3 = this.f9388d;
        if (aVar3 != null) {
            ArrayList arrayList = new ArrayList(aVar3.f9299a);
            aVar3.f9299a.clear();
            return arrayList;
        }
        throw null;
    }

    public final void a(b bVar, int i2) throws IOException {
        int readInt = this.f9385a.readInt() & Integer.MIN_VALUE;
        this.f9385a.readByte();
        if (((f) bVar) == null) {
            throw null;
        }
    }

    public static int a(g gVar) throws IOException {
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    public static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }
}
