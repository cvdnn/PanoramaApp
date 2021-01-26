package j.a.a.b.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import e.c.f.n.n;
import java.util.ArrayList;
import java.util.List;

public class f extends g {
    public f(BaseCamera baseCamera) {
        super(baseCamera);
    }

    public int a(boolean z) {
        return 2;
    }

    public PreviewStreamResolution a() {
        return PreviewStreamResolution.STREAM_424_240_15FPS;
    }

    public PreviewStreamResolution b() {
        return PreviewStreamResolution.STREAM_1280_720_30FPS;
    }

    public List<PreviewStreamResolution> a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 2) {
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_30FPS);
        } else {
            boolean e2 = n.e(this.f9927a.getFWVersion());
            arrayList.add(PreviewStreamResolution.STREAM_1280_960_30FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_1920_1080_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_1920_1080_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_60FPS);
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_120FPS);
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_200FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_1920_1440_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_1920_1440_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_1920_1440_30FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_2720_1530_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_2720_1530_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_60FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_100FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_2720_2040_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_2720_2040_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_2720_2040_30FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_3840_2160_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_3840_2160_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_3840_2160_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3840_2160_60FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_4000_3000_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_4000_3000_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_4000_3000_30FPS);
        }
        return arrayList;
    }
}
