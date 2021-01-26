package d.h.e.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* compiled from: ResourcesCompat */
public abstract class g {

    /* compiled from: ResourcesCompat */
    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Typeface f4804a;

        public a(Typeface typeface) {
            this.f4804a = typeface;
        }

        public void run() {
            g.this.a(this.f4804a);
        }
    }

    /* compiled from: ResourcesCompat */
    public class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f4806a;

        public b(int i2) {
            this.f4806a = i2;
        }

        public void run() {
            g.this.a(this.f4806a);
        }
    }

    public abstract void a(int i2);

    public abstract void a(Typeface typeface);

    public final void a(Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new a(typeface));
    }

    public final void a(int i2, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new b(i2));
    }
}
