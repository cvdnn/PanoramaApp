package d.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.o;

/* compiled from: OrientationHelper */
public final class r extends t {
    public r(LayoutManager layoutManager) {
        super(layoutManager, null);
    }

    public int a() {
        return this.f5399a.getWidth();
    }

    public int b() {
        return this.f5399a.getWidth() - this.f5399a.getPaddingRight();
    }

    public int c(View view) {
        o oVar = (o) view.getLayoutParams();
        return this.f5399a.getDecoratedMeasuredHeight(view) + oVar.topMargin + oVar.bottomMargin;
    }

    public int d(View view) {
        return this.f5399a.getDecoratedLeft(view) - ((o) view.getLayoutParams()).leftMargin;
    }

    public int e(View view) {
        this.f5399a.getTransformedBoundingBox(view, true, this.f5401c);
        return this.f5401c.right;
    }

    public int f() {
        return this.f5399a.getPaddingLeft();
    }

    public int g() {
        return (this.f5399a.getWidth() - this.f5399a.getPaddingLeft()) - this.f5399a.getPaddingRight();
    }

    public void a(int i2) {
        this.f5399a.offsetChildrenHorizontal(i2);
    }

    public int b(View view) {
        o oVar = (o) view.getLayoutParams();
        return this.f5399a.getDecoratedMeasuredWidth(view) + oVar.leftMargin + oVar.rightMargin;
    }

    public int f(View view) {
        this.f5399a.getTransformedBoundingBox(view, true, this.f5401c);
        return this.f5401c.left;
    }

    public int a(View view) {
        return this.f5399a.getDecoratedRight(view) + ((o) view.getLayoutParams()).rightMargin;
    }

    public int c() {
        return this.f5399a.getPaddingRight();
    }

    public int d() {
        return this.f5399a.getWidthMode();
    }

    public int e() {
        return this.f5399a.getHeightMode();
    }
}
