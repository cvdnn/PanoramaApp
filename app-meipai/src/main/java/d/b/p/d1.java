package d.b.p;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import d.h.k.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtils */
public class d1 {

    /* renamed from: a reason: collision with root package name */
    public static Method f4310a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
            f4310a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                f4310a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean a(View view) {
        return m.m(view) == 1;
    }

    public static void b(View view) {
        String str = "Could not invoke makeOptionalFitsSystemWindows";
        String str2 = "ViewUtils";
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (NoSuchMethodException unused) {
            Log.d(str2, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d(str2, str, e2);
        } catch (IllegalAccessException e3) {
            Log.d(str2, str, e3);
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f4310a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e2) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e2);
            }
        }
    }
}
