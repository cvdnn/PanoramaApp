package com.arashivision.insbase.graphic;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.arashivision.insbase.arlog.Log;
import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.lang.ref.WeakReference;

public class SurfaceTextureBridge {
    public static final int MSG_QUIT = 2;
    public static final int MSG_SET_SURFACETEXTURE = 1;
    public static final String TAG = "SurfaceTextureBridgeJ";
    public static final boolean TRACE = false;
    public boolean mCreated = false;
    public EventHandler mEventHandler;
    public int mHeight;
    public long mNativeObject;
    public boolean mReleased = false;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureID;
    public Thread mThread;
    public int mWidth;

    public static class EventHandler extends Handler {
        public WeakReference<SurfaceTextureBridge> mSurfaceTextureBridgeWeakRef;

        public EventHandler(SurfaceTextureBridge surfaceTextureBridge, Looper looper) {
            super(looper);
            this.mSurfaceTextureBridgeWeakRef = new WeakReference<>(surfaceTextureBridge);
        }

        public void handleMessage(Message message) {
            SurfaceTextureBridge surfaceTextureBridge = (SurfaceTextureBridge) this.mSurfaceTextureBridgeWeakRef.get();
            if (surfaceTextureBridge != null || message.what == 2) {
                int i2 = message.what;
                if (i2 == 1) {
                    Log.i(SurfaceTextureBridge.TAG, "setup surface texture");
                    Object[] objArr = (Object[]) message.obj;
                    surfaceTextureBridge.mSurfaceTexture = new SurfaceTexture(surfaceTextureBridge.mTextureID);
                    surfaceTextureBridge.mSurfaceTexture.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                            SurfaceTextureBridge surfaceTextureBridge = (SurfaceTextureBridge) EventHandler.this.mSurfaceTextureBridgeWeakRef.get();
                            if (surfaceTextureBridge != null) {
                                surfaceTextureBridge.onFrameAvailable(surfaceTexture, false);
                            }
                        }
                    });
                    if (surfaceTextureBridge.mWidth > 0 && surfaceTextureBridge.mHeight > 0) {
                        StringBuilder a2 = a.a("set surface texture size: ");
                        a2.append(surfaceTextureBridge.mWidth);
                        a2.append(Config.EVENT_HEAT_X);
                        a2.append(surfaceTextureBridge.mHeight);
                        Log.i(SurfaceTextureBridge.TAG, a2.toString());
                        surfaceTextureBridge.mSurfaceTexture.setDefaultBufferSize(surfaceTextureBridge.mWidth, surfaceTextureBridge.mHeight);
                    }
                    synchronized (objArr) {
                        objArr[0] = Boolean.valueOf(true);
                        objArr.notifyAll();
                    }
                } else if (i2 != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown message for event handler: ");
                    sb.append(i2);
                    Log.e(SurfaceTextureBridge.TAG, sb.toString());
                } else {
                    if (surfaceTextureBridge != null) {
                        surfaceTextureBridge.onFrameAvailable(surfaceTextureBridge.mSurfaceTexture, true);
                    }
                    Looper.myLooper().quit();
                }
                return;
            }
            StringBuilder a3 = a.a("SurfaceTextureBridge.EventHandler handleMessage: ");
            a3.append(message.what);
            a3.append(", but creator not exists now");
            Log.w(SurfaceTextureBridge.TAG, a3.toString());
        }
    }

    private Surface createSurface(int i2, int i3, int i4, long j2) {
        if (!this.mCreated) {
            this.mCreated = true;
            this.mNativeObject = j2;
            initLooper();
            this.mTextureID = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            Object[] objArr = {Boolean.valueOf(false)};
            EventHandler eventHandler = this.mEventHandler;
            eventHandler.sendMessage(eventHandler.obtainMessage(1, 0, 0, objArr));
            synchronized (objArr) {
                while (!((Boolean) objArr[0]).booleanValue()) {
                    try {
                        objArr.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Surface surface = new Surface(this.mSurfaceTexture);
            this.mSurface = surface;
            return surface;
        }
        throw new IllegalStateException("SurfaceTextureBridge already create one surface");
    }

    private float[] getTransformMatrix() {
        float[] fArr = new float[16];
        this.mSurfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    private void initLooper() {
        final Boolean[] boolArr = {Boolean.valueOf(false)};
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setName("SurfaceTextureBridge");
                Looper.prepare();
                SurfaceTextureBridge.this.mEventHandler = new EventHandler(SurfaceTextureBridge.this, Looper.myLooper());
                synchronized (boolArr) {
                    boolArr[0] = Boolean.valueOf(true);
                    boolArr.notifyAll();
                }
                Looper.loop();
            }
        });
        this.mThread = thread;
        thread.start();
        synchronized (boolArr) {
            while (!boolArr[0].booleanValue()) {
                try {
                    boolArr.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private native void nativeNotifyFrameAvailable(long j2, boolean z);

    private void release() {
        if (!this.mReleased) {
            this.mReleased = true;
            if (this.mCreated) {
                EventHandler eventHandler = this.mEventHandler;
                eventHandler.sendMessage(eventHandler.obtainMessage(2));
                try {
                    this.mThread.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.mSurface.release();
                this.mSurfaceTexture.release();
                this.mSurface = null;
                this.mSurfaceTexture = null;
            }
        }
    }

    private void updateTexImage() {
        if (this.mCreated) {
            this.mSurfaceTexture.updateTexImage();
        }
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture, boolean z) {
        if (!this.mReleased) {
            nativeNotifyFrameAvailable(this.mNativeObject, z);
        }
    }
}
