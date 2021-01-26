package e.i.a.h.l;

import e.i.a.c;
import e.i.a.h.l.c.b.C0130b;

/* compiled from: DownloadListener4WithSpeed */
public abstract class b extends a implements e.i.a.h.l.c.b.a {

    /* renamed from: e.i.a.h.l.b$b reason: collision with other inner class name */
    /* compiled from: DownloadListener4WithSpeed */
    public static class C0128b implements e.i.a.h.l.c.c.b<C0130b> {
        public /* synthetic */ C0128b(a aVar) {
        }

        public e.i.a.h.l.c.c.a a(int i2) {
            return new C0130b(i2);
        }
    }

    public b() {
        e.i.a.h.l.c.b bVar = new e.i.a.h.l.c.b();
        super(new e.i.a.h.l.c.a(new C0128b(null)));
        setAssistExtend(bVar);
    }

    public final void blockEnd(c cVar, int i2, e.i.a.h.d.a aVar) {
    }

    public final void infoReady(c cVar, e.i.a.h.d.c cVar2, boolean z, e.i.a.h.l.c.a.c cVar3) {
    }

    public final void progress(c cVar, long j2) {
    }

    public final void progressBlock(c cVar, int i2, long j2) {
    }

    public final void taskEnd(c cVar, e.i.a.h.e.a aVar, Exception exc, e.i.a.h.l.c.a.c cVar2) {
    }
}
