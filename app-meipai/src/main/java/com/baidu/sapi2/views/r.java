package com.baidu.sapi2.views;

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

/* compiled from: SystemBarTintManager */
public class r {

    /* renamed from: a reason: collision with root package name */
    public static final int f3229a = -1728053248;

    /* renamed from: b reason: collision with root package name */
    public static String f3230b;

    /* renamed from: c reason: collision with root package name */
    public final a f3231c;

    /* renamed from: d reason: collision with root package name */
    public boolean f3232d;

    /* renamed from: e reason: collision with root package name */
    public boolean f3233e;

    /* renamed from: f reason: collision with root package name */
    public View f3234f;

    /* renamed from: g reason: collision with root package name */
    public View f3235g;

    /* compiled from: SystemBarTintManager */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static final String f3236a = "status_bar_height";

        /* renamed from: b reason: collision with root package name */
        public static final String f3237b = "navigation_bar_height";

        /* renamed from: c reason: collision with root package name */
        public static final String f3238c = "navigation_bar_height_landscape";

        /* renamed from: d reason: collision with root package name */
        public static final String f3239d = "navigation_bar_width";

        /* renamed from: e reason: collision with root package name */
        public static final String f3240e = "config_showNavigationBar";

        /* renamed from: f reason: collision with root package name */
        public final int f3241f;

        /* renamed from: g reason: collision with root package name */
        public final boolean f3242g;

        /* renamed from: h reason: collision with root package name */
        public final int f3243h;

        /* renamed from: i reason: collision with root package name */
        public final int f3244i;

        /* renamed from: j reason: collision with root package name */
        public final boolean f3245j;
        public final float k;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (!c(context)) {
                return 0;
            }
            return a(resources, this.f3245j ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (c(context)) {
                return a(resources, "navigation_bar_width");
            }
            return 0;
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", SapiDeviceInfo.f3010c);
            boolean z = true;
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z2 = resources.getBoolean(identifier);
            if ("1".equals(r.f3230b)) {
                z = false;
            } else {
                if (!"0".equals(r.f3230b)) {
                    z = z2;
                }
            }
            return z;
        }

        public boolean d() {
            return this.f3242g;
        }

        public boolean e() {
            return this.k >= 600.0f || this.f3245j;
        }

        public a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            boolean z3 = false;
            this.f3245j = resources.getConfiguration().orientation == 1;
            this.k = a(activity);
            this.f3241f = a(resources, "status_bar_height");
            this.f3243h = a((Context) activity);
            this.f3244i = b(activity);
            if (this.f3243h > 0) {
                z3 = true;
            }
            this.f3242g = z3;
        }

        public int b() {
            return this.f3244i;
        }

        public int a() {
            return this.f3243h;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", SapiDeviceInfo.f3010c);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int c() {
            return this.f3241f;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            float f2 = (float) displayMetrics.widthPixels;
            float f3 = displayMetrics.density;
            return Math.min(f2 / f3, ((float) displayMetrics.heightPixels) / f3);
        }
    }

    static {
        try {
            Method declaredMethod = Class.forName(NotchUtils.SYSTEM_PROPERTIES).getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            Object[] objArr = new Object[1];
            objArr[0] = "qemu.hw.mainkeys";
            f3230b = (String) declaredMethod.invoke(null, objArr);
        } catch (Throwable unused) {
            f3230b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    @TargetApi(19)
    public r(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
        try {
            this.f3232d = obtainStyledAttributes.getBoolean(0, false);
            this.f3233e = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            LayoutParams attributes = window.getAttributes();
            if ((attributes.flags & 67108864) != 0) {
                this.f3232d = true;
            }
            if ((attributes.flags & 134217728) != 0) {
                this.f3233e = true;
            }
            a aVar = new a(activity, this.f3232d, this.f3233e);
            this.f3231c = aVar;
            if (!aVar.d()) {
                this.f3233e = false;
            }
            if (this.f3232d) {
                b(activity, viewGroup);
            }
            if (this.f3233e) {
                a(activity, viewGroup);
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void b(boolean z) {
        if (this.f3232d) {
            this.f3234f.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z) {
        if (this.f3233e) {
            this.f3235g.setVisibility(z ? 0 : 8);
        }
    }

    public void b(int i2) {
        if (this.f3232d) {
            this.f3234f.setBackgroundColor(i2);
        }
    }

    public void a(int i2) {
        if (this.f3233e) {
            this.f3235g.setBackgroundColor(i2);
        }
    }

    public a b() {
        return this.f3231c;
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f3235g = new View(context);
        if (this.f3231c.e()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f3231c.a());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f3231c.b(), -1);
            layoutParams.gravity = 5;
        }
        this.f3235g.setLayoutParams(layoutParams);
        this.f3235g.setBackgroundColor(-1728053248);
        this.f3235g.setVisibility(8);
        viewGroup.addView(this.f3235g);
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.f3234f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f3231c.c());
        layoutParams.gravity = 48;
        if (this.f3233e && !this.f3231c.e()) {
            layoutParams.rightMargin = this.f3231c.b();
        }
        this.f3234f.setLayoutParams(layoutParams);
        this.f3234f.setBackgroundColor(-1728053248);
        this.f3234f.setVisibility(8);
        viewGroup.addView(this.f3234f);
    }
}
