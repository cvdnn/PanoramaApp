package e.c.d.j;

import com.baidu.picapture.model.net.BaseResponse;
import g.e;

/* compiled from: lambda */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ i1 f6321a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ e f6322b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ int f6323c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ BaseResponse f6324d;

    public /* synthetic */ w(i1 i1Var, e eVar, int i2, BaseResponse baseResponse) {
        this.f6321a = i1Var;
        this.f6322b = eVar;
        this.f6323c = i2;
        this.f6324d = baseResponse;
    }

    public final void run() {
        this.f6321a.a(this.f6322b, this.f6323c, this.f6324d);
    }
}
