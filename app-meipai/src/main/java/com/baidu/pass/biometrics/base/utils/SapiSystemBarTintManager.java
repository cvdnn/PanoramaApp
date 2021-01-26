package com.baidu.pass.biometrics.base.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.gyf.immersionbar.NotchUtils;
import java.lang.reflect.Method;

public class SapiSystemBarTintManager {
    public static final int DEFAULT_TINT_COLOR = -1728053248;
    public static String sNavBarOverride;
    public final SystemBarConfig mConfig;
    public boolean mNavBarAvailable;
    public View mNavBarTintView;
    public boolean mStatusBarAvailable;
    public View mStatusBarTintView;

    public static class SystemBarConfig {
        public static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
        public static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
        public static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
        public static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
        public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        public final boolean mHasNavigationBar;
        public final boolean mInPortrait;
        public final int mNavigationBarHeight;
        public final int mNavigationBarWidth;
        public final float mSmallestWidthDp;
        public final int mStatusBarHeight;

        private int getInternalDimensionSize(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", SapiDeviceInfo.f3010c);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        private int getNavigationBarHeight(Context context) {
            Resources resources = context.getResources();
            if (!hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, this.mInPortrait ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        private int getNavigationBarWidth(Context context) {
            Resources resources = context.getResources();
            if (hasNavBar(context)) {
                return getInternalDimensionSize(resources, "navigation_bar_width");
            }
            return 0;
        }

        @SuppressLint({"NewApi"})
        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f2 = (float) displayMetrics.widthPixels;
            float f3 = displayMetrics.density;
            return Math.min(f2 / f3, ((float) displayMetrics.heightPixels) / f3);
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", SapiDeviceInfo.f3010c);
            boolean z = true;
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z2 = resources.getBoolean(identifier);
            if ("1".equals(SapiSystemBarTintManager.sNavBarOverride)) {
                z = false;
            } else {
                if (!"0".equals(SapiSystemBarTintManager.sNavBarOverride)) {
                    z = z2;
                }
            }
            return z;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }

        public SystemBarConfig(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            boolean z3 = false;
            this.mInPortrait = resources.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(resources, "status_bar_height");
            this.mNavigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            if (this.mNavigationBarHeight > 0) {
                z3 = true;
            }
            this.mHasNavigationBar = z3;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }
    }

    static {
        try {
            Method declaredMethod = Class.forName(NotchUtils.SYSTEM_PROPERTIES).getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            sNavBarOverride = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable unused) {
            sNavBarOverride = null;
        }
    }

    /* JADX INFO: finally extract failed */
    @TargetApi(19)
    public SapiSystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
        try {
            this.mStatusBarAvailable = obtainStyledAttributes.getBoolean(0, false);
            this.mNavBarAvailable = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            LayoutParams attributes = window.getAttributes();
            if ((67108864 & attributes.flags) != 0) {
                this.mStatusBarAvailable = true;
            }
            if ((attributes.flags & 134217728) != 0) {
                this.mNavBarAvailable = true;
            }
            SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.mStatusBarAvailable, this.mNavBarAvailable);
            this.mConfig = systemBarConfig;
            if (!systemBarConfig.hasNavigtionBar()) {
                this.mNavBarAvailable = false;
            }
            if (this.mStatusBarAvailable) {
                setupStatusBarView(activity, viewGroup);
            }
            if (this.mNavBarAvailable) {
                setupNavBarView(activity, viewGroup);
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setupNavBarView(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.mNavBarTintView = new View(context);
        if (this.mConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.mNavBarTintView.setLayoutParams(layoutParams);
        this.mNavBarTintView.setBackgroundColor(-1728053248);
        this.mNavBarTintView.setVisibility(8);
        viewGroup.addView(this.mNavBarTintView);
    }

    private void setupStatusBarView(Context context, ViewGroup viewGroup) {
        this.mStatusBarTintView = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.mNavBarAvailable && !this.mConfig.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.mConfig.getNavigationBarWidth();
        }
        this.mStatusBarTintView.setLayoutParams(layoutParams);
        this.mStatusBarTintView.setBackgroundColor(-1728053248);
        this.mStatusBarTintView.setVisibility(8);
        viewGroup.addView(this.mStatusBarTintView);
    }

    public SystemBarConfig getConfig() {
        return this.mConfig;
    }

    public void setNavigationBarTintColor(int i2) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundColor(i2);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintColor(int i2) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundColor(i2);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setVisibility(z ? 0 : 8);
        }
    }
}
