package e.d.a.n.p.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import e.c.f.n.n;
import e.d.a.n.l;
import e.d.a.n.p.g.g.b;

/* compiled from: GifDrawable */
public class c extends Drawable implements b, Animatable, d.u.a.a.b {

    /* renamed from: a reason: collision with root package name */
    public final a f7758a;

    /* renamed from: b reason: collision with root package name */
    public boolean f7759b;

    /* renamed from: c reason: collision with root package name */
    public boolean f7760c;

    /* renamed from: d reason: collision with root package name */
    public boolean f7761d;

    /* renamed from: e reason: collision with root package name */
    public boolean f7762e = true;

    /* renamed from: f reason: collision with root package name */
    public int f7763f;

    /* renamed from: g reason: collision with root package name */
    public int f7764g = -1;

    /* renamed from: h reason: collision with root package name */
    public boolean f7765h;

    /* renamed from: i reason: collision with root package name */
    public Paint f7766i;

    /* renamed from: j reason: collision with root package name */
    public Rect f7767j;

    /* compiled from: GifDrawable */
    public static final class a extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        public final g f7768a;

        public a(g gVar) {
            this.f7768a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new c(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new c(this);
        }
    }

    public c(Context context, e.d.a.m.a aVar, l<Bitmap> lVar, int i2, int i3, Bitmap bitmap) {
        g gVar = new g(e.d.a.b.a(context), aVar, i2, i3, lVar, bitmap);
        a aVar2 = new a(gVar);
        n.a(aVar2, "Argument must not be null");
        this.f7758a = aVar2;
    }

    public void a() {
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        e.d.a.n.p.g.g.a aVar = this.f7758a.f7768a.f7779j;
        if ((aVar != null ? aVar.f7781e : -1) == this.f7758a.f7768a.f7770a.getFrameCount() - 1) {
            this.f7763f++;
        }
        int i2 = this.f7764g;
        if (i2 != -1 && this.f7763f >= i2) {
            stop();
        }
    }

    public Bitmap b() {
        return this.f7758a.f7768a.m;
    }

    public final Paint c() {
        if (this.f7766i == null) {
            this.f7766i = new Paint(2);
        }
        return this.f7766i;
    }

    public final void d() {
        n.a(!this.f7761d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f7758a.f7768a.f7770a.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.f7759b) {
            this.f7759b = true;
            g gVar = this.f7758a.f7768a;
            if (gVar.k) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            } else if (!gVar.f7772c.contains(this)) {
                boolean isEmpty = gVar.f7772c.isEmpty();
                gVar.f7772c.add(this);
                if (isEmpty && !gVar.f7775f) {
                    gVar.f7775f = true;
                    gVar.k = false;
                    gVar.a();
                }
                invalidateSelf();
            } else {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (!this.f7761d) {
            if (this.f7765h) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.f7767j == null) {
                    this.f7767j = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f7767j);
                this.f7765h = false;
            }
            g gVar = this.f7758a.f7768a;
            e.d.a.n.p.g.g.a aVar = gVar.f7779j;
            if (aVar != null) {
                bitmap = aVar.f7783g;
            } else {
                bitmap = gVar.m;
            }
            if (this.f7767j == null) {
                this.f7767j = new Rect();
            }
            canvas.drawBitmap(bitmap, null, this.f7767j, c());
        }
    }

    public final void e() {
        this.f7759b = false;
        g gVar = this.f7758a.f7768a;
        gVar.f7772c.remove(this);
        if (gVar.f7772c.isEmpty()) {
            gVar.f7775f = false;
        }
    }

    public ConstantState getConstantState() {
        return this.f7758a;
    }

    public int getIntrinsicHeight() {
        return this.f7758a.f7768a.q;
    }

    public int getIntrinsicWidth() {
        return this.f7758a.f7768a.p;
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f7759b;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7765h = true;
    }

    public void setAlpha(int i2) {
        c().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        n.a(!this.f7761d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f7762e = z;
        if (!z) {
            e();
        } else if (this.f7760c) {
            d();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f7760c = true;
        this.f7763f = 0;
        if (this.f7762e) {
            d();
        }
    }

    public void stop() {
        this.f7760c = false;
        e();
    }

    public c(a aVar) {
        n.a(aVar, "Argument must not be null");
        this.f7758a = aVar;
    }
}
