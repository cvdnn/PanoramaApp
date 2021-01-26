package e.g.a.a.z;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.baidubce.auth.NTLMEngineImpl;
import d.h.k.m;
import e.g.a.a.k;

/* compiled from: FlowLayout */
public class d extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    public int f8445a;

    /* renamed from: b reason: collision with root package name */
    public int f8446b;

    /* renamed from: c reason: collision with root package name */
    public boolean f8447c;

    public d(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, k.FlowLayout, 0, 0);
        this.f8445a = obtainStyledAttributes.getDimensionPixelSize(k.FlowLayout_lineSpacing, 0);
        this.f8446b = obtainStyledAttributes.getDimensionPixelSize(k.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.f8446b;
    }

    public int getLineSpacing() {
        return this.f8445a;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (getChildCount() != 0) {
            boolean z2 = true;
            if (m.m(this) != 1) {
                z2 = false;
            }
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i8 = (i4 - i2) - paddingLeft;
            int i9 = paddingRight;
            int i10 = paddingTop;
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof MarginLayoutParams) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        i6 = marginLayoutParams.getMarginStart();
                        i7 = marginLayoutParams.getMarginEnd();
                    } else {
                        i7 = 0;
                        i6 = 0;
                    }
                    int measuredWidth = childAt.getMeasuredWidth() + i9 + i6;
                    if (!this.f8447c && measuredWidth > i8) {
                        i10 = this.f8445a + paddingTop;
                        i9 = paddingRight;
                    }
                    int i12 = i9 + i6;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                    int measuredHeight = childAt.getMeasuredHeight() + i10;
                    if (z2) {
                        childAt.layout(i8 - measuredWidth2, i10, (i8 - i9) - i6, measuredHeight);
                    } else {
                        childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                    }
                    i9 += childAt.getMeasuredWidth() + i6 + i7 + this.f8446b;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i3);
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                int i11 = i3;
            } else {
                measureChild(childAt, i2, i3);
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i6 = marginLayoutParams.rightMargin + 0;
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + i5 > paddingRight && !a()) {
                    paddingLeft = getPaddingLeft();
                    i8 = paddingTop + this.f8445a;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i5;
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i5 + i6 + this.f8446b + paddingLeft;
                if (i10 == getChildCount() - 1) {
                    i9 += i6;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i9;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i4 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i4 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i4) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i2) {
        this.f8446b = i2;
    }

    public void setLineSpacing(int i2) {
        this.f8445a = i2;
    }

    public void setSingleLine(boolean z) {
        this.f8447c = z;
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8447c = false;
        a(context, attributeSet);
    }

    public boolean a() {
        return this.f8447c;
    }

    @TargetApi(21)
    public d(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f8447c = false;
        a(context, attributeSet);
    }
}
