package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.arashivision.algorithm.AlgorithmHeroTrack;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.camerapreview.CameraHistogram;
import com.arashivision.arvbmg.camerapreview.CameraLive;
import com.arashivision.arvbmg.camerapreview.CameraLive.CameraLiveCallback;
import com.arashivision.arvbmg.camerapreview.CameraLiveOptions;
import com.arashivision.arvbmg.camerapreview.CameraLiveRender;
import com.arashivision.arvbmg.camerapreview.CameraPreviewFrameRender;
import com.arashivision.arvbmg.camerapreview.CameraPreviewTrack;
import com.arashivision.arvbmg.camerapreview.CameraRenderSurface;
import com.arashivision.arvbmg.previewer.BMGMediaSession.FrameOutput;
import com.arashivision.arvbmg.previewer.BMGMediaSession.SessionCallback;
import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.arvbmg.previewer.BMGSessionRender.MultiviewUpdateInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.MultiViewInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.rendermodel.BMGCompositeRenderModel;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.arvbmg.util.TimeCost;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.Stabilization.GyroRawItem;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;
import com.arashivision.graphicpath.render.source.SequenceSource;
import com.arashivision.graphicpath.render.source.SequenceSource.Listener;
import com.arashivision.graphicpath.render.util.SequenceStabilizer;
import com.arashivision.graphicpath.render.util.Stabilizer;
import com.arashivision.onestream.ImageData;
import com.arashivision.onestream.OneStreamPipeline.RecordParam;
import com.arashivision.onestream.pipeline.ICameraLivePipline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewScreenCaptureCallback;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import e.a.a.a.a;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public final class BMGCameraPreviewerSessionRender extends BMGSessionRender {
    public static final int RENDER_ENCODE_FORMAT_YUV420P = 0;
    public AlgorithmHeroTrack mAlgorithmHeroTrack;
    public CameraHistogram mCameraHistogram;
    public CameraHistogramParam mCameraHistogramParam;
    public boolean mCameraHistogramUpdate;
    public CameraLive mCameraLive;
    public Handler mCameraLiveHandler;
    public HandlerThread mCameraLiveHandlerThread;
    public ICameraLivePipline mCameraLivePipline;
    public CameraLiveRender mCameraLiveRender;
    public CameraPipelineCallback mCameraPipelineCallback;
    public Handler mCameraPreviewHandler;
    public HandlerThread mCameraPreviewHandlerThread;
    public CameraPreviewRenderCallback mCameraPreviewRenderCallback;
    public CameraPreviewTrack mCameraPreviewTrack;
    public Handler mCameraPreviewTrackHandler;
    public HandlerThread mCameraPreviewTrackHandlerThread;
    public CameraRenderSurface mCameraRenderSurface;
    public CameraRenderSurfaceInfo mCameraRenderSurfaceInfo;
    public ClipRenderInfo mClipRenderInfo;
    public long mFirstLiveTimestampMs;
    public int mGyroCount;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public LinkedList<ImageData[]> mImageDataList;
    public long mLastFramePtsMs;
    public GyroRawItem[] mLastGyroSaveRawItems;
    public long mLastGyroTimeMs;
    public double mLastLiveVideoTimestampMs;
    public long mLastTrackFramePtsMs;
    public double mLivePtsInterval;
    public boolean mMultiviewState;
    public MultiviewTrackFunction mMultiviewTrackFunction;
    public MultiviewTrackInfo mMultiviewTrackInfo;
    public RealTimeStabilizer mRealTimeStabilizer;
    public RecordParam mRecordParam;
    public long mRenderCount;
    public long mRenderStartTimeNs;
    public long mSetGyroTimeNs;
    public long mSlideTimeMs;
    public long mTrackRenderFrameCount;
    public BMGCameraSession mediaSession;

    public static final class CameraHistogramParam {
        public int renderHeight = 360;
        public int renderModeType = 11;
        public int renderWidth = 720;
    }

    public interface CameraPipelineCallback {
        void onCameraMultiviewTrackError(int i2, int i3, double d2);

        void onCameraMultiviewTrackInfo(float[] fArr, double d2);

        void onCameraRotation(int i2);

        void onCreateCameraPipeline(ICameraPreviewPipeline iCameraPreviewPipeline);

        void onReleaseCameraPipeline(ICameraPreviewPipeline iCameraPreviewPipeline);

        void onUpdateHistogram(int[] iArr);
    }

    public interface CameraPreviewRenderCallback {
        ClipRenderInfo onGetCameraHistorgramClipRenderInfo();

        ClipRenderInfo onGetCameraLiveClipRenerInfo();

        MultiViewRectInfo onGetCameraLiveMultivewRectInfo();

        boolean onGetCameraLiveMultiviewFrameRender();

        ClipRenderInfo onGetCameraMultviewTrackClipRenderInfo();
    }

    public static final class CameraRenderSurfaceInfo {
        public Surface mSurface;
        public int renderHeight = 720;
        public int renderModeType = 2;
        public int renderWidth = 1280;
    }

    public static final class GyroSlideInfo {
        public double fps = 0.0d;
        public int frameCount = -1;
        public int frameDurationInMS = -1;
    }

    public static final class MultiviewTrackErrorType {
        public static final int TRACK_ERROR = -9002;
        public static final int TRACK_INIT_ERROR = -9001;
    }

    public interface MultiviewTrackFunction {
        void onDeinit();

        void onInit();

        void onPutSourceSample(VideoSampleGroup videoSampleGroup);
    }

    public static final class MultiviewTrackInfo {
        public String mClxTxtPath;
        public String mModelPath;
        public MultiviewTrackCallback mMultiviewTrackCallback = new MultiviewTrackCallback() {
            public boolean onMultiviewTrackEnable() {
                return true;
            }
        };
        public boolean mSyncTrack;
        public int mTrackFpsInterval;
        public int mTrackHeight = CameraInterface.DEFAULT_PREVIEW_WIDTH;
        public int mTrackWidth = 1280;
        public boolean ownRenderCycle = true;

        public interface MultiviewTrackCallback {
            boolean onMultiviewTrackEnable();
        }

        public void printInfo() {
            StringBuilder a2 = a.a("MultiviewTrackInfo w ");
            a2.append(this.mTrackWidth);
            a2.append(" h ");
            a2.append(this.mTrackHeight);
            a2.append(" mTrackFpsInterval ");
            a2.append(this.mTrackFpsInterval);
            a2.append(" mSyncTrack ");
            a2.append(this.mSyncTrack);
            a2.append(" ownRenderCycle ");
            a2.append(this.ownRenderCycle);
            Log.i(BMGConstants.TAG, a2.toString());
        }
    }

    public static final class OnlineStabilizerInfo {
        public int mFilterInstanceType;
        public int mFilterType;
        public GyroSlideInfo mGyroSlideInfo;
        public long mPreviewDeltaNs;

        public void printInfo() {
            StringBuilder a2 = a.a(" mPreviewDeltaNs ");
            a2.append(this.mPreviewDeltaNs);
            a2.append(" mFilterType ");
            a2.append(this.mFilterType);
            a2.append(" mFilterInstanceType ");
            a.c(a2, this.mFilterInstanceType, BMGConstants.TAG);
        }
    }

    public BMGCameraPreviewerSessionRender(Context context, Options options, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler, ClipRenderInfo clipRenderInfo, CameraPipelineCallback cameraPipelineCallback, OnlineStabilizerInfo onlineStabilizerInfo, MultiviewTrackInfo multiviewTrackInfo, CameraPreviewRenderCallback cameraPreviewRenderCallback) {
        this("BMGCameraPreviewerSessionRender", context, options, callbacks, previewerRenderCallback, handler, clipRenderInfo, cameraPipelineCallback, onlineStabilizerInfo, multiviewTrackInfo, cameraPreviewRenderCallback);
    }

    /* access modifiers changed from: private */
    public long cameraPreviewTrackRender(VideoSampleGroup videoSampleGroup) {
        if (this.mCameraPreviewTrack == null) {
            Log.e(BMGConstants.TAG, " updateCameraPreviewTrack2 but mCameraPreviewTrack null");
            return 0;
        }
        TimeCost newInstance = TimeCost.newInstance("cameraPreviewTrackRender");
        long nativeRender2 = this.mCameraPreviewTrack.nativeRender2(videoSampleGroup);
        if (isDebug()) {
            newInstance.cost();
        }
        return nativeRender2;
    }

    private void createCameraPreviewStabilizer(OnlineStabilizerInfo onlineStabilizerInfo) {
        if (this.mRealTimeStabilizer == null) {
            Stabilizer stabilizer = this.mClipRenderInfo.getStabilizer();
            String str = BMGConstants.TAG;
            if (stabilizer != null) {
                Log.e(str, "mClipRenderInfo.getStabilizer() not null");
            }
            onlineStabilizerInfo.printInfo();
            RealTimeStabilizer realTimeStabilizer = new RealTimeStabilizer(this.mClipRenderInfo.getStabType(), this.mClipRenderInfo.getGyroType(), this.mClipRenderInfo.getOffset(), onlineStabilizerInfo.mPreviewDeltaNs, onlineStabilizerInfo.mFilterType, onlineStabilizerInfo.mFilterInstanceType);
            this.mRealTimeStabilizer = realTimeStabilizer;
            StringBuilder a2 = a.a("camera stabilizer type ");
            a2.append(this.mClipRenderInfo.getStabilizingType());
            a2.append(" stabType ");
            a2.append(this.mClipRenderInfo.getStabType());
            a2.append(" gyroType ");
            a2.append(this.mClipRenderInfo.getGyroType());
            Log.i(str, a2.toString());
            this.mClipRenderInfo.setStabilizer(this.mRealTimeStabilizer.getSequenceStabilizer());
            if (this.mClipRenderInfo.getStabilizingType() == StabilizingType.NO) {
                Log.e(str, "camera stabilize type no");
            }
            StabilizingType stabilizingType = this.mClipRenderInfo.getStabilizingType();
            this.mStabilizingType = stabilizingType;
            if (stabilizingType == null) {
                Log.e(str, "camera stabilizer type null");
            }
            if (this.mClipRenderInfo.getMultiViewInfo() != null) {
                ClipRenderInfo clipRenderInfo = this.mClipRenderInfo.getMultiViewInfo().mClipRenderInfo;
                if (clipRenderInfo != null) {
                    clipRenderInfo.setStabilizer(this.mRealTimeStabilizer.getSequenceStabilizer());
                } else {
                    Log.e(str, "multiViewInfo.mClipRenderInfo null");
                }
            }
            GyroSlideInfo gyroSlideInfo = onlineStabilizerInfo.mGyroSlideInfo;
            if (gyroSlideInfo != null) {
                String str2 = " duration ";
                if (gyroSlideInfo.frameCount <= 0 || gyroSlideInfo.frameDurationInMS <= 0) {
                    StringBuilder a3 = a.a("error gyroSlideInfo.frameCount ");
                    a3.append(gyroSlideInfo.frameCount);
                    a3.append(str2);
                    a.b(a3, gyroSlideInfo.frameDurationInMS, str);
                    return;
                }
                StringBuilder a4 = a.a("gyroSlideInfo.frameCount ");
                a4.append(gyroSlideInfo.frameCount);
                a4.append(str2);
                a.c(a4, gyroSlideInfo.frameDurationInMS, str);
                this.mSlideTimeMs = (long) (gyroSlideInfo.frameCount * gyroSlideInfo.frameDurationInMS);
                this.mRealTimeStabilizer.getSequenceStabilizer().setDurationForSlidingWindowFilter(gyroSlideInfo.frameCount, gyroSlideInfo.fps);
                return;
            }
            Log.w(str, " no slide info");
            return;
        }
        throw new IllegalStateException("createCameraPreviewStabilizer but mRealTimeStabilizer not null");
    }

    /* access modifiers changed from: private */
    public void deInitCameraPreviewTrack() {
        if (this.render != null) {
            Log.i(BMGConstants.TAG, " deInitCameraPreviewTrack");
            CameraPreviewTrack cameraPreviewTrack = this.mCameraPreviewTrack;
            if (cameraPreviewTrack != null) {
                cameraPreviewTrack.nativeDeinit();
                this.mCameraPreviewTrack.free();
                this.mCameraPreviewTrack = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("deInitCameraPreviewTrack but render null");
    }

    /* access modifiers changed from: private */
    public void deinitCameraHistogram() {
        if (this.render != null) {
            Log.i(BMGConstants.TAG, " deinitCameraHistogram");
            CameraHistogram cameraHistogram = this.mCameraHistogram;
            if (cameraHistogram != null) {
                cameraHistogram.nativeDeinit();
                this.mCameraHistogram.free();
                this.mCameraHistogram = null;
            }
            this.mCameraHistogramParam = null;
            return;
        }
        throw new IllegalStateException("deinitCameraHistogram but render null");
    }

    /* access modifiers changed from: private */
    public void deinitCameraRenderSurface() {
        if (this.render != null) {
            Log.i(BMGConstants.TAG, " deinitCameraRenderSurface");
            CameraRenderSurface cameraRenderSurface = this.mCameraRenderSurface;
            if (cameraRenderSurface != null) {
                cameraRenderSurface.nativeDeinit();
                this.mCameraRenderSurface.free();
                this.mCameraRenderSurface = null;
            }
            this.mCameraRenderSurfaceInfo = null;
            return;
        }
        throw new IllegalStateException("deinitCameraRenderSurface but render null");
    }

    /* access modifiers changed from: private */
    public void deinitHeroTrack() {
        AlgorithmHeroTrack algorithmHeroTrack = this.mAlgorithmHeroTrack;
        if (algorithmHeroTrack != null) {
            algorithmHeroTrack.release();
            this.mAlgorithmHeroTrack = null;
        }
    }

    private void emptyMultiviewFunction() {
        this.mMultiviewTrackFunction = new MultiviewTrackFunction() {
            public void onDeinit() {
            }

            public void onInit() {
            }

            public void onPutSourceSample(VideoSampleGroup videoSampleGroup) {
                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
            }
        };
    }

    /* access modifiers changed from: private */
    public void handleCameraVideoStream(ImageData[] imageDataArr) {
        int i2 = (this.mSlideTimeMs > 0 ? 1 : (this.mSlideTimeMs == 0 ? 0 : -1));
        String str = BMGConstants.TAG;
        if (i2 > 0) {
            StabilizingType stabilizingType = this.mStabilizingType;
            if (stabilizingType == null) {
                Log.e(str, " mStabilizingType null");
            } else if (stabilizingType != StabilizingType.NO) {
                this.mImageDataList.add(imageDataArr);
                return;
            }
        }
        if (this.mImageDataList.size() > 0) {
            Log.e(str, "gyro switch to null,otherwise fatal error mImageDataList not empty when stab no or no gyro slide");
            while (this.mImageDataList.size() > 0) {
                putVideo((ImageData[]) this.mImageDataList.pop());
            }
        }
        putVideo(imageDataArr);
    }

    /* access modifiers changed from: private */
    public void handleSlideVideo() {
        while (this.mImageDataList.size() > 0) {
            long j2 = ((ImageData[]) this.mImageDataList.getFirst())[0].timestampNs / 1000000;
            long j3 = this.mLastGyroTimeMs - j2;
            boolean isDebug = isDebug();
            String str = BMGConstants.TAG;
            if (isDebug) {
                StringBuilder a2 = a.a(" videoMs ", j2, " mLastGyroTimeMs ");
                a2.append(this.mLastGyroTimeMs);
                a2.append(" interval ");
                a2.append(j3);
                a2.append(" mSlideTimeMs ");
                a2.append(this.mSlideTimeMs);
                Log.i(str, a2.toString());
            }
            if (j3 > this.mSlideTimeMs) {
                if (isDebug()) {
                    StringBuilder a3 = a.a(" slide cache mImageDataList size ");
                    a3.append(this.mImageDataList.size());
                    Log.i(str, a3.toString());
                }
                putVideo((ImageData[]) this.mImageDataList.pop());
            } else {
                return;
            }
        }
    }

    private void initAlgoHeroTrack() {
        MultiViewInfo multiViewInfo = this.mClipRenderInfo.getMultiViewInfo();
        String str = BMGConstants.TAG;
        if (multiViewInfo != null) {
            this.mMultiviewState = true;
            if (this.mMultiviewTrackInfo != null) {
                AlgorithmHeroTrack algorithmHeroTrack = new AlgorithmHeroTrack();
                this.mAlgorithmHeroTrack = algorithmHeroTrack;
                MultiviewTrackInfo multiviewTrackInfo = this.mMultiviewTrackInfo;
                int init = algorithmHeroTrack.init(multiviewTrackInfo.mModelPath, multiviewTrackInfo.mClxTxtPath, multiviewTrackInfo.mTrackWidth, multiviewTrackInfo.mTrackHeight);
                if (init != 0) {
                    a.c("mAlgorithmHeroTrack.init error ret ", init, str);
                    this.mCameraPipelineCallback.onCameraMultiviewTrackError(MultiviewTrackErrorType.TRACK_INIT_ERROR, init, 0.0d);
                } else if (isDebug()) {
                    this.mAlgorithmHeroTrack.enableDebug();
                }
                MultiviewTrackInfo multiviewTrackInfo2 = this.mMultiviewTrackInfo;
                if (multiviewTrackInfo2.ownRenderCycle) {
                    this.mMultiviewTrackFunction = new MultiviewTrackFunction() {
                        public void onDeinit() {
                            final CountDownLatch countDownLatch = new CountDownLatch(1);
                            BMGCameraPreviewerSessionRender.this.runOnCameraPreviewTrackHandler(new Runnable() {
                                public void run() {
                                    BMGCameraPreviewerSessionRender.this.deInitCameraPreviewTrack();
                                    BMGCameraPreviewerSessionRender.this.deinitHeroTrack();
                                    countDownLatch.countDown();
                                }
                            });
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }

                        public void onInit() {
                            BMGCameraPreviewerSessionRender.this.runOnCameraPreviewTrackHandler(new Runnable() {
                                public void run() {
                                    BMGCameraPreviewerSessionRender.this.initCameraPreviewTrack();
                                }
                            });
                        }

                        public void onPutSourceSample(final VideoSampleGroup videoSampleGroup) {
                            if (!BMGCameraPreviewerSessionRender.this.mMultiviewTrackInfo.mMultiviewTrackCallback.onMultiviewTrackEnable()) {
                                BMGCameraPreviewerSessionRender.this.mTrackRenderFrameCount = 0;
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            } else if (BMGCameraPreviewerSessionRender.this.isTrackFrame()) {
                                BMGCameraPreviewerSessionRender.this.sequenceSource.putSample2(videoSampleGroup);
                                BMGCameraPreviewerSessionRender.this.runOnCameraPreviewTrackHandler(new Runnable() {
                                    public void run() {
                                        long access$1600 = BMGCameraPreviewerSessionRender.this.cameraPreviewTrackRender(videoSampleGroup);
                                        if (access$1600 != 0) {
                                            BMGCameraPreviewerSessionRender.this.trackSample(access$1600);
                                        }
                                    }
                                });
                            } else {
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            }
                        }
                    };
                } else if (multiviewTrackInfo2.mSyncTrack) {
                    this.mMultiviewTrackFunction = new MultiviewTrackFunction() {
                        public void onDeinit() {
                            if (BMGCameraPreviewerSessionRender.this.isRenderTread()) {
                                BMGCameraPreviewerSessionRender.this.deInitCameraPreviewTrack();
                                return;
                            }
                            final CountDownLatch countDownLatch = new CountDownLatch(1);
                            BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                public void doTask() {
                                    BMGCameraPreviewerSessionRender.this.deInitCameraPreviewTrack();
                                    BMGCameraPreviewerSessionRender.this.deinitHeroTrack();
                                    countDownLatch.countDown();
                                }
                            });
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e2) {
                                Log.e(BMGConstants.TAG, "deInitCameraPreviewTrack countDownLatch when syncTrack");
                                e2.printStackTrace();
                            }
                        }

                        public void onInit() {
                            BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                public void doTask() {
                                    BMGCameraPreviewerSessionRender.this.initCameraPreviewTrack();
                                }
                            });
                        }

                        public void onPutSourceSample(final VideoSampleGroup videoSampleGroup) {
                            if (!BMGCameraPreviewerSessionRender.this.mMultiviewTrackInfo.mMultiviewTrackCallback.onMultiviewTrackEnable()) {
                                BMGCameraPreviewerSessionRender.this.mTrackRenderFrameCount = 0;
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            } else if (BMGCameraPreviewerSessionRender.this.isTrackFrame()) {
                                BMGCameraPreviewerSessionRender.this.sequenceSource.putSample2(videoSampleGroup);
                                BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                    public void doTask() {
                                        long access$1600 = BMGCameraPreviewerSessionRender.this.cameraPreviewTrackRender(videoSampleGroup);
                                        if (access$1600 != 0) {
                                            BMGCameraPreviewerSessionRender.this.trackSample(access$1600);
                                        }
                                    }
                                });
                            } else {
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            }
                        }
                    };
                } else {
                    this.mMultiviewTrackFunction = new MultiviewTrackFunction() {
                        public void onDeinit() {
                            String str = BMGConstants.TAG;
                            if (BMGCameraPreviewerSessionRender.this.isRenderTread()) {
                                BMGCameraPreviewerSessionRender.this.deInitCameraPreviewTrack();
                                return;
                            }
                            final CountDownLatch countDownLatch = new CountDownLatch(1);
                            BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                public void doTask() {
                                    BMGCameraPreviewerSessionRender.this.deInitCameraPreviewTrack();
                                    countDownLatch.countDown();
                                }
                            });
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e2) {
                                Log.e(str, "deInitCameraPreviewTrack countDownLatch error");
                                e2.printStackTrace();
                            }
                            BMGCameraPreviewerSessionRender.this.runOnCameraPreviewTrackHandler(new Runnable() {
                                public void run() {
                                    BMGCameraPreviewerSessionRender.this.deinitHeroTrack();
                                    countDownLatch.countDown();
                                }
                            });
                            try {
                                countDownLatch.await();
                            } catch (InterruptedException e3) {
                                Log.e(str, "deinitHeroTrack countDownLatch error");
                                e3.printStackTrace();
                            }
                        }

                        public void onInit() {
                            BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                public void doTask() {
                                    BMGCameraPreviewerSessionRender.this.initCameraPreviewTrack();
                                }
                            });
                        }

                        public void onPutSourceSample(final VideoSampleGroup videoSampleGroup) {
                            if (!BMGCameraPreviewerSessionRender.this.mMultiviewTrackInfo.mMultiviewTrackCallback.onMultiviewTrackEnable()) {
                                BMGCameraPreviewerSessionRender.this.mTrackRenderFrameCount = 0;
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            } else if (BMGCameraPreviewerSessionRender.this.isTrackFrame()) {
                                BMGCameraPreviewerSessionRender.this.sequenceSource.putSample2(videoSampleGroup);
                                BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                    public void doTask() {
                                        final long access$1600 = BMGCameraPreviewerSessionRender.this.cameraPreviewTrackRender(videoSampleGroup);
                                        if (access$1600 != 0) {
                                            BMGCameraPreviewerSessionRender.this.runOnCameraPreviewTrackHandler(new Runnable() {
                                                public void run() {
                                                    BMGCameraPreviewerSessionRender.this.trackSample(access$1600);
                                                }
                                            });
                                        }
                                    }
                                });
                            } else {
                                BMGCameraPreviewerSessionRender.this.putSuperSourceSample(videoSampleGroup);
                            }
                        }
                    };
                }
            } else {
                Log.e(str, "open multiview but no track info");
                emptyMultiviewFunction();
            }
        } else {
            Log.e(str, "open camera preview render without multiview info");
            emptyMultiviewFunction();
        }
    }

    private void initCameraHistogram() {
        if (this.render == null) {
            throw new IllegalStateException("initCameraHistogram but render null");
        } else if (this.mCameraHistogram == null) {
            CameraHistogramParam cameraHistogramParam = this.mCameraHistogramParam;
            if (cameraHistogramParam != null) {
                int i2 = cameraHistogramParam.renderWidth;
                int i3 = cameraHistogramParam.renderHeight;
                Log.i(BMGConstants.TAG, " initCameraHistogram ");
                TimeCost newInstance = TimeCost.newInstance("initCameraHistogram");
                if (this.mClipRenderInfo != null) {
                    ClipRenderInfo onGetCameraHistorgramClipRenderInfo = this.mCameraPreviewRenderCallback.onGetCameraHistorgramClipRenderInfo();
                    if (onGetCameraHistorgramClipRenderInfo != null) {
                        onGetCameraHistorgramClipRenderInfo.setStabilizer(this.mClipRenderInfo.getStabilizer());
                        RenderModel createRootRenderModel = RenderModelUtil.createRootRenderModel(onGetCameraHistorgramClipRenderInfo, null);
                        CameraHistogram cameraHistogram = new CameraHistogram();
                        this.mCameraHistogram = cameraHistogram;
                        cameraHistogram.nativeInit(this.render, i2, i3, createRootRenderModel, isDebug());
                        if (isDebug()) {
                            newInstance.cost();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("onGetCameraHistorgramClipRenderInfo null");
                }
                throw new IllegalStateException("initCameraHistogram mClipRenderInfo null");
            }
            throw new IllegalStateException("initCameraHistogram mCameraHistogramParam null");
        } else {
            throw new IllegalStateException("initCameraHistogram mCameraHistogramParam not null");
        }
    }

    private void initCameraLiveRender(int i2, int i3, int i4) {
        RenderModel renderModel;
        String str = BMGConstants.TAG;
        Log.i(str, " initCameraLiveRender ");
        TimeCost newInstance = TimeCost.newInstance("initCameraLiveRender");
        if (this.mClipRenderInfo == null) {
            throw new IllegalStateException("initCameraLiveRender mClipRenderInfo null");
        } else if (this.mCameraLiveRender == null) {
            ClipRenderInfo onGetCameraLiveClipRenerInfo = this.mCameraPreviewRenderCallback.onGetCameraLiveClipRenerInfo();
            if (onGetCameraLiveClipRenerInfo != null) {
                onGetCameraLiveClipRenerInfo.setStabilizer(this.mClipRenderInfo.getStabilizer());
                if (onGetCameraLiveClipRenerInfo.getMultiViewInfo() != null) {
                    Log.i(str, "live with in multiview ");
                    renderModel = RenderModelUtil.createMultiViewRenderModel(onGetCameraLiveClipRenerInfo, null);
                } else {
                    Log.i(str, "live without multiview ");
                    renderModel = RenderModelUtil.createRootRenderModel(onGetCameraLiveClipRenerInfo, null);
                }
                RenderModel renderModel2 = renderModel;
                CameraLiveRender cameraLiveRender = new CameraLiveRender();
                this.mCameraLiveRender = cameraLiveRender;
                cameraLiveRender.nativeInit(this.render, i3, i4, 0, renderModel2, isDebug());
                if (isDebug()) {
                    newInstance.cost();
                    return;
                }
                return;
            }
            throw new IllegalStateException("onGetCameraLiveClipRenerInfo null");
        } else {
            throw new IllegalStateException("initCameraLiveRender mCameraLiveRender not null");
        }
    }

    /* access modifiers changed from: private */
    public void initCameraPreviewTrack() {
        if (this.mCameraPreviewTrack == null) {
            ClipRenderInfo clipRenderInfo = this.mClipRenderInfo;
            if (clipRenderInfo == null) {
                throw new IllegalStateException("initCameraPreviewTrack but mClipRenderInfo null");
            } else if (clipRenderInfo.getMultiViewInfo() != null) {
                MultiviewTrackInfo multiviewTrackInfo = this.mMultiviewTrackInfo;
                String str = BMGConstants.TAG;
                if (multiviewTrackInfo == null) {
                    Log.e(str, "multiview preview but without track info");
                } else if (multiviewTrackInfo.mMultiviewTrackCallback != null) {
                    Log.i(str, " initCameraPreviewTrack ");
                    this.mMultiviewTrackInfo.printInfo();
                    TimeCost newInstance = TimeCost.newInstance("initCameraPreviewTrack");
                    ClipRenderInfo onGetCameraMultviewTrackClipRenderInfo = this.mCameraPreviewRenderCallback.onGetCameraMultviewTrackClipRenderInfo();
                    if (onGetCameraMultviewTrackClipRenderInfo != null) {
                        RenderModel createRootRenderModel = RenderModelUtil.createRootRenderModel(onGetCameraMultviewTrackClipRenderInfo, null);
                        CameraPreviewTrack cameraPreviewTrack = new CameraPreviewTrack(this.mMultiviewTrackInfo.ownRenderCycle);
                        this.mCameraPreviewTrack = cameraPreviewTrack;
                        HybridRender hybridRender = this.render;
                        MultiviewTrackInfo multiviewTrackInfo2 = this.mMultiviewTrackInfo;
                        cameraPreviewTrack.nativeInit(hybridRender, multiviewTrackInfo2.mTrackWidth, multiviewTrackInfo2.mTrackHeight, 0, createRootRenderModel, isDebug());
                        if (isDebug()) {
                            newInstance.cost();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("onGetCameraMultviewTrackClipRenderInfo null");
                } else {
                    throw new IllegalArgumentException("mMultiviewTrackInfo.mMultiviewTrackCallback null");
                }
            }
        } else {
            throw new IllegalStateException("initCameraPreviewTrack but mCameraPreviewTrack not null");
        }
    }

    private void initCameraRenderSurface() {
        if (this.render == null) {
            throw new IllegalStateException("initCameraHistogram but render null");
        } else if (this.mCameraRenderSurface == null) {
            CameraRenderSurfaceInfo cameraRenderSurfaceInfo = this.mCameraRenderSurfaceInfo;
            if (cameraRenderSurfaceInfo == null) {
                throw new IllegalStateException("initCameraRenderSurface mCameraRenderSurfaceInfo null");
            } else if (cameraRenderSurfaceInfo.mSurface != null) {
                int i2 = cameraRenderSurfaceInfo.renderWidth;
                int i3 = cameraRenderSurfaceInfo.renderHeight;
                int i4 = cameraRenderSurfaceInfo.renderModeType;
                String str = BMGConstants.TAG;
                Log.i(str, " initCameraRenderSurface ");
                TimeCost newInstance = TimeCost.newInstance("initCameraRenderSurface");
                ClipRenderInfo clipRenderInfo = this.mClipRenderInfo;
                if (clipRenderInfo != null) {
                    ClipRenderInfo clone = clipRenderInfo.clone();
                    clone.setStabilizer(this.mClipRenderInfo.getStabilizer());
                    clone.setModelType(i4);
                    if (!(i4 == 2 || i4 == 4)) {
                        if (i4 == 11) {
                            clone.setBaseCameraController(null);
                            clone.setModelType(11);
                        } else if (i4 != 13) {
                            if (i4 != 20) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("initCameraRenderSurface error renderModel type ");
                                sb.append(i4);
                                sb.append(" use plane stitch as default ");
                                Log.e(str, sb.toString());
                                clone.setBaseCameraController(null);
                                clone.setModelType(11);
                            } else {
                                clone.setBaseCameraController(null);
                                clone.setModelType(20);
                            }
                        }
                    }
                    clone.setFilterInfos(null);
                    RenderModel createRenderModel = createRenderModel(clone, false);
                    CameraRenderSurface cameraRenderSurface = new CameraRenderSurface();
                    this.mCameraRenderSurface = cameraRenderSurface;
                    cameraRenderSurface.nativeInit(this.render, this.mCameraRenderSurfaceInfo.mSurface, i2, i3, createRenderModel, isDebug());
                    if (isDebug()) {
                        newInstance.cost();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("initCameraRenderSurface mClipRenderInfo null");
            } else {
                throw new IllegalStateException("initCameraRenderSurface mCameraRenderSurfaceInfo mSurface null");
            }
        } else {
            throw new IllegalStateException("initCameraRenderSurface mCameraRenderSurface not null");
        }
    }

    /* access modifiers changed from: private */
    public void initStartLive() {
        boolean z;
        if (this.mCameraLive == null) {
            RecordParam recordParam = this.mRecordParam;
            int i2 = recordParam.cameraLiveRenderMode;
            String str = BMGConstants.TAG;
            if (i2 == 0) {
                if (recordParam.width != recordParam.height * 2) {
                    StringBuilder a2 = a.a(" error width ( ");
                    a2.append(this.mRecordParam.width);
                    a2.append(" != 2 * ");
                    a2.append(this.mRecordParam.height);
                    a2.append(") height for plane stitch");
                    Log.i(str, a2.toString());
                }
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            StringBuilder a3 = a.a(" mRecordParam.path ");
            a3.append(this.mRecordParam.path);
            a3.append(" format ");
            a3.append(this.mRecordParam.format);
            a3.append(" mRecordParam.hasAudio ");
            a3.append(this.mRecordParam.hasAudio);
            a3.append(" mRecordParam.cameraLiveRenderMode ");
            a3.append(this.mRecordParam.cameraLiveRenderMode);
            a3.append(" mRecordParam.networkid ");
            a3.append(this.mRecordParam.networkid);
            Log.i(str, a3.toString());
            RecordParam recordParam2 = this.mRecordParam;
            String str2 = str;
            CameraLiveOptions cameraLiveOptions = new CameraLiveOptions(recordParam2.path, recordParam2.width, recordParam2.height, recordParam2.fps, recordParam2.bitrate, recordParam2.format, 0, z2, recordParam2.enableX264Encoder, recordParam2.x264Preset, recordParam2.hasAudio, recordParam2.channels, recordParam2.sampleRate, recordParam2.audioBitrate, recordParam2.networkid);
            CameraLive cameraLive = new CameraLive(new CameraLiveCallback() {
                public void onNotify(CameraLive cameraLive, int i2, int i3, int i4, String str, String str2) {
                    BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = BMGCameraPreviewerSessionRender.this;
                    final CameraLive cameraLive2 = cameraLive;
                    final int i5 = i2;
                    final int i6 = i3;
                    final int i7 = i4;
                    final String str3 = str;
                    final String str4 = str2;
                    AnonymousClass1 r0 = new Runnable() {
                        public void run() {
                            CameraLive access$800 = BMGCameraPreviewerSessionRender.this.mCameraLive;
                            String str = BMGConstants.TAG;
                            if (access$800 != null) {
                                if (cameraLive2 != BMGCameraPreviewerSessionRender.this.mCameraLive) {
                                    Log.e(str, "camera live not same");
                                }
                                if (BMGCameraPreviewerSessionRender.this.mCameraLivePipline != null) {
                                    StringBuilder a2 = a.a("camera live notify notifyType ");
                                    a2.append(i5);
                                    a2.append(" value ");
                                    a.c(a2, i6, str);
                                    BMGCameraPreviewerSessionRender.this.mCameraLivePipline.onCameraLiveNotify(i5, i6, i7, str3, str4);
                                    return;
                                }
                                return;
                            }
                            Log.e(str, "camera live notify but null");
                        }
                    };
                    bMGCameraPreviewerSessionRender.runOnCameraLiveHandler(r0);
                }
            });
            this.mCameraLive = cameraLive;
            cameraLive.nativeSetDebug(isDebug());
            this.mCameraLive.nativeSetOptions(cameraLiveOptions);
            this.mLivePtsInterval = (double) (1000 / this.mRecordParam.fps);
            StringBuilder a4 = a.a("camera live fps ");
            a4.append(this.mRecordParam.fps);
            a4.append(" interval ");
            a4.append(this.mLivePtsInterval);
            Log.i(str2, a4.toString());
            this.mRecordParam = null;
            return;
        }
        throw new IllegalStateException("initStartLive mCameraLive not null");
    }

    /* access modifiers changed from: private */
    public boolean isTrackFrame() {
        long j2 = this.mTrackRenderFrameCount;
        this.mTrackRenderFrameCount = 1 + j2;
        return (j2 % ((long) this.mMultiviewTrackInfo.mTrackFpsInterval) != 0 || this.mCameraPreviewTrack == null || this.mAlgorithmHeroTrack == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void notifyFps(int i2) {
        if (isDebug()) {
            long nanoTime = System.nanoTime();
            long j2 = this.mRenderCount + 1;
            this.mRenderCount = j2;
            if (j2 % ((long) i2) == 0) {
                long j3 = this.mRenderStartTimeNs;
                if (j3 != 0) {
                    double d2 = ((double) (i2 * 1000)) / (((double) (nanoTime - j3)) / 1000000.0d);
                    StringBuilder sb = new StringBuilder();
                    sb.append("camera preview render fps: ");
                    sb.append(d2);
                    Log.i(BMGConstants.TAG, sb.toString());
                }
                this.mRenderStartTimeNs = nanoTime;
            }
        }
    }

    /* access modifiers changed from: private */
    public void putSuperSourceSample(VideoSampleGroup videoSampleGroup) {
        super.putSourceSample(videoSampleGroup);
    }

    private void putVideo(ImageData[] imageDataArr) {
        this.mediaSession.putVideo(imageDataArr);
    }

    /* access modifiers changed from: private */
    public void runOnCameraLiveHandler(Runnable runnable) {
        if (this.mCameraLiveHandler == null) {
            throw new IllegalStateException(" mCameraLiveHandler null ");
        } else if (Looper.myLooper() == this.mCameraLiveHandler.getLooper()) {
            runnable.run();
        } else {
            this.mCameraLiveHandler.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void runOnCameraPreviewHandler(Runnable runnable) {
        if (this.mCameraPreviewHandler == null) {
            throw new IllegalStateException(" mCameraPreviewHandler null ");
        } else if (Looper.myLooper() == this.mCameraPreviewHandler.getLooper()) {
            runnable.run();
        } else {
            this.mCameraPreviewHandler.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void runOnCameraPreviewTrackHandler(Runnable runnable) {
        if (this.mCameraPreviewTrackHandler == null) {
            throw new IllegalStateException(" mCameraPreviewTrackHandler null ");
        } else if (Looper.myLooper() == this.mCameraPreviewTrackHandler.getLooper()) {
            runnable.run();
        } else {
            this.mCameraPreviewTrackHandler.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void startCameraStreamScreenCapture(int i2, int i3, String str, ICameraPreviewScreenCaptureCallback iCameraPreviewScreenCaptureCallback) {
        HybridRender hybridRender = this.render;
        if (hybridRender != null) {
            iCameraPreviewScreenCaptureCallback.onCameraPreviewScreenCaptureNotify(CameraPreviewFrameRender.nativeRender(hybridRender, i2, i3, str, 0, isDebug()), str);
            return;
        }
        throw new IllegalStateException("startCameraStreamScreenCapture but render null");
    }

    /* access modifiers changed from: private */
    public void startLiveRender(RecordParam recordParam) {
        if (this.render != null) {
            initCameraLiveRender(recordParam.cameraLiveRenderMode, recordParam.width, recordParam.height);
            return;
        }
        throw new IllegalStateException("startLiveRender but render null");
    }

    private void stopCameraHistogramSync() {
        if (isRenderTread()) {
            deinitCameraHistogram();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGCameraPreviewerSessionRender.this.deinitCameraHistogram();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void stopCameraLive() {
        Log.i(BMGConstants.TAG, "stopCameraLive");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        runOnCameraLiveHandler(new Runnable() {
            public void run() {
                BMGCameraPreviewerSessionRender.this.stopLiveInternal();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.mCameraLiveHandlerThread.quit();
        try {
            this.mCameraLiveHandlerThread.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.mCameraLiveHandlerThread = null;
        this.mCameraLiveHandler = null;
    }

    private void stopCameraPreview() {
        Log.i(BMGConstants.TAG, "stopCameraPreview");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        runOnCameraPreviewHandler(new Runnable() {
            public void run() {
                BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onReleaseCameraPipeline(BMGCameraPreviewerSessionRender.this.mICameraPreviewPipeline);
                BMGCameraPreviewerSessionRender.this.mediaSession.terminate();
                if (BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer != null) {
                    BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.release();
                    BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer = null;
                }
                BMGCameraPreviewerSessionRender.this.mImageDataList.clear();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.mCameraPreviewHandlerThread.quit();
        try {
            this.mCameraPreviewHandlerThread.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.mCameraPreviewHandlerThread = null;
        this.mCameraPreviewHandler = null;
    }

    private void stopCameraPreviewTrack() {
        Log.i(BMGConstants.TAG, "stopCameraPreviewTrack");
        this.mMultiviewTrackFunction.onDeinit();
        this.mCameraPreviewTrackHandlerThread.quit();
        try {
            this.mCameraPreviewTrackHandlerThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.mCameraPreviewTrackHandlerThread = null;
        this.mCameraPreviewTrackHandler = null;
    }

    /* access modifiers changed from: private */
    public void stopLiveInternal() {
        if (this.mCameraLive != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            addRenderTask(new RenderTask() {
                public void doTask() {
                    BMGCameraPreviewerSessionRender.this.stopLiveRender();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mCameraLive.stop();
            this.mCameraLive.free();
            this.mCameraLive = null;
        }
    }

    /* access modifiers changed from: private */
    public void stopLiveRender() {
        if (this.render != null) {
            CameraLiveRender cameraLiveRender = this.mCameraLiveRender;
            if (cameraLiveRender != null) {
                cameraLiveRender.nativeDeinit();
                this.mCameraLiveRender.free();
                this.mCameraLiveRender = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("stopLive but render null");
    }

    /* access modifiers changed from: private */
    public void trackSample(long j2) {
        VideoSampleGroup videoSampleGroup = new VideoSampleGroup(j2);
        debugSampleTime("cameraPreviewTrack", videoSampleGroup);
        if (this.mAlgorithmHeroTrack != null) {
            TimeCost newInstance = TimeCost.newInstance("camera preview trackSample");
            final float[] fArr = new float[4];
            final double srcTsMs = videoSampleGroup.getMeta().getSrcTsMs();
            long j3 = (long) srcTsMs;
            final int processFrame = this.mAlgorithmHeroTrack.processFrame(videoSampleGroup, fArr);
            String str = BMGConstants.TAG;
            if (processFrame == 0) {
                if (isDebug() && this.mLastTrackFramePtsMs > 0) {
                    StringBuilder a2 = a.a("mTrackRenderFrameCount ");
                    a2.append(this.mTrackRenderFrameCount);
                    a2.append(" mAlgorithmHeroTrack.processFrame ts ");
                    a2.append(j3);
                    a2.append(" mLastFramePtsMs ");
                    a2.append(this.mLastFramePtsMs);
                    a2.append(" delay ");
                    a2.append(this.mLastFramePtsMs - j3);
                    a2.append(" track interval ");
                    a2.append(j3 - this.mLastTrackFramePtsMs);
                    a2.append("ms quat (");
                    a2.append(fArr[0]);
                    String str2 = ",";
                    a2.append(str2);
                    a2.append(fArr[1]);
                    a2.append(str2);
                    a2.append(fArr[2]);
                    a2.append(str2);
                    a2.append(fArr[3]);
                    a2.append(")");
                    Log.i(str, a2.toString());
                }
                runOnCameraPreviewHandler(new Runnable() {
                    public void run() {
                        BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onCameraMultiviewTrackInfo(fArr, srcTsMs);
                    }
                });
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("mAlgorithmHeroTrack.processFrame error ret ");
                sb.append(processFrame);
                Log.e(str, sb.toString());
                runOnCameraPreviewHandler(new Runnable() {
                    public void run() {
                        BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onCameraMultiviewTrackError(MultiviewTrackErrorType.TRACK_ERROR, processFrame, srcTsMs);
                    }
                });
            }
            this.mLastTrackFramePtsMs = j3;
            if (isDebug()) {
                newInstance.cost();
                return;
            }
            return;
        }
        videoSampleGroup.free();
    }

    private void updateCameraPreviewTrack2(VideoSampleGroup videoSampleGroup) {
        if (this.mCameraPreviewTrack == null) {
            Log.e(BMGConstants.TAG, " updateCameraPreviewTrack2 but mCameraPreviewTrack null");
            return;
        }
        TimeCost newInstance = TimeCost.newInstance("updateCameraPreviewTrack");
        long nativeRender2 = this.mCameraPreviewTrack.nativeRender2(videoSampleGroup);
        if (nativeRender2 != 0) {
            trackSample(nativeRender2);
        }
        if (isDebug()) {
            newInstance.cost();
        }
    }

    /* access modifiers changed from: private */
    public void updateCameraRenderSurfaceInternal() {
        if (this.mCameraRenderSurface == null && this.mCameraRenderSurfaceInfo != null) {
            initCameraRenderSurface();
            this.mCameraRenderSurfaceInfo = null;
        }
        CameraRenderSurface cameraRenderSurface = this.mCameraRenderSurface;
        if (cameraRenderSurface != null) {
            cameraRenderSurface.nativeRender(this.render);
        }
    }

    /* access modifiers changed from: private */
    public void updateHistorgramInternal() {
        if (this.mCameraHistogram == null && this.mCameraHistogramParam != null) {
            initCameraHistogram();
        }
        if (this.mCameraHistogramUpdate) {
            this.mCameraHistogramUpdate = false;
            CameraHistogram cameraHistogram = this.mCameraHistogram;
            if (cameraHistogram != null) {
                long nativeRender = cameraHistogram.nativeRender(this.render);
                if (nativeRender != 0) {
                    final VideoSampleGroup videoSampleGroup = new VideoSampleGroup(nativeRender);
                    runOnCameraPreviewHandler(new Runnable() {
                        public void run() {
                            TimeCost newInstance = TimeCost.newInstance("nativeGetBrightness");
                            int[] nativeGetBrightness = CameraHistogram.nativeGetBrightness(videoSampleGroup);
                            if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                                newInstance.cost();
                            }
                            BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onUpdateHistogram(nativeGetBrightness);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public MultiviewUpdateInfo updateMultiviewStateInfo(VideoSampleGroup videoSampleGroup) {
        RenderModel rootRenderModel = getRootRenderModel();
        if (rootRenderModel == null || !(rootRenderModel instanceof BMGCompositeRenderModel)) {
            return null;
        }
        MultiviewUpdateInfo multiviewUpdateInfo = new MultiviewUpdateInfo();
        BMGCompositeRenderModel bMGCompositeRenderModel = (BMGCompositeRenderModel) rootRenderModel;
        boolean onMultiViewFrameRender = onMultiViewFrameRender(videoSampleGroup.getMeta());
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("camera preview onMultiViewFrameRender state ");
            sb.append(onMultiViewFrameRender);
            Log.i(BMGConstants.TAG, sb.toString());
        }
        bMGCompositeRenderModel.updateMultiViewState(onMultiViewFrameRender);
        if (onMultiViewFrameRender) {
            MultiViewRectInfo onUpdateMultiViewInfo = onUpdateMultiViewInfo(videoSampleGroup.getMeta());
            if (onUpdateMultiViewInfo != null) {
                bMGCompositeRenderModel.updateMultiViewInfo(onUpdateMultiViewInfo);
            }
            multiviewUpdateInfo.mMultiViewRectInfo = onUpdateMultiViewInfo;
        } else {
            multiviewUpdateInfo.mMultiViewRectInfo = null;
        }
        multiviewUpdateInfo.mState = onMultiViewFrameRender;
        return multiviewUpdateInfo;
    }

    public void enableDebug() {
        super.enableDebug();
        runOnCameraPreviewHandler(new Runnable() {
            public void run() {
                BMGCameraPreviewerSessionRender.this.mediaSession.enableDebug();
            }
        });
        MultiviewTrackInfo multiviewTrackInfo = this.mMultiviewTrackInfo;
        if (multiviewTrackInfo == null) {
            return;
        }
        if (multiviewTrackInfo.mSyncTrack) {
            addRenderTask(new RenderTask() {
                public void doTask() {
                    if (BMGCameraPreviewerSessionRender.this.mAlgorithmHeroTrack != null) {
                        BMGCameraPreviewerSessionRender.this.mAlgorithmHeroTrack.enableDebug();
                    }
                }
            });
        } else {
            runOnCameraPreviewTrackHandler(new Runnable() {
                public void run() {
                    if (BMGCameraPreviewerSessionRender.this.mAlgorithmHeroTrack != null) {
                        BMGCameraPreviewerSessionRender.this.mAlgorithmHeroTrack.enableDebug();
                    }
                }
            });
        }
    }

    public boolean isSampleFromSubStream(VideoSampleGroup videoSampleGroup) {
        return false;
    }

    public void onClearRenderBefore() {
    }

    public void onClipRenderInfoChangeInternal(ClipRenderInfo clipRenderInfo, boolean z) {
        String str = BMGConstants.TAG;
        Log.e(str, "onClipRenderInfoChangeInternal in camera preview session render");
        if (this.mClipRenderInfo != null) {
            if (!z) {
                Log.e(str, "onClipRenderInfoChangeInternal multiviewDisplay false?");
            }
            Log.e(str, "onClipRenderInfoChangeInternal and set stabilizer for camera preview");
            clipRenderInfo.setStabilizer(this.mRealTimeStabilizer.getSequenceStabilizer());
            if (clipRenderInfo.getMultiViewInfo() != null) {
                if (clipRenderInfo.getMultiViewInfo().mClipRenderInfo != null) {
                    Log.e(str, "onClipRenderInfoChangeInternal and set stabilizer for camera multiview");
                    clipRenderInfo.getMultiViewInfo().mClipRenderInfo.setStabilizer(this.mRealTimeStabilizer.getSequenceStabilizer());
                } else {
                    Log.e(str, "onClipRenderInfoChangeInternal multiViewInfo.mClipRenderInfo null");
                }
            }
            onPreviewerSourceClipStart(clipRenderInfo);
            return;
        }
        Log.e(str, " onClipRenderInfoChangeInternal but mClipRenderInfo null");
    }

    public void onRender() {
        super.onRender();
    }

    public void onRenderPrepare(HybridRender hybridRender) {
        Log.i(BMGConstants.TAG, " camera preview onRenderPrepare ");
        this.mMultiviewTrackFunction.onInit();
    }

    public final void pause() {
    }

    public void putSourceSample(VideoSampleGroup videoSampleGroup) {
        this.mMultiviewTrackFunction.onPutSourceSample(videoSampleGroup);
    }

    public void setFrameOutput(final FrameOutput frameOutput) {
        if (frameOutput == null) {
            this.mediaSession.setFrameOutput(null);
        } else {
            runOnCameraPreviewHandler(new Runnable() {
                public void run() {
                    BMGCameraPreviewerSessionRender.this.mediaSession.setFrameOutput(frameOutput);
                    BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onCreateCameraPipeline(BMGCameraPreviewerSessionRender.this.mICameraPreviewPipeline);
                }
            });
        }
    }

    public void setGyroCountForRotation(final int i2) {
        runOnCameraPreviewHandler(new Runnable() {
            public void run() {
                if (BMGCameraPreviewerSessionRender.this.mGyroCount > 0) {
                    StringBuilder a2 = a.a("update gyro count for rotation when calculating rotation mGyroCount ");
                    a2.append(BMGCameraPreviewerSessionRender.this.mGyroCount);
                    Log.e(BMGConstants.TAG, a2.toString());
                }
                BMGCameraPreviewerSessionRender.this.mSetGyroTimeNs = System.nanoTime();
                BMGCameraPreviewerSessionRender.this.mGyroCount = i2;
            }
        });
    }

    public void setGyroStabilizerFovDistance2(double d2, double d3, double d4, double d5, double d6, double d7) {
        final double d8 = d2;
        final double d9 = d3;
        final double d10 = d4;
        final double d11 = d5;
        final double d12 = d6;
        final double d13 = d7;
        AnonymousClass19 r0 = new Runnable() {
            public void run() {
                BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.getSequenceStabilizer().setGyroFilterRenderFovAdjust2(d8, d9, d10, d11, d12, d13);
            }
        };
        runOnCameraPreviewHandler(r0);
    }

    public void setSessionCallback() {
        runOnCameraPreviewHandler(new Runnable() {
            public void run() {
                BMGCameraPreviewerSessionRender.this.mediaSession.setSessionCallback(new SessionCallback() {
                    public void onComplete(int i2) {
                    }

                    public void onDecodeReport(int i2, int i3) {
                    }

                    public void onFail(final int i2, final String str, final String str2) {
                        BMGCameraPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                            public void run() {
                                BMGCameraPreviewerSessionRender.this.mSessionCallbacks.onFail(i2, str, str2);
                            }
                        });
                    }

                    public void onFpsNotify(double d2) {
                    }

                    public void onPrepared() {
                    }

                    public void onReBuffer(int i2, int i3) {
                    }

                    public void onSeek(int i2, int i3, String str, String str2) {
                    }

                    public void onSubStreamDecodeReport(int i2, int i3) {
                    }

                    public void onSubStreamFail(int i2, String str, String str2) {
                    }

                    public void onSubStreamPrepared() {
                    }

                    public void onSubStreamReBuffer(int i2, int i3) {
                    }

                    public void onSubStreamSeek(int i2, int i3, String str, String str2) {
                    }
                });
            }
        });
    }

    public void setStabilizerQueueBufferSize(int i2) {
        this.mRealTimeStabilizer.getSequenceStabilizer().setQueueBufferSize(i2);
    }

    public final void setupRender() {
        super.setupRender();
        updateMediaSessionState();
    }

    public final void start() {
    }

    public void startCameraHistogram(final CameraHistogramParam cameraHistogramParam) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGCameraPreviewerSessionRender.this.mCameraHistogramParam = cameraHistogramParam;
            }
        });
    }

    public void startCameraRenderSurface(final CameraRenderSurfaceInfo cameraRenderSurfaceInfo) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                if (BMGCameraPreviewerSessionRender.this.mCameraRenderSurfaceInfo != null) {
                    Log.e(BMGConstants.TAG, "old mCameraRenderSurfaceInfo not null");
                }
                BMGCameraPreviewerSessionRender.this.mCameraRenderSurfaceInfo = cameraRenderSurfaceInfo;
            }
        });
    }

    public void stopCameraHistogram() {
        stopCameraHistogramSync();
    }

    public void stopCameraRenderSurface() {
        Log.i(BMGConstants.TAG, "stopCameraRenderSurface");
        if (isRenderTread()) {
            deinitCameraRenderSurface();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGCameraPreviewerSessionRender.this.deinitCameraRenderSurface();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void terminateSession() {
        Log.i(BMGConstants.TAG, "camera session render terminateSession");
        stopCameraHistogramSync();
        stopCameraRenderSurface();
        stopCameraPreviewTrack();
        stopCameraPreview();
        stopCameraLive();
    }

    public void updateHistorgram() {
        addRenderTask(new RenderTask() {
            public void doTask() {
                if (BMGCameraPreviewerSessionRender.this.mCameraHistogramParam == null) {
                    Log.e(BMGConstants.TAG, " please start historgram firstly");
                }
                BMGCameraPreviewerSessionRender.this.mCameraHistogramUpdate = true;
            }
        });
    }

    public final void updateMediaSessionState() {
    }

    public BMGCameraPreviewerSessionRender(String str, Context context, Options options, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler, ClipRenderInfo clipRenderInfo, CameraPipelineCallback cameraPipelineCallback, OnlineStabilizerInfo onlineStabilizerInfo, MultiviewTrackInfo multiviewTrackInfo, CameraPreviewRenderCallback cameraPreviewRenderCallback) {
        CameraPreviewRenderCallback cameraPreviewRenderCallback2 = cameraPreviewRenderCallback;
        super(str, context, callbacks, previewerRenderCallback, handler);
        this.mFirstLiveTimestampMs = -1;
        this.mLastLiveVideoTimestampMs = -1.0d;
        this.mLivePtsInterval = -1.0d;
        this.mGyroCount = -1;
        this.mSetGyroTimeNs = -1;
        this.mSlideTimeMs = -1;
        this.mLastFramePtsMs = -1;
        this.mLastTrackFramePtsMs = -1;
        this.mTrackRenderFrameCount = 0;
        this.mImageDataList = new LinkedList<>();
        this.mCameraPreviewRenderCallback = cameraPreviewRenderCallback2;
        if (cameraPreviewRenderCallback2 == null) {
            Log.e(BMGConstants.TAG, " mCameraPreviewRenderCallback null");
        }
        this.mClipRenderInfo = clipRenderInfo;
        this.mMultiviewTrackInfo = multiviewTrackInfo;
        createCameraPreviewStabilizer(onlineStabilizerInfo);
        initAlgoHeroTrack();
        this.mCameraPipelineCallback = cameraPipelineCallback;
        HandlerThread handlerThread = new HandlerThread("CameraPreview");
        this.mCameraPreviewHandlerThread = handlerThread;
        handlerThread.start();
        this.mCameraPreviewHandler = new Handler(this.mCameraPreviewHandlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("CameraLive");
        this.mCameraLiveHandlerThread = handlerThread2;
        handlerThread2.start();
        this.mCameraLiveHandler = new Handler(this.mCameraLiveHandlerThread.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("CameraPreviewTrack");
        this.mCameraPreviewTrackHandlerThread = handlerThread3;
        handlerThread3.start();
        this.mCameraPreviewTrackHandler = new Handler(this.mCameraPreviewTrackHandlerThread.getLooper());
        setSequenceSourceListener(new Listener() {
            public void onSequenceSourceUpdate(SequenceSource sequenceSource, VideoSampleGroup videoSampleGroup, VideoSampleGroup videoSampleGroup2) {
                if (videoSampleGroup2 != null) {
                    BMGCameraPreviewerSessionRender.this.debugSampleTime("camera preview render sourceUpdate", videoSampleGroup2);
                }
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = BMGCameraPreviewerSessionRender.this;
                if (bMGCameraPreviewerSessionRender.render != null) {
                    RenderModel rootRenderModel = bMGCameraPreviewerSessionRender.getRootRenderModel();
                    String str = BMGConstants.TAG;
                    if (rootRenderModel == null) {
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            Log.i(str, "onSequenceSourceUpdate onPreviewerSourceClipStart");
                        }
                        StringBuilder a2 = a.a("preview render model type ");
                        a2.append(BMGCameraPreviewerSessionRender.this.mClipRenderInfo.getModelType());
                        Log.i(str, a2.toString());
                        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender2 = BMGCameraPreviewerSessionRender.this;
                        bMGCameraPreviewerSessionRender2.onPreviewerSourceClipStart(bMGCameraPreviewerSessionRender2.mClipRenderInfo);
                    }
                    BMGCameraPreviewerSessionRender.this.updateHistorgramInternal();
                    BMGCameraPreviewerSessionRender.this.updateCameraRenderSurfaceInternal();
                    BMGCameraPreviewerSessionRender.this.updateMultiviewStateInfo(videoSampleGroup2);
                    if (BMGCameraPreviewerSessionRender.this.mCameraLiveRender != null) {
                        TimeCost newInstance = TimeCost.newInstance("camera live native render");
                        boolean onGetCameraLiveMultiviewFrameRender = BMGCameraPreviewerSessionRender.this.mCameraPreviewRenderCallback.onGetCameraLiveMultiviewFrameRender();
                        MultiViewRectInfo multiViewRectInfo = null;
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("camera live multiview state ");
                            sb.append(onGetCameraLiveMultiviewFrameRender);
                            Log.i(str, sb.toString());
                        }
                        if (onGetCameraLiveMultiviewFrameRender) {
                            multiViewRectInfo = BMGCameraPreviewerSessionRender.this.mCameraPreviewRenderCallback.onGetCameraLiveMultivewRectInfo();
                        }
                        final long nativeRender2 = BMGCameraPreviewerSessionRender.this.mCameraLiveRender.nativeRender2(BMGCameraPreviewerSessionRender.this.render, onGetCameraLiveMultiviewFrameRender, multiViewRectInfo);
                        if (nativeRender2 != 0) {
                            BMGCameraPreviewerSessionRender.this.runOnCameraLiveHandler(new Runnable() {
                                public void run() {
                                    VideoSampleGroup videoSampleGroup = new VideoSampleGroup(nativeRender2);
                                    BMGCameraPreviewerSessionRender.this.debugSampleTime("cameraLiveSample", videoSampleGroup);
                                    if (BMGCameraPreviewerSessionRender.this.mCameraLive != null) {
                                        double srcTsMs = videoSampleGroup.getMeta().getSrcTsMs();
                                        int i2 = (BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs > -1 ? 1 : (BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs == -1 ? 0 : -1));
                                        String str = BMGConstants.TAG;
                                        if (i2 == 0 || srcTsMs <= ((double) BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs)) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(" skip bad live render video timestamp ");
                                            sb.append(srcTsMs);
                                            sb.append(" mFirstLiveTimestampMs ");
                                            sb.append(BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs);
                                            Log.e(str, sb.toString());
                                            videoSampleGroup.free();
                                        } else if (BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs == -1.0d) {
                                            BMGCameraPreviewerSessionRender.this.mCameraLive.putSample(videoSampleGroup);
                                            BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs = srcTsMs;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("first live video pts ");
                                            sb2.append(BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs);
                                            Log.e(str, sb2.toString());
                                        } else if (srcTsMs - BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs >= BMGCameraPreviewerSessionRender.this.mLivePtsInterval) {
                                            BMGCameraPreviewerSessionRender.this.mCameraLive.putSample(videoSampleGroup);
                                            BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs = srcTsMs;
                                        } else {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append(" skip less interval render video timestamp ");
                                            sb3.append(srcTsMs);
                                            sb3.append(" mLastLiveVideoTimestampMs ");
                                            sb3.append(BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs);
                                            sb3.append("inteval ( ");
                                            sb3.append(srcTsMs - BMGCameraPreviewerSessionRender.this.mLastLiveVideoTimestampMs);
                                            sb3.append(" < ");
                                            sb3.append(BMGCameraPreviewerSessionRender.this.mLivePtsInterval);
                                            sb3.append(")");
                                            Log.e(str, sb3.toString());
                                            videoSampleGroup.free();
                                        }
                                    } else {
                                        videoSampleGroup.free();
                                    }
                                }
                            });
                        }
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            newInstance.cost();
                        }
                    }
                    if (videoSampleGroup2 != null) {
                        BMGCameraPreviewerSessionRender.this.mLastFramePtsMs = (long) videoSampleGroup2.getMeta().getSrcTsMs();
                    }
                    BMGCameraPreviewerSessionRender.this.notifyFps(30);
                    return;
                }
                throw new IllegalStateException("render null when onSequenceSourceUpdate");
            }
        });
        BMGCameraSession bMGCameraSession = new BMGCameraSession(context, options, this.eglContextGroup, 0);
        this.mediaSession = bMGCameraSession;
        this.mICameraPreviewPipeline = new ICameraPreviewPipeline() {
            public void onAudioStream(final long j2, final byte[] bArr) {
                BMGCameraPreviewerSessionRender.this.runOnCameraLiveHandler(new Runnable() {
                    public void run() {
                        if (BMGCameraPreviewerSessionRender.this.mRecordParam != null) {
                            if (BMGCameraPreviewerSessionRender.this.mRecordParam.hasAudio) {
                                BMGCameraPreviewerSessionRender.this.initStartLive();
                            } else {
                                throw new IllegalStateException("putAudio with hasAudio false");
                            }
                        }
                        if (BMGCameraPreviewerSessionRender.this.mCameraLive != null) {
                            if (BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs == -1) {
                                BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs = j2 / 1000000;
                                StringBuilder sb = new StringBuilder();
                                sb.append(" first camera live ts(audio) ");
                                sb.append(BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs);
                                sb.append("ms");
                                Log.i(BMGConstants.TAG, sb.toString());
                            }
                            BMGCameraPreviewerSessionRender.this.mCameraLive.putAudio(j2, bArr);
                        }
                    }
                });
            }

            public void onExposureStream(long j2, double d2) {
                final TimeCost newInstance = TimeCost.newInstance("onExposureStream");
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = BMGCameraPreviewerSessionRender.this;
                final long j3 = j2;
                final double d3 = d2;
                AnonymousClass3 r1 = new Runnable() {
                    public void run() {
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            StringBuilder a2 = a.a(" timestampMs ");
                            a2.append(j3);
                            a2.append(" shutterSpeeds ");
                            a2.append(d3);
                            Log.i(BMGConstants.TAG, a2.toString());
                        }
                        if (!(BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer == null || BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.getRealTimeExposureRawData() == null)) {
                            BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.feedExposure(j3, d3);
                        }
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            newInstance.cost();
                        }
                    }
                };
                bMGCameraPreviewerSessionRender.runOnCameraPreviewHandler(r1);
            }

            public void onGyroStream(byte[] bArr, long j2) {
                final TimeCost newInstance = TimeCost.newInstance("onGyroStream");
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = BMGCameraPreviewerSessionRender.this;
                final long j3 = j2;
                final byte[] bArr2 = bArr;
                AnonymousClass4 r1 = new Runnable() {
                    public void run() {
                        boolean isDebug = BMGCameraPreviewerSessionRender.this.isDebug();
                        String str = BMGConstants.TAG;
                        if (isDebug) {
                            StringBuilder a2 = a.a(" lastGyroTimeMs ");
                            a2.append(j3);
                            Log.i(str, a2.toString());
                        }
                        BMGCameraPreviewerSessionRender.this.mLastGyroTimeMs = j3;
                        if (BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer != null) {
                            if (BMGCameraPreviewerSessionRender.this.mGyroCount > 0) {
                                if (BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems == null) {
                                    BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems = GyroRawItem.FromByteArray(bArr2);
                                } else {
                                    GyroRawItem[] FromByteArray = GyroRawItem.FromByteArray(bArr2);
                                    GyroRawItem[] gyroRawItemArr = new GyroRawItem[(BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems.length + FromByteArray.length)];
                                    System.arraycopy(BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems, 0, gyroRawItemArr, 0, BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems.length);
                                    System.arraycopy(FromByteArray, 0, gyroRawItemArr, BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems.length, FromByteArray.length);
                                    BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems = gyroRawItemArr;
                                }
                                if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                                    if (BMGCameraPreviewerSessionRender.this.mSetGyroTimeNs == -1) {
                                        Log.e(str, "error mSetGyroTimeNs -1");
                                    }
                                    StringBuilder a3 = a.a("time interval ");
                                    a3.append((System.nanoTime() - BMGCameraPreviewerSessionRender.this.mSetGyroTimeNs) / 1000000);
                                    a3.append(" mLastGyroSaveRawItems.length ");
                                    a3.append(BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems.length);
                                    a3.append(" mGyroCount ");
                                    a3.append(BMGCameraPreviewerSessionRender.this.mGyroCount);
                                    Log.i(str, a3.toString());
                                }
                                if (BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems.length >= BMGCameraPreviewerSessionRender.this.mGyroCount) {
                                    int mainRotationFromGyroData = SequenceStabilizer.getMainRotationFromGyroData(BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems, BMGCameraPreviewerSessionRender.this.mClipRenderInfo.getOffset(), BMGCameraPreviewerSessionRender.this.mClipRenderInfo.getGyroType(), 0.800000011920929d);
                                    if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(" cameraRotation ");
                                        sb.append(mainRotationFromGyroData);
                                        Log.i(str, sb.toString());
                                    }
                                    BMGCameraPreviewerSessionRender.this.mCameraPipelineCallback.onCameraRotation(mainRotationFromGyroData);
                                    BMGCameraPreviewerSessionRender.this.mLastGyroSaveRawItems = null;
                                    BMGCameraPreviewerSessionRender.this.mGyroCount = -1;
                                    BMGCameraPreviewerSessionRender.this.mSetGyroTimeNs = -1;
                                }
                            }
                            BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.feedGyro(bArr2);
                        }
                        BMGCameraPreviewerSessionRender.this.handleSlideVideo();
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            newInstance.cost();
                        }
                    }
                };
                bMGCameraPreviewerSessionRender.runOnCameraPreviewHandler(r1);
            }

            public void onScreenCapture(int i2, int i3, String str, ICameraPreviewScreenCaptureCallback iCameraPreviewScreenCaptureCallback) {
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = BMGCameraPreviewerSessionRender.this;
                final int i4 = i2;
                final int i5 = i3;
                final String str2 = str;
                final ICameraPreviewScreenCaptureCallback iCameraPreviewScreenCaptureCallback2 = iCameraPreviewScreenCaptureCallback;
                AnonymousClass8 r1 = new RenderTask() {
                    public void doTask() {
                        BMGCameraPreviewerSessionRender.this.startCameraStreamScreenCapture(i4, i5, str2, iCameraPreviewScreenCaptureCallback2);
                    }
                };
                bMGCameraPreviewerSessionRender.addRenderTask(r1);
            }

            public void onStartLive(final RecordParam recordParam, final ICameraLivePipline iCameraLivePipline) {
                final TimeCost newInstance = TimeCost.newInstance("onStartLive");
                BMGCameraPreviewerSessionRender.this.runOnCameraLiveHandler(new Runnable() {
                    public void run() {
                        if (BMGCameraPreviewerSessionRender.this.mCameraLive == null) {
                            BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs = -1;
                            BMGCameraPreviewerSessionRender.this.mRecordParam = recordParam;
                            BMGCameraPreviewerSessionRender.this.mCameraLivePipline = iCameraLivePipline;
                            StringBuilder sb = new StringBuilder();
                            sb.append(" recordParam.hasAudio ");
                            sb.append(recordParam.hasAudio);
                            Log.i(BMGConstants.TAG, sb.toString());
                            if (!recordParam.hasAudio) {
                                BMGCameraPreviewerSessionRender.this.initStartLive();
                                BMGCameraPreviewerSessionRender.this.mCameraLive.start();
                            }
                            BMGCameraPreviewerSessionRender.this.addRenderTask(new RenderTask() {
                                public void doTask() {
                                    AnonymousClass6 r0 = AnonymousClass6.this;
                                    BMGCameraPreviewerSessionRender.this.startLiveRender(recordParam);
                                }
                            });
                            if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                                newInstance.cost();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("onStartLive mCameraLive not null");
                    }
                });
            }

            public void onStopLive() {
                Log.i(BMGConstants.TAG, "onStopLive");
                BMGCameraPreviewerSessionRender.this.runOnCameraLiveHandler(new Runnable() {
                    public void run() {
                        CameraLive access$800 = BMGCameraPreviewerSessionRender.this.mCameraLive;
                        String str = BMGConstants.TAG;
                        if (access$800 != null) {
                            BMGCameraPreviewerSessionRender.this.stopLiveInternal();
                        } else {
                            Log.e(str, "onStopLive when mCameraLive null");
                        }
                        if (BMGCameraPreviewerSessionRender.this.mCameraLivePipline != null) {
                            BMGCameraPreviewerSessionRender.this.mCameraLivePipline.onCameraLiveStop();
                        } else {
                            Log.e(str, "onStopLive when mCameraLivePipline null");
                        }
                    }
                });
            }

            public void onUpdatePreviewDelta(final long j2) {
                BMGCameraPreviewerSessionRender.this.runOnCameraPreviewHandler(new Runnable() {
                    public void run() {
                        if (BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer != null) {
                            BMGCameraPreviewerSessionRender.this.mRealTimeStabilizer.setDelayTimeMs(j2);
                        }
                    }
                });
            }

            public void onVideoStream(final ImageData[] imageDataArr) {
                final TimeCost newInstance = TimeCost.newInstance("onVideoStream");
                BMGCameraPreviewerSessionRender.this.runOnCameraPreviewHandler(new Runnable() {
                    public void run() {
                        final long j2 = imageDataArr[0].timestampNs / 1000000;
                        BMGCameraPreviewerSessionRender.this.runOnCameraLiveHandler(new Runnable() {
                            public void run() {
                                if (BMGCameraPreviewerSessionRender.this.mCameraLive != null && BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs == -1) {
                                    BMGCameraPreviewerSessionRender.this.mFirstLiveTimestampMs = j2;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("no audio ? set first camera live ts(video) ");
                                    sb.append(j2);
                                    sb.append("ms");
                                    Log.i(BMGConstants.TAG, sb.toString());
                                }
                            }
                        });
                        BMGCameraPreviewerSessionRender.this.handleCameraVideoStream(imageDataArr);
                        if (BMGCameraPreviewerSessionRender.this.isDebug()) {
                            newInstance.cost();
                        }
                    }
                });
            }
        };
    }
}
