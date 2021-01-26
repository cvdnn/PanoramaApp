package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.t.a;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder */
public class g implements j<ByteBuffer, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final m f7676a;

    public g(m mVar) {
        this.f7676a = mVar;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        return this.f7676a.a(a.b((ByteBuffer) obj), i2, i3, hVar, m.k);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (this.f7676a != null) {
            return true;
        }
        throw null;
    }
}
