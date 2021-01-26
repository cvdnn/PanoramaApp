package e.d.a.n.p.c;

import android.media.MediaDataSource;
import e.d.a.n.p.c.b0.d;
import java.nio.ByteBuffer;

/* compiled from: VideoDecoder */
public class c0 extends MediaDataSource {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f7672a;

    public c0(d dVar, ByteBuffer byteBuffer) {
        this.f7672a = byteBuffer;
    }

    public void close() {
    }

    public long getSize() {
        return (long) this.f7672a.limit();
    }

    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        if (j2 >= ((long) this.f7672a.limit())) {
            return -1;
        }
        this.f7672a.position((int) j2);
        int min = Math.min(i3, this.f7672a.remaining());
        this.f7672a.get(bArr, i2, min);
        return min;
    }
}
