package com.baidu.mobstat;

import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.baidu.mobstat.by.a;
import com.baidu.mobstat.by.b;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ca implements by {

    /* renamed from: a reason: collision with root package name */
    public static final List<cd> f1777a;

    /* renamed from: b reason: collision with root package name */
    public static int f1778b = 16384;

    /* renamed from: c reason: collision with root package name */
    public static boolean f1779c = false;

    /* renamed from: h reason: collision with root package name */
    public static final /* synthetic */ boolean f1780h = (!ca.class.desiredAssertionStatus());

    /* renamed from: d reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f1781d;

    /* renamed from: e reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f1782e;

    /* renamed from: f reason: collision with root package name */
    public SelectionKey f1783f;

    /* renamed from: g reason: collision with root package name */
    public ByteChannel f1784g;

    /* renamed from: i reason: collision with root package name */
    public final cb f1785i;

    /* renamed from: j reason: collision with root package name */
    public volatile boolean f1786j = false;
    public a k = a.NOT_YET_CONNECTED;
    public cd l = null;
    public b m;
    public cq n = null;
    public ByteBuffer o = ByteBuffer.allocate(0);
    public cs p = null;
    public String q = null;
    public Integer r = null;
    public Boolean s = null;
    public String t = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        f1777a = arrayList;
        arrayList.add(new cf());
        f1777a.add(new ce());
    }

    public ca(cb cbVar, cd cdVar) {
        if (cbVar == null || cdVar == null) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f1781d = new LinkedBlockingQueue();
        this.f1782e = new LinkedBlockingQueue();
        this.f1785i = cbVar;
        this.m = b.CLIENT;
        this.l = cdVar.c();
    }

    private boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.o.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.o.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + this.o.capacity());
                this.o.flip();
                allocate.put(this.o);
                this.o = allocate;
            }
            this.o.put(byteBuffer);
            this.o.flip();
            byteBuffer2 = this.o;
        }
        byteBuffer2.mark();
        try {
            if (this.l == null && e(byteBuffer2) == cd.b.MATCHED) {
                try {
                    f(ByteBuffer.wrap(dc.a(this.f1785i.a(this))));
                    a(-3, "");
                } catch (ch unused) {
                    c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                if (this.m == b.CLIENT) {
                    this.l.a(this.m);
                    cx d2 = this.l.d(byteBuffer2);
                    if (!(d2 instanceof cz)) {
                        b(1002, "wrong http function", false);
                        return false;
                    }
                    cz czVar = (cz) d2;
                    if (this.l.a(this.p, czVar) == cd.b.MATCHED) {
                        try {
                            this.f1785i.a((by) this, this.p, czVar);
                            a((cx) czVar);
                            return true;
                        } catch (ch e2) {
                            b(e2.a(), e2.getMessage(), false);
                            return false;
                        } catch (RuntimeException e3) {
                            this.f1785i.a((by) this, (Exception) e3);
                            b(-1, e3.getMessage(), false);
                            return false;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("draft ");
                        sb.append(this.l);
                        sb.append(" refuses handshake");
                        a(1002, sb.toString());
                    }
                }
            } catch (cj e4) {
                a((ch) e4);
            }
            return false;
        } catch (cg e5) {
            if (this.o.capacity() == 0) {
                byteBuffer2.reset();
                int a2 = e5.a();
                if (a2 == 0) {
                    a2 = byteBuffer2.capacity() + 16;
                } else if (!f1780h && e5.a() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(a2);
                this.o = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.o;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.o;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
    }

    private void d(ByteBuffer byteBuffer) {
        try {
            for (cq cqVar : this.l.c(byteBuffer)) {
                if (f1779c) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("matched frame: ");
                    sb.append(cqVar);
                    printStream.println(sb.toString());
                }
                cq.a f2 = cqVar.f();
                boolean d2 = cqVar.d();
                if (this.k != a.CLOSING) {
                    if (f2 == cq.a.CLOSING) {
                        int i2 = 1005;
                        String str = "";
                        if (cqVar instanceof cn) {
                            cn cnVar = (cn) cqVar;
                            i2 = cnVar.a();
                            str = cnVar.b();
                        }
                        if (this.k == a.CLOSING) {
                            a(i2, str, true);
                        } else if (this.l.b() == cd.a.TWOWAY) {
                            c(i2, str, true);
                        } else {
                            b(i2, str, false);
                        }
                    } else if (f2 == cq.a.PING) {
                        this.f1785i.b(this, cqVar);
                    } else if (f2 == cq.a.PONG) {
                        this.f1785i.c(this, cqVar);
                    } else {
                        if (d2) {
                            if (f2 != cq.a.CONTINUOUS) {
                                if (this.n != null) {
                                    throw new ch(1002, "Continuous frame sequence not completed.");
                                } else if (f2 == cq.a.TEXT) {
                                    try {
                                        this.f1785i.a((by) this, dc.a(cqVar.c()));
                                    } catch (RuntimeException e2) {
                                        this.f1785i.a((by) this, (Exception) e2);
                                    }
                                } else if (f2 == cq.a.BINARY) {
                                    try {
                                        this.f1785i.a((by) this, cqVar.c());
                                    } catch (RuntimeException e3) {
                                        this.f1785i.a((by) this, (Exception) e3);
                                    }
                                } else {
                                    throw new ch(1002, "non control or continious frame expected");
                                }
                            }
                        }
                        if (f2 == cq.a.CONTINUOUS) {
                            String str2 = "Continuous frame sequence was not started.";
                            if (d2) {
                                if (this.n != null) {
                                    if (this.n.f() == cq.a.TEXT) {
                                        int max = Math.max(this.n.c().limit() - 64, 0);
                                        this.n.a(cqVar);
                                        if (!dc.a(this.n.c(), max)) {
                                            throw new ch(InstaCameraManager.CAPTURE_TYPE_BURST_CAPTURE);
                                        }
                                    }
                                    this.n = null;
                                } else {
                                    throw new ch(1002, str2);
                                }
                            } else if (this.n == null) {
                                throw new ch(1002, str2);
                            }
                        } else if (this.n == null) {
                            this.n = cqVar;
                        } else {
                            throw new ch(1002, "Previous continuous frame sequence not completed.");
                        }
                        if (f2 == cq.a.TEXT) {
                            if (!dc.b(cqVar.c())) {
                                throw new ch(InstaCameraManager.CAPTURE_TYPE_BURST_CAPTURE);
                            }
                        }
                        if (f2 == cq.a.CONTINUOUS && this.n != null && this.n.f() == cq.a.TEXT) {
                            int max2 = Math.max(this.n.c().limit() - 64, 0);
                            this.n.a(cqVar);
                            if (!dc.a(this.n.c(), max2)) {
                                throw new ch(InstaCameraManager.CAPTURE_TYPE_BURST_CAPTURE);
                            }
                        }
                        try {
                            this.f1785i.a((by) this, cqVar);
                        } catch (RuntimeException e4) {
                            this.f1785i.a((by) this, (Exception) e4);
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (ch e5) {
            this.f1785i.a((by) this, (Exception) e5);
            a(e5);
        }
    }

    private cd.b e(ByteBuffer byteBuffer) throws cg {
        byteBuffer.mark();
        if (byteBuffer.limit() > cd.f1800c.length) {
            return cd.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= cd.f1800c.length) {
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (cd.f1800c[i2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return cd.b.NOT_MATCHED;
                }
                i2++;
            }
            return cd.b.MATCHED;
        }
        throw new cg(cd.f1800c.length);
    }

    private void f(ByteBuffer byteBuffer) {
        if (f1779c) {
            PrintStream printStream = System.out;
            StringBuilder a2 = e.a.a.a.a.a("write(");
            a2.append(byteBuffer.remaining());
            a2.append("): {");
            a2.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            a2.append("}");
            printStream.println(a2.toString());
        }
        this.f1781d.add(byteBuffer);
        this.f1785i.b(this);
    }

    public void a(ByteBuffer byteBuffer) {
        if (f1780h || byteBuffer.hasRemaining()) {
            if (f1779c) {
                PrintStream printStream = System.out;
                StringBuilder a2 = e.a.a.a.a.a("process(");
                a2.append(byteBuffer.remaining());
                a2.append("): {");
                a2.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
                a2.append("}");
                printStream.println(a2.toString());
            }
            if (this.k != a.NOT_YET_CONNECTED) {
                d(byteBuffer);
            } else if (c(byteBuffer)) {
                if (!f1780h && this.o.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                    throw new AssertionError();
                } else if (byteBuffer.hasRemaining()) {
                    d(byteBuffer);
                } else if (this.o.hasRemaining()) {
                    d(this.o);
                }
            }
            if (!f1780h && !d() && !e() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            return;
        }
        throw new AssertionError();
    }

    public void b(int i2, String str) {
        a(i2, str, false);
    }

    public a g() {
        return this.k;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public synchronized void b(int i2, String str, boolean z) {
        if (!this.f1786j) {
            this.r = Integer.valueOf(i2);
            this.q = str;
            this.s = Boolean.valueOf(z);
            this.f1786j = true;
            this.f1785i.b(this);
            try {
                this.f1785i.b(this, i2, str, z);
            } catch (RuntimeException e2) {
                this.f1785i.a((by) this, (Exception) e2);
            }
            if (this.l != null) {
                this.l.a();
            }
            this.p = null;
        }
    }

    public boolean f() {
        return this.k == a.CLOSED;
    }

    public boolean e() {
        return this.f1786j;
    }

    public void a(int i2, String str) {
        c(i2, str, false);
    }

    public synchronized void a(int i2, String str, boolean z) {
        if (this.k != a.CLOSED) {
            if (this.f1783f != null) {
                this.f1783f.cancel();
            }
            if (this.f1784g != null) {
                try {
                    this.f1784g.close();
                } catch (IOException e2) {
                    this.f1785i.a((by) this, (Exception) e2);
                }
            }
            try {
                this.f1785i.a(this, i2, str, z);
            } catch (RuntimeException e3) {
                this.f1785i.a((by) this, (Exception) e3);
            }
            if (this.l != null) {
                this.l.a();
            }
            this.p = null;
            this.k = a.CLOSED;
            this.f1781d.clear();
            return;
        }
        return;
    }

    public void b() {
        if (g() == a.NOT_YET_CONNECTED) {
            a(-1, true);
        } else if (this.f1786j) {
            a(this.r.intValue(), this.q, this.s.booleanValue());
        } else if (this.l.b() == cd.a.NONE) {
            a(1000, true);
        } else if (this.l.b() == cd.a.ONEWAY) {
            a(1000, true);
        } else {
            a(1006, true);
        }
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cm {
        if (byteBuffer != null) {
            a((Collection<cq>) this.l.a(byteBuffer, this.m == b.CLIENT));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    public void a(int i2, boolean z) {
        a(i2, "", z);
    }

    public void a(int i2) {
        c(i2, "", false);
    }

    public void a(ch chVar) {
        c(chVar.a(), chVar.getMessage(), false);
    }

    public void a(byte[] bArr) throws IllegalArgumentException, cm {
        b(ByteBuffer.wrap(bArr));
    }

    private void a(Collection<cq> collection) {
        if (c()) {
            for (cq a2 : collection) {
                a(a2);
            }
            return;
        }
        throw new cm();
    }

    public void a(cq cqVar) {
        if (f1779c) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("send frame: ");
            sb.append(cqVar);
            printStream.println(sb.toString());
        }
        f(this.l.a(cqVar));
    }

    public void a(ct ctVar) throws cj {
        if (f1780h || this.k != a.CONNECTING) {
            this.p = this.l.a(ctVar);
            String a2 = ctVar.a();
            this.t = a2;
            if (f1780h || a2 != null) {
                try {
                    this.f1785i.a((by) this, this.p);
                    a(this.l.a((cx) this.p, this.m));
                } catch (ch unused) {
                    throw new cj("Handshake data rejected by client.");
                } catch (RuntimeException e2) {
                    this.f1785i.a((by) this, (Exception) e2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("rejected because of");
                    sb.append(e2);
                    throw new cj(sb.toString());
                }
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError("shall only be called once");
        }
    }

    private void c(int i2, String str, boolean z) {
        a aVar = this.k;
        if (!(aVar == a.CLOSING || aVar == a.CLOSED)) {
            if (aVar == a.OPEN) {
                if (i2 != 1006) {
                    if (this.l.b() != cd.a.NONE) {
                        if (!z) {
                            try {
                                this.f1785i.a((by) this, i2, str);
                            } catch (RuntimeException e2) {
                                try {
                                    this.f1785i.a((by) this, (Exception) e2);
                                } catch (ch e3) {
                                    this.f1785i.a((by) this, (Exception) e3);
                                    b(1006, "generated frame is invalid", false);
                                }
                            }
                        }
                        a((cq) new co(i2, str));
                    }
                    b(i2, str, z);
                } else if (f1780h || !z) {
                    this.k = a.CLOSING;
                    b(i2, str, false);
                    return;
                } else {
                    throw new AssertionError();
                }
            } else if (i2 != -3) {
                b(-1, str, false);
            } else if (f1780h || z) {
                b(-3, str, true);
            } else {
                throw new AssertionError();
            }
            if (i2 == 1002) {
                b(i2, str, z);
            }
            this.k = a.CLOSING;
            this.o = null;
        }
    }

    private void a(List<ByteBuffer> list) {
        for (ByteBuffer f2 : list) {
            f(f2);
        }
    }

    private void a(cx cxVar) {
        if (f1779c) {
            PrintStream printStream = System.out;
            StringBuilder a2 = e.a.a.a.a.a("open using draft: ");
            a2.append(this.l.getClass().getSimpleName());
            printStream.println(a2.toString());
        }
        this.k = a.OPEN;
        try {
            this.f1785i.a((by) this, cxVar);
        } catch (RuntimeException e2) {
            this.f1785i.a((by) this, (Exception) e2);
        }
    }

    public InetSocketAddress a() {
        return this.f1785i.c(this);
    }

    public boolean d() {
        return this.k == a.CLOSING;
    }

    public boolean c() {
        if (f1780h || this.k != a.OPEN || !this.f1786j) {
            return this.k == a.OPEN;
        }
        throw new AssertionError();
    }
}
