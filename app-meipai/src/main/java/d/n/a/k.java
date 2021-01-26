package d.n.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentManagerImpl */
public class k implements AnimationListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5156a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Fragment f5157b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ j f5158c;

    /* compiled from: FragmentManagerImpl */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (k.this.f5157b.getAnimatingAway() != null) {
                k.this.f5157b.setAnimatingAway(null);
                k kVar = k.this;
                j jVar = kVar.f5158c;
                Fragment fragment = kVar.f5157b;
                jVar.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
            }
        }
    }

    public k(j jVar, ViewGroup viewGroup, Fragment fragment) {
        this.f5158c = jVar;
        this.f5156a = viewGroup;
        this.f5157b = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        this.f5156a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
