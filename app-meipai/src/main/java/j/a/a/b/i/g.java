package j.a.a.b.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import java.util.List;

public abstract class g {

    /* renamed from: a reason: collision with root package name */
    public BaseCamera f9927a;

    public g(BaseCamera baseCamera) {
        this.f9927a = baseCamera;
    }

    public abstract int a(boolean z);

    public abstract PreviewStreamResolution a();

    public abstract List<PreviewStreamResolution> a(int i2);

    public abstract PreviewStreamResolution b();
}
