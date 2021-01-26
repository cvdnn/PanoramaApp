package c.a.a.a.a;

import android.text.TextUtils;
import com.arashivision.camera.listener.OnStillImageListener;
import com.arashivision.insta360.basecamera.camera.BaseCameraController;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.onecamera.cameranotification.Photo;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.TakePictureWithoutStorageResponse;
import e.a.a.a.a;

public class c implements OnStillImageListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BaseCameraController f1118a;

    public c(BaseCameraController baseCameraController) {
        this.f1118a = baseCameraController;
    }

    public void onDriverStillImageNotify(TakePictureResponse takePictureResponse) {
        CameraLogger cameraLogger = BaseCameraController.OoooOOo;
        StringBuilder a2 = a.a("onDriverStillImageNotify, errorCode: ");
        a2.append(takePictureResponse.error_code);
        a2.append(", image: ");
        a2.append(takePictureResponse.image.uri);
        a2.append(", aeb_images_size: ");
        a2.append(takePictureResponse.aeb_images.length);
        cameraLogger.d(a2.toString());
        if (this.f1118a.OooOo00() || this.f1118a.OooOOOO() || this.f1118a.OooOOoo() || this.f1118a.OooOOO0()) {
            int i2 = 0;
            if (this.f1118a.OooOo00() && !TextUtils.isEmpty(takePictureResponse.image.uri)) {
                String[] strArr = {takePictureResponse.image.uri};
                this.f1118a.OooOooo = strArr;
            }
            if (this.f1118a.OooOOOO() || this.f1118a.OooOOoo()) {
                Photo[] photoArr = takePictureResponse.aeb_images;
                if (photoArr != null && photoArr.length > 0) {
                    String[] strArr2 = new String[photoArr.length];
                    while (true) {
                        Photo[] photoArr2 = takePictureResponse.aeb_images;
                        if (i2 >= photoArr2.length) {
                            break;
                        }
                        strArr2[i2] = photoArr2[i2].uri;
                        i2++;
                    }
                    this.f1118a.OooOooo = strArr2;
                }
            }
            this.f1118a.Oooo000 = Integer.valueOf(takePictureResponse.error_code);
            this.f1118a.OooOoOO();
        }
    }

    public void onDriverStillImageWithoutStorageNotify(TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        CameraLogger cameraLogger = BaseCameraController.OoooOOo;
        StringBuilder a2 = a.a("onDriverStillImageWithoutStorageNotify, status: ");
        a2.append(takePictureWithoutStorageResponse.status);
        cameraLogger.d(a2.toString());
    }
}
