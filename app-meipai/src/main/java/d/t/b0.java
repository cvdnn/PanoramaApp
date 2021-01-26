package d.t;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtilsBase */
public class b0 {

    /* renamed from: a reason: collision with root package name */
    public static Field f5452a;

    /* renamed from: b reason: collision with root package name */
    public static boolean f5453b;

    public void a(View view) {
        throw null;
    }

    public void a(View view, float f2) {
        throw null;
    }

    public void a(View view, int i2) {
        if (!f5453b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f5452a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f5453b = true;
        }
        Field field = f5452a;
        if (field != null) {
            try {
                f5452a.setInt(view, i2 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        throw null;
    }

    public void a(View view, Matrix matrix) {
        throw null;
    }

    public float b(View view) {
        throw null;
    }

    public void b(View view, Matrix matrix) {
        throw null;
    }

    public void c(View view) {
        throw null;
    }
}
