package e.c.d.m.e.a;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.a.b0;
import e.c.d.i.a.z;
import java.util.TimerTask;

/* compiled from: SpinCapturePresenter */
public class v extends TimerTask {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ u f6691a;

    public v(u uVar) {
        this.f6691a = uVar;
    }

    public /* synthetic */ void a() {
        u uVar = this.f6691a;
        if (uVar != null) {
            b0 f2 = b0.impl();
            z zVar = uVar.o;
            if (f2.p.contains(zVar)) {
                f2.p.unregisterObserver(zVar);
            }
            ((SpinCaptureContact) uVar.f6403a).I();
            return;
        }
        throw null;
    }

    public void run() {
        ThreadPoolService.post(new p(this));
    }
}
