package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.l.d;
import com.arashivision.arvbmg.render.camera.GestureController;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.capture.ICaptureParams;
import com.arashivision.insta360.basemedia.ui.player.image.IImageParams;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.util.Arrays;

public class f {

    /* renamed from: h reason: collision with root package name */
    public static final MediaLogger f511h = MediaLogger.getLogger(f.class);

    /* renamed from: a reason: collision with root package name */
    public b f512a;

    /* renamed from: b reason: collision with root package name */
    public BaseCameraController f513b;

    /* renamed from: c reason: collision with root package name */
    public boolean f514c = false;

    /* renamed from: d reason: collision with root package name */
    public float f515d = 0.0f;

    /* renamed from: e reason: collision with root package name */
    public float f516e = 0.0f;

    /* renamed from: f reason: collision with root package name */
    public float f517f = 0.0f;

    /* renamed from: g reason: collision with root package name */
    public float f518g = 0.0f;

    public void a(float f2, float f3) {
        BaseCameraController baseCameraController;
        if (!a() || this.f513b == null) {
            f511h.e("setFovDistance, but camera is not available or mCameraController is null");
            return;
        }
        if (this.f512a.getFileType() == FileType.FISH_EYE) {
            boolean a2 = d.a(this.f512a.isRotateEnabled(), this.f512a.getRotateDegree());
            boolean z = this.f512a.getFitMode() != 3 ? a2 : this.f512a.isRotateScreenRatioEnabled() && a2 && Arrays.equals(this.f512a.getConstraintRatio(), this.f512a.getScreenRatio());
            int[] a3 = d.a(this.f512a.getScreenRatio(), z);
            float f4 = (((float) a3[0]) * 1.0f) / ((float) a3[1]);
            int[] a4 = d.a(this.f512a.getConstraintRatio(), a2);
            float f5 = (((float) a4[0]) * 1.0f) / ((float) a4[1]);
            if (this.f512a.getFitMode() == 3 && f4 >= f5) {
                f2 = (float) (Math.atan(Math.tan(((double) f2) / 2.0d) * ((double) ((f5 * 1.0f) / f4))) * 2.0d);
            }
        }
        if (this.f514c) {
            this.f513b.setFov(Math.min(Math.max(f2, this.f512a.getConstraint().getMinFov()), this.f512a.getConstraint().getMaxFov()));
            baseCameraController = this.f513b;
            f3 = Math.min(Math.max(f3, this.f512a.getConstraint().getMinDistance()), this.f512a.getConstraint().getMaxDistance());
        } else {
            this.f513b.setFov(f2);
            baseCameraController = this.f513b;
        }
        baseCameraController.setDistance(f3);
    }

    public void a(float f2, float f3, float f4) {
        if (a()) {
            BaseCameraController baseCameraController = this.f513b;
            if (baseCameraController != null) {
                this.f515d = f2;
                this.f516e = f3;
                baseCameraController.setYaw(f2 + this.f517f);
                this.f513b.setPitch(this.f516e + this.f518g);
                this.f513b.setRoll(f4);
                return;
            }
        }
        f511h.e("setYawPitchRoll, but camera is not available or mCameraController is null");
    }

    public void a(float f2, float f3, boolean z) {
        if (!a() || this.f513b == null) {
            f511h.e("updateHorizontalVerticalRoll, but camera is not available or mCameraController is null");
            return;
        }
        if (z) {
            f2 = -f2;
        }
        this.f517f = f2;
        this.f518g = f3;
        this.f513b.setYaw(this.f515d + f2);
        this.f513b.setPitch(this.f516e + this.f518g);
    }

    public void a(b bVar) {
        this.f512a = bVar;
        if (bVar.getConstraint() == null) {
            b bVar2 = this.f512a;
            boolean z = bVar2 instanceof IImageParams;
            String str = Config.EVENT_HEAT_X;
            String str2 = ", Size: ";
            String str3 = ", FileType: ";
            String str4 = ", CameraType: ";
            if (z) {
                IImageParams iImageParams = (IImageParams) bVar2;
                MediaLogger mediaLogger = f511h;
                StringBuilder a2 = a.a("setCameraParams(image), but constraint is null! isValid: ");
                a2.append(iImageParams.isValid());
                a2.append(str4);
                a2.append(iImageParams.getCameraType());
                a2.append(str3);
                a2.append(iImageParams.getFileType());
                a2.append(str2);
                a2.append(iImageParams.getWidth());
                a2.append(str);
                a2.append(iImageParams.getHeight());
                mediaLogger.e(a2.toString());
            }
            b bVar3 = this.f512a;
            if (bVar3 instanceof IVideoParams) {
                IVideoParams iVideoParams = (IVideoParams) bVar3;
                MediaLogger mediaLogger2 = f511h;
                StringBuilder a3 = a.a("setCameraParams(video), but constraint is null! isValid: ");
                a3.append(iVideoParams.isValid());
                a3.append(str4);
                a3.append(iVideoParams.getCameraType());
                a3.append(str3);
                a3.append(iVideoParams.getFileType());
                a3.append(str2);
                a3.append(iVideoParams.getWidth());
                a3.append(str);
                a3.append(iVideoParams.getHeight());
                mediaLogger2.e(a3.toString());
            }
            b bVar4 = this.f512a;
            if (bVar4 instanceof ICaptureParams) {
                ICaptureParams iCaptureParams = (ICaptureParams) bVar4;
                MediaLogger mediaLogger3 = f511h;
                StringBuilder a4 = a.a("setCameraParams(capture), but constraint is null! FileType: ");
                a4.append(iCaptureParams.getFileType());
                mediaLogger3.e(a4.toString());
            }
        }
    }

    public void a(GestureController gestureController) {
        if (gestureController != null) {
            gestureController.setRotate(new float[]{0.0f, 0.0f});
            Transform b2 = b();
            a(gestureController.getFov(), gestureController.getDistance());
            a(gestureController.getRotate()[0], gestureController.getRotate()[1], false);
            a(b2.getYaw(), b2.getPitch(), b2.getRoll());
        }
    }

    public void a(BaseCameraController baseCameraController) {
        this.f513b = baseCameraController;
        baseCameraController.setFov(this.f512a.getConstraint().getDefaultFov());
        this.f513b.setDistance(this.f512a.getConstraint().getDefaultDistance());
        d();
    }

    public void a(Transform transform) {
        a(transform.getFov(), transform.getDistance());
        a(transform.getYaw(), transform.getPitch(), transform.getRoll());
    }

    public boolean a() {
        b bVar = this.f512a;
        return (bVar == null || bVar.getFileType() == FileType.UNPANORAMA) ? false : true;
    }

    public boolean a(int i2) {
        b bVar = this.f512a;
        return (bVar == null || bVar.getCameraFacing() == -1 || (i2 != 2 && i2 != 3 && i2 != 11)) ? false : true;
    }

    public Transform b() {
        if (a()) {
            BaseCameraController baseCameraController = this.f513b;
            if (baseCameraController != null) {
                Transform transform = new Transform(baseCameraController.getYaw(), this.f513b.getPitch(), this.f513b.getRoll(), this.f513b.getDistance(), this.f513b.getFov());
                return transform;
            }
        }
        return null;
    }

    public void c() {
        this.f512a = null;
        this.f513b = null;
    }

    public void d() {
        float f2;
        BaseCameraController baseCameraController;
        if (!a() || this.f513b == null) {
            f511h.e("setScale, but camera is not available or mCameraController is null");
            return;
        }
        if (this.f512a.getRotateDegree() == 90 || this.f512a.getRotateDegree() == 270) {
            this.f513b.setXScale(this.f512a.getConstraint().getYScale());
            baseCameraController = this.f513b;
            f2 = this.f512a.getConstraint().getXScale();
        } else {
            this.f513b.setXScale(this.f512a.getConstraint().getXScale());
            baseCameraController = this.f513b;
            f2 = this.f512a.getConstraint().getYScale();
        }
        baseCameraController.setYScale(f2);
    }

    public void e() {
        if (this.f512a.getFileType() != FileType.UNPANORAMA) {
            int[] a2 = this.f512a.getConstraint().getPovMode() == 1 ? new int[]{4, 3} : d.a(this.f512a.getConstraintRatio(), d.a(this.f512a.isRotateEnabled(), this.f512a.getRotateDegree()));
            if (a()) {
                BaseCameraController baseCameraController = this.f513b;
                if (baseCameraController != null && a2[0] > 0 && a2[1] > 0) {
                    baseCameraController.setAspect((((float) a2[0]) * 1.0f) / ((float) a2[1]));
                }
            }
        }
    }
}
