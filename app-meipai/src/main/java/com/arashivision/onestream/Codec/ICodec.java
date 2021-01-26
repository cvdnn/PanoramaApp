package com.arashivision.onestream.Codec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

public interface ICodec {
    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2);

    int dequeueInputBuffer(long j2);

    int dequeueOutputBuffer(BufferInfo bufferInfo, long j2);

    void flush();

    ByteBuffer getInputBuffer(int i2);

    void queueInputBuffer(int i2, int i3, int i4, long j2, int i5);

    void release();

    void releaseOutputBuffer(int i2, boolean z);

    void start();

    void stop();
}
