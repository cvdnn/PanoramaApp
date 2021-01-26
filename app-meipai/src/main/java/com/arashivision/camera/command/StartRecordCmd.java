package com.arashivision.camera.command;

import android.os.Handler;
import android.util.Log;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.onecamera.AudioSource;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.StartCaptureWithoutStorage;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.render.RenderMethod;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onecamera.render.RenderMode.Type;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.OneStreamPipeline.RecordParam;
import com.arashivision.onestream.RenderWay;
import com.arashivision.onestream.pipeline.ICameraLivePipline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;

public class StartRecordCmd implements InstaCmdExe, ICameraLivePipline {
    public static final int AUDIO_CHANNEL = 1;
    public static final String TAG = "com.arashivision.camera.command.StartRecordCmd";
    public AudioSource mAudioSource;
    public ICameraLiveStateListener mCameraLiveStateListener;
    public StartCaptureWithoutStorage mCaptureWithoutStorage;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public Handler mInfoHandler;
    public InfoUpdateListener mInfoUpdateListener;
    public final boolean mLivePush;
    public int mMode;
    public final boolean mRecordOriginVideo;
    public String mRecordPath;
    public RecordingType mRecordingType;
    public OneStreamPipeline mStreamPipeline;
    public StartStreamingParam mStreamingParam;

    public StartRecordCmd(boolean z, boolean z2, int i2, StartStreamingParam startStreamingParam, RecordingType recordingType, OneStreamPipeline oneStreamPipeline, StartCaptureWithoutStorage startCaptureWithoutStorage, ICameraPreviewPipeline iCameraPreviewPipeline, AudioSource audioSource, InfoUpdateListener infoUpdateListener, Handler handler, ICameraLiveStateListener iCameraLiveStateListener) {
        this.mRecordOriginVideo = z;
        this.mLivePush = z2;
        this.mRecordingType = recordingType;
        this.mCaptureWithoutStorage = startCaptureWithoutStorage;
        this.mStreamPipeline = oneStreamPipeline;
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
        this.mStreamingParam = startStreamingParam;
        this.mAudioSource = audioSource;
        this.mMode = i2;
        this.mInfoUpdateListener = infoUpdateListener;
        this.mInfoHandler = handler;
        this.mCameraLiveStateListener = iCameraLiveStateListener;
    }

    private void notifyFps(final int i2) {
        Handler handler = this.mInfoHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    StartRecordCmd.this.mInfoUpdateListener.onRecordFpsUpdate(i2);
                }
            });
        } else {
            this.mInfoUpdateListener.onRecordFpsUpdate(i2);
        }
    }

    private void notifyLivePushStart() {
        Handler handler = this.mInfoHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    StartRecordCmd.this.mInfoUpdateListener.onLivePushStarted(StartRecordCmd.this.mRecordPath);
                }
            });
        } else {
            this.mInfoUpdateListener.onLivePushStarted(this.mRecordPath);
        }
    }

    private void onRecordError(int i2) {
        ICameraLiveStateListener iCameraLiveStateListener = this.mCameraLiveStateListener;
        if (iCameraLiveStateListener != null) {
            iCameraLiveStateListener.onRecordError(i2, this.mRecordingType, this.mRecordPath);
        }
    }

    public static RenderWay renderMode2RenderWay(RenderMode renderMode) {
        if (renderMode.type == Type.DirectDecoding) {
            return RenderWay.DirectDecoding;
        }
        return renderMode.renderMethod == RenderMethod.PlanarKeep ? RenderWay.PlanarKeep : RenderWay.DualFishEyeStitchingPlanar;
    }

    private void startCaptureWithoutStorage(StartCaptureWithoutStorage startCaptureWithoutStorage) {
        this.mRecordPath = startCaptureWithoutStorage.path;
        String str = TAG;
        StringBuilder a2 = a.a("startCaptureWithoutStorage mRecordStatus  mReq.mRecordType ");
        a2.append(startCaptureWithoutStorage.mRecordType);
        a2.append(" RenderWay ");
        a2.append(startCaptureWithoutStorage.renderMode.renderMethod);
        a2.append(" bmg live render mode ");
        a.c(a2, startCaptureWithoutStorage.cameraLiveRenderMode, str);
        if (this.mRecordingType == RecordingType.ReEncoded) {
            RecordParam recordParam = new RecordParam();
            if (this.mICameraPreviewPipeline == null || this.mStreamingParam == null) {
                if (AudioSource.AUDIO_MOBILE == this.mAudioSource) {
                    StartStreamingParam startStreamingParam = this.mStreamingParam;
                    if (startStreamingParam != null) {
                        AudioParam audioParam = startStreamingParam.getAudioParam();
                        recordParam.setAudioParam(false, 1, audioParam.sampleRate, audioParam.bitrate, null);
                    }
                }
                this.mStreamPipeline.startRecordVideo(recordParam);
                return;
            }
            Log.i(TAG, " onStartLive ");
            int i2 = startCaptureWithoutStorage.width;
            String str2 = ")";
            String str3 = ") to (";
            if (i2 % 16 != 0) {
                int i3 = ((i2 / 16) + 1) * 16;
                String str4 = TAG;
                StringBuilder a3 = a.a(" change live width from (");
                a3.append(startCaptureWithoutStorage.width);
                a3.append(str3);
                a3.append(i3);
                a3.append(str2);
                Log.e(str4, a3.toString());
                startCaptureWithoutStorage.width = i3;
            }
            int i4 = startCaptureWithoutStorage.height;
            if (i4 % 2 != 0) {
                int i5 = ((i4 / 2) + 1) * 2;
                String str5 = TAG;
                StringBuilder a4 = a.a(" change live height from (");
                a4.append(startCaptureWithoutStorage.height);
                a4.append(str3);
                a4.append(i5);
                a4.append(str2);
                Log.e(str5, a4.toString());
                startCaptureWithoutStorage.height = i5;
            }
            AudioParam audioParam2 = this.mStreamingParam.getAudioParam();
            RecordParam recordParam2 = recordParam;
            recordParam2.setAudioParam(false, 1, audioParam2.sampleRate, audioParam2.bitrate, null);
            recordParam.hasAudio = audioParam2.enable;
            recordParam2.setVideoParam(startCaptureWithoutStorage.width, startCaptureWithoutStorage.height, startCaptureWithoutStorage.fps, startCaptureWithoutStorage.bitrate, startCaptureWithoutStorage.path, startCaptureWithoutStorage.format, renderMode2RenderWay(startCaptureWithoutStorage.renderMode), startCaptureWithoutStorage.cameraLiveRenderMode);
            recordParam.networkid = startCaptureWithoutStorage.networkId;
            this.mICameraPreviewPipeline.onStartLive(recordParam, this);
            return;
        }
        StringBuilder a5 = a.a("mRecordingType: ");
        a5.append(this.mRecordingType);
        throw new IllegalStateException(a5.toString());
    }

    public Object exeCmd(OneDriver oneDriver) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" one driver = ");
        sb.append(oneDriver);
        Log.d(str, sb.toString());
        if (this.mLivePush) {
            startCaptureWithoutStorage(this.mCaptureWithoutStorage);
        } else if (this.mRecordOriginVideo) {
            return Integer.valueOf(oneDriver.startRecordWithCameraStorage(this.mMode));
        } else {
            startCaptureWithoutStorage(this.mCaptureWithoutStorage);
        }
        return Integer.valueOf(-1);
    }

    public void onCameraLiveNotify(int i2, int i3, int i4, String str, String str2) {
        a.c(a.a("onCameraLiveNotify notifyType ", i2, " value ", i3, " extra "), i4, TAG);
        if (i2 == -100) {
            onRecordError(i3);
        } else if (i2 == 100) {
            notifyFps(i3);
        } else if (i2 == 200) {
            notifyLivePushStart();
        }
    }

    public void onCameraLiveStop() {
        ICameraLiveStateListener iCameraLiveStateListener = this.mCameraLiveStateListener;
        if (iCameraLiveStateListener != null) {
            iCameraLiveStateListener.onRecordComplete(this.mRecordingType, this.mRecordPath);
        }
    }
}
