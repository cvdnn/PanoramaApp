package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ArraySet */
public final class c<E> implements Collection<E>, Set<E> {

    /* renamed from: e reason: collision with root package name */
    public static final int[] f4556e = new int[0];

    /* renamed from: f reason: collision with root package name */
    public static final Object[] f4557f = new Object[0];

    /* renamed from: g reason: collision with root package name */
    public static Object[] f4558g;

    /* renamed from: h reason: collision with root package name */
    public static int f4559h;

    /* renamed from: i reason: collision with root package name */
    public static Object[] f4560i;

    /* renamed from: j reason: collision with root package name */
    public static int f4561j;

    /* renamed from: a reason: collision with root package name */
    public int[] f4562a = f4556e;

    /* renamed from: b reason: collision with root package name */
    public Object[] f4563b = f4557f;

    /* renamed from: c reason: collision with root package name */
    public int f4564c = 0;

    /* renamed from: d reason: collision with root package name */
    public g<E, E> f4565d;

    public final int a(Object obj, int i2) {
        int i3 = this.f4564c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = d.a(this.f4562a, i3, i2);
        if (a2 < 0 || obj.equals(this.f4563b[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f4562a[i4] == i2) {
            if (obj.equals(this.f4563b[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f4562a[i5] == i2) {
            if (obj.equals(this.f4563b[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f4564c;
        if (i5 >= this.f4562a.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f4562a;
            Object[] objArr = this.f4563b;
            a(i6);
            int[] iArr2 = this.f4562a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f4563b, 0, objArr.length);
            }
            a(iArr, objArr, this.f4564c);
        }
        int i7 = this.f4564c;
        if (i4 < i7) {
            int[] iArr3 = this.f4562a;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f4563b;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f4564c - i4);
        }
        this.f4562a[i4] = i2;
        this.f4563b[i4] = e2;
        this.f4564c++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f4564c;
        int[] iArr = this.f4562a;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f4563b;
            a(size);
            int i2 = this.f4564c;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f4562a, 0, i2);
                System.arraycopy(objArr, 0, this.f4563b, 0, this.f4564c);
            }
            a(iArr, objArr, this.f4564c);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public E b(int i2) {
        E[] eArr = this.f4563b;
        E e2 = eArr[i2];
        int i3 = this.f4564c;
        if (i3 <= 1) {
            a(this.f4562a, eArr, i3);
            this.f4562a = f4556e;
            this.f4563b = f4557f;
            this.f4564c = 0;
        } else {
            int[] iArr = this.f4562a;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = this.f4564c - 1;
                this.f4564c = i5;
                if (i2 < i5) {
                    int[] iArr2 = this.f4562a;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr = this.f4563b;
                    System.arraycopy(objArr, i6, objArr, i2, this.f4564c - i2);
                }
                this.f4563b[this.f4564c] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f4562a;
                Object[] objArr2 = this.f4563b;
                a(i4);
                this.f4564c--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f4562a, 0, i2);
                    System.arraycopy(objArr2, 0, this.f4563b, 0, i2);
                }
                int i7 = this.f4564c;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f4562a, i2, i7 - i2);
                    System.arraycopy(objArr2, i8, this.f4563b, i2, this.f4564c - i2);
                }
            }
        }
        return e2;
    }

    public void clear() {
        int i2 = this.f4564c;
        if (i2 != 0) {
            a(this.f4562a, this.f4563b, i2);
            this.f4562a = f4556e;
            this.f4563b = f4557f;
            this.f4564c = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f4564c != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f4564c) {
                try {
                    if (!set.contains(this.f4563b[i2])) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f4562a;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4564c; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f4564c <= 0;
    }

    public Iterator<E> iterator() {
        if (this.f4565d == null) {
            this.f4565d = new b(this);
        }
        g<E, E> gVar = this.f4565d;
        if (gVar.f4582b == null) {
            gVar.f4582b = new d.e.g.c<>();
        }
        return gVar.f4582b.iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        b(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f4564c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f4563b[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f4564c;
    }

    public Object[] toArray() {
        int i2 = this.f4564c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f4563b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4564c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f4564c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f4563b[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f4564c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f4564c);
        }
        System.arraycopy(this.f4563b, 0, tArr, 0, this.f4564c);
        int length = tArr.length;
        int i2 = this.f4564c;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public final int a() {
        int i2 = this.f4564c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = d.a(this.f4562a, i2, 0);
        if (a2 < 0 || this.f4563b[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f4562a[i3] == 0) {
            if (this.f4563b[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f4562a[i4] == 0) {
            if (this.f4563b[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (c.class) {
                if (f4560i != null) {
                    Object[] objArr = f4560i;
                    this.f4563b = objArr;
                    f4560i = (Object[]) objArr[0];
                    this.f4562a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4561j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (c.class) {
                if (f4558g != null) {
                    Object[] objArr2 = f4558g;
                    this.f4563b = objArr2;
                    f4558g = (Object[]) objArr2[0];
                    this.f4562a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4559h--;
                    return;
                }
            }
        }
        this.f4562a = new int[i2];
        this.f4563b = new Object[i2];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f4561j < 10) {
                    objArr[0] = f4560i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f4560i = objArr;
                    f4561j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f4559h < 10) {
                    objArr[0] = f4558g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f4558g = objArr;
                    f4559h++;
                }
            }
        }
    }
}
