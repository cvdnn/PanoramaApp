package d.b.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.b.j;
import d.b.o.a.C0026a;

/* compiled from: ActionBar */
public abstract class a {

    /* renamed from: d.b.k.a$a reason: collision with other inner class name */
    /* compiled from: ActionBar */
    public static class C0022a extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        public int f3986a;

        public C0022a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3986a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f3986a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0022a(int i2, int i3) {
            super(i2, i3);
            this.f3986a = 0;
            this.f3986a = 8388627;
        }

        public C0022a(C0022a aVar) {
            super(aVar);
            this.f3986a = 0;
            this.f3986a = aVar.f3986a;
        }

        public C0022a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3986a = 0;
        }
    }

    /* compiled from: ActionBar */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* compiled from: ActionBar */
    public static abstract class c {
        public abstract void a();
    }

    public abstract d.b.o.a a(C0026a aVar);

    public abstract void a(Configuration configuration);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract boolean a(int i2, KeyEvent keyEvent);

    public abstract int b();

    public abstract void b(boolean z);

    public abstract Context c();

    public abstract void c(boolean z);
}
