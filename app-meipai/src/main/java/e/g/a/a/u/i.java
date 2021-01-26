package e.g.a.a.u;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.s;
import com.google.android.material.button.MaterialButton;

/* compiled from: MaterialCalendar */
public class i extends s {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ q f8359a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ MaterialButton f8360b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ f f8361c;

    public i(f fVar, q qVar, MaterialButton materialButton) {
        this.f8361c = fVar;
        this.f8359a = qVar;
        this.f8360b = materialButton;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        if (i2 == 0) {
            recyclerView.announceForAccessibility(this.f8360b.getText());
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        if (i2 < 0) {
            i4 = this.f8361c.a().findFirstVisibleItemPosition();
        } else {
            i4 = this.f8361c.a().findLastVisibleItemPosition();
        }
        this.f8361c.f8341e = this.f8359a.a(i4);
        this.f8360b.setText(this.f8359a.f8380a.f8314a.a(i4).f8368b);
    }
}
