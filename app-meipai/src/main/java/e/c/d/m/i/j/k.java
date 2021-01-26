package e.c.d.m.i.j;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;

import d.b.p.n;
import e.c.b.e.Utils;

/* compiled from: PhotoView */
public class k extends n {

    /* renamed from: a reason: collision with root package name */
    public l f6844a;

    /* renamed from: b reason: collision with root package name */
    public ScaleType f6845b;

    public k(Context context) {
        this(context, null);
    }

    public l getAttacher() {
        return this.f6844a;
    }

    public RectF getDisplayRect() {
        return this.f6844a.c();
    }

    public Matrix getImageMatrix() {
        return this.f6844a.f6847b;
    }

    public float getMaximumScale() {
        return this.f6844a.f6855j;
    }

    public float getMediumScale() {
        return this.f6844a.f6854i;
    }

    public float getMinimumScale() {
        return this.f6844a.f6853h;
    }

    public float getScale() {
        return this.f6844a.e();
    }

    public ScaleType getScaleType() {
        return this.f6844a.E;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f6844a.k = z;
    }

    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f6844a.g();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f6844a;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l lVar = this.f6844a;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f6844a;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void setMaximumScale(float f2) {
        l lVar = this.f6844a;
        Utils.a(lVar.f6853h, lVar.f6854i, f2);
        lVar.f6855j = f2;
    }

    public void setMediumScale(float f2) {
        l lVar = this.f6844a;
        Utils.a(lVar.f6853h, f2, lVar.f6855j);
        lVar.f6854i = f2;
    }

    public void setMinimumScale(float f2) {
        l lVar = this.f6844a;
        Utils.a(f2, lVar.f6854i, lVar.f6855j);
        lVar.f6853h = f2;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f6844a.u = onClickListener;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.f6844a.n.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.f6844a.v = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.f6844a.q = cVar;
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
        this.f6844a.s = dVar;
    }

    public void setOnPhotoTapListener(e eVar) {
        this.f6844a.r = eVar;
    }

    public void setOnPhotoTouchListener(f fVar) {
        this.f6844a.p = fVar;
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f6844a.w = gVar;
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f6844a.x = hVar;
    }

    public void setOnViewDragListener(Utils iVar) {
        this.f6844a.y = iVar;
    }

    public void setOnViewTapListener(j jVar) {
        this.f6844a.t = jVar;
    }

    public void setRotationBy(float f2) {
        l lVar = this.f6844a;
        lVar.f6848c.postRotate(f2 % 360.0f);
        lVar.a();
    }

    public void setRotationTo(float f2) {
        l lVar = this.f6844a;
        lVar.f6848c.setRotate(f2 % 360.0f);
        lVar.a();
    }

    public void setScale(float f2) {
        this.f6844a.a(f2, false);
    }

    public void setScaleType(ScaleType scaleType) {
        boolean z;
        l lVar = this.f6844a;
        if (lVar == null) {
            this.f6845b = scaleType;
        } else if (lVar != null) {
            if (scaleType == null) {
                z = false;
            } else if (scaleType != ScaleType.MATRIX) {
                z = true;
            } else {
                throw new IllegalStateException("Matrix scale type is not supported");
            }
            if (z && scaleType != lVar.E) {
                lVar.E = scaleType;
                lVar.g();
            }
        } else {
            throw null;
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f6844a.f6852g = i2;
    }

    public void setZoomable(boolean z) {
        l lVar = this.f6844a;
        lVar.D = z;
        lVar.g();
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6844a = new l(this);
        super.setScaleType(ScaleType.MATRIX);
        ScaleType scaleType = this.f6845b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f6845b = null;
        }
    }
}
