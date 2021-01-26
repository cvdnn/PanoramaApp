package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.c0.e;
import e.d.a.n.n.w;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter */
public final class n {

    /* renamed from: a reason: collision with root package name */
    public static final d f7705a = new a();

    /* compiled from: DrawableToBitmapConverter */
    public class a extends e {
        public void a(Bitmap bitmap) {
        }
    }

    /* JADX INFO: finally extract failed */
    public static w<Bitmap> a(d dVar, Drawable drawable, int i2, int i3) {
        Drawable current = drawable.getCurrent();
        boolean z = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            String str = "Unable to draw ";
            String str2 = "DrawableToBitmap";
            if (i2 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i3 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i2 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i3 = current.getIntrinsicHeight();
                    }
                    Lock lock = z.f7741d;
                    lock.lock();
                    Bitmap a2 = dVar.a(i2, i3, Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(a2);
                        current.setBounds(0, 0, i2, i3);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = a2;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable(str2, 5)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(current);
                    sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                    Log.w(str2, sb.toString());
                }
            } else if (Log.isLoggable(str2, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(current);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w(str2, sb2.toString());
            }
            z = true;
        }
        if (!z) {
            dVar = f7705a;
        }
        return e.a(bitmap, dVar);
    }
}
