package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.c0.b;
import e.d.a.n.n.w;
import e.d.a.t.d;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class y implements j<InputStream, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final m f7734a;

    /* renamed from: b reason: collision with root package name */
    public final b f7735b;

    /* compiled from: StreamBitmapDecoder */
    public static class a implements m.b {

        /* renamed from: a reason: collision with root package name */
        public final w f7736a;

        /* renamed from: b reason: collision with root package name */
        public final d f7737b;

        public a(w wVar, d dVar) {
            this.f7736a = wVar;
            this.f7737b = dVar;
        }

        public void a() {
            this.f7736a.a();
        }

        public void a(e.d.a.n.n.c0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOException = this.f7737b.f7909b;
            if (iOException != null) {
                if (bitmap != null) {
                    dVar.a(bitmap);
                }
                throw iOException;
            }
        }
    }

    public y(m mVar, b bVar) {
        this.f7734a = mVar;
        this.f7735b = bVar;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        w wVar;
        boolean z;
        InputStream inputStream = (InputStream) obj;
        if (inputStream instanceof w) {
            wVar = (w) inputStream;
            z = false;
        } else {
            w wVar2 = new w(inputStream, this.f7735b);
            z = true;
            wVar = wVar2;
        }
        d a2 = d.a(wVar);
        try {
            return this.f7734a.a((InputStream) new e.d.a.t.h(a2), i2, i3, hVar, (m.b) new a(wVar, a2));
        } finally {
            a2.a();
            if (z) {
                wVar.b();
            }
        }
    }

    public boolean a(Object obj, h hVar) throws IOException {
        InputStream inputStream = (InputStream) obj;
        if (this.f7734a != null) {
            return true;
        }
        throw null;
    }
}
