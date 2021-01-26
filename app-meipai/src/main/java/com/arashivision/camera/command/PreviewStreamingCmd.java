package com.arashivision.camera.command;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.arashivision.onecamera.AudioSource;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onestream.Gyro.GyroType;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;

public class PreviewStreamingCmd implements InstaCmdExe {
    public static final String TAG = "com.arashivision.camera.command.PreviewStreamingCmd";
    public AudioSource mAudioSource;
    public Context mContext;
    public float[] mGyroRebaseMatrix;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public Handler mMainHandler;
    public String mOffest;
    public OneStreamPipeline mOneStreamPipeline;
    public StartStreamingParam mStreamingParam;
    public Object mSurface;
    public boolean mWithoutYawRotation;

    public PreviewStreamingCmd(Context context, Handler handler, StartStreamingParam startStreamingParam, OneStreamPipeline oneStreamPipeline, ICameraPreviewPipeline iCameraPreviewPipeline, float[] fArr, AudioSource audioSource, Object obj, String str) {
        this.mOneStreamPipeline = oneStreamPipeline;
        this.mContext = context;
        this.mMainHandler = handler;
        this.mGyroRebaseMatrix = fArr;
        this.mStreamingParam = startStreamingParam;
        this.mOffest = str;
        this.mAudioSource = audioSource;
        this.mSurface = obj;
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
    }

    private long setImagePipleStream(StartStreamingParam startStreamingParam, OneDriver oneDriver) {
        VideoParam videoParam;
        int previewNum = startStreamingParam.getPreviewNum();
        if (previewNum == 0) {
            videoParam = startStreamingParam.getFirstVideoParam();
        } else if (previewNum == 1) {
            videoParam = startStreamingParam.getSecVideoParam();
        } else {
            StringBuilder a2 = a.a("error param.getPreviewNum() ");
            a2.append(startStreamingParam.getPreviewNum());
            throw new IllegalArgumentException(a2.toString());
        }
        AudioParam audioParam = startStreamingParam.getAudioParam();
        if (audioParam != null) {
            AudioSource audioSource = this.mAudioSource;
            if (audioSource != null) {
                if (AudioSource.AUDIO_CAMERA == audioSource) {
                    audioParam.enable = true;
                } else {
                    audioParam.enable = false;
                }
            }
            String str = TAG;
            StringBuilder a3 = a.a("context = ");
            a3.append(this.mContext);
            Log.d(str, a3.toString());
            GyroType gyroType = startStreamingParam.getGyroType();
            oneDriver.setVideoParam(videoParam);
            oneDriver.setAudioParam(audioParam);
            long startStreaming = oneDriver.startStreaming(startStreamingParam.getFirstVideoParam(), startStreamingParam.getSecVideoParam(), startStreamingParam.getAudioParam(), startStreamingParam.getPreviewNum());
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("retv = ");
            sb.append(startStreaming);
            Log.d(str2, sb.toString());
            this.mOneStreamPipeline.setInputWideoResolution(videoParam.width, videoParam.height);
            this.mOneStreamPipeline.setInputFps((double) videoParam.fps);
            if (videoParam.enableGyro) {
                this.mOneStreamPipeline.setGyroType(gyroType, this.mGyroRebaseMatrix, this.mWithoutYawRotation);
            }
            String str3 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" start streaming gyroType ");
            sb2.append(gyroType);
            sb2.append(" dual ");
            sb2.append(startStreamingParam.isDualStream());
            sb2.append(" first ");
            sb2.append(startStreamingParam.getFirstVideoParam().toString());
            sb2.append(" sec ");
            sb2.append(startStreamingParam.getSecVideoParam().toString());
            sb2.append(" previewNum ");
            sb2.append(startStreamingParam.getPreviewNum());
            sb2.append(" zdirectional ");
            sb2.append(startStreamingParam.isDiretionalZ());
            sb2.append(" mWriteH264 ");
            sb2.append(startStreamingParam.isRecordOriginH264());
            Log.i(str3, sb2.toString());
            String str4 = TAG;
            StringBuilder a4 = a.a("width = ");
            a4.append(videoParam.width);
            a4.append(",height = ");
            a4.append(videoParam.height);
            a4.append(",fps = ");
            a4.append(videoParam.fps);
            a4.append(",mSurface = ");
            a4.append(this.mSurface);
            a4.append(",enable gyro = ");
            a4.append(videoParam.enableGyro);
            Log.d(str4, a4.toString());
            this.mOneStreamPipeline.open(this.mOffest);
            Object obj = this.mSurface;
            if (obj != null) {
                this.mOneStreamPipeline.setSurface(obj);
            }
            return startStreaming;
        }
        throw new IllegalArgumentException("error param.getAudioParam(),must set AudioParam");
    }

    public Object exeCmd(OneDriver oneDriver) {
        return Long.valueOf(setImagePipleStream(this.mStreamingParam, oneDriver));
    }
}
