package d.f.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: Barrier */
public class a extends b {

    /* renamed from: g reason: collision with root package name */
    public int f4737g;

    /* renamed from: h reason: collision with root package name */
    public int f4738h;

    /* renamed from: i reason: collision with root package name */
    public d.f.a.h.a f4739i;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f4739i = new d.f.a.h.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == h.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f4739i.o0 = obtainStyledAttributes.getBoolean(index, true);
                }
            }
        }
        this.f4743d = this.f4739i;
        a();
    }

    public int getType() {
        return this.f4737g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f4739i.o0 = z;
    }

    public void setType(int i2) {
        this.f4737g = i2;
        this.f4738h = i2;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            int i3 = this.f4737g;
            if (i3 == 5) {
                this.f4738h = 1;
            } else if (i3 == 6) {
                this.f4738h = 0;
            }
        } else {
            int i4 = this.f4737g;
            if (i4 == 5) {
                this.f4738h = 0;
            } else if (i4 == 6) {
                this.f4738h = 1;
            }
        }
        this.f4739i.m0 = this.f4738h;
    }
}
