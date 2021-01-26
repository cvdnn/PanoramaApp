package com.arashivision.onestream;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.arashivision.onestream.AbstractPlayer.StreamExposureInfo;
import com.arashivision.onestream.Gyro.GyroType;
import com.arashivision.onestream.Gyro.OneGyroField;
import com.arashivision.onestream.Gyro.OneLatestIDR;
import com.arashivision.onestreamtarget.OneStreamTarget;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import e.a.a.a.a;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class OneStreamPipeline {
    public static final int PLAYER_MAX_RETRY_COUNT = 5;
    public static final String TAG = "OneStreamPipeline";
    public AudioSourceType mAudioSourceType = AudioSourceType.None;
    public Handler mCallbackHandler;
    public Callbacks mCallbacks;
    public Context mContext;
    public float[] mGyroRebaseMatrix;
    public GyroType mGyroType = GyroType.Unknown;
    public Handler mHandler;
    public boolean mHintRecordAudio;
    public RecordStatus mInnerRecordStatus = RecordStatus.Idle;
    public String mInputFormat;
    public double mInputVideoFps = 0.0d;
    public boolean mOpen;
    public int mOutHeight;
    public RecordState mOutRecordState = RecordState.Idle;
    public Object mOutTarget;
    public int mOutWidth;
    public String mPanoOffset;
    public Object mPendingTarget;
    public int mPipelineError;
    public AbstractPlayer mPlayerAdapter;
    public PlayerBackend mPlayerBackend;
    public int mPlayerErrorCount;
    public long mPreviewDeltaNs;
    public String mRecordFile;
    public boolean mReleased;
    public boolean mRendererDirty;
    public EGLContext mSharedEglContext = EGL10.EGL_NO_CONTEXT;
    public Thread mThread;
    public int mVideoHeight;
    public int mVideoWidth;
    public boolean mWithoutYawRotation;

    public enum AudioSourceType {
        None,
        InnerRecorder,
        OutsideSource
    }

    public interface Callbacks {
        void onPipelineError(OneStreamPipeline oneStreamPipeline, int i2, int i3, String str);

        void onPipelineImageCaptured(OneStreamPipeline oneStreamPipeline, int i2, int i3, int i4, String str);

        void onPipelineInfo(int i2, int i3, Object obj);

        void onPipelineRecordComplete(OneStreamPipeline oneStreamPipeline);

        void onPipelineRecordError(OneStreamPipeline oneStreamPipeline, int i2);
    }

    public static class RecordParam {
        public int audioBitrate;
        public int bitrate;
        public int cameraLiveRenderMode;
        public int channels;
        public byte[] csd;
        public boolean enableX264Encoder = false;
        public String format;
        public int fps;
        public boolean hasAudio;
        public int height;
        public long networkid;
        public boolean outsideAudioSource;
        public String path;
        public RenderWay renderWay;
        public int sampleRate;
        public int width;
        public String x264Preset;

        public void setAudioParam(boolean z, int i2, int i3, int i4, byte[] bArr) {
            this.hasAudio = true;
            this.outsideAudioSource = z;
            this.channels = i2;
            this.sampleRate = i3;
            this.audioBitrate = i4;
            this.csd = bArr;
        }

        public void setVideoParam(int i2, int i3, int i4, int i5, String str, String str2, RenderWay renderWay2, int i6) {
            this.width = i2;
            this.height = i3;
            this.fps = i4;
            this.bitrate = i5;
            this.path = str;
            this.format = str2;
            this.renderWay = renderWay2;
            this.cameraLiveRenderMode = i6;
        }
    }

    public enum RecordState {
        Idle,
        Started
    }

    public enum RecordStatus {
        Idle,
        Recording,
        WaitingStop,
        Error
    }

    public OneStreamPipeline(Context context, Callbacks callbacks, Looper looper, Handler handler) {
        this.mContext = context;
        this.mCallbacks = callbacks;
        Handler handler2 = new Handler(looper);
        this.mHandler = handler2;
        if (handler != null) {
            this.mCallbackHandler = handler;
        } else {
            this.mCallbackHandler = handler2;
        }
        AppContextStab.setContext(this.mContext);
    }

    public static /* synthetic */ int access$004(OneStreamPipeline oneStreamPipeline) {
        int i2 = oneStreamPipeline.mPlayerErrorCount + 1;
        oneStreamPipeline.mPlayerErrorCount = i2;
        return i2;
    }

    private void deInit() {
        Log.i(TAG, "deInit");
        this.mOutTarget = null;
        this.mPendingTarget = null;
        this.mGyroType = GyroType.Unknown;
    }

    /* access modifiers changed from: private */
    public void invokeCallback(Runnable runnable) {
        Handler handler = this.mCallbackHandler;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void onRecorderComplete() {
    }

    private void onRecorderError(final int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("on recorder error: ");
        sb.append(i2);
        Log.i(TAG, sb.toString());
        this.mInnerRecordStatus = RecordStatus.Error;
        invokeCallback(new Runnable() {
            public void run() {
                OneStreamPipeline.this.mCallbacks.onPipelineRecordError(OneStreamPipeline.this, i2);
            }
        });
    }

    private void onRecorderInfoUpdate(final int i2, final int i3, final Object obj) {
        if (this.mInnerRecordStatus == RecordStatus.Recording) {
            invokeCallback(new Runnable() {
                public void run() {
                    OneStreamPipeline.this.mCallbacks.onPipelineInfo(i2, i3, obj);
                }
            });
        }
    }

    private void performSetSurface(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(" target ");
        sb.append(obj);
        sb.append(" mOutTarget ");
        sb.append(this.mOutTarget);
        String sb2 = sb.toString();
        String str = TAG;
        Log.i(str, sb2);
        if (obj == this.mOutTarget) {
            StringBuilder a2 = a.a("surface not changed: ");
            a2.append(this.mOutTarget);
            a2.append(",  ");
            a2.append(obj);
            Log.i(str, a2.toString());
            return;
        }
        if (obj == null) {
            Log.i(str, "perform set surface null");
        } else if (obj instanceof OneStreamTarget) {
            Log.i(str, "perform stream target ");
        } else if (obj instanceof TexturePipeline) {
            Log.i(str, "perform stream pipeline ");
        } else {
            Log.e(str, "perform set error? ");
            throw new IllegalStateException("perform set error");
        }
        if (obj == null) {
            this.mOutTarget = null;
            this.mPendingTarget = null;
            releaseAdapter();
        } else if (this.mInputFormat != null) {
            this.mOutTarget = obj;
            this.mPendingTarget = null;
            reInitPlayer();
        } else {
            Log.w(str, "mInputFormat still null");
        }
    }

    /* access modifiers changed from: private */
    public void reInitPlayer() {
        if (this.mPlayerAdapter != null) {
            String str = " mPlayerAdapter not null error ";
            String str2 = TAG;
            Log.e(str2, str);
            Log.e(str2, " mPlayerAdapter not null error");
            Log.e(str2, str);
        }
        if (this.mPlayerBackend == PlayerBackend.DualPlayer) {
            OneStreamPlayer oneStreamPlayer = new OneStreamPlayer(this.mHandler.getLooper());
            this.mPlayerAdapter = oneStreamPlayer;
            oneStreamPlayer.init((OneStreamTarget) this.mOutTarget, this.mVideoWidth, this.mVideoHeight, this.mInputFormat, (int) this.mInputVideoFps);
        } else {
            NativePlayer nativePlayer = new NativePlayer(this.mHandler.getLooper());
            this.mPlayerAdapter = nativePlayer;
            nativePlayer.init(this.mOutTarget, this.mVideoWidth, this.mVideoHeight, this.mInputFormat, (int) this.mInputVideoFps);
        }
        this.mPlayerAdapter.setInfoNotify(new PlayerInfoListenr() {
            public void onError(final int i2) {
                int access$000 = OneStreamPipeline.this.mPlayerErrorCount;
                String str = OneStreamPipeline.TAG;
                if (access$000 <= 5) {
                    Log.e(str, "player met error, re-init");
                    OneStreamPipeline.access$004(OneStreamPipeline.this);
                    OneStreamPipeline.this.releaseAdapter();
                    OneStreamPipeline.this.reInitPlayer();
                    return;
                }
                a.c("player met error: ", i2, str);
                OneStreamPipeline.this.invokeCallback(new Runnable() {
                    public void run() {
                        OneStreamPipeline.this.mCallbacks.onPipelineError(OneStreamPipeline.this, -201, i2, "");
                    }
                });
            }

            public void onFps(final double d2) {
                OneStreamPipeline.this.invokeCallback(new Runnable() {
                    public void run() {
                        OneStreamPipeline.this.mCallbacks.onPipelineInfo(1, 0, new Double(d2));
                    }
                });
            }
        });
        this.mPlayerAdapter.setGyroType(this.mGyroType, this.mGyroRebaseMatrix, this.mWithoutYawRotation);
        this.mPlayerAdapter.setPreviewDeltaNs(this.mPreviewDeltaNs);
    }

    /* access modifiers changed from: private */
    public void releaseAdapter() {
        String str = TAG;
        Log.i(str, " releaseAdapter ");
        if (this.mPlayerAdapter != null) {
            Log.i(str, " releaseAdapter2 ");
            this.mPlayerAdapter.release();
            this.mPlayerAdapter = null;
            return;
        }
        Log.i(str, " releaseAdapter3 ");
    }

    public void close() {
        Log.i(TAG, LivenessStat.TYPE_VOICE_CLOSE);
        if (this.mOpen) {
            deInit();
            this.mOpen = false;
            this.mInputFormat = null;
            this.mPanoOffset = null;
            this.mPendingTarget = null;
        }
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public OneLatestIDR getLatestIDRFrame() {
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            return abstractPlayer.getLatestIDRFrame();
        }
        return null;
    }

    public void open(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("open: ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = TAG;
        Log.i(str2, sb2);
        this.mOpen = true;
        this.mPanoOffset = str;
        this.mPlayerErrorCount = 0;
        if (this.mPendingTarget != null && this.mInputFormat != null) {
            Log.i(str2, " perform pending");
            performSetSurface(this.mPendingTarget);
        }
    }

    public void putAudio(AudioData audioData) {
    }

    public void putExposureTime(StreamExposureInfo streamExposureInfo) {
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            abstractPlayer.putExposureTime(streamExposureInfo);
        }
    }

    public void putGyro(LinkedList<OneGyroField> linkedList) {
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            abstractPlayer.putGyro(linkedList);
        }
    }

    public void putImage(ImageData imageData) {
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            abstractPlayer.putData(imageData);
        }
    }

    public void release() {
        Log.i(TAG, "release");
        if (this.mOpen) {
            close();
        }
        this.mReleased = true;
    }

    public void resetRecord() {
    }

    public void setGyroType(GyroType gyroType, float[] fArr, boolean z) {
        this.mGyroType = gyroType;
        this.mGyroRebaseMatrix = fArr;
        this.mWithoutYawRotation = z;
    }

    public void setInputFormat(String str) {
        if (str != null) {
            String str2 = this.mInputFormat;
            String str3 = TAG;
            if (str2 == str) {
                StringBuilder a2 = a.a(" same format (");
                a2.append(this.mInputFormat);
                a2.append(" == ");
                a2.append(str);
                a2.append(")");
                Log.e(str3, a2.toString());
                return;
            }
            if (this.mOutTarget != null) {
                Log.i(str3, "mOutTarget not null");
            }
            this.mInputFormat = str;
            if (this.mPendingTarget != null) {
                Log.i(str3, " perform pending");
                performSetSurface(this.mPendingTarget);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(" format is null");
    }

    public void setInputFps(double d2) {
        this.mInputVideoFps = d2;
    }

    public void setInputWideoResolution(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }

    public void setPlayerBackend(PlayerBackend playerBackend) {
        StringBuilder sb = new StringBuilder();
        sb.append("set playerBackend ");
        sb.append(playerBackend);
        Log.i(TAG, sb.toString());
        this.mPlayerBackend = playerBackend;
    }

    public void setPreviewDeltaNs(long j2) {
        this.mPreviewDeltaNs = j2;
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            abstractPlayer.setPreviewDeltaNs(j2);
        }
    }

    public void setSurface(Object obj) {
        boolean z = this.mOpen;
        String str = TAG;
        if (!z || this.mInputFormat == null) {
            this.mPendingTarget = obj;
            String str2 = " mPendingTarget ";
            if (!this.mOpen) {
                StringBuilder sb = new StringBuilder();
                sb.append("not open pending set surface: ");
                sb.append(obj);
                sb.append(str2);
                sb.append(this.mPendingTarget);
                Log.i(str, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("mInputFormat null pending set surface: ");
                sb2.append(obj);
                sb2.append(str2);
                sb2.append(this.mPendingTarget);
                Log.e(str, sb2.toString());
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" performSetSurface ");
        sb3.append(obj);
        Log.i(str, sb3.toString());
        performSetSurface(obj);
    }

    public void startRecordVideo(RecordParam recordParam) {
    }

    public void stopRecordVideo() {
    }

    public void updatePanoOffset(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("update pano offset: ");
        sb.append(str);
        Log.i(TAG, sb.toString());
        this.mPanoOffset = str;
        this.mRendererDirty = true;
    }

    public void putImage(ImageData imageData, ImageData imageData2) {
        AbstractPlayer abstractPlayer = this.mPlayerAdapter;
        if (abstractPlayer != null) {
            abstractPlayer.putData(imageData, imageData2);
        }
    }
}
