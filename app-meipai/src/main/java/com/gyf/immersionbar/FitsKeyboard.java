package com.gyf.immersionbar;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

public class FitsKeyboard implements OnGlobalLayoutListener {
    public View mChildView;
    public View mContentView;
    public View mDecorView;
    public ImmersionBar mImmersionBar;
    public boolean mIsAddListener;
    public int mPaddingBottom = 0;
    public int mPaddingLeft = 0;
    public int mPaddingRight = 0;
    public int mPaddingTop = 0;
    public int mTempKeyboardHeight;
    public Window mWindow;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FitsKeyboard(com.gyf.immersionbar.ImmersionBar r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.mPaddingLeft = r0
            r3.mPaddingTop = r0
            r3.mPaddingRight = r0
            r3.mPaddingBottom = r0
            r3.mImmersionBar = r4
            android.view.Window r1 = r4.getWindow()
            r3.mWindow = r1
            android.view.View r1 = r1.getDecorView()
            r3.mDecorView = r1
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r2 = r4.isDialogFragment()
            if (r2 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r0 = r4.getSupportFragment()
            if (r0 == 0) goto L_0x0036
            android.view.View r4 = r0.getView()
            r3.mChildView = r4
            goto L_0x0057
        L_0x0036:
            android.app.Fragment r4 = r4.getFragment()
            if (r4 == 0) goto L_0x0057
            android.view.View r4 = r4.getView()
            r3.mChildView = r4
            goto L_0x0057
        L_0x0043:
            android.view.View r4 = r1.getChildAt(r0)
            r3.mChildView = r4
            if (r4 == 0) goto L_0x0057
            boolean r2 = r4 instanceof d.l.a.a
            if (r2 == 0) goto L_0x0057
            d.l.a.a r4 = (d.l.a.a) r4
            android.view.View r4 = r4.getChildAt(r0)
            r3.mChildView = r4
        L_0x0057:
            android.view.View r4 = r3.mChildView
            if (r4 == 0) goto L_0x0079
            int r4 = r4.getPaddingLeft()
            r3.mPaddingLeft = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingTop()
            r3.mPaddingTop = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingRight()
            r3.mPaddingRight = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingBottom()
            r3.mPaddingBottom = r4
        L_0x0079:
            android.view.View r4 = r3.mChildView
            if (r4 == 0) goto L_0x007e
            r1 = r4
        L_0x007e:
            r3.mContentView = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.FitsKeyboard.<init>(com.gyf.immersionbar.ImmersionBar):void");
    }

    public void cancel() {
        if (this.mIsAddListener) {
            this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.mIsAddListener = false;
        }
    }

    public void disable() {
        if (!this.mIsAddListener) {
            return;
        }
        if (this.mChildView != null) {
            this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        } else {
            this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
        }
    }

    public void enable(int i2) {
        this.mWindow.setSoftInputMode(i2);
        if (!this.mIsAddListener) {
            this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.mIsAddListener = true;
        }
    }

    public void onGlobalLayout() {
        int i2;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.getBarParams() != null && this.mImmersionBar.getBarParams().keyboardEnable) {
            BarConfig barConfig = this.mImmersionBar.getBarConfig();
            int navigationBarHeight = barConfig.isNavigationAtBottom() ? barConfig.getNavigationBarHeight() : barConfig.getNavigationBarWidth();
            Rect rect = new Rect();
            this.mDecorView.getWindowVisibleDisplayFrame(rect);
            int height = this.mContentView.getHeight() - rect.bottom;
            if (height != this.mTempKeyboardHeight) {
                this.mTempKeyboardHeight = height;
                boolean z = true;
                int i3 = 0;
                if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(16908290))) {
                    height -= navigationBarHeight;
                    if (height <= navigationBarHeight) {
                        z = false;
                    }
                } else if (this.mChildView != null) {
                    if (this.mImmersionBar.getBarParams().isSupportActionBar) {
                        height += barConfig.getStatusBarHeight() + this.mImmersionBar.getActionBarHeight();
                    }
                    if (this.mImmersionBar.getBarParams().fits) {
                        height += barConfig.getStatusBarHeight();
                    }
                    if (height > navigationBarHeight) {
                        i2 = this.mPaddingBottom + height;
                    } else {
                        i2 = 0;
                        z = false;
                    }
                    this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, i2);
                } else {
                    int paddingBottom = this.mImmersionBar.getPaddingBottom();
                    height -= navigationBarHeight;
                    if (height > navigationBarHeight) {
                        paddingBottom = height + navigationBarHeight;
                    } else {
                        z = false;
                    }
                    this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), paddingBottom);
                }
                if (height >= 0) {
                    i3 = height;
                }
                if (this.mImmersionBar.getBarParams().onKeyboardListener != null) {
                    this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(z, i3);
                }
                if (!z && this.mImmersionBar.getBarParams().barHide != BarHide.FLAG_SHOW_BAR) {
                    this.mImmersionBar.setBar();
                }
            }
        }
    }
}
