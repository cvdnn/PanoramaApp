package f.a.a.c;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: AudioChannel */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final Queue<b> f9001a = new ArrayDeque();

    /* renamed from: b reason: collision with root package name */
    public final Queue<b> f9002b = new ArrayDeque();

    /* renamed from: c reason: collision with root package name */
    public final MediaCodec f9003c;

    /* renamed from: d reason: collision with root package name */
    public final MediaCodec f9004d;

    /* renamed from: e reason: collision with root package name */
    public final MediaFormat f9005e;

    /* renamed from: f reason: collision with root package name */
    public int f9006f;

    /* renamed from: g reason: collision with root package name */
    public int f9007g;

    /* renamed from: h reason: collision with root package name */
    public int f9008h;

    /* renamed from: i reason: collision with root package name */
    public b f9009i;

    /* renamed from: j reason: collision with root package name */
    public final f.a.a.b.a f9010j;
    public final f.a.a.b.a k;
    public final b l = new b(null);
    public MediaFormat m;

    /* compiled from: AudioChannel */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public int f9011a;

        /* renamed from: b reason: collision with root package name */
        public long f9012b;

        /* renamed from: c reason: collision with root package name */
        public ShortBuffer f9013c;

        public b() {
        }

        public /* synthetic */ b(C0137a aVar) {
        }
    }

    public a(MediaCodec mediaCodec, MediaCodec mediaCodec2, MediaFormat mediaFormat) {
        this.f9003c = mediaCodec;
        this.f9004d = mediaCodec2;
        this.f9005e = mediaFormat;
        this.f9010j = new f.a.a.b.a(mediaCodec);
        this.k = new f.a.a.b.a(this.f9004d);
    }

    public void a(int i2, long j2) {
        ByteBuffer byteBuffer;
        String str = "AudioChannel";
        if (this.m != null) {
            ShortBuffer shortBuffer = null;
            if (i2 == -1) {
                byteBuffer = null;
            } else {
                byteBuffer = this.f9010j.f8998a.getOutputBuffer(i2);
            }
            b bVar = (b) this.f9001a.poll();
            if (bVar == null) {
                bVar = new b(null);
            }
            bVar.f9011a = i2;
            bVar.f9012b = j2;
            if (byteBuffer != null) {
                shortBuffer = byteBuffer.asShortBuffer();
            }
            bVar.f9013c = shortBuffer;
            b bVar2 = this.l;
            if (bVar2.f9013c == null) {
                if (byteBuffer != null) {
                    bVar2.f9013c = ByteBuffer.allocateDirect(byteBuffer.capacity()).order(ByteOrder.nativeOrder()).asShortBuffer();
                    this.l.f9013c.clear().flip();
                } else {
                    Log.e(str, "first audio data null");
                }
            }
            this.f9002b.add(bVar);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error audio channel bufferIndex ");
        sb.append(i2);
        sb.append(" presentationTimeUs ");
        sb.append(j2);
        Log.e(str, sb.toString());
        throw new RuntimeException("Buffer received before format!");
    }
}
