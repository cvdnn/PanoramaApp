package d.h.i;

/* compiled from: TextDirectionHeuristicsCompat */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public static final c f4891a = new e(null, false);

    /* renamed from: b reason: collision with root package name */
    public static final c f4892b = new e(null, true);

    /* renamed from: c reason: collision with root package name */
    public static final c f4893c = new e(b.f4897a, false);

    /* renamed from: d reason: collision with root package name */
    public static final c f4894d = new e(b.f4897a, true);

    /* compiled from: TextDirectionHeuristicsCompat */
    public static class a implements c {

        /* renamed from: b reason: collision with root package name */
        public static final a f4895b = new a(true);

        /* renamed from: a reason: collision with root package name */
        public final boolean f4896a;

        public a(boolean z) {
            this.f4896a = z;
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = d.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f4896a) {
                        return 1;
                    }
                } else if (this.f4896a) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f4896a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    public static class b implements c {

        /* renamed from: a reason: collision with root package name */
        public static final b f4897a = new b();

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = d.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    public interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* renamed from: d.h.i.d$d reason: collision with other inner class name */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static abstract class C0039d implements c {

        /* renamed from: a reason: collision with root package name */
        public final c f4898a;

        public C0039d(c cVar) {
            this.f4898a = cVar;
        }

        public abstract boolean a();

        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            }
            c cVar = this.f4898a;
            if (cVar == null) {
                return a();
            }
            int a2 = cVar.a(charSequence, i2, i3);
            boolean z = true;
            if (a2 != 0) {
                z = a2 != 1 ? a() : false;
            }
            return z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    public static class e extends C0039d {

        /* renamed from: b reason: collision with root package name */
        public final boolean f4899b;

        public e(c cVar, boolean z) {
            super(cVar);
            this.f4899b = z;
        }

        public boolean a() {
            return this.f4899b;
        }
    }

    static {
        a aVar = a.f4895b;
    }

    public static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i2) {
        if (i2 != 0) {
            if (!(i2 == 1 || i2 == 2)) {
                switch (i2) {
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                        break;
                    default:
                        return 2;
                }
            }
            return 0;
        }
        return 1;
    }
}
