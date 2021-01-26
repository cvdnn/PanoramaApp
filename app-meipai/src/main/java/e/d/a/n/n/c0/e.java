package e.d.a.n.n.c0;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: BitmapPoolAdapter */
public class e implements d {
    public void a() {
    }

    public void a(int i2) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap b(int i2, int i3, Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public Bitmap a(int i2, int i3, Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
