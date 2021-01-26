package e.b.e.a;

import com.arashivision.sdkmedia.export.IExportCallback;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IExportCallback f5835a;

    public /* synthetic */ d(IExportCallback iExportCallback) {
        this.f5835a = iExportCallback;
    }

    public final void run() {
        this.f5835a.onSuccess();
    }
}
