package e.i.a.h.l;

import e.i.a.f;
import e.i.a.h.l.c.a.C0129a;
import e.i.a.h.l.c.a.b;
import e.i.a.h.l.c.b.C0130b;
import e.i.a.h.l.c.c;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadListener4 */
public abstract class a implements e.i.a.a, b {

    /* renamed from: a reason: collision with root package name */
    public final e.i.a.h.l.c.a f8887a;

    /* renamed from: e.i.a.h.l.a$a reason: collision with other inner class name */
    /* compiled from: DownloadListener4 */
    public static class C0127a implements c.b<e.i.a.h.l.c.a.c> {
        public e.i.a.h.l.c.c.a a(int i2) {
            return new e.i.a.h.l.c.a.c(i2);
        }
    }

    public a(e.i.a.h.l.c.a aVar) {
        this.f8887a = aVar;
    }

    public void connectTrialEnd(e.i.a.c cVar, int i2, Map<String, List<String>> map) {
    }

    public void connectTrialStart(e.i.a.c cVar, Map<String, List<String>> map) {
    }

    public final void downloadFromBeginning(e.i.a.c cVar, e.i.a.h.d.c cVar2, e.i.a.h.e.b bVar) {
        this.f8887a.a(cVar, cVar2, false);
    }

    public final void downloadFromBreakpoint(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
        this.f8887a.a(cVar, cVar2, true);
    }

    public void fetchEnd(e.i.a.c cVar, int i2, long j2) {
        e.i.a.h.l.c.a aVar = this.f8887a;
        e.i.a.h.l.c.a.c cVar2 = (e.i.a.h.l.c.a.c) aVar.f8890c.b(cVar, cVar.h());
        if (cVar2 != null) {
            C0129a aVar2 = aVar.f8889b;
            if (aVar2 != null) {
                e.i.a.h.l.c.b bVar = (e.i.a.h.l.c.b) aVar2;
                C0130b bVar2 = (C0130b) cVar2;
                ((f) bVar2.f8897f.get(i2)).a();
                e.i.a.h.l.c.b.a aVar3 = bVar.f8895a;
                if (aVar3 != null) {
                    aVar3.blockEnd(cVar, i2, (e.i.a.h.d.a) cVar2.f8892b.f8708g.get(i2), (f) bVar2.f8897f.get(i2));
                    return;
                }
                return;
            }
            b bVar3 = aVar.f8888a;
            if (bVar3 != null) {
                bVar3.blockEnd(cVar, i2, (e.i.a.h.d.a) cVar2.f8892b.f8708g.get(i2));
            }
        }
    }

    public final void fetchProgress(e.i.a.c cVar, int i2, long j2) {
        e.i.a.h.l.c.a aVar = this.f8887a;
        e.i.a.h.l.c.a.c cVar2 = (e.i.a.h.l.c.a.c) aVar.f8890c.b(cVar, cVar.h());
        if (cVar2 != null) {
            long longValue = ((Long) cVar2.f8894d.get(i2)).longValue() + j2;
            cVar2.f8894d.put(i2, Long.valueOf(longValue));
            cVar2.f8893c += j2;
            C0129a aVar2 = aVar.f8889b;
            if (aVar2 != null) {
                e.i.a.h.l.c.b bVar = (e.i.a.h.l.c.b) aVar2;
                C0130b bVar2 = (C0130b) cVar2;
                ((f) bVar2.f8897f.get(i2)).a(j2);
                bVar2.f8896e.a(j2);
                e.i.a.h.l.c.b.a aVar3 = bVar.f8895a;
                if (aVar3 != null) {
                    aVar3.progressBlock(cVar, i2, ((Long) cVar2.f8894d.get(i2)).longValue(), (f) bVar2.f8897f.get(i2));
                    bVar.f8895a.progress(cVar, cVar2.f8893c, bVar2.f8896e);
                    return;
                }
                return;
            }
            b bVar3 = aVar.f8888a;
            if (bVar3 != null) {
                bVar3.progressBlock(cVar, i2, longValue);
                aVar.f8888a.progress(cVar, cVar2.f8893c);
            }
        }
    }

    public void fetchStart(e.i.a.c cVar, int i2, long j2) {
    }

    public boolean isAlwaysRecoverAssistModel() {
        Boolean bool = this.f8887a.f8890c.f8900c;
        return bool != null && bool.booleanValue();
    }

    public void setAlwaysRecoverAssistModel(boolean z) {
        this.f8887a.f8890c.f8900c = Boolean.valueOf(z);
    }

    public void setAlwaysRecoverAssistModelIfNotSet(boolean z) {
        c<T> cVar = this.f8887a.f8890c;
        if (cVar.f8900c == null) {
            cVar.f8900c = Boolean.valueOf(z);
        }
    }

    public void setAssistExtend(C0129a aVar) {
        this.f8887a.f8889b = aVar;
    }

    public final void taskEnd(e.i.a.c cVar, e.i.a.h.e.a aVar, Exception exc) {
        this.f8887a.a(cVar, aVar, exc);
    }

    public a() {
        e.i.a.h.l.c.a aVar = new e.i.a.h.l.c.a(new C0127a());
        this.f8887a = aVar;
    }
}
