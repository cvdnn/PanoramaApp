package d.f.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import d.f.a.h.d;
import d.f.a.h.h;
import java.util.Arrays;

/* compiled from: ConstraintHelper */
public abstract class b extends View {

    /* renamed from: a reason: collision with root package name */
    public int[] f4740a = new int[32];

    /* renamed from: b reason: collision with root package name */
    public int f4741b;

    /* renamed from: c reason: collision with root package name */
    public Context f4742c;

    /* renamed from: d reason: collision with root package name */
    public h f4743d;

    /* renamed from: e reason: collision with root package name */
    public boolean f4744e = false;

    /* renamed from: f reason: collision with root package name */
    public String f4745f;

    public b(Context context) {
        super(context);
        this.f4742c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str != null) {
            int i2 = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4745f = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4740a, this.f4741b);
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i2, int i3) {
        if (this.f4744e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4741b = 0;
        for (int tag : iArr) {
            setTag(tag, null);
        }
    }

    public void setTag(int i2, Object obj) {
        int i3 = this.f4741b + 1;
        int[] iArr = this.f4740a;
        if (i3 > iArr.length) {
            this.f4740a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4740a;
        int i4 = this.f4741b;
        iArr2[i4] = i2;
        this.f4741b = i4 + 1;
    }

    public void a() {
        if (this.f4743d != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof a) {
                ((a) layoutParams).k0 = this.f4743d;
            }
        }
    }

    public final void a(String str) {
        int i2;
        if (str != null && this.f4742c != null) {
            String trim = str.trim();
            try {
                i2 = g.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = this.f4742c.getResources().getIdentifier(trim, "id", this.f4742c.getPackageName());
            }
            if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object a2 = ((ConstraintLayout) getParent()).a(0, (Object) trim);
                if (a2 != null && (a2 instanceof Integer)) {
                    i2 = ((Integer) a2).intValue();
                }
            }
            if (i2 != 0) {
                setTag(i2, null);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find id of \"");
                sb.append(trim);
                sb.append("\"");
                Log.w("ConstraintHelper", sb.toString());
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f4745f);
        }
        h hVar = this.f4743d;
        if (hVar != null) {
            hVar.l0 = 0;
            for (int i2 = 0; i2 < this.f4741b; i2++) {
                View view = (View) constraintLayout.f823a.get(this.f4740a[i2]);
                if (view != null) {
                    h hVar2 = this.f4743d;
                    d a2 = constraintLayout.a(view);
                    int i3 = hVar2.l0 + 1;
                    d[] dVarArr = hVar2.k0;
                    if (i3 > dVarArr.length) {
                        hVar2.k0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    }
                    d[] dVarArr2 = hVar2.k0;
                    int i4 = hVar2.l0;
                    dVarArr2[i4] = a2;
                    hVar2.l0 = i4 + 1;
                }
            }
        }
    }
}
