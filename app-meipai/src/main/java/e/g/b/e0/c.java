package e.g.b.e0;

import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
public class c implements Closeable, Flushable {

    /* renamed from: j reason: collision with root package name */
    public static final String[] f8560j = new String[128];
    public static final String[] k;

    /* renamed from: a reason: collision with root package name */
    public final Writer f8561a;

    /* renamed from: b reason: collision with root package name */
    public int[] f8562b = new int[32];

    /* renamed from: c reason: collision with root package name */
    public int f8563c = 0;

    /* renamed from: d reason: collision with root package name */
    public String f8564d;

    /* renamed from: e reason: collision with root package name */
    public String f8565e;

    /* renamed from: f reason: collision with root package name */
    public boolean f8566f;

    /* renamed from: g reason: collision with root package name */
    public boolean f8567g;

    /* renamed from: h reason: collision with root package name */
    public String f8568h;

    /* renamed from: i reason: collision with root package name */
    public boolean f8569i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f8560j[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f8560j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f8565e = Config.TRACE_TODAY_VISIT_SPLIT;
        this.f8569i = true;
        if (writer != null) {
            this.f8561a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final c a(int i2, int i3, String str) throws IOException {
        int q = q();
        if (q != i3 && q != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f8568h == null) {
            this.f8563c--;
            if (q == i3) {
                l();
            }
            this.f8561a.write(str);
            return this;
        } else {
            StringBuilder a2 = a.a("Dangling name: ");
            a2.append(this.f8568h);
            throw new IllegalStateException(a2.toString());
        }
    }

    public c b() throws IOException {
        r();
        a();
        a(1);
        this.f8561a.write("[");
        return this;
    }

    public void close() throws IOException {
        this.f8561a.close();
        int i2 = this.f8563c;
        if (i2 > 1 || (i2 == 1 && this.f8562b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f8563c = 0;
    }

    public c d() throws IOException {
        r();
        a();
        a(3);
        this.f8561a.write("{");
        return this;
    }

    public c e() throws IOException {
        a(1, 2, "]");
        return this;
    }

    public void flush() throws IOException {
        if (this.f8563c != 0) {
            this.f8561a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c i() throws IOException {
        a(3, 5, "}");
        return this;
    }

    public final void l() throws IOException {
        if (this.f8564d != null) {
            this.f8561a.write("\n");
            int i2 = this.f8563c;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f8561a.write(this.f8564d);
            }
        }
    }

    public c m() throws IOException {
        if (this.f8568h != null) {
            if (this.f8569i) {
                r();
            } else {
                this.f8568h = null;
                return this;
            }
        }
        a();
        this.f8561a.write("null");
        return this;
    }

    public final int q() {
        int i2 = this.f8563c;
        if (i2 != 0) {
            return this.f8562b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void r() throws IOException {
        if (this.f8568h != null) {
            int q = q();
            if (q == 5) {
                this.f8561a.write(44);
            } else if (q != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            l();
            b(4);
            b(this.f8568h);
            this.f8568h = null;
        }
    }

    public final void b(int i2) {
        this.f8562b[this.f8563c - 1] = i2;
    }

    public c d(String str) throws IOException {
        if (str == null) {
            return m();
        }
        r();
        a();
        b(str);
        return this;
    }

    public final void b(String str) throws IOException {
        String str2;
        String[] strArr = this.f8567g ? k : f8560j;
        String str3 = "\"";
        this.f8561a.write(str3);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f8561a.write(str, i2, i3 - i2);
            }
            this.f8561a.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f8561a.write(str, i2, length - i2);
        }
        this.f8561a.write(str3);
    }

    public final void a(int i2) {
        int i3 = this.f8563c;
        int[] iArr = this.f8562b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f8562b = iArr2;
        }
        int[] iArr3 = this.f8562b;
        int i4 = this.f8563c;
        this.f8563c = i4 + 1;
        iArr3[i4] = i2;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f8568h != null) {
            throw new IllegalStateException();
        } else if (this.f8563c != 0) {
            this.f8568h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public c a(boolean z) throws IOException {
        r();
        a();
        this.f8561a.write(z ? "true" : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return m();
        }
        r();
        a();
        this.f8561a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c a(long j2) throws IOException {
        r();
        a();
        this.f8561a.write(Long.toString(j2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        r();
        String obj = number.toString();
        if (this.f8566f || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            a();
            this.f8561a.append(obj);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Numeric values must be finite, but was ");
        sb.append(number);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void a() throws IOException {
        int q = q();
        if (q == 1) {
            b(2);
            l();
        } else if (q == 2) {
            this.f8561a.append(',');
            l();
        } else if (q != 4) {
            if (q != 6) {
                if (q != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f8566f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.f8561a.append(this.f8565e);
            b(5);
        }
    }
}
