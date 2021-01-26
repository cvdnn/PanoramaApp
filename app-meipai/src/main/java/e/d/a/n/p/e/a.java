package e.d.a.n.p.e;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import d.b.o.c;

/* compiled from: DrawableDecoderCompat */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static volatile boolean f7744a = true;

    public static Drawable a(Context context, Context context2, int i2, Theme theme) {
        try {
            if (f7744a) {
                return d.b.l.a.a.b(theme != null ? new c(context2, theme) : context2, i2);
            }
        } catch (NoClassDefFoundError unused) {
            f7744a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return d.h.e.a.b(context2, i2);
            }
            throw e2;
        } catch (NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return context2.getResources().getDrawable(i2, theme);
    }
}
