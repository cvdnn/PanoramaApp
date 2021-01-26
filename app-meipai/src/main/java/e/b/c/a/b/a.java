package e.b.c.a.b;

import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0152OooOOo0;
import com.arashivision.insta360.basecamera.util.CameraMediaUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: lambda */
public final /* synthetic */ class a implements C0152OooOOo0 {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ArrayList f5755a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f5756b;

    public /* synthetic */ a(ArrayList arrayList, CountDownLatch countDownLatch) {
        this.f5755a = arrayList;
        this.f5756b = countDownLatch;
    }

    public final void OooO00o(int i2, List list) {
        CameraMediaUtils.OooO00o(this.f5755a, this.f5756b, i2, list);
    }
}
