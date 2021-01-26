package c.a.a.a.a;

import android.text.TextUtils;
import com.arashivision.camera.listener.ITimelapseListener;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus;
import com.arashivision.insta360.basecamera.camera.BaseCameraController;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import e.a.a.a.a;
import java.util.Locale;

public class d implements ITimelapseListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BaseCameraController f1119a;

    public d(BaseCameraController baseCameraController) {
        this.f1119a = baseCameraController;
    }

    public void ononTimelapseRecordNotify(int i2, VideoResult videoResult) {
        BaseCameraController baseCameraController;
        CameraLogger cameraLogger = BaseCameraController.OoooOOo;
        StringBuilder a2 = a.a("onTimelapseRecordNotify, state: ", i2, ", errorCode: ");
        a2.append(videoResult.error_code);
        a2.append(", uri: ");
        a2.append(videoResult.video.uri);
        a2.append(", fileSize: ");
        a2.append(videoResult.video.file_size);
        a2.append(", totalTime: ");
        a2.append(videoResult.video.total_time);
        cameraLogger.d(a2.toString());
        Integer valueOf = Integer.valueOf(0);
        if (i2 == 0) {
            BaseCameraController baseCameraController2 = this.f1119a;
            if (baseCameraController2.OooOoo != CaptureStatus.STARTING) {
                return;
            }
            if (baseCameraController2.OooOOo()) {
                BaseCameraController baseCameraController3 = this.f1119a;
                baseCameraController3.OooO00o(baseCameraController3.OooOoo0, (Integer) null, valueOf);
                return;
            }
            BaseCameraController baseCameraController4 = this.f1119a;
            baseCameraController4.OooO00o(baseCameraController4.OooOoo0, valueOf, (Integer) null);
        } else if (i2 == 1 || i2 == 2) {
            if (!this.f1119a.OooOOo()) {
                BaseCameraController baseCameraController5 = this.f1119a;
                baseCameraController5.OooOooo = baseCameraController5.OooO00o(videoResult.video.uri);
            } else if (!TextUtils.isEmpty(videoResult.video.uri)) {
                String str = videoResult.video.uri;
                int lastIndexOf = str.lastIndexOf("_") + 1;
                int indexOf = str.indexOf(".");
                String substring = str.substring(0, lastIndexOf);
                String substring2 = str.substring(indexOf);
                int parseInt = Integer.parseInt(str.substring(lastIndexOf, indexOf));
                String[] strArr = new String[this.f1119a.Oooo00O];
                int i3 = 0;
                while (true) {
                    baseCameraController = this.f1119a;
                    if (i3 >= baseCameraController.Oooo00O) {
                        break;
                    }
                    strArr[i3] = a.a(substring, String.format(Locale.ENGLISH, "%03d", new Object[]{Integer.valueOf(parseInt + i3)}), substring2);
                    i3++;
                }
                baseCameraController.OooOooo = strArr;
            }
            this.f1119a.Oooo000 = Integer.valueOf(videoResult.error_code);
            this.f1119a.OooOoOO();
        }
    }
}
