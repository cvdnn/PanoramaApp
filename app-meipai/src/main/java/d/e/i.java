package d.e;

/* compiled from: SparseArrayCompat */
public class i<E> implements Cloneable {

    /* renamed from: e reason: collision with root package name */
    public static final Object f4603e = new Object();

    /* renamed from: a reason: collision with root package name */
    public boolean f4604a;

    /* renamed from: b reason: collision with root package name */
    public int[] f4605b;

    /* renamed from: c reason: collision with root package name */
    public Object[] f4606c;

    /* renamed from: d reason: collision with root package name */
    public int f4607d;

    public i() {
        this(10);
    }

    public E a(int i2) {
        return b(i2, null);
    }

    public E b(int i2, E e2) {
        int a2 = d.a(this.f4605b, this.f4607d, i2);
        if (a2 >= 0) {
            E[] eArr = this.f4606c;
            if (eArr[a2] != f4603e) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public void c(int i2) {
        int a2 = d.a(this.f4605b, this.f4607d, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f4606c;
            Object obj = objArr[a2];
            Object obj2 = f4603e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f4604a = true;
            }
        }
    }

    public E d(int i2) {
        if (this.f4604a) {
            a();
        }
        return this.f4606c[i2];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4607d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f4607d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(b(i2));
            sb.append('=');
            Object d2 = d(i2);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public i(int i2) {
        this.f4604a = false;
        if (i2 == 0) {
            this.f4605b = d.f4566a;
            this.f4606c = d.f4568c;
            return;
        }
        int b2 = d.b(i2);
        this.f4605b = new int[b2];
        this.f4606c = new Object[b2];
    }

    public final void a() {
        int i2 = this.f4607d;
        int[] iArr = this.f4605b;
        Object[] objArr = this.f4606c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f4603e) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f4604a = false;
        this.f4607d = i3;
    }

    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f4605b = (int[]) this.f4605b.clone();
            iVar.f4606c = (Object[]) this.f4606c.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int b() {
        if (this.f4604a) {
            a();
        }
        return this.f4607d;
    }

    public void c(int i2, E e2) {
        int a2 = d.a(this.f4605b, this.f4607d, i2);
        if (a2 >= 0) {
            this.f4606c[a2] = e2;
        } else {
            int i3 = ~a2;
            if (i3 < this.f4607d) {
                Object[] objArr = this.f4606c;
                if (objArr[i3] == f4603e) {
                    this.f4605b[i3] = i2;
                    objArr[i3] = e2;
                    return;
                }
            }
            if (this.f4604a && this.f4607d >= this.f4605b.length) {
                a();
                i3 = ~d.a(this.f4605b, this.f4607d, i2);
            }
            int i4 = this.f4607d;
            if (i4 >= this.f4605b.length) {
                int b2 = d.b(i4 + 1);
                int[] iArr = new int[b2];
                Object[] objArr2 = new Object[b2];
                int[] iArr2 = this.f4605b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr3 = this.f4606c;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.f4605b = iArr;
                this.f4606c = objArr2;
            }
            int i5 = this.f4607d;
            if (i5 - i3 != 0) {
                int[] iArr3 = this.f4605b;
                int i6 = i3 + 1;
                System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
                Object[] objArr4 = this.f4606c;
                System.arraycopy(objArr4, i3, objArr4, i6, this.f4607d - i3);
            }
            this.f4605b[i3] = i2;
            this.f4606c[i3] = e2;
            this.f4607d++;
        }
    }

    public int b(int i2) {
        if (this.f4604a) {
            a();
        }
        return this.f4605b[i2];
    }

    public void a(int i2, E e2) {
        int i3 = this.f4607d;
        if (i3 == 0 || i2 > this.f4605b[i3 - 1]) {
            if (this.f4604a && this.f4607d >= this.f4605b.length) {
                a();
            }
            int i4 = this.f4607d;
            if (i4 >= this.f4605b.length) {
                int b2 = d.b(i4 + 1);
                int[] iArr = new int[b2];
                Object[] objArr = new Object[b2];
                int[] iArr2 = this.f4605b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f4606c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f4605b = iArr;
                this.f4606c = objArr;
            }
            this.f4605b[i4] = i2;
            this.f4606c[i4] = e2;
            this.f4607d = i4 + 1;
            return;
        }
        c(i2, e2);
    }
}
