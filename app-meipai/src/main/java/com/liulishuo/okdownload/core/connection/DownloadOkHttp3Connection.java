package com.liulishuo.okdownload.core.connection;

import e.c.f.n.n;
import e.i.a.h.f.a.C0121a;
import e.i.a.h.f.a.b;
import g.a0;
import g.u;
import g.x;
import g.y;
import g.z;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

public class DownloadOkHttp3Connection implements e.i.a.h.f.a, C0121a {

    /* renamed from: a reason: collision with root package name */
    public final u f3545a;

    /* renamed from: b reason: collision with root package name */
    public final g.x.a f3546b;

    /* renamed from: c reason: collision with root package name */
    public x f3547c;

    /* renamed from: d reason: collision with root package name */
    public z f3548d;

    public static class a implements b {

        /* renamed from: a reason: collision with root package name */
        public u.b f3549a;

        /* renamed from: b reason: collision with root package name */
        public volatile u f3550b;

        public e.i.a.h.f.a a(String str) throws IOException {
            u uVar;
            if (this.f3550b == null) {
                synchronized (a.class) {
                    if (this.f3550b == null) {
                        if (this.f3549a != null) {
                            u.b bVar = this.f3549a;
                            if (bVar != null) {
                                uVar = new u(bVar);
                            } else {
                                throw null;
                            }
                        } else {
                            uVar = new u();
                        }
                        this.f3550b = uVar;
                        this.f3549a = null;
                    }
                }
            }
            return new DownloadOkHttp3Connection(this.f3550b, str);
        }
    }

    public DownloadOkHttp3Connection(u uVar, String str) {
        g.x.a aVar = new g.x.a();
        aVar.a(str);
        this.f3545a = uVar;
        this.f3546b = aVar;
    }

    public void a(String str, String str2) {
        this.f3546b.a(str, str2);
    }

    public InputStream b() throws IOException {
        z zVar = this.f3548d;
        if (zVar != null) {
            a0 a0Var = zVar.f9620g;
            if (a0Var != null) {
                return a0Var.byteStream();
            }
            throw new IOException("no body found on response!");
        }
        throw new IOException("Please invoke execute first!");
    }

    public Map<String, List<String>> c() {
        z zVar = this.f3548d;
        if (zVar == null) {
            return null;
        }
        return zVar.f9619f.c();
    }

    public C0121a d() throws IOException {
        x a2 = this.f3546b.a();
        this.f3547c = a2;
        this.f3548d = this.f3545a.a(a2).d();
        return this;
    }

    public Map<String, List<String>> e() {
        x xVar = this.f3547c;
        if (xVar != null) {
            return xVar.f9597c.c();
        }
        return this.f3546b.a().f9597c.c();
    }

    public int f() throws IOException {
        z zVar = this.f3548d;
        if (zVar != null) {
            return zVar.f9616c;
        }
        throw new IOException("Please invoke execute first!");
    }

    public void release() {
        this.f3547c = null;
        z zVar = this.f3548d;
        if (zVar != null) {
            zVar.close();
        }
        this.f3548d = null;
    }

    public String a(String str) {
        z zVar = this.f3548d;
        if (zVar == null) {
            return null;
        }
        String a2 = zVar.f9619f.a(str);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public String a() {
        z zVar = this.f3548d;
        z zVar2 = zVar.f9623j;
        if (zVar2 != null) {
            int i2 = zVar.f9616c;
            if ((i2 >= 200 && i2 < 300) && n.b(zVar2.f9616c)) {
                return this.f3548d.f9614a.f9595a.f9542h;
            }
        }
        return null;
    }

    public boolean b(String str) throws ProtocolException {
        this.f3546b.a(str, (y) null);
        return true;
    }
}
