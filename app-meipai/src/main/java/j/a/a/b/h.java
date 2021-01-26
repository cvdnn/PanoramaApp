package j.a.a.b;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType;
import com.arashivision.insta360.basecamera.camera.CameraManager;
import com.arashivision.insta360.basecamera.camera.CameraManager.IConfiguration;
import com.arashivision.insta360.basecamera.camera.CameraType;
import com.arashivision.insta360.basecamera.camera.check.ICameraCheck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h implements IConfiguration {
    public List<ICameraCheck> getCameraCheckActivationList(String str, ConnectType connectType) {
        return new ArrayList();
    }

    public List<CameraType> getSupportCamera() {
        return Arrays.asList(new CameraType[]{CameraType.NANOS, CameraType.ONEX, CameraType.AKIKO, CameraType.ONEX2});
    }

    public boolean onOpenCamera(ConnectType connectType, List<BaseCamera> list) {
        for (BaseCamera baseCamera : list) {
            if (baseCamera.getConnectType() == ConnectType.USB) {
                if (connectType == ConnectType.WIFI) {
                    CameraManager.getInstance().destroyCamera(baseCamera);
                }
            } else if (baseCamera.getConnectType() == ConnectType.WIFI && connectType == ConnectType.USB) {
                CameraManager.getInstance().destroyCamera(baseCamera);
            }
        }
        return true;
    }
}
