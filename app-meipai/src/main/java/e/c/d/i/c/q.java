package e.c.d.i.c;

import com.arashivision.sdkmedia.export.IExportCallback;
import e.b.e.a.e;
import e.c.d.i.c.r.a;

/* compiled from: SphericalCamera */
public class q implements IExportCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f6217a;

    public q(r rVar, a aVar) {
        this.f6217a = aVar;
    }

    public void onCancel() {
        this.f6217a.a("", -2);
    }

    public void onFail() {
        this.f6217a.a("", -1);
    }

    public /* synthetic */ void onProgress(float f2) {
        e.$default$onProgress(this, f2);
    }

    public void onSuccess() {
        this.f6217a.a("", 0);
    }
}
