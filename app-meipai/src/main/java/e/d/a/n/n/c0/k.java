package e.d.a.n.n.c0;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: LruPoolStrategy */
public interface k {
    Bitmap a(int i2, int i3, Config config);

    void a(Bitmap bitmap);

    int b(Bitmap bitmap);

    String b(int i2, int i3, Config config);

    String c(Bitmap bitmap);

    Bitmap removeLast();
}
