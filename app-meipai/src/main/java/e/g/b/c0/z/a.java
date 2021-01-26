package e.g.b.c0.z;

import e.g.b.e0.b;
import e.g.b.l;
import e.g.b.q;
import e.g.b.r;
import e.g.b.t;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: JsonTreeReader */
public final class a extends e.g.b.e0.a {
    public static final Object u = new Object();
    public Object[] q;
    public int r;
    public String[] s;
    public int[] t;

    /* renamed from: e.g.b.c0.z.a$a reason: collision with other inner class name */
    /* compiled from: JsonTreeReader */
    public static class C0117a extends Reader {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        new C0117a();
    }

    private String r() {
        StringBuilder a2 = e.a.a.a.a.a(" at path ");
        a2.append(m());
        return a2.toString();
    }

    public b A() throws IOException {
        if (this.r == 0) {
            return b.END_DOCUMENT;
        }
        Object E = E();
        if (E instanceof Iterator) {
            boolean z = this.q[this.r - 2] instanceof r;
            Iterator it = (Iterator) E;
            if (!it.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            } else if (z) {
                return b.NAME;
            } else {
                a(it.next());
                return A();
            }
        } else if (E instanceof r) {
            return b.BEGIN_OBJECT;
        } else {
            if (E instanceof l) {
                return b.BEGIN_ARRAY;
            }
            if (E instanceof t) {
                Object obj = ((t) E).f8587a;
                if (obj instanceof String) {
                    return b.STRING;
                }
                if (obj instanceof Boolean) {
                    return b.BOOLEAN;
                }
                if (obj instanceof Number) {
                    return b.NUMBER;
                }
                throw new AssertionError();
            } else if (E instanceof q) {
                return b.NULL;
            } else {
                if (E == u) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void D() throws IOException {
        String str = "null";
        if (A() == b.NAME) {
            w();
            this.s[this.r - 2] = str;
        } else {
            F();
            int i2 = this.r;
            if (i2 > 0) {
                this.s[i2 - 1] = str;
            }
        }
        int i3 = this.r;
        if (i3 > 0) {
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public final Object E() {
        return this.q[this.r - 1];
    }

    public final Object F() {
        Object[] objArr = this.q;
        int i2 = this.r - 1;
        this.r = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    public void a() throws IOException {
        a(b.BEGIN_ARRAY);
        a((Object) ((l) E()).iterator());
        this.t[this.r - 1] = 0;
    }

    public void b() throws IOException {
        a(b.BEGIN_OBJECT);
        a((Object) ((r) E()).f8585a.entrySet().iterator());
    }

    public void close() throws IOException {
        this.q = new Object[]{u};
        this.r = 1;
    }

    public void i() throws IOException {
        a(b.END_ARRAY);
        F();
        F();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public void l() throws IOException {
        a(b.END_OBJECT);
        F();
        F();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String m() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.r) {
            Object[] objArr = this.q;
            if (objArr[i2] instanceof l) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.t[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof r) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.s;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    public boolean q() throws IOException {
        b A = A();
        return (A == b.END_OBJECT || A == b.END_ARRAY) ? false : true;
    }

    public boolean s() throws IOException {
        a(b.BOOLEAN);
        boolean a2 = ((t) F()).a();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return a2;
    }

    public double t() throws IOException {
        b A = A();
        if (A == b.NUMBER || A == b.STRING) {
            t tVar = (t) E();
            double doubleValue = tVar.f8587a instanceof Number ? tVar.h().doubleValue() : Double.parseDouble(tVar.g());
            if (this.f8541b || (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue))) {
                F();
                int i2 = this.r;
                if (i2 > 0) {
                    int[] iArr = this.t;
                    int i3 = i2 - 1;
                    iArr[i3] = iArr[i3] + 1;
                }
                return doubleValue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JSON forbids NaN and infinities: ");
            sb.append(doubleValue);
            throw new NumberFormatException(sb.toString());
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected ");
        a2.append(b.NUMBER);
        a2.append(" but was ");
        a2.append(A);
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public String toString() {
        return a.class.getSimpleName();
    }

    public int u() throws IOException {
        b A = A();
        if (A == b.NUMBER || A == b.STRING) {
            int c2 = ((t) E()).c();
            F();
            int i2 = this.r;
            if (i2 > 0) {
                int[] iArr = this.t;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return c2;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected ");
        a2.append(b.NUMBER);
        a2.append(" but was ");
        a2.append(A);
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public long v() throws IOException {
        b A = A();
        if (A == b.NUMBER || A == b.STRING) {
            t tVar = (t) E();
            long longValue = tVar.f8587a instanceof Number ? tVar.h().longValue() : Long.parseLong(tVar.g());
            F();
            int i2 = this.r;
            if (i2 > 0) {
                int[] iArr = this.t;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return longValue;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected ");
        a2.append(b.NUMBER);
        a2.append(" but was ");
        a2.append(A);
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public String w() throws IOException {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) E()).next();
        String str = (String) entry.getKey();
        this.s[this.r - 1] = str;
        a(entry.getValue());
        return str;
    }

    public void x() throws IOException {
        a(b.NULL);
        F();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String y() throws IOException {
        b A = A();
        if (A == b.STRING || A == b.NUMBER) {
            String g2 = ((t) F()).g();
            int i2 = this.r;
            if (i2 > 0) {
                int[] iArr = this.t;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return g2;
        }
        StringBuilder a2 = e.a.a.a.a.a("Expected ");
        a2.append(b.STRING);
        a2.append(" but was ");
        a2.append(A);
        a2.append(r());
        throw new IllegalStateException(a2.toString());
    }

    public final void a(b bVar) throws IOException {
        if (A() != bVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(bVar);
            sb.append(" but was ");
            sb.append(A());
            sb.append(r());
            throw new IllegalStateException(sb.toString());
        }
    }

    public final void a(Object obj) {
        int i2 = this.r;
        Object[] objArr = this.q;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[(i2 * 2)];
            int[] iArr = new int[(i2 * 2)];
            String[] strArr = new String[(i2 * 2)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.t, 0, iArr, 0, this.r);
            System.arraycopy(this.s, 0, strArr, 0, this.r);
            this.q = objArr2;
            this.t = iArr;
            this.s = strArr;
        }
        Object[] objArr3 = this.q;
        int i3 = this.r;
        this.r = i3 + 1;
        objArr3[i3] = obj;
    }
}
