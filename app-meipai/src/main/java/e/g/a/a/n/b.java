package e.g.a.a.n;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: BottomAppBar */
public class b extends com.google.android.material.floatingactionbutton.FloatingActionButton.a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ int f8270a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f8271b;

    /* compiled from: BottomAppBar */
    public class a extends com.google.android.material.floatingactionbutton.FloatingActionButton.a {
        public a() {
        }

        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.c(b.this.f8271b);
        }
    }

    public b(BottomAppBar bottomAppBar, int i2) {
        this.f8271b = bottomAppBar;
        this.f8270a = i2;
    }

    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f8271b.b(this.f8270a));
        floatingActionButton.b(new a(), true);
    }
}
