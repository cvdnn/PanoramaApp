package e.d.a.n.n;

/* compiled from: DiskCacheStrategy */
public abstract class k {

    /* renamed from: a reason: collision with root package name */
    public static final k f7435a = new a();

    /* renamed from: b reason: collision with root package name */
    public static final k f7436b = new b();

    /* renamed from: c reason: collision with root package name */
    public static final k f7437c = new c();

    /* compiled from: DiskCacheStrategy */
    public class a extends k {
        public boolean a() {
            return false;
        }

        public boolean a(e.d.a.n.a aVar) {
            return false;
        }

        public boolean a(boolean z, e.d.a.n.a aVar, e.d.a.n.c cVar) {
            return false;
        }

        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy */
    public class b extends k {
        public boolean a() {
            return true;
        }

        public boolean a(e.d.a.n.a aVar) {
            return (aVar == e.d.a.n.a.DATA_DISK_CACHE || aVar == e.d.a.n.a.MEMORY_CACHE) ? false : true;
        }

        public boolean a(boolean z, e.d.a.n.a aVar, e.d.a.n.c cVar) {
            return false;
        }

        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy */
    public class c extends k {
        public boolean a() {
            return true;
        }

        public boolean a(e.d.a.n.a aVar) {
            return aVar == e.d.a.n.a.REMOTE;
        }

        public boolean b() {
            return true;
        }

        public boolean a(boolean z, e.d.a.n.a aVar, e.d.a.n.c cVar) {
            return ((z && aVar == e.d.a.n.a.DATA_DISK_CACHE) || aVar == e.d.a.n.a.LOCAL) && cVar == e.d.a.n.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(e.d.a.n.a aVar);

    public abstract boolean a(boolean z, e.d.a.n.a aVar, e.d.a.n.c cVar);

    public abstract boolean b();
}
