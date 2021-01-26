package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.d.a.n.f;
import e.d.a.n.n.c0.d;
import java.security.MessageDigest;

/* compiled from: FitCenter */
public class q extends f {

    /* renamed from: b reason: collision with root package name */
    public static final byte[] f7708b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f.f7225a);

    public Bitmap a(d dVar, Bitmap bitmap, int i2, int i3) {
        return z.c(dVar, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof q;
    }

    public int hashCode() {
        return 1572326941;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f7708b);
    }
}
