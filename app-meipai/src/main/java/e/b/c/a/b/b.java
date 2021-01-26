package e.b.c.a.b;

import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0150OooOOOo;
import com.arashivision.insta360.basecamera.util.CameraMediaUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: lambda */
public final /* synthetic */ class b implements C0150OooOOOo {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ HashMap f5757a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f5758b;

    public /* synthetic */ b(HashMap hashMap, CountDownLatch countDownLatch) {
        this.f5757a = hashMap;
        this.f5758b = countDownLatch;
    }

    public final void OooO0O0(int i2, List list) {
        CameraMediaUtils.OooO00o(this.f5757a, this.f5758b, i2, list);
    }
}
