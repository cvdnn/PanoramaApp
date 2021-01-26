package e.g.a.a.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: DropdownMenuEndIconDelegate */
public class l extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ h f8187a;

    public l(h hVar) {
        this.f8187a = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        h hVar = this.f8187a;
        hVar.f8191c.setChecked(hVar.f8174h);
        this.f8187a.n.start();
    }
}
