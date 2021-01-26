package d.h.f;

import a.a.a.a.b.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import d.h.e.b.c;
import d.h.h.b.f;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl */
public class h {

    /* renamed from: a reason: collision with root package name */
    public ConcurrentHashMap<Long, c> f4825a = new ConcurrentHashMap<>();

    public Typeface a(Context context, CancellationSignal cancellationSignal, f[] fVarArr, int i2) {
        throw null;
    }

    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        throw null;
    }

    public f a(f[] fVarArr, int i2) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        f fVar = null;
        int i4 = Integer.MAX_VALUE;
        for (f fVar2 : fVarArr) {
            int abs = (Math.abs(fVar2.f4848c - i3) * 2) + (fVar2.f4849d == z ? 0 : 1);
            if (fVar == null || i4 > abs) {
                fVar = fVar2;
                i4 = abs;
            }
        }
        return fVar;
    }

    public Typeface a(Context context, InputStream inputStream) {
        File b2 = a.b(context);
        if (b2 == null) {
            return null;
        }
        try {
            if (!a.a(b2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(b2.getPath());
            b2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            b2.delete();
        }
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File b2 = a.b(context);
        if (b2 == null) {
            return null;
        }
        try {
            if (!a.a(b2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(b2.getPath());
            b2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            b2.delete();
        }
    }
}
