package e.d.a.n.p.c;

import android.content.Context;
import android.graphics.Bitmap;
import e.d.a.b;
import e.d.a.n.l;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.w;
import e.d.a.t.j;

/* compiled from: BitmapTransformation */
public abstract class f implements l<Bitmap> {
    public abstract Bitmap a(d dVar, Bitmap bitmap, int i2, int i3);

    public final w<Bitmap> a(Context context, w<Bitmap> wVar, int i2, int i3) {
        if (j.a(i2, i3)) {
            d dVar = b.a(context).f7083a;
            Bitmap bitmap = (Bitmap) wVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap a2 = a(dVar, bitmap, i2, i3);
            return bitmap.equals(a2) ? wVar : e.a(a2, dVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(i2);
        sb.append(" or height: ");
        sb.append(i3);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
