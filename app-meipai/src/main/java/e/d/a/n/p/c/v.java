package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.n.p.c.s.b;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorBitmapDecoder */
public final class v implements j<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final m f7725a;

    public v(m mVar) {
        this.f7725a = mVar;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        m mVar = this.f7725a;
        return mVar.a((s) new b(parcelFileDescriptor, mVar.f7703d, mVar.f7702c), i2, i3, hVar, m.k);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        if (this.f7725a != null) {
            return true;
        }
        throw null;
    }
}
