package e.i.a.h.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import e.i.a.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: CallbackDispatcher */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final e.i.a.a f8757a;

    /* renamed from: b reason: collision with root package name */
    public final Handler f8758b;

    /* renamed from: e.i.a.h.g.a$a reason: collision with other inner class name */
    /* compiled from: CallbackDispatcher */
    public class C0123a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Collection f8759a;

        public C0123a(a aVar, Collection collection) {
            this.f8759a = collection;
        }

        public void run() {
            for (c cVar : this.f8759a) {
                cVar.q.taskEnd(cVar, e.i.a.h.e.a.CANCELED, null);
            }
        }
    }

    /* compiled from: CallbackDispatcher */
    public static class b implements e.i.a.a {

        /* renamed from: a reason: collision with root package name */
        public final Handler f8760a;

        /* renamed from: e.i.a.h.g.a$b$a reason: collision with other inner class name */
        /* compiled from: CallbackDispatcher */
        public class C0124a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8761a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8762b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ long f8763c;

            public C0124a(b bVar, e.i.a.c cVar, int i2, long j2) {
                this.f8761a = cVar;
                this.f8762b = i2;
                this.f8763c = j2;
            }

            public void run() {
                this.f8761a.q.fetchEnd(this.f8761a, this.f8762b, this.f8763c);
            }
        }

        /* renamed from: e.i.a.h.g.a$b$b reason: collision with other inner class name */
        /* compiled from: CallbackDispatcher */
        public class C0125b implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8764a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ e.i.a.h.e.a f8765b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ Exception f8766c;

            public C0125b(b bVar, e.i.a.c cVar, e.i.a.h.e.a aVar, Exception exc) {
                this.f8764a = cVar;
                this.f8765b = aVar;
                this.f8766c = exc;
            }

            public void run() {
                this.f8764a.q.taskEnd(this.f8764a, this.f8765b, this.f8766c);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class c implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8767a;

            public c(b bVar, e.i.a.c cVar) {
                this.f8767a = cVar;
            }

            public void run() {
                this.f8767a.q.taskStart(this.f8767a);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class d implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8768a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ Map f8769b;

            public d(b bVar, e.i.a.c cVar, Map map) {
                this.f8768a = cVar;
                this.f8769b = map;
            }

            public void run() {
                this.f8768a.q.connectTrialStart(this.f8768a, this.f8769b);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class e implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8770a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8771b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ Map f8772c;

            public e(b bVar, e.i.a.c cVar, int i2, Map map) {
                this.f8770a = cVar;
                this.f8771b = i2;
                this.f8772c = map;
            }

            public void run() {
                this.f8770a.q.connectTrialEnd(this.f8770a, this.f8771b, this.f8772c);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class f implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8773a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ e.i.a.h.d.c f8774b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ e.i.a.h.e.b f8775c;

            public f(b bVar, e.i.a.c cVar, e.i.a.h.d.c cVar2, e.i.a.h.e.b bVar2) {
                this.f8773a = cVar;
                this.f8774b = cVar2;
                this.f8775c = bVar2;
            }

            public void run() {
                this.f8773a.q.downloadFromBeginning(this.f8773a, this.f8774b, this.f8775c);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class g implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8776a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ e.i.a.h.d.c f8777b;

            public g(b bVar, e.i.a.c cVar, e.i.a.h.d.c cVar2) {
                this.f8776a = cVar;
                this.f8777b = cVar2;
            }

            public void run() {
                this.f8776a.q.downloadFromBreakpoint(this.f8776a, this.f8777b);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class h implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8778a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8779b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ Map f8780c;

            public h(b bVar, e.i.a.c cVar, int i2, Map map) {
                this.f8778a = cVar;
                this.f8779b = i2;
                this.f8780c = map;
            }

            public void run() {
                this.f8778a.q.connectStart(this.f8778a, this.f8779b, this.f8780c);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class i implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8781a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8782b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ int f8783c;

            /* renamed from: d reason: collision with root package name */
            public final /* synthetic */ Map f8784d;

            public i(b bVar, e.i.a.c cVar, int i2, int i3, Map map) {
                this.f8781a = cVar;
                this.f8782b = i2;
                this.f8783c = i3;
                this.f8784d = map;
            }

            public void run() {
                this.f8781a.q.connectEnd(this.f8781a, this.f8782b, this.f8783c, this.f8784d);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class j implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8785a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8786b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ long f8787c;

            public j(b bVar, e.i.a.c cVar, int i2, long j2) {
                this.f8785a = cVar;
                this.f8786b = i2;
                this.f8787c = j2;
            }

            public void run() {
                this.f8785a.q.fetchStart(this.f8785a, this.f8786b, this.f8787c);
            }
        }

        /* compiled from: CallbackDispatcher */
        public class k implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ e.i.a.c f8788a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ int f8789b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ long f8790c;

            public k(b bVar, e.i.a.c cVar, int i2, long j2) {
                this.f8788a = cVar;
                this.f8789b = i2;
                this.f8790c = j2;
            }

            public void run() {
                this.f8788a.q.fetchProgress(this.f8788a, this.f8789b, this.f8790c);
            }
        }

        public b(Handler handler) {
            this.f8760a = handler;
        }

        public void connectEnd(e.i.a.c cVar, int i2, int i3, Map<String, List<String>> map) {
            StringBuilder a2 = e.a.a.a.a.a("<----- finish connection task(");
            a2.append(cVar.f8649b);
            a2.append(") block(");
            a2.append(i2);
            a2.append(") code[");
            a2.append(i3);
            a2.append("]");
            a2.append(map);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                Handler handler = this.f8760a;
                i iVar = new i(this, cVar, i2, i3, map);
                handler.post(iVar);
                return;
            }
            cVar.q.connectEnd(cVar, i2, i3, map);
        }

        public void connectStart(e.i.a.c cVar, int i2, Map<String, List<String>> map) {
            StringBuilder a2 = e.a.a.a.a.a("-----> start connection task(");
            a2.append(cVar.f8649b);
            a2.append(") block(");
            a2.append(i2);
            a2.append(") ");
            a2.append(map);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                this.f8760a.post(new h(this, cVar, i2, map));
            } else {
                cVar.q.connectStart(cVar, i2, map);
            }
        }

        public void connectTrialEnd(e.i.a.c cVar, int i2, Map<String, List<String>> map) {
            StringBuilder a2 = e.a.a.a.a.a("<----- finish trial task(");
            a2.append(cVar.f8649b);
            a2.append(") code[");
            a2.append(i2);
            a2.append("]");
            a2.append(map);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                this.f8760a.post(new e(this, cVar, i2, map));
            } else {
                cVar.q.connectTrialEnd(cVar, i2, map);
            }
        }

        public void connectTrialStart(e.i.a.c cVar, Map<String, List<String>> map) {
            StringBuilder a2 = e.a.a.a.a.a("-----> start trial task(");
            a2.append(cVar.f8649b);
            a2.append(") ");
            a2.append(map);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                this.f8760a.post(new d(this, cVar, map));
            } else {
                cVar.q.connectTrialStart(cVar, map);
            }
        }

        public void downloadFromBeginning(e.i.a.c cVar, e.i.a.h.d.c cVar2, e.i.a.h.e.b bVar) {
            StringBuilder a2 = e.a.a.a.a.a("downloadFromBeginning: ");
            a2.append(cVar.f8649b);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            e.i.a.b bVar2 = e.i.a.e.a().f8672i;
            if (bVar2 != null) {
                bVar2.a(cVar, cVar2, bVar);
            }
            if (cVar.o) {
                this.f8760a.post(new f(this, cVar, cVar2, bVar));
            } else {
                cVar.q.downloadFromBeginning(cVar, cVar2, bVar);
            }
        }

        public void downloadFromBreakpoint(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
            StringBuilder a2 = e.a.a.a.a.a("downloadFromBreakpoint: ");
            a2.append(cVar.f8649b);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            e.i.a.b bVar = e.i.a.e.a().f8672i;
            if (bVar != null) {
                bVar.a(cVar, cVar2);
            }
            if (cVar.o) {
                this.f8760a.post(new g(this, cVar, cVar2));
            } else {
                cVar.q.downloadFromBreakpoint(cVar, cVar2);
            }
        }

        public void fetchEnd(e.i.a.c cVar, int i2, long j2) {
            StringBuilder a2 = e.a.a.a.a.a("fetchEnd: ");
            a2.append(cVar.f8649b);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                Handler handler = this.f8760a;
                C0124a aVar = new C0124a(this, cVar, i2, j2);
                handler.post(aVar);
                return;
            }
            cVar.q.fetchEnd(cVar, i2, j2);
        }

        public void fetchProgress(e.i.a.c cVar, int i2, long j2) {
            if (cVar.p > 0) {
                cVar.t.set(SystemClock.uptimeMillis());
            }
            if (cVar.o) {
                Handler handler = this.f8760a;
                k kVar = new k(this, cVar, i2, j2);
                handler.post(kVar);
                return;
            }
            cVar.q.fetchProgress(cVar, i2, j2);
        }

        public void fetchStart(e.i.a.c cVar, int i2, long j2) {
            StringBuilder a2 = e.a.a.a.a.a("fetchStart: ");
            a2.append(cVar.f8649b);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            if (cVar.o) {
                Handler handler = this.f8760a;
                j jVar = new j(this, cVar, i2, j2);
                handler.post(jVar);
                return;
            }
            cVar.q.fetchStart(cVar, i2, j2);
        }

        public void taskEnd(e.i.a.c cVar, e.i.a.h.e.a aVar, Exception exc) {
            if (aVar == e.i.a.h.e.a.ERROR) {
                StringBuilder a2 = e.a.a.a.a.a("taskEnd: ");
                a2.append(cVar.f8649b);
                String str = " ";
                a2.append(str);
                a2.append(aVar);
                a2.append(str);
                a2.append(exc);
                e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            }
            e.i.a.b bVar = e.i.a.e.a().f8672i;
            if (bVar != null) {
                bVar.taskEnd(cVar, aVar, exc);
            }
            if (cVar.o) {
                this.f8760a.post(new C0125b(this, cVar, aVar, exc));
            } else {
                cVar.q.taskEnd(cVar, aVar, exc);
            }
        }

        public void taskStart(e.i.a.c cVar) {
            StringBuilder a2 = e.a.a.a.a.a("taskStart: ");
            a2.append(cVar.f8649b);
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            e.i.a.b bVar = e.i.a.e.a().f8672i;
            if (bVar != null) {
                bVar.taskStart(cVar);
            }
            if (cVar.o) {
                this.f8760a.post(new c(this, cVar));
            } else {
                cVar.q.taskStart(cVar);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f8758b = handler;
        this.f8757a = new b(handler);
    }

    public void a(Collection<c> collection) {
        if (collection.size() > 0) {
            StringBuilder a2 = e.a.a.a.a.a("endTasksWithCanceled canceled[");
            a2.append(collection.size());
            a2.append("]");
            e.i.a.h.c.a("CallbackDispatcher", a2.toString());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (!cVar.o) {
                    cVar.q.taskEnd(cVar, e.i.a.h.e.a.CANCELED, null);
                    it.remove();
                }
            }
            this.f8758b.post(new C0123a(this, collection));
        }
    }
}
