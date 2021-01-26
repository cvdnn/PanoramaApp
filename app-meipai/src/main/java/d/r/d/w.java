package d.r.d;

import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.l.c;
import d.r.d.k.a;
import java.util.ArrayList;

/* compiled from: SimpleItemAnimator */
public abstract class w extends l {

    /* renamed from: g reason: collision with root package name */
    public boolean f5407g = true;

    public abstract boolean a(d0 d0Var, int i2, int i3, int i4, int i5);

    public boolean a(d0 d0Var, d0 d0Var2, c cVar, c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.f1039a;
        int i5 = cVar.f1040b;
        if (d0Var2.shouldIgnore()) {
            int i6 = cVar.f1039a;
            i2 = cVar.f1040b;
            i3 = i6;
        } else {
            i3 = cVar2.f1039a;
            i2 = cVar2.f1040b;
        }
        k kVar = (k) this;
        if (d0Var == d0Var2) {
            return kVar.a(d0Var, i4, i5, i3, i2);
        }
        float translationX = d0Var.itemView.getTranslationX();
        float translationY = d0Var.itemView.getTranslationY();
        float alpha = d0Var.itemView.getAlpha();
        kVar.e(d0Var);
        int i7 = (int) (((float) (i3 - i4)) - translationX);
        int i8 = (int) (((float) (i2 - i5)) - translationY);
        d0Var.itemView.setTranslationX(translationX);
        d0Var.itemView.setTranslationY(translationY);
        d0Var.itemView.setAlpha(alpha);
        kVar.e(d0Var2);
        d0Var2.itemView.setTranslationX((float) (-i7));
        d0Var2.itemView.setTranslationY((float) (-i8));
        d0Var2.itemView.setAlpha(0.0f);
        ArrayList<a> arrayList = kVar.k;
        a aVar = new a(d0Var, d0Var2, i4, i5, i3, i2);
        arrayList.add(aVar);
        return true;
    }
}
