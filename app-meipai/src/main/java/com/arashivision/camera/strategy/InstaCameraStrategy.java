package com.arashivision.camera.strategy;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.arashivision.camera.InstaCameraConstants.RecordingType;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.camera.listener.ICameraConnectionListener;
import com.arashivision.camera.listener.ICameraInfoListener;
import com.arashivision.camera.listener.ICameraLiveStateListener;
import com.arashivision.camera.listener.ICameraRecordListener;
import com.arashivision.camera.listener.IScreenCaptureListener;
import com.arashivision.camera.listener.ITimelapseListener;
import com.arashivision.camera.listener.OnStillImageListener;
import com.arashivision.camera.scheduler.CommandExeManager;
import com.arashivision.camera.strategy.IContentStaregyListener.IBleConntectListener;
import com.arashivision.camera.strategy.IContentStaregyListener.IUsbConnectListener;
import com.arashivision.camera.strategy.IContentStaregyListener.IWIfiConnectListener;
import com.arashivision.camera.stream.StreamProcess;
import com.arashivision.onecamera.AudioSource;
import com.arashivision.onecamera.InfoUpdateListener;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.OneDriver.OnNotificationListener;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.appusb.AppUsbService;
import com.arashivision.onecamera.cameraresponse.StreamData;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.TakePictureWithoutStorageResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.PlayerBackend;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewScreenCaptureCallback;
import e.a.a.a.a;
import e.e.a.d.k;
import e.e.a.d.l;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class InstaCameraStrategy implements IContentStaregyListener, OnNotificationListener, IWIfiConnectListener, IBleConntectListener, IUsbConnectListener {
    public static final String TAG = "com.arashivision.camera.strategy.InstaCameraStrategy";
    public Object firstSurface;
    public HandlerThread handlerThread;
    public boolean isStreamTraget;
    public AudioSource mAudioSource;
    public k mBleStopWakeupCallback;
    public l mBleWakeUpListener;
    public ArrayList<ICameraConnectionListener> mCameraConnectionListeners;
    public ArrayList<ICameraInfoListener> mCameraInfoListeners;
    public ICameraLiveStateListener mCameraLiveStateListener;
    public ArrayList<ICameraRecordListener> mCameraRecordListeners;
    public CommandExeManager mCommandExeManager;
    public Context mContext;
    public HandlerThread mDriverHandlerThread;
    public float[] mGyroMatrix;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public Handler mInfoHandler;
    public InfoUpdateListener mInfoUpdateListener;
    public Handler mMainHandler;
    public OneDriver mOneDrvier;
    public RecordingType mRecordingType;
    public IScreenCaptureListener mScreenCaptureListener;
    public StartStreamingParam mStartStreamingParam;
    public ArrayList<OnStillImageListener> mStillImageListeners;
    public OneStreamPipeline mStreamPiple;
    public StreamProcess mStreamProcess;
    public Handler mThreadHandler;
    public ArrayList<ITimelapseListener> mTimelapseListeners;
    public AppUsbService mUsbService;
    public Object secoundSurface;

    public void addCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        if (!this.mCameraInfoListeners.contains(iCameraInfoListener)) {
            this.mCameraInfoListeners.add(iCameraInfoListener);
        }
    }

    public void addCameraRecordListener(ICameraRecordListener iCameraRecordListener) {
        if (!this.mCameraRecordListeners.contains(iCameraRecordListener)) {
            this.mCameraRecordListeners.add(iCameraRecordListener);
        }
    }

    public void addConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        if (!this.mCameraConnectionListeners.contains(iCameraConnectionListener)) {
            this.mCameraConnectionListeners.add(iCameraConnectionListener);
        }
    }

    public void addStillImageListener(OnStillImageListener onStillImageListener) {
        if (!this.mStillImageListeners.contains(onStillImageListener)) {
            this.mStillImageListeners.add(onStillImageListener);
        }
    }

    public void addTimelapseListener(ITimelapseListener iTimelapseListener) {
        if (!this.mTimelapseListeners.contains(iTimelapseListener)) {
            this.mTimelapseListeners.add(iTimelapseListener);
        }
    }

    public Object addWorker(InstaCmdExe... instaCmdExeArr) {
        return addWorker(0, instaCmdExeArr);
    }

    public void addWorkerSync(long j2, InstaCmdExe... instaCmdExeArr) {
        this.mCommandExeManager.exeCommandSync(this.mOneDrvier, j2, instaCmdExeArr);
    }

    public Object getSurface() {
        return this.firstSurface;
    }

    public void init(Context context) {
        this.mContext = context;
        HandlerThread handlerThread2 = new HandlerThread("OneDriver");
        this.mDriverHandlerThread = handlerThread2;
        handlerThread2.start();
        OneDriver oneDriver = new OneDriver(context, this.mDriverHandlerThread.getLooper());
        this.mOneDrvier = oneDriver;
        oneDriver.setNotificationListener(this);
        this.mCommandExeManager = new CommandExeManager();
        this.mRecordingType = RecordingType.Camera;
        this.mThreadHandler = new Handler(this.mDriverHandlerThread.getLooper());
        this.mMainHandler = new Handler(Looper.getMainLooper());
        OneStreamPipeline oneStreamPipeline = new OneStreamPipeline(this.mContext, new OneStreamPipleImpl(), this.mDriverHandlerThread.getLooper(), this.mThreadHandler);
        this.mStreamPiple = oneStreamPipeline;
        oneStreamPipeline.setPlayerBackend(PlayerBackend.NativePlayer);
        this.mCameraInfoListeners = new ArrayList<>();
        this.mStillImageListeners = new ArrayList<>();
        this.mCameraRecordListeners = new ArrayList<>();
        this.mCameraConnectionListeners = new ArrayList<>();
        this.mTimelapseListeners = new ArrayList<>();
        this.mUsbService = new AppUsbService(context);
    }

    public void onDriverInfoNotify(final int i2, final int i3, final Object obj) {
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mCameraInfoListeners.iterator();
                while (it.hasNext()) {
                    ((ICameraInfoListener) it.next()).onCameraInfo(i2, i3, obj);
                }
            }
        });
    }

    public void onDriverRecordVideoStateNotify(final int i2, final VideoResult videoResult) {
        String str = TAG;
        StringBuilder a2 = a.a("record finish ");
        a2.append(videoResult.video.uri);
        a2.append(videoResult.video.file_size);
        Log.d(str, a2.toString());
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mCameraRecordListeners.iterator();
                while (it.hasNext()) {
                    ((ICameraRecordListener) it.next()).onDriverRecordVideoStateNotify(i2, videoResult);
                }
            }
        });
    }

    public void onDriverStillImageNotify(final TakePictureResponse takePictureResponse) {
        String str = TAG;
        StringBuilder a2 = a.a("record finish ");
        a2.append(this.mStillImageListeners);
        Log.d(str, a2.toString());
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mStillImageListeners.iterator();
                while (it.hasNext()) {
                    ((OnStillImageListener) it.next()).onDriverStillImageNotify(takePictureResponse);
                }
            }
        });
    }

    public void onDriverStillImageWithoutStorageNotify(final TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mStillImageListeners.iterator();
                while (it.hasNext()) {
                    ((OnStillImageListener) it.next()).onDriverStillImageWithoutStorageNotify(takePictureWithoutStorageResponse);
                }
            }
        });
    }

    public void onDriverStreamDataNotify(StreamData streamData) {
    }

    public void onDriverTimelapseNotify(final int i2, final VideoResult videoResult) {
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mTimelapseListeners.iterator();
                while (it.hasNext()) {
                    ((ITimelapseListener) it.next()).ononTimelapseRecordNotify(i2, videoResult);
                }
            }
        });
    }

    public void onDriverUsbState(int i2, final int i3) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("state = ");
        sb.append(i2);
        sb.append(",err = ");
        sb.append(i3);
        Log.i(str, sb.toString());
        this.mMainHandler.post(new Runnable() {
            public void run() {
                Iterator it = InstaCameraStrategy.this.mCameraConnectionListeners.iterator();
                while (it.hasNext()) {
                    ICameraConnectionListener iCameraConnectionListener = (ICameraConnectionListener) it.next();
                    int i2 = i3;
                    if (i2 == 0) {
                        iCameraConnectionListener.onCameraStateChange();
                    } else {
                        iCameraConnectionListener.onCameraError(i2);
                    }
                }
            }
        });
    }

    public void release() {
        StreamProcess streamProcess = this.mStreamProcess;
        if (streamProcess != null) {
            streamProcess.release();
            this.mStreamProcess = null;
        }
        OneStreamPipeline oneStreamPipeline = this.mStreamPiple;
        if (oneStreamPipeline != null) {
            oneStreamPipeline.release();
            this.mStreamPiple = null;
        }
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
            try {
                this.handlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        HandlerThread handlerThread3 = this.mDriverHandlerThread;
        if (handlerThread3 != null) {
            handlerThread3.quitSafely();
            try {
                this.mDriverHandlerThread.join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void removeCameraInfoListener(ICameraInfoListener iCameraInfoListener) {
        this.mCameraInfoListeners.remove(iCameraInfoListener);
    }

    public void removeCameraRecordListener(ICameraRecordListener iCameraRecordListener) {
        this.mCameraRecordListeners.remove(iCameraRecordListener);
    }

    public void removeConnectionListener(ICameraConnectionListener iCameraConnectionListener) {
        this.mCameraConnectionListeners.remove(iCameraConnectionListener);
    }

    public void removeStillImageListener(OnStillImageListener onStillImageListener) {
        this.mStillImageListeners.remove(onStillImageListener);
    }

    public void removeTimelapseListener(ITimelapseListener iTimelapseListener) {
        this.mTimelapseListeners.remove(iTimelapseListener);
    }

    public void setAudioSource(AudioSource audioSource) {
        this.mAudioSource = audioSource;
    }

    public void setBleStopWakeupListener(k kVar) {
        this.mBleStopWakeupCallback = kVar;
    }

    public void setBleWakeupListener(l lVar) {
        this.mBleWakeUpListener = lVar;
    }

    public void setCameraLiveStateListener(ICameraLiveStateListener iCameraLiveStateListener) {
        this.mCameraLiveStateListener = iCameraLiveStateListener;
    }

    public void setGyroRebaseMatrix(float[] fArr) {
        this.mGyroMatrix = fArr;
    }

    public void setInfoUpdateListener(Handler handler, InfoUpdateListener infoUpdateListener) {
        this.mInfoHandler = handler;
        this.mInfoUpdateListener = infoUpdateListener;
    }

    public void setPipeline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
        String str = TAG;
        StringBuilder a2 = a.a("mStreamProcess = ");
        a2.append(this.mStreamProcess);
        a2.append(",cameraPreviewPipeline = ");
        a2.append(iCameraPreviewPipeline);
        Log.d(str, a2.toString());
        StreamProcess streamProcess = this.mStreamProcess;
        if (streamProcess != null) {
            streamProcess.updatePiple(iCameraPreviewPipeline);
        }
    }

    public void setPlayerBackend(PlayerBackend playerBackend) {
        OneStreamPipeline oneStreamPipeline = this.mStreamPiple;
        if (oneStreamPipeline != null) {
            oneStreamPipeline.setPlayerBackend(playerBackend);
        }
    }

    public void setPreviewDelta(long j2) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onUpdatePreviewDelta(j2);
        } else {
            this.mStreamPiple.setPreviewDeltaNs(j2);
        }
    }

    public void setRecordType(RecordingType recordingType) {
        this.mRecordingType = recordingType;
    }

    public void setScreenScptureListener(IScreenCaptureListener iScreenCaptureListener) {
        this.mScreenCaptureListener = iScreenCaptureListener;
    }

    public void setStreamEncode(boolean z) {
        if (this.mStreamPiple != null) {
            StreamProcess streamProcess = this.mStreamProcess;
            if (streamProcess != null) {
                streamProcess.release();
                this.mStreamProcess = null;
            }
            String str = TAG;
            StringBuilder a2 = a.a(" mDualStreaming ");
            a2.append(this.mStartStreamingParam.isDualStream());
            a2.append(" isH265 ");
            a2.append(z);
            Log.i(str, a2.toString());
            if (z) {
                this.mStreamPiple.setInputFormat("h265");
            } else {
                this.mStreamPiple.setInputFormat("h264");
            }
            StreamProcess streamProcess2 = new StreamProcess(this.mOneDrvier, this.mThreadHandler, this.mStreamPiple, this.mStartStreamingParam, z, this.mContext);
            this.mStreamProcess = streamProcess2;
            ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
            if (iCameraPreviewPipeline != null) {
                streamProcess2.updatePiple(iCameraPreviewPipeline);
            }
        }
    }

    public void setSurface(Object obj, Object obj2, boolean z) {
        this.isStreamTraget = z;
        this.firstSurface = obj;
        this.secoundSurface = obj2;
        if (obj != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(" mSurface is ");
            sb.append(obj);
            Log.i(str, sb.toString());
            this.mICameraPreviewPipeline = null;
        }
        this.mStreamPiple.setSurface(obj);
    }

    public void startScreenCapture(int i2, int i3, String str) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onScreenCapture(i2, i3, str, new ICameraPreviewScreenCaptureCallback() {
                public void onCameraPreviewScreenCaptureNotify(int i2, String str) {
                    IScreenCaptureListener iScreenCaptureListener = InstaCameraStrategy.this.mScreenCaptureListener;
                    if (iScreenCaptureListener != null) {
                        iScreenCaptureListener.onScreenCapture(i2, str);
                    }
                }
            });
        }
    }

    public void updateOffset(String str) {
        OneStreamPipeline oneStreamPipeline = this.mStreamPiple;
        if (oneStreamPipeline != null) {
            oneStreamPipeline.updatePanoOffset(str);
        }
    }

    public Object addWorker(long j2, InstaCmdExe... instaCmdExeArr) {
        return this.mCommandExeManager.exeCommand(this.mOneDrvier, j2, instaCmdExeArr);
    }
}
