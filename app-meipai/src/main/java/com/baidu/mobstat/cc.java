package com.baidu.mobstat;

import com.baidubce.BceConfig;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

public abstract class cc extends bz implements by, Runnable {

    /* renamed from: c reason: collision with root package name */
    public static final /* synthetic */ boolean f1787c = (!cc.class.desiredAssertionStatus());

    /* renamed from: a reason: collision with root package name */
    public ca f1788a = null;

    /* renamed from: b reason: collision with root package name */
    public URI f1789b = null;

    /* renamed from: d reason: collision with root package name */
    public Socket f1790d = null;

    /* renamed from: e reason: collision with root package name */
    public InputStream f1791e;

    /* renamed from: f reason: collision with root package name */
    public OutputStream f1792f;

    /* renamed from: g reason: collision with root package name */
    public Proxy f1793g = Proxy.NO_PROXY;

    /* renamed from: h reason: collision with root package name */
    public Thread f1794h;

    /* renamed from: i reason: collision with root package name */
    public cd f1795i;

    /* renamed from: j reason: collision with root package name */
    public Map<String, String> f1796j;
    public CountDownLatch k = new CountDownLatch(1);
    public CountDownLatch l = new CountDownLatch(1);
    public int m = 0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) cc.this.f1788a.f1781d.take();
                    cc.this.f1792f.write(byteBuffer.array(), 0, byteBuffer.limit());
                    cc.this.f1792f.flush();
                } catch (IOException unused) {
                    cc.this.f1788a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i2) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (cdVar != null) {
            this.f1789b = uri;
            this.f1795i = cdVar;
            this.f1796j = map;
            this.m = i2;
            this.f1788a = new ca(this, cdVar);
        } else {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
    }

    private int h() {
        int port = this.f1789b.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.f1789b.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException(e.a.a.a.a.a("unknown scheme: ", scheme));
    }

    private void i() throws cj {
        String rawPath = this.f1789b.getRawPath();
        String rawQuery = this.f1789b.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = BceConfig.BOS_DELIMITER;
        }
        if (rawQuery != null) {
            rawPath = e.a.a.a.a.a(rawPath, "?", rawQuery);
        }
        int h2 = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1789b.getHost());
        sb.append(h2 != 80 ? e.a.a.a.a.a(Config.TRACE_TODAY_VISIT_SPLIT, h2) : "");
        String sb2 = sb.toString();
        cv cvVar = new cv();
        cvVar.a(rawPath);
        cvVar.a(Headers.HOST, sb2);
        Map<String, String> map = this.f1796j;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                cvVar.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f1788a.a((ct) cvVar);
    }

    public void a(int i2, String str) {
    }

    public abstract void a(int i2, String str, boolean z);

    public abstract void a(cz czVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(int i2, String str, boolean z) {
    }

    public final void b(by byVar) {
    }

    public void b(cq cqVar) {
    }

    public boolean c() throws InterruptedException {
        b();
        this.k.await();
        return this.f1788a.c();
    }

    public void d() {
        if (this.f1794h != null) {
            this.f1788a.a(1000);
        }
    }

    public boolean e() {
        return this.f1788a.e();
    }

    public boolean f() {
        return this.f1788a.f();
    }

    public boolean g() {
        return this.f1788a.d();
    }

    public void run() {
        try {
            if (this.f1790d == null) {
                this.f1790d = new Socket(this.f1793g);
            } else if (this.f1790d.isClosed()) {
                throw new IOException();
            }
            if (!this.f1790d.isBound()) {
                this.f1790d.connect(new InetSocketAddress(this.f1789b.getHost(), h()), this.m);
            }
            this.f1791e = this.f1790d.getInputStream();
            this.f1792f = this.f1790d.getOutputStream();
            i();
            Thread thread = new Thread(new a());
            this.f1794h = thread;
            thread.start();
            byte[] bArr = new byte[ca.f1778b];
            while (!g() && !f()) {
                try {
                    int read = this.f1791e.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    this.f1788a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f1788a.b();
                } catch (RuntimeException e2) {
                    a((Exception) e2);
                    this.f1788a.b(1006, e2.getMessage());
                }
            }
            this.f1788a.b();
            if (!f1787c && !this.f1790d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a((by) this.f1788a, e3);
            this.f1788a.b(-1, e3.getMessage());
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f1788a.a(bArr);
    }

    public void b() {
        if (this.f1794h == null) {
            Thread thread = new Thread(this);
            this.f1794h = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public final void a(by byVar, String str) {
        a(str);
    }

    public final void a(by byVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    public InetSocketAddress c(by byVar) {
        Socket socket = this.f1790d;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public void a(by byVar, cq cqVar) {
        b(cqVar);
    }

    public final void a(by byVar, cx cxVar) {
        a((cz) cxVar);
        this.k.countDown();
    }

    public void b(by byVar, int i2, String str, boolean z) {
        b(i2, str, z);
    }

    public final void a(by byVar, int i2, String str, boolean z) {
        Thread thread = this.f1794h;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            if (this.f1790d != null) {
                this.f1790d.close();
            }
        } catch (IOException e2) {
            a((by) this, (Exception) e2);
        }
        a(i2, str, z);
        this.k.countDown();
        this.l.countDown();
    }

    public final void a(by byVar, Exception exc) {
        a(exc);
    }

    public void a(by byVar, int i2, String str) {
        a(i2, str);
    }

    public void a(Socket socket) {
        if (this.f1790d == null) {
            this.f1790d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void a(cq cqVar) {
        this.f1788a.a(cqVar);
    }

    public InetSocketAddress a() {
        return this.f1788a.a();
    }
}
