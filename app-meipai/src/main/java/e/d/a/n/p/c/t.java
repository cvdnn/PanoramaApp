package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.t.a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder */
public final class t implements j<InputStream, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final d f7722a = new d();

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        return this.f7722a.a(ImageDecoder.createSource(a.a((InputStream) obj)), i2, i3, hVar);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        InputStream inputStream = (InputStream) obj;
        return true;
    }
}
