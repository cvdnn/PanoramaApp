package com.arashivision.onestream;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import e.a.a.a.a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EglCore {
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final String TAG = "EglCore";
    public EGLConfig mEGLConfig;
    public EGLContext mEGLContext = EGL10.EGL_NO_CONTEXT;
    public EGLDisplay mEGLDisplay = EGL10.EGL_NO_DISPLAY;
    public EGL10 mEgl;

    public EglCore(EGLContext eGLContext, boolean z) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        this.mEGLDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        int[] iArr = new int[2];
        int[] iArr2 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344, 0, 12344};
        if (z) {
            iArr2[8] = 12610;
            iArr2[9] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        if (!this.mEgl.eglInitialize(this.mEGLDisplay, iArr)) {
            throw new RuntimeException("eglInitialize failed");
        } else if (!this.mEgl.eglChooseConfig(this.mEGLDisplay, iArr2, eGLConfigArr, 1, iArr3)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        } else if (iArr3[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.mEGLConfig = eGLConfig;
            EGLContext eglCreateContext = this.mEgl.eglCreateContext(this.mEGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
            this.mEGLContext = eglCreateContext;
            if (eglCreateContext == EGL10.EGL_NO_CONTEXT) {
                throw new RuntimeException("eglCreateContext failed");
            }
        } else {
            throw new IllegalArgumentException("No configs match configSpec");
        }
    }

    private void checkEglError(String str) {
        int eglGetError = this.mEgl.eglGetError();
        if (eglGetError != 12288) {
            StringBuilder b2 = a.b(str, ": EGL error: 0x");
            b2.append(Integer.toHexString(eglGetError));
            throw new RuntimeException(b2.toString());
        }
    }

    public EGLSurface createOffscreenSurface(int i2, int i3) {
        EGLSurface eglCreatePbufferSurface = this.mEgl.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i2, 12374, i3, 12344});
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public EGLSurface createWindowSurface(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344});
            checkEglError("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException(a.a("invalid surface: ", obj));
    }

    public void destroyEglSurface(EGLSurface eGLSurface) {
        this.mEgl.eglDestroySurface(this.mEGLDisplay, eGLSurface);
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent false");
        }
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.mEgl;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            this.mEgl.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public void swapBuffers(EGLSurface eGLSurface) {
        this.mEgl.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
    }
}
