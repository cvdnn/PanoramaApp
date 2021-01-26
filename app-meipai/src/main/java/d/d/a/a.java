package d.d.a;

import android.content.res.ColorStateList;
import android.widget.FrameLayout;

/* compiled from: CardView */
public class a extends FrameLayout {

    /* renamed from: c reason: collision with root package name */
    public static final d f4541c = new b();

    /* renamed from: a reason: collision with root package name */
    public boolean f4542a;

    /* renamed from: b reason: collision with root package name */
    public boolean f4543b;

    public ColorStateList getCardBackgroundColor() {
        b bVar = (b) f4541c;
        throw null;
    }

    public float getCardElevation() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getMaxCardElevation() {
        return ((b) f4541c).b(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.f4543b;
    }

    public float getRadius() {
        return ((b) f4541c).c(null);
    }

    public boolean getUseCompatPadding() {
        return this.f4542a;
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        ((b) f4541c).a((c) null, ColorStateList.valueOf(i2));
        throw null;
    }

    public void setCardElevation(float f2) {
        throw null;
    }

    public void setMaxCardElevation(float f2) {
        ((b) f4541c).a((c) null, f2);
    }

    public void setMinimumHeight(int i2) {
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f4543b) {
            this.f4543b = z;
            b bVar = (b) f4541c;
            throw null;
        }
    }

    public void setRadius(float f2) {
        b bVar = (b) f4541c;
        throw null;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f4542a != z) {
            this.f4542a = z;
            b bVar = (b) f4541c;
            throw null;
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        ((b) f4541c).a((c) null, colorStateList);
        throw null;
    }
}
