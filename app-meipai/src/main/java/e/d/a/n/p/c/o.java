package e.d.a.n.p.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import e.d.a.b;
import e.d.a.n.l;
import e.d.a.n.n.w;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation */
public class o implements l<Drawable> {

    /* renamed from: b reason: collision with root package name */
    public final l<Bitmap> f7706b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f7707c;

    public o(l<Bitmap> lVar, boolean z) {
        this.f7706b = lVar;
        this.f7707c = z;
    }

    public w<Drawable> a(Context context, w<Drawable> wVar, int i2, int i3) {
        Drawable drawable = (Drawable) wVar.get();
        w a2 = n.a(b.a(context).f7083a, drawable, i2, i3);
        if (a2 != null) {
            w a3 = this.f7706b.a(context, a2, i2, i3);
            if (!a3.equals(a2)) {
                return u.a(context.getResources(), a3);
            }
            a3.b();
            return wVar;
        } else if (!this.f7707c) {
            return wVar;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return this.f7706b.equals(((o) obj).f7706b);
    }

    public int hashCode() {
        return this.f7706b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        this.f7706b.a(messageDigest);
    }
}
