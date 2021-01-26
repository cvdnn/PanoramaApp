package d.b.p;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import d.b.j;
import d.h.k.m;

/* compiled from: AppCompatSeekBarHelper */
public class u extends q {

    /* renamed from: d reason: collision with root package name */
    public final SeekBar f4448d;

    /* renamed from: e reason: collision with root package name */
    public Drawable f4449e;

    /* renamed from: f reason: collision with root package name */
    public ColorStateList f4450f = null;

    /* renamed from: g reason: collision with root package name */
    public Mode f4451g = null;

    /* renamed from: h reason: collision with root package name */
    public boolean f4452h = false;

    /* renamed from: i reason: collision with root package name */
    public boolean f4453i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f4448d = seekBar;
    }

    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        x0 a2 = x0.a(this.f4448d.getContext(), attributeSet, j.AppCompatSeekBar, i2, 0);
        Drawable c2 = a2.c(j.AppCompatSeekBar_android_thumb);
        if (c2 != null) {
            this.f4448d.setThumb(c2);
        }
        Drawable b2 = a2.b(j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f4449e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f4449e = b2;
        if (b2 != null) {
            b2.setCallback(this.f4448d);
            b2.setLayoutDirection(m.m(this.f4448d));
            if (b2.isStateful()) {
                b2.setState(this.f4448d.getDrawableState());
            }
            a();
        }
        this.f4448d.invalidate();
        if (a2.f(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f4451g = e0.a(a2.d(j.AppCompatSeekBar_tickMarkTintMode, -1), this.f4451g);
            this.f4453i = true;
        }
        if (a2.f(j.AppCompatSeekBar_tickMarkTint)) {
            this.f4450f = a2.a(j.AppCompatSeekBar_tickMarkTint);
            this.f4452h = true;
        }
        a2.f4485b.recycle();
        a();
    }

    public final void a() {
        if (this.f4449e == null) {
            return;
        }
        if (this.f4452h || this.f4453i) {
            Drawable mutate = this.f4449e.mutate();
            this.f4449e = mutate;
            if (this.f4452h) {
                mutate.setTintList(this.f4450f);
            }
            if (this.f4453i) {
                this.f4449e.setTintMode(this.f4451g);
            }
            if (this.f4449e.isStateful()) {
                this.f4449e.setState(this.f4448d.getDrawableState());
            }
        }
    }

    public void a(Canvas canvas) {
        if (this.f4449e != null) {
            int max = this.f4448d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f4449e.getIntrinsicWidth();
                int intrinsicHeight = this.f4449e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f4449e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f4448d.getWidth() - this.f4448d.getPaddingLeft()) - this.f4448d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f4448d.getPaddingLeft(), (float) (this.f4448d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f4449e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
