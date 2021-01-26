package e.d.a.n.p.e;

import android.graphics.drawable.Drawable;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;

/* compiled from: UnitDrawableDecoder */
public class e implements j<Drawable, Drawable> {
    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    public boolean a(Object obj, h hVar) throws IOException {
        Drawable drawable = (Drawable) obj;
        return true;
    }
}
