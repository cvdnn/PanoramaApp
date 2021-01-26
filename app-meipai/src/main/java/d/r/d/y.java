package d.r.d;

import android.view.View;

/* compiled from: ViewBoundsCheck */
public class y {

    /* renamed from: a reason: collision with root package name */
    public final b f5411a;

    /* renamed from: b reason: collision with root package name */
    public a f5412b = new a();

    /* compiled from: ViewBoundsCheck */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public int f5413a = 0;

        /* renamed from: b reason: collision with root package name */
        public int f5414b;

        /* renamed from: c reason: collision with root package name */
        public int f5415c;

        /* renamed from: d reason: collision with root package name */
        public int f5416d;

        /* renamed from: e reason: collision with root package name */
        public int f5417e;

        public int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        public boolean a() {
            int i2 = this.f5413a;
            if ((i2 & 7) != 0 && (i2 & (a(this.f5416d, this.f5414b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f5413a;
            if ((i3 & 112) != 0 && (i3 & (a(this.f5416d, this.f5415c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f5413a;
            if ((i4 & 1792) != 0 && (i4 & (a(this.f5417e, this.f5414b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f5413a;
            if ((i5 & 28672) == 0 || (i5 & (a(this.f5417e, this.f5415c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: ViewBoundsCheck */
    public interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    public y(b bVar) {
        this.f5411a = bVar;
    }

    public View a(int i2, int i3, int i4, int i5) {
        int a2 = this.f5411a.a();
        int b2 = this.f5411a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f5411a.a(i2);
            int a4 = this.f5411a.a(a3);
            int b3 = this.f5411a.b(a3);
            a aVar = this.f5412b;
            aVar.f5414b = a2;
            aVar.f5415c = b2;
            aVar.f5416d = a4;
            aVar.f5417e = b3;
            if (i4 != 0) {
                aVar.f5413a = 0;
                aVar.f5413a = i4 | 0;
                if (aVar.a()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                a aVar2 = this.f5412b;
                aVar2.f5413a = 0;
                aVar2.f5413a = i5 | 0;
                if (aVar2.a()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    public boolean a(View view, int i2) {
        a aVar = this.f5412b;
        int a2 = this.f5411a.a();
        int b2 = this.f5411a.b();
        int a3 = this.f5411a.a(view);
        int b3 = this.f5411a.b(view);
        aVar.f5414b = a2;
        aVar.f5415c = b2;
        aVar.f5416d = a3;
        aVar.f5417e = b3;
        if (i2 == 0) {
            return false;
        }
        a aVar2 = this.f5412b;
        aVar2.f5413a = 0;
        aVar2.f5413a = 0 | i2;
        return aVar2.a();
    }
}
