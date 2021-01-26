package com.arashivision.arvbmg.transcode;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.BeautyParam;
import com.arashivision.arvbmg.util.ADTSParser;
import com.arashivision.onecamera.OneCameraImplement;
import com.sina.weibo.sdk.utils.FileUtils;
import e.a.a.a.a;
import f.a.a.c.c;
import f.a.a.c.f;
import f.a.a.c.i;
import f.a.a.c.j;
import f.a.a.c.j.b;
import f.a.a.c.m;
import f.a.a.c.o;
import f.a.a.c.p;
import f.a.a.c.s;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class TranscodeEngine {
    public static final long PROGRESS_INTERVAL_STEPS = 10;
    public static final double PROGRESS_UNKNOWN = -1.0d;
    public static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 1;
    public static final String TAG = "TranscodeEngine";
    public MediaExtractor mAudioExtractor;
    public MediaFormat mAudioOutputMediaFormat;
    public int mAudioTrackIndex;
    public m mAudioTrackTranscoder;
    public boolean mCancel;
    public boolean mDebug;
    public long mDurationUs;
    public EngineCallback mEngineCallback;
    public MediaExtractor mExtractor;
    public long mFirstVideoPtsUs;
    public Handler mHandler = new Handler(this.mHandlerThread.getLooper());
    public HandlerThread mHandlerThread;
    public long mLastAudioPtsUs;
    public long mLastVideoPtsUs;
    public p mMuxer;
    public boolean mReleased;
    public TranscodeError mTranscodeError;
    public o mTranscodeInfo;
    public MediaFormat mVideoOutputMediaFormat;
    public int mVideoTrackIndex;
    public m mVideoTrackTranscoder;

    public interface EngineCallback {
        void onTranscodeCancel();

        void onTranscodeComplete();

        void onTranscodeFail(TranscodeError transcodeError);

        void onTranscodeProgress(double d2);
    }

    public TranscodeEngine() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
    }

    private void createVideoOutputFormat(MediaFormat mediaFormat) {
        boolean isDebugOn = isDebugOn();
        String str = TAG;
        if (isDebugOn) {
            StringBuilder a2 = a.a(" input video format ");
            a2.append(mediaFormat.toString());
            Log.i(str, a2.toString());
        }
        o oVar = this.mTranscodeInfo;
        String str2 = "video/avc";
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str2, oVar.f9103g, oVar.f9104h);
        createVideoFormat.setInteger("bitrate", this.mTranscodeInfo.f9106j);
        createVideoFormat.setFloat("frame-rate", (float) this.mTranscodeInfo.f9105i);
        createVideoFormat.setInteger("i-frame-interval", this.mTranscodeInfo.r);
        createVideoFormat.setInteger("color-format", 2130708361);
        String str3 = BeautyParam.LEVEL;
        String str4 = "profile";
        if (str2 == str2) {
            createVideoFormat.setInteger(str4, 1);
            createVideoFormat.setInteger(str3, 1);
        } else {
            createVideoFormat.setInteger(str4, 1);
            createVideoFormat.setInteger(str3, 1);
        }
        if (isDebugOn()) {
            StringBuilder a3 = a.a(" output video format ");
            a3.append(createVideoFormat.toString());
            Log.i(str, a3.toString());
        }
        this.mVideoOutputMediaFormat = createVideoFormat;
    }

    private double getProgress(long j2) {
        return ((double) (j2 - this.mFirstVideoPtsUs)) / ((double) this.mDurationUs);
    }

    private boolean hasAudio() {
        return !this.mTranscodeInfo.k;
    }

    private void runPipelines() {
        double d2;
        long j2;
        long j3;
        long j4 = 0;
        int i2 = (this.mDurationUs > 0 ? 1 : (this.mDurationUs == 0 ? 0 : -1));
        String str = TAG;
        if (i2 <= 0) {
            StringBuilder a2 = a.a("error duration ");
            a2.append(this.mDurationUs);
            Log.e(str, a2.toString());
            this.mEngineCallback.onTranscodeProgress(-1.0d);
        }
        int i3 = -405;
        if (hasAudio()) {
            while (!this.mCancel) {
                if (!this.mVideoTrackTranscoder.f9094e || !this.mAudioTrackTranscoder.f9094e) {
                    if (this.mAudioTrackTranscoder.f9094e) {
                        j2 = RecyclerView.FOREVER_NS;
                    } else {
                        j2 = this.mLastAudioPtsUs;
                    }
                    if (this.mVideoTrackTranscoder.f9094e) {
                        j3 = RecyclerView.FOREVER_NS;
                    } else {
                        j3 = this.mLastVideoPtsUs;
                    }
                    try {
                        boolean b2 = this.mVideoTrackTranscoder.b(j2);
                        try {
                            boolean b3 = this.mAudioTrackTranscoder.b(j3);
                            if (!b2 && !b3) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                    this.mEngineCallback.onTranscodeFail(setTranscodeError(-405));
                                }
                            } else if (this.mDurationUs > 0 && !(this.mVideoTrackTranscoder.f9096g == this.mLastVideoPtsUs && this.mAudioTrackTranscoder.f9096g == this.mLastAudioPtsUs)) {
                                long j5 = this.mVideoTrackTranscoder.f9096g;
                                this.mLastVideoPtsUs = j5;
                                this.mLastAudioPtsUs = this.mAudioTrackTranscoder.f9096g;
                                this.mEngineCallback.onTranscodeProgress((Math.min(1.0d, getProgress(this.mLastAudioPtsUs)) + Math.min(1.0d, getProgress(j5))) / 2.0d);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            this.mEngineCallback.onTranscodeFail(setTranscodeError(-411));
                            StringBuilder sb = new StringBuilder();
                            sb.append(" audio step to break e ");
                            sb.append(e3);
                            Log.e(str, sb.toString());
                            return;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        this.mEngineCallback.onTranscodeFail(setTranscodeError(-410));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" video step to break e ");
                        sb2.append(e4);
                        Log.e(str, sb2.toString());
                        return;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        while (!this.mCancel) {
            m mVar = this.mVideoTrackTranscoder;
            if (!mVar.f9094e) {
                try {
                    if (!mVar.b(RecyclerView.FOREVER_NS)) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e5) {
                            e5.printStackTrace();
                            this.mEngineCallback.onTranscodeFail(setTranscodeError(i3));
                        }
                    } else if (this.mDurationUs > j4) {
                        m mVar2 = this.mVideoTrackTranscoder;
                        long j6 = mVar2.f9096g;
                        if (j6 != this.mLastVideoPtsUs) {
                            this.mLastVideoPtsUs = j6;
                            if (mVar2.f9094e) {
                                d2 = 1.0d;
                            } else {
                                d2 = Math.min(1.0d, getProgress(j6));
                            }
                            this.mEngineCallback.onTranscodeProgress(d2);
                        }
                    }
                    i3 = -405;
                    j4 = 0;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    this.mEngineCallback.onTranscodeFail(setTranscodeError(-410));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" only video step to break e ");
                    sb3.append(e6);
                    Log.e(str, sb3.toString());
                    return;
                }
            } else {
                return;
            }
        }
    }

    private TranscodeError setTranscodeError(int i2) {
        TranscodeError transcodeError = this.mTranscodeError;
        if (transcodeError == null) {
            this.mTranscodeError = new TranscodeError(i2);
        } else {
            transcodeError.setErrorCode(i2);
        }
        return this.mTranscodeError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupMetadata(java.io.FileDescriptor r8) {
        /*
            r7 = this;
            java.lang.String r0 = "TranscodeEngine"
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            r1.setDataSource(r8)
            r8 = 24
            java.lang.String r8 = r1.extractMetadata(r8)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0039 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x0039 }
            java.lang.String r4 = " rotate "
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0039 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x0039 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x0039 }
            android.util.Log.i(r0, r3)     // Catch:{ NumberFormatException -> 0x0039 }
            f.a.a.c.p r3 = r7.mMuxer     // Catch:{ NumberFormatException -> 0x0039 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0039 }
            if (r3 == 0) goto L_0x0038
            f.a.a.c.p$a r4 = f.a.a.c.p.a.TRANSCODE_INIT     // Catch:{ NumberFormatException -> 0x0039 }
            r3.a(r4)     // Catch:{ NumberFormatException -> 0x0039 }
            android.media.MediaMuxer r3 = r3.f9110a     // Catch:{ NumberFormatException -> 0x0039 }
            r3.setOrientationHint(r8)     // Catch:{ NumberFormatException -> 0x0039 }
            goto L_0x0039
        L_0x0038:
            throw r2     // Catch:{ NumberFormatException -> 0x0039 }
        L_0x0039:
            r8 = 23
            java.lang.String r8 = r1.extractMetadata(r8)
            if (r8 == 0) goto L_0x009c
            java.lang.String r1 = "([+\\-][0-9.]+)([+\\-][0-9.]+)"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            r3 = 0
            r4 = 1
            java.util.regex.Matcher r1 = r1.matcher(r8)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x0071
            int r5 = r1.groupCount()
            r6 = 2
            if (r5 != r6) goto L_0x0071
            java.lang.String r5 = r1.group(r4)
            java.lang.String r1 = r1.group(r6)
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x0071 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0071 }
            float[] r6 = new float[r6]     // Catch:{ NumberFormatException -> 0x0071 }
            r6[r3] = r5     // Catch:{ NumberFormatException -> 0x0071 }
            r6[r4] = r1     // Catch:{ NumberFormatException -> 0x0071 }
            goto L_0x0072
        L_0x0071:
            r6 = r2
        L_0x0072:
            if (r6 == 0) goto L_0x0088
            f.a.a.c.p r8 = r7.mMuxer
            r1 = r6[r3]
            r3 = r6[r4]
            if (r8 == 0) goto L_0x0087
            f.a.a.c.p$a r2 = f.a.a.c.p.a.TRANSCODE_INIT
            r8.a(r2)
            android.media.MediaMuxer r8 = r8.f9110a
            r8.setLocation(r1, r3)
            goto L_0x009c
        L_0x0087:
            throw r2
        L_0x0088:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse the location metadata: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r0, r8)
        L_0x009c:
            f.a.a.c.o r8 = r7.mTranscodeInfo
            long r1 = r8.f9100d
            long r3 = r8.f9099c
            long r1 = r1 - r3
            r7.mDurationUs = r1
            java.lang.String r8 = "Duration (us): "
            java.lang.StringBuilder r8 = e.a.a.a.a.a(r8)
            long r1 = r7.mDurationUs
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.transcode.TranscodeEngine.setupMetadata(java.io.FileDescriptor):void");
    }

    private void setupTrackTranscoders() {
        o oVar = this.mTranscodeInfo;
        long j2 = oVar.f9099c;
        long j3 = oVar.f9100d;
        MediaExtractor mediaExtractor = this.mExtractor;
        int trackCount = mediaExtractor.getTrackCount();
        StringBuilder sb = new StringBuilder();
        sb.append("trackCount ");
        sb.append(trackCount);
        Log.i(" MediaExtractorUtils", sb.toString());
        int i2 = -1;
        MediaFormat mediaFormat = null;
        int i3 = -1;
        MediaFormat mediaFormat2 = null;
        for (int i4 = 0; i4 < trackCount; i4++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i4);
            String string = trackFormat.getString("mime");
            if (i2 < 0 && string.startsWith(FileUtils.VIDEO_FILE_START)) {
                i2 = i4;
                mediaFormat2 = trackFormat;
            } else if (i3 < 0 && string.startsWith("audio/")) {
                i3 = i4;
                mediaFormat = trackFormat;
            }
            if (i2 >= 0 && i3 >= 0) {
                break;
            }
        }
        if (i2 >= 0) {
            if (i3 < 0) {
                Log.e("MediaExtractorUtils", "extractor does not contain audio tracks");
            }
            j jVar = new j(this.mMuxer, new b() {
                public void onDetermineOutputFormat() {
                    MediaFormat a2 = TranscodeEngine.this.mVideoTrackTranscoder.a();
                    String str = "mime";
                    String string = a2.getString(str);
                    String str2 = "video/avc";
                    boolean equals = str2.equals(string);
                    String str3 = "video/hevc";
                    String str4 = BMGMediaTranscode.TAG;
                    if (equals || str3.equals(string)) {
                        ByteBuffer asReadOnlyBuffer = a2.getByteBuffer("csd-0").asReadOnlyBuffer();
                        ByteBuffer order = ByteBuffer.allocate(asReadOnlyBuffer.limit()).order(asReadOnlyBuffer.order());
                        order.put(asReadOnlyBuffer);
                        order.flip();
                        byte[] bArr = new byte[3];
                        order.get(bArr);
                        if (!Arrays.equals(bArr, f.a.a.d.a.f9124a)) {
                            byte[] copyOf = Arrays.copyOf(bArr, 4);
                            copyOf[3] = order.get();
                            if (!Arrays.equals(copyOf, f.a.a.d.a.f9125b)) {
                                throw new IllegalStateException("AVC NAL start code does not found in csd.");
                            }
                        }
                        String string2 = a2.getString(str);
                        byte b2 = order.get();
                        if (str3.equals(string2)) {
                            StringBuilder a3 = a.a("h265 spsNalData ");
                            a3.append(Byte.toString(b2));
                            String str5 = " hex 0x";
                            a3.append(str5);
                            a3.append(Integer.toString(b2, 16));
                            String str6 = "AvcCsdUtils";
                            Log.i(str6, a3.toString());
                            if (!(b2 == 64 || b2 == 66)) {
                                StringBuilder a4 = a.a("hevc spsNalData ");
                                a4.append(Byte.toString(b2));
                                a4.append(str5);
                                a4.append(Integer.toString(b2, 16));
                                Log.e(str6, a4.toString());
                            }
                        } else if (!(b2 == 103 || b2 == 39 || b2 == 71)) {
                            throw new IllegalStateException("Got non SPS NAL data.");
                        }
                        ByteBuffer slice = order.slice();
                        if (str2.equals(string)) {
                            byte b3 = slice.get(0);
                            if (b3 != 66) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(" profileIdc ");
                                sb.append(b3);
                                Log.e(str4, sb.toString());
                                throw new f(a.a("Non-baseline AVC video profile is not supported by Android OS, actual profile_idc: ", (int) b3));
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" encode mime ");
                            sb2.append(string);
                            Log.i("MediaFormatValidator", sb2.toString());
                        }
                        if (TranscodeEngine.this.mAudioTrackTranscoder != null) {
                            String string3 = TranscodeEngine.this.mAudioTrackTranscoder.a().getString(str);
                            if (!"audio/mp4a-latm".equals(string3)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("error audio mime ");
                                sb3.append(string3);
                                Log.e(str4, sb3.toString());
                                throw new f(a.a("Audio codecs other than AAC is not supported, actual mime type: ", string3));
                            }
                            return;
                        }
                        return;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("error video mime ");
                    sb4.append(string);
                    Log.e(str4, sb4.toString());
                    throw new f(a.a("Video codecs other than AVC is not supported, actual mime type: ", string));
                }
            });
            String str = TAG;
            if (i3 < 0 && !this.mTranscodeInfo.k) {
                Log.e(str, "force noAudio true");
                this.mTranscodeInfo.k = true;
            }
            jVar.f9061j = this.mTranscodeInfo.k;
            this.mVideoTrackIndex = i2;
            createVideoOutputFormat(mediaFormat2);
            long j4 = j3;
            s sVar = new s(this.mExtractor, this.mVideoTrackIndex, this.mVideoOutputMediaFormat, jVar, this.mTranscodeInfo);
            this.mVideoTrackTranscoder = sVar;
            sVar.c();
            m mVar = this.mVideoTrackTranscoder;
            boolean isDebugOn = isDebugOn();
            mVar.f9093d = isDebugOn;
            i iVar = mVar.f9092c;
            if (iVar != null) {
                iVar.f9042a = isDebugOn;
            }
            ((s) this.mVideoTrackTranscoder).t = new s.a() {
                public void onFirstFramePtsUs(long j2) {
                    TranscodeEngine.this.mFirstVideoPtsUs = j2;
                }
            };
            if (hasAudio()) {
                int checkIsAdts = ADTSParser.checkIsAdts(this.mTranscodeInfo.f9097a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" checkIsAdts ret ");
                sb2.append(checkIsAdts);
                Log.i(str, sb2.toString());
                if (checkIsAdts == 0) {
                    this.mTranscodeInfo.t = false;
                } else if (checkIsAdts != 1) {
                    a.c(" checkIsAdts error ret ", checkIsAdts, str);
                } else {
                    this.mTranscodeInfo.t = true;
                }
                this.mAudioTrackIndex = i3;
                createAudioOutputFormat(mediaFormat);
                c cVar = new c(this.mAudioExtractor, this.mAudioTrackIndex, this.mAudioOutputMediaFormat, jVar, this.mTranscodeInfo);
                this.mAudioTrackTranscoder = cVar;
                cVar.f9090a = j2;
                long j5 = j4;
                cVar.f9091b = j5;
                int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                String str2 = "TrackTranscoder";
                if (i5 < 0) {
                    StringBuilder a2 = a.a(" error trackcode trim end ");
                    a2.append(cVar.f9091b);
                    Log.e(str2, a2.toString());
                }
                if (cVar.f9090a < 0) {
                    StringBuilder a3 = a.a(" error trackcode trim start ");
                    a3.append(cVar.f9090a);
                    Log.e(str2, a3.toString());
                }
                if (cVar.f9091b < cVar.f9090a) {
                    StringBuilder a4 = a.a(" error trackcode trim end(");
                    a4.append(cVar.f9091b);
                    a4.append(") < (");
                    a4.append(cVar.f9090a);
                    a4.append(")");
                    Log.e(str2, a4.toString());
                }
                this.mAudioTrackTranscoder.c();
                m mVar2 = this.mAudioTrackTranscoder;
                boolean isDebugOn2 = isDebugOn();
                mVar2.f9093d = isDebugOn2;
                i iVar2 = mVar2.f9092c;
                if (iVar2 != null) {
                    iVar2.f9042a = isDebugOn2;
                }
            }
            if (j2 > 0) {
                this.mExtractor.seekTo(j2, 0);
                if (hasAudio()) {
                    this.mAudioExtractor.seekTo(j2, 0);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("extractor does not contain video tracks.");
    }

    public void cancel() {
        this.mCancel = true;
    }

    public void createAudioOutputFormat(MediaFormat mediaFormat) {
        int i2;
        int i3;
        boolean isDebugOn = isDebugOn();
        String str = TAG;
        if (isDebugOn) {
            StringBuilder a2 = a.a(" input audio format ");
            a2.append(mediaFormat.toString());
            Log.i(str, a2.toString());
        }
        int i4 = OneCameraImplement.AUDIO_SAMPLE_RATE_DEF;
        int i5 = 128000;
        String str2 = "channel-count";
        boolean z = true;
        int integer = (!mediaFormat.containsKey(str2) || !mediaFormat.containsKey(str2)) ? 1 : mediaFormat.getInteger(str2);
        String str3 = "sample-rate";
        if (mediaFormat.containsKey(str3) && mediaFormat.containsKey(str3)) {
            i4 = mediaFormat.getInteger(str3);
        }
        String str4 = "bitrate";
        if (mediaFormat.containsKey(str4) && mediaFormat.containsKey(str4)) {
            i5 = mediaFormat.getInteger(str4);
        }
        o oVar = this.mTranscodeInfo;
        if (oVar.l <= 0 || oVar.m <= 0 || oVar.n <= 0) {
            z = false;
        }
        if (z) {
            int i6 = this.mTranscodeInfo.m;
            String str5 = ")";
            String str6 = " > ";
            if (i6 > integer) {
                StringBuilder a3 = a.a(" error audio channel count (");
                a3.append(this.mTranscodeInfo.m);
                a3.append(str6);
                a3.append(integer);
                a3.append(str5);
                Log.e(str, a3.toString());
            } else {
                integer = i6;
            }
            int i7 = this.mTranscodeInfo.l;
            if (i7 > i4) {
                StringBuilder a4 = a.a(" error audio samplerate (");
                a4.append(this.mTranscodeInfo.l);
                a4.append(str6);
                a4.append(i4);
                a4.append(str5);
                Log.e(str, a4.toString());
            } else {
                i4 = i7;
            }
            if (this.mTranscodeInfo.n > i5) {
                StringBuilder a5 = a.a(" error audio bitrate (");
                a5.append(this.mTranscodeInfo.n);
                a5.append(str6);
                a5.append(i5);
                a5.append(str5);
                Log.e(str, a5.toString());
            }
            o oVar2 = this.mTranscodeInfo;
            int i8 = oVar2.n;
            int i9 = integer;
            i3 = oVar2.o;
            i5 = i8;
            i2 = i9;
        } else {
            i2 = integer;
            i3 = 1024;
        }
        o oVar3 = this.mTranscodeInfo;
        if (oVar3 != null) {
            StringBuilder a6 = a.a(" set audio info audioSampleRate ", i4, " audioChannelCount ", i2, " audioBitrate ");
            a6.append(i5);
            a6.append(" audioFrameSize ");
            a6.append(i3);
            String str7 = "TranscodeInfo";
            Log.i(str7, a6.toString());
            oVar3.l = i4;
            oVar3.m = i2;
            oVar3.n = i5;
            oVar3.o = i3;
            if (i3 != 1024) {
                a.c("other audio frame size ? ", i3, str7);
            }
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i4, i2);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger(str4, i5);
            if (isDebugOn()) {
                StringBuilder a7 = a.a(" output audio format ");
                a7.append(createAudioFormat.toString());
                Log.i(str, a7.toString());
            }
            this.mAudioOutputMediaFormat = createAudioFormat;
            return;
        }
        throw null;
    }

    public void finalize() {
        release();
        try {
            super.finalize();
        } catch (Throwable th) {
            Log.e(TAG, "finalize error");
            th.printStackTrace();
        }
    }

    public boolean isDebugOn() {
        return this.mDebug;
    }

    public void release() {
        if (!this.mReleased) {
            this.mReleased = true;
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                try {
                    this.mHandlerThread.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.mHandlerThread = null;
                this.mHandler = null;
            }
        }
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void start(final o oVar, final EngineCallback engineCallback) {
        this.mHandler.post(new Runnable() {
            public void run() {
                TranscodeEngine.this.mTranscodeInfo = oVar;
                TranscodeEngine.this.mEngineCallback = engineCallback;
                TranscodeEngine.this.transcodeVideo();
            }
        });
    }

    public void transcodeVideo() {
        o oVar = this.mTranscodeInfo;
        String str = oVar.f9097a;
        String str2 = oVar.f9102f;
        if (str == null) {
            throw new NullPointerException("Input path cannot be null.");
        } else if (str2 == null) {
            throw new NullPointerException("Output path cannot be null.");
        } else if (this.mTranscodeError == null) {
            boolean startsWith = str.startsWith("http://");
            String str3 = TAG;
            if (startsWith || str.startsWith("https://")) {
                HashMap hashMap = new HashMap();
                o oVar2 = this.mTranscodeInfo;
                long j2 = oVar2.w;
                Object[] objArr = {Long.valueOf(oVar2.x), Long.valueOf(j2), Integer.valueOf(oVar2.y)};
                hashMap.put("x-cache-config", String.format("%d/%d/%d", objArr));
                MediaExtractor mediaExtractor = new MediaExtractor();
                this.mExtractor = mediaExtractor;
                try {
                    mediaExtractor.setDataSource(str, hashMap);
                } catch (IOException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" video extrator setDataSource error inputPath ");
                    sb.append(str);
                    Log.e(str3, sb.toString());
                    e2.printStackTrace();
                    setTranscodeError(-403);
                }
                if (this.mTranscodeError == null && hasAudio()) {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    this.mAudioExtractor = mediaExtractor2;
                    try {
                        mediaExtractor2.setDataSource(str);
                    } catch (IOException e3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" audio extrator setDataSource error inputPath ");
                        sb2.append(str);
                        Log.e(str3, sb2.toString());
                        e3.printStackTrace();
                        setTranscodeError(-408);
                    }
                }
                if (this.mTranscodeError == null) {
                    try {
                        this.mMuxer = new p(str2, 0);
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        setTranscodeError(-404);
                    }
                    if (this.mTranscodeError == null) {
                        setupMetadata(str);
                        try {
                            setupTrackTranscoders();
                        } catch (Exception e5) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("http setupTrackTranscoders exception ");
                            sb3.append(e5);
                            Log.e(str3, sb3.toString());
                            setTranscodeError(-409);
                        }
                        if (this.mTranscodeError == null) {
                            runPipelines();
                            this.mMuxer.b();
                        }
                    }
                }
            } else {
                if (this.mTranscodeInfo.v) {
                    Log.e(str3, "local set audio cache from true to false");
                    this.mTranscodeInfo.v = false;
                }
                if (this.mTranscodeInfo.u) {
                    Log.e(str3, "local set video cache from true to false");
                    this.mTranscodeInfo.u = false;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    try {
                        FileDescriptor fd = fileInputStream.getFD();
                        MediaExtractor mediaExtractor3 = new MediaExtractor();
                        this.mExtractor = mediaExtractor3;
                        try {
                            mediaExtractor3.setDataSource(fd);
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            setTranscodeError(-403);
                        }
                        if (this.mTranscodeError == null && hasAudio()) {
                            MediaExtractor mediaExtractor4 = new MediaExtractor();
                            this.mAudioExtractor = mediaExtractor4;
                            try {
                                mediaExtractor4.setDataSource(fd);
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                setTranscodeError(-408);
                            }
                        }
                        if (this.mTranscodeError == null) {
                            try {
                                this.mMuxer = new p(str2, 0);
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                setTranscodeError(-404);
                            }
                            if (this.mTranscodeError == null) {
                                setupMetadata(fd);
                                try {
                                    setupTrackTranscoders();
                                } catch (Exception e9) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(" setupTrackTranscoders exception ");
                                    sb4.append(e9);
                                    Log.e(str3, sb4.toString());
                                    e9.printStackTrace();
                                    setTranscodeError(-409);
                                }
                                if (this.mTranscodeError == null) {
                                    runPipelines();
                                    this.mMuxer.b();
                                }
                            }
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            Log.e(str3, "2Can't close input stream: ", e10);
                            setTranscodeError(-402);
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            Log.e(str3, "Can't close input stream: ", e12);
                            setTranscodeError(-402);
                        }
                        this.mEngineCallback.onTranscodeFail(setTranscodeError(-407));
                        return;
                    }
                } catch (FileNotFoundException e13) {
                    e13.printStackTrace();
                    this.mEngineCallback.onTranscodeFail(setTranscodeError(-401));
                    return;
                }
            }
            try {
                if (this.mVideoTrackTranscoder != null) {
                    this.mVideoTrackTranscoder.b();
                    this.mVideoTrackTranscoder = null;
                }
                if (this.mAudioTrackTranscoder != null) {
                    this.mAudioTrackTranscoder.b();
                    this.mAudioTrackTranscoder = null;
                }
                if (this.mExtractor != null) {
                    this.mExtractor.release();
                    this.mExtractor = null;
                }
                if (this.mAudioExtractor != null) {
                    this.mAudioExtractor.release();
                    this.mAudioExtractor = null;
                }
                try {
                    if (this.mMuxer != null) {
                        this.mMuxer.a();
                        this.mMuxer = null;
                    }
                } catch (RuntimeException e14) {
                    Log.e(str3, "Failed to release muxer.", e14);
                    setTranscodeError(-406);
                }
                TranscodeError transcodeError = this.mTranscodeError;
                if (transcodeError != null) {
                    this.mEngineCallback.onTranscodeFail(transcodeError);
                } else if (this.mCancel) {
                    File file = new File(this.mTranscodeInfo.f9102f);
                    if (file.exists() && !file.delete()) {
                        StringBuilder a2 = a.a("cancel delete ");
                        a2.append(this.mTranscodeInfo.f9102f);
                        a2.append(" fail");
                        Log.e(str3, a2.toString());
                    }
                    this.mEngineCallback.onTranscodeCancel();
                } else {
                    this.mEngineCallback.onTranscodeComplete();
                }
            } catch (RuntimeException e15) {
                throw new Error("Could not shutdown extractor, codecs and muxer pipeline.", e15);
            }
        } else {
            StringBuilder a3 = a.a("transcode error before start ");
            a3.append(this.mTranscodeError.getErrorCode());
            throw new IllegalArgumentException(a3.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupMetadata(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "TranscodeEngine"
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r1.setDataSource(r8, r2)
            r8 = 24
            java.lang.String r8 = r1.extractMetadata(r8)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x003e }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x003e }
            java.lang.String r4 = " rotate "
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x003e }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x003e }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x003e }
            android.util.Log.i(r0, r3)     // Catch:{ NumberFormatException -> 0x003e }
            f.a.a.c.p r3 = r7.mMuxer     // Catch:{ NumberFormatException -> 0x003e }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x003e }
            if (r3 == 0) goto L_0x003d
            f.a.a.c.p$a r4 = f.a.a.c.p.a.TRANSCODE_INIT     // Catch:{ NumberFormatException -> 0x003e }
            r3.a(r4)     // Catch:{ NumberFormatException -> 0x003e }
            android.media.MediaMuxer r3 = r3.f9110a     // Catch:{ NumberFormatException -> 0x003e }
            r3.setOrientationHint(r8)     // Catch:{ NumberFormatException -> 0x003e }
            goto L_0x003e
        L_0x003d:
            throw r2     // Catch:{ NumberFormatException -> 0x003e }
        L_0x003e:
            r8 = 23
            java.lang.String r8 = r1.extractMetadata(r8)
            if (r8 == 0) goto L_0x00a1
            java.lang.String r1 = "([+\\-][0-9.]+)([+\\-][0-9.]+)"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            r3 = 0
            r4 = 1
            java.util.regex.Matcher r1 = r1.matcher(r8)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x0076
            int r5 = r1.groupCount()
            r6 = 2
            if (r5 != r6) goto L_0x0076
            java.lang.String r5 = r1.group(r4)
            java.lang.String r1 = r1.group(r6)
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x0076 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0076 }
            float[] r6 = new float[r6]     // Catch:{ NumberFormatException -> 0x0076 }
            r6[r3] = r5     // Catch:{ NumberFormatException -> 0x0076 }
            r6[r4] = r1     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
            r6 = r2
        L_0x0077:
            if (r6 == 0) goto L_0x008d
            f.a.a.c.p r8 = r7.mMuxer
            r1 = r6[r3]
            r3 = r6[r4]
            if (r8 == 0) goto L_0x008c
            f.a.a.c.p$a r2 = f.a.a.c.p.a.TRANSCODE_INIT
            r8.a(r2)
            android.media.MediaMuxer r8 = r8.f9110a
            r8.setLocation(r1, r3)
            goto L_0x00a1
        L_0x008c:
            throw r2
        L_0x008d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse the location metadata: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r0, r8)
        L_0x00a1:
            f.a.a.c.o r8 = r7.mTranscodeInfo
            long r1 = r8.f9100d
            long r3 = r8.f9099c
            long r1 = r1 - r3
            r7.mDurationUs = r1
            java.lang.String r8 = "Duration (us): "
            java.lang.StringBuilder r8 = e.a.a.a.a.a(r8)
            long r1 = r7.mDurationUs
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.transcode.TranscodeEngine.setupMetadata(java.lang.String):void");
    }
}
