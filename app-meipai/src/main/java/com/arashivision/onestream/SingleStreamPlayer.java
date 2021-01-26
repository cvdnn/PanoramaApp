package com.arashivision.onestream;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.Surface;
import com.arashivision.onestream.DualStreamUtil.RenderInfo;
import com.arashivision.onestream.DualStreamUtil.SystemClock;
import com.arashivision.onestream.Gyro.ByteBuf;
import com.arashivision.onestream.SurfaceClient.ImageInfo;
import e.a.a.a.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public class SingleStreamPlayer {
    public static final boolean VERBOSE = false;
    public static final int kMaxCachePackets = 5;
    public final String TAG;
    public boolean mCSDSent;
    public CodecInput mCodecInput;
    public LinkedList<Integer> mCodecInputList;
    public MediaCodec mDecoder;
    public long mDelayDeadline;
    public int mError;
    public boolean mFirstIFrame;
    public String mFormat;
    public LongSparseArray<ImageInfo> mFrameInfoList = new LongSparseArray<>();
    public SmoothInputSource mInputSource;
    public boolean mOutputEos;
    public MediaFormat mOutputFormat;
    public boolean mPlayerStopped;
    public RenderAvailableCallback mRenderCallback;
    public boolean mStarted;
    public Surface mSurface;
    public Object mSyncCodec = new Object();
    public SystemClock mSystemClock = new SystemClock();
    public int mVideoHeight;
    public final LinkedList<ImageData> mVideoPackets = new LinkedList<>();
    public int mVideoWidth;

    public class CodecInput {
        public boolean mReleased;
        public Thread mThread;

        public CodecInput() {
            Thread thread = new Thread(new Runnable(SingleStreamPlayer.this) {
                /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r4 = this;
                    L_0x0000:
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r0 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this
                        com.arashivision.onestream.SingleStreamPlayer r0 = com.arashivision.onestream.SingleStreamPlayer.this
                        java.util.LinkedList<java.lang.Integer> r0 = r0.mCodecInputList
                        monitor-enter(r0)
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r1 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this     // Catch:{ all -> 0x0045 }
                        boolean r1 = r1.mReleased     // Catch:{ all -> 0x0045 }
                        if (r1 == 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                        goto L_0x0044
                    L_0x0011:
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r1 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this     // Catch:{ all -> 0x0045 }
                        com.arashivision.onestream.SingleStreamPlayer r1 = com.arashivision.onestream.SingleStreamPlayer.this     // Catch:{ all -> 0x0045 }
                        java.util.LinkedList<java.lang.Integer> r1 = r1.mCodecInputList     // Catch:{ all -> 0x0045 }
                        r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                        com.arashivision.onestream.DualStreamUtil.waitUntil(r1, r2)     // Catch:{ all -> 0x0045 }
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r1 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this     // Catch:{ all -> 0x0045 }
                        com.arashivision.onestream.SingleStreamPlayer r1 = com.arashivision.onestream.SingleStreamPlayer.this     // Catch:{ all -> 0x0045 }
                        java.util.LinkedList<java.lang.Integer> r1 = r1.mCodecInputList     // Catch:{ all -> 0x0045 }
                        boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0045 }
                        if (r1 != 0) goto L_0x0034
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r1 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this     // Catch:{ all -> 0x0045 }
                        com.arashivision.onestream.SingleStreamPlayer r1 = com.arashivision.onestream.SingleStreamPlayer.this     // Catch:{ all -> 0x0045 }
                        r1.fillInputSource()     // Catch:{ all -> 0x0045 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                        goto L_0x0000
                    L_0x0034:
                        com.arashivision.onestream.SingleStreamPlayer$CodecInput r1 = com.arashivision.onestream.SingleStreamPlayer.CodecInput.this     // Catch:{ all -> 0x0045 }
                        boolean r1 = r1.mReleased     // Catch:{ all -> 0x0045 }
                        if (r1 != 0) goto L_0x0043
                        java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0045 }
                        java.lang.String r2 = "CodecInput mReleased not released"
                        r1.<init>(r2)     // Catch:{ all -> 0x0045 }
                    L_0x0043:
                        monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                    L_0x0044:
                        return
                    L_0x0045:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.SingleStreamPlayer.CodecInput.AnonymousClass1.run():void");
                }
            });
            this.mThread = thread;
            thread.start();
        }

        public void release() {
            Log.d("OneCodecInput", "release");
            synchronized (SingleStreamPlayer.this.mCodecInputList) {
                this.mReleased = true;
                SingleStreamPlayer.this.mCodecInputList.clear();
                SingleStreamPlayer.this.mCodecInputList.notifyAll();
            }
            try {
                this.mThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Log.d("OneCodecInput", "release over");
        }
    }

    public class CodecInputInfo {
        public int inputBufIndex;
        public ImageData packet;

        public CodecInputInfo() {
        }
    }

    public class CodecOutputInfo {
        public BufferInfo info;
        public int outputIndex;

        public CodecOutputInfo() {
        }
    }

    public interface RenderAvailableCallback {
        void onDropFrame(LinkedList<ImageData> linkedList);

        void onError(SingleStreamPlayer singleStreamPlayer, int i2);

        void onForceRender();

        void onInput(long j2, RenderInfo renderInfo);
    }

    public static class SmoothInputSource {
        public final String TAG;
        public InputDataAvailableCallback mCallback;
        public boolean mDebug;
        public double mFps;
        public long mInputIntervalNs;
        public final LinkedList<ImageData> mInputQueue = new LinkedList<>();
        public long mLastInputTimeNs;
        public int mMinCacheSize;
        public long mOrgInputIntervalNs;
        public boolean mReleased;
        public Thread mThread;
        public long mWaitTimeNs;

        public interface InputDataAvailableCallback {
            void onInputData(ImageData imageData);
        }

        public SmoothInputSource(String str, double d2, int i2, InputDataAvailableCallback inputDataAvailableCallback) {
            this.TAG = str;
            this.mFps = d2;
            this.mMinCacheSize = i2;
            this.mCallback = inputDataAvailableCallback;
            this.mLastInputTimeNs = System.nanoTime();
            this.mWaitTimeNs = 30000000;
            Thread thread = new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e3, code lost:
                    com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.access$900(r9.this$0).onInputData(r1);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r9 = this;
                    L_0x0000:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r0 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this
                        java.util.LinkedList r0 = r0.mInputQueue
                        monitor-enter(r0)
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r1 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        boolean r1 = r1.mReleased     // Catch:{ all -> 0x00ee }
                        if (r1 == 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x00ee }
                        return
                    L_0x0011:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r1 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        java.util.LinkedList r1 = r1.mInputQueue     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r2 = r2.mLastInputTimeNs     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r4 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r4 = r4.mWaitTimeNs     // Catch:{ all -> 0x00ee }
                        long r2 = r2 + r4
                        com.arashivision.onestream.DualStreamUtil.waitUntil(r1, r2)     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r1 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        java.util.LinkedList r1 = r1.mInputQueue     // Catch:{ all -> 0x00ee }
                        boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ee }
                        if (r1 == 0) goto L_0x003e
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r1 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00ee }
                        r1.mLastInputTimeNs = r2     // Catch:{ all -> 0x00ee }
                        monitor-exit(r0)     // Catch:{ all -> 0x00ee }
                        goto L_0x0000
                    L_0x003e:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r1 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        java.util.LinkedList r1 = r1.mInputQueue     // Catch:{ all -> 0x00ee }
                        java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.ImageData r1 = (com.arashivision.onestream.ImageData) r1     // Catch:{ all -> 0x00ee }
                        long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r4 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r4 = r4.mLastInputTimeNs     // Catch:{ all -> 0x00ee }
                        long r2 = r2 - r4
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r4 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r4 = r4.mOrgInputIntervalNs     // Catch:{ all -> 0x00ee }
                        r6 = 2
                        long r4 = r4 * r6
                        int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r4 <= 0) goto L_0x00d4
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r4 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        boolean r4 = r4.mDebug     // Catch:{ all -> 0x00ee }
                        if (r4 == 0) goto L_0x00be
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r4 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        java.lang.String r4 = r4.TAG     // Catch:{ all -> 0x00ee }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
                        r5.<init>()     // Catch:{ all -> 0x00ee }
                        java.lang.String r8 = "feed interval "
                        r5.append(r8)     // Catch:{ all -> 0x00ee }
                        long r2 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setNsToMs(r2)     // Catch:{ all -> 0x00ee }
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        java.lang.String r2 = " mWaitTimeNs "
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r2 = r2.mWaitTimeNs     // Catch:{ all -> 0x00ee }
                        long r2 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setNsToMs(r2)     // Catch:{ all -> 0x00ee }
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        java.lang.String r2 = " size "
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        java.util.LinkedList r2 = r2.mInputQueue     // Catch:{ all -> 0x00ee }
                        int r2 = r2.size()     // Catch:{ all -> 0x00ee }
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        java.lang.String r2 = " mInputIntervalNs "
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r2 = r2.mInputIntervalNs     // Catch:{ all -> 0x00ee }
                        long r2 = com.arashivision.onestream.DualStreamUtil.ClockUtil.setNsToMs(r2)     // Catch:{ all -> 0x00ee }
                        r5.append(r2)     // Catch:{ all -> 0x00ee }
                        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00ee }
                        android.util.Log.w(r4, r2)     // Catch:{ all -> 0x00ee }
                    L_0x00be:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        boolean r3 = com.arashivision.onestream.DualStreamUtil.isIFrame(r1)     // Catch:{ all -> 0x00ee }
                        if (r3 == 0) goto L_0x00c9
                        r3 = 0
                        goto L_0x00d0
                    L_0x00c9:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r3 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r3 = r3.mOrgInputIntervalNs     // Catch:{ all -> 0x00ee }
                        long r3 = r3 / r6
                    L_0x00d0:
                        r2.mInputIntervalNs = r3     // Catch:{ all -> 0x00ee }
                        goto L_0x00d9
                    L_0x00d4:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        r2.resumeInterval()     // Catch:{ all -> 0x00ee }
                    L_0x00d9:
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r2 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this     // Catch:{ all -> 0x00ee }
                        long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00ee }
                        r2.mLastInputTimeNs = r3     // Catch:{ all -> 0x00ee }
                        monitor-exit(r0)     // Catch:{ all -> 0x00ee }
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource r0 = com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.this
                        com.arashivision.onestream.SingleStreamPlayer$SmoothInputSource$InputDataAvailableCallback r0 = r0.mCallback
                        r0.onInputData(r1)
                        goto L_0x0000
                    L_0x00ee:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x00ee }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.SingleStreamPlayer.SmoothInputSource.AnonymousClass1.run():void");
                }
            });
            this.mThread = thread;
            thread.start();
        }

        /* access modifiers changed from: private */
        public void resumeInterval() {
            this.mInputIntervalNs = this.mOrgInputIntervalNs;
        }

        public void finalize() throws Throwable {
            if (!this.mReleased) {
                release();
            }
            super.finalize();
        }

        public void putData(ImageData imageData) {
            synchronized (this.mInputQueue) {
                this.mInputQueue.add(imageData);
                if (this.mInputQueue.size() >= this.mMinCacheSize) {
                    this.mWaitTimeNs = (this.mInputIntervalNs * ((long) this.mMinCacheSize)) / ((long) this.mInputQueue.size());
                } else {
                    this.mWaitTimeNs = this.mInputIntervalNs;
                }
            }
        }

        public void release() {
            synchronized (this.mInputQueue) {
                this.mReleased = true;
                this.mInputQueue.clear();
                this.mInputQueue.notifyAll();
            }
            try {
                this.mThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        public void setFps(double d2) {
            this.mFps = d2;
            this.mOrgInputIntervalNs = (long) (1.0E9d / d2);
            resumeInterval();
        }
    }

    public SingleStreamPlayer(String str) {
        this.TAG = str;
        SmoothInputSource smoothInputSource = new SmoothInputSource(str, 30.0d, 3, new InputDataAvailableCallback() {
            public void onInputData(ImageData imageData) {
                SingleStreamPlayer.this.putToDecodingQueue(imageData);
            }
        });
        this.mInputSource = smoothInputSource;
        this.mCodecInput = new CodecInput();
        this.mCodecInputList = new LinkedList<>();
    }

    /* access modifiers changed from: private */
    public void drainDecoderOutput(int i2, BufferInfo bufferInfo) {
        if (!this.mOutputEos) {
            ImageInfo imageInfo = (ImageInfo) this.mFrameInfoList.get(bufferInfo.presentationTimeUs);
            if (imageInfo == null) {
                String str = this.TAG;
                StringBuilder a2 = a.a("frame info lost, is decoder changed the pts(");
                a2.append(bufferInfo.presentationTimeUs);
                a2.append(")? mPendingRenderBuffer ");
                a2.append(i2);
                Log.e(str, a2.toString());
                synchronized (this.mSyncCodec) {
                    if (this.mDecoder != null) {
                        this.mDecoder.releaseOutputBuffer(i2, false);
                        return;
                    }
                    return;
                }
            }
            RenderAvailableCallback renderAvailableCallback = this.mRenderCallback;
            long j2 = imageInfo.timestampNs;
            RenderInfo renderInfo = new RenderInfo(i2, bufferInfo.presentationTimeUs, j2, imageInfo.mIFrame, imageInfo.byteBuf);
            renderAvailableCallback.onInput(j2, renderInfo);
            if ((bufferInfo.flags & 4) != 0) {
                Log.d(this.TAG, "decoder output end");
                this.mOutputEos = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fillInputSource() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mSyncCodec
            monitor-enter(r0)
            android.media.MediaCodec r1 = r3.mDecoder     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0009:
            java.util.LinkedList<java.lang.Integer> r1 = r3.mCodecInputList     // Catch:{ all -> 0x0033 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0031
            java.util.LinkedList<com.arashivision.onestream.ImageData> r1 = r3.mVideoPackets     // Catch:{ all -> 0x0033 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0031
            java.util.LinkedList<java.lang.Integer> r1 = r3.mCodecInputList     // Catch:{ all -> 0x0033 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0033 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0033 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0033 }
            java.util.LinkedList<com.arashivision.onestream.ImageData> r2 = r3.mVideoPackets     // Catch:{ all -> 0x0033 }
            java.lang.Object r2 = r2.removeFirst()     // Catch:{ all -> 0x0033 }
            com.arashivision.onestream.ImageData r2 = (com.arashivision.onestream.ImageData) r2     // Catch:{ all -> 0x0033 }
            r3.fillInputSource(r1, r2)     // Catch:{ all -> 0x0033 }
            goto L_0x0009
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.SingleStreamPlayer.fillInputSource():void");
    }

    private void initDecoder(ImageData imageData) {
        if (this.mDecoder == null) {
            byte[] bArr = imageData.csd;
            if (bArr == null) {
                Log.e(this.TAG, "no csd data, cannot init decoder");
                notifyAndSetError(-201);
                return;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                String str = this.TAG;
                StringBuilder a2 = a.a("init decoder, csd size: ");
                a2.append(bArr.length);
                a2.append(" surface ");
                a2.append(surface);
                Log.i(str, a2.toString());
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if ("h264".equals(this.mFormat)) {
                    String str2 = "video/avc";
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str2, this.mVideoWidth, this.mVideoHeight);
                    createVideoFormat.setByteBuffer("csd-0", wrap);
                    try {
                        this.mDecoder = MediaCodec.createDecoderByType(str2);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    MediaCodec mediaCodec = this.mDecoder;
                    if (mediaCodec == null) {
                        notifyAndSetError(-201);
                    } else {
                        mediaCodec.setCallback(new Callback() {
                            public void onError(MediaCodec mediaCodec, CodecException codecException) {
                                String str = SingleStreamPlayer.this.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("codec error ");
                                sb.append(codecException);
                                Log.e(str, sb.toString());
                                codecException.printStackTrace();
                            }

                            public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
                                synchronized (SingleStreamPlayer.this.mCodecInputList) {
                                    SingleStreamPlayer.this.mCodecInputList.add(Integer.valueOf(i2));
                                    SingleStreamPlayer.this.mCodecInputList.notifyAll();
                                }
                            }

                            public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, BufferInfo bufferInfo) {
                                SingleStreamPlayer.this.drainDecoderOutput(i2, bufferInfo);
                            }

                            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                                Log.i(SingleStreamPlayer.this.TAG, "onOutputFormatChanged ");
                                SingleStreamPlayer.this.mOutputFormat = mediaFormat;
                            }
                        });
                        this.mDecoder.configure(createVideoFormat, surface, null, 0);
                        this.mDecoder.start();
                        Log.d(this.TAG, "init decoder suc");
                    }
                    return;
                }
                throw new RuntimeException("input format not set");
            }
            Log.e(this.TAG, "surface not set when create decoder");
            throw new RuntimeException("initDecoder: surface not set!");
        }
        throw new RuntimeException("startDecoder decoder not null");
    }

    private void notifyAndSetError(int i2) {
        if (this.mError == 0) {
            this.mError = i2;
            this.mRenderCallback.onError(this, i2);
        }
    }

    private void onCoreStop() {
        this.mRenderCallback.onForceRender();
        synchronized (this.mSyncCodec) {
            if (this.mDecoder != null) {
                this.mDecoder.stop();
                this.mDecoder.release();
                this.mDecoder = null;
            }
        }
        this.mSystemClock.reset();
        this.mPlayerStopped = true;
    }

    /* access modifiers changed from: private */
    public void putToDecodingQueue(ImageData imageData) {
        synchronized (this.mCodecInputList) {
            this.mVideoPackets.add(imageData);
            fillInputSource();
            if (this.mVideoPackets.size() > 5) {
                long nanoTime = System.nanoTime();
                if (this.mDelayDeadline == 0) {
                    this.mDelayDeadline = nanoTime + 200000000;
                } else if (this.mDelayDeadline <= nanoTime) {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append(" playback too slow size ");
                    sb.append(this.mVideoPackets.size());
                    Log.e(str, sb.toString());
                    this.mRenderCallback.onDropFrame(this.mVideoPackets);
                    String str2 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("after drop  size ");
                    sb2.append(this.mVideoPackets.size());
                    Log.e(str2, sb2.toString());
                    this.mDelayDeadline = 0;
                } else {
                    String str3 = this.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("playback slow still size ");
                    sb3.append(this.mVideoPackets.size());
                    Log.w(str3, sb3.toString());
                }
            } else {
                this.mDelayDeadline = 0;
            }
        }
    }

    private void stop() {
        onCoreStop();
    }

    public void postRender(RenderInfo renderInfo, boolean z) {
        render(renderInfo.mIndex, renderInfo.mPts, z);
    }

    public void put(ImageData imageData) {
        if (!this.mFirstIFrame) {
            if (!DualStreamUtil.isIFrame(imageData)) {
                String str = this.TAG;
                StringBuilder a2 = a.a(" skip non-iframe ");
                a2.append(imageData.flags);
                Log.w(str, a2.toString());
                return;
            }
            this.mFirstIFrame = true;
            initDecoder(imageData);
        }
        this.mInputSource.putData(imageData);
    }

    public void release() {
        this.mInputSource.release();
        CodecInput codecInput = this.mCodecInput;
        if (codecInput != null) {
            codecInput.release();
        }
        stop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(int r5, long r6, boolean r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mSyncCodec
            monitor-enter(r0)
            android.media.MediaCodec r1 = r4.mDecoder     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0009:
            android.util.LongSparseArray<com.arashivision.onestream.SurfaceClient$ImageInfo> r1 = r4.mFrameInfoList     // Catch:{ all -> 0x0053 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = r4.TAG     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r2.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = " fatal frame info changed unexpectedly,"
            r2.append(r3)     // Catch:{ all -> 0x0053 }
            r2.append(r6)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = "  renderIdx "
            r2.append(r6)     // Catch:{ all -> 0x0053 }
            r2.append(r5)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = " mFrameInfoList size "
            r2.append(r6)     // Catch:{ all -> 0x0053 }
            android.util.LongSparseArray<com.arashivision.onestream.SurfaceClient$ImageInfo> r6 = r4.mFrameInfoList     // Catch:{ all -> 0x0053 }
            int r6 = r6.size()     // Catch:{ all -> 0x0053 }
            r2.append(r6)     // Catch:{ all -> 0x0053 }
            r2.append(r8)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0053 }
            android.util.Log.e(r1, r6)     // Catch:{ all -> 0x0053 }
            android.media.MediaCodec r6 = r4.mDecoder     // Catch:{ all -> 0x0053 }
            r7 = 0
            r6.releaseOutputBuffer(r5, r7)     // Catch:{ all -> 0x0053 }
            goto L_0x0051
        L_0x0047:
            android.util.LongSparseArray<com.arashivision.onestream.SurfaceClient$ImageInfo> r1 = r4.mFrameInfoList     // Catch:{ all -> 0x0053 }
            r1.remove(r6)     // Catch:{ all -> 0x0053 }
            android.media.MediaCodec r6 = r4.mDecoder     // Catch:{ all -> 0x0053 }
            r6.releaseOutputBuffer(r5, r8)     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0053:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.SingleStreamPlayer.render(int, long, boolean):void");
    }

    public void setFormat(String str) {
        this.mFormat = str;
    }

    public void setFps(double d2) {
        this.mInputSource.setFps(d2);
    }

    public void setPreviewSurface(Surface surface) {
        this.mSurface = surface;
    }

    public void setRenderCallback(RenderAvailableCallback renderAvailableCallback) {
        this.mRenderCallback = renderAvailableCallback;
    }

    public void setVideoSize(int i2, int i3) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" w ");
        sb.append(i2);
        sb.append(" h ");
        sb.append(i3);
        Log.i(str, sb.toString());
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }

    public void start() {
        this.mSystemClock.start();
    }

    private void fillInputSource(int i2, ImageData imageData) {
        MediaCodec mediaCodec = this.mDecoder;
        long currentTimeUs = this.mSystemClock.getCurrentTimeUs();
        int i3 = imageData.flags;
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.timestampNs = imageData.timestampNs;
        imageInfo.mIFrame = i3;
        if (imageInfo.isIFrame()) {
            ByteBuf byteBuf = new ByteBuf();
            imageInfo.byteBuf = byteBuf;
            byteBuf.data = imageData.data;
            byteBuf.offset = imageData.data_offset;
            byteBuf.size = imageData.data_size;
        }
        this.mFrameInfoList.append(currentTimeUs, imageInfo);
        ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i2);
        inputBuffer.clear();
        if (!this.mCSDSent) {
            inputBuffer.put(imageData.csd);
            this.mCSDSent = true;
        }
        inputBuffer.put(imageData.data, imageData.data_offset, imageData.data_size);
        inputBuffer.flip();
        mediaCodec.queueInputBuffer(i2, 0, inputBuffer.remaining(), currentTimeUs, i3);
    }
}
