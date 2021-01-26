package e.i.a.h.j;

import e.a.a.a.a;
import java.io.IOException;

/* compiled from: MultiPointOutputStream */
public class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ f f8864a;

    public d(f fVar) {
        this.f8864a = fVar;
    }

    public void run() {
        f fVar = this.f8864a;
        if (fVar != null) {
            try {
                fVar.d();
            } catch (IOException e2) {
                fVar.s = e2;
                StringBuilder a2 = a.a("Sync to breakpoint-store for task[");
                a2.append(fVar.f8875j.f8649b);
                a2.append("] ");
                a2.append("failed with cause: ");
                a2.append(e2);
                a2.toString();
            }
        } else {
            throw null;
        }
    }
}
