package e.d.a.n.p.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import e.c.f.n.n;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder */
public class a<DataType> implements j<DataType, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    public final j<DataType, Bitmap> f7656a;

    /* renamed from: b reason: collision with root package name */
    public final Resources f7657b;

    public a(Resources resources, j<DataType, Bitmap> jVar) {
        String str = "Argument must not be null";
        n.a(resources, str);
        this.f7657b = resources;
        n.a(jVar, str);
        this.f7656a = jVar;
    }

    public boolean a(DataType datatype, h hVar) throws IOException {
        return this.f7656a.a(datatype, hVar);
    }

    public w<BitmapDrawable> a(DataType datatype, int i2, int i3, h hVar) throws IOException {
        return u.a(this.f7657b, this.f7656a.a(datatype, i2, i3, hVar));
    }
}
