package e.c.d.k;

import com.baidu.picapture.nativeapi.Tools;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;

/* compiled from: lambda */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Tools f6356a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6357b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f6358c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ a f6359d;

    public /* synthetic */ m(Tools tools, String str, String str2, a aVar) {
        this.f6356a = tools;
        this.f6357b = str;
        this.f6358c = str2;
        this.f6359d = aVar;
    }

    public final void run() {
        this.f6356a.a(this.f6357b, this.f6358c, this.f6359d);
    }
}
