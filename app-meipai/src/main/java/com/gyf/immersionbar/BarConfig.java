package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.baidu.sapi2.utils.SapiDeviceInfo;

public class BarConfig {
    public final int mActionBarHeight;
    public final boolean mHasNavigationBar;
    public final boolean mInPortrait;
    public final int mNavigationBarHeight;
    public final int mNavigationBarWidth;
    public final float mSmallestWidthDp;
    public final int mStatusBarHeight;

    public BarConfig(Activity activity) {
        boolean z = false;
        this.mInPortrait = activity.getResources().getConfiguration().orientation == 1;
        this.mSmallestWidthDp = getSmallestWidthDp(activity);
        this.mStatusBarHeight = getInternalDimensionSize(activity, "status_bar_height");
        this.mActionBarHeight = getActionBarHeight(activity);
        this.mNavigationBarHeight = getNavigationBarHeight(activity);
        this.mNavigationBarWidth = getNavigationBarWidth(activity);
        if (this.mNavigationBarHeight > 0) {
            z = true;
        }
        this.mHasNavigationBar = z;
    }

    @TargetApi(14)
    private int getActionBarHeight(Activity activity) {
        View findViewById = activity.getWindow().findViewById(R.id.action_bar_container);
        int measuredHeight = findViewById != null ? findViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(16843499, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    private int getInternalDimensionSize(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", SapiDeviceInfo.f3010c);
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f2 = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f2 >= 0.0f ? f2 + 0.5f : f2 - 0.5f);
            }
        } catch (NotFoundException unused) {
        }
        return 0;
    }

    @TargetApi(14)
    private int getNavigationBarHeight(Context context) {
        if (!hasNavBar((Activity) context)) {
            return 0;
        }
        return getInternalDimensionSize(context, this.mInPortrait ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    @TargetApi(14)
    private int getNavigationBarWidth(Context context) {
        if (hasNavBar((Activity) context)) {
            return getInternalDimensionSize(context, "navigation_bar_width");
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
    private boolean hasNavBar(Activity activity) {
        boolean z = false;
        if (Global.getInt(activity.getContentResolver(), Constants.IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW, 0) != 0) {
            return false;
        }
        if (OSUtils.isEMUI()) {
            boolean isEMUI3_x = OSUtils.isEMUI3_x();
            String str = Constants.IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW;
            if (!isEMUI3_x) {
                if (Global.getInt(activity.getContentResolver(), str, 0) != 0) {
                    return false;
                }
            } else if (System.getInt(activity.getContentResolver(), str, 0) != 0) {
                return false;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i4 = displayMetrics2.heightPixels;
        if (i3 - displayMetrics2.widthPixels > 0 || i2 - i4 > 0) {
            z = true;
        }
        return z;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    public boolean isNavigationAtBottom() {
        return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
    }

    public int getNavigationBarWidth() {
        return this.mNavigationBarWidth;
    }

    public int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }

    public int getActionBarHeight() {
        return this.mActionBarHeight;
    }
}
