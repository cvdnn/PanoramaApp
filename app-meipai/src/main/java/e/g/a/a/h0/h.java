package e.g.a.a.h0;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout.e;
import com.google.android.material.textfield.TextInputLayout.f;
import d.h.k.m;
import e.c.f.n.n;
import e.g.a.a.e0.g;
import e.g.a.a.e0.j;
import e.g.a.a.i;

/* compiled from: DropdownMenuEndIconDelegate */
public class h extends n {

    /* renamed from: d reason: collision with root package name */
    public final TextWatcher f8170d = new a();

    /* renamed from: e reason: collision with root package name */
    public final e f8171e = new b(this.f8189a);

    /* renamed from: f reason: collision with root package name */
    public final f f8172f = new c();

    /* renamed from: g reason: collision with root package name */
    public boolean f8173g = false;

    /* renamed from: h reason: collision with root package name */
    public boolean f8174h = false;

    /* renamed from: i reason: collision with root package name */
    public long f8175i = RecyclerView.FOREVER_NS;

    /* renamed from: j reason: collision with root package name */
    public StateListDrawable f8176j;
    public g k;
    public AccessibilityManager l;
    public ValueAnimator m;
    public ValueAnimator n;

    /* compiled from: DropdownMenuEndIconDelegate */
    public class a implements TextWatcher {

        /* renamed from: e.g.a.a.h0.h$a$a reason: collision with other inner class name */
        /* compiled from: DropdownMenuEndIconDelegate */
        public class C0109a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f8178a;

            public C0109a(AutoCompleteTextView autoCompleteTextView) {
                this.f8178a = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.f8178a.isPopupShowing();
                h.a(h.this, isPopupShowing);
                h.this.f8173g = isPopupShowing;
            }
        }

        public a() {
        }

        public void afterTextChanged(Editable editable) {
            h hVar = h.this;
            AutoCompleteTextView a2 = h.a(hVar, hVar.f8189a.getEditText());
            a2.post(new C0109a(a2));
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    public class b extends e {
        public b(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        public void a(View view, d.h.k.w.b bVar) {
            boolean z;
            super.a(view, bVar);
            bVar.f4953a.setClassName(Spinner.class.getName());
            if (VERSION.SDK_INT >= 26) {
                z = bVar.f4953a.isShowingHintText();
            } else {
                Bundle f2 = bVar.f();
                z = f2 != null && (f2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                bVar.a((CharSequence) null);
            }
        }

        public void c(View view, AccessibilityEvent accessibilityEvent) {
            this.f4909a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            h hVar = h.this;
            AutoCompleteTextView a2 = h.a(hVar, hVar.f8189a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.l.isTouchExplorationEnabled()) {
                h.a(h.this, a2);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    public class c implements f {
        public c() {
        }

        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView a2 = h.a(h.this, textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.f8189a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                a2.setDropDownBackgroundDrawable(hVar.k);
            } else if (boxBackgroundMode == 1) {
                a2.setDropDownBackgroundDrawable(hVar.f8176j);
            }
            h hVar2 = h.this;
            if (hVar2 != null) {
                if (a2.getKeyListener() == null) {
                    int boxBackgroundMode2 = hVar2.f8189a.getBoxBackgroundMode();
                    g boxBackground = hVar2.f8189a.getBoxBackground();
                    int a3 = n.a((View) a2, e.g.a.a.b.colorControlHighlight);
                    int[][] iArr = {new int[]{16842919}, new int[0]};
                    if (boxBackgroundMode2 == 2) {
                        int a4 = n.a((View) a2, e.g.a.a.b.colorSurface);
                        g gVar = new g(boxBackground.f8072a.f8083a);
                        int a5 = n.a(a3, a4, 0.1f);
                        gVar.a(new ColorStateList(iArr, new int[]{a5, 0}));
                        gVar.setTint(a4);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{a5, a4});
                        g gVar2 = new g(boxBackground.f8072a.f8083a);
                        gVar2.setTint(-1);
                        m.a((View) a2, (Drawable) new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground}));
                    } else if (boxBackgroundMode2 == 1) {
                        int boxBackgroundColor = hVar2.f8189a.getBoxBackgroundColor();
                        m.a((View) a2, (Drawable) new RippleDrawable(new ColorStateList(iArr, new int[]{n.a(a3, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                    }
                }
                h hVar3 = h.this;
                if (hVar3 != null) {
                    a2.setOnTouchListener(new i(hVar3, a2));
                    a2.setOnFocusChangeListener(new j(hVar3));
                    a2.setOnDismissListener(new k(hVar3));
                    a2.setThreshold(0);
                    a2.removeTextChangedListener(h.this.f8170d);
                    a2.addTextChangedListener(h.this.f8170d);
                    textInputLayout.setErrorIconDrawable((Drawable) null);
                    textInputLayout.setTextInputAccessibilityDelegate(h.this.f8171e);
                    textInputLayout.setEndIconVisible(true);
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate */
    public class d implements OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            h.a(h.this, (AutoCompleteTextView) h.this.f8189a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public void a() {
        float dimensionPixelOffset = (float) this.f8190b.getResources().getDimensionPixelOffset(e.g.a.a.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f8190b.getResources().getDimensionPixelOffset(e.g.a.a.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f8190b.getResources().getDimensionPixelOffset(e.g.a.a.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g a2 = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        g a3 = a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.k = a2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f8176j = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, a2);
        this.f8176j.addState(new int[0], a3);
        this.f8189a.setEndIconDrawable(d.b.l.a.a.b(this.f8190b, e.g.a.a.e.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f8189a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.exposed_dropdown_menu_content_description));
        this.f8189a.setEndIconOnClickListener(new d());
        this.f8189a.a(this.f8172f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(e.g.a.a.l.a.f8217a);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new m(this));
        this.n = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.setInterpolator(e.g.a.a.l.a.f8217a);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new m(this));
        this.m = ofFloat2;
        ofFloat2.addListener(new l(this));
        m.g(this.f8191c, 2);
        this.l = (AccessibilityManager) this.f8190b.getSystemService("accessibility");
    }

    public boolean a(int i2) {
        return i2 != 0;
    }

    public boolean b() {
        return true;
    }

    public final boolean c() {
        long currentTimeMillis = System.currentTimeMillis() - this.f8175i;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    public static /* synthetic */ void a(h hVar, AutoCompleteTextView autoCompleteTextView) {
        if (hVar == null) {
            throw null;
        } else if (autoCompleteTextView != null) {
            if (hVar.c()) {
                hVar.f8173g = false;
            }
            if (!hVar.f8173g) {
                boolean z = hVar.f8174h;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.f8174h = z2;
                    hVar.n.cancel();
                    hVar.m.start();
                }
                if (hVar.f8174h) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.f8173g = false;
        }
    }

    public static /* synthetic */ AutoCompleteTextView a(h hVar, EditText editText) {
        if (hVar == null) {
            throw null;
        } else if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        } else {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
    }

    public static /* synthetic */ void a(h hVar, boolean z) {
        if (hVar.f8174h != z) {
            hVar.f8174h = z;
            hVar.n.cancel();
            hVar.m.start();
        }
    }

    public final g a(float f2, float f3, float f4, int i2) {
        e.g.a.a.e0.j.b bVar = new e.g.a.a.e0.j.b();
        bVar.c(f2);
        bVar.d(f2);
        bVar.a(f3);
        bVar.b(f3);
        j a2 = bVar.a();
        g a3 = g.a(this.f8190b, f4);
        a3.f8072a.f8083a = a2;
        a3.invalidateSelf();
        e.g.a.a.e0.g.b bVar2 = a3.f8072a;
        if (bVar2.f8091i == null) {
            bVar2.f8091i = new Rect();
        }
        a3.f8072a.f8091i.set(0, i2, 0, i2);
        a3.t = a3.f8072a.f8091i;
        a3.invalidateSelf();
        return a3;
    }
}
