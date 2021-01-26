package e.g.a.a.h0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;

/* compiled from: DropdownMenuEndIconDelegate */
public class i implements OnTouchListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f8183a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ h f8184b;

    public i(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f8184b = hVar;
        this.f8183a = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f8184b.c()) {
                this.f8184b.f8173g = false;
            }
            h.a(this.f8184b, this.f8183a);
            view.performClick();
        }
        return false;
    }
}
