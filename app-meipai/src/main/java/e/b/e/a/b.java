package e.b.e.a;

import com.arashivision.sdkmedia.export.IExportCallback;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IExportCallback f5832a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ float f5833b;

    public /* synthetic */ b(IExportCallback iExportCallback, float f2) {
        this.f5832a = iExportCallback;
        this.f5833b = f2;
    }

    public final void run() {
        this.f5832a.onProgress(this.f5833b);
    }
}
