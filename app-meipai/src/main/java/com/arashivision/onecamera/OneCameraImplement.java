package com.arashivision.onecamera;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.LongSparseArray;
import com.arashivision.onecamera.OneDriver.OnNotificationListener;
import com.arashivision.onecamera.OneDriverInfo.Options;
import com.arashivision.onecamera.appusb.AppUsbService;
import com.arashivision.onecamera.appusb.DeviceFilter;
import com.arashivision.onecamera.appusb.UsbObserver;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
import com.arashivision.onecamera.camerarequest.ConnectToBTPeripheral;
import com.arashivision.onecamera.camerarequest.DeleteFiles;
import com.arashivision.onecamera.camerarequest.DisconnectBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetConnectedBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetFileExtra;
import com.arashivision.onecamera.camerarequest.GetFileList;
import com.arashivision.onecamera.camerarequest.GetGyro;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.ScanBTPeripheral;
import com.arashivision.onecamera.camerarequest.SetFileExtra;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onecamera.cameraresponse.CameraCaptureStatus;
import com.arashivision.onecamera.cameraresponse.GetCurrentCaptureStatusResp;
import com.arashivision.onecamera.cameraresponse.GetGyroResp;
import com.arashivision.onecamera.cameraresponse.StreamData;
import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.TakePictureWithoutStorageResponse;
import com.arashivision.onecamera.cameraresponse.TakePicturewithoutStorageResult;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import com.arashivision.onecamera.render.RenderMethod;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onecamera.render.RenderMode.Type;
import com.arashivision.onecamera.util.H2645Parser;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onecamera.util.H2645Parser.SPSCallback;
import com.arashivision.onecamera.util.H264Parser;
import com.arashivision.onecamera.util.H265Parser;
import com.arashivision.onestream.AbstractPlayer.StreamExposureInfo;
import com.arashivision.onestream.AudioData;
import com.arashivision.onestream.Gyro.GyroType;
import com.arashivision.onestream.Gyro.OneGyroDataCollection;
import com.arashivision.onestream.Gyro.OneGyroField;
import com.arashivision.onestream.Gyro.OneLatestIDR;
import com.arashivision.onestream.ImageData;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.OneStreamPipeline.Callbacks;
import com.arashivision.onestream.OneStreamPipeline.RecordParam;
import com.arashivision.onestream.PlayerBackend;
import com.arashivision.onestream.RenderWay;
import com.arashivision.onestream.pipeline.ICameraLivePipline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewScreenCaptureCallback;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.sina.weibo.sdk.constant.WBConstants;
import e.a.a.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class OneCameraImplement extends UsbObserver implements Callbacks {
    public static final int AUDIO_CHANNEL = 1;
    public static final int AUDIO_SAMPLE_RATE_DEF = 48000;
    public static final boolean DUMP_OUTPUT = false;
    public static final long EXTRA_LIMIT_TIME = 10000000000L;
    public static final String TAG = "OneCamera";
    public static boolean TRACE = false;
    public static final int VENDOR_ID_ONE2_UB = 11802;
    public static final int VENDOR_ID_ONE_UB = 16981;
    public static final char[] hexArray = SapiDataEncryptor.f3003a.toCharArray();
    public volatile byte[] mAudioExtradata;
    public AudioParam mAudioParam;
    public AudioSource mAudioSource = AudioSource.AUDIO_CAMERA;
    public Handler mCBHandler;
    public OneCallbacks mCallbacks;
    public OneCameraProcess mCameraProcess;
    public Context mContext;
    public volatile boolean mDetached;
    public UsbDevice mDevice;
    public DeviceFilter mDeviceFilter = new DeviceFilter() {
        public boolean filter(UsbDevice usbDevice) {
            return OneCameraImplement.this.isDeviceSupport(usbDevice);
        }
    };
    public OneDriver mDriver;
    public HandlerThread mDriverHandlerThread;
    public boolean mDualStreaming;
    public File mFileH264;
    public float[] mGyroRebaseMatrix;
    public Handler mHandler;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public OneStreamPipeline mImagePipeline;
    public Handler mInfoHandler;
    public InfoUpdateListener mInfoUpdateListener;
    public String mOffset;
    public OpenState mOpenState = OpenState.Idle;
    public long mPreviewDeltaNs;
    public String mRecordPath;
    public volatile RecordStatus mRecordStatus = RecordStatus.Idle;
    public volatile byte[] mRecordThumb;
    public RecordType mRecordType = RecordType.Camera;
    public boolean mReleased;
    public RenderMode mRenderMode = RenderMode.withGlRenderer(RenderMethod.DualFishEyeStitchingPlanar);
    public volatile int mRunningError;
    public String mStillImageCapturePath;
    public boolean mStitchingImage;
    public volatile byte[] mStopExtraData;
    public boolean mStreaming;
    public boolean mSupportStreaming;
    public Object mSurface;
    public Object mSurface2;
    public final Object mSyncExtraData = new Object();
    public AppUsbService mUsbService;
    public VideoParam mVideoParam;
    public boolean mWithoutYawRotation;
    public boolean mWriteH264;
    public long timeDeltaNs = 1000000000;

    public class DualVideoQueue extends VideoQueue {
        public LongSparseArray<DualImageInfo> mQueue = new LongSparseArray<>();

        public class DualImageInfo {
            public H2645Frame mLeftFrame;
            public H2645Frame mRightFrame;

            public DualImageInfo() {
            }

            public boolean isReady() {
                return (this.mLeftFrame == null || this.mRightFrame == null) ? false : true;
            }
        }

        public DualVideoQueue(int i2) {
            super(i2);
        }

        private void dropImage(String str) {
            if (isQueueExceed(str)) {
                int i2 = 0;
                while (true) {
                    String str2 = "OneCamera";
                    if (i2 < this.mQueue.size()) {
                        DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
                        H2645Frame h2645Frame = dualImageInfo.mLeftFrame;
                        if (h2645Frame == null) {
                            H2645Frame h2645Frame2 = dualImageInfo.mRightFrame;
                            if (h2645Frame2 != null && h2645Frame2.type == FrameType.Other) {
                                StringBuilder a2 = a.a("drop right ts ");
                                a2.append(this.mQueue.keyAt(i2));
                                Log.d(str2, a2.toString());
                                this.mQueue.removeAt(i2);
                            }
                        } else if (h2645Frame.type == FrameType.Other) {
                            StringBuilder a3 = a.a("drop left ts ");
                            a3.append(this.mQueue.keyAt(i2));
                            Log.d(str2, a3.toString());
                            this.mQueue.removeAt(i2);
                        }
                        i2++;
                    } else {
                        StringBuilder b2 = a.b(str, " after drop mQueue.size() ");
                        b2.append(this.mQueue.size());
                        Log.e(str2, b2.toString());
                        return;
                    }
                }
            }
        }

        private boolean isQueueExceed(String str) {
            if (this.mQueue.size() < this.mCapacity) {
                return false;
            }
            StringBuilder b2 = a.b(str, " mQueue size ");
            b2.append(this.mQueue.size());
            Log.e("OneCamera", b2.toString());
            return true;
        }

        public void enqueSecVideo(H2645Frame h2645Frame, long j2) {
            String str = "OneCamera";
            if (OneCameraImplement.TRACE) {
                StringBuilder sb = new StringBuilder();
                sb.append("enqueSecVideo timestamp ");
                sb.append(j2);
                Log.d(str, sb.toString());
            }
            int i2 = 0;
            while (i2 < this.mQueue.size() && this.mQueue.keyAt(i2) < j2) {
                DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
                if (dualImageInfo.mRightFrame == null) {
                    StringBuilder a2 = a.a("sec remove early ts (");
                    a2.append(this.mQueue.keyAt(i2));
                    a2.append(",");
                    a2.append(j2);
                    a2.append(")");
                    Log.e(str, a2.toString());
                    if (dualImageInfo.mLeftFrame != null) {
                        StringBuilder a3 = a.a(" type ");
                        a3.append(dualImageInfo.mLeftFrame.type);
                        Log.e(str, a3.toString());
                    }
                    this.mQueue.removeAt(i2);
                } else {
                    i2++;
                }
            }
            DualImageInfo dualImageInfo2 = (DualImageInfo) this.mQueue.get(j2);
            if (dualImageInfo2 == null) {
                DualImageInfo dualImageInfo3 = new DualImageInfo();
                dualImageInfo3.mRightFrame = h2645Frame;
                this.mQueue.append(j2, dualImageInfo3);
                dropImage("right");
            } else if (dualImageInfo2.mLeftFrame != null) {
                dualImageInfo2.mRightFrame = h2645Frame;
                if (j2 == this.mQueue.keyAt(0)) {
                    this.mQueue.remove(j2);
                    OneCameraImplement.this.mCameraProcess.feedPipelineVideo(dualImageInfo2.mLeftFrame, dualImageInfo2.mRightFrame, j2);
                    return;
                }
                throw new RuntimeException("enqueSecVideo dual deque not first");
            } else {
                throw new RuntimeException("dual enqueSecVideo null");
            }
        }

        public void enqueVideo(H2645Frame h2645Frame, long j2) {
            String str = "OneCamera";
            if (OneCameraImplement.TRACE) {
                StringBuilder sb = new StringBuilder();
                sb.append("enqueVideo timestamp ");
                sb.append(j2);
                Log.d(str, sb.toString());
            }
            int i2 = 0;
            while (i2 < this.mQueue.size() && this.mQueue.keyAt(i2) < j2) {
                DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
                if (dualImageInfo.mLeftFrame == null) {
                    StringBuilder a2 = a.a("remove early ts (");
                    a2.append(this.mQueue.keyAt(i2));
                    a2.append(",");
                    a2.append(j2);
                    a2.append(")");
                    Log.e(str, a2.toString());
                    this.mQueue.removeAt(i2);
                    if (dualImageInfo.mRightFrame != null) {
                        StringBuilder a3 = a.a(" type ");
                        a3.append(dualImageInfo.mRightFrame.type);
                        Log.e(str, a3.toString());
                    }
                } else {
                    i2++;
                }
            }
            DualImageInfo dualImageInfo2 = (DualImageInfo) this.mQueue.get(j2);
            if (dualImageInfo2 == null) {
                DualImageInfo dualImageInfo3 = new DualImageInfo();
                dualImageInfo3.mLeftFrame = h2645Frame;
                this.mQueue.append(j2, dualImageInfo3);
                dropImage("left");
            } else if (dualImageInfo2.mRightFrame != null) {
                dualImageInfo2.mLeftFrame = h2645Frame;
                if (j2 == this.mQueue.keyAt(0)) {
                    this.mQueue.remove(j2);
                    OneCameraImplement.this.mCameraProcess.feedPipelineVideo(dualImageInfo2.mLeftFrame, dualImageInfo2.mRightFrame, j2);
                    return;
                }
                throw new RuntimeException("enqueVideo dual deque not first");
            } else {
                throw new RuntimeException("dual enqueVideo null");
            }
        }
    }

    public class OneCameraProcess {
        public long frameCount = 0;
        public ByteDump mByteDump;
        public boolean mH265;
        public H2645Frame mLastFrame;
        public H2645Frame mLastFrameR;
        public long mLastFrameTime = 0;
        public long mLastOrgFrameTsMs = -1;
        public long mLastOrgFrameTsMsR = -1;
        public H2645Parser mParser;
        public H2645Parser mParserR;
        public boolean mReleased;
        public VideoQueue mVideoQueue;
        public long originLastGyroTsMs;
        public long startTime;

        public OneCameraProcess(boolean z, boolean z2) {
            this.mH265 = z2;
            if (z2) {
                if (z) {
                    this.mParser = new H265Parser();
                    this.mParserR = new H265Parser();
                } else {
                    this.mParser = new H265Parser();
                }
            } else if (z) {
                this.mParser = new H264Parser();
                this.mParserR = new H264Parser();
            } else {
                this.mParser = new H264Parser();
            }
            if (z) {
                this.mVideoQueue = new DualVideoQueue(30);
                this.mParser.setSpsCallback(new SPSCallback(OneCameraImplement.this) {
                    public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                        if (OneCameraImplement.this.mVideoParam != null) {
                            boolean access$2200 = OneCameraImplement.TRACE;
                            String str = Config.EVENT_HEAT_X;
                            String str2 = "OneCamera";
                            if (access$2200) {
                                StringBuilder a2 = a.a("dual left sps parse video resolution (", i2, str, i3, ") fps ");
                                a2.append(i4);
                                a2.append(" fpsFloat ");
                                a2.append(f2);
                                a2.append("");
                                Log.i(str2, a2.toString());
                            }
                            String str3 = ")";
                            if (!(OneCameraImplement.this.mVideoParam.width / 2 == i2 && OneCameraImplement.this.mVideoParam.height == i3)) {
                                StringBuilder a3 = a.a("dual left video resolution update from (");
                                a3.append(OneCameraImplement.this.mVideoParam.width);
                                a3.append(str);
                                a3.append(OneCameraImplement.this.mVideoParam.height);
                                a3.append(") to (");
                                int i5 = i2 * 2;
                                a3.append(i5);
                                a3.append(str);
                                a3.append(i3 * 2);
                                a3.append(str3);
                                Log.e(str2, a3.toString());
                                OneCameraImplement.this.mVideoParam.width = i5;
                                OneCameraImplement.this.mVideoParam.height = i3;
                            }
                            if (Math.abs(OneCameraImplement.this.mVideoParam.fps - i4) > 1) {
                                StringBuilder a4 = a.a("dual left video fps (");
                                a4.append(OneCameraImplement.this.mVideoParam.fps);
                                a4.append(") mismatch (");
                                a4.append(i4);
                                a4.append(str3);
                                Log.e(str2, a4.toString());
                            }
                        }
                    }
                });
                this.mParserR.setSpsCallback(new SPSCallback(OneCameraImplement.this) {
                    public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                        if (OneCameraImplement.this.mVideoParam != null) {
                            boolean access$2200 = OneCameraImplement.TRACE;
                            String str = Config.EVENT_HEAT_X;
                            String str2 = "OneCamera";
                            if (access$2200) {
                                StringBuilder a2 = a.a("dual right sps parse video resolution (", i2, str, i3, ") fps ");
                                a2.append(i4);
                                a2.append(" fpsFloat ");
                                a2.append(f2);
                                a2.append("");
                                Log.i(str2, a2.toString());
                            }
                            String str3 = ")";
                            if (!(OneCameraImplement.this.mVideoParam.width / 2 == i2 && OneCameraImplement.this.mVideoParam.height == i3)) {
                                StringBuilder a3 = a.a("dual right video resolution update from (");
                                a3.append(OneCameraImplement.this.mVideoParam.width);
                                a3.append(str);
                                a3.append(OneCameraImplement.this.mVideoParam.height);
                                a3.append(") to (");
                                a3.append(i2);
                                a3.append(str);
                                a3.append(i3);
                                a3.append(str3);
                                Log.e(str2, a3.toString());
                                OneCameraImplement.this.mVideoParam.width = i2 * 2;
                                OneCameraImplement.this.mVideoParam.height = i3;
                            }
                            if (Math.abs(OneCameraImplement.this.mVideoParam.fps - i4) > 1) {
                                StringBuilder a4 = a.a("dual right video fps (");
                                a4.append(OneCameraImplement.this.mVideoParam.fps);
                                a4.append(") mismatch (");
                                a4.append(i4);
                                a4.append(str3);
                                Log.e(str2, a4.toString());
                            }
                        }
                    }
                });
            } else {
                this.mVideoQueue = new SingleVideoQueue(30);
                this.mParser.setSpsCallback(new SPSCallback(OneCameraImplement.this) {
                    public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                        if (OneCameraImplement.this.mVideoParam != null) {
                            boolean access$2200 = OneCameraImplement.TRACE;
                            String str = Config.EVENT_HEAT_X;
                            String str2 = "OneCamera";
                            if (access$2200) {
                                StringBuilder a2 = a.a("single sps parse video resolution (", i2, str, i3, ") fps ");
                                a2.append(i4);
                                a2.append(" fpsFloat ");
                                a2.append(f2);
                                a2.append("");
                                Log.i(str2, a2.toString());
                            }
                            String str3 = ")";
                            if (!(OneCameraImplement.this.mVideoParam.width == i2 && OneCameraImplement.this.mVideoParam.height == i3)) {
                                StringBuilder a3 = a.a("single video resolution update from (");
                                a3.append(OneCameraImplement.this.mVideoParam.width);
                                a3.append(str);
                                a3.append(OneCameraImplement.this.mVideoParam.height);
                                a3.append(") to (");
                                a3.append(i2);
                                a3.append(str);
                                a3.append(i3);
                                a3.append(str3);
                                Log.e(str2, a3.toString());
                                OneCameraImplement.this.mVideoParam.width = i2;
                                OneCameraImplement.this.mVideoParam.height = i3;
                            }
                            if (Math.abs(OneCameraImplement.this.mVideoParam.fps - i4) > 1) {
                                StringBuilder a4 = a.a("single video fps (");
                                a4.append(OneCameraImplement.this.mVideoParam.fps);
                                a4.append(") mismatch (");
                                a4.append(i4);
                                a4.append(str3);
                                Log.e(str2, a4.toString());
                            }
                        }
                    }
                });
            }
            this.startTime = System.nanoTime();
        }

        private double bytes2Double(byte[] bArr, int i2) {
            long j2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                j2 |= ((long) (bArr[i3 + i2] & 255)) << (i3 * 8);
            }
            return Double.longBitsToDouble(j2);
        }

        private void debugVideoInterval(FrameType frameType) {
            long nanoTime = System.nanoTime();
            if (this.mLastFrameTime != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("frame[");
                sb.append(frameType);
                sb.append("] + interval ");
                sb.append(nanoTime - this.mLastFrameTime);
                Log.d("OneCamera", sb.toString());
            }
            this.mLastFrameTime = nanoTime;
        }

        private void dumpDataIfNecessary(StreamData streamData) {
        }

        private long getFixTimestap(long j2) {
            return j2;
        }

        private void putExposureTime(StreamExposureInfo streamExposureInfo) {
            if (OneCameraImplement.this.mICameraPreviewPipeline != null) {
                Log.e("OneCamera", "putExposureTime meet mICameraPreviewPipeline null");
            }
        }

        private void putGyro(LinkedList<OneGyroField> linkedList) {
            if (OneCameraImplement.this.mICameraPreviewPipeline != null) {
                Log.e("OneCamera", "putGyro but mICameraPreviewPipeline not null error");
            } else {
                OneCameraImplement.this.mImagePipeline.putGyro(linkedList);
            }
        }

        private void putImage(ImageData[] imageDataArr) {
            if (OneCameraImplement.this.mICameraPreviewPipeline != null) {
                OneCameraImplement.this.mICameraPreviewPipeline.onVideoStream(imageDataArr);
            } else {
                Log.i("OneCamera", " empty");
            }
        }

        private void writeH264Data(byte[] bArr, int i2, int i3) {
            try {
                String str = "OneCamera";
                if (OneCameraImplement.this.mFileH264 == null) {
                    OneCameraImplement oneCameraImplement = OneCameraImplement.this;
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    StringBuilder sb = new StringBuilder();
                    sb.append("one_demo/insv_");
                    sb.append(new SimpleDateFormat("MM_dd_HH_mm_ss_SSS", Locale.getDefault()).format(new Date()));
                    sb.append(".h264");
                    oneCameraImplement.mFileH264 = new File(externalStorageDirectory, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mFileH264 is ");
                    sb2.append(OneCameraImplement.this.mFileH264.getAbsolutePath());
                    Log.d(str, sb2.toString());
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(OneCameraImplement.this.mFileH264, "rw");
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr, i2, i3);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" ");
                sb3.append(OneCameraImplement.this.mFileH264.getAbsoluteFile());
                sb3.append(" input size ");
                sb3.append(i3);
                sb3.append(" file size ");
                sb3.append(OneCameraImplement.this.mFileH264.length());
                Log.d(str, sb3.toString());
                randomAccessFile.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void debugFPS(int i2) {
            long nanoTime = System.nanoTime();
            long j2 = this.frameCount + 1;
            this.frameCount = j2;
            if (j2 % ((long) i2) == 0) {
                double d2 = ((double) (i2 * 1000)) / (((double) (nanoTime - this.startTime)) / 1000000.0d);
                StringBuilder sb = new StringBuilder();
                sb.append("camera input fps: ");
                sb.append(d2);
                Log.i("OneCamera", sb.toString());
                this.startTime = nanoTime;
            }
        }

        public void feedPipelineVideo(H2645Frame h2645Frame, long j2) {
            ImageData imageData = new ImageData();
            imageData.data = h2645Frame.data;
            imageData.data_offset = h2645Frame.offset;
            imageData.data_size = h2645Frame.size;
            imageData.csd = this.mParser.getCsdData();
            int i2 = imageData.flags;
            FrameType frameType = h2645Frame.type;
            imageData.flags = i2 | ((frameType == FrameType.IDR || frameType == FrameType.IFrame) ? 1 : 0);
            imageData.timestampNs = j2;
            imageData.width = OneCameraImplement.this.getPreviewWidth();
            imageData.height = OneCameraImplement.this.getPreviewHeight();
            imageData.fps = OneCameraImplement.this.getPreviewFps();
            imageData.mH265 = this.mH265;
            if (OneCameraImplement.TRACE) {
                StringBuilder a2 = a.a("put video packet: offset: ");
                a2.append(imageData.data_offset);
                a2.append(", size: ");
                a2.append(imageData.data_size);
                a2.append(", type: ");
                a2.append(h2645Frame.type);
                a2.append(" , flags ");
                a2.append(imageData.flags);
                a2.append(" imageData.mH265 ");
                a2.append(imageData.mH265);
                a2.append(", start bytes: ");
                a2.append(imageData.data[imageData.data_offset]);
                String str = ", ";
                a2.append(str);
                a2.append(imageData.data[imageData.data_offset + 1]);
                a2.append(str);
                a2.append(imageData.data[imageData.data_offset + 2]);
                a2.append(" frameSysTimeNs ");
                a2.append(j2);
                Log.i("OneCamera", a2.toString());
            }
            putImage(new ImageData[]{imageData});
        }

        public void finalize() throws Throwable {
            if (!this.mReleased) {
                release();
            }
            super.finalize();
        }

        public void processAudioFrame(StreamData streamData) {
            AudioData audioData = new AudioData();
            byte[] bArr = streamData.data;
            audioData.data = bArr;
            audioData.dataSize = bArr.length;
            audioData.dataOffset = 0;
            audioData.timestampNsSysClock = getFixTimestap(streamData.timestamp * 1000000);
            if (OneCameraImplement.this.mAudioParam.codec == 1 && OneCameraImplement.this.mICameraPreviewPipeline != null) {
                OneCameraImplement.this.mICameraPreviewPipeline.onAudioStream(audioData.timestampNsSysClock, streamData.data);
            }
        }

        public void processExposureTime(StreamData streamData) {
            if (!OneCameraImplement.this.isGyroEnable()) {
                return;
            }
            if (OneCameraImplement.this.mICameraPreviewPipeline != null) {
                new StreamExposureInfo();
                OneCameraImplement.this.mICameraPreviewPipeline.onExposureStream(streamData.timestamp, bytes2Double(streamData.data, 0));
                return;
            }
            StreamExposureInfo streamExposureInfo = new StreamExposureInfo();
            streamExposureInfo.timestampNs = getFixTimestap(streamData.timestamp * 1000000);
            streamExposureInfo.exposureTimeNs = (long) (bytes2Double(streamData.data, 0) * 1.0E9d);
            putExposureTime(streamExposureInfo);
        }

        public void processGyro(StreamData streamData) {
            if (OneCameraImplement.this.isGyroEnable() && OneCameraImplement.this.mICameraPreviewPipeline == null) {
                int length = streamData.data.length / 56;
                LinkedList linkedList = new LinkedList();
                OneGyroField oneGyroField = new OneGyroField(streamData.data, 0, OneCameraImplement.this.timeDeltaNs);
                if (this.originLastGyroTsMs >= oneGyroField.originTsMs) {
                    for (int i2 = length - 1; i2 > 0; i2--) {
                        oneGyroField = new OneGyroField(streamData.data, i2 * 56, OneCameraImplement.this.timeDeltaNs);
                        if (this.originLastGyroTsMs >= oneGyroField.originTsMs) {
                            break;
                        }
                        linkedList.add(oneGyroField);
                    }
                    StringBuilder a2 = a.a("remove duplicate gyro:last gyro ts ");
                    a2.append(this.originLastGyroTsMs);
                    a2.append(" >= new ");
                    a2.append(oneGyroField.originTsMs);
                    a2.append(" delta ");
                    a2.append(this.originLastGyroTsMs - oneGyroField.originTsMs);
                    a2.append(" reset gyroFields size ");
                    a2.append(linkedList.size());
                    Log.e("OneCamera", a2.toString());
                    if (linkedList.size() > 0) {
                        putGyro(linkedList);
                        this.originLastGyroTsMs = ((OneGyroField) linkedList.get(linkedList.size() - 1)).originTsMs;
                        return;
                    }
                    return;
                }
                linkedList.add(oneGyroField);
                for (int i3 = 1; i3 < length; i3++) {
                    linkedList.add(new OneGyroField(streamData.data, i3 * 56, OneCameraImplement.this.timeDeltaNs));
                }
                putGyro(linkedList);
                this.originLastGyroTsMs = ((OneGyroField) linkedList.get(linkedList.size() - 1)).originTsMs;
            }
        }

        public void processSecVideoFrame(StreamData streamData) {
            byte[] bArr = streamData.data;
            String str = "OneCamera";
            if (bArr[0] == 0 && bArr[1] == 0) {
                String str2 = " frameSysTimeNs ";
                if (bArr[2] == 0 && bArr[3] == 1) {
                    long fixTimestap = getFixTimestap(streamData.timestamp * 1000000);
                    if (OneCameraImplement.TRACE) {
                        StringBuilder a2 = a.a("sec first received one video frame, size: ");
                        a2.append(streamData.data.length);
                        a2.append(str2);
                        a2.append(fixTimestap);
                        Log.i(str, a2.toString());
                    }
                    H2645Frame h2645Frame = this.mLastFrameR;
                    if (h2645Frame != null) {
                        if (h2645Frame.size == 0) {
                            Log.e(str, "frame size 0");
                        } else if (this.mParserR.getCsdData() != null) {
                            this.mVideoQueue.enqueSecVideo(this.mLastFrameR, getFixTimestap(this.mLastOrgFrameTsMsR * 1000000));
                        } else if (this.mLastFrameR.type != FrameType.IDR) {
                            StringBuilder a3 = a.a("sec sps and pps data not received, drop frame: ");
                            a3.append(this.mLastFrameR.type);
                            Log.w(str, a3.toString());
                        } else {
                            Log.e(str, "sec iframe but no video extra");
                        }
                        this.mLastFrameR = null;
                    }
                    H2645Parser h2645Parser = this.mParserR;
                    byte[] bArr2 = streamData.data;
                    h2645Parser.feedData(bArr2, 0, bArr2.length);
                    H2645Frame h2645Frame2 = new H2645Frame();
                    while (this.mParserR.readFrame(h2645Frame2)) {
                        if (this.mLastFrameR == null) {
                            this.mLastFrameR = h2645Frame2;
                        } else {
                            Log.e(str, " mLastFrameR not null");
                            throw new IllegalArgumentException("mLastFrameR not null during readFrame");
                        }
                    }
                    this.mLastOrgFrameTsMsR = streamData.timestamp;
                    if (this.mLastFrameR == null) {
                        throw new IllegalArgumentException("mLastFrameR null after readFrame");
                    }
                    return;
                } else if (streamData.data[2] == 1) {
                    if (!this.mH265) {
                        Log.e(str, "sec h264 meet begin with 00 00 01");
                    } else if (this.mLastOrgFrameTsMsR != -1) {
                        long fixTimestap2 = getFixTimestap(streamData.timestamp * 1000000);
                        if (OneCameraImplement.TRACE) {
                            StringBuilder a4 = a.a("concat received one video frame, size: ");
                            a4.append(streamData.data.length);
                            a4.append(str2);
                            a4.append(fixTimestap2);
                            Log.i(str, a4.toString());
                        }
                        if (this.mLastFrame != null) {
                            if (this.mLastOrgFrameTsMsR != streamData.timestamp) {
                                StringBuilder a5 = a.a("mismatch last frame ts (");
                                a5.append(this.mLastOrgFrameTsMsR);
                                a5.append(" != ");
                                a5.append(streamData.timestamp);
                                a5.append(") delta ");
                                a5.append(this.mLastOrgFrameTsMsR - streamData.timestamp);
                                Log.e(str, a5.toString());
                            }
                            if (OneCameraImplement.TRACE) {
                                StringBuilder a6 = a.a("go on received one video frame, size: ");
                                a6.append(streamData.data.length);
                                a6.append(str2);
                                a6.append(fixTimestap2);
                                Log.i(str, a6.toString());
                            }
                            H2645Frame h2645Frame3 = this.mLastFrameR;
                            int i2 = h2645Frame3.size;
                            byte[] bArr3 = new byte[(streamData.data.length + i2)];
                            System.arraycopy(h2645Frame3.data, h2645Frame3.offset, bArr3, 0, i2);
                            byte[] bArr4 = streamData.data;
                            System.arraycopy(bArr4, 0, bArr3, this.mLastFrameR.size, bArr4.length);
                            H2645Frame h2645Frame4 = this.mLastFrameR;
                            h2645Frame4.offset = 0;
                            h2645Frame4.data = bArr3;
                            h2645Frame4.size = bArr3.length;
                        } else {
                            throw new IllegalArgumentException("sec concat but mLastFrame null");
                        }
                    } else {
                        Log.e(str, "sec skip non-first h265 slice");
                    }
                    return;
                }
            }
            StringBuilder a7 = a.a("sec process invalid ");
            a7.append(this.mH265 ? "h265" : "h264");
            a7.append("  frame, size: ");
            a7.append(streamData.data.length);
            a7.append(", start bytes: ");
            a7.append(OneCameraImplement.bytesToHex(streamData.data, 0, 8));
            Log.e(str, a7.toString());
        }

        public void processVideoFrame(StreamData streamData) {
            byte[] bArr = streamData.data;
            String str = "OneCamera";
            if (bArr[0] == 0 && bArr[1] == 0) {
                String str2 = " frameSysTimeNs ";
                if (bArr[2] == 0 && bArr[3] == 1) {
                    long fixTimestap = getFixTimestap(streamData.timestamp * 1000000);
                    if (OneCameraImplement.TRACE) {
                        StringBuilder a2 = a.a("received one video frame, size: ");
                        a2.append(streamData.data.length);
                        a2.append(str2);
                        a2.append(fixTimestap);
                        Log.i(str, a2.toString());
                    }
                    H2645Frame h2645Frame = this.mLastFrame;
                    if (h2645Frame != null) {
                        if (h2645Frame.size == 0) {
                            Log.e(str, "frame size 0");
                        } else if (this.mParser.getCsdData() != null) {
                            this.mVideoQueue.enqueVideo(this.mLastFrame, getFixTimestap(this.mLastOrgFrameTsMs * 1000000));
                        } else if (this.mLastFrame.type != FrameType.IDR) {
                            StringBuilder a3 = a.a("sps and pps data not received, drop frame: ");
                            a3.append(this.mLastFrame.type);
                            Log.w(str, a3.toString());
                        } else {
                            Log.e(str, "iframe but no video extra");
                        }
                        if (OneCameraImplement.this.mWriteH264) {
                            H2645Frame h2645Frame2 = this.mLastFrame;
                            writeH264Data(h2645Frame2.data, h2645Frame2.offset, h2645Frame2.size);
                        }
                        this.mLastFrame = null;
                    }
                    H2645Parser h2645Parser = this.mParser;
                    byte[] bArr2 = streamData.data;
                    h2645Parser.feedData(bArr2, 0, bArr2.length);
                    H2645Frame h2645Frame3 = new H2645Frame();
                    while (this.mParser.readFrame(h2645Frame3)) {
                        if (this.mLastFrame == null) {
                            this.mLastFrame = h2645Frame3;
                        } else {
                            Log.e(str, " mLastFrame not null");
                            throw new IllegalArgumentException("mLastFrame not null during readFrame");
                        }
                    }
                    this.mLastOrgFrameTsMs = streamData.timestamp;
                    if (this.mLastFrame == null) {
                        throw new IllegalArgumentException("mLastFrame null after readFrame");
                    }
                    return;
                } else if (streamData.data[2] == 1) {
                    if (!this.mH265) {
                        Log.e(str, " skip non-first h265 slice");
                    } else if (this.mLastOrgFrameTsMs == -1) {
                        Log.e(str, " h264 meet begin with 00 00 01");
                    } else if (this.mLastFrame != null) {
                        long fixTimestap2 = getFixTimestap(streamData.timestamp * 1000000);
                        if (OneCameraImplement.TRACE) {
                            StringBuilder a4 = a.a("concat received one video frame, size: ");
                            a4.append(streamData.data.length);
                            a4.append(str2);
                            a4.append(fixTimestap2);
                            Log.i(str, a4.toString());
                        }
                        if (this.mLastOrgFrameTsMs != streamData.timestamp) {
                            StringBuilder a5 = a.a("mismatch last frame ts (");
                            a5.append(this.mLastOrgFrameTsMs);
                            a5.append(" != ");
                            a5.append(streamData.timestamp);
                            a5.append(") delta ");
                            a5.append(this.mLastOrgFrameTsMs - streamData.timestamp);
                            Log.e(str, a5.toString());
                        }
                        if (OneCameraImplement.TRACE) {
                            StringBuilder a6 = a.a("go on received one video frame, size: ");
                            a6.append(streamData.data.length);
                            a6.append(str2);
                            a6.append(fixTimestap2);
                            Log.i(str, a6.toString());
                        }
                        H2645Frame h2645Frame4 = this.mLastFrame;
                        int i2 = h2645Frame4.size;
                        byte[] bArr3 = new byte[(streamData.data.length + i2)];
                        System.arraycopy(h2645Frame4.data, h2645Frame4.offset, bArr3, 0, i2);
                        byte[] bArr4 = streamData.data;
                        System.arraycopy(bArr4, 0, bArr3, this.mLastFrame.size, bArr4.length);
                        H2645Frame h2645Frame5 = this.mLastFrame;
                        h2645Frame5.offset = 0;
                        h2645Frame5.data = bArr3;
                        h2645Frame5.size = bArr3.length;
                    } else {
                        throw new IllegalArgumentException(" concat but mLastFrame null");
                    }
                    return;
                }
            }
            StringBuilder a7 = a.a(" process invalid ");
            a7.append(this.mH265 ? "h265" : "h264");
            a7.append(" frame, size: ");
            a7.append(streamData.data.length);
            a7.append(", start bytes: ");
            a7.append(OneCameraImplement.bytesToHex(streamData.data, 0, 8));
            Log.e(str, a7.toString());
        }

        public void release() {
            String str = "OneCamera";
            Log.i(str, "release camera source");
            this.mReleased = true;
            Log.i(str, "camera source released");
        }

        public void feedPipelineVideo(H2645Frame h2645Frame, H2645Frame h2645Frame2, long j2) {
            ImageData imageData = new ImageData();
            imageData.data = h2645Frame.data;
            imageData.data_offset = h2645Frame.offset;
            imageData.data_size = h2645Frame.size;
            imageData.csd = this.mParser.getCsdData();
            int i2 = imageData.flags;
            FrameType frameType = h2645Frame.type;
            imageData.flags = ((frameType == FrameType.IDR || frameType == FrameType.IFrame) ? 1 : 0) | i2;
            imageData.timestampNs = j2;
            imageData.width = OneCameraImplement.this.getPreviewWidth();
            imageData.height = OneCameraImplement.this.getPreviewHeight();
            imageData.fps = OneCameraImplement.this.getPreviewFps();
            imageData.mH265 = this.mH265;
            ImageData imageData2 = new ImageData();
            imageData2.data = h2645Frame2.data;
            imageData2.data_offset = h2645Frame2.offset;
            imageData2.data_size = h2645Frame2.size;
            imageData2.csd = this.mParserR.getCsdData();
            int i3 = imageData2.flags;
            FrameType frameType2 = h2645Frame2.type;
            imageData2.flags = ((frameType2 == FrameType.IDR || frameType2 == FrameType.IFrame) ? 1 : 0) | i3;
            imageData2.timestampNs = j2;
            imageData2.width = OneCameraImplement.this.getPreviewWidth();
            imageData2.height = OneCameraImplement.this.getPreviewHeight();
            imageData2.fps = OneCameraImplement.this.getPreviewFps();
            imageData2.mH265 = this.mH265;
            putImage(new ImageData[]{imageData, imageData2});
        }
    }

    public enum OpenState {
        Idle,
        Opening,
        OpenComplete,
        Error
    }

    public enum RecordStatus {
        Idle,
        Recording,
        Stopping,
        Error,
        TimelapseError
    }

    public class SingleVideoQueue extends VideoQueue {
        public SingleVideoQueue(int i2) {
            super(i2);
        }

        public void enqueSecVideo(H2645Frame h2645Frame, long j2) {
        }

        public void enqueVideo(H2645Frame h2645Frame, long j2) {
            OneCameraImplement.this.mCameraProcess.feedPipelineVideo(h2645Frame, j2);
        }
    }

    public abstract class VideoQueue {
        public int mCapacity;

        public VideoQueue(int i2) {
            this.mCapacity = i2;
        }

        public abstract void enqueSecVideo(H2645Frame h2645Frame, long j2);

        public abstract void enqueVideo(H2645Frame h2645Frame, long j2);
    }

    public OneCameraImplement(Looper looper, Context context, OneCallbacks oneCallbacks, Handler handler) {
        String str = "OneCamera";
        Log.i(str, "onecamera created");
        this.mHandler = new Handler(looper);
        this.mContext = context;
        this.mCallbacks = oneCallbacks;
        if (handler != null) {
            StringBuilder a2 = a.a("camera callback run on caller's handler thread: ");
            a2.append(handler.getLooper().getThread().getName());
            Log.i(str, a2.toString());
            this.mCBHandler = handler;
        } else {
            Log.i(str, "camera callback run on camera thread");
            this.mCBHandler = this.mHandler;
        }
        OneStreamPipeline oneStreamPipeline = new OneStreamPipeline(this.mContext, this, looper, this.mCBHandler);
        this.mImagePipeline = oneStreamPipeline;
        oneStreamPipeline.setPlayerBackend(PlayerBackend.DualPlayer);
        initVideoParam();
        initAudioParam();
    }

    public static String bytesToHex(byte[] bArr, int i2, int i3) {
        if (i2 + i3 > bArr.length) {
            i3 = bArr.length - i2;
        }
        char[] cArr = new char[(i3 * 2)];
        for (int i4 = 0; i4 < i3; i4++) {
            byte b2 = bArr[i4 + i2] & 255;
            int i5 = i4 * 2;
            char[] cArr2 = hexArray;
            cArr[i5] = cArr2[b2 >>> 4];
            cArr[i5 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    private void checkOpenComplete(String str) {
        if (this.mOpenState != OpenState.OpenComplete) {
            throw new IllegalStateException("camera not open");
        }
    }

    private void checkRecord(String str) {
        if (this.mRecordStatus != RecordStatus.Recording) {
            StringBuilder b2 = a.b(str, "Record state: ");
            b2.append(this.mRecordStatus);
            throw new IllegalStateException(b2.toString());
        }
    }

    private void checkRecordIdle(String str) {
        if (this.mRecordStatus != RecordStatus.Idle) {
            StringBuilder b2 = a.b(str, " mRecordStatus: ");
            b2.append(this.mRecordStatus);
            Log.e("OneCamera", b2.toString());
            StringBuilder a2 = a.a("Record state: ");
            a2.append(this.mRecordStatus);
            throw new IllegalStateException(a2.toString());
        }
    }

    private void closeInternal() {
        if (this.mStreaming) {
            Log.w("OneCamera", "closing camera, streaming is on, stop it");
            stopStreamInternal();
        }
        OneDriver oneDriver = this.mDriver;
        if (oneDriver != null) {
            oneDriver.close();
            this.mDriverHandlerThread.quit();
            try {
                this.mDriverHandlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mDriverHandlerThread = null;
            this.mDriver = null;
        }
        AppUsbService appUsbService = this.mUsbService;
        if (appUsbService != null) {
            UsbDevice usbDevice = this.mDevice;
            if (usbDevice != null) {
                appUsbService.closeDevice(usbDevice);
                this.mDevice = null;
            }
            this.mUsbService.release();
            this.mUsbService = null;
        }
        this.mOpenState = OpenState.Idle;
        this.mOffset = null;
        this.mRunningError = 0;
        this.mDetached = false;
    }

    public static void deleteFile(String str) {
        new File(str).delete();
    }

    private void dumpGyroData(OneGyroDataCollection oneGyroDataCollection, String str) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(str));
            Iterator it = oneGyroDataCollection.gyroFields.iterator();
            while (it.hasNext()) {
                OneGyroField oneGyroField = (OneGyroField) it.next();
                StringBuilder a2 = a.a("time: ");
                a2.append(oneGyroField.timestampNs);
                a2.append(", rotationX: ");
                a2.append(-oneGyroField.accels[0]);
                a2.append(", rotationY: ");
                a2.append(oneGyroField.accels[1]);
                a2.append(", rotationZ: ");
                a2.append(-oneGyroField.accels[2]);
                a2.append(", gravityX: ");
                a2.append(-oneGyroField.gyros[0]);
                a2.append(", gravityY: ");
                a2.append(oneGyroField.gyros[1]);
                a2.append(", gravityZ: ");
                a2.append(-oneGyroField.gyros[2]);
                Log.i("OneCamera", a2.toString());
                printStream.print(oneGyroField.timestampNs);
                printStream.print('_');
                printStream.print(-oneGyroField.accels[0]);
                printStream.print('_');
                printStream.print(oneGyroField.accels[1]);
                printStream.print('_');
                printStream.print(-oneGyroField.accels[2]);
                printStream.print('_');
                printStream.print(-oneGyroField.gyros[0]);
                printStream.print('_');
                printStream.print(oneGyroField.gyros[1]);
                printStream.print('_');
                printStream.print(-oneGyroField.gyros[2]);
                printStream.println();
            }
            printStream.close();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void finishRecordFile() {
    }

    private void fixCameraAndMobileTime() {
        long nanoTime = System.nanoTime();
        int i2 = 0;
        while (true) {
            if (i2 >= 10) {
                break;
            }
            long oneCameraTime = getOneCameraTime() * 1000000;
            long nanoTime2 = ((System.nanoTime() + System.nanoTime()) / 2) - oneCameraTime;
            if (nanoTime2 <= 10000000) {
                this.timeDeltaNs = nanoTime2;
                break;
            }
            if (nanoTime2 < this.timeDeltaNs) {
                this.timeDeltaNs = nanoTime2;
            }
            i2++;
        }
        long nanoTime3 = System.nanoTime();
        StringBuilder a2 = a.a("cost ");
        a2.append((nanoTime3 - nanoTime) / 1000000);
        a2.append("ms timeDeltaNs ");
        a2.append(this.timeDeltaNs);
        Log.d("OneCamera", a2.toString());
    }

    private long getOneCameraTime() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Options.MEDIA_TIME);
        return this.mDriver.getOptions(arrayList).getMediaTime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        if (r4.mDetached != false) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void isAllowCloseOrStopStreaming(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = r4.mRecordStatus
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r1 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Idle
            r2 = 1
            if (r0 != r1) goto L_0x0008
            goto L_0x0075
        L_0x0008:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = r4.mRecordStatus
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r1 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Error
            java.lang.String r3 = "OneCamera"
            if (r0 != r1) goto L_0x0028
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r0 = " met record error force resetRecord"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r3, r6)
            r4.resetRecordInternal()
            goto L_0x0075
        L_0x0028:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = r4.mRecordStatus
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r1 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.TimelapseError
            if (r0 != r1) goto L_0x0048
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = " met timelapse error force resetTimelpase"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r3, r0)
            com.arashivision.onecamera.camerarequest.StopTimelapse r6 = (com.arashivision.onecamera.camerarequest.StopTimelapse) r6
            r4.resetTimelpase(r6)
            goto L_0x0075
        L_0x0048:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r6 = r4.mRecordStatus
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Stopping
            if (r6 != r0) goto L_0x0059
            com.arashivision.onecamera.RecordType r6 = r4.mRecordType
            com.arashivision.onecamera.RecordType r0 = com.arashivision.onecamera.RecordType.Camera
            if (r6 != r0) goto L_0x0074
            boolean r6 = r4.mDetached
            if (r6 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0059:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r6 = r4.mRecordStatus
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Recording
            if (r6 != r0) goto L_0x0074
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r0 = "　with keeping on record "
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r3, r6)
            goto L_0x0075
        L_0x0074:
            r2 = 0
        L_0x0075:
            if (r2 == 0) goto L_0x0078
            return
        L_0x0078:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r0 = " mRecordStatus "
            java.lang.StringBuilder r5 = e.a.a.a.a.b(r5, r0)
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r0 = r4.mRecordStatus
            r5.append(r0)
            java.lang.String r0 = " mDetached "
            r5.append(r0)
            boolean r0 = r4.mDetached
            r5.append(r0)
            java.lang.String r0 = " mRecordType "
            r5.append(r0)
            com.arashivision.onecamera.RecordType r0 = r4.mRecordType
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onecamera.OneCameraImplement.isAllowCloseOrStopStreaming(java.lang.String, java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    public boolean isDeviceSupport(UsbDevice usbDevice) {
        int vendorId = usbDevice.getVendorId();
        boolean z = true;
        if (!(vendorId == 16981 || vendorId == 11802 || (usbDevice.getInterfaceCount() > 0 && usbDevice.getInterface(0).getInterfaceClass() == 14))) {
            z = false;
        }
        StringBuilder a2 = a.a("device support ? ");
        a2.append(z ? "yes" : "no");
        a2.append(", vendor id: ");
        a2.append(vendorId);
        a2.append("(");
        a2.append(vendorId);
        a2.append(")");
        String sb = a2.toString();
        String str = "OneCamera";
        Log.i(str, sb);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("device.getInterfaceCount() ");
        sb2.append(usbDevice.getInterfaceCount());
        Log.i(str, sb2.toString());
        if (usbDevice.getInterfaceCount() > 0) {
            StringBuilder a3 = a.a("device.getInterface(0).getInterfaceClass(): ");
            a3.append(usbDevice.getInterface(0).getInterfaceClass());
            Log.i(str, a3.toString());
        }
        return z;
    }

    /* access modifiers changed from: private */
    public boolean isGyroEnable() {
        return this.mVideoParam.enableGyro;
    }

    private void notifyCaptured(int i2, String str, boolean z, TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        Handler handler = this.mHandler;
        final int i3 = i2;
        final String str2 = str;
        final boolean z2 = z;
        final TakePictureWithoutStorageResponse takePictureWithoutStorageResponse2 = takePictureWithoutStorageResponse;
        AnonymousClass2 r1 = new Runnable() {
            public void run() {
                OneCameraImplement.this.onStillImageCaptured(i3, str2, z2, takePictureWithoutStorageResponse2);
            }
        };
        handler.post(r1);
    }

    private void notifyComplete() {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneCameraImplement.this.mCallbacks.onOpenComplete();
            }
        });
    }

    private void notifyError(final int i2) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneCameraImplement.this.mCallbacks.onError(i2, 0, "Camera Error");
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyFps(final int i2) {
        Handler handler = this.mInfoHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    OneCameraImplement.this.mInfoUpdateListener.onRecordFpsUpdate(i2);
                }
            });
        } else {
            this.mInfoUpdateListener.onRecordFpsUpdate(i2);
        }
    }

    /* access modifiers changed from: private */
    public void notifyLivePushStart() {
        if (this.mRecordStatus == RecordStatus.Recording && this.mRecordType == RecordType.ReEncoded) {
            Handler handler = this.mInfoHandler;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        OneCameraImplement.this.mInfoUpdateListener.onLivePushStarted(OneCameraImplement.this.mRecordPath);
                    }
                });
            } else {
                this.mInfoUpdateListener.onLivePushStarted(this.mRecordPath);
            }
        } else {
            StringBuilder a2 = a.a("error notifyLivePushStart mRecordStatus ");
            a2.append(this.mRecordStatus);
            a2.append(" mRecordType ");
            a2.append(this.mRecordType);
            Log.e("OneCamera", a2.toString());
        }
    }

    private void notifyRecordComplete(final RecordType recordType, final String str) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneCameraImplement.this.mCallbacks.onRecordComplete(recordType, str);
            }
        });
    }

    private void notifyRecordError(final int i2, final RecordType recordType, final String str) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                StringBuilder a2 = a.a("notifyRecordError ");
                a2.append(i2);
                a2.append(" recordType ");
                a2.append(recordType);
                a2.append(" path ");
                a2.append(str);
                Log.i("OneCamera", a2.toString());
                OneCameraImplement.this.mCallbacks.onRecordError(i2, recordType, str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyScreenCapture(final int i2, final String str) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneCameraImplement.this.mCallbacks.onScreenCapture(i2, str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyStillImageCaptureResult(final int i2, final String str, final TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                TakePicturewithoutStorageResult takePicturewithoutStorageResult = new TakePicturewithoutStorageResult();
                takePicturewithoutStorageResult.err = i2;
                takePicturewithoutStorageResult.path = str;
                takePicturewithoutStorageResult.mRespone = takePictureWithoutStorageResponse;
                OneCameraImplement.this.mCallbacks.onStillImageCaptured(i2, str);
            }
        });
    }

    private void onDetached() {
        if (this.mOpenState != OpenState.Idle) {
            this.mDetached = true;
            this.mCBHandler.post(new Runnable() {
                public void run() {
                    OneCameraImplement.this.mCallbacks.onDetached();
                }
            });
        }
    }

    private void onDeviceOpenResult(UsbDevice usbDevice, int i2) {
        String str = "OneCamera";
        Log.i(str, "onDeviceOpenResult");
        if (this.mOpenState != OpenState.Opening) {
            StringBuilder a2 = a.a("onDeviceOpenResult, state: ");
            a2.append(this.mOpenState);
            Log.d(str, a2.toString());
        } else if (i2 != 0) {
            this.mOpenState = OpenState.Error;
            if (i2 == -900001) {
                Log.e(str, "onDeviceOpenResult, device permission granted");
                notifyError(-406);
            } else {
                a.c("onDeviceOpenResult: device cannot open: ", i2, str);
                notifyError(-402);
            }
        } else {
            this.mDevice = usbDevice;
            StringBuilder a3 = a.a("2init device: ");
            a3.append(this.mDevice);
            Log.i(str, a3.toString());
            HandlerThread handlerThread = new HandlerThread("OneDriver");
            this.mDriverHandlerThread = handlerThread;
            handlerThread.start();
            this.mDriver = new OneDriver(this.mContext, this.mDriverHandlerThread.getLooper());
            setDriverListener();
            int open = this.mDriver.open(this.mUsbService.getUsbSysPath());
            if (open != 0) {
                this.mOpenState = OpenState.Error;
                a.c("failed init camera: ", open, str);
                notifyError(-403);
                return;
            }
            this.mOpenState = OpenState.OpenComplete;
            notifyComplete();
        }
    }

    private void onError(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onError: ");
        sb.append(i2);
        String str = "OneCamera";
        Log.i(str, sb.toString());
        if (this.mRunningError != 0) {
            Log.i(str, "onError, already in error state");
            return;
        }
        this.mRunningError = i2;
        notifyError(i2);
    }

    /* access modifiers changed from: private */
    public void onRecordComplete() {
        String str = "OneCamera";
        Log.i(str, "onRecordComplete");
        if (this.mRecordStatus != RecordStatus.Stopping) {
            StringBuilder a2 = a.a("received record complete message, status: ");
            a2.append(this.mRecordStatus);
            Log.e(str, a2.toString());
            return;
        }
        this.mRecordStatus = RecordStatus.Idle;
        finishRecordFile();
        notifyRecordComplete(this.mRecordType, this.mRecordPath);
        this.mStopExtraData = null;
        this.mRecordPath = null;
    }

    /* access modifiers changed from: private */
    public void onRecordError(int i2) {
        String str = "OneCamera";
        Log.i(str, "onRecordError");
        if (this.mRecordStatus != RecordStatus.Idle) {
            RecordStatus recordStatus = this.mRecordStatus;
            RecordStatus recordStatus2 = RecordStatus.Error;
            if (recordStatus != recordStatus2) {
                this.mRecordStatus = recordStatus2;
                notifyRecordError(i2, this.mRecordType, this.mRecordPath);
                this.mStopExtraData = null;
                this.mRecordPath = null;
                return;
            }
        }
        StringBuilder a2 = a.a("onRecordError, status: ");
        a2.append(this.mRecordStatus);
        Log.i(str, a2.toString());
    }

    /* access modifiers changed from: private */
    public void onStillImageCaptured(int i2, String str, boolean z, TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("still image captured: ");
        sb.append(i2);
        sb.append(", path: ");
        sb.append(str);
        Log.i("OneCamera", sb.toString());
        if (i2 != 0) {
            notifyStillImageCaptureResult(i2, str, takePictureWithoutStorageResponse);
        } else {
            notifyStillImageCaptureResult(0, str, takePictureWithoutStorageResponse);
        }
    }

    public static RenderWay renderMode2RenderWay(RenderMode renderMode) {
        if (renderMode.type == Type.DirectDecoding) {
            return RenderWay.DirectDecoding;
        }
        return renderMode.renderMethod == RenderMethod.PlanarKeep ? RenderWay.PlanarKeep : RenderWay.DualFishEyeStitchingPlanar;
    }

    private void resetRecordInternal() {
        StringBuilder a2 = a.a("resetRecord mRecordType ");
        a2.append(this.mRecordType);
        a2.append(" mRecordStatus ");
        a2.append(this.mRecordStatus);
        a2.append(" mDetached ");
        a2.append(this.mDetached);
        String str = "OneCamera";
        Log.i(str, a2.toString());
        this.mRecordStatus = RecordStatus.Idle;
        if (this.mRecordType == RecordType.Camera) {
            Log.i(str, "reset camera record empty");
        } else if (this.mICameraPreviewPipeline != null) {
            Log.i(str, "resetRecord while live");
            this.mICameraPreviewPipeline.onStopLive();
        } else {
            this.mImagePipeline.resetRecord();
        }
        this.mStopExtraData = null;
    }

    private void resetTimelpase(StopTimelapse stopTimelapse) {
        this.mRecordStatus = RecordStatus.Idle;
        this.mStopExtraData = null;
    }

    private void setCameraRecord() {
        this.mRecordStatus = RecordStatus.Recording;
        if (this.mRecordType.equals(RecordType.ReEncoded)) {
            Log.e("OneCamera", " camera record when live");
        }
        this.mRecordType = RecordType.Camera;
    }

    private void setDriverListener() {
        this.mDriver.setNotificationListener(new OnNotificationListener() {
            public void onDriverInfoNotify(final int i2, final int i3, final Object obj) {
                OneCameraImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        String str = "OneCamera";
                        if (i3 != 0) {
                            StringBuilder a2 = a.a("onDriverInfoNotify error ");
                            a2.append(i3);
                            a2.append(" what ");
                            a.b(a2, i2, str);
                        }
                        int i2 = i2;
                        if (i2 == 8) {
                            Log.i(str, "RECORD_STOPPED ");
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else if (i2 == 72) {
                            GetCurrentCaptureStatusResp getCurrentCaptureStatusResp = (GetCurrentCaptureStatusResp) obj;
                            if (getCurrentCaptureStatusResp.errorCode == 0) {
                                a.c(a.a("GET_CURRENT_CAPTURE_STATUS state "), getCurrentCaptureStatusResp.status.state, str);
                                OneCameraImplement.this.updateCameraState(getCurrentCaptureStatusResp.status.state);
                            } else {
                                a.b(a.a("error mCaptureStatus.errorCode "), getCurrentCaptureStatusResp.errorCode, str);
                            }
                        } else if (i2 == 77) {
                            OneCameraImplement.this.updateCameraState(((CameraCaptureStatus) obj).state);
                        }
                        if (OneCameraImplement.this.mInfoHandler != null) {
                            OneCameraImplement.this.mInfoHandler.post(new Runnable() {
                                public void run() {
                                    InfoUpdateListener access$500 = OneCameraImplement.this.mInfoUpdateListener;
                                    AnonymousClass1 r1 = AnonymousClass1.this;
                                    access$500.onCameraInfoNotify(i2, i3, obj);
                                }
                            });
                        } else {
                            OneCameraImplement.this.mInfoUpdateListener.onCameraInfoNotify(i2, i3, obj);
                        }
                    }
                });
            }

            public void onDriverRecordVideoStateNotify(final int i2, final VideoResult videoResult) {
                OneCameraImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        int i2 = i2;
                        String str = "OneCamera";
                        if (i2 == 0) {
                            StringBuilder a2 = a.a("STARTED mRecordStatus ");
                            a2.append(OneCameraImplement.this.mRecordStatus);
                            Log.i(str, a2.toString());
                        } else if (i2 == 1) {
                            if (OneCameraImplement.this.mRecordStatus != RecordStatus.Stopping) {
                                StringBuilder a3 = a.a("received record complete message, status: ");
                                a3.append(OneCameraImplement.this.mRecordStatus);
                                Log.e(str, a3.toString());
                            }
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else if (i2 == 2) {
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Error;
                        } else if (i2 == 3) {
                            StringBuilder a4 = a.a("received record cancell, mRecordStatus status: ");
                            a4.append(OneCameraImplement.this.mRecordStatus);
                            Log.e(str, a4.toString());
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else {
                            StringBuilder a5 = a.a("onDriverRecordVideoStateNotify state: ");
                            a5.append(i2);
                            throw new IllegalStateException(a5.toString());
                        }
                        OneCameraImplement.this.mCBHandler.post(new Runnable() {
                            public void run() {
                                OneCallbacks access$700 = OneCameraImplement.this.mCallbacks;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                access$700.onRecordVideoStateNotify(i2, videoResult);
                            }
                        });
                    }
                });
            }

            public void onDriverStillImageNotify(final TakePictureResponse takePictureResponse) {
                OneCameraImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        OneCameraImplement.this.mCallbacks.onStillImageWithStorageNotify(takePictureResponse);
                    }
                });
            }

            public void onDriverStillImageWithoutStorageNotify(final TakePictureWithoutStorageResponse takePictureWithoutStorageResponse) {
                OneCameraImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        String str = "OneCamera";
                        if (takePictureWithoutStorageResponse.status == 0) {
                            a.c(a.a("file_size "), takePictureWithoutStorageResponse.data.length, str);
                            if (OneCameraImplement.this.mStillImageCapturePath != null) {
                                OneCameraImplement.this.mStillImageCapturePath = null;
                            } else {
                                Log.i(str, "cancel or error response");
                            }
                        } else {
                            StringBuilder a2 = a.a("onDriverStillImageWithoutStorageNotify error ");
                            a2.append(takePictureWithoutStorageResponse.status);
                            Log.d(str, a2.toString());
                            OneCameraImplement oneCameraImplement = OneCameraImplement.this;
                            oneCameraImplement.notifyStillImageCaptureResult(takePictureWithoutStorageResponse.status, oneCameraImplement.mStillImageCapturePath, takePictureWithoutStorageResponse);
                        }
                    }
                });
            }

            public void onDriverStreamDataNotify(final StreamData streamData) {
                OneCameraImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        if (OneCameraImplement.this.mStreaming) {
                            String str = "OneCamera";
                            if (OneCameraImplement.this.mDetached) {
                                Log.i(str, "stop reading as camera detached");
                            } else if (OneCameraImplement.this.mRunningError != 0) {
                                Log.i(str, " stop reading as camera met error");
                            } else if (OneCameraImplement.this.mCameraProcess == null) {
                                Log.i(str, " mCameraProcess released");
                            } else {
                                int i2 = streamData.streamType;
                                if (i2 == 48) {
                                    OneCameraImplement.this.mCameraProcess.processGyro(streamData);
                                } else if (i2 != 64) {
                                    switch (i2) {
                                        case 16:
                                            OneCameraImplement.this.mCameraProcess.processAudioFrame(streamData);
                                            break;
                                        case 17:
                                        case 18:
                                            break;
                                        default:
                                            switch (i2) {
                                                case 32:
                                                    if (OneCameraImplement.this.mDualStreaming) {
                                                        Log.e(str, "dual but rec single stream");
                                                    }
                                                    OneCameraImplement.this.mCameraProcess.processVideoFrame(streamData);
                                                    break;
                                                case 33:
                                                    if (!OneCameraImplement.this.mDualStreaming) {
                                                        Log.e(str, "single but rec dual left stream");
                                                    }
                                                    OneCameraImplement.this.mCameraProcess.processVideoFrame(streamData);
                                                    break;
                                                case 34:
                                                    if (!OneCameraImplement.this.mDualStreaming) {
                                                        Log.e(str, "single but rec dual right stream");
                                                    }
                                                    OneCameraImplement.this.mCameraProcess.processSecVideoFrame(streamData);
                                                    break;
                                                default:
                                                    a.b(a.a("error stream type "), streamData.streamType, str);
                                                    break;
                                            }
                                    }
                                } else {
                                    OneCameraImplement.this.mCameraProcess.processExposureTime(streamData);
                                }
                                streamData.data = null;
                            }
                        }
                    }
                });
            }

            public void onDriverTimelapseNotify(final int i2, final VideoResult videoResult) {
                OneCameraImplement.this.mHandler.post(new Runnable() {
                    public void run() {
                        int i2 = i2;
                        String str = "OneCamera";
                        if (i2 == 0) {
                            StringBuilder a2 = a.a("timelapse STARTED mRecordStatus ");
                            a2.append(OneCameraImplement.this.mRecordStatus);
                            Log.i(str, a2.toString());
                        } else if (i2 == 1) {
                            StringBuilder a3 = a.a("timelapse COMPLETE mRecordStatus ");
                            a3.append(OneCameraImplement.this.mRecordStatus);
                            Log.i(str, a3.toString());
                            if (OneCameraImplement.this.mRecordStatus != RecordStatus.Stopping) {
                                StringBuilder a4 = a.a("received record complete message, status: ");
                                a4.append(OneCameraImplement.this.mRecordStatus);
                                Log.w(str, a4.toString());
                                return;
                            }
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else if (i2 == 2) {
                            OneCameraImplement.this.mRecordStatus = RecordStatus.TimelapseError;
                        } else if (i2 == 3) {
                            StringBuilder a5 = a.a("received cancelled, record status: ");
                            a5.append(OneCameraImplement.this.mRecordStatus);
                            Log.e(str, a5.toString());
                            OneCameraImplement.this.mRecordStatus = RecordStatus.Idle;
                        } else {
                            StringBuilder a6 = a.a("onDriverRecordVideoStateNotify state: ");
                            a6.append(i2);
                            throw new IllegalStateException(a6.toString());
                        }
                        OneCameraImplement.this.mCBHandler.post(new Runnable() {
                            public void run() {
                                OneCallbacks access$700 = OneCameraImplement.this.mCallbacks;
                                AnonymousClass6 r1 = AnonymousClass6.this;
                                access$700.onTimelapseNotify(i2, videoResult);
                            }
                        });
                    }
                });
                OneCameraImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        if (videoResult.error_code != 0) {
                            StringBuilder a2 = a.a("handleDriverTimelapseNotify error code ");
                            a2.append(videoResult.error_code);
                            a2.append(" state ");
                            a.b(a2, i2, "OneCamera");
                        }
                        OneCameraImplement.this.mCallbacks.onTimelapseNotify(i2, videoResult);
                    }
                });
            }

            public void onDriverUsbState(final int i2, final int i3) {
                OneCameraImplement.this.mCBHandler.post(new Runnable() {
                    public void run() {
                        StringBuilder a2 = a.a("onDriverUsbState ");
                        a2.append(i2);
                        a2.append(" err ");
                        a2.append(i3);
                        Log.d("OneCamera", a2.toString());
                        OneCameraImplement.this.mCallbacks.onUsbState(i2, i3);
                    }
                });
            }
        });
    }

    private void stopCaptureWithStorage(byte[] bArr) {
        this.mDriver.stopRecordWithCameraStorage(0, bArr);
    }

    private long stopStreamInternal() {
        long j2;
        StringBuilder a2 = a.a("set mCameraProcess to null: ");
        a2.append(this.mCameraProcess.hashCode());
        a2.append("(OneCamera:");
        a2.append(hashCode());
        a2.append(")");
        String str = "OneCamera";
        Log.i(str, a2.toString());
        this.mCameraProcess.release();
        this.mCameraProcess = null;
        this.mImagePipeline.close();
        if (!this.mDetached) {
            j2 = this.mDriver.stopStreaming();
        } else {
            Log.i(str, " stop streaming when detached ");
            j2 = 0;
        }
        this.mStreaming = false;
        this.mAudioExtradata = null;
        Log.i(str, "stop streaming suc");
        return j2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        r2.mRecordStatus = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Idle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        setCameraRecord();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateCameraState(int r3) {
        /*
            r2 = this;
            java.lang.String r0 = "updateCameraState  "
            java.lang.String r1 = " org state "
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0, r3, r1)
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r1 = r2.mRecordStatus
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "OneCamera"
            android.util.Log.i(r1, r0)
            r0 = 100
            if (r3 == r0) goto L_0x002f
            switch(r3) {
                case 0: goto L_0x002f;
                case 1: goto L_0x002b;
                case 2: goto L_0x002b;
                case 3: goto L_0x002b;
                case 4: goto L_0x0026;
                case 5: goto L_0x0026;
                case 6: goto L_0x0026;
                case 7: goto L_0x002b;
                default: goto L_0x001d;
            }
        L_0x001d:
            switch(r3) {
                case 9: goto L_0x002b;
                case 10: goto L_0x0026;
                case 11: goto L_0x0026;
                case 12: goto L_0x002b;
                default: goto L_0x0020;
            }
        L_0x0020:
            java.lang.String r3 = " settings_new_value"
            android.util.Log.i(r1, r3)
            goto L_0x0033
        L_0x0026:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r3 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Idle
            r2.mRecordStatus = r3
            goto L_0x0033
        L_0x002b:
            r2.setCameraRecord()
            goto L_0x0033
        L_0x002f:
            com.arashivision.onecamera.OneCameraImplement$RecordStatus r3 = com.arashivision.onecamera.OneCameraImplement.RecordStatus.Idle
            r2.mRecordStatus = r3
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onecamera.OneCameraImplement.updateCameraState(int):void");
    }

    private void writeFileExtraWithoutStorage() {
    }

    public long calibrateGyro(CalibrateGyro calibrateGyro) {
        checkOpenComplete("calibrateGyro");
        return this.mDriver.calibrateGyro(calibrateGyro);
    }

    public long cancelAuthorization() {
        checkOpenComplete("cancelAuthorization");
        return this.mDriver.cancelAuthorization();
    }

    public void captureStillImage(TakePicture takePicture) {
        StringBuilder a2 = a.a("captureStillImage status ");
        a2.append(this.mRecordStatus);
        Log.i("OneCamera", a2.toString());
        if (this.mStreaming || !this.mSupportStreaming) {
            checkRecordIdle("captureStillImage");
            this.mDriver.captureStillImage(takePicture);
            return;
        }
        throw new IllegalStateException("streaming is not on");
    }

    public void captureStillImageWithouStorage(String str, boolean z, TakePicture takePicture) {
        StringBuilder a2 = a.a("captureStillImageWithouStorage mRecordStatus ");
        a2.append(this.mRecordStatus);
        Log.i("OneCamera", a2.toString());
        if (this.mStreaming || !this.mSupportStreaming) {
            checkRecordIdle("captureStillImageWithouStorage");
            this.mStillImageCapturePath = str;
            this.mStitchingImage = z;
            this.mDriver.captureStillImageWithouStorage(takePicture);
            return;
        }
        throw new IllegalStateException("streaming is not on");
    }

    public long checkAuthorization(CheckAuthorization checkAuthorization) {
        checkOpenComplete("checkAuthorization");
        return this.mDriver.checkAuthorization(checkAuthorization.uniqueId);
    }

    public void close(Object obj) {
        String str = LivenessStat.TYPE_VOICE_CLOSE;
        Log.i("OneCamera", str);
        isAllowCloseOrStopStreaming(str, obj);
        closeInternal();
    }

    public long closeCameraOled() {
        checkOpenComplete("closeCameraOled");
        return this.mDriver.closeCameraOled();
    }

    public long closeCameraWifi() {
        checkOpenComplete("closeCameraWifi");
        return this.mDriver.closeCameraWifi();
    }

    public long closeIperf() {
        checkOpenComplete("closeIperf");
        return this.mDriver.closeIperf();
    }

    public long connectBT(ConnectToBTPeripheral connectToBTPeripheral) {
        checkOpenComplete("connectBT");
        return this.mDriver.connectBT(connectToBTPeripheral);
    }

    public long deleteFileList(DeleteFiles deleteFiles) {
        checkOpenComplete("deleteFileList");
        return this.mDriver.deleteFiles(deleteFiles);
    }

    public long disConnectBT(DisconnectBTPeripheral disconnectBTPeripheral) {
        checkOpenComplete("disConnectBT");
        return this.mDriver.disConnectBT(disconnectBTPeripheral);
    }

    public long eraseSDCard() {
        checkOpenComplete("eraseSDCard");
        return this.mDriver.eraseSDCard();
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public void fixSomething() {
        fixCameraAndMobileTime();
    }

    public boolean getAVExtraData(StartCaptureWithoutStorage startCaptureWithoutStorage) {
        synchronized (this.mSyncExtraData) {
            if (startCaptureWithoutStorage.mRecordType != RecordType.ReEncoded) {
                StringBuilder sb = new StringBuilder();
                sb.append("mReq.mRecordType: ");
                sb.append(startCaptureWithoutStorage.mRecordType);
                throw new IllegalStateException(sb.toString());
            }
        }
        return true;
    }

    public Options getAllOptions() {
        checkOpenComplete("getAllOptions");
        return this.mDriver.getAllOptions();
    }

    public long getAllOptionsAsync() {
        checkOpenComplete("getAllOptionsAsync");
        return this.mDriver.getAllOptionsAsync();
    }

    public long getCaptureStatus() {
        checkOpenComplete("startStreaming");
        return this.mDriver.getCaptureStatus();
    }

    public long getConnectBT(GetConnectedBTPeripheral getConnectedBTPeripheral) {
        checkOpenComplete("getConnectBT");
        return this.mDriver.getConnectBT(getConnectedBTPeripheral);
    }

    public float[] getCurrentGyroMatrix() {
        return null;
    }

    public long getFileExtra(GetFileExtra getFileExtra) {
        checkOpenComplete("getFileExtra");
        return this.mDriver.getFileExtra(getFileExtra);
    }

    public long getFileInfoList() {
        checkOpenComplete("getFileInfoList");
        return this.mDriver.getFileInfoList();
    }

    public long getFileList(GetFileList getFileList) {
        checkOpenComplete("getFileList");
        return this.mDriver.getFileList(getFileList);
    }

    public GetGyroResp getGyro(GetGyro getGyro) {
        checkOpenComplete("getGyro");
        return this.mDriver.getGyro(getGyro);
    }

    public long getGyroAsync(GetGyro getGyro) {
        checkOpenComplete("getGyroAsync");
        return this.mDriver.getGyroAsync(getGyro);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public ICameraPreviewPipeline getICameraPreviewPipeline() {
        return this.mICameraPreviewPipeline;
    }

    public long getIperfAverage() {
        checkOpenComplete("getIperfAverage");
        return this.mDriver.getIperfAverage();
    }

    public OneLatestIDR getLatestIDRFrame() {
        OneStreamPipeline oneStreamPipeline = this.mImagePipeline;
        if (oneStreamPipeline != null) {
            return oneStreamPipeline.getLatestIDRFrame();
        }
        return null;
    }

    public Options getOptions(List<String> list) {
        checkOpenComplete("getOptions");
        return this.mDriver.getOptions(list);
    }

    public long getOptionsAsync(List<String> list) {
        checkOpenComplete("getOptionsAsync");
        return this.mDriver.getOptionsAsync(list);
    }

    public PhotoOptions getPhotoOptions(int i2) {
        checkOpenComplete("getPhotoOptions");
        return this.mDriver.getPhotographyOptions(i2, null);
    }

    public long getPhotoOptionsAsync(int i2) {
        checkOpenComplete("getPhotoOptionsAsync");
        return this.mDriver.getPhotographyOptionsAsync(i2, null);
    }

    public int getPreviewFps() {
        return this.mVideoParam.fps;
    }

    public int getPreviewHeight() {
        return this.mVideoParam.height;
    }

    public int getPreviewWidth() {
        return this.mDualStreaming ? this.mVideoParam.width / 2 : this.mVideoParam.width;
    }

    public OpenState getStatus() {
        return this.mOpenState;
    }

    public Object getSurface() {
        StringBuilder a2 = a.a("get surface: ");
        a2.append(this.mSurface);
        Log.i("OneCamera", a2.toString());
        return this.mSurface;
    }

    public Object getSurface2() {
        StringBuilder a2 = a.a("get surface2: ");
        a2.append(this.mSurface2);
        Log.i("OneCamera", a2.toString());
        return this.mSurface2;
    }

    public long getSyncCaptureMode() {
        checkOpenComplete("getSyncCaptureMode");
        return this.mDriver.getSyncCaptureMode();
    }

    public TimelapseOptionsInfo getTimelapseOption(GetTimelapseOptions getTimelapseOptions) {
        checkOpenComplete("getTimelapseOption");
        return this.mDriver.getTimelapseOptions(getTimelapseOptions);
    }

    public long getTimelapseOptionAsync(GetTimelapseOptions getTimelapseOptions) {
        checkOpenComplete("getTimelapseOptionAsync");
        return this.mDriver.getTimelapseOptionsAsync(getTimelapseOptions);
    }

    public int getTunelPort() {
        checkOpenComplete("getTunelPort");
        return this.mDriver.getTunelPort();
    }

    public void initAudioParam() {
        AudioParam audioParam = new AudioParam();
        this.mAudioParam = audioParam;
        audioParam.enable = true;
        audioParam.bitrate = 128000;
        audioParam.codec = 1;
        audioParam.sampleRate = AUDIO_SAMPLE_RATE_DEF;
    }

    public void initVideoParam() {
        VideoParam videoParam = new VideoParam();
        this.mVideoParam = videoParam;
        videoParam.width = 3840;
        videoParam.height = WBConstants.SDK_NEW_PAY_VERSION;
        videoParam.fps = 30;
        videoParam.enableGyro = true;
        videoParam.bitrate = 40;
    }

    public boolean isNoncancelableTaskRunning() {
        StringBuilder a2 = a.a("isNoncancelableTaskRunning mRecordStatus is ");
        a2.append(this.mRecordStatus);
        String str = "OneCamera";
        Log.d(str, a2.toString());
        if (this.mRecordStatus != RecordStatus.Stopping) {
            return false;
        }
        if (this.mRecordType != RecordType.Camera || !this.mDetached) {
            return true;
        }
        Log.i(str, "met Stopping with camera when detach");
        return false;
    }

    public void onDeviceDetached(UsbDevice usbDevice, DeviceFilter deviceFilter) {
        onDetached();
    }

    public void onDeviceOpenComplete(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, DeviceFilter deviceFilter, int i2) {
        onDeviceOpenResult(usbDevice, i2);
    }

    public void onPipelineError(OneStreamPipeline oneStreamPipeline, int i2, int i3, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPipelineError: ");
        sb.append(oneStreamPipeline);
        sb.append(", error: ");
        sb.append(i2);
        Log.e("OneCamera", sb.toString());
        onError(i2);
    }

    public void onPipelineImageCaptured(OneStreamPipeline oneStreamPipeline, int i2, int i3, int i4, final String str) {
        this.mCBHandler.post(new Runnable() {
            public void run() {
                OneCameraImplement.this.mCallbacks.onPhotoCaptured(0, str);
            }
        });
    }

    public void onPipelineInfo(int i2, int i3, Object obj) {
    }

    public void onPipelineRecordComplete(OneStreamPipeline oneStreamPipeline) {
        onRecordComplete();
    }

    public void onPipelineRecordError(OneStreamPipeline oneStreamPipeline, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPipelineRecordError: ");
        sb.append(oneStreamPipeline);
        sb.append(", error: ");
        sb.append(i2);
        Log.e("OneCamera", sb.toString());
        onRecordError(i2);
    }

    public void open(String str) {
        if (this.mOpenState == OpenState.Idle) {
            this.mOpenState = OpenState.Opening;
            this.mOffset = str;
            AppUsbService appUsbService = new AppUsbService(this.mContext);
            this.mUsbService = appUsbService;
            UsbDevice device = appUsbService.getDevice(this.mDeviceFilter);
            if (device == null) {
                Log.e("OneCamera", "no device found");
                this.mOpenState = OpenState.Error;
                notifyError(-401);
                return;
            }
            this.mUsbService.addObserver(this.mDeviceFilter, this);
            this.mDevice = device;
            this.mUsbService.openDevice(device);
            return;
        }
        StringBuilder a2 = a.a("open camera in state: ");
        a2.append(this.mOpenState);
        throw new IllegalStateException(a2.toString());
    }

    public long openCameraOled() {
        checkOpenComplete("openCameraOled");
        return this.mDriver.openCameraOled();
    }

    public long openCameraWifi() {
        checkOpenComplete("openCameraWifi");
        return this.mDriver.openCameraWifi();
    }

    public long openIperf(int i2) {
        checkOpenComplete("openIperf");
        return this.mDriver.openIperf(i2);
    }

    public void openWifi(String str, int i2, String str2, short s) {
        this.mOffset = str;
        HandlerThread handlerThread = new HandlerThread("OneDriver");
        this.mDriverHandlerThread = handlerThread;
        handlerThread.start();
        this.mDriver = new OneDriver(this.mContext, this.mDriverHandlerThread.getLooper());
        setDriverListener();
        int openWifi = this.mDriver.openWifi(i2, str2, s);
        if (openWifi != 0) {
            this.mOpenState = OpenState.Error;
            a.c("failed init wifi: ", openWifi, "OneCamera");
            notifyError(Error.ERR_INITWIFI);
            return;
        }
        this.mOpenState = OpenState.OpenComplete;
        notifyComplete();
    }

    public long reboot() {
        checkOpenComplete("reboot");
        return this.mDriver.reboot();
    }

    public void release() {
        String str = "OneCamera";
        Log.i(str, "release");
        if (this.mOpenState != OpenState.Idle) {
            Log.w(str, "release with camera open");
            close(null);
        }
        OneStreamPipeline oneStreamPipeline = this.mImagePipeline;
        if (oneStreamPipeline != null) {
            oneStreamPipeline.release();
            this.mImagePipeline = null;
        }
        this.mReleased = true;
    }

    public void resetRecord(Object obj) {
        if (this.mRecordStatus == RecordStatus.TimelapseError) {
            resetTimelpase((StopTimelapse) obj);
        } else if (this.mRecordStatus == RecordStatus.Idle) {
            StringBuilder a2 = a.a("resetRecord when record idle mRecordType ");
            a2.append(this.mRecordType);
            a2.append(" mDetached ");
            a2.append(this.mDetached);
            Log.i("OneCamera", a2.toString());
        } else {
            if (this.mRecordStatus != RecordStatus.Error) {
                StringBuilder a3 = a.a("resetRecord record status ");
                a3.append(this.mRecordStatus);
                new IllegalStateException(a3.toString());
            }
            resetRecordInternal();
        }
    }

    public long scanBT(ScanBTPeripheral scanBTPeripheral) {
        checkOpenComplete("scanBT");
        return this.mDriver.scanBT(scanBTPeripheral);
    }

    public void sendHeartBeat() {
        checkOpenComplete("sendHeartBeat");
        this.mDriver.sendHeartBeat();
    }

    public void setAudioParam(boolean z, int i2, int i3, int i4) {
        if (i2 == 0) {
            this.mAudioParam.sampleRate = AUDIO_SAMPLE_RATE_DEF;
        }
        this.mAudioParam.enable = z;
        if (i4 != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(" audio not adts ");
            sb.append(i4);
            Log.w("OneCamera", sb.toString());
        }
        if (i3 == 0) {
            this.mAudioParam.bitrate = 128000;
        }
        this.mAudioParam.codec = i4;
    }

    public void setAudioSource(AudioSource audioSource) {
        this.mAudioSource = audioSource;
        if (audioSource == AudioSource.AUDIO_MOBILE) {
            this.mAudioParam.enable = false;
        } else if (audioSource == AudioSource.AUDIO_CAMERA) {
            this.mAudioParam.enable = true;
        } else {
            this.mAudioParam.enable = false;
        }
    }

    public void setCameraDevMode(boolean z) {
        TRACE = z;
    }

    public long setFileExtra(SetFileExtra setFileExtra) {
        checkOpenComplete("setFileExtra");
        return this.mDriver.setFileExtra(setFileExtra);
    }

    public long setGPSData(byte[] bArr) {
        checkOpenComplete("setGPSData");
        return this.mDriver.setGPSData(bArr);
    }

    public void setGyroRebaseMatrix(float[] fArr) {
    }

    public void setInfoUpdateListener(Handler handler, InfoUpdateListener infoUpdateListener) {
        this.mInfoHandler = handler;
        this.mInfoUpdateListener = infoUpdateListener;
    }

    public int setOptions(Options options) {
        checkOpenComplete("setOptions");
        return this.mDriver.setOptions(options);
    }

    public long setOptionsAsync(Options options) {
        checkOpenComplete("setOptionsAsync");
        return this.mDriver.setOptionsAsync(options);
    }

    public long setPhotoOptions(int i2, PhotoOptions photoOptions) {
        checkOpenComplete("setPhotoOptions");
        return this.mDriver.setPhotographyOptions(i2, photoOptions);
    }

    public long setPhotoOptionsAsync(int i2, PhotoOptions photoOptions) {
        checkOpenComplete("setPhotoOptionsAsync");
        return this.mDriver.setPhotographyOptionsAsync(i2, photoOptions);
    }

    public void setPipeline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        StringBuilder sb = new StringBuilder();
        sb.append(" set camera pipeline ");
        sb.append(iCameraPreviewPipeline);
        String str = "OneCamera";
        Log.i(str, sb.toString());
        if (!(iCameraPreviewPipeline == null || this.mICameraPreviewPipeline == null)) {
            Log.e(str, "setPipline meet pipline not null ");
        }
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
    }

    public void setPlayerBackend(PlayerBackend playerBackend) {
        StringBuilder sb = new StringBuilder();
        sb.append("set playerBackend ");
        sb.append(playerBackend);
        Log.i("OneCamera", sb.toString());
        this.mImagePipeline.setPlayerBackend(playerBackend);
    }

    public void setPreviewDeltaNs(long j2) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onUpdatePreviewDelta(j2);
        } else {
            this.mImagePipeline.setPreviewDeltaNs(j2);
        }
    }

    public void setSupportStreaming(boolean z) {
        checkOpenComplete("setSupportStreaming");
        this.mSupportStreaming = z;
        this.mDriver.setSupportStreaming(z);
    }

    public void setSurface(Object obj) {
        setSurface(obj, null);
    }

    public long setSyncCaptureMode(int i2) {
        checkOpenComplete("setSyncCaptureMode");
        return this.mDriver.setSyncCaptureMode(i2);
    }

    public long setSyncStandByMode(int i2) {
        checkOpenComplete("setSyncStandByMode");
        return this.mDriver.setStandbyMode(i2);
    }

    public int setTimelapseOption(SetTimelapseOptions setTimelapseOptions) {
        checkOpenComplete("setTimelapseOption");
        return this.mDriver.setTimelapseOptions(setTimelapseOptions);
    }

    public long setTimelapseOptionAsync(SetTimelapseOptions setTimelapseOptions) {
        checkOpenComplete("setTimelapseOptionAsync");
        return this.mDriver.setTimelapseOptionsASync(setTimelapseOptions);
    }

    public void setVideoParam(int i2, int i3, int i4, int i5, boolean z) {
        VideoParam videoParam = this.mVideoParam;
        videoParam.width = i2;
        videoParam.height = i3;
        videoParam.bitrate = i5;
        videoParam.fps = i4;
        videoParam.enableGyro = z;
    }

    public long startBluetoothStatusTest() {
        checkOpenComplete("startBluetoothStatusTest");
        return this.mDriver.startBluetoothStatusTest();
    }

    public int startBulletTime() {
        StringBuilder a2 = a.a("startCaptureWithStorage mRecordStatus ");
        a2.append(this.mRecordStatus);
        Log.d("OneCamera", a2.toString());
        if (this.mStreaming || !this.mSupportStreaming) {
            this.mRecordStatus = RecordStatus.Recording;
            this.mRecordType = RecordType.Camera;
            this.mRecordPath = null;
            return this.mDriver.startBulletTime();
        }
        throw new IllegalStateException("streaming is not on");
    }

    public int startCaptureWithStorage() {
        StringBuilder a2 = a.a("startCaptureWithStorage mRecordStatus ");
        a2.append(this.mRecordStatus);
        Log.d("OneCamera", a2.toString());
        if (this.mStreaming || !this.mSupportStreaming) {
            this.mRecordStatus = RecordStatus.Recording;
            this.mRecordType = RecordType.Camera;
            this.mRecordPath = null;
            return this.mDriver.startRecordWithCameraStorage(0);
        }
        throw new IllegalStateException("streaming is not on");
    }

    public void startCaptureWithoutStorage(StartCaptureWithoutStorage startCaptureWithoutStorage) {
        if (this.mStreaming || !this.mSupportStreaming) {
            RecordType recordType = startCaptureWithoutStorage.mRecordType;
            this.mRecordType = recordType;
            if (recordType == RecordType.ReEncoded) {
                RecordParam recordParam = new RecordParam();
                int i2 = startCaptureWithoutStorage.width;
                String str = ")";
                String str2 = ") to (";
                String str3 = "OneCamera";
                if (i2 % 16 != 0) {
                    int i3 = ((i2 / 16) + 1) * 16;
                    StringBuilder a2 = a.a(" change live width from (");
                    a2.append(startCaptureWithoutStorage.width);
                    a2.append(str2);
                    a2.append(i3);
                    a2.append(str);
                    Log.e(str3, a2.toString());
                    startCaptureWithoutStorage.width = i3;
                }
                int i4 = startCaptureWithoutStorage.height;
                if (i4 % 2 != 0) {
                    int i5 = ((i4 / 2) + 1) * 2;
                    StringBuilder a3 = a.a(" change live height from (");
                    a3.append(startCaptureWithoutStorage.height);
                    a3.append(str2);
                    a3.append(i5);
                    a3.append(str);
                    Log.e(str3, a3.toString());
                    startCaptureWithoutStorage.height = i5;
                }
                if (this.mICameraPreviewPipeline != null) {
                    AudioParam audioParam = this.mAudioParam;
                    recordParam.setAudioParam(false, 1, audioParam.sampleRate, audioParam.bitrate, null);
                    Log.i(str3, " onStartLive ");
                    this.mICameraPreviewPipeline.onStartLive(recordParam, new ICameraLivePipline() {
                        public void onCameraLiveNotify(int i2, int i3, int i4, String str, String str2) {
                            a.c(a.a("onCameraLiveNotify notifyType ", i2, " value ", i3, " extra "), i4, "OneCamera");
                            if (i2 == -100) {
                                OneCameraImplement.this.onRecordError(i3);
                            } else if (i2 == 100) {
                                OneCameraImplement.this.notifyFps(i3);
                            } else if (i2 == 200) {
                                OneCameraImplement.this.notifyLivePushStart();
                            }
                        }

                        public void onCameraLiveStop() {
                            Log.i("OneCamera", "onCameraLiveStop");
                            OneCameraImplement.this.onRecordComplete();
                        }
                    });
                } else {
                    if (AudioSource.AUDIO_MOBILE == this.mAudioSource) {
                        AudioParam audioParam2 = this.mAudioParam;
                        recordParam.setAudioParam(false, 1, audioParam2.sampleRate, audioParam2.bitrate, null);
                    } else if (this.mAudioExtradata != null) {
                        AudioParam audioParam3 = this.mAudioParam;
                        recordParam.setAudioParam(true, 1, audioParam3.sampleRate, audioParam3.bitrate, this.mAudioExtradata);
                    }
                    Log.i(str3, " startRecordVideo ");
                    this.mImagePipeline.startRecordVideo(recordParam);
                }
                this.mRecordStatus = RecordStatus.Recording;
                this.mRecordPath = startCaptureWithoutStorage.path;
                return;
            }
            StringBuilder a4 = a.a("mRecordType: ");
            a4.append(this.mRecordType);
            throw new IllegalStateException(a4.toString());
        }
        throw new IllegalStateException("streaming is not on");
    }

    public void startHdrCapture() {
        StringBuilder a2 = a.a("startHdrCapture mRecordStatus ");
        a2.append(this.mRecordStatus);
        a2.append(" mStreaming ");
        a2.append(this.mStreaming);
        Log.d("OneCamera", a2.toString());
        this.mRecordStatus = RecordStatus.Recording;
        this.mRecordType = RecordType.Camera;
        this.mRecordPath = null;
        this.mDriver.startHdrCapture();
    }

    public long startLedTest() {
        checkOpenComplete("startLedTest");
        return this.mDriver.startLedTest();
    }

    public void startScreenCapture(int i2, int i3, String str) {
        if (this.mStreaming || !this.mSupportStreaming) {
            ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
            if (iCameraPreviewPipeline != null) {
                iCameraPreviewPipeline.onScreenCapture(i2, i3, str, new ICameraPreviewScreenCaptureCallback() {
                    public void onCameraPreviewScreenCaptureNotify(int i2, String str) {
                        OneCameraImplement.this.notifyScreenCapture(i2, str);
                    }
                });
                return;
            }
            Log.e("OneCamera", "mICameraPreviewPipeline null?");
            notifyScreenCapture(-10, str);
            return;
        }
        throw new IllegalStateException("startScreenCapture but streaming is not on");
    }

    public long startSpeakerTest() {
        checkOpenComplete("startSpeakerTest");
        return this.mDriver.startSpeakerTest();
    }

    public long startStreaming(StartStreamingParam startStreamingParam) {
        checkOpenComplete("startStreaming");
        this.mVideoParam = null;
        int previewNum = startStreamingParam.getPreviewNum();
        if (previewNum == 0) {
            this.mVideoParam = startStreamingParam.getFirstVideoParam();
        } else if (previewNum == 1) {
            this.mVideoParam = startStreamingParam.getSecVideoParam();
        } else {
            StringBuilder a2 = a.a("error param.getPreviewNum() ");
            a2.append(startStreamingParam.getPreviewNum());
            throw new IllegalArgumentException(a2.toString());
        }
        this.mWriteH264 = startStreamingParam.isRecordOriginH264();
        this.mDualStreaming = startStreamingParam.isDualStream();
        GyroType gyroType = startStreamingParam.getGyroType();
        StringBuilder sb = new StringBuilder();
        sb.append(" start streaming gyroType ");
        sb.append(gyroType);
        sb.append(" dual ");
        sb.append(startStreamingParam.isDualStream());
        sb.append(" first ");
        sb.append(startStreamingParam.getFirstVideoParam().toString());
        sb.append(" sec ");
        sb.append(startStreamingParam.getSecVideoParam().toString());
        sb.append(" previewNum ");
        sb.append(startStreamingParam.getPreviewNum());
        sb.append(" zdirectional ");
        sb.append(startStreamingParam.isDiretionalZ());
        sb.append(" mWriteH264 ");
        sb.append(this.mWriteH264);
        String str = "OneCamera";
        Log.i(str, sb.toString());
        AudioParam audioParam = startStreamingParam.getAudioParam();
        this.mAudioParam = audioParam;
        if (audioParam.enable && audioParam.codec != 1) {
            a.b(a.a("error streaming audio codec "), this.mAudioParam.codec, str);
        }
        OneStreamPipeline oneStreamPipeline = this.mImagePipeline;
        VideoParam videoParam = this.mVideoParam;
        oneStreamPipeline.setInputWideoResolution(videoParam.width, videoParam.height);
        this.mImagePipeline.setInputFps((double) this.mVideoParam.fps);
        if (isGyroEnable()) {
            this.mImagePipeline.setGyroType(gyroType, this.mGyroRebaseMatrix, this.mWithoutYawRotation);
        } else {
            Log.i(str, "gyro disable");
        }
        Object obj = this.mSurface;
        if (obj != null) {
            this.mImagePipeline.setSurface(obj);
        }
        StringBuilder a3 = a.a("open image pipeline mOffset ");
        a3.append(this.mOffset);
        Log.i(str, a3.toString());
        this.mImagePipeline.open(this.mOffset);
        long startStreaming = this.mDriver.startStreaming(startStreamingParam.getFirstVideoParam(), startStreamingParam.getSecVideoParam(), startStreamingParam.getAudioParam(), startStreamingParam.getPreviewNum());
        this.mStreaming = true;
        return startStreaming;
    }

    public void startTimeplapse(StartTimelapse startTimelapse) {
        this.mRecordStatus = RecordStatus.Recording;
        this.mRecordType = RecordType.Camera;
        this.mRecordPath = null;
        this.mDriver.startTimeplapse(startTimelapse);
    }

    public long startWifiStatusTest() {
        checkOpenComplete("startWifiStatusTest");
        return this.mDriver.startWifiStatusTest();
    }

    public void stopBulletTime(byte[] bArr) {
        String str = "OneCamera";
        if (this.mRecordStatus == RecordStatus.Error) {
            Log.w(str, "stop record won't run as recorder is already met error,need call reset in app");
            return;
        }
        checkRecord("stopBulletTime");
        this.mRecordStatus = RecordStatus.Stopping;
        if (!this.mDetached) {
            this.mDriver.stopBulletTime(bArr);
        } else {
            Log.w(str, "stopBulletTime when detached");
        }
    }

    public void stopHdrCapture(byte[] bArr) {
        String str = "OneCamera";
        if (this.mRecordStatus == RecordStatus.Error) {
            Log.w(str, "stop hdr won't run as recorder is already met error,need call reset in app");
            return;
        }
        checkRecord("stopHdrCapture");
        this.mRecordStatus = RecordStatus.Stopping;
        if (!this.mDetached) {
            this.mDriver.stopHdrCapture(bArr);
        } else {
            Log.w(str, "stopHdrCapture when detached");
        }
    }

    public void stopRecord(byte[] bArr) {
        String str = "OneCamera";
        if (this.mRecordStatus == RecordStatus.Error) {
            Log.w(str, "stop record won't run as recorder is already met error,need call reset in app");
            return;
        }
        checkRecord("stopRecord");
        this.mRecordStatus = RecordStatus.Stopping;
        if (this.mRecordType != RecordType.Camera) {
            ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
            if (iCameraPreviewPipeline != null) {
                iCameraPreviewPipeline.onStopLive();
            } else {
                Log.i(str, "stop image pipeline recorder");
                this.mImagePipeline.stopRecordVideo();
            }
        } else if (!this.mDetached) {
            stopCaptureWithStorage(bArr);
        } else {
            Log.w(str, "rec stop record with storage when detached");
        }
    }

    public long stopStreaming(Object obj) {
        StringBuilder a2 = a.a("stop streaming mDetached ");
        a2.append(this.mDetached);
        Log.i("OneCamera", a2.toString());
        isAllowCloseOrStopStreaming("stopStreaming", obj);
        if (this.mStreaming || !this.mSupportStreaming) {
            return stopStreamInternal();
        }
        throw new IllegalStateException("stopStreaming streaming is not on");
    }

    public void stopTimeplapse(StopTimelapse stopTimelapse) {
        if (this.mRecordStatus == RecordStatus.TimelapseError) {
            Log.w("OneCamera", "stopTimeplapse won't run as recorder is already met error,need call reset in app");
            return;
        }
        checkRecord("stopTimeplapse");
        this.mDriver.stopTimeplapse(stopTimelapse);
        this.mRecordStatus = RecordStatus.Stopping;
    }

    public void suggestApplyGyroStabilizer(boolean z, boolean z2) {
        StringBuilder a2 = a.a("apply gyro stabilizer? ");
        a2.append(z ? "yes" : "no");
        a2.append(", without yaw rotation: ");
        a2.append(z2);
        Log.i("OneCamera", a2.toString());
    }

    public void switchRenderMode(RenderMode renderMode) {
    }

    public long syncCaptureStatus() {
        checkOpenComplete("syncCaptureStatus");
        return this.mDriver.resumeInitialState();
    }

    public void takePhoto(int i2, int i3, String str) {
    }

    public long testSDCardSpeed(TestSDCardSpeed testSDCardSpeed) {
        checkOpenComplete("testSDCardSpeed");
        return this.mDriver.testSDCardSpeed(testSDCardSpeed);
    }

    public void updatePanoOffset(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("update pano offset: ");
        sb.append(str);
        Log.i("OneCamera", sb.toString());
        if (this.mStreaming) {
            this.mImagePipeline.updatePanoOffset(str);
        }
        this.mOffset = str;
    }

    public void setSurface(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append("set surface: ");
        sb.append(obj);
        sb.append(" surface2 ");
        sb.append(obj2);
        Log.i("OneCamera", sb.toString());
        this.mSurface = obj;
        this.mSurface2 = obj2;
        this.mICameraPreviewPipeline = null;
        this.mImagePipeline.setSurface(obj);
    }

    public PhotoOptions getPhotoOptions(int i2, List<String> list) {
        checkOpenComplete("getPhotoOptions");
        return this.mDriver.getPhotographyOptions(i2, list);
    }

    public long getPhotoOptionsAsync(int i2, List<String> list) {
        checkOpenComplete("getPhotoOptionsAsync");
        return this.mDriver.getPhotographyOptionsAsync(i2, list);
    }
}
