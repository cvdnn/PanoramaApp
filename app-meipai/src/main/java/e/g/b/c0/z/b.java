package e.g.b.c0.z;

import e.g.b.e0.c;
import e.g.b.l;
import e.g.b.o;
import e.g.b.q;
import e.g.b.r;
import e.g.b.t;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class b extends c {
    public static final Writer o = new a();
    public static final t p = new t("closed");
    public final List<o> l = new ArrayList();
    public String m;
    public o n = q.f8584a;

    /* compiled from: JsonTreeWriter */
    public static class a extends Writer {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public b() {
        super(o);
    }

    public final void a(o oVar) {
        if (this.m != null) {
            if (oVar != null) {
                if (!(oVar instanceof q) || this.f8569i) {
                    r rVar = (r) q();
                    String str = this.m;
                    if (rVar != null) {
                        rVar.f8585a.put(str, oVar);
                    } else {
                        throw null;
                    }
                }
                this.m = null;
                return;
            }
            throw null;
        } else if (this.l.isEmpty()) {
            this.n = oVar;
        } else {
            o q = q();
            if (q instanceof l) {
                l lVar = (l) q;
                if (lVar != null) {
                    if (oVar == null) {
                        oVar = q.f8584a;
                    }
                    lVar.f8583a.add(oVar);
                    return;
                }
                throw null;
            }
            throw new IllegalStateException();
        }
    }

    public c b() throws IOException {
        l lVar = new l();
        a((o) lVar);
        this.l.add(lVar);
        return this;
    }

    public void close() throws IOException {
        if (this.l.isEmpty()) {
            this.l.add(p);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        r rVar = new r();
        a((o) rVar);
        this.l.add(rVar);
        return this;
    }

    public c e() throws IOException {
        if (this.l.isEmpty() || this.m != null) {
            throw new IllegalStateException();
        } else if (q() instanceof l) {
            List<o> list = this.l;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void flush() throws IOException {
    }

    public c i() throws IOException {
        if (this.l.isEmpty() || this.m != null) {
            throw new IllegalStateException();
        } else if (q() instanceof r) {
            List<o> list = this.l;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c m() throws IOException {
        a((o) q.f8584a);
        return this;
    }

    public final o q() {
        List<o> list = this.l;
        return (o) list.get(list.size() - 1);
    }

    public c d(String str) throws IOException {
        if (str == null) {
            a((o) q.f8584a);
            return this;
        }
        a((o) new t(str));
        return this;
    }

    public c a(String str) throws IOException {
        if (this.l.isEmpty() || this.m != null) {
            throw new IllegalStateException();
        } else if (q() instanceof r) {
            this.m = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            a((o) q.f8584a);
            return this;
        }
        a((o) new t(bool));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            a((o) q.f8584a);
            return this;
        }
        if (!this.f8566f) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSON forbids NaN and infinities: ");
                sb.append(number);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        a((o) new t(number));
        return this;
    }

    public c a(boolean z) throws IOException {
        a((o) new t(Boolean.valueOf(z)));
        return this;
    }

    public c a(long j2) throws IOException {
        a((o) new t((Number) Long.valueOf(j2)));
        return this;
    }
}
