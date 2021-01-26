package e.c.d.j;

import com.baidu.picapture.model.net.panorama.NewPanoTaskResp;
import e.c.d.f.d.d;
import e.c.d.j.h1.a;

/* compiled from: lambda */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ a f6257a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f6258b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ NewPanoTaskResp f6259c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ d f6260d;

    public /* synthetic */ g(a aVar, int i2, NewPanoTaskResp newPanoTaskResp, d dVar) {
        this.f6257a = aVar;
        this.f6258b = i2;
        this.f6259c = newPanoTaskResp;
        this.f6260d = dVar;
    }

    public final void run() {
        this.f6257a.a(this.f6258b, this.f6259c, this.f6260d);
    }
}
