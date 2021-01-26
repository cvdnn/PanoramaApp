package e.c.d.m.i;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.picapture.ui.widget.SpinView;
import e.c.d.m.i.j.f;

/* compiled from: lambda */
public final /* synthetic */ class c implements f {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ SpinView f6794a;

    public /* synthetic */ c(SpinView spinView) {
        this.f6794a = spinView;
    }

    public final void onTouch(View view, MotionEvent motionEvent) {
        this.f6794a.a(view, motionEvent);
    }
}
