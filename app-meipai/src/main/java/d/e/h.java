package d.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap */
public class h<K, V> {

    /* renamed from: d reason: collision with root package name */
    public static Object[] f4596d;

    /* renamed from: e reason: collision with root package name */
    public static int f4597e;

    /* renamed from: f reason: collision with root package name */
    public static Object[] f4598f;

    /* renamed from: g reason: collision with root package name */
    public static int f4599g;

    /* renamed from: a reason: collision with root package name */
    public int[] f4600a;

    /* renamed from: b reason: collision with root package name */
    public Object[] f4601b;

    /* renamed from: c reason: collision with root package name */
    public int f4602c;

    public h() {
        this.f4600a = d.f4566a;
        this.f4601b = d.f4568c;
        this.f4602c = 0;
    }

    public int a(Object obj, int i2) {
        int i3 = this.f4602c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a2 = d.a(this.f4600a, i3, i2);
            if (a2 < 0 || obj.equals(this.f4601b[a2 << 1])) {
                return a2;
            }
            int i4 = a2 + 1;
            while (i4 < i3 && this.f4600a[i4] == i2) {
                if (obj.equals(this.f4601b[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            int i5 = a2 - 1;
            while (i5 >= 0 && this.f4600a[i5] == i2) {
                if (obj.equals(this.f4601b[i5 << 1])) {
                    return i5;
                }
                i5--;
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void b(int i2) {
        int i3 = this.f4602c;
        int[] iArr = this.f4600a;
        if (iArr.length < i2) {
            Object[] objArr = this.f4601b;
            a(i2);
            if (this.f4602c > 0) {
                System.arraycopy(iArr, 0, this.f4600a, 0, i3);
                System.arraycopy(objArr, 0, this.f4601b, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f4602c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public K c(int i2) {
        return this.f4601b[i2 << 1];
    }

    public void clear() {
        int i2 = this.f4602c;
        if (i2 > 0) {
            int[] iArr = this.f4600a;
            Object[] objArr = this.f4601b;
            this.f4600a = d.f4566a;
            this.f4601b = d.f4568c;
            this.f4602c = 0;
            a(iArr, objArr, i2);
        }
        if (this.f4602c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        V[] vArr = this.f4601b;
        int i3 = i2 << 1;
        V v = vArr[i3 + 1];
        int i4 = this.f4602c;
        int i5 = 0;
        if (i4 <= 1) {
            a(this.f4600a, vArr, i4);
            this.f4600a = d.f4566a;
            this.f4601b = d.f4568c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f4600a;
            int i7 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int[] iArr2 = this.f4600a;
                    int i8 = i2 + 1;
                    int i9 = i6 - i2;
                    System.arraycopy(iArr2, i8, iArr2, i2, i9);
                    Object[] objArr = this.f4601b;
                    System.arraycopy(objArr, i8 << 1, objArr, i3, i9 << 1);
                }
                Object[] objArr2 = this.f4601b;
                int i10 = i6 << 1;
                objArr2[i10] = null;
                objArr2[i10 + 1] = null;
            } else {
                if (i4 > 8) {
                    i7 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.f4600a;
                Object[] objArr3 = this.f4601b;
                a(i7);
                if (i4 == this.f4602c) {
                    if (i2 > 0) {
                        System.arraycopy(iArr3, 0, this.f4600a, 0, i2);
                        System.arraycopy(objArr3, 0, this.f4601b, 0, i3);
                    }
                    if (i2 < i6) {
                        int i11 = i2 + 1;
                        int i12 = i6 - i2;
                        System.arraycopy(iArr3, i11, this.f4600a, i2, i12);
                        System.arraycopy(objArr3, i11 << 1, this.f4601b, i3, i12 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i5 = i6;
        }
        if (i4 == this.f4602c) {
            this.f4602c = i5;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V e(int i2) {
        return this.f4601b[(i2 << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f4602c != hVar.f4602c) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f4602c) {
                try {
                    Object c2 = c(i2);
                    Object e2 = e(i2);
                    Object obj2 = hVar.get(c2);
                    if (e2 == null) {
                        if (obj2 != null || !hVar.containsKey(c2)) {
                            return false;
                        }
                    } else if (!e2.equals(obj2)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f4602c != map.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.f4602c) {
                try {
                    Object c3 = c(i3);
                    Object e3 = e(i3);
                    Object obj3 = map.get(c3);
                    if (e3 == null) {
                        if (obj3 != null || !map.containsKey(c3)) {
                            return false;
                        }
                    } else if (!e3.equals(obj3)) {
                        return false;
                    }
                    i3++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? this.f4601b[(a2 << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f4600a;
        Object[] objArr = this.f4601b;
        int i2 = this.f4602c;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public boolean isEmpty() {
        return this.f4602c <= 0;
    }

    public V put(K k, V v) {
        int i2;
        int i3;
        int i4 = this.f4602c;
        if (k == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = hashCode;
            i3 = a((Object) k, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.f4601b;
            V v2 = vArr[i5];
            vArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        if (i4 >= this.f4600a.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            int[] iArr = this.f4600a;
            Object[] objArr = this.f4601b;
            a(i7);
            if (i4 == this.f4602c) {
                int[] iArr2 = this.f4600a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f4601b, 0, objArr.length);
                }
                a(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f4600a;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.f4601b;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.f4602c - i6) << 1);
        }
        int i9 = this.f4602c;
        if (i4 == i9) {
            int[] iArr4 = this.f4600a;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.f4601b;
                int i10 = i6 << 1;
                objArr3[i10] = k;
                objArr3[i10 + 1] = v;
                this.f4602c = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V orDefault = getOrDefault(k, null);
        return orDefault == null ? put(k, v) : orDefault;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public V replace(K k, V v) {
        int a2 = a((Object) k);
        if (a2 >= 0) {
            return a(a2, v);
        }
        return null;
    }

    public int size() {
        return this.f4602c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4602c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f4602c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object c2 = c(i2);
            String str = "(this Map)";
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append(str);
            }
            sb.append('=');
            Object e2 = e(i2);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append(str);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 >= 0) {
            Object e2 = e(a2);
            if (obj2 == e2 || (obj2 != null && obj2.equals(e2))) {
                d(a2);
                return true;
            }
        }
        return false;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a((Object) k);
        if (a2 >= 0) {
            V e2 = e(a2);
            if (e2 == v || (v != null && v.equals(e2))) {
                a(a2, v2);
                return true;
            }
        }
        return false;
    }

    public h(int i2) {
        if (i2 == 0) {
            this.f4600a = d.f4566a;
            this.f4601b = d.f4568c;
        } else {
            a(i2);
        }
        this.f4602c = 0;
    }

    public int a() {
        int i2 = this.f4602c;
        if (i2 == 0) {
            return -1;
        }
        try {
            int a2 = d.a(this.f4600a, i2, 0);
            if (a2 < 0 || this.f4601b[a2 << 1] == null) {
                return a2;
            }
            int i3 = a2 + 1;
            while (i3 < i2 && this.f4600a[i3] == 0) {
                if (this.f4601b[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            int i4 = a2 - 1;
            while (i4 >= 0 && this.f4600a[i4] == 0) {
                if (this.f4601b[i4 << 1] == null) {
                    return i4;
                }
                i4--;
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int b(Object obj) {
        int i2 = this.f4602c * 2;
        Object[] objArr = this.f4601b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
        } else {
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (obj.equals(objArr[i4])) {
                    return i4 >> 1;
                }
            }
        }
        return -1;
    }

    public final void a(int i2) {
        Class<h> cls = h.class;
        if (i2 == 8) {
            synchronized (cls) {
                if (f4598f != null) {
                    Object[] objArr = f4598f;
                    this.f4601b = objArr;
                    f4598f = (Object[]) objArr[0];
                    this.f4600a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4599g--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (cls) {
                if (f4596d != null) {
                    Object[] objArr2 = f4596d;
                    this.f4601b = objArr2;
                    f4596d = (Object[]) objArr2[0];
                    this.f4600a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4597e--;
                    return;
                }
            }
        }
        this.f4600a = new int[i2];
        this.f4601b = new Object[(i2 << 1)];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        Class<h> cls = h.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f4599g < 10) {
                    objArr[0] = f4598f;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f4598f = objArr;
                    f4599g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f4597e < 10) {
                    objArr[0] = f4596d;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f4596d = objArr;
                    f4597e++;
                }
            }
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f4601b;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public void a(h<? extends K, ? extends V> hVar) {
        int i2 = hVar.f4602c;
        b(this.f4602c + i2);
        if (this.f4602c != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(hVar.c(i3), hVar.e(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(hVar.f4600a, 0, this.f4600a, 0, i2);
            System.arraycopy(hVar.f4601b, 0, this.f4601b, 0, i2 << 1);
            this.f4602c = i2;
        }
    }
}
