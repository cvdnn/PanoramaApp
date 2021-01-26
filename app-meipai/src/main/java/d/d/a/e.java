package d.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable */
public class e extends Drawable {

    /* renamed from: a reason: collision with root package name */
    public float f4544a;

    /* renamed from: b reason: collision with root package name */
    public float f4545b;

    /* renamed from: c reason: collision with root package name */
    public boolean f4546c;

    /* renamed from: d reason: collision with root package name */
    public boolean f4547d;

    /* renamed from: e reason: collision with root package name */
    public ColorStateList f4548e;

    /* renamed from: f reason: collision with root package name */
    public PorterDuffColorFilter f4549f;

    /* renamed from: g reason: collision with root package name */
    public ColorStateList f4550g;

    /* renamed from: h reason: collision with root package name */
    public Mode f4551h;

    public final void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        int i2 = rect.left;
        throw null;
    }

    public void draw(Canvas canvas) {
        if (this.f4549f == null) {
            float f2 = this.f4544a;
            canvas.drawRoundRect(null, f2, f2, null);
            return;
        }
        throw null;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(null, this.f4544a);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f4550g;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.f4548e;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && !super.isStateful()) {
                return false;
            }
        }
        return true;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
        throw null;
    }

    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f4548e;
        colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        throw null;
    }

    public void setAlpha(int i2) {
        throw null;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw null;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f4550g = colorStateList;
        this.f4549f = a(colorStateList, this.f4551h);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f4551h = mode;
        this.f4549f = a(this.f4550g, mode);
        invalidateSelf();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
