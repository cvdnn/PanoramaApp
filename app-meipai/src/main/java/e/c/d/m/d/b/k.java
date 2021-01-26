package e.c.d.m.d.b;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.c.r;
import e.c.d.i.c.r.a;
import e.c.d.m.a.c;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: PanoramaGuidePresenter */
public class k extends c<i> implements h {

    /* renamed from: b reason: collision with root package name */
    public ScheduledFuture<?> f6649b;

    public k(i iVar) {
        super(iVar);
    }

    public /* synthetic */ void F() {
        r.f6218b.a((a<Boolean>) new j<Boolean>(this));
    }

    public void d() {
        ScheduledFuture<?> scheduledFuture = this.f6649b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f6649b = null;
        }
    }

    public void l() {
        if (this.f6649b == null) {
            this.f6649b = ThreadPoolService.scheduleAtFixedRate(new g(this), 1, 5, TimeUnit.SECONDS);
        }
    }
}
