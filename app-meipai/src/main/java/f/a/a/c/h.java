package f.a.a.c;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/* compiled from: OutputSurface */
public class h implements OnFrameAvailableListener {

    /* renamed from: a reason: collision with root package name */
    public EGLDisplay f9032a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b reason: collision with root package name */
    public EGLContext f9033b = EGL14.EGL_NO_CONTEXT;

    /* renamed from: c reason: collision with root package name */
    public EGLSurface f9034c = EGL14.EGL_NO_SURFACE;

    /* renamed from: d reason: collision with root package name */
    public SurfaceTexture f9035d;

    /* renamed from: e reason: collision with root package name */
    public Surface f9036e;

    /* renamed from: f reason: collision with root package name */
    public Object f9037f = new Object();

    /* renamed from: g reason: collision with root package name */
    public boolean f9038g;

    /* renamed from: h reason: collision with root package name */
    public l f9039h;

    /* renamed from: i reason: collision with root package name */
    public HandlerThread f9040i;

    /* renamed from: j reason: collision with root package name */
    public Handler f9041j;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h() {
        /*
            r9 = this;
            r9.<init>()
            android.opengl.EGLDisplay r0 = android.opengl.EGL14.EGL_NO_DISPLAY
            r9.f9032a = r0
            android.opengl.EGLContext r0 = android.opengl.EGL14.EGL_NO_CONTEXT
            r9.f9033b = r0
            android.opengl.EGLSurface r0 = android.opengl.EGL14.EGL_NO_SURFACE
            r9.f9034c = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r9.f9037f = r0
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r1 = "OutputSurface"
            r0.<init>(r1)
            r9.f9040i = r0
            r0.start()
            android.os.Handler r0 = new android.os.Handler
            android.os.HandlerThread r1 = r9.f9040i
            android.os.Looper r1 = r1.getLooper()
            r0.<init>(r1)
            r9.f9041j = r0
            f.a.a.c.l r0 = new f.a.a.c.l
            r0.<init>()
            r9.f9039h = r0
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            long r1 = r1.getId()
            r0.f9080a = r1
            r1 = 35633(0x8b31, float:4.9932E-41)
            java.lang.String r2 = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n"
            int r1 = r0.a(r1, r2)
            java.lang.String r2 = "TextureRender"
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x0055
            java.lang.String r1 = " texture render loader vertex shader error"
            android.util.Log.e(r2, r1)
            goto L_0x006a
        L_0x0055:
            r5 = 35632(0x8b30, float:4.9931E-41)
            java.lang.String r6 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"
            int r5 = r0.a(r5, r6)
            if (r5 != 0) goto L_0x006c
            java.lang.String r5 = " texture render loader fragment shader error"
            android.util.Log.e(r2, r5)
            if (r1 <= 0) goto L_0x006a
            android.opengl.GLES20.glDeleteShader(r1)
        L_0x006a:
            r6 = r4
            goto L_0x00af
        L_0x006c:
            int r6 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r7 = "glCreateProgram"
            r0.a(r7)
            if (r6 != 0) goto L_0x007c
            java.lang.String r7 = "Could not create program"
            android.util.Log.e(r2, r7)
        L_0x007c:
            android.opengl.GLES20.glAttachShader(r6, r1)
            java.lang.String r7 = "glAttachShader"
            r0.a(r7)
            android.opengl.GLES20.glAttachShader(r6, r5)
            r0.a(r7)
            android.opengl.GLES20.glLinkProgram(r6)
            int[] r7 = new int[r3]
            r8 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r6, r8, r7, r4)
            r7 = r7[r4]
            if (r7 == r3) goto L_0x00a9
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r2, r7)
            java.lang.String r7 = android.opengl.GLES20.glGetProgramInfoLog(r6)
            android.util.Log.e(r2, r7)
            android.opengl.GLES20.glDeleteProgram(r6)
            r6 = r4
        L_0x00a9:
            android.opengl.GLES20.glDeleteShader(r1)
            android.opengl.GLES20.glDeleteShader(r5)
        L_0x00af:
            r0.f9085f = r6
            if (r6 == 0) goto L_0x016b
            java.lang.String r1 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r6, r1)
            r0.f9089j = r1
            java.lang.String r1 = "glGetAttribLocation aPosition"
            r0.a(r1)
            int r1 = r0.f9089j
            r2 = -1
            if (r1 == r2) goto L_0x0163
            int r1 = r0.f9085f
            java.lang.String r5 = "aTextureCoord"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r5)
            r0.k = r1
            java.lang.String r1 = "glGetAttribLocation aTextureCoord"
            r0.a(r1)
            int r1 = r0.k
            if (r1 == r2) goto L_0x015b
            int r1 = r0.f9085f
            java.lang.String r5 = "uMVPMatrix"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r5)
            r0.f9087h = r1
            java.lang.String r1 = "glGetUniformLocation uMVPMatrix"
            r0.a(r1)
            int r1 = r0.f9087h
            if (r1 == r2) goto L_0x0153
            int r1 = r0.f9085f
            java.lang.String r5 = "uSTMatrix"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r5)
            r0.f9088i = r1
            java.lang.String r1 = "glGetUniformLocation uSTMatrix"
            r0.a(r1)
            int r1 = r0.f9088i
            if (r1 == r2) goto L_0x014b
            int[] r1 = new int[r3]
            android.opengl.GLES20.glGenTextures(r3, r1, r4)
            r1 = r1[r4]
            r0.f9086g = r1
            r2 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r2, r1)
            java.lang.String r1 = "glBindTexture mTextureID"
            r0.a(r1)
            r1 = 10241(0x2801, float:1.435E-41)
            r3 = 1175979008(0x46180400, float:9729.0)
            android.opengl.GLES20.glTexParameterf(r2, r1, r3)
            r1 = 10240(0x2800, float:1.4349E-41)
            android.opengl.GLES20.glTexParameterf(r2, r1, r3)
            r1 = 10242(0x2802, float:1.4352E-41)
            r3 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r2, r1, r3)
            r1 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r2, r1, r3)
            java.lang.String r1 = "glTexParameter"
            r0.a(r1)
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            f.a.a.c.l r1 = r9.f9039h
            int r1 = r1.f9086g
            r0.<init>(r1)
            r9.f9035d = r0
            android.os.Handler r1 = r9.f9041j
            r0.setOnFrameAvailableListener(r9, r1)
            android.view.Surface r0 = new android.view.Surface
            android.graphics.SurfaceTexture r1 = r9.f9035d
            r0.<init>(r1)
            r9.f9036e = r0
            return
        L_0x014b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not get attrib location for uSTMatrix"
            r0.<init>(r1)
            throw r0
        L_0x0153:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not get attrib location for uMVPMatrix"
            r0.<init>(r1)
            throw r0
        L_0x015b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not get attrib location for aTextureCoord"
            r0.<init>(r1)
            throw r0
        L_0x0163:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not get attrib location for aPosition"
            r0.<init>(r1)
            throw r0
        L_0x016b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "failed creating program"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.h.<init>():void");
    }

    public void a() {
        synchronized (this.f9037f) {
            while (!this.f9038g) {
                try {
                    this.f9037f.wait(FragmentStateAdapter.GRACE_WINDOW_TIME_MS);
                    if (!this.f9038g) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f9038g = false;
        }
        this.f9039h.a("before updateTexImage");
        try {
            this.f9035d.updateTexImage();
        } catch (Exception e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateTexImage error ");
            sb.append(e3);
            Log.e("OutputSurface", sb.toString());
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f9037f) {
            if (!this.f9038g) {
                this.f9038g = true;
                this.f9037f.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
