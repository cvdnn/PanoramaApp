package e.c.d.m.e.b;

import android.os.Bundle;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidu.picapture.model.spin.SpinTaskInfo;
import com.baidubce.BceConfig;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.f.b.b;
import e.c.d.j.e0;
import e.c.d.j.f0;
import e.c.d.j.j1;
import e.c.d.j.j1.d;
import e.c.d.m.a.c;
import e.c.d.n.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: SpinDetailPresenter */
public class q extends c<p> implements o {

    /* renamed from: b reason: collision with root package name */
    public String f6718b;

    /* renamed from: c reason: collision with root package name */
    public String f6719c;

    /* renamed from: d reason: collision with root package name */
    public List<HotSpot> f6720d;

    /* renamed from: e reason: collision with root package name */
    public ScheduledFuture<?> f6721e;

    /* renamed from: f reason: collision with root package name */
    public d f6722f = new a();

    /* compiled from: SpinDetailPresenter */
    public class a implements d {
        public a() {
        }

        public /* synthetic */ void a() {
            if (q.this == null) {
                throw null;
            }
        }

        public void b(SpinTaskInfo spinTaskInfo) {
            if (q.this.f6718b.equalsIgnoreCase(spinTaskInfo.getTask().f6072a)) {
                ThreadPoolService.post(new h(this));
            }
        }

        public /* synthetic */ void c(SpinTaskInfo spinTaskInfo) {
            q qVar = q.this;
            String str = spinTaskInfo.getTask().f6073b;
            String str2 = spinTaskInfo.getTask().f6076e;
            if (qVar != null) {
                qVar.f6721e = ThreadPoolService.scheduleAtFixedRate(new m(qVar, str, str2), 0, 3, TimeUnit.SECONDS);
                V v = qVar.f6403a;
                if (v != null) {
                    ((p) v).t();
                    return;
                }
                return;
            }
            throw null;
        }

        public void a(SpinTaskInfo spinTaskInfo, float f2) {
            if (q.this.f6718b.equalsIgnoreCase(spinTaskInfo.getTask().f6072a)) {
                ThreadPoolService.post(new f(this, f2));
            }
        }

        public /* synthetic */ void a(float f2) {
            int i2 = (int) f2;
            V v = q.this.f6403a;
            if (v != null) {
                ((p) v).k(i2);
            }
        }

        public void a(SpinTaskInfo spinTaskInfo, int i2) {
            if (q.this.f6718b.equalsIgnoreCase(spinTaskInfo.getTask().f6072a)) {
                j1.e().a(q.this.f6722f);
                ThreadPoolService.post(new e(this, i2));
            }
        }

        public /* synthetic */ void a(int i2) {
            q qVar = q.this;
            V v = qVar.f6403a;
            if (v != null) {
                ((p) v).Y();
                qVar.F();
            }
        }

        public void a(SpinTaskInfo spinTaskInfo) {
            if (q.this.f6718b.equalsIgnoreCase(spinTaskInfo.getTask().f6072a)) {
                j1.e().a(q.this.f6722f);
                ThreadPoolService.post(new g(this, spinTaskInfo));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [e.c.d.m.e.b.p, e.c.d.m.a.e] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=e.c.d.m.e.b.p, code=null, for r1v0, types: [e.c.d.m.e.b.p, e.c.d.m.a.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(e.c.d.m.e.b.p r1) {
        /*
            r0 = this;
            r0.<init>(r1)
            e.c.d.m.e.b.q$a r1 = new e.c.d.m.e.b.q$a
            r1.<init>()
            r0.f6722f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.m.e.b.q.<init>(e.c.d.m.e.b.p):void");
    }

    public final void F() {
        ThreadPoolService.schedule(new d(this), 2, TimeUnit.SECONDS);
    }

    public /* synthetic */ void G() {
        ThreadPoolService.post(new n(this));
    }

    public final void H() {
        e.c.d.f.d.c cVar = new e.c.d.f.d.c();
        cVar.f6076e = this.f6719c;
        cVar.f6072a = this.f6718b;
        int i2 = e.h().getInt("round_total_count", -1);
        if (i2 < 0) {
            i2 = 36;
        }
        cVar.f6079h = i2;
        j1 e2 = j1.e();
        if (e2 != null) {
            cVar.f6077f = 1;
            cVar.f6075d = e.c.d.d.c.e.f6006d.f6009c;
            b b2 = b.b();
            if (b2 != null) {
                cVar.f6078g = new Date();
                b2.a().c(cVar);
                SpinTaskInfo spinTaskInfo = new SpinTaskInfo();
                spinTaskInfo.setTask(cVar);
                e2.f6284g.observable(new e0(spinTaskInfo));
                e2.f6254a.execute(new f0(e2, spinTaskInfo));
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void I() {
        ScheduledFuture<?> scheduledFuture = this.f6721e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f6721e = null;
        }
    }

    public void a(String str, String str2) {
        this.f6718b = str;
        this.f6719c = str2;
    }

    public void b(Bundle bundle) {
        bundle.putString("task_id", this.f6718b);
    }

    public /* synthetic */ void c(String str, String str2) {
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        r rVar = new r(this, str, str2);
        if (a2 != null) {
            g.x.a aVar = new g.x.a();
            StringBuilder sb = new StringBuilder();
            sb.append("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v2/package/");
            sb.append(str);
            sb.append("/detail");
            aVar.a(sb.toString());
            aVar.b();
            a2.f6374a.a(aVar.a()).a(rVar);
            return;
        }
        throw null;
    }

    public void d(int i2) {
        if (i2 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.j(this.f6718b));
            sb.append(BceConfig.BOS_DELIMITER);
            sb.append(((HotSpot) this.f6720d.get(i2)).getImg());
            ((p) this.f6403a).a(sb.toString(), this.f6718b, (HotSpot) this.f6720d.get(i2));
        } else if (this.f6720d.size() <= 10) {
            String str = this.f6718b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(e.j(str));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e.j(str));
            String str2 = "/hotspots";
            sb2.append(str2);
            arrayList.add(sb2.toString());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                e.b((String) it.next());
            }
            String str3 = this.f6718b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(e.j(str3));
            sb3.append(str2);
            String sb4 = sb3.toString();
            long time = new Date().getTime();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("/hotspot-");
            sb5.append(time);
            sb5.append(".jpg");
            ((p) this.f6403a).d(this.f6718b, sb5.toString());
        }
    }

    public void e() {
        super.e();
        j1.e().a(this.f6722f);
        I();
    }

    public void g() {
        if (this.f6403a != null) {
            i.b.a.c.b().a((Object) new e.c.d.g.d("#/materials?type=spin"));
            ((p) this.f6403a).a();
        }
    }

    public void j() {
        j1 e2 = j1.e();
        d dVar = this.f6722f;
        if (!e2.f6284g.contains(dVar)) {
            e2.f6284g.registerObserver(dVar);
        }
        H();
        ((p) this.f6403a).V();
    }

    public void q() {
        H();
        ((p) this.f6403a).b(App.f1954b.getString(R.string.asset_is_saved));
        ((p) this.f6403a).d();
    }

    public void start() {
        File[] i2 = e.i(this.f6718b);
        if (i2.length > 0) {
            ((p) this.f6403a).b(i2[0]);
        }
        List<HotSpot> f2 = e.f(this.f6718b);
        this.f6720d = f2;
        if (f2 == null) {
            this.f6720d = new ArrayList();
        }
        HotSpot hotSpot = new HotSpot();
        hotSpot.setTitle("capture");
        this.f6720d.add(0, hotSpot);
        ((p) this.f6403a).a(this.f6720d, this.f6718b);
    }

    public void u() {
        ((p) this.f6403a).d(this.f6718b);
    }

    public void y() {
        e.c(this.f6718b);
        ((p) this.f6403a).d();
    }

    public void a(Bundle bundle) {
        this.f6718b = bundle.getString("task_id", "");
    }

    public static /* synthetic */ void a(q qVar, String str, int i2) {
        V v = qVar.f6403a;
        if (v != null) {
            if (i2 == -20) {
                ((p) v).f(2);
                return;
            }
            ((p) v).f(1);
            qVar.F();
        }
    }
}
