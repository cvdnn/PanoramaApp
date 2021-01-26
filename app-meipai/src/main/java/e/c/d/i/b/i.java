package e.c.d.i.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import e.c.d.d.e.ThreadPoolService;

@TargetApi(21)
/* compiled from: Camera2 */
public class i extends g {
    public static final SparseIntArray E;
    public final SurfaceTextureListener A = new b();
    public CaptureCallback B = new c();
    public StateCallback C = new d();
    public final CameraDevice.StateCallback D = new e();

    /* renamed from: g reason: collision with root package name */
    public Size f6169g;

    /* renamed from: h reason: collision with root package name */
    public CameraDevice f6170h;

    /* renamed from: i reason: collision with root package name */
    public Context f6171i;

    /* renamed from: j reason: collision with root package name */
    public TextureView f6172j;
    public String k = "0";
    public CameraManager l;
    public Handler m;
    public HandlerThread n;
    public ImageReader o;
    public Builder p;
    public CameraCaptureSession q;
    public CameraCharacteristics r;
    public int s = 0;
    public int t = 90;
    public File u = null;
    public Semaphore v = new Semaphore(1);
    public float w = 0.0f;
    public int x = 1;
    public Rect y;
    public OnImageAvailableListener z = new a();

    /* compiled from: Camera2 */
    public class a implements OnImageAvailableListener {
        public a() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            i iVar = i.this;
            iVar.m.post(new f(imageReader.acquireNextImage(), i.this.u));
        }
    }

    /* compiled from: Camera2 */
    public class b implements SurfaceTextureListener {
        public b() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (i.this.d()) {
                i iVar = i.this;
                iVar.c(iVar.f6161d, iVar.f6160c);
                i.this.b();
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: Camera2 */
    public class c extends CaptureCallback {
        public c() {
        }

        public final void a(CaptureResult captureResult) {
            int i2 = i.this.s;
            if (i2 == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    i.a(i.this);
                } else if (4 == num.intValue() || 5 == num.intValue()) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 == null || num2.intValue() == 2) {
                        i iVar = i.this;
                        iVar.s = 4;
                        i.a(iVar);
                        return;
                    }
                    i iVar2 = i.this;
                    if (iVar2 != null) {
                        try {
                            iVar2.p.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
                            iVar2.s = 2;
                            iVar2.q.capture(iVar2.p.build(), iVar2.B, iVar2.m);
                            iVar2.p.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
                        } catch (CameraAccessException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        throw null;
                    }
                }
            } else if (i2 == 2) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4) {
                    i.this.s = 3;
                }
            } else if (i2 == 3) {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() != 5) {
                    i iVar3 = i.this;
                    iVar3.s = 4;
                    i.a(iVar3);
                }
            }
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
            i iVar = i.this;
            i.a(iVar, iVar.p.build());
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            a(captureResult);
        }
    }

    /* compiled from: Camera2 */
    public class d extends StateCallback {
        public d() {
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            CameraCaptureSession cameraCaptureSession2 = i.this.q;
            if (cameraCaptureSession2 != null && cameraCaptureSession2.equals(cameraCaptureSession)) {
                i.this.q = null;
            }
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            i iVar = i.this;
            if (iVar.f6170h != null) {
                iVar.q = cameraCaptureSession;
                int[] iArr = (int[]) iVar.r.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                if (iArr == null || iArr.length == 0 || (iArr.length == 1 && iArr[0] == 0)) {
                    iVar.p.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                } else {
                    iVar.f6172j.setOnTouchListener(new e(iVar));
                    iVar.p.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                }
                i iVar2 = i.this;
                i.a(iVar2, iVar2.p.build());
            }
        }
    }

    /* compiled from: Camera2 */
    public class e extends CameraDevice.StateCallback {
        public e() {
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            i.this.v.release();
            cameraDevice.close();
            i.this.f6170h = null;
        }

        public void onError(CameraDevice cameraDevice, int i2) {
            i.this.v.release();
            cameraDevice.close();
            i iVar = i.this;
            iVar.f6170h = null;
            iVar.q = null;
        }

        public void onOpened(CameraDevice cameraDevice) {
            i.this.v.release();
            i iVar = i.this;
            iVar.f6170h = cameraDevice;
            if ((cameraDevice != null) && iVar.f6172j.getSurfaceTexture() != null && iVar.o != null) {
                try {
                    iVar.p = iVar.f6170h.createCaptureRequest(1);
                } catch (CameraAccessException e2) {
                    e2.printStackTrace();
                }
                SurfaceTexture surfaceTexture = iVar.f6172j.getSurfaceTexture();
                surfaceTexture.setDefaultBufferSize(iVar.f6169g.getWidth(), iVar.f6169g.getHeight());
                Surface surface = new Surface(surfaceTexture);
                iVar.p.addTarget(surface);
                iVar.a(iVar.p);
                try {
                    iVar.f6170h.createCaptureSession(Arrays.asList(new Surface[]{surface, iVar.o.getSurface()}), iVar.C, iVar.m);
                } catch (CameraAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: Camera2 */
    public class f implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final Image f6178a;

        /* renamed from: b reason: collision with root package name */
        public final File f6179b;

        public f(Image image, File file) {
            this.f6178a = image;
            this.f6179b = file;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC, Splitter:B:23:0x0037] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0048 A[SYNTHETIC, Splitter:B:31:0x0048] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0056 A[SYNTHETIC, Splitter:B:37:0x0056] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x002d=Splitter:B:19:0x002d, B:27:0x003e=Splitter:B:27:0x003e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void a(byte[] r6) {
            /*
                r5 = this;
                java.lang.String r0 = ""
                r1 = 0
                r2 = 0
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x002c }
                java.io.File r4 = r5.f6179b     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x002c }
                r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x002c }
                r3.write(r6)     // Catch:{ FileNotFoundException -> 0x0027, IOException -> 0x0024, all -> 0x0021 }
                android.media.Image r6 = r5.f6178a
                r6.close()
                r3.close()     // Catch:{ IOException -> 0x0017 }
                goto L_0x001b
            L_0x0017:
                r6 = move-exception
            L_0x0018:
                r6.printStackTrace()
            L_0x001b:
                e.c.d.i.b.i r6 = e.c.d.i.b.i.this
                e.c.d.i.b.i.a(r6, r1, r0)
                goto L_0x004e
            L_0x0021:
                r6 = move-exception
                r2 = r3
                goto L_0x004f
            L_0x0024:
                r6 = move-exception
                r2 = r3
                goto L_0x002d
            L_0x0027:
                r6 = move-exception
                r2 = r3
                goto L_0x003e
            L_0x002a:
                r6 = move-exception
                goto L_0x004f
            L_0x002c:
                r6 = move-exception
            L_0x002d:
                r6.getMessage()     // Catch:{ all -> 0x002a }
                android.media.Image r6 = r5.f6178a
                r6.close()
                if (r2 == 0) goto L_0x001b
                r2.close()     // Catch:{ IOException -> 0x003b }
                goto L_0x001b
            L_0x003b:
                r6 = move-exception
                goto L_0x0018
            L_0x003d:
                r6 = move-exception
            L_0x003e:
                r6.getMessage()     // Catch:{ all -> 0x002a }
                android.media.Image r6 = r5.f6178a
                r6.close()
                if (r2 == 0) goto L_0x001b
                r2.close()     // Catch:{ IOException -> 0x004c }
                goto L_0x001b
            L_0x004c:
                r6 = move-exception
                goto L_0x0018
            L_0x004e:
                return
            L_0x004f:
                android.media.Image r3 = r5.f6178a
                r3.close()
                if (r2 == 0) goto L_0x005e
                r2.close()     // Catch:{ IOException -> 0x005a }
                goto L_0x005e
            L_0x005a:
                r2 = move-exception
                r2.printStackTrace()
            L_0x005e:
                e.c.d.i.b.i r2 = e.c.d.i.b.i.this
                e.c.d.i.b.i.a(r2, r1, r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.d.i.b.i.f.a(byte[]):void");
        }

        public void run() {
            ByteBuffer buffer = this.f6178a.getPlanes()[0].getBuffer();
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            ThreadPoolService.fixedThreadPool.execute(new f(this, bArr));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(0, 0);
        E.put(1, 90);
        E.put(2, HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        E.put(3, HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public i(ViewGroup viewGroup) {
        this.f6171i = viewGroup.getContext();
        TextureView textureView = new TextureView(this.f6171i);
        this.f6172j = textureView;
        viewGroup.addView(textureView);
        this.l = (CameraManager) this.f6171i.getSystemService("camera");
    }

    public void a(int i2, int i3) {
        this.f6161d = i2;
        this.f6160c = i3;
        g();
        if (!this.f6159b) {
            try {
                if (d() || this.f6172j != null) {
                    if (this.f6172j.isAvailable()) {
                        c(this.f6161d, this.f6160c);
                        b();
                    } else {
                        this.f6172j.setSurfaceTextureListener(this.A);
                    }
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            this.f6159b = true;
        }
    }

    public final void b() {
        if (d.h.e.a.a(this.f6171i, "android.permission.CAMERA") == 0) {
            g();
            try {
                if (this.v.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                    b(this.f6172j.getWidth(), this.f6172j.getHeight());
                    this.l.openCamera(this.k, this.D, this.m);
                }
            } catch (CameraAccessException | InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(int i2, int i3) {
        Size size;
        Size[] outputSizes;
        CameraCharacteristics cameraCharacteristics = this.r;
        if (cameraCharacteristics != null) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null) {
                Size[] outputSizes2 = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                int width = this.f6172j.getWidth();
                int height = this.f6172j.getHeight();
                if (width < height) {
                    int i4 = height;
                    height = width;
                    width = i4;
                }
                int length = outputSizes2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        size = outputSizes2[outputSizes2.length - 1];
                        break;
                    }
                    size = outputSizes2[i5];
                    if (size.getWidth() * i3 == size.getHeight() * i2 && size.getWidth() >= width && size.getHeight() >= height && size.getWidth() <= 1920 && size.getHeight() <= 1080) {
                        break;
                    }
                    i5++;
                }
                this.f6169g = size;
                if (size != null) {
                    String.format(Locale.getDefault(), "[Camera2][setPreviewRatio] Find Preview Ratio width:%s height:%s", new Object[]{Integer.valueOf(this.f6169g.getWidth()), Integer.valueOf(this.f6169g.getHeight())});
                }
                long j2 = 0;
                Size size2 = null;
                for (Size size3 : streamConfigurationMap.getOutputSizes(256)) {
                    if (size3.getWidth() * i3 == size3.getHeight() * i2) {
                        if (j2 < ((long) (size3.getWidth() * size3.getHeight()))) {
                            j2 = (long) (size3.getWidth() * size3.getHeight());
                            size2 = size3;
                        }
                    }
                }
                if (size2 != null) {
                    ImageReader newInstance = ImageReader.newInstance(size2.getWidth(), size2.getHeight(), 256, 1);
                    this.o = newInstance;
                    newInstance.setOnImageAvailableListener(this.z, this.m);
                }
            }
        }
    }

    public final boolean d() {
        String[] cameraIdList;
        try {
            for (String str : this.l.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = this.l.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num != null) {
                    if (num.intValue() != 2) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                        if (num2 != null && num2.intValue() == 1) {
                            this.k = str;
                            this.r = cameraCharacteristics;
                            return true;
                        }
                    }
                }
            }
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public void e() {
        a();
        this.f6172j = null;
        this.f6162e = null;
        this.f6171i = null;
        this.l = null;
    }

    public void f() {
        a();
        HandlerThread handlerThread = this.n;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.n.join();
                this.n = null;
                this.m = null;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void g() {
        if (this.n == null) {
            HandlerThread handlerThread = new HandlerThread("CameraBackground");
            this.n = handlerThread;
            handlerThread.start();
            this.m = new Handler(this.n.getLooper());
        }
    }

    public final void b(int i2, int i3) {
        if (this.f6172j != null && this.f6169g != null) {
            Matrix matrix = new Matrix();
            float f2 = (float) i2;
            float f3 = (float) i3;
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.f6169g.getHeight(), (float) this.f6169g.getWidth());
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            int i4 = this.t;
            if (i4 == 90 || i4 == 270) {
                rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
                matrix.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                float max = Math.max(f3 / ((float) this.f6169g.getHeight()), f2 / ((float) this.f6169g.getWidth()));
                matrix.postScale(max, max, centerX, centerY);
                matrix.postRotate((float) (this.t - HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT), centerX, centerY);
            } else if (i4 == 180) {
                matrix.postRotate(180.0f, centerX, centerY);
            }
            this.f6172j.setTransform(matrix);
        }
    }

    public void a(int i2) {
        this.t = E.get(i2);
    }

    public void a(String str) {
        this.f6158a = str;
        this.u = new File(str);
        this.f6159b = false;
        Integer num = (Integer) this.r.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (this.r == null || num == null) {
            num = Integer.valueOf(90);
        }
        this.p.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(((num.intValue() - this.t) + 360) % 360));
        try {
            if (this.q != null) {
                this.p.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                this.s = 1;
                this.q.capture(this.p.build(), this.B, this.m);
            }
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        CameraCaptureSession cameraCaptureSession = this.q;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.p.build(), this.B, null);
            } catch (CameraAccessException | IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a() {
        try {
            this.v.acquire();
            CameraCaptureSession cameraCaptureSession = this.q;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.q.abortCaptures();
                this.q = null;
            }
        } catch (Exception unused) {
        } catch (InterruptedException unused2) {
        } catch (Throwable th) {
            this.v.release();
            throw th;
        }
        CameraDevice cameraDevice = this.f6170h;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.f6170h = null;
        }
        ImageReader imageReader = this.o;
        if (imageReader != null) {
            imageReader.close();
            this.o = null;
        }
        if (this.f6159b) {
            this.f6159b = false;
        }
        this.v.release();
    }

    public static /* synthetic */ void a(i iVar) {
        if (iVar != null) {
            try {
                Builder createCaptureRequest = iVar.f6170h.createCaptureRequest(2);
                createCaptureRequest.addTarget(iVar.o.getSurface());
                iVar.q.stopRepeating();
                iVar.q.abortCaptures();
                iVar.f6159b = false;
                iVar.a(createCaptureRequest);
                if (iVar.y != null) {
                    createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, iVar.y);
                }
                iVar.q.capture(createCaptureRequest.build(), iVar.B, null);
                iVar.p.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
        } else {
            throw null;
        }
    }

    public final void a(Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
    }

    public static /* synthetic */ void a(i iVar, CaptureRequest captureRequest) {
        if (iVar != null) {
            try {
                if (iVar.q != null) {
                    iVar.q.setRepeatingRequest(captureRequest, iVar.B, iVar.m);
                    iVar.f6159b = true;
                }
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
        } else {
            throw null;
        }
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            Rect rect = (Rect) this.r.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (rect != null) {
                Float f2 = (Float) this.r.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
                if (this.r == null || f2 == null) {
                    f2 = Float.valueOf(1.0f);
                }
                float x2 = motionEvent.getX(0) - motionEvent.getX(1);
                float y2 = motionEvent.getY(0) - motionEvent.getY(1);
                float sqrt = (float) Math.sqrt((double) ((y2 * y2) + (x2 * x2)));
                float f3 = this.w;
                if (f3 != 0.0f) {
                    if (sqrt > f3) {
                        float f4 = (float) this.x;
                        if (f2.floatValue() > f4 && f4 < f2.floatValue() / 2.0f) {
                            this.x++;
                            int width = rect.width() - ((int) (((float) rect.width()) / f2.floatValue()));
                            int intValue = (width / f2.intValue()) * this.x;
                            int height = ((rect.height() - ((int) (((float) rect.height()) / f2.floatValue()))) / f2.intValue()) * this.x;
                            int i2 = intValue - (intValue & 3);
                            int i3 = height - (height & 3);
                            Rect rect2 = new Rect(i2, i3, rect.width() - i2, rect.height() - i3);
                            this.y = rect2;
                            this.p.set(CaptureRequest.SCALER_CROP_REGION, rect2);
                        }
                    }
                    if (sqrt < this.w) {
                        int i4 = this.x;
                        if (i4 > 1) {
                            this.x = i4 - 1;
                        }
                    }
                    int width2 = rect.width() - ((int) (((float) rect.width()) / f2.floatValue()));
                    int intValue2 = (width2 / f2.intValue()) * this.x;
                    int height2 = ((rect.height() - ((int) (((float) rect.height()) / f2.floatValue()))) / f2.intValue()) * this.x;
                    int i22 = intValue2 - (intValue2 & 3);
                    int i32 = height2 - (height2 & 3);
                    Rect rect22 = new Rect(i22, i32, rect.width() - i22, rect.height() - i32);
                    this.y = rect22;
                    this.p.set(CaptureRequest.SCALER_CROP_REGION, rect22);
                }
                this.w = sqrt;
                c();
            }
            return true;
        }
        if (motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            Integer valueOf = Integer.valueOf(1);
            if (!(action != 1 || this.f6170h == null || ((Rect) this.r.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) == null)) {
                int x3 = (int) motionEvent.getX();
                int y3 = (int) motionEvent.getY();
                Rect rect3 = new Rect(0, 0, this.f6172j.getWidth(), this.f6172j.getHeight());
                Integer num = (Integer) this.r.get(CameraCharacteristics.SENSOR_ORIENTATION);
                if (this.r == null || num == null) {
                    num = Integer.valueOf(90);
                }
                int intValue3 = ((num.intValue() - this.t) + 360) % 360;
                m mVar = new m(this.r, intValue3, new RectF(rect3));
                int i5 = x3 - 150;
                int i6 = rect3.left;
                int i7 = rect3.right - 300;
                if (i5 > i7) {
                    i5 = i7;
                } else if (i5 < i6) {
                    i5 = i6;
                }
                int i8 = y3 - 150;
                int i9 = rect3.top;
                int i10 = rect3.bottom - 300;
                if (i8 > i10) {
                    i8 = i10;
                } else if (i8 < i9) {
                    i8 = i9;
                }
                RectF rectF = new RectF((float) i5, (float) i8, (float) (i5 + 300), (float) (i8 + 300));
                RectF rectF2 = new RectF();
                mVar.f6187a.mapRect(rectF2, rectF);
                Rect rect4 = new Rect();
                rect4.left = Math.round(rectF2.left);
                rect4.top = Math.round(rectF2.top);
                rect4.right = Math.round(rectF2.right);
                rect4.bottom = Math.round(rectF2.bottom);
                String.format(Locale.getDefault(), "[Camera2][handleFocus] centerX:%d, centerY:%d, displayOrientation:%d", new Object[]{Integer.valueOf(x3), Integer.valueOf(y3), Integer.valueOf(intValue3)});
                String.format(Locale.getDefault(), "[Camera2][handleFocus] FocusRect: LeftTop(%d, %d), RightBottom(%d, %d)", new Object[]{Integer.valueOf(rect4.left), Integer.valueOf(rect4.top), Integer.valueOf(rect4.right), Integer.valueOf(rect4.bottom)});
                MeteringRectangle[] meteringRectangleArr = {new MeteringRectangle(rect4, 1000)};
                this.p.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
                this.p.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
                this.p.set(CaptureRequest.CONTROL_AF_MODE, valueOf);
                this.p.set(CaptureRequest.CONTROL_AF_TRIGGER, valueOf);
                this.p.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, valueOf);
                c();
            }
        }
        return true;
    }

    public static /* synthetic */ void a(i iVar, int i2, String str) {
        e.c.d.i.b.j.b bVar = iVar.f6162e;
        if (bVar != null) {
            bVar.a(iVar.f6158a, i2, str);
        }
    }
}
