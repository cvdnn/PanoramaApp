package com.arashivision.camera.stream;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import com.arashivision.camera.strategy.TraceUtil;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.OneDriver.OnStreamListener;
import com.arashivision.onecamera.StartStreamingParam;
import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onecamera.cameraresponse.StreamData;
import com.arashivision.onecamera.util.H2645Parser;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onecamera.util.H2645Parser.SPSCallback;
import com.arashivision.onecamera.util.H264Parser;
import com.arashivision.onecamera.util.H265Parser;
import com.arashivision.onestream.AbstractPlayer.StreamExposureInfo;
import com.arashivision.onestream.AudioData;
import com.arashivision.onestream.Gyro.OneGyroField;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class StreamProcess implements OnStreamListener {
    public static final String TAG = "com.arashivision.camera.stream.StreamProcess";
    public int codec;
    public long frameCount = 0;
    public volatile byte[] mAudioExtradata;
    public AudioParam mAudioParam;
    public Context mContext;
    public File mFileH264;
    public boolean mGyroStabilizerApplied;
    public boolean mH265;
    public Handler mHandler;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public H2645Frame mLastFrame;
    public H2645Frame mLastFrameR;
    public long mLastOrgFrameTsMs = -1;
    public long mLastOrgFrameTsMsR = -1;
    public H2645Parser mParser;
    public H2645Parser mParserR;
    public boolean mReleased;
    public StartStreamingParam mStartStreamingParam;
    public OneStreamPipeline mStreamPipeline;
    public final Object mSyncExtraData = new Object();
    public VideoParam mVideoParam;
    public VideoQueue mVideoQueue;
    public boolean mWriteH264;
    public long originLastGyroTsMs;
    public long startTime;
    public long timeDeltaNs = 1000000000;

    public StreamProcess(OneDriver oneDriver, Handler handler, OneStreamPipeline oneStreamPipeline, StartStreamingParam startStreamingParam, boolean z, Context context) {
        this.mHandler = handler;
        this.mH265 = z;
        this.mStreamPipeline = oneStreamPipeline;
        this.mStartStreamingParam = startStreamingParam;
        this.mContext = context;
        oneDriver.setStreamListener(this);
        changeStreamProcess(startStreamingParam.isDualStream(), z);
    }

    private long getFixTimestap(long j2) {
        return j2;
    }

    private void h264Parser(boolean z, boolean z2, final VideoParam videoParam) {
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
            this.mParser.setSpsCallback(new SPSCallback() {
                public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                    if (videoParam != null) {
                        boolean z = TraceUtil.TRACE;
                        String str = Config.EVENT_HEAT_X;
                        if (z) {
                            String access$000 = StreamProcess.TAG;
                            StringBuilder a2 = a.a("dual left sps parse video resolution (", i2, str, i3, ") fps ");
                            a2.append(i4);
                            a2.append(" fpsFloat ");
                            a2.append(f2);
                            a2.append("");
                            Log.i(access$000, a2.toString());
                        }
                        VideoParam videoParam = videoParam;
                        String str2 = ")";
                        if (!(videoParam.width / 2 == i2 && videoParam.height == i3)) {
                            String access$0002 = StreamProcess.TAG;
                            StringBuilder a3 = a.a("dual left video resolution update from (");
                            a3.append(videoParam.width);
                            a3.append(str);
                            a3.append(videoParam.height);
                            a3.append(") to (");
                            int i5 = i2 * 2;
                            a3.append(i5);
                            a3.append(str);
                            a3.append(i3 * 2);
                            a3.append(str2);
                            Log.e(access$0002, a3.toString());
                            VideoParam videoParam2 = videoParam;
                            videoParam2.width = i5;
                            videoParam2.height = i3;
                        }
                        if (Math.abs(videoParam.fps - i4) > 1) {
                            String access$0003 = StreamProcess.TAG;
                            StringBuilder a4 = a.a("dual left video fps (");
                            a4.append(videoParam.fps);
                            a4.append(") mismatch (");
                            a4.append(i4);
                            a4.append(str2);
                            Log.e(access$0003, a4.toString());
                        }
                    }
                }
            });
            this.mParserR.setSpsCallback(new SPSCallback() {
                public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                    if (videoParam != null) {
                        boolean z = TraceUtil.TRACE;
                        String str = Config.EVENT_HEAT_X;
                        if (z) {
                            String access$000 = StreamProcess.TAG;
                            StringBuilder a2 = a.a("dual right sps parse video resolution (", i2, str, i3, ") fps ");
                            a2.append(i4);
                            a2.append(" fpsFloat ");
                            a2.append(f2);
                            a2.append("");
                            Log.i(access$000, a2.toString());
                        }
                        VideoParam videoParam = videoParam;
                        String str2 = ")";
                        if (!(videoParam.width / 2 == i2 && videoParam.height == i3)) {
                            String access$0002 = StreamProcess.TAG;
                            StringBuilder a3 = a.a("dual right video resolution update from (");
                            a3.append(videoParam.width);
                            a3.append(str);
                            a3.append(videoParam.height);
                            a3.append(") to (");
                            a3.append(i2);
                            a3.append(str);
                            a3.append(i3);
                            a3.append(str2);
                            Log.e(access$0002, a3.toString());
                            VideoParam videoParam2 = videoParam;
                            videoParam2.width = i2 * 2;
                            videoParam2.height = i3;
                        }
                        if (i4 > 0 && Math.abs(videoParam.fps - i4) > 1) {
                            String access$0003 = StreamProcess.TAG;
                            StringBuilder a4 = a.a("update dual right video fps (");
                            a4.append(videoParam.fps);
                            a4.append(") mismatch (");
                            a4.append(i4);
                            a4.append(str2);
                            Log.e(access$0003, a4.toString());
                            videoParam.fps = i4;
                        }
                    }
                }
            });
        } else {
            this.mParser.setSpsCallback(new SPSCallback() {
                public void onSpsUpdate(int i2, int i3, int i4, float f2) {
                    if (videoParam != null) {
                        boolean z = TraceUtil.TRACE;
                        String str = Config.EVENT_HEAT_X;
                        if (z) {
                            String access$000 = StreamProcess.TAG;
                            StringBuilder a2 = a.a("single sps parse video resolution (", i2, str, i3, ") fps ");
                            a2.append(i4);
                            a2.append(" fpsFloat ");
                            a2.append(f2);
                            a2.append("");
                            Log.i(access$000, a2.toString());
                        }
                        VideoParam videoParam = videoParam;
                        String str2 = ")";
                        if (!(videoParam.width == i2 && videoParam.height == i3)) {
                            String access$0002 = StreamProcess.TAG;
                            StringBuilder a3 = a.a("single video resolution update from (");
                            a3.append(videoParam.width);
                            a3.append(str);
                            a3.append(videoParam.height);
                            a3.append(") to (");
                            a3.append(i2);
                            a3.append(str);
                            a3.append(i3);
                            a3.append(str2);
                            Log.e(access$0002, a3.toString());
                            VideoParam videoParam2 = videoParam;
                            videoParam2.width = i2;
                            videoParam2.height = i3;
                        }
                        if (Math.abs(videoParam.fps - i4) > 1) {
                            String access$0003 = StreamProcess.TAG;
                            StringBuilder a4 = a.a("update single video fps (");
                            a4.append(videoParam.fps);
                            a4.append(") mismatch (");
                            a4.append(i4);
                            a4.append(str2);
                            Log.e(access$0003, a4.toString());
                            videoParam.fps = i4;
                        }
                    }
                }
            });
        }
        setParams();
    }

    /* access modifiers changed from: private */
    public void precoss(StreamData streamData) {
        Log.i(TAG, "process data");
        int i2 = streamData.streamType;
        if (i2 == 48) {
            processGyro(streamData);
        } else if (i2 != 64) {
            switch (i2) {
                case 16:
                    processAudioFrame(streamData);
                    break;
                case 17:
                case 18:
                    break;
                default:
                    switch (i2) {
                        case 32:
                            processVideoFrame(streamData);
                            break;
                        case 33:
                            processVideoFrame(streamData);
                            break;
                        case 34:
                            processSecVideoFrame(streamData);
                            break;
                        default:
                            a.b(a.a("error stream type "), streamData.streamType, TAG);
                            break;
                    }
            }
        } else {
            processExposureTime(streamData);
        }
        streamData.data = null;
    }

    private void putExposureTime(StreamExposureInfo streamExposureInfo) {
        if (this.mICameraPreviewPipeline != null) {
            Log.e(TAG, "putExposureTime meet mICameraPreviewPipeline null");
        }
    }

    private void putGyro(LinkedList<OneGyroField> linkedList) {
        if (this.mICameraPreviewPipeline != null) {
            Log.e(TAG, "putGyro but mICameraPreviewPipeline not null error");
        } else {
            this.mStreamPipeline.putGyro(linkedList);
        }
    }

    private void writeH264Data(byte[] bArr, int i2, int i3) {
        try {
            if (this.mFileH264 == null) {
                File externalFilesDir = this.mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                StringBuilder sb = new StringBuilder();
                sb.append("insv_");
                sb.append(new SimpleDateFormat("MM_dd_HH_mm_ss_SSS", Locale.getDefault()).format(new Date()));
                sb.append(".h264");
                this.mFileH264 = new File(externalFilesDir, sb.toString());
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("mFileH264 is ");
                sb2.append(this.mFileH264.getAbsolutePath());
                Log.d(str, sb2.toString());
                if (!this.mFileH264.exists()) {
                    this.mFileH264.createNewFile();
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFileH264, "rw");
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(bArr, i2, i3);
            String str2 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" ");
            sb3.append(this.mFileH264.getAbsoluteFile());
            sb3.append(" input size ");
            sb3.append(i3);
            sb3.append(" file size ");
            sb3.append(this.mFileH264.length());
            Log.d(str2, sb3.toString());
            randomAccessFile.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void changeStreamProcess(boolean z, boolean z2) {
        if (z) {
            this.mVideoQueue = new DualVideoQueue(30, this.mStreamPipeline, this.mICameraPreviewPipeline);
        } else {
            this.mVideoQueue = new SingleVideoQueue(30, this.mStreamPipeline, this.mICameraPreviewPipeline);
        }
        VideoParam videoParam = null;
        int previewNum = this.mStartStreamingParam.getPreviewNum();
        if (previewNum == 0) {
            videoParam = this.mStartStreamingParam.getFirstVideoParam();
        } else if (previewNum == 1) {
            videoParam = this.mStartStreamingParam.getSecVideoParam();
        }
        this.mVideoParam = videoParam;
        this.mAudioParam = this.mStartStreamingParam.getAudioParam();
        h264Parser(z, z2, videoParam);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("init stream process, dual = ");
        sb.append(z);
        Log.i(str, sb.toString());
    }

    public void debugFPS(int i2) {
        long nanoTime = System.nanoTime();
        long j2 = this.frameCount + 1;
        this.frameCount = j2;
        if (j2 % ((long) i2) == 0) {
            double d2 = ((double) (i2 * 1000)) / (((double) (nanoTime - this.startTime)) / 1000000.0d);
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("camera input fps: ");
            sb.append(d2);
            Log.i(str, sb.toString());
            this.startTime = nanoTime;
        }
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public void onDriverStreamDataNotify(final StreamData streamData) {
        if (TraceUtil.TRACE) {
            String str = TAG;
            StringBuilder a2 = a.a("onDriverStreamDataNotify type");
            a2.append(streamData.streamType);
            Log.d(str, a2.toString());
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                StreamProcess.this.precoss(streamData);
            }
        });
    }

    public void processAudioFrame(StreamData streamData) {
        if (this.mAudioParam == null) {
            StartStreamingParam startStreamingParam = this.mStartStreamingParam;
            if (startStreamingParam != null) {
                this.mAudioParam = startStreamingParam.getAudioParam();
            }
        }
        if (this.mAudioParam != null) {
            AudioData audioData = new AudioData();
            byte[] bArr = streamData.data;
            audioData.data = bArr;
            audioData.dataSize = bArr.length;
            audioData.dataOffset = 0;
            long fixTimestap = getFixTimestap(streamData.timestamp * 1000000);
            audioData.timestampNsSysClock = fixTimestap;
            if (this.mAudioParam.codec == 1) {
                ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
                if (iCameraPreviewPipeline != null) {
                    iCameraPreviewPipeline.onAudioStream(fixTimestap, streamData.data);
                }
            }
        }
    }

    public void processExposureTime(StreamData streamData) {
        if (!this.mGyroStabilizerApplied) {
            return;
        }
        if (this.mICameraPreviewPipeline != null) {
            new StreamExposureInfo();
            this.mICameraPreviewPipeline.onExposureStream(streamData.timestamp, NumberUtil.bytes2Double(streamData.data, 0));
            return;
        }
        StreamExposureInfo streamExposureInfo = new StreamExposureInfo();
        streamExposureInfo.timestampNs = getFixTimestap(streamData.timestamp * 1000000);
        streamExposureInfo.exposureTimeNs = (long) (NumberUtil.bytes2Double(streamData.data, 0) * 1.0E9d);
        putExposureTime(streamExposureInfo);
    }

    public void processGyro(StreamData streamData) {
        if (this.mGyroStabilizerApplied) {
            byte[] bArr = streamData.data;
            int length = bArr.length / 56;
            if (this.mICameraPreviewPipeline != null) {
                this.mICameraPreviewPipeline.onGyroStream(streamData.data, new OneGyroField(bArr, (length - 1) * 56, 0).originTsMs);
                return;
            }
            LinkedList linkedList = new LinkedList();
            OneGyroField oneGyroField = new OneGyroField(streamData.data, 0, this.timeDeltaNs);
            if (this.originLastGyroTsMs >= oneGyroField.originTsMs) {
                for (int i2 = length - 1; i2 > 0; i2--) {
                    oneGyroField = new OneGyroField(streamData.data, i2 * 56, this.timeDeltaNs);
                    if (this.originLastGyroTsMs >= oneGyroField.originTsMs) {
                        break;
                    }
                    linkedList.add(oneGyroField);
                }
                String str = TAG;
                StringBuilder a2 = a.a("remove duplicate gyro:last gyro ts ");
                a2.append(this.originLastGyroTsMs);
                a2.append(" >= new ");
                a2.append(oneGyroField.originTsMs);
                a2.append(" delta ");
                a2.append(this.originLastGyroTsMs - oneGyroField.originTsMs);
                a2.append(" reset gyroFields size ");
                a2.append(linkedList.size());
                Log.e(str, a2.toString());
                if (linkedList.size() > 0) {
                    putGyro(linkedList);
                    this.originLastGyroTsMs = ((OneGyroField) linkedList.get(linkedList.size() - 1)).originTsMs;
                    return;
                }
                return;
            }
            linkedList.add(oneGyroField);
            for (int i3 = 1; i3 < length; i3++) {
                linkedList.add(new OneGyroField(streamData.data, i3 * 56, this.timeDeltaNs));
            }
            putGyro(linkedList);
            this.originLastGyroTsMs = ((OneGyroField) linkedList.get(linkedList.size() - 1)).originTsMs;
        }
    }

    public void processSecVideoFrame(StreamData streamData) {
        if (this.mParserR != null) {
            byte[] bArr = streamData.data;
            if (bArr[0] == 0 && bArr[1] == 0) {
                String str = " frameSysTimeNs ";
                if (bArr[2] == 0 && bArr[3] == 1) {
                    long fixTimestap = getFixTimestap(streamData.timestamp * 1000000);
                    if (TraceUtil.TRACE) {
                        String str2 = TAG;
                        StringBuilder a2 = a.a("sec first received one video frame, size: ");
                        a2.append(streamData.data.length);
                        a2.append(str);
                        a2.append(fixTimestap);
                        Log.i(str2, a2.toString());
                    }
                    H2645Frame h2645Frame = this.mLastFrameR;
                    if (h2645Frame != null) {
                        if (h2645Frame.size == 0) {
                            Log.e(TAG, "frame size 0");
                        } else if (this.mParserR.getCsdData() != null) {
                            this.mVideoQueue.enqueSecVideo(this.mLastFrameR, getFixTimestap(this.mLastOrgFrameTsMsR * 1000000));
                        } else if (this.mLastFrameR.type != FrameType.IDR) {
                            String str3 = TAG;
                            StringBuilder a3 = a.a("sec sps and pps data not received, drop frame: ");
                            a3.append(this.mLastFrameR.type);
                            Log.w(str3, a3.toString());
                        } else {
                            Log.e(TAG, "sec iframe but no video extra");
                        }
                        this.mLastFrameR = null;
                    }
                    H2645Parser h2645Parser = this.mParserR;
                    if (h2645Parser != null) {
                        byte[] bArr2 = streamData.data;
                        h2645Parser.feedData(bArr2, 0, bArr2.length);
                        H2645Frame h2645Frame2 = new H2645Frame();
                        while (this.mParserR.readFrame(h2645Frame2)) {
                            if (this.mLastFrameR != null) {
                                Log.e(TAG, " mLastFrameR not null,skip crash for xuege said,force null");
                                this.mLastFrameR = null;
                            }
                            this.mLastFrameR = h2645Frame2;
                        }
                        if (this.mLastFrameR == null) {
                            Log.e(TAG, "mLastFrameR null after readFrame,skip crash for xuege said");
                            this.mLastOrgFrameTsMsR = -1;
                        } else {
                            this.mLastOrgFrameTsMsR = streamData.timestamp;
                        }
                        return;
                    }
                    return;
                } else if (streamData.data[2] == 1) {
                    if (!this.mH265) {
                        Log.e(TAG, "sec h264 meet begin with 00 00 01");
                    } else if (this.mLastOrgFrameTsMsR != -1) {
                        long fixTimestap2 = getFixTimestap(streamData.timestamp * 1000000);
                        if (TraceUtil.TRACE) {
                            String str4 = TAG;
                            StringBuilder a4 = a.a("concat received one video frame, size: ");
                            a4.append(streamData.data.length);
                            a4.append(str);
                            a4.append(fixTimestap2);
                            Log.i(str4, a4.toString());
                        }
                        if (this.mLastFrame != null) {
                            if (this.mLastOrgFrameTsMsR != streamData.timestamp) {
                                String str5 = TAG;
                                StringBuilder a5 = a.a("sec mismatch last frame ts (");
                                a5.append(this.mLastOrgFrameTsMsR);
                                a5.append(" != ");
                                a5.append(streamData.timestamp);
                                a5.append(") delta ");
                                a5.append(this.mLastOrgFrameTsMsR - streamData.timestamp);
                                Log.e(str5, a5.toString());
                            }
                            if (TraceUtil.TRACE) {
                                String str6 = TAG;
                                StringBuilder a6 = a.a("go on received one video frame, size: ");
                                a6.append(streamData.data.length);
                                a6.append(str);
                                a6.append(fixTimestap2);
                                Log.i(str6, a6.toString());
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
                        Log.e(TAG, "sec skip non-first h265 slice");
                    }
                    return;
                }
            }
            String str7 = TAG;
            StringBuilder a7 = a.a("sec process invalid ");
            a7.append(this.mH265 ? "h265" : "h264");
            a7.append("  frame, size: ");
            a7.append(streamData.data.length);
            a7.append(", start bytes: ");
            a7.append(NumberUtil.bytesToHex(streamData.data, 0, 8));
            Log.e(str7, a7.toString());
        }
    }

    public void processVideoFrame(StreamData streamData) {
        if (this.mParser != null) {
            String str = ", start bytes: ";
            String str2 = "h265";
            String str3 = "h264";
            if (TraceUtil.TRACE) {
                String str4 = TAG;
                StringBuilder a2 = a.a("process ");
                a2.append(this.mH265 ? str2 : str3);
                a2.append("  frame, size: ");
                a2.append(streamData.data.length);
                a2.append(str);
                a2.append(NumberUtil.bytesToHex(streamData.data, 0, 8));
                Log.i(str4, a2.toString());
                debugFPS(300);
            }
            byte[] bArr = streamData.data;
            if (bArr[0] == 0 && bArr[1] == 0) {
                String str5 = " frameSysTimeNs ";
                if (bArr[2] == 0 && bArr[3] == 1) {
                    long fixTimestap = getFixTimestap(streamData.timestamp * 1000000);
                    if (TraceUtil.TRACE) {
                        String str6 = TAG;
                        StringBuilder a3 = a.a("received one video frame, size: ");
                        a3.append(streamData.data.length);
                        a3.append(str5);
                        a3.append(fixTimestap);
                        Log.i(str6, a3.toString());
                    }
                    H2645Frame h2645Frame = this.mLastFrame;
                    if (h2645Frame != null) {
                        if (h2645Frame.size == 0) {
                            Log.e(TAG, "frame size 0");
                        } else if (this.mParser.getCsdData() != null) {
                            this.mVideoQueue.enqueVideo(this.mLastFrame, getFixTimestap(this.mLastOrgFrameTsMs * 1000000));
                        } else if (this.mLastFrame.type != FrameType.IDR) {
                            String str7 = TAG;
                            StringBuilder a4 = a.a("sps and pps data not received, drop frame: ");
                            a4.append(this.mLastFrame.type);
                            Log.w(str7, a4.toString());
                        } else {
                            Log.e(TAG, "iframe but no video extra");
                        }
                        if (this.mWriteH264) {
                            H2645Frame h2645Frame2 = this.mLastFrame;
                            writeH264Data(h2645Frame2.data, h2645Frame2.offset, h2645Frame2.size);
                        }
                        this.mLastFrame = null;
                    }
                    H2645Parser h2645Parser = this.mParser;
                    if (h2645Parser != null) {
                        byte[] bArr2 = streamData.data;
                        h2645Parser.feedData(bArr2, 0, bArr2.length);
                        H2645Frame h2645Frame3 = new H2645Frame();
                        while (this.mParser.readFrame(h2645Frame3)) {
                            if (this.mLastFrame != null) {
                                Log.e(TAG, " mLastFrame not null ,skip crash for xuege said,force null");
                                this.mLastFrame = null;
                            }
                            this.mLastFrame = h2645Frame3;
                        }
                        if (this.mLastFrame == null) {
                            Log.e(TAG, " mLastFrame null after readFrame ,skip crash for xuege said");
                            this.mLastOrgFrameTsMs = -1;
                        } else {
                            this.mLastOrgFrameTsMs = streamData.timestamp;
                        }
                        return;
                    }
                    return;
                } else if (streamData.data[2] == 1) {
                    if (!this.mH265) {
                        Log.e(TAG, " h264 meet begin with 00 00 01");
                    } else if (this.mLastOrgFrameTsMs == -1) {
                        Log.e(TAG, " skip non-first h265 slice");
                    } else if (this.mLastFrame != null) {
                        long fixTimestap2 = getFixTimestap(streamData.timestamp * 1000000);
                        if (TraceUtil.TRACE) {
                            String str8 = TAG;
                            StringBuilder a5 = a.a("concat received one video frame, size: ");
                            a5.append(streamData.data.length);
                            a5.append(str5);
                            a5.append(fixTimestap2);
                            Log.i(str8, a5.toString());
                        }
                        if (this.mLastOrgFrameTsMs != streamData.timestamp) {
                            String str9 = TAG;
                            StringBuilder a6 = a.a("mismatch last frame ts (");
                            a6.append(this.mLastOrgFrameTsMs);
                            a6.append(" != ");
                            a6.append(streamData.timestamp);
                            a6.append(") delta ");
                            a6.append(this.mLastOrgFrameTsMs - streamData.timestamp);
                            Log.e(str9, a6.toString());
                        }
                        if (TraceUtil.TRACE) {
                            String str10 = TAG;
                            StringBuilder a7 = a.a("go on received one video frame, size: ");
                            a7.append(streamData.data.length);
                            a7.append(str5);
                            a7.append(fixTimestap2);
                            Log.i(str10, a7.toString());
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
            String str11 = TAG;
            StringBuilder a8 = a.a(" process invalid ");
            if (!this.mH265) {
                str2 = str3;
            }
            a8.append(str2);
            a8.append(" frame, size: ");
            a8.append(streamData.data.length);
            a8.append(str);
            a8.append(NumberUtil.bytesToHex(streamData.data, 0, 8));
            Log.e(str11, a8.toString());
        }
    }

    public void release() {
        this.mReleased = true;
        Log.i(TAG, "camera source released");
    }

    public void setParams() {
        this.mWriteH264 = this.mStartStreamingParam.isRecordOriginH264();
        boolean z = this.mVideoParam.enableGyro;
        this.mGyroStabilizerApplied = z;
        this.codec = this.mAudioParam.codec;
        this.mVideoQueue.setGyroStabilizerApplied(z);
        this.mVideoQueue.setVideoParam(this.mVideoParam);
        this.mVideoQueue.setParser(this.mParser, this.mParserR);
        this.mVideoQueue.setH265(this.mH265);
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            this.mVideoQueue.updatePipleline(iCameraPreviewPipeline);
        }
        Log.i(TAG, " stream setParams");
    }

    public void updatePiple(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
        VideoQueue videoQueue = this.mVideoQueue;
        if (videoQueue != null) {
            videoQueue.updatePipleline(iCameraPreviewPipeline);
        }
    }
}
