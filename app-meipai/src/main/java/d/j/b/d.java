package d.j.b;

import android.graphics.Rect;
import d.j.b.a.C0046a;
import java.util.Comparator;

/* compiled from: FocusStrategy */
public class d<T> implements Comparator<T> {

    /* renamed from: a reason: collision with root package name */
    public final Rect f5021a = new Rect();

    /* renamed from: b reason: collision with root package name */
    public final Rect f5022b = new Rect();

    /* renamed from: c reason: collision with root package name */
    public final boolean f5023c;

    /* renamed from: d reason: collision with root package name */
    public final b<T> f5024d;

    public d(boolean z, b<T> bVar) {
        this.f5023c = z;
        this.f5024d = bVar;
    }

    public int compare(T t, T t2) {
        Rect rect = this.f5021a;
        Rect rect2 = this.f5022b;
        ((C0046a) this.f5024d).a(t, rect);
        ((C0046a) this.f5024d).a(t2, rect2);
        int i2 = rect.top;
        int i3 = rect2.top;
        int i4 = -1;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        int i5 = rect.left;
        int i6 = rect2.left;
        if (i5 < i6) {
            if (this.f5023c) {
                i4 = 1;
            }
            return i4;
        } else if (i5 > i6) {
            if (!this.f5023c) {
                i4 = 1;
            }
            return i4;
        } else {
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            if (i7 < i8) {
                return -1;
            }
            if (i7 > i8) {
                return 1;
            }
            int i9 = rect.right;
            int i10 = rect2.right;
            if (i9 < i10) {
                if (this.f5023c) {
                    i4 = 1;
                }
                return i4;
            } else if (i9 <= i10) {
                return 0;
            } else {
                if (!this.f5023c) {
                    i4 = 1;
                }
                return i4;
            }
        }
    }
}
