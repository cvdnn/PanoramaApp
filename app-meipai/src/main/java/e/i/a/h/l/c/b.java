package e.i.a.h.l.c;

import android.util.SparseArray;
import e.i.a.c;
import e.i.a.f;
import e.i.a.h.l.c.a.C0129a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({"BC"})
/* compiled from: Listener4SpeedAssistExtend */
public class b implements C0129a, e.i.a.h.l.c.c.b<C0130b> {

    /* renamed from: a reason: collision with root package name */
    public a f8895a = this;

    /* compiled from: Listener4SpeedAssistExtend */
    public interface a {
        void blockEnd(c cVar, int i2, e.i.a.h.d.a aVar, f fVar);

        void infoReady(c cVar, e.i.a.h.d.c cVar2, boolean z, C0130b bVar);

        void progress(c cVar, long j2, f fVar);

        void progressBlock(c cVar, int i2, long j2, f fVar);

        void taskEnd(c cVar, e.i.a.h.e.a aVar, Exception exc, f fVar);
    }

    /* renamed from: e.i.a.h.l.c.b$b reason: collision with other inner class name */
    /* compiled from: Listener4SpeedAssistExtend */
    public static class C0130b extends a.c {

        /* renamed from: e reason: collision with root package name */
        public f f8896e;

        /* renamed from: f reason: collision with root package name */
        public SparseArray<f> f8897f;

        public C0130b(int i2) {
            super(i2);
        }

        public void a(e.i.a.h.d.c cVar) {
            super.a(cVar);
            this.f8896e = new f();
            this.f8897f = new SparseArray<>();
            int b2 = cVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f8897f.put(i2, new f());
            }
        }
    }

    public e.i.a.h.l.c.c.a a(int i2) {
        return new C0130b(i2);
    }
}
