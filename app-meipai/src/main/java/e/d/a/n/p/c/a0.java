package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;

/* compiled from: UnitBitmapDecoder */
public final class a0 implements j<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder */
    public static final class a implements w<Bitmap> {

        /* renamed from: a reason: collision with root package name */
        public final Bitmap f7658a;

        public a(Bitmap bitmap) {
            this.f7658a = bitmap;
        }

        public void b() {
        }

        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public Object get() {
            return this.f7658a;
        }

        public int getSize() {
            return e.d.a.t.j.a(this.f7658a);
        }
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        return new a((Bitmap) obj);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        Bitmap bitmap = (Bitmap) obj;
        return true;
    }
}
