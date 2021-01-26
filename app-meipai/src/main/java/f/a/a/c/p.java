package f.a.a.c;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: TranscodeMuxer */
public class p {

    /* renamed from: a reason: collision with root package name */
    public MediaMuxer f9110a;

    /* renamed from: b reason: collision with root package name */
    public a f9111b = a.TRANSCODE_IDLE;

    /* compiled from: TranscodeMuxer */
    public enum a {
        TRANSCODE_IDLE,
        TRANSCODE_INIT,
        TRANSCODE_START,
        TRANSCODE_STOP
    }

    public p(String str, int i2) throws IOException {
        this.f9110a = new MediaMuxer(str, i2);
        this.f9111b = a.TRANSCODE_INIT;
    }

    public void a(a aVar) {
        if (aVar != this.f9111b) {
            StringBuilder a2 = e.a.a.a.a.a("bad muxer status ");
            a2.append(this.f9111b);
            a2.append(" but require ");
            a2.append(aVar);
            throw new IllegalArgumentException(a2.toString());
        }
    }

    public void b() {
        if (a.TRANSCODE_START == this.f9111b) {
            this.f9110a.stop();
            this.f9111b = a.TRANSCODE_STOP;
            return;
        }
        Log.e("TranscodeMuxer", "stop without start , called quickly cancel when transcode?");
    }

    public int a(MediaFormat mediaFormat) {
        a(a.TRANSCODE_INIT);
        return this.f9110a.addTrack(mediaFormat);
    }

    public void a(int i2, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        a(a.TRANSCODE_START);
        this.f9110a.writeSampleData(i2, byteBuffer, bufferInfo);
    }

    public void a() {
        a aVar = this.f9111b;
        if (aVar == a.TRANSCODE_INIT || a.TRANSCODE_STOP == aVar) {
            this.f9110a.release();
            this.f9110a = null;
            this.f9111b = a.TRANSCODE_IDLE;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("bad release status ");
        a2.append(this.f9111b);
        throw new IllegalArgumentException(a2.toString());
    }
}
