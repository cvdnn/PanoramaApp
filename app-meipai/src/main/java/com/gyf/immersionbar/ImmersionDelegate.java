package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import d.n.a.c;

public class ImmersionDelegate implements Runnable {
    public BarProperties mBarProperties;
    public ImmersionBar mImmersionBar;
    public int mNotchHeight;
    public OnBarListener mOnBarListener;

    public ImmersionDelegate(Object obj) {
        if (obj instanceof Activity) {
            if (this.mImmersionBar == null) {
                this.mImmersionBar = new ImmersionBar((Activity) obj);
            }
        } else if (obj instanceof Fragment) {
            if (this.mImmersionBar != null) {
                return;
            }
            if (obj instanceof c) {
                this.mImmersionBar = new ImmersionBar((c) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((Fragment) obj);
            }
        } else if ((obj instanceof android.app.Fragment) && this.mImmersionBar == null) {
            if (obj instanceof DialogFragment) {
                this.mImmersionBar = new ImmersionBar((DialogFragment) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    private void barChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.initialized()) {
            OnBarListener onBarListener = this.mImmersionBar.getBarParams().onBarListener;
            this.mOnBarListener = onBarListener;
            if (onBarListener != null) {
                Activity activity = this.mImmersionBar.getActivity();
                if (this.mBarProperties == null) {
                    this.mBarProperties = new BarProperties();
                }
                this.mBarProperties.setPortrait(configuration.orientation == 1);
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 1) {
                    this.mBarProperties.setLandscapeLeft(true);
                    this.mBarProperties.setLandscapeRight(false);
                } else if (rotation == 3) {
                    this.mBarProperties.setLandscapeLeft(false);
                    this.mBarProperties.setLandscapeRight(true);
                } else {
                    this.mBarProperties.setLandscapeLeft(false);
                    this.mBarProperties.setLandscapeRight(false);
                }
                activity.getWindow().getDecorView().post(this);
            }
        }
    }

    public ImmersionBar get() {
        return this.mImmersionBar;
    }

    public void onActivityCreated(Configuration configuration) {
        barChanged(configuration);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onConfigurationChanged(configuration);
            barChanged(configuration);
        }
    }

    public void onDestroy() {
        this.mBarProperties = null;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onDestroy();
            this.mImmersionBar = null;
        }
    }

    public void onResume() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onResume();
        }
    }

    public void run() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.getActivity() != null) {
            Activity activity = this.mImmersionBar.getActivity();
            BarConfig barConfig = new BarConfig(activity);
            this.mBarProperties.setStatusBarHeight(barConfig.getStatusBarHeight());
            this.mBarProperties.setNavigationBar(barConfig.hasNavigationBar());
            this.mBarProperties.setNavigationBarHeight(barConfig.getNavigationBarHeight());
            this.mBarProperties.setNavigationBarWidth(barConfig.getNavigationBarWidth());
            this.mBarProperties.setActionBarHeight(barConfig.getActionBarHeight());
            boolean hasNotchScreen = NotchUtils.hasNotchScreen(activity);
            this.mBarProperties.setNotchScreen(hasNotchScreen);
            if (hasNotchScreen && this.mNotchHeight == 0) {
                int notchHeight = NotchUtils.getNotchHeight(activity);
                this.mNotchHeight = notchHeight;
                this.mBarProperties.setNotchHeight(notchHeight);
            }
            this.mOnBarListener.onBarChange(this.mBarProperties);
        }
    }

    public ImmersionDelegate(Activity activity, Dialog dialog) {
        if (this.mImmersionBar == null) {
            this.mImmersionBar = new ImmersionBar(activity, dialog);
        }
    }
}
