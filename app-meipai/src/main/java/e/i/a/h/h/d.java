package e.i.a.h.h;

import e.i.a.h.i.b;
import e.i.a.h.i.c;
import e.i.a.h.i.e;
import e.i.a.h.i.i;
import e.i.a.h.j.f;
import java.io.IOException;
import java.net.SocketException;

/* compiled from: DownloadCache */
public class d {

    /* renamed from: a reason: collision with root package name */
    public String f8822a;

    /* renamed from: b reason: collision with root package name */
    public final f f8823b;

    /* renamed from: c reason: collision with root package name */
    public volatile boolean f8824c;

    /* renamed from: d reason: collision with root package name */
    public volatile boolean f8825d;

    /* renamed from: e reason: collision with root package name */
    public volatile boolean f8826e;

    /* renamed from: f reason: collision with root package name */
    public volatile boolean f8827f = true;

    /* renamed from: g reason: collision with root package name */
    public volatile boolean f8828g;

    /* renamed from: h reason: collision with root package name */
    public volatile boolean f8829h;

    /* renamed from: i reason: collision with root package name */
    public volatile IOException f8830i;

    /* compiled from: DownloadCache */
    public static class a extends d {
        public a(IOException iOException) {
            super(null);
            this.f8830i = iOException;
        }
    }

    public d(f fVar) {
        this.f8823b = fVar;
    }

    public f a() {
        f fVar = this.f8823b;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException();
    }

    public boolean b() {
        return this.f8824c || this.f8825d || this.f8826e || this.f8827f || this.f8828g || this.f8829h;
    }

    public void a(IOException iOException) {
        if (!this.f8825d) {
            if (iOException instanceof e.i.a.h.i.f) {
                this.f8824c = true;
                this.f8830i = iOException;
            } else if (iOException instanceof i) {
                this.f8826e = true;
                this.f8830i = iOException;
            } else if (iOException == b.f8855a) {
                this.f8828g = true;
            } else if (iOException instanceof e) {
                this.f8829h = true;
                this.f8830i = iOException;
            } else if (iOException != c.f8856a) {
                this.f8827f = true;
                this.f8830i = iOException;
                if (!(iOException instanceof SocketException)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("catch unknown error ");
                    sb.append(iOException);
                    e.i.a.h.c.a("DownloadCache", sb.toString());
                }
            }
        }
    }
}
