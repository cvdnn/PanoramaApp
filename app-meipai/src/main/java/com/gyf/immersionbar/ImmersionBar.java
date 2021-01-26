package com.gyf.immersionbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import d.l.a.a;
import d.n.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(19)
public final class ImmersionBar implements ImmersionCallback {
    public int mActionBarHeight;
    public Activity mActivity;
    public BarConfig mBarConfig;
    public BarParams mBarParams;
    public ViewGroup mContentView;
    public ViewGroup mDecorView;
    public Dialog mDialog;
    public FitsKeyboard mFitsKeyboard;
    public int mFitsStatusBarType;
    public Fragment mFragment;
    public boolean mInitialized;
    public boolean mIsActionBarBelowLOLLIPOP;
    public boolean mIsActivity;
    public boolean mIsDialog;
    public boolean mIsDialogFragment;
    public boolean mIsFragment;
    public boolean mKeyboardTempEnable;
    public int mNavigationBarHeight;
    public int mNavigationBarWidth;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public ImmersionBar mParentBar;
    public androidx.fragment.app.Fragment mSupportFragment;
    public Map<String, BarParams> mTagMap;
    public Window mWindow;

    /* renamed from: com.gyf.immersionbar.ImmersionBar$2 reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$gyf$immersionbar$BarHide;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.gyf.immersionbar.BarHide[] r0 = com.gyf.immersionbar.BarHide.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$gyf$immersionbar$BarHide = r0
                r1 = 1
                r2 = 2
                com.gyf.immersionbar.BarHide r3 = com.gyf.immersionbar.BarHide.FLAG_HIDE_BAR     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$gyf$immersionbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.gyf.immersionbar.BarHide r3 = com.gyf.immersionbar.BarHide.FLAG_HIDE_STATUS_BAR     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3 = 0
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 3
                int[] r2 = $SwitchMap$com$gyf$immersionbar$BarHide     // Catch:{ NoSuchFieldError -> 0x001d }
                com.gyf.immersionbar.BarHide r3 = com.gyf.immersionbar.BarHide.FLAG_HIDE_NAVIGATION_BAR     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = $SwitchMap$com$gyf$immersionbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.gyf.immersionbar.BarHide r2 = com.gyf.immersionbar.BarHide.FLAG_SHOW_BAR     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.ImmersionBar.AnonymousClass2.<clinit>():void");
        }
    }

    public ImmersionBar(Activity activity) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsActivity = true;
        this.mActivity = activity;
        initCommonParameter(activity.getWindow());
    }

    private void adjustDarkModeParams() {
        BarParams barParams = this.mBarParams;
        boolean z = true;
        if (barParams.autoStatusBarDarkModeEnable) {
            int i2 = barParams.statusBarColor;
            if (i2 != 0) {
                statusBarDarkFont(i2 > -4539718, this.mBarParams.autoStatusBarDarkModeAlpha);
            }
        }
        BarParams barParams2 = this.mBarParams;
        if (barParams2.autoNavigationBarDarkModeEnable) {
            int i3 = barParams2.navigationBarColor;
            if (i3 != 0) {
                if (i3 <= -4539718) {
                    z = false;
                }
                navigationBarDarkIcon(z, this.mBarParams.autoNavigationBarDarkModeAlpha);
            }
        }
    }

    private void cancelListener() {
        if (this.mActivity != null) {
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (((childAt instanceof a) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkInitWithActivity() {
        if (this.mParentBar == null) {
            this.mParentBar = with(this.mActivity);
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null && !immersionBar.mInitialized) {
            immersionBar.init();
        }
    }

    public static void destroy(androidx.fragment.app.Fragment fragment) {
        getRetriever().destroy(fragment, false);
    }

    private void fitsKeyboard() {
        if (this.mIsFragment) {
            ImmersionBar immersionBar = this.mParentBar;
            if (immersionBar == null) {
                return;
            }
            if (immersionBar.mBarParams.keyboardEnable) {
                if (immersionBar.mFitsKeyboard == null) {
                    immersionBar.mFitsKeyboard = new FitsKeyboard(immersionBar);
                }
                ImmersionBar immersionBar2 = this.mParentBar;
                immersionBar2.mFitsKeyboard.enable(immersionBar2.mBarParams.keyboardMode);
                return;
            }
            FitsKeyboard fitsKeyboard = immersionBar.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.disable();
            }
        } else if (this.mBarParams.keyboardEnable) {
            if (this.mFitsKeyboard == null) {
                this.mFitsKeyboard = new FitsKeyboard(this);
            }
            this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
        } else {
            FitsKeyboard fitsKeyboard2 = this.mFitsKeyboard;
            if (fitsKeyboard2 != null) {
                fitsKeyboard2.disable();
            }
        }
    }

    private void fitsLayoutOverlap() {
        int statusBarHeight = this.mBarParams.fitsLayoutOverlapEnable ? getStatusBarHeight(this.mActivity) : 0;
        int i2 = this.mFitsStatusBarType;
        if (i2 == 1) {
            setTitleBar(this.mActivity, statusBarHeight, this.mBarParams.titleBarView);
        } else if (i2 == 2) {
            setTitleBarMarginTop(this.mActivity, statusBarHeight, this.mBarParams.titleBarView);
        } else if (i2 == 3) {
            setStatusBarView(this.mActivity, statusBarHeight, this.mBarParams.statusBarView);
        }
    }

    private void fitsNotchScreen() {
        if (VERSION.SDK_INT >= 28 && !this.mInitialized) {
            LayoutParams attributes = this.mWindow.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.mWindow.setAttributes(attributes);
        }
    }

    private void fitsWindows() {
        if (!OSUtils.isEMUI3_x()) {
            fitsWindowsAboveLOLLIPOP();
        } else {
            fitsWindowsBelowLOLLIPOP();
        }
        fitsLayoutOverlap();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        updateBarConfig();
        if (checkFitsSystemWindows(this.mDecorView.findViewById(16908290))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int statusBarHeight = (!this.mBarParams.fits || this.mFitsStatusBarType != 4) ? 0 : this.mBarConfig.getStatusBarHeight();
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
        }
        setPadding(0, statusBarHeight, 0, 0);
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (this.mBarParams.isSupportActionBar) {
            this.mIsActionBarBelowLOLLIPOP = true;
            this.mContentView.post(this);
            return;
        }
        this.mIsActionBarBelowLOLLIPOP = false;
        postFitsWindowsBelowLOLLIPOP();
    }

    private void fitsWindowsEMUI() {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        BarParams barParams = this.mBarParams;
        if (!barParams.navigationBarEnable || !barParams.navigationBarWithKitkatEnable) {
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            EMUI3NavigationBarObserver.getInstance().addOnNavigationBarListener(this);
            EMUI3NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    private void fitsWindowsKITKAT() {
        int i2;
        int i3;
        if (checkFitsSystemWindows(this.mDecorView.findViewById(16908290))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int statusBarHeight = (!this.mBarParams.fits || this.mFitsStatusBarType != 4) ? 0 : this.mBarConfig.getStatusBarHeight();
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
        }
        if (this.mBarConfig.hasNavigationBar()) {
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable && barParams.navigationBarWithKitkatEnable) {
                if (barParams.fullScreen) {
                    i3 = 0;
                    i2 = 0;
                } else if (this.mBarConfig.isNavigationAtBottom()) {
                    i2 = this.mBarConfig.getNavigationBarHeight();
                    i3 = 0;
                } else {
                    i3 = this.mBarConfig.getNavigationBarWidth();
                    i2 = 0;
                }
                if (this.mBarParams.hideNavigationBar) {
                    if (this.mBarConfig.isNavigationAtBottom()) {
                        i2 = 0;
                    } else {
                        i3 = 0;
                    }
                } else if (!this.mBarConfig.isNavigationAtBottom()) {
                    i3 = this.mBarConfig.getNavigationBarWidth();
                }
                setPadding(0, statusBarHeight, i3, i2);
            }
        }
        i3 = 0;
        i2 = 0;
        setPadding(0, statusBarHeight, i3, i2);
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    public static int getNotchHeight(Activity activity) {
        if (hasNotchScreen(activity)) {
            return NotchUtils.getNotchHeight(activity);
        }
        return 0;
    }

    public static RequestManagerRetriever getRetriever() {
        return RequestManagerRetriever.getInstance();
    }

    @TargetApi(14)
    public static int getStatusBarHeight(Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static boolean hasNotchScreen(Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    private int hideBar(int i2) {
        int ordinal = this.mBarParams.barHide.ordinal();
        if (ordinal == 0) {
            i2 |= 1028;
        } else if (ordinal == 1) {
            i2 |= 514;
        } else if (ordinal == 2) {
            i2 |= 518;
        } else if (ordinal == 3) {
            i2 |= 0;
        }
        return i2 | 4096;
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    private int initBarAboveLOLLIPOP(int i2) {
        if (!this.mInitialized) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
        }
        int i3 = i2 | 1024;
        BarParams barParams = this.mBarParams;
        if (barParams.fullScreen && barParams.navigationBarEnable) {
            i3 |= 512;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(134217728);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        BarParams barParams2 = this.mBarParams;
        if (barParams2.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(d.h.f.a.a(barParams2.statusBarColor, barParams2.statusBarColorTransform, barParams2.statusBarAlpha));
        } else {
            this.mWindow.setStatusBarColor(d.h.f.a.a(barParams2.statusBarColor, 0, barParams2.statusBarAlpha));
        }
        BarParams barParams3 = this.mBarParams;
        if (barParams3.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(d.h.f.a.a(barParams3.navigationBarColor, barParams3.navigationBarColorTransform, barParams3.navigationBarAlpha));
        } else {
            this.mWindow.setNavigationBarColor(barParams3.defaultNavigationBarColor);
        }
        return i3;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            if (!barParams.navigationBarEnable || !barParams.navigationBarWithKitkatEnable) {
                this.mWindow.clearFlags(134217728);
            } else {
                this.mWindow.addFlags(134217728);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private void initCommonParameter(Window window) {
        this.mWindow = window;
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(16908290);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (!OSUtils.isMIUI6Later()) {
            boolean isFlymeOS4Later = OSUtils.isFlymeOS4Later();
        }
        return true;
    }

    private void postFitsWindowsBelowLOLLIPOP() {
        updateBarConfig();
        fitsWindowsKITKAT();
        if (!this.mIsFragment && OSUtils.isEMUI3_x()) {
            fitsWindowsEMUI();
        }
    }

    public static void setFitsSystemWindows(Activity activity, boolean z) {
        if (activity != null) {
            setFitsSystemWindows(((ViewGroup) activity.findViewById(16908290)).getChildAt(0), z);
        }
    }

    private int setNavigationIconDark(int i2) {
        return (VERSION.SDK_INT < 26 || !this.mBarParams.navigationBarDarkIcon) ? i2 : i2 | 16;
    }

    private void setPadding(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i2, i3, i4, i5);
        }
        this.mPaddingLeft = i2;
        this.mPaddingTop = i3;
        this.mPaddingRight = i4;
        this.mPaddingBottom = i5;
    }

    private void setSpecialBarDarkMode() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.mWindow, Constants.IMMERSION_MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable) {
                SpecialBarFontUtils.setMIUIBarDark(this.mWindow, Constants.IMMERSION_MIUI_NAVIGATION_BAR_DARK, barParams.navigationBarDarkIcon);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            BarParams barParams2 = this.mBarParams;
            int i2 = barParams2.flymeOSStatusBarFontColor;
            if (i2 != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, i2);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, barParams2.statusBarDarkFont);
            }
        }
    }

    private int setStatusBarDarkFont(int i2) {
        return this.mBarParams.statusBarDarkFont ? i2 | 8192 : i2;
    }

    public static void setStatusBarView(Activity activity, int i2, View... viewArr) {
        if (activity != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = Integer.valueOf(0);
                    }
                    if (num.intValue() != i2) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i2));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, 0);
                        }
                        layoutParams.height = i2;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void setTitleBar(Activity activity, final int i2, View... viewArr) {
        if (activity != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            for (final View view : viewArr) {
                if (view != null) {
                    final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = Integer.valueOf(0);
                    }
                    if (num.intValue() != i2) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i2));
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        }
                        int i3 = layoutParams.height;
                        if (i3 == -2 || i3 == -1) {
                            view.post(new Runnable() {
                                public void run() {
                                    layoutParams.height = (view.getHeight() + i2) - num.intValue();
                                    View view = view;
                                    view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i2) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        } else {
                            layoutParams.height = (i2 - num.intValue()) + i3;
                            view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i2) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, int i2, View... viewArr) {
        if (activity != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = Integer.valueOf(0);
                    }
                    if (num.intValue() != i2) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i2));
                        Object layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new MarginLayoutParams(-1, -2);
                        }
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i2) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        BarParams barParams = this.mBarParams;
        findViewById.setBackgroundColor(d.h.f.a.a(barParams.navigationBarColor, barParams.navigationBarColorTransform, barParams.navigationBarAlpha));
        BarParams barParams2 = this.mBarParams;
        if (!barParams2.navigationBarEnable || !barParams2.navigationBarWithKitkatEnable || barParams2.hideNavigationBar) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    private void setupStatusBarView() {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_STATUS_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(Constants.IMMERSION_ID_STATUS_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        BarParams barParams = this.mBarParams;
        if (barParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(d.h.f.a.a(barParams.statusBarColor, barParams.statusBarColorTransform, barParams.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(d.h.f.a.a(barParams.statusBarColor, 0, barParams.statusBarAlpha));
        }
    }

    public static void showStatusBar(Window window) {
        window.clearFlags(1024);
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Entry entry : this.mBarParams.viewMap.entrySet()) {
                View view = (View) entry.getKey();
                Map map = (Map) entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Entry entry2 : map.entrySet()) {
                    Integer num = (Integer) entry2.getKey();
                    valueOf2 = (Integer) entry2.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        view.setBackgroundColor(d.h.f.a.a(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.statusBarAlpha));
                    } else {
                        view.setBackgroundColor(d.h.f.a.a(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.viewAlpha));
                    }
                }
            }
        }
    }

    private void updateBarConfig() {
        this.mBarConfig = new BarConfig(this.mActivity);
        if (!this.mInitialized || this.mIsActionBarBelowLOLLIPOP) {
            this.mActionBarHeight = this.mBarConfig.getActionBarHeight();
        }
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        updateBarConfig();
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null) {
            if (this.mIsFragment) {
                immersionBar.mBarParams = this.mBarParams;
            }
            if (this.mIsDialog) {
                ImmersionBar immersionBar2 = this.mParentBar;
                if (immersionBar2.mKeyboardTempEnable) {
                    immersionBar2.mBarParams.keyboardEnable = false;
                }
            }
        }
    }

    public static ImmersionBar with(Activity activity) {
        return getRetriever().get(activity);
    }

    public ImmersionBar addTag(String str) {
        if (!isEmpty(str)) {
            this.mTagMap.put(str, this.mBarParams.clone());
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i2) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i2));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar applySystemFits(boolean z) {
        this.mBarParams.fitsLayoutOverlapEnable = !z;
        setFitsSystemWindows(this.mActivity, z);
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar barAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f2;
        barParams.statusBarTempAlpha = f2;
        barParams.navigationBarAlpha = f2;
        barParams.navigationBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar barColor(int i2) {
        return barColorInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar barColorInt(int i2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        return this;
    }

    public ImmersionBar barColorTransform(int i2) {
        return barColorTransformInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar barColorTransformInt(int i2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColorTransform = i2;
        barParams.navigationBarColorTransform = i2;
        return this;
    }

    public ImmersionBar barEnable(boolean z) {
        this.mBarParams.barEnable = z;
        return this;
    }

    public ImmersionBar fitsLayoutOverlapEnable(boolean z) {
        this.mBarParams.fitsLayoutOverlapEnable = z;
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.mBarParams.fits = z;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i2) {
        return fitsSystemWindowsInt(z, i2, -16777216, 0.0f);
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i2) {
        this.mBarParams.flymeOSStatusBarFontColor = d.h.e.a.a((Context) this.mActivity, i2);
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i2) {
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontColor = i2;
        barParams.flymeOSStatusBarFontTempColor = i2;
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.fullScreen = z;
        return this;
    }

    public int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public BarConfig getBarConfig() {
        if (this.mBarConfig == null) {
            this.mBarConfig = new BarConfig(this.mActivity);
        }
        return this.mBarConfig;
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.mSupportFragment;
    }

    public ImmersionBar getTag(String str) {
        if (!isEmpty(str)) {
            BarParams barParams = (BarParams) this.mTagMap.get(str);
            if (barParams != null) {
                this.mBarParams = barParams.clone();
            }
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public Window getWindow() {
        return this.mWindow;
    }

    public void init() {
        if (this.mBarParams.barEnable) {
            updateBarParams();
            setBar();
            fitsWindows();
            fitsKeyboard();
            transformView();
            this.mInitialized = true;
        }
    }

    public boolean initialized() {
        return this.mInitialized;
    }

    public boolean isDialogFragment() {
        return this.mIsDialogFragment;
    }

    public boolean isFragment() {
        return this.mIsFragment;
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardMode(int i2) {
        this.mBarParams.keyboardMode = i2;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarAlpha = f2;
        barParams.navigationBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(int i2) {
        return navigationBarColorInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar navigationBarColorInt(int i2) {
        this.mBarParams.navigationBarColor = i2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i2) {
        return navigationBarColorTransformInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar navigationBarColorTransformInt(int i2) {
        this.mBarParams.navigationBarColorTransform = i2;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.2f);
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            barParams.navigationBarWithEMUI3Enable = z;
            barParams.navigationBarWithKitkatEnable = z;
        }
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.navigationBarWithKitkatEnable = z;
        return this;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!OSUtils.isEMUI3_x()) {
            fitsWindows();
        } else if (!this.mInitialized || this.mIsFragment || !this.mBarParams.navigationBarWithKitkatEnable) {
            fitsWindows();
        } else {
            init();
        }
    }

    public void onDestroy() {
        cancelListener();
        if (this.mIsDialog) {
            ImmersionBar immersionBar = this.mParentBar;
            if (immersionBar != null) {
                BarParams barParams = immersionBar.mBarParams;
                barParams.keyboardEnable = immersionBar.mKeyboardTempEnable;
                if (barParams.barHide != BarHide.FLAG_SHOW_BAR) {
                    immersionBar.setBar();
                }
            }
        }
        this.mInitialized = false;
    }

    public void onNavigationBarChange(boolean z) {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (findViewById != null) {
            this.mBarConfig = new BarConfig(this.mActivity);
            int paddingBottom = this.mContentView.getPaddingBottom();
            int paddingRight = this.mContentView.getPaddingRight();
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.mDecorView.findViewById(16908290))) {
                    if (this.mNavigationBarHeight == 0) {
                        this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
                    }
                    if (this.mNavigationBarWidth == 0) {
                        this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
                    }
                    if (!this.mBarParams.hideNavigationBar) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.mBarConfig.isNavigationAtBottom()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.mNavigationBarHeight;
                            layoutParams.height = paddingBottom;
                            if (this.mBarParams.fullScreen) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = 8388613;
                            int i2 = this.mNavigationBarWidth;
                            layoutParams.width = i2;
                            if (this.mBarParams.fullScreen) {
                                i2 = 0;
                            }
                            paddingRight = i2;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public void onResume() {
        if (!this.mIsFragment && this.mInitialized && this.mBarParams != null) {
            if (OSUtils.isEMUI3_x() && this.mBarParams.navigationBarWithEMUI3Enable) {
                init();
            } else if (this.mBarParams.barHide != BarHide.FLAG_SHOW_BAR) {
                setBar();
            }
        }
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view != null) {
            Map map = (Map) this.mBarParams.viewMap.get(view);
            if (!(map == null || map.size() == 0)) {
                this.mBarParams.viewMap.remove(view);
            }
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public void run() {
        postFitsWindowsBelowLOLLIPOP();
    }

    public void setBar() {
        int i2 = 256;
        if (!OSUtils.isEMUI3_x()) {
            fitsNotchScreen();
            i2 = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(256)));
        } else {
            initBarBelowLOLLIPOP();
        }
        this.mDecorView.setSystemUiVisibility(hideBar(i2));
        setSpecialBarDarkMode();
        if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    public ImmersionBar setOnBarListener(OnBarListener onBarListener) {
        if (onBarListener != null) {
            BarParams barParams = this.mBarParams;
            if (barParams.onBarListener == null) {
                barParams.onBarListener = onBarListener;
            }
        } else {
            BarParams barParams2 = this.mBarParams;
            if (barParams2.onBarListener != null) {
                barParams2.onBarListener = null;
            }
        }
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        BarParams barParams = this.mBarParams;
        if (barParams.onKeyboardListener == null) {
            barParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            BarParams barParams = this.mBarParams;
            if (barParams.onNavigationBarListener == null) {
                barParams.onNavigationBarListener = onNavigationBarListener;
                NavigationBarObserver.getInstance().addOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
            }
        } else if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
            this.mBarParams.onNavigationBarListener = null;
        }
        return this;
    }

    public ImmersionBar statusBarAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f2;
        barParams.statusBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColor(int i2) {
        return statusBarColorInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar statusBarColorInt(int i2) {
        this.mBarParams.statusBarColor = i2;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i2) {
        return statusBarColorTransformInt(d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(int i2) {
        this.mBarParams.statusBarColorTransform = i2;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.2f);
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.statusBarView = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBarMarginTop(int i2) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.mSupportFragment.getView().findViewById(i2));
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBarMarginTop(this.mActivity.findViewById(i2));
        }
        return titleBarMarginTop(this.mFragment.getView().findViewById(i2));
    }

    public ImmersionBar transparentBar() {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = 0;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar viewAlpha(float f2) {
        this.mBarParams.viewAlpha = f2;
        return this;
    }

    public static void destroy(androidx.fragment.app.Fragment fragment, boolean z) {
        getRetriever().destroy(fragment, z);
    }

    @TargetApi(14)
    public static int getActionBarHeight(Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    public static boolean hasNotchScreen(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen((Activity) fragment.getActivity());
    }

    public static void setFitsSystemWindows(Activity activity) {
        setFitsSystemWindows(activity, true);
    }

    public static ImmersionBar with(androidx.fragment.app.Fragment fragment) {
        return getRetriever().get(fragment, false);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i2) {
        return addViewSupportTransformColorInt(view, d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f2;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar barColor(int i2, float f2) {
        return barColorInt(d.h.e.a.a((Context) this.mActivity, i2), (float) i2);
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i2, int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.fits = z;
        barParams.contentColor = i2;
        barParams.contentColorTransform = i3;
        barParams.contentAlpha = f2;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        ViewGroup viewGroup = this.mContentView;
        BarParams barParams2 = this.mBarParams;
        viewGroup.setBackgroundColor(d.h.f.a.a(barParams2.contentColor, barParams2.contentColorTransform, barParams2.contentAlpha));
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            BarHide barHide2 = barParams.barHide;
            barParams.hideNavigationBar = barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public ImmersionBar keyboardEnable(boolean z, int i2) {
        BarParams barParams = this.mBarParams;
        barParams.keyboardEnable = z;
        barParams.keyboardMode = i2;
        this.mKeyboardTempEnable = z;
        return this;
    }

    public ImmersionBar navigationBarColor(int i2, float f2) {
        return navigationBarColorInt(d.h.e.a.a((Context) this.mActivity, i2), f2);
    }

    public ImmersionBar navigationBarColorInt(int i2, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f2) {
        this.mBarParams.navigationBarDarkIcon = z;
        if (!z || isSupportNavigationIconDark()) {
            BarParams barParams = this.mBarParams;
            barParams.navigationBarAlpha = barParams.navigationBarTempAlpha;
        } else {
            this.mBarParams.navigationBarAlpha = f2;
        }
        return this;
    }

    public ImmersionBar statusBarColor(int i2, float f2) {
        return statusBarColorInt(d.h.e.a.a((Context) this.mActivity, i2), f2);
    }

    public ImmersionBar statusBarColorInt(int i2, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f2) {
        this.mBarParams.statusBarDarkFont = z;
        if (!z || isSupportStatusBarDarkFont()) {
            BarParams barParams = this.mBarParams;
            barParams.flymeOSStatusBarFontColor = barParams.flymeOSStatusBarFontTempColor;
            barParams.statusBarAlpha = barParams.statusBarTempAlpha;
        } else {
            this.mBarParams.statusBarAlpha = f2;
        }
        return this;
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        BarParams barParams = this.mBarParams;
        barParams.titleBarView = view;
        barParams.statusBarColorEnabled = z;
        return this;
    }

    public static void destroy(Activity activity, Dialog dialog) {
        getRetriever().destroy(activity, dialog);
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight((Activity) fragment.getActivity());
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth((Activity) fragment.getActivity());
    }

    public static int getNotchHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight((Activity) fragment.getActivity());
    }

    @TargetApi(14)
    public static int getStatusBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight((Activity) fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar((Activity) fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom((Activity) fragment.getActivity());
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity(), z);
        }
    }

    public static ImmersionBar with(androidx.fragment.app.Fragment fragment, boolean z) {
        return getRetriever().get(fragment, z);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i2, int i3) {
        return addViewSupportTransformColorInt(view, d.h.e.a.a((Context) this.mActivity, i2), this.mActivity.getColor(i3));
    }

    public ImmersionBar barColor(int i2, int i3, float f2) {
        return barColorInt(d.h.e.a.a((Context) this.mActivity, i2), this.mActivity.getColor(i3), f2);
    }

    public ImmersionBar barColorInt(int i2, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar navigationBarColor(int i2, int i3, float f2) {
        return navigationBarColorInt(d.h.e.a.a((Context) this.mActivity, i2), this.mActivity.getColor(i3), f2);
    }

    public ImmersionBar statusBarColor(int i2, int i3, float f2) {
        return statusBarColorInt(d.h.e.a.a((Context) this.mActivity, i2), this.mActivity.getColor(i3), f2);
    }

    @TargetApi(14)
    public static int getActionBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight((Activity) fragment.getActivity());
    }

    public static boolean hasNotchScreen(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity());
        }
    }

    public static ImmersionBar with(Fragment fragment) {
        return getRetriever().get(fragment, false);
    }

    public ImmersionBar navigationBarColorInt(int i2, int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i2;
        barParams.navigationBarColorTransform = i3;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i2, int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.statusBarColorTransform = i3;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarView(int i2) {
        return statusBarView(this.mActivity.findViewById(i2));
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static int getNotchHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getStatusBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static void setFitsSystemWindows(Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity(), z);
        }
    }

    public static ImmersionBar with(Fragment fragment, boolean z) {
        return getRetriever().get(fragment, z);
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i2, int i3) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i2) {
        return fitsSystemWindowsInt(z, d.h.e.a.a((Context) this.mActivity, i2));
    }

    public ImmersionBar statusBarView(int i2, View view) {
        return statusBarView(view.findViewById(i2));
    }

    @TargetApi(14)
    public static int getActionBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity());
        }
    }

    public static ImmersionBar with(c cVar) {
        return getRetriever().get((androidx.fragment.app.Fragment) cVar, false);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i2, int i3, float f2) {
        return fitsSystemWindowsInt(z, d.h.e.a.a((Context) this.mActivity, i2), this.mActivity.getColor(i3), f2);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar titleBar(int i2) {
        return titleBar(i2, true);
    }

    public ImmersionBar titleBarMarginTop(int i2, View view) {
        return titleBarMarginTop(view.findViewById(i2));
    }

    public static void setFitsSystemWindows(View view, boolean z) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup instanceof a) {
                    setFitsSystemWindows(viewGroup.getChildAt(0), z);
                } else {
                    viewGroup.setFitsSystemWindows(z);
                    viewGroup.setClipToPadding(true);
                }
            } else {
                view.setFitsSystemWindows(z);
            }
        }
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        return getRetriever().get((Fragment) dialogFragment, false);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f2) {
        return barColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar barColorInt(int i2, int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        barParams.statusBarColorTransform = i3;
        barParams.navigationBarColorTransform = i3;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(String str, float f2) {
        return navigationBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar statusBarColor(String str, float f2) {
        return statusBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar titleBar(int i2, boolean z) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mSupportFragment.getView().findViewById(i2), z);
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBar(this.mActivity.findViewById(i2), z);
        }
        return titleBar(this.mFragment.getView().findViewById(i2), z);
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        return getRetriever().get(activity, dialog);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar barColor(String str, String str2, float f2) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f2) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f2) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public static void setStatusBarView(Activity activity, View... viewArr) {
        setStatusBarView(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), i2, viewArr);
        }
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), viewArr);
        }
    }

    public ImmersionBar titleBar(int i2, View view) {
        return titleBar(view.findViewById(i2), true);
    }

    public static void setStatusBarView(Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), i2, viewArr);
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), viewArr);
    }

    public ImmersionBar titleBar(int i2, View view, boolean z) {
        return titleBar(view.findViewById(i2), z);
    }

    public static void setStatusBarView(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), i2, viewArr);
        }
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        setTitleBar(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), i2, viewArr);
        }
    }

    public static void setTitleBarMarginTop(Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), i2, viewArr);
        }
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBar(Fragment fragment, int i2, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), i2, viewArr);
        }
    }

    public ImmersionBar(androidx.fragment.app.Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mSupportFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), viewArr);
        }
    }

    public ImmersionBar(Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    public ImmersionBar(c cVar) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = cVar.getActivity();
        this.mSupportFragment = cVar;
        this.mDialog = cVar.f5109h;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    public ImmersionBar(DialogFragment dialogFragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = dialogFragment.getActivity();
        this.mFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    public ImmersionBar(Activity activity, Dialog dialog) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = activity;
        this.mDialog = dialog;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }
}
