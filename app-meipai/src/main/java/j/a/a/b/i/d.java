package j.a.a.b.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import j.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class d extends g {
    public d(BaseCamera baseCamera) {
        super(baseCamera);
    }

    public int a(boolean z) {
        return z ? 0 : 1;
    }

    public PreviewStreamResolution a() {
        return PreviewStreamResolution.STREAM_480_240_30FPS;
    }

    public PreviewStreamResolution b() {
        return PreviewStreamResolution.STREAM_2176_1088_30FPS;
    }

    public List<PreviewStreamResolution> a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 2) {
            arrayList.add(PreviewStreamResolution.STREAM_1920_960_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2560_1280_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3840_1920_30FPS);
        } else {
            arrayList.add(PreviewStreamResolution.STREAM_1440_720_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2176_1088_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3008_1504_100FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3840_1920_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3840_1920_50FPS);
            boolean z = true;
            if (i2 == 1) {
                if (a.a(this.f9927a.getFWVersion(), "1.18.20") < 0) {
                    z = false;
                }
                if (z) {
                    arrayList.add(PreviewStreamResolution.STREAM_5760_2880_24FPS);
                    arrayList.add(PreviewStreamResolution.STREAM_5760_2880_25FPS);
                }
                arrayList.add(PreviewStreamResolution.STREAM_5760_2880_30FPS);
            }
        }
        return arrayList;
    }
}
