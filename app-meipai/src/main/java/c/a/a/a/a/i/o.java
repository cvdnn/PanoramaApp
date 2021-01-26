package c.a.a.a.a.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0151OooOOo;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.onecamera.OneDriverInfo;
import com.arashivision.onecamera.Options;
import com.arashivision.onestream.Gyro.GyroType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class o extends BaseCameraController {

    /* renamed from: a reason: collision with root package name */
    public static CameraLogger f1182a = CameraLogger.getLogger(o.class);

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Options options) {
        CameraLogger cameraLogger = f1182a;
        StringBuilder sb = new StringBuilder();
        sb.append("syncOptions, errorCode: ");
        sb.append(i2);
        cameraLogger.d(sb.toString());
        OooO00o(i2 == 0 ? OooO0O0.READY : OooO0O0.ERROR, 0);
    }

    public List<String> OooO() {
        return new ArrayList();
    }

    public GyroType OooO0o0() {
        return GyroType.Unknown;
    }

    public int[] OooO0oo() {
        return new int[0];
    }

    public int[] OooOO0() {
        return new int[0];
    }

    public boolean OooOo() {
        return false;
    }

    public void OooOooo() {
        OooO00o(Arrays.asList(new String[]{OneDriverInfo.Options.MEDIA_OFFSET}), (C0151OooOOo) new e(this));
    }
}
