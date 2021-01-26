package e.b.e.a;

import com.arashivision.sdkmedia.export.IExportCallback;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IExportCallback f5831a;

    public /* synthetic */ a(IExportCallback iExportCallback) {
        this.f5831a = iExportCallback;
    }

    public final void run() {
        this.f5831a.onFail();
    }
}
