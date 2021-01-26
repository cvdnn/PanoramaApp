package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder */
public final class h implements j<ByteBuffer, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final d f7677a = new d();

    public w a(Object obj, int i2, int i3, e.d.a.n.h hVar) throws IOException {
        return this.f7677a.a(ImageDecoder.createSource((ByteBuffer) obj), i2, i3, hVar);
    }

    public boolean a(Object obj, e.d.a.n.h hVar) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        return true;
    }
}
