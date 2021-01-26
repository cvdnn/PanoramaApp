package g;

import com.tencent.connect.common.Constants;
import e.c.f.n.n;
import g.r.a.C0141a;

/* compiled from: Request */
public final class x {

    /* renamed from: a reason: collision with root package name */
    public final r f9595a;

    /* renamed from: b reason: collision with root package name */
    public final String f9596b;

    /* renamed from: c reason: collision with root package name */
    public final q f9597c;

    /* renamed from: d reason: collision with root package name */
    public final y f9598d;

    /* renamed from: e reason: collision with root package name */
    public final Object f9599e;

    /* renamed from: f reason: collision with root package name */
    public volatile d f9600f;

    /* compiled from: Request */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public r f9601a;

        /* renamed from: b reason: collision with root package name */
        public String f9602b;

        /* renamed from: c reason: collision with root package name */
        public g.q.a f9603c;

        /* renamed from: d reason: collision with root package name */
        public y f9604d;

        /* renamed from: e reason: collision with root package name */
        public Object f9605e;

        public a() {
            this.f9602b = Constants.HTTP_GET;
            this.f9603c = new g.q.a();
        }

        public a a(r rVar) {
            if (rVar != null) {
                this.f9601a = rVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str, String str2) {
            g.q.a aVar = this.f9603c;
            aVar.b(str, str2);
            aVar.a(str);
            aVar.f9533a.add(str);
            aVar.f9533a.add(str2.trim());
            return this;
        }

        public a a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder a2 = e.a.a.a.a.a("http:");
                    a2.append(str.substring(3));
                    str = a2.toString();
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        StringBuilder a3 = e.a.a.a.a.a("https:");
                        a3.append(str.substring(4));
                        str = a3.toString();
                    }
                }
                g.r.a aVar = new g.r.a();
                r rVar = null;
                if (aVar.a(null, str) == C0141a.SUCCESS) {
                    rVar = aVar.a();
                }
                if (rVar != null) {
                    a(rVar);
                    return this;
                }
                throw new IllegalArgumentException(e.a.a.a.a.a("unexpected url: ", str));
            }
            throw new NullPointerException("url == null");
        }

        public a(x xVar) {
            this.f9601a = xVar.f9595a;
            this.f9602b = xVar.f9596b;
            this.f9604d = xVar.f9598d;
            this.f9605e = xVar.f9599e;
            this.f9603c = xVar.f9597c.a();
        }

        public a b() {
            a(Constants.HTTP_GET, (y) null);
            return this;
        }

        public a a(String str, String str2) {
            g.q.a aVar = this.f9603c;
            aVar.b(str, str2);
            aVar.f9533a.add(str);
            aVar.f9533a.add(str2.trim());
            return this;
        }

        public a a(String str, y yVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() != 0) {
                String str2 = "method ";
                if (yVar != null && !n.b(str)) {
                    throw new IllegalArgumentException(e.a.a.a.a.a(str2, str, " must not have a request body."));
                } else if (yVar != null || !n.c(str)) {
                    this.f9602b = str;
                    this.f9604d = yVar;
                    return this;
                } else {
                    throw new IllegalArgumentException(e.a.a.a.a.a(str2, str, " must have a request body."));
                }
            } else {
                throw new IllegalArgumentException("method.length() == 0");
            }
        }

        public x a() {
            if (this.f9601a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public x(a aVar) {
        this.f9595a = aVar.f9601a;
        this.f9596b = aVar.f9602b;
        g.q.a aVar2 = aVar.f9603c;
        if (aVar2 != null) {
            this.f9597c = new q(aVar2);
            this.f9598d = aVar.f9604d;
            Object obj = aVar.f9605e;
            if (obj == 0) {
                obj = this;
            }
            this.f9599e = obj;
            return;
        }
        throw null;
    }

    public d a() {
        d dVar = this.f9600f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f9597c);
        this.f9600f = a2;
        return a2;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Request{method=");
        a2.append(this.f9596b);
        a2.append(", url=");
        a2.append(this.f9595a);
        a2.append(", tag=");
        Object obj = this.f9599e;
        if (obj == this) {
            obj = null;
        }
        a2.append(obj);
        a2.append('}');
        return a2.toString();
    }
}
