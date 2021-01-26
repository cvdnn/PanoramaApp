package d.b.p;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import d.b.d;
import d.h.k.m;
import d.h.k.q;

/* compiled from: TooltipCompatHandler */
public class a1 implements OnLongClickListener, OnHoverListener, OnAttachStateChangeListener {

    /* renamed from: j reason: collision with root package name */
    public static a1 f4278j;
    public static a1 k;

    /* renamed from: a reason: collision with root package name */
    public final View f4279a;

    /* renamed from: b reason: collision with root package name */
    public final CharSequence f4280b;

    /* renamed from: c reason: collision with root package name */
    public final int f4281c;

    /* renamed from: d reason: collision with root package name */
    public final Runnable f4282d = new a();

    /* renamed from: e reason: collision with root package name */
    public final Runnable f4283e = new b();

    /* renamed from: f reason: collision with root package name */
    public int f4284f;

    /* renamed from: g reason: collision with root package name */
    public int f4285g;

    /* renamed from: h reason: collision with root package name */
    public b1 f4286h;

    /* renamed from: i reason: collision with root package name */
    public boolean f4287i;

    /* compiled from: TooltipCompatHandler */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            a1.this.a(false);
        }
    }

    /* compiled from: TooltipCompatHandler */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a1.this.b();
        }
    }

    public a1(View view, CharSequence charSequence) {
        this.f4279a = view;
        this.f4280b = charSequence;
        this.f4281c = q.a(ViewConfiguration.get(view.getContext()));
        a();
        this.f4279a.setOnLongClickListener(this);
        this.f4279a.setOnHoverListener(this);
    }

    public void a(boolean z) {
        int i2;
        int i3;
        long j2;
        int i4;
        long j3;
        if (m.y(this.f4279a)) {
            a((a1) null);
            a1 a1Var = k;
            if (a1Var != null) {
                a1Var.b();
            }
            k = this;
            this.f4287i = z;
            b1 b1Var = new b1(this.f4279a.getContext());
            this.f4286h = b1Var;
            View view = this.f4279a;
            int i5 = this.f4284f;
            int i6 = this.f4285g;
            boolean z2 = this.f4287i;
            CharSequence charSequence = this.f4280b;
            if (b1Var.f4293b.getParent() != null) {
                b1Var.a();
            }
            b1Var.f4294c.setText(charSequence);
            LayoutParams layoutParams = b1Var.f4295d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = b1Var.f4292a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i5 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = b1Var.f4292a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
                i2 = i6 + dimensionPixelOffset2;
                i3 = i6 - dimensionPixelOffset2;
            } else {
                i2 = view.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = b1Var.f4292a.getResources().getDimensionPixelOffset(z2 ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof LayoutParams) || ((LayoutParams) layoutParams2).type != 2) {
                Context context = view.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Activity) {
                        rootView = ((Activity) context).getWindow().getDecorView();
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(b1Var.f4296e);
                Rect rect = b1Var.f4296e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = b1Var.f4292a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", SapiDeviceInfo.f3010c);
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    b1Var.f4296e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(b1Var.f4298g);
                view.getLocationOnScreen(b1Var.f4297f);
                int[] iArr = b1Var.f4297f;
                int i7 = iArr[0];
                int[] iArr2 = b1Var.f4298g;
                iArr[0] = i7 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i5) - (rootView.getWidth() / 2);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                b1Var.f4293b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = b1Var.f4293b.getMeasuredHeight();
                int[] iArr3 = b1Var.f4297f;
                int i8 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
                int i9 = iArr3[1] + i2 + dimensionPixelOffset3;
                if (z2) {
                    if (i8 >= 0) {
                        layoutParams.y = i8;
                    } else {
                        layoutParams.y = i9;
                    }
                } else if (measuredHeight + i9 <= b1Var.f4296e.height()) {
                    layoutParams.y = i9;
                } else {
                    layoutParams.y = i8;
                }
            }
            ((WindowManager) b1Var.f4292a.getSystemService("window")).addView(b1Var.f4293b, b1Var.f4295d);
            this.f4279a.addOnAttachStateChangeListener(this);
            if (this.f4287i) {
                j2 = 2500;
            } else {
                if ((this.f4279a.getWindowSystemUiVisibility() & 1) == 1) {
                    j3 = 3000;
                    i4 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i4 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i4);
            }
            this.f4279a.removeCallbacks(this.f4283e);
            this.f4279a.postDelayed(this.f4283e, j2);
        }
    }

    public void b() {
        if (k == this) {
            k = null;
            b1 b1Var = this.f4286h;
            if (b1Var != null) {
                b1Var.a();
                this.f4286h = null;
                a();
                this.f4279a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f4278j == this) {
            a((a1) null);
        }
        this.f4279a.removeCallbacks(this.f4283e);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.f4286h != null && this.f4287i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f4279a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
                b();
            }
        } else if (this.f4279a.isEnabled() && this.f4286h == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.f4284f) > this.f4281c || Math.abs(y - this.f4285g) > this.f4281c) {
                this.f4284f = x;
                this.f4285g = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a(this);
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f4284f = view.getWidth() / 2;
        this.f4285g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }

    public static void a(a1 a1Var) {
        a1 a1Var2 = f4278j;
        if (a1Var2 != null) {
            a1Var2.f4279a.removeCallbacks(a1Var2.f4282d);
        }
        f4278j = a1Var;
        if (a1Var != null) {
            a1Var.f4279a.postDelayed(a1Var.f4282d, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.f4284f = Integer.MAX_VALUE;
        this.f4285g = Integer.MAX_VALUE;
    }
}
