package e.e.a.g;

import e.e.a.d.h;
import e.e.a.d.i;
import e.e.a.e.b;

/* compiled from: BleScanPresenter */
public class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ b f7995a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ b f7996b;

    public a(b bVar, b bVar2) {
        this.f7996b = bVar;
        this.f7995a = bVar2;
    }

    public void run() {
        b bVar = this.f7996b;
        b bVar2 = this.f7995a;
        b bVar3 = f.this.f8022b;
        if (bVar3.f8000d) {
            h hVar = (h) bVar3.f8002f;
            if (hVar != null) {
                hVar.a();
                return;
            }
            return;
        }
        i iVar = (i) bVar3.f8002f;
        if (iVar != null) {
            iVar.onLeScan(bVar2);
        }
    }
}
