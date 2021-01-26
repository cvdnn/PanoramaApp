package com.arashivision.onestream;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.recyclerview.widget.RecyclerView;
import com.arashivision.onestream.DualStreamUtil.ClockUtil;
import com.arashivision.onestream.DualStreamUtil.RenderInfo;
import com.arashivision.onestream.Gyro.OneGyroField;
import com.arashivision.onestream.Gyro.OneLatestIDR;
import com.arashivision.onestream.SingleStreamPlayer.RenderAvailableCallback;
import com.arashivision.onestreamtarget.OneStreamTarget;
import com.arashivision.onestreamtarget.OneStreamTarget.ShadowObj;
import com.arashivision.onestreamtarget.OneStreamTarget.StreamExtra;
import com.arashivision.onestreamtarget.StreamShadowTexture;
import com.arashivision.onestreamtarget.StreamShadowTexture.onShadowTexutureListener;
import e.a.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class OneStreamPlayer extends AbstractPlayer {
    public static final String TAG = "OneStreamPlayer";
    public boolean mDebug = false;
    public LinkedList<Long> mDropTimestampList = new LinkedList<>();
    public long mFrameCount;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public float[] mLastRendrGyro;
    public long mLastRendrOriginTs;
    public long mLeastRenderIntervalNs;
    public StreamTarget mLeftStreamTarget;
    public long mNextRenderTimeNs;
    public LinkedList<RenderObj> mReadyInfoList = new LinkedList<>();
    public LongSparseArray<DualRenderObj> mRenderInfoList = new LongSparseArray<>();
    public StreamTarget mRightStreamTarget;
    public ShadowObj mShadowObj;
    public long mStartTime;
    public SingleStreamPlayer mStreamLeftPlayer;
    public SingleStreamPlayer mStreamRightPlayer;
    public Object mSyncRender = new Object();

    public class DualRenderObj extends RenderObj {
        public RenderInfo mSecond;

        public DualRenderObj(long j2) {
            super(j2);
        }

        public RenderInfo getSecond() {
            return this.mSecond;
        }

        public boolean isEmpty() {
            return this.mFirst == null && this.mSecond == null;
        }

        public void render(boolean z) {
            OneStreamPlayer.this.mStreamLeftPlayer.postRender(this.mFirst, z);
            OneStreamPlayer.this.mStreamRightPlayer.postRender(this.mSecond, z);
        }

        public void setLatestIDR(OneGyroField oneGyroField) {
            super.setLatestIDR(oneGyroField);
            OneStreamPlayer.this.mLatestIDRFrame.mSecIDRFrame = this.mSecond.mByteBuf;
        }
    }

    public class RenderObj {
        public RenderInfo mFirst;
        public long mOriginTs;

        public RenderObj(long j2) {
            this.mOriginTs = j2;
        }

        public RenderInfo getFirst() {
            return this.mFirst;
        }

        public void getGyroInfo() {
        }

        public long getOriginTs() {
            return this.mOriginTs;
        }

        public RenderInfo getSecond() {
            return null;
        }

        public boolean isEmpty() {
            return this.mFirst == null;
        }

        public boolean isIFrame() {
            return this.mFirst.isIFrame();
        }

        public void render(boolean z) {
            OneStreamPlayer.this.mStreamLeftPlayer.postRender(this.mFirst, true);
        }

        public void setLatestIDR(OneGyroField oneGyroField) {
            OneStreamPlayer.this.mLatestIDRFrame.mIDRFrame = this.mFirst.mByteBuf;
            OneStreamPlayer.this.mLatestIDRFrame.mOneGyroField = oneGyroField;
        }
    }

    public class StreamTarget {
        public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
        public static final int mTextureCount = 3;
        public final String TAG;
        public EglCore mEglCore;
        public EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;
        public int mFbo;
        public LinkedList<StreamShadowTexture> mFilledTexureList = new LinkedList<>();
        public Handler mGLHandler;
        public Thread mGLThread;
        public int mHeight;
        public LinkedList<StreamShadowTexture> mIdleTexureList = new LinkedList<>();
        public onShadowTextureAvalableListener mListener;
        public int mOESTexture;
        public boolean mReleased;
        public DefaultTexRendererNew mRenderer;
        public Surface mSurface;
        public SurfaceTexture mSurfaceTexture;
        public Object mSyncList = new Object();
        public int mWidth;
        public final /* synthetic */ OneStreamPlayer this$0;

        public StreamTarget(OneStreamPlayer oneStreamPlayer, String str, EGLContext eGLContext, int i2, int i3, onShadowTextureAvalableListener onshadowtextureavalablelistener) {
            this.this$0 = oneStreamPlayer;
            this.TAG = str;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            final OneStreamPlayer oneStreamPlayer2 = oneStreamPlayer;
            final EGLContext eGLContext2 = eGLContext;
            final int i4 = i2;
            final int i5 = i3;
            final onShadowTextureAvalableListener onshadowtextureavalablelistener2 = onshadowtextureavalablelistener;
            final CountDownLatch countDownLatch2 = countDownLatch;
            AnonymousClass1 r1 = new Runnable() {
                public void run() {
                    String access$1700 = StreamTarget.this.TAG;
                    StringBuilder a2 = a.a("GL thread start tid ");
                    a2.append(DualStreamUtil.getTid());
                    a2.append(" egl instance ");
                    a2.append(EGLContext.getEGL());
                    a2.append(" eglContext ");
                    a2.append(eGLContext2);
                    Log.i(access$1700, a2.toString());
                    if (eGLContext2 == EGL10.EGL_NO_CONTEXT) {
                        Log.w(StreamTarget.this.TAG, "egl no context");
                    } else {
                        String access$17002 = StreamTarget.this.TAG;
                        StringBuilder a3 = a.a("eglContext ");
                        a3.append(eGLContext2);
                        Log.i(access$17002, a3.toString());
                    }
                    Thread.currentThread().setName(StreamTarget.this.TAG);
                    Looper.prepare();
                    StreamTarget.this.mGLHandler = new Handler(Looper.myLooper());
                    StreamTarget.this.mWidth = i4;
                    StreamTarget.this.mHeight = i5;
                    StreamTarget.this.mListener = onshadowtextureavalablelistener2;
                    StreamTarget.this.initGL(eGLContext2);
                    StreamTarget.this.init();
                    StreamTarget.this.createInputSurface();
                    StreamTarget.this.recreateRender();
                    countDownLatch2.countDown();
                    Looper.loop();
                    Log.i(StreamTarget.this.TAG, "GL thread end");
                }
            };
            Thread thread = new Thread(r1);
            this.mGLThread = thread;
            thread.start();
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public void createInputSurface() {
            initFrameBuffer();
            initOESTexutre();
            this.mSurfaceTexture = new SurfaceTexture(this.mOESTexture);
            String str = this.TAG;
            StringBuilder a2 = a.a("surface w ");
            a2.append(this.mWidth);
            a2.append(" h ");
            a2.append(this.mHeight);
            Log.i(str, a2.toString());
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mSurfaceTexture.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    StreamTarget.this.invokeFrameAvailable(new Runnable() {
                        public void run() {
                            if (!StreamTarget.this.checkEmpty()) {
                                StreamTarget.this.textureCopy();
                            }
                        }
                    });
                }
            });
        }

        private StreamShadowTexture getTexutre() {
            StreamShadowTexture streamShadowTexture;
            synchronized (this.mSyncList) {
                if (this.mIdleTexureList.size() != 0) {
                    streamShadowTexture = (StreamShadowTexture) this.mIdleTexureList.removeFirst();
                    this.mFilledTexureList.add(streamShadowTexture);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.TAG);
                    sb.append(" getTexutre null");
                    throw new RuntimeException(sb.toString());
                }
            }
            return streamShadowTexture;
        }

        /* access modifiers changed from: private */
        public void init() {
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                GLUtils.checkGLError("glGenTextures");
                int i3 = iArr[0];
                GLES20.glBindTexture(3553, i3);
                StringBuilder sb = new StringBuilder();
                sb.append("glBindTexture ");
                sb.append(i3);
                GLUtils.checkGLError(sb.toString());
                GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLUtils.checkGLError("glTexParameter");
                a.b("init: texture id ", i3, this.TAG);
                this.mIdleTexureList.add(StreamShadowTexture.createShadowTexture(i3, this.mWidth, this.mHeight, new onShadowTexutureListener() {
                    public void onDirectRelease(int i2) {
                        StreamTarget.this.releaseTexutre(i2);
                    }
                }));
            }
            GLES20.glBindTexture(3553, 0);
            GLUtils.checkGLError("glBindTexture 0");
        }

        private void initFrameBuffer() {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLUtils.checkGLError("glGenFramebuffers");
            int i2 = iArr[0];
            this.mFbo = i2;
            GLES20.glBindFramebuffer(36160, i2);
            GLES20.glBindFramebuffer(36160, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("glBindFramebuffer init");
            sb.append(this.mFbo);
            GLUtils.checkGLError(sb.toString());
        }

        /* access modifiers changed from: private */
        public void initGL(EGLContext eGLContext) {
            EglCore eglCore = new EglCore(eGLContext, false);
            this.mEglCore = eglCore;
            EGLSurface createOffscreenSurface = eglCore.createOffscreenSurface(1, 1);
            this.mEglSurface = createOffscreenSurface;
            this.mEglCore.makeCurrent(createOffscreenSurface, createOffscreenSurface);
        }

        private void initOESTexutre() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLUtils.checkGLError("glGenTextures");
            int i2 = iArr[0];
            GLES20.glBindTexture(36197, i2);
            StringBuilder sb = new StringBuilder();
            sb.append("glBindTexture ");
            sb.append(i2);
            GLUtils.checkGLError(sb.toString());
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameterf(36197, 10242, 33071.0f);
            GLES20.glTexParameterf(36197, 10243, 33071.0f);
            GLUtils.checkGLError("glTexParameter");
            this.mOESTexture = i2;
            GLES20.glBindTexture(36197, 0);
            a.b("initOESTexutre: textureId ", i2, this.TAG);
        }

        /* access modifiers changed from: private */
        public void invokeFrameAvailable(Runnable runnable) {
            if (Looper.myLooper() == this.mGLHandler.getLooper()) {
                runnable.run();
            } else {
                this.mGLHandler.post(runnable);
            }
        }

        /* access modifiers changed from: private */
        public void recreateRender() {
            DefaultTexRendererNew defaultTexRendererNew = this.mRenderer;
            if (defaultTexRendererNew != null) {
                defaultTexRendererNew.deInit();
                this.mRenderer = null;
            }
            DefaultTexRendererNew defaultTexRendererNew2 = new DefaultTexRendererNew(TextureType.GL2_OES, this.mWidth, this.mHeight, false);
            this.mRenderer = defaultTexRendererNew2;
            if (defaultTexRendererNew2.init() == 0) {
                this.mRenderer.setTargetFb(this.mFbo);
                return;
            }
            throw new RuntimeException(a.a(new StringBuilder(), this.TAG, " Renderer init failed"));
        }

        /* access modifiers changed from: private */
        public void releaseGL() {
            Log.i(this.TAG, "releaseGL:");
            DefaultTexRendererNew defaultTexRendererNew = this.mRenderer;
            if (defaultTexRendererNew != null) {
                defaultTexRendererNew.deInit();
                this.mRenderer = null;
            }
            synchronized (this.mSyncList) {
                if (this.mFilledTexureList.size() > 0) {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("filled size ");
                    sb.append(this.mFilledTexureList.size());
                    sb.append(" idle size ");
                    sb.append(this.mIdleTexureList.size());
                    Log.i(str, sb.toString());
                }
                Iterator it = this.mIdleTexureList.iterator();
                while (it.hasNext()) {
                    GLES20.glDeleteTextures(1, new int[]{((StreamShadowTexture) it.next()).getTextureId()}, 0);
                }
                this.mFilledTexureList.clear();
                this.mFilledTexureList = null;
                this.mIdleTexureList.clear();
                this.mIdleTexureList = null;
            }
            if (this.mSurface != null) {
                this.mSurfaceTexture.release();
                this.mSurface.release();
                this.mSurface = null;
                this.mSurfaceTexture = null;
                int[] iArr = {this.mFbo};
                int[] iArr2 = {this.mOESTexture};
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                GLES20.glDeleteTextures(1, iArr2, 0);
            }
            EglCore eglCore = this.mEglCore;
            if (eglCore != null) {
                eglCore.destroyEglSurface(this.mEglSurface);
                this.mEglSurface = EGL10.EGL_NO_SURFACE;
                this.mEglCore.release();
                this.mEglCore = null;
            }
            Log.i(this.TAG, "releaseGL: over");
        }

        /* access modifiers changed from: private */
        public void textureCopy() {
            StreamShadowTexture texutre = getTexutre();
            try {
                this.mSurfaceTexture.updateTexImage();
            } catch (Throwable unused) {
                Log.e(this.TAG, "!!!!!!!!!!!!!!updateTexImage error!!");
            }
            float[] fArr = new float[16];
            this.mSurfaceTexture.getTransformMatrix(fArr);
            this.mRenderer.setTargetTexture(texutre.getTextureId());
            if (this.mRenderer.render(this.mOESTexture, fArr, null) == 0) {
                GLES20.glFinish();
                this.mListener.onShadowTextureAvailable(texutre);
                return;
            }
            throw new RuntimeException(a.a(new StringBuilder(), this.TAG, " render error "));
        }

        public boolean checkEmpty() {
            boolean isEmpty;
            synchronized (this.mSyncList) {
                isEmpty = this.mIdleTexureList.isEmpty();
            }
            return isEmpty;
        }

        public void finalize() throws Throwable {
            if (!this.mReleased) {
                release();
            }
            super.finalize();
        }

        public Surface getInputSurface() {
            return this.mSurface;
        }

        public void release() {
            this.mReleased = true;
            this.mGLHandler.post(new Runnable() {
                public void run() {
                    StreamTarget.this.releaseGL();
                    Looper myLooper = Looper.myLooper();
                    if (myLooper != null) {
                        myLooper.quit();
                    }
                }
            });
            try {
                this.mGLThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        public void releaseTexutre(int i2) {
            synchronized (this.mSyncList) {
                boolean z = true;
                if (this.mFilledTexureList == null) {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("releaseTexutre: filled already release texture_id ");
                    sb.append(i2);
                    Log.w(str, sb.toString());
                    GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                } else {
                    Iterator it = this.mFilledTexureList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        StreamShadowTexture streamShadowTexture = (StreamShadowTexture) it.next();
                        if (i2 == streamShadowTexture.getTextureId()) {
                            this.mFilledTexureList.remove(streamShadowTexture);
                            this.mIdleTexureList.add(streamShadowTexture);
                            break;
                        }
                    }
                    if (!z) {
                        String str2 = this.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("releaseTexture: fail  ");
                        sb2.append(i2);
                        Log.e(str2, sb2.toString());
                    }
                }
            }
        }
    }

    public interface onShadowTextureAvalableListener {
        void onShadowTextureAvailable(StreamShadowTexture streamShadowTexture);
    }

    public OneStreamPlayer(Looper looper) {
        this.mCBHandler = new Handler(looper);
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mNextRenderTimeNs = System.nanoTime() + 30000000;
        this.mHandler.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                L_0x0000:
                    com.arashivision.onestream.OneStreamPlayer r0 = com.arashivision.onestream.OneStreamPlayer.this
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r0 = r0.mReadyInfoList
                    monitor-enter(r0)
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r1 = r1.mReadyInfoList     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    long r2 = r2.mNextRenderTimeNs     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.DualStreamUtil.waitUntil(r1, r2)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    boolean r1 = r1.mReleased     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x0040
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    boolean r1 = r1.mDebug     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x003e
                    java.lang.String r1 = "OneStreamPlayer"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
                    r2.<init>()     // Catch:{ all -> 0x0168 }
                    java.lang.String r3 = "force release ready "
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r3 = r3.mReadyInfoList     // Catch:{ all -> 0x0168 }
                    int r3 = r3.size()     // Catch:{ all -> 0x0168 }
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0168 }
                    android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0168 }
                L_0x003e:
                    monitor-exit(r0)     // Catch:{ all -> 0x0168 }
                    return
                L_0x0040:
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r1 = r1.mReadyInfoList     // Catch:{ all -> 0x0168 }
                    int r1 = r1.size()     // Catch:{ all -> 0x0168 }
                    if (r1 <= 0) goto L_0x0158
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestreamtarget.OneStreamTarget r1 = r1.mTarget     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x013d
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestreamtarget.OneStreamTarget r1 = r1.mTarget     // Catch:{ all -> 0x0168 }
                    boolean r1 = r1.isSurface()     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x0078
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r2 = r2.mReadyInfoList     // Catch:{ all -> 0x0168 }
                    java.lang.Object r2 = r2.removeFirst()     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$RenderObj r2 = (com.arashivision.onestream.OneStreamPlayer.RenderObj) r2     // Catch:{ all -> 0x0168 }
                    r1.startRender(r2)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestreamtarget.OneStreamTarget r1 = r1.mTarget     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestreamtarget.OneStreamTarget$StreamExtra r2 = r2.getStreamExtra()     // Catch:{ all -> 0x0168 }
                    r1.notifySurfaceRender(r2)     // Catch:{ all -> 0x0168 }
                    goto L_0x0165
                L_0x0078:
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$StreamTarget r1 = r1.mLeftStreamTarget     // Catch:{ all -> 0x0168 }
                    boolean r1 = r1.checkEmpty()     // Catch:{ all -> 0x0168 }
                    if (r1 != 0) goto L_0x00f8
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$StreamTarget r1 = r1.mRightStreamTarget     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x0099
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$StreamTarget r1 = r1.mRightStreamTarget     // Catch:{ all -> 0x0168 }
                    boolean r1 = r1.checkEmpty()     // Catch:{ all -> 0x0168 }
                    if (r1 == 0) goto L_0x0099
                    goto L_0x00f8
                L_0x0099:
                    long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.lang.Object r3 = r3.mSyncRender     // Catch:{ all -> 0x0168 }
                    monitor-enter(r3)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r4 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00f5 }
                    com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00f5 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r5 = r5.mReadyInfoList     // Catch:{ all -> 0x00f5 }
                    java.lang.Object r5 = r5.removeFirst()     // Catch:{ all -> 0x00f5 }
                    com.arashivision.onestream.OneStreamPlayer$RenderObj r5 = (com.arashivision.onestream.OneStreamPlayer.RenderObj) r5     // Catch:{ all -> 0x00f5 }
                    r4.startRender(r5)     // Catch:{ all -> 0x00f5 }
                    com.arashivision.onestream.OneStreamPlayer r4 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ InterruptedException -> 0x00bd }
                    java.lang.Object r4 = r4.mSyncRender     // Catch:{ InterruptedException -> 0x00bd }
                    r4.wait()     // Catch:{ InterruptedException -> 0x00bd }
                    goto L_0x00c1
                L_0x00bd:
                    r4 = move-exception
                    r4.printStackTrace()     // Catch:{ all -> 0x00f5 }
                L_0x00c1:
                    long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00f5 }
                    long r4 = r4 - r1
                    long r4 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setNsToMs(r4)     // Catch:{ all -> 0x00f5 }
                    com.arashivision.onestream.OneStreamPlayer r6 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00f5 }
                    long r6 = r6.mLeastRenderIntervalNs     // Catch:{ all -> 0x00f5 }
                    int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r4 <= 0) goto L_0x00f3
                    java.lang.String r4 = "OneStreamPlayer"
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
                    r5.<init>()     // Catch:{ all -> 0x00f5 }
                    java.lang.String r6 = "render transfer too slow "
                    r5.append(r6)     // Catch:{ all -> 0x00f5 }
                    long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00f5 }
                    long r6 = r6 - r1
                    long r1 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setNsToMs(r6)     // Catch:{ all -> 0x00f5 }
                    r5.append(r1)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x00f5 }
                    android.util.Log.w(r4, r1)     // Catch:{ all -> 0x00f5 }
                L_0x00f3:
                    monitor-exit(r3)     // Catch:{ all -> 0x00f5 }
                    goto L_0x0165
                L_0x00f5:
                    r1 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x00f5 }
                    throw r1     // Catch:{ all -> 0x0168 }
                L_0x00f8:
                    java.lang.String r1 = "OneStreamPlayer"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
                    r2.<init>()     // Catch:{ all -> 0x0168 }
                    java.lang.String r3 = "run: no more texture left "
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$StreamTarget r3 = r3.mLeftStreamTarget     // Catch:{ all -> 0x0168 }
                    boolean r3 = r3.checkEmpty()     // Catch:{ all -> 0x0168 }
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    java.lang.String r3 = " right "
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$StreamTarget r3 = r3.mRightStreamTarget     // Catch:{ all -> 0x0168 }
                    boolean r3 = r3.checkEmpty()     // Catch:{ all -> 0x0168 }
                    r2.append(r3)     // Catch:{ all -> 0x0168 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0168 }
                    android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0168 }
                    r4 = 10
                    long r4 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setMsToNs(r4)     // Catch:{ all -> 0x0168 }
                    long r2 = r2 + r4
                    r1.mNextRenderTimeNs = r2     // Catch:{ all -> 0x0168 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0168 }
                    goto L_0x0000
                L_0x013d:
                    java.lang.String r1 = "OneStreamPlayer"
                    java.lang.String r2 = "no target happen"
                    android.util.Log.e(r1, r2)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r1 = r1.mReadyInfoList     // Catch:{ all -> 0x0168 }
                    java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer$RenderObj r1 = (com.arashivision.onestream.OneStreamPlayer.RenderObj) r1     // Catch:{ all -> 0x0168 }
                    r2 = 1
                    r1.render(r2)     // Catch:{ all -> 0x0168 }
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    r1.updateNextRenderTime()     // Catch:{ all -> 0x0168 }
                    goto L_0x0165
                L_0x0158:
                    com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0168 }
                    long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0168 }
                    r4 = 30000000(0x1c9c380, double:1.48219694E-316)
                    long r2 = r2 + r4
                    r1.mNextRenderTimeNs = r2     // Catch:{ all -> 0x0168 }
                L_0x0165:
                    monitor-exit(r0)     // Catch:{ all -> 0x0168 }
                    goto L_0x0000
                L_0x0168:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0168 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.OneStreamPlayer.AnonymousClass1.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkInputNum() {
        if (this.mRenderInfoList.size() >= 6) {
            for (int i2 = 0; i2 < this.mRenderInfoList.size(); i2++) {
                RenderInfo renderInfo = ((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mFirst;
                String str = " iframe ";
                String str2 = " idx ";
                String str3 = TAG;
                if (renderInfo != null) {
                    StringBuilder a2 = a.a("left mpts ");
                    a2.append(((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mFirst.mPts);
                    a2.append(str2);
                    a2.append(((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mFirst.mIndex);
                    a2.append(str);
                    a.b(a2, ((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mFirst.mIFrame, str3);
                } else if (((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mSecond != null) {
                    StringBuilder a3 = a.a("right mpts ");
                    a3.append(((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mSecond.mPts);
                    a3.append(str2);
                    a3.append(((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mSecond.mIndex);
                    a3.append(str);
                    a.b(a3, ((DualRenderObj) this.mRenderInfoList.valueAt(i2)).mSecond.mIFrame, str3);
                } else {
                    throw new RuntimeException("null render info");
                }
            }
        }
    }

    private void debugContext() {
    }

    private void debugFPS(int i2) {
        long nanoTime = System.nanoTime();
        long j2 = this.mFrameCount + 1;
        this.mFrameCount = j2;
        if (j2 % ((long) i2) == 0) {
            final double d2 = ((double) (i2 * 1000)) / (((double) (nanoTime - this.mStartTime)) / 1000000.0d);
            StringBuilder sb = new StringBuilder();
            sb.append("render fps: ");
            sb.append(d2);
            Log.i(TAG, sb.toString());
            this.mStartTime = nanoTime;
            this.mCBHandler.post(new Runnable() {
                public void run() {
                    OneStreamPlayer.this.mPlayerInfoListenr.onFps(d2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public StreamExtra getStreamExtra() {
        StreamExtra streamExtra = new StreamExtra();
        streamExtra.setGyroMatrix(this.mLastRendrGyro);
        streamExtra.setOriginPts(this.mLastRendrOriginTs);
        return streamExtra;
    }

    private void initPlayer() {
        StringBuilder a2 = a.a("initPlayer dual ");
        a2.append(this.mTarget.isDualStream());
        Log.d(TAG, a2.toString());
        this.mStreamLeftPlayer = new SingleStreamPlayer("OneL");
        if (this.mTarget.isDualStream()) {
            this.mStreamLeftPlayer.setRenderCallback(new RenderAvailableCallback() {
                public void onDropFrame(LinkedList<ImageData> linkedList) {
                    synchronized (OneStreamPlayer.this.mRenderInfoList) {
                        if (OneStreamPlayer.this.mDebug) {
                            String str = OneStreamPlayer.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("left onDropFrame: mRenderInfoList.size() ");
                            sb.append(OneStreamPlayer.this.mRenderInfoList.size());
                            Log.w(str, sb.toString());
                        }
                        Iterator descendingIterator = linkedList.descendingIterator();
                        while (descendingIterator.hasNext()) {
                            ImageData imageData = (ImageData) descendingIterator.next();
                            if (OneStreamPlayer.this.mRenderInfoList.get(imageData.timestampNs) != null) {
                                OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("left skip drop imageData.timestampNs ");
                                sb2.append(imageData.timestampNs);
                                oneStreamPlayer.logd(sb2.toString());
                            } else if (!DualStreamUtil.isIFrame(imageData)) {
                                if (OneStreamPlayer.this.mDropTimestampList.contains(Long.valueOf(imageData.timestampNs))) {
                                    OneStreamPlayer oneStreamPlayer2 = OneStreamPlayer.this;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("onDropFrame: left drop over imageData.timestampNs");
                                    sb3.append(imageData.timestampNs);
                                    oneStreamPlayer2.logd(sb3.toString());
                                    OneStreamPlayer.this.mDropTimestampList.remove(Long.valueOf(imageData.timestampNs));
                                } else {
                                    OneStreamPlayer oneStreamPlayer3 = OneStreamPlayer.this;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("onDropFrame: left imageData.timestampNs ");
                                    sb4.append(imageData.timestampNs);
                                    oneStreamPlayer3.logd(sb4.toString());
                                    OneStreamPlayer.this.mDropTimestampList.add(Long.valueOf(imageData.timestampNs));
                                }
                                descendingIterator.remove();
                            }
                        }
                    }
                }

                public void onError(SingleStreamPlayer singleStreamPlayer, int i2) {
                    OneStreamPlayer.this.notifyError(i2);
                }

                public void onForceRender() {
                    synchronized (OneStreamPlayer.this.mReadyInfoList) {
                        OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("left onForceRender: mReadyInfoList.size() ");
                        sb.append(OneStreamPlayer.this.mReadyInfoList.size());
                        oneStreamPlayer.logd(sb.toString());
                        for (int i2 = 0; i2 < OneStreamPlayer.this.mReadyInfoList.size(); i2++) {
                            RenderObj renderObj = (RenderObj) OneStreamPlayer.this.mReadyInfoList.get(i2);
                            if (renderObj.getFirst() != null) {
                                OneStreamPlayer.this.mStreamLeftPlayer.postRender(renderObj.getFirst(), false);
                            }
                        }
                    }
                    synchronized (OneStreamPlayer.this.mRenderInfoList) {
                        OneStreamPlayer oneStreamPlayer2 = OneStreamPlayer.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("left onForceRender: mRenderInfoList.size() ");
                        sb2.append(OneStreamPlayer.this.mRenderInfoList.size());
                        oneStreamPlayer2.logd(sb2.toString());
                        for (int i3 = 0; i3 < OneStreamPlayer.this.mRenderInfoList.size(); i3++) {
                            RenderObj renderObj2 = (RenderObj) OneStreamPlayer.this.mRenderInfoList.valueAt(i3);
                            if (renderObj2.mFirst != null) {
                                OneStreamPlayer.this.mStreamLeftPlayer.postRender(renderObj2.mFirst, false);
                            }
                        }
                    }
                }

                public void onInput(final long j2, final RenderInfo renderInfo) {
                    OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                    StringBuilder a2 = a.a("onInput: left render ");
                    a2.append(renderInfo.mIndex);
                    a2.append(" ts ");
                    a2.append(j2);
                    a2.append(" renderPts ");
                    a2.append(renderInfo.mPts);
                    a2.append(" iframe ");
                    a2.append(renderInfo.mIFrame);
                    oneStreamPlayer.logd(a2.toString());
                    OneStreamPlayer.this.mCBHandler.post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e4, code lost:
                            return;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r6 = this;
                                com.arashivision.onestream.OneStreamPlayer$4 r0 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this
                                com.arashivision.onestream.OneStreamPlayer r0 = com.arashivision.onestream.OneStreamPlayer.this
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r0 = r0.mRenderInfoList
                                monitor-enter(r0)
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r1 = r1.mRenderInfoList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$DualRenderObj r1 = (com.arashivision.onestream.OneStreamPlayer.DualRenderObj) r1     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x0073
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r1.mFirst = r2     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r1 = r1.mSecond     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x0055
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r1 = r1.mReadyInfoList     // Catch:{ all -> 0x00e5 }
                                monitor-enter(r1)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r2 = r2.mReadyInfoList     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$4 r3 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r3 = r3.mRenderInfoList     // Catch:{ all -> 0x0052 }
                                long r4 = r5     // Catch:{ all -> 0x0052 }
                                java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0052 }
                                r2.add(r3)     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$4 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r2 = r2.mRenderInfoList     // Catch:{ all -> 0x0052 }
                                long r3 = r5     // Catch:{ all -> 0x0052 }
                                r2.remove(r3)     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$4 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r2 = r2.mReadyInfoList     // Catch:{ all -> 0x0052 }
                                r2.notifyAll()     // Catch:{ all -> 0x0052 }
                                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                                goto L_0x00e3
                            L_0x0052:
                                r2 = move-exception
                                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                                throw r2     // Catch:{ all -> 0x00e5 }
                            L_0x0055:
                                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e5 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
                                r2.<init>()     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = "ts "
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = "no right "
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
                                r1.<init>(r2)     // Catch:{ all -> 0x00e5 }
                                throw r1     // Catch:{ all -> 0x00e5 }
                            L_0x0073:
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList r1 = r1.mDropTimestampList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e5 }
                                boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x00c2
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
                                r2.<init>()     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = "onInput: left drop over imageData.timestampNs"
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
                                r1.logd(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList r1 = r1.mDropTimestampList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e5 }
                                r1.remove(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.SingleStreamPlayer r1 = r1.mStreamLeftPlayer     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r3 = 0
                                r1.postRender(r2, r3)     // Catch:{ all -> 0x00e5 }
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                return
                            L_0x00c2:
                                com.arashivision.onestream.OneStreamPlayer$DualRenderObj r1 = new com.arashivision.onestream.OneStreamPlayer$DualRenderObj     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r1.<init>(r3)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r1.mFirst = r2     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r2 = r2.mRenderInfoList     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3, r1)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$4 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                r1.checkInputNum()     // Catch:{ all -> 0x00e5 }
                            L_0x00e3:
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                return
                            L_0x00e5:
                                r1 = move-exception
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.OneStreamPlayer.AnonymousClass4.AnonymousClass1.run():void");
                        }
                    });
                }
            });
            SingleStreamPlayer singleStreamPlayer = new SingleStreamPlayer("OneR");
            this.mStreamRightPlayer = singleStreamPlayer;
            singleStreamPlayer.setRenderCallback(new RenderAvailableCallback() {
                public void onDropFrame(LinkedList<ImageData> linkedList) {
                    synchronized (OneStreamPlayer.this.mRenderInfoList) {
                        if (OneStreamPlayer.this.mDebug) {
                            String str = OneStreamPlayer.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("right onDropFrame: mRenderInfoList.size() ");
                            sb.append(OneStreamPlayer.this.mRenderInfoList.size());
                            Log.w(str, sb.toString());
                        }
                        Iterator descendingIterator = linkedList.descendingIterator();
                        while (descendingIterator.hasNext()) {
                            ImageData imageData = (ImageData) descendingIterator.next();
                            if (OneStreamPlayer.this.mRenderInfoList.get(imageData.timestampNs) != null) {
                                OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("right skip drop imageData.timestampNs ");
                                sb2.append(imageData.timestampNs);
                                oneStreamPlayer.logd(sb2.toString());
                            } else if (!DualStreamUtil.isIFrame(imageData)) {
                                if (OneStreamPlayer.this.mDropTimestampList.contains(Long.valueOf(imageData.timestampNs))) {
                                    OneStreamPlayer oneStreamPlayer2 = OneStreamPlayer.this;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("onDropFrame: rigth drop over imageData.timestampNs ");
                                    sb3.append(imageData.timestampNs);
                                    oneStreamPlayer2.logd(sb3.toString());
                                    OneStreamPlayer.this.mDropTimestampList.remove(Long.valueOf(imageData.timestampNs));
                                } else {
                                    OneStreamPlayer oneStreamPlayer3 = OneStreamPlayer.this;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("onDropFrame: right imageData.timestampNs ");
                                    sb4.append(imageData.timestampNs);
                                    oneStreamPlayer3.logd(sb4.toString());
                                    OneStreamPlayer.this.mDropTimestampList.add(Long.valueOf(imageData.timestampNs));
                                }
                                descendingIterator.remove();
                            }
                        }
                    }
                }

                public void onError(SingleStreamPlayer singleStreamPlayer, int i2) {
                    OneStreamPlayer.this.notifyError(i2);
                }

                public void onForceRender() {
                    synchronized (OneStreamPlayer.this.mReadyInfoList) {
                        OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("right onForceRender: mReadyInfoList.size() ");
                        sb.append(OneStreamPlayer.this.mReadyInfoList.size());
                        oneStreamPlayer.logd(sb.toString());
                        for (int i2 = 0; i2 < OneStreamPlayer.this.mReadyInfoList.size(); i2++) {
                            RenderObj renderObj = (RenderObj) OneStreamPlayer.this.mReadyInfoList.get(i2);
                            if (renderObj.getFirst() != null) {
                                OneStreamPlayer.this.mStreamRightPlayer.postRender(renderObj.getSecond(), false);
                            }
                        }
                    }
                    synchronized (OneStreamPlayer.this.mRenderInfoList) {
                        OneStreamPlayer oneStreamPlayer2 = OneStreamPlayer.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("right onForceRender: mRenderInfoList.size() ");
                        sb2.append(OneStreamPlayer.this.mRenderInfoList.size());
                        oneStreamPlayer2.logd(sb2.toString());
                        for (int i3 = 0; i3 < OneStreamPlayer.this.mRenderInfoList.size(); i3++) {
                            DualRenderObj dualRenderObj = (DualRenderObj) OneStreamPlayer.this.mRenderInfoList.valueAt(i3);
                            if (dualRenderObj.mSecond != null) {
                                OneStreamPlayer.this.mStreamRightPlayer.postRender(dualRenderObj.mSecond, false);
                            }
                        }
                    }
                }

                public void onInput(final long j2, final RenderInfo renderInfo) {
                    OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                    StringBuilder a2 = a.a("onInput: right render ");
                    a2.append(renderInfo.mIndex);
                    a2.append(" ts ");
                    a2.append(j2);
                    a2.append(" renderPts ");
                    a2.append(renderInfo.mPts);
                    a2.append(" iframe ");
                    a2.append(renderInfo.mIFrame);
                    oneStreamPlayer.logd(a2.toString());
                    OneStreamPlayer.this.mCBHandler.post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e4, code lost:
                            return;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r6 = this;
                                com.arashivision.onestream.OneStreamPlayer$5 r0 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this
                                com.arashivision.onestream.OneStreamPlayer r0 = com.arashivision.onestream.OneStreamPlayer.this
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r0 = r0.mRenderInfoList
                                monitor-enter(r0)
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r1 = r1.mRenderInfoList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$DualRenderObj r1 = (com.arashivision.onestream.OneStreamPlayer.DualRenderObj) r1     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x0073
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r1.mSecond = r2     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r1 = r1.mFirst     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x0055
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r1 = r1.mReadyInfoList     // Catch:{ all -> 0x00e5 }
                                monitor-enter(r1)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r2 = r2.mReadyInfoList     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$5 r3 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r3 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r3 = r3.mRenderInfoList     // Catch:{ all -> 0x0052 }
                                long r4 = r5     // Catch:{ all -> 0x0052 }
                                java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0052 }
                                r2.add(r3)     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$5 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r2 = r2.mRenderInfoList     // Catch:{ all -> 0x0052 }
                                long r3 = r5     // Catch:{ all -> 0x0052 }
                                r2.remove(r3)     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer$5 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x0052 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0052 }
                                java.util.LinkedList<com.arashivision.onestream.OneStreamPlayer$RenderObj> r2 = r2.mReadyInfoList     // Catch:{ all -> 0x0052 }
                                r2.notifyAll()     // Catch:{ all -> 0x0052 }
                                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                                goto L_0x00e3
                            L_0x0052:
                                r2 = move-exception
                                monitor-exit(r1)     // Catch:{ all -> 0x0052 }
                                throw r2     // Catch:{ all -> 0x00e5 }
                            L_0x0055:
                                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e5 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
                                r2.<init>()     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = "ts "
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = " no left "
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
                                r1.<init>(r2)     // Catch:{ all -> 0x00e5 }
                                throw r1     // Catch:{ all -> 0x00e5 }
                            L_0x0073:
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList r1 = r1.mDropTimestampList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e5 }
                                boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x00e5 }
                                if (r1 == 0) goto L_0x00c2
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
                                r2.<init>()     // Catch:{ all -> 0x00e5 }
                                java.lang.String r3 = "onInput: right drop over imageData.timestampNs"
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3)     // Catch:{ all -> 0x00e5 }
                                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
                                r1.logd(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                java.util.LinkedList r1 = r1.mDropTimestampList     // Catch:{ all -> 0x00e5 }
                                long r2 = r5     // Catch:{ all -> 0x00e5 }
                                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e5 }
                                r1.remove(r2)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.SingleStreamPlayer r1 = r1.mStreamRightPlayer     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r3 = 0
                                r1.postRender(r2, r3)     // Catch:{ all -> 0x00e5 }
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                return
                            L_0x00c2:
                                com.arashivision.onestream.OneStreamPlayer$DualRenderObj r1 = new com.arashivision.onestream.OneStreamPlayer$DualRenderObj     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r1.<init>(r3)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.DualStreamUtil$RenderInfo r2 = r7     // Catch:{ all -> 0x00e5 }
                                r1.mSecond = r2     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r2 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r2 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                android.util.LongSparseArray<com.arashivision.onestream.OneStreamPlayer$DualRenderObj> r2 = r2.mRenderInfoList     // Catch:{ all -> 0x00e5 }
                                long r3 = r5     // Catch:{ all -> 0x00e5 }
                                r2.append(r3, r1)     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer$5 r1 = com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.this     // Catch:{ all -> 0x00e5 }
                                com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x00e5 }
                                r1.checkInputNum()     // Catch:{ all -> 0x00e5 }
                            L_0x00e3:
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                return
                            L_0x00e5:
                                r1 = move-exception
                                monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.OneStreamPlayer.AnonymousClass5.AnonymousClass1.run():void");
                        }
                    });
                }
            });
            return;
        }
        this.mStreamLeftPlayer.setRenderCallback(new RenderAvailableCallback() {
            public void onDropFrame(LinkedList<ImageData> linkedList) {
                Iterator descendingIterator = linkedList.descendingIterator();
                while (descendingIterator.hasNext()) {
                    if (!DualStreamUtil.isIFrame((ImageData) descendingIterator.next())) {
                        descendingIterator.remove();
                    }
                }
            }

            public void onError(SingleStreamPlayer singleStreamPlayer, int i2) {
                OneStreamPlayer.this.notifyError(i2);
            }

            public void onForceRender() {
                synchronized (OneStreamPlayer.this.mReadyInfoList) {
                    OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("single onForceRender: mReadyInfoList.size() ");
                    sb.append(OneStreamPlayer.this.mReadyInfoList.size());
                    oneStreamPlayer.logd(sb.toString());
                    for (int i2 = 0; i2 < OneStreamPlayer.this.mReadyInfoList.size(); i2++) {
                        RenderObj renderObj = (RenderObj) OneStreamPlayer.this.mReadyInfoList.get(i2);
                        if (renderObj.getFirst() != null) {
                            OneStreamPlayer.this.mStreamLeftPlayer.postRender(renderObj.getSecond(), false);
                        }
                    }
                }
                synchronized (OneStreamPlayer.this.mReadyInfoList) {
                    OneStreamPlayer oneStreamPlayer2 = OneStreamPlayer.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("single onForceRender: mRenderInfoList.size() ");
                    sb2.append(OneStreamPlayer.this.mReadyInfoList.size());
                    oneStreamPlayer2.logd(sb2.toString());
                    while (OneStreamPlayer.this.mReadyInfoList.size() > 0) {
                        ((RenderObj) OneStreamPlayer.this.mReadyInfoList.removeFirst()).render(false);
                    }
                }
            }

            public void onInput(final long j2, final RenderInfo renderInfo) {
                OneStreamPlayer oneStreamPlayer = OneStreamPlayer.this;
                StringBuilder a2 = a.a("onInput: single render ");
                a2.append(renderInfo.mIndex);
                a2.append(" ts ");
                a2.append(j2);
                a2.append(" renderPts ");
                a2.append(renderInfo.mPts);
                a2.append(" iframe ");
                a2.append(renderInfo.mIFrame);
                oneStreamPlayer.logd(a2.toString());
                OneStreamPlayer.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        synchronized (OneStreamPlayer.this.mReadyInfoList) {
                            RenderObj renderObj = new RenderObj(j2);
                            renderObj.mFirst = renderInfo;
                            OneStreamPlayer.this.mReadyInfoList.add(renderObj);
                            OneStreamPlayer.this.mReadyInfoList.notifyAll();
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void logd(String str) {
        if (this.mDebug) {
            Log.d(TAG, str);
        }
    }

    /* access modifiers changed from: private */
    public void notifyError(final int i2) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneStreamPlayer.this.mPlayerInfoListenr.onError(i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyRender() {
        ShadowObj shadowObj = this.mShadowObj;
        this.mShadowObj = null;
        shadowObj.mStreamExtra = getStreamExtra();
        this.mSyncRender.notifyAll();
        this.mTarget.notifyStreamShadowRender(shadowObj);
    }

    private void setPreviewSurface(int i2, int i3) {
        if (this.mStreamRightPlayer != null) {
            int i4 = i2 / 2;
            StreamTarget streamTarget = new StreamTarget(this, "OneLeftTarget", this.mTarget.getEGLContext(), i4, i3, new onShadowTextureAvalableListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onShadowTextureAvailable(com.arashivision.onestreamtarget.StreamShadowTexture r5) {
                    /*
                        r4 = this;
                        com.arashivision.onestream.OneStreamPlayer r0 = com.arashivision.onestream.OneStreamPlayer.this
                        java.lang.Object r0 = r0.mSyncRender
                        monitor-enter(r0)
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        boolean r1 = r1.mReleased     // Catch:{ all -> 0x0078 }
                        if (r1 == 0) goto L_0x0027
                        r5.directRelease()     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r5 = r5.mShadowObj     // Catch:{ all -> 0x0078 }
                        if (r5 == 0) goto L_0x0025
                        java.lang.String r5 = "OneStreamPlayer"
                        java.lang.String r1 = "left target released2"
                        android.util.Log.i(r5, r1)     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        r1 = 0
                        r5.mShadowObj = r1     // Catch:{ all -> 0x0078 }
                    L_0x0025:
                        monitor-exit(r0)     // Catch:{ all -> 0x0078 }
                        return
                    L_0x0027:
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x0078 }
                        if (r1 != 0) goto L_0x0042
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj r2 = new com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj     // Catch:{ all -> 0x0078 }
                        r2.<init>()     // Catch:{ all -> 0x0078 }
                        r1.mShadowObj = r2     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x0078 }
                        r1.mFirst = r5     // Catch:{ all -> 0x0078 }
                        goto L_0x005b
                    L_0x0042:
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x0078 }
                        r1.mFirst = r5     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj r1 = (com.arashivision.onestreamtarget.OneStreamTarget.DualShadowObj) r1     // Catch:{ all -> 0x0078 }
                        com.arashivision.onestreamtarget.StreamShadowTexture r1 = r1.mSecond     // Catch:{ all -> 0x0078 }
                        if (r1 == 0) goto L_0x005d
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x0078 }
                        r5.notifyRender()     // Catch:{ all -> 0x0078 }
                    L_0x005b:
                        monitor-exit(r0)     // Catch:{ all -> 0x0078 }
                        return
                    L_0x005d:
                        java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
                        r2.<init>()     // Catch:{ all -> 0x0078 }
                        java.lang.String r3 = "mShadowObj.mSecond unexpected null "
                        r2.append(r3)     // Catch:{ all -> 0x0078 }
                        int r5 = r5.getTextureId()     // Catch:{ all -> 0x0078 }
                        r2.append(r5)     // Catch:{ all -> 0x0078 }
                        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0078 }
                        r1.<init>(r5)     // Catch:{ all -> 0x0078 }
                        throw r1     // Catch:{ all -> 0x0078 }
                    L_0x0078:
                        r5 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0078 }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.OneStreamPlayer.AnonymousClass7.onShadowTextureAvailable(com.arashivision.onestreamtarget.StreamShadowTexture):void");
                }
            });
            this.mLeftStreamTarget = streamTarget;
            this.mStreamLeftPlayer.setPreviewSurface(streamTarget.getInputSurface());
            StreamTarget streamTarget2 = new StreamTarget(this, "OneRightTarget", this.mTarget.getEGLContext(), i4, i3, new onShadowTextureAvalableListener() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onShadowTextureAvailable(com.arashivision.onestreamtarget.StreamShadowTexture r5) {
                    /*
                        r4 = this;
                        com.arashivision.onestream.OneStreamPlayer r0 = com.arashivision.onestream.OneStreamPlayer.this
                        java.lang.Object r0 = r0.mSyncRender
                        monitor-enter(r0)
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        boolean r1 = r1.mReleased     // Catch:{ all -> 0x008f }
                        if (r1 == 0) goto L_0x003c
                        r5.directRelease()     // Catch:{ all -> 0x008f }
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r5 = r5.mShadowObj     // Catch:{ all -> 0x008f }
                        if (r5 == 0) goto L_0x003a
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r5 = r5.mShadowObj     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.StreamShadowTexture r5 = r5.mFirst     // Catch:{ all -> 0x008f }
                        if (r5 == 0) goto L_0x003a
                        java.lang.String r5 = "OneStreamPlayer"
                        java.lang.String r1 = "left target released2"
                        android.util.Log.d(r5, r1)     // Catch:{ all -> 0x008f }
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r5 = r5.mShadowObj     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.StreamShadowTexture r5 = r5.mFirst     // Catch:{ all -> 0x008f }
                        r5.directRelease()     // Catch:{ all -> 0x008f }
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        r1 = 0
                        r5.mShadowObj = r1     // Catch:{ all -> 0x008f }
                    L_0x003a:
                        monitor-exit(r0)     // Catch:{ all -> 0x008f }
                        return
                    L_0x003c:
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x008f }
                        if (r1 != 0) goto L_0x0059
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj r2 = new com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj     // Catch:{ all -> 0x008f }
                        r2.<init>()     // Catch:{ all -> 0x008f }
                        r1.mShadowObj = r2     // Catch:{ all -> 0x008f }
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj r1 = (com.arashivision.onestreamtarget.OneStreamTarget.DualShadowObj) r1     // Catch:{ all -> 0x008f }
                        r1.mSecond = r5     // Catch:{ all -> 0x008f }
                        goto L_0x0072
                    L_0x0059:
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$DualShadowObj r1 = (com.arashivision.onestreamtarget.OneStreamTarget.DualShadowObj) r1     // Catch:{ all -> 0x008f }
                        r1.mSecond = r5     // Catch:{ all -> 0x008f }
                        com.arashivision.onestream.OneStreamPlayer r1 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.OneStreamTarget$ShadowObj r1 = r1.mShadowObj     // Catch:{ all -> 0x008f }
                        com.arashivision.onestreamtarget.StreamShadowTexture r1 = r1.mFirst     // Catch:{ all -> 0x008f }
                        if (r1 == 0) goto L_0x0074
                        com.arashivision.onestream.OneStreamPlayer r5 = com.arashivision.onestream.OneStreamPlayer.this     // Catch:{ all -> 0x008f }
                        r5.notifyRender()     // Catch:{ all -> 0x008f }
                    L_0x0072:
                        monitor-exit(r0)     // Catch:{ all -> 0x008f }
                        return
                    L_0x0074:
                        java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008f }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
                        r2.<init>()     // Catch:{ all -> 0x008f }
                        java.lang.String r3 = "mShadowObj.mFirst unexpected null "
                        r2.append(r3)     // Catch:{ all -> 0x008f }
                        int r5 = r5.getTextureId()     // Catch:{ all -> 0x008f }
                        r2.append(r5)     // Catch:{ all -> 0x008f }
                        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x008f }
                        r1.<init>(r5)     // Catch:{ all -> 0x008f }
                        throw r1     // Catch:{ all -> 0x008f }
                    L_0x008f:
                        r5 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x008f }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.OneStreamPlayer.AnonymousClass8.onShadowTextureAvailable(com.arashivision.onestreamtarget.StreamShadowTexture):void");
                }
            });
            this.mRightStreamTarget = streamTarget2;
            this.mStreamRightPlayer.setPreviewSurface(streamTarget2.getInputSurface());
            return;
        }
        StreamTarget streamTarget3 = new StreamTarget(this, "OneLeftTarget", this.mTarget.getEGLContext(), i2, i3, new onShadowTextureAvalableListener() {
            public void onShadowTextureAvailable(StreamShadowTexture streamShadowTexture) {
                synchronized (OneStreamPlayer.this.mSyncRender) {
                    if (OneStreamPlayer.this.mReleased) {
                        streamShadowTexture.directRelease();
                        return;
                    }
                    OneStreamPlayer.this.mShadowObj = new ShadowObj();
                    OneStreamPlayer.this.mShadowObj.mFirst = streamShadowTexture;
                    OneStreamPlayer.this.notifyRender();
                }
            }
        });
        this.mLeftStreamTarget = streamTarget3;
        this.mStreamLeftPlayer.setPreviewSurface(streamTarget3.getInputSurface());
    }

    /* access modifiers changed from: private */
    public void startRender(RenderObj renderObj) {
        renderObj.render(true);
        updateNextRenderTime();
        renderObj.getGyroInfo();
    }

    /* access modifiers changed from: private */
    public void updateNextRenderTime() {
        debugFPS(300);
        if (System.nanoTime() - this.mNextRenderTimeNs > this.mLeastRenderIntervalNs * 2) {
            if (this.mDebug) {
                StringBuilder a2 = a.a("render delay ");
                a2.append(ClockUtil.setNsToMs(System.nanoTime() - this.mNextRenderTimeNs));
                a2.append(" ready render ");
                a2.append(this.mReadyInfoList.size());
                Log.w(TAG, a2.toString());
            }
            this.mNextRenderTimeNs = (this.mLeastRenderIntervalNs / 2) + System.nanoTime();
            return;
        }
        this.mNextRenderTimeNs = System.nanoTime() + this.mLeastRenderIntervalNs;
    }

    public OneLatestIDR getLatestIDRFrame() {
        return this.mLatestIDRFrame;
    }

    public void init(OneStreamTarget oneStreamTarget, int i2, int i3, String str, int i4) {
        this.mTarget = oneStreamTarget;
        initPlayer();
        if (this.mTarget.isSurface()) {
            this.mStreamLeftPlayer.setPreviewSurface(this.mTarget.getSurface());
            SingleStreamPlayer singleStreamPlayer = this.mStreamRightPlayer;
            if (singleStreamPlayer != null) {
                singleStreamPlayer.setPreviewSurface(this.mTarget.getSecSurface());
            }
        } else {
            setPreviewSurface(i2, i3);
        }
        this.mStreamLeftPlayer.setFormat(str);
        if (i4 == 30) {
            this.mLeastRenderIntervalNs = 20;
        } else if (i4 == 25) {
            this.mLeastRenderIntervalNs = 30;
        } else if (i4 == 20) {
            this.mLeastRenderIntervalNs = 40;
        } else if (i4 == 15) {
            this.mLeastRenderIntervalNs = 50;
        } else if (i4 == 10) {
            this.mLeastRenderIntervalNs = 80;
        } else {
            this.mLeastRenderIntervalNs = 10;
        }
        this.mLeastRenderIntervalNs = ClockUtil.setMsToNs(this.mLeastRenderIntervalNs);
        double d2 = (double) i4;
        this.mStreamLeftPlayer.setFps(d2);
        SingleStreamPlayer singleStreamPlayer2 = this.mStreamRightPlayer;
        if (singleStreamPlayer2 != null) {
            singleStreamPlayer2.setVideoSize(i2 / 2, i3);
            this.mStreamRightPlayer.setFormat(str);
            this.mStreamRightPlayer.setFps(d2);
            return;
        }
        this.mStreamLeftPlayer.setVideoSize(i2, i3);
    }

    public void putData(ImageData imageData) {
        this.mStreamLeftPlayer.put(imageData);
    }

    public void release() {
        Log.i(TAG, "release: ");
        synchronized (this.mReadyInfoList) {
            this.mNextRenderTimeNs = RecyclerView.FOREVER_NS;
            this.mReleased = true;
            this.mReadyInfoList.notifyAll();
        }
        this.mHandlerThread.quit();
        try {
            this.mHandlerThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.mHandlerThread = null;
        SingleStreamPlayer singleStreamPlayer = this.mStreamLeftPlayer;
        if (singleStreamPlayer != null) {
            singleStreamPlayer.release();
            this.mStreamLeftPlayer = null;
        }
        SingleStreamPlayer singleStreamPlayer2 = this.mStreamRightPlayer;
        if (singleStreamPlayer2 != null) {
            singleStreamPlayer2.release();
            this.mStreamRightPlayer = null;
        }
        StreamTarget streamTarget = this.mLeftStreamTarget;
        if (streamTarget != null) {
            streamTarget.release();
        }
        StreamTarget streamTarget2 = this.mRightStreamTarget;
        if (streamTarget2 != null) {
            streamTarget2.release();
        }
        this.mLatestIDRFrame = null;
        this.mExposureQueue = null;
    }

    public void start() {
        this.mStreamLeftPlayer.start();
        SingleStreamPlayer singleStreamPlayer = this.mStreamRightPlayer;
        if (singleStreamPlayer != null) {
            singleStreamPlayer.start();
        }
    }

    public void putData(ImageData imageData, ImageData imageData2) {
        putData(imageData);
        this.mStreamRightPlayer.put(imageData2);
    }
}
