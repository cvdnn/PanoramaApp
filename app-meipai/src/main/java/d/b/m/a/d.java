package d.b.m.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import d.b.m.a.b.c;

@SuppressLint({"RestrictedAPI"})
/* compiled from: StateListDrawable */
public class d extends b {
    public a m;
    public boolean n;

    /* compiled from: StateListDrawable */
    public static class a extends c {
        public int[][] J;

        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[this.f4089g.length][];
            }
        }

        public int a(int[] iArr) {
            int[][] iArr2 = this.J;
            int i2 = this.f4090h;
            for (int i3 = 0; i3 < i2; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        public void d() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public Drawable newDrawable() {
            return new d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    public d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    public void applyTheme(Theme theme) {
        c cVar = this.f4071a;
        if (cVar != null) {
            if (theme != null) {
                cVar.c();
                int i2 = cVar.f4090h;
                Drawable[] drawableArr = cVar.f4089g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        cVar.f4087e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                cVar.a(theme.getResources());
            }
            onStateChange(getState());
            return;
        }
        throw null;
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.n) {
            super.mutate();
            if (this == this) {
                this.m.d();
                this.n = true;
            }
        }
        return this;
    }

    public boolean onStateChange(int[] iArr) {
        boolean z;
        Drawable drawable = this.f4074d;
        if (drawable != null) {
            z = drawable.setState(iArr);
        } else {
            Drawable drawable2 = this.f4073c;
            z = drawable2 != null ? drawable2.setState(iArr) : false;
        }
        int a2 = this.m.a(iArr);
        if (a2 < 0) {
            a2 = this.m.a(StateSet.WILD_CARD);
        }
        if (a(a2) || z) {
            return true;
        }
        return false;
    }

    public a a() {
        return new a(this.m, this, null);
    }

    public void a(c cVar) {
        super.a(cVar);
        if (cVar instanceof a) {
            this.m = (a) cVar;
        }
    }

    public d(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
