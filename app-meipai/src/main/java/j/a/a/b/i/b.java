package j.a.a.b.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import java.util.ArrayList;
import java.util.List;

public class b extends g {
    public b(BaseCamera baseCamera) {
        super(baseCamera);
    }

    public int a(boolean z) {
        return z ? 0 : 1;
    }

    public PreviewStreamResolution a() {
        return PreviewStreamResolution.STREAM_480_240_30FPS;
    }

    public PreviewStreamResolution b() {
        return PreviewStreamResolution.STREAM_1440_720_30FPS;
    }

    public List<PreviewStreamResolution> a(int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PreviewStreamResolution.STREAM_1440_720_30FPS);
        arrayList.add(PreviewStreamResolution.STREAM_3840_1920_30FPS);
        return arrayList;
    }
}
