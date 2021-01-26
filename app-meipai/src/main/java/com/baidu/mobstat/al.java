package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class al implements Callback {

    /* renamed from: a reason: collision with root package name */
    public Callback f1530a;

    /* renamed from: b reason: collision with root package name */
    public a f1531b;

    public interface a {
        void a(KeyEvent keyEvent);

        void a(MotionEvent motionEvent);
    }

    public al(Callback callback, a aVar) {
        this.f1530a = callback;
        this.f1531b = aVar;
    }

    public Callback a() {
        return this.f1530a;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1530a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        a aVar = this.f1531b;
        if (aVar != null) {
            aVar.a(keyEvent);
        }
        return this.f1530a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1530a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1530a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f1531b;
        if (aVar != null) {
            aVar.a(motionEvent);
        }
        return this.f1530a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1530a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1530a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1530a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f1530a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f1530a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f1530a.onCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return this.f1530a.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f1530a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f1530a.onMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f1530a.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f1530a.onPanelClosed(i2, menu);
    }

    @SuppressLint({"NewApi"})
    public void onPointerCaptureChanged(boolean z) {
        this.f1530a.onPointerCaptureChanged(z);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f1530a.onPreparePanel(i2, view, menu);
    }

    @SuppressLint({"NewApi"})
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.f1530a.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public boolean onSearchRequested() {
        return this.f1530a.onSearchRequested();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f1530a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f1530a.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1530a.onWindowStartingActionMode(callback);
    }

    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f1530a.onSearchRequested(searchEvent);
    }

    @SuppressLint({"NewApi"})
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f1530a.onWindowStartingActionMode(callback, i2);
    }
}
