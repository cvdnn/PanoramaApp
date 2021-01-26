package d.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.o;

/* compiled from: OrientationHelper */
public final class s extends t {
    public s(LayoutManager layoutManager) {
        super(layoutManager, null);
    }

    public int a() {
        return this.f5399a.getHeight();
    }

    public int b() {
        return this.f5399a.getHeight() - this.f5399a.getPaddingBottom();
    }

    public int c(View view) {
        o oVar = (o) view.getLayoutParams();
        return this.f5399a.getDecoratedMeasuredWidth(view) + oVar.leftMargin + oVar.rightMargin;
    }

    public int d(View view) {
        return this.f5399a.getDecoratedTop(view) - ((o) view.getLayoutParams()).topMargin;
    }

    public int e(View view) {
        this.f5399a.getTransformedBoundingBox(view, true, this.f5401c);
        return this.f5401c.bottom;
    }

    public int f() {
        return this.f5399a.getPaddingTop();
    }

    public int g() {
        return (this.f5399a.getHeight() - this.f5399a.getPaddingTop()) - this.f5399a.getPaddingBottom();
    }

    public void a(int i2) {
        this.f5399a.offsetChildrenVertical(i2);
    }

    public int b(View view) {
        o oVar = (o) view.getLayoutParams();
        return this.f5399a.getDecoratedMeasuredHeight(view) + oVar.topMargin + oVar.bottomMargin;
    }

    public int f(View view) {
        this.f5399a.getTransformedBoundingBox(view, true, this.f5401c);
        return this.f5401c.top;
    }

    public int a(View view) {
        return this.f5399a.getDecoratedBottom(view) + ((o) view.getLayoutParams()).bottomMargin;
    }

    public int c() {
        return this.f5399a.getPaddingBottom();
    }

    public int d() {
        return this.f5399a.getHeightMode();
    }

    public int e() {
        return this.f5399a.getWidthMode();
    }
}
