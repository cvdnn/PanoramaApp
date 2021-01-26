package d.r.d;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
public class b {

    /* renamed from: a reason: collision with root package name */
    public final C0054b f5310a;

    /* renamed from: b reason: collision with root package name */
    public final a f5311b = new a();

    /* renamed from: c reason: collision with root package name */
    public final List<View> f5312c = new ArrayList();

    /* compiled from: ChildHelper */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public long f5313a = 0;

        /* renamed from: b reason: collision with root package name */
        public a f5314b;

        public final void a() {
            if (this.f5314b == null) {
                this.f5314b = new a();
            }
        }

        public void b() {
            this.f5313a = 0;
            a aVar = this.f5314b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public boolean c(int i2) {
            if (i2 >= 64) {
                a();
                return this.f5314b.c(i2 - 64);
            }
            return (this.f5313a & (1 << i2)) != 0;
        }

        public boolean d(int i2) {
            if (i2 >= 64) {
                a();
                return this.f5314b.d(i2 - 64);
            }
            long j2 = 1 << i2;
            boolean z = (this.f5313a & j2) != 0;
            long j3 = this.f5313a & (~j2);
            this.f5313a = j3;
            long j4 = j2 - 1;
            this.f5313a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.f5314b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f5314b.d(0);
            }
            return z;
        }

        public void e(int i2) {
            if (i2 >= 64) {
                a();
                this.f5314b.e(i2 - 64);
                return;
            }
            this.f5313a |= 1 << i2;
        }

        public String toString() {
            if (this.f5314b == null) {
                return Long.toBinaryString(this.f5313a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5314b.toString());
            sb.append("xx");
            sb.append(Long.toBinaryString(this.f5313a));
            return sb.toString();
        }

        public void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f5314b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f5313a &= ~(1 << i2);
        }

        public int b(int i2) {
            a aVar = this.f5314b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f5313a);
                }
                return Long.bitCount(this.f5313a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f5313a & ((1 << i2) - 1));
            } else {
                return Long.bitCount(this.f5313a) + aVar.b(i2 - 64);
            }
        }

        public void a(int i2, boolean z) {
            if (i2 >= 64) {
                a();
                this.f5314b.a(i2 - 64, z);
                return;
            }
            boolean z2 = (this.f5313a & Long.MIN_VALUE) != 0;
            long j2 = (1 << i2) - 1;
            long j3 = this.f5313a;
            this.f5313a = ((j3 & (~j2)) << 1) | (j3 & j2);
            if (z) {
                e(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f5314b != null) {
                a();
                this.f5314b.a(0, z2);
            }
        }
    }

    /* renamed from: d.r.d.b$b reason: collision with other inner class name */
    /* compiled from: ChildHelper */
    public interface C0054b {
    }

    public b(C0054b bVar) {
        this.f5310a = bVar;
    }

    public final void a(View view) {
        this.f5312c.add(view);
        e eVar = (e) this.f5310a;
        if (eVar != null) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                return;
            }
            return;
        }
        throw null;
    }

    public View b(int i2) {
        return ((e) this.f5310a).a(c(i2));
    }

    public final int c(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = ((e) this.f5310a).a();
        int i3 = i2;
        while (i3 < a2) {
            int b2 = i2 - (i3 - this.f5311b.b(i3));
            if (b2 == 0) {
                while (this.f5311b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    public final boolean d(View view) {
        if (!this.f5312c.remove(view)) {
            return false;
        }
        e eVar = (e) this.f5310a;
        if (eVar != null) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
            return true;
        }
        throw null;
    }

    public void e(int i2) {
        int c2 = c(i2);
        View a2 = ((e) this.f5310a).a(c2);
        if (a2 != null) {
            if (this.f5311b.d(c2)) {
                d(a2);
            }
            ((e) this.f5310a).b(c2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5311b.toString());
        sb.append(", hidden list:");
        sb.append(this.f5312c.size());
        return sb.toString();
    }

    public int b() {
        return ((e) this.f5310a).a();
    }

    public int b(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild != -1 && !this.f5311b.c(indexOfChild)) {
            return indexOfChild - this.f5311b.b(indexOfChild);
        }
        return -1;
    }

    public boolean c(View view) {
        return this.f5312c.contains(view);
    }

    public void a(View view, int i2, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = ((e) this.f5310a).a();
        } else {
            i3 = c(i2);
        }
        this.f5311b.a(i3, z);
        if (z) {
            a(view);
        }
        e eVar = (e) this.f5310a;
        RecyclerView.this.addView(view, i3);
        RecyclerView.this.dispatchChildAttached(view);
    }

    public View d(int i2) {
        return RecyclerView.this.getChildAt(i2);
    }

    public void a(View view, int i2, LayoutParams layoutParams, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = ((e) this.f5310a).a();
        } else {
            i3 = c(i2);
        }
        this.f5311b.a(i3, z);
        if (z) {
            a(view);
        }
        e eVar = (e) this.f5310a;
        if (eVar != null) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Called attach on a child which is not detached: ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(e.a.a.a.a.a(RecyclerView.this, sb));
                }
            }
            RecyclerView.this.attachViewToParent(view, i3, layoutParams);
            return;
        }
        throw null;
    }

    public int a() {
        return ((e) this.f5310a).a() - this.f5312c.size();
    }

    public void a(int i2) {
        int c2 = c(i2);
        this.f5311b.d(c2);
        e eVar = (e) this.f5310a;
        View childAt = RecyclerView.this.getChildAt(c2);
        if (childAt != null) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.addFlags(256);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(e.a.a.a.a.a(RecyclerView.this, sb));
                }
            }
        }
        RecyclerView.this.detachViewFromParent(c2);
    }
}
