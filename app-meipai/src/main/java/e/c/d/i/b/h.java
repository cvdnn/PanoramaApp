package e.c.d.i.b;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.system.ErrnoException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.LanguageUtils;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: Camera1 */
public class h extends g {

    /* renamed from: g reason: collision with root package name */
    public Camera f6164g;

    /* renamed from: h reason: collision with root package name */
    public l f6165h;

    /* renamed from: i reason: collision with root package name */
    public Parameters f6166i;

    /* renamed from: j reason: collision with root package name */
    public String f6167j;
    public LottieAnimationView k;
    public int l = 90;
    public float m = 0.0f;
    public int n = 0;
    public boolean o = true;
    public boolean p = false;
    public List<Area> q;
    public List<Area> r;
    public PictureCallback s = new a();

    /* compiled from: Camera1 */
    public class a implements PictureCallback {
        public a() {
        }

        public /* synthetic */ void a(byte[] bArr) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(h.this.f6167j));
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                Utils.b(h.this.f6167j);
                h.a(h.this, 0, "");
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                e2.getMessage();
                h.a(h.this, -2, e2.getMessage());
            } catch (IOException e3) {
                e3.printStackTrace();
                e3.getMessage();
                if (e3.getCause() instanceof ErrnoException) {
                    h.a(h.this, -4, e3.getMessage());
                } else {
                    h.a(h.this, -1, e3.getMessage());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                e4.getMessage();
                h.a(h.this, -3, e4.getMessage());
            }
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            h hVar = h.this;
            hVar.a(hVar.f6161d, hVar.f6160c);
            ThreadPoolService.fixedThreadPool.execute(new a(this, bArr));
        }
    }

    public h(ViewGroup viewGroup) {
        a();
        this.f6165h = new l(viewGroup.getContext(), this.f6164g);
        this.k = (LottieAnimationView) viewGroup.findViewById(R.id.focus_rect);
        viewGroup.addView(this.f6165h, 0);
    }

    public static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public final void a() {
        Camera open = Camera.open();
        this.f6164g = open;
        Parameters parameters = open.getParameters();
        this.f6166i = parameters;
        parameters.setFocusMode(LanguageUtils.AUTO);
        this.f6164g.setParameters(this.f6166i);
    }

    public void b(int i2, int i3) {
        this.f6160c = i3;
        this.f6161d = i2;
        Iterator it = this.f6164g.getParameters().getSupportedPreviewSizes().iterator();
        while (true) {
            if (it.hasNext()) {
                Size size = (Size) it.next();
                if (size.width * i3 == size.height * i2) {
                    String.format(Locale.getDefault(), "[Camera1][setPreviewRatio] Find Preview Ratio width:%s height:%s", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height)});
                    this.f6166i.setPreviewSize(size.width, size.height);
                    break;
                }
            }
        }
        try {
            Size size2 = null;
            int i4 = 0;
            for (Size size3 : this.f6164g.getParameters().getSupportedPictureSizes()) {
                if (size3.width * i3 == size3.height * i2 && i4 < size3.height) {
                    i4 = size3.height;
                    size2 = size3;
                }
            }
            if (size2 != null) {
                String.format(Locale.getDefault(), "[Camera1][setPictureRatio] Find Picture Ratio width:%s height:%s", new Object[]{Integer.valueOf(size2.width), Integer.valueOf(size2.height)});
                this.f6166i.setPictureSize(size2.width, size2.height);
            }
            this.f6164g.setParameters(this.f6166i);
        } catch (Exception e2) {
            e2.toString();
        }
    }

    public void e() {
        if (this.f6159b) {
            this.f6159b = false;
            this.f6164g.cancelAutoFocus();
            this.f6164g.stopPreview();
        }
        this.f6164g.release();
        this.f6165h = null;
        this.f6166i = null;
        this.f6162e = null;
    }

    public void f() {
        if (this.f6159b) {
            this.f6159b = false;
            this.f6164g.cancelAutoFocus();
            this.f6164g.stopPreview();
        }
        this.o = true;
    }

    public void a(int i2, int i3) {
        if (!this.f6159b) {
            this.f6159b = true;
            try {
                b(i2, i3);
                if (this.n > 1) {
                    this.f6166i.setZoom(this.n);
                    this.f6164g.setParameters(this.f6166i);
                }
                if (this.q != null) {
                    this.f6166i.setFocusAreas(this.q);
                    this.f6164g.setParameters(this.f6166i);
                }
                this.f6164g.startPreview();
            } catch (RuntimeException unused) {
                a();
                this.f6165h.setCamera(this.f6164g);
                b(i2, i3);
                this.f6164g.startPreview();
            }
            this.f6165h.setOnTouchListener(new c(this));
        }
    }

    public void a(String str) {
        if (this.f6159b) {
            this.f6159b = false;
        }
        this.f6167j = str;
        this.f6165h.setOnTouchListener(null);
        int i2 = this.n;
        if (i2 >= 1) {
            this.f6166i.setZoom(i2);
            this.f6164g.setParameters(this.f6166i);
        }
        List<Area> list = this.q;
        if (list != null) {
            this.f6166i.setFocusAreas(list);
            this.f6164g.setParameters(this.f6166i);
        }
        List<Area> list2 = this.r;
        if (list2 != null) {
            this.f6166i.setMeteringAreas(list2);
            this.f6164g.setParameters(this.f6166i);
        }
        try {
            this.f6164g.autoFocus(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f6164g.takePicture(null, null, this.s);
            this.o = false;
        }
    }

    public /* synthetic */ void a(boolean z, Camera camera) {
        try {
            camera.takePicture(null, null, this.s);
        } catch (Exception e2) {
            e2.printStackTrace();
            b bVar = this.f6162e;
            if (bVar != null) {
                bVar.a(this.f6167j, -3, "");
            }
        }
        this.o = false;
    }

    public void a(int i2) {
        CameraInfo cameraInfo = new CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo2 = new CameraInfo();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= numberOfCameras) {
                i4 = -1;
                break;
            } else if (cameraInfo2.facing == 0) {
                break;
            } else {
                i4++;
            }
        }
        Camera.getCameraInfo(i4, cameraInfo);
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 90;
            } else if (i2 == 2) {
                i3 = HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 == 3) {
                i3 = HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE;
            }
        }
        int i5 = ((cameraInfo.orientation - i3) + 360) % 360;
        this.l = i5;
        this.f6164g.setDisplayOrientation(i5);
        this.f6166i.setRotation(this.l);
        this.f6164g.setParameters(this.f6166i);
    }

    public static /* synthetic */ void a(h hVar, int i2, String str) {
        b bVar = hVar.f6162e;
        if (bVar != null) {
            bVar.a(hVar.f6167j, i2, str);
        }
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getPointerCount() == 2 && this.o) {
            if (this.f6159b) {
                Parameters parameters = this.f6164g.getParameters();
                if (parameters.isZoomSupported()) {
                    int maxZoom = parameters.getMaxZoom();
                    if (maxZoom > 0) {
                        float x = motionEvent.getX(0) - motionEvent.getX(1);
                        float y = motionEvent.getY(0) - motionEvent.getY(1);
                        float sqrt = (float) Math.sqrt((double) ((y * y) + (x * x)));
                        float f2 = this.m;
                        if (f2 != 0.0f) {
                            if (sqrt > f2) {
                                int i2 = this.n;
                                if (maxZoom > i2) {
                                    this.n = i2 + 1;
                                    parameters.setZoom(this.n);
                                    this.f6164g.setParameters(parameters);
                                    this.p = true;
                                }
                            }
                            if (sqrt < this.m) {
                                int i3 = this.n;
                                if (i3 > 1) {
                                    this.n = i3 - 1;
                                }
                            }
                            try {
                                parameters.setZoom(this.n);
                                this.f6164g.setParameters(parameters);
                                this.p = true;
                            } catch (Exception e2) {
                                e2.toString();
                            }
                        }
                        this.m = sqrt;
                        z = true;
                    }
                }
            }
            return z;
        } else if (motionEvent.getPointerCount() != 1) {
            return true;
        } else {
            String str = "macro";
            if (this.f6159b) {
                if (motionEvent.getAction() == 1) {
                    if (this.p) {
                        this.p = false;
                    } else {
                        Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f);
                        Rect a3 = a(motionEvent.getX(), motionEvent.getY(), 1.5f);
                        String.format(Locale.getDefault(), "[Camera1][handleFocus] FocusRect: LeftTop(%d, %d), RightBottom(%d, %d)", new Object[]{Integer.valueOf(a2.left), Integer.valueOf(a2.top), Integer.valueOf(a2.right), Integer.valueOf(a2.bottom)});
                        try {
                            this.f6164g.cancelAutoFocus();
                            Parameters parameters2 = this.f6164g.getParameters();
                            String focusMode = parameters2.getFocusMode();
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                ArrayList arrayList = new ArrayList();
                                this.q = arrayList;
                                arrayList.add(new Area(a2, 1000));
                                if (parameters2.getSupportedFocusModes().contains(str)) {
                                    parameters2.setFocusMode(str);
                                } else {
                                    parameters2.setFocusMode(LanguageUtils.AUTO);
                                }
                                parameters2.setFocusAreas(this.q);
                                if (parameters2.getMaxNumMeteringAreas() > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    this.r = arrayList2;
                                    arrayList2.add(new Area(a3, 1000));
                                    parameters2.setMeteringAreas(this.r);
                                }
                                if (this.f6163f != null) {
                                    this.f6163f.onStart();
                                }
                                this.f6164g.setParameters(parameters2);
                                this.f6164g.autoFocus(new b(this, focusMode));
                                this.k.setAnimation((int) R.raw.focus_rect_anim);
                                this.k.setX(motionEvent.getX() - (((float) this.k.getWidth()) / 2.0f));
                                this.k.setY(motionEvent.getY() - (((float) this.k.getHeight()) / 2.0f));
                                this.k.setVisibility(0);
                                this.k.loop(false);
                                this.k.playAnimation();
                            }
                        } catch (Exception e3) {
                            e3.toString();
                        }
                    }
                }
                z = true;
            }
            return z;
        }
    }

    public /* synthetic */ void a(String str, boolean z, Camera camera) {
        if (this.f6159b) {
            Parameters parameters = camera.getParameters();
            parameters.setFocusMode(str);
            camera.setParameters(parameters);
        }
    }

    public final Rect a(float f2, float f3, float f4) {
        this.f6165h.getPreviewWidth();
        this.f6165h.getPreviewHeight();
        int i2 = (int) f2;
        int i3 = (int) f3;
        int intValue = Float.valueOf(f4 * 300.0f).intValue();
        float[] fArr = {(float) i2, (float) i3};
        float[] fArr2 = {0.0f, 0.0f};
        new m(false, this.l, this.f6165h.getPreviewRect()).f6187a.mapPoints(fArr2, fArr);
        int i4 = intValue / 2;
        int a2 = a(((int) fArr2[0]) - i4, -1000, 1000);
        int a3 = a(((int) fArr2[1]) - i4, -1000, 1000);
        return new Rect(a2, a3, a(a2 + intValue, -1000, 1000), a(intValue + a3, -1000, 1000));
    }
}
