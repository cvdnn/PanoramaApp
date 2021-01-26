package e.g.a.a.z;

import android.graphics.Typeface;
import android.text.TextPaint;
import e.g.a.a.b0.d;
import java.lang.ref.WeakReference;

/* compiled from: TextDrawableHelper */
public class g {

    /* renamed from: a reason: collision with root package name */
    public final TextPaint f8455a = new TextPaint(1);

    /* renamed from: b reason: collision with root package name */
    public final d f8456b = new a();

    /* renamed from: c reason: collision with root package name */
    public float f8457c;

    /* renamed from: d reason: collision with root package name */
    public boolean f8458d = true;

    /* renamed from: e reason: collision with root package name */
    public WeakReference<b> f8459e = new WeakReference<>(null);

    /* renamed from: f reason: collision with root package name */
    public e.g.a.a.b0.b f8460f;

    /* compiled from: TextDrawableHelper */
    public class a extends d {
        public a() {
        }

        public void a(Typeface typeface, boolean z) {
            if (!z) {
                g gVar = g.this;
                gVar.f8458d = true;
                b bVar = (b) gVar.f8459e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        public void a(int i2) {
            g gVar = g.this;
            gVar.f8458d = true;
            b bVar = (b) gVar.f8459e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: TextDrawableHelper */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public g(b bVar) {
        this.f8459e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        float f2;
        if (!this.f8458d) {
            return this.f8457c;
        }
        if (str == null) {
            f2 = 0.0f;
        } else {
            f2 = this.f8455a.measureText(str, 0, str.length());
        }
        this.f8457c = f2;
        this.f8458d = false;
        return f2;
    }
}
