package e.g.a.a.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;

/* compiled from: ViewOffsetBehavior */
public class e<V extends View> extends c<V> {

    /* renamed from: a reason: collision with root package name */
    public f f8259a;

    /* renamed from: b reason: collision with root package name */
    public int f8260b = 0;

    /* renamed from: c reason: collision with root package name */
    public int f8261c = 0;

    public e() {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        b(coordinatorLayout, v, i2);
        if (this.f8259a == null) {
            this.f8259a = new f(v);
        }
        f fVar = this.f8259a;
        fVar.f8263b = fVar.f8262a.getTop();
        fVar.f8264c = fVar.f8262a.getLeft();
        this.f8259a.a();
        int i3 = this.f8260b;
        if (i3 != 0) {
            f fVar2 = this.f8259a;
            if (fVar2.f8267f && fVar2.f8265d != i3) {
                fVar2.f8265d = i3;
                fVar2.a();
            }
            this.f8260b = 0;
        }
        int i4 = this.f8261c;
        if (i4 != 0) {
            f fVar3 = this.f8259a;
            if (fVar3.f8268g && fVar3.f8266e != i4) {
                fVar3.f8266e = i4;
                fVar3.a();
            }
            this.f8261c = 0;
        }
        return true;
    }

    public void b(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.b(v, i2);
    }

    public int b() {
        f fVar = this.f8259a;
        if (fVar != null) {
            return fVar.f8265d;
        }
        return 0;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i2) {
        f fVar = this.f8259a;
        boolean z = false;
        if (fVar != null) {
            if (fVar.f8267f && fVar.f8265d != i2) {
                fVar.f8265d = i2;
                fVar.a();
                z = true;
            }
            return z;
        }
        this.f8260b = i2;
        return false;
    }
}
