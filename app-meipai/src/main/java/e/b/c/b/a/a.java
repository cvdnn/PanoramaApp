package e.b.c.b.a;

import android.util.Pair;
import com.arashivision.insta360.basemedia.export.ExportManager.IL1Iii;
import com.arashivision.insta360.basemedia.export.IExportTask;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IL1Iii f5759a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pair f5760b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ IExportTask.IL1Iii f5761c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f5762d;

    public /* synthetic */ a(IL1Iii iL1Iii, Pair pair, IExportTask.IL1Iii iL1Iii2, String str) {
        this.f5759a = iL1Iii;
        this.f5760b = pair;
        this.f5761c = iL1Iii2;
        this.f5762d = str;
    }

    public final void run() {
        this.f5759a.IL1Iii(this.f5760b, this.f5761c, this.f5762d);
    }
}
