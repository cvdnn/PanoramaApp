package e.d.a.n.p.h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import e.d.a.n.h;
import e.d.a.n.n.w;
import e.d.a.n.p.d.b;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a reason: collision with root package name */
    public final CompressFormat f7791a = CompressFormat.JPEG;

    /* renamed from: b reason: collision with root package name */
    public final int f7792b = 100;

    public w<byte[]> a(w<Bitmap> wVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) wVar.get()).compress(this.f7791a, this.f7792b, byteArrayOutputStream);
        wVar.b();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
