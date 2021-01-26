package d.e;

/* compiled from: LongSparseArray */
public class e<E> implements Cloneable {

    /* renamed from: e reason: collision with root package name */
    public static final Object f4569e = new Object();

    /* renamed from: a reason: collision with root package name */
    public boolean f4570a;

    /* renamed from: b reason: collision with root package name */
    public long[] f4571b;

    /* renamed from: c reason: collision with root package name */
    public Object[] f4572c;

    /* renamed from: d reason: collision with root package name */
    public int f4573d;

    public e() {
        this(10);
    }

    public long a(int i2) {
        if (this.f4570a) {
            b();
        }
        return this.f4571b[i2];
    }

    public E b(long j2) {
        return b(j2, null);
    }

    public void c(long j2) {
        int a2 = d.a(this.f4571b, this.f4573d, j2);
        if (a2 >= 0) {
            Object[] objArr = this.f4572c;
            Object obj = objArr[a2];
            Object obj2 = f4569e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f4570a = true;
            }
        }
    }

    public int e() {
        if (this.f4570a) {
            b();
        }
        return this.f4573d;
    }

    public String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4573d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f4573d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(a(i2));
            sb.append('=');
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public e(int i2) {
        this.f4570a = false;
        if (i2 == 0) {
            this.f4571b = d.f4567b;
            this.f4572c = d.f4568c;
            return;
        }
        int c2 = d.c(i2);
        this.f4571b = new long[c2];
        this.f4572c = new Object[c2];
    }

    public E b(long j2, E e2) {
        int a2 = d.a(this.f4571b, this.f4573d, j2);
        if (a2 >= 0) {
            E[] eArr = this.f4572c;
            if (eArr[a2] != f4569e) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f4571b = (long[]) this.f4571b.clone();
            eVar.f4572c = (Object[]) this.f4572c.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean a(long j2) {
        if (this.f4570a) {
            b();
        }
        return d.a(this.f4571b, this.f4573d, j2) >= 0;
    }

    public final void b() {
        int i2 = this.f4573d;
        long[] jArr = this.f4571b;
        Object[] objArr = this.f4572c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f4569e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f4570a = false;
        this.f4573d = i3;
    }

    public void c(long j2, E e2) {
        int a2 = d.a(this.f4571b, this.f4573d, j2);
        if (a2 >= 0) {
            this.f4572c[a2] = e2;
        } else {
            int i2 = ~a2;
            if (i2 < this.f4573d) {
                Object[] objArr = this.f4572c;
                if (objArr[i2] == f4569e) {
                    this.f4571b[i2] = j2;
                    objArr[i2] = e2;
                    return;
                }
            }
            if (this.f4570a && this.f4573d >= this.f4571b.length) {
                b();
                i2 = ~d.a(this.f4571b, this.f4573d, j2);
            }
            int i3 = this.f4573d;
            if (i3 >= this.f4571b.length) {
                int c2 = d.c(i3 + 1);
                long[] jArr = new long[c2];
                Object[] objArr2 = new Object[c2];
                long[] jArr2 = this.f4571b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr3 = this.f4572c;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.f4571b = jArr;
                this.f4572c = objArr2;
            }
            int i4 = this.f4573d;
            if (i4 - i2 != 0) {
                long[] jArr3 = this.f4571b;
                int i5 = i2 + 1;
                System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
                Object[] objArr4 = this.f4572c;
                System.arraycopy(objArr4, i2, objArr4, i5, this.f4573d - i2);
            }
            this.f4571b[i2] = j2;
            this.f4572c[i2] = e2;
            this.f4573d++;
        }
    }

    public void a() {
        int i2 = this.f4573d;
        Object[] objArr = this.f4572c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f4573d = 0;
        this.f4570a = false;
    }

    public void a(long j2, E e2) {
        int i2 = this.f4573d;
        if (i2 == 0 || j2 > this.f4571b[i2 - 1]) {
            if (this.f4570a && this.f4573d >= this.f4571b.length) {
                b();
            }
            int i3 = this.f4573d;
            if (i3 >= this.f4571b.length) {
                int c2 = d.c(i3 + 1);
                long[] jArr = new long[c2];
                Object[] objArr = new Object[c2];
                long[] jArr2 = this.f4571b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f4572c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f4571b = jArr;
                this.f4572c = objArr;
            }
            this.f4571b[i3] = j2;
            this.f4572c[i3] = e2;
            this.f4573d = i3 + 1;
            return;
        }
        c(j2, e2);
    }

    public E b(int i2) {
        if (this.f4570a) {
            b();
        }
        return this.f4572c[i2];
    }

    public boolean c() {
        return e() == 0;
    }
}
