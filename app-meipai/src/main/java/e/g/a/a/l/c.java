package e.g.a.a.l;

import android.util.Property;
import android.view.ViewGroup;
import e.g.a.a.f;

/* compiled from: ChildrenAlphaProperty */
public class c extends Property<ViewGroup, Float> {

    /* renamed from: a reason: collision with root package name */
    public static final Property<ViewGroup, Float> f8223a = new c("childrenAlpha");

    public c(String str) {
        super(Float.class, str);
    }

    public Object get(Object obj) {
        Float f2 = (Float) ((ViewGroup) obj).getTag(f.mtrl_internal_children_alpha_tag);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    public void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        float floatValue = ((Float) obj2).floatValue();
        viewGroup.setTag(f.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}
