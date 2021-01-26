package f.a.a.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import e.a.a.a.a;

/* compiled from: InputSurface */
public class e {

    /* renamed from: a reason: collision with root package name */
    public EGLDisplay f9028a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b reason: collision with root package name */
    public EGLContext f9029b = EGL14.EGL_NO_CONTEXT;

    /* renamed from: c reason: collision with root package name */
    public EGLSurface f9030c = EGL14.EGL_NO_SURFACE;

    /* renamed from: d reason: collision with root package name */
    public Surface f9031d;

    public e(Surface surface) {
        if (surface != null) {
            this.f9031d = surface;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f9028a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (EGL14.eglChooseConfig(this.f9028a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        this.f9029b = EGL14.eglCreateContext(this.f9028a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                        a("eglCreateContext");
                        if (this.f9029b != null) {
                            this.f9030c = EGL14.eglCreateWindowSurface(this.f9028a, eGLConfigArr[0], this.f9031d, new int[]{12344}, 0);
                            a("eglCreateWindowSurface");
                            if (this.f9030c == null) {
                                throw new RuntimeException("surface was null");
                            }
                            return;
                        }
                        throw new RuntimeException("null context");
                    }
                    throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
                }
                this.f9028a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw null;
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            StringBuilder b2 = a.b(str, ": EGL error: 0x");
            b2.append(Integer.toHexString(eglGetError));
            throw new RuntimeException(b2.toString());
        }
    }
}
