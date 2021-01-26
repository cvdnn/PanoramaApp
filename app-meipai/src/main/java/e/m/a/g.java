package e.m.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

/* compiled from: RecyclerViewProxy */
public class g {

    /* renamed from: a reason: collision with root package name */
    public LayoutManager f8995a;

    public g(LayoutManager layoutManager) {
        this.f8995a = layoutManager;
    }

    public int a() {
        return this.f8995a.getChildCount();
    }

    public int b() {
        return this.f8995a.getHeight();
    }

    public int c() {
        return this.f8995a.getItemCount();
    }

    public int d() {
        return this.f8995a.getWidth();
    }

    public View a(int i2) {
        return this.f8995a.getChildAt(i2);
    }
}
