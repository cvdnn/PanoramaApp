package e.e.a.g;

import android.os.Handler;
import android.os.Looper;
import e.e.a.d.h;
import e.e.a.d.i;
import e.e.a.e.b;
import e.e.a.g.f.a;
import java.util.List;

/* compiled from: BleScanPresenter */
public class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ b f8012a;

    public c(b bVar) {
        this.f8012a = bVar;
    }

    public void run() {
        b bVar = this.f8012a;
        List<b> list = bVar.f8003g;
        a aVar = (a) bVar;
        b bVar2 = f.this.f8022b;
        if (bVar2.f8000d) {
            h hVar = (h) bVar2.f8002f;
            if (list != null && list.size() >= 1) {
                if (hVar != null) {
                    hVar.a((b) list.get(0));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new e(aVar, list, hVar), 100);
            } else if (hVar != null) {
                hVar.a(null);
            }
        } else {
            i iVar = (i) bVar2.f8002f;
            if (iVar != null) {
                iVar.onScanFinished(list);
            }
        }
    }
}
