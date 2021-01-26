package e.g.a.a.q;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import e.g.a.a.b;
import e.g.a.a.e0.j;
import e.g.a.a.e0.n;

/* compiled from: MaterialCardView */
public class a extends d.d.a.a implements Checkable, n {

    /* renamed from: g reason: collision with root package name */
    public static final int[] f8295g = {16842911};

    /* renamed from: h reason: collision with root package name */
    public static final int[] f8296h = {16842912};

    /* renamed from: i reason: collision with root package name */
    public static final int[] f8297i = {b.state_dragged};

    /* renamed from: d reason: collision with root package name */
    public boolean f8298d;

    /* renamed from: e reason: collision with root package name */
    public boolean f8299e;

    /* renamed from: f reason: collision with root package name */
    public C0110a f8300f;

    /* renamed from: e.g.a.a.q.a$a reason: collision with other inner class name */
    /* compiled from: MaterialCardView */
    public interface C0110a {
    }

    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
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

    public float getProgress() {
        throw null;
    }

    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public j getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    public boolean isChecked() {
        return this.f8298d;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (this.f8298d) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f8296h);
        }
        if (this.f8299e) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f8297i);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(d.d.a.a.class.getName());
        accessibilityEvent.setChecked(this.f8298d);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(d.d.a.a.class.getName());
        accessibilityNodeInfo.setCheckable(false);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f8298d);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i2) {
        ColorStateList.valueOf(i2);
        throw null;
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        throw null;
    }

    public void setCheckable(boolean z) {
        throw null;
    }

    public void setChecked(boolean z) {
        boolean z2 = this.f8298d;
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconResource(int i2) {
        d.b.l.a.a.b(getContext(), i2);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        throw null;
    }

    public void setDragged(boolean z) {
        if (this.f8299e != z) {
            this.f8299e = z;
            refreshDrawableState();
            if (VERSION.SDK_INT <= 26) {
                invalidate();
                return;
            }
            throw null;
        }
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        throw null;
    }

    public void setOnCheckedChangeListener(C0110a aVar) {
        this.f8300f = aVar;
    }

    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        throw null;
    }

    public void setProgress(float f2) {
        throw null;
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i2) {
        d.b.l.a.a.a(getContext(), i2);
        throw null;
    }

    public void setShapeAppearanceModel(j jVar) {
        throw null;
    }

    public void setStrokeColor(int i2) {
        ColorStateList.valueOf(i2);
        throw null;
    }

    public void setStrokeWidth(int i2) {
        throw null;
    }

    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        throw null;
    }

    public void toggle() {
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }
}
