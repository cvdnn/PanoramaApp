package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.d.a.n.f;
import e.d.a.n.n.c0.d;
import java.security.MessageDigest;

/* compiled from: CenterCrop */
public class i extends f {

    /* renamed from: b reason: collision with root package name */
    public static final byte[] f7678b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f.f7225a);

    public Bitmap a(d dVar, Bitmap bitmap, int i2, int i3) {
        return z.a(dVar, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    public int hashCode() {
        return -599754482;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f7678b);
    }
}
