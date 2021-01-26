package com.arashivision.bmgmedia.test;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.arashivision.bmgmedia.NativeLibsLoader;
import com.arashivision.bmgmedia.utils.EglCore;
import com.arashivision.bmgmedia.utils.FboTarget;
import com.arashivision.bmgmedia.utils.GLUtils;
import com.arashivision.bmgmedia.utils.TimerLogger;
import com.arashivision.insbase.arlog.Log;
import com.baidu.mobstat.Config;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;

public class ReadFromGl {
    static {
        NativeLibsLoader.load();
    }

    public static void glReadPixels(int i2, int i3, String str) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i3 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        EglCore eglCore = new EglCore(EGL10.EGL_NO_CONTEXT, true);
        EGLSurface createOffscreenSurface = eglCore.createOffscreenSurface(1, 1);
        eglCore.makeCurrent(createOffscreenSurface, createOffscreenSurface);
        GLUtils.checkGLError("makeCurrent");
        new FboTarget(i2, i3).bind();
        GLUtils.checkGLError("bindFbo");
        StringBuilder sb = new StringBuilder();
        sb.append("glReadPixels: ");
        sb.append(i2);
        sb.append(Config.EVENT_HEAT_X);
        sb.append(i3);
        TimerLogger timerLogger = new TimerLogger(sb.toString());
        for (int i4 = 0; i4 < 300; i4++) {
            GLES30.glClearColor(0.33333334f, 0.33333334f, 0.49803922f, 1.0f);
            GLES30.glClear(16384);
            GLUtils.checkGLError("glClear");
            GLES30.glFinish();
            GLUtils.checkGLError("glFinish");
            timerLogger.reset();
            GLES30.glPixelStorei(3333, 1);
            GLUtils.checkGLError("glPixelStorei");
            allocateDirect.rewind();
            GLES30.glReadPixels(0, 0, i2, i3, 6408, 5121, allocateDirect);
            GLUtils.checkGLError("glReadPixels");
            timerLogger.printElapsed();
        }
    }

    public static native void handlePlaneData(ByteBuffer byteBuffer, int i2, int i3, int i4);

    public static void readFromImageReader(int i2, int i3, String str) {
        ByteBuffer.allocateDirect(i2 * i3 * 4).order(ByteOrder.nativeOrder());
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
        try {
            linkedBlockingQueue.put(Integer.valueOf(0));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ImageReader: ");
        sb.append(i2);
        sb.append(Config.EVENT_HEAT_X);
        sb.append(i3);
        final TimerLogger timerLogger = new TimerLogger(sb.toString());
        HandlerThread handlerThread = new HandlerThread("handle image reader");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        ImageReader newInstance = ImageReader.newInstance(i2, i3, 1, 1);
        newInstance.setOnImageAvailableListener(new OnImageAvailableListener() {
            public void onImageAvailable(ImageReader imageReader) {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                int length = acquireLatestImage.getPlanes().length;
                Plane plane = acquireLatestImage.getPlanes()[0];
                ReadFromGl.handlePlaneData(plane.getBuffer(), plane.getRowStride(), acquireLatestImage.getWidth(), acquireLatestImage.getHeight());
                timerLogger.printElapsed("from glFinish to rgba copied");
                acquireLatestImage.close();
                try {
                    linkedBlockingQueue.put(Integer.valueOf(1));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }, handler);
        Surface surface = newInstance.getSurface();
        EglCore eglCore = new EglCore(EGL10.EGL_NO_CONTEXT, true);
        EGLSurface createWindowSurface = eglCore.createWindowSurface(surface);
        eglCore.makeCurrent(createWindowSurface, createWindowSurface);
        GLUtils.checkGLError("makeCurrent");
        for (int i4 = 0; i4 < 300; i4++) {
            GLES30.glClearColor(0.33333334f, 0.33333334f, 0.49803922f, 1.0f);
            GLES30.glClear(16384);
            GLUtils.checkGLError("glClear");
            GLES30.glFinish();
            GLUtils.checkGLError("glFinish");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("swap buffers: ");
            sb2.append(i4);
            Log.i("ins", sb2.toString());
            try {
                linkedBlockingQueue.take();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            timerLogger.reset();
            eglCore.swapBuffers(createWindowSurface);
        }
        handlerThread.quit();
    }
}
