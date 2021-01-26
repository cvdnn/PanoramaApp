package e.g.a.a.l;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import d.e.h;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec */
public class g {

    /* renamed from: a reason: collision with root package name */
    public final h<String, h> f8230a = new h<>();

    /* renamed from: b reason: collision with root package name */
    public final h<String, PropertyValuesHolder[]> f8231b = new h<>();

    public h a(String str) {
        if (this.f8230a.getOrDefault(str, null) != null) {
            return (h) this.f8230a.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f8230a.equals(((g) obj).f8230a);
    }

    public int hashCode() {
        return this.f8230a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(10);
        sb.append(g.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" timings: ");
        sb.append(this.f8230a);
        sb.append("}\n");
        return sb.toString();
    }

    public static g a(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                return a(context, resourceId);
            }
        }
        return null;
    }

    public static g a(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a((List<Animator>) arrayList);
        } catch (Exception e2) {
            StringBuilder a2 = a.a("Can't load animation resource ID #0x");
            a2.append(Integer.toHexString(i2));
            Log.w("MotionSpec", a2.toString(), e2);
            return null;
        }
    }

    public static g a(List<Animator> list) {
        g gVar = new g();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Animator animator = (Animator) list.get(i2);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                gVar.f8231b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = a.f8218b;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = a.f8219c;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = a.f8220d;
                }
                h hVar = new h(startDelay, duration, interpolator);
                hVar.f8235d = objectAnimator.getRepeatCount();
                hVar.f8236e = objectAnimator.getRepeatMode();
                gVar.f8230a.put(propertyName, hVar);
                i2++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator must be an ObjectAnimator: ");
                sb.append(animator);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return gVar;
    }
}
