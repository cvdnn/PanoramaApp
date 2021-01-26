package e.c.d.m.i.h;

import com.baidu.picapture.ui.widget.bdwebview.NativeBridge;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ NativeBridge f6805a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6806b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f6807c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a f6808d;

    public /* synthetic */ a(NativeBridge nativeBridge, String str, String str2, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a aVar) {
        this.f6805a = nativeBridge;
        this.f6806b = str;
        this.f6807c = str2;
        this.f6808d = aVar;
    }

    public final void run() {
        this.f6805a.b(this.f6806b, this.f6807c, this.f6808d);
    }
}
