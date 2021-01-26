package d.f.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* compiled from: Constraints */
public class d extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    public c f4759a;

    /* compiled from: Constraints */
    public static class a extends androidx.constraintlayout.widget.ConstraintLayout.a {
        public float m0;
        public boolean n0;
        public float o0;
        public float p0;
        public float q0;
        public float r0;
        public float s0;
        public float t0;
        public float u0;
        public float v0;
        public float w0;
        public float x0;
        public float y0;

        public a(int i2, int i3) {
            super(i2, i3);
            this.m0 = 1.0f;
            this.n0 = false;
            this.o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 1.0f;
            this.t0 = 1.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.m0 = 1.0f;
            this.n0 = false;
            this.o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.r0 = 0.0f;
            this.s0 = 1.0f;
            this.t0 = 1.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 0.0f;
            this.y0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == h.ConstraintSet_android_alpha) {
                    this.m0 = obtainStyledAttributes.getFloat(index, this.m0);
                } else if (index == h.ConstraintSet_android_elevation) {
                    this.o0 = obtainStyledAttributes.getFloat(index, this.o0);
                    this.n0 = true;
                } else if (index == h.ConstraintSet_android_rotationX) {
                    this.q0 = obtainStyledAttributes.getFloat(index, this.q0);
                } else if (index == h.ConstraintSet_android_rotationY) {
                    this.r0 = obtainStyledAttributes.getFloat(index, this.r0);
                } else if (index == h.ConstraintSet_android_rotation) {
                    this.p0 = obtainStyledAttributes.getFloat(index, this.p0);
                } else if (index == h.ConstraintSet_android_scaleX) {
                    this.s0 = obtainStyledAttributes.getFloat(index, this.s0);
                } else if (index == h.ConstraintSet_android_scaleY) {
                    this.t0 = obtainStyledAttributes.getFloat(index, this.t0);
                } else if (index == h.ConstraintSet_android_transformPivotX) {
                    this.u0 = obtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == h.ConstraintSet_android_transformPivotY) {
                    this.v0 = obtainStyledAttributes.getFloat(index, this.v0);
                } else if (index == h.ConstraintSet_android_translationX) {
                    this.w0 = obtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == h.ConstraintSet_android_translationY) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == h.ConstraintSet_android_translationZ) {
                    this.w0 = obtainStyledAttributes.getFloat(index, this.y0);
                }
            }
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.f4759a == null) {
            this.f4759a = new c();
        }
        c cVar = this.f4759a;
        if (cVar != null) {
            int childCount = getChildCount();
            cVar.f4748a.clear();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                a aVar = (a) childAt.getLayoutParams();
                int id = childAt.getId();
                if (id != -1) {
                    if (!cVar.f4748a.containsKey(Integer.valueOf(id))) {
                        cVar.f4748a.put(Integer.valueOf(id), new d.f.b.c.a());
                    }
                    d.f.b.c.a aVar2 = (d.f.b.c.a) cVar.f4748a.get(Integer.valueOf(id));
                    if (childAt instanceof b) {
                        b bVar = (b) childAt;
                        aVar2.a(id, aVar);
                        if (bVar instanceof a) {
                            aVar2.t0 = 1;
                            a aVar3 = (a) bVar;
                            aVar2.s0 = aVar3.getType();
                            aVar2.u0 = aVar3.getReferencedIds();
                        }
                    }
                    aVar2.a(id, aVar);
                    i2++;
                } else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }
            return this.f4759a;
        }
        throw null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new androidx.constraintlayout.widget.ConstraintLayout.a(layoutParams);
    }
}
