package e.c.d.j;

import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.spin.SpinTaskInfo;
import e.c.d.j.j1.b;

/* compiled from: lambda */
public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f6229a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ SpinTaskInfo f6230b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ BaseResponse f6231c;

    public /* synthetic */ b0(b bVar, SpinTaskInfo spinTaskInfo, BaseResponse baseResponse) {
        this.f6229a = bVar;
        this.f6230b = spinTaskInfo;
        this.f6231c = baseResponse;
    }

    public final void run() {
        this.f6229a.a(this.f6230b, this.f6231c);
    }
}
