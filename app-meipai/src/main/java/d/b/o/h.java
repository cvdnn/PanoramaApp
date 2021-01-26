package d.b.o;

import android.view.ActionMode;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: WindowCallbackWrapper */
public class h implements Callback {

    /* renamed from: a reason: collision with root package name */
    public final Callback f4140a;

    public h(Callback callback) {
        if (callback != null) {
            this.f4140a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4140a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4140a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4140a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4140a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f4140a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f4140a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f4140a.onAttachedToWindow();
    }

    public View onCreatePanelView(int i2) {
        return this.f4140a.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f4140a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f4140a.onMenuItemSelected(i2, menuItem);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.f4140a.onPointerCaptureChanged(z);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f4140a.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f4140a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f4140a.onWindowFocusChanged(z);
    }

    public boolean onSearchRequested() {
        return this.f4140a.onSearchRequested();
    }
}
