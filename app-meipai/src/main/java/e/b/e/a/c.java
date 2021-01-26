package e.b.e.a;

import com.arashivision.sdkmedia.export.IExportCallback;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IExportCallback f5834a;

    public /* synthetic */ c(IExportCallback iExportCallback) {
        this.f5834a = iExportCallback;
    }

    public final void run() {
        this.f5834a.onCancel();
    }
}
