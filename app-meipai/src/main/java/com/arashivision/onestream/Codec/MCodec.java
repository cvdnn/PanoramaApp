package com.arashivision.onestream.Codec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MCodec implements ICodec {
    public ByteBuffer[] mInputBuffers;
    public MediaCodec mMediaCodec;

    public MCodec(MediaCodec mediaCodec) {
        this.mMediaCodec = mediaCodec;
    }

    public static MCodec createDecoderByType(String str) throws IOException {
        return new MCodec(MediaCodec.createDecoderByType(str));
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        this.mMediaCodec.configure(mediaFormat, surface, mediaCrypto, i2);
    }

    public int dequeueInputBuffer(long j2) {
        return this.mMediaCodec.dequeueInputBuffer(j2);
    }

    public int dequeueOutputBuffer(BufferInfo bufferInfo, long j2) {
        return this.mMediaCodec.dequeueOutputBuffer(bufferInfo, j2);
    }

    public void flush() {
        this.mMediaCodec.flush();
    }

    public ByteBuffer getInputBuffer(int i2) {
        return this.mMediaCodec.getInputBuffer(i2);
    }

    public void queueInputBuffer(int i2, int i3, int i4, long j2, int i5) {
        this.mMediaCodec.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void release() {
        this.mMediaCodec.release();
    }

    public void releaseOutputBuffer(int i2, boolean z) {
        this.mMediaCodec.releaseOutputBuffer(i2, z);
    }

    public void start() {
        this.mMediaCodec.start();
    }

    public void stop() {
        this.mMediaCodec.stop();
    }
}
