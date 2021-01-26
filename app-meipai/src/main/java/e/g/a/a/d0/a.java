package e.g.a.a.d0;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;

/* compiled from: ShadowRenderer */
public class a {

    /* renamed from: h reason: collision with root package name */
    public static final int[] f8058h = new int[3];

    /* renamed from: i reason: collision with root package name */
    public static final float[] f8059i = {0.0f, 0.5f, 1.0f};

    /* renamed from: j reason: collision with root package name */
    public static final int[] f8060j = new int[4];
    public static final float[] k = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a reason: collision with root package name */
    public final Paint f8061a;

    /* renamed from: b reason: collision with root package name */
    public final Paint f8062b;

    /* renamed from: c reason: collision with root package name */
    public final Paint f8063c;

    /* renamed from: d reason: collision with root package name */
    public int f8064d;

    /* renamed from: e reason: collision with root package name */
    public int f8065e;

    /* renamed from: f reason: collision with root package name */
    public int f8066f;

    /* renamed from: g reason: collision with root package name */
    public final Path f8067g = new Path();

    public a() {
        a(-16777216);
        Paint paint = new Paint(4);
        this.f8062b = paint;
        paint.setStyle(Style.FILL);
        Paint paint2 = new Paint();
        this.f8061a = paint2;
        paint2.setColor(this.f8064d);
        this.f8063c = new Paint(this.f8062b);
    }

    public void a(int i2) {
        this.f8064d = d.h.f.a.b(i2, 68);
        this.f8065e = d.h.f.a.b(i2, 20);
        this.f8066f = d.h.f.a.b(i2, 0);
    }
}
