package e.g.a.a.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import d.h.k.m;
import e.c.f.n.n;
import e.g.a.a.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndicatorViewController */
public final class o {

    /* renamed from: a reason: collision with root package name */
    public final Context f8192a;

    /* renamed from: b reason: collision with root package name */
    public final TextInputLayout f8193b;

    /* renamed from: c reason: collision with root package name */
    public LinearLayout f8194c;

    /* renamed from: d reason: collision with root package name */
    public int f8195d;

    /* renamed from: e reason: collision with root package name */
    public FrameLayout f8196e;

    /* renamed from: f reason: collision with root package name */
    public int f8197f;

    /* renamed from: g reason: collision with root package name */
    public Animator f8198g;

    /* renamed from: h reason: collision with root package name */
    public final float f8199h;

    /* renamed from: i reason: collision with root package name */
    public int f8200i;

    /* renamed from: j reason: collision with root package name */
    public int f8201j;
    public CharSequence k;
    public boolean l;
    public TextView m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    /* compiled from: IndicatorViewController */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f8202a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ TextView f8203b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ int f8204c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ TextView f8205d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.f8202a = i2;
            this.f8203b = textView;
            this.f8204c = i3;
            this.f8205d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            o oVar = o.this;
            oVar.f8200i = this.f8202a;
            oVar.f8198g = null;
            TextView textView = this.f8203b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8204c == 1) {
                    TextView textView2 = o.this.m;
                    if (textView2 != null) {
                        textView2.setText(null);
                    }
                }
                TextView textView3 = this.f8205d;
                if (textView3 != null) {
                    textView3.setTranslationY(0.0f);
                    this.f8205d.setAlpha(1.0f);
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8205d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public o(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f8192a = context;
        this.f8193b = textInputLayout;
        this.f8199h = (float) context.getResources().getDimensionPixelSize(d.design_textinput_caption_translate_y);
    }

    public final boolean a(TextView textView, CharSequence charSequence) {
        return m.z(this.f8193b) && this.f8193b.isEnabled() && (this.f8201j != this.f8200i || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public void b() {
        Animator animator = this.f8198g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public boolean c() {
        if (this.f8201j != 1 || this.m == null || TextUtils.isEmpty(this.k)) {
            return false;
        }
        return true;
    }

    public int d() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void e() {
        this.k = null;
        b();
        if (this.f8200i == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.f8201j = 0;
            } else {
                this.f8201j = 2;
            }
        }
        a(this.f8200i, this.f8201j, a(this.m, (CharSequence) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.widget.TextView r4, int r5) {
        /*
            r3 = this;
            android.widget.LinearLayout r0 = r3.f8194c
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r5 == 0) goto L_0x000d
            if (r5 != r0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r5 = 0
            goto L_0x000e
        L_0x000d:
            r5 = r0
        L_0x000e:
            r1 = 8
            if (r5 == 0) goto L_0x0026
            android.widget.FrameLayout r5 = r3.f8196e
            if (r5 == 0) goto L_0x0026
            int r2 = r3.f8197f
            int r2 = r2 - r0
            r3.f8197f = r2
            if (r2 != 0) goto L_0x0020
            r5.setVisibility(r1)
        L_0x0020:
            android.widget.FrameLayout r5 = r3.f8196e
            r5.removeView(r4)
            goto L_0x002b
        L_0x0026:
            android.widget.LinearLayout r5 = r3.f8194c
            r5.removeView(r4)
        L_0x002b:
            int r4 = r3.f8195d
            int r4 = r4 - r0
            r3.f8195d = r4
            android.widget.LinearLayout r5 = r3.f8194c
            if (r4 != 0) goto L_0x0037
            r5.setVisibility(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.h0.o.b(android.widget.TextView, int):void");
    }

    public final void a(int i2, int i3, boolean z) {
        int i4 = i2;
        int i5 = i3;
        boolean z2 = z;
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f8198g = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i6 = i2;
            int i7 = i3;
            a(arrayList2, this.q, this.r, 2, i6, i7);
            a(arrayList2, this.l, this.m, 1, i6, i7);
            n.a(animatorSet, (List<Animator>) arrayList);
            a aVar = new a(i3, a(i2), i2, a(i5));
            animatorSet.addListener(aVar);
            animatorSet.start();
        } else if (i4 != i5) {
            if (i5 != 0) {
                TextView a2 = a(i5);
                if (a2 != null) {
                    a2.setVisibility(0);
                    a2.setAlpha(1.0f);
                }
            }
            if (i4 != 0) {
                TextView a3 = a(i2);
                if (a3 != null) {
                    a3.setVisibility(4);
                    if (i4 == 1) {
                        a3.setText(null);
                    }
                }
            }
            this.f8200i = i5;
        }
        this.f8193b.l();
        this.f8193b.a(z2, false);
        this.f8193b.o();
    }

    public final void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{i4 == i2 ? 1.0f : 0.0f});
                ofFloat.setDuration(167);
                ofFloat.setInterpolator(e.g.a.a.l.a.f8217a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f8199h, 0.0f});
                    ofFloat2.setDuration(217);
                    ofFloat2.setInterpolator(e.g.a.a.l.a.f8220d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public final TextView a(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    public void a() {
        if ((this.f8194c == null || this.f8193b.getEditText() == null) ? false : true) {
            this.f8194c.setPaddingRelative(m.q(this.f8193b.getEditText()), 0, this.f8193b.getEditText().getPaddingEnd(), 0);
        }
    }

    public void a(TextView textView, int i2) {
        if (this.f8194c == null && this.f8196e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f8192a);
            this.f8194c = linearLayout;
            linearLayout.setOrientation(0);
            this.f8193b.addView(this.f8194c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.f8192a);
            this.f8196e = frameLayout;
            this.f8194c.addView(frameLayout, -1, new LayoutParams(-2, -2));
            this.f8194c.addView(new Space(this.f8192a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f8193b.getEditText() != null) {
                a();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f8196e.setVisibility(0);
            this.f8196e.addView(textView);
            this.f8197f++;
        } else {
            this.f8194c.addView(textView, i2);
        }
        this.f8194c.setVisibility(0);
        this.f8195d++;
    }
}
