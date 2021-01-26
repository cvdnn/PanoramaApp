package com.arashivision.insbase.graphic;

import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import com.arashivision.insbase.arlog.Log;
import com.sina.weibo.sdk.constant.WBConstants;
import e.a.a.a.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class MediaCodecEncoderBridge {
    public static final String BITRATE_MODE_CBR = "cbr";
    public static final String BITRATE_MODE_CQ = "cq";
    public static final String BITRATE_MODE_VBR = "vbr";
    public static final String TAG = "MediaCodecEncoderBridge";
    public Callback mCallback = new Callback() {
        public void onError(MediaCodec mediaCodec, CodecException codecException) {
            synchronized (MediaCodecEncoderBridge.this) {
                if (!MediaCodecEncoderBridge.this.mStopped) {
                    String str = MediaCodecEncoderBridge.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError: ");
                    sb.append(codecException);
                    Log.e(str, sb.toString());
                    codecException.printStackTrace();
                    MediaCodecEncoderBridge.this.mError = true;
                }
            }
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            synchronized (MediaCodecEncoderBridge.this) {
                if (!MediaCodecEncoderBridge.this.mStopped) {
                    try {
                        Image inputImage = MediaCodecEncoderBridge.this.mMediaCodec.getInputImage(i2);
                        Plane[] planes = inputImage.getPlanes();
                        ByteBuffer[] byteBufferArr = new ByteBuffer[planes.length];
                        if (inputImage.getFormat() != 35) {
                            String str = MediaCodecEncoderBridge.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("unexpected input image format: ");
                            sb.append(String.format("0x%x", new Object[]{Integer.valueOf(inputImage.getFormat())}));
                            Log.e(str, sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("unexpected input image format: ");
                            sb2.append(String.format("0x%x", new Object[]{Integer.valueOf(inputImage.getFormat())}));
                            throw new Exception(sb2.toString());
                        } else if (planes.length == 3) {
                            int[] iArr = new int[planes.length];
                            int[] iArr2 = new int[planes.length];
                            for (int i3 = 0; i3 < planes.length; i3++) {
                                byteBufferArr[i3] = planes[i3].getBuffer();
                                iArr[i3] = planes[i3].getPixelStride();
                                iArr2[i3] = planes[i3].getRowStride();
                            }
                            MediaCodecEncoderBridge.this.nativeOnInputBufferAvailable(i2, inputImage.getWidth(), inputImage.getHeight(), byteBufferArr, iArr, iArr2);
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("encoder input buffer plane count: ");
                            sb3.append(planes.length);
                            sb3.append(", expected 3 ");
                            throw new Exception(sb3.toString());
                        }
                    } catch (Exception e2) {
                        String str2 = MediaCodecEncoderBridge.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onInputBufferAvailable met exception: ");
                        sb4.append(e2);
                        Log.e(str2, sb4.toString());
                        e2.printStackTrace();
                        MediaCodecEncoderBridge.this.nativeOnError(-1);
                    }
                }
            }
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, BufferInfo bufferInfo) {
            synchronized (MediaCodecEncoderBridge.this) {
                if (!MediaCodecEncoderBridge.this.mStopped) {
                    int i3 = i2;
                    MediaCodecEncoderBridge.this.nativeOnOutputBufferAvailable(i3, MediaCodecEncoderBridge.this.mMediaCodec.getOutputBuffer(i2), bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                }
            }
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            StringBuilder a2 = a.a("output format changed: ");
            a2.append(mediaFormat.toString());
            Log.i(MediaCodecEncoderBridge.TAG, a2.toString());
            synchronized (MediaCodecEncoderBridge.this) {
                if (!MediaCodecEncoderBridge.this.mStopped) {
                    MediaCodecEncoderBridge.this.mOutputFormat = mediaFormat;
                }
            }
        }
    };
    public Codec mCodec;
    public int mEncInputBufferSize = -1;
    public volatile boolean mError;
    public HandlerThread mHandlerThread;
    public MediaCodec mMediaCodec;
    public String mMime;
    public long mNativeInstance;
    public MediaFormat mOutputFormat;
    public volatile boolean mStopped;

    public static class Codec {
        public HashSet<String> bitrateModes = new HashSet<>();
        public MediaCodecInfo codecInfo;
        public int maxBitrate;
        public Range<Integer> qualityRange;
        public int score;

        public Codec(MediaCodecInfo mediaCodecInfo) {
            Integer valueOf = Integer.valueOf(0);
            this.qualityRange = new Range<>(valueOf, valueOf);
            this.codecInfo = mediaCodecInfo;
        }
    }

    public static Codec chooseBestCodec(ArrayList<MediaCodecInfo> arrayList, String str) {
        int i2;
        StringBuilder a2 = a.a("have ");
        a2.append(arrayList.size());
        a2.append(" hw encoder support ");
        a2.append(str);
        String sb = a2.toString();
        String str2 = TAG;
        Log.i(str2, sb);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new Codec((MediaCodecInfo) it.next()));
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Codec codec = (Codec) it2.next();
            MediaCodecInfo mediaCodecInfo = codec.codecInfo;
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
            EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, 3840, WBConstants.SDK_NEW_PAY_VERSION);
            createVideoFormat.setString("frame-rate", null);
            createVideoFormat.setInteger("color-format", 2135033992);
            if (capabilitiesForType.isFormatSupported(createVideoFormat)) {
                codec.score += 60;
            } else {
                StringBuilder a3 = a.a("encoder ");
                a3.append(mediaCodecInfo.getName());
                a3.append(" may not support 4k yuv420 flexible format");
                Log.w(str2, a3.toString());
            }
            if (encoderCapabilities.isBitrateModeSupported(2)) {
                codec.score += 10;
                codec.bitrateModes.add(BITRATE_MODE_CBR);
            }
            if (encoderCapabilities.isBitrateModeSupported(0)) {
                codec.score += 5;
                codec.bitrateModes.add(BITRATE_MODE_CQ);
            }
            if (encoderCapabilities.isBitrateModeSupported(1)) {
                codec.score += 5;
                codec.bitrateModes.add(BITRATE_MODE_VBR);
            }
            codec.maxBitrate = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        }
        Codec codec2 = (Codec) arrayList2.get(0);
        for (i2 = 1; i2 < arrayList2.size(); i2++) {
            if (((Codec) arrayList2.get(i2)).score > codec2.score) {
                codec2 = (Codec) arrayList2.get(i2);
            }
        }
        return codec2;
    }

    private synchronized int configure(Bundle bundle) {
        String string = bundle.getString("mime");
        int i2 = bundle.getInt("width");
        int i3 = bundle.getInt("height");
        int i4 = bundle.getInt("color-format");
        int i5 = bundle.getInt("bitrate");
        int i6 = bundle.getInt("frame-rate");
        int i7 = bundle.getInt("i-frame-interval");
        if (i5 > this.mCodec.maxBitrate) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("bitrate ");
            sb.append(i5);
            sb.append(" is higher than encoder max bitrate ");
            sb.append(this.mCodec.maxBitrate);
            sb.append(", adjust to ");
            sb.append(this.mCodec.maxBitrate);
            Log.w(str, sb.toString());
            i5 = this.mCodec.maxBitrate;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(string, i2, i3);
        createVideoFormat.setInteger("color-format", i4);
        createVideoFormat.setInteger("bitrate", i5);
        createVideoFormat.setInteger("frame-rate", i6);
        createVideoFormat.setInteger("i-frame-interval", i7);
        MediaFormat detectOutputFormat = detectOutputFormat(createVideoFormat);
        if (detectOutputFormat == null) {
            Log.e(TAG, "failed detect output format");
            return -1;
        }
        this.mOutputFormat = detectOutputFormat;
        try {
            this.mMediaCodec.configure(createVideoFormat, null, null, 1);
            return 0;
        } catch (Exception unused) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("failed configure encoder, format: ");
            sb2.append(createVideoFormat.toString());
            Log.e(str2, sb2.toString());
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public MediaCodec createCodec(String str) throws IOException {
        Codec selectCodec = selectCodec(str);
        if (selectCodec != null) {
            this.mCodec = selectCodec;
            StringBuilder a2 = a.a("encoder ");
            a2.append(this.mCodec.codecInfo.getName());
            a2.append(" supported bitrate modes: ");
            a2.append(this.mCodec.bitrateModes.toString());
            Log.i(TAG, a2.toString());
            return MediaCodec.createByCodecName(selectCodec.codecInfo.getName());
        }
        throw new IOException(a.a("no suitable encoder for mime type: ", str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.media.MediaFormat detectOutputFormat(android.media.MediaFormat r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "frame-rate"
            java.lang.String r3 = " ms"
            java.lang.String r4 = "detect output format cost: "
            java.lang.String r5 = "MediaCodecEncoderBridge"
            long r6 = android.os.SystemClock.elapsedRealtime()
            r8 = 0
            java.lang.String r9 = r1.mMime     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            android.media.MediaCodec r9 = r1.createCodec(r9)     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            r10 = 1
            r9.configure(r0, r8, r8, r10)     // Catch:{ Exception -> 0x00c6 }
            r9.start()     // Catch:{ Exception -> 0x00c6 }
            int r10 = r0.getInteger(r2)     // Catch:{ Exception -> 0x00c6 }
            if (r10 == 0) goto L_0x0026
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c6 }
            goto L_0x002a
        L_0x0026:
            float r0 = r0.getFloat(r2)     // Catch:{ Exception -> 0x00c6 }
        L_0x002a:
            r2 = 0
            r17 = r2
        L_0x002d:
            r10 = 0
            int r11 = r9.dequeueInputBuffer(r10)     // Catch:{ Exception -> 0x00c6 }
            r10 = -1
            if (r11 >= 0) goto L_0x006a
            if (r11 == r10) goto L_0x008b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6 }
            r0.<init>()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r2 = "detect output format, dequeue input buffer failed, return: "
            r0.append(r2)     // Catch:{ Exception -> 0x00c6 }
            r0.append(r11)     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c6 }
            com.arashivision.insbase.arlog.Log.e(r5, r0)     // Catch:{ Exception -> 0x00c6 }
            r9.release()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            long r9 = android.os.SystemClock.elapsedRealtime()
            long r9 = r9 - r6
            r0.append(r9)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.arashivision.insbase.arlog.Log.i(r5, r0)
            return r8
        L_0x006a:
            java.nio.ByteBuffer r8 = r9.getInputBuffer(r11)     // Catch:{ Exception -> 0x00c6 }
            r8.clear()     // Catch:{ Exception -> 0x00c6 }
            int r13 = r8.limit()     // Catch:{ Exception -> 0x00c6 }
            byte[] r10 = new byte[r13]     // Catch:{ Exception -> 0x00c6 }
            r8.put(r10)     // Catch:{ Exception -> 0x00c6 }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = r8 * r17
            float r8 = (float) r8     // Catch:{ Exception -> 0x00c6 }
            float r8 = r8 / r0
            long r14 = (long) r8     // Catch:{ Exception -> 0x00c6 }
            r12 = 0
            r16 = 0
            r8 = -1
            r10 = r9
            r10.queueInputBuffer(r11, r12, r13, r14, r16)     // Catch:{ Exception -> 0x00c6 }
            r10 = r8
        L_0x008b:
            android.media.MediaCodec$BufferInfo r8 = new android.media.MediaCodec$BufferInfo     // Catch:{ Exception -> 0x00c6 }
            r8.<init>()     // Catch:{ Exception -> 0x00c6 }
            r11 = 5000(0x1388, double:2.4703E-320)
            int r8 = r9.dequeueOutputBuffer(r8, r11)     // Catch:{ Exception -> 0x00c6 }
            if (r8 != r10) goto L_0x0099
            goto L_0x00c1
        L_0x0099:
            r10 = -2
            if (r8 != r10) goto L_0x00be
            android.media.MediaFormat r0 = r9.getOutputFormat()     // Catch:{ Exception -> 0x00c6 }
            r9.release()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r6
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.arashivision.insbase.arlog.Log.i(r5, r2)
            return r0
        L_0x00be:
            r9.releaseOutputBuffer(r8, r2)     // Catch:{ Exception -> 0x00c6 }
        L_0x00c1:
            int r17 = r17 + 1
            r8 = 0
            goto L_0x002d
        L_0x00c6:
            r0 = move-exception
            goto L_0x00cd
        L_0x00c8:
            r0 = move-exception
            r2 = 0
            goto L_0x0103
        L_0x00cb:
            r0 = move-exception
            r9 = 0
        L_0x00cd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r2.<init>()     // Catch:{ all -> 0x0101 }
            java.lang.String r8 = "codec exception occurred while detect output format: "
            r2.append(r8)     // Catch:{ all -> 0x0101 }
            r2.append(r0)     // Catch:{ all -> 0x0101 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0101 }
            com.arashivision.insbase.arlog.Log.e(r5, r2)     // Catch:{ all -> 0x0101 }
            r0.printStackTrace()     // Catch:{ all -> 0x0101 }
            if (r9 == 0) goto L_0x00e9
            r9.release()
        L_0x00e9:
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r4)
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r6
            r0.append(r8)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.arashivision.insbase.arlog.Log.i(r5, r0)
            r0 = 0
            return r0
        L_0x0101:
            r0 = move-exception
            r2 = r9
        L_0x0103:
            if (r2 == 0) goto L_0x0108
            r2.release()
        L_0x0108:
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r4)
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r6
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.arashivision.insbase.arlog.Log.i(r5, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.graphic.MediaCodecEncoderBridge.detectOutputFormat(android.media.MediaFormat):android.media.MediaFormat");
    }

    public static int getCodecInfo(String str, int i2, int i3, String[] strArr, int[] iArr, double[] dArr) {
        Codec selectCodec = selectCodec(str);
        if (selectCodec == null) {
            return -22;
        }
        VideoCapabilities videoCapabilities = selectCodec.codecInfo.getCapabilitiesForType(str).getVideoCapabilities();
        strArr[0] = selectCodec.codecInfo.getName();
        iArr[0] = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        dArr[0] = ((Double) videoCapabilities.getSupportedFrameRatesFor(i2, i3).getUpper()).doubleValue();
        return 0;
    }

    public static MediaCodecInfo[] getCodecInfos() {
        return new MediaCodecList(1).getCodecInfos();
    }

    private synchronized Bundle getOutputFormat() {
        if (this.mOutputFormat == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("width", this.mOutputFormat.getInteger("width"));
        bundle.putInt("height", this.mOutputFormat.getInteger("height"));
        String[] strArr = {"csd-0", "csd-1"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            ByteBuffer byteBuffer = this.mOutputFormat.getByteBuffer(str);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            bundle.putByteArray(str, bArr);
        }
        return bundle;
    }

    private int init(final String str) {
        this.mMime = str;
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        final int[] iArr = new int[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() {
            public void run() {
                try {
                    MediaCodecEncoderBridge.this.mMediaCodec = MediaCodecEncoderBridge.this.createCodec(str);
                    iArr[0] = 0;
                    MediaCodecEncoderBridge.this.mMediaCodec.setCallback(MediaCodecEncoderBridge.this.mCallback);
                    countDownLatch.countDown();
                } catch (Exception e2) {
                    StringBuilder a2 = a.a("failed create encoder: ");
                    a2.append(str);
                    a2.append(", error: ");
                    a2.append(e2);
                    Log.e(MediaCodecEncoderBridge.TAG, a2.toString());
                    e2.printStackTrace();
                    iArr[0] = -1;
                    countDownLatch.countDown();
                }
            }
        });
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return iArr[0];
    }

    /* access modifiers changed from: private */
    public native void nativeOnError(int i2);

    /* access modifiers changed from: private */
    public native void nativeOnInputBufferAvailable(int i2, int i3, int i4, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2);

    /* access modifiers changed from: private */
    public native void nativeOnOutputBufferAvailable(int i2, ByteBuffer byteBuffer, int i3, int i4, long j2, int i5);

    private int queueInputBuffer(int i2, int i3, int i4, long j2, int i5) {
        if (this.mStopped || this.mError) {
            return 0;
        }
        try {
            if (this.mEncInputBufferSize < 0) {
                this.mEncInputBufferSize = this.mMediaCodec.getInputBuffer(i2).capacity();
            }
            this.mMediaCodec.queueInputBuffer(i2, i3, (i5 & 4) > 0 ? 0 : this.mEncInputBufferSize, j2, i5);
            return 0;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("queueInputBuffer met exception: ");
            sb.append(e2);
            Log.e(TAG, sb.toString());
            e2.printStackTrace();
            return -1;
        }
    }

    private void release() {
        if (!this.mStopped) {
            Log.e(TAG, "release, not stopped");
            stop();
        }
        this.mHandlerThread.quit();
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.release();
        }
    }

    private int releaseOutputBuffer(int i2) {
        if (this.mStopped || this.mError) {
            return 0;
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i2, true);
            return 0;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("releaseOutputBuffer met exception: ");
            sb.append(e2);
            Log.e(TAG, sb.toString());
            e2.printStackTrace();
            return -1;
        }
    }

    public static Codec selectCodec(String str) {
        MediaCodecInfo[] codecInfos;
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 < supportedTypes.length) {
                        if (supportedTypes[i2].equalsIgnoreCase(str) && !mediaCodecInfo.getName().startsWith("OMX.google.") && !mediaCodecInfo.getName().toLowerCase().contains("ffmpeg") && mediaCodecInfo.getName().toLowerCase().startsWith("omx.")) {
                            arrayList.add(mediaCodecInfo);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return chooseBestCodec(arrayList, str);
    }

    private synchronized int start() {
        try {
            this.mMediaCodec.start();
        } catch (Exception e2) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("failed start encoder: ");
            sb.append(e2);
            Log.e(str, sb.toString());
            e2.printStackTrace();
            return -1;
        }
        return 0;
    }

    private synchronized int stop() {
        if (this.mStopped) {
            return 0;
        }
        this.mStopped = true;
        if (this.mMediaCodec == null) {
            Log.e(TAG, "failed stop encoder: mMediaCodec is null");
            return -1;
        }
        try {
            this.mMediaCodec.stop();
            this.mMediaCodec.release();
            return 0;
        } catch (Exception e2) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("failed stop encoder: ");
            sb.append(e2);
            Log.e(str, sb.toString());
            e2.printStackTrace();
            return -1;
        }
    }
}
