package e.g.a.a.b0;

import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: TextAppearance */
public class c extends d {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ TextPaint f8052a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ d f8053b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ b f8054c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f8054c = bVar;
        this.f8052a = textPaint;
        this.f8053b = dVar;
    }

    public void a(Typeface typeface, boolean z) {
        this.f8054c.a(this.f8052a, typeface);
        this.f8053b.a(typeface, z);
    }

    public void a(int i2) {
        this.f8053b.a(i2);
    }
}
