package d.k;

import android.view.Choreographer.FrameCallback;
import androidx.databinding.ViewDataBinding;

/* compiled from: ViewDataBinding */
public class f implements FrameCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ViewDataBinding f5041a;

    public f(ViewDataBinding viewDataBinding) {
        this.f5041a = viewDataBinding;
    }

    public void doFrame(long j2) {
        this.f5041a.f923a.run();
    }
}
