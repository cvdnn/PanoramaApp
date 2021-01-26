package e.c.d.k;

import com.baidu.picapture.model.nativeapi.UnZipTask;
import com.baidu.picapture.nativeapi.Tools;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;

/* compiled from: lambda */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Tools f6360a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ UnZipTask f6361b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ a f6362c;

    public /* synthetic */ n(Tools tools, UnZipTask unZipTask, a aVar) {
        this.f6360a = tools;
        this.f6361b = unZipTask;
        this.f6362c = aVar;
    }

    public final void run() {
        this.f6360a.a(this.f6361b, this.f6362c);
    }
}
