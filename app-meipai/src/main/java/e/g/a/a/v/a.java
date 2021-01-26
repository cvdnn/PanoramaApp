package e.g.a.a.v;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener */
public class a implements OnTouchListener {

    /* renamed from: a reason: collision with root package name */
    public final Dialog f8391a;

    /* renamed from: b reason: collision with root package name */
    public final int f8392b;

    /* renamed from: c reason: collision with root package name */
    public final int f8393c;

    /* renamed from: d reason: collision with root package name */
    public final int f8394d;

    public a(Dialog dialog, Rect rect) {
        this.f8391a = dialog;
        this.f8392b = rect.left;
        this.f8393c = rect.top;
        this.f8394d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f8392b;
        int top = findViewById.getTop() + this.f8393c;
        if (new RectF((float) left, (float) top, (float) (findViewById.getWidth() + left), (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(4);
        if (VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f8394d;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.f8391a.onTouchEvent(obtain);
    }
}
