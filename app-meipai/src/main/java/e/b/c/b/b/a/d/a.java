package e.b.c.b.b.a.d;

import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer.SequenceStabilizerCallback;
import com.arashivision.insta360.basemedia.ui.player.video.SimpleVideoParams;

/* compiled from: lambda */
public final /* synthetic */ class a implements SequenceStabilizerCallback {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ SimpleVideoParams f5781a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ a.a.a.a.a.e.a f5782b;

    public /* synthetic */ a(SimpleVideoParams simpleVideoParams, a.a.a.a.a.e.a aVar) {
        this.f5781a = simpleVideoParams;
        this.f5782b = aVar;
    }

    public final void onLoadingProgress(long j2, long j3) {
        this.f5781a.IL1Iii(this.f5782b, j2, j3);
    }
}
