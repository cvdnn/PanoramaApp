package j.a.a.b.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.resolution.PreviewStreamResolution;
import e.c.f.n.n;
import java.util.ArrayList;
import java.util.List;

public class e extends g {
    public e(BaseCamera baseCamera) {
        super(baseCamera);
    }

    public int a(boolean z) {
        return 2;
    }

    public PreviewStreamResolution a() {
        return PreviewStreamResolution.STREAM_424_240_15FPS;
    }

    public PreviewStreamResolution b() {
        return PreviewStreamResolution.STREAM_1152_768_30FPS;
    }

    public List<PreviewStreamResolution> a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 2) {
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_30FPS);
        } else {
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            boolean e2 = n.e(this.f9927a.getFWVersion());
            arrayList.add(PreviewStreamResolution.STREAM_1152_768_30FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_1920_1080_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_1920_1080_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_60FPS);
            arrayList.add(PreviewStreamResolution.STREAM_1920_1080_120FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_2720_1530_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_2720_1530_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_2720_1530_60FPS);
            if (e2) {
                arrayList.add(PreviewStreamResolution.STREAM_3840_2160_24FPS);
                arrayList.add(PreviewStreamResolution.STREAM_3840_2160_25FPS);
            }
            arrayList.add(PreviewStreamResolution.STREAM_3840_2160_30FPS);
            arrayList.add(PreviewStreamResolution.STREAM_3840_2160_60FPS);
            if (z) {
                if (e2) {
                    arrayList.add(PreviewStreamResolution.STREAM_5312_2988_24FPS);
                    arrayList.add(PreviewStreamResolution.STREAM_5312_2988_25FPS);
                }
                arrayList.add(PreviewStreamResolution.STREAM_5312_2988_30FPS);
            }
        }
        return arrayList;
    }
}
