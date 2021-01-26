package d.b.m.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: DrawableWrapper */
public class c extends Drawable implements Callback {

    /* renamed from: a reason: collision with root package name */
    public Drawable f4093a;

    public c(Drawable drawable) {
        Drawable drawable2 = this.f4093a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4093a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f4093a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f4093a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f4093a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f4093a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f4093a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f4093a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f4093a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f4093a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f4093a.getPadding(rect);
    }

    public int[] getState() {
        return this.f4093a.getState();
    }

    public Region getTransparentRegion() {
        return this.f4093a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f4093a.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.f4093a.isStateful();
    }

    public void jumpToCurrentState() {
        this.f4093a.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.f4093a.setBounds(rect);
    }

    public boolean onLevelChange(int i2) {
        return this.f4093a.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f4093a.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        this.f4093a.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i2) {
        this.f4093a.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4093a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f4093a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f4093a.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        this.f4093a.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f4093a.setHotspotBounds(i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.f4093a.setState(iArr);
    }

    public void setTint(int i2) {
        this.f4093a.setTint(i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f4093a.setTintList(colorStateList);
    }

    public void setTintMode(Mode mode) {
        this.f4093a.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f4093a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
